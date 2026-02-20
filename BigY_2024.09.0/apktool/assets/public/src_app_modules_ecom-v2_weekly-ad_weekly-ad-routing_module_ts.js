"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_weekly-ad_weekly-ad-routing_module_ts"],{

/***/ 31105:
/*!********************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/weekly-ad/pages/weekly-ad-page/weekly-ad-page.component.ts ***!
  \********************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   WeeklyAdPageComponent: () => (/* binding */ WeeklyAdPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/core/enum */ 35619);
/* harmony import */ var _rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/route-tracker.service */ 68674);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! rxjs */ 19999);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! rxjs */ 14876);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/utils/constants/constants */ 29665);
/* harmony import */ var _ionic_storage__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/storage */ 60850);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../weekly-all-ads/weekly-all-ads.component */ 33991);
/* harmony import */ var _weekly_product_view_weekly_product_view_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../weekly-product-view/weekly-product-view.component */ 69893);
/* harmony import */ var _weekly_flyer_view_weekly_flyer_view_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../weekly-flyer-view/weekly-flyer-view.component */ 40541);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @ngx-translate/core */ 90852);























const _c0 = ["container"];
const _c1 = a0 => ({
  loading: a0
});
const _c2 = () => [1, 2, 3, 4];
function WeeklyAdPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "widget-layout", 8);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function WeeklyAdPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "widget-layout", 9);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function WeeklyAdPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "widget-layout", 10);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function WeeklyAdPageComponent_ng_container_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](1, "div", 11)(2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](3, "ion-img", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](4, "p", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpipe"](6, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](7, "p", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpipe"](9, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()()();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpipeBind1"](6, 2, "common.notFoundTitle"));
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpipeBind1"](9, 4, "common.notFoundDescription"));
  }
}
function WeeklyAdPageComponent_ng_container_9_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "mag-subscribe-now");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
}
function WeeklyAdPageComponent_ng_container_9_mag_tabs_2_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "mag-tabs", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵlistener"]("selectTab", function WeeklyAdPageComponent_ng_container_9_mag_tabs_2_Template_mag_tabs_selectTab_0_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵrestoreView"](_r2);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵresetView"](ctx_r0.selectedChanged($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("activeItem", ctx_r0.activeTab)("defaultId", ctx_r0.activeTab == null ? null : ctx_r0.activeTab.id)("data", ctx_r0.dataTabs);
  }
}
function WeeklyAdPageComponent_ng_container_9_div_3_div_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "div", 26);
  }
}
function WeeklyAdPageComponent_ng_container_9_div_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "div", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](2, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](3, WeeklyAdPageComponent_ng_container_9_div_3_div_3_Template, 1, 0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngForOf", _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpureFunction0"](1, _c2));
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "widget-layout", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_weekly_flyer_view_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "weekly-flyer-view");
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_weekly_product_view_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "weekly-product-view");
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_weekly_all_ads_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "weekly-all-ads");
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerStart"](0)(1, 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](2, WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_weekly_flyer_view_2_Template, 1, 0, "weekly-flyer-view", 31)(3, WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_weekly_product_view_3_Template, 1, 0, "weekly-product-view", 31)(4, WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_weekly_all_ads_4_Template, 1, 0, "weekly-all-ads", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngSwitch", ctx_r0.activeTab == null ? null : ctx_r0.activeTab.id);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngSwitchCase", "flyer-view");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngSwitchCase", "product-view");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngSwitchCase", "all-ads");
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_ng_container_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "weekly-flyer-view");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerEnd"]();
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_div_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "widget-layout", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function WeeklyAdPageComponent_ng_container_9_div_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 11, 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](2, WeeklyAdPageComponent_ng_container_9_div_4_div_2_Template, 2, 1, "div", 27)(3, WeeklyAdPageComponent_ng_container_9_div_4_ng_container_3_Template, 5, 4, "ng-container", 7)(4, WeeklyAdPageComponent_ng_container_9_div_4_ng_container_4_Template, 2, 0, "ng-container", 7)(5, WeeklyAdPageComponent_ng_container_9_div_4_div_5_Template, 2, 1, "div", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.loadedWidget);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.dataTabs == null ? null : ctx_r0.dataTabs.length);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", !(ctx_r0.dataTabs == null ? null : ctx_r0.dataTabs.length));
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.loadedWidget);
  }
}
function WeeklyAdPageComponent_ng_container_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](1, WeeklyAdPageComponent_ng_container_9_div_1_Template, 2, 0, "div", 16)(2, WeeklyAdPageComponent_ng_container_9_mag_tabs_2_Template, 1, 3, "mag-tabs", 17)(3, WeeklyAdPageComponent_ng_container_9_div_3_Template, 4, 2, "div", 18)(4, WeeklyAdPageComponent_ng_container_9_div_4_Template, 6, 4, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.enabledSubscribeBanner);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", (ctx_r0.dataTabs == null ? null : ctx_r0.dataTabs.length) > 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.loadingSkeleton);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.loaded);
  }
}
class WeeklyAdPageComponent {
  router;
  navCtrl;
  routeTracker;
  appSettings;
  storage;
  cdr;
  containerElement;
  enumTabsOptionType = _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.EnumMagWeeklyadTabOption;
  activeTab;
  isShoppingList = false;
  enabledPage = true;
  enabledSubscribeBanner = false;
  loaded = false;
  loadedWidget = false;
  loadingSkeleton = true;
  dataTabs;
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_12__.Subject();
  clearInterval;
  constructor(router, navCtrl, routeTracker, appSettings, storage, cdr) {
    this.router = router;
    this.navCtrl = navCtrl;
    this.routeTracker = routeTracker;
    this.appSettings = appSettings;
    this.storage = storage;
    this.cdr = cdr;
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const currentLocale = (yield _this.storage.get(_rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__.LOCAL_LOCALE_KEY)) || _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__.DEFAULT_LOCALE;
      (0,rxjs__WEBPACK_IMPORTED_MODULE_13__.combineLatest)([_this.appSettings.getSettingValue('digital_circular_support'), _this.appSettings.getSettingValue('digital_circular_page_navigation_support'), _this.appSettings.getSettingValue('subscribe_now_banner_support')]).pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_14__.takeUntil)(_this.destroy$)).subscribe(([digitalCircular, navigationSupport, subscribeNowBanner]) => {
        const configTabs = JSON.parse(navigationSupport);
        // 1. Set digital circular enabled flag
        _this.enabledPage = digitalCircular?.toLowerCase() === 'true';
        _this.enabledSubscribeBanner = subscribeNowBanner?.toLowerCase() === 'true';
        // 2. Mapping data tabs
        _this.dataTabs = configTabs && configTabs.map(config => ({
          id: config?.Id,
          label: config?.Title?.[currentLocale]
        }));
        // 3. Set active tab
        if (_this.dataTabs?.length) {
          const path = _this.router.url.split('/').pop() || _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.EnumMagWeeklyadTabOption.FlyerView;
          _this.activeTab = _this.dataTabs.find(tab => tab.id == path);
        }
        _this.loaded = true;
        _this.loadedWidget = true;
        _this.showLoadingSkeleton();
      });
      _this.routeTracker.getRenderType().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_14__.takeUntil)(_this.destroy$)).subscribe(value => {
        _this.isShoppingList = value === _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.EnumMagFulfillmentManagementRenderType.ShoppingList;
        _this.loadedWidget = false;
        _this.cdr.detectChanges();
        _this.loadedWidget = true;
        const path = _this.router.url.split('/').pop() || _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.EnumMagWeeklyadTabOption.FlyerView;
        if (path === _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.EnumMagWeeklyadTabOption.FlyerView) {
          _this.activeTab = _this.dataTabs.find(tab => tab.id == path);
        }
        _this.showLoadingSkeleton();
        _this.clearInterval = setInterval(() => {
          window.scrollTo(0, window.scrollY + 1);
        }, 3000);
      });
      window.addEventListener('message', event => {
        if (event.origin !== window.location.origin) return;
        if (event.data.action == 'MagFlipLoadCompleted') {
          _this.loadingSkeleton = false;
          _this.cdr.detectChanges();
        }
      }, false);
    })();
  }
  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.complete();
    if (this.clearInterval) {
      clearInterval(this.clearInterval);
    }
  }
  backToHome() {
    this.navCtrl.navigateRoot('/tabs/home', {
      replaceUrl: true
    });
  }
  selectedChanged(event) {
    this.loadedWidget = false;
    this.activeTab = event.detail;
    window.history.replaceState({}, '', '/tabs/weekly-ad');
    this.navCtrl.navigateForward(`/tabs/weekly-ad/${event.detail?.id || _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_1__.EnumMagWeeklyadTabOption.FlyerView}`);
    this.containerElement?.nativeElement?.scrollIntoView({
      behavior: 'smooth',
      block: 'start'
    });
  }
  showLoadingSkeleton() {
    this.loadingSkeleton = true;
    if (this.activeTab.id == this.enumTabsOptionType?.FlyerView) return;
    (0,rxjs__WEBPACK_IMPORTED_MODULE_15__.timer)(3000).pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_14__.takeUntil)(this.destroy$)).subscribe(() => this.loadingSkeleton = false);
  }
  static ɵfac = function WeeklyAdPageComponent_Factory(t) {
    return new (t || WeeklyAdPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_16__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_17__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_2__.RouteTrackerService), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_3__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_ionic_storage__WEBPACK_IMPORTED_MODULE_5__.Storage), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_11__.ChangeDetectorRef));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdefineComponent"]({
    type: WeeklyAdPageComponent,
    selectors: [["weely-ad-page"]],
    viewQuery: function WeeklyAdPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵviewQuery"](_c0, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵloadQuery"]()) && (ctx.containerElement = _t.first);
      }
    },
    decls: 10,
    vars: 12,
    consts: [["container", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader"], [1, "title-header"], [3, "ngClass"], [4, "ngIf"], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "container"], [1, "not-found"], ["src", "assets/imgs/404.svg", 1, "not-found__image"], [1, "not-found__title"], [1, "not-found__description"], ["class", "banner", 4, "ngIf"], ["mode", "scale", 3, "activeItem", "defaultId", "data", "selectTab", 4, "ngIf"], ["class", "skeleton", 4, "ngIf"], ["class", "container", 4, "ngIf"], [1, "banner"], ["mode", "scale", 3, "selectTab", "activeItem", "defaultId", "data"], [1, "skeleton"], [1, "skeleton-banner"], [1, "skeleton-grid"], ["class", "skeleton-product", 4, "ngFor", "ngForOf"], [1, "skeleton-product"], ["class", "widget-layout", 4, "ngIf"], [1, "widget-layout"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [3, "ngSwitch"], [4, "ngSwitchCase"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function WeeklyAdPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](0, WeeklyAdPageComponent_widget_layout_0_Template, 1, 1, "widget-layout", 1)(1, WeeklyAdPageComponent_widget_layout_1_Template, 1, 1, "widget-layout", 2)(2, WeeklyAdPageComponent_widget_layout_2_Template, 1, 1, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](3, "app-header", 4)(4, "ion-title", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](7, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](8, WeeklyAdPageComponent_ng_container_8_Template, 10, 6, "ng-container", 7)(9, WeeklyAdPageComponent_ng_container_9_Template, 5, 4, "ng-container", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx.loadedWidget);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx.loadedWidget);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx.loadedWidget);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("isSimpleHeader", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpipeBind1"](6, 8, "header.weeklyAd"));
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵpureFunction1"](10, _c1, ctx.loadingSkeleton));
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", !ctx.enabledPage);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx.enabledPage);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_18__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_18__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_18__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_18__.NgSwitch, _angular_common__WEBPACK_IMPORTED_MODULE_18__.NgSwitchCase, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_6__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_7__.HeaderComponent, _weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_8__.WeeklyAllAdsComponent, _weekly_product_view_weekly_product_view_component__WEBPACK_IMPORTED_MODULE_9__.WeeklyProductViewComponent, _weekly_flyer_view_weekly_flyer_view_component__WEBPACK_IMPORTED_MODULE_10__.WeeklyFlyerViewComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_20__.TranslatePipe],
    styles: ["[_nghost-%COMP%] {\n  --height-header: 56px;\n}\n[_nghost-%COMP%]   ion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: var(--mag-color-surface-primary, #fff);\n}\n[_nghost-%COMP%]   ion-content[_ngcontent-%COMP%] {\n  --padding-bottom: 0 !important;\n}\n[_nghost-%COMP%]   ion-back-button[_ngcontent-%COMP%] {\n  --color: var(--mag-color-text-primary, #121212);\n}\n[_nghost-%COMP%]   mag-tabs[_ngcontent-%COMP%] {\n  white-space: nowrap;\n}\n[_nghost-%COMP%]   .title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n[_nghost-%COMP%]   .banner[_ngcontent-%COMP%] {\n  padding: 0px var(--mag-spacing-200, 16px) var(--mag-spacing-300, 24px) var(--mag-spacing-200, 16px);\n}\n[_nghost-%COMP%]   .container[_ngcontent-%COMP%] {\n  height: calc(100% - var(--height-header));\n  overflow-y: auto;\n  overflow-x: hidden;\n  padding-top: var(--mag-spacing-300, 24px);\n}\n[_nghost-%COMP%]   .container[_ngcontent-%COMP%]   .widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n[_nghost-%COMP%]   .container[_ngcontent-%COMP%]   .not-found[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-200, 16px) var(--mag-spacing-1000, 80px) var(--mag-spacing-200, 16px);\n}\n[_nghost-%COMP%]   .container[_ngcontent-%COMP%]   .not-found__image[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  object-fit: cover;\n  margin-bottom: var(--mag-spacing-150, 12px);\n}\n[_nghost-%COMP%]   .container[_ngcontent-%COMP%]   .not-found__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend, Arial, sans-serif);\n  font-size: var(--mag-typography-display-large-font-size, 32px);\n  font-style: normal;\n  font-weight: var(--mag-typography-display-large-font-weight, 600);\n  line-height: var(--mag-typography-display-large-line-height, 40px);\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n[_nghost-%COMP%]   .container[_ngcontent-%COMP%]   .not-found__description[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend, Arial, sans-serif);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n[_nghost-%COMP%]   .skeleton-grid[_ngcontent-%COMP%] {\n  padding: 10px;\n  display: grid;\n  grid-template-columns: repeat(2, 1fr);\n  gap: 10px;\n  overflow: hidden;\n}\n[_nghost-%COMP%]   .skeleton-banner[_ngcontent-%COMP%] {\n  height: 150px;\n  margin: 10px;\n  background-color: #ddd;\n  background-image: linear-gradient(90deg, #ddd 0px, #e8e8e8 40px, #ddd 80px);\n  background-size: 600px;\n  animation: _ngcontent-%COMP%_shine-lines 1.6s infinite linear;\n  border-radius: 8px;\n}\n[_nghost-%COMP%]   .skeleton-product[_ngcontent-%COMP%] {\n  aspect-ratio: 1/1.5;\n  background-color: #ddd;\n  background-image: linear-gradient(90deg, #ddd 0px, #e8e8e8 40px, #ddd 80px);\n  background-size: 600px;\n  animation: _ngcontent-%COMP%_shine-lines 1.6s infinite linear;\n  border-radius: 8px;\n}\n@keyframes _ngcontent-%COMP%_shine-lines {\n  0% {\n    background-position: -100px;\n  }\n  40%, 100% {\n    background-position: 375px;\n  }\n}\n[_nghost-%COMP%]   .loading[_ngcontent-%COMP%] {\n  pointer-events: none;\n  --overflow: hidden;\n  opacity: 0.5;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3dlZWtseS1hZC9wYWdlcy93ZWVrbHktYWQtcGFnZS93ZWVrbHktYWQtcGFnZS5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHFCQUFBO0FBQ0Y7QUFDRTtFQUNFLDRCQUFBO0VBQ0Esb0RBQUE7QUFDSjtBQUVFO0VBQ0UsOEJBQUE7QUFBSjtBQUdFO0VBQ0UsK0NBQUE7QUFESjtBQUlFO0VBQ0UsbUJBQUE7QUFGSjtBQUtFO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUNBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFISjtBQU1FO0VBQ0UsbUdBQUE7QUFKSjtBQU9FO0VBQ0UseUNBQUE7RUFDQSxnQkFBQTtFQUNBLGtCQUFBO0VBQ0EseUNBQUE7QUFMSjtBQU9JO0VBQ0UsdUNBQUE7QUFMTjtBQVFJO0VBQ0UsNkhBQUE7QUFOTjtBQVNNO0VBQ0UsV0FBQTtFQUNBLFlBQUE7RUFDQSxpQkFBQTtFQUNBLDJDQUFBO0FBUFI7QUFVTTtFQUNFLDZDQUFBO0VBQ0Esa0ZBQUE7RUFDQSw4REFBQTtFQUNBLGtCQUFBO0VBQ0EsaUVBQUE7RUFDQSxrRUFBQTtFQUNBLDJDQUFBO0FBUlI7QUFXTTtFQUNFLDZDQUFBO0VBQ0Esa0ZBQUE7RUFDQSw0REFBQTtFQUNBLGtCQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtBQVRSO0FBZUk7RUFDRSxhQUFBO0VBQ0EsYUFBQTtFQUNBLHFDQUFBO0VBQ0EsU0FBQTtFQUNBLGdCQUFBO0FBYk47QUFnQkk7RUFDRSxhQUFBO0VBQ0EsWUFBQTtFQUNBLHNCQUFBO0VBQ0EsMkVBQUE7RUFDQSxzQkFBQTtFQUNBLDJDQUFBO0VBQ0Esa0JBQUE7QUFkTjtBQWlCSTtFQUNFLG1CQUFBO0VBQ0Esc0JBQUE7RUFDQSwyRUFBQTtFQUNBLHNCQUFBO0VBQ0EsMkNBQUE7RUFDQSxrQkFBQTtBQWZOO0FBaUJJO0VBQ0U7SUFDRSwyQkFBQTtFQWZOO0VBaUJJO0lBRUUsMEJBQUE7RUFoQk47QUFDRjtBQW9CRTtFQUNFLG9CQUFBO0VBQ0Esa0JBQUE7RUFDQSxZQUFBO0FBbEJKIiwic291cmNlc0NvbnRlbnQiOlsiOmhvc3Qge1xuICAtLWhlaWdodC1oZWFkZXI6IDU2cHg7XG5cbiAgaW9uLXRvb2xiYXIge1xuICAgIC0tYm9yZGVyLXdpZHRoOiAwICFpbXBvcnRhbnQ7XG4gICAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbiAgfVxuXG4gIGlvbi1jb250ZW50IHtcbiAgICAtLXBhZGRpbmctYm90dG9tOiAwICFpbXBvcnRhbnQ7XG4gIH1cblxuICBpb24tYmFjay1idXR0b24ge1xuICAgIC0tY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICB9XG5cbiAgbWFnLXRhYnMge1xuICAgIHdoaXRlLXNwYWNlOiBub3dyYXA7XG4gIH1cblxuICAudGl0bGUge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCBMZXhlbmQpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG4gIH1cblxuICAuYmFubmVyIHtcbiAgICBwYWRkaW5nOiAwcHggdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KSB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpIHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIH1cblxuICAuY29udGFpbmVyIHtcbiAgICBoZWlnaHQ6IGNhbGMoMTAwJSAtIHZhcigtLWhlaWdodC1oZWFkZXIpKTtcbiAgICBvdmVyZmxvdy15OiBhdXRvO1xuICAgIG92ZXJmbG93LXg6IGhpZGRlbjtcbiAgICBwYWRkaW5nLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcblxuICAgIC53aWRnZXQtbGF5b3V0IHtcbiAgICAgIHBhZGRpbmc6IDAgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgICB9XG5cbiAgICAubm90LWZvdW5kIHtcbiAgICAgIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCkgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KSB2YXIoLS1tYWctc3BhY2luZy0xMDAwLCA4MHB4KVxuICAgICAgICB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuXG4gICAgICAmX19pbWFnZSB7XG4gICAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgICBoZWlnaHQ6IDEwMCU7XG4gICAgICAgIG9iamVjdC1maXQ6IGNvdmVyO1xuICAgICAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0xNTAsIDEycHgpO1xuICAgICAgfVxuXG4gICAgICAmX190aXRsZSB7XG4gICAgICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICAgICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCBMZXhlbmQsIEFyaWFsLCBzYW5zLXNlcmlmKTtcbiAgICAgICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LWxhcmdlLWZvbnQtc2l6ZSwgMzJweCk7XG4gICAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRpc3BsYXktbGFyZ2UtZm9udC13ZWlnaHQsIDYwMCk7XG4gICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LWxhcmdlLWxpbmUtaGVpZ2h0LCA0MHB4KTtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgICAgIH1cblxuICAgICAgJl9fZGVzY3JpcHRpb24ge1xuICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kLCBBcmlhbCwgc2Fucy1zZXJpZik7XG4gICAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICAuc2tlbGV0b24ge1xuICAgICYtZ3JpZCB7XG4gICAgICBwYWRkaW5nOiAxMHB4O1xuICAgICAgZGlzcGxheTogZ3JpZDtcbiAgICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogcmVwZWF0KDIsIDFmcik7XG4gICAgICBnYXA6IDEwcHg7XG4gICAgICBvdmVyZmxvdzogaGlkZGVuO1xuICAgIH1cblxuICAgICYtYmFubmVyIHtcbiAgICAgIGhlaWdodDogMTUwcHg7XG4gICAgICBtYXJnaW46IDEwcHg7XG4gICAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGRkO1xuICAgICAgYmFja2dyb3VuZC1pbWFnZTogbGluZWFyLWdyYWRpZW50KDkwZGVnLCAjZGRkIDBweCwgI2U4ZThlOCA0MHB4LCAjZGRkIDgwcHgpO1xuICAgICAgYmFja2dyb3VuZC1zaXplOiA2MDBweDtcbiAgICAgIGFuaW1hdGlvbjogc2hpbmUtbGluZXMgMS42cyBpbmZpbml0ZSBsaW5lYXI7XG4gICAgICBib3JkZXItcmFkaXVzOiA4cHg7XG4gICAgfVxuXG4gICAgJi1wcm9kdWN0IHtcbiAgICAgIGFzcGVjdC1yYXRpbzogMSAvIDEuNTtcbiAgICAgIGJhY2tncm91bmQtY29sb3I6ICNkZGQ7XG4gICAgICBiYWNrZ3JvdW5kLWltYWdlOiBsaW5lYXItZ3JhZGllbnQoOTBkZWcsICNkZGQgMHB4LCAjZThlOGU4IDQwcHgsICNkZGQgODBweCk7XG4gICAgICBiYWNrZ3JvdW5kLXNpemU6IDYwMHB4O1xuICAgICAgYW5pbWF0aW9uOiBzaGluZS1saW5lcyAxLjZzIGluZmluaXRlIGxpbmVhcjtcbiAgICAgIGJvcmRlci1yYWRpdXM6IDhweDtcbiAgICB9XG4gICAgQGtleWZyYW1lcyBzaGluZS1saW5lcyB7XG4gICAgICAwJSB7XG4gICAgICAgIGJhY2tncm91bmQtcG9zaXRpb246IC0xMDBweDtcbiAgICAgIH1cbiAgICAgIDQwJSxcbiAgICAgIDEwMCUge1xuICAgICAgICBiYWNrZ3JvdW5kLXBvc2l0aW9uOiAzNzVweDtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICAubG9hZGluZyB7XG4gICAgcG9pbnRlci1ldmVudHM6IG5vbmU7XG4gICAgLS1vdmVyZmxvdzogaGlkZGVuO1xuICAgIG9wYWNpdHk6IDAuNTtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 33991:
/*!********************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/weekly-ad/pages/weekly-all-ads/weekly-all-ads.component.ts ***!
  \********************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   WeeklyAllAdsComponent: () => (/* binding */ WeeklyAllAdsComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ionic/angular */ 78205);





class WeeklyAllAdsComponent {
  router;
  navCtrl;
  slug;
  constructor(router, navCtrl) {
    this.router = router;
    this.navCtrl = navCtrl;
  }
  ngOnInit() {
    this.slug = this.router.url.split('?')[0];
  }
  backToHome() {
    this.navCtrl.navigateRoot('/tabs/home', {
      replaceUrl: true
    });
  }
  static ɵfac = function WeeklyAllAdsComponent_Factory(t) {
    return new (t || WeeklyAllAdsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_2__.NavController));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
    type: WeeklyAllAdsComponent,
    selectors: [["weekly-all-ads"]],
    decls: 0,
    vars: 0,
    template: function WeeklyAllAdsComponent_Template(rf, ctx) {},
    styles: ["/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 40541:
/*!**************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/weekly-ad/pages/weekly-flyer-view/weekly-flyer-view.component.ts ***!
  \**************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   WeeklyFlyerViewComponent: () => (/* binding */ WeeklyFlyerViewComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);






function WeeklyFlyerViewComponent_div_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("innerHtml", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](1, 1, ctx_r0.magDigitalCircularInnerHtml), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsanitizeHtml"]);
  }
}
class WeeklyFlyerViewComponent {
  cStore;
  store;
  magDigitalCircularInnerHtml = '';
  constructor(cStore) {
    this.cStore = cStore;
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.store = yield _this.cStore.getStore();
      _this.magDigitalCircularInnerHtml = `<mag-digital-circular store-code="${_this.store?.StoreCode}"></mag-digital-circular>`;
    })();
  }
  static ɵfac = function WeeklyFlyerViewComponent_Factory(t) {
    return new (t || WeeklyFlyerViewComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_1__.CurrentStore));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: WeeklyFlyerViewComponent,
    selectors: [["weekly-flyer-view"]],
    decls: 1,
    vars: 1,
    consts: [[3, "innerHtml", 4, "ngIf"], [3, "innerHtml"]],
    template: function WeeklyFlyerViewComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](0, WeeklyFlyerViewComponent_div_0_Template, 2, 3, "div", 0);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", ctx.magDigitalCircularInnerHtml);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__.SafeHtmlPipe],
    styles: ["/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 69893:
/*!******************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/weekly-ad/pages/weekly-product-view/weekly-product-view.component.ts ***!
  \******************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   WeeklyProductViewComponent: () => (/* binding */ WeeklyProductViewComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);

class WeeklyProductViewComponent {
  static ɵfac = function WeeklyProductViewComponent_Factory(t) {
    return new (t || WeeklyProductViewComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
    type: WeeklyProductViewComponent,
    selectors: [["weekly-product-view"]],
    decls: 2,
    vars: 0,
    consts: [[1, "product-view"]],
    template: function WeeklyProductViewComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "mag-product-view-page");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
      }
    },
    styles: [".product-view[_ngcontent-%COMP%] {\n  padding-left: var(--mag-spacing-200, 16px);\n  padding-right: var(--mag-spacing-200, 16px);\n}\n\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3dlZWtseS1hZC9wYWdlcy93ZWVrbHktcHJvZHVjdC12aWV3L3dlZWtseS1wcm9kdWN0LXZpZXcuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLDBDQUEwQztFQUMxQywyQ0FBMkM7QUFDN0MiLCJzb3VyY2VzQ29udGVudCI6WyIucHJvZHVjdC12aWV3IHtcbiAgcGFkZGluZy1sZWZ0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBwYWRkaW5nLXJpZ2h0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 34880:
/*!***********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/weekly-ad/weekly-ad-routing.module.ts ***!
  \***********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   WeeklyAdRoutingModule: () => (/* binding */ WeeklyAdRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _pages_weekly_ad_page_weekly_ad_page_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/weekly-ad-page/weekly-ad-page.component */ 31105);
/* harmony import */ var _weekly_ad_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./weekly-ad.module */ 2449);
/* harmony import */ var _pages_weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/weekly-all-ads/weekly-all-ads.component */ 33991);
/* harmony import */ var _pages_weekly_product_view_weekly_product_view_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/weekly-product-view/weekly-product-view.component */ 69893);
/* harmony import */ var _pages_weekly_flyer_view_weekly_flyer_view_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/weekly-flyer-view/weekly-flyer-view.component */ 40541);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);








const routes = [{
  path: '',
  component: _pages_weekly_ad_page_weekly_ad_page_component__WEBPACK_IMPORTED_MODULE_0__.WeeklyAdPageComponent,
  children: [{
    path: '',
    redirectTo: 'flyer-view',
    pathMatch: 'full'
  }, {
    path: 'flyer-view',
    component: _pages_weekly_flyer_view_weekly_flyer_view_component__WEBPACK_IMPORTED_MODULE_4__.WeeklyFlyerViewComponent
  }, {
    path: 'product-view',
    component: _pages_weekly_product_view_weekly_product_view_component__WEBPACK_IMPORTED_MODULE_3__.WeeklyProductViewComponent
  }, {
    path: 'all-ads',
    component: _pages_weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_2__.WeeklyAllAdsComponent
  }]
}];
class WeeklyAdRoutingModule {
  static ɵfac = function WeeklyAdRoutingModule_Factory(t) {
    return new (t || WeeklyAdRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineNgModule"]({
    type: WeeklyAdRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule.forChild(routes), _weekly_ad_module__WEBPACK_IMPORTED_MODULE_1__.WeeklyAdModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsetNgModuleScope"](WeeklyAdRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _weekly_ad_module__WEBPACK_IMPORTED_MODULE_1__.WeeklyAdModule]
  });
})();

/***/ }),

/***/ 2449:
/*!***************************************************************!*\
  !*** ./src/app/modules/ecom-v2/weekly-ad/weekly-ad.module.ts ***!
  \***************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   WeeklyAdModule: () => (/* binding */ WeeklyAdModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/utils.module */ 50777);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _pages_weekly_ad_page_weekly_ad_page_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/weekly-ad-page/weekly-ad-page.component */ 31105);
/* harmony import */ var _pages_weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/weekly-all-ads/weekly-all-ads.component */ 33991);
/* harmony import */ var _pages_weekly_product_view_weekly_product_view_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/weekly-product-view/weekly-product-view.component */ 69893);
/* harmony import */ var _pages_weekly_flyer_view_weekly_flyer_view_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/weekly-flyer-view/weekly-flyer-view.component */ 40541);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/core */ 37580);













class WeeklyAdModule {
  static ɵfac = function WeeklyAdModule_Factory(t) {
    return new (t || WeeklyAdModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineNgModule"]({
    type: WeeklyAdModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_7__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_10__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_11__.RouterModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_12__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_5__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵsetNgModuleScope"](WeeklyAdModule, {
    declarations: [_pages_weekly_ad_page_weekly_ad_page_component__WEBPACK_IMPORTED_MODULE_1__.WeeklyAdPageComponent, _pages_weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_2__.WeeklyAllAdsComponent, _pages_weekly_product_view_weekly_product_view_component__WEBPACK_IMPORTED_MODULE_3__.WeeklyProductViewComponent, _pages_weekly_flyer_view_weekly_flyer_view_component__WEBPACK_IMPORTED_MODULE_4__.WeeklyFlyerViewComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_7__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_10__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_11__.RouterModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_12__.TranslateModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_5__.HeaderComponentModule],
    exports: [_pages_weekly_ad_page_weekly_ad_page_component__WEBPACK_IMPORTED_MODULE_1__.WeeklyAdPageComponent, _pages_weekly_all_ads_weekly_all_ads_component__WEBPACK_IMPORTED_MODULE_2__.WeeklyAllAdsComponent]
  });
})();

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_weekly-ad_weekly-ad-routing_module_ts.js.map