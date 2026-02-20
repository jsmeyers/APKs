if (typeof window.AndroidMonkeyPatch === 'undefined') {
    window.AndroidMonkeyPatch = {};

    var realXhrOpen = XMLHttpRequest.prototype.open;
    var realXhrSend = XMLHttpRequest.prototype.send;

    XMLHttpRequest.prototype.open = function (method, url, async, user, password) {
        this._url = url;
        this._requestId = Math.random().toString(16).substring(2);
        realXhrOpen.call(this, method, url, async, user, password);
        // headers must be set between the open and the send call.
        this.setRequestHeader('X-Android-RequestId', this._requestId);
    };

    XMLHttpRequest.prototype.send = function (body) {
        // override the onreadystatechange so we can look for done.
        if(this.onreadystatechange) {
            this._onreadystatechange = this.onreadystatechange;
        }
        this.onreadystatechange = onReadyStateChangeReplacement
        // let the WebLoginViewModel know we've started a request.
        window.Android.requestStarted(this._url, this._requestId, body);
        return realXhrSend.call(this, body);
    };

    function onReadyStateChangeReplacement() {
        // if we're done, remove the completed request
        if (this.readyState === 4) {
            window.Android.requestCompleted(this._requestId);
        }
        if(this._onreadystatechange) {
            return this._onreadystatechange.apply(this, arguments);
        }
    }


    (function attachClickHandler() {
        var disclaimerText = document.getElementById('login-department-disclaimer-text');
        if (!disclaimerText) {
            window.requestAnimationFrame((timestamp) => attachClickHandler());
        } else {
            disclaimerText.addEventListener('click', () => window.AndroidClick.call());
        }
    })();
}
