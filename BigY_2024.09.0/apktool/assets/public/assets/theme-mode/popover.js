'use strict';
import Helper from './helper.js';

export default class CSSVariablePopover {
  constructor(popoverElement, onVariableChange) {
    this.currentValues = {};
    this.currentChanges = {};
    this.tagName = '';
    this.onVariableChange = onVariableChange;
    this.isDragging = false;
    this.popoverWidth = 320;
    this.dragOffset = { x: 0, y: 0 };
    this.popoverPosition = { x: 0, y: 0 };
    this.popover = popoverElement;
    this.popoverContent = this.popover.querySelector('.fixed-popover__content');

    // Initialize event listeners
    this.initEventListeners();
  }

  // Create the popover element
  render() {
    this.popover.classList.add('fixed-popover__container');
    if (!this.currentValues || Object.keys(this.currentValues).length === 0) {
      this.popover.innerHTML = '';
      return;
    }
    this.popover.innerHTML = `
      <div class="fixed-popover__header">
        <div style="color: #000; display: flex; font-weight: 500; justify-content: flex-start; align-items: center; flex: 1;">
          CSS Variables Inspector
        </div>
        <div style="display: flex; align-items: center; justify-content: flex-end;">
          <span class="drag-icon" style="font-size: 20px;">☰</span>
        </div>
      </div>
      <div class="fixed-popover__content">
        <label class="fixed-popover__content-label">&lt;${this.tagName.toLocaleLowerCase()}&gt;</label>
        <div id="list-content"></div>
      </div>`;
    this._renderList();
  }

  _renderList() {
    const ul = document.createElement('ul');
    ul.className = 'fixed-popover__list';

    Object.entries(this.currentValues).forEach(([property, vars]) => {
      const li = document.createElement('li');
      li.className = 'fixed-popover__item';

      const strong = document.createElement('strong');
      strong.className = 'fixed-popover__item-title';
      strong.textContent = property;
      li.appendChild(strong);

      Object.entries(vars).forEach(([variable, value]) => {
        const flexBox = document.createElement('div');
        flexBox.className = 'fixed-popover__item-variable';
        flexBox.style.display = 'flex';

        const variableDiv = document.createElement('div');
        variableDiv.textContent = variable;
        variableDiv.style.flex = '1';
        variableDiv.style.alignItems = 'center';

        const inputDiv = document.createElement('div');
        inputDiv.style.marginLeft = 'auto';

        const cssVariableItem = Helper.renderCSSVariableItem(this.currentChanges, variable, value, (...args) => {
          this.handleChange(property, ...args);
        });
        inputDiv.appendChild(cssVariableItem);

        flexBox.appendChild(variableDiv);
        flexBox.appendChild(inputDiv);

        const input = document.createElement('input');
        input.className = 'fixed-popover__content-input';

        if (Helper.isColorValue(variable, value, property)) {
          input.type = 'color';
          input.value = value;
          input.onchange = (e) => this.handleChange(property, variable, e.target.value);
        } else if (Helper.isDimensionValue(value)) {
          input.type = 'number';
          input.value = parseFloat(value);
          input.onchange = (e) => {
            this.handleChange(property, variable, `${e.target.value}${value.replace(/\d/g, '')}`);
          };
        } else {
          input.type = 'text';
          input.value = value;
          input.onchange = (e) => this.handleChange(property, variable, e.target.value);
        }

        const inputContainer = document.createElement('div');
        inputContainer.style.alignItems = 'center';
        inputContainer.appendChild(input);
        flexBox.appendChild(inputContainer);

        li.appendChild(flexBox);
      });

      ul.appendChild(li);
    });
    const listContainer = this.popover.querySelector('#list-content');

    if (listContainer) {
      listContainer.innerHTML = '';
      listContainer.appendChild(ul);
    }
  }

  handleChange(property, variable, value) {
    this.currentValues[property] = {
      ...this.currentValues[property],
      [variable]: value,
    };

    this._renderList();
    this.onVariableChange(property, variable, value);
  }

  // Set variables, current changes, and other dynamic data
  setVariables({ variables, tagName, currentChanges }) {
    this.currentValues = variables || {};
    this.tagName = tagName || '';
    this.render();
  }

  setCurrentChanges(changes) {
    this.currentChanges = changes;
    this._renderList();
  }

  // This method can be called by the main program to set the position of the popover
  setPosition(position) {
    this.popoverPosition = position;
    this.popover.style.left = `${this.popoverPosition.x}px`;
    this.popover.style.top = `${this.popoverPosition.y}px`;
    this.popover.style.display = Object.keys(this.currentValues).length ? 'block' : 'none';

    // Correct position
    if (Object.keys(this.currentValues).length) {
      const popoverHeight = this.popover.offsetHeight;
      const windowWidth = window.innerWidth;
      const windowHeight = window.innerHeight;

      // Adjust if overflowing on the right
      if (position.x + this.popoverWidth > windowWidth) {
        this.popover.style.left = `${position.x - this.popoverWidth}px`;
      }

      // Adjust if overflowing on the bottom
      if (position.y + popoverHeight > windowHeight) {
        const newY = position.y - popoverHeight;
        this.popover.style.top = `${newY > 0 ? newY : 0}px`;
      }
    }
  }

  // Hide popover
  hidePopover() {
    this.popover.style.display = 'none';
  }

  // Handle drag start event
  handleDragStart(event) {
    this.isDragging = true;
    const rect = this.popover.getBoundingClientRect();
    this.dragOffset = {
      x: event.clientX - rect.left,
      y: event.clientY - rect.top,
    };
  }

  // Handle dragging
  handleDrag(event) {
    if (this.isDragging) {
      const newX = event.clientX - this.dragOffset.x;
      const newY = event.clientY - this.dragOffset.y;
      this.popover.style.left = `${newX}px`;
      this.popover.style.top = `${newY}px`;
    }
  }

  // Handle drag end
  handleDragEnd() {
    const rect = this.popover.getBoundingClientRect();

    let correctedX = this.popover.style.left;
    let correctedY = this.popover.style.top;

    // Correct X position if out of bounds
    if (rect.left < 0) {
      correctedX = 0; // Align to the left
    } else if (rect.right > window.innerWidth) {
      correctedX = window.innerWidth - rect.width; // Align to the right
    }

    // Correct Y position if out of bounds
    if (rect.top < 0) {
      correctedY = 0; // Align to the top
    } else if (rect.bottom > window.innerHeight) {
      correctedY = window.innerHeight - rect.height; // Align to the bottom
    }

    // Only update the X or Y position if changed
    if (correctedX !== this.popover.style.left || correctedY !== this.popover.style.top) {
      this.popover.style.left = `${correctedX}px`;
      this.popover.style.top = `${correctedY}px`;
    }
    this.isDragging = false;
  }

  // Detect clicks outside the popover to close it
  handleClickOutside(event) {
    if (!this.popover.contains(event.target)) {
      this.hidePopover();
    }
  }

  // Set the content of the popover dynamically
  setContent() {
    this.popoverContent.innerHTML = '';
    for (const [variable, value] of Object.entries(this.variables)) {
      const listItem = document.createElement('div');
      listItem.classList.add('fixed-popover__item');
      listItem.innerHTML = `
          <strong class="fixed-popover__item-title">${variable}</strong> 
          <input type="text" value="${value}" class="fixed-popover__content-input"/>`;
      this.popoverContent.appendChild(listItem);
    }
  }

  // Initialize event listeners
  initEventListeners() {
    // Add listeners for dragging
    this.popover.addEventListener('mousedown', this.handleDragStart.bind(this));
    document.addEventListener('mousemove', this.handleDrag.bind(this));
    document.addEventListener('mouseup', this.handleDragEnd.bind(this));

    // Add listener for detecting clicks outside the popover
    document.addEventListener('click', this.handleClickOutside.bind(this));
  }

  // Method to destroy event listeners if needed
  destroy() {
    document.removeEventListener('mousemove', this.handleDrag.bind(this));
    document.removeEventListener('mouseup', this.handleDragEnd.bind(this));
    document.removeEventListener('click', this.handleClickOutside.bind(this));
  }
}
