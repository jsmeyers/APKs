
  cordova.define('cordova/plugin_list', function(require, exports, module) {
    module.exports = [
      {
          "id": "cordova-plugin-inappbrowser.inappbrowser",
          "file": "plugins/cordova-plugin-inappbrowser/www/inappbrowser.js",
          "pluginId": "cordova-plugin-inappbrowser",
        "clobbers": [
          "cordova.InAppBrowser.open"
        ]
        },
      {
          "id": "cordova-plugin-onetrust-cmp.OneTrust",
          "file": "plugins/cordova-plugin-onetrust-cmp/www/OneTrust.js",
          "pluginId": "cordova-plugin-onetrust-cmp",
        "clobbers": [
          "OneTrust"
        ],
        "merges": [
          "cordova.plugins.OneTrust"
        ]
        },
      {
          "id": "es6-promise-plugin.Promise",
          "file": "plugins/es6-promise-plugin/www/promise.js",
          "pluginId": "es6-promise-plugin",
        "runs": true
        }
    ];
    module.exports.metadata =
    // TOP OF METADATA
    {
      "cordova-plugin-inappbrowser": "6.0.0",
      "cordova-plugin-onetrust-cmp": "202505.2.0",
      "es6-promise-plugin": "4.2.2"
    };
    // BOTTOM OF METADATA
    });
    