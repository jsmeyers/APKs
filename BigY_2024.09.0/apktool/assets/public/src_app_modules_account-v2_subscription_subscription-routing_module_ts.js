"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_account-v2_subscription_subscription-routing_module_ts"],{

/***/ 57309:
/*!********************************************************************************!*\
  !*** ./src/app/modules/account-v2/subscription/subscription-routing.module.ts ***!
  \********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   SubscriptionModule: () => (/* binding */ SubscriptionModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _page_subscription_subscription__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./page/subscription/subscription */ 42570);
/* harmony import */ var _page_subscription_confirm_subscription_confirm__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./page/subscription-confirm/subscription-confirm */ 2676);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);





const routes = [{
  path: '',
  component: _page_subscription_subscription__WEBPACK_IMPORTED_MODULE_0__.SubscriptionComponent
}, {
  path: 'subscribe-confirm',
  component: _page_subscription_confirm_subscription_confirm__WEBPACK_IMPORTED_MODULE_1__.SubscriptionConfirmationComponent
}];
class SubscriptionModule {
  static ɵfac = function SubscriptionModule_Factory(t) {
    return new (t || SubscriptionModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
    type: SubscriptionModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule.forChild(routes)]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](SubscriptionModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule]
  });
})();

/***/ })

}]);
//# sourceMappingURL=src_app_modules_account-v2_subscription_subscription-routing_module_ts.js.map