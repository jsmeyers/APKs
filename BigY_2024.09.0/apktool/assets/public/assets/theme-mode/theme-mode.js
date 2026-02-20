'use strict';

import ThemeEditorLeftSidebar from './sidebar.js';
import PopoverController from './popover-controller.js';
import Helper from './helper.js';
import ThemerService from './service.js';

export class ThemeMode {
  mobileViewport;

  // Left sidebar
  currentChanges = {};
  filteredVariables = {};
  currentValues = {};
  listForRender = [];

  constructor() {
    this.initialize();
  }

  /**
   * Validating params and Admin User is valid.
   */
  static async validator() {
    const urlParams = new URLSearchParams(window.location.search);
    const envName = urlParams.get('env');
    const adminUsername = urlParams.get('un');
    const adminToken = urlParams.get('tk');
    const themeId = urlParams.get('tid');
    const tenantId = urlParams.get('tnid');
    const appCode = urlParams.get('ac');

    if (!envName || !adminUsername || !adminToken || !themeId || !tenantId || !appCode) {
      Helper.displayMessage('Invalid parameters!');
      return;
    }

    Helper.displayMessage('Authorizing...');
    const isAdminValid = await ThemerService.validateAdminToken(envName, adminUsername, adminToken);

    if (!isAdminValid) {
      Helper.displayMessage('Unauthorized!');
      return;
    }

    Helper.displayMessage('Fetching the site configuration...');
    const setting = await ThemerService.getTenantSettingBySiteCode(envName, tenantId, appCode, adminToken);

    if (!setting) {
      Helper.displayMessage('Application settings not found!');
      return;
    }

    try {
      const themes = JSON.parse(setting?.ThemeConfigurations);
      const currentTheme = themes.find((t) => t.Id === themeId);

      if (!currentTheme?.Configurations) {
        Helper.displayMessage('No selected theme found!');
        return;
      }

      sessionStorage.setItem(
        'themerConfig',
        JSON.stringify({
          un: adminUsername,
          tk: adminToken,
          tid: themeId,
          themeConfig: currentTheme?.Configurations,
          en: envName,
          tnid: tenantId,
          ac: appCode,
        })
      );
      console.log(`Editing theme: ${currentTheme.Name} - ${currentTheme.Id}`);
      Helper.displayMessage('Done! Navigating to home...');
      location.href = '/';
    } catch (err) {
      console.error('Cannot parse the theme configuration!');
      return null;
    }
  }

  initialize() {
    const themeConfig = this.getThemeConfig();
    if (!themeConfig) return;
    const variables = themeConfig?.globalCss[':root'] || {};
    this.render(variables);

    if (this._isBestWindowWidth()) {
      this._displayMessage('For the best experience, we recommend setting your window width between 700px and 1199px.');
    }
  }

  getThemeConfig() {
    const validWindowWidth = window.innerWidth > 650;

    if (!validWindowWidth) {
      console.warn('Invalid window width!');
      return null;
    }

    const themerConfigStr = sessionStorage.getItem(Helper.THEMER_SESSION_KEY);
    if (!themerConfigStr) {
      console.warn("Invalid themer's parameters!");
      return null;
    }
    const themerConfig = JSON.parse(themerConfigStr);
    const { un, tk, en, tnid, ac, themeConfig } = themerConfig;

    if (!un || !tk || !tnid || !ac || !themeConfig) {
      console.warn("Invalid themer's parameters!");
      return null;
    }

    const validEnvironments = ['prod', 'uat', 'stg', 'sandbox', 'dxpro.staging', 'dxpro.uat', 'dxpro.production'];

    if (!validEnvironments.includes(en)) {
      console.warn(
        'Cannot found env: ' + en + '. It should be prod|uat|stg|sandbox|dxpro.staging|dxpro.uat|dxpro.production'
      );
      return null;
    }

    window.addEventListener(
      'resize',
      (event) => {
        const invalidWindowWidth = window.innerWidth < 650;

        if (invalidWindowWidth) {
          this._displayMessage('Invalid viewport. Exiting the edit mode in 3 second(s).');
          setTimeout(() => {
            location.reload(); // Force reload page
          }, 3000);
        } else {
          this._displayMessage(
            this._isBestWindowWidth()
              ? 'For the best experience, we recommend setting your window width between 700px and 1199px.'
              : ''
          );
        }
      },
      true
    );

    try {
      return JSON.parse(themeConfig);
    } catch (err) {
      return null;
    }
  }

  render(variables) {
    this.renderLayout();
    this.mobileViewport = document.getElementById('mobile-viewport');
    const leftSidebar = new ThemeEditorLeftSidebar({
      onVariableChange: (...args) => {
        this.onVariableChange(variables, ...args);
        popoverController.setCurrentChanges(this.currentChanges);
        leftSidebar.setCurrentChanges(this.currentChanges);
      },
    });

    const popoverElement = document.getElementById('popover');
    const sidebarElement = document.getElementById('left-panel');
    const popoverController = new PopoverController(popoverElement, sidebarElement, (...args) => {
      this.onVariableChange(variables, ...args);
      popoverController.setCurrentChanges(this.currentChanges);
      leftSidebar.setCurrentChanges(this.currentChanges);
    });

    leftSidebar.initialize(variables);
    popoverController.init(variables);
    leftSidebar.setPopoverController(popoverController);

    // Listen to window resize to recalculate the scale
    window.addEventListener('resize', () => {
      if (document.getElementById('preview-wrapper').classList.contains('preview-wrapper--preview-mode')) {
        this.scaleMobileViewport();
      }
    });
    this.togglePreviewMode();
    setTimeout(() => {
      this.scaleMobileViewport();
    }, 1000);
  }

  renderLayout() {
    document.body.innerHTML = `
      <div id="preview-wrapper" class="preview-wrapper preview-wrapper--preview-mode">
        <div id="left-panel" class="preview-wrapper__left-panel"></div>

        <div id="right-panel" class="preview-wrapper__right-panel">
          <div id="mobile-viewport" class="mobile-viewport">
            <!-- iPhone 15 Dynamic Island -->
            <div class="dynamic-island"></div>

            <!-- iPhone 15 Header (Status Bar) -->
            <div class="mobile-viewport__header">
              <div class="mobile-viewport__time">9:41</div>
              <div class="mobile-viewport__status-icons">
                <div class="status-icons__signal-bars"></div>
                <div class="status-icons__wifi-icon"></div>
                <div class="status-icons__battery-icon"></div>
              </div>
            </div>

            <!-- Mobile screen container (the app root) -->
            <div id="mobile-screen" class="mobile-viewport__screen">
              <app-root></app-root>
            </div>
          </div>
        </div>
        <div class="corner-message"></div>
      </div>
      <div id="popover" style="display: none; position: absolute;"></div>
    `;
  }

  onVariableChange(variables, property, variable, value) {
    console.log(`Updated ${variable} in ${property}: ${value}`);
    const oldValue = variables[variable] || '';
    const newObj = {
      ...this.currentChanges,
      [variable]: {
        oldValue,
        newValue: value,
      },
    };
    if (oldValue === value) {
      delete newObj[variable];
    }

    this.currentChanges = newObj;

    this.cssVariableOnChanges({
      variable: variable,
      value: value,
    });
  }

  cssVariableOnChanges(data) {
    window.parent.postMessage(
      {
        action: Helper.CSS_VARIABLE_EDIT_GLOBAL_MSG_ACTION,
        data: { ...data },
      },
      window.location.origin
    );
  }

  scaleMobileViewport() {
    const wrapperWidth = document.getElementById('right-panel').offsetWidth;

    // Mobile device aspect ratio (330x932, iPhone 14 Pro Max for example)
    const mobileWidth = 430;
    const mobileHeight = 932;

    // Calculate the scale based on the wrapper size and maintain the aspect ratio
    const scale = Math.min(wrapperWidth / mobileWidth, window.innerHeight / mobileHeight) * 0.95;

    // Apply scale transformation to the mobile viewport
    if (this.mobileViewport) {
      this.mobileViewport.style.transform = `scale(${scale <= 1 ? scale : 1})`;
    }
  }

  togglePreviewMode() {
    const wrapper = document.getElementById('preview-wrapper');
    const head = document.head;
    let linkElement = document.getElementById('preview-mode-css');

    // Check if the preview mode is already on
    if (wrapper.classList.contains('preview-mode')) {
      // Turn off preview mode
      wrapper.classList.remove('preview-mode');
      wrapper.classList.add('normal-mode');

      // Remove the preview CSS if it exists
      if (linkElement) {
        linkElement.remove();
      }

      // Reset scale
      this.mobileViewport.style.transform = 'none';
    } else {
      // Turn on preview mode
      wrapper.classList.remove('normal-mode');
      wrapper.classList.add('preview-mode');

      // Dynamically add the preview CSS link to the header
      if (!linkElement) {
        linkElement = document.createElement('link');
        linkElement.rel = 'stylesheet';
        linkElement.href = 'assets/theme-mode/styles.css'; // Path to the CSS file
        linkElement.id = 'preview-mode-css';
        head.appendChild(linkElement);
      }

      // Scale the mobile viewport when entering preview mode
      this.scaleMobileViewport();
    }
  }

  // Function to open IndexedDB and get data from a specified object store
  _getDataFromIndexedDB(dbName, storeName, key) {
    return new Promise((resolve, reject) => {
      // Open the IndexedDB database
      const request = indexedDB.open(dbName);

      request.onerror = function (event) {
        console.error('Database failed to open', event);
        reject('Failed to open database');
      };

      request.onsuccess = function (event) {
        console.log('Database opened successfully');
        const db = event.target.result;

        // Create a transaction and access the object store
        const transaction = db.transaction([storeName], 'readonly');
        const store = transaction.objectStore(storeName);

        // Request the data by the key
        const getRequest = store.get(key);

        getRequest.onerror = function (event) {
          console.error('Failed to get data from object store', event);
          reject('Failed to get data');
        };

        getRequest.onsuccess = function (event) {
          if (getRequest.result) {
            resolve(getRequest.result); // Return the data if found
          } else {
            resolve(null); // Return null if no data found
          }
        };
      };

      request.onupgradeneeded = function (event) {
        const db = event.target.result;
        console.log('Upgrade needed, creating object store');
        if (!db.objectStoreNames.contains(storeName)) {
          db.createObjectStore(storeName, { keyPath: 'id' });
        }
      };
    });
  }

  _isBestWindowWidth() {
    return window.innerWidth < 700 || window.innerWidth > 1199;
  }

  _displayMessage(msg) {
    const cornerMsg = document.querySelector('.corner-message');
    cornerMsg.textContent = msg;
  }
}
