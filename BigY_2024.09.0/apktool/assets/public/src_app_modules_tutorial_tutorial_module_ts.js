"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_tutorial_tutorial_module_ts"],{

/***/ 64627:
/*!***************************************************************!*\
  !*** ./src/app/modules/tutorial/pages/set-store/set-store.ts ***!
  \***************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   SetStorePageComponent: () => (/* binding */ SetStorePageComponent)
/* harmony export */ });
/* harmony import */ var _ionic_storage__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @ionic/storage */ 60850);
/* harmony import */ var _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/constants/constants */ 29665);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);









const _c0 = a0 => ({
  "input-error": a0
});
function SetStorePageComponent_p_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "p", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](1, "Please enter a valid ZIP Code");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
}
class SetStorePageComponent {
  router;
  route;
  storage;
  RegularExpression = _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_1__.RegularExpression;
  zipCode = '';
  constructor(router, route, storage) {
    this.router = router;
    this.route = route;
    this.storage = storage;
  }
  getPageName() {
    return 'SetStorePage';
  }
  static ɵfac = function SetStorePageComponent_Factory(t) {
    return new (t || SetStorePageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_ionic_storage__WEBPACK_IMPORTED_MODULE_0__.Storage));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: SetStorePageComponent,
    selectors: [["set-store"]],
    decls: 16,
    vars: 6,
    consts: [["cZip", "ngModel"], [1, "ion-no-line"], ["slot", "start"], ["defaultHref", "tutorial", "text", "", "icon", "md-arrow-back", "color", "dark"], [1, "zipcode-container"], ["label", "ZIP Code", "type", "tel", "maxlength", "5", "label-placement", "floating", 3, "ngModelChange", "ngClass", "pattern", "ngModel"], ["class", "error", 4, "ngIf"], [1, "actions"], [1, "find-store"], [1, "current-location"], [1, "error"]],
    template: function SetStorePageComponent_Template(rf, ctx) {
      if (rf & 1) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "ion-header")(1, "ion-toolbar", 1)(2, "ion-title");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3, "Enter a ZIP Code");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "ion-buttons", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](5, "ion-back-button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](6, "ion-content")(7, "div", 4)(8, "ion-input", 5, 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtwoWayListener"]("ngModelChange", function SetStorePageComponent_Template_ion_input_ngModelChange_8_listener($event) {
          _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1);
          _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtwoWayBindingSet"](ctx.zipCode, $event) || (ctx.zipCode = $event);
          return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"]($event);
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](10, SetStorePageComponent_p_10_Template, 2, 0, "p", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](11, "div", 7)(12, "ion-button", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](13, "Find And Set My Store");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](14, "ion-button", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](15, "Use Current Location");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
      }
      if (rf & 2) {
        const cZip_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵreference"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction1"](4, _c0, (cZip_r2 == null ? null : cZip_r2.errors == null ? null : cZip_r2.errors.pattern) ? true : false))("pattern", ctx.RegularExpression.ZipPattern);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtwoWayProperty"]("ngModel", ctx.zipCode);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (cZip_r2 == null ? null : cZip_r2.errors == null ? null : cZip_r2.errors.pattern) && (cZip_r2 == null ? null : cZip_r2.touched));
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf, _angular_forms__WEBPACK_IMPORTED_MODULE_5__.NgControlStatus, _angular_forms__WEBPACK_IMPORTED_MODULE_5__.MaxLengthValidator, _angular_forms__WEBPACK_IMPORTED_MODULE_5__.PatternValidator, _angular_forms__WEBPACK_IMPORTED_MODULE_5__.NgModel, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonInput, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.TextValueAccessor, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonBackButton],
    styles: ["@font-face {\n  font-family: \"Poppins\";\n  font-style: normal;\n  font-weight: 400;\n  src: url(/assets/fonts/poppins/pxiEyp8kv8JHgFVrJJbecmNE.woff2) format(\"woff2\");\n  unicode-range: U+0900-097F, U+1CD0-1CF6, U+1CF8-1CF9, U+200C-200D, U+20A8, U+20B9, U+25CC, U+A830-A839, U+A8E0-A8FB;\n}\n\n\n@font-face {\n  font-family: \"Poppins\";\n  font-style: normal;\n  font-weight: 400;\n  src: url(/assets/fonts/poppins/pxiEyp8kv8JHgFVrJJnecmNE.woff2) format(\"woff2\");\n  unicode-range: U+0100-024F, U+0259, U+1E00-1EFF, U+2020, U+20A0-20AB, U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;\n}\n\n\n@font-face {\n  font-family: \"Poppins\";\n  font-style: normal;\n  font-weight: 400;\n  src: url(/assets/fonts/poppins/pxiEyp8kv8JHgFVrJJfecg.woff2) format(\"woff2\");\n  unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;\n}\nion-content[_ngcontent-%COMP%] {\n  --padding-start: 15px;\n  --padding-end: 15px;\n}\n\nion-input[_ngcontent-%COMP%] {\n  border: 2px solid var(--mag-colorborder, #121212);\n  border-radius: var(--mag-borderradiusmedium, 8px);\n  --color: var(--mag-colortext, #121212);\n  --highlight-color-invalid: var(--mag-colorborderalert, #da0808);\n  font-family: var(--mag-typographyplatformfont-family, \"Lexend\");\n  font-size: var(--mag-typographybodymediumfont-size, 16px);\n  font-weight: var(--mag-typographybodymediumfont-weightregular, 300);\n  line-height: var(--mag-typographybodymediumline-height, 24px);\n  text-align: left;\n}\n\nion-title[_ngcontent-%COMP%] {\n  --color: var(--mag-colortext, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typographyheadlinessmallfont-size, 18px);\n  font-weight: var(--mag-typographyheadlinessmallfont-weight, 500);\n  line-height: var(--mag-typographyheadlinessmallline-height, 24px);\n}\n\n.input-error[_ngcontent-%COMP%] {\n  border: 2px solid var(--mag-colorborderalert, #da0808);\n  background-color: rgba(218, 8, 8, 0.1);\n  color: var(--mag-colortextalert, #da0808);\n}\n\n.error[_ngcontent-%COMP%] {\n  text-align: left;\n  margin-left: 5px;\n  color: var(--mag-colortextalert, #da0808);\n  font-family: var(--mag-typographyplatformfont-family, \"Lexend\");\n  font-size: var(--mag-typographybodysmallfont-size, 14px);\n  font-weight: var(--mag-typographybodysmallfont-weightemphasized, 400);\n  line-height: var(--mag-typographybodysmallline-height, 20px);\n}\n\n.actions[_ngcontent-%COMP%] {\n  margin-top: 20px;\n}\n.actions[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  width: 100%;\n  --background-activated: none;\n  --background-focused: none;\n  --background-hover: none;\n}\n.actions[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: 48px;\n}\n.actions[_ngcontent-%COMP%]   .find-store[_ngcontent-%COMP%] {\n  --border-radius: var(--mag-borderradiusrounded, 9999px);\n  --color: var(--mag-colortextbuttonfilledbrand, #ffffff);\n  --background: var(--mag-colorsurfacebuttonfilledbrand, #008000);\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typographybutton-labelsmediumfont-size, 16px);\n  font-weight: var(--mag-typographybutton-labelmediumfont-weight, 500);\n  line-height: var(--mag-typographybutton-labelsmediumline-height, 24px);\n}\n.actions[_ngcontent-%COMP%]   .current-location[_ngcontent-%COMP%] {\n  --color: var(--mag-colortextbuttonfilledbrand, #008000);\n  --background: transparent;\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typographybutton-labelsmediumfont-size, 16px);\n  font-weight: var(--mag-typographybutton-labelmediumfont-weight, 500);\n  line-height: var(--mag-typographybutton-labelsmediumline-height, 24px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy90dXRvcmlhbC9wYWdlcy9zZXQtc3RvcmUvc2V0LXN0b3JlLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxzQkFBQTtFQUNBLGtCQUFBO0VBQ0EsZ0JBQUE7RUFDQSw4RUFBQTtFQUNBLG1IQUFBO0FBQ0Y7QUFDQSxjQUFBO0FBRUE7RUFDRSxzQkFBQTtFQUNBLGtCQUFBO0VBQ0EsZ0JBQUE7RUFDQSw4RUFBQTtFQUNBLG1IQUFBO0FBQUY7QUFFQSxVQUFBO0FBRUE7RUFDRSxzQkFBQTtFQUNBLGtCQUFBO0VBQ0EsZ0JBQUE7RUFDQSw0RUFBQTtFQUNBLHlLQUFBO0FBREY7QUFLQTtFQUNFLHFCQUFBO0VBQ0EsbUJBQUE7QUFIRjs7QUFNQTtFQUNFLGlEQUFBO0VBQ0EsaURBQUE7RUFDQSxzQ0FBQTtFQUNBLCtEQUFBO0VBQ0EsK0RBQUE7RUFDQSx5REFBQTtFQUNBLG1FQUFBO0VBQ0EsNkRBQUE7RUFDQSxnQkFBQTtBQUhGOztBQU1BO0VBQ0Usc0NBQUE7RUFDQSx3REFBQTtFQUNBLDZEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxpRUFBQTtBQUhGOztBQU1BO0VBQ0Usc0RBQUE7RUFDQSxzQ0FBQTtFQUNBLHlDQUFBO0FBSEY7O0FBTUE7RUFDRSxnQkFBQTtFQUNBLGdCQUFBO0VBQ0EseUNBQUE7RUFDQSwrREFBQTtFQUNBLHdEQUFBO0VBQ0EscUVBQUE7RUFDQSw0REFBQTtBQUhGOztBQU1BO0VBQ0UsZ0JBQUE7QUFIRjtBQUlFO0VBQ0UsV0FBQTtFQUNBLDRCQUFBO0VBQ0EsMEJBQUE7RUFDQSx3QkFBQTtBQUZKO0FBSUU7RUFDRSxZQUFBO0FBRko7QUFJRTtFQUNFLHVEQUFBO0VBQ0EsdURBQUE7RUFDQSwrREFBQTtFQUNBLHdEQUFBO0VBQ0Esa0VBQUE7RUFDQSxvRUFBQTtFQUNBLHNFQUFBO0FBRko7QUFLRTtFQUNFLHVEQUFBO0VBQ0EseUJBQUE7RUFDQSx3REFBQTtFQUNBLGtFQUFBO0VBQ0Esb0VBQUE7RUFDQSxzRUFBQTtBQUhKIiwic291cmNlc0NvbnRlbnQiOlsiQGZvbnQtZmFjZSB7XG4gIGZvbnQtZmFtaWx5OiAnUG9wcGlucyc7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgZm9udC13ZWlnaHQ6IDQwMDtcbiAgc3JjOiB1cmwoL2Fzc2V0cy9mb250cy9wb3BwaW5zL3B4aUV5cDhrdjhKSGdGVnJKSmJlY21ORS53b2ZmMikgZm9ybWF0KCd3b2ZmMicpO1xuICB1bmljb2RlLXJhbmdlOiBVKzA5MDAtMDk3RiwgVSsxQ0QwLTFDRjYsIFUrMUNGOC0xQ0Y5LCBVKzIwMEMtMjAwRCwgVSsyMEE4LCBVKzIwQjksIFUrMjVDQywgVStBODMwLUE4MzksIFUrQThFMC1BOEZCO1xufVxuLyogbGF0aW4tZXh0ICovXG5cbkBmb250LWZhY2Uge1xuICBmb250LWZhbWlseTogJ1BvcHBpbnMnO1xuICBmb250LXN0eWxlOiBub3JtYWw7XG4gIGZvbnQtd2VpZ2h0OiA0MDA7XG4gIHNyYzogdXJsKC9hc3NldHMvZm9udHMvcG9wcGlucy9weGlFeXA4a3Y4SkhnRlZySkpuZWNtTkUud29mZjIpIGZvcm1hdCgnd29mZjInKTtcbiAgdW5pY29kZS1yYW5nZTogVSswMTAwLTAyNEYsIFUrMDI1OSwgVSsxRTAwLTFFRkYsIFUrMjAyMCwgVSsyMEEwLTIwQUIsIFUrMjBBRC0yMENGLCBVKzIxMTMsIFUrMkM2MC0yQzdGLCBVK0E3MjAtQTdGRjtcbn1cbi8qIGxhdGluICovXG5cbkBmb250LWZhY2Uge1xuICBmb250LWZhbWlseTogJ1BvcHBpbnMnO1xuICBmb250LXN0eWxlOiBub3JtYWw7XG4gIGZvbnQtd2VpZ2h0OiA0MDA7XG4gIHNyYzogdXJsKC9hc3NldHMvZm9udHMvcG9wcGlucy9weGlFeXA4a3Y4SkhnRlZySkpmZWNnLndvZmYyKSBmb3JtYXQoJ3dvZmYyJyk7XG4gIHVuaWNvZGUtcmFuZ2U6IFUrMDAwMC0wMEZGLCBVKzAxMzEsIFUrMDE1Mi0wMTUzLCBVKzAyQkItMDJCQywgVSswMkM2LCBVKzAyREEsIFUrMDJEQywgVSsyMDAwLTIwNkYsIFUrMjA3NCwgVSsyMEFDLFxuICAgIFUrMjEyMiwgVSsyMTkxLCBVKzIxOTMsIFUrMjIxMiwgVSsyMjE1LCBVK0ZFRkYsIFUrRkZGRDtcbn1cblxuaW9uLWNvbnRlbnQge1xuICAtLXBhZGRpbmctc3RhcnQ6IDE1cHg7XG4gIC0tcGFkZGluZy1lbmQ6IDE1cHg7XG59XG5cbmlvbi1pbnB1dCB7XG4gIGJvcmRlcjogMnB4IHNvbGlkIHZhcigtLW1hZy1jb2xvcmJvcmRlciwgIzEyMTIxMik7XG4gIGJvcmRlci1yYWRpdXM6IHZhcigtLW1hZy1ib3JkZXJyYWRpdXNtZWRpdW0sIDhweCk7XG4gIC0tY29sb3I6IHZhcigtLW1hZy1jb2xvcnRleHQsICMxMjEyMTIpO1xuICAtLWhpZ2hsaWdodC1jb2xvci1pbnZhbGlkOiB2YXIoLS1tYWctY29sb3Jib3JkZXJhbGVydCwgI2RhMDgwOCk7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeXBsYXRmb3JtZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeWJvZHltZWRpdW1mb250LXNpemUsIDE2cHgpO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHlib2R5bWVkaXVtZm9udC13ZWlnaHRyZWd1bGFyLCAzMDApO1xuICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHlib2R5bWVkaXVtbGluZS1oZWlnaHQsIDI0cHgpO1xuICB0ZXh0LWFsaWduOiBsZWZ0O1xufVxuXG5pb24tdGl0bGUge1xuICAtLWNvbG9yOiB2YXIoLS1tYWctY29sb3J0ZXh0LCAjMTIxMjEyKTtcbiAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHloZWFkbGluZXNzbWFsbGZvbnQtc2l6ZSwgMThweCk7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeWhlYWRsaW5lc3NtYWxsZm9udC13ZWlnaHQsIDUwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeWhlYWRsaW5lc3NtYWxsbGluZS1oZWlnaHQsIDI0cHgpO1xufVxuXG4uaW5wdXQtZXJyb3Ige1xuICBib3JkZXI6IDJweCBzb2xpZCB2YXIoLS1tYWctY29sb3Jib3JkZXJhbGVydCwgI2RhMDgwOCk7XG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjE4LCA4LCA4LCAwLjEpO1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9ydGV4dGFsZXJ0LCAjZGEwODA4KTtcbn1cblxuLmVycm9yIHtcbiAgdGV4dC1hbGlnbjogbGVmdDtcbiAgbWFyZ2luLWxlZnQ6IDVweDtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvcnRleHRhbGVydCwgI2RhMDgwOCk7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeXBsYXRmb3JtZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeWJvZHlzbWFsbGZvbnQtc2l6ZSwgMTRweCk7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeWJvZHlzbWFsbGZvbnQtd2VpZ2h0ZW1waGFzaXplZCwgNDAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5Ym9keXNtYWxsbGluZS1oZWlnaHQsIDIwcHgpO1xufVxuXG4uYWN0aW9ucyB7XG4gIG1hcmdpbi10b3A6IDIwcHg7XG4gIGlvbi1idXR0b24ge1xuICAgIHdpZHRoOiAxMDAlO1xuICAgIC0tYmFja2dyb3VuZC1hY3RpdmF0ZWQ6IG5vbmU7XG4gICAgLS1iYWNrZ3JvdW5kLWZvY3VzZWQ6IG5vbmU7XG4gICAgLS1iYWNrZ3JvdW5kLWhvdmVyOiBub25lO1xuICB9XG4gIGlvbi1idXR0b246OnBhcnQobmF0aXZlKSB7XG4gICAgaGVpZ2h0OiA0OHB4O1xuICB9XG4gIC5maW5kLXN0b3JlIHtcbiAgICAtLWJvcmRlci1yYWRpdXM6IHZhcigtLW1hZy1ib3JkZXJyYWRpdXNyb3VuZGVkLCA5OTk5cHgpO1xuICAgIC0tY29sb3I6IHZhcigtLW1hZy1jb2xvcnRleHRidXR0b25maWxsZWRicmFuZCwgI2ZmZmZmZik7XG4gICAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3JzdXJmYWNlYnV0dG9uZmlsbGVkYnJhbmQsICMwMDgwMDApO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHlidXR0b24tbGFiZWxzbWVkaXVtZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHlidXR0b24tbGFiZWxtZWRpdW1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHlidXR0b24tbGFiZWxzbWVkaXVtbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG5cbiAgLmN1cnJlbnQtbG9jYXRpb24ge1xuICAgIC0tY29sb3I6IHZhcigtLW1hZy1jb2xvcnRleHRidXR0b25maWxsZWRicmFuZCwgIzAwODAwMCk7XG4gICAgLS1iYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5YnV0dG9uLWxhYmVsc21lZGl1bWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5YnV0dG9uLWxhYmVsbWVkaXVtZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5YnV0dG9uLWxhYmVsc21lZGl1bWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 88649:
/*!*************************************************************!*\
  !*** ./src/app/modules/tutorial/pages/tutorial/tutorial.ts ***!
  \*************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   TutorialPageComponent: () => (/* binding */ TutorialPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _ionic_storage__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ionic/storage */ 60850);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/utils/constants/constants */ 29665);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _providers_zoomable_directive__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../providers/zoomable.directive */ 97728);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);






















function TutorialPageComponent_ion_modal_8_ng_template_1_swiper_slide_12_img_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](0, "img", 21);
  }
  if (rf & 2) {
    const slide_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpropertyInterpolate"]("alt", slide_r4 == null ? null : slide_r4.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("src", slide_r4 == null ? null : slide_r4.imageUrl, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeUrl"]);
  }
}
function TutorialPageComponent_ion_modal_8_ng_template_1_swiper_slide_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "swiper-slide", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](1, TutorialPageComponent_ion_modal_8_ng_template_1_swiper_slide_12_img_1_Template, 1, 2, "img", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const slide_r4 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", slide_r4 == null ? null : slide_r4.imageUrl);
  }
}
function TutorialPageComponent_ion_modal_8_ng_template_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "ion-header", 12)(1, "ion-toolbar")(2, "ion-title", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipe"](4, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](5, "ion-buttons", 4)(6, "ion-button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function TutorialPageComponent_ion_modal_8_ng_template_1_Template_ion_button_click_6_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r3);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r1.closeViewer());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](7, "span", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipe"](9, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()()()()();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](10, "ion-content", 16)(11, "swiper-container", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](12, TutorialPageComponent_ion_modal_8_ng_template_1_swiper_slide_12_Template, 2, 1, "swiper-slide", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipeBind1"](4, 4, "tutorial.title"), " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipeBind1"](9, 6, "tutorial.btnDone"), " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵattribute"]("initial-slide", ctx_r1.initialSlideIndex);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngForOf", ctx_r1.tutorialList);
  }
}
function TutorialPageComponent_ion_modal_8_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "ion-modal", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("didDismiss", function TutorialPageComponent_ion_modal_8_Template_ion_modal_didDismiss_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r1);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r1.closeViewer());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](1, TutorialPageComponent_ion_modal_8_ng_template_1_Template, 13, 8, "ng-template");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("isOpen", ctx_r1.isViewerOpen)("showBackdrop", false)("backdropDismiss", false);
  }
}
function TutorialPageComponent_ion_content_10_div_1_div_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div", 31)(1, "button", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function TutorialPageComponent_ion_content_10_div_1_div_3_Template_button_click_1_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r6);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r1.openViewer(0));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](2, "img", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpropertyInterpolate"]("alt", ctx_r1.firstTour == null ? null : ctx_r1.firstTour.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("src", ctx_r1.firstTour == null ? null : ctx_r1.firstTour.imageUrl, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeUrl"]);
  }
}
function TutorialPageComponent_ion_content_10_div_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r5 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div", 23)(1, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](2, "h1", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](3, TutorialPageComponent_ion_content_10_div_1_div_3_Template, 3, 2, "div", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](4, "span", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](5, "div", 28)(6, "ion-button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function TutorialPageComponent_ion_content_10_div_1_Template_ion_button_click_6_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r5);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r1.startTour());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](7, "span", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipe"](9, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](10, "ion-icon", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()()()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("innerHTML", ctx_r1.firstTour == null ? null : ctx_r1.firstTour.title, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeHtml"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx_r1.firstTour == null ? null : ctx_r1.firstTour.imageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("innerHTML", ctx_r1.firstTour == null ? null : ctx_r1.firstTour.description, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeHtml"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipeBind1"](9, 4, "tutorial.btnNext"), " ");
  }
}
function TutorialPageComponent_ion_content_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "ion-content");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](1, TutorialPageComponent_ion_content_10_div_1_Template, 11, 6, "div", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx_r1.firstTour);
  }
}
function TutorialPageComponent_ion_content_11_swiper_slide_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "swiper-slide", 37)(1, "div", 38)(2, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](3, "h1", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](4, "div", 31)(5, "button", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function TutorialPageComponent_ion_content_11_swiper_slide_3_Template_button_click_5_listener() {
      const i_r9 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r8).index;
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r1.openViewer(i_r9 + 1));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](6, "img", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](7, "span", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const slide_r10 = ctx.$implicit;
    const i_r9 = ctx.index;
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpropertyInterpolate2"]("aria-label", "Slide ", i_r9 + 1, " of ", slide_r10 == null ? null : slide_r10.title, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("innerHTML", slide_r10 == null ? null : slide_r10.title, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeHtml"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpropertyInterpolate"]("alt", slide_r10 == null ? null : slide_r10.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("src", slide_r10 == null ? null : slide_r10.imageUrl, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeUrl"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("innerHTML", slide_r10 == null ? null : slide_r10.description, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵsanitizeHtml"]);
  }
}
function TutorialPageComponent_ion_content_11_Template(rf, ctx) {
  if (rf & 1) {
    const _r7 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "ion-content")(1, "div", 34)(2, "swiper-container", 35);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("swiperslidechange", function TutorialPageComponent_ion_content_11_Template_swiper_container_swiperslidechange_2_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r7);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r1.slideChanged($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](3, TutorialPageComponent_ion_content_11_swiper_slide_3_Template, 8, 7, "swiper-slide", 36);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngForOf", ctx_r1.swiperSlides);
  }
}
class TutorialPageComponent {
  router;
  route;
  storage;
  utils;
  appSettings;
  translate;
  cre;
  appHammerZoomable;
  swiperRef;
  swiper;
  back;
  info = {
    version: _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.AppVersion,
    buildNumber: _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.BuildNumber
  };
  isStartTour = false;
  isDidTutorial;
  currentSlide = 0;
  firstTour;
  swiperSlides = [];
  tutorialList = [];
  tutorialNumber;
  isViewerOpen = false;
  currentImage = '';
  initialSlideIndex = 0;
  constructor(router, route, storage, utils, appSettings, translate, cre) {
    this.router = router;
    this.route = route;
    this.storage = storage;
    this.utils = utils;
    this.appSettings = appSettings;
    this.translate = translate;
    this.cre = cre;
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const currentLocale = _this.translate.currentLang || (yield _this.storage.get(_rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__.LOCAL_LOCALE_KEY)) || _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__.DEFAULT_LOCALE;
      _this.appSettings.getSettingValue('tutorial_configurations').subscribe(/*#__PURE__*/function () {
        var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (rs) {
          try {
            const parseData = typeof rs === 'string' ? JSON.parse(rs) : [];
            const items = Array.isArray(parseData.tutorial_information) ? parseData.tutorial_information : [];
            _this.tutorialNumber = parseData.tutorial_version;
            _this.tutorialList = items.map(item => ({
              ...item,
              title: item.title?.[currentLocale] || '',
              description: item.description?.[currentLocale] || ''
            })).filter(({
              title,
              imageUrl,
              description
            }) => title?.trim() || imageUrl?.trim() || description?.trim());
            if (_this.tutorialList?.length) {
              _this.firstTour = _this.tutorialList[0];
              _this.swiperSlides = _this.tutorialList.slice(1);
            }
            const tutorialCached = yield _this.storage.get('tutorial_version');
            const updateVersion = !tutorialCached || parseInt(tutorialCached) < parseInt(_this.tutorialNumber);
            if (updateVersion) _this.storage.set('tutorial_version', _this.tutorialNumber);
          } catch (e) {
            _this.router.navigate(['/tabs/home']);
            _this.tutorialList = [];
            console.error(e);
          }
        });
        return function (_x) {
          return _ref.apply(this, arguments);
        };
      }());
    })();
  }
  startTour() {
    this.isStartTour = true;
  }
  ngAfterViewInit() {
    this.swiperRef = document.querySelector('swiper-container');
  }
  slideChanged(e) {
    this.currentSlide = e?.detail[0]?.activeIndex;
  }
  moveSlide(index) {
    this.swiperRef.swiper.slideTo(index);
    this.currentSlide = index;
  }
  openViewer(index) {
    this.currentImage = this.tutorialList[index]?.imageUrl;
    this.initialSlideIndex = index;
    this.isViewerOpen = true;
  }
  closeViewer() {
    this.currentImage = null;
    this.isViewerOpen = false;
  }
  closeTutorial() {
    if (this.cre?.currentUser?.UserId) {
      this.router.navigate(['/tabs/home']);
    } else {
      this.router.navigate(['/sign-in']);
    }
  }
  onSlideChange() {
    this.appHammerZoomable.forEach(z => z.reset());
  }
  getPageName() {
    return 'TutorialPage';
  }
  static ɵfac = function TutorialPageComponent_Factory(t) {
    return new (t || TutorialPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_10__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_10__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_ionic_storage__WEBPACK_IMPORTED_MODULE_2__.Storage), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_6__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_5__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_11__.TranslateService), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_3__.Credential));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdefineComponent"]({
    type: TutorialPageComponent,
    selectors: [["page-tutorial"]],
    viewQuery: function TutorialPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵviewQuery"](_providers_zoomable_directive__WEBPACK_IMPORTED_MODULE_7__.ZoomableDirective, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵloadQuery"]()) && (ctx.appHammerZoomable = _t);
      }
    },
    decls: 13,
    vars: 8,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "ion-no-line"], ["slot", "end"], ["fill", "clear", 3, "click"], ["slot", "icon-only", "src", "assets/icon/close-modal-ico.svg"], ["class", "tutorial-viewer", 3, "isOpen", "showBackdrop", "backdropDismiss", "didDismiss", 4, "ngIf"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "tutorial-viewer", 3, "didDismiss", "isOpen", "showBackdrop", "backdropDismiss"], [1, "tutorial-viewer__header"], [1, "tutorial-viewer__title"], [3, "click"], [1, "tutorial-viewer__btn-close"], ["fullscreen", "", "scroll-y", "false", 1, "tutorial-viewer__content"], [1, "tutorial-viewer__swiper"], ["class", "tutorial-viewer__slide", 4, "ngFor", "ngForOf"], [1, "tutorial-viewer__slide"], ["class", "tutorial-viewer__image", "appHammerZoomable", "", 3, "src", "alt", 4, "ngIf"], ["appHammerZoomable", "", 1, "tutorial-viewer__image", 3, "src", "alt"], ["class", "first-tour", 4, "ngIf"], [1, "first-tour"], [1, "title-container"], [1, "ion-text-center", 3, "innerHTML"], ["class", "image-container", 4, "ngIf"], [1, "ion-no-margin", "primary", 3, "innerHTML"], [1, "footer"], [1, "btn-text-with-icon"], ["name", "chevron-forward-outline"], [1, "image-container"], ["type", "button", 3, "click"], [3, "src", "alt"], [1, "slides-wrapper"], ["pagination", "true", 3, "swiperslidechange"], ["tabindex", "0", 3, "aria-label", 4, "ngFor", "ngForOf"], ["tabindex", "0", 3, "aria-label"], [1, "slide-content"]],
    template: function TutorialPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar", 3)(5, "ion-buttons", 4)(6, "ion-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function TutorialPageComponent_Template_ion_button_click_6_listener() {
          return ctx.closeTutorial();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](7, "ion-img", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](8, TutorialPageComponent_ion_modal_8_Template, 2, 3, "ion-modal", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](9, "widget-layout", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](10, TutorialPageComponent_ion_content_10_Template, 2, 1, "ion-content", 9)(11, TutorialPageComponent_ion_content_11_Template, 4, 1, "ion-content", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](12, "widget-layout", 10);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx.currentImage);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", !ctx.isStartTour);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx.isStartTour);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_12__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_12__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonModal, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_8__.WidgetLayoutComponent, _providers_zoomable_directive__WEBPACK_IMPORTED_MODULE_7__.ZoomableDirective, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_11__.TranslatePipe],
    styles: ["span[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  text-align: center;\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n\nion-buttons[_ngcontent-%COMP%] {\n  justify-content: right;\n  padding: 15px;\n}\n\nion-button.ion-focused[_ngcontent-%COMP%]::part(native) {\n  box-shadow: 0 0 0 2px rgba(0, 0, 0, 0.72);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --padding-start: 24px;\n  --padding-end: 24px;\n  --padding-bottom: 40px;\n}\nion-content[_ngcontent-%COMP%]   .title-container[_ngcontent-%COMP%] {\n  display: flex;\n  height: 64px;\n  flex-direction: column;\n  justify-content: center;\n  align-self: stretch;\n}\nion-content[_ngcontent-%COMP%]   .title-container[_ngcontent-%COMP%]   h1[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-brand, #c40d3c);\n  font-family: var(--mag-typography-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-display-medium-font-size, 24px);\n  font-weight: var(--mag-typography-display-medium-font-weight, 700);\n  line-height: var(--mag-typography-display-medium-line-height, 32px);\n  margin: 0px;\n}\nion-content[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\n  background: transparent;\n  border: none;\n  padding: 0;\n  margin: 0;\n}\nion-content[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]:focus-visible {\n  box-shadow: 0 0 0 2px rgba(0, 0, 0, 0.72);\n  border-radius: 4px;\n}\nion-content[_ngcontent-%COMP%]   .image-container[_ngcontent-%COMP%] {\n  padding: 24px 0;\n  background: transparent;\n  display: flex;\n  justify-content: center;\n}\nion-content[_ngcontent-%COMP%]   .image-container[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  max-height: 50vh;\n  width: 100%;\n  object-fit: contain;\n}\nion-content[_ngcontent-%COMP%]   .slides-wrapper[_ngcontent-%COMP%] {\n  --swiper-size-bullet: 8px;\n  --swiper-pagination-bullet-width: var(--swiper-size-bullet);\n  --swiper-pagination-bullet-height: var(--swiper-size-bullet);\n  --swiper-pagination-bullet-horizontal-gap: 6px;\n  --swiper-pagination-bullet-inactive-color: var(--mag-coloriconinactive, #d8d8d8);\n  --swiper-pagination-color: var(--mag-coloricon, #121212);\n  --swiper-pagination-bullet-inactive-opacity: 1;\n}\nion-content[_ngcontent-%COMP%]   .slides-wrapper[_ngcontent-%COMP%]   swiper-container[_ngcontent-%COMP%] {\n  height: calc(100dvh - 62px - 30px - var(--ion-safe-area-top, 0) - var(--ion-safe-area-bottom, 0));\n}\nion-content[_ngcontent-%COMP%]   .slides-wrapper[_ngcontent-%COMP%]   swiper-container[_ngcontent-%COMP%]   swiper-slide[_ngcontent-%COMP%]   .slide-content[_ngcontent-%COMP%] {\n  height: 100%;\n}\nion-content[_ngcontent-%COMP%]   .slides-wrapper[_ngcontent-%COMP%]   swiper-container[_ngcontent-%COMP%]   swiper-slide[_ngcontent-%COMP%]   .slide-content[_ngcontent-%COMP%]   .image-container[_ngcontent-%COMP%] {\n  height: 70%;\n}\n\n.first-tour[_ngcontent-%COMP%] {\n  float: left;\n  width: 100%;\n  height: calc(100% - var(--ion-safe-area-top, 0) - var(--ion-safe-area-bottom, 0));\n  margin-bottom: 10px;\n  display: flex;\n  flex-direction: column;\n}\n\n.footer[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  text-align: center;\n  margin-top: 40px;\n}\n.footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  width: 35%;\n  --background: var(--mag-color-surface-button-filled-brand, #c40d3c);\n  --padding-top: var(--mag-spacing-150, 12px);\n  --padding-bottom: var(--mag-spacing-150, 12px);\n  --padding-left: var(--mag-spacing-150, 24px);\n  --padding-right: var(--mag-spacing-150, 24px);\n  --border-radius: var(--mag-border-radius-rounded, 9999px);\n}\n.footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]   .btn-text-with-icon[_ngcontent-%COMP%] {\n  display: inline-flex;\n  align-items: center;\n  gap: 5px;\n  margin-bottom: 2px;\n  color: var(--mag-color-text-button-filled-brand, #fff);\n  font-family: var(--mag-typography-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-button-labels-medium-font-size, 16px);\n  font-weight: var(--mag-typography-button-label-medium-font-weight, 600);\n  line-height: var(--mag-typography-button-labels-medium-line-height, 24px);\n}\n.footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]   .btn-text-with-icon[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  width: 18px;\n  height: 18px;\n  color: var(--mag-color-text-button-filled-brand, #fff);\n  padding-top: 2px;\n}\n\n.tutorial-viewer[_ngcontent-%COMP%] {\n  --width: 100%;\n  --height: 100%;\n}\n.tutorial-viewer__header[_ngcontent-%COMP%] {\n  background: #fff;\n}\n.tutorial-viewer__header[style*=\"display: none\"][_ngcontent-%COMP%] {\n  pointer-events: none !important;\n}\n.tutorial-viewer__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 600);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n.tutorial-viewer__btn-close[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-style: normal;\n  font-weight: var(--mag-typography-button-label-small-regular-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 20px);\n  text-decoration-line: underline;\n  text-decoration-style: solid;\n  -webkit-text-decoration-skip-ink: none;\n          text-decoration-skip-ink: none;\n  text-decoration-thickness: auto;\n  text-underline-offset: 4px;\n}\n.tutorial-viewer__content[_ngcontent-%COMP%] {\n  --background: linear-gradient(\n    0deg,\n    #1a1a1a 0%,\n    rgba(26, 26, 26, 0.7) 34.82%,\n    rgba(26, 26, 26, 0.3) 64.67%,\n    rgba(26, 26, 26, 0) 99.5%\n  );\n  --padding-start: 0;\n  --padding-end: 0;\n  --padding-bottom: 0;\n}\n.tutorial-viewer__swiper[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n}\n.tutorial-viewer__slide[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n.tutorial-viewer__image[_ngcontent-%COMP%] {\n  height: 75vh;\n  object-fit: contain;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy90dXRvcmlhbC9wYWdlcy90dXRvcmlhbC90dXRvcmlhbC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsYUFBQTtFQUNBLHVCQUFBO0VBQ0Esa0JBQUE7RUFDQSw2Q0FBQTtFQUNBLDJFQUFBO0VBQ0EsNERBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0FBQ0Y7O0FBRUE7RUFDRSxzQkFBQTtFQUNBLGFBQUE7QUFDRjs7QUFHQTtFQUNFLHlDQUFBO0FBQUY7O0FBSUE7RUFDRSxxQkFBQTtFQUNBLG1CQUFBO0VBQ0Esc0JBQUE7QUFERjtBQUdFO0VBQ0UsYUFBQTtFQUNBLFlBQUE7RUFDQSxzQkFBQTtFQUNBLHVCQUFBO0VBQ0EsbUJBQUE7QUFESjtBQUdJO0VBQ0UsMkNBQUE7RUFDQSwyRUFBQTtFQUNBLCtEQUFBO0VBQ0Esa0VBQUE7RUFDQSxtRUFBQTtFQUNBLFdBQUE7QUFETjtBQUtFO0VBQ0UsdUJBQUE7RUFDQSxZQUFBO0VBQ0EsVUFBQTtFQUNBLFNBQUE7QUFISjtBQUlJO0VBQ0UseUNBQUE7RUFDQSxrQkFBQTtBQUZOO0FBTUU7RUFDRSxlQUFBO0VBQ0EsdUJBQUE7RUFDQSxhQUFBO0VBQ0EsdUJBQUE7QUFKSjtBQU1JO0VBQ0UsZ0JBQUE7RUFDQSxXQUFBO0VBQ0EsbUJBQUE7QUFKTjtBQVFFO0VBQ0UseUJBQUE7RUFDQSwyREFBQTtFQUNBLDREQUFBO0VBQ0EsOENBQUE7RUFDQSxnRkFBQTtFQUNBLHdEQUFBO0VBQ0EsOENBQUE7QUFOSjtBQVFJO0VBQ0UsaUdBQUE7QUFOTjtBQVNRO0VBQ0UsWUFBQTtBQVBWO0FBU1U7RUFDRSxXQUFBO0FBUFo7O0FBZ0JBO0VBQ0UsV0FBQTtFQUNBLFdBQUE7RUFDQSxpRkFBQTtFQUNBLG1CQUFBO0VBQ0EsYUFBQTtFQUNBLHNCQUFBO0FBYkY7O0FBZ0JBO0VBQ0UsYUFBQTtFQUNBLHVCQUFBO0VBQ0Esa0JBQUE7RUFDQSxnQkFBQTtBQWJGO0FBZUU7RUFDRSxVQUFBO0VBQ0EsbUVBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsNENBQUE7RUFDQSw2Q0FBQTtFQUNBLHlEQUFBO0FBYko7QUFlSTtFQUNFLG9CQUFBO0VBQ0EsbUJBQUE7RUFDQSxRQUFBO0VBQ0Esa0JBQUE7RUFDQSxzREFBQTtFQUNBLDJFQUFBO0VBQ0EscUVBQUE7RUFDQSx1RUFBQTtFQUNBLHlFQUFBO0FBYk47QUFlTTtFQUNFLFdBQUE7RUFDQSxZQUFBO0VBQ0Esc0RBQUE7RUFDQSxnQkFBQTtBQWJSOztBQXNCQTtFQUNFLGFBQUE7RUFDQSxjQUFBO0FBbkJGO0FBcUJFO0VBQ0UsZ0JBQUE7QUFuQko7QUFxQkk7RUFDRSwrQkFBQTtBQW5CTjtBQXVCRTtFQUNFLDZDQUFBO0VBQ0Esa0JBQUE7RUFDQSwyRUFBQTtFQUNBLGdFQUFBO0VBQ0Esa0JBQUE7RUFDQSxtRUFBQTtFQUNBLG9FQUFBO0FBckJKO0FBd0JFO0VBQ0UsNkNBQUE7RUFDQSwyRUFBQTtFQUNBLG9FQUFBO0VBQ0Esa0JBQUE7RUFDQSw4RUFBQTtFQUNBLHdFQUFBO0VBQ0EsK0JBQUE7RUFDQSw0QkFBQTtFQUNBLHNDQUFBO1VBQUEsOEJBQUE7RUFDQSwrQkFBQTtFQUNBLDBCQUFBO0FBdEJKO0FBeUJFO0VBQ0U7Ozs7OztHQUFBO0VBT0Esa0JBQUE7RUFDQSxnQkFBQTtFQUNBLG1CQUFBO0FBdkJKO0FBMEJFO0VBQ0UsV0FBQTtFQUNBLFlBQUE7QUF4Qko7QUEyQkU7RUFDRSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtBQXpCSjtBQTRCRTtFQUNFLFlBQUE7RUFDQSxtQkFBQTtBQTFCSiIsInNvdXJjZXNDb250ZW50IjpbInNwYW4ge1xuICBkaXNwbGF5OiBmbGV4O1xuICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYnKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbn1cblxuaW9uLWJ1dHRvbnMge1xuICBqdXN0aWZ5LWNvbnRlbnQ6IHJpZ2h0O1xuICBwYWRkaW5nOiAxNXB4O1xufVxuXG4vL2FkYSBidXR0b25cbmlvbi1idXR0b24uaW9uLWZvY3VzZWQ6OnBhcnQobmF0aXZlKSB7XG4gIGJveC1zaGFkb3c6IDAgMCAwIDJweCByZ2JhKDAsIDAsIDAsIDAuNzIpO1xufVxuXG4vL3N0eWxlIGZvciBhbGwgY29udGVudCArIGltZ1xuaW9uLWNvbnRlbnQge1xuICAtLXBhZGRpbmctc3RhcnQ6IDI0cHg7XG4gIC0tcGFkZGluZy1lbmQ6IDI0cHg7XG4gIC0tcGFkZGluZy1ib3R0b206IDQwcHg7XG5cbiAgLnRpdGxlLWNvbnRhaW5lciB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBoZWlnaHQ6IDY0cHg7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICBhbGlnbi1zZWxmOiBzdHJldGNoO1xuXG4gICAgaDEge1xuICAgICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJyYW5kLCAjYzQwZDNjKTtcbiAgICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYnKTtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGlzcGxheS1tZWRpdW0tZm9udC1zaXplLCAyNHB4KTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LW1lZGl1bS1mb250LXdlaWdodCwgNzAwKTtcbiAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LW1lZGl1bS1saW5lLWhlaWdodCwgMzJweCk7XG4gICAgICBtYXJnaW46IDBweDtcbiAgICB9XG4gIH1cblxuICBidXR0b24ge1xuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xuICAgIGJvcmRlcjogbm9uZTtcbiAgICBwYWRkaW5nOiAwO1xuICAgIG1hcmdpbjogMDtcbiAgICAmOmZvY3VzLXZpc2libGUge1xuICAgICAgYm94LXNoYWRvdzogMCAwIDAgMnB4IHJnYmEoMCwgMCwgMCwgMC43Mik7XG4gICAgICBib3JkZXItcmFkaXVzOiA0cHg7XG4gICAgfVxuICB9XG5cbiAgLmltYWdlLWNvbnRhaW5lciB7XG4gICAgcGFkZGluZzogMjRweCAwO1xuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG5cbiAgICBpbWcge1xuICAgICAgbWF4LWhlaWdodDogNTB2aDtcbiAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICB9XG4gIH1cblxuICAuc2xpZGVzLXdyYXBwZXIge1xuICAgIC0tc3dpcGVyLXNpemUtYnVsbGV0OiA4cHg7XG4gICAgLS1zd2lwZXItcGFnaW5hdGlvbi1idWxsZXQtd2lkdGg6IHZhcigtLXN3aXBlci1zaXplLWJ1bGxldCk7XG4gICAgLS1zd2lwZXItcGFnaW5hdGlvbi1idWxsZXQtaGVpZ2h0OiB2YXIoLS1zd2lwZXItc2l6ZS1idWxsZXQpO1xuICAgIC0tc3dpcGVyLXBhZ2luYXRpb24tYnVsbGV0LWhvcml6b250YWwtZ2FwOiA2cHg7XG4gICAgLS1zd2lwZXItcGFnaW5hdGlvbi1idWxsZXQtaW5hY3RpdmUtY29sb3I6IHZhcigtLW1hZy1jb2xvcmljb25pbmFjdGl2ZSwgI2Q4ZDhkOCk7XG4gICAgLS1zd2lwZXItcGFnaW5hdGlvbi1jb2xvcjogdmFyKC0tbWFnLWNvbG9yaWNvbiwgIzEyMTIxMik7XG4gICAgLS1zd2lwZXItcGFnaW5hdGlvbi1idWxsZXQtaW5hY3RpdmUtb3BhY2l0eTogMTtcblxuICAgIHN3aXBlci1jb250YWluZXIge1xuICAgICAgaGVpZ2h0OiBjYWxjKDEwMGR2aCAtIDYycHggLSAzMHB4IC0gdmFyKC0taW9uLXNhZmUtYXJlYS10b3AsIDApIC0gdmFyKC0taW9uLXNhZmUtYXJlYS1ib3R0b20sIDApKTtcblxuICAgICAgc3dpcGVyLXNsaWRlIHtcbiAgICAgICAgLnNsaWRlLWNvbnRlbnQge1xuICAgICAgICAgIGhlaWdodDogMTAwJTtcblxuICAgICAgICAgIC5pbWFnZS1jb250YWluZXIge1xuICAgICAgICAgICAgaGVpZ2h0OiA3MCU7XG4gICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuICB9XG59XG5cbi8vc3R5bGUgZm9yIGZyaXN0IGltZyB0dXRvcmlhbFxuLmZpcnN0LXRvdXIge1xuICBmbG9hdDogbGVmdDtcbiAgd2lkdGg6IDEwMCU7XG4gIGhlaWdodDogY2FsYygxMDAlIC0gdmFyKC0taW9uLXNhZmUtYXJlYS10b3AsIDApIC0gdmFyKC0taW9uLXNhZmUtYXJlYS1ib3R0b20sIDApKTtcbiAgbWFyZ2luLWJvdHRvbTogMTBweDtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbn1cblxuLmZvb3RlciB7XG4gIGRpc3BsYXk6IGZsZXg7XG4gIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gIG1hcmdpbi10b3A6IDQwcHg7XG5cbiAgaW9uLWJ1dHRvbiB7XG4gICAgd2lkdGg6IDM1JTtcbiAgICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLWJ1dHRvbi1maWxsZWQtYnJhbmQsICNjNDBkM2MpO1xuICAgIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTE1MCwgMTJweCk7XG4gICAgLS1wYWRkaW5nLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMTUwLCAxMnB4KTtcbiAgICAtLXBhZGRpbmctbGVmdDogdmFyKC0tbWFnLXNwYWNpbmctMTUwLCAyNHB4KTtcbiAgICAtLXBhZGRpbmctcmlnaHQ6IHZhcigtLW1hZy1zcGFjaW5nLTE1MCwgMjRweCk7XG4gICAgLS1ib3JkZXItcmFkaXVzOiB2YXIoLS1tYWctYm9yZGVyLXJhZGl1cy1yb3VuZGVkLCA5OTk5cHgpO1xuXG4gICAgLmJ0bi10ZXh0LXdpdGgtaWNvbiB7XG4gICAgICBkaXNwbGF5OiBpbmxpbmUtZmxleDtcbiAgICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgICBnYXA6IDVweDtcbiAgICAgIG1hcmdpbi1ib3R0b206IDJweDtcbiAgICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1idXR0b24tZmlsbGVkLWJyYW5kLCAjZmZmKTtcbiAgICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYnKTtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYnV0dG9uLWxhYmVscy1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWwtbWVkaXVtLWZvbnQtd2VpZ2h0LCA2MDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcblxuICAgICAgaW9uLWljb24ge1xuICAgICAgICB3aWR0aDogMThweDtcbiAgICAgICAgaGVpZ2h0OiAxOHB4O1xuICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtYnV0dG9uLWZpbGxlZC1icmFuZCwgI2ZmZik7XG4gICAgICAgIHBhZGRpbmctdG9wOiAycHg7XG4gICAgICB9XG4gICAgfVxuICB9XG59XG5cbi8vIGVuZCBzdHlsZSBmb3IgZnJpc3QgaW1nIHR1dG9yaWFsXG5cbi8vc3R5bGUgZm9yIG1vZGFsIHpvb21pbmdcbi50dXRvcmlhbC12aWV3ZXIge1xuICAtLXdpZHRoOiAxMDAlO1xuICAtLWhlaWdodDogMTAwJTtcblxuICAmX19oZWFkZXIge1xuICAgIGJhY2tncm91bmQ6ICNmZmY7XG5cbiAgICAmW3N0eWxlKj0nZGlzcGxheTogbm9uZSddIHtcbiAgICAgIHBvaW50ZXItZXZlbnRzOiBub25lICFpbXBvcnRhbnQ7XG4gICAgfVxuICB9XG5cbiAgJl9fdGl0bGUge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kLCBBcmlhbCwgc2Fucy1zZXJpZicpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDYwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG4gIH1cblxuICAmX19idG4tY2xvc2Uge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksICdMZXhlbmQsIEFyaWFsLCBzYW5zLXNlcmlmJyk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWZvbnQtc2l6ZSwgMTRweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWwtc21hbGwtcmVndWxhci1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYnV0dG9uLWxhYmVscy1zbWFsbC1saW5lLWhlaWdodCwgMjBweCk7XG4gICAgdGV4dC1kZWNvcmF0aW9uLWxpbmU6IHVuZGVybGluZTtcbiAgICB0ZXh0LWRlY29yYXRpb24tc3R5bGU6IHNvbGlkO1xuICAgIHRleHQtZGVjb3JhdGlvbi1za2lwLWluazogbm9uZTtcbiAgICB0ZXh0LWRlY29yYXRpb24tdGhpY2tuZXNzOiBhdXRvO1xuICAgIHRleHQtdW5kZXJsaW5lLW9mZnNldDogNHB4O1xuICB9XG5cbiAgJl9fY29udGVudCB7XG4gICAgLS1iYWNrZ3JvdW5kOiBsaW5lYXItZ3JhZGllbnQoXG4gICAgICAwZGVnLFxuICAgICAgIzFhMWExYSAwJSxcbiAgICAgIHJnYmEoMjYsIDI2LCAyNiwgMC43KSAzNC44MiUsXG4gICAgICByZ2JhKDI2LCAyNiwgMjYsIDAuMykgNjQuNjclLFxuICAgICAgcmdiYSgyNiwgMjYsIDI2LCAwKSA5OS41JVxuICAgICk7XG4gICAgLS1wYWRkaW5nLXN0YXJ0OiAwO1xuICAgIC0tcGFkZGluZy1lbmQ6IDA7XG4gICAgLS1wYWRkaW5nLWJvdHRvbTogMDtcbiAgfVxuXG4gICZfX3N3aXBlciB7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgaGVpZ2h0OiAxMDAlO1xuICB9XG5cbiAgJl9fc2xpZGUge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgfVxuXG4gICZfX2ltYWdlIHtcbiAgICBoZWlnaHQ6IDc1dmg7XG4gICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgfVxufVxuXG4vLyBlbmQgc3R5bGUgZm9yIG1vZGFsIHpvb21pbmdcbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 97728:
/*!******************************************************************!*\
  !*** ./src/app/modules/tutorial/providers/zoomable.directive.ts ***!
  \******************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ZoomableDirective: () => (/* binding */ ZoomableDirective)
/* harmony export */ });
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! hammerjs */ 85684);
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(hammerjs__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);



class ZoomableDirective {
  el;
  renderer;
  hammer;
  scale = 1;
  lastScale = 1;
  position = {
    x: 0,
    y: 0
  };
  lastPos = {
    x: 0,
    y: 0
  };
  isZoomed = false;
  headerTimeout;
  isHeaderVisible = true;
  isPanning = false;
  constructor(el, renderer) {
    this.el = el;
    this.renderer = renderer;
  }
  ngAfterViewInit() {
    const element = this.el.nativeElement;
    this.hammer = new hammerjs__WEBPACK_IMPORTED_MODULE_0__.Manager(element);
    const singleTap = new hammerjs__WEBPACK_IMPORTED_MODULE_0__.Tap({
      event: 'singletap',
      taps: 1
    });
    const doubleTap = new hammerjs__WEBPACK_IMPORTED_MODULE_0__.Tap({
      event: 'doubletap',
      taps: 2
    });
    singleTap.requireFailure(doubleTap);
    this.hammer.add([doubleTap, singleTap]);
    this.hammer.add(new hammerjs__WEBPACK_IMPORTED_MODULE_0__.Pan({
      threshold: 0,
      pointers: 0
    }));
    this.hammer.add(new hammerjs__WEBPACK_IMPORTED_MODULE_0__.Pinch({
      threshold: 0
    })).recognizeWith(this.hammer.get('pan'));
    this.hammer.on('doubletap', ev => this.onDoubleTap(ev));
    this.hammer.on('singletap', () => this.onTap());
    this.hammer.on('pinchmove', ev => this.onPinch(ev));
    this.hammer.on('pinchend', () => this.endPinch());
    this.hammer.on('panmove', ev => this.onPan(ev));
    this.hammer.on('panend', () => this.endPan());
    this.applyTransform();
  }
  toggleSwiper(enable) {
    const el = this.el.nativeElement;
    const swiperContainer = el.closest('swiper-container');
    if (swiperContainer && swiperContainer.swiper) {
      swiperContainer.swiper.allowTouchMove = enable;
    }
  }
  onPinch(ev) {
    this.scale = this.lastScale * ev.scale;
    this.isZoomed = this.scale > 1;
    if (this.scale > 1) {
      this.isZoomed = true;
      this.toggleSwiper(false);
    }
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (ionHeader) {
      this.renderer.setStyle(ionHeader, 'display', 'none');
    }
    this.applyTransform();
  }
  endPinch() {
    this.lastScale = this.scale;
    if (this.scale < 1) {
      this.reset();
    }
  }
  onPan(ev) {
    if (!this.isZoomed) return;
    this.isPanning = true;
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (ionHeader) {
      this.renderer.setStyle(ionHeader, 'display', 'none');
    }
    this.position.x = this.lastPos.x + ev.deltaX;
    this.position.y = this.lastPos.y + ev.deltaY;
    this.applyTransform();
  }
  endPan() {
    this.isPanning = false;
    const limitX = window.innerWidth * 0.8;
    const limitY = window.innerHeight * 0.8;
    if (Math.abs(this.position.x) > limitX || Math.abs(this.position.y) > limitY) {
      this.reset();
      return;
    }
    this.lastPos = {
      ...this.position
    };
  }
  onDoubleTap(ev) {
    if (this.isZoomed) {
      this.reset();
    } else {
      this.toggleSwiper(false);
      const scaleFactor = 2;
      this.scale = scaleFactor;
      this.isZoomed = true;
      this.position.x = -ev.center.x + window.innerWidth / 2;
      this.position.y = -ev.center.y + window.innerHeight / 2;
      this.applyTransform();
      const modalEl = this.el.nativeElement.closest('ion-modal');
      const ionHeader = modalEl?.querySelector('ion-header');
      if (!ionHeader) return;
      const isHidden = getComputedStyle(ionHeader).display === 'none';
      if (isHidden) {
        this.showHeader();
      } else {
        this.hideHeader();
      }
    }
  }
  reset() {
    if (this.scale > 3) {
      return;
    }
    this.scale = 1;
    this.lastScale = 1;
    this.position = {
      x: 0,
      y: 0
    };
    this.lastPos = {
      x: 0,
      y: 0
    };
    this.isZoomed = false;
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (ionHeader) {
      this.renderer.setStyle(ionHeader, 'display', 'block');
      this.renderer.setStyle(ionHeader, 'opacity', '1');
    }
    this.toggleSwiper(true);
    this.applyTransform();
  }
  applyTransform() {
    const el = this.el.nativeElement;
    const isZooming = this.scale > 1;
    // Apply zoom transform
    const transform = `scale(${this.scale}) translate(${this.position.x / this.scale}px, ${this.position.y / this.scale}px)`;
    this.renderer.setStyle(el, 'transform', transform);
    this.renderer.setStyle(el, 'transform-origin', 'center center');
    this.renderer.setStyle(el, 'transition', 'transform 0.05s ease-out');
    this.renderer.setStyle(el, 'touch-action', 'none');
    // Zoomed styling
    if (isZooming) {
      this.renderer.setStyle(el, 'position', 'fixed');
      this.renderer.setStyle(el, 'top', '0');
      this.renderer.setStyle(el, 'left', '0');
      this.renderer.setStyle(el, 'width', '100vw');
      this.renderer.setStyle(el, 'height', '100vh');
      this.renderer.setStyle(el, 'z-index', '9999');
      this.renderer.setStyle(el, 'object-fit', 'contain');
      el.addEventListener('click', this.onZoomTap);
    } else {
      this.renderer.removeStyle(el, 'position');
      this.renderer.removeStyle(el, 'top');
      this.renderer.removeStyle(el, 'left');
      this.renderer.removeStyle(el, 'width');
      this.renderer.removeStyle(el, 'height');
      this.renderer.removeStyle(el, 'z-index');
      this.renderer.removeStyle(el, 'object-fit');
      this.renderer.removeStyle(el, 'background');
      el.removeEventListener('click', this.onZoomTap);
      clearTimeout(this.headerTimeout);
    }
    const currentSlide = el.closest('swiper-slide');
    const swiperContainer = currentSlide?.closest('swiper-container');
    if (swiperContainer) {
      const slides = swiperContainer.querySelectorAll('swiper-slide');
      slides.forEach(slide => {
        if (slide !== currentSlide) {
          this.renderer.setStyle(slide, 'visibility', isZooming ? 'hidden' : '');
        }
      });
    }
  }
  onZoomTap = () => {
    if (this.scale <= 1) return;
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (!ionHeader) return;
    this.renderer.setStyle(ionHeader, 'display', 'block');
    this.renderer.setStyle(ionHeader, 'opacity', '1');
    this.renderer.setStyle(ionHeader, 'display', 'none');
    clearTimeout(this.headerTimeout);
  };
  hideHeader() {
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (ionHeader) {
      this.renderer.setStyle(ionHeader, 'display', 'none');
      this.isHeaderVisible = false;
    }
  }
  showHeader() {
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (ionHeader) {
      this.renderer.setStyle(ionHeader, 'display', 'block');
      this.renderer.setStyle(ionHeader, 'opacity', '1');
      this.isHeaderVisible = true;
    }
  }
  onTap() {
    if (this.scale <= 1) return;
    const modalEl = this.el.nativeElement.closest('ion-modal');
    const ionHeader = modalEl?.querySelector('ion-header');
    if (!ionHeader) return;
    const isHidden = getComputedStyle(ionHeader).display === 'none';
    if (isHidden) {
      this.showHeader();
      this.headerTimeout = setTimeout(() => {
        this.hideHeader();
      }, 2000);
    } else {
      this.hideHeader();
    }
  }
  ngOnDestroy() {
    if (this.hammer) {
      this.hammer.destroy();
    }
  }
  static ɵfac = function ZoomableDirective_Factory(t) {
    return new (t || ZoomableDirective)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_1__.ElementRef), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_1__.Renderer2));
  };
  static ɵdir = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineDirective"]({
    type: ZoomableDirective,
    selectors: [["", "appHammerZoomable", ""]]
  });
}

/***/ }),

/***/ 76707:
/*!*****************************************************!*\
  !*** ./src/app/modules/tutorial/tutorial.module.ts ***!
  \*****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   TutorialModule: () => (/* binding */ TutorialModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _pages_tutorial_tutorial__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/tutorial/tutorial */ 88649);
/* harmony import */ var _pages_set_store_set_store__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/set-store/set-store */ 64627);
/* harmony import */ var _providers_zoomable_directive__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./providers/zoomable.directive */ 97728);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);











const routes = [{
  path: '',
  component: _pages_tutorial_tutorial__WEBPACK_IMPORTED_MODULE_1__.TutorialPageComponent
}, {
  path: 'set-store',
  component: _pages_set_store_set_store__WEBPACK_IMPORTED_MODULE_2__.SetStorePageComponent
}];
class TutorialModule {
  static ɵfac = function TutorialModule_Factory(t) {
    return new (t || TutorialModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: TutorialModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule.forChild(routes), _angular_common__WEBPACK_IMPORTED_MODULE_6__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_7__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](TutorialModule, {
    declarations: [_pages_tutorial_tutorial__WEBPACK_IMPORTED_MODULE_1__.TutorialPageComponent, _pages_set_store_set_store__WEBPACK_IMPORTED_MODULE_2__.SetStorePageComponent, _providers_zoomable_directive__WEBPACK_IMPORTED_MODULE_3__.ZoomableDirective],
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule, _angular_common__WEBPACK_IMPORTED_MODULE_6__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_7__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule]
  });
})();

/***/ })

}]);
//# sourceMappingURL=src_app_modules_tutorial_tutorial_module_ts.js.map