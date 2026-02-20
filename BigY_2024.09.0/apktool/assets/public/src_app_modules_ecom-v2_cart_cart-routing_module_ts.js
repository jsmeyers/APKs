"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_cart_cart-routing_module_ts"],{

/***/ 46602:
/*!*************************************************************!*\
  !*** ./src/app/modules/ecom-v2/cart/cart-routing.module.ts ***!
  \*************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CartRoutingModule: () => (/* binding */ CartRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _pages_shopping_cart_shopping_cart_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/shopping-cart/shopping-cart.component */ 30714);
/* harmony import */ var _cart_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./cart.module */ 94739);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);





const routes = [{
  path: '',
  component: _pages_shopping_cart_shopping_cart_component__WEBPACK_IMPORTED_MODULE_0__.ShoppingCartPageComponent,
  data: {
    hideTab: true,
    hiddenCartIcon: true
  }
}];
class CartRoutingModule {
  static ɵfac = function CartRoutingModule_Factory(t) {
    return new (t || CartRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
    type: CartRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule.forChild(routes), _cart_module__WEBPACK_IMPORTED_MODULE_1__.CartModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](CartRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule, _cart_module__WEBPACK_IMPORTED_MODULE_1__.CartModule]
  });
})();

/***/ }),

/***/ 94739:
/*!*****************************************************!*\
  !*** ./src/app/modules/ecom-v2/cart/cart.module.ts ***!
  \*****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CartModule: () => (/* binding */ CartModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/utils.module */ 50777);
/* harmony import */ var _pages_shopping_cart_shopping_cart_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/shopping-cart/shopping-cart.component */ 30714);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);










class CartModule {
  static ɵfac = function CartModule_Factory(t) {
    return new (t || CartModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
    type: CartModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_5__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_7__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_8__.RouterModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_2__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](CartModule, {
    declarations: [_pages_shopping_cart_shopping_cart_component__WEBPACK_IMPORTED_MODULE_1__.ShoppingCartPageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_5__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_7__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_8__.RouterModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_2__.HeaderComponentModule],
    exports: [_pages_shopping_cart_shopping_cart_component__WEBPACK_IMPORTED_MODULE_1__.ShoppingCartPageComponent]
  });
})();

/***/ }),

/***/ 30714:
/*!*************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/cart/pages/shopping-cart/shopping-cart.component.ts ***!
  \*************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ShoppingCartPageComponent: () => (/* binding */ ShoppingCartPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/enum/enum */ 24457);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);











class ShoppingCartPageComponent {
  router;
  navCtrl;
  content;
  innerHtml;
  checkoutReturnFlagKey = 'fromCheckoutAfterSignIn';
  constructor(router, navCtrl) {
    this.router = router;
    this.navCtrl = navCtrl;
    window.addEventListener('message', evt => {
      if (evt.origin !== window.location.origin) return;
      if (evt && evt.data) {
        const {
          action,
          upc,
          itemId
        } = evt.data;
        if (action && action === 'MagUpdateProductOption') {
          this.router.navigate([`/product/product-detail/${upc}`, {
            itemId: itemId
          }]);
        }
      }
    });
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      // Clear cached for mag-cart-page
      if (_this.innerHtml) {
        _this.innerHtml = '';
      }
      customElements.whenDefined('mag-cart-page').then(() => {
        _this.innerHtml = '<mag-cart-page></mag-cart-page>';
      });
      window.postMessage({
        action: _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_1__.ActionType.MagRefreshShoppingCart
      }, window.location.origin);
      window.addEventListener('scrollToTop', _this.handleScrollToTop);
    })();
  }
  ionViewWillLeave() {
    window.removeEventListener('scrollToTop', this.handleScrollToTop);
  }
  handleScrollToTop = () => {
    this.content?.scrollToTop();
  };
  backToPreviousPage() {
    const isComingFromCheckoutAfterSignIn = window.sessionStorage.getItem(this.checkoutReturnFlagKey);
    if (isComingFromCheckoutAfterSignIn === 'true') {
      this.clearCheckoutReturnFlag();
      this.router.navigate(['/tabs/home']);
      return;
    }
    this.navCtrl.back();
  }
  clearCheckoutReturnFlag() {
    if (typeof window === 'undefined') return;
    try {
      window.sessionStorage.removeItem(this.checkoutReturnFlagKey);
    } catch (error) {
      console.warn('Unable to clear checkout return flag', error);
    }
  }
  static ɵfac = function ShoppingCartPageComponent_Factory(t) {
    return new (t || ShoppingCartPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_7__.NavController));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: ShoppingCartPageComponent,
    selectors: [["shopping-cart-page"]],
    viewQuery: function ShoppingCartPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵviewQuery"](_ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵloadQuery"]()) && (ctx.content = _t.first);
      }
    },
    decls: 13,
    vars: 14,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton", "isHideCartListIcons"], [1, "title-header"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "cart-container", 3, "innerHtml"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function ShoppingCartPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function ShoppingCartPageComponent_Template_ion_back_button_click_7_listener() {
          return ctx.backToPreviousPage();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](8, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](9, "widget-layout", 6)(10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](11, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](12, "widget-layout", 8);
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
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](6, 10, "header.myCart"));
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("innerHtml", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](11, 12, ctx.innerHtml), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_3__.HeaderComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_4__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: var(--mag-color-surface-primary, #fff);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --padding-bottom: 0 !important;\n}\n\nion-back-button[_ngcontent-%COMP%] {\n  --color: var(--mag-color-text-primary, #121212);\n}\n\n.title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.cart-container[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-200, 16px);\n  height: 100%;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL2NhcnQvcGFnZXMvc2hvcHBpbmctY2FydC9zaG9wcGluZy1jYXJ0LmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsNEJBQUE7RUFDQSxvREFBQTtBQUNGOztBQUVBO0VBQ0UsOEJBQUE7QUFDRjs7QUFFQTtFQUNFLCtDQUFBO0FBQ0Y7O0FBRUE7RUFDRSw2Q0FBQTtFQUNBLGtCQUFBO0VBQ0Esc0RBQUE7RUFDQSxnRUFBQTtFQUNBLGtCQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQTtBQUNGOztBQUNBO0VBQ0Usa0VBQUE7RUFDQSxZQUFBO0FBRUYiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tdG9vbGJhciB7XG4gIC0tYm9yZGVyLXdpZHRoOiAwICFpbXBvcnRhbnQ7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG59XG5cbmlvbi1jb250ZW50IHtcbiAgLS1wYWRkaW5nLWJvdHRvbTogMCAhaW1wb3J0YW50O1xufVxuXG5pb24tYmFjay1idXR0b24ge1xuICAtLWNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbn1cblxuLnRpdGxlIHtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgZm9udC1zdHlsZTogbm9ybWFsO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbn1cbi5jYXJ0LWNvbnRhaW5lciB7XG4gIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCkgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgaGVpZ2h0OiAxMDAlO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_cart_cart-routing_module_ts.js.map