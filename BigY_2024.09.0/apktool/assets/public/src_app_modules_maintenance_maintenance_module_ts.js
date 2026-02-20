"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_maintenance_maintenance_module_ts"],{

/***/ 71517:
/*!***********************************************************!*\
  !*** ./src/app/modules/maintenance/maintenance.module.ts ***!
  \***********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MaintenanceModule: () => (/* binding */ MaintenanceModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _maintenance__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./maintenance */ 27435);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);






const routes = [{
  path: '',
  component: _maintenance__WEBPACK_IMPORTED_MODULE_0__.MaintenancePageComponent
}];
class MaintenanceModule {
  static ɵfac = function MaintenanceModule_Factory(t) {
    return new (t || MaintenanceModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineNgModule"]({
    type: MaintenanceModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__.RouterModule.forChild(routes), _angular_common__WEBPACK_IMPORTED_MODULE_3__.CommonModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__.TranslateModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](MaintenanceModule, {
    declarations: [_maintenance__WEBPACK_IMPORTED_MODULE_0__.MaintenancePageComponent],
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__.RouterModule, _angular_common__WEBPACK_IMPORTED_MODULE_3__.CommonModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__.TranslateModule]
  });
})();

/***/ }),

/***/ 27435:
/*!****************************************************!*\
  !*** ./src/app/modules/maintenance/maintenance.ts ***!
  \****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MaintenancePageComponent: () => (/* binding */ MaintenancePageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../utils/providers/tenant-settings.service */ 84852);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);







function MaintenancePageComponent_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](1, "div", 3)(2, "p", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3, "Our site is under maintenance");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "p", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](5, " We are working on making better experiences for you. We should be back shortly. Thank you for your patience. ");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](6, "ion-img", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
}
function MaintenancePageComponent_ng_template_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "ion-img", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](2, "p", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3, "Please check back soon!");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "p", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](5, "We\u2019re making a few updates to improve your experience.");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
  }
}
class MaintenancePageComponent {
  tenantSettingsStore;
  router;
  isShowUIBigY;
  _tenantSettings;
  constructor(tenantSettingsStore, router) {
    this.tenantSettingsStore = tenantSettingsStore;
    this.router = router;
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        _this._tenantSettings = yield _this.tenantSettingsStore.getTenantSettings();
        if (_this._tenantSettings?.maintenanceMode === false) {
          _this.router.navigateByUrl('/');
          return;
        }
      } catch (error) {
        console.warn(error);
      }
      _this.isShowUIBigY = window.TenantId === 10008;
    })();
  }
  static ɵfac = function MaintenancePageComponent_Factory(t) {
    return new (t || MaintenancePageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_1__.TenantSettingsStore), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: MaintenancePageComponent,
    selectors: [["page-maintenance"]],
    decls: 4,
    vars: 2,
    consts: [["bigyTpl", ""], [1, "maintenance"], [4, "ngIf", "ngIfElse"], [1, "maintenance__content"], [1, "maintenance__title"], [1, "maintenance__desc"], ["src", "assets/imgs/maintenance.png", "alt", "App maintenance illustration", 1, "maintenance__image"], [1, "maintenance__content--special"], ["src", "assets/imgs/maintenanceBigY.png", "alt", "Big Y app maintenance illustration", 1, "maintenance__image"], [1, "maintenance__title--special"], [1, "maintenance__desc--special"]],
    template: function MaintenancePageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "ion-content", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, MaintenancePageComponent_ng_container_1_Template, 7, 0, "ng-container", 2)(2, MaintenancePageComponent_ng_template_2_Template, 6, 0, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        const bigyTpl_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵreference"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !ctx.isShowUIBigY)("ngIfElse", bigyTpl_r1);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf],
    styles: [".maintenance__content[_ngcontent-%COMP%] {\n  display: flex;\n  padding: 32px 16px;\n  flex-direction: column;\n  justify-content: center;\n  gap: 32px;\n  align-self: stretch;\n  margin-top: 20px;\n}\n.maintenance__title[_ngcontent-%COMP%] {\n  color: #161616;\n  font-family: Lato;\n  font-size: 32px;\n  font-style: normal;\n  font-weight: 900;\n  line-height: normal;\n  margin: 0;\n}\n.maintenance__desc[_ngcontent-%COMP%] {\n  color: #4b4b4b;\n  font-family: Lato;\n  font-size: 24px;\n  font-style: normal;\n  font-weight: 400;\n  line-height: 40px;\n  margin: 0;\n}\n.maintenance__image[_ngcontent-%COMP%] {\n  height: auto;\n  margin: 0 auto;\n}\n.maintenance__content--special[_ngcontent-%COMP%] {\n  display: flex;\n  padding: 32px 16px;\n  flex-direction: column;\n  justify-content: center;\n  gap: 20px;\n  align-self: stretch;\n  margin-top: 20px;\n}\n.maintenance__title--special[_ngcontent-%COMP%] {\n  color: #161616;\n  font-size: var(--mag-typography-display-large-font-size, 32px);\n  font-weight: var(--mag-typography-display-large-font-weight, 600);\n  line-height: var(--mag-typography-display-large-line-height, 40px);\n  margin: 0;\n}\n.maintenance__desc--special[_ngcontent-%COMP%] {\n  color: #4b4b4b;\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  margin: 0;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tYWludGVuYW5jZS9tYWludGVuYW5jZS5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNFO0VBQ0UsYUFBQTtFQUNBLGtCQUFBO0VBQ0Esc0JBQUE7RUFDQSx1QkFBQTtFQUNBLFNBQUE7RUFDQSxtQkFBQTtFQUNBLGdCQUFBO0FBQUo7QUFHRTtFQUNFLGNBQUE7RUFDQSxpQkFBQTtFQUNBLGVBQUE7RUFDQSxrQkFBQTtFQUNBLGdCQUFBO0VBQ0EsbUJBQUE7RUFDQSxTQUFBO0FBREo7QUFJRTtFQUNFLGNBQUE7RUFDQSxpQkFBQTtFQUNBLGVBQUE7RUFDQSxrQkFBQTtFQUNBLGdCQUFBO0VBQ0EsaUJBQUE7RUFDQSxTQUFBO0FBRko7QUFLRTtFQUNFLFlBQUE7RUFDQSxjQUFBO0FBSEo7QUFNRTtFQUNFLGFBQUE7RUFDQSxrQkFBQTtFQUNBLHNCQUFBO0VBQ0EsdUJBQUE7RUFDQSxTQUFBO0VBQ0EsbUJBQUE7RUFDQSxnQkFBQTtBQUpKO0FBT0U7RUFDRSxjQUFBO0VBQ0EsOERBQUE7RUFDQSxpRUFBQTtFQUNBLGtFQUFBO0VBQ0EsU0FBQTtBQUxKO0FBUUU7RUFDRSxjQUFBO0VBQ0EsK0RBQUE7RUFDQSw0REFBQTtFQUNBLGtCQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtFQUNBLFNBQUE7QUFOSiIsInNvdXJjZXNDb250ZW50IjpbIi5tYWludGVuYW5jZSB7XG4gICZfX2NvbnRlbnQge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgcGFkZGluZzogMzJweCAxNnB4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgZ2FwOiAzMnB4O1xuICAgIGFsaWduLXNlbGY6IHN0cmV0Y2g7XG4gICAgbWFyZ2luLXRvcDogMjBweDtcbiAgfVxuXG4gICZfX3RpdGxlIHtcbiAgICBjb2xvcjogIzE2MTYxNjtcbiAgICBmb250LWZhbWlseTogTGF0bztcbiAgICBmb250LXNpemU6IDMycHg7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiA5MDA7XG4gICAgbGluZS1oZWlnaHQ6IG5vcm1hbDtcbiAgICBtYXJnaW46IDA7XG4gIH1cblxuICAmX19kZXNjIHtcbiAgICBjb2xvcjogIzRiNGI0YjtcbiAgICBmb250LWZhbWlseTogTGF0bztcbiAgICBmb250LXNpemU6IDI0cHg7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiA0MDA7XG4gICAgbGluZS1oZWlnaHQ6IDQwcHg7XG4gICAgbWFyZ2luOiAwO1xuICB9XG5cbiAgJl9faW1hZ2Uge1xuICAgIGhlaWdodDogYXV0bztcbiAgICBtYXJnaW46IDAgYXV0bztcbiAgfVxuXG4gICZfX2NvbnRlbnQtLXNwZWNpYWwge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgcGFkZGluZzogMzJweCAxNnB4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgZ2FwOiAyMHB4O1xuICAgIGFsaWduLXNlbGY6IHN0cmV0Y2g7XG4gICAgbWFyZ2luLXRvcDogMjBweDtcbiAgfVxuXG4gICZfX3RpdGxlLS1zcGVjaWFsIHtcbiAgICBjb2xvcjogIzE2MTYxNjtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRpc3BsYXktbGFyZ2UtZm9udC1zaXplLCAzMnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGlzcGxheS1sYXJnZS1mb250LXdlaWdodCwgNjAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGlzcGxheS1sYXJnZS1saW5lLWhlaWdodCwgNDBweCk7XG4gICAgbWFyZ2luOiAwO1xuICB9XG5cbiAgJl9fZGVzYy0tc3BlY2lhbCB7XG4gICAgY29sb3I6ICM0YjRiNGI7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCBMZXhlbmQpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICBtYXJnaW46IDA7XG4gIH1cbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_maintenance_maintenance_module_ts.js.map