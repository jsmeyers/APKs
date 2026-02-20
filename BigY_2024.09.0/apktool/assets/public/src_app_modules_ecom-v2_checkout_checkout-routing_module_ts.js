"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_checkout_checkout-routing_module_ts"],{

/***/ 80666:
/*!*********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/checkout/checkout-routing.module.ts ***!
  \*********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CheckoutRoutingModule: () => (/* binding */ CheckoutRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _pages_checkout_checkout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/checkout/checkout */ 19287);
/* harmony import */ var _checkout_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./checkout.module */ 55683);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);









const routes = [{
  path: '',
  component: _pages_checkout_checkout__WEBPACK_IMPORTED_MODULE_1__.CheckoutPageComponent,
  data: {
    hideTab: true,
    hiddenCartIcon: true
  }
}];
class CheckoutRoutingModule {
  static ɵfac = function CheckoutRoutingModule_Factory(t) {
    return new (t || CheckoutRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
    type: CheckoutRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_4__.RouterModule.forChild(routes), _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonicModule, _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormsModule, _angular_common__WEBPACK_IMPORTED_MODULE_7__.CommonModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _checkout_module__WEBPACK_IMPORTED_MODULE_2__.CheckoutModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](CheckoutRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_4__.RouterModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonicModule, _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormsModule, _angular_common__WEBPACK_IMPORTED_MODULE_7__.CommonModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _checkout_module__WEBPACK_IMPORTED_MODULE_2__.CheckoutModule]
  });
})();

/***/ }),

/***/ 49390:
/*!**********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/checkout/checkout-services.module.ts ***!
  \**********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CheckoutServiceModule: () => (/* binding */ CheckoutServiceModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _providers_checkout_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./providers/checkout.service */ 13443);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);





class CheckoutServiceModule {
  static ɵfac = function CheckoutServiceModule_Factory(t) {
    return new (t || CheckoutServiceModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
    type: CheckoutServiceModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
    providers: [_providers_checkout_service__WEBPACK_IMPORTED_MODULE_1__.CheckoutService],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_3__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](CheckoutServiceModule, {
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_3__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule]
  });
})();

/***/ }),

/***/ 55683:
/*!*************************************************************!*\
  !*** ./src/app/modules/ecom-v2/checkout/checkout.module.ts ***!
  \*************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CheckoutModule: () => (/* binding */ CheckoutModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/utils.module */ 50777);
/* harmony import */ var _checkout_services_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./checkout-services.module */ 49390);
/* harmony import */ var _pages_checkout_checkout__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/checkout/checkout */ 19287);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);











class CheckoutModule {
  static ɵfac = function CheckoutModule_Factory(t) {
    return new (t || CheckoutModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: CheckoutModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_8__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_9__.RouterModule, _checkout_services_module__WEBPACK_IMPORTED_MODULE_1__.CheckoutServiceModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_3__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](CheckoutModule, {
    declarations: [_pages_checkout_checkout__WEBPACK_IMPORTED_MODULE_2__.CheckoutPageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_6__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_8__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_9__.RouterModule, _checkout_services_module__WEBPACK_IMPORTED_MODULE_1__.CheckoutServiceModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_3__.HeaderComponentModule],
    exports: [_pages_checkout_checkout__WEBPACK_IMPORTED_MODULE_2__.CheckoutPageComponent]
  });
})();

/***/ }),

/***/ 19287:
/*!*********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/checkout/pages/checkout/checkout.ts ***!
  \*********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CheckoutPageComponent: () => (/* binding */ CheckoutPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_components_mag_confirm_modal_mag_modal_confirm__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/components/mag-confirm-modal/mag-modal-confirm */ 95672);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);













function CheckoutPageComponent_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](1, 1, ctx_r0.dxpMagCheckoutInformation), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsanitizeHtml"]);
  }
}
class CheckoutPageComponent {
  router;
  route;
  navCtrl;
  modalCtrl;
  translate;
  entryRoute = null;
  enteredFromSignIn = false;
  checkoutReturnFlagKey = 'fromCheckoutAfterSignIn';
  hasGiftCertificateValue = false;
  dxpMagCheckoutInformation = '';
  constructor(router, route, navCtrl, modalCtrl, translate) {
    this.router = router;
    this.route = route;
    this.navCtrl = navCtrl;
    this.modalCtrl = modalCtrl;
    this.translate = translate;
    const currentNavigation = this.router.getCurrentNavigation();
    const navigationState = currentNavigation?.extras.state || history.state;
    const previousNavigation = currentNavigation?.previousNavigation;
    const previousNavigationUrl = previousNavigation?.finalUrl?.toString?.() || previousNavigation?.extractedUrl?.toString?.() || null;
    this.entryRoute = navigationState?.fromRoute || previousNavigationUrl;
    this.enteredFromSignIn = navigationState?.fromSignIn || this.entryRoute?.startsWith('/sign-in') || false;
    if (this.enteredFromSignIn) {
      this.markCheckoutReturnFromSignIn();
    }
    this.preventBackNavigation();
  }
  ionViewWillEnter() {
    const params = this.route.snapshot.paramMap;
    const serviceUrlSlug = params.get('serviceUrlSlug');
    if (!serviceUrlSlug) {
      console.warn('Service url slug not found');
      return;
    }
    customElements.whenDefined('mag-checkout-information').then(() => {
      this.dxpMagCheckoutInformation = `<mag-checkout-information service-slug="${serviceUrlSlug}"></mag-checkout-information>`;
    });
  }
  ionViewDidEnter() {
    // Add event listener to handle message from DXP Component
    window.addEventListener('message', this.handleEvent);
  }
  ionViewDidLeave() {
    if (!this.hasGiftCertificateValue) {
      this.dxpMagCheckoutInformation = '';
    }
    // Clean up event listener
    window.removeEventListener('message', this.handleEvent);
  }
  handleEvent = event => {
    const {
      action,
      data
    } = event?.data || {};
    if (action === 'MagHasGiftCertificateValue') {
      this.hasGiftCertificateValue = data?.hasGiftCertificateValue ?? false;
    }
  };
  preventBackNavigation() {
    this.navCtrl.navigateBack = () => {
      if (this.hasGiftCertificateValue) {
        this.openConfirmModal();
      } else {
        if (this.enteredFromSignIn) {
          this.markCheckoutReturnFromSignIn();
          this.navCtrl.navigateRoot(['/tabs/home']);
          return;
        }
        this.navCtrl.back();
      }
      return Promise.resolve(false);
    };
  }
  handleBackNavigation() {
    if (this.enteredFromSignIn) {
      this.markCheckoutReturnFromSignIn();
      this.navCtrl.navigateRoot(['/tabs/home']);
      return;
    }
    this.navCtrl.back();
  }
  markCheckoutReturnFromSignIn() {
    if (typeof window === 'undefined') return;
    try {
      window.sessionStorage.setItem(this.checkoutReturnFlagKey, 'true');
    } catch (error) {
      console.warn('Unable to persist checkout return flag', error);
    }
  }
  openConfirmModal() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const modal = yield _this.modalCtrl.create({
        component: _rsApp_components_mag_confirm_modal_mag_modal_confirm__WEBPACK_IMPORTED_MODULE_1__.MagModalConfirmComponent,
        componentProps: {
          title: _this.translate.instant('checkout.leavePageTitle'),
          description: _this.translate.instant('checkout.leavePageDescription'),
          confirmTitle: _this.translate.instant('checkout.stay'),
          cancelTitle: _this.translate.instant('checkout.leavePage'),
          verticalButtons: false
        },
        cssClass: 'mag-confirm-modal'
      });
      modal.onDidDismiss().then(result => {
        if (result?.data === false) {
          _this.hasGiftCertificateValue = false;
          const payload = {
            action: 'MagGiftCertificateConfirmLeavePage',
            data: {
              leave: true
            }
          };
          window.postMessage(payload, window.location.origin);
          _this.handleBackNavigation();
        }
      });
      yield modal.present();
    })();
  }
  static ɵfac = function CheckoutPageComponent_Factory(t) {
    return new (t || CheckoutPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_7__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_8__.ModalController), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: CheckoutPageComponent,
    selectors: [["checkout-v2"]],
    decls: 11,
    vars: 12,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton", "isHideCartListIcons"], [1, "title-header"], [1, "no-padding-bottom"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["class", "checkout", 3, "innerHTML", 4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "checkout", 3, "innerHTML"]],
    template: function CheckoutPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](7, "ion-content", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](8, "widget-layout", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](9, CheckoutPageComponent_div_9_Template, 2, 3, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](10, "widget-layout", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true)("isHideCartListIcons", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](6, 10, "header.checkout"));
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.dxpMagCheckoutInformation);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_10__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_3__.HeaderComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_4__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: var(--mag-color-surface-primary, #fff);\n}\n\nion-back-button[_ngcontent-%COMP%] {\n  --color: var(--mag-color-text-primary, #121212);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-bg-contrast, #f7f7f7);\n}\n\nion-header[_ngcontent-%COMP%] {\n  height: 60px;\n  padding: var(--mag-spacing-100, 8px) 0;\n  display: flex;\n  align-items: center;\n}\n\n  .backdrop-no-scroll ion-router-outlet {\n  filter: blur(0px);\n}\n\n  ion-radio::part(label) {\n  overflow: unset;\n  text-overflow: unset;\n}\n\n.checkout__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.checkout[_ngcontent-%COMP%] {\n  padding: 0 16px;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL2NoZWNrb3V0L3BhZ2VzL2NoZWNrb3V0L2NoZWNrb3V0LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw0QkFBQTtFQUNBLG9EQUFBO0FBQ0Y7O0FBQ0E7RUFDRSwrQ0FBQTtBQUVGOztBQUFBO0VBQ0UsbURBQUE7QUFHRjs7QUFEQTtFQUNFLFlBQUE7RUFDQSxzQ0FBQTtFQUNBLGFBQUE7RUFDQSxtQkFBQTtBQUlGOztBQUFJO0VBQ0UsaUJBQUE7QUFHTjs7QUFFQTtFQUNFLGVBQUE7RUFDQSxvQkFBQTtBQUNGOztBQUdFO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUNBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFBSjs7QUFJQTtFQUNFLGVBQUE7QUFERiIsInNvdXJjZXNDb250ZW50IjpbImlvbi10b29sYmFyIHtcbiAgLS1ib3JkZXItd2lkdGg6IDAgIWltcG9ydGFudDtcbiAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbn1cbmlvbi1iYWNrLWJ1dHRvbiB7XG4gIC0tY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xufVxuaW9uLWNvbnRlbnQge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1iZy1jb250cmFzdCwgI2Y3ZjdmNyk7XG59XG5pb24taGVhZGVyIHtcbiAgaGVpZ2h0OiA2MHB4O1xuICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCkgMDtcbiAgZGlzcGxheTogZmxleDtcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbn1cbjo6bmctZGVlcCB7XG4gIC5iYWNrZHJvcC1uby1zY3JvbGwge1xuICAgIGlvbi1yb3V0ZXItb3V0bGV0IHtcbiAgICAgIGZpbHRlcjogYmx1cigwcHgpO1xuICAgIH1cbiAgfVxufVxuXG46Om5nLWRlZXAgaW9uLXJhZGlvOjpwYXJ0KGxhYmVsKSB7XG4gIG92ZXJmbG93OiB1bnNldDtcbiAgdGV4dC1vdmVyZmxvdzogdW5zZXQ7XG59XG5cbi5jaGVja291dCB7XG4gICZfX3RpdGxlIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXNpemUsIDE4cHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG59XG5cbi5jaGVja291dCB7XG4gIHBhZGRpbmc6IDAgMTZweDtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 13443:
/*!************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/checkout/providers/checkout.service.ts ***!
  \************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CheckoutService: () => (/* binding */ CheckoutService)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var ionic_cache__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ionic-cache */ 65503);



class CheckoutService {
  cache;
  constructor(cache) {
    this.cache = cache;
  }
  static ɵfac = function CheckoutService_Factory(t) {
    return new (t || CheckoutService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](ionic_cache__WEBPACK_IMPORTED_MODULE_1__.CacheService));
  };
  static ɵprov = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
    token: CheckoutService,
    factory: CheckoutService.ɵfac
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_checkout_checkout-routing_module_ts.js.map