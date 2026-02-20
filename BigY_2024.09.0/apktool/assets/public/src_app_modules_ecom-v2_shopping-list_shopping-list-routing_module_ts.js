"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_shopping-list_shopping-list-routing_module_ts"],{

/***/ 90121:
/*!************************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/shopping-list/pages/shopping-list-detail/shopping-list-detail.component.ts ***!
  \************************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ShoppingListDetailComponent: () => (/* binding */ ShoppingListDetailComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/core/enum */ 35619);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 18537);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs */ 52575);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
















class ShoppingListDetailComponent {
  dxpComponentService;
  router;
  activeRoute;
  navCtrl;
  routerOutlet;
  location;
  magShoppingListDetail = '';
  listId;
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_6__.Subject();
  previousPath = '';
  constructor(dxpComponentService, router, activeRoute, navCtrl, routerOutlet, location) {
    this.dxpComponentService = dxpComponentService;
    this.router = router;
    this.activeRoute = activeRoute;
    this.navCtrl = navCtrl;
    this.routerOutlet = routerOutlet;
    this.location = location;
    this.previousPath = this.router.getCurrentNavigation()?.previousNavigation?.finalUrl.toString();
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this.dxpComponentService.onConnected();
      _this.listId = _this.activeRoute.snapshot.paramMap.get('id');
      _this.magShoppingListDetail = `<mag-shopping-list-detail-page shopping-list-id='${_this.listId}'></mag-shopping-list-detail-page>`;
      (0,rxjs__WEBPACK_IMPORTED_MODULE_7__.fromEvent)(window, 'backToList').pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_8__.takeUntil)(_this.destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_9__.debounceTime)(300)).subscribe(/*#__PURE__*/(0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
        if (!_this.routerOutlet.canGoBack()) {
          _this.router.navigateByUrl('tabs/home', {
            replaceUrl: true
          });
          return;
        }
        if (_this.previousPath) {
          _this.navCtrl.back();
        } else {
          _this.navCtrl.setDirection('back');
          _this.router.navigate(['/tabs/home'], {
            replaceUrl: true
          });
        }
      }));
    })();
  }
  ngOnDestroy() {
    this.magShoppingListDetail = '';
    this.destroy$.next(true);
  }
  handleNavigation() {
    // if (!this.routerOutlet.canGoBack()) {
    //   this.router.navigateByUrl('tabs/home', { replaceUrl: true });
    //   return;
    // }
    if (_rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.RegexRouteName.LOGIN.test(this.previousPath)) {
      this.navCtrl.setDirection('back');
      this.router.navigate(['/home'], {
        replaceUrl: true
      });
    } else {
      this.location.back();
    }
  }
  static ɵfac = function ShoppingListDetailComponent_Factory(t) {
    return new (t || ShoppingListDetailComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_11__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_11__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_12__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonRouterOutlet), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_14__.Location));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdefineComponent"]({
    type: ShoppingListDetailComponent,
    selectors: [["app-shopping-list-detail"]],
    decls: 13,
    vars: 13,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], [1, "no-padding-bottom"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "shopping-list-detail__container", 3, "innerHTML"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function ShoppingListDetailComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵlistener"]("click", function ShoppingListDetailComponent_Template_ion_back_button_click_7_listener() {
          return ctx.handleNavigation();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](8, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](9, "widget-layout", 7)(10, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵpipe"](11, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](12, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵpipeBind1"](6, 9, "shoppingList.titleListDetails"));
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵpipeBind1"](11, 11, ctx.magShoppingListDetail), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_4__.HeaderComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_5__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_15__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: var(--mag-color-surface-primary, #fff);\n}\n\nion-back-button[_ngcontent-%COMP%] {\n  --color: var(--mag-color-text-primary, #121212);\n}\n\n.shopping-list-detail__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 600);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.shopping-list-detail__icon[_ngcontent-%COMP%] {\n  padding: 0px var(--mag-spacing-150, 12px);\n}\n\n.shopping-list-detail__container[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Nob3BwaW5nLWxpc3QvcGFnZXMvc2hvcHBpbmctbGlzdC1kZXRhaWwvc2hvcHBpbmctbGlzdC1kZXRhaWwuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw0QkFBQTtFQUNBLG9EQUFBO0FBQ0Y7O0FBRUE7RUFDRSwrQ0FBQTtBQUNGOztBQUVBO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUNBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFDRjs7QUFFQTtFQUNFLHlDQUFBO0FBQ0Y7O0FBRUE7RUFDRSxrRUFBQTtBQUNGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLXRvb2xiYXIge1xuICAtLWJvcmRlci13aWR0aDogMCAhaW1wb3J0YW50O1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xufVxuXG5pb24tYmFjay1idXR0b24ge1xuICAtLWNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbn1cblxuLnNob3BwaW5nLWxpc3QtZGV0YWlsX190aXRsZSB7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksIExleGVuZCk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNjAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG59XG5cbi5zaG9wcGluZy1saXN0LWRldGFpbF9faWNvbiB7XG4gIHBhZGRpbmc6IDBweCB2YXIoLS1tYWctc3BhY2luZy0xNTAsIDEycHgpO1xufVxuXG4uc2hvcHBpbmctbGlzdC1kZXRhaWxfX2NvbnRhaW5lciB7XG4gIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCkgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 68443:
/*!************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/shopping-list/pages/shopping-lists/shopping-lists.component.ts ***!
  \************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ShoppingListsComponent: () => (/* binding */ ShoppingListsComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/core/enum */ 35619);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @pscoped/ngx-pub-sub */ 2055);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @ngx-translate/core */ 90852);

















function ShoppingListsComponent_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵpipeBind1"](1, 1, ctx_r0.magShoppingList), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵsanitizeHtml"]);
  }
}
class ShoppingListsComponent {
  dxpComponentService;
  router;
  navCtrl;
  events;
  route;
  magShoppingList = '';
  innerIconShoppingList = '';
  previousPath = '';
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_7__.Subject();
  constructor(dxpComponentService, router, navCtrl, events, route) {
    this.dxpComponentService = dxpComponentService;
    this.router = router;
    this.navCtrl = navCtrl;
    this.events = events;
    this.route = route;
    this.previousPath = this.router.getCurrentNavigation().previousNavigation?.finalUrl.toString();
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.router.events.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_8__.takeUntil)(_this.destroy$)).subscribe(/*#__PURE__*/function () {
        var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (event) {
          if (event instanceof _angular_router__WEBPACK_IMPORTED_MODULE_9__.NavigationEnd) {
            const urlPath = event.url.split('?')[0]; // strip query params
            if (urlPath === '/shopping-list') {
              yield _this.dxpComponentService.onConnected();
              _this.magShoppingList = `<mag-shopping-list-page></mag-shopping-list-page>`;
            } else {
              _this.magShoppingList = ``;
            }
          }
        });
        return function (_x) {
          return _ref.apply(this, arguments);
        };
      }());
    })();
  }
  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.complete();
  }
  handleNavigation() {
    if (_rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.RegexRouteName.LOGIN.test(this.previousPath)) {
      this.navCtrl.setDirection('back');
      this.router.navigate(['/home'], {
        replaceUrl: true
      });
    } else {
      this.navCtrl.back();
    }
  }
  static ɵfac = function ShoppingListsComponent_Factory(t) {
    return new (t || ShoppingListsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_9__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_10__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_11__.NgxPubSubService), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_9__.ActivatedRoute));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineComponent"]({
    type: ShoppingListsComponent,
    selectors: [["app-shopping-lists"]],
    decls: 12,
    vars: 11,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], [1, "no-padding-bottom"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["class", "shopping-lists__container", 3, "innerHTML", 4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "shopping-lists__container", 3, "innerHTML"]],
    template: function ShoppingListsComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](7, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵlistener"]("click", function ShoppingListsComponent_Template_ion_back_button_click_7_listener() {
          return ctx.handleNavigation();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](8, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](9, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplate"](10, ShoppingListsComponent_div_10_Template, 2, 3, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](11, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵpipeBind1"](6, 9, "shoppingList.titleMyLists"));
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", ctx.magShoppingList);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_12__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_4__.HeaderComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_5__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: var(--mag-color-surface-primary, #fff);\n}\n\nion-back-button[_ngcontent-%COMP%] {\n  --color: var(--mag-color-text-primary, #121212);\n}\n\n.shopping-lists__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 600);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.shopping-lists__container[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-200, 16px);\n}\n\n.shopping-lists__icon[_ngcontent-%COMP%] {\n  padding: 0px var(--mag-spacing-150, 12px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Nob3BwaW5nLWxpc3QvcGFnZXMvc2hvcHBpbmctbGlzdHMvc2hvcHBpbmctbGlzdHMuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw0QkFBQTtFQUNBLG9EQUFBO0FBQ0Y7O0FBRUE7RUFDRSwrQ0FBQTtBQUNGOztBQUVBO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUNBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFDRjs7QUFFQTtFQUNFLGtFQUFBO0FBQ0Y7O0FBRUE7RUFDRSx5Q0FBQTtBQUNGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLXRvb2xiYXIge1xuICAtLWJvcmRlci13aWR0aDogMCAhaW1wb3J0YW50O1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xufVxuXG5pb24tYmFjay1idXR0b24ge1xuICAtLWNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbn1cblxuLnNob3BwaW5nLWxpc3RzX190aXRsZSB7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksIExleGVuZCk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNjAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG59XG5cbi5zaG9wcGluZy1saXN0c19fY29udGFpbmVyIHtcbiAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KSB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuXG4uc2hvcHBpbmctbGlzdHNfX2ljb24ge1xuICBwYWRkaW5nOiAwcHggdmFyKC0tbWFnLXNwYWNpbmctMTUwLCAxMnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 78832:
/*!*******************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/shopping-list/shopping-list-routing.module.ts ***!
  \*******************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ShoppingListPageRoutingModule: () => (/* binding */ ShoppingListPageRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _pages_shopping_list_detail_shopping_list_detail_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/shopping-list-detail/shopping-list-detail.component */ 90121);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _shopping_list_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./shopping-list.module */ 7361);
/* harmony import */ var _pages_shopping_lists_shopping_lists_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/shopping-lists/shopping-lists.component */ 68443);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);







const routes = [{
  path: '',
  component: _pages_shopping_lists_shopping_lists_component__WEBPACK_IMPORTED_MODULE_3__.ShoppingListsComponent
}, {
  path: ':id',
  component: _pages_shopping_list_detail_shopping_list_detail_component__WEBPACK_IMPORTED_MODULE_0__.ShoppingListDetailComponent
}];
class ShoppingListPageRoutingModule {
  static ɵfac = function ShoppingListPageRoutingModule_Factory(t) {
    return new (t || ShoppingListPageRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: ShoppingListPageRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule.forChild(routes), _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_1__.UtilsModule, _shopping_list_module__WEBPACK_IMPORTED_MODULE_2__.ShoppingListPageModule, _angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](ShoppingListPageRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_1__.UtilsModule, _shopping_list_module__WEBPACK_IMPORTED_MODULE_2__.ShoppingListPageModule],
    exports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule]
  });
})();

/***/ }),

/***/ 7361:
/*!***********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/shopping-list/shopping-list.module.ts ***!
  \***********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ShoppingListPageModule: () => (/* binding */ ShoppingListPageModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _pages_shopping_list_detail_shopping_list_detail_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/shopping-list-detail/shopping-list-detail.component */ 90121);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _pages_shopping_lists_shopping_lists_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/shopping-lists/shopping-lists.component */ 68443);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);









class ShoppingListPageModule {
  static ɵfac = function ShoppingListPageModule_Factory(t) {
    return new (t || ShoppingListPageModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: ShoppingListPageModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_1__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_7__.RouterModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_3__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](ShoppingListPageModule, {
    declarations: [_pages_shopping_list_detail_shopping_list_detail_component__WEBPACK_IMPORTED_MODULE_0__.ShoppingListDetailComponent, _pages_shopping_lists_shopping_lists_component__WEBPACK_IMPORTED_MODULE_2__.ShoppingListsComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_1__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_7__.RouterModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_3__.HeaderComponentModule],
    exports: [_pages_shopping_list_detail_shopping_list_detail_component__WEBPACK_IMPORTED_MODULE_0__.ShoppingListDetailComponent, _pages_shopping_lists_shopping_lists_component__WEBPACK_IMPORTED_MODULE_2__.ShoppingListsComponent]
  });
})();

/***/ }),

/***/ 52575:
/*!***********************************************************************!*\
  !*** ./node_modules/rxjs/dist/esm/internal/operators/debounceTime.js ***!
  \***********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   debounceTime: () => (/* binding */ debounceTime)
/* harmony export */ });
/* harmony import */ var _scheduler_async__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../scheduler/async */ 18473);
/* harmony import */ var _util_lift__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../util/lift */ 50819);
/* harmony import */ var _OperatorSubscriber__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./OperatorSubscriber */ 91687);



function debounceTime(dueTime, scheduler = _scheduler_async__WEBPACK_IMPORTED_MODULE_0__.asyncScheduler) {
  return (0,_util_lift__WEBPACK_IMPORTED_MODULE_1__.operate)((source, subscriber) => {
    let activeTask = null;
    let lastValue = null;
    let lastTime = null;
    const emit = () => {
      if (activeTask) {
        activeTask.unsubscribe();
        activeTask = null;
        const value = lastValue;
        lastValue = null;
        subscriber.next(value);
      }
    };
    function emitWhenIdle() {
      const targetTime = lastTime + dueTime;
      const now = scheduler.now();
      if (now < targetTime) {
        activeTask = this.schedule(undefined, targetTime - now);
        subscriber.add(activeTask);
        return;
      }
      emit();
    }
    source.subscribe((0,_OperatorSubscriber__WEBPACK_IMPORTED_MODULE_2__.createOperatorSubscriber)(subscriber, value => {
      lastValue = value;
      lastTime = scheduler.now();
      if (!activeTask) {
        activeTask = scheduler.schedule(emitWhenIdle, dueTime);
        subscriber.add(activeTask);
      }
    }, () => {
      emit();
      subscriber.complete();
    }, undefined, () => {
      lastValue = activeTask = null;
    }));
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_shopping-list_shopping-list-routing_module_ts.js.map