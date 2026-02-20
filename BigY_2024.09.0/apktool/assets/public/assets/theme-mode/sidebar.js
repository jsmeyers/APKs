'use strict';
import HyperList from './hyperlist.js';
import Helper from './helper.js';
import ThemerService from './service.js';

export default class ThemeEditorLeftSidebar {
  options = {};
  _currentValues = {};
  _currentChanges = {};

  // Virtual list
  _hyperList;
  _listContainer = document.createElement('div');
  _itemHeight = 45;

  _popoverController = null;
  _inspectButton = null;

  constructor(opts) {
    this.options = { ...opts };
  }

  initialize(variables) {
    this.searchTerm = '';
    this.filterType = 'all';
    this.noVarsFound = false;
    this.colorForReplacement = '';
    this.isColorValid = true;
    this.highlightedIndex = null;

    this.filteredVariables = { ...variables };
    this._currentValues = { ...variables };
    this.listForRender = Object.entries(this.filteredVariables);
    this._render();
  }

  // Function to search for variables
  handleSearch = Helper.debounce((term, type) => {
    const keyword = term.trim();
    let newFilteredVariables = {};

    if (type !== 'being-edited') {
      newFilteredVariables = Object.entries(this._currentValues).reduce((acc, [variable, value]) => {
        const matchesType =
          type === 'all' ||
          (type === 'color' && Helper.isColorValue(variable, value)) ||
          (type === 'dimension' && Helper.isDimensionValue(value));
        if (matchesType && (variable.includes(keyword) || `${value}`.includes(keyword))) {
          acc[variable] = value;
        }
        return acc;
      }, {});
    } else {
      newFilteredVariables = Object.entries(this._currentChanges).reduce((acc, [variable, value]) => {
        const { oldValue, newValue } = value;
        if (variable.includes(keyword) || `${oldValue}`.includes(keyword) || `${newValue}`.includes(keyword)) {
          acc[variable] = oldValue;
        }
        return acc;
      }, {});
    }

    this.noVarsFound = Object.keys(newFilteredVariables).length === 0;
    this.filteredVariables = newFilteredVariables;
    this.listForRender = Object.entries(this.filteredVariables);
    this._renderList();
  }, 150);

  handleSearchChange(event) {
    const term = event.target.value;
    this.searchTerm = term;

    // Check the replace button state
    if (this.filterType === 'color') {
      this.updateReplaceButtonState();
    }

    this.handleSearch(term, this.filterType);
  }

  handleFilterChange(event) {
    const type = event.target.value;
    this.filterType = type;
    this.handleSearch(this.searchTerm, type);
  }

  handleChange(variable, value) {
    this.filteredVariables = {
      ...this.filteredVariables,
      [variable]: value,
    };
    this.onVariableChange('global-css', variable, value);
  }

  handleColorInputChange(event) {
    const inputColor = event.target.value;
    this.colorForReplacement = inputColor;
    this.isColorValid =
      this.isValidHex(inputColor) || this.isValidRGB(inputColor) || this.isValidNamedColor(inputColor);
  }

  handleReplaceAllColors() {
    const isValid = this.colorForReplacement && this.isColorValid && !this.noVarsFound && this.searchTerm;
    if (isValid) {
      Object.entries(this.filteredVariables).forEach(([variable, value]) => {
        this.handleChange(variable, this.colorForReplacement);
      });
    } else {
      alert('Invalid color format. Please enter a valid color.');
    }
  }

  setCurrentChanges(changes) {
    this._currentChanges = changes;
    this._renderList(true);

    // Toggle the save button state.
    const footerContainer = document.querySelector('.sidebar__footer');
    const saveButton = footerContainer.querySelector('.sidebar__footer-btn-save');
    saveButton.disabled = !changes || !Object.keys(changes).length;
  }

  // Method to create hyperlist instance and render the virtualized list
  _renderList(refresh = false) {
    this._listContainer.classList.add('sidebar__content');
    if (!this.listForRender || !this.listForRender.length) {
      this._listContainer.innerHTML = '<div style="text-align: center; padding: 20px;">No variables found!</div>';
      return;
    }

    const config = {
      height: window.innerHeight - 350,
      itemHeight: this._itemHeight,
      total: this.listForRender.length,
      generate: (index) => {
        const [variable, value] = this.listForRender[index];
        return this._listItemTpl(variable, value, index);
      },
    };

    if (refresh && this._hyperList) {
      this._hyperList.refresh(this._listContainer, config);
      return;
    }

    // Init once
    if (!this._hyperList) {
      window.onresize = () => {
        if (this._hyperList) {
          config.height = (window.innerHeight * 2) / 3;
          this._hyperList.refresh(this._listContainer, config);
        }
      };
    }
    this._hyperList = HyperList.create(this._listContainer, config);
    document.querySelector('.list-container').appendChild(this._listContainer); // replace with the actual container selector
  }

  _listItemTpl(variable, value, index) {
    const flexBox = document.createElement('div');
    flexBox.className = `fixed-popover__item-variable item-${index}`;
    flexBox.style.display = 'flex';

    const variableDiv = document.createElement('div');
    variableDiv.textContent = variable;
    variableDiv.style.flex = '1';
    variableDiv.style.alignItems = 'center';

    const inputDiv = document.createElement('div');
    inputDiv.style.marginLeft = 'auto';

    const cssVariableItem = Helper.renderCSSVariableItem(this._currentChanges, variable, value, (...args) => {
      this.handleChange(...args);
    });
    inputDiv.appendChild(cssVariableItem);

    flexBox.appendChild(variableDiv);
    flexBox.appendChild(inputDiv);

    const input = document.createElement('input');
    input.className = 'fixed-popover__content-input';

    if (Helper.isColorValue(variable, value)) {
      input.type = 'color';
      input.value = value;
      input.onchange = (e) => this.handleChange(variable, e.target.value);
    } else if (Helper.isDimensionValue(value)) {
      input.type = 'number';
      input.value = parseFloat(value);
      input.onchange = (e) => {
        this.handleChange(variable, `${e.target.value}${value.replace(/\d/g, '')}`);
      };
    } else {
      input.type = 'text';
      input.value = value;
      input.onchange = (e) => this.handleChange(variable, e.target.value);
    }

    const inputContainer = document.createElement('div');
    inputContainer.style.alignItems = 'center';
    inputContainer.appendChild(input);
    flexBox.appendChild(inputContainer);

    return flexBox;
  }

  handleChange(variable, value) {
    this._renderList(true);
    if (this.options.onVariableChange) {
      this.options.onVariableChange('global-css', variable, value);
    }
  }

  attachEventListeners() {
    const searchInput = document.querySelector('.sidebar__content-search-input');
    const filterSelect = document.querySelector('.sidebar__content-filter');

    searchInput.addEventListener('input', this.handleSearchChange.bind(this));
    filterSelect.addEventListener('change', this.handleFilterChange.bind(this));

    // Click outside
    document.addEventListener('mousedown', () => {
      this._inspectButton.classList.remove('sidebar__header-inspect-btn--inspecting');
    });

    // Scroll the list to item
    const handleScrollTo = (event) => {
      // Check the type of the message
      if (event.data.action === Helper.CSS_VARIABLE_EDIT_GLOBAL_MSG_ACTION) {
        const { variable } = event.data.data;
        if (this._listContainer) {
          const index = this.listForRender.findIndex(([key]) => key === variable);
          const scrollPosition = index * this._itemHeight;
          this._listContainer.scrollTo({
            top: scrollPosition,
            behavior: 'smooth',
          });

          // Wait until scroll finish
          const checkIfScrollToIsFinished = setInterval(() => {
            if (scrollPosition === this._listContainer.scrollTop) {
              this.highlightItem(index);
              setTimeout(() => this.removeHighlightItem(index), 1e3);
              clearInterval(checkIfScrollToIsFinished);
            }
          }, 25);
        }
      }
    };

    window.addEventListener('message', handleScrollTo, false);
  }

  setPopoverController(ctrl) {
    this._popoverController = ctrl;
  }

  highlightItem(index) {
    const item = this._listContainer.querySelector(`div.item-${index}`);
    if (item) {
      item.classList.add('sidebar__content-item--highlight');
    }
  }

  removeHighlightItem(index) {
    const item = this._listContainer.querySelector(`div.item-${index}`);

    if (item) {
      item.classList.remove('sidebar__content-item--highlight');
    }
  }

  _render() {
    const sidebar = document.createElement('div');
    sidebar.className = 'sidebar';

    // Header section
    const header = document.createElement('div');
    header.className = 'sidebar__header';
    header.innerHTML = '<span>CSS Variables</span>';
    sidebar.appendChild(header);

    // Inspecting button
    this._inspectButton = document.createElement('button');
    this._inspectButton.className = 'sidebar__header-inspect-btn';
    this._inspectButton.innerHTML = `
      <svg focusable="false" aria-hidden="true" viewBox="0 0 24 24" style="fill: black;">
        <g stroke="none" stroke-width="1" fill-rule="evenodd">
          <g fill-rule="nonzero">
            <path d="M11.1950893,10.1463676 L11.2803,10.2197 L18.7803,17.7197 C19.015,17.9544 19.0675,18.3154 18.9095,18.6073 C18.7689667,18.8666778 18.491742,19.0165444 18.203754,18.9986064 L18.0955,18.9839 L13.8348,18.0869 L11.368,21.6749 C11.1819,21.9456 10.8413,22.0637 10.5275,21.9663 C10.2486556,21.8796333 10.0487444,21.6406309 10.0077623,21.3578731 L10,21.25 L10,10.75 C10,10.4467 10.1827,10.1732 10.463,10.0571 C10.708175,9.95553875 10.9858125,9.99197375 11.1950893,10.1463676 Z M11.5,12.5607 L11.5,18.8353 L12.882,16.8251 C13.0320625,16.6067875 13.2841063,16.4861688 13.5432703,16.5012283 L13.6545,16.5161 L15.9357,16.9964 L11.5,12.5607 Z M19.5,4 C20.8807,4 22,5.11929 22,6.5 L22,15.5 C22,16.7183 21.1285,17.7331 19.975,17.9549 C19.9,17.5176 19.6598,17.1137 19.2849,16.8388 L18.9461,16.5 L19.5,16.5 C20.0523,16.5 20.5,16.0523 20.5,15.5 L20.5,6.5 C20.5,5.94772 20.0523,5.5 19.5,5.5 L4.5,5.5 C3.94772,5.5 3.5,5.94772 3.5,6.5 L3.5,15.5 C3.5,16.0523 3.94772,16.5 4.5,16.5 L9,16.5 L9,18 L4.5,18 C3.11929,18 2,16.8807 2,15.5 L2,6.5 C2,5.11929 3.11929,4 4.5,4 L19.5,4 Z"></path>
          </g>
        </g>
      </svg>
    `;
    this._inspectButton.addEventListener('click', () => {
      const isEnabled = this._popoverController.toggleInspecting();
      const screenContainer = document.getElementById('mobile-screen');
      if (isEnabled) {
        this._inspectButton.classList.add('sidebar__header-inspect-btn--inspecting');
        screenContainer.setAttribute('data-cssvareditable', true);
      } else {
        this._inspectButton.classList.remove('sidebar__header-inspect-btn--inspecting');
        screenContainer.removeAttribute('data-cssvareditable');
      }
    });
    // Append the button to the sidebar header
    header.appendChild(this._inspectButton);

    // Search and filter section
    const searchContainer = document.createElement('div');
    searchContainer.className = 'sidebar__content-search';
    searchContainer.innerHTML = `
      <input type="text" placeholder="Search..." class="sidebar__content-search-input" />
      <select class="sidebar__content-filter">
        <option value="all">All</option>
        <option value="color">Color</option>
        <option value="dimension">Dimension</option>
        <option value="being-edited">Being Edited</option>
      </select>
    `;
    sidebar.appendChild(searchContainer);

    // Create color replacement section (initially hidden)
    const colorReplaceContainer = document.createElement('div');
    colorReplaceContainer.className = 'sidebar__color-replace';
    colorReplaceContainer.style.display = 'none';
    colorReplaceContainer.innerHTML = `
      <div class="sidebar__color-replace-searchbox">
        <input type="text" placeholder="#000000, rgb(255, 255, 255), red" class="sidebar__color-replace-input" />
        <input type="color" class="sidebar__color-replace-picker" />
      </div>
      <div>
        <button class="sidebar__color-replace-button" disabled title="Replace All">
          <svg focusable="false" aria-hidden="true" viewBox="0 0 521.92 521.92"><g><path d="M230.088,104.839c0-4.422,1.732-8.589,4.862-11.715l88.428-88.425c6.253-6.265,17.17-6.265,23.424,0   c6.461,6.455,6.461,16.97,0,23.431l-60.153,60.142h87.337c73.737,0,133.726,59.988,133.726,133.726   c0,69.604-69.771,124.74-118.015,129.321c-6.703,0.018-14.865-5.68-12.88-18.914c2.418-8.559,19.252-12.359,20.292-12.602   c44.337-10.48,77.467-50.301,77.467-97.806c0-55.467-45.123-100.59-100.59-100.59H286.66l60.142,60.154   c6.461,6.454,6.461,16.964,0,23.424c-6.266,6.271-17.171,6.254-23.424,0l-88.428-88.431   C231.82,113.427,230.088,109.266,230.088,104.839z M232.311,350.697h-46.849l49.812,49.811h-87.331   c-55.473,0-100.596-45.129-100.596-100.59c0-16.248,3.975-31.521,10.894-45.075c-1.132-2.896-2.196-5.798-3.121-8.677   c-3.047-9.481-4.688-19.305-5.612-29.241c-20.555,22.325-35.299,51.081-35.299,82.993c0,73.743,59.988,133.731,133.729,133.731   h87.331l-60.151,60.142c-6.452,6.455-6.452,16.965,0,23.431c6.254,6.266,17.171,6.266,23.424,0l88.438-88.431   c3.126-3.121,4.853-7.294,4.853-11.709c0-4.428-1.732-8.589-4.853-11.722L232.311,350.697z M307.809,282.014   c12.105-16.42,19.843-35.051,23.33-54.296c-14.098-11.106-26.941-23.933-38.261-37.569c4.374,28-4.008,57.612-25.54,79.146   c-35.813,35.813-94.079,35.813-129.883,0c-35.816-35.813-35.816-94.076,0-129.883c21.092-21.101,49.925-29.43,77.416-25.629   c1.782-14.333,6.345-28.105,17.803-35.979c-40.202-10.485-92.249,3.127-122.979,33.857c-51.107,51.104-51.107,134.275,0,185.391   c46.388,46.388,119.099,50.52,170.363,12.72L444.772,474.48c7.661,7.673,20.091,7.673,27.758,0c7.66-7.66,7.66-20.084,0-27.75   L307.809,282.014z"></path></g></svg>
        </button>
      </div>
    `;
    sidebar.appendChild(colorReplaceContainer);
    this._replacementState(colorReplaceContainer);

    // Filter change event listener
    const filterSelect = searchContainer.querySelector('.sidebar__content-filter');
    filterSelect.addEventListener('change', function () {
      this.filterType = this.value;
      if (this.filterType === 'color') {
        colorReplaceContainer.style.display = 'flex';
      } else {
        colorReplaceContainer.style.display = 'none';
      }
    });

    // List container
    const listContainer = document.createElement('div');
    listContainer.className = 'list-container';
    sidebar.appendChild(listContainer);

    document.getElementById('left-panel').appendChild(sidebar);

    // Initialize the list with HyperList
    this._renderList();

    // Footer section
    const footer = document.createElement('div');
    footer.className = 'sidebar__footer';

    // State message
    const stateMsg = document.createElement('div');
    stateMsg.className = 'sidebar__footer-state-msg';

    // Create exit button
    const exitButton = document.createElement('button');
    exitButton.className = 'sidebar__footer-btn-exit';
    exitButton.innerHTML =
      '<svg focusable="false" aria-hidden="true" viewBox="0 0 24 24"><path d="M10.09 15.59 11.5 17l5-5-5-5-1.41 1.41L12.67 11H3v2h9.67zM19 3H5c-1.11 0-2 .9-2 2v4h2V5h14v14H5v-4H3v4c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2"></path></svg> <span>EXIT</span>';
    exitButton.addEventListener('click', () => {
      this._onExit();
    });

    // Create save button
    const saveButton = document.createElement('button');
    saveButton.disabled = true;
    saveButton.className = 'sidebar__footer-btn-save';
    saveButton.innerHTML =
      '<svg focusable="false" aria-hidden="true" viewBox="0 0 24 24"><path d="M17 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V7zm-5 16c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3m3-10H5V5h10z"></path></svg> <span>SAVE</span>';
    saveButton.addEventListener('click', () => {
      this._onSave();
    });

    // Append buttons to footer
    footer.appendChild(saveButton);
    footer.appendChild(exitButton);
    footer.appendChild(stateMsg);

    // Append footer to sidebar
    sidebar.appendChild(footer);

    // Attach event listeners for search and filter
    this.attachEventListeners();
  }

  _replacementState(colorReplaceContainer) {
    const colorInput = colorReplaceContainer.querySelector('.sidebar__color-replace-input');
    const colorPicker = colorReplaceContainer.querySelector('.sidebar__color-replace-picker');
    const replaceButton = colorReplaceContainer.querySelector('.sidebar__color-replace-button');

    colorInput.addEventListener('input', (event) => {
      this.colorForReplacement = event.target.value;
      this.isColorValid =
        Helper.isValidHex(this.colorForReplacement) ||
        Helper.isValidRGB(this.colorForReplacement) ||
        Helper.isValidNamedColor(this.colorForReplacement);
      if (this.isColorValid) {
        colorInput.classList.remove('sidebar__color-replace-input--invalid');
      } else {
        colorInput.classList.add('sidebar__color-replace-input--invalid');
      }
      this.updateReplaceButtonState();
    });

    colorPicker.addEventListener('input', (event) => {
      this.colorForReplacement = event.target.value;
      colorInput.value = this.colorForReplacement;
      this.isColorValid =
        Helper.isValidHex(this.colorForReplacement) ||
        Helper.isValidRGB(this.colorForReplacement) ||
        Helper.isValidNamedColor(this.colorForReplacement);
      if (this.isColorValid) {
        colorInput.classList.remove('sidebar__color-replace-input--invalid');
      } else {
        colorInput.classList.add('sidebar__color-replace-input--invalid');
      }
      this.updateReplaceButtonState();
    });

    replaceButton.addEventListener('click', () => {
      this.handleReplaceAllColors();
    });
  }

  updateReplaceButtonState() {
    const colorReplaceContainer = document.querySelector('.sidebar__color-replace');
    const replaceButton = colorReplaceContainer.querySelector('.sidebar__color-replace-button');
    const isSearchTermValidColor =
      (!!this.searchTerm && Helper.isValidHex(this.searchTerm)) ||
      Helper.isValidRGB(this.searchTerm) ||
      Helper.isValidNamedColor(this.searchTerm);
    replaceButton.disabled = !this.colorForReplacement || !this.isColorValid || !isSearchTermValidColor;
  }

  async _onSave() {
    if (!this._currentChanges || !Object.keys(this._currentChanges).length) {
      console.warn('Nothing to save!');
      return;
    }

    const footerContainer = document.querySelector('.sidebar__footer');
    const saveButton = footerContainer.querySelector('.sidebar__footer-btn-save');
    const exitButton = footerContainer.querySelector('.sidebar__footer-btn-exit');
    const stateMsg = footerContainer.querySelector('.sidebar__footer-state-msg');

    saveButton.disabled = true;
    exitButton.disabled = true;
    stateMsg.textContent = 'Saving...';

    const newThemeConfig = await ThemerService.saveTokens(this._currentChanges);

    exitButton.disabled = false;

    if (newThemeConfig) {
      console.log('The theme configuration has been updated.');
      stateMsg.textContent = 'Done!';
      this._currentChanges = {};

      try {
        // Update from session
        const themerConfigStr = sessionStorage.getItem(Helper.THEMER_SESSION_KEY);
        const themerConfig = JSON.parse(themerConfigStr);
        this._renderList(true);

        sessionStorage.setItem(
          Helper.THEMER_SESSION_KEY,
          JSON.stringify({
            ...themerConfig,
            themeConfig: JSON.stringify(newThemeConfig),
          })
        );

        this._popoverController.setOriginVariables({ ...newThemeConfig.globalCss[':root'] });
        this._popoverController.setCurrentChanges({});
      } catch (err) {
        console.error('Cannot parse the themer configuration!');
      }
    } else {
      console.error('Something went wrong. Please try again or contact the system administrator.');
      stateMsg.textContent = 'Something went wrong!';
      saveButton.disabled = false;
    }

    setTimeout(() => {
      stateMsg.textContent = '';
    }, 3e3);
  }

  _onExit() {
    sessionStorage.removeItem(Helper.THEMER_SESSION_KEY);
    location.reload();
  }
}
