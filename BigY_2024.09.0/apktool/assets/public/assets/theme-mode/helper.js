export default class Helper {
  static CSS_VARIABLE_EDIT_GLOBAL_MSG_ACTION = 'updateCSSGlobalVariable';
  static THEMER_SESSION_KEY = 'themerConfig';

  static renderCSSVariableItem(currentChanges, variable, value, onRevertColor) {
    const currentChange = currentChanges[variable];
    const emptyEl = document.createElement('span');
    emptyEl.className = 'sidebar__empty';
    emptyEl.innerHTML = '(empty)&nbsp;';

    if (currentChange) {
      const { oldValue, newValue } = currentChange;

      const wrapperDiv = document.createElement('div');
      wrapperDiv.style.textAlign = 'center';

      if (oldValue === newValue) {
        const span = document.createElement('span');
        span.className = 'sidebar__new-value';
        span.innerHTML = oldValue || emptyEl.innerHTML;
        wrapperDiv.appendChild(span);
        return wrapperDiv;
      }

      if (oldValue) {
        const oldSpan = document.createElement('span');
        oldSpan.className = 'sidebar__old-value';
        oldSpan.textContent = oldValue;
        wrapperDiv.appendChild(oldSpan);
      } else {
        wrapperDiv.appendChild(emptyEl.cloneNode(true));
      }

      const revertBtn = document.createElement('button');
      revertBtn.className = 'sidebar__revert-color-btn';
      revertBtn.onclick = () => {
        onRevertColor(variable, oldValue);
      };

      const tooltipDiv = document.createElement('div');
      tooltipDiv.className = 'tooltip';
      tooltipDiv.setAttribute('title', 'Revert changes');
      tooltipDiv.appendChild(revertBtn);

      wrapperDiv.appendChild(tooltipDiv);

      const newSpan = document.createElement('span');
      newSpan.className = 'sidebar__new-value';
      newSpan.innerHTML = newValue || emptyEl.innerHTML;
      wrapperDiv.appendChild(newSpan);

      return wrapperDiv;
    }

    const valueSpan = document.createElement('span');
    valueSpan.className = 'sidebar__new-value';
    valueSpan.innerHTML = value || emptyEl.innerHTML;

    return valueSpan;
  }

  static isValidHex(color) {
    return /^#([0-9A-F]{3}|[0-9A-F]{6})$/i.test(color);
  }

  static isValidRGB(color) {
    return /^rgb\((\d{1,3}),\s*(\d{1,3}),\s*(\d{1,3})\)$/.test(color);
  }

  static isValidNamedColor(color) {
    const testElement = document.createElement('div');
    testElement.style.color = color;
    return !!testElement.style.color;
  }

  static debounce(func, delay) {
    let timeoutId;
    return function (...args) {
      const context = this;
      clearTimeout(timeoutId);
      timeoutId = setTimeout(() => {
        func.apply(context, args);
      }, delay);
    };
  }

  static isColorValue(variable, value, property = '') {
    if (property.indexOf('color') !== -1 || variable.indexOf('color') !== -1) return true;
    return /^#[0-9A-F]{6}$/i.test(value) || /^rgb/.test(value);
  }

  static isDimensionValue(value) {
    return /^(\d+|\d*\.\d+)(px|em|rem|%)$/.test(value);
  }

  static displayMessage(msg) {
    document.getElementsByTagName('body')[0].innerHTML = msg;
  }
}
