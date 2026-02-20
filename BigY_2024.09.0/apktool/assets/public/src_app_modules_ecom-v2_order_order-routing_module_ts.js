"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_order_order-routing_module_ts"],{

/***/ 39960:
/*!*****************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/model/enum.ts ***!
  \*****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   EDeliveryMethod: () => (/* binding */ EDeliveryMethod),
/* harmony export */   EOrderStatus: () => (/* binding */ EOrderStatus),
/* harmony export */   EPickingStatus: () => (/* binding */ EPickingStatus),
/* harmony export */   EPickupOrderMode: () => (/* binding */ EPickupOrderMode),
/* harmony export */   EUserPickupStatus: () => (/* binding */ EUserPickupStatus),
/* harmony export */   ErenderMethodMode: () => (/* binding */ ErenderMethodMode)
/* harmony export */ });
var EPickupOrderMode;
(function (EPickupOrderMode) {
  EPickupOrderMode["IN_STORE"] = "In-store";
  EPickupOrderMode["CARRY_OUT"] = "Carry-out";
})(EPickupOrderMode || (EPickupOrderMode = {}));
var EOrderStatus;
(function (EOrderStatus) {
  EOrderStatus["New"] = "new";
  EOrderStatus["Preparing"] = "preparing";
  EOrderStatus["Ready"] = "ready";
  EOrderStatus["OutForPickedUp"] = "out_for_pickup";
  EOrderStatus["PickedUp"] = "picked_up";
  EOrderStatus["OutForDelivery"] = "out_for_delivery";
  EOrderStatus["DeliveryReview"] = "delivery_review";
  EOrderStatus["Delivered"] = "delivered";
  EOrderStatus["Completed"] = "completed";
  EOrderStatus["Cancelled"] = "cancelled";
})(EOrderStatus || (EOrderStatus = {}));
var EPickingStatus;
(function (EPickingStatus) {
  EPickingStatus["CheckIn"] = "Check In";
  EPickingStatus["Start"] = "Start Pickup";
  EPickingStatus["Continue"] = "Continue Pickup";
})(EPickingStatus || (EPickingStatus = {}));
var EUserPickupStatus;
(function (EUserPickupStatus) {
  EUserPickupStatus[EUserPickupStatus["None"] = 0] = "None";
  EUserPickupStatus[EUserPickupStatus["OnMyWay"] = 1] = "OnMyWay";
  EUserPickupStatus[EUserPickupStatus["Arrived"] = 2] = "Arrived";
})(EUserPickupStatus || (EUserPickupStatus = {}));
var ErenderMethodMode;
(function (ErenderMethodMode) {
  ErenderMethodMode[ErenderMethodMode["All"] = 0] = "All";
  ErenderMethodMode[ErenderMethodMode["Continue"] = 1] = "Continue";
  ErenderMethodMode[ErenderMethodMode["CheckIn"] = 2] = "CheckIn";
  ErenderMethodMode[ErenderMethodMode["Curbside"] = 3] = "Curbside";
})(ErenderMethodMode || (ErenderMethodMode = {}));
var EDeliveryMethod;
(function (EDeliveryMethod) {
  EDeliveryMethod[EDeliveryMethod["PICKUP"] = 1] = "PICKUP";
  EDeliveryMethod[EDeliveryMethod["DELIVERY"] = 2] = "DELIVERY";
  EDeliveryMethod[EDeliveryMethod["MAIL"] = 3] = "MAIL";
})(EDeliveryMethod || (EDeliveryMethod = {}));

/***/ }),

/***/ 83192:
/*!***************************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/order-routing.module.ts ***!
  \***************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderRoutingModule: () => (/* binding */ OrderRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _pages_order_confirmation_order_confirmation__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/order-confirmation/order-confirmation */ 79541);
/* harmony import */ var _pages_order_detail_order_detail_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/order-detail/order-detail.component */ 92320);
/* harmony import */ var _pages_order_history_order_history__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/order-history/order-history */ 96659);
/* harmony import */ var _order_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./order.module */ 3049);
/* harmony import */ var _pages_order_rebuild_order_rebuild__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/order-rebuild/order-rebuild */ 48131);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);








const routes = [{
  path: 'order-detail/:orderId',
  component: _pages_order_detail_order_detail_component__WEBPACK_IMPORTED_MODULE_1__.OrderDetailPageComponent,
  data: {
    hideTab: true,
    hiddenCartIcon: true
  }
}, {
  path: 'order-rebuild/:orderId',
  component: _pages_order_rebuild_order_rebuild__WEBPACK_IMPORTED_MODULE_4__.OrderRebuildComponent,
  data: {
    hideTab: true,
    hiddenCartIcon: true
  }
}, {
  path: 'order-history',
  component: _pages_order_history_order_history__WEBPACK_IMPORTED_MODULE_2__.OrderHistoryPageComponent,
  data: {
    hideTab: true,
    hiddenCartIcon: true
  }
}, {
  path: 'order-confirmation/:orderId',
  component: _pages_order_confirmation_order_confirmation__WEBPACK_IMPORTED_MODULE_0__.OrderConfirmationPageComponent,
  data: {
    hideTab: true,
    hiddenCartIcon: true
  }
}];
class OrderRoutingModule {
  static ɵfac = function OrderRoutingModule_Factory(t) {
    return new (t || OrderRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineNgModule"]({
    type: OrderRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule.forChild(routes), _order_module__WEBPACK_IMPORTED_MODULE_3__.OrderModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsetNgModuleScope"](OrderRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _order_module__WEBPACK_IMPORTED_MODULE_3__.OrderModule]
  });
})();

/***/ }),

/***/ 3049:
/*!*******************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/order.module.ts ***!
  \*******************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderModule: () => (/* binding */ OrderModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/utils.module */ 50777);
/* harmony import */ var _pages_order_detail_order_detail_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/order-detail/order-detail.component */ 92320);
/* harmony import */ var _pages_order_history_order_history__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/order-history/order-history */ 96659);
/* harmony import */ var _pages_order_confirmation_order_confirmation__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/order-confirmation/order-confirmation */ 79541);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _providers_order_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./providers/order.service */ 79263);
/* harmony import */ var _pages_order_rebuild_order_rebuild__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./pages/order-rebuild/order-rebuild */ 48131);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);














class OrderModule {
  static ɵfac = function OrderModule_Factory(t) {
    return new (t || OrderModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineNgModule"]({
    type: OrderModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineInjector"]({
    providers: [_providers_order_service__WEBPACK_IMPORTED_MODULE_4__.OrderService],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_8__.CommonModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_12__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_6__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsetNgModuleScope"](OrderModule, {
    declarations: [_pages_order_detail_order_detail_component__WEBPACK_IMPORTED_MODULE_1__.OrderDetailPageComponent, _pages_order_history_order_history__WEBPACK_IMPORTED_MODULE_2__.OrderHistoryPageComponent, _pages_order_confirmation_order_confirmation__WEBPACK_IMPORTED_MODULE_3__.OrderConfirmationPageComponent, _pages_order_rebuild_order_rebuild__WEBPACK_IMPORTED_MODULE_5__.OrderRebuildComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_8__.CommonModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_12__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_6__.HeaderComponentModule],
    exports: [_pages_order_detail_order_detail_component__WEBPACK_IMPORTED_MODULE_1__.OrderDetailPageComponent, _pages_order_history_order_history__WEBPACK_IMPORTED_MODULE_2__.OrderHistoryPageComponent, _pages_order_confirmation_order_confirmation__WEBPACK_IMPORTED_MODULE_3__.OrderConfirmationPageComponent, _pages_order_rebuild_order_rebuild__WEBPACK_IMPORTED_MODULE_5__.OrderRebuildComponent]
  });
})();

/***/ }),

/***/ 79541:
/*!**************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/pages/order-confirmation/order-confirmation.ts ***!
  \**************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderConfirmationPageComponent: () => (/* binding */ OrderConfirmationPageComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);









const _c0 = ["buttonView"];
class OrderConfirmationPageComponent {
  router;
  route;
  buttonView;
  dxpMagOrderConfirmation = '';
  constructor(router, route) {
    this.router = router;
    this.route = route;
  }
  ionViewWillEnter() {
    const params = this.route.snapshot.paramMap;
    const orderId = params.get('orderId');
    if (!orderId) {
      console.warn('orderId not found');
      return;
    }
    customElements.whenDefined('mag-order-confirmation').then(() => {
      this.dxpMagOrderConfirmation = `<mag-order-confirmation order-id=${orderId}></mag-order-confirmation>`;
    });
  }
  ionViewDidLeave() {
    this.dxpMagOrderConfirmation = '';
  }
  ionViewDidEnter() {
    this.handleHeightButtonView();
  }
  goHome() {
    this.router.navigate(['/tabs/home']);
  }
  handleHeightButtonView() {
    const content = document.querySelector('.order-confirmation');
    const element = this.buttonView.nativeElement;
    content.style.setProperty('--mag-order-confirmation-mb', `${element.offsetHeight}px`);
  }
  static ɵfac = function OrderConfirmationPageComponent_Factory(t) {
    return new (t || OrderConfirmationPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.ActivatedRoute));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: OrderConfirmationPageComponent,
    selectors: [["order-confirmation"]],
    viewQuery: function OrderConfirmationPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵviewQuery"](_c0, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵloadQuery"]()) && (ctx.buttonView = _t.first);
      }
    },
    decls: 18,
    vars: 13,
    consts: [["buttonView", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], [1, "order-confirmation"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "order-confirmation__content", 3, "innerHTML"], [1, "order-confirmation__bottom", "bottom"], ["fill", "solid", 1, "bottom__button", 3, "click"], [1, "bottom__text"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function OrderConfirmationPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "widget-layout", 1)(1, "widget-layout", 2)(2, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](3, "app-header", 4)(4, "ion-title", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](7, "ion-back-button", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("click", function OrderConfirmationPageComponent_Template_ion_back_button_click_7_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵresetView"](ctx.goHome());
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](8, "ion-content", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](9, "widget-layout", 8)(10, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](11, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](12, "div", 10, 0)(14, "ion-button", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("click", function OrderConfirmationPageComponent_Template_ion_button_click_14_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵresetView"](ctx.goHome());
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](15, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](16, "Go Back To Shopping");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](17, "widget-layout", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](6, 9, "header.orderConfirm"));
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](11, 11, ctx.dxpMagOrderConfirmation), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_0__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_1__.HeaderComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__.TranslatePipe, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__.SafeHtmlPipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: white;\n}\n\nion-content[_ngcontent-%COMP%] {\n  --padding-bottom: calc(var(--mag-order-confirmation-mb, 100%) + var(--ion-safe-area-bottom, 0));\n}\n\n.order-confirmation__content[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n.order-confirmation__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px); \n\n}\n.order-confirmation__bottom[_ngcontent-%COMP%] {\n  border-top: var(--mag-border-width-100, 1px) solid var(--mag-color-border-divider, #eee);\n  bottom: 0;\n  position: fixed;\n  left: 0;\n  right: 0;\n  background: var(--mag-color-surface-primary, #fff);\n  padding: var(--mag-spacing-200, 16px);\n  padding-bottom: var(--mag-spacing-300, 24px);\n}\n.order-confirmation__bottom[_ngcontent-%COMP%]   .bottom__button[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-button-filled-brand, #008000);\n  --border-radius: var(--mag-border-radius-rounded, 9999px);\n  --background-activated: transparent;\n  --background-hover: transparent;\n  --background-focused: transparent;\n  display: flex;\n  align-items: center;\n}\n.order-confirmation__bottom[_ngcontent-%COMP%]   .bottom__button[_ngcontent-%COMP%]::part(native) {\n  height: 48px;\n}\n.order-confirmation__bottom[_ngcontent-%COMP%]   .bottom__text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-button-filled-brand, #fff);\n  font-size: var(--mag-typography-button-labels-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-button-label-medium-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-medium-line-height, 24px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29yZGVyL3BhZ2VzL29yZGVyLWNvbmZpcm1hdGlvbi9vcmRlci1jb25maXJtYXRpb24uc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLDRCQUFBO0VBQ0EsbUJBQUE7QUFDRjs7QUFFQTtFQUNFLCtGQUFBO0FBQ0Y7O0FBR0U7RUFDRSx1Q0FBQTtBQUFKO0FBR0U7RUFDRSw2Q0FBQTtFQUNBLGtCQUFBO0VBQ0Esc0RBQUE7RUFDQSxnRUFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUEsRUFBQSxhQUFBO0FBREo7QUFJRTtFQUNFLHdGQUFBO0VBQ0EsU0FBQTtFQUNBLGVBQUE7RUFDQSxPQUFBO0VBQ0EsUUFBQTtFQUNBLGtEQUFBO0VBQ0EscUNBQUE7RUFDQSw0Q0FBQTtBQUZKO0FBSU07RUFDRSxtRUFBQTtFQUNBLHlEQUFBO0VBQ0EsbUNBQUE7RUFDQSwrQkFBQTtFQUNBLGlDQUFBO0VBRUEsYUFBQTtFQUNBLG1CQUFBO0FBSFI7QUFLUTtFQUNFLFlBQUE7QUFIVjtBQU1NO0VBQ0Usc0RBQUE7RUFDQSxxRUFBQTtFQUNBLGtCQUFBO0VBQ0EsdUVBQUE7RUFDQSx5RUFBQTtBQUpSIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLXRvb2xiYXIge1xuICAtLWJvcmRlci13aWR0aDogMCAhaW1wb3J0YW50O1xuICAtLWJhY2tncm91bmQ6IHdoaXRlO1xufVxuXG5pb24tY29udGVudCB7XG4gIC0tcGFkZGluZy1ib3R0b206IGNhbGModmFyKC0tbWFnLW9yZGVyLWNvbmZpcm1hdGlvbi1tYiwgMTAwJSkgKyB2YXIoLS1pb24tc2FmZS1hcmVhLWJvdHRvbSwgMCkpO1xufVxuXG4ub3JkZXItY29uZmlybWF0aW9uIHtcbiAgJl9fY29udGVudCB7XG4gICAgcGFkZGluZzogMCB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICB9XG5cbiAgJl9fdGl0bGUge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCBMZXhlbmQpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTsgLyogMTMzLjMzMyUgKi9cbiAgfVxuXG4gICZfX2JvdHRvbSB7XG4gICAgYm9yZGVyLXRvcDogdmFyKC0tbWFnLWJvcmRlci13aWR0aC0xMDAsIDFweCkgc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyLCAjZWVlKTtcbiAgICBib3R0b206IDA7XG4gICAgcG9zaXRpb246IGZpeGVkO1xuICAgIGxlZnQ6IDA7XG4gICAgcmlnaHQ6IDA7XG4gICAgYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gICAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgICBwYWRkaW5nLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcbiAgICAuYm90dG9tIHtcbiAgICAgICZfX2J1dHRvbiB7XG4gICAgICAgIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtYnV0dG9uLWZpbGxlZC1icmFuZCwgIzAwODAwMCk7XG4gICAgICAgIC0tYm9yZGVyLXJhZGl1czogdmFyKC0tbWFnLWJvcmRlci1yYWRpdXMtcm91bmRlZCwgOTk5OXB4KTtcbiAgICAgICAgLS1iYWNrZ3JvdW5kLWFjdGl2YXRlZDogdHJhbnNwYXJlbnQ7XG4gICAgICAgIC0tYmFja2dyb3VuZC1ob3ZlcjogdHJhbnNwYXJlbnQ7XG4gICAgICAgIC0tYmFja2dyb3VuZC1mb2N1c2VkOiB0cmFuc3BhcmVudDtcblxuICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuXG4gICAgICAgICY6OnBhcnQobmF0aXZlKSB7XG4gICAgICAgICAgaGVpZ2h0OiA0OHB4O1xuICAgICAgICB9XG4gICAgICB9XG4gICAgICAmX190ZXh0IHtcbiAgICAgICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJ1dHRvbi1maWxsZWQtYnJhbmQsICNmZmYpO1xuICAgICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbC1tZWRpdW0tZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gICAgICB9XG4gICAgfVxuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 92320:
/*!************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/pages/order-detail/order-detail.component.ts ***!
  \************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderDetailPageComponent: () => (/* binding */ OrderDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _providers_order_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../providers/order.service */ 79263);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var _model_enum__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/enum */ 39960);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _capacitor_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @capacitor/core */ 14070);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var ionic_cache__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ionic-cache */ 65503);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @ngx-translate/core */ 90852);






















function OrderDetailPageComponent_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](1, "mag-order-detail", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("order", ctx_r0.order);
  }
}
function OrderDetailPageComponent_ion_footer_12_div_2_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div", 12)(1, "div")(2, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](3, "Let us know when you\u2019re on the way and we'll have your order ready.");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](4, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function OrderDetailPageComponent_ion_footer_12_div_2_Template_button_click_4_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r2);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r0.postUserLocation());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](6, "button", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function OrderDetailPageComponent_ion_footer_12_div_2_Template_button_click_6_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r2);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r0.walkInPickup());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](7, "Already at the store? Check In");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtextInterpolate1"](" ", ctx_r0.pickingOrderContent, " ");
  }
}
function OrderDetailPageComponent_ion_footer_12_div_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div", 12)(1, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function OrderDetailPageComponent_ion_footer_12_div_3_Template_button_click_1_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r3);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r0.handleClickContinuePickup());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](2, "Continue Pickup");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
}
function OrderDetailPageComponent_ion_footer_12_div_4_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div", 12)(1, "div")(2, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](3, "Already at the store?");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](4, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function OrderDetailPageComponent_ion_footer_12_div_4_Template_button_click_4_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r4);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r0.walkInPickup());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](5, "Check In");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
}
function OrderDetailPageComponent_ion_footer_12_div_5_Template(rf, ctx) {
  if (rf & 1) {
    const _r5 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "div", 12)(1, "div")(2, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](3, "Let us know when you\u2019re on the way and we'll have your order ready.");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](4, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("click", function OrderDetailPageComponent_ion_footer_12_div_5_Template_button_click_4_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵrestoreView"](_r5);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresetView"](ctx_r0.postUserLocation());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](5, "Start Pickup");
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
}
function OrderDetailPageComponent_ion_footer_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](0, "ion-footer")(1, "ion-toolbar", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](2, OrderDetailPageComponent_ion_footer_12_div_2_Template, 8, 1, "div", 11)(3, OrderDetailPageComponent_ion_footer_12_div_3_Template, 3, 0, "div", 11)(4, OrderDetailPageComponent_ion_footer_12_div_4_Template, 6, 0, "div", 11)(5, OrderDetailPageComponent_ion_footer_12_div_5_Template, 6, 0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx_r0.renderMethod === 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx_r0.renderMethod === 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx_r0.renderMethod === 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx_r0.renderMethod === 3);
  }
}
class OrderDetailPageComponent {
  router;
  route;
  dxpComponentService;
  utils;
  cache;
  orderService;
  cre;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_10__.Subject();
  _initCompleted$ = new rxjs__WEBPACK_IMPORTED_MODULE_10__.Subject();
  orderId;
  orderNumber;
  curbsideLink;
  orderStatus;
  pickingOrderContent = _model_enum__WEBPACK_IMPORTED_MODULE_4__.EPickingStatus.Start;
  checkinContent = _model_enum__WEBPACK_IMPORTED_MODULE_4__.EPickingStatus.CheckIn;
  continuePickup = false;
  showPickingOrder;
  inStoreOption;
  curbSideOption = true;
  order;
  currentCurbsideOrderData;
  dxpOrderDetailReady = false;
  curbsideCheckReady = false;
  renderMethod = _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.All;
  pickupData;
  actionType;
  constructor(router, route, dxpComponentService, utils, cache, orderService, cre) {
    this.router = router;
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.utils = utils;
    this.cache = cache;
    this.orderService = orderService;
    this.cre = cre;
  }
  onMyWayHandler() {
    this.renderPickingMode();
  }
  ngOnInit() {
    this.route.params.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_11__.takeUntil)(this._destroy$)).subscribe(params => {
      this.orderId = params?.orderId || '';
    });
    this.route.queryParams.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_11__.takeUntil)(this._destroy$)).subscribe(params => {
      this.actionType = params?.action || '';
    });
    this._initCompleted$.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_11__.takeUntil)(this._destroy$)).subscribe(() => {
      if (_capacitor_core__WEBPACK_IMPORTED_MODULE_6__.Capacitor.isNativePlatform() && this.actionType) {
        this.openCubsideFromDeepLink(this.actionType);
      }
    });
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        yield _this.initOrderData();
        yield _this.initPickingData();
        yield _this.initCurbsideOrderData();
        _this._initCompleted$.next();
      } catch (error) {
        console.error(error);
      }
    })();
  }
  initPickingData() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.pickupData = _this2.order?.Curbside;
      if (!_this2.pickupData) {
        console.error('No picking data found');
        return;
      }
    })();
  }
  checkOwnership(orderUserId) {
    const currentUserId = this.cre?.currentUser?.UserId;
    if (!currentUserId || currentUserId != orderUserId) {
      this.router.navigateByUrl('/tabs/home');
      return false;
    }
    return true;
  }
  openCubsideFromDeepLink(action) {
    switch (action) {
      case 'pickup':
        this.postUserLocation();
        break;
      case 'checkin':
        this.walkInPickup();
        break;
    }
  }
  initOrderData() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this3.order = yield _this3.fetchOrderDataById(_this3.orderId);
      if (!_this3.order) {
        console.error('Order not found');
        return;
      }
      const {
        OrderStatus,
        Curbside,
        OrderNumber,
        UserId
      } = _this3.order;
      if (_capacitor_core__WEBPACK_IMPORTED_MODULE_6__.Capacitor.isNativePlatform() && _this3.actionType) {
        const isOwner = _this3.checkOwnership(UserId);
        if (!isOwner) {
          return;
        }
      }
      _this3.orderStatus = OrderStatus;
      _this3.curbsideLink = Curbside?.CurbsideLink;
      _this3.orderNumber = OrderNumber;
      _this3.dxpOrderDetailReady = true;
    })();
  }
  initCurbsideOrderData() {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this4.showPickingOrder = yield _this4.checkShowPickingOrder();
      if (!_this4.showPickingOrder) return;
      _this4.changeAppCurbsideLink(_this4.curbsideLink);
      yield _this4.renderPickingMode();
      _this4.curbsideCheckReady = true;
    })();
  }
  fetchOrderDataById(id) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const orderData = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_12__.firstValueFrom)(_this5.orderService.getOrderById(id));
        if (!orderData) return null;
        return orderData;
      } catch (error) {
        console.error('Error fetching order data:', error);
        return null;
      }
    })();
  }
  fetchCacheCurbsideOrderData() {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      return yield _this6.cache.getItem('curbside-order-data').catch(() => null);
    })();
  }
  checkShowPickingOrder() {
    var _this7 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (_this7.pickupData?.Geofence && _this7.pickupData?.CurbsidePickup && _this7.order?.DeliveryMethod === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EDeliveryMethod.PICKUP) {
        const currentOrderData = yield _this7.fetchCacheCurbsideOrderData();
        let removedCacheData = false;
        if (currentOrderData) {
          const resolvedCacheOrderData = yield _this7.fetchOrderDataById(currentOrderData?.orderId);
          if (resolvedCacheOrderData?.OrderStatus === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EOrderStatus.Completed) {
            yield _this7.cache.removeItem('curbside-order-data');
            removedCacheData = true;
          }
          if (removedCacheData) {
            return _this7.orderStatus === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EOrderStatus.Ready || _this7.orderStatus === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EOrderStatus.OutForPickedUp;
          }
          return String(currentOrderData?.orderId) === String(_this7.orderId);
        } else {
          return _this7.orderStatus === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EOrderStatus.Ready || _this7.orderStatus === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EOrderStatus.OutForPickedUp;
        }
      } else {
        return false;
      }
    })();
  }
  changeAppCurbsideLink(curbsideLink) {
    if (!curbsideLink) {
      return;
    }
    const url = new URL(curbsideLink);
    url.searchParams.set('inAppMode', 'true');
    this.curbsideLink = url.toString();
  }
  renderPickingMode() {
    var _this8 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const pickupTypes = _this8.pickupData?.CurbsidePickupType || [];
        const hasInStore = pickupTypes.includes(_model_enum__WEBPACK_IMPORTED_MODULE_4__.EPickupOrderMode.IN_STORE);
        const hasCarryOut = pickupTypes.includes(_model_enum__WEBPACK_IMPORTED_MODULE_4__.EPickupOrderMode.CARRY_OUT);
        if (hasInStore && hasCarryOut) {
          if (_this8.isInStorePickupArrived() || (yield _this8.isSameOrderPickup())) {
            _this8.renderMethod = _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.Continue;
          } else {
            _this8.renderMethod = _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.All;
          }
        } else if (hasInStore) {
          _this8.renderMethod = _this8.isInStorePickupArrived() ? _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.Continue : _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.CheckIn;
        } else if (hasCarryOut) {
          _this8.renderMethod = (yield _this8.isSameOrderPickup()) ? _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.Continue : _model_enum__WEBPACK_IMPORTED_MODULE_4__.ErenderMethodMode.Curbside;
        }
      } catch (err) {
        console.error('Error loading pickup mode', err);
      }
    })();
  }
  isInStorePickupArrived() {
    return this.order?.UserPickupStatus === _model_enum__WEBPACK_IMPORTED_MODULE_4__.EUserPickupStatus.Arrived;
  }
  isSameOrderPickup() {
    var _this9 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const curbsideOrderData = yield _this9.fetchCacheCurbsideOrderData();
      return curbsideOrderData && String(curbsideOrderData?.orderId) === String(_this9.orderId);
    })();
  }
  handleClickContinuePickup() {
    var _this0 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (_this0.isInStorePickupArrived()) {
        _this0.walkInPickup();
      }
      if (yield _this0.isSameOrderPickup()) {
        _this0.postUserLocation();
      }
    })();
  }
  walkInPickup() {
    var _this1 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const url = new URL(_this1.curbsideLink);
      url.searchParams.set('isWalkin', 'true');
      const curbsideLink = url.toString();
      _this1.dxpComponentService.listenToInAppBrowserEvents(curbsideLink, 'checkin', () => {
        _this1.renderPickingMode();
      });
    })();
  }
  postUserLocation() {
    var _this10 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this10.dxpComponentService.checkPermissionLocation();
      _this10.dxpComponentService.listenToInAppBrowserEvents(_this10.curbsideLink, undefined, () => {
        _this10.renderPickingMode();
      });
    })();
  }
  static ɵfac = function OrderDetailPageComponent_Factory(t) {
    return new (t || OrderDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_13__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_13__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_2__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](ionic_cache__WEBPACK_IMPORTED_MODULE_14__.CacheService), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_providers_order_service__WEBPACK_IMPORTED_MODULE_3__.OrderService), _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_5__.Credential));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵdefineComponent"]({
    type: OrderDetailPageComponent,
    selectors: [["order-detail"]],
    hostBindings: function OrderDetailPageComponent_HostBindings(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵlistener"]("curbside:onMyWay", function OrderDetailPageComponent_curbside_onMyWay_HostBindingHandler($event) {
          return ctx.onMyWayHandler($event);
        }, false, _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵresolveWindow"]);
      }
    },
    decls: 13,
    vars: 13,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center ", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/order/order-history", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [3, "order"], [1, "toolbar"], ["class", "picking", 4, "ngIf"], [1, "picking"], [1, "picking__desc"], ["expand", "block", 1, "button-pickup", 3, "click"], ["expand", "block", 1, "button-at-store", 3, "click"], [1, "checkin__desc"]],
    template: function OrderDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementStart"](8, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](9, "widget-layout", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](10, OrderDetailPageComponent_div_10_Template, 2, 1, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelement"](11, "widget-layout", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtemplate"](12, OrderDetailPageComponent_ion_footer_12_Template, 6, 4, "ion-footer", 7);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵtextInterpolate2"]("", _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵpipeBind1"](6, 11, "header.order"), " #", ctx.orderNumber, "");
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx.dxpOrderDetailReady);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_9__["ɵɵproperty"]("ngIf", ctx.showPickingOrder && ctx.curbsideLink && ctx.curbsideCheckReady);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_15__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonFooter, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_7__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_8__.HeaderComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: white;\n  border-bottom: var(--mag-border-width-100, 1px) solid var(--mag-color-border-divider, #eee);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --padding-bottom: 0 !important;\n}\n\n.picking[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  gap: var(--mag-spacing-200, 16px);\n}\n\n.toolbar[_ngcontent-%COMP%] {\n  display: flex;\n  padding: var(--mag-spacing-200, 16px);\n  padding-bottom: 16px !important;\n  flex-direction: column;\n  align-items: flex-start;\n  gap: var(--mag-spacing-200, 16px);\n  align-self: stretch;\n  border-top: var(--mag-border-width-100, 1px) solid var(--mag-color-border-divider, #eee);\n  background: var(--mag-color-surface-primary, #fff);\n}\n\nion-toolbar[_ngcontent-%COMP%] {\n  --padding-top: 0;\n  --padding-bottom: 0;\n}\n\n.button-pickup[_ngcontent-%COMP%] {\n  border: none;\n  height: 48px;\n  text-align: center;\n  border-radius: var(--mag-border-radius-rounded, 9999px);\n  background: var(--mag-color-surface-button-filled-brand, #008000);\n  cursor: pointer;\n  color: var(--mag-color-text-button-filled-brand, #fff);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px); \n\n}\n\n.button-at-store[_ngcontent-%COMP%] {\n  border: none;\n  background-color: transparent;\n  color: var(--mag-color-text-button-text-brand, #0d3876);\n  font-family: var(--mag-typography-font-family, Poppins);\n  font-size: var(--mag-typography-button-labels-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-button-label-medium-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-medium-line-height, 24px); \n\n}\n\n.picking__desc[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-weight: var(--mag-typography-body-small-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-small-line-height, 20px);\n}\n\n.checkin__desc[_ngcontent-%COMP%] {\n  text-align: center;\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-weight: var(--mag-typography-body-small-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-small-line-height, 20px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29yZGVyL3BhZ2VzL29yZGVyLWRldGFpbC9vcmRlci1kZXRhaWwuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw0QkFBQTtFQUNBLG1CQUFBO0VBQ0EsMkZBQUE7QUFDRjs7QUFFQTtFQUNFLDhCQUFBO0FBQ0Y7O0FBRUE7RUFDRSxhQUFBO0VBQ0Esc0JBQUE7RUFDQSxpQ0FBQTtBQUNGOztBQUNBO0VBQ0UsYUFBQTtFQUNBLHFDQUFBO0VBQ0EsK0JBQUE7RUFDQSxzQkFBQTtFQUNBLHVCQUFBO0VBQ0EsaUNBQUE7RUFDQSxtQkFBQTtFQUNBLHdGQUFBO0VBQ0Esa0RBQUE7QUFFRjs7QUFDQTtFQUNFLGdCQUFBO0VBQ0EsbUJBQUE7QUFFRjs7QUFBQTtFQUNFLFlBQUE7RUFDQSxZQUFBO0VBQ0Esa0JBQUE7RUFDQSx1REFBQTtFQUNBLGlFQUFBO0VBQ0EsZUFBQTtFQUNBLHNEQUFBO0VBQ0EsK0RBQUE7RUFDQSw0REFBQTtFQUNBLDBFQUFBO0VBQ0EsZ0VBQUEsRUFBQSxTQUFBO0FBR0Y7O0FBQUE7RUFDRSxZQUFBO0VBQ0EsNkJBQUE7RUFDQSx1REFBQTtFQUVBLHVEQUFBO0VBQ0EscUVBQUE7RUFDQSxrQkFBQTtFQUNBLHVFQUFBO0VBQ0EseUVBQUEsRUFBQSxTQUFBO0FBRUY7O0FBQ0E7RUFDRSw2Q0FBQTtFQUNBLCtEQUFBO0VBQ0EsMkRBQUE7RUFDQSxzRUFBQTtFQUNBLCtEQUFBO0FBRUY7O0FBQ0E7RUFDRSxrQkFBQTtFQUNBLDZDQUFBO0VBQ0EsK0RBQUE7RUFDQSwyREFBQTtFQUNBLHNFQUFBO0VBQ0EsK0RBQUE7QUFFRiIsInNvdXJjZXNDb250ZW50IjpbImlvbi10b29sYmFyIHtcbiAgLS1ib3JkZXItd2lkdGg6IDAgIWltcG9ydGFudDtcbiAgLS1iYWNrZ3JvdW5kOiB3aGl0ZTtcbiAgYm9yZGVyLWJvdHRvbTogdmFyKC0tbWFnLWJvcmRlci13aWR0aC0xMDAsIDFweCkgc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyLCAjZWVlKTtcbn1cblxuaW9uLWNvbnRlbnQge1xuICAtLXBhZGRpbmctYm90dG9tOiAwICFpbXBvcnRhbnQ7XG59XG5cbi5waWNraW5nIHtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuLnRvb2xiYXIge1xuICBkaXNwbGF5OiBmbGV4O1xuICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBwYWRkaW5nLWJvdHRvbTogMTZweCAhaW1wb3J0YW50O1xuICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICBhbGlnbi1pdGVtczogZmxleC1zdGFydDtcbiAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBhbGlnbi1zZWxmOiBzdHJldGNoO1xuICBib3JkZXItdG9wOiB2YXIoLS1tYWctYm9yZGVyLXdpZHRoLTEwMCwgMXB4KSBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLWRpdmlkZXIsICNlZWUpO1xuICBiYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbn1cblxuaW9uLXRvb2xiYXIge1xuICAtLXBhZGRpbmctdG9wOiAwO1xuICAtLXBhZGRpbmctYm90dG9tOiAwO1xufVxuLmJ1dHRvbi1waWNrdXAge1xuICBib3JkZXI6IG5vbmU7XG4gIGhlaWdodDogNDhweDtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuICBib3JkZXItcmFkaXVzOiB2YXIoLS1tYWctYm9yZGVyLXJhZGl1cy1yb3VuZGVkLCA5OTk5cHgpO1xuICBiYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1idXR0b24tZmlsbGVkLWJyYW5kLCAjMDA4MDAwKTtcbiAgY3Vyc29yOiBwb2ludGVyO1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtYnV0dG9uLWZpbGxlZC1icmFuZCwgI2ZmZik7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtZW1waGFzaXplZCwgNDAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTsgLyogMTUwJSAqL1xufVxuXG4uYnV0dG9uLWF0LXN0b3JlIHtcbiAgYm9yZGVyOiBub25lO1xuICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJ1dHRvbi10ZXh0LWJyYW5kLCAjMGQzODc2KTtcblxuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksIFBvcHBpbnMpO1xuICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbC1tZWRpdW0tZm9udC13ZWlnaHQsIDUwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7IC8qIDE1MCUgKi9cbn1cblxuLnBpY2tpbmdfX2Rlc2Mge1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWZvbnQtc2l6ZSwgMTRweCk7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbn1cblxuLmNoZWNraW5fX2Rlc2Mge1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCBMZXhlbmQpO1xuICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtZm9udC1zaXplLCAxNHB4KTtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtbGluZS1oZWlnaHQsIDIwcHgpO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 96659:
/*!****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/pages/order-history/order-history.ts ***!
  \****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderHistoryPageComponent: () => (/* binding */ OrderHistoryPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);












function OrderHistoryPageComponent_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](1, 1, ctx_r0.innerHtml), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsanitizeHtml"]);
  }
}
class OrderHistoryPageComponent {
  router;
  dxpService;
  constructor(router, dxpService) {
    this.router = router;
    this.dxpService = dxpService;
  }
  innerHtml;
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this.dxpService.onConnected();
      _this.innerHtml = '<mag-order-container></mag-order-container>';
    })();
  }
  ionViewWillLeave() {
    this.innerHtml = '';
  }
  static ɵfac = function OrderHistoryPageComponent_Factory(t) {
    return new (t || OrderHistoryPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__.DxpComponentService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: OrderHistoryPageComponent,
    selectors: [["order-history"]],
    decls: 11,
    vars: 11,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], [1, "order-history"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["class", "order-history__content", 3, "innerHTML", 4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "order-history__content", 3, "innerHTML"]],
    template: function OrderHistoryPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](7, "ion-content", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](8, "widget-layout", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](9, OrderHistoryPageComponent_div_9_Template, 2, 3, "div", 7);
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
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](6, 9, "header.orderHistory"));
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.innerHtml);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_3__.HeaderComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslatePipe, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_4__.SafeHtmlPipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: white;\n  border-bottom: var(--mag-border-width-100, 1px) solid var(--mag-color-border-divider, #eee);\n}\n\n.order-history__content[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-200, 16px);\n}\n.order-history__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29yZGVyL3BhZ2VzL29yZGVyLWhpc3Rvcnkvb3JkZXItaGlzdG9yeS5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsNEJBQUE7RUFDQSxtQkFBQTtFQUNBLDJGQUFBO0FBQ0Y7O0FBR0U7RUFDRSxrRUFBQTtBQUFKO0FBR0U7RUFDRSw2Q0FBQTtFQUNBLGtCQUFBO0VBQ0Esc0RBQUE7RUFDQSxnRUFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFESiIsInNvdXJjZXNDb250ZW50IjpbImlvbi10b29sYmFyIHtcbiAgLS1ib3JkZXItd2lkdGg6IDAgIWltcG9ydGFudDtcbiAgLS1iYWNrZ3JvdW5kOiB3aGl0ZTtcbiAgYm9yZGVyLWJvdHRvbTogdmFyKC0tbWFnLWJvcmRlci13aWR0aC0xMDAsIDFweCkgc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyLCAjZWVlKTtcbn1cblxuLm9yZGVyLWhpc3Rvcnkge1xuICAmX19jb250ZW50IHtcbiAgICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpIHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIH1cblxuICAmX190aXRsZSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksIExleGVuZCk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 48131:
/*!****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/pages/order-rebuild/order-rebuild.ts ***!
  \****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderRebuildComponent: () => (/* binding */ OrderRebuildComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);









function OrderRebuildComponent_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](1, 1, ctx_r0.dxpMagOrderRebuildContainer), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsanitizeHtml"]);
  }
}
class OrderRebuildComponent {
  router;
  route;
  orderId = '';
  serviceId = '';
  constructor(router, route) {
    this.router = router;
    this.route = route;
  }
  dxpMagOrderRebuildContainer = '';
  ionViewWillEnter() {
    const params = this.route.snapshot.paramMap;
    this.orderId = params.get('orderId');
    this.serviceId = params.get('serviceId');
    this.dxpMagOrderRebuildContainer = `<mag-order-rebuild-container order-id=${this.orderId} service-id=${this.serviceId}></mag-order-rebuild-container>`;
  }
  ionViewDidLeave() {
    this.dxpMagOrderRebuildContainer = '';
  }
  static ɵfac = function OrderRebuildComponent_Factory(t) {
    return new (t || OrderRebuildComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.ActivatedRoute));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: OrderRebuildComponent,
    selectors: [["order-rebuild"]],
    decls: 12,
    vars: 11,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/order/order-history", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn"], [1, "ion-padding"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["class", "order-rebuild", 3, "innerHTML", 4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "order-rebuild", 3, "innerHTML"]],
    template: function OrderRebuildComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](8, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](9, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](10, OrderRebuildComponent_div_10_Template, 2, 3, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](11, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](6, 9, "order.reOrder"));
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", ctx.dxpMagOrderRebuildContainer);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_0__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_1__.HeaderComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__.TranslatePipe, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__.SafeHtmlPipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider, #eee);\n}\n\nion-title[_ngcontent-%COMP%] {\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29yZGVyL3BhZ2VzL29yZGVyLXJlYnVpbGQvb3JkZXItcmVidWlsZC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLDhEQUFBO0FBQ0Y7O0FBRUE7RUFDRSx3REFBQTtFQUNBLGdFQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQTtFQUNBLDZDQUFBO0FBQ0Y7O0FBRUE7RUFDRSxvREFBQTtFQUNBLDJDQUFBO0VBQ0EsNkNBQUE7RUFDQSwyQ0FBQTtBQUNGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLXRvb2xiYXIge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctZW5kOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLWRpdmlkZXIsICNlZWUpO1xufVxuXG5pb24tdGl0bGUge1xuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNTAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbn1cblxuaW9uLWNvbnRlbnQge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 79263:
/*!******************************************************************!*\
  !*** ./src/app/modules/ecom-v2/order/providers/order.service.ts ***!
  \******************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OrderService: () => (/* binding */ OrderService)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/gateway/mag-ecom-core-api.service */ 31627);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ 70271);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ 46443);






class OrderService {
  api;
  http;
  constructor(api, http) {
    this.api = api;
    this.http = http;
  }
  getOrderById(id) {
    return this.api.get(`/order/v2.0/api/order/id/${id}/full`).pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_1__.map)(data => {
      return data;
    }));
  }
  static ɵfac = function OrderService_Factory(t) {
    return new (t || OrderService)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_0__.MagEComCoreApiHttpClient), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__.HttpClient));
  };
  static ɵprov = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjectable"]({
    token: OrderService,
    factory: OrderService.ɵfac,
    providedIn: 'root'
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_order_order-routing_module_ts.js.map