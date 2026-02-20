"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_offer_offer-routing_module_ts"],{

/***/ 676:
/*!**********************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/model/interface.ts ***!
  \**********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   EnumMagOfferType: () => (/* binding */ EnumMagOfferType),
/* harmony export */   enumCouponDisplayType: () => (/* binding */ enumCouponDisplayType)
/* harmony export */ });
var EnumMagOfferType;
(function (EnumMagOfferType) {
  EnumMagOfferType[EnumMagOfferType["StoreCoupon"] = 1] = "StoreCoupon";
  EnumMagOfferType[EnumMagOfferType["PromoCode"] = 2] = "PromoCode";
  EnumMagOfferType[EnumMagOfferType["Sale"] = 3] = "Sale";
  EnumMagOfferType[EnumMagOfferType["LoyaltyReward"] = 4] = "LoyaltyReward";
})(EnumMagOfferType || (EnumMagOfferType = {}));
var enumCouponDisplayType;
(function (enumCouponDisplayType) {
  enumCouponDisplayType[enumCouponDisplayType["Offer"] = 0] = "Offer";
  enumCouponDisplayType[enumCouponDisplayType["Coupon"] = 1] = "Coupon";
  enumCouponDisplayType[enumCouponDisplayType["Reward"] = 2] = "Reward";
  enumCouponDisplayType[enumCouponDisplayType["All"] = 3] = "All";
  enumCouponDisplayType[enumCouponDisplayType["WeeklyAd"] = 4] = "WeeklyAd";
})(enumCouponDisplayType || (enumCouponDisplayType = {}));

/***/ }),

/***/ 80019:
/*!***************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/offer-routing.module.ts ***!
  \***************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferRoutingModule: () => (/* binding */ OfferRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _offer_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./offer.module */ 72465);
/* harmony import */ var _pages_offer_detail_offer_detail__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/offer-detail/offer-detail */ 58779);
/* harmony import */ var _pages_offer_list_offer_list__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/offer-list/offer-list */ 73417);
/* harmony import */ var _pages_coupons_list_coupons_list__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/coupons-list/coupons-list */ 47439);
/* harmony import */ var _pages_rewards_rewards__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/rewards/rewards */ 6137);
/* harmony import */ var _pages_loaded_savings_loaded_saving__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./pages/loaded-savings/loaded-saving */ 78678);
/* harmony import */ var _pages_deals_page_deals_page__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./pages/deals-page/deals-page */ 45113);
/* harmony import */ var _pages_coupon_detail_coupon_detail__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pages/coupon-detail/coupon-detail */ 34057);
/* harmony import */ var _pages_reward_detail_reward_detail__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./pages/reward-detail/reward-detail */ 86329);
/* harmony import */ var _rsApp_modules_auth_v2_guards_auth_guard_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @rsApp/modules/auth-v2/guards/auth-guard.service */ 52714);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/core */ 37580);













const routes = [{
  path: '',
  component: _pages_deals_page_deals_page__WEBPACK_IMPORTED_MODULE_6__.DealsPageComponent,
  children: [{
    path: '',
    redirectTo: 'rewards',
    pathMatch: 'full'
  }, {
    path: 'offers',
    component: _pages_offer_list_offer_list__WEBPACK_IMPORTED_MODULE_2__.OfferListPageComponent
  }, {
    path: 'deals',
    component: _pages_offer_list_offer_list__WEBPACK_IMPORTED_MODULE_2__.OfferListPageComponent
  }, {
    path: 'rewards',
    component: _pages_rewards_rewards__WEBPACK_IMPORTED_MODULE_4__.RewardsPageComponent,
    children: [{
      path: ':slug',
      component: _pages_rewards_rewards__WEBPACK_IMPORTED_MODULE_4__.RewardsPageComponent
    }],
    canActivate: [_rsApp_modules_auth_v2_guards_auth_guard_service__WEBPACK_IMPORTED_MODULE_9__.AuthGuardService]
  }, {
    path: 'loaded-savings',
    component: _pages_loaded_savings_loaded_saving__WEBPACK_IMPORTED_MODULE_5__.LoadedSavingPageComponent,
    canActivate: [_rsApp_modules_auth_v2_guards_auth_guard_service__WEBPACK_IMPORTED_MODULE_9__.AuthGuardService]
  }, {
    path: 'coupons',
    component: _pages_coupons_list_coupons_list__WEBPACK_IMPORTED_MODULE_3__.CouponsListPageComponent,
    canActivate: [_rsApp_modules_auth_v2_guards_auth_guard_service__WEBPACK_IMPORTED_MODULE_9__.AuthGuardService]
  }]
}, {
  path: 'coupons-detail/:couponCode',
  component: _pages_coupon_detail_coupon_detail__WEBPACK_IMPORTED_MODULE_7__.CouponDetailPageComponent,
  data: {
    hideTab: true
  }
}, {
  path: 'offer-detail/:offerCode',
  component: _pages_offer_detail_offer_detail__WEBPACK_IMPORTED_MODULE_1__.OfferDetailPageComponent,
  data: {
    hideTab: true
  }
}, {
  path: 'reward-detail/:offerCode',
  component: _pages_reward_detail_reward_detail__WEBPACK_IMPORTED_MODULE_8__.RewardDetailPageComponent,
  data: {
    hideTab: true
  }
}];
class OfferRoutingModule {
  static ɵfac = function OfferRoutingModule_Factory(t) {
    return new (t || OfferRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdefineNgModule"]({
    type: OfferRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_11__.RouterModule.forChild(routes), _offer_module__WEBPACK_IMPORTED_MODULE_0__.OfferModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵsetNgModuleScope"](OfferRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_11__.RouterModule, _offer_module__WEBPACK_IMPORTED_MODULE_0__.OfferModule]
  });
})();

/***/ }),

/***/ 31556:
/*!****************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/offer-services.module.ts ***!
  \****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferServiceModule: () => (/* binding */ OfferServiceModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common/http */ 46443);
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/gateway/mag-ecom-core-api.service */ 31627);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _environments_environment_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../environments/environment.service */ 25957);
/* harmony import */ var _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../utils/ecom-api-configs */ 847);
/* harmony import */ var _providers_offer_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./providers/offer.service */ 811);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);











class OfferServiceModule {
  static ɵfac = function OfferServiceModule_Factory(t) {
    return new (t || OfferServiceModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineNgModule"]({
    type: OfferServiceModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineInjector"]({
    providers: [{
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__.MAG_OFFER_DXP_CORE_API,
      useValue: _app_env__WEBPACK_IMPORTED_MODULE_0__.ENV.DXPCoreAPI
    }, {
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__.MAG_OFFER_V2_HTTP_CLIENT,
      useFactory: _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_2__.MagEComCoreApiHttpClientFactory,
      deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_8__.HttpHandler, _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential, _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__.MAG_OFFER_DXP_CORE_API, _environments_environment_service__WEBPACK_IMPORTED_MODULE_4__.EnvironmentService]
    }, {
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__.MAG_REWARD_API,
      useValue: _app_env__WEBPACK_IMPORTED_MODULE_0__.ENV.EComRewardAPIURL
    }, {
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__.MAG_REWARD_HTTP_CLIENT,
      useFactory: _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_2__.MagEComCoreApiHttpClientFactory,
      deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_8__.HttpHandler, _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential, _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_5__.MAG_REWARD_API, _environments_environment_service__WEBPACK_IMPORTED_MODULE_4__.EnvironmentService]
    }, _providers_offer_service__WEBPACK_IMPORTED_MODULE_6__.OfferService],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_3__.UtilsModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsetNgModuleScope"](OfferServiceModule, {
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_3__.UtilsModule]
  });
})();

/***/ }),

/***/ 72465:
/*!*******************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/offer.module.ts ***!
  \*******************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferModule: () => (/* binding */ OfferModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/shared/shared.module */ 70541);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _offer_services_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./offer-services.module */ 31556);
/* harmony import */ var _pages_offer_detail_offer_detail__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/offer-detail/offer-detail */ 58779);
/* harmony import */ var _pages_offer_list_offer_list__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./pages/offer-list/offer-list */ 73417);
/* harmony import */ var _pages_coupons_list_coupons_list__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./pages/coupons-list/coupons-list */ 47439);
/* harmony import */ var _pages_rewards_rewards__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pages/rewards/rewards */ 6137);
/* harmony import */ var _pages_loaded_savings_loaded_saving__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./pages/loaded-savings/loaded-saving */ 78678);
/* harmony import */ var _pages_deals_page_deals_page__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./pages/deals-page/deals-page */ 45113);
/* harmony import */ var _pages_coupon_detail_coupon_detail__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./pages/coupon-detail/coupon-detail */ 34057);
/* harmony import */ var _pages_reward_detail_reward_detail__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./pages/reward-detail/reward-detail */ 86329);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/core */ 37580);



















class OfferModule {
  static ɵfac = function OfferModule_Factory(t) {
    return new (t || OfferModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_12__["ɵɵdefineNgModule"]({
    type: OfferModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_12__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_13__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_14__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_15__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_16__.MomentModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_17__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__.HeaderComponentModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_18__.TranslateModule, _offer_services_module__WEBPACK_IMPORTED_MODULE_3__.OfferServiceModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_12__["ɵɵsetNgModuleScope"](OfferModule, {
    declarations: [_pages_offer_list_offer_list__WEBPACK_IMPORTED_MODULE_5__.OfferListPageComponent, _pages_offer_detail_offer_detail__WEBPACK_IMPORTED_MODULE_4__.OfferDetailPageComponent, _pages_coupon_detail_coupon_detail__WEBPACK_IMPORTED_MODULE_10__.CouponDetailPageComponent, _pages_coupons_list_coupons_list__WEBPACK_IMPORTED_MODULE_6__.CouponsListPageComponent, _pages_rewards_rewards__WEBPACK_IMPORTED_MODULE_7__.RewardsPageComponent, _pages_loaded_savings_loaded_saving__WEBPACK_IMPORTED_MODULE_8__.LoadedSavingPageComponent, _pages_deals_page_deals_page__WEBPACK_IMPORTED_MODULE_9__.DealsPageComponent, _pages_reward_detail_reward_detail__WEBPACK_IMPORTED_MODULE_11__.RewardDetailPageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_13__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_14__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_15__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_16__.MomentModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_17__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__.HeaderComponentModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_18__.TranslateModule, _offer_services_module__WEBPACK_IMPORTED_MODULE_3__.OfferServiceModule],
    exports: [_pages_offer_list_offer_list__WEBPACK_IMPORTED_MODULE_5__.OfferListPageComponent, _pages_offer_detail_offer_detail__WEBPACK_IMPORTED_MODULE_4__.OfferDetailPageComponent, _pages_coupon_detail_coupon_detail__WEBPACK_IMPORTED_MODULE_10__.CouponDetailPageComponent, _pages_coupons_list_coupons_list__WEBPACK_IMPORTED_MODULE_6__.CouponsListPageComponent, _pages_rewards_rewards__WEBPACK_IMPORTED_MODULE_7__.RewardsPageComponent, _pages_loaded_savings_loaded_saving__WEBPACK_IMPORTED_MODULE_8__.LoadedSavingPageComponent, _pages_deals_page_deals_page__WEBPACK_IMPORTED_MODULE_9__.DealsPageComponent, _pages_reward_detail_reward_detail__WEBPACK_IMPORTED_MODULE_11__.RewardDetailPageComponent]
  });
})();

/***/ }),

/***/ 34057:
/*!****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/coupon-detail/coupon-detail.ts ***!
  \****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CouponDetailPageComponent: () => (/* binding */ CouponDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! moment */ 39545);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var _providers_offer_product_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../providers/offer-product.service */ 31485);
/* harmony import */ var _providers_offer_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../providers/offer.service */ 811);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/utils/providers/route-tracker.service */ 68674);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _shared_page_not_found_not_found__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../../shared/page/not-found/not-found */ 9217);






















function CouponDetailPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 9);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "coupon/" + ctx_r0.couponCode)("slug", ctx_r0.router.url);
  }
}
function CouponDetailPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 10);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "coupon/" + ctx_r0.couponCode)("slug", ctx_r0.router.url);
  }
}
function CouponDetailPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 11);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "coupon/" + ctx_r0.couponCode)("slug", ctx_r0.router.url);
  }
}
function CouponDetailPageComponent_ng_container_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](1, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](2, "ion-spinner", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerEnd"]();
  }
}
function CouponDetailPageComponent_ng_container_8_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "page-not-found");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerEnd"]();
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "mag-img", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("src", ctx_r0.coupon == null ? null : ctx_r0.coupon.ImageURL);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_ng_template_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "mag-img", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 32)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate"](ctx_r0.coupon.Title);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 33)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate"](ctx_r0.coupon.Description);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 34)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](3, "mag-deal-expire-badge", 35);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate1"]("Expires: ", ctx_r0.couponExpirationDate, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("expirationDate", ctx_r0.coupon == null ? null : ctx_r0.coupon.ExpireDate);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 36)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate2"]("Valid: ", ctx_r0.startDate, " - ", ctx_r0.endDate, "");
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 37)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate"](ctx_r0.coupon.Description);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 38)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate"](ctx_r0.coupon.DisclaimerText);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 39);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "mag-deal-participating-products", 40);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("upcs", ctx_r0.conditionUpcs)("isBundle", ctx_r0.isBundle);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "widget-layout", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](2, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_2_Template, 2, 1, "div", 18)(3, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_ng_template_3_Template, 2, 0, "ng-template", null, 1, _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplateRefExtractor"])(5, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_5_Template, 3, 1, "div", 19)(6, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_6_Template, 3, 1, "div", 20)(7, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_7_Template, 4, 2, "div", 21)(8, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_8_Template, 3, 2, "div", 22)(9, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_9_Template, 3, 1, "div", 23)(10, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_10_Template, 3, 1, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](11, "mag-deal-button-container", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](12, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_div_12_Template, 2, 2, "div", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](13, "widget-layout", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const img_default_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵreference"](4);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "coupon/" + ctx_r0.couponCode)("slug", ctx_r0.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.coupon == null ? null : ctx_r0.coupon.ImageURL)("ngIfElse", img_default_r2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.coupon == null ? null : ctx_r0.coupon.Title);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.coupon == null ? null : ctx_r0.coupon.Description);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.couponExpirationDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.startDate && ctx_r0.endDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.coupon == null ? null : ctx_r0.coupon.Description);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.coupon == null ? null : ctx_r0.coupon.DisclaimerText);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("offer", ctx_r0.coupon);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.isLoadedParticipatingProducts);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "coupon/" + ctx_r0.couponCode)("slug", ctx_r0.router.url);
  }
}
function CouponDetailPageComponent_ng_container_8_ng_template_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](0, CouponDetailPageComponent_ng_container_8_ng_template_2_div_0_Template, 14, 14, "div", 15);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.coupon);
  }
}
function CouponDetailPageComponent_ng_container_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](1, CouponDetailPageComponent_ng_container_8_ng_container_1_Template, 2, 0, "ng-container", 14)(2, CouponDetailPageComponent_ng_container_8_ng_template_2_Template, 1, 1, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const couponDetail_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵreference"](3);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", !ctx_r0.coupon)("ngIfElse", couponDetail_r3);
  }
}
class CouponDetailPageComponent {
  router;
  route;
  offerService;
  offerProductService;
  cStore;
  cre;
  routeTracker;
  ngZone;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_11__.Subject();
  coupon;
  magGallery;
  couponCode;
  transactionId;
  couponExpirationDate;
  startDate;
  endDate;
  isCoupon;
  consolidatedField;
  conditionUpcs;
  participatingProducts;
  isBundle;
  isLoadedParticipatingProducts = false;
  store;
  isShoppingList = false;
  loaded = false;
  constructor(router, route, offerService, offerProductService, cStore, cre, routeTracker, ngZone) {
    this.router = router;
    this.route = route;
    this.offerService = offerService;
    this.offerProductService = offerProductService;
    this.cStore = cStore;
    this.cre = cre;
    this.routeTracker = routeTracker;
    this.ngZone = ngZone;
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.route.paramMap.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_12__.takeUntil)(_this._destroy$)).subscribe(params => {
        _this.couponCode = params.get('couponCode');
      });
      try {
        yield _this.init();
      } catch (error) {
        console.error(error);
      }
    })();
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  // async ionViewWillEnter() {
  //   try {
  //     await this.init();
  //   } catch (error) {
  //     console.error(error);
  //   }
  // }
  init() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.store = yield _this2.cStore.getStore();
      if (!_this2.store) {
        console.error('Store not found');
        return;
      }
      _this2.loaded = false;
      _this2.coupon = yield _this2.fetchCoupon();
      if (!_this2.coupon) {
        _this2.ngZone.run(() => {
          _this2.loaded = true;
        });
        console.error('Offer not found');
        return;
      }
      _this2.updateMagGallery(_this2.coupon?.ImageURL);
      _this2.initCouponData();
      //TODO : Uncomment and implement this method when needed
      yield _this2.initParticipatingData();
      _this2.ngZone.run(() => {
        _this2.loaded = true;
      });
    })();
  }
  initCouponData() {
    const {
      ExpireDate,
      StartDate,
      EndDate
    } = this.coupon || {};
    this.couponExpirationDate = ExpireDate ? moment__WEBPACK_IMPORTED_MODULE_2__(ExpireDate).format('MMM DD, YYYY') : '';
    this.startDate = StartDate ? moment__WEBPACK_IMPORTED_MODULE_2__(StartDate).format('MMM DD, YYYY') : '';
    this.endDate = EndDate ? moment__WEBPACK_IMPORTED_MODULE_2__(EndDate).format('MMM DD, YYYY') : '';
  }
  initParticipatingData() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        Upcs
      } = _this3.coupon || {};
      _this3.conditionUpcs = Upcs;
      if (_this3.conditionUpcs?.length > 0) {
        const dataSource = yield _this3.fetchDataByUpcs(_this3.conditionUpcs);
        _this3.participatingProducts = dataSource?.length > 0 ? dataSource : null;
      }
      //just for test , will remove when has data
      _this3.isBundle = false;
      _this3.isLoadedParticipatingProducts = true;
    })();
  }
  processUpcGroups(upcGroups) {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const promises = upcGroups.map(group => _this4.fetchDataByUpcs(group));
        const results = yield Promise.all(promises);
        return results;
      } catch (error) {
        console.error('Error processing UPC groups:', error);
        return [];
      }
    })();
  }
  fetchDataByUpcs(upcs) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      return yield (0,rxjs__WEBPACK_IMPORTED_MODULE_13__.firstValueFrom)(_this5.offerProductService.getParticipatingProducts(upcs, _this5.store?.StoreCode, true, _this5.cre.currentUser));
    })();
  }
  fetchCoupon() {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const coupon = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_13__.firstValueFrom)(_this6.offerService.getCouponByCode(_this6.couponCode));
        if (!coupon) return null;
        return coupon;
      } catch (error) {
        console.error('Error fetching offer data:', error);
        return null;
      }
    })();
  }
  updateMagGallery(payload) {
    if (!payload) return;
    this.magGallery = `<mag-gallery image-string='${payload}'></mag-gallery`;
  }
  static ɵfac = function CouponDetailPageComponent_Factory(t) {
    return new (t || CouponDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_14__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_14__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_providers_offer_service__WEBPACK_IMPORTED_MODULE_4__.OfferService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_providers_offer_product_service__WEBPACK_IMPORTED_MODULE_3__.OfferProductService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_1__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_5__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_6__.RouteTrackerService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_10__.NgZone));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdefineComponent"]({
    type: CouponDetailPageComponent,
    selectors: [["coupon-detail"]],
    decls: 9,
    vars: 7,
    consts: [["couponDetail", ""], ["img_default", ""], ["type", "coupon", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "coupon", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "coupon", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], [1, "ion-padding"], [4, "ngIf"], ["type", "coupon", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "coupon", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "coupon", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "loading-container"], ["name", "crescent"], [4, "ngIf", "ngIfElse"], ["class", "coupons-detail", 4, "ngIf"], [1, "coupons-detail"], ["type", "coupon", "zoneName", "Top", 3, "objectId", "slug"], ["class", "coupons-detail__img", 4, "ngIf", "ngIfElse"], ["class", "coupons-detail__display-name mb-200", 4, "ngIf"], ["class", "coupons-detail__description mb-200", 4, "ngIf"], ["class", "coupons-detail__expiration-date mb-200", 4, "ngIf"], ["class", "coupons-detail__valid-date mb-200", 4, "ngIf"], ["class", "coupons-detail__disclaimer-text mb-200", 4, "ngIf"], ["class", "coupons-detail__disclaimer-text", 4, "ngIf"], [3, "offer"], ["class", "coupons-detail__participating-products", 4, "ngIf"], ["type", "coupon", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "coupons-detail__img"], [3, "src"], [1, "coupons-detail__default-img"], ["src", ""], [1, "coupons-detail__display-name", "mb-200"], [1, "coupons-detail__description", "mb-200"], [1, "coupons-detail__expiration-date", "mb-200"], [3, "expirationDate"], [1, "coupons-detail__valid-date", "mb-200"], [1, "coupons-detail__disclaimer-text", "mb-200"], [1, "coupons-detail__disclaimer-text"], [1, "coupons-detail__participating-products"], [3, "upcs", "isBundle"]],
    template: function CouponDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](0, CouponDetailPageComponent_widget_layout_0_Template, 1, 2, "widget-layout", 2)(1, CouponDetailPageComponent_widget_layout_1_Template, 1, 2, "widget-layout", 3)(2, CouponDetailPageComponent_widget_layout_2_Template, 1, 2, "widget-layout", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](3, "app-header", 5)(4, "ion-title", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](5, "Coupon Details");
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](6, "ion-content", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](7, CouponDetailPageComponent_ng_container_7_Template, 3, 0, "ng-container", 8)(8, CouponDetailPageComponent_ng_container_8_Template, 4, 2, "ng-container", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", !ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_15__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonSpinner, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_16__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_7__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_8__.HeaderComponent, _shared_page_not_found_not_found__WEBPACK_IMPORTED_MODULE_9__.NotFoundPageComponent],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\n\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n  --background-activated: none;\n}\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: var(--mag-spacing-600, 48px);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n\n.title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.coupons-detail[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-style: normal;\n  padding-bottom: 60px;\n}\n.coupons-detail__img[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n.coupons-detail__img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 343px;\n  height: 343px;\n  object-fit: contain;\n}\n.coupons-detail__display-name[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-pricing-deal, #da0808);\n  font-size: var(--mag-typography-deal-large-font-size, 28px);\n  font-weight: var(--mag-typography-deal-font-weight, 500);\n  line-height: var(--mag-typography-deal-large-line-height, 36px);\n  \n\n}\n.coupons-detail__description[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  font-size: var(--mag-typography-headlines-large-font-size, 24px);\n  font-weight: var(--mag-typography-headlines-large-font-weight, 500);\n  line-height: var(--mag-typography-headlines-large-line-height, 32px);\n  \n\n}\n.coupons-detail__expiration-date[_ngcontent-%COMP%], .coupons-detail__valid-date[_ngcontent-%COMP%], .coupons-detail__disclaimer-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  \n\n}\n.coupons-detail__expiration-date[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  display: flex;\n  align-items: center;\n  gap: 8px;\n}\n.coupons-detail__participating-products[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-400, 32px);\n  margin-bottom: var(--mag-spacing-500, 40px);\n}\n.coupons-detail__clipped-label[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-200, 16px);\n  margin-left: var(--mag-spacing-100, 8px);\n}\n\n.mb-200[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n\n.loading-container[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL2NvdXBvbi1kZXRhaWwvY291cG9uLWRldGFpbC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLHdEQUFBO0FBQ0Y7O0FBR0U7RUFDRSwwREFBQTtFQUNBLDRCQUFBO0FBQUo7QUFHRTtFQUNFLG9DQUFBO0FBREo7O0FBS0E7RUFDRSxvREFBQTtFQUNBLDJDQUFBO0VBQ0EsNkNBQUE7RUFDQSwyQ0FBQTtBQUZGOztBQUtBO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUVBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFIRjs7QUFNQTtFQUNFLDZDQUFBO0VBQ0EsK0RBQUE7RUFDQSxrQkFBQTtFQUNBLG9CQUFBO0FBSEY7QUFLRTtFQUNFLDJDQUFBO0FBSEo7QUFLSTtFQUNFLFlBQUE7RUFDQSxhQUFBO0VBQ0EsbUJBQUE7QUFITjtBQU9FO0VBQ0Usa0RBQUE7RUFDQSwyREFBQTtFQUNBLHdEQUFBO0VBQ0EsK0RBQUE7RUFDQSxhQUFBO0FBTEo7QUFRRTtFQUNFLDRDQUFBO0VBQ0EsZ0VBQUE7RUFDQSxtRUFBQTtFQUNBLG9FQUFBO0VBQ0EsYUFBQTtBQU5KO0FBU0U7RUFHRSw2Q0FBQTtFQUNBLDREQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtFQUNBLFNBQUE7QUFUSjtBQVlFO0VBQ0UsNENBQUE7RUFDQSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSxRQUFBO0FBVko7QUFhRTtFQUNFLHdDQUFBO0VBQ0EsMkNBQUE7QUFYSjtBQWNFO0VBQ0Usd0NBQUE7RUFDQSx3Q0FBQTtBQVpKOztBQWdCQTtFQUNFLDJDQUFBO0FBYkY7O0FBZ0JBO0VBQ0UsV0FBQTtFQUNBLFlBQUE7RUFDQSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtBQWJGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLXRvb2xiYXIge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctZW5kOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLWRpdmlkZXIpO1xufVxuXG5pb24tZm9vdGVyIHtcbiAgaW9uLWJ1dHRvbiB7XG4gICAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctYnJhbmQtZm91bmRhdGlvbi1wcmltYXJ5LCAjMDA4MDAwKTtcbiAgICAtLWJhY2tncm91bmQtYWN0aXZhdGVkOiBub25lO1xuICB9XG5cbiAgaW9uLWJ1dHRvbjo6cGFydChuYXRpdmUpIHtcbiAgICBoZWlnaHQ6IHZhcigtLW1hZy1zcGFjaW5nLTYwMCwgNDhweCk7XG4gIH1cbn1cblxuaW9uLWNvbnRlbnQge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG5cbi50aXRsZSB7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuXG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgZm9udC1zdHlsZTogbm9ybWFsO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbn1cblxuLmNvdXBvbnMtZGV0YWlsIHtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksIExleGVuZCk7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgcGFkZGluZy1ib3R0b206IDYwcHg7XG5cbiAgJl9faW1nIHtcbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuXG4gICAgaW1nIHtcbiAgICAgIHdpZHRoOiAzNDNweDtcbiAgICAgIGhlaWdodDogMzQzcHg7XG4gICAgICBvYmplY3QtZml0OiBjb250YWluO1xuICAgIH1cbiAgfVxuXG4gICZfX2Rpc3BsYXktbmFtZSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaWNpbmctZGVhbCwgI2RhMDgwOCk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kZWFsLWxhcmdlLWZvbnQtc2l6ZSwgMjhweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRlYWwtZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRlYWwtbGFyZ2UtbGluZS1oZWlnaHQsIDM2cHgpO1xuICAgIC8qIDEyOC41NzElICovXG4gIH1cblxuICAmX19kZXNjcmlwdGlvbiB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXNlY29uZGFyeSwgIzU1NSk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtZm9udC1zaXplLCAyNHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLWxhcmdlLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtbGluZS1oZWlnaHQsIDMycHgpO1xuICAgIC8qIDEzMy4zMzMlICovXG4gIH1cblxuICAmX19leHBpcmF0aW9uLWRhdGUsXG4gICZfX3ZhbGlkLWRhdGUsXG4gICZfX2Rpc2NsYWltZXItdGV4dCB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICAgIC8qIDE1MCUgKi9cbiAgfVxuXG4gICZfX2V4cGlyYXRpb24tZGF0ZSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXNlY29uZGFyeSwgIzU1NSk7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGdhcDogOHB4O1xuICB9XG5cbiAgJl9fcGFydGljaXBhdGluZy1wcm9kdWN0cyB7XG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KTtcbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy01MDAsIDQwcHgpO1xuICB9XG5cbiAgJl9fY2xpcHBlZC1sYWJlbCB7XG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgICBtYXJnaW4tbGVmdDogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuICB9XG59XG5cbi5tYi0yMDAge1xuICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuXG4ubG9hZGluZy1jb250YWluZXIge1xuICB3aWR0aDogMTAwJTtcbiAgaGVpZ2h0OiAxMDAlO1xuICBkaXNwbGF5OiBmbGV4O1xuICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 47439:
/*!**************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/coupons-list/coupons-list.ts ***!
  \**************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CouponsListPageComponent: () => (/* binding */ CouponsListPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);









class CouponsListPageComponent {
  router;
  route;
  cStore;
  cre;
  constructor(router, route, cStore, cre) {
    this.router = router;
    this.route = route;
    this.cStore = cStore;
    this.cre = cre;
  }
  static ɵfac = function CouponsListPageComponent_Factory(t) {
    return new (t || CouponsListPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_0__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: CouponsListPageComponent,
    selectors: [["coupons-list"]],
    decls: 6,
    vars: 2,
    consts: [[1, "widget-layout"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["id", "coupons-list", "active-page", "coupons"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function CouponsListPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "ion-content")(1, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](2, "widget-layout", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](3, "mag-deal-container", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](4, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](5, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonContent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent],
    styles: [".widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL2NvdXBvbnMtbGlzdC9jb3Vwb25zLWxpc3Quc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHVDQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyIud2lkZ2V0LWxheW91dCB7XG4gIHBhZGRpbmc6IDAgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 45113:
/*!**********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/deals-page/deals-page.ts ***!
  \**********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DealsPageComponent: () => (/* binding */ DealsPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ 51567);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
















function DealsPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "widget-layout", 6);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function DealsPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "widget-layout", 7);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function DealsPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "widget-layout", 8);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function DealsPageComponent_app_header_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](0, "app-header", 9)(1, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](2, "mag-deal-search-box");
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("isSimpleHeader", true);
  }
}
function DealsPageComponent_ng_container_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](1, "ion-img", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementContainerEnd"]();
  }
}
function DealsPageComponent_ng_template_6_mag_deal_tabs_0_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](0, "mag-deal-tabs", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵlistener"]("tabChange", function DealsPageComponent_ng_template_6_mag_deal_tabs_0_Template_mag_deal_tabs_tabChange_0_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵrestoreView"](_r2);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵresetView"](ctx_r0.selectTab($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("data", ctx_r0.settingsTabItems)("defaultTab", ctx_r0.activeTab);
  }
}
function DealsPageComponent_ng_template_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplate"](0, DealsPageComponent_ng_template_6_mag_deal_tabs_0_Template, 1, 2, "mag-deal-tabs", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](1, "ion-tabs", 13)(2, "ion-tab-bar", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](3, "ion-tab-button", 15)(4, "ion-tab-button", 16)(5, "ion-tab-button", 17)(6, "ion-tab-button", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", ctx_r0.settingsTabItems && ctx_r0.settingsTabItems.length > 0);
  }
}
class DealsPageComponent {
  router;
  route;
  cStore;
  cre;
  appSettings;
  content;
  tabItems = [{
    id: 'rewards',
    label: 'myRewards'
  }, {
    id: 'offers',
    label: 'myOffers'
  }, {
    id: 'coupons',
    label: 'myCoupons'
  }, {
    id: 'loaded-savings',
    label: 'myLoaded Savings'
  }];
  activeTab = '';
  activeSlug = '';
  settingsTabItems = [];
  OFFER_PATH_SETTING = 'PROMOTIONS';
  dealSupport = true;
  isInit = true;
  loaded;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_7__.Subject();
  constructor(router, route, cStore, cre, appSettings) {
    this.router = router;
    this.route = route;
    this.cStore = cStore;
    this.cre = cre;
    this.appSettings = appSettings;
    const slug = this.route.snapshot.children[0].routeConfig.path || 'rewards';
    this.activeSlug = slug;
    this.router.events.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_8__.filter)(event => event instanceof _angular_router__WEBPACK_IMPORTED_MODULE_9__.NavigationEnd), (0,rxjs__WEBPACK_IMPORTED_MODULE_10__.takeUntil)(this._destroy$)).subscribe(() => {
      if (this.isInit) {
        this.isInit = false;
      } else {
        const activeRoute = this.getDeepestChild(this.router.routerState.root);
        const configPath = activeRoute.routeConfig?.path;
        if (!configPath?.startsWith(':')) {
          this.activeSlug = configPath;
          this.setActiveTab();
        }
      }
    });
  }
  getDeepestChild(route) {
    while (route.firstChild) {
      route = route.firstChild;
    }
    return route;
  }
  setActiveTab() {
    const currentTab = this.settingsTabItems.find(s => s.id.toLocaleLowerCase() === this.activeSlug.toLocaleLowerCase());
    if (currentTab) this.activeTab = currentTab.id;
    setTimeout(() => this.loaded = true);
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const rs = yield _this.appSettings.getSettingByPath(_this.OFFER_PATH_SETTING).toPromise();
      const dealNagition = rs['deal_page_navigation_support'];
      _this.dealSupport = rs['deals_support'];
      if (!rs) return;
      _this.settingsTabItems = dealNagition || [];
      _this.setActiveTab();
    })();
  }
  ionViewDidEnter() {
    window.addEventListener('scrollToTop', this.handleScrollToTop);
  }
  ionViewWillLeave() {
    window.removeEventListener('scrollToTop', this.handleScrollToTop);
  }
  handleScrollToTop = () => {
    const scrollTopListId = ['#offers-list', '#coupons-list'];
    scrollTopListId.forEach(idElement => {
      document.querySelector(idElement)?.scrollIntoView({
        behavior: 'smooth',
        block: 'start'
      });
    });
    this.content?.scrollToTop();
  };
  selectTab($event) {
    const data = $event.detail;
    this.activeTab = data.id;
    this.loaded = false;
    this.router.navigate([`/tabs/deals/${data.id}`], {
      relativeTo: this.route
    });
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  static ɵfac = function DealsPageComponent_Factory(t) {
    return new (t || DealsPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_9__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_9__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_3__.AppSettings));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineComponent"]({
    type: DealsPageComponent,
    selectors: [["deals-page"]],
    viewQuery: function DealsPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵviewQuery"](_ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonContent, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵloadQuery"]()) && (ctx.content = _t.first);
      }
    },
    decls: 8,
    vars: 6,
    consts: [["deal_support", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader", 4, "ngIf"], [4, "ngIf", "ngIfElse"], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader"], [1, "header-simple__container"], ["src", "assets/imgs/404.svg", 1, "img"], [3, "data", "defaultTab", "tabChange", 4, "ngIf"], [1, "content-deals-page"], ["slot", "top"], ["tab", "offers"], ["tab", "rewards"], ["tab", "loaded-savings"], ["tab", "coupons"], [3, "tabChange", "data", "defaultTab"]],
    template: function DealsPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplate"](0, DealsPageComponent_widget_layout_0_Template, 1, 1, "widget-layout", 1)(1, DealsPageComponent_widget_layout_1_Template, 1, 1, "widget-layout", 2)(2, DealsPageComponent_widget_layout_2_Template, 1, 1, "widget-layout", 3)(3, DealsPageComponent_app_header_3_Template, 3, 1, "app-header", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](4, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplate"](5, DealsPageComponent_ng_container_5_Template, 2, 0, "ng-container", 5)(6, DealsPageComponent_ng_template_6_Template, 7, 1, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        const deal_support_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵreference"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", ctx.dealSupport);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngIf", !ctx.dealSupport)("ngIfElse", deal_support_r3);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_12__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonTabBar, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonTabButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonTabs, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_5__.HeaderComponent],
    styles: ["ion-content[_ngcontent-%COMP%] {\n  --overflow: hidden;\n}\n\nion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\n\nion-content.content-deal-page[_ngcontent-%COMP%] {\n  --overflow: hidden;\n  --padding-bottom: 0px;\n}\n\n.content-deals-page[_ngcontent-%COMP%] {\n  position: relative;\n}\n.content-deals-page[_ngcontent-%COMP%]   ion-tab-bar[_ngcontent-%COMP%] {\n  display: none;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL2RlYWxzLXBhZ2UvZGVhbHMtcGFnZS5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usa0JBQUE7QUFDRjs7QUFFQTtFQUNFLG9EQUFBO0VBQ0EsMkNBQUE7RUFDQSw4Q0FBQTtFQUNBLDJDQUFBO0VBQ0EsNkNBQUE7RUFDQSx3REFBQTtBQUNGOztBQUVBO0VBQ0Usa0JBQUE7RUFDQSxxQkFBQTtBQUNGOztBQUVBO0VBQ0Usa0JBQUE7QUFDRjtBQUNFO0VBQ0UsYUFBQTtBQUNKIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLWNvbnRlbnQge1xuICAtLW92ZXJmbG93OiBoaWRkZW47XG59XG5cbmlvbi10b29sYmFyIHtcbiAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbiAgLS1wYWRkaW5nLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLWVuZDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLXN0YXJ0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBib3JkZXItYm90dG9tOiAxcHggc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyKTtcbn1cblxuaW9uLWNvbnRlbnQuY29udGVudC1kZWFsLXBhZ2Uge1xuICAtLW92ZXJmbG93OiBoaWRkZW47XG4gIC0tcGFkZGluZy1ib3R0b206IDBweDtcbn1cblxuLmNvbnRlbnQtZGVhbHMtcGFnZSB7XG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcblxuICBpb24tdGFiLWJhciB7XG4gICAgZGlzcGxheTogbm9uZTtcbiAgfVxufVxuXG4vLyAuY29udGVudC1kZWFsLWNvbnRhaW5lciB7XG4vLyAgIGhlaWdodDogMTAwJTtcbi8vICAgb3ZlcmZsb3c6IGF1dG87XG4vLyB9XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 78678:
/*!*****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/loaded-savings/loaded-saving.ts ***!
  \*****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   LoadedSavingPageComponent: () => (/* binding */ LoadedSavingPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);









class LoadedSavingPageComponent {
  router;
  route;
  cStore;
  cre;
  loadedSavingContainer;
  constructor(router, route, cStore, cre) {
    this.router = router;
    this.route = route;
    this.cStore = cStore;
    this.cre = cre;
  }
  static ɵfac = function LoadedSavingPageComponent_Factory(t) {
    return new (t || LoadedSavingPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_0__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: LoadedSavingPageComponent,
    selectors: [["loaded-saving"]],
    decls: 6,
    vars: 2,
    consts: [[1, "widget-layout"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["active-page", "loaded-savings"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function LoadedSavingPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "ion-content")(1, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](2, "widget-layout", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](3, "mag-deal-container", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](4, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](5, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonContent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent],
    styles: [".widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL2xvYWRlZC1zYXZpbmdzL2xvYWRlZC1zYXZpbmcuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHVDQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyIud2lkZ2V0LWxheW91dCB7XG4gIHBhZGRpbmc6IDAgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 58779:
/*!**************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/offer-detail/offer-detail.ts ***!
  \**************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferDetailPageComponent: () => (/* binding */ OfferDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! moment */ 39545);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var _model_interface__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/interface */ 676);
/* harmony import */ var _providers_offer_product_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../providers/offer-product.service */ 31485);
/* harmony import */ var _providers_offer_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../providers/offer.service */ 811);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @rsApp/modules/utils/providers/route-tracker.service */ 68674);
/* harmony import */ var _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @rsApp/core/enum */ 35619);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _shared_page_not_found_not_found__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../../shared/page/not-found/not-found */ 9217);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @ngx-translate/core */ 90852);




























function OfferDetailPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](0, "widget-layout", 8);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("objectId", "offer/" + ctx_r0.offerCode)("slug", ctx_r0.router.url);
  }
}
function OfferDetailPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](0, "widget-layout", 9);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("objectId", "offer/" + ctx_r0.offerCode)("slug", ctx_r0.router.url);
  }
}
function OfferDetailPageComponent_ng_container_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](1, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](2, "ion-spinner", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementContainerEnd"]();
  }
}
function OfferDetailPageComponent_ng_container_9_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](1, "page-not-found");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementContainerEnd"]();
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](1, "mag-img", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("src", ctx_r0.saleTagImageUrl);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](1, "mag-img", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("src", ctx_r0.offer == null ? null : ctx_r0.offer.ImageUrl);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 34);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](1, "mag-img", 35);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 36)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate"](ctx_r0.offer.DiscountPricing);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 37)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate"](ctx_r0.offer.Name);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 38)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](3, "ion-icon", 39);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate"](ctx_r0.offer.SalePriceText);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 40)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](4, "mag-deal-expire-badge", 41);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate2"]("", _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵpipeBind1"](3, 3, "offer.expires"), ": ", ctx_r0.offerExpirationDate, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("expirationDate", ctx_r0.offer == null ? null : ctx_r0.offer.ExpirationDate);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 42)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate3"]("", _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵpipeBind1"](3, 3, "offer.valid"), ": ", ctx_r0.startDate, " - ", ctx_r0.endDate, "");
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 43)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate"](ctx_r0.offer.Description);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 44)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate"](ctx_r0.offer.DisclaimerText);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_mag_deal_button_container_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](0, "mag-deal-button-container", 45);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("offer", ctx_r0.offer);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](0, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](1, "widget-layout", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtemplate"](2, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_2_Template, 2, 1, "div", 16)(3, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_3_Template, 2, 1, "div", 17)(4, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_4_Template, 2, 0, "div", 18)(5, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_5_Template, 3, 1, "div", 19)(6, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_6_Template, 3, 1, "div", 20)(7, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_7_Template, 4, 1, "div", 21)(8, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_8_Template, 5, 5, "div", 22)(9, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_9_Template, 4, 5, "div", 23)(10, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_10_Template, 3, 1, "div", 24)(11, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_div_11_Template, 3, 1, "div", 25)(12, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_mag_deal_button_container_12_Template, 1, 1, "mag-deal-button-container", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](13, "div", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](14, "mag-deal-participating-products", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelement"](15, "widget-layout", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("objectId", "offer/" + ctx_r0.offerCode)("slug", ctx_r0.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.saleTagImageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer == null ? null : ctx_r0.offer.ImageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", !(ctx_r0.offer == null ? null : ctx_r0.offer.ImageUrl));
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer == null ? null : ctx_r0.offer.DiscountPricing);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer == null ? null : ctx_r0.offer.Name);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer == null ? null : ctx_r0.offer.SalePriceText);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offerExpirationDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.startDate && ctx_r0.endDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer == null ? null : ctx_r0.offer.Description);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer == null ? null : ctx_r0.offer.DisclaimerText);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.isCoupon && (ctx_r0.offer == null ? null : ctx_r0.offer.CanLoad));
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("upcs", ctx_r0.conditionUpcs)("isBundle", ctx_r0.isBundle);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("objectId", "offer/" + ctx_r0.offerCode)("slug", ctx_r0.router.url);
  }
}
function OfferDetailPageComponent_ng_container_9_ng_template_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtemplate"](0, OfferDetailPageComponent_ng_container_9_ng_template_2_div_0_Template, 16, 17, "div", 13);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx_r0.offer);
  }
}
function OfferDetailPageComponent_ng_container_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtemplate"](1, OfferDetailPageComponent_ng_container_9_ng_container_1_Template, 2, 0, "ng-container", 12)(2, OfferDetailPageComponent_ng_container_9_ng_template_2_Template, 1, 1, "ng-template", null, 1, _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const offerDetail_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵreference"](3);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", !ctx_r0.offer)("ngIfElse", offerDetail_r2);
  }
}
class OfferDetailPageComponent {
  route;
  offerService;
  offerProductService;
  cStore;
  cre;
  routeTracker;
  router;
  appSettings;
  ngZone;
  content;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_14__.Subject();
  offer;
  magGallery;
  offerCode;
  transactionId;
  offerExpirationDate;
  startDate;
  endDate;
  isCoupon;
  consolidatedField;
  conditionUpcs;
  participatingProducts;
  isBundle;
  isLoadedParticipatingProducts = false;
  store;
  saleTagImageUrl;
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_14__.Subject();
  unsub;
  isShoppingList = false;
  loaded = false;
  constructor(route, offerService, offerProductService, cStore, cre, routeTracker, router, appSettings, ngZone) {
    this.route = route;
    this.offerService = offerService;
    this.offerProductService = offerProductService;
    this.cStore = cStore;
    this.cre = cre;
    this.routeTracker = routeTracker;
    this.router = router;
    this.appSettings = appSettings;
    this.ngZone = ngZone;
  }
  ngOnInit() {
    var _this = this;
    this.appSettings.getSettingValue('digital_circular_default_sale_tag_image_url').pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_15__.takeUntil)(this.destroy$)).subscribe(value => {
      this.saleTagImageUrl = value;
    });
    this.route.paramMap.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_15__.takeUntil)(this._destroy$)).subscribe(params => {
      this.offerCode = params.get('offerCode');
    });
    const firstLoad = this.route.snapshot.queryParamMap.get('transactionId');
    if (firstLoad) {
      this.transactionId = firstLoad;
    } else {
      this.route.queryParamMap.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_15__.takeUntil)(this._destroy$)).subscribe(/*#__PURE__*/function () {
        var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (queryParams) {
          _this.transactionId = queryParams.get('transactionId');
          if (!_this.transactionId) return;
          yield _this.loadData();
        });
        return function (_x) {
          return _ref.apply(this, arguments);
        };
      }());
    }
    this.routeTracker.getRenderType().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_15__.takeUntil)(this.destroy$)).subscribe(value => {
      this.isShoppingList = value === _rsApp_core_enum__WEBPACK_IMPORTED_MODULE_8__.EnumMagFulfillmentManagementRenderType.ShoppingList;
    });
    this.init();
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
    this.unsub?.unsubscribe();
  }
  ionViewDidEnter() {
    window.addEventListener('scrollToTop', this.handleScrollToTop);
  }
  ionViewWillLeave() {
    window.removeEventListener('scrollToTop', this.handleScrollToTop);
  }
  handleCardClipped(e) {
    const {
      isClipped,
      transactionId
    } = e.detail;
    if (!isClipped) return;
    this.transactionId = transactionId;
    this.loadData();
  }
  handleScrollToTop = () => {
    this.content.scrollToTop();
  };
  loadData() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.loaded = false;
      _this2.offer = yield _this2.fetchOfferData();
      if (!_this2.offer) {
        _this2.ngZone.run(() => {
          _this2.loaded = true;
        });
        console.error('Offer not found');
        return;
      }
      _this2.updateMagGallery(_this2.offer?.ImageUrl);
      _this2.initOfferData();
      _this2.ngZone.run(() => {
        _this2.loaded = true;
      });
    })();
  }
  init() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this3.store = yield _this3.cStore.getStore();
      if (!_this3.store) {
        console.error('Store not found');
        return;
      }
      yield _this3.loadData();
      // await this.initParticipatingData();
      // get UPCs of Offer - TODO
      const {
        ParticipatingUpcs,
        ConditionUpcs,
        IsBundle
      } = _this3.offer || {};
      _this3.conditionUpcs = ParticipatingUpcs?.length > 0 ? ParticipatingUpcs : ConditionUpcs?.length > 0 ? ConditionUpcs.map(x => x.Upcs) : [];
      _this3.isBundle = IsBundle;
    })();
  }
  initOfferData() {
    const {
      ExpirationDate,
      StartDate,
      EndDate,
      ConsolidatedField
    } = this.offer || {};
    this.offerExpirationDate = ExpirationDate ? moment__WEBPACK_IMPORTED_MODULE_2__(ExpirationDate).format('MMM DD, YYYY') : '';
    this.startDate = StartDate ? moment__WEBPACK_IMPORTED_MODULE_2__(StartDate).format('MMM DD, YYYY') : '';
    this.endDate = EndDate ? moment__WEBPACK_IMPORTED_MODULE_2__(EndDate).format('MMM DD, YYYY') : '';
    this.isCoupon = ConsolidatedField === _model_interface__WEBPACK_IMPORTED_MODULE_3__.EnumMagOfferType.StoreCoupon;
    this.consolidatedField = ConsolidatedField;
    this.saleTagImageUrl = this.offer?.CouponDisplayType == _model_interface__WEBPACK_IMPORTED_MODULE_3__.enumCouponDisplayType?.WeeklyAd && this.saleTagImageUrl;
  }
  initParticipatingData() {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        ParticipatingUpcs,
        ConditionUpcs,
        IsBundle
      } = _this4.offer || {};
      _this4.conditionUpcs = ParticipatingUpcs?.length > 0 ? ParticipatingUpcs : ConditionUpcs?.length > 0 ? ConditionUpcs.map(x => x.Upcs) : [];
      if (_this4.conditionUpcs?.length > 0) {
        const dataSource = yield IsBundle ? _this4.processUpcGroups(_this4.conditionUpcs) : _this4.fetchDataByUpcs(_this4.conditionUpcs);
        _this4.participatingProducts = dataSource?.length > 0 ? dataSource : null;
      }
      _this4.isBundle = IsBundle;
      _this4.isLoadedParticipatingProducts = true;
    })();
  }
  processUpcGroups(upcGroups) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const promises = upcGroups.map(group => _this5.fetchDataByUpcs(group));
        const results = yield Promise.all(promises);
        return results;
      } catch (error) {
        console.error('Error processing UPC groups:', error);
        return [];
      }
    })();
  }
  fetchDataByUpcs(upcs) {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      return yield (0,rxjs__WEBPACK_IMPORTED_MODULE_16__.firstValueFrom)(_this6.offerProductService.getParticipatingProducts(upcs, _this6.store?.StoreCode, true, _this6.cre.currentUser));
    })();
  }
  fetchOfferData() {
    var _this7 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const offerData = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_16__.firstValueFrom)(_this7.offerService.getOfferByCode(_this7.store?.StoreCode, _this7.offerCode, _this7.transactionId));
        if (!offerData) return null;
        return offerData;
      } catch (error) {
        console.error('Error fetching offer data:', error);
        return null;
      }
    })();
  }
  updateMagGallery(payload) {
    if (!payload) return;
    this.magGallery = `<mag-gallery image-string='${payload}'></mag-gallery`;
  }
  static ɵfac = function OfferDetailPageComponent_Factory(t) {
    return new (t || OfferDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_17__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_providers_offer_service__WEBPACK_IMPORTED_MODULE_5__.OfferService), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_providers_offer_product_service__WEBPACK_IMPORTED_MODULE_4__.OfferProductService), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_1__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_6__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_7__.RouteTrackerService), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_17__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_9__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_13__.NgZone));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdefineComponent"]({
    type: OfferDetailPageComponent,
    selectors: [["offer-detail"]],
    viewQuery: function OfferDetailPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵviewQuery"](_ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonContent, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵloadQuery"]()) && (ctx.content = _t.first);
      }
    },
    hostBindings: function OfferDetailPageComponent_HostBindings(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵlistener"]("couponIsClipped", function OfferDetailPageComponent_couponIsClipped_HostBindingHandler($event) {
          return ctx.handleCardClipped($event);
        }, false, _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵresolveWindow"]);
      }
    },
    decls: 10,
    vars: 9,
    consts: [["content", ""], ["offerDetail", ""], ["type", "offer", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "offer", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], [1, "ion-padding"], [4, "ngIf"], ["type", "offer", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "offer", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "loading-container"], ["name", "crescent"], [4, "ngIf", "ngIfElse"], ["class", "offer-detail", 4, "ngIf"], [1, "offer-detail"], ["type", "offer", "zoneName", "Top", 3, "objectId", "slug"], ["class", "offer-detail__img-box offer-detail__sale-tag", 4, "ngIf"], ["class", "offer-detail__img-box offer-detail__img", 4, "ngIf"], ["class", "offer-detail__img-box offer-detail__default-img", 4, "ngIf"], ["class", "offer-detail__display-name mb-200", 4, "ngIf"], ["class", "offer-detail__description mb-200", 4, "ngIf"], ["class", "offer-detail__sale-text mb-200", 4, "ngIf"], ["class", "offer-detail__expiration-date mb-200", 4, "ngIf"], ["class", "offer-detail__valid-date mb-200", 4, "ngIf"], ["class", "offer-detail__disclaimer-text mb-200", 4, "ngIf"], ["class", "offer-detail__disclaimer-text", 4, "ngIf"], [3, "offer", 4, "ngIf"], [1, "offer-detail__participating-products"], [3, "upcs", "isBundle"], ["type", "offer", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "offer-detail__img-box", "offer-detail__sale-tag"], [3, "src"], [1, "offer-detail__img-box", "offer-detail__img"], ["ratio", "square", 3, "src"], [1, "offer-detail__img-box", "offer-detail__default-img"], ["src", ""], [1, "offer-detail__display-name", "mb-200"], [1, "offer-detail__description", "mb-200"], [1, "offer-detail__sale-text", "mb-200"], ["src", "../assets/icon/phone-ring.svg"], [1, "offer-detail__expiration-date", "mb-200"], [3, "expirationDate"], [1, "offer-detail__valid-date", "mb-200"], [1, "offer-detail__disclaimer-text", "mb-200"], [1, "offer-detail__disclaimer-text"], [3, "offer"]],
    template: function OfferDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtemplate"](0, OfferDetailPageComponent_widget_layout_0_Template, 1, 2, "widget-layout", 2)(1, OfferDetailPageComponent_widget_layout_1_Template, 1, 2, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](2, "app-header", 4)(3, "ion-title", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵpipe"](5, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementStart"](6, "ion-content", 6, 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtemplate"](8, OfferDetailPageComponent_ng_container_8_Template, 3, 0, "ng-container", 7)(9, OfferDetailPageComponent_ng_container_9_Template, 4, 2, "ng-container", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵpipeBind1"](5, 7, "offer.title"));
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", !ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵproperty"]("ngIf", ctx.loaded);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_19__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonSpinner, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_10__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_11__.HeaderComponent, _shared_page_not_found_not_found__WEBPACK_IMPORTED_MODULE_12__.NotFoundPageComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_20__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\n\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n  --background-activated: none;\n}\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: var(--mag-spacing-600, 48px);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n\n.title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.offer-detail[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-style: normal;\n  padding-bottom: 60px;\n  --mag-icon-size: 16px;\n}\n.offer-detail__img[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n.offer-detail__img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 343px;\n  height: 343px;\n  object-fit: contain;\n}\n.offer-detail__img-box[_ngcontent-%COMP%] {\n  max-width: 343px;\n  margin-left: auto;\n  margin-right: auto;\n}\n.offer-detail__sale-tag[_ngcontent-%COMP%] {\n  position: absolute;\n  z-index: 10;\n  width: 240px;\n}\n.offer-detail__display-name[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-pricing-deal, #da0808);\n  font-size: var(--mag-typography-deal-large-font-size, 28px);\n  font-weight: var(--mag-typography-deal-font-weight, 500);\n  line-height: var(--mag-typography-deal-large-line-height, 36px);\n}\n.offer-detail__description[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  font-size: var(--mag-typography-headlines-large-font-size, 24px);\n  font-weight: var(--mag-typography-headlines-large-font-weight, 500);\n  line-height: var(--mag-typography-headlines-large-line-height, 32px);\n  font-family: var(--mag-typography-font-family, Lexend);\n}\n.offer-detail__expiration-date[_ngcontent-%COMP%], .offer-detail__valid-date[_ngcontent-%COMP%], .offer-detail__disclaimer-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.offer-detail__sale-text[_ngcontent-%COMP%] {\n  display: flex;\n  gap: var(--mag-spacing-100, 8px);\n  color: var(--mag-color-text-pricing-deal, #da0808);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.offer-detail__expiration-date[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  display: flex;\n  align-items: center;\n  gap: 8px;\n}\n.offer-detail__participating-products[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-400, 32px);\n  margin-bottom: var(--mag-spacing-500, 40px);\n}\n.offer-detail__clipped-label[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-200, 16px);\n  margin-left: var(--mag-spacing-100, 8px);\n}\n\n.mb-200[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n\nion-icon[_ngcontent-%COMP%] {\n  font-size: 24px;\n}\n\n.loading-container[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL29mZmVyLWRldGFpbC9vZmZlci1kZXRhaWwuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLG9EQUFBO0VBQ0EsMkNBQUE7RUFDQSw4Q0FBQTtFQUNBLDJDQUFBO0VBQ0EsNkNBQUE7RUFDQSx3REFBQTtBQUNGOztBQUdFO0VBQ0UsMERBQUE7RUFDQSw0QkFBQTtBQUFKO0FBR0U7RUFDRSxvQ0FBQTtBQURKOztBQUtBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDZDQUFBO0VBQ0EsMkNBQUE7QUFGRjs7QUFLQTtFQUNFLDZDQUFBO0VBQ0Esa0JBQUE7RUFFQSxzREFBQTtFQUNBLGdFQUFBO0VBQ0Esa0JBQUE7RUFDQSxtRUFBQTtFQUNBLG9FQUFBO0FBSEY7O0FBTUE7RUFDRSw2Q0FBQTtFQUNBLCtEQUFBO0VBQ0Esa0JBQUE7RUFDQSxvQkFBQTtFQUNBLHFCQUFBO0FBSEY7QUFLRTtFQUNFLDJDQUFBO0FBSEo7QUFLSTtFQUNFLFlBQUE7RUFDQSxhQUFBO0VBQ0EsbUJBQUE7QUFITjtBQU9FO0VBQ0UsZ0JBQUE7RUFDQSxpQkFBQTtFQUNBLGtCQUFBO0FBTEo7QUFRRTtFQUNFLGtCQUFBO0VBQ0EsV0FBQTtFQUNBLFlBQUE7QUFOSjtBQVNFO0VBQ0Usa0RBQUE7RUFDQSwyREFBQTtFQUNBLHdEQUFBO0VBQ0EsK0RBQUE7QUFQSjtBQVVFO0VBQ0UsNENBQUE7RUFDQSxnRUFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7RUFDQSxzREFBQTtBQVJKO0FBV0U7RUFHRSw2Q0FBQTtFQUNBLDREQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtBQVhKO0FBY0U7RUFDRSxhQUFBO0VBQ0EsZ0NBQUE7RUFDQSxrREFBQTtFQUNBLGtCQUFBO0VBQ0EsMEVBQUE7RUFDQSw0REFBQTtFQUNBLGdFQUFBO0FBWko7QUFlRTtFQUNFLDRDQUFBO0VBQ0EsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsUUFBQTtBQWJKO0FBZ0JFO0VBQ0Usd0NBQUE7RUFDQSwyQ0FBQTtBQWRKO0FBaUJFO0VBQ0Usd0NBQUE7RUFDQSx3Q0FBQTtBQWZKOztBQW1CQTtFQUNFLDJDQUFBO0FBaEJGOztBQW1CQTtFQUNFLGVBQUE7QUFoQkY7O0FBbUJBO0VBQ0UsV0FBQTtFQUNBLFlBQUE7RUFDQSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtBQWhCRiIsInNvdXJjZXNDb250ZW50IjpbImlvbi10b29sYmFyIHtcbiAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbiAgLS1wYWRkaW5nLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLWVuZDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLXN0YXJ0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBib3JkZXItYm90dG9tOiAxcHggc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyKTtcbn1cblxuaW9uLWZvb3RlciB7XG4gIGlvbi1idXR0b24ge1xuICAgIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWJyYW5kLWZvdW5kYXRpb24tcHJpbWFyeSwgIzAwODAwMCk7XG4gICAgLS1iYWNrZ3JvdW5kLWFjdGl2YXRlZDogbm9uZTtcbiAgfVxuXG4gIGlvbi1idXR0b246OnBhcnQobmF0aXZlKSB7XG4gICAgaGVpZ2h0OiB2YXIoLS1tYWctc3BhY2luZy02MDAsIDQ4cHgpO1xuICB9XG59XG5cbmlvbi1jb250ZW50IHtcbiAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbiAgLS1wYWRkaW5nLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KTtcbiAgLS1wYWRkaW5nLXN0YXJ0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctZW5kOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuXG4udGl0bGUge1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gIHRleHQtYWxpZ246IGNlbnRlcjtcblxuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksIExleGVuZCk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNTAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG59XG5cbi5vZmZlci1kZXRhaWwge1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgZm9udC1zdHlsZTogbm9ybWFsO1xuICBwYWRkaW5nLWJvdHRvbTogNjBweDtcbiAgLS1tYWctaWNvbi1zaXplOiAxNnB4O1xuXG4gICZfX2ltZyB7XG4gICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KTtcblxuICAgIGltZyB7XG4gICAgICB3aWR0aDogMzQzcHg7XG4gICAgICBoZWlnaHQ6IDM0M3B4O1xuICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICB9XG4gIH1cblxuICAmX19pbWctYm94IHtcbiAgICBtYXgtd2lkdGg6IDM0M3B4O1xuICAgIG1hcmdpbi1sZWZ0OiBhdXRvO1xuICAgIG1hcmdpbi1yaWdodDogYXV0bztcbiAgfVxuXG4gICZfX3NhbGUtdGFnIHtcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgei1pbmRleDogMTA7XG4gICAgd2lkdGg6IDI0MHB4O1xuICB9XG5cbiAgJl9fZGlzcGxheS1uYW1lIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpY2luZy1kZWFsLCAjZGEwODA4KTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRlYWwtbGFyZ2UtZm9udC1zaXplLCAyOHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGVhbC1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGVhbC1sYXJnZS1saW5lLWhlaWdodCwgMzZweCk7XG4gIH1cblxuICAmX19kZXNjcmlwdGlvbiB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXNlY29uZGFyeSwgIzU1NSk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtZm9udC1zaXplLCAyNHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLWxhcmdlLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtbGluZS1oZWlnaHQsIDMycHgpO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgfVxuXG4gICZfX2V4cGlyYXRpb24tZGF0ZSxcbiAgJl9fdmFsaWQtZGF0ZSxcbiAgJl9fZGlzY2xhaW1lci10ZXh0IHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gIH1cblxuICAmX19zYWxlLXRleHQge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaWNpbmctZGVhbCwgI2RhMDgwOCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG5cbiAgJl9fZXhwaXJhdGlvbi1kYXRlIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtc2Vjb25kYXJ5LCAjNTU1KTtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgZ2FwOiA4cHg7XG4gIH1cblxuICAmX19wYXJ0aWNpcGF0aW5nLXByb2R1Y3RzIHtcbiAgICBtYXJnaW4tdG9wOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTUwMCwgNDBweCk7XG4gIH1cblxuICAmX19jbGlwcGVkLWxhYmVsIHtcbiAgICBtYXJnaW4tdG9wOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAgIG1hcmdpbi1sZWZ0OiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gIH1cbn1cblxuLm1iLTIwMCB7XG4gIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG5cbmlvbi1pY29uIHtcbiAgZm9udC1zaXplOiAyNHB4O1xufVxuXG4ubG9hZGluZy1jb250YWluZXIge1xuICB3aWR0aDogMTAwJTtcbiAgaGVpZ2h0OiAxMDAlO1xuICBkaXNwbGF5OiBmbGV4O1xuICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 73417:
/*!**********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/offer-list/offer-list.ts ***!
  \**********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferListPageComponent: () => (/* binding */ OfferListPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var _providers_offer_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../providers/offer.service */ 811);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);










class OfferListPageComponent {
  router;
  route;
  dxpComponentService;
  offerService;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_3__.Subject();
  magDealContainer;
  tab;
  constructor(router, route, dxpComponentService, offerService) {
    this.router = router;
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.offerService = offerService;
  }
  static ɵfac = function OfferListPageComponent_Factory(t) {
    return new (t || OfferListPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_providers_offer_service__WEBPACK_IMPORTED_MODULE_1__.OfferService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
    type: OfferListPageComponent,
    selectors: [["offer-list"]],
    decls: 7,
    vars: 2,
    consts: [[1, "widget-layout"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "offer-list"], ["id", "offers-list", "active-page", "deals"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function OfferListPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "ion-content")(1, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "widget-layout", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](4, "mag-deal-container", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](5, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](6, "widget-layout", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\n\nion-toolbar[_ngcontent-%COMP%] {\n  --border-width: 0 !important;\n  --background: var(--mag-color-surface-primary, #fff);\n}\n\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n  --background-activated: none;\n}\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: var(--mag-spacing-600, 48px);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n}\n\n.title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.mb-200[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n\n.widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL29mZmVyLWxpc3Qvb2ZmZXItbGlzdC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLHdEQUFBO0FBQ0Y7O0FBRUE7RUFDRSw0QkFBQTtFQUNBLG9EQUFBO0FBQ0Y7O0FBR0U7RUFDRSwwREFBQTtFQUNBLDRCQUFBO0FBQUo7QUFHRTtFQUNFLG9DQUFBO0FBREo7O0FBS0E7RUFDRSxvREFBQTtBQUZGOztBQUtBO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUVBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFIRjs7QUFNQTtFQUNFLDJDQUFBO0FBSEY7O0FBTUE7RUFDRSx1Q0FBQTtBQUhGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLXRvb2xiYXIge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctZW5kOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLWRpdmlkZXIpO1xufVxuXG5pb24tdG9vbGJhciB7XG4gIC0tYm9yZGVyLXdpZHRoOiAwICFpbXBvcnRhbnQ7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG59XG5cbmlvbi1mb290ZXIge1xuICBpb24tYnV0dG9uIHtcbiAgICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1icmFuZC1mb3VuZGF0aW9uLXByaW1hcnksICMwMDgwMDApO1xuICAgIC0tYmFja2dyb3VuZC1hY3RpdmF0ZWQ6IG5vbmU7XG4gIH1cblxuICBpb24tYnV0dG9uOjpwYXJ0KG5hdGl2ZSkge1xuICAgIGhlaWdodDogdmFyKC0tbWFnLXNwYWNpbmctNjAwLCA0OHB4KTtcbiAgfVxufVxuXG5pb24tY29udGVudCB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG59XG5cbi50aXRsZSB7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuXG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgZm9udC1zdHlsZTogbm9ybWFsO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbn1cblxuLm1iLTIwMCB7XG4gIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG5cbi53aWRnZXQtbGF5b3V0IHtcbiAgcGFkZGluZzogMCB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 86329:
/*!****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/reward-detail/reward-detail.ts ***!
  \****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RewardDetailPageComponent: () => (/* binding */ RewardDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _ionic_storage__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ionic/storage */ 60850);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/utils/constants/constants */ 29665);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! moment */ 39545);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_6___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_6__);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var _providers_offer_product_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../providers/offer-product.service */ 31485);
/* harmony import */ var _providers_offer_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../providers/offer.service */ 811);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);

























function RewardDetailPageComponent_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "ion-spinner", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
}
function RewardDetailPageComponent_div_8_div_2_div_1_mag_img_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "mag-img", 28);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("src", ctx_r0.reward == null ? null : ctx_r0.reward.ImageTagUrl);
  }
}
function RewardDetailPageComponent_div_8_div_2_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](1, RewardDetailPageComponent_div_8_div_2_div_1_mag_img_1_Template, 1, 1, "mag-img", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](2, "mag-img", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward == null ? null : ctx_r0.reward.ImageTagUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("src", ctx_r0.reward == null ? null : ctx_r0.reward.ImageUrl);
  }
}
function RewardDetailPageComponent_div_8_div_2_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "mag-img", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
}
function RewardDetailPageComponent_div_8_div_2_ng_container_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](1, "div", 31)(2, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate1"]("Free with ", ctx_r0.reward.ClipPoint, " points");
  }
}
function RewardDetailPageComponent_div_8_div_2_ng_template_4_div_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 31)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate2"]("", ctx_r0.reward == null ? null : ctx_r0.reward.ClippedInfo == null ? null : ctx_r0.reward.ClippedInfo.ClippedValueDisplay, " ", ctx_r0.labelArr == null ? null : ctx_r0.labelArr.clipped_balance_type, "");
  }
}
function RewardDetailPageComponent_div_8_div_2_ng_template_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](0, RewardDetailPageComponent_div_8_div_2_ng_template_4_div_0_Template, 3, 2, "div", 32);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward == null ? null : ctx_r0.reward.ClippedInfo == null ? null : ctx_r0.reward.ClippedInfo.ClippedValueDisplay);
  }
}
function RewardDetailPageComponent_div_8_div_2_div_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 33)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate"](ctx_r0.reward.Name);
  }
}
function RewardDetailPageComponent_div_8_div_2_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 34)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](3, "mag-deal-expire-badge", 35);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate1"]("Expires: ", ctx_r0.offerExpirationDate, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("expirationDate", ctx_r0.reward == null ? null : ctx_r0.reward.ExpirationEndDate);
  }
}
function RewardDetailPageComponent_div_8_div_2_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 36)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate2"]("Valid: ", ctx_r0.startDate, " - ", ctx_r0.endDate, "");
  }
}
function RewardDetailPageComponent_div_8_div_2_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 37)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtextInterpolate"](ctx_r0.reward.Description);
  }
}
function RewardDetailPageComponent_div_8_div_2_div_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 38);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "mag-deal-participating-products", 39);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("upcs", ctx_r0.conditionUpcs)("isBundle", ctx_r0.isBundle);
  }
}
function RewardDetailPageComponent_div_8_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](1, RewardDetailPageComponent_div_8_div_2_div_1_Template, 3, 2, "div", 16)(2, RewardDetailPageComponent_div_8_div_2_div_2_Template, 2, 0, "div", 17)(3, RewardDetailPageComponent_div_8_div_2_ng_container_3_Template, 4, 1, "ng-container", 18)(4, RewardDetailPageComponent_div_8_div_2_ng_template_4_Template, 1, 1, "ng-template", null, 1, _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplateRefExtractor"])(6, RewardDetailPageComponent_div_8_div_2_div_6_Template, 3, 1, "div", 19)(7, RewardDetailPageComponent_div_8_div_2_div_7_Template, 4, 2, "div", 20)(8, RewardDetailPageComponent_div_8_div_2_div_8_Template, 3, 2, "div", 21)(9, RewardDetailPageComponent_div_8_div_2_div_9_Template, 3, 1, "div", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](10, "mag-deal-button-container", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](11, RewardDetailPageComponent_div_8_div_2_div_11_Template, 2, 2, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const rewardClaimPoint_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵreference"](5);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward == null ? null : ctx_r0.reward.ImageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", !(ctx_r0.reward == null ? null : ctx_r0.reward.ImageUrl));
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward == null ? null : ctx_r0.reward.ClipPoint)("ngIfElse", rewardClaimPoint_r2);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward == null ? null : ctx_r0.reward.Name);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.offerExpirationDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.startDate && ctx_r0.endDate);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward == null ? null : ctx_r0.reward.Description);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("offer", ctx_r0.reward)("type", "reward")("isLoaded", !!ctx_r0.clippedRewardId);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.isLoadedParticipatingProducts);
  }
}
function RewardDetailPageComponent_div_8_ng_template_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](1, "Reward not found");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
}
function RewardDetailPageComponent_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](1, "widget-layout", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](2, RewardDetailPageComponent_div_8_div_2_Template, 12, 12, "div", 13)(3, RewardDetailPageComponent_div_8_ng_template_3_Template, 2, 0, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](5, "widget-layout", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const noReward_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵreference"](4);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx_r0.reward)("ngIfElse", noReward_r3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
class RewardDetailPageComponent {
  router;
  route;
  rewardService;
  offerProductService;
  cStore;
  cre;
  appSettings;
  translate;
  storage;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_12__.Subject();
  reward;
  offerCode;
  programCode;
  clippedRewardId;
  offerExpirationDate;
  startDate;
  endDate;
  conditionUpcs;
  participatingProducts;
  isBundle;
  isLoadedParticipatingProducts = false;
  store;
  returnRoute;
  isLoading = true;
  labelArr;
  defaultProgramCode = 'free-products';
  constructor(router, route, rewardService, offerProductService, cStore, cre, appSettings, translate, storage) {
    this.router = router;
    this.route = route;
    this.rewardService = rewardService;
    this.offerProductService = offerProductService;
    this.cStore = cStore;
    this.cre = cre;
    this.appSettings = appSettings;
    this.translate = translate;
    this.storage = storage;
  }
  ngOnInit() {
    this.route.paramMap.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_13__.takeUntil)(this._destroy$)).subscribe(params => {
      this.offerCode = params.get('offerCode');
    });
    this.route.queryParamMap.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_13__.takeUntil)(this._destroy$)).subscribe(queryParams => {
      this.programCode = queryParams.get('programCode');
      this.clippedRewardId = queryParams.get('clippedRewardId');
      this.returnRoute = queryParams.get('returnRoute');
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
        yield _this.init();
      } catch (error) {
        console.error(error);
      }
    })();
  }
  init() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.store = yield _this2.cStore.getStore();
      if (!_this2.store) {
        console.error('Store not found');
        return;
      }
      const locale = _this2.translate.currentLang || (yield _this2.storage.get(_rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__.LOCAL_LOCALE_KEY)) || _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_4__.DEFAULT_LOCALE;
      const rs = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_14__.firstValueFrom)(_this2.appSettings.getSettingByPath('LOYALTY'));
      const programLabel = rs[`${_this2.programCode.replace('-', '_')}_program_label_settings`];
      _this2.labelArr = programLabel && programLabel.reduce((pre, curr) => ({
        ...pre,
        [curr.SettingName]: curr.SettingValue[locale]
      }), {});
      _this2.reward = yield _this2.fetchRewardData();
      if (!_this2.reward) {
        console.error('Reward not found');
        _this2.isLoading = false;
        return;
      }
      _this2.initRewardData();
      yield _this2.initParticipatingData();
      _this2.isLoading = false;
    })();
  }
  initRewardData() {
    const {
      ExpirationDate,
      StartDate,
      EndDate
    } = this.reward || {};
    this.offerExpirationDate = ExpirationDate ? moment__WEBPACK_IMPORTED_MODULE_6__(ExpirationDate).format('MMM DD, YYYY') : '';
    this.startDate = StartDate ? moment__WEBPACK_IMPORTED_MODULE_6__(StartDate).format('MMM DD, YYYY') : '';
    this.endDate = EndDate ? moment__WEBPACK_IMPORTED_MODULE_6__(EndDate).format('MMM DD, YYYY') : '';
  }
  initParticipatingData() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        ProductUPCs,
        IsBundle
      } = _this3.reward || {};
      _this3.conditionUpcs = ProductUPCs?.length > 0 ? ProductUPCs.map(upc => _this3.padLeadingZeros(upc, 14)) : [];
      if (_this3.conditionUpcs?.length > 0) {
        const dataSource = yield _this3.fetchDataByUpcs(_this3.conditionUpcs);
        _this3.participatingProducts = dataSource?.length > 0 ? dataSource : null;
      }
      _this3.isBundle = IsBundle;
      _this3.isLoadedParticipatingProducts = true;
    })();
  }
  processUpcGroups(upcGroups) {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const promises = upcGroups.map(group => _this4.fetchDataByUpcs(group));
        const results = yield Promise.all(promises);
        return results;
      } catch (error) {
        console.error('Error processing UPC groups:', error);
        return [];
      }
    })();
  }
  fetchDataByUpcs(upcs) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      return yield (0,rxjs__WEBPACK_IMPORTED_MODULE_14__.firstValueFrom)(_this5.offerProductService.getParticipatingProducts(upcs, _this5.store?.StoreCode, true, _this5.cre.currentUser));
    })();
  }
  fetchRewardData() {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const data = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_14__.firstValueFrom)(_this6.rewardService.getRewardDetail(_this6.offerCode, _this6.programCode, _this6.clippedRewardId));
        if (!data) return null;
        return data;
      } catch (error) {
        console.error('Error fetching reward data:', error);
        return null;
      }
    })();
  }
  padLeadingZeros(num, size) {
    let s = num + '';
    while (s.length < size) s = '0' + s;
    return s;
  }
  static ɵfac = function RewardDetailPageComponent_Factory(t) {
    return new (t || RewardDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_15__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_15__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_providers_offer_service__WEBPACK_IMPORTED_MODULE_8__.OfferService), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_providers_offer_product_service__WEBPACK_IMPORTED_MODULE_7__.OfferProductService), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_3__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_2__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_5__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_16__.TranslateService), _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdirectiveInject"](_ionic_storage__WEBPACK_IMPORTED_MODULE_1__.Storage));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵdefineComponent"]({
    type: RewardDetailPageComponent,
    selectors: [["reward-detail"]],
    decls: 9,
    vars: 7,
    consts: [["noReward", ""], ["rewardClaimPoint", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], [1, "ion-padding"], ["class", "center-page", 4, "ngIf"], [4, "ngIf"], [1, "center-page"], ["name", "circles"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["class", "offer-detail", 4, "ngIf", "ngIfElse"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "offer-detail"], ["class", "offer-detail__img", 4, "ngIf"], ["class", "offer-detail__default-img", 4, "ngIf"], [4, "ngIf", "ngIfElse"], ["class", "offer-detail__description mb-200", 4, "ngIf"], ["class", "offer-detail__expiration-date mb-200", 4, "ngIf"], ["class", "offer-detail__valid-date mb-200", 4, "ngIf"], ["class", "offer-detail__disclaimer-text mb-200", 4, "ngIf"], [3, "offer", "type", "isLoaded"], ["class", "offer-detail__participating-products", 4, "ngIf"], [1, "offer-detail__img"], ["class", "offer-detail__img-tag", 3, "src", 4, "ngIf"], ["ratio", "square", 3, "src"], [1, "offer-detail__img-tag", 3, "src"], [1, "offer-detail__default-img"], ["src", ""], [1, "offer-detail__display-name", "mb-200"], ["class", "offer-detail__display-name mb-200", 4, "ngIf"], [1, "offer-detail__description", "mb-200"], [1, "offer-detail__expiration-date", "mb-200"], [3, "expirationDate"], [1, "offer-detail__valid-date", "mb-200"], [1, "offer-detail__disclaimer-text", "mb-200"], [1, "offer-detail__participating-products"], [3, "upcs", "isBundle"]],
    template: function RewardDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelement"](0, "widget-layout", 2)(1, "widget-layout", 3)(2, "widget-layout", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](3, "app-header", 5)(4, "ion-title", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtext"](5, "Deals Details");
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementStart"](6, "ion-content", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵtemplate"](7, RewardDetailPageComponent_div_7_Template, 2, 0, "div", 8)(8, RewardDetailPageComponent_div_8_Template, 6, 4, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", ctx.isLoading);
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_11__["ɵɵproperty"]("ngIf", !ctx.isLoading);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_17__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonSpinner, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_18__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_9__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_10__.HeaderComponent],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\n\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n  --background-activated: none;\n}\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: var(--mag-spacing-600, 48px);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n\n.title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.offer-detail[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-style: normal;\n  padding-bottom: 60px;\n}\n.offer-detail__img[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n  position: relative;\n}\n.offer-detail__img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 343px;\n  height: 343px;\n  object-fit: contain;\n}\n.offer-detail__img-tag[_ngcontent-%COMP%] {\n  position: absolute;\n  top: 0;\n  left: 0;\n  width: 100%;\n  max-width: 200px;\n  z-index: 1;\n}\n.offer-detail__display-name[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-pricing-deal, #da0808);\n  font-size: var(--mag-typography-deal-large-font-size, 28px);\n  font-weight: var(--mag-typography-deal-font-weight, 500);\n  line-height: var(--mag-typography-deal-large-line-height, 36px); \n\n}\n.offer-detail__description[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  font-size: var(--mag-typography-headlines-large-font-size, 24px);\n  font-weight: var(--mag-typography-headlines-large-font-weight, 500);\n  line-height: var(--mag-typography-headlines-large-line-height, 32px); \n\n}\n.offer-detail__expiration-date[_ngcontent-%COMP%], .offer-detail__valid-date[_ngcontent-%COMP%], .offer-detail__disclaimer-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px); \n\n}\n.offer-detail__expiration-date[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  display: flex;\n  align-items: center;\n  gap: 8px;\n}\n.offer-detail__participating-products[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-400, 32px);\n  margin-bottom: var(--mag-spacing-500, 40px);\n}\n.offer-detail__clipped-label[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-200, 16px);\n  margin-left: var(--mag-spacing-100, 8px);\n}\n\n.mb-200[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n\n.btn-load-wrapper[_ngcontent-%COMP%] {\n  position: fixed;\n  bottom: 0;\n  left: 0;\n  right: 0;\n  z-index: 3;\n  padding: var(--mag-spacing-200, 16px);\n  border-top: var(--mag-border-width-100, 1px) solid var(--mag-color-border-divider, #eee);\n  background: var(--mag-color-surface-primary, #fff);\n}\n.btn-load-wrapper[_ngcontent-%COMP%]   mag-rewards-button[_ngcontent-%COMP%] {\n  position: relative;\n  z-index: 2;\n}\n\n.center-page[_ngcontent-%COMP%] {\n  height: 100%;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL3Jld2FyZC1kZXRhaWwvcmV3YXJkLWRldGFpbC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLHdEQUFBO0FBQ0Y7O0FBR0U7RUFDRSwwREFBQTtFQUNBLDRCQUFBO0FBQUo7QUFHRTtFQUNFLG9DQUFBO0FBREo7O0FBS0E7RUFDRSxvREFBQTtFQUNBLDJDQUFBO0VBQ0EsNkNBQUE7RUFDQSwyQ0FBQTtBQUZGOztBQUtBO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUVBLHNEQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFIRjs7QUFNQTtFQUNFLDZDQUFBO0VBQ0EsK0RBQUE7RUFDQSxrQkFBQTtFQUNBLG9CQUFBO0FBSEY7QUFLRTtFQUNFLDJDQUFBO0VBQ0Esa0JBQUE7QUFISjtBQUtJO0VBQ0UsWUFBQTtFQUNBLGFBQUE7RUFDQSxtQkFBQTtBQUhOO0FBT0U7RUFDRSxrQkFBQTtFQUNBLE1BQUE7RUFDQSxPQUFBO0VBQ0EsV0FBQTtFQUNBLGdCQUFBO0VBQ0EsVUFBQTtBQUxKO0FBUUU7RUFDRSxrREFBQTtFQUNBLDJEQUFBO0VBQ0Esd0RBQUE7RUFDQSwrREFBQSxFQUFBLGFBQUE7QUFOSjtBQVNFO0VBQ0UsNENBQUE7RUFDQSxnRUFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUEsRUFBQSxhQUFBO0FBUEo7QUFVRTtFQUdFLDZDQUFBO0VBQ0EsNERBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBLEVBQUEsU0FBQTtBQVZKO0FBYUU7RUFDRSw0Q0FBQTtFQUNBLGFBQUE7RUFDQSxtQkFBQTtFQUNBLFFBQUE7QUFYSjtBQWNFO0VBQ0Usd0NBQUE7RUFDQSwyQ0FBQTtBQVpKO0FBZUU7RUFDRSx3Q0FBQTtFQUNBLHdDQUFBO0FBYko7O0FBaUJBO0VBQ0UsMkNBQUE7QUFkRjs7QUFpQkE7RUFDRSxlQUFBO0VBQ0EsU0FBQTtFQUNBLE9BQUE7RUFDQSxRQUFBO0VBQ0EsVUFBQTtFQUNBLHFDQUFBO0VBQ0Esd0ZBQUE7RUFDQSxrREFBQTtBQWRGO0FBZ0JFO0VBQ0Usa0JBQUE7RUFDQSxVQUFBO0FBZEo7O0FBa0JBO0VBQ0UsWUFBQTtFQUNBLGFBQUE7RUFDQSx1QkFBQTtFQUNBLG1CQUFBO0FBZkYiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tdG9vbGJhciB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1zdGFydDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItZGl2aWRlcik7XG59XG5cbmlvbi1mb290ZXIge1xuICBpb24tYnV0dG9uIHtcbiAgICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1icmFuZC1mb3VuZGF0aW9uLXByaW1hcnksICMwMDgwMDApO1xuICAgIC0tYmFja2dyb3VuZC1hY3RpdmF0ZWQ6IG5vbmU7XG4gIH1cblxuICBpb24tYnV0dG9uOjpwYXJ0KG5hdGl2ZSkge1xuICAgIGhlaWdodDogdmFyKC0tbWFnLXNwYWNpbmctNjAwLCA0OHB4KTtcbiAgfVxufVxuXG5pb24tY29udGVudCB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG4gIC0tcGFkZGluZy1zdGFydDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLWVuZDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cblxuLnRpdGxlIHtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG5cbiAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCBMZXhlbmQpO1xuICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXNpemUsIDE4cHgpO1xuICBmb250LXN0eWxlOiBub3JtYWw7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDUwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xufVxuXG4ub2ZmZXItZGV0YWlsIHtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksIExleGVuZCk7XG4gIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgcGFkZGluZy1ib3R0b206IDYwcHg7XG5cbiAgJl9faW1nIHtcbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcblxuICAgIGltZyB7XG4gICAgICB3aWR0aDogMzQzcHg7XG4gICAgICBoZWlnaHQ6IDM0M3B4O1xuICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICB9XG4gIH1cblxuICAmX19pbWctdGFnIHtcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgdG9wOiAwO1xuICAgIGxlZnQ6IDA7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgbWF4LXdpZHRoOiAyMDBweDtcbiAgICB6LWluZGV4OiAxO1xuICB9XG5cbiAgJl9fZGlzcGxheS1uYW1lIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpY2luZy1kZWFsLCAjZGEwODA4KTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRlYWwtbGFyZ2UtZm9udC1zaXplLCAyOHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGVhbC1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGVhbC1sYXJnZS1saW5lLWhlaWdodCwgMzZweCk7IC8qIDEyOC41NzElICovXG4gIH1cblxuICAmX19kZXNjcmlwdGlvbiB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXNlY29uZGFyeSwgIzU1NSk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtZm9udC1zaXplLCAyNHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLWxhcmdlLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtbGluZS1oZWlnaHQsIDMycHgpOyAvKiAxMzMuMzMzJSAqL1xuICB9XG5cbiAgJl9fZXhwaXJhdGlvbi1kYXRlLFxuICAmX192YWxpZC1kYXRlLFxuICAmX19kaXNjbGFpbWVyLXRleHQge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTsgLyogMTUwJSAqL1xuICB9XG5cbiAgJl9fZXhwaXJhdGlvbi1kYXRlIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtc2Vjb25kYXJ5LCAjNTU1KTtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgZ2FwOiA4cHg7XG4gIH1cblxuICAmX19wYXJ0aWNpcGF0aW5nLXByb2R1Y3RzIHtcbiAgICBtYXJnaW4tdG9wOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTUwMCwgNDBweCk7XG4gIH1cblxuICAmX19jbGlwcGVkLWxhYmVsIHtcbiAgICBtYXJnaW4tdG9wOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAgIG1hcmdpbi1sZWZ0OiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gIH1cbn1cblxuLm1iLTIwMCB7XG4gIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG5cbi5idG4tbG9hZC13cmFwcGVyIHtcbiAgcG9zaXRpb246IGZpeGVkO1xuICBib3R0b206IDA7XG4gIGxlZnQ6IDA7XG4gIHJpZ2h0OiAwO1xuICB6LWluZGV4OiAzO1xuICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBib3JkZXItdG9wOiB2YXIoLS1tYWctYm9yZGVyLXdpZHRoLTEwMCwgMXB4KSBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLWRpdmlkZXIsICNlZWUpO1xuICBiYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcblxuICBtYWctcmV3YXJkcy1idXR0b24ge1xuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcbiAgICB6LWluZGV4OiAyO1xuICB9XG59XG5cbi5jZW50ZXItcGFnZSB7XG4gIGhlaWdodDogMTAwJTtcbiAgZGlzcGxheTogZmxleDtcbiAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 6137:
/*!****************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/pages/rewards/rewards.ts ***!
  \****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RewardsPageComponent: () => (/* binding */ RewardsPageComponent)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ 51567);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ 91817);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);








function RewardsPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](0, "widget-layout", 5);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function RewardsPageComponent_widget_layout_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](0, "widget-layout", 6);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
class RewardsPageComponent {
  router;
  cdr;
  loaded = true;
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_2__.Subject();
  previousUrl = '';
  needResetRewardTab = false;
  constructor(router, cdr) {
    this.router = router;
    this.cdr = cdr;
  }
  ngOnInit() {
    this.router.events.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_3__.filter)(ev => ev instanceof _angular_router__WEBPACK_IMPORTED_MODULE_4__.NavigationEnd), (0,rxjs__WEBPACK_IMPORTED_MODULE_5__.distinctUntilChanged)(), (0,rxjs__WEBPACK_IMPORTED_MODULE_6__.takeUntil)(this.destroy$)).subscribe(event => {
      const currentUrl = event.url;
      const isRewardsPage = currentUrl.includes('/tabs/deals/rewards');
      const isDealsTab = currentUrl.includes('/tabs/deals');
      const wasInDealsTab = this.previousUrl.includes('/tabs/deals');
      const isLeavingDealsTab = wasInDealsTab && !isDealsTab;
      //  rewards page and page is active
      if (isRewardsPage) {
        this.needResetRewardTab = false;
        this.loaded = false;
        this.cdr.detectChanges();
        this.loaded = true;
      } else if (isLeavingDealsTab) {
        // navigated away from deals tab to another tab
        this.needResetRewardTab = true;
      }
      // Update previous URL
      this.previousUrl = currentUrl;
    });
  }
  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
  static ɵfac = function RewardsPageComponent_Factory(t) {
    return new (t || RewardsPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_1__.ChangeDetectorRef));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
    type: RewardsPageComponent,
    selectors: [["rewards"]],
    decls: 7,
    vars: 3,
    consts: [[1, "widget-layout"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug", 4, "ngIf"], [1, "rewards-container"], ["id", "rewards-list", "active-page", "rewards", 3, "needResetRewardTab"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug", 4, "ngIf"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function RewardsPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "ion-content")(1, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](2, RewardsPageComponent_widget_layout_2_Template, 1, 1, "widget-layout", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](4, "mag-deal-container", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](5, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](6, RewardsPageComponent_widget_layout_6_Template, 1, 1, "widget-layout", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("needResetRewardTab", ctx.needResetRewardTab);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.loaded);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_0__.WidgetLayoutComponent],
    styles: [".rewards-container[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-horizontal-padding-medium, 16px);\n}\n\n.widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL29mZmVyL3BhZ2VzL3Jld2FyZHMvcmV3YXJkcy5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usd0ZBQUE7QUFDRjs7QUFFQTtFQUNFLHVDQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyIucmV3YXJkcy1jb250YWluZXIge1xuICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpIHZhcigtLW1hZy1zcGFjaW5nLWhvcml6b250YWwtcGFkZGluZy1tZWRpdW0sIDE2cHgpO1xufVxuXG4ud2lkZ2V0LWxheW91dCB7XG4gIHBhZGRpbmc6IDAgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 31485:
/*!**************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/providers/offer-product.service.ts ***!
  \**************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferProductService: () => (/* binding */ OfferProductService)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/gateway/mag-ecom-core-api.service */ 31627);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ 70271);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ 61318);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ 59452);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);






class OfferProductService {
  route;
  api;
  constructor(route, api) {
    this.route = route;
    this.api = api;
  }
  getParticipatingProducts(upcs, storeCode, includeOffers, user) {
    const params = {
      upcs,
      storeCode,
      includeOffers,
      customerCode: user && user.ExternalCustomerID
    };
    return this.api.post('/product/v2.0/api/products/by-upcs', params).pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_1__.map)(data => {
      return data.Data;
    }), (0,rxjs__WEBPACK_IMPORTED_MODULE_2__.catchError)(() => {
      return (0,rxjs__WEBPACK_IMPORTED_MODULE_3__.of)([]);
    }));
  }
  static ɵfac = function OfferProductService_Factory(t) {
    return new (t || OfferProductService)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵinject"](_rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_0__.MagEComCoreApiHttpClient));
  };
  static ɵprov = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjectable"]({
    token: OfferProductService,
    factory: OfferProductService.ɵfac,
    providedIn: 'root'
  });
}

/***/ }),

/***/ 811:
/*!******************************************************************!*\
  !*** ./src/app/modules/ecom-v2/offer/providers/offer.service.ts ***!
  \******************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   OfferService: () => (/* binding */ OfferService)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/gateway/mag-ecom-core-api.service */ 31627);
/* harmony import */ var _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../utils/ecom-api-configs */ 847);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);




class OfferService {
  api;
  apiReward;
  constructor(api, apiReward) {
    this.api = api;
    this.apiReward = apiReward;
  }
  getOfferByCode(storeCode, offerCode, transactionId) {
    //customrcode is hardcoded , will remove it later
    return this.api.get(`/Offer/GetDealDetail?storeCode=${storeCode}&offerCode=${offerCode}${transactionId ? `&transactionId=${transactionId}` : ''}`);
  }
  getCouponByCode(couponCode) {
    return this.api.get(`/coupons/${couponCode}`);
  }
  getRewardDetail(offerCode, programCode, clippedRewardId = null) {
    let url = `/${offerCode}/programs/${programCode}`;
    if (clippedRewardId) {
      url += `?clippedRewardId=${clippedRewardId}`;
    }
    return this.apiReward.get(url);
  }
  getRewardClippedList() {
    const url = '/clipped';
    return this.apiReward.get(url);
  }
  getRewardClaimProduct(pi = 1, ps = 10) {
    const url = `/programs/free-products/class/claim-product?pi=${pi}&ps=${ps}`;
    return this.apiReward.get(url);
  }
  static ɵfac = function OfferService_Factory(t) {
    return new (t || OfferService)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_OFFER_V2_HTTP_CLIENT), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵinject"](_utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_REWARD_HTTP_CLIENT));
  };
  static ɵprov = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjectable"]({
    token: OfferService,
    factory: OfferService.ɵfac
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_offer_offer-routing_module_ts.js.map