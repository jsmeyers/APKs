'use strict';
import CSSVariablePopover from './popover.js';

const MOCK_VARIABLES = {
  'border-radius': {
    '--mag-border-radius-rounded': '9999px',
  },
  background: {
    '--mag-color-surface-secondary': '#f7f8f9',
    '--mag-spacing-500': '40px',
  },
  height: {
    '--mag-spacing-500': '40px',
  },
  'padding-left': {
    '--mag-spacing-150': '12px',
  },
  'padding-right': {
    '--mag-spacing-150': '12px',
  },
  gap: {
    '--mag-spacing-100': '8px',
  },
};

export default class PopoverController {
  prefix = '--mag';
  selectedTarget = null;
  throttleTimer = null;
  isInspecting = false;
  isPopoverVisible = false;
  originVariables = {};

  constructor(popoverElement, sidebarElement, onVariableChange) {
    this.popoverElement = popoverElement;
    this.sidebarElement = sidebarElement;
    this.popover = new CSSVariablePopover(this.popoverElement, onVariableChange);
  }

  init(variables) {
    this.originVariables = { ...variables };
    this.attachEventListeners();
  }

  attachEventListeners() {
    document.addEventListener('mousemove', this.handleMouseMove.bind(this));
    document.addEventListener('mousedown', this.handleClickOutside.bind(this));
  }

  handleGetVariables(target) {
    if (this.throttleTimer) return;
    this.throttleTimer = setTimeout(() => {
      // Get CSS variables from the target element (implement logic here)
      const variables = {
        ...this.getCSSVariablesFromStylesheet(target),
        ...this.getCSSVariablesFromStylesheet(target.parentElement),
      };
      this.popover.setVariables({
        variables: variables,
        tagName: target.tagName,
      });
      this.selectedTarget = target;
      this.throttleTimer = null;
    }, 150);
  }

  setCurrentChanges(changes) {
    this.popover.setCurrentChanges(changes);
  }

  /**
   * Update state after saving
   * @param {*} variables
   */
  setOriginVariables(variables) {
    this.originVariables = { ...variables };
  }

  handleMouseMove(event) {
    const { clientX, clientY, target } = event;

    if (this.isInspecting) {
      // Prevent the popover from showing when hovering over itself or the sidebar
      const isHoveringOverPopover = this.popoverElement && this.popoverElement.contains(target);
      const isHoveringOverSidebar = this.sidebarElement && this.sidebarElement.contains(target);

      if (!isHoveringOverPopover && !isHoveringOverSidebar) {
        this.handleGetVariables(target);
      }

      // Prevent re-positioning when hovering over the popover or sidebar
      if (!isHoveringOverPopover && !isHoveringOverSidebar) {
        this.popover.setPosition({ x: clientX, y: clientY });
      }
    }
  }

  handleClickOutside(event) {
    if (this.isInspecting) {
      const screenContainer = document.getElementById('mobile-screen');
      if (screenContainer) screenContainer.removeAttribute('data-cssvareditable');

      this.setInspecting(false);
      return;
    }
    const isClickOutsidePopover = this.popoverElement && !this.popoverElement.contains(event.target);
    const isClickOutsideSidebar = this.sidebarElement && !this.sidebarElement.contains(event.target);

    if (isClickOutsidePopover && isClickOutsideSidebar) {
      this.popover.destroy();
      setTimeout(() => {
        this.selectedTarget = null;
      }, 1000);
    }
  }

  getCSSVariablesFromStylesheet(element) {
    const result = {};
    const shadowRoot = element.shadowRoot;
    const sheets = !shadowRoot ? this._getDocumentStylesheets() : shadowRoot.adoptedStyleSheets;
    const regex = new RegExp(`var\\(([^,\\s)]+)`, 'g');

    for (const sheet of sheets) {
      try {
        const rules = sheet.cssRules || sheet.rules;

        for (const rule of rules) {
          if (!shadowRoot) {
            this._handleGetVariables(rule, element, regex, result);
          } else {
            shadowRoot.querySelectorAll('*').forEach((el) => {
              this._handleGetVariables(rule, el, regex, result);
            });
          }
        }
      } catch (e) {
        console.warn(e);
        console.warn(`Cannot access stylesheet: ${sheet.href}`);
      }
    }
    // return MOCK_VARIABLES; // Debug: mock data
    return result;
  }

  setInspecting(isEnable) {
    this.isInspecting = isEnable;
  }

  toggleInspecting() {
    this.isInspecting = !this.isInspecting;
    return this.isInspecting;
  }

  destroy() {
    document.removeEventListener('mousemove', this.handleMouseMove.bind(this));
    document.removeEventListener('mousedown', this.handleClickOutside.bind(this));
  }

  _getDocumentStylesheets() {
    return Array.from(document.styleSheets).filter((sheet) => {
      // Filter out external stylesheets by checking if the href is null or matches your domain
      return sheet.href === null || sheet.href.startsWith(window.location.origin);
    });
  }

  _handleGetVariables(rule, element, regex, result) {
    if (rule.style && element.matches(rule.selectorText)) {
      // console.log(`${element.tagName.toLowerCase()} - ${rule.style.cssText} - ${rule.selectorText}`);
      let styles = rule.style.cssText.split('; ');
      for (const style of styles) {
        const property = style.split(': ')[0];
        let match;

        while ((match = regex.exec(style)) !== null) {
          const variableName = match[1];

          if (!result[property]) {
            result[property] = {};
          }
          if (variableName.startsWith(this.prefix)) {
            result[property][variableName] = this.originVariables[variableName];
          }
        }
        if (result[property] && Object.keys(result[property]).length === 0) {
          delete result[property];
        }
      }
    }
  }
}
