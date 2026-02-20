"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["src_app_modules_ecom-v2_dxpage_dxpage-routing_module_ts"],{

/***/ 38143:
/*!***********************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/component/dxpage-custom-layout/dxpage-custom-layout.ts ***!
  \***********************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageCustomLayoutComponent: () => (/* binding */ DXPageCustomLayoutComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_tracker_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp-tracker.service */ 81527);
/* harmony import */ var _dxpage_utils__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../dxpage.utils */ 25276);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 60316);










const _c0 = a0 => ({
  zoneData: a0,
  isFirstZone: true
});
const _c1 = a0 => ({
  padding: a0
});
const _c2 = a0 => ({
  zoneData: a0,
  isFirstZone: false
});
function DXPageCustomLayoutComponent_div_0_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainer"](0);
  }
}
function DXPageCustomLayoutComponent_div_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](1, DXPageCustomLayoutComponent_div_0_ng_container_1_Template, 1, 0, "ng-container", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    const renderZone_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵreference"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngStyle", ctx_r0.wrapperStyles);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngTemplateOutlet", renderZone_r2)("ngTemplateOutletContext", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpureFunction1"](3, _c0, ctx_r0.trackedZoneData));
  }
}
function DXPageCustomLayoutComponent_ng_template_1_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](1, "mag-dxpages-content-item", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const item_r3 = ctx.$implicit;
    const zoneData_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]().zoneData;
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("headline", item_r3 == null ? null : item_r3.ContentItemName)("contentType", item_r3 == null ? null : item_r3.ContentType)("dataSources", item_r3 == null ? null : item_r3.DataSources)("thumbnail", item_r3 == null ? null : item_r3.Thumbnail)("fallback", item_r3 == null ? null : item_r3.Fallback)("trackInfo", item_r3 == null ? null : item_r3.extendedTrackInfo)("ngStyle", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpureFunction1"](7, _c1, ctx_r0.getItemPadding(zoneData_r4)));
  }
}
function DXPageCustomLayoutComponent_ng_template_1_ng_container_3_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainer"](0);
  }
}
function DXPageCustomLayoutComponent_ng_template_1_ng_container_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](1, DXPageCustomLayoutComponent_ng_template_1_ng_container_3_ng_container_1_Template, 1, 0, "ng-container", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const child_r5 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"](2);
    const renderZone_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵreference"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngTemplateOutlet", renderZone_r2)("ngTemplateOutletContext", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpureFunction1"](2, _c2, child_r5));
  }
}
function DXPageCustomLayoutComponent_ng_template_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](2, DXPageCustomLayoutComponent_ng_template_1_ng_container_2_Template, 2, 9, "ng-container", 5)(3, DXPageCustomLayoutComponent_ng_template_1_ng_container_3_Template, 2, 4, "ng-container", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const zoneData_r4 = ctx.zoneData;
    const isFirstZone_r6 = ctx.isFirstZone;
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngClass", ctx_r0.getClassNames(zoneData_r4 == null ? null : zoneData_r4.ClassNames, isFirstZone_r6));
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngForOf", zoneData_r4 == null ? null : zoneData_r4.ContentItems);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngForOf", zoneData_r4 == null ? null : zoneData_r4.Children);
  }
}
class DXPageCustomLayoutComponent {
  route;
  dxpComponentService;
  dxpTracking;
  layoutConfig;
  trackInfo;
  utmSource;
  utmMedium;
  trackedZoneData;
  constructor(route, dxpComponentService, dxpTracking) {
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.dxpTracking = dxpTracking;
  }
  ngOnInit() {
    this.trackedZoneData = (0,_dxpage_utils__WEBPACK_IMPORTED_MODULE_2__.prepareTrackingZoneData)(this.layoutConfig, this.trackInfo);
  }
  /**
   * Angular lifecycle hook. Called after a bound input property changes.
   * Trigger page view tracking if the `trackInfo` input property is changed and the page is actived.
   * @param changes The changes object containing the SimpleChange objects.
   */
  ngOnChanges(changes) {
    if (changes['trackInfo']) {
      const latestTrackInfo = changes['trackInfo'].currentValue;
      if (latestTrackInfo?.isActived) {
        this.utmSource = this.route.snapshot.paramMap.get('utm_source');
        this.utmMedium = this.route.snapshot.paramMap.get('utm_medium');
        const trackingPayload = (0,_dxpage_utils__WEBPACK_IMPORTED_MODULE_2__.getDXPagesTrackingPageView)(this.layoutConfig, latestTrackInfo, this.utmSource, this.utmMedium, 'trackDXPagesPageView');
        const {
          eventName,
          payload
        } = trackingPayload || {};
        this.dxpTracking.handlePushDxpTracking(eventName, payload);
      }
    }
  }
  get wrapperStyles() {
    const background = this.layoutConfig.Styles?.Background || {};
    return {
      'background-image': background.Image ? `url(${background.Image})` : '',
      'background-size': background.Size || 'auto',
      'background-repeat': background.Repeat || 'no-repeat',
      'background-position': background.Position || 'center',
      'background-color': background.Color || 'transparent',
      width: '100%',
      'flex-shrink': '0',
      margin: '0 auto',
      display: 'flex',
      'max-width': '1240px',
      padding: ' 4px'
    };
  }
  getItemPadding(zoneData) {
    const gap = Number(zoneData?.Styles?.Gap);
    const hasItems = zoneData?.ContentItems?.length;
    return `${gap && hasItems ? gap / 2 : 12}px`;
  }
  getClassNames(classNames, isParent) {
    return Object.values(classNames).join(' ') + `custom-layout ${isParent ? 'parent-zone' : ''}`;
  }
  static ɵfac = function DXPageCustomLayoutComponent_Factory(t) {
    return new (t || DXPageCustomLayoutComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_tracker_service__WEBPACK_IMPORTED_MODULE_1__.DXPTracker));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: DXPageCustomLayoutComponent,
    selectors: [["dxpage-custom-layout"]],
    inputs: {
      layoutConfig: "layoutConfig",
      trackInfo: "trackInfo"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵNgOnChangesFeature"]],
    decls: 3,
    vars: 1,
    consts: [["renderZone", ""], ["class", "dxpage-custom-layout__wrapper", 3, "ngStyle", 4, "ngIf"], [1, "dxpage-custom-layout__wrapper", 3, "ngStyle"], [4, "ngTemplateOutlet", "ngTemplateOutletContext"], [1, "dxpage-custom-layout__zone", 3, "ngClass"], [4, "ngFor", "ngForOf"], [3, "headline", "contentType", "dataSources", "thumbnail", "fallback", "trackInfo", "ngStyle"]],
    template: function DXPageCustomLayoutComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](0, DXPageCustomLayoutComponent_div_0_Template, 2, 5, "div", 1)(1, DXPageCustomLayoutComponent_ng_template_1_Template, 4, 3, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplateRefExtractor"]);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", ctx.trackedZoneData);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_5__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_5__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_5__.NgTemplateOutlet, _angular_common__WEBPACK_IMPORTED_MODULE_5__.NgStyle],
    styles: [".dxpage-custom-layout__zone[_ngcontent-%COMP%] {\n  height: -moz-fit-content;\n  height: fit-content;\n}\n\n.parent-zone[_ngcontent-%COMP%] {\n  height: -moz-fit-content;\n  height: fit-content;\n  align-items: stretch;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL2R4cGFnZS9jb21wb25lbnQvZHhwYWdlLWN1c3RvbS1sYXlvdXQvZHhwYWdlLWN1c3RvbS1sYXlvdXQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHdCQUFBO0VBQUEsbUJBQUE7QUFDRjs7QUFFQTtFQUNFLHdCQUFBO0VBQUEsbUJBQUE7RUFDQSxvQkFBQTtBQUNGIiwic291cmNlc0NvbnRlbnQiOlsiLmR4cGFnZS1jdXN0b20tbGF5b3V0X196b25lIHtcbiAgaGVpZ2h0OiBmaXQtY29udGVudDtcbn1cblxuLnBhcmVudC16b25lIHtcbiAgaGVpZ2h0OiBmaXQtY29udGVudDtcbiAgYWxpZ24taXRlbXM6IHN0cmV0Y2g7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 91761:
/*!*************************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/component/dxpage-detail-vertical-view/dxpage-detail-vertical-view.ts ***!
  \*************************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageDetailVerticalViewComponent: () => (/* binding */ DXPageDetailVerticalViewComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _dxpage_custom_layout_dxpage_custom_layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../dxpage-custom-layout/dxpage-custom-layout */ 38143);








function DXPageDetailVerticalViewComponent_ng_container_0_dxpage_custom_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "dxpage-custom-layout", 3);
  }
  if (rf & 2) {
    const page_r1 = ctx.$implicit;
    const index_r2 = ctx.index;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpropertyInterpolate1"]("id", "dxpage-vertical-", index_r2 + 1, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("layoutConfig", page_r1.LayoutConfig)("trackInfo", ctx_r2.trackInfoList[index_r2]);
  }
}
function DXPageDetailVerticalViewComponent_ng_container_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](1, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](2, DXPageDetailVerticalViewComponent_ng_container_0_dxpage_custom_layout_2_Template, 1, 4, "dxpage-custom-layout", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.pages);
  }
}
class DXPageDetailVerticalViewComponent {
  route;
  dxpComponentService;
  pages;
  trackInfo;
  activePage;
  layoutConfig;
  trackInfoList = [];
  trackTimeouts = new Map(); // To track timeouts per element
  observer;
  constructor(route, dxpComponentService) {
    this.route = route;
    this.dxpComponentService = dxpComponentService;
  }
  ngAfterViewInit() {
    this.setupIntersectionObserver();
  }
  // Update Tracking payload when srcoll by mag-pagination-control / native scroll.
  ngOnChanges(changes) {
    if (changes.activePage) {
      this.updateTrackInfoList();
    }
  }
  /**
   * Sets up an IntersectionObserver to track scroll-based visibility of `<dxpage-custom-layout>` elements.
   *
   * As the user scrolls:
   * - When at least 10% of a section is visible in the viewport, a 2-second timer starts.
   * - If the section stays visible for the full 2 seconds, it's considered "active":
   *     - `activePage` is updated
   *     - `trackInfoList` is refreshed
   * - If the section scrolls out of view before 2 seconds, the timer is canceled.
   *
   * Example:
   * <dxpage-custom-layout id="dxpage-vertical-1"></dxpage-custom-layout>
   * <dxpage-custom-layout id="dxpage-vertical-2"></dxpage-custom-layout>
   * <dxpage-custom-layout id="dxpage-vertical-3"></dxpage-custom-layout>
   *
   * References :
   * https://developer.mozilla.org/en-US/docs/Web/API/IntersectionObserver
   * https://medium.com/coding-beauty/javascript-intersection-observer-cded4e80a377
   */
  setupIntersectionObserver() {
    this.observer = new IntersectionObserver(this.handleIntersection, {
      threshold: 0.1 // Trigger when 10% of the element is visible in the viewport
    });
    const pageElements = document.querySelectorAll('dxpage-custom-layout');
    pageElements.forEach(element => this.observer.observe(element));
  }
  handleIntersection = entries => {
    entries?.forEach(entry => {
      const index = Number(entry.target.id.split('-')[2]) - 1;
      if (entry.isIntersecting) {
        this.handleElementVisible(index); // Element scrolled into view
      } else {
        this.handleElementNotVisible(index); // Element scrolled out of view
      }
    });
  };
  handleElementVisible(index) {
    const timeoutKey = index;
    const currentPage = index + 1;
    // If scroll by mag-pagination-control, do nothing
    if (this.activePage === currentPage) return;
    const timeout = setTimeout(() => {
      this.activePage = currentPage;
      this.updateTrackInfoList(); // Native scroll update tracking payload
    }, 2000);
    // Store the timeout so it can be cleared if the element goes out of view
    this.trackTimeouts.set(timeoutKey, timeout);
  }
  handleElementNotVisible(index) {
    const timeoutKey = index;
    const existingTimeout = this.trackTimeouts.get(timeoutKey);
    if (existingTimeout) {
      clearTimeout(existingTimeout);
      this.trackTimeouts.delete(timeoutKey);
    }
  }
  updateTrackInfoList() {
    this.trackInfoList = this.pages.map((page, index) => this.getTrackInfo(page, index));
  }
  getTrackInfo(item, index) {
    return {
      ...this.trackInfo,
      isActived: this.activePage === index + 1,
      PageID: item?.Id,
      PageNumber: index + 1
    };
  }
  ngOnDestroy() {
    if (this.observer) {
      this.observer.disconnect();
    }
  }
  static ɵfac = function DXPageDetailVerticalViewComponent_Factory(t) {
    return new (t || DXPageDetailVerticalViewComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__.DxpComponentService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: DXPageDetailVerticalViewComponent,
    selectors: [["dxpage-detail-vertical-view"]],
    inputs: {
      pages: "pages",
      trackInfo: "trackInfo",
      activePage: "activePage"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵNgOnChangesFeature"]],
    decls: 1,
    vars: 1,
    consts: [[4, "ngIf"], [1, "dxpage-vertical-view__wrapper"], [3, "id", "layoutConfig", "trackInfo", 4, "ngFor", "ngForOf"], [3, "id", "layoutConfig", "trackInfo"]],
    template: function DXPageDetailVerticalViewComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](0, DXPageDetailVerticalViewComponent_ng_container_0_Template, 3, 1, "ng-container", 0);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", ctx.pages == null ? null : ctx.pages.length);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf, _dxpage_custom_layout_dxpage_custom_layout__WEBPACK_IMPORTED_MODULE_1__.DXPageCustomLayoutComponent],
    styles: [".dxpage-vertical-view__wrapper[_ngcontent-%COMP%] {\n  min-height: 100vh;\n  display: flex;\n  padding: 0;\n  flex-direction: column;\n  align-items: center;\n  gap: 48px;\n  border: 1px solid var(--mag-color-border-primary, #d8d8d8);\n}\n@media screen and (min-width: 768px) {\n  .dxpage-vertical-view__wrapper[_ngcontent-%COMP%] {\n    padding: 24px 24px 48px 24px;\n  }\n}\n\ndxpage-custom-layout[_ngcontent-%COMP%] {\n  width: 100%;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL2R4cGFnZS9jb21wb25lbnQvZHhwYWdlLWRldGFpbC12ZXJ0aWNhbC12aWV3L2R4cGFnZS1kZXRhaWwtdmVydGljYWwtdmlldy5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNFO0VBQ0UsaUJBQUE7RUFDQSxhQUFBO0VBQ0EsVUFBQTtFQUNBLHNCQUFBO0VBQ0EsbUJBQUE7RUFDQSxTQUFBO0VBQ0EsMERBQUE7QUFBSjtBQUVJO0VBVEY7SUFVSSw0QkFBQTtFQUNKO0FBQ0Y7O0FBR0E7RUFDRSxXQUFBO0FBQUYiLCJzb3VyY2VzQ29udGVudCI6WyIuZHhwYWdlLXZlcnRpY2FsLXZpZXcge1xuICAmX193cmFwcGVyIHtcbiAgICBtaW4taGVpZ2h0OiAxMDB2aDtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIHBhZGRpbmc6IDA7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGdhcDogNDhweDtcbiAgICBib3JkZXI6IDFweCBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLXByaW1hcnksICNkOGQ4ZDgpO1xuXG4gICAgQG1lZGlhIHNjcmVlbiBhbmQgKG1pbi13aWR0aDogNzY4cHgpIHtcbiAgICAgIHBhZGRpbmc6IDI0cHggMjRweCA0OHB4IDI0cHg7XG4gICAgfVxuICB9XG59XG5cbmR4cGFnZS1jdXN0b20tbGF5b3V0IHtcbiAgd2lkdGg6IDEwMCU7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 95008:
/*!*****************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/dxpage-routing.module.ts ***!
  \*****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageRoutingModule: () => (/* binding */ DXPageRoutingModule)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _dxpage_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./dxpage.module */ 1265);
/* harmony import */ var _pages_dxpage_detail_dxpage_detail__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/dxpage-detail/dxpage-detail */ 63898);
/* harmony import */ var _pages_dxpage_list_dxpage_list__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/dxpage-list/dxpage-list */ 59738);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);






const routes = [{
  path: '',
  component: _pages_dxpage_list_dxpage_list__WEBPACK_IMPORTED_MODULE_2__.DXPageListPageComponent
}, {
  path: ':campaign',
  component: _pages_dxpage_detail_dxpage_detail__WEBPACK_IMPORTED_MODULE_1__.DXPageDetailPageComponent
}];
class DXPageRoutingModule {
  static ɵfac = function DXPageRoutingModule_Factory(t) {
    return new (t || DXPageRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineNgModule"]({
    type: DXPageRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_4__.RouterModule.forChild(routes), _dxpage_module__WEBPACK_IMPORTED_MODULE_0__.DXPageModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsetNgModuleScope"](DXPageRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_4__.RouterModule, _dxpage_module__WEBPACK_IMPORTED_MODULE_0__.DXPageModule]
  });
})();

/***/ }),

/***/ 68260:
/*!******************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/dxpage-services.module.ts ***!
  \******************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageServiceModule: () => (/* binding */ DXPageServiceModule)
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
/* harmony import */ var _providers_dxpage_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./providers/dxpage.service */ 11993);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);











class DXPageServiceModule {
  static ɵfac = function DXPageServiceModule_Factory(t) {
    return new (t || DXPageServiceModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineNgModule"]({
    type: DXPageServiceModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineInjector"]({
    providers: [{
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_DXPAGE_API,
      useValue: _app_env__WEBPACK_IMPORTED_MODULE_2__.ENV.EComDXPageAPIURL
    }, {
      provide: _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_DXPAGE_HTTP_CLIENT,
      useFactory: _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_3__.MagEComCoreApiHttpClientFactory,
      deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_8__.HttpHandler, _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_4__.Credential, _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_DXPAGE_API, _environments_environment_service__WEBPACK_IMPORTED_MODULE_5__.EnvironmentService]
    }, _providers_dxpage_service__WEBPACK_IMPORTED_MODULE_6__.DXPageService],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵsetNgModuleScope"](DXPageServiceModule, {
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_10__.IonicModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule]
  });
})();

/***/ }),

/***/ 1265:
/*!*********************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/dxpage.module.ts ***!
  \*********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageModule: () => (/* binding */ DXPageModule)
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
/* harmony import */ var _dxpage_services_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./dxpage-services.module */ 68260);
/* harmony import */ var _component_dxpage_custom_layout_dxpage_custom_layout__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./component/dxpage-custom-layout/dxpage-custom-layout */ 38143);
/* harmony import */ var _component_dxpage_detail_vertical_view_dxpage_detail_vertical_view__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./component/dxpage-detail-vertical-view/dxpage-detail-vertical-view */ 91761);
/* harmony import */ var _pages_dxpage_detail_dxpage_detail__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./pages/dxpage-detail/dxpage-detail */ 63898);
/* harmony import */ var _pages_dxpage_list_dxpage_list__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./pages/dxpage-list/dxpage-list */ 59738);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/core */ 37580);















class DXPageModule {
  static ɵfac = function DXPageModule_Factory(t) {
    return new (t || DXPageModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdefineNgModule"]({
    type: DXPageModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_12__.MomentModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__.HeaderComponentModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__.TranslateModule, _dxpage_services_module__WEBPACK_IMPORTED_MODULE_3__.DXPageServiceModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_8__["ɵɵsetNgModuleScope"](DXPageModule, {
    declarations: [_pages_dxpage_list_dxpage_list__WEBPACK_IMPORTED_MODULE_7__.DXPageListPageComponent, _pages_dxpage_detail_dxpage_detail__WEBPACK_IMPORTED_MODULE_6__.DXPageDetailPageComponent, _component_dxpage_detail_vertical_view_dxpage_detail_vertical_view__WEBPACK_IMPORTED_MODULE_5__.DXPageDetailVerticalViewComponent, _component_dxpage_custom_layout_dxpage_custom_layout__WEBPACK_IMPORTED_MODULE_4__.DXPageCustomLayoutComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_10__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_12__.MomentModule, _rsApp_modules_utils_utils_module__WEBPACK_IMPORTED_MODULE_2__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_13__.RouterModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_0__.HeaderComponentModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_1__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_14__.TranslateModule, _dxpage_services_module__WEBPACK_IMPORTED_MODULE_3__.DXPageServiceModule],
    exports: [_pages_dxpage_list_dxpage_list__WEBPACK_IMPORTED_MODULE_7__.DXPageListPageComponent, _pages_dxpage_detail_dxpage_detail__WEBPACK_IMPORTED_MODULE_6__.DXPageDetailPageComponent, _component_dxpage_detail_vertical_view_dxpage_detail_vertical_view__WEBPACK_IMPORTED_MODULE_5__.DXPageDetailVerticalViewComponent, _component_dxpage_custom_layout_dxpage_custom_layout__WEBPACK_IMPORTED_MODULE_4__.DXPageCustomLayoutComponent]
  });
})();

/***/ }),

/***/ 25276:
/*!********************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/dxpage.utils.ts ***!
  \********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   getDXPagesTrackingPageView: () => (/* binding */ getDXPagesTrackingPageView),
/* harmony export */   getTrackingDyanmicZone: () => (/* binding */ getTrackingDyanmicZone),
/* harmony export */   mapContentItem: () => (/* binding */ mapContentItem),
/* harmony export */   mapDataSource: () => (/* binding */ mapDataSource),
/* harmony export */   mapZone: () => (/* binding */ mapZone),
/* harmony export */   prepareTrackingZoneData: () => (/* binding */ prepareTrackingZoneData)
/* harmony export */ });
//Tracking utils
const mapDataSource = (dataSource, item) => {
  return {
    ItemID: dataSource?.ProductUpc || dataSource?.OfferCode || dataSource?.Url || item?.Fallback || item?.Thumbnail || '',
    ItemName: dataSource?.ProductName?.En || dataSource?.Name || dataSource?.OfferName || '',
    ItemSize: dataSource?.Unit || dataSource?.ApplyLimitByUser || '',
    ItemValue: dataSource?.Price || dataSource?.ShortName || '',
    ItemTemplateID: dataSource?.Template?.Id || ''
  };
};
const mapContentItem = item => {
  return {
    CollectionID: item?.ContentItemId,
    CollectionName: item?.ContentItemName || '',
    CollectionType: item?.ContentType || '',
    TotalItems: item?.DataSources?.length || 0,
    ItemInfo: (item?.DataSources || [])?.map(dataSource => {
      return mapDataSource(dataSource, item);
    })
  };
};
const mapZone = zone => {
  return {
    ZoneID: zone?.UId,
    ZoneName: zone?.Label || '',
    TotalCollections: zone?.ContentItems?.length || 0,
    CollectionInfo: (zone?.ContentItems || [])?.map(item => {
      return mapContentItem(item);
    })
  };
};
const getTrackingDyanmicZone = data => {
  return (data?.Children || [])?.map(zone => {
    return mapZone(zone);
  });
};
const getDXPagesTrackingPageView = (data, trackInfo, utmSource, utmMedium, eventName) => {
  const {
    CampaignId,
    CampaignStartDate,
    CampaignEndDate,
    TotalPages,
    PageID,
    CampaignCode,
    CampaignName,
    PageNumber
  } = trackInfo;
  const dynamicZones = getTrackingDyanmicZone(data);
  return {
    eventName: eventName,
    payload: {
      CampaignId: CampaignId,
      PageNumber: PageNumber,
      CampaignStartDate: CampaignStartDate || '',
      CampaignEndDate: CampaignEndDate || '',
      TotalPages: TotalPages || 0,
      PageID: PageID || '',
      PageInfo: {
        PageVersion: '',
        PageTemplateID: PageID || '',
        TotalZones: data?.Children?.length || 0,
        ZoneInfo: dynamicZones
      },
      // extradata
      CampaignCode: CampaignCode || '',
      CampaignSource: utmSource || '',
      CampaignMedium: utmMedium || '',
      CampaignName: CampaignName || '',
      PreviousPage: document.referrer
    }
  };
};
const prepareTrackingZoneData = (zoneData, trackInfo) => {
  const updatedItems = zoneData.ContentItems?.map(item => ({
    ...item,
    extendedTrackInfo: {
      ...trackInfo,
      ZoneID: zoneData?.UId || '',
      ZoneName: zoneData?.Label || '',
      CollectionID: item?.ContentItemId || '',
      CollectionName: item?.ContentItemName || '',
      CollectionType: item?.ContentType || ''
    }
  })) || [];
  return {
    ...zoneData,
    ContentItems: updatedItems,
    Children: zoneData.Children?.map(child => {
      return prepareTrackingZoneData(child, trackInfo);
    })
  };
};

/***/ }),

/***/ 93315:
/*!***********************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/model/interface.ts ***!
  \***********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ViewMode: () => (/* binding */ ViewMode)
/* harmony export */ });
const ViewMode = {
  VERTICAL: 'VERTICAL',
  HORIZONTAL: 'HORIZONTAL',
  PAGINATION: 'PAGINATION'
};

/***/ }),

/***/ 63898:
/*!*****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/pages/dxpage-detail/dxpage-detail.ts ***!
  \*****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageDetailPageComponent: () => (/* binding */ DXPageDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var _providers_dxpage_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../providers/dxpage.service */ 11993);
/* harmony import */ var _model_interface__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/interface */ 93315);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _component_dxpage_detail_vertical_view_dxpage_detail_vertical_view__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../component/dxpage-detail-vertical-view/dxpage-detail-vertical-view */ 91761);















function DXPageDetailPageComponent_dxpage_detail_vertical_view_18_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "dxpage-detail-vertical-view", 18);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("pages", ctx_r1.campaignDetail == null ? null : ctx_r1.campaignDetail.Pages)("trackInfo", ctx_r1.campaignTrackingInfo)("activePage", ctx_r1.activePage);
  }
}
class DXPageDetailPageComponent {
  router;
  route;
  dxpComponentService;
  dxPagesService;
  campaignDetail;
  campaignName;
  activePage = 1;
  pageList = [];
  viewMode;
  campaignTrackingInfo;
  contentEl;
  constructor(router, route, dxpComponentService, dxPagesService) {
    this.router = router;
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.dxPagesService = dxPagesService;
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const campaign = _this.route.snapshot.paramMap.get('campaign');
      if (campaign) {
        yield _this.setup(campaign);
      }
    })();
  }
  setup(campaignCode) {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (!campaignCode) {
        console.warn('Campaign code not found');
        return;
      }
      try {
        const data = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_7__.firstValueFrom)(_this2.dxPagesService.getCampaign({
          campaignCode
        }));
        _this2.campaignName = data?.Name;
        _this2.setupAdLayout(data?.AdLayout);
        if (_this2.campaignDetail) {
          _this2.setupTrackingInfo(data, _this2.campaignDetail);
        }
      } catch (error) {
        console.warn('Error fetching campaign details:', error);
      }
    })();
  }
  setupAdLayout(adLayout) {
    if (!adLayout) {
      console.warn('No AdLayout found in campaign data');
      return;
    }
    try {
      this.campaignDetail = JSON.parse(adLayout);
      this.campaignDetail.ViewMode = 'VERTICAL';
      this.viewMode = this.campaignDetail?.ViewMode;
      this.pageList = this.campaignDetail?.Pages?.map((_, idx) => idx + 1) || [1];
    } catch (error) {
      console.warn('Error parsing AdLayout JSON:', error);
    }
  }
  setupTrackingInfo(data, adLayout) {
    const {
      Id,
      Code,
      Name,
      StartDate,
      EndDate
    } = data || {};
    const {
      Pages
    } = adLayout || {};
    this.campaignTrackingInfo = {
      CampaignId: Id,
      CampaignCode: Code,
      CampaignName: Name,
      CampaignStartDate: StartDate,
      CampaignEndDate: EndDate,
      TotalPages: Pages?.length,
      viewMode: _model_interface__WEBPACK_IMPORTED_MODULE_3__.ViewMode.VERTICAL
    };
  }
  handleScrollToTop(event) {
    if (this.viewMode !== 'VERTICAL') return;
    const firstPage = document.getElementById(`dxpage-vertical-${1}`);
    if (!firstPage) return;
    const scrollTop = event.detail.scrollTop; // ion-content's scroll position
    const elementTop = firstPage.offsetTop; // distance from ion-content top
    if (scrollTop < elementTop) {
      this.activePage = 1;
    }
  }
  // Handle mag-pagination-control scroll
  handleScroll(event) {
    if (this.viewMode !== _model_interface__WEBPACK_IMPORTED_MODULE_3__.ViewMode.VERTICAL) return;
    const {
      detail
    } = event || {};
    const currentPage = document.getElementById(`dxpage-vertical-${detail}`);
    if (!currentPage) return;
    const yOffset = currentPage.offsetTop - 100;
    this.contentEl.scrollToPoint(0, yOffset, 500);
    this.activePage = detail;
  }
  static ɵfac = function DXPageDetailPageComponent_Factory(t) {
    return new (t || DXPageDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_providers_dxpage_service__WEBPACK_IMPORTED_MODULE_2__.DXPageService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineComponent"]({
    type: DXPageDetailPageComponent,
    selectors: [["dxpage-detail"]],
    viewQuery: function DXPageDetailPageComponent_Query(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵviewQuery"](_ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, 5);
      }
      if (rf & 2) {
        let _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵloadQuery"]()) && (ctx.contentEl = _t.first);
      }
    },
    decls: 20,
    vars: 10,
    consts: [["contentEl", ""], ["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "ion-no-line"], ["slot", "start"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["slot", "end"], ["is-show-preview", "false"], ["scrollEvents", "true", 1, "ion-padding", 3, "ionScroll"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], [1, "dxpage-detail__container"], [1, "dxpage-detail__title"], [1, "dxpage-detail__actions"], [3, "changePage", "pageList", "activePage"], [3, "ngSwitch"], [3, "pages", "trackInfo", "activePage", 4, "ngSwitchCase"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"], [3, "pages", "trackInfo", "activePage"]],
    template: function DXPageDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "widget-layout", 1)(1, "widget-layout", 2)(2, "widget-layout", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar", 4)(5, "ion-buttons", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](6, "ion-back-button", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](7, "ion-buttons", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](8, "mag-icon-cart", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](9, "ion-content", 9, 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵlistener"]("ionScroll", function DXPageDetailPageComponent_Template_ion_content_ionScroll_9_listener($event) {
          _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵresetView"](ctx.handleScrollToTop($event));
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](11, "widget-layout", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](12, "div", 11)(13, "h1", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtext"](14);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](15, "div", 13)(16, "mag-pagination-control", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵlistener"]("changePage", function DXPageDetailPageComponent_Template_mag_pagination_control_changePage_16_listener($event) {
          _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵresetView"](ctx.handleScroll($event));
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementContainerStart"](17, 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplate"](18, DXPageDetailPageComponent_dxpage_detail_vertical_view_18_Template, 1, 3, "dxpage-detail-vertical-view", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](19, "widget-layout", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtextInterpolate"](ctx.campaignName || "Your Ads");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("pageList", ctx.pageList)("activePage", ctx.activePage);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngSwitch", ctx.viewMode);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngSwitchCase", "VERTICAL");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_10__.NgSwitch, _angular_common__WEBPACK_IMPORTED_MODULE_10__.NgSwitchCase, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__.WidgetLayoutComponent, _component_dxpage_detail_vertical_view_dxpage_detail_vertical_view__WEBPACK_IMPORTED_MODULE_5__.DXPageDetailVerticalViewComponent],
    styles: [".dxpage-detail__container[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n}\n.dxpage-detail__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  text-align: left;\n  \n\n  font-family: var(--mag-typography-font-family, Lexend);\n  font-size: var(--mag-typography-display-large-font-size, 32px);\n  font-style: normal;\n  font-weight: var(--mag-typography-display-large-font-weight, 600);\n  line-height: var(--mag-typography-display-large-line-height, 40px); \n\n}\n@media screen and (min-width: 768px) {\n  .dxpage-detail__title[_ngcontent-%COMP%]   h1[_ngcontent-%COMP%] {\n    margin-bottom: 48px;\n  }\n}\n.dxpage-detail__actions[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-250, 20px);\n  width: 100%;\n  display: flex;\n  flex-direction: column;\n  align-items: center;\n  gap: 20px;\n}\n.dxpage-detail__actions[_ngcontent-%COMP%]   mag-pagination-control[_ngcontent-%COMP%] {\n  width: -moz-fit-content;\n  width: fit-content;\n}\n.dxpage-detail__actions[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\n  min-width: -moz-fit-content;\n  min-width: fit-content;\n  height: 24px;\n  display: flex;\n  gap: 10px;\n  background: transparent;\n  border: none;\n  color: #000;\n  font-family: Lexend;\n  font-size: 16px;\n  font-style: normal;\n  font-weight: 400;\n  line-height: 24px; \n\n}\n.dxpage-detail__actions[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  height: 100%;\n}\n@media screen and (min-width: 768px) {\n  .dxpage-detail__actions[_ngcontent-%COMP%] {\n    margin-bottom: 24px;\n    flex-direction: row;\n    justify-content: space-between;\n    align-items: center;\n  }\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL2R4cGFnZS9wYWdlcy9keHBhZ2UtZGV0YWlsL2R4cGFnZS1kZXRhaWwuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDRTtFQUNFLGFBQUE7RUFDQSxzQkFBQTtBQUFKO0FBR0U7RUFDRSw2Q0FBQTtFQUNBLGdCQUFBO0VBQ0EsdUJBQUE7RUFDQSxzREFBQTtFQUNBLDhEQUFBO0VBQ0Esa0JBQUE7RUFDQSxpRUFBQTtFQUNBLGtFQUFBLEVBQUEsU0FBQTtBQURKO0FBR0k7RUFDRTtJQUNFLG1CQUFBO0VBRE47QUFDRjtBQUtFO0VBQ0UsMkNBQUE7RUFDQSxXQUFBO0VBQ0EsYUFBQTtFQUNBLHNCQUFBO0VBQ0EsbUJBQUE7RUFDQSxTQUFBO0FBSEo7QUFLSTtFQUNFLHVCQUFBO0VBQUEsa0JBQUE7QUFITjtBQU1JO0VBQ0UsMkJBQUE7RUFBQSxzQkFBQTtFQUNBLFlBQUE7RUFDQSxhQUFBO0VBQ0EsU0FBQTtFQUNBLHVCQUFBO0VBQ0EsWUFBQTtFQUVBLFdBQUE7RUFDQSxtQkFBQTtFQUNBLGVBQUE7RUFDQSxrQkFBQTtFQUNBLGdCQUFBO0VBQ0EsaUJBQUEsRUFBQSxTQUFBO0FBTE47QUFRSTtFQUNFLFlBQUE7QUFOTjtBQVNJO0VBaENGO0lBaUNJLG1CQUFBO0lBQ0EsbUJBQUE7SUFDQSw4QkFBQTtJQUNBLG1CQUFBO0VBTko7QUFDRiIsInNvdXJjZXNDb250ZW50IjpbIi5keHBhZ2UtZGV0YWlsIHtcbiAgJl9fY29udGFpbmVyIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gIH1cblxuICAmX190aXRsZSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIHRleHQtYWxpZ246IGxlZnQ7XG4gICAgLyogU2tpbi9EaXNwbGF5L0xhcmdlICovXG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCBMZXhlbmQpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGlzcGxheS1sYXJnZS1mb250LXNpemUsIDMycHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGlzcGxheS1sYXJnZS1mb250LXdlaWdodCwgNjAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGlzcGxheS1sYXJnZS1saW5lLWhlaWdodCwgNDBweCk7IC8qIDEyNSUgKi9cblxuICAgIEBtZWRpYSBzY3JlZW4gYW5kIChtaW4td2lkdGg6IDc2OHB4KSB7XG4gICAgICBoMSB7XG4gICAgICAgIG1hcmdpbi1ib3R0b206IDQ4cHg7XG4gICAgICB9XG4gICAgfVxuICB9XG5cbiAgJl9fYWN0aW9ucyB7XG4gICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMjUwLCAyMHB4KTtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBnYXA6IDIwcHg7XG5cbiAgICBtYWctcGFnaW5hdGlvbi1jb250cm9sIHtcbiAgICAgIHdpZHRoOiBmaXQtY29udGVudDtcbiAgICB9XG5cbiAgICBidXR0b24ge1xuICAgICAgbWluLXdpZHRoOiBmaXQtY29udGVudDtcbiAgICAgIGhlaWdodDogMjRweDtcbiAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICBnYXA6IDEwcHg7XG4gICAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcbiAgICAgIGJvcmRlcjogbm9uZTtcblxuICAgICAgY29sb3I6ICMwMDA7XG4gICAgICBmb250LWZhbWlseTogTGV4ZW5kO1xuICAgICAgZm9udC1zaXplOiAxNnB4O1xuICAgICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgICAgZm9udC13ZWlnaHQ6IDQwMDtcbiAgICAgIGxpbmUtaGVpZ2h0OiAyNHB4OyAvKiAxNTAlICovXG4gICAgfVxuXG4gICAgaW9uLWljb24ge1xuICAgICAgaGVpZ2h0OiAxMDAlO1xuICAgIH1cblxuICAgIEBtZWRpYSBzY3JlZW4gYW5kIChtaW4td2lkdGg6IDc2OHB4KSB7XG4gICAgICBtYXJnaW4tYm90dG9tOiAyNHB4O1xuICAgICAgZmxleC1kaXJlY3Rpb246IHJvdztcbiAgICAgIGp1c3RpZnktY29udGVudDogc3BhY2UtYmV0d2VlbjtcbiAgICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgfVxuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 59738:
/*!*************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/pages/dxpage-list/dxpage-list.ts ***!
  \*************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageListPageComponent: () => (/* binding */ DXPageListPageComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);








class DXPageListPageComponent {
  router;
  route;
  dxpComponentService;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_2__.Subject();
  constructor(router, route, dxpComponentService) {
    this.router = router;
    this.route = route;
    this.dxpComponentService = dxpComponentService;
  }
  ionViewWillEnter() {
    this.route.data.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_3__.takeUntil)(this._destroy$)).subscribe(() => {
      // This block will run after both data and queryParams have been processed
    });
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  static ɵfac = function DXPageListPageComponent_Factory(t) {
    return new (t || DXPageListPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_0__.DxpComponentService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({
    type: DXPageListPageComponent,
    selectors: [["dxpage-list"]],
    decls: 13,
    vars: 5,
    consts: [["type", "page", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "ion-no-line"], ["slot", "start"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["slot", "end"], ["is-show-preview", "false"], [1, "ion-padding"], ["type", "page", "zoneName", "Top", 3, "objectId", "slug"], ["type", "page", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function DXPageListPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar", 3)(5, "ion-buttons", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](6, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "ion-buttons", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](8, "mag-icon-cart", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "ion-content", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](10, "widget-layout", 9)(11, "mag-dxpages-list")(12, "widget-layout", 10);
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
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_1__.WidgetLayoutComponent],
    styles: ["/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 11993:
/*!********************************************************************!*\
  !*** ./src/app/modules/ecom-v2/dxpage/providers/dxpage.service.ts ***!
  \********************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPageService: () => (/* binding */ DXPageService)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_gateway_mag_ecom_core_api_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/gateway/mag-ecom-core-api.service */ 31627);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ 70271);
/* harmony import */ var _utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../utils/ecom-api-configs */ 847);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var ionic_cache__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ionic-cache */ 65503);







class DXPageService {
  cache;
  api;
  constructor(cache, api) {
    this.cache = cache;
    this.api = api;
  }
  getCampaign(payload) {
    return this.api.get(`/Campaigns/by-code/${payload?.campaignCode}`).pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_2__.map)(data => {
      return data.Data;
    }));
  }
  static ɵfac = function DXPageService_Factory(t) {
    return new (t || DXPageService)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](ionic_cache__WEBPACK_IMPORTED_MODULE_4__.CacheService), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵinject"](_utils_ecom_api_configs__WEBPACK_IMPORTED_MODULE_1__.MAG_DXPAGE_HTTP_CLIENT));
  };
  static ɵprov = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineInjectable"]({
    token: DXPageService,
    factory: DXPageService.ɵfac
  });
}

/***/ })

}]);
//# sourceMappingURL=src_app_modules_ecom-v2_dxpage_dxpage-routing_module_ts.js.map