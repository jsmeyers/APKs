"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_browse_browse_router_module_ts"],{

/***/ 45124:
/*!****************************************************!*\
  !*** ./src/app/modules/browse/browse.component.ts ***!
  \****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   BrowsePageComponent: () => (/* binding */ BrowsePageComponent)
/* harmony export */ });
/* harmony import */ var _provider_category_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./provider/category.service */ 39548);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 61318);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../header/header.component */ 55074);
/* harmony import */ var _header_components_search_search_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../header/components/search/search.component */ 64269);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _component_popular_departments_popular_departments__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./component/popular-departments/popular-departments */ 37300);











class BrowsePageComponent {
  categoryService;
  router;
  departments;
  isSimpleHeader = true;
  isLocalSearch = false;
  isShowBackButton = false;
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_5__.Subject();
  departmentLoaded = false;
  constructor(categoryService, router) {
    this.categoryService = categoryService;
    this.router = router;
  }
  ngOnInit() {
    this.categoryService.getDepartments().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_6__.takeUntil)(this.destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_7__.catchError)(() => {
      this.departmentLoaded = true;
      return [];
    })).subscribe(value => {
      if (value) {
        this.departments = value;
        this.departmentLoaded = true;
      }
    });
  }
  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.complete();
  }
  ionViewWillEnter() {
    this.categoryService.resetCategoryAndDepartment();
  }
  static ɵfac = function BrowsePageComponent_Factory(t) {
    return new (t || BrowsePageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdirectiveInject"](_provider_category_service__WEBPACK_IMPORTED_MODULE_0__.CategoryService), _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_9__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdefineComponent"]({
    type: BrowsePageComponent,
    selectors: [["browse-page"]],
    decls: 11,
    vars: 10,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader"], [1, "header-simple__container"], [3, "isLocalSearch", "isShowBackButton"], [1, "browse"], [1, "browse__container"], ["type", "page", "objectId", "", "zoneName", "Top", 3, "slug"], [3, "departments", "departmentLoaded"], ["type", "page", "objectId", "", "zoneName", "Bottom", 3, "slug"]],
    template: function BrowsePageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelementStart"](3, "app-header", 3)(4, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelement"](5, "app-search", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelementStart"](6, "ion-content", 6)(7, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelement"](8, "widget-layout", 8)(9, "app-popular-departments", 9)(10, "widget-layout", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("isSimpleHeader", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("isLocalSearch", false)("isShowBackButton", false);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("departments", ctx.departments)("departmentLoaded", ctx.departmentLoaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonContent, _header_header_component__WEBPACK_IMPORTED_MODULE_1__.HeaderComponent, _header_components_search_search_component__WEBPACK_IMPORTED_MODULE_2__.SearchComponent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent, _component_popular_departments_popular_departments__WEBPACK_IMPORTED_MODULE_4__.PopularDepartmentsComponent],
    styles: [".browse[_ngcontent-%COMP%] {\n  --padding-bottom: 0px;\n  --background: var(--mag-color-border-divider, #eee);\n}\n.browse__container[_ngcontent-%COMP%] {\n  display: flex;\n  gap: var(--mag-spacing-100, 8px);\n  flex-direction: column;\n  height: 100%;\n}\n\napp-popular-departments[_ngcontent-%COMP%] {\n  display: flex;\n  flex: 1;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvYnJvd3NlLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UscUJBQUE7RUFDQSxtREFBQTtBQUNGO0FBQ0U7RUFDRSxhQUFBO0VBQ0EsZ0NBQUE7RUFDQSxzQkFBQTtFQUNBLFlBQUE7QUFDSjs7QUFHQTtFQUNFLGFBQUE7RUFDQSxPQUFBO0FBQUYiLCJzb3VyY2VzQ29udGVudCI6WyIuYnJvd3NlIHtcbiAgLS1wYWRkaW5nLWJvdHRvbTogMHB4O1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1ib3JkZXItZGl2aWRlciwgI2VlZSk7XG5cbiAgJl9fY29udGFpbmVyIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGdhcDogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gICAgaGVpZ2h0OiAxMDAlO1xuICB9XG59XG5cbmFwcC1wb3B1bGFyLWRlcGFydG1lbnRzIHtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleDogMTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 74499:
/*!*************************************************!*\
  !*** ./src/app/modules/browse/browse.module.ts ***!
  \*************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   BrowseModule: () => (/* binding */ BrowseModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../account-v2/providers/user.service */ 51074);
/* harmony import */ var _header_header_component_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../header/header.component.module */ 88770);
/* harmony import */ var _shared_shared_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shared/shared.module */ 70541);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../utils/utils.module */ 50777);
/* harmony import */ var _browse_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./browse.component */ 45124);
/* harmony import */ var _category_service_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./category-service.module */ 70079);
/* harmony import */ var _component_categories_swiper_categories_swiper_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./component/categories-swiper/categories-swiper.component */ 33461);
/* harmony import */ var _component_popular_departments_popular_departments__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./component/popular-departments/popular-departments */ 37300);
/* harmony import */ var _component_quick_example_quick_example_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./component/quick-example/quick-example.component */ 65257);
/* harmony import */ var _component_recommend_selection_recommend_selection_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./component/recommend-selection/recommend-selection.component */ 50293);
/* harmony import */ var _component_top_sellers_top_sellers_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./component/top-sellers/top-sellers.component */ 98137);
/* harmony import */ var _pages_all_categories_all_categories_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./pages/all-categories/all-categories.component */ 27228);
/* harmony import */ var _pages_category_category_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./pages/category/category.component */ 75956);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/core */ 37580);


















class BrowseModule {
  static ɵfac = function BrowseModule_Factory(t) {
    return new (t || BrowseModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdefineNgModule"]({
    type: BrowseModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_14__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_15__.IonicModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_1__.HeaderComponentModule, _angular_router__WEBPACK_IMPORTED_MODULE_16__.RouterModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_3__.UtilsModule, _shared_shared_module__WEBPACK_IMPORTED_MODULE_2__.SharedModule, _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_0__.UserServiceModule, _category_service_module__WEBPACK_IMPORTED_MODULE_5__.CategoryServiceModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__.TranslateModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_13__["ɵɵsetNgModuleScope"](BrowseModule, {
    declarations: [_component_categories_swiper_categories_swiper_component__WEBPACK_IMPORTED_MODULE_6__.CategoriesSwiperComponent, _component_recommend_selection_recommend_selection_component__WEBPACK_IMPORTED_MODULE_9__.RecommendSelectionComponent, _component_quick_example_quick_example_component__WEBPACK_IMPORTED_MODULE_8__.QuickExampleComponent, _component_popular_departments_popular_departments__WEBPACK_IMPORTED_MODULE_7__.PopularDepartmentsComponent, _component_top_sellers_top_sellers_component__WEBPACK_IMPORTED_MODULE_10__.TopSellersComponent, _browse_component__WEBPACK_IMPORTED_MODULE_4__.BrowsePageComponent, _pages_all_categories_all_categories_component__WEBPACK_IMPORTED_MODULE_11__.AllCategoriesPageComponent, _pages_category_category_component__WEBPACK_IMPORTED_MODULE_12__.CategoryPageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_14__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_15__.IonicModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_1__.HeaderComponentModule, _angular_router__WEBPACK_IMPORTED_MODULE_16__.RouterModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_3__.UtilsModule, _shared_shared_module__WEBPACK_IMPORTED_MODULE_2__.SharedModule, _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_0__.UserServiceModule, _category_service_module__WEBPACK_IMPORTED_MODULE_5__.CategoryServiceModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__.TranslateModule]
  });
})();

/***/ }),

/***/ 75110:
/*!********************************************************!*\
  !*** ./src/app/modules/browse/browse.router.module.ts ***!
  \********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   BrowsePageRoutingModule: () => (/* binding */ BrowsePageRoutingModule)
/* harmony export */ });
/* harmony import */ var _pages_category_category_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./pages/category/category.component */ 75956);
/* harmony import */ var _browse_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./browse.module */ 74499);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _browse_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./browse.component */ 45124);
/* harmony import */ var _pages_all_categories_all_categories_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/all-categories/all-categories.component */ 27228);
/* harmony import */ var _utils_guard__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../utils/guard */ 14359);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);








const routes = [{
  path: '',
  component: _browse_component__WEBPACK_IMPORTED_MODULE_2__.BrowsePageComponent
}, {
  path: 'all-categories',
  component: _pages_all_categories_all_categories_component__WEBPACK_IMPORTED_MODULE_3__.AllCategoriesPageComponent
}, {
  path: 'category',
  component: _pages_category_category_component__WEBPACK_IMPORTED_MODULE_0__.CategoryPageComponent
}, {
  path: 'subcategory',
  component: _pages_category_category_component__WEBPACK_IMPORTED_MODULE_0__.CategoryPageComponent
}, {
  path: 'product',
  loadChildren: () => Promise.all(/*! import() */[__webpack_require__.e("default-node_modules_ngx-moment_fesm2020_ngx-moment_mjs"), __webpack_require__.e("default-src_app_modules_ecom-v2_product_product-routing_module_ts")]).then(__webpack_require__.bind(__webpack_require__, /*! ../ecom-v2/product/product-routing.module */ 2112)).then(m => m.ProductRoutingModule),
  canActivate: _utils_guard__WEBPACK_IMPORTED_MODULE_4__.AppGuardsWithoutAuth,
  data: {
    hideTab: true
  }
}];
class BrowsePageRoutingModule {
  static ɵfac = function BrowsePageRoutingModule_Factory(t) {
    return new (t || BrowsePageRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineNgModule"]({
    type: BrowsePageRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule.forChild(routes), _browse_module__WEBPACK_IMPORTED_MODULE_1__.BrowseModule, _angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsetNgModuleScope"](BrowsePageRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _browse_module__WEBPACK_IMPORTED_MODULE_1__.BrowseModule],
    exports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule]
  });
})();

/***/ }),

/***/ 33461:
/*!*******************************************************************************************!*\
  !*** ./src/app/modules/browse/component/categories-swiper/categories-swiper.component.ts ***!
  \*******************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CategoriesSwiperComponent: () => (/* binding */ CategoriesSwiperComponent)
/* harmony export */ });
/* harmony import */ var _provider_category_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../provider/category.service */ 39548);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ 60316);





const _c0 = ["swiper"];
function CategoriesSwiperComponent_ng_container_1_swiper_slide_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "swiper-slide", 5)(1, "button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function CategoriesSwiperComponent_ng_container_1_swiper_slide_3_Template_button_click_1_listener() {
      const cat_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵresetView"](ctx_r2.navigateSpecificCategory(cat_r2.Code, ctx_r2.categoryService.getNameOfCategory(cat_r2)));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](2, "div", 7)(3, "mag-img", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("ionError", function CategoriesSwiperComponent_ng_container_1_swiper_slide_3_Template_mag_img_ionError_3_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r1);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵresetView"](ctx_r2.onErrorImage($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](4, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    const cat_r2 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("src", cat_r2.ImageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](ctx_r2.categoryService.getNameOfCategory(cat_r2));
  }
}
function CategoriesSwiperComponent_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "swiper-container", 3, 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](3, CategoriesSwiperComponent_ng_container_1_swiper_slide_3_Template, 6, 2, "swiper-slide", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("slidesPerView", ctx_r2.slidesPerView)("spaceBetween", ctx_r2.spaceBetween);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngForOf", ctx_r2.category == null ? null : ctx_r2.category.SubCategories);
  }
}
class CategoriesSwiperComponent {
  categoryService;
  slidesPerView = 'auto';
  spaceBetween = '16';
  category = null;
  disable = true;
  swiperRef;
  localeCode;
  constructor(categoryService) {
    this.categoryService = categoryService;
  }
  ngOnChanges(changes) {
    if (changes['category'] && this.category?.SubCategories?.length) {
      setTimeout(() => this.updateSwiper(), 0); // need to update margin of swiper with Cat doesn't have images
    }
  }
  updateSwiper() {
    const swiperEl = this.swiperRef?.nativeElement;
    if (swiperEl?.swiper) {
      swiperEl.swiper.params.spaceBetween = this.spaceBetween;
      swiperEl.swiper.update();
    }
  }
  onErrorImage(event) {
    const img = event.srcElement.shadowRoot.children[0];
    img.src = 'assets/imgs/DefaultMissingImage.jpg';
  }
  navigateSpecificCategory(categoryCode, categoryName) {
    if (this.disable) return;
    this.categoryService.navigateToCategoryPage(categoryCode, categoryName);
  }
  static ɵfac = function CategoriesSwiperComponent_Factory(t) {
    return new (t || CategoriesSwiperComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_provider_category_service__WEBPACK_IMPORTED_MODULE_0__.CategoryService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
    type: CategoriesSwiperComponent,
    selectors: [["app-categories-swiper"]],
    viewQuery: function CategoriesSwiperComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵviewQuery"](_c0, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵloadQuery"]()) && (ctx.swiperRef = _t.first);
      }
    },
    inputs: {
      slidesPerView: "slidesPerView",
      spaceBetween: "spaceBetween",
      category: "category",
      disable: "disable"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵNgOnChangesFeature"]],
    decls: 2,
    vars: 1,
    consts: [["swiper", ""], [1, "categories-swiper"], [4, "ngIf"], [1, "categories-swiper__slides", "swiper-container", 3, "slidesPerView", "spaceBetween"], ["class", "swiper__slide slide", 4, "ngFor", "ngForOf"], [1, "swiper__slide", "slide"], [1, "slide__item", "item", 3, "click"], [1, "item__img-wrapper"], ["alt", "image", 1, "item__image-content", 3, "ionError", "src"], [1, "item__text"]],
    template: function CategoriesSwiperComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](1, CategoriesSwiperComponent_ng_container_1_Template, 4, 3, "ng-container", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.category == null ? null : ctx.category.SubCategories == null ? null : ctx.category.SubCategories.length);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_2__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_2__.NgIf],
    styles: [".categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%] {\n  width: 128px;\n}\n.categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%]   .slide__item[_ngcontent-%COMP%] {\n  width: 100%;\n  display: flex;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n  gap: var(--mag-spacing-200, 16px);\n  background-color: transparent;\n}\n.categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%]   .slide__item[_ngcontent-%COMP%]   .item__img-wrapper[_ngcontent-%COMP%] {\n  width: 100%;\n  aspect-ratio: 1/1;\n  display: flex;\n  align-items: center;\n  justify-content: center;\n  overflow: hidden;\n  border: var(--mag-border-width-100, 1px) solid var(--mag-Neutral-N-D8, #d8d8d8);\n  border-radius: var(--mag-border-radius-large, 16px);\n  padding: var(--mag-spacing-250, 20px) var(--mag-spacing-150, 12px);\n}\n.categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%]   .slide__item[_ngcontent-%COMP%]   .item__image-content[_ngcontent-%COMP%] {\n  object-fit: contain;\n  object-position: center;\n}\n.categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%]   .slide__item[_ngcontent-%COMP%]   .item__text[_ngcontent-%COMP%] {\n  word-break: break-word;\n  width: 100%;\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%]:first-child {\n  margin-left: var(--mag-spacing-200, 16px);\n}\n.categories-swiper__slides[_ngcontent-%COMP%]   .swiper__slide[_ngcontent-%COMP%]:last-child {\n  margin-right: var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvY29tcG9uZW50L2NhdGVnb3JpZXMtc3dpcGVyL2NhdGVnb3JpZXMtc3dpcGVyLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUVJO0VBQ0UsWUFBQTtBQUROO0FBR1E7RUFDRSxXQUFBO0VBQ0EsYUFBQTtFQUNBLHNCQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtFQUNBLGlDQUFBO0VBQ0EsNkJBQUE7QUFEVjtBQUlZO0VBQ0UsV0FBQTtFQUNBLGlCQUFBO0VBQ0EsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsdUJBQUE7RUFDQSxnQkFBQTtFQUNBLCtFQUFBO0VBQ0EsbURBQUE7RUFDQSxrRUFBQTtBQUZkO0FBSVk7RUFDRSxtQkFBQTtFQUNBLHVCQUFBO0FBRmQ7QUFJWTtFQUNFLHNCQUFBO0VBQ0EsV0FBQTtFQUNBLDZDQUFBO0VBQ0Esa0JBQUE7RUFDQSw0REFBQTtFQUNBLGtCQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtBQUZkO0FBUUk7RUFDRSx5Q0FBQTtBQU5OO0FBUUk7RUFDRSwwQ0FBQTtBQU5OIiwic291cmNlc0NvbnRlbnQiOlsiLmNhdGVnb3JpZXMtc3dpcGVyIHtcbiAgJl9fc2xpZGVzIHtcbiAgICAuc3dpcGVyX19zbGlkZSB7XG4gICAgICB3aWR0aDogMTI4cHg7XG4gICAgICAuc2xpZGUge1xuICAgICAgICAmX19pdGVtIHtcbiAgICAgICAgICB3aWR0aDogMTAwJTtcbiAgICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gICAgICAgICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICAgICAgICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gICAgICAgICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG5cbiAgICAgICAgICAuaXRlbSB7XG4gICAgICAgICAgICAmX19pbWctd3JhcHBlciB7XG4gICAgICAgICAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgICAgICAgICBhc3BlY3QtcmF0aW86IDEvMTtcbiAgICAgICAgICAgICAgZGlzcGxheTogZmxleDtcbiAgICAgICAgICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICAgICAgICAgICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgICAgICAgICAgIG92ZXJmbG93OiBoaWRkZW47XG4gICAgICAgICAgICAgIGJvcmRlcjogdmFyKC0tbWFnLWJvcmRlci13aWR0aC0xMDAsIDFweCkgc29saWQgdmFyKC0tbWFnLU5ldXRyYWwtTi1EOCwgI2Q4ZDhkOCk7XG4gICAgICAgICAgICAgIGJvcmRlci1yYWRpdXM6IHZhcigtLW1hZy1ib3JkZXItcmFkaXVzLWxhcmdlLCAxNnB4KTtcbiAgICAgICAgICAgICAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctMjUwLCAyMHB4KSB2YXIoLS1tYWctc3BhY2luZy0xNTAsIDEycHgpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgJl9faW1hZ2UtY29udGVudCB7XG4gICAgICAgICAgICAgIG9iamVjdC1maXQ6IGNvbnRhaW47XG4gICAgICAgICAgICAgIG9iamVjdC1wb3NpdGlvbjogY2VudGVyO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgJl9fdGV4dCB7XG4gICAgICAgICAgICAgIHdvcmQtYnJlYWs6IGJyZWFrLXdvcmQ7XG4gICAgICAgICAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICAgICAgICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgICAgICAgICAgICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICAgICAgICAgICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICAgICAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgICAgICAgICAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cbiAgICAuc3dpcGVyX19zbGlkZTpmaXJzdC1jaGlsZCB7XG4gICAgICBtYXJnaW4tbGVmdDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgICB9XG4gICAgLnN3aXBlcl9fc2xpZGU6bGFzdC1jaGlsZCB7XG4gICAgICBtYXJnaW4tcmlnaHQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gICAgfVxuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 37300:
/*!*************************************************************************************!*\
  !*** ./src/app/modules/browse/component/popular-departments/popular-departments.ts ***!
  \*************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   PopularDepartmentsComponent: () => (/* binding */ PopularDepartmentsComponent)
/* harmony export */ });
/* harmony import */ var _provider_category_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../provider/category.service */ 39548);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/core */ 90852);









const _c0 = (a0, a1) => ({
  "container__grid grid": a0,
  "container__grid--no-data": a1
});
function PopularDepartmentsComponent_Conditional_10_button_0_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "ion-img", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const item_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("src", item_r2.ImageUrl);
  }
}
function PopularDepartmentsComponent_Conditional_10_button_0_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipe"](2, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipeBind1"](2, 1, ctx_r2.magImg), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeHtml"]);
  }
}
function PopularDepartmentsComponent_Conditional_10_button_0_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "button", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function PopularDepartmentsComponent_Conditional_10_button_0_Template_button_click_0_listener() {
      const item_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.navigateSpecificCategory(item_r2.CategoryCode, ctx_r2.categoryService.getNameOfCategory(item_r2)));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, PopularDepartmentsComponent_Conditional_10_button_0_div_1_Template, 2, 1, "div", 8)(2, PopularDepartmentsComponent_Conditional_10_button_0_div_2_Template, 3, 3, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "div", 9)(4, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    const item_r2 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", item_r2 == null ? null : item_r2.ImageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !(item_r2 == null ? null : item_r2.ImageUrl));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](ctx_r2.categoryService.getNameOfCategory(item_r2));
  }
}
function PopularDepartmentsComponent_Conditional_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](0, PopularDepartmentsComponent_Conditional_10_button_0_Template, 6, 3, "button", 6);
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.departments);
  }
}
function PopularDepartmentsComponent_Conditional_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 14)(1, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipe"](6, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipeBind1"](3, 2, "common.noPopularCatAvailable.title"));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipeBind1"](6, 4, "common.noPopularCatAvailable.message"));
  }
}
function PopularDepartmentsComponent_Conditional_12_button_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "button", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "ion-skeleton-text", 19)(2, "ion-skeleton-text", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
}
function PopularDepartmentsComponent_Conditional_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](0, PopularDepartmentsComponent_Conditional_12_button_0_Template, 3, 0, "button", 17);
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.skeletonCategories);
  }
}
class PopularDepartmentsComponent {
  router;
  categoryService;
  departments;
  departmentLoaded = false;
  magImg = `<mag-img src></mag-img>`;
  LIMITATION = 9;
  skeletonCategories = [...Array(this.LIMITATION).keys()];
  constructor(router, categoryService) {
    this.router = router;
    this.categoryService = categoryService;
  }
  viewAllCategories() {
    this.router.navigate(['/tabs/browse/all-categories']);
  }
  getNumberOfDepartments() {
    if (this.departments) return this.departments.length;
    return 0;
  }
  onErrorImage(event) {
    const img = event.srcElement.shadowRoot.children[0];
    img.src = 'assets/imgs/DefaultMissingImage.jpg';
  }
  navigateSpecificCategory(categoryCode, categoryName) {
    this.categoryService.navigateToCategoryPage(categoryCode, categoryName);
  }
  static ɵfac = function PopularDepartmentsComponent_Factory(t) {
    return new (t || PopularDepartmentsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_provider_category_service__WEBPACK_IMPORTED_MODULE_0__.CategoryService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: PopularDepartmentsComponent,
    selectors: [["app-popular-departments"]],
    inputs: {
      departments: "departments",
      departmentLoaded: "departmentLoaded"
    },
    decls: 13,
    vars: 11,
    consts: [[1, "shop-by-category", "container"], [1, "container__top", "top"], [1, "top__title"], [1, "top__cta", 3, "click"], [3, "ngClass"], [1, "grid__item", "item"], ["class", "grid__item item", 3, "click", 4, "ngFor", "ngForOf"], [1, "grid__item", "item", 3, "click"], ["class", "item__image-container loaded", 4, "ngIf"], [1, "item__content"], [1, "item__content-text"], [1, "item__image-container", "loaded"], ["alt", "image", 1, "item__image-content", 3, "src"], [3, "innerHTML"], [1, "grid__no-data"], [1, "no-data__title"], [1, "no-data"], ["class", "grid__item item skeleton", 4, "ngFor", "ngForOf"], [1, "grid__item", "item", "skeleton"], ["animated", "", 1, "item__image-container", "loaded"], ["animated", "", 1, "item__content", "loaded"]],
    template: function PopularDepartmentsComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0)(1, "div", 1)(2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](5, "div")(6, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function PopularDepartmentsComponent_Template_button_click_6_listener() {
          return ctx.viewAllCategories();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipe"](8, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](9, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](10, PopularDepartmentsComponent_Conditional_10_Template, 1, 1, "button", 5)(11, PopularDepartmentsComponent_Conditional_11_Template, 7, 6)(12, PopularDepartmentsComponent_Conditional_12_Template, 1, 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipeBind1"](4, 4, "browse.titleDepartment"));
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipeBind1"](8, 6, "common.viewAll"));
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction2"](8, _c0, !ctx.departmentLoaded || ctx.departments && ctx.departments.length > 0, !ctx.departments && ctx.departmentLoaded));
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵconditional"](10, ctx.departments && ctx.departments.length > 0 ? 10 : ctx.departmentLoaded === true ? 11 : 12);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonSkeletonText, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_1__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__.TranslatePipe],
    styles: [".shop-by-category[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-300, 24px) var(--mag-spacing-200, 16px);\n  background-color: var(--mag-color-surface-primary, #fff);\n  display: flex;\n  flex: 1;\n  flex-direction: column;\n}\n.shop-by-category[_ngcontent-%COMP%]   .no-data[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-secondary, #555);\n  text-align: center;\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.shop-by-category[_ngcontent-%COMP%]   .no-data__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text, #121212);\n  text-align: center;\n  font-family: var(--mag-typography-font-family, Lato);\n  font-size: var(--mag-typography-headlines-large-font-size, 24px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-large-font-weight, 600);\n  line-height: var(--mag-typography-headlines-large-line-height, 32px);\n}\n.shop-by-category[_ngcontent-%COMP%]   .grid__no-data[_ngcontent-%COMP%] {\n  display: flex;\n  flex: 1;\n  flex-direction: column;\n  align-items: center;\n  justify-content: center;\n  gap: var(--mag-spacing-200, 16px);\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__top[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n  align-items: center;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__top[_ngcontent-%COMP%]   .top__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-headlines-medium-font-size, 20px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-medium-font-weight, 500);\n  line-height: var(--mag-typography-headlines-medium-line-height, 28px);\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__top[_ngcontent-%COMP%]   .top__cta[_ngcontent-%COMP%] {\n  color: var(--mag-brand-foundation-primary, #008000);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  text-decoration: none;\n  background-color: transparent;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%] {\n  display: grid;\n  grid-template-columns: 1fr 1fr 1fr;\n  column-gap: var(--mag-spacing-100, 8px);\n  row-gap: var(--mag-spacing-300, 24px);\n  margin-top: var(--mag-spacing-300, 24px);\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid[_ngcontent-%COMP%] {\n  display: flex;\n  flex: 1;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid__item[_ngcontent-%COMP%] {\n  background-color: transparent;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid__item[_ngcontent-%COMP%]   .item__image-container[_ngcontent-%COMP%] {\n  aspect-ratio: 1/1;\n  border-radius: var(--mag-spacing-100, 8px);\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  overflow: hidden;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid__item[_ngcontent-%COMP%]   .item__image-container.loaded[_ngcontent-%COMP%] {\n  background: var(--mag-color-surface-hovered, #f7f7f7);\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid__item[_ngcontent-%COMP%]   .item__image-content[_ngcontent-%COMP%] {\n  object-fit: contain;\n  object-position: center;\n  padding: 0px 12px;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid__item[_ngcontent-%COMP%]   .item__content[_ngcontent-%COMP%] {\n  aspect-ratio: 4/1;\n  margin-top: 9px;\n  width: 100%;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid[_ngcontent-%COMP%]   .grid__item[_ngcontent-%COMP%]   .item__content-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-small-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-small-line-height, 20px);\n  word-break: break-word;\n}\n.shop-by-category[_ngcontent-%COMP%]   .container__grid--no-data[_ngcontent-%COMP%] {\n  display: flex;\n  flex: 1;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvY29tcG9uZW50L3BvcHVsYXItZGVwYXJ0bWVudHMvcG9wdWxhci1kZXBhcnRtZW50cy5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usa0VBQUE7RUFDQSx3REFBQTtFQUNBLGFBQUE7RUFDQSxPQUFBO0VBQ0Esc0JBQUE7QUFDRjtBQUNFO0VBQ0UsNENBQUE7RUFDQSxrQkFBQTtFQUNBLCtEQUFBO0VBQ0EsNERBQUE7RUFDQSxrQkFBQTtFQUNBLHVFQUFBO0VBQ0EsZ0VBQUE7QUFDSjtBQUVFO0VBQ0UscUNBQUE7RUFDQSxrQkFBQTtFQUNBLG9EQUFBO0VBQ0EsZ0VBQUE7RUFDQSxrQkFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7QUFBSjtBQUdFO0VBQ0UsYUFBQTtFQUNBLE9BQUE7RUFDQSxzQkFBQTtFQUNBLG1CQUFBO0VBQ0EsdUJBQUE7RUFDQSxpQ0FBQTtBQURKO0FBS0k7RUFDRSxhQUFBO0VBQ0EsOEJBQUE7RUFDQSxtQkFBQTtBQUhOO0FBTVE7RUFDRSw2Q0FBQTtFQUNBLGlFQUFBO0VBQ0Esa0JBQUE7RUFDQSxvRUFBQTtFQUNBLHFFQUFBO0FBSlY7QUFPUTtFQUNFLG1EQUFBO0VBQ0EsNERBQUE7RUFDQSxrQkFBQTtFQUNBLDBFQUFBO0VBQ0EsZ0VBQUE7RUFDQSxxQkFBQTtFQUNBLDZCQUFBO0FBTFY7QUFVSTtFQUNFLGFBQUE7RUFDQSxrQ0FBQTtFQUNBLHVDQUFBO0VBQ0EscUNBQUE7RUFDQSx3Q0FBQTtBQVJOO0FBVU07RUFDRSxhQUFBO0VBQ0EsT0FBQTtBQVJSO0FBVVE7RUFDRSw2QkFBQTtBQVJWO0FBY1k7RUFDRSxpQkFBQTtFQUNBLDBDQUFBO0VBQ0EsYUFBQTtFQUNBLHVCQUFBO0VBQ0EsbUJBQUE7RUFDQSxnQkFBQTtBQVpkO0FBY2M7RUFDRSxxREFBQTtBQVpoQjtBQWdCWTtFQUNFLG1CQUFBO0VBQ0EsdUJBQUE7RUFDQSxpQkFBQTtBQWRkO0FBaUJZO0VBQ0UsaUJBQUE7RUFDQSxlQUFBO0VBQ0EsV0FBQTtBQWZkO0FBaUJjO0VBQ0UsNkNBQUE7RUFDQSxrQkFBQTtFQUNBLDJEQUFBO0VBQ0Esa0JBQUE7RUFDQSx5RUFBQTtFQUNBLCtEQUFBO0VBQ0Esc0JBQUE7QUFmaEI7QUFzQk07RUFDRSxhQUFBO0VBQ0EsT0FBQTtBQXBCUiIsInNvdXJjZXNDb250ZW50IjpbIi5zaG9wLWJ5LWNhdGVnb3J5IHtcbiAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KSB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleDogMTtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcblxuICAubm8tZGF0YSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXNlY29uZGFyeSwgIzU1NSk7XG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gIH1cblxuICAubm8tZGF0YV9fdGl0bGUge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dCwgIzEyMTIxMik7XG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGF0byk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtZm9udC1zaXplLCAyNHB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1sYXJnZS1mb250LXdlaWdodCwgNjAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLWxhcmdlLWxpbmUtaGVpZ2h0LCAzMnB4KTtcbiAgfVxuXG4gIC5ncmlkX19uby1kYXRhIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZsZXg6IDE7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgIGdhcDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgfVxuXG4gIC5jb250YWluZXIge1xuICAgICZfX3RvcCB7XG4gICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcblxuICAgICAgLnRvcCB7XG4gICAgICAgICZfX3RpdGxlIHtcbiAgICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICAgICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtc2l6ZSwgMjBweCk7XG4gICAgICAgICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgICAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWxpbmUtaGVpZ2h0LCAyOHB4KTtcbiAgICAgICAgfVxuXG4gICAgICAgICZfX2N0YSB7XG4gICAgICAgICAgY29sb3I6IHZhcigtLW1hZy1icmFuZC1mb3VuZGF0aW9uLXByaW1hcnksICMwMDgwMDApO1xuICAgICAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICAgICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LWVtcGhhc2l6ZWQsIDQwMCk7XG4gICAgICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICAgICAgICB0ZXh0LWRlY29yYXRpb246IG5vbmU7XG4gICAgICAgICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG4gICAgICAgIH1cbiAgICAgIH1cbiAgICB9XG5cbiAgICAmX19ncmlkIHtcbiAgICAgIGRpc3BsYXk6IGdyaWQ7XG4gICAgICBncmlkLXRlbXBsYXRlLWNvbHVtbnM6IDFmciAxZnIgMWZyO1xuICAgICAgY29sdW1uLWdhcDogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuICAgICAgcm93LWdhcDogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcbiAgICAgIG1hcmdpbi10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweCk7XG5cbiAgICAgIC5ncmlkIHtcbiAgICAgICAgZGlzcGxheTogZmxleDtcbiAgICAgICAgZmxleDogMTtcblxuICAgICAgICAmX19pdGVtIHtcbiAgICAgICAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcblxuICAgICAgICAgICYuc2tlbGV0b24ge1xuICAgICAgICAgIH1cblxuICAgICAgICAgIC5pdGVtIHtcbiAgICAgICAgICAgICZfX2ltYWdlLWNvbnRhaW5lciB7XG4gICAgICAgICAgICAgIGFzcGVjdC1yYXRpbzogMS8xO1xuICAgICAgICAgICAgICBib3JkZXItcmFkaXVzOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgICAgICAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICAgICAgICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgICAgICAgICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgICAgICAgICAgICBvdmVyZmxvdzogaGlkZGVuO1xuXG4gICAgICAgICAgICAgICYubG9hZGVkIHtcbiAgICAgICAgICAgICAgICBiYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1ob3ZlcmVkLCAjZjdmN2Y3KTtcbiAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAmX19pbWFnZS1jb250ZW50IHtcbiAgICAgICAgICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICAgICAgICAgICAgb2JqZWN0LXBvc2l0aW9uOiBjZW50ZXI7XG4gICAgICAgICAgICAgIHBhZGRpbmc6IDBweCAxMnB4O1xuICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAmX19jb250ZW50IHtcbiAgICAgICAgICAgICAgYXNwZWN0LXJhdGlvOiA0LzE7XG4gICAgICAgICAgICAgIG1hcmdpbi10b3A6IDlweDtcbiAgICAgICAgICAgICAgd2lkdGg6IDEwMCU7XG5cbiAgICAgICAgICAgICAgJi10ZXh0IHtcbiAgICAgICAgICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICAgICAgICAgICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICAgICAgICAgICAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1zbWFsbC1mb250LXNpemUsIDE0cHgpO1xuICAgICAgICAgICAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgICAgICAgICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1zbWFsbC1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgICAgICAgICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbiAgICAgICAgICAgICAgICB3b3JkLWJyZWFrOiBicmVhay13b3JkO1xuICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICB9XG5cbiAgICAgICYtLW5vLWRhdGEge1xuICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICBmbGV4OiAxO1xuICAgICAgfVxuICAgIH1cbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 65257:
/*!***********************************************************************************!*\
  !*** ./src/app/modules/browse/component/quick-example/quick-example.component.ts ***!
  \***********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   QuickExampleComponent: () => (/* binding */ QuickExampleComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);

class QuickExampleComponent {
  static ɵfac = function QuickExampleComponent_Factory(t) {
    return new (t || QuickExampleComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
    type: QuickExampleComponent,
    selectors: [["app-quick-example"]],
    decls: 3,
    vars: 0,
    consts: [[1, "quick-example"], [1, "quick-example__title"]],
    template: function QuickExampleComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Quick Link Examples");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()();
      }
    },
    styles: [".quick-example[_ngcontent-%COMP%] {\n  background-color: var(--mag-color-surface-primary, #fff);\n  padding-top: var(--mag-spacing-300, 24px);\n  padding-bottom: var(--mag-spacing-300, 24px);\n  padding-left: var(--mag-spacing-200, 16px);\n}\n.quick-example__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-headlines-medium-font-size, 20px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-medium-font-weight, 500);\n  line-height: var(--mag-typography-headlines-medium-line-height, 28px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvY29tcG9uZW50L3F1aWNrLWV4YW1wbGUvcXVpY2stZXhhbXBsZS5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHdEQUFBO0VBQ0EseUNBQUE7RUFDQSw0Q0FBQTtFQUNBLDBDQUFBO0FBQ0Y7QUFDRTtFQUNFLDZDQUFBO0VBQ0EsaUVBQUE7RUFDQSxrQkFBQTtFQUNBLG9FQUFBO0VBQ0EscUVBQUE7QUFDSiIsInNvdXJjZXNDb250ZW50IjpbIi5xdWljay1leGFtcGxlIHtcbiAgYmFja2dyb3VuZC1jb2xvcjogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIHBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpO1xuICBwYWRkaW5nLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcbiAgcGFkZGluZy1sZWZ0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuXG4gICZfX3RpdGxlIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtc2l6ZSwgMjBweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWxpbmUtaGVpZ2h0LCAyOHB4KTtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 50293:
/*!***********************************************************************************************!*\
  !*** ./src/app/modules/browse/component/recommend-selection/recommend-selection.component.ts ***!
  \***********************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecommendSelectionComponent: () => (/* binding */ RecommendSelectionComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ionic/angular */ 37401);


class RecommendSelectionComponent {
  static ɵfac = function RecommendSelectionComponent_Factory(t) {
    return new (t || RecommendSelectionComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
    type: RecommendSelectionComponent,
    selectors: [["app-recommend-selection"]],
    decls: 20,
    vars: 0,
    consts: [[1, "recommend-selection"], [1, "recommend-selection__title"], [1, "recommend-selection__wrapper", "wrapper"], [1, "wrapper__element"], ["src", "../../../../../assets/icon/shopping-cart-reorder.svg"], [1, "wrapper__text"], ["src", "../../../../../assets/icon/scissors-outline.svg"], ["src", "../../../../../assets/icon/save-money.svg"]],
    template: function RecommendSelectionComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "ion-grid", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "For you");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "ion-row", 2)(4, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "ion-icon", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Reorder");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "ion-icon", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11, "Rewards!");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](13, "ion-icon", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "On Sale");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](17, "ion-icon", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19, "Coupons");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()()()();
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_1__.IonGrid, _ionic_angular__WEBPACK_IMPORTED_MODULE_1__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_1__.IonRow],
    styles: ["ion-icon[_ngcontent-%COMP%] {\n  width: 24px;\n  height: 24px;\n}\n\n.recommend-selection[_ngcontent-%COMP%] {\n  background-color: var(--mag-color-surface-primary, #fff);\n  display: flex;\n  flex-direction: column;\n  gap: var(--mag-spacing-300, 24px);\n  padding: var(--mag-spacing-300, 24px) var(--mag-spacing-200, 16px);\n}\n.recommend-selection__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-headlines-medium-font-size, 20px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-medium-font-weight, 500);\n  line-height: var(--mag-typography-headlines-medium-line-height, 28px);\n}\n.recommend-selection__wrapper[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n}\n.recommend-selection__wrapper[_ngcontent-%COMP%]   .wrapper__element[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n  gap: 8px;\n  padding: var(--mag-spacing-100, 8px);\n  background-color: transparent;\n}\n.recommend-selection__wrapper[_ngcontent-%COMP%]   .wrapper__text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: center;\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-small-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-small-line-height, 20px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvY29tcG9uZW50L3JlY29tbWVuZC1zZWxlY3Rpb24vcmVjb21tZW5kLXNlbGVjdGlvbi5jb21wb25lbnQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLFdBQUE7RUFDQSxZQUFBO0FBQ0Y7O0FBRUE7RUFDRSx3REFBQTtFQUNBLGFBQUE7RUFDQSxzQkFBQTtFQUNBLGlDQUFBO0VBQ0Esa0VBQUE7QUFDRjtBQUFFO0VBQ0UsNkNBQUE7RUFDQSxpRUFBQTtFQUNBLGtCQUFBO0VBQ0Esb0VBQUE7RUFDQSxxRUFBQTtBQUVKO0FBQUU7RUFDRSxhQUFBO0VBQ0EsOEJBQUE7QUFFSjtBQUFNO0VBQ0UsYUFBQTtFQUNBLHNCQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtFQUNBLFFBQUE7RUFDQSxvQ0FBQTtFQUNBLDZCQUFBO0FBRVI7QUFBTTtFQUNFLDZDQUFBO0VBQ0Esa0JBQUE7RUFDQSwyREFBQTtFQUNBLGtCQUFBO0VBQ0EseUVBQUE7RUFDQSwrREFBQTtBQUVSIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLWljb24ge1xuICB3aWR0aDogMjRweDtcbiAgaGVpZ2h0OiAyNHB4O1xufVxuXG4ucmVjb21tZW5kLXNlbGVjdGlvbiB7XG4gIGJhY2tncm91bmQtY29sb3I6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICBkaXNwbGF5OiBmbGV4O1xuICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweCk7XG4gIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweCkgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgJl9fdGl0bGUge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tZm9udC1zaXplLCAyMHB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tbGluZS1oZWlnaHQsIDI4cHgpO1xuICB9XG4gICZfX3dyYXBwZXIge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuICAgIC53cmFwcGVyIHtcbiAgICAgICZfX2VsZW1lbnQge1xuICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICAgICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICAgICAgZ2FwOiA4cHg7XG4gICAgICAgIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTEwMCwgOHB4KTtcbiAgICAgICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG4gICAgICB9XG4gICAgICAmX190ZXh0IHtcbiAgICAgICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgICAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1zbWFsbC1mb250LXNpemUsIDE0cHgpO1xuICAgICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWZvbnQtd2VpZ2h0LWVtcGhhc2l6ZWQsIDQwMCk7XG4gICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbiAgICAgIH1cbiAgICB9XG4gIH1cbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 98137:
/*!*******************************************************************************!*\
  !*** ./src/app/modules/browse/component/top-sellers/top-sellers.component.ts ***!
  \*******************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   TopSellersComponent: () => (/* binding */ TopSellersComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ionic/angular */ 37401);


class TopSellersComponent {
  static ɵfac = function TopSellersComponent_Factory(t) {
    return new (t || TopSellersComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
    type: TopSellersComponent,
    selectors: [["app-top-sellers"]],
    decls: 31,
    vars: 0,
    consts: [[1, "top-sellers", "container"], [1, "container__title"], [1, "container__content", "content"], [1, "content__item", "item"], [1, "item__left", "left"], [1, "left__image-container"], ["src", "../../../../../assets/img/ecom-v2/seller-example1.png", "alt", "image", 1, "left__image-content"], [1, "left__text"], ["name", "chevron-forward-outline", 1, "left__icon"], [1, "item__right", "right"], ["src", "../../../../../assets/img/ecom-v2/seller-example-right1.png", "alt", "image", 1, "right__image"]],
    template: function TopSellersComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Our Top Sellers");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2)(4, "div", 3)(5, "div", 4)(6, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "img", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "Chobani, Yogurt, Greek, Strawberry Banana, 4 Value Pack");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "ion-icon", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "img", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 3)(14, "div", 4)(15, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](16, "img", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "Chobani, Yogurt, Greek, Strawberry Banana, 4 Value Pack");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](19, "ion-icon", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](21, "img", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 3)(23, "div", 4)(24, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](25, "img", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, "Chobani, Yogurt, Greek, Strawberry Banana, 4 Value Pack");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](28, "ion-icon", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](30, "img", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()()()();
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_1__.IonIcon],
    styles: [".top-sellers[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-300, 24px) var(--mag-spacing-100, 8px) var(--mag-spacing-300, 24px) var(--mag-spacing-200, 16px);\n  background-color: var(--mag-color-surface-primary, #fff);\n}\n.top-sellers[_ngcontent-%COMP%]   .container__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-headlines-medium-font-size, 20px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-medium-font-weight, 500);\n  line-height: var(--mag-typography-headlines-medium-line-height, 28px);\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-300, 24px);\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]:last-child   .item__left[_ngcontent-%COMP%], .top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]:last-child   .item__right[_ngcontent-%COMP%] {\n  border-bottom: none;\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  justify-content: space-between;\n  height: 92px;\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]   .item__left[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  column-gap: var(--mag-spacing-100, 8px);\n  flex-wrap: wrap;\n  padding: var(--mag-spacing-200, 16px) var(--mag-spacing-150, 12px);\n  border-bottom: var(--mag-border-width-0, 1px) solid var(--mag-color-border-divider, #eee);\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]   .item__left[_ngcontent-%COMP%]   .left__image-container[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  width: 48px;\n  height: 48px;\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]   .item__left[_ngcontent-%COMP%]   .left__text[_ngcontent-%COMP%] {\n  width: 168px;\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-small-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-small-line-height, 20px);\n  word-break: break-word;\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]   .item__left[_ngcontent-%COMP%]   .left__icon[_ngcontent-%COMP%] {\n  width: 24px;\n  height: 24px;\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]   .item__right[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  height: 100%;\n  border-bottom: var(--mag-border-width-0, 1px) solid var(--mag-color-border-divider, #eee);\n}\n.top-sellers[_ngcontent-%COMP%]   .container__content[_ngcontent-%COMP%]   .content__item[_ngcontent-%COMP%]   .item__right[_ngcontent-%COMP%]   .right__image[_ngcontent-%COMP%] {\n  width: 48px;\n  height: 48px;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvY29tcG9uZW50L3RvcC1zZWxsZXJzL3RvcC1zZWxsZXJzLmNvbXBvbmVudC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsMkhBQUE7RUFFQSx3REFBQTtBQUFGO0FBR0k7RUFDRSw2Q0FBQTtFQUNBLGlFQUFBO0VBQ0Esa0JBQUE7RUFDQSxvRUFBQTtFQUNBLHFFQUFBO0FBRE47QUFJSTtFQUNFLHdDQUFBO0FBRk47QUFPWTtFQUVFLG1CQUFBO0FBTmQ7QUFVUTtFQUNFLGFBQUE7RUFDQSxtQkFBQTtFQUNBLDhCQUFBO0VBQ0EsWUFBQTtBQVJWO0FBVVk7RUFDRSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSx1Q0FBQTtFQUNBLGVBQUE7RUFDQSxrRUFBQTtFQUNBLHlGQUFBO0FBUmQ7QUFXZ0I7RUFDRSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtFQUNBLFdBQUE7RUFDQSxZQUFBO0FBVGxCO0FBZWdCO0VBQ0UsWUFBQTtFQUNBLDZDQUFBO0VBQ0EsMkRBQUE7RUFDQSxrQkFBQTtFQUNBLHlFQUFBO0VBQ0EsK0RBQUE7RUFDQSxzQkFBQTtBQWJsQjtBQWdCZ0I7RUFDRSxXQUFBO0VBQ0EsWUFBQTtBQWRsQjtBQW1CWTtFQUNFLGFBQUE7RUFDQSx1QkFBQTtFQUNBLG1CQUFBO0VBQ0EsWUFBQTtFQUNBLHlGQUFBO0FBakJkO0FBbUJnQjtFQUNFLFdBQUE7RUFDQSxZQUFBO0FBakJsQiIsInNvdXJjZXNDb250ZW50IjpbIi50b3Atc2VsbGVycyB7XG4gIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweCkgdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpIHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweClcbiAgICB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmKTtcblxuICAuY29udGFpbmVyIHtcbiAgICAmX190aXRsZSB7XG4gICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tZm9udC1zaXplLCAyMHB4KTtcbiAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tbGluZS1oZWlnaHQsIDI4cHgpO1xuICAgIH1cblxuICAgICZfX2NvbnRlbnQge1xuICAgICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcblxuICAgICAgLmNvbnRlbnQge1xuICAgICAgICAmX19pdGVtOmxhc3QtY2hpbGQge1xuICAgICAgICAgIC5pdGVtIHtcbiAgICAgICAgICAgICZfX2xlZnQsXG4gICAgICAgICAgICAmX19yaWdodCB7XG4gICAgICAgICAgICAgIGJvcmRlci1ib3R0b206IG5vbmU7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgICZfX2l0ZW0ge1xuICAgICAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICAgICAgICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWJldHdlZW47XG4gICAgICAgICAgaGVpZ2h0OiA5MnB4O1xuICAgICAgICAgIC5pdGVtIHtcbiAgICAgICAgICAgICZfX2xlZnQge1xuICAgICAgICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICAgICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgICAgICAgICAgICBjb2x1bW4tZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgICAgICAgICAgIGZsZXgtd3JhcDogd3JhcDtcbiAgICAgICAgICAgICAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KSB2YXIoLS1tYWctc3BhY2luZy0xNTAsIDEycHgpO1xuICAgICAgICAgICAgICBib3JkZXItYm90dG9tOiB2YXIoLS1tYWctYm9yZGVyLXdpZHRoLTAsIDFweCkgc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyLCAjZWVlKTtcblxuICAgICAgICAgICAgICAubGVmdCB7XG4gICAgICAgICAgICAgICAgJl9faW1hZ2UtY29udGFpbmVyIHtcbiAgICAgICAgICAgICAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICAgICAgICAgICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICAgICAgICAgICAgICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgICAgICAgICAgICAgICB3aWR0aDogNDhweDtcbiAgICAgICAgICAgICAgICAgIGhlaWdodDogNDhweDtcbiAgICAgICAgICAgICAgICB9XG5cbiAgICAgICAgICAgICAgICAmX19pbWFnZS1jb250ZW50IHtcbiAgICAgICAgICAgICAgICB9XG5cbiAgICAgICAgICAgICAgICAmX190ZXh0IHtcbiAgICAgICAgICAgICAgICAgIHdpZHRoOiAxNjhweDtcbiAgICAgICAgICAgICAgICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICAgICAgICAgICAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1zbWFsbC1mb250LXNpemUsIDE0cHgpO1xuICAgICAgICAgICAgICAgICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgICAgICAgICAgICAgICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtZm9udC13ZWlnaHQtZW1waGFzaXplZCwgNDAwKTtcbiAgICAgICAgICAgICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbiAgICAgICAgICAgICAgICAgIHdvcmQtYnJlYWs6IGJyZWFrLXdvcmQ7XG4gICAgICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAgICAgJl9faWNvbiB7XG4gICAgICAgICAgICAgICAgICB3aWR0aDogMjRweDtcbiAgICAgICAgICAgICAgICAgIGhlaWdodDogMjRweDtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgJl9fcmlnaHQge1xuICAgICAgICAgICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgICAgICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICAgICAgICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICAgICAgICAgICAgaGVpZ2h0OiAxMDAlO1xuICAgICAgICAgICAgICBib3JkZXItYm90dG9tOiB2YXIoLS1tYWctYm9yZGVyLXdpZHRoLTAsIDFweCkgc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyLCAjZWVlKTtcbiAgICAgICAgICAgICAgLnJpZ2h0IHtcbiAgICAgICAgICAgICAgICAmX19pbWFnZSB7XG4gICAgICAgICAgICAgICAgICB3aWR0aDogNDhweDtcbiAgICAgICAgICAgICAgICAgIGhlaWdodDogNDhweDtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgIH1cbiAgICB9XG5cbiAgICAmX19jb250ZW50IHtcbiAgICAgIC5jb250ZW50IHtcbiAgICAgIH1cbiAgICB9XG4gIH1cbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 27228:
/*!*********************************************************************************!*\
  !*** ./src/app/modules/browse/pages/all-categories/all-categories.component.ts ***!
  \*********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   AllCategoriesPageComponent: () => (/* binding */ AllCategoriesPageComponent)
/* harmony export */ });
/* harmony import */ var _provider_category_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../provider/category.service */ 39548);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../header/header.component */ 55074);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);










function AllCategoriesPageComponent_ng_container_6_ng_container_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "button", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("click", function AllCategoriesPageComponent_ng_container_6_ng_container_3_Template_button_click_1_listener() {
      const category_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵresetView"](ctx_r2.navigateSpecificCategory(category_r2.Code, ctx_r2.categoryService.getNameOfCategory(category_r2)));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](2, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](4, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](5, "ion-icon", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const category_r2 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](ctx_r2.categoryService.getNameOfCategory(category_r2));
  }
}
function AllCategoriesPageComponent_ng_container_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](2, "widget-layout", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](3, AllCategoriesPageComponent_ng_container_6_ng_container_3_Template, 6, 1, "ng-container", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](4, "widget-layout", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx_r2.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngForOf", ctx_r2.categories);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx_r2.router.url);
  }
}
function AllCategoriesPageComponent_ng_template_7_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](2, "ion-skeleton-text", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
}
function AllCategoriesPageComponent_ng_template_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](1, AllCategoriesPageComponent_ng_template_7_ng_container_1_Template, 3, 0, "ng-container", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngForOf", ctx_r2.skeletonCategories);
  }
}
class AllCategoriesPageComponent {
  router;
  categoryService;
  LIMITATION = 11;
  skeletonCategories = [...Array(this.LIMITATION).keys()];
  categories = [];
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_4__.Subject();
  constructor(router, categoryService) {
    this.router = router;
    this.categoryService = categoryService;
  }
  ngOnInit() {
    this.categoryService.getCategories().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_5__.takeUntil)(this.destroy$)).subscribe(value => {
      this.categories = value;
    });
  }
  ionViewWillEnter() {
    this.categoryService.loadCategories();
  }
  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.complete();
  }
  navigateSpecificCategory(categoryCode, categoryName) {
    this.categoryService.navigateToCategoryPage([categoryCode], [categoryName]);
  }
  static ɵfac = function AllCategoriesPageComponent_Factory(t) {
    return new (t || AllCategoriesPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_provider_category_service__WEBPACK_IMPORTED_MODULE_0__.CategoryService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: AllCategoriesPageComponent,
    selectors: [["app-all-categories"]],
    decls: 9,
    vars: 7,
    consts: [["elseBlock", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isOnlySearchHeader", "isShowBackButton"], [1, "all-categories"], [1, "all-categories__container"], [4, "ngIf", "ngIfElse"], [1, "all-categories__list", "list"], ["type", "page", "objectId", "", "zoneName", "Top", 3, "slug"], [4, "ngFor", "ngForOf"], ["type", "page", "objectId", "", "zoneName", "Bottom", 3, "slug"], [1, "list__item", "item", 3, "click"], [1, "item__text"], [1, "item__cta"], ["name", "chevron-forward-outline"], ["animated", "", 1, "list__item", "item"], ["animated", "", 1, "item__skeleton"]],
    template: function AllCategoriesPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "widget-layout", 1)(1, "widget-layout", 2)(2, "widget-layout", 3)(3, "app-header", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](4, "ion-content", 5)(5, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](6, AllCategoriesPageComponent_ng_container_6_Template, 5, 3, "ng-container", 7)(7, AllCategoriesPageComponent_ng_template_7_Template, 2, 1, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        const elseBlock_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵreference"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("isOnlySearchHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", ctx.categories && ctx.categories.length > 0)("ngIfElse", elseBlock_r4);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_7__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonSkeletonText, _header_header_component__WEBPACK_IMPORTED_MODULE_1__.HeaderComponent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent],
    styles: [".all-categories[_ngcontent-%COMP%] {\n  --padding-bottom: 0px;\n  --background: var(--color-surface, #fff);\n}\n.all-categories__list[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-250, 20px) var(--mag-spacing-250, 20px) var(--mag-spacing-250, 20px);\n}\n.all-categories__list[_ngcontent-%COMP%]   .list__item[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n  align-items: center;\n  padding: var(--mag-spacing-300, 24px) 0px;\n  border-bottom: var(--mag-border-width-1, 1px) solid var(--mag-color-border-divider, #eee);\n  gap: var(--mag-spacing-100, 8px);\n  background: transparent;\n}\n.all-categories__list[_ngcontent-%COMP%]   .list__item[_ngcontent-%COMP%]   .item__text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.all-categories__list[_ngcontent-%COMP%]   .list__item[_ngcontent-%COMP%]   .item__cta[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  width: 18px;\n  height: 18px;\n  color: var(--mag-color-text-primary, #121212);\n  fill: var(--mag-color-text-primary, #121212);\n  -webkit-text-fill-color: var(--mag-color-icon-primary, #121212);\n}\n.all-categories__list[_ngcontent-%COMP%]   .list__item[_ngcontent-%COMP%]   .item__skeleton[_ngcontent-%COMP%] {\n  width: 100%;\n  border-radius: 10px;\n  height: calc(var(--mag-typography-body-medium-line-height, 24px) + 2 * var(--mag-spacing-300, 24px));\n}\n.all-categories__list[_ngcontent-%COMP%]   .list__item[_ngcontent-%COMP%]:last-child {\n  border-bottom: 0px;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvcGFnZXMvYWxsLWNhdGVnb3JpZXMvYWxsLWNhdGVnb3JpZXMuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxxQkFBQTtFQUNBLHdDQUFBO0FBQ0Y7QUFBRTtFQUNFLGFBQUE7RUFDQSxzQkFBQTtFQUNBLDRIQUFBO0FBRUo7QUFDTTtFQUNFLGFBQUE7RUFDQSw4QkFBQTtFQUNBLG1CQUFBO0VBQ0EseUNBQUE7RUFDQSx5RkFBQTtFQUNBLGdDQUFBO0VBQ0EsdUJBQUE7QUFDUjtBQUVVO0VBQ0UsNkNBQUE7RUFDQSwrREFBQTtFQUNBLDREQUFBO0VBQ0Esa0JBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0FBQVo7QUFJWTtFQUNFLFdBQUE7RUFDQSxZQUFBO0VBQ0EsNkNBQUE7RUFDQSw0Q0FBQTtFQUNBLCtEQUFBO0FBRmQ7QUFNVTtFQUNFLFdBQUE7RUFDQSxtQkFBQTtFQUNBLG9HQUFBO0FBSlo7QUFRTTtFQUNFLGtCQUFBO0FBTlIiLCJzb3VyY2VzQ29udGVudCI6WyIuYWxsLWNhdGVnb3JpZXMge1xuICAtLXBhZGRpbmctYm90dG9tOiAwcHg7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tY29sb3Itc3VyZmFjZSwgI2ZmZik7XG4gICZfX2xpc3Qge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpIHZhcigtLW1hZy1zcGFjaW5nLTI1MCwgMjBweCkgdmFyKC0tbWFnLXNwYWNpbmctMjUwLCAyMHB4KVxuICAgICAgdmFyKC0tbWFnLXNwYWNpbmctMjUwLCAyMHB4KTtcbiAgICAubGlzdCB7XG4gICAgICAmX19pdGVtIHtcbiAgICAgICAgZGlzcGxheTogZmxleDtcbiAgICAgICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuICAgICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgICAgICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpIDBweDtcbiAgICAgICAgYm9yZGVyLWJvdHRvbTogdmFyKC0tbWFnLWJvcmRlci13aWR0aC0xLCAxcHgpIHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItZGl2aWRlciwgI2VlZSk7XG4gICAgICAgIGdhcDogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuICAgICAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcblxuICAgICAgICAuaXRlbSB7XG4gICAgICAgICAgJl9fdGV4dCB7XG4gICAgICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICAgICAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksIExleGVuZCk7XG4gICAgICAgICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgICAgICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICAgICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICAgICAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gICAgICAgICAgfVxuXG4gICAgICAgICAgJl9fY3RhIHtcbiAgICAgICAgICAgIGlvbi1pY29uIHtcbiAgICAgICAgICAgICAgd2lkdGg6IDE4cHg7XG4gICAgICAgICAgICAgIGhlaWdodDogMThweDtcbiAgICAgICAgICAgICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgICAgICAgICAgICBmaWxsOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICAgICAgICAgICAgLXdlYmtpdC10ZXh0LWZpbGwtY29sb3I6IHZhcigtLW1hZy1jb2xvci1pY29uLXByaW1hcnksICMxMjEyMTIpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgIH1cblxuICAgICAgICAgICZfX3NrZWxldG9uIHtcbiAgICAgICAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgICAgICAgYm9yZGVyLXJhZGl1czogMTBweDtcbiAgICAgICAgICAgIGhlaWdodDogY2FsYyh2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCkgKyAyICogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KSk7XG4gICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICB9XG4gICAgICAmX19pdGVtOmxhc3QtY2hpbGQge1xuICAgICAgICBib3JkZXItYm90dG9tOiAwcHg7XG4gICAgICB9XG4gICAgfVxuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 75956:
/*!*********************************************************************!*\
  !*** ./src/app/modules/browse/pages/category/category.component.ts ***!
  \*********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CategoryPageComponent: () => (/* binding */ CategoryPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _rsApp_modules_ecom_v2_product_providers_product_search_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/ecom-v2/product/providers/product-search.service */ 84898);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var lodash_cloneDeep__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! lodash/cloneDeep */ 23891);
/* harmony import */ var lodash_cloneDeep__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(lodash_cloneDeep__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! rxjs */ 51567);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! rxjs */ 91817);
/* harmony import */ var _provider_category_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../provider/category.service */ 39548);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @pscoped/ngx-pub-sub */ 2055);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../header/header.component */ 55074);
/* harmony import */ var _header_components_search_search_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../header/components/search/search.component */ 64269);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _component_categories_swiper_categories_swiper_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../component/categories-swiper/categories-swiper.component */ 33461);

























function CategoryPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 9);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "category/" + ctx_r0.catCode)("slug", ctx_r0.router.url);
  }
}
function CategoryPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 10);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "category/" + ctx_r0.catCode)("slug", ctx_r0.router.url);
  }
}
function CategoryPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](0, "widget-layout", 11);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "category/" + ctx_r0.catCode)("slug", ctx_r0.router.url);
  }
}
function CategoryPageComponent_ng_container_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](1, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](2, "ion-spinner", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerEnd"]();
  }
}
function CategoryPageComponent_ng_template_8_ng_container_2_ng_container_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "app-categories-swiper", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("category", ctx_r0.category)("spaceBetween", 24)("disable", ctx_r0.disableCategory);
  }
}
function CategoryPageComponent_ng_template_8_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](1, "div", 20)(2, "div", 21)(3, "div", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](5, CategoryPageComponent_ng_template_8_ng_container_2_ng_container_5_Template, 2, 3, "ng-container", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtextInterpolate"](ctx_r0.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", (ctx_r0.category == null ? null : ctx_r0.category.SubCategories == null ? null : ctx_r0.category.SubCategories.length) >= ctx_r0.MINIMUM_NUMBER_CATEGORY);
  }
}
function CategoryPageComponent_ng_template_8_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](0, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](1, "widget-layout", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](2, CategoryPageComponent_ng_template_8_ng_container_2_Template, 6, 2, "ng-container", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](3, "div", 17)(4, "mag-search-container", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵlistener"]("onContentLoaded", function CategoryPageComponent_ng_template_8_Template_mag_search_container_onContentLoaded_4_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵrestoreView"](_r2);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵresetView"](ctx_r0.onContentLoaded());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](5, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](6, "widget-layout", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "category/" + ctx_r0.catCode)("slug", ctx_r0.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx_r0.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("isDepartment", ctx_r0.isDepartment)("keyword", ctx_r0.keyword)("queryParams", ctx_r0.queryParamsString);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("objectId", "category/" + ctx_r0.catCode)("slug", ctx_r0.router.url);
  }
}
class CategoryPageComponent {
  router;
  route;
  categoryService;
  productSearchService;
  dxpComponentService;
  events;
  translate;
  ngZone;
  location;
  MINIMUM_NUMBER_CATEGORY = 3;
  category = null;
  title = '';
  catCode;
  loaded;
  isAllCategoryMode = false;
  isAddedListener = false;
  destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_11__.Subject();
  eventListenerFn;
  catSub = null;
  isDepartment = '';
  keyword = '';
  queryParamsString;
  disableCategory = true;
  fromDetailPage = false;
  constructor(router, route, categoryService, productSearchService, dxpComponentService, events, translate, ngZone, location) {
    this.router = router;
    this.route = route;
    this.categoryService = categoryService;
    this.productSearchService = productSearchService;
    this.dxpComponentService = dxpComponentService;
    this.events = events;
    this.translate = translate;
    this.ngZone = ngZone;
    this.location = location;
    this.router.events.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_12__.takeUntil)(this.destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_13__.filter)(e => e instanceof _angular_router__WEBPACK_IMPORTED_MODULE_14__.NavigationEnd)).subscribe(() => {
      this.fromDetailPage = history.state?.fromDetailPage ?? false;
      this.fromDetailPage && this.clearNavigationState();
    });
  }
  clearNavigationState() {
    const cleanState = {
      ...history.state
    };
    delete cleanState.fromDetailPage;
    history.replaceState(cleanState, document.title, location.pathname + location.search);
  }
  isLocalSearch() {
    return !!this.title;
  }
  hasCategories() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      return new Promise(resolve => {
        _this.categoryService.getCategories().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_12__.takeUntil)(_this.destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_15__.distinctUntilChanged)()).subscribe(category => {
          if (category && category.length > 0) {
            resolve(true);
          }
        });
      });
    })();
  }
  ngOnInit() {
    var _this2 = this;
    this.route.queryParams.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_12__.takeUntil)(this.destroy$)).subscribe(/*#__PURE__*/function () {
      var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (params) {
        const {
          paramsFromUrls,
          cats
        } = _this2.getParamsFromUrls(params);
        yield _this2.hasCategories();
        _this2.initCategoryData(paramsFromUrls);
        _this2.catCode = cats;
        _this2.loaded = true;
      });
      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }());
    document.body.addEventListener('eventChangedParamsMagSearch', this.handleParamChange);
  }
  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
    document.body.removeEventListener('eventChangedParamsMagSearch', this.handleParamChange);
  }
  clearQueryParams() {
    const path = this.router.url.split('?')[0];
    this.location.replaceState(path);
  }
  ionViewDidLeave() {
    this.productSearchService.setKeyWord('');
    this.isAllCategoryMode = false;
  }
  getParamsFromUrls(params) {
    const queryParams = params || this.route.snapshot.queryParams;
    const {
      cats,
      catsName,
      dept,
      brands,
      promo,
      diet,
      featured
    } = queryParams || {};
    const paramsFromUrls = {
      categoryCodes: cats?.split(';'),
      categoryNames: catsName?.split(';'),
      dept: (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.convertToArray)(dept),
      brands: (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.convertToArray)(brands),
      promo: (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.convertToArray)(promo),
      diet: (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.convertToArray)(diet),
      featured: (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.convertToArray)(featured)
    };
    return {
      paramsFromUrls,
      cats,
      catsName
    };
  }
  initCategory() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        paramsFromUrls,
        cats,
        catsName
      } = _this3.getParamsFromUrls();
      yield _this3.initCategoryData(paramsFromUrls);
      _this3.categoryService.saveCategoryCodesAndNames([cats], [catsName]);
      _this3.catCode = cats;
      _this3.loaded = true;
    })();
  }
  handleParamChange = (() => {
    var _this4 = this;
    return function () {
      var _ref2 = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (event) {
        const dxpParams = (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.preprocessParams)(event?.detail);
        if (!dxpParams || _this4.productSearchService.isProductSearchListPage()) return;
        const {
          cats = [],
          catsName = [],
          featured = []
        } = dxpParams || {};
        _this4.prepareInfo(cats, catsName, featured);
      });
      return function (_x2) {
        return _ref2.apply(this, arguments);
      };
    }();
  })();
  prepareInfo(categoryCodes, categoryNames, featured) {
    if (featured?.length > 0) {
      this.title = '';
    }
    if (this.category?.Code === categoryCodes.at(-1)) return; // No change in category, do nothing
    this.isAllCategoryMode = categoryCodes?.length === 0 && categoryNames?.length === 0 && featured?.length === 0;
    if (this.isAllCategoryMode) {
      this.title = this.translate.instant('browse.titleAllCategories');
      this.category = null;
      this.categoryService.navigateToAllCategories();
    } else {
      this.category = lodash_cloneDeep__WEBPACK_IMPORTED_MODULE_4___default()(this.categoryService.getCategoryByCode(categoryCodes));
      this.title = categoryNames.at(-1) || '';
    }
  }
  initCategoryData(_x3) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* ({
      categoryCodes = [],
      categoryNames = [],
      brands = [],
      dept = [],
      promo = [],
      diet = [],
      featured = []
    }) {
      _this5.catSub = _this5.categoryService.getCategories().subscribe(/*#__PURE__*/function () {
        var _ref3 = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (categories) {
          if (!categories) return;
          _this5.prepareInfo(categoryCodes, categoryNames, featured);
          // Get keyword for search
          const keyword = (yield _this5.productSearchService.getKeyWordString()) || '';
          // Prepare filters
          const filterParams = {
            Categories: categoryCodes,
            Brands: brands,
            Departments: dept,
            Promotions: promo,
            DietaryInterest: diet,
            Featured: featured || []
          };
          _this5.setParamsChange(keyword, filterParams);
          _this5.catSub?.unsubscribe();
          _this5.catSub = null;
        });
        return function (_x4) {
          return _ref3.apply(this, arguments);
        };
      }());
    }).apply(this, arguments);
  }
  setParamsChange(keyword, filterParams) {
    this.disableCategory = true;
    this.ngZone.run(() => {
      this.isDepartment = '';
      this.keyword = keyword || '';
      if (typeof filterParams === 'object' && filterParams !== null) {
        if (this.fromDetailPage) {
          Object.assign(filterParams, {
            timeChange: new Date().getTime()
          });
          this.fromDetailPage = false;
        }
        this.queryParamsString = JSON.stringify(filterParams);
      }
    });
  }
  onContentLoaded() {
    this.disableCategory = false;
  }
  static ɵfac = function CategoryPageComponent_Factory(t) {
    return new (t || CategoryPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_14__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_14__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_provider_category_service__WEBPACK_IMPORTED_MODULE_5__.CategoryService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_rsApp_modules_ecom_v2_product_providers_product_search_service__WEBPACK_IMPORTED_MODULE_1__.ProductSearchService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_16__.NgxPubSubService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_17__.TranslateService), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_10__.NgZone), _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_18__.Location));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵdefineComponent"]({
    type: CategoryPageComponent,
    selectors: [["app-category"]],
    decls: 10,
    vars: 8,
    consts: [["loadedContent", ""], ["type", "category", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "category", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "category", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader"], [1, "header-simple__container"], [3, "isLocalSearch", "isShowBackButton"], [1, "category"], [4, "ngIf", "ngIfElse"], ["type", "category", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "category", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "category", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "loading-container"], ["name", "crescent"], [1, "widget-layout"], ["type", "category", "zoneName", "Top", 3, "objectId", "slug"], [4, "ngIf"], [1, "wrapper__department-search"], ["view-mode", "mobile", 3, "onContentLoaded", "isDepartment", "keyword", "queryParams"], ["type", "category", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "category__container", "container"], [1, "container__wrapper", "wrapper"], [1, "wrapper__title"], [3, "category", "spaceBetween", "disable"]],
    template: function CategoryPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](0, CategoryPageComponent_widget_layout_0_Template, 1, 2, "widget-layout", 1)(1, CategoryPageComponent_widget_layout_1_Template, 1, 2, "widget-layout", 2)(2, CategoryPageComponent_widget_layout_2_Template, 1, 2, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](3, "app-header", 4)(4, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelement"](5, "app-search", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementStart"](6, "ion-content", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplate"](7, CategoryPageComponent_ng_container_7_Template, 3, 0, "ng-container", 8)(8, CategoryPageComponent_ng_template_8_Template, 7, 8, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        const loadedContent_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵreference"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("isSimpleHeader", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("isLocalSearch", false)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_10__["ɵɵproperty"]("ngIf", !ctx.loaded)("ngIfElse", loadedContent_r3);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_18__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_19__.IonSpinner, _header_header_component__WEBPACK_IMPORTED_MODULE_6__.HeaderComponent, _header_components_search_search_component__WEBPACK_IMPORTED_MODULE_7__.SearchComponent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_8__.WidgetLayoutComponent, _component_categories_swiper_categories_swiper_component__WEBPACK_IMPORTED_MODULE_9__.CategoriesSwiperComponent],
    styles: ["[_nghost-%COMP%]     .category__container {\n  padding-top: var(--mag-spacing-400, 32px);\n}\n[_nghost-%COMP%]     .category__container .container__wrapper {\n  margin-bottom: -8px;\n  padding-top: var(--mag-spacing-300, 24px);\n  display: flex;\n  flex-direction: column;\n  gap: var(--mag-spacing-300, 24px);\n}\n[_nghost-%COMP%]     .category__container .container__wrapper .wrapper__title {\n  padding: 0px var(--mag-spacing-200, 16px);\n  color: var(--mag-color-text-primary, #121212);\n  font-size: var(--mag-typography-display-large-font-size, 32px);\n  font-style: normal;\n  font-weight: var(--mag-typography-display-large-font-weight, 600);\n  line-height: var(--mag-typography-display-large-line-height, 40px);\n}\n\n.widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9icm93c2UvcGFnZXMvY2F0ZWdvcnkvY2F0ZWdvcnkuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQ0U7RUFDRSx5Q0FBQTtBQUFKO0FBRU07RUFDRSxtQkFBQTtFQUNBLHlDQUFBO0VBRUEsYUFBQTtFQUNBLHNCQUFBO0VBQ0EsaUNBQUE7QUFEUjtBQUdVO0VBQ0UseUNBQUE7RUFDQSw2Q0FBQTtFQUNBLDhEQUFBO0VBQ0Esa0JBQUE7RUFDQSxpRUFBQTtFQUNBLGtFQUFBO0FBRFo7O0FBU0E7RUFDRSx1Q0FBQTtBQU5GIiwic291cmNlc0NvbnRlbnQiOlsiOmhvc3QgOjpuZy1kZWVwIC5jYXRlZ29yeSB7XG4gICZfX2NvbnRhaW5lciB7XG4gICAgcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG4gICAgLmNvbnRhaW5lciB7XG4gICAgICAmX193cmFwcGVyIHtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogLThweDtcbiAgICAgICAgcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweCk7XG5cbiAgICAgICAgZGlzcGxheTogZmxleDtcbiAgICAgICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICAgICAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpO1xuICAgICAgICAud3JhcHBlciB7XG4gICAgICAgICAgJl9fdGl0bGUge1xuICAgICAgICAgICAgcGFkZGluZzogMHB4IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gICAgICAgICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICAgICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRpc3BsYXktbGFyZ2UtZm9udC1zaXplLCAzMnB4KTtcbiAgICAgICAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgICAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LWxhcmdlLWZvbnQtd2VpZ2h0LCA2MDApO1xuICAgICAgICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWRpc3BsYXktbGFyZ2UtbGluZS1oZWlnaHQsIDQwcHgpO1xuICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cbiAgfVxufVxuXG4ud2lkZ2V0LWxheW91dCB7XG4gIHBhZGRpbmc6IDAgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_browse_browse_router_module_ts.js.map