"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_membership_membership-routing_module_ts"],{

/***/ 49238:
/*!*****************************************************************!*\
  !*** ./src/app/modules/membership/membership-routing.module.ts ***!
  \*****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MembershipPageRoutingModule: () => (/* binding */ MembershipPageRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _pages_membership_membership_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/membership/membership.component */ 65782);
/* harmony import */ var _membership_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./membership.module */ 58847);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);





const routes = [{
  path: '',
  component: _pages_membership_membership_component__WEBPACK_IMPORTED_MODULE_0__.MembershipPageComponent
}];
class MembershipPageRoutingModule {
  static ɵfac = function MembershipPageRoutingModule_Factory(t) {
    return new (t || MembershipPageRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
    type: MembershipPageRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule.forChild(routes), _membership_module__WEBPACK_IMPORTED_MODULE_1__.MembershipModule, _angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](MembershipPageRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule, _membership_module__WEBPACK_IMPORTED_MODULE_1__.MembershipModule],
    exports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule]
  });
})();

/***/ })

}]);
//# sourceMappingURL=src_app_modules_membership_membership-routing_module_ts.js.map