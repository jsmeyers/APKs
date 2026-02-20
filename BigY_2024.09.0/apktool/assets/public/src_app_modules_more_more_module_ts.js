"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_more_more_module_ts"],{

/***/ 92309:
/*!*********************************************!*\
  !*** ./src/app/modules/more/more.module.ts ***!
  \*********************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MoreModule: () => (/* binding */ MoreModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/utils.module */ 50777);
/* harmony import */ var _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../account-v2/providers/user.service */ 51074);
/* harmony import */ var _pages_about_about__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/about/about */ 13828);
/* harmony import */ var _pages_coffee_club_coffee_club__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/coffee-club/coffee-club */ 25852);
/* harmony import */ var _pages_contact_contact__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./pages/contact/contact */ 16444);
/* harmony import */ var _pages_guest_survey_guest_survey__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./pages/guest-survey/guest-survey */ 91884);
/* harmony import */ var _pages_legal_legal__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./pages/legal/legal */ 70352);
/* harmony import */ var _pages_log_log_page__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pages/log/log.page */ 61923);
/* harmony import */ var _pages_message_center_message_center__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./pages/message-center/message-center */ 45836);
/* harmony import */ var _pages_more_more__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./pages/more/more */ 27304);
/* harmony import */ var _providers_dynamic_menu_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./providers/dynamic-menu.service */ 39683);
/* harmony import */ var _header_header_component_module__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../header/header.component.module */ 88770);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/core */ 37580);



















const routes = [{
  path: '',
  component: _pages_more_more__WEBPACK_IMPORTED_MODULE_9__.MorePageComponent
}, {
  path: 'store',
  loadChildren: () => Promise.resolve(/*! import() */).then(__webpack_require__.bind(__webpack_require__, /*! ../store/store.module */ 74233)).then(m => m.StoreModule)
}, {
  path: 'guest-survey',
  component: _pages_guest_survey_guest_survey__WEBPACK_IMPORTED_MODULE_5__.GuestSurveyPageComponent
}, {
  path: 'about',
  component: _pages_about_about__WEBPACK_IMPORTED_MODULE_2__.AboutPageComponent,
  data: {
    hideTab: true
  }
}, {
  path: 'contact',
  component: _pages_contact_contact__WEBPACK_IMPORTED_MODULE_4__.ContactPageComponent
}, {
  path: 'legal',
  component: _pages_legal_legal__WEBPACK_IMPORTED_MODULE_6__.LegalPageComponent
}, {
  path: 'log',
  component: _pages_log_log_page__WEBPACK_IMPORTED_MODULE_7__.LogPageComponent
}, {
  path: 'coffee-club',
  component: _pages_coffee_club_coffee_club__WEBPACK_IMPORTED_MODULE_3__.CoffeeClubPageComponent
}, {
  path: 'message-center',
  component: _pages_message_center_message_center__WEBPACK_IMPORTED_MODULE_8__.MessageCenterPageComponent
}];
class MoreModule {
  static ɵfac = function MoreModule_Factory(t) {
    return new (t || MoreModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_12__["ɵɵdefineNgModule"]({
    type: MoreModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_12__["ɵɵdefineInjector"]({
    providers: [_providers_dynamic_menu_service__WEBPACK_IMPORTED_MODULE_10__.DynamicMenu],
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule.forChild(routes), _angular_common__WEBPACK_IMPORTED_MODULE_14__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_15__.FormsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_16__.TranslateModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_17__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_1__.UserServiceModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_11__.HeaderComponentModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_12__["ɵɵsetNgModuleScope"](MoreModule, {
    declarations: [_pages_more_more__WEBPACK_IMPORTED_MODULE_9__.MorePageComponent, _pages_guest_survey_guest_survey__WEBPACK_IMPORTED_MODULE_5__.GuestSurveyPageComponent, _pages_about_about__WEBPACK_IMPORTED_MODULE_2__.AboutPageComponent, _pages_contact_contact__WEBPACK_IMPORTED_MODULE_4__.ContactPageComponent, _pages_legal_legal__WEBPACK_IMPORTED_MODULE_6__.LegalPageComponent, _pages_log_log_page__WEBPACK_IMPORTED_MODULE_7__.LogPageComponent, _pages_coffee_club_coffee_club__WEBPACK_IMPORTED_MODULE_3__.CoffeeClubPageComponent, _pages_message_center_message_center__WEBPACK_IMPORTED_MODULE_8__.MessageCenterPageComponent],
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _angular_common__WEBPACK_IMPORTED_MODULE_14__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_15__.FormsModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_16__.TranslateModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_17__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_1__.UserServiceModule, _header_header_component_module__WEBPACK_IMPORTED_MODULE_11__.HeaderComponentModule]
  });
})();

/***/ }),

/***/ 13828:
/*!***************************************************!*\
  !*** ./src/app/modules/more/pages/about/about.ts ***!
  \***************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   AboutPageComponent: () => (/* binding */ AboutPageComponent)
/* harmony export */ });
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../header/header.component */ 55074);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ngx-translate/core */ 90852);










class AboutPageComponent {
  router;
  route;
  utils;
  info = {
    version: _app_env__WEBPACK_IMPORTED_MODULE_0__.ENV.AppVersion,
    buildNumber: _app_env__WEBPACK_IMPORTED_MODULE_0__.ENV.BuildNumber
  };
  constructor(router, route, utils) {
    this.router = router;
    this.route = route;
    this.utils = utils;
  }
  getPageName() {
    return 'AboutPage';
  }
  goAppSettings() {
    this.utils.openAppSettings();
  }
  goTutorial() {
    this.router.navigate(['/tutorial']);
  }
  static ɵfac = function AboutPageComponent_Factory(t) {
    return new (t || AboutPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.Utils));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
    type: AboutPageComponent,
    selectors: [["page-about"]],
    decls: 21,
    vars: 22,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [3, "isSimpleHeader", "isShowBackButton", "isHideCartListIcons"], [1, "title-header"], ["scroll-y", "false"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "about-page__container"], [3, "click"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "about-page__version-info"]],
    template: function AboutPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "app-header", 3)(4, "ion-title", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "ion-content", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](8, "widget-layout", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "div", 7)(10, "button", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function AboutPageComponent_Template_button_click_10_listener() {
          return ctx.goTutorial();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipe"](12, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](13, "button", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function AboutPageComponent_Template_button_click_13_listener() {
          return ctx.goAppSettings();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](14);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipe"](15, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](16, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](17, "ion-footer")(18, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipe"](20, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true)("isHideCartListIcons", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipeBind1"](6, 14, "aboutPage.title"));
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipeBind1"](12, 16, "aboutPage.whatNew"));
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipeBind1"](15, 18, "aboutPage.appSetting"));
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate3"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipeBind1"](20, 20, "aboutPage.appVersion"), " ", ctx.info.version, " (", ctx.info.buildNumber, ") ");
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonFooter, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonTitle, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_3__.HeaderComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__.TranslatePipe],
    styles: ["ion-content[_ngcontent-%COMP%] {\n  --padding-start: var(--mag-spacing-250, 20px);\n  --padding-end: var(--mag-spacing-250, 20px);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-bottom: var(--mag-spacing-250, 20px);\n}\n\nion-title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px);\n}\n\n.about-page__container[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  align-items: flex-start;\n  row-gap: var(--mag-spacing-300, 24px);\n}\n.about-page__container[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  background-color: transparent;\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n\nion-footer[_ngcontent-%COMP%] {\n  padding-bottom: var(--mag-spacing-250, 20px);\n}\n\n.about-page__version-info[_ngcontent-%COMP%] {\n  width: 100%;\n  text-align: center;\n  color: var(--mag-color-text-info, #647281);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-subtext-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-subtext-font-weight-regular, 300);\n  line-height: var(--mag-typography-subtext-line-height, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL2Fib3V0L2Fib3V0LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw2Q0FBQTtFQUNBLDJDQUFBO0VBQ0EsMkNBQUE7RUFDQSw4Q0FBQTtBQUNGOztBQUVBO0VBQ0UsNkNBQUE7RUFDQSx3REFBQTtFQUNBLGdFQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQTtBQUNGOztBQUVBO0VBQ0UsYUFBQTtFQUNBLHNCQUFBO0VBQ0EsdUJBQUE7RUFDQSxxQ0FBQTtBQUNGO0FBQUU7RUFDRSw2Q0FBQTtFQUNBLDZCQUFBO0VBQ0EsaUVBQUE7RUFDQSw0REFBQTtFQUNBLGtCQUFBO0VBQ0EsZ0VBQUE7RUFDQSxnRUFBQTtBQUVKOztBQUVBO0VBQ0UsNENBQUE7QUFDRjs7QUFFQTtFQUNFLFdBQUE7RUFDQSxrQkFBQTtFQUNBLDBDQUFBO0VBQ0EsaUVBQUE7RUFDQSx3REFBQTtFQUNBLGtCQUFBO0VBQ0EsbUVBQUE7RUFDQSw0REFBQTtBQUNGIiwic291cmNlc0NvbnRlbnQiOlsiaW9uLWNvbnRlbnQge1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTI1MCwgMjBweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTI1MCwgMjBweCk7XG4gIC0tcGFkZGluZy10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG4gIC0tcGFkZGluZy1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTI1MCwgMjBweCk7XG59XG5cbmlvbi10aXRsZSB7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDUwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xufVxuXG4uYWJvdXQtcGFnZV9fY29udGFpbmVyIHtcbiAgZGlzcGxheTogZmxleDtcbiAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgYWxpZ24taXRlbXM6IGZsZXgtc3RhcnQ7XG4gIHJvdy1nYXA6IHZhcigtLW1hZy1zcGFjaW5nLTMwMCwgMjRweCk7XG4gIGJ1dHRvbiB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50O1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG59XG5cbmlvbi1mb290ZXIge1xuICBwYWRkaW5nLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMjUwLCAyMHB4KTtcbn1cblxuLmFib3V0LXBhZ2VfX3ZlcnNpb24taW5mbyB7XG4gIHdpZHRoOiAxMDAlO1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1pbmZvLCAjNjQ3MjgxKTtcbiAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXNpemUsIDE2cHgpO1xuICBmb250LXN0eWxlOiBub3JtYWw7XG4gIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWxpbmUtaGVpZ2h0LCAxNnB4KTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 25852:
/*!***************************************************************!*\
  !*** ./src/app/modules/more/pages/coffee-club/coffee-club.ts ***!
  \***************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CoffeeClubPageComponent: () => (/* binding */ CoffeeClubPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../utils/pipes/safe-html/safe-html */ 93943);










class CoffeeClubPageComponent {
  utils;
  cre;
  router;
  coffeeClubComponent = '';
  constructor(utils, cre, router) {
    this.utils = utils;
    this.cre = cre;
    this.router = router;
  }
  ionViewWillEnter() {
    this.loadData();
  }
  loadData() {
    this.coffeeClubComponent = `<united-coffee-club></united-coffee-club>`;
  }
  getPageName() {
    return 'CoffeeClubPage';
  }
  static ɵfac = function CoffeeClubPageComponent_Factory(t) {
    return new (t || CoffeeClubPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_1__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
    type: CoffeeClubPageComponent,
    selectors: [["coffee-club-page"]],
    decls: 14,
    vars: 8,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", 1, "dark"], ["text-center", ""], ["padding", "", 1, "custom-content"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [3, "innerHTML"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function CoffeeClubPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar")(5, "ion-buttons", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](6, "ion-back-button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "ion-title", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](8, "United Express Coffee Club");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "ion-content", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](10, "widget-layout", 7)(11, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipe"](12, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](13, "widget-layout", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpipeBind1"](12, 6, ctx.coffeeClubComponent), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_2__.WidgetLayoutComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_3__.SafeHtmlPipe],
    styles: ["coffee-club-page ion-title {\n  padding: 0;\n}\ncoffee-club-page ion-content {\n  --background: #5a4a42;\n}\ncoffee-club-page ion-content ion-grid {\n  padding: 0;\n}\ncoffee-club-page ion-content ion-grid .text-header ion-label {\n  margin: 0px;\n  color: var(--white);\n  font-size: 30px;\n  font-weight: bold;\n}\ncoffee-club-page ion-content ion-grid .text-header {\n  padding-top: 15px;\n}\ncoffee-club-page ion-content ion-grid .custom-hr {\n  width: 90%;\n  height: 1px;\n  background-color: var(--white) !important;\n}\ncoffee-club-page ion-content ion-grid .circle-earn-free-coffee {\n  padding-top: 40px;\n}\ncoffee-club-page ion-content ion-grid .circle-earn-free-coffee .circle-background {\n  height: 180px;\n  width: 180px;\n  background-color: var(--primary);\n  border-radius: 50%;\n  display: inline-block;\n}\ncoffee-club-page ion-content ion-grid .circle-earn-free-coffee .text:first-child {\n  padding-top: 35px;\n}\ncoffee-club-page ion-content ion-grid .circle-earn-free-coffee .text {\n  display: block;\n  line-height: 24px;\n  font-size: 32px;\n  padding-top: 0;\n  font-weight: bold;\n  color: var(--white);\n  margin: 0px;\n  white-space: normal;\n}\ncoffee-club-page ion-content ion-grid .circle-earn-free-coffee .points {\n  display: block;\n  margin: 0px;\n  color: var(--white);\n  font-size: 60px;\n  font-weight: bold;\n  white-space: normal;\n  line-height: 60px;\n}\ncoffee-club-page ion-content ion-grid .circle-points-coffee .circle-background {\n  height: 180px;\n  width: 180px;\n  background-color: var(--primary);\n  border-radius: 50%;\n  display: inline-block;\n}\ncoffee-club-page ion-content ion-grid .circle-points-coffee .text:first-child {\n  padding-top: 35px;\n}\ncoffee-club-page ion-content ion-grid .circle-points-coffee .text {\n  display: block;\n  line-height: 24px;\n  font-size: 24px;\n  padding-top: 0;\n  font-weight: bold;\n  color: var(--white);\n  margin: 0px;\n  white-space: normal;\n}\ncoffee-club-page ion-content ion-grid .circle-points-coffee .points {\n  display: block;\n  margin: 0px;\n  color: var(--white);\n  line-height: 90px;\n  padding-top: 15%;\n  font-size: 120px;\n  padding-bottom: 3%;\n  white-space: normal;\n}\ncoffee-club-page ion-content ion-grid .circle-congratulations .circle-background {\n  height: 180px;\n  width: 180px;\n  background-color: var(--primary);\n  border-radius: 50%;\n  display: inline-block;\n}\ncoffee-club-page ion-content ion-grid .circle-congratulations .img {\n  width: 64px;\n  contain: unset;\n  padding-top: 20px;\n}\ncoffee-club-page ion-content ion-grid .text-content-earn-free-coffee {\n  font-size: 20px;\n  color: var(--white);\n  line-height: 30px;\n}\ncoffee-club-page ion-content ion-grid .text-content-points-coffee {\n  font-size: 32px;\n  font-weight: bold;\n}\ncoffee-club-page ion-content ion-grid .text-content-points-coffee .white {\n  color: var(--white);\n}\ncoffee-club-page ion-content ion-grid .text-content-points-coffee .primary {\n  color: var(--primary);\n}\ncoffee-club-page ion-content ion-grid .text-child-content-points-coffee {\n  line-height: 24px;\n  color: var(--white);\n}\ncoffee-club-page ion-content ion-grid .text-content-congratulations {\n  font-size: 32px;\n  font-weight: bold;\n}\ncoffee-club-page ion-content ion-grid .text-child-content-congratulations {\n  line-height: 24px;\n  color: var(--white);\n}\ncoffee-club-page ion-content ion-grid .img-unitedExp {\n  width: 170px;\n  contain: unset;\n  margin: auto;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL2NvZmZlZS1jbHViL2NvZmZlZS1jbHViLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQ0U7RUFDRSxVQUFBO0FBQUo7QUFHRTtFQUNFLHFCQUFBO0FBREo7QUFHSTtFQUNFLFVBQUE7QUFETjtBQUlRO0VBQ0UsV0FBQTtFQUNBLG1CQUFBO0VBQ0EsZUFBQTtFQUNBLGlCQUFBO0FBRlY7QUFNTTtFQUNFLGlCQUFBO0FBSlI7QUFPTTtFQUNFLFVBQUE7RUFDQSxXQUFBO0VBQ0EseUNBQUE7QUFMUjtBQVFNO0VBQ0UsaUJBQUE7QUFOUjtBQVFRO0VBQ0UsYUFBQTtFQUNBLFlBQUE7RUFDQSxnQ0FBQTtFQUNBLGtCQUFBO0VBQ0EscUJBQUE7QUFOVjtBQVNRO0VBQ0UsaUJBQUE7QUFQVjtBQVVRO0VBQ0UsY0FBQTtFQUNBLGlCQUFBO0VBQ0EsZUFBQTtFQUNBLGNBQUE7RUFDQSxpQkFBQTtFQUNBLG1CQUFBO0VBQ0EsV0FBQTtFQUNBLG1CQUFBO0FBUlY7QUFXUTtFQUNFLGNBQUE7RUFDQSxXQUFBO0VBQ0EsbUJBQUE7RUFDQSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxtQkFBQTtFQUNBLGlCQUFBO0FBVFY7QUFjUTtFQUNFLGFBQUE7RUFDQSxZQUFBO0VBQ0EsZ0NBQUE7RUFDQSxrQkFBQTtFQUNBLHFCQUFBO0FBWlY7QUFlUTtFQUNFLGlCQUFBO0FBYlY7QUFnQlE7RUFDRSxjQUFBO0VBQ0EsaUJBQUE7RUFDQSxlQUFBO0VBQ0EsY0FBQTtFQUNBLGlCQUFBO0VBQ0EsbUJBQUE7RUFDQSxXQUFBO0VBQ0EsbUJBQUE7QUFkVjtBQWlCUTtFQUNFLGNBQUE7RUFDQSxXQUFBO0VBQ0EsbUJBQUE7RUFDQSxpQkFBQTtFQUNBLGdCQUFBO0VBQ0EsZ0JBQUE7RUFDQSxrQkFBQTtFQUNBLG1CQUFBO0FBZlY7QUFvQlE7RUFDRSxhQUFBO0VBQ0EsWUFBQTtFQUNBLGdDQUFBO0VBQ0Esa0JBQUE7RUFDQSxxQkFBQTtBQWxCVjtBQXFCUTtFQUNFLFdBQUE7RUFDQSxjQUFBO0VBQ0EsaUJBQUE7QUFuQlY7QUF1Qk07RUFDRSxlQUFBO0VBQ0EsbUJBQUE7RUFDQSxpQkFBQTtBQXJCUjtBQXdCTTtFQVNFLGVBQUE7RUFDQSxpQkFBQTtBQTlCUjtBQXFCUTtFQUNFLG1CQUFBO0FBbkJWO0FBc0JRO0VBQ0UscUJBQUE7QUFwQlY7QUEyQk07RUFDRSxpQkFBQTtFQUNBLG1CQUFBO0FBekJSO0FBNEJNO0VBQ0UsZUFBQTtFQUNBLGlCQUFBO0FBMUJSO0FBNkJNO0VBQ0UsaUJBQUE7RUFDQSxtQkFBQTtBQTNCUjtBQThCTTtFQUNFLFlBQUE7RUFDQSxjQUFBO0VBQ0EsWUFBQTtBQTVCUiIsInNvdXJjZXNDb250ZW50IjpbImNvZmZlZS1jbHViLXBhZ2Uge1xuICBpb24tdGl0bGUge1xuICAgIHBhZGRpbmc6IDA7XG4gIH1cblxuICBpb24tY29udGVudCB7XG4gICAgLS1iYWNrZ3JvdW5kOiAjNWE0YTQyO1xuXG4gICAgaW9uLWdyaWQge1xuICAgICAgcGFkZGluZzogMDtcblxuICAgICAgLnRleHQtaGVhZGVyIHtcbiAgICAgICAgaW9uLWxhYmVsIHtcbiAgICAgICAgICBtYXJnaW46IDBweDtcbiAgICAgICAgICBjb2xvcjogdmFyKC0td2hpdGUpO1xuICAgICAgICAgIGZvbnQtc2l6ZTogMzBweDtcbiAgICAgICAgICBmb250LXdlaWdodDogYm9sZDtcbiAgICAgICAgfVxuICAgICAgfVxuXG4gICAgICAudGV4dC1oZWFkZXIge1xuICAgICAgICBwYWRkaW5nLXRvcDogMTVweDtcbiAgICAgIH1cblxuICAgICAgLmN1c3RvbS1ociB7XG4gICAgICAgIHdpZHRoOiA5MCU7XG4gICAgICAgIGhlaWdodDogMXB4O1xuICAgICAgICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS13aGl0ZSkgIWltcG9ydGFudDtcbiAgICAgIH1cblxuICAgICAgLmNpcmNsZS1lYXJuLWZyZWUtY29mZmVlIHtcbiAgICAgICAgcGFkZGluZy10b3A6IDQwcHg7XG5cbiAgICAgICAgLmNpcmNsZS1iYWNrZ3JvdW5kIHtcbiAgICAgICAgICBoZWlnaHQ6IDE4MHB4O1xuICAgICAgICAgIHdpZHRoOiAxODBweDtcbiAgICAgICAgICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1wcmltYXJ5KTtcbiAgICAgICAgICBib3JkZXItcmFkaXVzOiA1MCU7XG4gICAgICAgICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xuICAgICAgICB9XG5cbiAgICAgICAgLnRleHQ6Zmlyc3QtY2hpbGQge1xuICAgICAgICAgIHBhZGRpbmctdG9wOiAzNXB4O1xuICAgICAgICB9XG5cbiAgICAgICAgLnRleHQge1xuICAgICAgICAgIGRpc3BsYXk6IGJsb2NrO1xuICAgICAgICAgIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICAgICAgICAgIGZvbnQtc2l6ZTogMzJweDtcbiAgICAgICAgICBwYWRkaW5nLXRvcDogMDtcbiAgICAgICAgICBmb250LXdlaWdodDogYm9sZDtcbiAgICAgICAgICBjb2xvcjogdmFyKC0td2hpdGUpO1xuICAgICAgICAgIG1hcmdpbjogMHB4O1xuICAgICAgICAgIHdoaXRlLXNwYWNlOiBub3JtYWw7XG4gICAgICAgIH1cblxuICAgICAgICAucG9pbnRzIHtcbiAgICAgICAgICBkaXNwbGF5OiBibG9jaztcbiAgICAgICAgICBtYXJnaW46IDBweDtcbiAgICAgICAgICBjb2xvcjogdmFyKC0td2hpdGUpO1xuICAgICAgICAgIGZvbnQtc2l6ZTogNjBweDtcbiAgICAgICAgICBmb250LXdlaWdodDogYm9sZDtcbiAgICAgICAgICB3aGl0ZS1zcGFjZTogbm9ybWFsO1xuICAgICAgICAgIGxpbmUtaGVpZ2h0OiA2MHB4O1xuICAgICAgICB9XG4gICAgICB9XG5cbiAgICAgIC5jaXJjbGUtcG9pbnRzLWNvZmZlZSB7XG4gICAgICAgIC5jaXJjbGUtYmFja2dyb3VuZCB7XG4gICAgICAgICAgaGVpZ2h0OiAxODBweDtcbiAgICAgICAgICB3aWR0aDogMTgwcHg7XG4gICAgICAgICAgYmFja2dyb3VuZC1jb2xvcjogdmFyKC0tcHJpbWFyeSk7XG4gICAgICAgICAgYm9yZGVyLXJhZGl1czogNTAlO1xuICAgICAgICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcbiAgICAgICAgfVxuXG4gICAgICAgIC50ZXh0OmZpcnN0LWNoaWxkIHtcbiAgICAgICAgICBwYWRkaW5nLXRvcDogMzVweDtcbiAgICAgICAgfVxuXG4gICAgICAgIC50ZXh0IHtcbiAgICAgICAgICBkaXNwbGF5OiBibG9jaztcbiAgICAgICAgICBsaW5lLWhlaWdodDogMjRweDtcbiAgICAgICAgICBmb250LXNpemU6IDI0cHg7XG4gICAgICAgICAgcGFkZGluZy10b3A6IDA7XG4gICAgICAgICAgZm9udC13ZWlnaHQ6IGJvbGQ7XG4gICAgICAgICAgY29sb3I6IHZhcigtLXdoaXRlKTtcbiAgICAgICAgICBtYXJnaW46IDBweDtcbiAgICAgICAgICB3aGl0ZS1zcGFjZTogbm9ybWFsO1xuICAgICAgICB9XG5cbiAgICAgICAgLnBvaW50cyB7XG4gICAgICAgICAgZGlzcGxheTogYmxvY2s7XG4gICAgICAgICAgbWFyZ2luOiAwcHg7XG4gICAgICAgICAgY29sb3I6IHZhcigtLXdoaXRlKTtcbiAgICAgICAgICBsaW5lLWhlaWdodDogOTBweDtcbiAgICAgICAgICBwYWRkaW5nLXRvcDogMTUlO1xuICAgICAgICAgIGZvbnQtc2l6ZTogMTIwcHg7XG4gICAgICAgICAgcGFkZGluZy1ib3R0b206IDMlO1xuICAgICAgICAgIHdoaXRlLXNwYWNlOiBub3JtYWw7XG4gICAgICAgIH1cbiAgICAgIH1cblxuICAgICAgLmNpcmNsZS1jb25ncmF0dWxhdGlvbnMge1xuICAgICAgICAuY2lyY2xlLWJhY2tncm91bmQge1xuICAgICAgICAgIGhlaWdodDogMTgwcHg7XG4gICAgICAgICAgd2lkdGg6IDE4MHB4O1xuICAgICAgICAgIGJhY2tncm91bmQtY29sb3I6IHZhcigtLXByaW1hcnkpO1xuICAgICAgICAgIGJvcmRlci1yYWRpdXM6IDUwJTtcbiAgICAgICAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XG4gICAgICAgIH1cblxuICAgICAgICAuaW1nIHtcbiAgICAgICAgICB3aWR0aDogNjRweDtcbiAgICAgICAgICBjb250YWluOiB1bnNldDtcbiAgICAgICAgICBwYWRkaW5nLXRvcDogMjBweDtcbiAgICAgICAgfVxuICAgICAgfVxuXG4gICAgICAudGV4dC1jb250ZW50LWVhcm4tZnJlZS1jb2ZmZWUge1xuICAgICAgICBmb250LXNpemU6IDIwcHg7XG4gICAgICAgIGNvbG9yOiB2YXIoLS13aGl0ZSk7XG4gICAgICAgIGxpbmUtaGVpZ2h0OiAzMHB4O1xuICAgICAgfVxuXG4gICAgICAudGV4dC1jb250ZW50LXBvaW50cy1jb2ZmZWUge1xuICAgICAgICAud2hpdGUge1xuICAgICAgICAgIGNvbG9yOiB2YXIoLS13aGl0ZSk7XG4gICAgICAgIH1cblxuICAgICAgICAucHJpbWFyeSB7XG4gICAgICAgICAgY29sb3I6IHZhcigtLXByaW1hcnkpO1xuICAgICAgICB9XG5cbiAgICAgICAgZm9udC1zaXplOiAzMnB4O1xuICAgICAgICBmb250LXdlaWdodDogYm9sZDtcbiAgICAgIH1cblxuICAgICAgLnRleHQtY2hpbGQtY29udGVudC1wb2ludHMtY29mZmVlIHtcbiAgICAgICAgbGluZS1oZWlnaHQ6IDI0cHg7XG4gICAgICAgIGNvbG9yOiB2YXIoLS13aGl0ZSk7XG4gICAgICB9XG5cbiAgICAgIC50ZXh0LWNvbnRlbnQtY29uZ3JhdHVsYXRpb25zIHtcbiAgICAgICAgZm9udC1zaXplOiAzMnB4O1xuICAgICAgICBmb250LXdlaWdodDogYm9sZDtcbiAgICAgIH1cblxuICAgICAgLnRleHQtY2hpbGQtY29udGVudC1jb25ncmF0dWxhdGlvbnMge1xuICAgICAgICBsaW5lLWhlaWdodDogMjRweDtcbiAgICAgICAgY29sb3I6IHZhcigtLXdoaXRlKTtcbiAgICAgIH1cblxuICAgICAgLmltZy11bml0ZWRFeHAge1xuICAgICAgICB3aWR0aDogMTcwcHg7XG4gICAgICAgIGNvbnRhaW46IHVuc2V0O1xuICAgICAgICBtYXJnaW46IGF1dG87XG4gICAgICB9XG4gICAgfVxuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"],
    encapsulation: 2
  });
}

/***/ }),

/***/ 16444:
/*!*******************************************************!*\
  !*** ./src/app/modules/more/pages/contact/contact.ts ***!
  \*******************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ContactPageComponent: () => (/* binding */ ContactPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);







class ContactPageComponent {
  utils;
  route;
  router;
  surveyStore;
  constructor(utils, route, router) {
    this.utils = utils;
    this.route = route;
    this.router = router;
  }
  getPageName() {
    return 'ContactPage';
  }
  static ɵfac = function ContactPageComponent_Factory(t) {
    return new (t || ContactPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: ContactPageComponent,
    selectors: [["page-contact"]],
    decls: 27,
    vars: 5,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "cus-toolbar"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", 1, "dark"], ["text-center", ""], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "text-content"], ["no-lines", ""], ["href", "tel:+1-855-762-7880"], ["ion-button", ""], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function ContactPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar", 3)(5, "ion-buttons", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](6, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](7, "ion-title", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](8, "Contact Us");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](9, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](10, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](11, "div", 8)(12, "h2");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](13, "We'd like to hear from you!");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](14, " Guest Services Hours: ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](15, "br");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](16, " Monday - Friday: 8 am - 5 pm ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](17, "br")(18, "br");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](19, "ion-item", 9)(20, "a", 10)(21, "button", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](22, "1-855-762-7880");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](23, "ion-item", 9)(24, "button", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](25, "Email Us");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](26, "widget-layout", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](16);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonItem, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__.WidgetLayoutComponent],
    styles: ["page-guest-survey ion-header {\n  border-bottom: 1px solid var(--grey-icon);\n}\npage-guest-survey .text-content {\n  text-align: center;\n  font-size: 28px;\n  color: #203764;\n  padding-top: 15px;\n  font-weight: 600;\n  padding-bottom: 40px;\n}\npage-guest-survey .checkbox-container {\n  display: flex;\n  justify-content: center;\n}\npage-guest-survey ion-item {\n  left: 7vh;\n}\npage-guest-survey ion-item img {\n  max-width: 55%;\n}\npage-guest-survey .button-item {\n  text-align: center;\n  left: 0;\n}\npage-guest-survey .button-item .item-inner {\n  border-bottom: 0 !important;\n}\npage-guest-survey .button-item button {\n  width: 160px;\n  height: 40px !important;\n  border-radius: 20px;\n  font-size: 14px !important;\n  font-weight: 400;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL2NvbnRhY3QvY29udGFjdC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNFO0VBQ0UseUNBQUE7QUFBSjtBQUdFO0VBQ0Usa0JBQUE7RUFDQSxlQUFBO0VBQ0EsY0FBQTtFQUNBLGlCQUFBO0VBQ0EsZ0JBQUE7RUFDQSxvQkFBQTtBQURKO0FBSUU7RUFDRSxhQUFBO0VBQ0EsdUJBQUE7QUFGSjtBQUtFO0VBQ0UsU0FBQTtBQUhKO0FBS0k7RUFDRSxjQUFBO0FBSE47QUFPRTtFQUNFLGtCQUFBO0VBQ0EsT0FBQTtBQUxKO0FBT0k7RUFDRSwyQkFBQTtBQUxOO0FBUUk7RUFDRSxZQUFBO0VBQ0EsdUJBQUE7RUFFQSxtQkFBQTtFQUNBLDBCQUFBO0VBQ0EsZ0JBQUE7QUFQTiIsInNvdXJjZXNDb250ZW50IjpbInBhZ2UtZ3Vlc3Qtc3VydmV5IHtcbiAgaW9uLWhlYWRlciB7XG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIHZhcigtLWdyZXktaWNvbik7XG4gIH1cblxuICAudGV4dC1jb250ZW50IHtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgZm9udC1zaXplOiAyOHB4O1xuICAgIGNvbG9yOiAjMjAzNzY0O1xuICAgIHBhZGRpbmctdG9wOiAxNXB4O1xuICAgIGZvbnQtd2VpZ2h0OiA2MDA7XG4gICAgcGFkZGluZy1ib3R0b206IDQwcHg7XG4gIH1cblxuICAuY2hlY2tib3gtY29udGFpbmVyIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICB9XG5cbiAgaW9uLWl0ZW0ge1xuICAgIGxlZnQ6IDd2aDtcblxuICAgIGltZyB7XG4gICAgICBtYXgtd2lkdGg6IDU1JTtcbiAgICB9XG4gIH1cblxuICAuYnV0dG9uLWl0ZW0ge1xuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgICBsZWZ0OiAwO1xuXG4gICAgLml0ZW0taW5uZXIge1xuICAgICAgYm9yZGVyLWJvdHRvbTogMCAhaW1wb3J0YW50O1xuICAgIH1cblxuICAgIGJ1dHRvbiB7XG4gICAgICB3aWR0aDogMTYwcHg7XG4gICAgICBoZWlnaHQ6IDQwcHggIWltcG9ydGFudDtcbiAgICAgIC8vIGJhY2tncm91bmQ6ICMyMDM3NjQ7XG4gICAgICBib3JkZXItcmFkaXVzOiAyMHB4O1xuICAgICAgZm9udC1zaXplOiAxNHB4ICFpbXBvcnRhbnQ7XG4gICAgICBmb250LXdlaWdodDogNDAwO1xuICAgIH1cbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"],
    encapsulation: 2
  });
}

/***/ }),

/***/ 91884:
/*!*****************************************************************!*\
  !*** ./src/app/modules/more/pages/guest-survey/guest-survey.ts ***!
  \*****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   GuestSurveyPageComponent: () => (/* binding */ GuestSurveyPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);







class GuestSurveyPageComponent {
  utils;
  route;
  router;
  surveyStore;
  constructor(utils, route, router) {
    this.utils = utils;
    this.route = route;
    this.router = router;
  }
  goSurvey() {
    switch (this.surveyStore) {
      case 'treetSide':
        this.utils.openInaAppBrowser('https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united');
        break;
      case 'united':
        this.utils.openInaAppBrowser('https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united');
        break;
      case 'mktstreet':
        this.utils.openInaAppBrowser('https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united');
        break;
      case 'albertsons':
        this.utils.openInaAppBrowser('https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united');
        break;
      case 'amigos':
        this.utils.openInaAppBrowser('https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united');
        break;
      case 'unitedExpress':
        this.utils.openInaAppBrowser('https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united');
        break;
      default:
        break;
    }
  }
  getPageName() {
    return 'GuestSurveyPage';
  }
  static ɵfac = function GuestSurveyPageComponent_Factory(t) {
    return new (t || GuestSurveyPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: GuestSurveyPageComponent,
    selectors: [["page-guest-survey"]],
    decls: 26,
    vars: 5,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "cus-toolbar"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", 1, "dark"], ["text-center", ""], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "text-content"], [1, "button-item"], ["ion-button", "", 3, "click"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function GuestSurveyPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar", 3)(5, "ion-buttons", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](6, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](7, "ion-title", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](8, "Guest Survey");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](9, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](10, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](11, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](12, " Where Do You ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](13, "br");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](14, " Shop With Us? ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](15, "ion-row")(16, "ion-item", 9)(17, "button", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function GuestSurveyPageComponent_Template_button_click_17_listener() {
          return ctx.utils.openInaAppBrowser("https://albertsons.az1.qualtrics.com/jfe/form/SV_6WEsX4eEQbIGu4R?Banner=united");
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](18, " Grocery Store ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](19, "ion-item", 9)(20, "button", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function GuestSurveyPageComponent_Template_button_click_20_listener() {
          return ctx.utils.openInaAppBrowser("https://albertsons.az1.qualtrics.com/jfe/form/SV_0Nis4kLulr3nBUV");
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](21, " Online Grocery Store ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](22, "ion-item", 9)(23, "button", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function GuestSurveyPageComponent_Template_button_click_23_listener() {
          return ctx.utils.openInaAppBrowser("https://albertsons.az1.qualtrics.com/jfe/form/SV_9ST7PNu6qHsSqFL");
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](24, " Fuel/Convenience Store ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](25, "widget-layout", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](15);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonItem, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonRow, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__.WidgetLayoutComponent],
    styles: ["page-guest-survey ion-header {\n  border-bottom: 1px solid var(--grey-icon);\n}\npage-guest-survey .text-content {\n  text-align: center;\n  font-size: 28px;\n  color: #203764;\n  padding-top: 15px;\n  font-weight: 600;\n  padding-bottom: 40px;\n}\npage-guest-survey .checkbox-container {\n  display: flex;\n  justify-content: center;\n}\npage-guest-survey ion-item {\n  left: 7vh;\n}\npage-guest-survey ion-item img {\n  max-width: 55%;\n}\npage-guest-survey .button-item {\n  text-align: center;\n  left: 0;\n}\npage-guest-survey .button-item .item-inner {\n  border-bottom: 0 !important;\n}\npage-guest-survey .button-item button {\n  width: 160px;\n  height: 40px !important;\n  border-radius: 20px;\n  font-size: 14px !important;\n  font-weight: 400;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL2d1ZXN0LXN1cnZleS9ndWVzdC1zdXJ2ZXkuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDRTtFQUNFLHlDQUFBO0FBQUo7QUFHRTtFQUNFLGtCQUFBO0VBQ0EsZUFBQTtFQUNBLGNBQUE7RUFDQSxpQkFBQTtFQUNBLGdCQUFBO0VBQ0Esb0JBQUE7QUFESjtBQUlFO0VBQ0UsYUFBQTtFQUNBLHVCQUFBO0FBRko7QUFLRTtFQUNFLFNBQUE7QUFISjtBQUtJO0VBQ0UsY0FBQTtBQUhOO0FBT0U7RUFDRSxrQkFBQTtFQUNBLE9BQUE7QUFMSjtBQU9JO0VBQ0UsMkJBQUE7QUFMTjtBQVFJO0VBQ0UsWUFBQTtFQUNBLHVCQUFBO0VBRUEsbUJBQUE7RUFDQSwwQkFBQTtFQUNBLGdCQUFBO0FBUE4iLCJzb3VyY2VzQ29udGVudCI6WyJwYWdlLWd1ZXN0LXN1cnZleSB7XG4gIGlvbi1oZWFkZXIge1xuICAgIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCB2YXIoLS1ncmV5LWljb24pO1xuICB9XG5cbiAgLnRleHQtY29udGVudCB7XG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICAgIGZvbnQtc2l6ZTogMjhweDtcbiAgICBjb2xvcjogIzIwMzc2NDtcbiAgICBwYWRkaW5nLXRvcDogMTVweDtcbiAgICBmb250LXdlaWdodDogNjAwO1xuICAgIHBhZGRpbmctYm90dG9tOiA0MHB4O1xuICB9XG5cbiAgLmNoZWNrYm94LWNvbnRhaW5lciB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgfVxuXG4gIGlvbi1pdGVtIHtcbiAgICBsZWZ0OiA3dmg7XG5cbiAgICBpbWcge1xuICAgICAgbWF4LXdpZHRoOiA1NSU7XG4gICAgfVxuICB9XG5cbiAgLmJ1dHRvbi1pdGVtIHtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgbGVmdDogMDtcblxuICAgIC5pdGVtLWlubmVyIHtcbiAgICAgIGJvcmRlci1ib3R0b206IDAgIWltcG9ydGFudDtcbiAgICB9XG5cbiAgICBidXR0b24ge1xuICAgICAgd2lkdGg6IDE2MHB4O1xuICAgICAgaGVpZ2h0OiA0MHB4ICFpbXBvcnRhbnQ7XG4gICAgICAvLyBiYWNrZ3JvdW5kOiAjMjAzNzY0O1xuICAgICAgYm9yZGVyLXJhZGl1czogMjBweDtcbiAgICAgIGZvbnQtc2l6ZTogMTRweCAhaW1wb3J0YW50O1xuICAgICAgZm9udC13ZWlnaHQ6IDQwMDtcbiAgICB9XG4gIH1cbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"],
    encapsulation: 2
  });
}

/***/ }),

/***/ 70352:
/*!***************************************************!*\
  !*** ./src/app/modules/more/pages/legal/legal.ts ***!
  \***************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   LegalPageComponent: () => (/* binding */ LegalPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/tenant-settings.service */ 84852);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);










class LegalPageComponent {
  route;
  router;
  utils;
  tenantSettingsStore;
  links;
  constructor(route, router, utils, tenantSettingsStore) {
    this.route = route;
    this.router = router;
    this.utils = utils;
    this.tenantSettingsStore = tenantSettingsStore;
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const tenantSetting = yield _this.tenantSettingsStore.getTenantSettings();
      _this.links = tenantSetting.pages;
    })();
  }
  getPageName() {
    return 'LegalPage';
  }
  static ɵfac = function LegalPageComponent_Factory(t) {
    return new (t || LegalPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_2__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_1__.TenantSettingsStore));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
    type: LegalPageComponent,
    selectors: [["page-legal"]],
    decls: 23,
    vars: 5,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "cus-listButton"], [3, "click"], [1, "cus-menuItemHeavy", "ion-text-left"], ["slot", "end"], [1, "custom-size-icon", "ion-float-end", "ion-ios-arrow-forward-outline"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function LegalPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar")(5, "ion-buttons", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](6, "ion-back-button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "ion-title");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](8, "Legal");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](10, "widget-layout", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](11, "ion-list", 6)(12, "ion-item", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function LegalPageComponent_Template_ion_item_click_12_listener() {
          return ctx.utils.openInaAppBrowser(ctx.links.privacy);
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](13, "ion-label", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](14, " Privacy Policy ");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](15, "ion-note", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](16, "ion-icon", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](17, "ion-item", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function LegalPageComponent_Template_ion_item_click_17_listener() {
          return ctx.utils.openInaAppBrowser(ctx.links.terms);
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](18, "ion-label", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](19, " Terms & Conditions ");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](20, "ion-note", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](21, "ion-icon", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](22, "widget-layout", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonItem, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonLabel, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonList, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonNote, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent],
    styles: ["/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 61923:
/*!****************************************************!*\
  !*** ./src/app/modules/more/pages/log/log.page.ts ***!
  \****************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   LogPageComponent: () => (/* binding */ LogPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var ionic_logging_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ionic-logging-service */ 32759);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);












function LogPageComponent_ion_row_11_a_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "a", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](1, "send");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const item_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate1"]("href", "mailto:trang@relationshop.com?body=", item_r2.mailContent, "", _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsanitizeUrl"]);
  }
}
function LogPageComponent_ion_row_11_ion_col_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "ion-col", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const item_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" User: ", item_r2.message[1], " ");
  }
}
function LogPageComponent_ion_row_11_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "ion-row")(1, "ion-col", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "ion-col", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](5, "ion-col", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "ion-col", 10)(8, "ion-button", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵlistener"]("click", function LogPageComponent_ion_row_11_Template_ion_button_click_8_listener() {
      const item_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵresetView"](ctx_r2.sendMail(item_r2));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](9, "compose");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](10, LogPageComponent_ion_row_11_a_10_Template, 2, 2, "a", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](11, LogPageComponent_ion_row_11_ion_col_11_Template, 2, 1, "ion-col", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](12, "ion-col", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const item_r2 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", item_r2.timeStamp.toLocaleString(), " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", item_r2.level, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", item_r2.methodName, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", item_r2.mailContent);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", item_r2.message.length > 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtextInterpolate1"](" ", item_r2.message[0], " ");
  }
}
class LogPageComponent {
  route;
  router;
  utils;
  loggingService;
  logger;
  logs;
  localStorageKey = 'united_log';
  constructor(route, router, utils, loggingService) {
    this.route = route;
    this.router = router;
    this.utils = utils;
    this.loggingService = loggingService;
    this.logger = this.loggingService.getLogger('Health');
  }
  ionViewDidEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.load();
    })();
  }
  getPageName() {
    return 'LogPage';
  }
  load() {
    // this.loggingService.a
    // this.lo
    // this.logs = this.loggingService.getLogMessagesFromLocalStorage();
    // this.logs = LocalStorageAppender.getLogMessages();
    let logs;
    const localStorage = window.localStorage;
    if (localStorage.getItem(this.localStorageKey) === null) {
      logs = [];
    } else {
      logs = JSON.parse(localStorage.getItem(this.localStorageKey));
      for (const logMessage of logs) {
        // timestamps are serialized as strings
        logMessage.timeStamp = new Date(logMessage.timeStamp);
      }
    }
    this.logs = lodash__WEBPACK_IMPORTED_MODULE_2___default().reverse(logs);
  }
  clear() {
    // this.logger.de;
    // this.loggingService.clear
  }
  sendMail(log) {
    const logDisplay = JSON.parse(JSON.stringify(log));
    if (logDisplay && logDisplay.message && logDisplay.message[0]) {
      logDisplay.message[0] = JSON.parse(logDisplay.message[0]);
    }
    const logStr = JSON.stringify(logDisplay),
      encodeStr = encodeURIComponent(logStr);
    log.mailContent = encodeStr;
  }
  static ɵfac = function LogPageComponent_Factory(t) {
    return new (t || LogPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](ionic_logging_service__WEBPACK_IMPORTED_MODULE_6__.LoggingService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
    type: LogPageComponent,
    selectors: [["page-log"]],
    decls: 13,
    vars: 6,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [4, "ngFor", "ngForOf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], ["size", "3"], ["size", "6"], ["size", "12"], ["size", "small", "fill", "clear", 3, "click"], [3, "href", 4, "ngIf"], ["size", "12", 4, "ngIf"], [3, "href"]],
    template: function LogPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar")(5, "ion-buttons", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](6, "ion-back-button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "ion-title");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtext"](8, "Debug Log");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](10, "widget-layout", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](11, LogPageComponent_ion_row_11_Template, 14, 6, "ion-row", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](12, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx.logs);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_7__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonCol, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonRow, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_3__.WidgetLayoutComponent],
    styles: ["ion-row[_ngcontent-%COMP%] {\n  border: 1px solid blue;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL2xvZy9sb2cuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHNCQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tcm93IHtcbiAgYm9yZGVyOiAxcHggc29saWQgYmx1ZTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 45836:
/*!*********************************************************************!*\
  !*** ./src/app/modules/more/pages/message-center/message-center.ts ***!
  \*********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MessageCenterPageComponent: () => (/* binding */ MessageCenterPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../utils/pipes/safe-html/safe-html */ 93943);







class MessageCenterPageComponent {
  router;
  constructor(router) {
    this.router = router;
  }
  notificationHtml = '';
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (_this.notificationHtml) {
        _this.notificationHtml = '';
      }
      customElements.whenDefined('dxp-notification-page').then(() => {
        _this.notificationHtml = '<dxp-notification-page></dxp-notification-page>';
      });
    })();
  }
  static ɵfac = function MessageCenterPageComponent_Factory(t) {
    return new (t || MessageCenterPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: MessageCenterPageComponent,
    selectors: [["message-center"]],
    decls: 14,
    vars: 8,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "message-center", 3, "innerHtml"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function MessageCenterPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar")(5, "ion-buttons", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](6, "ion-back-button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](7, "ion-title");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](8, "Message Center");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](9, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](10, "widget-layout", 5)(11, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](12, "safeHtml");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](13, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("innerHtml", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](12, 6, ctx.notificationHtml), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__.WidgetLayoutComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__.SafeHtmlPipe],
    styles: ["ion-content[_ngcontent-%COMP%] {\n  --padding-bottom: 0 !important;\n}\n\nion-back-button[_ngcontent-%COMP%] {\n  --color: var(--mag-color-text-primary, #121212);\n}\n\n.message-center[_ngcontent-%COMP%] {\n  height: 100%;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL21lc3NhZ2UtY2VudGVyL21lc3NhZ2UtY2VudGVyLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw4QkFBQTtBQUNGOztBQUVBO0VBQ0UsK0NBQUE7QUFDRjs7QUFFQTtFQUNFLFlBQUE7QUFDRiIsInNvdXJjZXNDb250ZW50IjpbImlvbi1jb250ZW50IHtcbiAgLS1wYWRkaW5nLWJvdHRvbTogMCAhaW1wb3J0YW50O1xufVxuXG5pb24tYmFjay1idXR0b24ge1xuICAtLWNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbn1cblxuLm1lc3NhZ2UtY2VudGVyIHtcbiAgaGVpZ2h0OiAxMDAlO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 27304:
/*!*************************************************!*\
  !*** ./src/app/modules/more/pages/more/more.ts ***!
  \*************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MorePageComponent: () => (/* binding */ MorePageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _capacitor_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @capacitor/core */ 14070);
/* harmony import */ var _ionic_storage__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ionic/storage */ 60850);
/* harmony import */ var _rsApp_modules_account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/account-v2/providers/user.service */ 51074);
/* harmony import */ var _rsApp_modules_auth_v2_providers_auth_v2_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/auth-v2.service */ 19683);
/* harmony import */ var _rsApp_modules_store_providers_current_store_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @rsApp/modules/store/providers/current-store.service */ 68775);
/* harmony import */ var _rsApp_modules_store_providers_store_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @rsApp/modules/store/providers/store.service */ 4247);
/* harmony import */ var _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @rsApp/modules/utils/constants/constants */ 29665);
/* harmony import */ var _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @rsApp/modules/utils/enum/enum */ 24457);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _rsApp_modules_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @rsApp/modules/utils/providers/tenant-settings.service */ 84852);
/* harmony import */ var _rsApp_modules_utils_providers_google_tracker_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @rsApp/modules/utils/providers/google-tracker.service */ 16324);
/* harmony import */ var _rsApp_modules_utils_providers_rs_tracker_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @rsApp/modules/utils/providers/rs-tracker.service */ 32980);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_15__);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! rxjs/operators */ 64334);
/* harmony import */ var _providers_dynamic_menu_service__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../providers/dynamic-menu.service */ 39683);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var ionic_cache__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ionic-cache */ 65503);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! @ngx-translate/core */ 90852);








































const _c0 = () => ["/tabs/more/message-center"];
const _c1 = () => ["/account"];
const _c2 = () => ["/shopping-list"];
const _c3 = () => ["/recipe"];
const _c4 = () => ["/order/order-history"];
const _c5 = () => ["/tabs/more/about"];
const _c6 = () => ["/tabs/more/legal"];
function MorePageComponent_ion_item_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-item", 11)(1, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](2, " Messages ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](3, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](4, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](1, _c0));
  }
}
function MorePageComponent_ng_container_13_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](1, "ion-item", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ng_container_13_Template_ion_item_click_1_listener() {
      const nav_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.onClickDynamicMenu(nav_r2));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](2, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](5, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const nav_r2 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"](" ", nav_r2 == null ? null : nav_r2.Label, " ");
  }
}
function MorePageComponent_ng_container_14_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](1, "ion-item", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ng_container_14_Template_ion_item_click_1_listener() {
      const nav_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r4).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.checkCustomServiceAvailableInstore(nav_r5.ServiceId));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](2, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](4, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](5, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const nav_r5 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("hidden", !ctx_r2.user);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate1"](" ", nav_r5 == null ? null : nav_r5.Name, " ");
  }
}
function MorePageComponent_ng_container_15_ion_row_42_Template(rf, ctx) {
  if (rf & 1) {
    const _r7 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-row", 19)(1, "ion-col", 20)(2, "ion-button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ng_container_15_ion_row_42_Template_ion_button_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r7);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.utils.openInaAppBrowser(ctx_r2.links.teamMember));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3, "Team Members ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
  }
}
function MorePageComponent_ng_container_15_Template(rf, ctx) {
  if (rf & 1) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](1, "ion-list", 17)(2, "ion-item", 18)(3, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](4, " My Account ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](5, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](6, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](7, "ion-item", 18)(8, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](9, " My Lists ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](10, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](11, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](12, "ion-item", 18)(13, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](14, " Recipes ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](15, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](16, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](17, "ion-item", 18)(18, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](19, " Purchase History ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](20, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](21, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](22, "ion-item", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ng_container_15_Template_ion_item_click_22_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r6);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.utils.openInaAppBrowser(ctx_r2.links.contactUs));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](23, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](24, "FAQs");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](25, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](26, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](27, "ion-item", 11)(28, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](29, " About Our App ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](30, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](31, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](32, "ion-item", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ng_container_15_Template_ion_item_click_32_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r6);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.utils.openInaAppBrowser(ctx_r2.links.help));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](33, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](34, " Help ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](35, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](36, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](37, "ion-item", 11)(38, "ion-label", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](39, " Legal ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](40, "ion-note", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](41, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](42, MorePageComponent_ng_container_15_ion_row_42_Template, 4, 0, "ion-row", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("hidden", !ctx_r2.user)("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](11, _c1));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("hidden", !ctx_r2.user)("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](12, _c2));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("hidden", !ctx_r2.user)("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](13, _c3));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("hidden", !ctx_r2.user)("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](14, _c4));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](15, _c5));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpureFunction0"](16, _c6));
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx_r2.isTeamMember && ctx_r2.user);
  }
}
function MorePageComponent_ion_row_16_Template(rf, ctx) {
  if (rf & 1) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-row", 19)(1, "ion-col", 20)(2, "ion-button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ion_row_16_Template_ion_button_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r8);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.utils.openInaAppBrowser(ctx_r2.links.teamMember));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3, "Team Members ");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
  }
}
function MorePageComponent_ion_row_17_Template(rf, ctx) {
  if (rf & 1) {
    const _r9 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-row", 19)(1, "ion-col", 20)(2, "ion-button", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ion_row_17_Template_ion_button_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r9);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.logOut());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](4, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](4, 1, "login.logOut"));
  }
}
function MorePageComponent_ion_row_18_Template(rf, ctx) {
  if (rf & 1) {
    const _r10 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](0, "ion-row", 19)(1, "ion-col", 20)(2, "ion-button", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵlistener"]("click", function MorePageComponent_ion_row_18_Template_ion_button_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵrestoreView"](_r10);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵresetView"](ctx_r2.logInSignUp());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](4, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](5, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate2"]("", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](4, 2, "login.login"), "/ ", _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](5, 4, "login.signUp"), "");
  }
}
class MorePageComponent {
  auth;
  route;
  router;
  utils;
  cache;
  cStore;
  userS;
  platform;
  alertCtrl;
  navCtrl;
  storage;
  tracker;
  appSetting;
  oStore;
  dynamicMenuSvc;
  googleTracking;
  tenantSettingsStore;
  user;
  store;
  isTeamMember = false;
  customServices = _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV;
  dynamicNavs = [];
  links;
  currentOnlineStore;
  allServices;
  dynamicMenus;
  menuCode = '';
  locale;
  title = 'More ...';
  subscriptions = [];
  constructor(auth, route, router, utils, cache, cStore, userS, platform, alertCtrl, navCtrl, storage, tracker, appSetting, oStore, dynamicMenuSvc, googleTracking, tenantSettingsStore) {
    this.auth = auth;
    this.route = route;
    this.router = router;
    this.utils = utils;
    this.cache = cache;
    this.cStore = cStore;
    this.userS = userS;
    this.platform = platform;
    this.alertCtrl = alertCtrl;
    this.navCtrl = navCtrl;
    this.storage = storage;
    this.tracker = tracker;
    this.appSetting = appSetting;
    this.oStore = oStore;
    this.dynamicMenuSvc = dynamicMenuSvc;
    this.googleTracking = googleTracking;
    this.tenantSettingsStore = tenantSettingsStore;
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const tenantSettingsStore = yield _this.tenantSettingsStore.getTenantSettings();
      _this.links = tenantSettingsStore.pages;
    })();
  }
  ionViewDidEnter() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.menuCode = _this2.route.snapshot.paramMap.get('menu') || 'APP_MORE_MENU';
      _this2.locale = yield _this2.storage.get(_rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_8__.LOCAL_LOCALE_KEY);
      _this2.loadData();
    })();
  }
  ngOnDestroy() {
    this.subscriptions.forEach(s => {
      s.unsubscribe();
    });
  }
  loadData() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this3.store = yield _this3.cStore.getStore();
      const getCUser = _this3.auth.getCurrentUser().subscribe(/*#__PURE__*/function () {
        var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (user) {
          _this3.user = user;
          // verybad code
          const store = yield _this3.cache.getItem('selected-store').catch();
          if (store) {
            yield _this3.setCurrenStore(store);
          }
          // end very bad code
          if (_this3.user && !_this3.user.Segments) {
            const cardInfo = yield _this3.userS.getCardInfo(user.SRCardID).toPromise();
            _this3.user.Segments = cardInfo && cardInfo.Segments || null;
          }
          // Load check segment
          if (_this3.user && _this3.user.Segments && _this3.user.Segments.length > 0) {
            _this3.isTeamMember = lodash__WEBPACK_IMPORTED_MODULE_15___default().find(_this3.user.Segments, function (o) {
              return o.SegmentId === 60;
            }) !== null;
          }
          // end Load check segment
          _this3.importForAfterDisplay();
        });
        return function (_x) {
          return _ref.apply(this, arguments);
        };
      }());
      _this3.subscriptions.push(getCUser);
    })();
  }
  importForAfterDisplay() {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this4.getOnlineStore();
      yield _this4.getAllCustomServices();
      _this4.loadDynamicMenu();
    })();
  }
  changeStore() {
    const cri = {
      keyword: this.store && this.store.ZipCode,
      size: 3
    };
    this.cache.saveItem('store-search-params', cri);
    this.cache.saveItem('store-back', {
      route: ['/tabs/more'],
      key: 'selected-store'
    }, 'store');
    this.router.navigate(['/tabs/more/store/near', {
      type: 'chooseStore',
      returnRoute: 'tabs/more'
    }]);
  }
  goStore() {
    this.navCtrl.navigateRoot(['/store/find'], {
      animated: true,
      animationDirection: 'forward'
    });
  }
  setCurrenStore(store) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield (0,rxjs__WEBPACK_IMPORTED_MODULE_19__.firstValueFrom)(_this5.userS.setStore(_this5.user, store));
      yield _this5.cStore.setStore(store);
      _this5.cache.removeItem('selected-store');
      _this5.auth.refreshUser();
      // this.store = await this.cStore.getStore();
      _this5.store = store;
    })();
  }
  logOut() {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this6.utils.showLoading();
      yield _this6.auth.logout();
      _this6.store = null;
      yield _this6.utils.hideLoading();
      _this6.navCtrl.navigateRoot(['/tabs/home']);
    })();
  }
  logInSignUp() {
    var _this7 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this7.utils.showLoading();
      _this7.navCtrl.navigateRoot(['/sign-in']).then(() => {
        _this7.utils.hideLoading();
      });
    })();
  }
  goPharmacy() {
    if (!this.platform.is('cordova')) {
      return;
    }
    const urlScheme = _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.PharmacyAppUrl;
    let appLink;
    if (this.platform.is('ios')) {
      appLink = _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.AppStorePharmacyAppUrl;
    }
    if (this.platform.is('android')) {
      appLink = _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.GooglePlayPharmacyAppUrl;
    }
    if (_capacitor_core__WEBPACK_IMPORTED_MODULE_2__.Capacitor.isNativePlatform()) {
      this.utils.openInSystem(appLink);
    } else {
      this.utils.openInSystem(urlScheme);
    }
  }
  getOnlineStore() {
    var _this8 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      // always fetch new store data from menu
      if (!_this8.currentOnlineStore && _this8.store) {
        _this8.currentOnlineStore = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_19__.firstValueFrom)(_this8.oStore.getStoreByCode(_this8.store.StoreCode));
      }
      return _this8.currentOnlineStore;
    })();
  }
  getAllCustomServices() {
    var _this9 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (!_this9.allServices) {
        _this9.allServices = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_19__.firstValueFrom)(_this9.oStore.getStoreSystemServices());
      }
      return _this9.allServices;
    })();
  }
  checkCustomServiceAvailableInstore(serviceSlug) {
    var _this0 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (!_this0.store) {
        _this0.goStore();
        return;
      }
      let foundService;
      try {
        const services = yield _this0.getAllCustomServices();
        foundService = lodash__WEBPACK_IMPORTED_MODULE_15___default().find(services, {
          UrlSlug: String(foundService && foundService.UrlSlug || serviceSlug)
        });
      } catch (error) {
        console.error(error);
        return;
      }
      if (foundService?.Type === 'CustomService') {
        try {
          yield _this0.getOnlineStore();
        } catch (error) {
          console.error(error);
        }
      }
      if (!foundService) {
        _this0.goToCollectionPage(null, serviceSlug);
      } else {
        _this0.goToCollectionPage(foundService);
      }
    })();
  }
  goToCollectionPage(service, serviceSlug) {
    if (service) {
      this.storage.set('CurrentService', JSON.stringify(service));
    }
    try {
      const systemService = lodash__WEBPACK_IMPORTED_MODULE_15___default().find(this.allServices, s => s.ServiceId === (service ? service.ParentId || service.ServiceId : serviceSlug));
      if (!systemService) {
        console.error('systemService not found');
        return;
      }
      const contentType = systemService.ServiceName.toLowerCase().replace(' ', '-');
      this.eventTrackSelectContent(contentType, '');
      if (service && service.DisplayMode === _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_9__.enumDisplayModeCustomService.Products || serviceSlug === 'gift-cards') {
        this.router.navigate([`/commerce/${systemService.UrlSlug}/list-products/${service.UrlSlug}`]);
      } else if (service && service.Type === 'CustomService') {
        this.router.navigate([`/commerce/${systemService.UrlSlug}/collections/${service.UrlSlug}`]);
      } else {
        // is System Service
        this.router.navigate([`/commerce/${service && service.Type === 'CustomService' ? systemService.UrlSlug : service.UrlSlug}/`]);
      }
    } catch (error) {
      console.error('Error navigating to collection page:', error);
    }
  }
  loadDynamicNavigationServiceSetting() {
    this.appSetting.getDynamicNavigationServiceSetting().pipe((0,rxjs_operators__WEBPACK_IMPORTED_MODULE_20__.take)(1)).subscribe(dynamicNavs => {
      this.dynamicNavs = dynamicNavs;
    });
  }
  eventTrackSelectContent(contentType, contentId) {
    this.googleTracking.gtagTrackSelectContent(contentType, contentId);
  }
  loadDynamicMenu() {
    var _this1 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      yield _this1.utils.showLoading();
      const s = _this1.dynamicMenuSvc.getMenu(_this1.menuCode, _this1.user, _this1.store, 'Mobile', _this1.locale).subscribe(/*#__PURE__*/function () {
        var _ref2 = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (moreMenu) {
          if (!moreMenu || moreMenu.IsDeleted || !moreMenu.Childs || !_this1.user && moreMenu.Options && moreMenu.Options.AuthRequired) {
            return;
          }
          const dynamicMenus = lodash__WEBPACK_IMPORTED_MODULE_15___default().filter(moreMenu.Childs, menu => {
            const isValid = !_this1.user && !menu.Options.AuthRequired || _this1.user;
            return isValid;
          });
          _this1.title = moreMenu.Label;
          _this1.dynamicMenus = dynamicMenus.filter(menu => {
            if (!menu.Options.ServiceId) return true;
            const dataService = _this1.allServices.find(service => service.ServiceId === menu.Options.ServiceId);
            return dataService && dataService.IsActive;
          });
          yield _this1.utils.hideLoading();
        });
        return function (_x2) {
          return _ref2.apply(this, arguments);
        };
      }());
      _this1.subscriptions.push(s);
    })();
  }
  onClickDynamicMenu(menu) {
    const mobileUrl = menu.UrlLink;
    if (mobileUrl) {
      if (mobileUrl.indexOf('func://') > -1) {
        const startIdxParams = mobileUrl.indexOf('(') + 1;
        const endIdxParams = mobileUrl.indexOf(')');
        const fnName = (mobileUrl.slice(0, startIdxParams - 1) + mobileUrl.slice(endIdxParams + 1)).replace('func://', '');
        const params = mobileUrl.slice(startIdxParams, endIdxParams);
        const fn = this[fnName];
        if (fn && typeof fn === 'function') {
          fn.call(this, params);
        }
        return;
      }
    }
    this.utils.navigateByUrl(mobileUrl);
  }
  getPageName() {
    return 'MorePage';
  }
  static ɵfac = function MorePageComponent_Factory(t) {
    return new (t || MorePageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_auth_v2_service__WEBPACK_IMPORTED_MODULE_5__.AuthService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_21__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_21__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_14__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](ionic_cache__WEBPACK_IMPORTED_MODULE_22__.CacheService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_store_providers_current_store_service__WEBPACK_IMPORTED_MODULE_6__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_account_v2_providers_user_service__WEBPACK_IMPORTED_MODULE_4__.User), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_23__.Platform), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_24__.AlertController), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_23__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_ionic_storage__WEBPACK_IMPORTED_MODULE_3__.Storage), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_rs_tracker_service__WEBPACK_IMPORTED_MODULE_13__.RSTracker), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_10__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_store_providers_store_service__WEBPACK_IMPORTED_MODULE_7__.StoreService), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_providers_dynamic_menu_service__WEBPACK_IMPORTED_MODULE_16__.DynamicMenu), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_google_tracker_service__WEBPACK_IMPORTED_MODULE_12__.GoogleAnalyticTracker), _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_tenant_settings_service__WEBPACK_IMPORTED_MODULE_11__.TenantSettingsStore));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdefineComponent"]({
    type: MorePageComponent,
    selectors: [["page-more"]],
    decls: 20,
    vars: 15,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], ["slot", "start"], ["defaultHref", "home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["detail", "false", 3, "routerLink", 4, "ngIf"], [4, "ngFor", "ngForOf"], [4, "ngIf"], ["margin-top", "", 4, "ngIf"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], ["detail", "false", 3, "routerLink"], [1, "cus-menuItemHeavy", "ion-text-left"], ["slot", "end"], [1, "custom-size-icon", "ion-float-end", "ion-ios-arrow-forward-outline"], ["detail", "false", 3, "click"], ["detail", "false", 3, "click", "hidden"], [1, "cus-listButton"], ["detail", "false", 3, "hidden", "routerLink"], ["margin-top", ""], [1, "ion-text-center"], ["color", "secondary", 1, "l-btn", 3, "click"], [1, "l-btn", "btn-default-theme", 3, "click"]],
    template: function MorePageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar")(5, "ion-buttons", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](6, "ion-back-button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](7, "ion-title");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtext"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipe"](9, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementStart"](10, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](11, "widget-layout", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtemplate"](12, MorePageComponent_ion_item_12_Template, 5, 2, "ion-item", 6)(13, MorePageComponent_ng_container_13_Template, 6, 1, "ng-container", 7)(14, MorePageComponent_ng_container_14_Template, 6, 2, "ng-container", 7)(15, MorePageComponent_ng_container_15_Template, 43, 17, "ng-container", 8)(16, MorePageComponent_ion_row_16_Template, 4, 0, "ion-row", 9)(17, MorePageComponent_ion_row_17_Template, 5, 3, "ion-row", 9)(18, MorePageComponent_ion_row_18_Template, 6, 6, "ion-row", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelement"](19, "widget-layout", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵpipeBind1"](9, 13, "header.more"));
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.user);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngForOf", ctx.dynamicMenus);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngForOf", ctx.dynamicNavs);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", false);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", ctx.isTeamMember && ctx.user);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !!ctx.user);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("ngIf", !ctx.user);
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_router__WEBPACK_IMPORTED_MODULE_21__.RouterLink, _angular_common__WEBPACK_IMPORTED_MODULE_25__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_25__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonCol, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonItem, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonLabel, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonList, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonNote, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonRow, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonTitle, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.IonBackButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_24__.RouterLinkDelegate, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_17__.WidgetLayoutComponent, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_26__.TranslatePipe],
    styles: ["ion-list[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  text-transform: uppercase;\n}\n\nstrong[_ngcontent-%COMP%] {\n  color: var(--ion-color-primary);\n}\n\n.info-store[_ngcontent-%COMP%] {\n  margin-left: 26px;\n}\n\n.l-btn[_ngcontent-%COMP%] {\n  min-width: 300px !important;\n  padding: 7px !important;\n  --border-radius: 5px !important;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9tb3JlL3BhZ2VzL21vcmUvbW9yZS5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUVFO0VBQ0UseUJBQUE7QUFESjs7QUFJQTtFQUNFLCtCQUFBO0FBREY7O0FBR0E7RUFDRSxpQkFBQTtBQUFGOztBQUVBO0VBQ0UsMkJBQUE7RUFDQSx1QkFBQTtFQUNBLCtCQUFBO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tbGlzdCB7XG4gIC8vIG1pbi1oZWlnaHQ6IGNhbGMoMTAwdmggLSA0MDBweCk7XG4gIGlvbi1idXR0b24ge1xuICAgIHRleHQtdHJhbnNmb3JtOiB1cHBlcmNhc2U7XG4gIH1cbn1cbnN0cm9uZyB7XG4gIGNvbG9yOiB2YXIoLS1pb24tY29sb3ItcHJpbWFyeSk7XG59XG4uaW5mby1zdG9yZSB7XG4gIG1hcmdpbi1sZWZ0OiAyNnB4O1xufVxuLmwtYnRuIHtcbiAgbWluLXdpZHRoOiAzMDBweCAhaW1wb3J0YW50O1xuICBwYWRkaW5nOiA3cHggIWltcG9ydGFudDtcbiAgLS1ib3JkZXItcmFkaXVzOiA1cHggIWltcG9ydGFudDtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_more_more_module_ts.js.map