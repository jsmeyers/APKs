"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_notification_notification-routing_module_ts"],{

/***/ 33208:
/*!*********************************************************************!*\
  !*** ./src/app/modules/notification/notification-routing.module.ts ***!
  \*********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   NotificationRoutingModule: () => (/* binding */ NotificationRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _notification_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./notification.module */ 69193);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);




const routes = [{
  path: '',
  component: _notification_module__WEBPACK_IMPORTED_MODULE_0__.NotificationPageComponent
}, {
  path: ':messageId',
  component: _notification_module__WEBPACK_IMPORTED_MODULE_0__.NotificationDetailComponent
}];
class NotificationRoutingModule {
  static ɵfac = function NotificationRoutingModule_Factory(t) {
    return new (t || NotificationRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineNgModule"]({
    type: NotificationRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__.RouterModule.forChild(routes), _notification_module__WEBPACK_IMPORTED_MODULE_0__.NotificationModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](NotificationRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__.RouterModule, _notification_module__WEBPACK_IMPORTED_MODULE_0__.NotificationModule]
  });
})();

/***/ }),

/***/ 69193:
/*!*************************************************************!*\
  !*** ./src/app/modules/notification/notification.module.ts ***!
  \*************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   NotificationDetailComponent: () => (/* reexport safe */ _pages_notification_detail_notification_detail__WEBPACK_IMPORTED_MODULE_1__.NotificationDetailComponent),
/* harmony export */   NotificationModule: () => (/* binding */ NotificationModule),
/* harmony export */   NotificationPageComponent: () => (/* reexport safe */ _pages_notification_page_notification_page__WEBPACK_IMPORTED_MODULE_0__.NotificationPageComponent)
/* harmony export */ });
/* harmony import */ var _pages_notification_page_notification_page__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/notification-page/notification-page */ 50538);
/* harmony import */ var _pages_notification_detail_notification_detail__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/notification-detail/notification-detail */ 59374);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../utils/utils.module */ 50777);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _header_header_component_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);










class NotificationModule {
  static ɵfac = function NotificationModule_Factory(t) {
    return new (t || NotificationModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: NotificationModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule, _angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__.TranslateModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_3__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](NotificationModule, {
    declarations: [_pages_notification_page_notification_page__WEBPACK_IMPORTED_MODULE_0__.NotificationPageComponent, _pages_notification_detail_notification_detail__WEBPACK_IMPORTED_MODULE_1__.NotificationDetailComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule, _angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__.TranslateModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_3__.HeaderComponentModule],
    exports: [_pages_notification_page_notification_page__WEBPACK_IMPORTED_MODULE_0__.NotificationPageComponent, _pages_notification_detail_notification_detail__WEBPACK_IMPORTED_MODULE_1__.NotificationDetailComponent]
  });
})();

/***/ }),

/***/ 59374:
/*!***************************************************************************************!*\
  !*** ./src/app/modules/notification/pages/notification-detail/notification-detail.ts ***!
  \***************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   NotificationDetailComponent: () => (/* binding */ NotificationDetailComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../header/header.component */ 55074);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ngx-translate/core */ 90852);















class NotificationDetailComponent {
  dxpComponentService;
  route;
  router;
  cre;
  cStore;
  notificationDetailWidgets = '';
  messageId = '';
  constructor(dxpComponentService, route, router, cre, cStore) {
    this.dxpComponentService = dxpComponentService;
    this.route = route;
    this.router = router;
    this.cre = cre;
    this.cStore = cStore;
    const params = this.route.snapshot.paramMap;
    this.messageId = params.get('messageId');
  }
  ionViewDidEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this.dxpComponentService.onConnected();
      try {
        _this.notificationDetailWidgets = `<dxp-notification-detail message-id="${_this.messageId}"></dxp-notification-detail>`;
      } catch (err) {
        console.error('err', err);
      }
    })();
  }
  reloadSelectedMessage() {
    const payload = {
      action: 'MessageSelected'
    };
    window.postMessage({
      ...payload
    }, window.location.origin);
    return this.router.navigate(['/notification']);
  }
  static ɵfac = function NotificationDetailComponent_Factory(t) {
    return new (t || NotificationDetailComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_3__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__.CurrentStore));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineComponent"]({
    type: NotificationDetailComponent,
    selectors: [["notification-detail"]],
    decls: 13,
    vars: 13,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], [1, "ion-padding-horizontal"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [3, "innerHTML"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function NotificationDetailComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵlistener"]("click", function NotificationDetailComponent_Template_ion_back_button_click_7_listener() {
          return ctx.reloadSelectedMessage();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](8, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](9, "widget-layout", 7)(10, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipe"](11, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](12, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipeBind1"](6, 9, "header.messageDetail"));
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipeBind1"](11, 11, ctx.notificationDetailWidgets), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_5__.HeaderComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_6__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__.TranslatePipe],
    styles: ["ion-content[_ngcontent-%COMP%] {\n  --padding-top: var(--mag-spacing-400, 32px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9ub3RpZmljYXRpb24vcGFnZXMvbm90aWZpY2F0aW9uLWRldGFpbC9ub3RpZmljYXRpb24tZGV0YWlsLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSwyQ0FBQTtBQUNGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLWNvbnRlbnQge1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 50538:
/*!***********************************************************************************!*\
  !*** ./src/app/modules/notification/pages/notification-page/notification-page.ts ***!
  \***********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   NotificationPageComponent: () => (/* binding */ NotificationPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../header/header.component */ 55074);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ngx-translate/core */ 90852);















class NotificationPageComponent {
  dxpComponentService;
  route;
  router;
  cre;
  cStore;
  notificationWidgets = '';
  constructor(dxpComponentService, route, router, cre, cStore) {
    this.dxpComponentService = dxpComponentService;
    this.route = route;
    this.router = router;
    this.cre = cre;
    this.cStore = cStore;
  }
  ionViewDidEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this.dxpComponentService.onConnected();
      try {
        _this.notificationWidgets = `<dxp-notification-page></dxp-notification-page>`;
      } catch (err) {
        console.error('err', err);
      }
    })();
  }
  returnHome() {
    return this.router.navigate(['tabs/home']);
  }
  static ɵfac = function NotificationPageComponent_Factory(t) {
    return new (t || NotificationPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_3__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__.CurrentStore));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineComponent"]({
    type: NotificationPageComponent,
    selectors: [["notification-page"]],
    decls: 13,
    vars: 13,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], ["scrollY", "false", 1, "ion-padding-horizontal", "notification"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [3, "innerHTML"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function NotificationPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵlistener"]("click", function NotificationPageComponent_Template_ion_back_button_click_7_listener() {
          return ctx.returnHome();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](8, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](9, "widget-layout", 7)(10, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipe"](11, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](12, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipeBind1"](6, 9, "header.messageCenter"));
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵpipeBind1"](11, 11, ctx.notificationWidgets), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_5__.HeaderComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_6__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__.TranslatePipe],
    styles: ["ion-content[_ngcontent-%COMP%] {\n  --padding-top: var(--mag-spacing-400, 32px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9ub3RpZmljYXRpb24vcGFnZXMvbm90aWZpY2F0aW9uLXBhZ2Uvbm90aWZpY2F0aW9uLXBhZ2Uuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLDJDQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tY29udGVudCB7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_notification_notification-routing_module_ts.js.map