"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_recipe_recipe-routing_module_ts"],{

/***/ 24571:
/*!*****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/recipe/pages/recipe-detail/recipe-detail.ts ***!
  \*****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecipeDetailPageComponent: () => (/* binding */ RecipeDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! rxjs */ 98764);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _providers_recipe_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../providers/recipe.service */ 68879);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_components_mag_app_bottom_sheet_mag_app_bottom_sheet__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../../../components/mag-app-bottom-sheet/mag-app-bottom-sheet */ 66088);
/* harmony import */ var _rsApp_modules_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @rsApp/modules/utils/providers/tenant-settings.service */ 84852);
/* harmony import */ var _capacitor_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @capacitor/core */ 14070);
/* harmony import */ var _capacitor_share__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @capacitor/share */ 74334);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _shared_page_not_found_not_found__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../../shared/page/not-found/not-found */ 9217);
/* harmony import */ var _components_mag_app_share_mag_app_share__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../../../components/mag-app-share/mag-app-share */ 38184);
/* harmony import */ var _components_mag_app_share_email_mag_app_share_email__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../../../components/mag-app-share-email/mag-app-share-email */ 8568);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! @ngx-translate/core */ 90852);



































const _c0 = ["bottomSheet"];
const _c1 = ["bottomSheetMail"];
const _c2 = a0 => ({
  "recipe-detail__des-content--blur": a0
});
const _c3 = a0 => ({
  "recipe-detail__content": a0
});
function RecipeDetailPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 17);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("objectId", "recipe/" + (ctx_r1.recipe == null ? null : ctx_r1.recipe.Code))("slug", ctx_r1.router.url);
  }
}
function RecipeDetailPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 18);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("objectId", "recipe/" + (ctx_r1.recipe == null ? null : ctx_r1.recipe.Code))("slug", ctx_r1.router.url);
  }
}
function RecipeDetailPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 19);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("objectId", "recipe/" + (ctx_r1.recipe == null ? null : ctx_r1.recipe.Code))("slug", ctx_r1.router.url);
  }
}
function RecipeDetailPageComponent_widget_layout_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 20);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("objectId", "recipe/" + (ctx_r1.recipe == null ? null : ctx_r1.recipe.Code))("slug", ctx_r1.router.url);
  }
}
function RecipeDetailPageComponent_ng_container_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](1, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](2, "ion-spinner", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
}
function RecipeDetailPageComponent_ng_container_10_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](1, "page-not-found");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
}
function RecipeDetailPageComponent_ng_container_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](1, RecipeDetailPageComponent_ng_container_10_ng_container_1_Template, 2, 0, "ng-container", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    const recipeDetail_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵreference"](12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !ctx_r1.recipe)("ngIfElse", recipeDetail_r3);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "div", 38);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](1, 1, ctx_r1.dxpGallery), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
  }
}
function RecipeDetailPageComponent_ng_template_11_ion_img_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "ion-img", 39);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("src", ctx_r1.defaultRecipeImage);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 40)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](ctx_r1.recipe == null ? null : ctx_r1.recipe.Title == null ? null : ctx_r1.recipe.Title.En);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_5_ion_img_2_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-img", 43);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("ionError", function RecipeDetailPageComponent_ng_template_11_div_5_ion_img_2_Template_ion_img_ionError_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r4);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r1.loadingImageFailed = true);
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("src", ctx_r1.recipe == null ? null : ctx_r1.recipe.Logo == null ? null : ctx_r1.recipe.Logo.CloudUrl);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 41);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](2, RecipeDetailPageComponent_ng_template_11_div_5_ion_img_2_Template, 1, 1, "ion-img", 42);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"](" By ", !(ctx_r1.recipe == null ? null : ctx_r1.recipe.Logo == null ? null : ctx_r1.recipe.Logo.CloudUrl) || ctx_r1.loadingImageFailed ? ctx_r1.recipe == null ? null : ctx_r1.recipe.Logo == null ? null : ctx_r1.recipe.Logo.Name == null ? null : ctx_r1.recipe.Logo.Name.En : "", " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Logo == null ? null : ctx_r1.recipe.Logo.CloudUrl);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_6_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](1, "div", 46);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const attr_r5 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](attr_r5 == null ? null : attr_r5.Name == null ? null : attr_r5.Name.En);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 44);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](1, RecipeDetailPageComponent_ng_template_11_div_6_ng_container_1_Template, 3, 1, "ng-container", 45);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngForOf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Categories);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_7_ion_button_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-button", 50);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function RecipeDetailPageComponent_ng_template_11_div_7_ion_button_3_Template_ion_button_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r6);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r1.openShare());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](1, "ion-img", 51);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](2, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](4, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](4, 1, "productDetail.share"));
  }
}
function RecipeDetailPageComponent_ng_template_11_div_7_ng_template_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "div", 52);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](1, 1, ctx_r1.dxpShareRecipeBtn), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 47);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](1, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](2, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](3, RecipeDetailPageComponent_ng_template_11_div_7_ion_button_3_Template, 5, 3, "ion-button", 49)(4, RecipeDetailPageComponent_ng_template_11_div_7_ng_template_4_Template, 2, 3, "ng-template", null, 3, _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const webShare_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵreference"](5);
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](2, 3, ctx_r1.dxpSavedRecipeBtn), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.isNative)("ngIfElse", webShare_r7);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_div_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 60)(1, "div", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "div", 62);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.preparationTime"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"](" ", ctx_r1.recipe == null ? null : ctx_r1.recipe.PrepareTime, " mins ");
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 60)(1, "div", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "div", 63);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.cookingTime"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"]("", ctx_r1.recipe == null ? null : ctx_r1.recipe.CookTime, " mins");
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 60)(1, "div", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "div", 63);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.readyIn"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"]("", ctx_r1.recipe == null ? null : ctx_r1.recipe.ReadyTime, " mins");
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 60)(1, "div", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "div", 63);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.servings"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](ctx_r1.recipe == null ? null : ctx_r1.recipe.Servings);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 60)(1, "div", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "div", 63);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.difficulty"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](ctx_r1.recipe == null ? null : ctx_r1.recipe.Difficulty == null ? null : ctx_r1.recipe.Difficulty.En);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_div_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](1, "ion-text", 64);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction1"](2, _c3, ctx_r1.isReadMore && !ctx_r1.hideReadMore))("innerHTML", ctx_r1.recipe == null ? null : ctx_r1.recipe.Description == null ? null : ctx_r1.recipe.Description.En, _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_ion_button_13_Template(rf, ctx) {
  if (rf & 1) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-button", 65);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function RecipeDetailPageComponent_ng_template_11_div_8_ion_button_13_Template_ion_button_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r8);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r1.changeDesView());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"](" ", ctx_r1.isReadMore ? _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](2, 1, "recipe.readMore") : _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 3, "recipe.readLess"), " ");
  }
}
function RecipeDetailPageComponent_ng_template_11_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 53)(1, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](4, "div", 55);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](5, "div", 56);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](6, RecipeDetailPageComponent_ng_template_11_div_8_div_6_Template, 6, 4, "div", 57)(7, RecipeDetailPageComponent_ng_template_11_div_8_div_7_Template, 6, 4, "div", 57)(8, RecipeDetailPageComponent_ng_template_11_div_8_div_8_Template, 6, 4, "div", 57)(9, RecipeDetailPageComponent_ng_template_11_div_8_div_9_Template, 6, 4, "div", 57)(10, RecipeDetailPageComponent_ng_template_11_div_8_div_10_Template, 6, 4, "div", 57);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](11, "div", 58);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](12, RecipeDetailPageComponent_ng_template_11_div_8_div_12_Template, 2, 4, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](13, RecipeDetailPageComponent_ng_template_11_div_8_ion_button_13_Template, 4, 5, "ion-button", 59);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 9, "recipe.recipeDescription"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.PrepareTime);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.CookTime);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.ReadyTime);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Servings);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", (ctx_r1.recipe == null ? null : ctx_r1.recipe.Difficulty == null ? null : ctx_r1.recipe.Difficulty.En) && (ctx_r1.recipe == null ? null : ctx_r1.recipe.Difficulty == null ? null : ctx_r1.recipe.Difficulty.En) !== "None");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction1"](11, _c2, ctx_r1.isReadMore && !ctx_r1.hideReadMore));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Description == null ? null : ctx_r1.recipe.Description.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", (ctx_r1.recipe == null ? null : ctx_r1.recipe.Description == null ? null : ctx_r1.recipe.Description.En == null ? null : ctx_r1.recipe.Description.En.length) > 0 && !ctx_r1.hideReadMore);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_9_ion_item_10_ion_checkbox_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r9 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-checkbox", 74);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtwoWayListener"]("ngModelChange", function RecipeDetailPageComponent_ng_template_11_div_9_ion_item_10_ion_checkbox_1_Template_ion_checkbox_ngModelChange_0_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r9);
      const ing_r10 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]().$implicit;
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtwoWayBindingSet"](ing_r10.checked, $event) || (ing_r10.checked = $event);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"]($event);
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("ionChange", function RecipeDetailPageComponent_ng_template_11_div_9_ion_item_10_ion_checkbox_1_Template_ion_checkbox_ionChange_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r9);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](4);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r1.countCheckedItems());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ing_r10 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtwoWayProperty"]("ngModel", ing_r10.checked);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_9_ion_item_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-item", 72);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](1, RecipeDetailPageComponent_ng_template_11_div_9_ion_item_10_ion_checkbox_1_Template, 1, 1, "ion-checkbox", 73);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](2, "ion-label");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ing_r10 = ctx.$implicit;
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !ctx_r1.isAdjustUI);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](ing_r10 == null ? null : ing_r10.Name == null ? null : ing_r10.Name.En);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_9_div_11_ion_button_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r11 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-button", 79);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function RecipeDetailPageComponent_ng_template_11_div_9_div_11_ion_button_1_Template_ion_button_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r11);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](4);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r1.unselectAll());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](2, 1, "recipe.unselectAll"));
  }
}
function RecipeDetailPageComponent_ng_template_11_div_9_div_11_ion_button_2_Template(rf, ctx) {
  if (rf & 1) {
    const _r12 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-button", 80);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function RecipeDetailPageComponent_ng_template_11_div_9_div_11_ion_button_2_Template_ion_button_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r12);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](4);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r1.selectAll());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](2, 1, "recipe.selectAll"));
  }
}
function RecipeDetailPageComponent_ng_template_11_div_9_div_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 75);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](1, RecipeDetailPageComponent_ng_template_11_div_9_div_11_ion_button_1_Template, 3, 3, "ion-button", 76)(2, RecipeDetailPageComponent_ng_template_11_div_9_div_11_ion_button_2_Template, 3, 3, "ion-button", 77);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](3, "mag-add-ingredients-button", 78);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.checkedCount && ctx_r1.checkedCount === (ctx_r1.recipe == null ? null : ctx_r1.recipe.Ingredients == null ? null : ctx_r1.recipe.Ingredients.length));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.checkedCount !== (ctx_r1.recipe == null ? null : ctx_r1.recipe.Ingredients == null ? null : ctx_r1.recipe.Ingredients.length));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("recipeCode", ctx_r1.recipe == null ? null : ctx_r1.recipe.Code)("recipeName", ctx_r1.recipe == null ? null : ctx_r1.recipe.Title == null ? null : ctx_r1.recipe.Title.En)("ingredients", ctx_r1.checkedIngredients)("disabled", ctx_r1.checkedCount === 0);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 66)(1, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](4, "div", 55);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](5, "fieldset", 67)(6, "legend", 68);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](8, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](9, "ion-list", 69);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](10, RecipeDetailPageComponent_ng_template_11_div_9_ion_item_10_Template, 4, 2, "ion-item", 70);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](11, RecipeDetailPageComponent_ng_template_11_div_9_div_11_Template, 4, 6, "div", 71);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 4, "recipe.ingredients"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](8, 6, "recipe.instructions"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngForOf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Ingredients);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !ctx_r1.isAdjustUI);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 81)(1, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](4, "div", 55)(5, "div", 82);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](6, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.directions"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](6, 4, ctx_r1.recipe == null ? null : ctx_r1.recipe.PreparationInstructions == null ? null : ctx_r1.recipe.PreparationInstructions.En), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 83)(1, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](4, "div", 55)(5, "div", 84);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](6, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.nutrition"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](6, 4, ctx_r1.recipe == null ? null : ctx_r1.recipe.NutritionValue == null ? null : ctx_r1.recipe.NutritionValue.En), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
  }
}
function RecipeDetailPageComponent_ng_template_11_div_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 85)(1, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](4, "div", 55)(5, "div", 38);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](6, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](3, 2, "recipe.tips"));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](6, 4, ctx_r1.recipe == null ? null : ctx_r1.recipe.TipNotes == null ? null : ctx_r1.recipe.TipNotes.En), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsanitizeHtml"]);
  }
}
function RecipeDetailPageComponent_ng_template_11_mag_product_list_recipe_13_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "mag-product-list-recipe", 86);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("relatedProducts", ctx_r1.recipe == null ? null : ctx_r1.recipe.RelatedProducts);
  }
}
function RecipeDetailPageComponent_ng_template_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "div", 24)(1, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](2, RecipeDetailPageComponent_ng_template_11_div_2_Template, 2, 3, "div", 26)(3, RecipeDetailPageComponent_ng_template_11_ion_img_3_Template, 1, 1, "ion-img", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](4, RecipeDetailPageComponent_ng_template_11_div_4_Template, 3, 1, "div", 28)(5, RecipeDetailPageComponent_ng_template_11_div_5_Template, 3, 2, "div", 29)(6, RecipeDetailPageComponent_ng_template_11_div_6_Template, 2, 1, "div", 30)(7, RecipeDetailPageComponent_ng_template_11_div_7_Template, 6, 5, "div", 31)(8, RecipeDetailPageComponent_ng_template_11_div_8_Template, 14, 13, "div", 32)(9, RecipeDetailPageComponent_ng_template_11_div_9_Template, 12, 8, "div", 33)(10, RecipeDetailPageComponent_ng_template_11_div_10_Template, 7, 6, "div", 34)(11, RecipeDetailPageComponent_ng_template_11_div_11_Template, 7, 6, "div", 35)(12, RecipeDetailPageComponent_ng_template_11_div_12_Template, 7, 6, "div", 36)(13, RecipeDetailPageComponent_ng_template_11_mag_product_list_recipe_13_Template, 1, 1, "mag-product-list-recipe", 37);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", (ctx_r1.recipe == null ? null : ctx_r1.recipe.Images == null ? null : ctx_r1.recipe.Images.length) > 0 && ctx_r1.dxpGallery);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !(ctx_r1.recipe == null ? null : ctx_r1.recipe.Images == null ? null : ctx_r1.recipe.Images.length));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Title == null ? null : ctx_r1.recipe.Title.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.Logo);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", (ctx_r1.recipe == null ? null : ctx_r1.recipe.Categories == null ? null : ctx_r1.recipe.Categories.length) > 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.dxpSavedRecipeBtn);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.PrepareTime);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", (ctx_r1.recipe == null ? null : ctx_r1.recipe.Ingredients == null ? null : ctx_r1.recipe.Ingredients.length) > 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.PreparationInstructions == null ? null : ctx_r1.recipe.PreparationInstructions.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.NutritionValue == null ? null : ctx_r1.recipe.NutritionValue.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.TipNotes == null ? null : ctx_r1.recipe.TipNotes.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r1.recipe == null ? null : ctx_r1.recipe.RelatedProducts);
  }
}
function RecipeDetailPageComponent_widget_layout_13_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 87);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("objectId", "recipe/" + (ctx_r1.recipe == null ? null : ctx_r1.recipe.Code))("slug", ctx_r1.router.url);
  }
}
class RecipeDetailPageComponent {
  router;
  utils;
  route;
  cStore;
  navCtrl;
  appSettings;
  recipeService;
  dxpComponentService;
  cre;
  tenantSettingsStore;
  slug;
  isReadMore = true;
  hideReadMore = false;
  checkedCount = 0;
  isFavorite = false;
  loadingImageFailed = false;
  isAdjustUI = false;
  loaded = false;
  defaultRecipeImage;
  isNative = false;
  recipe;
  checkedIngredients = [];
  webSEOUrl;
  //dxp
  dxpGallery;
  dxpSavedRecipeBtn;
  dxpShareRecipeBtn;
  bottomSheetComponent;
  bottomSheetMailComponent;
  sharingOptions = [{
    type: 'email',
    actionText: 'Mail',
    icon: 'mail-outline'
  }, {
    type: 'more',
    actionText: 'More',
    icon: 'ellipsis-horizontal-outline'
  }];
  tenantSettings;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_19__.Subject();
  constructor(router, utils, route, cStore, navCtrl, appSettings, recipeService, dxpComponentService, cre, tenantSettingsStore) {
    this.router = router;
    this.utils = utils;
    this.route = route;
    this.cStore = cStore;
    this.navCtrl = navCtrl;
    this.appSettings = appSettings;
    this.recipeService = recipeService;
    this.dxpComponentService = dxpComponentService;
    this.cre = cre;
    this.tenantSettingsStore = tenantSettingsStore;
    this.route.params.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_20__.takeUntil)(this._destroy$)).subscribe(param => {
      this.slug = param?.slug || '';
    });
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.isAdjustUI = (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.toBoolean)(yield (0,rxjs__WEBPACK_IMPORTED_MODULE_21__.firstValueFrom)(_this.appSettings.getSettingValue('adjust_ui_temporary')));
      _this.tenantSettings = yield _this.tenantSettingsStore.getTenantSettings();
    })();
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  ionViewWillEnter() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        yield _this2.init();
      } catch (error) {
        console.error(error);
      }
    })();
  }
  ionViewDidEnter() {
    this.appSettings.getSettingValue('recipe_default_image_url').pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_20__.takeUntil)(this._destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_22__.tap)(val => {
      this.defaultRecipeImage = val;
    })).subscribe();
  }
  ionViewDidLeave() {
    this.dxpGallery = '';
    this.dxpSavedRecipeBtn = '';
    this.dxpShareRecipeBtn = '';
    this.webSEOUrl = '';
  }
  init() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this3.isNative = _capacitor_core__WEBPACK_IMPORTED_MODULE_10__.Capacitor.isNativePlatform();
      _this3.checkedCount = 0;
      _this3.loaded = false;
      _this3.recipe = _this3.slug && (yield (0,rxjs__WEBPACK_IMPORTED_MODULE_21__.firstValueFrom)(_this3.recipeService.getRecipe({
        userId: _this3.cre.currentUser?.UserId,
        Code: _this3.slug
      })));
      _this3.loaded = true;
      _this3.initUiFromDxp();
      _this3.hideReadMore = _this3.recipe?.Description?.En?.length < 250;
    })();
  }
  updateMagGallery(images) {
    const imageStr = images?.map(img => {
      return img?.CloudUrl;
    });
    this.dxpGallery = `<mag-gallery image-string='${(0,lodash__WEBPACK_IMPORTED_MODULE_3__.escape)(JSON.stringify(imageStr))}'></mag-gallery>`;
  }
  initUiFromDxp() {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const formatSavedRecipe = _this4.recipe && (0,lodash__WEBPACK_IMPORTED_MODULE_3__.escape)(JSON.stringify(_this4.recipe));
      const webRecipeSlug = _this4.utils.getSEOSlug(_this4.recipe?.Title?.En, _this4.recipe?.Code);
      const webSEOUrl = yield _this4.utils.mappingWebSEOUrl('recipe', webRecipeSlug);
      _this4.webSEOUrl = webSEOUrl;
      _this4.dxpShareRecipeBtn = `<mag-share-button show-copy-button=${!!webSEOUrl} share-url=${webSEOUrl} item-id=${_this4.recipe?.Code} share-type=${'recipe'} is-show-label=${true} share-image-url=${_this4.recipe?.Images[0]?.CloudUrl}></mag-share-button>`;
      _this4.dxpSavedRecipeBtn = `<mag-recipe-favorite-button class="recipe-detail__save-action" recipe-str='${formatSavedRecipe}' is-show-label=${true} ></mag-recipe-favorite-button>`;
      _this4.updateMagGallery(_this4.recipe?.Images);
    })();
  }
  changeDesView() {
    this.isReadMore = !this.isReadMore;
  }
  selectAll() {
    (0,lodash__WEBPACK_IMPORTED_MODULE_3__.each)(this.recipe?.Ingredients, i => {
      i.checked = true;
    });
    this.countCheckedItems();
  }
  unselectAll() {
    (0,lodash__WEBPACK_IMPORTED_MODULE_3__.each)(this.recipe?.Ingredients, i => {
      i.checked = false;
    });
    this.countCheckedItems();
  }
  countCheckedItems() {
    this.checkedIngredients = (0,lodash__WEBPACK_IMPORTED_MODULE_3__.filter)(this.recipe?.Ingredients, {
      checked: true
    });
    this.checkedCount = this.checkedIngredients?.length;
  }
  handleOption(actionType) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      switch (actionType) {
        case 'email':
          _this5.bottomSheetMailComponent?.openModal();
          break;
        case 'more':
          yield _this5.openNativeShare();
          break;
      }
    })();
  }
  openShare() {
    this.bottomSheetComponent?.openModal();
  }
  openNativeShare() {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        yield _capacitor_share__WEBPACK_IMPORTED_MODULE_11__.Share.share({
          text: _this6.webSEOUrl
        });
      } catch (error) {
        console.warn(error, 'failed to share native');
      }
    })();
  }
  closeShareModal() {
    var _this7 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this7.bottomSheetMailComponent?.closeModal();
      _this7.bottomSheetComponent?.closeModal();
    })();
  }
  // Todo
  handlePrint() {
    window.print();
  }
  static ɵfac = function RecipeDetailPageComponent_Factory(t) {
    return new (t || RecipeDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_23__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_23__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_2__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_24__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_4__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_providers_recipe_service__WEBPACK_IMPORTED_MODULE_5__.RecipeService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_6__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_7__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_9__.TenantSettingsStore));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdefineComponent"]({
    type: RecipeDetailPageComponent,
    selectors: [["recipe-detail"]],
    viewQuery: function RecipeDetailPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_c0, 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵviewQuery"](_c1, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.bottomSheetComponent = _t.first);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵloadQuery"]()) && (ctx.bottomSheetMailComponent = _t.first);
      }
    },
    decls: 20,
    vars: 16,
    consts: [["recipeDetail", ""], ["bottomSheet", ""], ["bottomSheetMail", ""], ["webShare", ""], ["type", "recipe", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "recipe", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "recipe", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], [1, "ion-padding"], ["type", "recipe", "zoneName", "Top", 3, "objectId", "slug", 4, "ngIf"], [4, "ngIf"], ["type", "recipe", "zoneName", "Bottom", 3, "objectId", "slug", 4, "ngIf"], ["title", "Share"], [3, "optionSelected", "options"], ["title", "Share via Email", "showBackBtn", "true"], [3, "emailSubmitted", "recipeCode", "bannerId", "siteCode"], ["type", "recipe", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "recipe", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "recipe", "zoneName", "Fixed Center", 3, "objectId", "slug"], ["type", "recipe", "zoneName", "Top", 3, "objectId", "slug"], [1, "loading-container"], ["name", "crescent"], [4, "ngIf", "ngIfElse"], [1, "recipe-detail"], [1, "recipe-detail__img"], [3, "innerHTML", 4, "ngIf"], [3, "src", 4, "ngIf"], ["class", "recipe-detail__title mb-50", 4, "ngIf"], ["class", "recipe-detail__author mb-400", 4, "ngIf"], ["class", "recipe-detail__attributes mb-400", 4, "ngIf"], ["class", "recipe-detail__actions mb-600", 4, "ngIf"], ["class", "recipe-detail__description mb-600", 4, "ngIf"], ["class", "recipe-detail__ingredients mb-600", 4, "ngIf"], ["class", "recipe-detail__directions mb-600", 4, "ngIf"], ["class", "recipe-detail__nutritions mb-600", 4, "ngIf"], ["class", "recipe-detail__tips mb-600", 4, "ngIf"], [3, "relatedProducts", 4, "ngIf"], [3, "innerHTML"], [3, "src"], [1, "recipe-detail__title", "mb-50"], [1, "recipe-detail__author", "mb-400"], [3, "src", "ionError", 4, "ngIf"], [3, "ionError", "src"], [1, "recipe-detail__attributes", "mb-400"], [4, "ngFor", "ngForOf"], [1, "recipe-detail__attribute"], [1, "recipe-detail__actions", "mb-600"], [1, "recipe-detail__add-favorite", 3, "innerHTML"], ["fill", "clear", "class", "recipe-detail__share", 3, "click", 4, "ngIf", "ngIfElse"], ["fill", "clear", 1, "recipe-detail__share", 3, "click"], ["src", "assets/icon/share-ico.svg"], [1, "recipe-detail__share", 3, "innerHTML"], [1, "recipe-detail__description", "mb-600"], [1, "recipe-detail__session-title"], [1, "recipe-detail__session-line"], [1, "recipe-detail__description-content"], ["class", "description-content-item", 4, "ngIf"], [1, "recipe-detail__des-content", 3, "ngClass"], ["fill", "clear", "class", "recipe-detail__read-more", 3, "click", 4, "ngIf"], [1, "description-content-item"], [1, "description-content-item__name"], [1, "description-content-item__value", "description-content-item__value"], [1, "description-content-item__value"], [3, "ngClass", "innerHTML"], ["fill", "clear", 1, "recipe-detail__read-more", 3, "click"], [1, "recipe-detail__ingredients", "mb-600"], [2, "border", "0", "padding", "0", "margin", "0"], [1, "sr-only"], [1, "mb-300"], ["lines", "none", 4, "ngFor", "ngForOf"], ["class", "recipe-detail__ingredients-actions", 4, "ngIf"], ["lines", "none"], [3, "ngModel", "ngModelChange", "ionChange", 4, "ngIf"], [3, "ngModelChange", "ionChange", "ngModel"], [1, "recipe-detail__ingredients-actions"], ["class", "recipe-detail__unSelect", 3, "click", 4, "ngIf"], ["class", "recipe-detail__select", 3, "click", 4, "ngIf"], [3, "recipeCode", "recipeName", "ingredients", "disabled"], [1, "recipe-detail__unSelect", 3, "click"], [1, "recipe-detail__select", 3, "click"], [1, "recipe-detail__directions", "mb-600"], [1, "recipe-detail__directions-text", 3, "innerHTML"], [1, "recipe-detail__nutritions", "mb-600"], [1, "recipe-detail__nutrition-text", 3, "innerHTML"], [1, "recipe-detail__tips", "mb-600"], [3, "relatedProducts"], ["type", "recipe", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function RecipeDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](0, RecipeDetailPageComponent_widget_layout_0_Template, 1, 2, "widget-layout", 4)(1, RecipeDetailPageComponent_widget_layout_1_Template, 1, 2, "widget-layout", 5)(2, RecipeDetailPageComponent_widget_layout_2_Template, 1, 2, "widget-layout", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](3, "app-header", 7)(4, "ion-title", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](7, "ion-content", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](8, RecipeDetailPageComponent_widget_layout_8_Template, 1, 2, "widget-layout", 10)(9, RecipeDetailPageComponent_ng_container_9_Template, 3, 0, "ng-container", 11)(10, RecipeDetailPageComponent_ng_container_10_Template, 2, 2, "ng-container", 11)(11, RecipeDetailPageComponent_ng_template_11_Template, 14, 12, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplateRefExtractor"])(13, RecipeDetailPageComponent_widget_layout_13_Template, 1, 2, "widget-layout", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](14, "mag-app-bottom-sheet", 13, 1)(16, "mag-app-share", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("optionSelected", function RecipeDetailPageComponent_Template_mag_app_share_optionSelected_16_listener($event) {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.handleOption($event));
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](17, "mag-app-bottom-sheet", 15, 2)(19, "mag-app-share-email", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("emailSubmitted", function RecipeDetailPageComponent_Template_mag_app_share_email_emailSubmitted_19_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx.closeShareModal());
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](6, 14, "recipe.recipeTitle"));
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("options", ctx.sharingOptions);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("recipeCode", ctx.recipe == null ? null : ctx.recipe.Code)("bannerId", ctx.tenantSettings == null ? null : ctx.tenantSettings.bannerId)("siteCode", ctx.tenantSettings == null ? null : ctx.tenantSettings.siteCode);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_25__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_25__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_25__.NgIf, _angular_forms__WEBPACK_IMPORTED_MODULE_26__.NgControlStatus, _angular_forms__WEBPACK_IMPORTED_MODULE_26__.NgModel, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonCheckbox, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonItem, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonLabel, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonList, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonSpinner, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_27__.BooleanValueAccessor, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_12__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_13__.HeaderComponent, _shared_page_not_found_not_found__WEBPACK_IMPORTED_MODULE_14__.NotFoundPageComponent, _rsApp_components_mag_app_bottom_sheet_mag_app_bottom_sheet__WEBPACK_IMPORTED_MODULE_8__.MagAppBottomSheetComponent, _components_mag_app_share_mag_app_share__WEBPACK_IMPORTED_MODULE_15__.MagAppShareComponent, _components_mag_app_share_email_mag_app_share_email__WEBPACK_IMPORTED_MODULE_16__.MagAppShareEmailComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_17__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_28__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\n\nion-title[_ngcontent-%COMP%] {\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n\n  mag-recipe-favorite-button {\n  padding: 0;\n  --font-size-icon: var(--mag-typography-body-medium-font-size, 16px);\n  --background-color-button: transparent;\n  --width-button: 100%;\n  --height-button: 100%;\n  --color-icon: var(--mag-color-text-primary, #121212);\n  --border-radius-button: 0;\n  --out-line-offset-button: 0;\n}\n\n  mag-share-button {\n  --font-size-icon: var(--mag-typography-body-medium-font-size, 16px);\n}\n\n.mb-400[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n\n.mb-50[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-50, 4px);\n}\n\n.mb-1000[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-1000, 80px);\n}\n\n.mb-600[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-600, 48px);\n}\n\n.l-btn[_ngcontent-%COMP%] {\n  min-width: 150px;\n  margin-right: 10px;\n}\n\n.recipe-detail[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n}\n.recipe-detail__img[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n.recipe-detail__img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 343px;\n  height: 343px;\n  object-fit: contain;\n}\n.recipe-detail__title[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-headlines-large-font-size, 24px);\n  font-weight: var(--mag-typography-headlines-large-font-weight, 500);\n  line-height: var(--mag-typography-headlines-large-line-height, 32px);\n  \n\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n}\n.recipe-detail__author[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  color: var(--mag-color-text-info, #647281);\n}\n.recipe-detail__author[_ngcontent-%COMP%]   ion-img[_ngcontent-%COMP%] {\n  max-width: 200px;\n  height: 36px;\n  max-height: 36px;\n  margin: 8px 16px;\n}\n.recipe-detail__attributes[_ngcontent-%COMP%] {\n  display: flex;\n  flex-wrap: wrap;\n}\n.recipe-detail__attribute[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  border-radius: var(--mag-border-radius-small, 4px);\n  background: var(--mag-color-surface-info, #e5f5f9);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-caption-font-size, 11px);\n  font-style: normal;\n  font-weight: var(--mag-typography-caption-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-caption-line-height, 14px);\n  \n\n  width: -moz-fit-content;\n  width: fit-content;\n  display: flex;\n  padding: var(--mag-spacing-25, 2px) var(--mag-spacing-50, 4px);\n  align-items: flex-start;\n  gap: 10px;\n  margin: 5px 5px 5px 0;\n}\n.recipe-detail__actions[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 68px;\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  display: flex;\n  align-items: center;\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 20px);\n  \n\n  border-bottom: 1px solid #eeeeee;\n  border-top: 1px solid #eeeeee;\n}\n.recipe-detail__actions[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  --color: var(--mag-color-text-primary, #121212);\n}\n.recipe-detail__actions[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  margin-right: 5px;\n}\n.recipe-detail__add-favorite[_ngcontent-%COMP%], .recipe-detail__print[_ngcontent-%COMP%], .recipe-detail__share[_ngcontent-%COMP%] {\n  width: 50%;\n  height: 100%;\n  display: flex;\n  align-items: center;\n  justify-content: center;\n  gap: 8px;\n}\n.recipe-detail__add-favorite[_ngcontent-%COMP%], .recipe-detail__print[_ngcontent-%COMP%] {\n  border-right: 1px solid #eeeeee;\n}\n.recipe-detail__description-content[_ngcontent-%COMP%] {\n  max-width: 480px;\n}\n.recipe-detail[_ngcontent-%COMP%]   .description-content-item[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: var(--mag-spacing-400, 32px);\n  padding: var(--mag-spacing-200, 16px);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n}\n.recipe-detail[_ngcontent-%COMP%]   .description-content-item__value[_ngcontent-%COMP%] {\n  flex-basis: 50%;\n  font-size: var(--mag-typography-body-medium-font-size);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n}\n.recipe-detail[_ngcontent-%COMP%]   .description-content-item__value--underline[_ngcontent-%COMP%] {\n  text-decoration: underline;\n}\n.recipe-detail[_ngcontent-%COMP%]   .description-content-item__name[_ngcontent-%COMP%] {\n  flex-basis: 50%;\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.recipe-detail[_ngcontent-%COMP%]   .description-content-item[_ngcontent-%COMP%]:nth-child(odd) {\n  background-color: #f7f8f9;\n  \n\n}\n.recipe-detail[_ngcontent-%COMP%]   .description-content-item[_ngcontent-%COMP%]:nth-child(even) {\n  background-color: transparent;\n  \n\n}\n.recipe-detail__des-content[_ngcontent-%COMP%] {\n  position: relative;\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  \n\n  margin-top: var(--mag-spacing-300, 24px);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n}\n.recipe-detail__des-content--blur[_ngcontent-%COMP%]:after {\n  position: absolute;\n  content: \"\";\n  filter: blur(10px);\n  height: 24px;\n  background-color: #ffffff;\n  left: -10px;\n  right: -10px;\n  bottom: 0;\n}\n.recipe-detail__declaimer[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  \n\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-subtext-font-size, 12px);\n  font-style: normal;\n  font-weight: var(--mag-typography-subtext-font-weight-regular, 300);\n  line-height: var(--mag-typography-subtext-line-height, 16px);\n  \n\n}\n.recipe-detail__content[_ngcontent-%COMP%] {\n  overflow: hidden;\n  display: -webkit-box;\n  -webkit-line-clamp: 4;\n  -webkit-box-orient: vertical;\n}\n.recipe-detail__read-more[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-button-text-brand, #008000);\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 20px);\n  \n\n  margin-bottom: var(--mag-spacing-300, 24px);\n}\n.recipe-detail__session-title[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-headlines-medium-font-size, 20px);\n  font-weight: var(--mag-typography-headlines-medium-font-weight, 500);\n  line-height: var(--mag-typography-headlines-medium-line-height, 28px);\n  \n\n  margin: var(--mag-spacing-200, 16px) 0px;\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n}\n.recipe-detail__session-line[_ngcontent-%COMP%] {\n  width: 100%;\n  border-bottom: 1px solid #eeeeee;\n  margin-bottom: var(--mag-spacing-300, 24px);\n}\n.recipe-detail__session-image[_ngcontent-%COMP%] {\n  max-width: 343px;\n}\n.recipe-detail__ingredients[_ngcontent-%COMP%]   ion-item[_ngcontent-%COMP%] {\n  --padding-start: 0px;\n  --padding-end: 0px;\n}\n.recipe-detail__ingredients[_ngcontent-%COMP%]   ion-checkbox[_ngcontent-%COMP%] {\n  --border-width: 1px;\n  --border-radius: var(--mag-border-radius-small, 4px);\n  --border-color: var(--mag-color-border-selector, #767676);\n  --checkbox-background: var(--mag-color-surface-primary, #ffffff);\n  width: var(--mag-typography-line-height-400, 24px) !important;\n  height: var(--mag-typography-line-height-400, 24px) !important;\n  margin-right: var(--mag-spacing-150, 12px);\n  --checkbox-background-checked: var(--mag-color-icon-selector-brand, #c40d3c);\n  --border-color-checked: var(--mag-color-icon-selector-brand, #c40d3c);\n}\n.recipe-detail__ingredients[_ngcontent-%COMP%]   ion-list[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-300, 24px);\n}\n.recipe-detail__ingredients[_ngcontent-%COMP%]   ion-label[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.recipe-detail__ingredients[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: var(--mag-spacing-600, 48px);\n}\n.recipe-detail__ingredients-actions[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n  gap: var(--mag-spacing-button-group-gap, 16px);\n  width: 100%;\n  align-items: center;\n}\n.recipe-detail__ingredients-actions[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  --background: none;\n  --background-activated: none;\n  --color: font-size: var(--mag-typography-button-labels-medium-font-size, 16px);\n  --padding-start: var(--mag-spacing-150, 12px);\n  --padding-end: var(--mag-spacing-150, 12px);\n  --padding-top: var(--mag-spacing-150, 12px);\n  --padding-bottom: var(--mag-spacing-150, 12px);\n  font-weight: var(--mag-typography-button-label-medium-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-medium-line-height, 24px);\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  width: 100%;\n  max-width: 232px;\n  min-width: 136px;\n  text-align: center;\n}\n@media only screen and (min-width: 576px) {\n  .recipe-detail__ingredients-actions[_ngcontent-%COMP%] {\n    justify-content: flex-start;\n  }\n}\n.recipe-detail__unSelect[_ngcontent-%COMP%], .recipe-detail__select[_ngcontent-%COMP%] {\n  border-radius: var(--mag-border-radius-rounded, 9999px);\n  background: var(--mag-color-surface-primary, #ffffff);\n  border: 1px solid var(--mag-color-border-primary, #d8d8d8);\n  color: var(--mag-color-text-primary, #121212);\n  flex: 1;\n}\n.recipe-detail__add-list[_ngcontent-%COMP%] {\n  border-radius: var(--mag-border-radius-rounded, 9999px);\n  background: var(--mag-color-surface-button-filled-brand, #008000);\n  color: var(--mag-color-text-button-filled-brand, #121212);\n}\n.recipe-detail__nutrition-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.recipe-detail__nutrition-text[_ngcontent-%COMP%]   ul.nutritions[_ngcontent-%COMP%]   ul.nutritions[_ngcontent-%COMP%] {\n  padding-left: 0px;\n}\n.recipe-detail__tips[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.recipe-detail__directions-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n\n.sr-only[_ngcontent-%COMP%] {\n  position: absolute;\n  width: 1px;\n  height: 1px;\n  padding: 0;\n  margin: -1px;\n  overflow: hidden;\n  clip: rect(0, 0, 0, 0);\n  white-space: nowrap;\n  border: 0;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3JlY2lwZS9wYWdlcy9yZWNpcGUtZGV0YWlsL3JlY2lwZS1kZXRhaWwuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLG9EQUFBO0VBQ0EsMkNBQUE7RUFDQSw4Q0FBQTtFQUNBLDJDQUFBO0VBQ0EsNkNBQUE7RUFDQSx3REFBQTtBQUNGOztBQUVBO0VBQ0Usd0RBQUE7RUFDQSxnRUFBQTtFQUNBLG1FQUFBO0VBQ0Esb0VBQUE7RUFDQSw2Q0FBQTtBQUNGOztBQUVBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDZDQUFBO0VBQ0EsMkNBQUE7QUFDRjs7QUFFQTtFQUNFLFVBQUE7RUFDQSxtRUFBQTtFQUNBLHNDQUFBO0VBQ0Esb0JBQUE7RUFDQSxxQkFBQTtFQUNBLG9EQUFBO0VBQ0EseUJBQUE7RUFDQSwyQkFBQTtBQUNGOztBQUVBO0VBQ0UsbUVBQUE7QUFDRjs7QUFFQTtFQUNFLDJDQUFBO0FBQ0Y7O0FBRUE7RUFDRSx5Q0FBQTtBQUNGOztBQUVBO0VBQ0UsNENBQUE7QUFDRjs7QUFFQTtFQUNFLDJDQUFBO0FBQ0Y7O0FBRUE7RUFDRSxnQkFBQTtFQUNBLGtCQUFBO0FBQ0Y7O0FBRUE7RUFDRSw2Q0FBQTtBQUNGO0FBQ0U7RUFDRSwyQ0FBQTtBQUNKO0FBQ0k7RUFDRSxZQUFBO0VBQ0EsYUFBQTtFQUNBLG1CQUFBO0FBQ047QUFHRTtFQUNFLGdFQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQTtFQUNBLGFBQUE7RUFDQSx3REFBQTtBQURKO0FBSUU7RUFDRSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSxpRUFBQTtFQUNBLDREQUFBO0VBQ0EsMEVBQUE7RUFDQSxnRUFBQTtFQUNBLDBDQUFBO0FBRko7QUFJSTtFQUNFLGdCQUFBO0VBQ0EsWUFBQTtFQUNBLGdCQUFBO0VBQ0EsZ0JBQUE7QUFGTjtBQU1FO0VBQ0UsYUFBQTtFQUNBLGVBQUE7QUFKSjtBQU9FO0VBQ0UsNkNBQUE7RUFDQSxrREFBQTtFQUNBLGtEQUFBO0VBQ0EsaUVBQUE7RUFDQSx3REFBQTtFQUNBLGtCQUFBO0VBQ0Esc0VBQUE7RUFDQSw0REFBQTtFQUNBLGFBQUE7RUFDQSx1QkFBQTtFQUFBLGtCQUFBO0VBQ0EsYUFBQTtFQUNBLDhEQUFBO0VBQ0EsdUJBQUE7RUFDQSxTQUFBO0VBQ0EscUJBQUE7QUFMSjtBQVFFO0VBQ0UsV0FBQTtFQUNBLFlBQUE7RUFDQSx3REFBQTtFQUNBLGFBQUE7RUFDQSxtQkFBQTtFQUVBLG9FQUFBO0VBQ0EsaUZBQUE7RUFDQSx3RUFBQTtFQUNBLGFBQUE7RUFDQSxnQ0FBQTtFQUNBLDZCQUFBO0FBUEo7QUFTSTtFQUNFLG9FQUFBO0VBQ0EsaUZBQUE7RUFDQSwrQ0FBQTtBQVBOO0FBVUk7RUFDRSxpQkFBQTtBQVJOO0FBWUU7RUFHRSxVQUFBO0VBQ0EsWUFBQTtFQUNBLGFBQUE7RUFDQSxtQkFBQTtFQUNBLHVCQUFBO0VBQ0EsUUFBQTtBQVpKO0FBZUU7RUFFRSwrQkFBQTtBQWRKO0FBaUJFO0VBQ0UsZ0JBQUE7QUFmSjtBQWtCRTtFQUNFLGFBQUE7RUFDQSxtQkFBQTtFQUNBLGlDQUFBO0VBQ0EscUNBQUE7RUFDQSxpRUFBQTtBQWhCSjtBQWtCSTtFQUNFLGVBQUE7RUFDQSxzREFBQTtFQUNBLHVFQUFBO0FBaEJOO0FBa0JNO0VBQ0UsMEJBQUE7QUFoQlI7QUFvQkk7RUFDRSxlQUFBO0VBQ0EsNERBQUE7RUFDQSwwRUFBQTtFQUNBLGdFQUFBO0FBbEJOO0FBc0JFO0VBQ0UseUJBQUE7RUFDQSxpREFBQTtBQXBCSjtBQXVCRTtFQUNFLDZCQUFBO0VBQ0EsdUNBQUE7QUFyQko7QUF3QkU7RUFDRSxrQkFBQTtFQUNBLDREQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtFQUNBLFNBQUE7RUFDQSx3Q0FBQTtFQUNBLGlFQUFBO0FBdEJKO0FBd0JJO0VBQ0Usa0JBQUE7RUFDQSxXQUFBO0VBQ0Esa0JBQUE7RUFDQSxZQUFBO0VBQ0EseUJBQUE7RUFDQSxXQUFBO0VBQ0EsWUFBQTtFQUNBLFNBQUE7QUF0Qk47QUEwQkU7RUFDRSwwQ0FBQTtFQUNBLG9CQUFBO0VBQ0EsaUVBQUE7RUFDQSx3REFBQTtFQUNBLGtCQUFBO0VBQ0EsbUVBQUE7RUFDQSw0REFBQTtFQUNBLGFBQUE7QUF4Qko7QUEyQkU7RUFDRSxnQkFBQTtFQUNBLG9CQUFBO0VBQ0EscUJBQUE7RUFDQSw0QkFBQTtBQXpCSjtBQTRCRTtFQUNFLHVEQUFBO0VBQ0Esb0VBQUE7RUFDQSxpRkFBQTtFQUNBLHdFQUFBO0VBQ0EsYUFBQTtFQUNBLDJDQUFBO0FBMUJKO0FBNkJFO0VBQ0UsaUVBQUE7RUFDQSxvRUFBQTtFQUNBLHFFQUFBO0VBQ0EsU0FBQTtFQUNBLHdDQUFBO0VBQ0Esd0RBQUE7QUEzQko7QUE4QkU7RUFDRSxXQUFBO0VBQ0EsZ0NBQUE7RUFDQSwyQ0FBQTtBQTVCSjtBQStCRTtFQUNFLGdCQUFBO0FBN0JKO0FBaUNJO0VBQ0Usb0JBQUE7RUFDQSxrQkFBQTtBQS9CTjtBQWtDSTtFQUNFLG1CQUFBO0VBQ0Esb0RBQUE7RUFDQSx5REFBQTtFQUNBLGdFQUFBO0VBQ0EsNkRBQUE7RUFDQSw4REFBQTtFQUNBLDBDQUFBO0VBQ0EsNEVBQUE7RUFDQSxxRUFBQTtBQWhDTjtBQW1DSTtFQUNFLDJDQUFBO0FBakNOO0FBb0NJO0VBQ0UsNkNBQUE7RUFDQSwrREFBQTtFQUNBLDREQUFBO0VBQ0Esa0JBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0FBbENOO0FBcUNJO0VBQ0Usb0NBQUE7QUFuQ047QUF1Q0U7RUFDRSxhQUFBO0VBQ0EsOEJBQUE7RUFDQSw4Q0FBQTtFQUNBLFdBQUE7RUFDQSxtQkFBQTtBQXJDSjtBQXVDSTtFQUNFLGtCQUFBO0VBQ0EsNEJBQUE7RUFDQSw4RUFBQTtFQUNBLDZDQUFBO0VBQ0EsMkNBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsdUVBQUE7RUFDQSx5RUFBQTtFQUNBLHdEQUFBO0VBQ0EsV0FBQTtFQUNBLGdCQUFBO0VBQ0EsZ0JBQUE7RUFDQSxrQkFBQTtBQXJDTjtBQTBDRTtFQUNFO0lBQ0UsMkJBQUE7RUF4Q0o7QUFDRjtBQTJDRTtFQUVFLHVEQUFBO0VBQ0EscURBQUE7RUFDQSwwREFBQTtFQUNBLDZDQUFBO0VBQ0EsT0FBQTtBQTFDSjtBQTZDRTtFQUNFLHVEQUFBO0VBQ0EsaUVBQUE7RUFDQSx5REFBQTtBQTNDSjtBQThDRTtFQUNFLDZDQUFBO0VBQ0EsaUVBQUE7RUFDQSw0REFBQTtFQUNBLGtCQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtBQTVDSjtBQStDTTtFQUNFLGlCQUFBO0FBN0NSO0FBa0RFO0VBQ0UsNkNBQUE7RUFDQSxpRUFBQTtFQUNBLDREQUFBO0VBQ0Esa0JBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0FBaERKO0FBbURFO0VBQ0UsNkNBQUE7RUFDQSxpRUFBQTtFQUNBLDREQUFBO0VBQ0Esa0JBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0FBakRKOztBQXFEQTtFQUNFLGtCQUFBO0VBQ0EsVUFBQTtFQUNBLFdBQUE7RUFDQSxVQUFBO0VBQ0EsWUFBQTtFQUNBLGdCQUFBO0VBQ0Esc0JBQUE7RUFDQSxtQkFBQTtFQUNBLFNBQUE7QUFsREYiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tdG9vbGJhciB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1zdGFydDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItZGl2aWRlcik7XG59XG5cbmlvbi10aXRsZSB7XG4gIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXNpemUsIDE4cHgpO1xuICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xufVxuXG5pb24tY29udGVudCB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG4gIC0tcGFkZGluZy1zdGFydDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgLS1wYWRkaW5nLWVuZDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbn1cblxuOjpuZy1kZWVwIG1hZy1yZWNpcGUtZmF2b3JpdGUtYnV0dG9uIHtcbiAgcGFkZGluZzogMDtcbiAgLS1mb250LXNpemUtaWNvbjogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgLS1iYWNrZ3JvdW5kLWNvbG9yLWJ1dHRvbjogdHJhbnNwYXJlbnQ7XG4gIC0td2lkdGgtYnV0dG9uOiAxMDAlO1xuICAtLWhlaWdodC1idXR0b246IDEwMCU7XG4gIC0tY29sb3ItaWNvbjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gIC0tYm9yZGVyLXJhZGl1cy1idXR0b246IDA7XG4gIC0tb3V0LWxpbmUtb2Zmc2V0LWJ1dHRvbjogMDtcbn1cblxuOjpuZy1kZWVwIG1hZy1zaGFyZS1idXR0b24ge1xuICAtLWZvbnQtc2l6ZS1pY29uOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xufVxuXG4ubWItNDAwIHtcbiAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KTtcbn1cblxuLm1iLTUwIHtcbiAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctNTAsIDRweCk7XG59XG5cbi5tYi0xMDAwIHtcbiAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMTAwMCwgODBweCk7XG59XG5cbi5tYi02MDAge1xuICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy02MDAsIDQ4cHgpO1xufVxuXG4ubC1idG4ge1xuICBtaW4td2lkdGg6IDE1MHB4O1xuICBtYXJnaW4tcmlnaHQ6IDEwcHg7XG59XG5cbi5yZWNpcGUtZGV0YWlsIHtcbiAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuXG4gICZfX2ltZyB7XG4gICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KTtcblxuICAgIGltZyB7XG4gICAgICB3aWR0aDogMzQzcHg7XG4gICAgICBoZWlnaHQ6IDM0M3B4O1xuICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICB9XG4gIH1cblxuICAmX190aXRsZSB7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtZm9udC1zaXplLCAyNHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLWxhcmdlLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtbGluZS1oZWlnaHQsIDMycHgpO1xuICAgIC8qIDEzMy4zMzMlICovXG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gIH1cblxuICAmX19hdXRob3Ige1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LWVtcGhhc2l6ZWQsIDQwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtaW5mbywgIzY0NzI4MSk7XG5cbiAgICBpb24taW1nIHtcbiAgICAgIG1heC13aWR0aDogMjAwcHg7XG4gICAgICBoZWlnaHQ6IDM2cHg7XG4gICAgICBtYXgtaGVpZ2h0OiAzNnB4O1xuICAgICAgbWFyZ2luOiA4cHggMTZweDtcbiAgICB9XG4gIH1cblxuICAmX19hdHRyaWJ1dGVzIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZsZXgtd3JhcDogd3JhcDtcbiAgfVxuXG4gICZfX2F0dHJpYnV0ZSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIGJvcmRlci1yYWRpdXM6IHZhcigtLW1hZy1ib3JkZXItcmFkaXVzLXNtYWxsLCA0cHgpO1xuICAgIGJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLWluZm8sICNlNWY1ZjkpO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktY2FwdGlvbi1mb250LXNpemUsIDExcHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktY2FwdGlvbi1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1jYXB0aW9uLWxpbmUtaGVpZ2h0LCAxNHB4KTtcbiAgICAvKiAxMjcuMjczJSAqL1xuICAgIHdpZHRoOiBmaXQtY29udGVudDtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTI1LCAycHgpIHZhcigtLW1hZy1zcGFjaW5nLTUwLCA0cHgpO1xuICAgIGFsaWduLWl0ZW1zOiBmbGV4LXN0YXJ0O1xuICAgIGdhcDogMTBweDtcbiAgICBtYXJnaW46IDVweCA1cHggNXB4IDA7XG4gIH1cblxuICAmX19hY3Rpb25zIHtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBoZWlnaHQ6IDY4cHg7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuXG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWZvbnQtc2l6ZSwgMTRweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbC1zbWFsbC1lbXBoYXNpemVkLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbiAgICAvKiAxNDIuODU3JSAqL1xuICAgIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCAjZWVlZWVlO1xuICAgIGJvcmRlci10b3A6IDFweCBzb2xpZCAjZWVlZWVlO1xuXG4gICAgaW9uLWJ1dHRvbiB7XG4gICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtc21hbGwtZm9udC1zaXplLCAxNHB4KTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWwtc21hbGwtZW1waGFzaXplZC1mb250LXdlaWdodCwgNTAwKTtcbiAgICAgIC0tY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIH1cblxuICAgIGlvbi1pY29uIHtcbiAgICAgIG1hcmdpbi1yaWdodDogNXB4O1xuICAgIH1cbiAgfVxuXG4gICZfX2FkZC1mYXZvcml0ZSxcbiAgJl9fcHJpbnQsXG4gICZfX3NoYXJlIHtcbiAgICB3aWR0aDogNTAlO1xuICAgIGhlaWdodDogMTAwJTtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgZ2FwOiA4cHg7XG4gIH1cblxuICAmX19hZGQtZmF2b3JpdGUsXG4gICZfX3ByaW50IHtcbiAgICBib3JkZXItcmlnaHQ6IDFweCBzb2xpZCAjZWVlZWVlO1xuICB9XG5cbiAgJl9fZGVzY3JpcHRpb24tY29udGVudCB7XG4gICAgbWF4LXdpZHRoOiA0ODBweDtcbiAgfVxuXG4gIC5kZXNjcmlwdGlvbi1jb250ZW50LWl0ZW0ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG4gICAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksICdMZXhlbmQnKTtcblxuICAgICZfX3ZhbHVlIHtcbiAgICAgIGZsZXgtYmFzaXM6IDUwJTtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplKTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuXG4gICAgICAmLS11bmRlcmxpbmUge1xuICAgICAgICB0ZXh0LWRlY29yYXRpb246IHVuZGVybGluZTtcbiAgICAgIH1cbiAgICB9XG5cbiAgICAmX19uYW1lIHtcbiAgICAgIGZsZXgtYmFzaXM6IDUwJTtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICB9XG4gIH1cblxuICAuZGVzY3JpcHRpb24tY29udGVudC1pdGVtOm50aC1jaGlsZChvZGQpIHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjdmOGY5O1xuICAgIC8qIE9kZCByb3dzIHdpdGggdGhlIHNwZWNpZmllZCBsaWdodCBncmF5IGNvbG9yICovXG4gIH1cblxuICAuZGVzY3JpcHRpb24tY29udGVudC1pdGVtOm50aC1jaGlsZChldmVuKSB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG4gICAgLyogRXZlbiByb3dzIHdpdGggbm8gYmFja2dyb3VuZCBjb2xvciAqL1xuICB9XG5cbiAgJl9fZGVzLWNvbnRlbnQge1xuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICAvKiAxNTAlICovXG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksICdMZXhlbmQnKTtcblxuICAgICYtLWJsdXI6YWZ0ZXIge1xuICAgICAgcG9zaXRpb246IGFic29sdXRlO1xuICAgICAgY29udGVudDogJyc7XG4gICAgICBmaWx0ZXI6IGJsdXIoMTBweCk7XG4gICAgICBoZWlnaHQ6IDI0cHg7XG4gICAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZmZmZmZmO1xuICAgICAgbGVmdDogLTEwcHg7XG4gICAgICByaWdodDogLTEwcHg7XG4gICAgICBib3R0b206IDA7XG4gICAgfVxuICB9XG5cbiAgJl9fZGVjbGFpbWVyIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtaW5mbywgIzY0NzI4MSk7XG4gICAgLyogU3VidGV4dC9SZWd1bGFyICovXG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWZvbnQtc2l6ZSwgMTJweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXN1YnRleHQtbGluZS1oZWlnaHQsIDE2cHgpO1xuICAgIC8qIDEzMy4zMzMlICovXG4gIH1cblxuICAmX19jb250ZW50IHtcbiAgICBvdmVyZmxvdzogaGlkZGVuO1xuICAgIGRpc3BsYXk6IC13ZWJraXQtYm94O1xuICAgIC13ZWJraXQtbGluZS1jbGFtcDogNDtcbiAgICAtd2Via2l0LWJveC1vcmllbnQ6IHZlcnRpY2FsO1xuICB9XG5cbiAgJl9fcmVhZC1tb3JlIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtYnV0dG9uLXRleHQtYnJhbmQsICMwMDgwMDApO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYnV0dG9uLWxhYmVscy1zbWFsbC1mb250LXNpemUsIDE0cHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWwtc21hbGwtZW1waGFzaXplZC1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYnV0dG9uLWxhYmVscy1zbWFsbC1saW5lLWhlaWdodCwgMjBweCk7XG4gICAgLyogMTQyLjg1NyUgKi9cbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpO1xuICB9XG5cbiAgJl9fc2Vzc2lvbi10aXRsZSB7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtc2l6ZSwgMjBweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1tZWRpdW0tbGluZS1oZWlnaHQsIDI4cHgpO1xuICAgIC8qIDE0MCUgKi9cbiAgICBtYXJnaW46IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCkgMHB4O1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICB9XG5cbiAgJl9fc2Vzc2lvbi1saW5lIHtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgI2VlZWVlZTtcbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpO1xuICB9XG5cbiAgJl9fc2Vzc2lvbi1pbWFnZSB7XG4gICAgbWF4LXdpZHRoOiAzNDNweDtcbiAgfVxuXG4gICZfX2luZ3JlZGllbnRzIHtcbiAgICBpb24taXRlbSB7XG4gICAgICAtLXBhZGRpbmctc3RhcnQ6IDBweDtcbiAgICAgIC0tcGFkZGluZy1lbmQ6IDBweDtcbiAgICB9XG5cbiAgICBpb24tY2hlY2tib3gge1xuICAgICAgLS1ib3JkZXItd2lkdGg6IDFweDtcbiAgICAgIC0tYm9yZGVyLXJhZGl1czogdmFyKC0tbWFnLWJvcmRlci1yYWRpdXMtc21hbGwsIDRweCk7XG4gICAgICAtLWJvcmRlci1jb2xvcjogdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1zZWxlY3RvciwgIzc2NzY3Nik7XG4gICAgICAtLWNoZWNrYm94LWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmZmZmYpO1xuICAgICAgd2lkdGg6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWxpbmUtaGVpZ2h0LTQwMCwgMjRweCkgIWltcG9ydGFudDtcbiAgICAgIGhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktbGluZS1oZWlnaHQtNDAwLCAyNHB4KSAhaW1wb3J0YW50O1xuICAgICAgbWFyZ2luLXJpZ2h0OiB2YXIoLS1tYWctc3BhY2luZy0xNTAsIDEycHgpO1xuICAgICAgLS1jaGVja2JveC1iYWNrZ3JvdW5kLWNoZWNrZWQ6IHZhcigtLW1hZy1jb2xvci1pY29uLXNlbGVjdG9yLWJyYW5kLCAjYzQwZDNjKTtcbiAgICAgIC0tYm9yZGVyLWNvbG9yLWNoZWNrZWQ6IHZhcigtLW1hZy1jb2xvci1pY29uLXNlbGVjdG9yLWJyYW5kLCAjYzQwZDNjKTtcbiAgICB9XG5cbiAgICBpb24tbGlzdCB7XG4gICAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpO1xuICAgIH1cblxuICAgIGlvbi1sYWJlbCB7XG4gICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksIExleGVuZCk7XG4gICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gICAgfVxuXG4gICAgaW9uLWJ1dHRvbjo6cGFydChuYXRpdmUpIHtcbiAgICAgIGhlaWdodDogdmFyKC0tbWFnLXNwYWNpbmctNjAwLCA0OHB4KTtcbiAgICB9XG4gIH1cblxuICAmX19pbmdyZWRpZW50cy1hY3Rpb25zIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGp1c3RpZnktY29udGVudDogc3BhY2UtYmV0d2VlbjtcbiAgICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLWJ1dHRvbi1ncm91cC1nYXAsIDE2cHgpO1xuICAgIHdpZHRoOiAxMDAlO1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG5cbiAgICBpb24tYnV0dG9uIHtcbiAgICAgIC0tYmFja2dyb3VuZDogbm9uZTtcbiAgICAgIC0tYmFja2dyb3VuZC1hY3RpdmF0ZWQ6IG5vbmU7XG4gICAgICAtLWNvbG9yOiBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTE1MCwgMTJweCk7XG4gICAgICAtLXBhZGRpbmctZW5kOiB2YXIoLS1tYWctc3BhY2luZy0xNTAsIDEycHgpO1xuICAgICAgLS1wYWRkaW5nLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMTUwLCAxMnB4KTtcbiAgICAgIC0tcGFkZGluZy1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTE1MCwgMTJweCk7XG4gICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYnV0dG9uLWxhYmVsLW1lZGl1bS1mb250LXdlaWdodCwgNTAwKTtcbiAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gICAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgbWF4LXdpZHRoOiAyMzJweDtcbiAgICAgIG1pbi13aWR0aDogMTM2cHg7XG4gICAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgfVxuICB9XG5cbiAgLy8gVEFCTEVUICYgREVTS1RPUFxuICBAbWVkaWEgb25seSBzY3JlZW4gYW5kIChtaW4td2lkdGg6IDU3NnB4KSB7XG4gICAgJl9faW5ncmVkaWVudHMtYWN0aW9ucyB7XG4gICAgICBqdXN0aWZ5LWNvbnRlbnQ6IGZsZXgtc3RhcnQ7XG4gICAgfVxuICB9XG5cbiAgJl9fdW5TZWxlY3QsXG4gICZfX3NlbGVjdCB7XG4gICAgYm9yZGVyLXJhZGl1czogdmFyKC0tbWFnLWJvcmRlci1yYWRpdXMtcm91bmRlZCwgOTk5OXB4KTtcbiAgICBiYWNrZ3JvdW5kOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1wcmltYXJ5LCAjZmZmZmZmKTtcbiAgICBib3JkZXI6IDFweCBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLXByaW1hcnksICNkOGQ4ZDgpO1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICBmbGV4OiAxO1xuICB9XG5cbiAgJl9fYWRkLWxpc3Qge1xuICAgIGJvcmRlci1yYWRpdXM6IHZhcigtLW1hZy1ib3JkZXItcmFkaXVzLXJvdW5kZWQsIDk5OTlweCk7XG4gICAgYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtYnV0dG9uLWZpbGxlZC1icmFuZCwgIzAwODAwMCk7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJ1dHRvbi1maWxsZWQtYnJhbmQsICMxMjEyMTIpO1xuICB9XG5cbiAgJl9fbnV0cml0aW9uLXRleHQge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG5cbiAgICB1bC5udXRyaXRpb25zIHtcbiAgICAgIHVsLm51dHJpdGlvbnMge1xuICAgICAgICBwYWRkaW5nLWxlZnQ6IDBweDtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICAmX190aXBzIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG5cbiAgJl9fZGlyZWN0aW9ucy10ZXh0IHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG59XG5cbi5zci1vbmx5IHtcbiAgcG9zaXRpb246IGFic29sdXRlO1xuICB3aWR0aDogMXB4O1xuICBoZWlnaHQ6IDFweDtcbiAgcGFkZGluZzogMDtcbiAgbWFyZ2luOiAtMXB4O1xuICBvdmVyZmxvdzogaGlkZGVuO1xuICBjbGlwOiByZWN0KDAsIDAsIDAsIDApO1xuICB3aGl0ZS1zcGFjZTogbm93cmFwO1xuICBib3JkZXI6IDA7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 56489:
/*!*******************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/recipe/pages/recipe-list-favorite/recipe-list-favorite.ts ***!
  \*******************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecipeListFavoritePageComponent: () => (/* binding */ RecipeListFavoritePageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 51903);
/* harmony import */ var _providers_recipe_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../providers/recipe.service */ 68879);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ngx-translate/core */ 90852);














function RecipeListFavoritePageComponent_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "widget-layout", 8)(2, "mag-favorite-recipes", 9)(3, "widget-layout", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx_r0.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("keyword", ctx_r0.keyword)("queryParams", ctx_r0.queryParamsStr);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function RecipeListFavoritePageComponent_ng_template_9_ion_spinner_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "ion-spinner", 13);
  }
}
function RecipeListFavoritePageComponent_ng_template_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, RecipeListFavoritePageComponent_ng_template_9_ion_spinner_1_Template, 1, 0, "ion-spinner", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    const loading_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵreference"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", loading_r2);
  }
}
class RecipeListFavoritePageComponent {
  route;
  dxpComponentService;
  recipeService;
  router;
  dxpRecipeList = '';
  dxpFavoriteRecipeList = '';
  dxpRecipeSearchBox = '';
  queryParamsStr;
  onScreen = true;
  uns;
  routeName;
  keyword = '';
  eventListenerFn;
  constructor(route, dxpComponentService, recipeService, router) {
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.recipeService = recipeService;
    this.router = router;
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.onScreen = true;
      _this.eventListenerFn = _this.updateQueryParams.bind(_this);
      yield _this.dxpComponentService.onConnected();
      document.body.addEventListener('eventChangedParamsMagFavoriteRecipes', _this.eventListenerFn);
    })();
  }
  updateQueryParams = _e => {
    this.router.navigate([], {
      queryParams: {
        keyword: _e.detail.kw,
        cats: _e.detail.cats,
        readyInIds: _e.detail.readyIns,
        pageIndex: _e.detail.pageIndex
      }
    });
  };
  getParams(key, params) {
    const values = params?.[key] ? typeof params[key] === 'string' ? params[key].split(';') : Array.isArray(params[key]) ? params[key] : [params[key]] : [];
    return values;
  }
  ionViewWillEnter() {
    this.uns = this.route.data.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_6__.concatMap)(() => {
      return this.route.queryParams;
    })).subscribe(params => {
      const cats = this.getParams('cats', params);
      const readyInIds = this.getParams('readyInIds', params);
      const queryParams = {
        categoryCodes: cats.length ? cats : null,
        pageIndex: params?.pageIndex || 1,
        readyInIds: readyInIds.length ? readyInIds : null
      };
      this.queryParamsStr = JSON.stringify(queryParams);
      this.keyword = params?.keyword;
    });
  }
  ionViewDidLeave() {
    this.uns?.unsubscribe();
  }
  ngOnDestroy() {
    this.onScreen = false;
    document.body.removeEventListener('eventChangedParamsMagFavoriteRecipes', this.eventListenerFn);
  }
  static ɵfac = function RecipeListFavoritePageComponent_Factory(t) {
    return new (t || RecipeListFavoritePageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_providers_recipe_service__WEBPACK_IMPORTED_MODULE_2__.RecipeService), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: RecipeListFavoritePageComponent,
    selectors: [["app-recipe-list-favorite"]],
    decls: 11,
    vars: 10,
    consts: [["loading", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "title-header"], ["class", "mag-recipe-saved-list", 4, "ngIf", "ngIfElse"], [1, "mag-recipe-saved-list"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [3, "keyword", "queryParams"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "center-page"], ["aria-label", "Loading", "name", "crescent", "class", "mag-app-button-spinner", 4, "ngIf"], ["aria-label", "Loading", "name", "crescent", 1, "mag-app-button-spinner"]],
    template: function RecipeListFavoritePageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "widget-layout", 1)(1, "widget-layout", 2)(2, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "app-header", 4)(4, "ion-title", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](7, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](8, RecipeListFavoritePageComponent_div_8_Template, 4, 4, "div", 6)(9, RecipeListFavoritePageComponent_ng_template_9_Template, 2, 1, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        const loading_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵreference"](10);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](6, 8, "recipe.myFavoritesTitle"));
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.onScreen)("ngIfElse", loading_r2);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_8__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonSpinner, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_4__.HeaderComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_10__.TranslatePipe],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\nion-toolbar[_ngcontent-%COMP%]   .mag-recipe-search-wrapper[_ngcontent-%COMP%] {\n  margin-right: var(--mag-typography-line-height-200, 16px);\n}\n\nion-title[_ngcontent-%COMP%] {\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3JlY2lwZS9wYWdlcy9yZWNpcGUtbGlzdC1mYXZvcml0ZS9yZWNpcGUtbGlzdC1mYXZvcml0ZS5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLHdEQUFBO0FBQ0Y7QUFBRTtFQUNFLHlEQUFBO0FBRUo7O0FBRUE7RUFDRSx3REFBQTtFQUNBLGdFQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQTtFQUNBLDZDQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tdG9vbGJhciB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1zdGFydDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItZGl2aWRlcik7XG4gIC5tYWctcmVjaXBlLXNlYXJjaC13cmFwcGVyIHtcbiAgICBtYXJnaW4tcmlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWxpbmUtaGVpZ2h0LTIwMCwgMTZweCk7XG4gIH1cbn1cblxuaW9uLXRpdGxlIHtcbiAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDUwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xuICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 5679:
/*!*************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/recipe/pages/recipe-list/recipe-list.ts ***!
  \*************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecipeListPageComponent: () => (/* binding */ RecipeListPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 51903);
/* harmony import */ var _providers_recipe_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../providers/recipe.service */ 68879);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);













function RecipeListPageComponent_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 9)(1, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](2, "widget-layout", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](3, "mag-recipe-summary-list", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](4, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](5, "widget-layout", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx_r0.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("keyword", ctx_r0.keyword)("queryParams", ctx_r0.queryParamsStr);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx_r0.router.url);
  }
}
function RecipeListPageComponent_ng_template_9_ion_spinner_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "ion-spinner", 16);
  }
}
function RecipeListPageComponent_ng_template_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, RecipeListPageComponent_ng_template_9_ion_spinner_1_Template, 1, 0, "ion-spinner", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    const loading_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵreference"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", loading_r2);
  }
}
class RecipeListPageComponent {
  route;
  dxpComponentService;
  recipeService;
  router;
  dxpRecipeList = '';
  dxpFavoriteRecipeList = '';
  queryParamsStr;
  keyword = '';
  onScreen = true;
  onInit = true;
  uns;
  eventListenerFn;
  constructor(route, dxpComponentService, recipeService, router) {
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.recipeService = recipeService;
    this.router = router;
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      document.body.addEventListener('eventChangedParamsMagRecipe', _this.updateQueryParams);
      yield _this.dxpComponentService.onConnected();
      _this.onScreen = true;
    })();
  }
  updateQueryParams = _e => {
    this.router.navigate([], {
      queryParams: {
        keyword: _e.detail.kw,
        cats: _e.detail.cats,
        readyInIds: _e.detail.readyIns,
        pageIndex: _e.detail.pageIndex
      }
    });
  };
  getParams(key, params) {
    const values = params?.[key] ? typeof params[key] === 'string' ? params[key].split(';') : Array.isArray(params[key]) ? params[key] : [params[key]] : [];
    return values;
  }
  ionViewWillEnter() {
    this.uns = this.route.data.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_6__.concatMap)(() => {
      return this.route.queryParams;
    })).subscribe(params => {
      const cats = this.getParams('cats', params);
      const readyInIds = this.getParams('readyInIds', params);
      const queryParams = {
        categoryCodes: cats.length ? cats : null,
        pageIndex: params?.pageIndex || 1,
        readyInIds: readyInIds.length ? readyInIds : null
      };
      if (this.onInit) {
        this.onInit = false;
        this.queryParamsStr = JSON.stringify(queryParams);
      }
      this.keyword = params?.keyword || '';
    });
  }
  ionViewWillLeave() {
    this.onInit = true;
    this.uns?.unsubscribe();
  }
  ngOnDestroy() {
    this.onScreen = false;
    document.body.removeEventListener('eventChangedParamsMagRecipe', this.updateQueryParams);
  }
  static ɵfac = function RecipeListPageComponent_Factory(t) {
    return new (t || RecipeListPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_providers_recipe_service__WEBPACK_IMPORTED_MODULE_2__.RecipeService), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: RecipeListPageComponent,
    selectors: [["app-recipe-list"]],
    decls: 11,
    vars: 8,
    consts: [["loading", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton"], [1, "header-simple__container"], [1, "mag-recipe-search-wrapper"], ["is-show-back-button", "true", 3, "keyword"], ["class", "mag-recipe-search-list", 4, "ngIf", "ngIfElse"], [1, "mag-recipe-search-list"], [1, "widget-layout"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["view-mode", "mobile", 3, "keyword", "queryParams"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "center-page"], ["aria-label", "Loading", "name", "crescent", "class", "mag-app-button-spinner", 4, "ngIf"], ["aria-label", "Loading", "name", "crescent", 1, "mag-app-button-spinner"]],
    template: function RecipeListPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "widget-layout", 1)(1, "widget-layout", 2)(2, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "app-header", 4)(4, "div", 5)(5, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](6, "mag-recipe-search-box", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](7, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](8, RecipeListPageComponent_div_8_Template, 6, 4, "div", 8)(9, RecipeListPageComponent_ng_template_9_Template, 2, 1, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        const loading_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵreference"](10);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", false);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("keyword", ctx.keyword);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.onScreen)("ngIfElse", loading_r2);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_8__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonSpinner, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_4__.HeaderComponent],
    styles: ["ion-toolbar[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-200, 16px);\n  --padding-bottom: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  border-bottom: 1px solid var(--mag-color-border-divider);\n}\nion-toolbar[_ngcontent-%COMP%]   .mag-recipe-search-wrapper[_ngcontent-%COMP%] {\n  margin-right: var(--mag-typography-line-height-200, 16px);\n}\n\nion-title[_ngcontent-%COMP%] {\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n}\n\n.center-page[_ngcontent-%COMP%] {\n  height: 100%;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n\n.widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3JlY2lwZS9wYWdlcy9yZWNpcGUtbGlzdC9yZWNpcGUtbGlzdC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0Usb0RBQUE7RUFDQSwyQ0FBQTtFQUNBLDhDQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLHdEQUFBO0FBQ0Y7QUFDRTtFQUNFLHlEQUFBO0FBQ0o7O0FBR0E7RUFDRSx3REFBQTtFQUNBLGdFQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQTtFQUNBLDZDQUFBO0FBQUY7O0FBR0E7RUFDRSxZQUFBO0VBQ0EsYUFBQTtFQUNBLHVCQUFBO0VBQ0EsbUJBQUE7QUFBRjs7QUFHQTtFQUNFLHVDQUFBO0FBQUYiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tdG9vbGJhciB7XG4gIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtcHJpbWFyeSwgI2ZmZik7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1zdGFydDogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItZGl2aWRlcik7XG5cbiAgLm1hZy1yZWNpcGUtc2VhcmNoLXdyYXBwZXIge1xuICAgIG1hcmdpbi1yaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktbGluZS1oZWlnaHQtMjAwLCAxNnB4KTtcbiAgfVxufVxuXG5pb24tdGl0bGUge1xuICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZm9udC1mYW1pbHksICdMZXhlbmQnKTtcbiAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNTAwKTtcbiAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbn1cblxuLmNlbnRlci1wYWdlIHtcbiAgaGVpZ2h0OiAxMDAlO1xuICBkaXNwbGF5OiBmbGV4O1xuICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbn1cblxuLndpZGdldC1sYXlvdXQge1xuICBwYWRkaW5nOiAwIHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 83186:
/*!*****************************************************************!*\
  !*** ./src/app/modules/ecom-v2/recipe/recipe-routing.module.ts ***!
  \*****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecipeRoutingModule: () => (/* binding */ RecipeRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _recipe_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./recipe.module */ 49659);
/* harmony import */ var _pages_recipe_list_recipe_list__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/recipe-list/recipe-list */ 5679);
/* harmony import */ var _pages_recipe_detail_recipe_detail__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/recipe-detail/recipe-detail */ 24571);
/* harmony import */ var _pages_recipe_list_favorite_recipe_list_favorite__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/recipe-list-favorite/recipe-list-favorite */ 56489);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);







const baseRoute = [{
  path: '',
  redirectTo: 'browse',
  pathMatch: 'full'
}, {
  path: 'recipe-detail/:slug',
  component: _pages_recipe_detail_recipe_detail__WEBPACK_IMPORTED_MODULE_2__.RecipeDetailPageComponent
}, {
  path: 'browse',
  component: _pages_recipe_list_recipe_list__WEBPACK_IMPORTED_MODULE_1__.RecipeListPageComponent,
  data: {
    routeName: 'browse'
  }
}, {
  path: 'favorites',
  component: _pages_recipe_list_favorite_recipe_list_favorite__WEBPACK_IMPORTED_MODULE_3__.RecipeListFavoritePageComponent,
  data: {
    routeName: 'favorites'
  }
}];
const routes = baseRoute.map(route => ({
  ...route,
  data: {
    ...route.data,
    hideTab: true
  }
}));
class RecipeRoutingModule {
  static ɵfac = function RecipeRoutingModule_Factory(t) {
    return new (t || RecipeRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: RecipeRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule.forChild(routes), _recipe_module__WEBPACK_IMPORTED_MODULE_0__.RecipeModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](RecipeRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule, _recipe_module__WEBPACK_IMPORTED_MODULE_0__.RecipeModule]
  });
})();

/***/ }),

/***/ 51638:
/*!******************************************************************!*\
  !*** ./src/app/modules/ecom-v2/recipe/recipe-services.module.ts ***!
  \******************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecipeServiceModule: () => (/* binding */ RecipeServiceModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../utils/ecom-api-configs */ 847);
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/gateway/mag-ecom-core-api.service */ 31627);
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common/http */ 46443);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _environments_environment_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../../environments/environment.service */ 25957);
/* harmony import */ var _providers_recipe_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./providers/recipe.service */ 68879);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);



// import { ProductService } from './providers/product.service';








class RecipeServiceModule {
  static ɵfac = function RecipeServiceModule_Factory(t) {
    return new (t || RecipeServiceModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineNgModule"]({
    type: RecipeServiceModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineInjector"]({
    providers: [{
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_RECIPE_V2_API,
      useValue: _app_env__WEBPACK_IMPORTED_MODULE_2__.ENV.EComRecipeAPIV2URL
    }, {
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_RECIPE_V2_HTTP_CLIENT,
      useFactory: _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_3__.MagEComCoreApiHttpClientFactory,
      deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_8__.HttpHandler, _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_4__.Credential, _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_RECIPE_V2_API, _environments_environment_service__WEBPACK_IMPORTED_MODULE_5__.EnvironmentService]
    }, _providers_recipe_service__WEBPACK_IMPORTED_MODULE_6__.RecipeService],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsetNgModuleScope"](RecipeServiceModule, {
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule]
  });
})();

/***/ }),

/***/ 49659:
/*!*********************************************************!*\
  !*** ./src/app/modules/ecom-v2/recipe/recipe.module.ts ***!
  \*********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   RecipeModule: () => (/* binding */ RecipeModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/shared/shared.module */ 70541);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _pages_recipe_list_recipe_list__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/recipe-list/recipe-list */ 5679);
/* harmony import */ var _pages_recipe_detail_recipe_detail__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/recipe-detail/recipe-detail */ 24571);
/* harmony import */ var _recipe_services_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./recipe-services.module */ 51638);
/* harmony import */ var _pages_recipe_list_favorite_recipe_list_favorite__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./pages/recipe-list-favorite/recipe-list-favorite */ 56489);
/* harmony import */ var _rsApp_components_shared_component_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @rsApp/components/shared.component.module */ 67249);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/core */ 37580);















class RecipeModule {
  static ɵfac = function RecipeModule_Factory(t) {
    return new (t || RecipeModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdefineNgModule"]({
    type: RecipeModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_12__.MomentModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__.HeaderComponentModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__.TranslateModule, _recipe_services_module__WEBPACK_IMPORTED_MODULE_5__.RecipeServiceModule, _rsApp_components_shared_component_module__WEBPACK_IMPORTED_MODULE_7__.SharedComponentModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.ReactiveFormsModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵsetNgModuleScope"](RecipeModule, {
    declarations: [_pages_recipe_list_recipe_list__WEBPACK_IMPORTED_MODULE_3__.RecipeListPageComponent, _pages_recipe_detail_recipe_detail__WEBPACK_IMPORTED_MODULE_4__.RecipeDetailPageComponent, _pages_recipe_list_favorite_recipe_list_favorite__WEBPACK_IMPORTED_MODULE_6__.RecipeListFavoritePageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_12__.MomentModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__.HeaderComponentModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__.TranslateModule, _recipe_services_module__WEBPACK_IMPORTED_MODULE_5__.RecipeServiceModule, _rsApp_components_shared_component_module__WEBPACK_IMPORTED_MODULE_7__.SharedComponentModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.ReactiveFormsModule],
    exports: [_pages_recipe_list_recipe_list__WEBPACK_IMPORTED_MODULE_3__.RecipeListPageComponent, _pages_recipe_detail_recipe_detail__WEBPACK_IMPORTED_MODULE_4__.RecipeDetailPageComponent, _pages_recipe_list_favorite_recipe_list_favorite__WEBPACK_IMPORTED_MODULE_6__.RecipeListFavoritePageComponent]
  });
})();

/***/ }),

/***/ 55104:
/*!***************************************************************!*\
  !*** ./node_modules/@capacitor/share/dist/esm/definitions.js ***!
  \***************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);


/***/ }),

/***/ 74334:
/*!*********************************************************!*\
  !*** ./node_modules/@capacitor/share/dist/esm/index.js ***!
  \*********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   Share: () => (/* binding */ Share)
/* harmony export */ });
/* harmony import */ var _capacitor_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @capacitor/core */ 14070);
/* harmony import */ var _definitions__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./definitions */ 55104);

const Share = (0,_capacitor_core__WEBPACK_IMPORTED_MODULE_0__.registerPlugin)('Share', {
  web: () => __webpack_require__.e(/*! import() */ "node_modules_capacitor_share_dist_esm_web_js").then(__webpack_require__.bind(__webpack_require__, /*! ./web */ 15612)).then(m => new m.ShareWeb())
});



/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_recipe_recipe-routing_module_ts.js.map