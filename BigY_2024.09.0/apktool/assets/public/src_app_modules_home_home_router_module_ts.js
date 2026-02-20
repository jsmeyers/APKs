"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_home_home_router_module_ts"],{

/***/ 76269:
/*!*********************************************!*\
  !*** ./src/app/modules/home/home.module.ts ***!
  \*********************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   HomeModule: () => (/* binding */ HomeModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../account-v2/providers/user.service */ 51074);
/* harmony import */ var _header_header_component_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../header/header.component.module */ 88770);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../utils/utils.module */ 50777);
/* harmony import */ var _pages_home_home__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/home/home */ 74522);
/* harmony import */ var _rsApp_components_shared_component_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/components/shared.component.module */ 67249);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);





// import { CmsService } from '../dashboard/providers/cms.service';





class HomeModule {
  static ɵfac = function HomeModule_Factory(t) {
    return new (t || HomeModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineNgModule"]({
    type: HomeModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_6__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_1__.HeaderComponentModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.FormsModule, _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_0__.UserServiceModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule, _rsApp_components_shared_component_module__WEBPACK_IMPORTED_MODULE_4__.SharedComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsetNgModuleScope"](HomeModule, {
    declarations: [_pages_home_home__WEBPACK_IMPORTED_MODULE_3__.HomePageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_6__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_7__.IonicModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_1__.HeaderComponentModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.FormsModule, _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_0__.UserServiceModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__.TranslateModule, _rsApp_components_shared_component_module__WEBPACK_IMPORTED_MODULE_4__.SharedComponentModule]
  });
})();

/***/ }),

/***/ 79308:
/*!****************************************************!*\
  !*** ./src/app/modules/home/home.router.module.ts ***!
  \****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   HomePageRoutingModule: () => (/* binding */ HomePageRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _pages_home_home__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/home/home */ 74522);
/* harmony import */ var _home_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./home.module */ 76269);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);





const routes = [{
  path: '',
  component: _pages_home_home__WEBPACK_IMPORTED_MODULE_0__.HomePageComponent
}];
class HomePageRoutingModule {
  static ɵfac = function HomePageRoutingModule_Factory(t) {
    return new (t || HomePageRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
    type: HomePageRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule.forChild(routes), _home_module__WEBPACK_IMPORTED_MODULE_1__.HomeModule, _angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](HomePageRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule, _home_module__WEBPACK_IMPORTED_MODULE_1__.HomeModule],
    exports: [_angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterModule]
  });
})();

/***/ }),

/***/ 74522:
/*!*************************************************!*\
  !*** ./src/app/modules/home/pages/home/home.ts ***!
  \*************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   HomePageComponent: () => (/* binding */ HomePageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _rsApp_components_mag_app_dialog_mag_app_dialog__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../components/mag-app-dialog/mag-app-dialog */ 37414);
/* harmony import */ var _rsApp_components_mag_confirm_modal_mag_modal_confirm__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/components/mag-confirm-modal/mag-modal-confirm */ 95672);
/* harmony import */ var _rsApp_modules_auth_v2_providers_auth_v2_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/auth-v2.service */ 19683);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @rsApp/modules/utils/enum/enum */ 24457);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _rsApp_modules_utils_providers_rs_tracker_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @rsApp/modules/utils/providers/rs-tracker.service */ 32980);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_11___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_11__);
/* harmony import */ var _rsApp_modules_utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _rsApp_modules_utils_components_skeletons_home_home_skeleton_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../utils/components/skeletons/home/home-skeleton.component */ 77098);
/* harmony import */ var _rsApp_modules_utils_providers_performance_logger_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @rsApp/modules/utils/providers/performance-logger.service */ 5159);
/* harmony import */ var _rsApp_modules_utils_providers_widget_prerender_service__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @rsApp/modules/utils/providers/widget-prerender.service */ 81894);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var ionic_cache__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ionic-cache */ 65503);
/* harmony import */ var _pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @pscoped/ngx-pub-sub */ 2055);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../header/header.component */ 55074);
/* harmony import */ var _components_mag_content_block_modal_mag_content_block_modal__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../../components/mag-content-block-modal/mag-content-block-modal */ 68512);











// import { CmsService } from '@rsApp/modules/dashboard/providers/cms.service';































const _c0 = ["slides"];
const _c1 = ["dialogThanksModal"];
const _c2 = ["dialogCheckPhoneModal"];
function HomePageComponent_ion_row_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-row", 11)(1, "ion-col", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](2, "pickup-widget");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
}
class HomePageComponent {
  utils;
  auth;
  cStore;
  modalCtrl;
  router;
  route;
  cache;
  navCtrl;
  appSettings;
  tracker;
  events;
  cre;
  translate;
  perfLogger;
  widgetPrerenderService;
  currentUser;
  currentStore;
  innerHTML = '';
  receiveTextMessage = false;
  receiveEmail = false;
  subscriptions = [];
  slides;
  widgetLayouts;
  homeSkeleton;
  skeletonHidden = false;
  slideOpts = {
    initialSlide: 1,
    speed: 400,
    autoplay: {
      delay: 5000
    }
  };
  returnRoute;
  displayOnlineOrderBanner;
  eventSubscription;
  dialogThanksModal;
  dialogCheckPhoneModal;
  constructor(utils, auth, cStore, modalCtrl, router, route, cache, navCtrl, appSettings, tracker, events, cre, translate, perfLogger, widgetPrerenderService) {
    this.utils = utils;
    this.auth = auth;
    this.cStore = cStore;
    this.modalCtrl = modalCtrl;
    this.router = router;
    this.route = route;
    this.cache = cache;
    this.navCtrl = navCtrl;
    this.appSettings = appSettings;
    this.tracker = tracker;
    this.events = events;
    this.cre = cre;
    this.translate = translate;
    this.perfLogger = perfLogger;
    this.widgetPrerenderService = widgetPrerenderService;
    this.perfLogger.mark('HOME_COMPONENT_CONSTRUCTOR');
    const params = this.route.snapshot.paramMap;
    this.returnRoute = params.get('returnRoute');
    this.subscriptions.push(this.cStore.storeState().subscribe(store => {
      this.currentStore = store;
    }));
    const {
      receiveEmail,
      receiveTextMessage
    } = this.route.snapshot.data.extrasStateResolver;
    this.receiveEmail = receiveEmail ?? false;
    this.receiveTextMessage = receiveTextMessage ?? false;
    // Reset state after get it
    history.replaceState({}, '', this.router.url);
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.perfLogger.mark('HOME_VIEW_WILL_ENTER');
      _this.trackPage();
      _this.events.publishEvent('reload-timeslot');
      _this.events.publishEvent('reload-widget');
      _this.displayOnlineOrderBanner = _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.OnlineOrderEnabled;
    })();
  }
  doRefresh(event) {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.perfLogger.log('🔄 Pull to refresh triggered');
      try {
        // Show skeleton during refresh
        if (_this2.homeSkeleton) {
          _this2.skeletonHidden = false;
          _this2.homeSkeleton.show();
          _this2.perfLogger.log('💀 Skeleton shown for refresh');
        }
        // Reload widgets by publishing reload event
        _this2.events.publishEvent('reload-widget');
        // Reload timeslot data
        _this2.events.publishEvent('reload-timeslot');
        event.target.complete();
        // Refresh all widget-layout components
        const widgets = _this2.widgetLayouts.toArray();
        if (widgets.length > 0) {
          _this2.perfLogger.log(`🔄 Refreshing ${widgets.length} widget-layout components`);
          // Set up a promise to wait for the first widget to be ready
          const firstWidgetReady = new Promise(resolve => {
            let resolved = false;
            widgets.forEach(widget => {
              widget.widgetReady.subscribe(() => {
                if (!resolved) {
                  resolved = true;
                  resolve();
                }
              });
            });
            // Fallback: resolve after 3 seconds if no widget emits
            setTimeout(() => {
              if (!resolved) {
                resolved = true;
                resolve();
              }
            }, 3000);
          });
          // Start refreshing all widgets
          const refreshPromises = widgets.map(widget => widget.refresh());
          // Wait for refresh to complete and first widget to be ready
          yield Promise.all([...refreshPromises, firstWidgetReady]);
          _this2.perfLogger.log('✅ All widgets refreshed');
        }
        // Hide skeleton after widgets are ready
        if (_this2.homeSkeleton && !_this2.skeletonHidden) {
          _this2.homeSkeleton.hide();
          _this2.skeletonHidden = true;
          _this2.perfLogger.log('💀 Skeleton hidden after refresh');
        }
        // Complete the refresh
        event.target.complete();
        _this2.perfLogger.log('✅ Pull to refresh completed');
      } catch (error) {
        console.error('Error during refresh:', error);
        _this2.perfLogger.log('❌ Error during refresh', error);
        // Hide skeleton even on error
        if (_this2.homeSkeleton && !_this2.skeletonHidden) {
          _this2.homeSkeleton.hide();
          _this2.skeletonHidden = true;
        }
      }
    })();
  }
  ngAfterViewInit() {
    this.perfLogger.mark('HOME_AFTER_VIEW_INIT');
    // Wait for widget layouts to be available
    setTimeout(() => {
      this.setupWidgetTracking();
      // Also listen for changes in the widget list
      this.widgetLayouts.changes.subscribe(() => {
        this.setupWidgetTracking();
      });
    }, 150);
  }
  setupWidgetTracking() {
    const widgets = this.widgetLayouts.toArray();
    this.perfLogger.log(`🔍 Found ${widgets.length} widget-layout components`);
    if (widgets.length === 0) {
      // No widgets, hide skeleton immediately
      if (this.homeSkeleton && !this.skeletonHidden) {
        this.perfLogger.log('⚠️ No widgets found, hiding skeleton immediately');
        this.homeSkeleton.hide();
        this.skeletonHidden = true;
      }
      return;
    }
    // Subscribe to the first widget's ready event
    widgets.forEach((widget, index) => {
      widget.widgetReady.subscribe(() => {
        this.perfLogger.log(`✅ Widget ${index + 1} ready`);
        // Hide skeleton as soon as first widget is ready
        if (this.homeSkeleton && !this.skeletonHidden) {
          setTimeout(() => {
            this.perfLogger.mark('FIRST_WIDGET_READY');
            this.perfLogger.log('🎉 Hiding skeleton - first widget loaded');
            this.homeSkeleton.hide();
            this.skeletonHidden = true;
          }, 500);
        }
      });
    });
  }
  ionViewDidEnter() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this3.perfLogger.mark('HOME_VIEW_DID_ENTER');
      _this3.perfLogger.printSummary('HOME_VIEW_DID_ENTER');
      if (_this3.receiveTextMessage) {
        _this3.dialogCheckPhoneModal.openDialog();
      } else if (_this3.receiveEmail) {
        _this3.dialogThanksModal.openDialog();
      }
      if (_this3.currentUser) {
        customElements.whenDefined('dxp-notification-icon').then(() => {
          _this3.innerHTML = '<dxp-notification-icon theme="dark" path="/notification"></dxp-notification-icon>';
        });
      }
      _this3.widgetPrerenderService.clearPrerenderStencilComponent();
    })();
  }
  ngOnDestroy() {
    lodash__WEBPACK_IMPORTED_MODULE_11___default().each(this.subscriptions, s => {
      s.unsubscribe();
    });
    if (this.eventSubscription) {
      this.eventSubscription.unsubscribe();
    }
  }
  onCloseModalThanksSubscribing() {
    this.receiveEmail = false;
    this.dialogThanksModal.closeDialog();
  }
  onCloseModalCheckPhone() {
    this.receiveTextMessage = false;
    this.dialogCheckPhoneModal.closeDialog();
  }
  onNavigateWeeklyAds() {
    this.onCloseModalThanksSubscribing();
    setTimeout(() => {
      this.router.navigate(['/tabs/weekly-ad']);
    }, 0);
  }
  chooseStorePage() {
    const cri = {
      keyword: '',
      size: 3
    };
    this.cache.saveItem('store-search-params', cri);
    this.cache.saveItem('store-back', {
      route: ['/tabs/home'],
      key: 'selected-store'
    }, 'store');
    // Using navigateRoot for refresh home page data
    this.navCtrl.navigateRoot(['/store/near', {
      type: 'chooseStore',
      returnRoute: 'tabs/home'
    }]);
  }
  goSlider(slider) {
    if (slider.SliderType === 'EndCap') {
      this.router.navigate(['/tabs/products/product-encap', {
        sliderId: slider.Id,
        sliderTitle: slider.Title
      }]);
    } else {
      if (slider.Link.search('app://') !== -1) {
        const pageName = lodash__WEBPACK_IMPORTED_MODULE_11___default().replace(slider.Link, 'app://', '');
        this.router.navigateByUrl(pageName);
      } else if (slider.Link.search(_app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.URLSCHEME) !== -1) {
        // deprecate
        const pageName = lodash__WEBPACK_IMPORTED_MODULE_11___default().replace(slider.Link, _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.URLSCHEME + '//', '');
        this.router.navigate([pageName]);
      } else {
        if (slider.Link && this.utils.validURL(slider.Link)) {
          if (this.currentUser) {
            if (slider.LinkOut) {
              // window.open(slider.Link, '_system', '');
              this.utils.openInSystem(slider.Link);
            } else {
              this.utils.openInaAppBrowser(slider.Link);
            }
          } else {
            if (slider.SignOutLinkOut) {
              // window.open(slider.Link, '_system', '');
              this.utils.openInSystem(slider.SignOutLink);
            } else {
              this.utils.openInaAppBrowser(slider.SignOutLink);
            }
          }
        }
      }
    }
  }
  onIonSlidesDidLoad(slider) {
    slider.startAutoplay();
  }
  trackPage() {
    this.events.publishEvent(_rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_7__.enumTrackAction.OnChangeSystemService, {
      systemServiceName: this.currentStore?.ShopPath
    });
  }
  viewMoreStore() {
    if (this.returnRoute) {
      this.router.navigate(['/store/find', {
        router: this.returnRoute
      }]);
    } else {
      this.router.navigate(['/store/find']);
    }
  }
  getPageName() {
    return 'HomePage';
  }
  openSubscriptionNotAppliedModal() {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const modal = yield _this4.modalCtrl.create({
        component: _rsApp_components_mag_confirm_modal_mag_modal_confirm__WEBPACK_IMPORTED_MODULE_3__.MagModalConfirmComponent,
        componentProps: {
          title: _this4.translate.instant('subscriptions.subscriptionNotApplied.title'),
          description: _this4.translate.instant('subscriptions.subscriptionNotApplied.content'),
          confirmTitle: _this4.translate.instant('subscriptions.subscriptionNotApplied.primaryButtonText'),
          cancelTitle: _this4.translate.instant('subscriptions.subscriptionNotApplied.secondaryButtonText')
        },
        cssClass: 'mag-confirm-modal'
      });
      modal.onDidDismiss().then(/*#__PURE__*/function () {
        var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (result) {
          if (result.data) {
            _this4.router.navigate(['/tabs/my-account'], {
              state: {
                openPreferencesOnInit: true
              }
            });
          }
        });
        return function (_x) {
          return _ref.apply(this, arguments);
        };
      }());
      yield modal.present();
    })();
  }
  static ɵfac = function HomePageComponent_Factory(t) {
    return new (t || HomePageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_10__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_auth_v2_service__WEBPACK_IMPORTED_MODULE_4__.AuthService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_6__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_19__.ModalController), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_20__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_20__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](ionic_cache__WEBPACK_IMPORTED_MODULE_21__.CacheService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_22__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_8__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_rs_tracker_service__WEBPACK_IMPORTED_MODULE_9__.RSTracker), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_23__.NgxPubSubService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_5__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_24__.TranslateService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_performance_logger_service__WEBPACK_IMPORTED_MODULE_14__.PerformanceLoggerService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_widget_prerender_service__WEBPACK_IMPORTED_MODULE_15__.WidgetPrerenderService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdefineComponent"]({
    type: HomePageComponent,
    selectors: [["home-page"]],
    viewQuery: function HomePageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_c0, 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_rsApp_modules_utils_components_skeletons_home_home_skeleton_component__WEBPACK_IMPORTED_MODULE_13__.HomeSkeletonComponent, 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_c1, 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_c2, 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_rsApp_modules_utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_12__.WidgetLayoutComponent, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.slides = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.homeSkeleton = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.dialogThanksModal = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.dialogCheckPhoneModal = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.widgetLayouts = _t);
      }
    },
    decls: 29,
    vars: 25,
    consts: [["dialogThanksModal", ""], ["dialogCheckPhoneModal", ""], ["type", "home", "objectId", "home", "zoneName", "Sticky", 3, "slug"], ["type", "home", "objectId", "home", "zoneName", "Fixed Top", 3, "slug"], ["type", "home", "objectId", "home", "zoneName", "Fixed Center", 3, "slug"], [1, "outer-content"], ["slot", "fixed", 3, "ionRefresh"], ["pullingIcon", "arrow-down", "pullingText", "Pull to refresh", "refreshingSpinner", "circles", "refreshingText", "Refreshing..."], [3, "timeout"], [1, "home-menu", "ion-no-padding"], ["class", "item-widget", 4, "ngIf"], [1, "item-widget"], ["size", "12"], ["type", "home", "objectId", "home", "zoneName", "Top", 3, "slug"], ["type", "home", "objectId", "home", "zoneName", "Bottom", 3, "slug"], ["variant", "success", "iconType", "checkmark", 3, "primaryAction", "closeAction", "title", "description", "primaryButtonText"], ["variant", "warning", "iconType", "phone", 3, "primaryAction", "closeAction", "title", "description", "primaryButtonText"]],
    template: function HomePageComponent_Template(rf, ctx) {
      if (rf & 1) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 2)(1, "widget-layout", 3)(2, "widget-layout", 4)(3, "app-header");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "ion-content", 5)(5, "ion-refresher", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("ionRefresh", function HomePageComponent_Template_ion_refresher_ionRefresh_5_listener($event) {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.doRefresh($event));
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](6, "ion-refresher-content", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](7, "home-skeleton", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](8, "ion-grid", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](10, HomePageComponent_ion_row_10_Template, 3, 0, "ion-row", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](11, "ion-row", 11)(12, "ion-col", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](13, "widget-layout", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](14, "ion-row", 11)(15, "ion-col", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](16, "widget-layout", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](17, "mag-app-dialog", null, 0)(19, "mag-content-block-modal", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](20, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](21, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](22, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("primaryAction", function HomePageComponent_Template_mag_content_block_modal_primaryAction_19_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.onNavigateWeeklyAds());
        })("closeAction", function HomePageComponent_Template_mag_content_block_modal_closeAction_19_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.onCloseModalThanksSubscribing());
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](23, "mag-app-dialog", null, 1)(25, "mag-content-block-modal", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](26, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](27, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](28, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("primaryAction", function HomePageComponent_Template_mag_content_block_modal_primaryAction_25_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.onCloseModalCheckPhone());
        })("closeAction", function HomePageComponent_Template_mag_content_block_modal_closeAction_25_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.onCloseModalCheckPhone());
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("timeout", 1000);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.currentUser);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("title", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](20, 13, "notification.signUpSubscriptionThanks.title"))("description", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](21, 15, "notification.signUpSubscriptionThanks.description"))("primaryButtonText", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](22, 17, "notification.signUpSubscriptionThanks.primaryButtonText"));
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("title", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](26, 19, "notification.signUpSubscriptionPhone.title"))("description", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](27, 21, "notification.signUpSubscriptionPhone.description"))("primaryButtonText", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](28, 23, "notification.signUpSubscriptionPhone.primaryButtonText"));
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_25__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonCol, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonGrid, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonRefresher, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonRefresherContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonRow, _header_header_component__WEBPACK_IMPORTED_MODULE_16__.HeaderComponent, _rsApp_modules_utils_components_skeletons_home_home_skeleton_component__WEBPACK_IMPORTED_MODULE_13__.HomeSkeletonComponent, _rsApp_modules_utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_12__.WidgetLayoutComponent, _rsApp_components_mag_app_dialog_mag_app_dialog__WEBPACK_IMPORTED_MODULE_2__.MagAppDialogComponent, _components_mag_content_block_modal_mag_content_block_modal__WEBPACK_IMPORTED_MODULE_17__.MagContentBlockComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_24__.TranslatePipe],
    styles: ["home-page .outer-content {\n  --padding-start: 16px;\n  --padding-end: 16px;\n  --background: white;\n}\nhome-page .content-ios.outer-content {\n  background: var(--white);\n}\nhome-page .home-menu {\n  padding-top: 0 !important;\n}\nhome-page .home-menu .icon-header {\n  padding-top: 4px;\n}\nhome-page .home-menu .icon-header .icon-nav-badge {\n  font-weight: bold;\n  color: var(--grey-icon);\n}\nhome-page .home-menu .icon-header .nav-badge {\n  right: 0px;\n  position: absolute;\n  border-radius: 30px;\n  font-weight: normal;\n  background-color: var(--primary);\n}\nhome-page .home-menu .tab {\n  padding: 4px;\n}\nhome-page .home-menu .tab ion-row {\n  background-color: var(--white);\n  border-radius: 5px;\n}\nhome-page .home-menu .tab ion-row .col-label {\n  padding: 0px;\n}\nhome-page .home-menu .tab ion-row .tab-img {\n  display: inline-block;\n  min-width: 20px;\n  min-height: 20px;\n  background: transparent;\n  contain: strict;\n  width: 50px;\n  height: 50px;\n}\nhome-page .home-menu .tab ion-row .tab-lable {\n  margin: 5px 0;\n}\nhome-page .home-menu .store-info {\n  background-color: var(--grey-input);\n}\nhome-page .home-menu .store-info .custom-btn {\n  background-color: transparent;\n  width: 100%;\n  padding: 0;\n}\nhome-page .home-menu .store-info .custom-icon {\n  padding: 10px 10px 0 13px !important;\n}\nhome-page .home-menu .service-name-info {\n  color: var(--ion-color-tertiary);\n  display: block;\n  font-size: var(--dxp-fz);\n}\nhome-page .home-menu .make-a-list,\nhome-page .home-menu .making-a-list {\n  color: var(--primary) !important;\n}\nhome-page .home-menu .store-info-top {\n  background-color: white;\n}\nhome-page .home-menu .your-store-txt {\n  color: var(--ion-color-primary) !important;\n}\nhome-page .home-menu .right-store-info {\n  color: var(--ion-color-primary) !important;\n  font-size: 13px;\n  font-weight: 600;\n}\nhome-page .home-menu .store-info-line {\n  padding: 0;\n  margin: 0;\n  color: black;\n  height: 1px;\n}\nhome-page .home-menu .h-logo {\n  background-color: white;\n  padding-top: 5px;\n}\nhome-page .home-menu .h-logo ion-button {\n  color: var(--background-blue);\n}\nhome-page .home-menu .user-info {\n  background-color: var(--background-blue);\n}\nhome-page .home-menu .user-info .reward-img {\n  width: 130px;\n}\nhome-page .home-menu .user-info .no-mc-icon {\n  display: flex;\n  justify-content: flex-end;\n}\nhome-page .home-menu .img-barcode {\n  width: 54px;\n  height: auto;\n  contain: unset;\n  padding-top: 6px;\n  background-color: rgba(255, 255, 255, 0);\n}\nhome-page ion-slides {\n  height: auto;\n}\nhome-page ion-slides .img-container {\n  width: 100%;\n  height: 100%;\n}\nhome-page ion-slides .img-container img {\n  max-width: 100%;\n  width: auto;\n  height: auto;\n}\nhome-page .swiper-slide {\n  display: block;\n}\nhome-page .home-list .slider {\n  width: 100%;\n}\nhome-page .home-list .slider img {\n  width: 100%;\n}\nhome-page .home-list .border {\n  border-bottom: 1px solid #e4e4e6;\n  padding: 0;\n}\nhome-page .home-list .custom-btn {\n  background-color: rgba(255, 255, 255, 0);\n  width: 100%;\n}\nhome-page .home-list .custom-btn .custom-lable {\n  margin: 0px;\n  font-size: 19px !important;\n}\nhome-page .btn {\n  width: 125px;\n  height: 40px;\n}\nhome-page .custom-display-center {\n  display: flex;\n  align-items: center;\n  padding: 10px !important;\n}\nhome-page .logo-store {\n  min-width: 120px;\n  height: 50px;\n}\nhome-page .logo-store img {\n  min-width: 120px;\n  height: 50px;\n}\nhome-page .logo-store.filter {\n  filter: brightness(0) invert(1);\n}\nhome-page .item-widget {\n  background-color: white;\n}\nhome-page .item-widget ion-col {\n  min-height: 0;\n}\nhome-page .message-center-group ion-item {\n  --padding-start: 10px;\n}\nhome-page .message-center-group .dxp-notification-icon {\n  --padding-vertical-icon: 0px;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9ob21lL3BhZ2VzL2hvbWUvaG9tZS5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQVNFO0VBQ0UscUJBQUE7RUFDQSxtQkFBQTtFQUNBLG1CQUFBO0FBUko7QUFXRTtFQUNFLHdCQUFBO0FBVEo7QUFZRTtFQUVFLHlCQUFBO0FBWEo7QUFhSTtFQUNFLGdCQUFBO0FBWE47QUFhTTtFQUNFLGlCQUFBO0VBQ0EsdUJBQUE7QUFYUjtBQWNNO0VBQ0UsVUFBQTtFQUNBLGtCQUFBO0VBQ0EsbUJBQUE7RUFDQSxtQkFBQTtFQUNBLGdDQUFBO0FBWlI7QUFnQkk7RUFDRSxZQUFBO0FBZE47QUFnQk07RUFDRSw4QkFBQTtFQUNBLGtCQUFBO0FBZFI7QUFnQlE7RUFDRSxZQUFBO0FBZFY7QUFpQlE7RUFDRSxxQkFBQTtFQUNBLGVBQUE7RUFDQSxnQkFBQTtFQUNBLHVCQUFBO0VBQ0EsZUFBQTtFQUNBLFdBQUE7RUFDQSxZQUFBO0FBZlY7QUFrQlE7RUFDRSxhQUFBO0FBaEJWO0FBeUNJO0VBQ0UsbUNBQUE7QUF2Q047QUF5Q007RUFDRSw2QkFBQTtFQUNBLFdBQUE7RUFDQSxVQUFBO0FBdkNSO0FBMENNO0VBQ0Usb0NBQUE7QUF4Q1I7QUE0Q0k7RUFDRSxnQ0FBQTtFQUNBLGNBQUE7RUFDQSx3QkFBQTtBQTFDTjtBQTZDSTs7RUFFRSxnQ0FBQTtBQTNDTjtBQThDSTtFQUNFLHVCQUFBO0FBNUNOO0FBK0NJO0VBQ0UsMENBQUE7QUE3Q047QUFnREk7RUFDRSwwQ0FBQTtFQUNBLGVBQUE7RUFDQSxnQkFBQTtBQTlDTjtBQWlESTtFQUNFLFVBQUE7RUFDQSxTQUFBO0VBQ0EsWUFBQTtFQUNBLFdBQUE7QUEvQ047QUFrREk7RUFDRSx1QkFBQTtFQUNBLGdCQUFBO0FBaEROO0FBa0RNO0VBQ0UsNkJBQUE7QUFoRFI7QUFvREk7RUFDRSx3Q0FBQTtBQWxETjtBQW9ETTtFQUNFLFlBQUE7QUFsRFI7QUFxRE07RUFDRSxhQUFBO0VBQ0EseUJBQUE7QUFuRFI7QUF1REk7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLGNBQUE7RUFDQSxnQkFBQTtFQUNBLHdDQUFBO0FBckROO0FBeURFO0VBQ0UsWUFBQTtBQXZESjtBQTBESTtFQUNFLFdBQUE7RUFDQSxZQUFBO0FBeEROO0FBOERNO0VBRUUsZUFBQTtFQUNBLFdBQUE7RUFDQSxZQUFBO0FBN0RSO0FBa0VFO0VBQ0UsY0FBQTtBQWhFSjtBQW9FSTtFQUNFLFdBQUE7QUFsRU47QUFxRU07RUFDRSxXQUFBO0FBbkVSO0FBdUVJO0VBQ0UsZ0NBQUE7RUFDQSxVQUFBO0FBckVOO0FBd0VJO0VBQ0Usd0NBQUE7RUFDQSxXQUFBO0FBdEVOO0FBd0VNO0VBQ0UsV0FBQTtFQUNBLDBCQUFBO0FBdEVSO0FBMkVFO0VBQ0UsWUFBQTtFQUNBLFlBQUE7QUF6RUo7QUE0RUU7RUFDRSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSx3QkFBQTtBQTFFSjtBQTZFRTtFQUNFLGdCQUFBO0VBQ0EsWUFBQTtBQTNFSjtBQTZFSTtFQUNFLGdCQUFBO0VBQ0EsWUFBQTtBQTNFTjtBQThFSTtFQUNFLCtCQUFBO0FBNUVOO0FBZ0ZFO0VBQ0UsdUJBQUE7QUE5RUo7QUFnRkk7RUFDRSxhQUFBO0FBOUVOO0FBbUZJO0VBQ0UscUJBQUE7QUFqRk47QUFvRkk7RUFDRSw0QkFBQTtBQWxGTiIsInNvdXJjZXNDb250ZW50IjpbImhvbWUtcGFnZSB7XG4gIC8vRml4IHBhZGRpbmcgaXBob25lIG5vdGNoIHhcbiAgLy8gcGFkZGluZy10b3A6IGNvbnN0YW50KC0taW9uLXNhZmUtYXJlYS10b3ApO1xuICAvLyBwYWRkaW5nLXRvcDogZW52KC0taW9uLXNhZmUtYXJlYS10b3ApO1xuICAvLyBwYWRkaW5nLXRvcDogdmFyKC0taW9uLXNhZmUtYXJlYS10b3AsMCk7XG5cbiAgLy8gaW9uLWNvbnRlbnR7XG4gIC8vICAgICAtLXBhZGRpbmctYm90dG9tOiAwO1xuICAvLyB9XG4gIC5vdXRlci1jb250ZW50IHtcbiAgICAtLXBhZGRpbmctc3RhcnQ6IDE2cHg7XG4gICAgLS1wYWRkaW5nLWVuZDogMTZweDtcbiAgICAtLWJhY2tncm91bmQ6IHdoaXRlO1xuICB9XG5cbiAgLmNvbnRlbnQtaW9zLm91dGVyLWNvbnRlbnQge1xuICAgIGJhY2tncm91bmQ6IHZhcigtLXdoaXRlKTtcbiAgfVxuXG4gIC5ob21lLW1lbnUge1xuICAgIC8vIGJhY2tncm91bmQtY29sb3I6IHZhcigtLWJhY2tncm91bmQtYmx1ZSk7XG4gICAgcGFkZGluZy10b3A6IDAgIWltcG9ydGFudDtcblxuICAgIC5pY29uLWhlYWRlciB7XG4gICAgICBwYWRkaW5nLXRvcDogNHB4O1xuXG4gICAgICAuaWNvbi1uYXYtYmFkZ2Uge1xuICAgICAgICBmb250LXdlaWdodDogYm9sZDtcbiAgICAgICAgY29sb3I6IHZhcigtLWdyZXktaWNvbik7XG4gICAgICB9XG5cbiAgICAgIC5uYXYtYmFkZ2Uge1xuICAgICAgICByaWdodDogMHB4O1xuICAgICAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgICAgIGJvcmRlci1yYWRpdXM6IDMwcHg7XG4gICAgICAgIGZvbnQtd2VpZ2h0OiBub3JtYWw7XG4gICAgICAgIGJhY2tncm91bmQtY29sb3I6IHZhcigtLXByaW1hcnkpO1xuICAgICAgfVxuICAgIH1cblxuICAgIC50YWIge1xuICAgICAgcGFkZGluZzogNHB4O1xuXG4gICAgICBpb24tcm93IHtcbiAgICAgICAgYmFja2dyb3VuZC1jb2xvcjogdmFyKC0td2hpdGUpO1xuICAgICAgICBib3JkZXItcmFkaXVzOiA1cHg7XG5cbiAgICAgICAgLmNvbC1sYWJlbCB7XG4gICAgICAgICAgcGFkZGluZzogMHB4O1xuICAgICAgICB9XG5cbiAgICAgICAgLnRhYi1pbWcge1xuICAgICAgICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcbiAgICAgICAgICBtaW4td2lkdGg6IDIwcHg7XG4gICAgICAgICAgbWluLWhlaWdodDogMjBweDtcbiAgICAgICAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcbiAgICAgICAgICBjb250YWluOiBzdHJpY3Q7XG4gICAgICAgICAgd2lkdGg6IDUwcHg7XG4gICAgICAgICAgaGVpZ2h0OiA1MHB4O1xuICAgICAgICB9XG5cbiAgICAgICAgLnRhYi1sYWJsZSB7XG4gICAgICAgICAgbWFyZ2luOiA1cHggMDtcbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cblxuICAgIC8vIC5jdXN0b20tY29sLTEwe1xuICAgIC8vICAgICB3aWR0aDogODAlO1xuICAgIC8vICAgICBmbGV4OiA4MCU7XG4gICAgLy8gICAgIG1heC13aWR0aDogODAlO1xuICAgIC8vICAgICBpb24tc2VhcmNoYmFye1xuICAgIC8vICAgICAgICAgaGVpZ2h0OiA0NHB4O1xuICAgIC8vICAgICAgICAgYmFja2dyb3VuZDogcmdiYSgwLCAwLCAwLCAwKTtcbiAgICAvLyAgICAgICAgIHBhZGRpbmc6IDA7XG4gICAgLy8gICAgICAgICAuc2VhcmNoYmFyLWlucHV0e1xuICAgIC8vICAgICAgICAgICAgIGJvcmRlci1yYWRpdXM6IDE1cHg7XG4gICAgLy8gICAgICAgICAgICAgcGFkZGluZy1sZWZ0OiAzNXB4O1xuICAgIC8vICAgICAgICAgICAgIGZvbnQtc2l6ZTogMTNweDtcbiAgICAvLyAgICAgICAgIH1cbiAgICAvLyAgICAgICAgIC5zZWFyY2hiYXItc2VhcmNoLWljb257XG4gICAgLy8gICAgICAgICAgICAgY29sb3I6IHRyYW5zcGFyZW50O1xuICAgIC8vICAgICAgICAgICAgIGJhY2tncm91bmQtaW1hZ2U6IHVybCgvYXNzZXRzL2ltZ3Mvc2VhcmNoSWNvbkRhc2hib2FyZC5wbmcpICFpbXBvcnRhbnQ7XG4gICAgLy8gICAgICAgICAgICAgbGVmdDogOXB4O1xuICAgIC8vICAgICAgICAgfVxuICAgIC8vICAgICB9XG4gICAgLy8gfVxuICAgIC5zdG9yZS1pbmZvIHtcbiAgICAgIGJhY2tncm91bmQtY29sb3I6IHZhcigtLWdyZXktaW5wdXQpO1xuXG4gICAgICAuY3VzdG9tLWJ0biB7XG4gICAgICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50O1xuICAgICAgICB3aWR0aDogMTAwJTtcbiAgICAgICAgcGFkZGluZzogMDtcbiAgICAgIH1cblxuICAgICAgLmN1c3RvbS1pY29uIHtcbiAgICAgICAgcGFkZGluZzogMTBweCAxMHB4IDAgMTNweCAhaW1wb3J0YW50O1xuICAgICAgfVxuICAgIH1cblxuICAgIC5zZXJ2aWNlLW5hbWUtaW5mbyB7XG4gICAgICBjb2xvcjogdmFyKC0taW9uLWNvbG9yLXRlcnRpYXJ5KTtcbiAgICAgIGRpc3BsYXk6IGJsb2NrO1xuICAgICAgZm9udC1zaXplOiB2YXIoLS1keHAtZnopO1xuICAgIH1cblxuICAgIC5tYWtlLWEtbGlzdCxcbiAgICAubWFraW5nLWEtbGlzdCB7XG4gICAgICBjb2xvcjogdmFyKC0tcHJpbWFyeSkgIWltcG9ydGFudDtcbiAgICB9XG5cbiAgICAuc3RvcmUtaW5mby10b3Age1xuICAgICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XG4gICAgfVxuXG4gICAgLnlvdXItc3RvcmUtdHh0IHtcbiAgICAgIGNvbG9yOiB2YXIoLS1pb24tY29sb3ItcHJpbWFyeSkgIWltcG9ydGFudDtcbiAgICB9XG5cbiAgICAucmlnaHQtc3RvcmUtaW5mbyB7XG4gICAgICBjb2xvcjogdmFyKC0taW9uLWNvbG9yLXByaW1hcnkpICFpbXBvcnRhbnQ7XG4gICAgICBmb250LXNpemU6IDEzcHg7XG4gICAgICBmb250LXdlaWdodDogNjAwO1xuICAgIH1cblxuICAgIC5zdG9yZS1pbmZvLWxpbmUge1xuICAgICAgcGFkZGluZzogMDtcbiAgICAgIG1hcmdpbjogMDtcbiAgICAgIGNvbG9yOiBibGFjaztcbiAgICAgIGhlaWdodDogMXB4O1xuICAgIH1cblxuICAgIC5oLWxvZ28ge1xuICAgICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XG4gICAgICBwYWRkaW5nLXRvcDogNXB4O1xuXG4gICAgICBpb24tYnV0dG9uIHtcbiAgICAgICAgY29sb3I6IHZhcigtLWJhY2tncm91bmQtYmx1ZSk7XG4gICAgICB9XG4gICAgfVxuXG4gICAgLnVzZXItaW5mbyB7XG4gICAgICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1iYWNrZ3JvdW5kLWJsdWUpO1xuXG4gICAgICAucmV3YXJkLWltZyB7XG4gICAgICAgIHdpZHRoOiAxMzBweDtcbiAgICAgIH1cblxuICAgICAgLm5vLW1jLWljb24ge1xuICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGZsZXgtZW5kO1xuICAgICAgfVxuICAgIH1cblxuICAgIC5pbWctYmFyY29kZSB7XG4gICAgICB3aWR0aDogNTRweDtcbiAgICAgIGhlaWdodDogYXV0bztcbiAgICAgIGNvbnRhaW46IHVuc2V0O1xuICAgICAgcGFkZGluZy10b3A6IDZweDtcbiAgICAgIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjU1LCAyNTUsIDI1NSwgMCk7XG4gICAgfVxuICB9XG5cbiAgaW9uLXNsaWRlcyB7XG4gICAgaGVpZ2h0OiBhdXRvO1xuXG4gICAgLy8gbWF4LWhlaWdodDogMjAwcHg7XG4gICAgLmltZy1jb250YWluZXIge1xuICAgICAgd2lkdGg6IDEwMCU7XG4gICAgICBoZWlnaHQ6IDEwMCU7XG5cbiAgICAgIC8vIC8vIGJhY2tncm91bmQtaW1hZ2U6IHVybChodHRwczovL3Rlc3R1bml0ZWRjbG91ZC5yZWxhdGlvbnNob3AubmV0L1JTRGF0YS8wLzE2MDcyMDE5MTEzMjMxX0RlcGFydG1lbnQtTW9iaWxlLmpwZyk7XG4gICAgICAvLyBiYWNrZ3JvdW5kLXNpemU6IGNvdmVyO1xuICAgICAgLy8gYmFja2dyb3VuZC1yZXBlYXQ6IG5vLXJlcGVhdDtcbiAgICAgIC8vIGJhY2tncm91bmQtcG9zaXRpb246IDUwJSA1MCU7XG4gICAgICBpbWcge1xuICAgICAgICAvLyB3aWR0aDogMTAwJTtcbiAgICAgICAgbWF4LXdpZHRoOiAxMDAlO1xuICAgICAgICB3aWR0aDogYXV0bztcbiAgICAgICAgaGVpZ2h0OiBhdXRvO1xuICAgICAgfVxuICAgIH1cbiAgfVxuXG4gIC5zd2lwZXItc2xpZGUge1xuICAgIGRpc3BsYXk6IGJsb2NrO1xuICB9XG5cbiAgLmhvbWUtbGlzdCB7XG4gICAgLnNsaWRlciB7XG4gICAgICB3aWR0aDogMTAwJTtcblxuICAgICAgLy8gaGVpZ2h0OiAyODBweDtcbiAgICAgIGltZyB7XG4gICAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgfVxuICAgIH1cblxuICAgIC5ib3JkZXIge1xuICAgICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICNlNGU0ZTY7XG4gICAgICBwYWRkaW5nOiAwO1xuICAgIH1cblxuICAgIC5jdXN0b20tYnRuIHtcbiAgICAgIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMjU1LCAyNTUsIDI1NSwgMCk7XG4gICAgICB3aWR0aDogMTAwJTtcblxuICAgICAgLmN1c3RvbS1sYWJsZSB7XG4gICAgICAgIG1hcmdpbjogMHB4O1xuICAgICAgICBmb250LXNpemU6IDE5cHggIWltcG9ydGFudDtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICAuYnRuIHtcbiAgICB3aWR0aDogMTI1cHg7XG4gICAgaGVpZ2h0OiA0MHB4O1xuICB9XG5cbiAgLmN1c3RvbS1kaXNwbGF5LWNlbnRlciB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIHBhZGRpbmc6IDEwcHggIWltcG9ydGFudDtcbiAgfVxuXG4gIC5sb2dvLXN0b3JlIHtcbiAgICBtaW4td2lkdGg6IDEyMHB4O1xuICAgIGhlaWdodDogNTBweDtcblxuICAgIGltZyB7XG4gICAgICBtaW4td2lkdGg6IDEyMHB4O1xuICAgICAgaGVpZ2h0OiA1MHB4O1xuICAgIH1cblxuICAgICYuZmlsdGVyIHtcbiAgICAgIGZpbHRlcjogYnJpZ2h0bmVzcygwKSBpbnZlcnQoMSk7XG4gICAgfVxuICB9XG5cbiAgLml0ZW0td2lkZ2V0IHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcblxuICAgIGlvbi1jb2wge1xuICAgICAgbWluLWhlaWdodDogMDtcbiAgICB9XG4gIH1cblxuICAubWVzc2FnZS1jZW50ZXItZ3JvdXAge1xuICAgIGlvbi1pdGVtIHtcbiAgICAgIC0tcGFkZGluZy1zdGFydDogMTBweDtcbiAgICB9XG5cbiAgICAuZHhwLW5vdGlmaWNhdGlvbi1pY29uIHtcbiAgICAgIC0tcGFkZGluZy12ZXJ0aWNhbC1pY29uOiAwcHg7XG4gICAgfVxuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"],
    encapsulation: 2
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_home_home_router_module_ts.js.map