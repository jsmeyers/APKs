"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["default-src_app_modules_ecom-v2_product_product-routing_module_ts"],{

/***/ 46318:
/*!*****************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/custom-img/custom-img.ts ***!
  \*****************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CustomImgComponent: () => (/* binding */ CustomImgComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _app_env__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @app/env */ 45312);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ 60316);





const _c0 = (a0, a1, a2) => ({
  container: a0,
  "full-width": a1,
  "full-height": a2
});
const _c1 = () => ({
  height: "100%",
  width: "100%"
});
const _c2 = (a0, a1, a2) => ({
  fit: a0,
  cover: a1,
  contain: a2
});
function CustomImgComponent_ng_container_1_img_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "img", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("load", function CustomImgComponent_ng_container_1_img_1_Template_img_load_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r1.onLoad());
    })("error", function CustomImgComponent_ng_container_1_img_1_Template_img_error_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r1.onError());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles)("hidden", !ctx_r1.loaded)("src", ctx_r1.src, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeUrl"])("alt", ctx_r1.alt)("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](5, _c2, ctx_r1.isFit, ctx_r1.isCover, ctx_r1.isContain));
  }
}
function CustomImgComponent_ng_container_1_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "div", 6);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles);
  }
}
function CustomImgComponent_ng_container_1_img_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "img", 7);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles)("src", ctx_r1.default, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeUrl"])("alt", ctx_r1.alt)("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](4, _c2, ctx_r1.isFit, ctx_r1.isCover, ctx_r1.isContain));
  }
}
function CustomImgComponent_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, CustomImgComponent_ng_container_1_img_1_Template, 1, 9, "img", 2)(2, CustomImgComponent_ng_container_1_div_2_Template, 1, 1, "div", 3)(3, CustomImgComponent_ng_container_1_img_3_Template, 1, 8, "img", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !ctx_r1.error);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", ctx_r1.src && !ctx_r1.loaded && !ctx_r1.error);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !ctx_r1.src || ctx_r1.src && ctx_r1.error);
  }
}
function CustomImgComponent_ng_container_2_img_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "img", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("error", function CustomImgComponent_ng_container_2_img_1_Template_img_error_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r3);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r1.onError());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles)("src", ctx_r1.src, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeUrl"])("alt", ctx_r1.alt)("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](4, _c2, ctx_r1.isFit, ctx_r1.isCover, ctx_r1.isContain));
  }
}
function CustomImgComponent_ng_container_2_img_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "img", 7);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles)("src", ctx_r1.default, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeUrl"])("alt", ctx_r1.alt)("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](4, _c2, ctx_r1.isFit, ctx_r1.isCover, ctx_r1.isContain));
  }
}
function CustomImgComponent_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, CustomImgComponent_ng_container_2_img_1_Template, 1, 8, "img", 8)(2, CustomImgComponent_ng_container_2_img_2_Template, 1, 8, "img", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !ctx_r1.error);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", ctx_r1.default && ctx_r1.error);
  }
}
class CustomImgComponent {
  cd;
  src;
  alt = '';
  styles = {};
  isFit = false;
  objectFit;
  displayDefaultImage = true;
  imgSize;
  default;
  cached;
  loaded;
  error;
  isFullWidth;
  isFullHeight;
  isCover;
  isContain;
  lastSrc;
  originSrc;
  originImgSize;
  constructor(cd) {
    this.cd = cd;
    try {
      this.default = _app_env__WEBPACK_IMPORTED_MODULE_1__.ENV.DefaultImg;
      this.cached = false;
      this.loaded = false;
      this.error = false;
      this.isFullWidth = false;
      this.isFullHeight = false;
    } catch (err) {
      console.error(err);
    }
  }
  ngOnInit() {
    this.cd.detectChanges();
  }
  ngOnChanges() {
    if (this.imgSize && this.originSrc !== this.src) {
      this.originSrc = this.src;
      this.originImgSize = this.imgSize;
      this.src = this.src + `?imgsize=${this.imgSize}`;
    }
    this.isContain = this.objectFit === 'contain';
    this.isCover = this.objectFit === 'cover';
    if (this.src !== this.lastSrc) {
      this.lastSrc = this.src;
      this.loaded = false;
      this.error = false;
      this.cached = this.isCached(this.src);
    }
    if (!this.src) {
      this.error = true;
    }
  }
  onLoad() {
    this.loaded = true;
  }
  onError() {
    if (this.imgSize) {
      setTimeout(() => {
        this.src = this.originSrc;
        this.imgSize = null;
        //Get image origin
        this.ngOnChanges();
        // this.requestResizeImage(src);
      });
    } else {
      this.error = true;
    }
  }
  isCached(url) {
    if (!url) {
      return false;
    }
    const image = new Image();
    image.src = url;
    image.onload = () => {
      // Re-calculate image position
      if (image.width > image.height) {
        this.isFullHeight = true;
      } else if (image.height > image.width) {
        this.isFullWidth = true;
      } else {
        this.isFullHeight = this.isFullWidth = true;
        this.isCover = !this.isContain ? true : false;
      }
    };
    return image.complete;
  }
  requestResizeImage(src) {
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        src = src.replace('get-resized-image', 'resize-image');
        yield fetch(src);
      } catch (error) {
        console.error(error);
      }
    })();
  }
  static ɵfac = function CustomImgComponent_Factory(t) {
    return new (t || CustomImgComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__.ChangeDetectorRef));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: CustomImgComponent,
    selectors: [["custom-img"]],
    inputs: {
      src: "src",
      alt: "alt",
      styles: "styles",
      isFit: "isFit",
      objectFit: "objectFit",
      displayDefaultImage: "displayDefaultImage",
      imgSize: "imgSize"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵNgOnChangesFeature"]],
    decls: 3,
    vars: 9,
    consts: [[3, "ngClass", "ngStyle"], [4, "ngIf"], [3, "ngStyle", "hidden", "src", "alt", "ngClass", "load", "error", 4, "ngIf"], ["class", "img-loading", 3, "ngStyle", 4, "ngIf"], [3, "ngStyle", "src", "alt", "ngClass", 4, "ngIf"], [3, "load", "error", "ngStyle", "hidden", "src", "alt", "ngClass"], [1, "img-loading", 3, "ngStyle"], [3, "ngStyle", "src", "alt", "ngClass"], [3, "ngStyle", "src", "alt", "ngClass", "error", 4, "ngIf"], [3, "error", "ngStyle", "src", "alt", "ngClass"]],
    template: function CustomImgComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, CustomImgComponent_ng_container_1_Template, 4, 3, "ng-container", 1)(2, CustomImgComponent_ng_container_2_Template, 3, 2, "ng-container", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](4, _c0, ctx.isFit || ctx.isCover || ctx.isContain, ctx.isFullWidth, ctx.isFullHeight))("ngStyle", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction0"](8, _c1));
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !ctx.cached);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", ctx.cached);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_3__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_3__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_3__.NgStyle],
    styles: [".container[_ngcontent-%COMP%] {\n  position: relative;\n  height: 100%;\n  width: 100%;\n  text-align: center;\n}\n\nimg[_ngcontent-%COMP%] {\n  max-width: 100%;\n  max-height: 100%;\n}\n\n.container.full-width[_ngcontent-%COMP%]   img.fit[_ngcontent-%COMP%] {\n  max-height: none;\n  width: 100%;\n}\n\n.container.full-height[_ngcontent-%COMP%]   img.fit[_ngcontent-%COMP%] {\n  max-width: none;\n  height: 100%;\n}\n\n.container[_ngcontent-%COMP%]   img.cover.fit[_ngcontent-%COMP%] {\n  height: 100%;\n  width: 100%;\n  object-fit: cover;\n}\n\nimg.cover[_ngcontent-%COMP%] {\n  object-fit: cover;\n}\n\nimg.contain[_ngcontent-%COMP%] {\n  object-fit: contain !important;\n}\n\nimg.fit[_ngcontent-%COMP%], img.cover[_ngcontent-%COMP%] {\n  position: absolute;\n  top: 50%;\n  left: 50%;\n  transform: translate(-50%, -50%);\n}\n\n.img-loading[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  border-radius: 6px;\n  animation: _ngcontent-%COMP%_image-loading 2s infinite;\n  background: linear-gradient(to right, #eff1f3 4%, #e2e2e2 25%, #eff1f3 36%);\n  background-size: 1000px 100%;\n  opacity: 0.8;\n}\n\n@keyframes _ngcontent-%COMP%_image-loading {\n  0% {\n    background-position: -1000px 0;\n  }\n  100% {\n    background-position: 1000px 0;\n  }\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9jdXN0b20taW1nL2N1c3RvbS1pbWcuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGtCQUFBO0VBQ0EsWUFBQTtFQUNBLFdBQUE7RUFDQSxrQkFBQTtBQUNGOztBQUNBO0VBQ0UsZUFBQTtFQUNBLGdCQUFBO0FBRUY7O0FBQUE7RUFDRSxnQkFBQTtFQUNBLFdBQUE7QUFHRjs7QUFBQTtFQUNFLGVBQUE7RUFDQSxZQUFBO0FBR0Y7O0FBQUE7RUFDRSxZQUFBO0VBQ0EsV0FBQTtFQUNBLGlCQUFBO0FBR0Y7O0FBREE7RUFDRSxpQkFBQTtBQUlGOztBQUZBO0VBQ0UsOEJBQUE7QUFLRjs7QUFIQTs7RUFFRSxrQkFBQTtFQUNBLFFBQUE7RUFDQSxTQUFBO0VBQ0EsZ0NBQUE7QUFNRjs7QUFIQTtFQUNFLFdBQUE7RUFDQSxZQUFBO0VBQ0Esa0JBQUE7RUFDQSxvQ0FBQTtFQUNBLDJFQUFBO0VBQ0EsNEJBQUE7RUFDQSxZQUFBO0FBTUY7O0FBSEE7RUFDRTtJQUNFLDhCQUFBO0VBTUY7RUFKQTtJQUNFLDZCQUFBO0VBTUY7QUFDRiIsInNvdXJjZXNDb250ZW50IjpbIi5jb250YWluZXIge1xuICBwb3NpdGlvbjogcmVsYXRpdmU7XG4gIGhlaWdodDogMTAwJTtcbiAgd2lkdGg6IDEwMCU7XG4gIHRleHQtYWxpZ246IGNlbnRlcjtcbn1cbmltZyB7XG4gIG1heC13aWR0aDogMTAwJTtcbiAgbWF4LWhlaWdodDogMTAwJTtcbn1cbi5jb250YWluZXIuZnVsbC13aWR0aCBpbWcuZml0IHtcbiAgbWF4LWhlaWdodDogbm9uZTtcbiAgd2lkdGg6IDEwMCU7XG59XG5cbi5jb250YWluZXIuZnVsbC1oZWlnaHQgaW1nLmZpdCB7XG4gIG1heC13aWR0aDogbm9uZTtcbiAgaGVpZ2h0OiAxMDAlO1xufVxuXG4uY29udGFpbmVyIGltZy5jb3Zlci5maXQge1xuICBoZWlnaHQ6IDEwMCU7XG4gIHdpZHRoOiAxMDAlO1xuICBvYmplY3QtZml0OiBjb3Zlcjtcbn1cbmltZy5jb3ZlciB7XG4gIG9iamVjdC1maXQ6IGNvdmVyO1xufVxuaW1nLmNvbnRhaW4ge1xuICBvYmplY3QtZml0OiBjb250YWluICFpbXBvcnRhbnQ7XG59XG5pbWcuZml0LFxuaW1nLmNvdmVyIHtcbiAgcG9zaXRpb246IGFic29sdXRlO1xuICB0b3A6IDUwJTtcbiAgbGVmdDogNTAlO1xuICB0cmFuc2Zvcm06IHRyYW5zbGF0ZSgtNTAlLCAtNTAlKTtcbn1cblxuLmltZy1sb2FkaW5nIHtcbiAgd2lkdGg6IDEwMCU7XG4gIGhlaWdodDogMTAwJTtcbiAgYm9yZGVyLXJhZGl1czogNnB4O1xuICBhbmltYXRpb246IGltYWdlLWxvYWRpbmcgMnMgaW5maW5pdGU7XG4gIGJhY2tncm91bmQ6IGxpbmVhci1ncmFkaWVudCh0byByaWdodCwgI2VmZjFmMyA0JSwgI2UyZTJlMiAyNSUsICNlZmYxZjMgMzYlKTtcbiAgYmFja2dyb3VuZC1zaXplOiAxMDAwcHggMTAwJTtcbiAgb3BhY2l0eTogMC44O1xufVxuXG5Aa2V5ZnJhbWVzIGltYWdlLWxvYWRpbmcge1xuICAwJSB7XG4gICAgYmFja2dyb3VuZC1wb3NpdGlvbjogLTEwMDBweCAwO1xuICB9XG4gIDEwMCUge1xuICAgIGJhY2tncm91bmQtcG9zaXRpb246IDEwMDBweCAwO1xuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 73418:
/*!***********************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/custom-photos/custom-photos.ts ***!
  \***********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   CustomPhotosComponent: () => (/* binding */ CustomPhotosComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _shared_components_dxp_img_dxp_img_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../../../shared/components/dxp-img/dxp-img.component */ 29499);
/* harmony import */ var _custom_img_custom_img__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../custom-img/custom-img */ 46318);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);






const _c0 = () => ({
  "max-width": "100%"
});
function CustomPhotosComponent_ng_container_0_div_1_ng_container_1_custom_img_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "custom-img", 5);
  }
  if (rf & 2) {
    const photo_r1 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵstyleProp"]("z-index", photo_r1.zIndex);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("src", photo_r1.imageUrl)("isFit", true)("displayDefaultImage", false)("styles", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpureFunction0"](6, _c0));
  }
}
function CustomPhotosComponent_ng_container_0_div_1_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](1, CustomPhotosComponent_ng_container_0_div_1_ng_container_1_custom_img_1_Template, 1, 7, "custom-img", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const photos_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"](2).ngIf;
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngForOf", photos_r2);
  }
}
function CustomPhotosComponent_ng_container_0_div_1_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](1, "dxp-img", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵstyleProp"]("z-index", 999);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("src", ctx_r2.imageRenderedUrl)("isFit", true)("displayDefaultImage", false)("styles", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpureFunction0"](6, _c0));
  }
}
function CustomPhotosComponent_ng_container_0_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](1, CustomPhotosComponent_ng_container_0_div_1_ng_container_1_Template, 2, 1, "ng-container", 0)(2, CustomPhotosComponent_ng_container_0_div_1_ng_container_2_Template, 2, 7, "ng-container", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const photos_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]().ngIf;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", (photos_r2 == null ? null : photos_r2.length) > 0 && !ctx_r2.imageRenderedUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", (photos_r2 == null ? null : photos_r2.length) === 0 && ctx_r2.imageRenderedUrl);
  }
}
function CustomPhotosComponent_ng_container_0_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](0, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](1, "safeHtml");
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](1, 1, ctx_r2.magImg), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵsanitizeHtml"]);
  }
}
function CustomPhotosComponent_ng_container_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](1, CustomPhotosComponent_ng_container_0_div_1_Template, 3, 2, "div", 1)(2, CustomPhotosComponent_ng_container_0_div_2_Template, 2, 3, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const photos_r2 = ctx.ngIf;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", (photos_r2 == null ? null : photos_r2.length) > 0 || ctx_r2.imageRenderedUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", (photos_r2 == null ? null : photos_r2.length) === 0 && !ctx_r2.imageRenderedUrl);
  }
}
class CustomPhotosComponent {
  photos$;
  imageRenderedUrl;
  magImg = `<mag-img src></mag-img>`;
  static ɵfac = function CustomPhotosComponent_Factory(t) {
    return new (t || CustomPhotosComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({
    type: CustomPhotosComponent,
    selectors: [["custom-photos"]],
    inputs: {
      photos$: "photos$",
      imageRenderedUrl: "imageRenderedUrl"
    },
    decls: 2,
    vars: 3,
    consts: [[4, "ngIf"], ["class", "photo-container", 4, "ngIf"], ["class", "default-img", 3, "innerHTML", 4, "ngIf"], [1, "photo-container"], ["class", "photo", "objectFit", "contain", "imgSize", "height_450", 3, "src", "isFit", "displayDefaultImage", "styles", "zIndex", 4, "ngFor", "ngForOf"], ["objectFit", "contain", "imgSize", "height_450", 1, "photo", 3, "src", "isFit", "displayDefaultImage", "styles"], [1, "default-img", 3, "innerHTML"]],
    template: function CustomPhotosComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](0, CustomPhotosComponent_ng_container_0_Template, 3, 2, "ng-container", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipe"](1, "async");
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpipeBind1"](1, 1, ctx.photos$));
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf, _shared_components_dxp_img_dxp_img_component__WEBPACK_IMPORTED_MODULE_0__.DXPImageComponent, _custom_img_custom_img__WEBPACK_IMPORTED_MODULE_1__.CustomImgComponent, _angular_common__WEBPACK_IMPORTED_MODULE_4__.AsyncPipe, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_2__.SafeHtmlPipe],
    styles: [".photo-container[_ngcontent-%COMP%] {\n  padding: 0 10px 10px;\n  margin-bottom: 10px;\n  position: relative;\n  height: 30vh;\n  min-height: 190px;\n}\n.photo-container[_ngcontent-%COMP%]   .photo[_ngcontent-%COMP%] {\n  height: 100%;\n  width: 100%;\n  display: block;\n  overflow: hidden;\n  position: absolute;\n  top: 0;\n  left: 0;\n  animation: _ngcontent-%COMP%_fadeIn 1s;\n}\n@keyframes _ngcontent-%COMP%_fadeIn {\n  from {\n    opacity: 0;\n  }\n  to {\n    opacity: 1;\n  }\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9jdXN0b20tcGhvdG9zL2N1c3RvbS1waG90b3Muc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLG9CQUFBO0VBQ0EsbUJBQUE7RUFDQSxrQkFBQTtFQUNBLFlBQUE7RUFDQSxpQkFBQTtBQUNGO0FBQUU7RUFDRSxZQUFBO0VBQ0EsV0FBQTtFQUNBLGNBQUE7RUFDQSxnQkFBQTtFQUNBLGtCQUFBO0VBQ0EsTUFBQTtFQUNBLE9BQUE7RUFFQSxvQkFBQTtBQUVKO0FBVUE7RUFDRTtJQUNFLFVBQUE7RUFDRjtFQUNBO0lBQ0UsVUFBQTtFQUNGO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyIucGhvdG8tY29udGFpbmVyIHtcbiAgcGFkZGluZzogMCAxMHB4IDEwcHg7XG4gIG1hcmdpbi1ib3R0b206IDEwcHg7XG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcbiAgaGVpZ2h0OiAzMHZoO1xuICBtaW4taGVpZ2h0OiAxOTBweDtcbiAgLnBob3RvIHtcbiAgICBoZWlnaHQ6IDEwMCU7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgZGlzcGxheTogYmxvY2s7XG4gICAgb3ZlcmZsb3c6IGhpZGRlbjtcbiAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgdG9wOiAwO1xuICAgIGxlZnQ6IDA7XG4gICAgLXdlYmtpdC1hbmltYXRpb246IGZhZGVJbiAxcztcbiAgICBhbmltYXRpb246IGZhZGVJbiAxcztcbiAgfVxufVxuXG5ALXdlYmtpdC1rZXlmcmFtZXMgZmFkZUluIHtcbiAgZnJvbSB7XG4gICAgb3BhY2l0eTogMDtcbiAgfVxuICB0byB7XG4gICAgb3BhY2l0eTogMTtcbiAgfVxufVxuQGtleWZyYW1lcyBmYWRlSW4ge1xuICBmcm9tIHtcbiAgICBvcGFjaXR5OiAwO1xuICB9XG4gIHRvIHtcbiAgICBvcGFjaXR5OiAxO1xuICB9XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 84742:
/*!*******************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/gift-card-options-modal/gift-card-options-modal.ts ***!
  \*******************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   GiftCardOptionsModalComponent: () => (/* binding */ GiftCardOptionsModalComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _providers_product_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../providers/product.service */ 13487);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 75797);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _model_util__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/util */ 38372);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/forms */ 34456);















const _c0 = a0 => ({
  "gift-card-modal__styles-img": true,
  selected: a0
});
const _c1 = a0 => ({
  "gift-card-modal__amount-item": true,
  selected: a0
});
const _c2 = a0 => ({
  "gift-card-modal__amount-quantity--disable": a0
});
function GiftCardOptionsModalComponent_ng_container_8_div_5_swiper_slide_2_div_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function GiftCardOptionsModalComponent_ng_container_8_div_5_swiper_slide_2_div_1_Template_div_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r1);
      const style_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r2.handleChangeOption(style_r2));
    })("keydown", function GiftCardOptionsModalComponent_ng_container_8_div_5_swiper_slide_2_div_1_Template_div_keydown_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r1);
      const style_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r2.handleChangeOption(style_r2));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "img", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const style_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpureFunction1"](2, _c0, (ctx_r2.giftCardStyles == null ? null : ctx_r2.giftCardStyles.SelectedOptionValue) === style_r2.Id));
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("src", style_r2.IconUrl, _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsanitizeUrl"]);
  }
}
function GiftCardOptionsModalComponent_ng_container_8_div_5_swiper_slide_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "swiper-slide");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, GiftCardOptionsModalComponent_ng_container_8_div_5_swiper_slide_2_div_1_Template, 2, 4, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const style_r2 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", style_r2);
  }
}
function GiftCardOptionsModalComponent_ng_container_8_div_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 17)(1, "swiper-container", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](2, GiftCardOptionsModalComponent_ng_container_8_div_5_swiper_slide_2_Template, 2, 1, "swiper-slide", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("slidesPerView", 2.25)("spaceBetween", 12)("ally", false);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngForOf", ctx_r2.giftCardStyles.Options);
  }
}
function GiftCardOptionsModalComponent_ng_container_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](1, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](5, GiftCardOptionsModalComponent_ng_container_8_div_5_Template, 3, 4, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](ctx_r2.giftCardStyles.Name);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"]((ctx_r2.giftCardStyles == null ? null : ctx_r2.giftCardStyles.IsRequired) ? "Required" : "Optional");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx_r2.giftCardStyles == null ? null : ctx_r2.giftCardStyles.Options);
  }
}
function GiftCardOptionsModalComponent_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "div", 23);
  }
}
function GiftCardOptionsModalComponent_ng_container_10_ion_button_6_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "ion-button", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function GiftCardOptionsModalComponent_ng_container_10_ion_button_6_Template_ion_button_click_0_listener() {
      const amount_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r4).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r2.handleChangeOption(amount_r5));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const amount_r5 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpureFunction1"](2, _c1, ctx_r2.giftCardAmounts.SelectedOptionValue === amount_r5.Id));
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](amount_r5.DisplayName.En || amount_r5.Name);
  }
}
function GiftCardOptionsModalComponent_ng_container_10_div_7_Template(rf, ctx) {
  if (rf & 1) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 29)(1, "button", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function GiftCardOptionsModalComponent_ng_container_10_div_7_Template_button_click_1_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r6);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r2.handleChangeOtherAmount(false, ctx_r2.giftCardAmounts));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](2, "ion-icon", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "div", 31)(4, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](6, "button", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function GiftCardOptionsModalComponent_ng_container_10_div_7_Template_button_click_6_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r6);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r2.handleChangeOtherAmount(true, ctx_r2.giftCardAmounts));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](7, "ion-icon", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpureFunction1"](3, _c2, ctx_r2.isAmountMinimum));
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate1"]("$ ", ctx_r2.amountOtherValue, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpureFunction1"](5, _c2, ctx_r2.isAmountMaximum));
  }
}
function GiftCardOptionsModalComponent_ng_container_10_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 33)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](3, "currency");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](4, "currency");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate5"](" Between", " ", "", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind4"](3, 5, ctx_r2.min, "USD", "symbol", "1.2-2"), "", " ", "and", " ", " ", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind4"](4, 10, ctx_r2.max, "USD", "symbol", "1.2-2"), " ");
  }
}
function GiftCardOptionsModalComponent_ng_container_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](1, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](5, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](6, GiftCardOptionsModalComponent_ng_container_10_ion_button_6_Template, 3, 4, "ion-button", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](7, GiftCardOptionsModalComponent_ng_container_10_div_7_Template, 8, 7, "div", 26)(8, GiftCardOptionsModalComponent_ng_container_10_div_8_Template, 5, 15, "div", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](ctx_r2.giftCardAmounts.Name);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"]((ctx_r2.giftCardAmounts == null ? null : ctx_r2.giftCardAmounts.IsRequired) ? "Required" : "Optional");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngForOf", ctx_r2.giftCardAmounts.Options);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx_r2.isOtherAmount);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx_r2.isOtherAmount);
  }
}
function GiftCardOptionsModalComponent_div_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](0, "div", 23);
  }
}
function GiftCardOptionsModalComponent_ng_container_12_Template(rf, ctx) {
  if (rf & 1) {
    const _r7 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](1, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](5, "textarea", 34);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("ngModelChange", function GiftCardOptionsModalComponent_ng_container_12_Template_textarea_ngModelChange_5_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r7);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r2.hanldeChangeMesage($event, ctx_r2.giftCardMessage));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](6, "div", 35)(7, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](8, " Maximum of 50 characters ");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](ctx_r2.giftCardMessage.Name);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"]((ctx_r2.giftCardMessage == null ? null : ctx_r2.giftCardMessage.IsRequired) ? "Required" : "Optional");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngModel", ctx_r2.giftCardMessage == null ? null : ctx_r2.giftCardMessage.SelectedOptionValue);
  }
}
class GiftCardOptionsModalComponent {
  modalCtrl;
  productService;
  dxpComponentService;
  utils;
  giftCardOptions;
  selectedOptionSets;
  productName;
  shoppingMode;
  isInstoreOnly = false;
  IsOutOfStock = false;
  rawProduct;
  storeCode;
  productId;
  isEdit;
  cartItemId;
  handleCloseModal = new _angular_core__WEBPACK_IMPORTED_MODULE_5__.EventEmitter();
  magQuanityBtn;
  giftCardStyles;
  giftCardAmounts;
  giftCardMessage;
  amountOtherValue;
  totalVal;
  isOtherAmount = false;
  isOtherAmountInitialized = false;
  isAmountMaximum = false;
  isAmountMinimum = true;
  max;
  min;
  btnMode = 'MODAL';
  submitOptions = [];
  allOptionSetsWithSelectedValue = [];
  renderOptionSets = [];
  //ToDo: hard code for now
  gapAmount = 5;
  optionSetList = ['giftCardStyles', 'giftCardAmounts', 'giftCardMessage'];
  seletedOptions$ = new rxjs__WEBPACK_IMPORTED_MODULE_6__.BehaviorSubject([]);
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_7__.Subject();
  constructor(modalCtrl, productService, dxpComponentService, utils) {
    this.modalCtrl = modalCtrl;
    this.productService = productService;
    this.dxpComponentService = dxpComponentService;
    this.utils = utils;
  }
  // Lifecycle hooks
  ngOnInit() {
    this.subscribeToSelectedOptions();
    this.allOptionSetsWithSelectedValue = (0,_model_util__WEBPACK_IMPORTED_MODULE_3__.formatGiftCard)((0,lodash__WEBPACK_IMPORTED_MODULE_4__.cloneDeep)(this.giftCardOptions), this.isEdit, this.selectedOptionSets);
    this.prepareRenderOptionSets((0,lodash__WEBPACK_IMPORTED_MODULE_4__.cloneDeep)(this.allOptionSetsWithSelectedValue));
    window.addEventListener('actionSuccess', event => this.handleActionSuccess(event));
  }
  subscribeToSelectedOptions() {
    this.seletedOptions$.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_8__.takeUntil)(this._destroy$)).subscribe(options => {
      if (options?.length) {
        this.optionSetList.forEach(option => {
          this[option] = (0,_model_util__WEBPACK_IMPORTED_MODULE_3__.getOptionsByType)((0,_model_util__WEBPACK_IMPORTED_MODULE_3__.flattenOptionSets)(options), option);
        });
        this.selectCustomValueOption();
        this.totalVal = this.isOtherAmountInitialized && this.getTotalPrice(this.giftCardAmounts, this.isOtherAmount, this.amountOtherValue);
        this.transformDataForSubmit(options);
      }
    });
  }
  prepareRenderOptionSets(selectedOptionSets) {
    const rs = selectedOptionSets?.filter(optionSet => (0,_model_util__WEBPACK_IMPORTED_MODULE_3__.checkOptionSetToDisplay)(optionSet, selectedOptionSets));
    this.seletedOptions$.next(rs);
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
    this.isEdit = false;
    this.isOtherAmountInitialized = false;
    window.removeEventListener('actionSuccess', event => this.handleActionSuccess(event));
  }
  handleActionSuccess(event) {
    if (event?.detail) {
      this.closeModal();
    }
  }
  getTotalPrice(optionSet, isOtherAmount, amountOtherValue) {
    if (isOtherAmount) {
      return amountOtherValue;
    }
    return optionSet?.Options?.find(option => option?.Code === optionSet?.SelectedOptionValue)?.PriceModifier;
  }
  setupOtherAmount() {
    if (this.isOtherAmountInitialized) return;
    const defaultPrice = this.giftCardAmounts?.Options[0]?.PriceModifier ?? 0;
    this.min = defaultPrice;
    this.max = 1000;
    if (this.isEdit) {
      const customValue = Number(this.giftCardAmounts?.CustumOptionValue);
      this.isOtherAmount = !isNaN(customValue);
      this.amountOtherValue = customValue || defaultPrice;
    } else {
      this.amountOtherValue = defaultPrice;
    }
    this.isOtherAmountInitialized = true;
  }
  transformDataForSubmit(optionSets) {
    const submitOptionSetsForGiftCard = (0,_model_util__WEBPACK_IMPORTED_MODULE_3__.getSubmitOptionSetsForGiftCard)((0,lodash__WEBPACK_IMPORTED_MODULE_4__.cloneDeep)(optionSets));
    const submitOptionSets = submitOptionSetsForGiftCard?.map(optionSets => (0,_model_util__WEBPACK_IMPORTED_MODULE_3__.formatSubmitGiftCardOptionSet)(optionSets));
    if (submitOptionSets?.length) {
      this.submitOptions = submitOptionSets;
    }
  }
  selectCustomValueOption() {
    if (!this.giftCardAmounts || !this.giftCardAmounts.Options) return;
    const customValueOption = this.giftCardAmounts.Options.find(option => this.giftCardAmounts.SelectedOptionValue === option.Id);
    if (customValueOption && customValueOption?.Tags?.includes('customvalue')) {
      this.isOtherAmount = true;
      this.isAmountMaximum = false;
      this.isAmountMinimum = true;
      this.setupOtherAmount();
    }
  }
  handleChangeOption(option) {
    this.isOtherAmount = option?.Tags?.includes('customvalue');
    if (this.isOtherAmount) {
      this.isAmountMaximum = false;
      this.isAmountMinimum = true;
    }
    this.allOptionSetsWithSelectedValue = this.updateSelectedValue(this.allOptionSetsWithSelectedValue, option, 'ParentId');
    this.prepareRenderOptionSets(this.allOptionSetsWithSelectedValue);
    this.selectCustomValueOption();
  }
  updateSelectedValue(giftCardOptions, option, keyCompare) {
    return giftCardOptions?.map(giftCardOption => {
      if (giftCardOption.Id === option[keyCompare]) {
        if (this.amountOtherValue) {
          return {
            ...giftCardOption,
            SelectedOptionValue: option.Id,
            CustumOptionValue: String(this.amountOtherValue)
          };
        }
        return {
          ...giftCardOption,
          SelectedOptionValue: option.Id
        };
      } else {
        return {
          ...giftCardOption,
          OptionSets: this.updateSelectedValue(giftCardOption?.OptionSets, option, keyCompare)
        };
      }
    });
  }
  updateCustomValue(optionSets, option, keyCompare, updateValue) {
    return optionSets.map(optionSet => {
      if (optionSet?.IsParent) {
        const optionSets = this.updateCustomValue(optionSet?.OptionSets, option, keyCompare, updateValue);
        if (optionSets) {
          return {
            ...optionSet,
            OptionSets: optionSets
          };
        }
        return {
          ...optionSet
        };
      } else if (optionSet[keyCompare] === option[keyCompare]) {
        const options = {
          ...optionSet,
          ...updateValue
        };
        return options;
      }
      return optionSet;
    });
  }
  handleChangeOtherAmount(isIncrease, amountObj) {
    if (!this.gapAmount) return;
    if (isIncrease && this.amountOtherValue + this.gapAmount <= this.max) {
      this.amountOtherValue += this.gapAmount;
    }
    if (!isIncrease && this.amountOtherValue - this.gapAmount >= this.min) {
      this.amountOtherValue -= this.gapAmount;
    }
    this.isAmountMaximum = this.amountOtherValue + this.gapAmount > this.max;
    this.isAmountMinimum = this.amountOtherValue - this.gapAmount < this.min;
    // const updatedOptionSet = this.allOptionSetsWithSelectedValue.find((optionSet) => optionSet.Code === amountObj.Code);
    // updatedOptionSet.CustumOptionValue = String(this.amountOtherValue);
    const updateValue = {
      CustumOptionValue: String(this.amountOtherValue)
    };
    this.allOptionSetsWithSelectedValue = this.updateCustomValue(this.allOptionSetsWithSelectedValue, amountObj, 'Code', updateValue);
    this.prepareRenderOptionSets(this.allOptionSetsWithSelectedValue);
  }
  hanldeChangeMesage(message, messageObj) {
    // const updatedOptionSet = this.allOptionSetsWithSelectedValue.find((optionSet) => optionSet.Code === messageObj.Code);
    // updatedOptionSet.SelectedOptionValue = message;
    const updateValue = {
      SelectedOptionValue: message
    };
    this.allOptionSetsWithSelectedValue = this.updateCustomValue(this.allOptionSetsWithSelectedValue, messageObj, 'Code', updateValue);
    this.prepareRenderOptionSets(this.allOptionSetsWithSelectedValue);
  }
  // Modal functions
  closeModal() {
    return this.modalCtrl.dismiss();
  }
  static ɵfac = function GiftCardOptionsModalComponent_Factory(t) {
    return new (t || GiftCardOptionsModalComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_9__.ModalController), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_providers_product_service__WEBPACK_IMPORTED_MODULE_0__.ProductService), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_1__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_2__.Utils));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: GiftCardOptionsModalComponent,
    selectors: [["gift-card-options-modal"]],
    inputs: {
      giftCardOptions: "giftCardOptions",
      selectedOptionSets: "selectedOptionSets",
      productName: "productName",
      shoppingMode: "shoppingMode",
      isInstoreOnly: "isInstoreOnly",
      IsOutOfStock: "IsOutOfStock",
      rawProduct: "rawProduct",
      storeCode: "storeCode",
      productId: "productId",
      isEdit: "isEdit",
      cartItemId: "cartItemId"
    },
    outputs: {
      handleCloseModal: "handleCloseModal"
    },
    decls: 23,
    vars: 18,
    consts: [[1, "gift-card-modal__header"], ["fill", "clear", 1, "gift-card-modal__close-btn", 3, "click"], ["slot", "end", "src", "assets/icon/close-modal-ico.svg", "alt", "Close Modal"], [1, "gift-card-modal__title"], [1, "gift-card-modal__content"], [1, "gift-card-modal__option"], [4, "ngIf"], ["class", "gift-card-modal__option-line", 4, "ngIf"], [1, "gift-card-modal__toolbar"], [1, "gift-card-modal__total-price"], [1, "gift-card-modal__total-price-text"], [1, "gift-card-modal__total-price-value"], [1, "btn-add"], [3, "buttonViewMode", "selectedOptions", "product", "isEditOption", "productOptionInCartId", "isFullWidth"], [1, "gift-card-modal__option-title"], [1, "gift-card-modal__option-condition"], ["class", "gift-card-modal__styles", 4, "ngIf"], [1, "gift-card-modal__styles"], [3, "slidesPerView", "spaceBetween", "ally"], [4, "ngFor", "ngForOf"], ["tabindex", "0", 3, "ngClass", "click", "keydown", 4, "ngIf"], ["tabindex", "0", 3, "click", "keydown", "ngClass"], ["alt", "Gift Card Style", 3, "src"], [1, "gift-card-modal__option-line"], [1, "gift-card-modal__amount"], [3, "ngClass", "click", 4, "ngFor", "ngForOf"], ["class", "gift-card-modal__amount-quantity", 4, "ngIf"], ["class", "gift-card-modal__amount-condition", 4, "ngIf"], [3, "click", "ngClass"], [1, "gift-card-modal__amount-quantity"], ["name", "remove-outline"], [1, "gift-card-modal__amount-quantity--quantity"], ["name", "add-outline"], [1, "gift-card-modal__amount-condition"], ["placeholder", "Add a personal message to the recipient", "maxlength", "50", 1, "gift-card-modal__message", 3, "ngModelChange", "ngModel"], [1, "gift-card-modal__message-condition"]],
    template: function GiftCardOptionsModalComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "ion-header", 0)(1, "ion-button", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function GiftCardOptionsModalComponent_Template_ion_button_click_1_listener() {
          return ctx.closeModal();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](2, "ion-img", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](5, "ion-content")(6, "div", 4)(7, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](8, GiftCardOptionsModalComponent_ng_container_8_Template, 6, 3, "ng-container", 6)(9, GiftCardOptionsModalComponent_div_9_Template, 1, 0, "div", 7)(10, GiftCardOptionsModalComponent_ng_container_10_Template, 9, 5, "ng-container", 6)(11, GiftCardOptionsModalComponent_div_11_Template, 1, 0, "div", 7)(12, GiftCardOptionsModalComponent_ng_container_12_Template, 9, 3, "ng-container", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](13, "ion-footer")(14, "ion-toolbar", 8)(15, "div", 9)(16, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](17, "Total");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](18, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](20, "currency");
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](21, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](22, "mag-product-cta", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](ctx.productName);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.giftCardStyles);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.giftCardAmounts || ctx.giftCardMessage);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.giftCardAmounts);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.giftCardMessage);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", ctx.giftCardMessage);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind4"](20, 13, ctx.totalVal, "USD", "symbol", "1.2-2"));
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("buttonViewMode", ctx.btnMode)("selectedOptions", ctx.submitOptions)("product", ctx.rawProduct)("isEditOption", ctx.isEdit)("productOptionInCartId", ctx.cartItemId)("isFullWidth", true);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_10__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_10__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_10__.NgIf, _angular_forms__WEBPACK_IMPORTED_MODULE_11__.DefaultValueAccessor, _angular_forms__WEBPACK_IMPORTED_MODULE_11__.NgControlStatus, _angular_forms__WEBPACK_IMPORTED_MODULE_11__.MaxLengthValidator, _angular_forms__WEBPACK_IMPORTED_MODULE_11__.NgModel, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonFooter, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonToolbar, _angular_common__WEBPACK_IMPORTED_MODULE_10__.CurrencyPipe],
    styles: [".gift-card-modal__header[_ngcontent-%COMP%] {\n  padding-left: 16px !important;\n  padding-right: 16px !important;\n}\n.gift-card-modal__header[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  padding: 0;\n}\n.gift-card-modal__close-btn[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: flex-end;\n  align-items: center;\n  margin: 0;\n  padding-top: 16px;\n  padding-bottom: 16px;\n}\n.gift-card-modal__close-btn[_ngcontent-%COMP%]   ion-img[_ngcontent-%COMP%] {\n  margin-left: auto;\n}\n.gift-card-modal__title[_ngcontent-%COMP%] {\n  font-weight: 600;\n  font-size: 18px;\n  line-height: 28px;\n  padding-bottom: 16px;\n}\n.gift-card-modal__content[_ngcontent-%COMP%] {\n  padding: 24px 16px;\n}\n.gift-card-modal__option-title[_ngcontent-%COMP%] {\n  font-size: 16px;\n  line-height: 24px;\n  font-weight: 500;\n}\n.gift-card-modal__option-condition[_ngcontent-%COMP%] {\n  font-size: 12px;\n  line-height: 16px;\n  color: #647281;\n  margin-bottom: 16px;\n}\n.gift-card-modal__styles-img[_ngcontent-%COMP%] {\n  width: 140px;\n  height: 78px;\n  border: 2px solid #d8d8d8;\n  border-radius: 8px;\n  display: grid;\n  place-items: center;\n}\n.gift-card-modal__styles-img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 90px;\n  object-fit: contain;\n}\n.gift-card-modal__amount[_ngcontent-%COMP%] {\n  display: grid;\n  grid-template-columns: 1fr 1fr;\n  gap: 12px;\n}\n.gift-card-modal__amount-item[_ngcontent-%COMP%] {\n  --background: transparent;\n  --background-activated: transparent;\n  height: 48px;\n  border: 2px solid #d8d8d8;\n  border-radius: 8px;\n  font-size: 16;\n  font-weight: 500;\n  color: #121212;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n.gift-card-modal__amount-quantity[_ngcontent-%COMP%] {\n  position: relative;\n  height: 48px;\n  display: flex;\n  justify-content: space-around;\n  align-items: center;\n  border-radius: 50px;\n  border: 2px solid var(--mag-border);\n  font-size: 14px;\n  font-weight: 500;\n  color: #121212;\n  padding: 10px 0;\n  margin-top: 28px;\n  margin-bottom: 8px;\n}\n.gift-card-modal__amount-quantity--disable[_ngcontent-%COMP%] {\n  opacity: 0.5;\n}\n.gift-card-modal__amount-quantity[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  color: #121212;\n  font-size: 22px;\n}\n.gift-card-modal__amount-quantity--quantity[_ngcontent-%COMP%] {\n  text-align: center;\n}\n.gift-card-modal__amount-quantity--quantity[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\n  display: block;\n  font-size: 14px;\n}\n.gift-card-modal__amount-condition[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: center;\n  margin-top: 8px;\n  font-size: 12px;\n  line-height: 16px;\n  color: #647281;\n}\n.gift-card-modal__message[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 150px;\n  padding: 16px;\n  font-size: 16px;\n  line-height: 24px;\n  border: 1px solid var(--mag-border);\n  border-radius: 8px;\n}\n.gift-card-modal__message-condition[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  justify-content: flex-end;\n  margin-top: 8px;\n}\n.gift-card-modal__option-line[_ngcontent-%COMP%] {\n  width: 100%;\n  border-bottom: 1px solid #eeeeee;\n  margin-top: 32px;\n  margin-bottom: 32px;\n}\n.gift-card-modal__total-price[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n  align-items: center;\n  font-size: 18px;\n  line-height: 28px;\n  font-weight: 600;\n  margin-bottom: 16px;\n}\n.gift-card-modal__toolbar[_ngcontent-%COMP%] {\n  padding: 0 !important;\n  --background: transparent;\n  --padding-top: 16px;\n  --padding-bottom: 16px;\n  --padding-end: 16px;\n  --padding-start: 16px;\n}\n.gift-card-modal__submit-btn[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n}\n.gift-card-modal__submit-btn[_ngcontent-%COMP%]::part(native) {\n  height: 48px;\n}\n\nswiper-slide[_ngcontent-%COMP%] {\n  margin-right: 12px;\n  width: 140px !important;\n}\n\nion-content[_ngcontent-%COMP%] {\n  border-top: 1px solid var(--mag-border);\n}\n\n.selected[_ngcontent-%COMP%] {\n  border-color: var(--mag-brand-foundation-primary, #008000);\n}\n\nbutton[_ngcontent-%COMP%] {\n  border: none;\n  background: none;\n}\nbutton[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  font-size: 16px;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9naWZ0LWNhcmQtb3B0aW9ucy1tb2RhbC9naWZ0LWNhcmQtb3B0aW9ucy1tb2RhbC5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNFO0VBQ0UsNkJBQUE7RUFDQSw4QkFBQTtBQUFKO0FBQ0k7RUFDRSxVQUFBO0FBQ047QUFHRTtFQUNFLGFBQUE7RUFDQSx5QkFBQTtFQUNBLG1CQUFBO0VBQ0EsU0FBQTtFQUNBLGlCQUFBO0VBQ0Esb0JBQUE7QUFESjtBQUVJO0VBQ0UsaUJBQUE7QUFBTjtBQUlFO0VBQ0UsZ0JBQUE7RUFDQSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxvQkFBQTtBQUZKO0FBS0U7RUFDRSxrQkFBQTtBQUhKO0FBTUU7RUFDRSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxnQkFBQTtBQUpKO0FBT0U7RUFDRSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxjQUFBO0VBQ0EsbUJBQUE7QUFMSjtBQVFFO0VBQ0UsWUFBQTtFQUNBLFlBQUE7RUFDQSx5QkFBQTtFQUNBLGtCQUFBO0VBRUEsYUFBQTtFQUNBLG1CQUFBO0FBUEo7QUFTSTtFQUNFLFdBQUE7RUFDQSxtQkFBQTtBQVBOO0FBV0U7RUFDRSxhQUFBO0VBQ0EsOEJBQUE7RUFDQSxTQUFBO0FBVEo7QUFZRTtFQUNFLHlCQUFBO0VBQ0EsbUNBQUE7RUFDQSxZQUFBO0VBQ0EseUJBQUE7RUFDQSxrQkFBQTtFQUVBLGFBQUE7RUFDQSxnQkFBQTtFQUNBLGNBQUE7RUFFQSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtBQVpKO0FBZUU7RUFDRSxrQkFBQTtFQUNBLFlBQUE7RUFFQSxhQUFBO0VBQ0EsNkJBQUE7RUFDQSxtQkFBQTtFQUVBLG1CQUFBO0VBQ0EsbUNBQUE7RUFFQSxlQUFBO0VBQ0EsZ0JBQUE7RUFDQSxjQUFBO0VBRUEsZUFBQTtFQUNBLGdCQUFBO0VBQ0Esa0JBQUE7QUFqQko7QUFtQkk7RUFDRSxZQUFBO0FBakJOO0FBb0JJO0VBQ0UsY0FBQTtFQUNBLGVBQUE7QUFsQk47QUFxQkk7RUFDRSxrQkFBQTtBQW5CTjtBQXFCTTtFQUNFLGNBQUE7RUFDQSxlQUFBO0FBbkJSO0FBd0JFO0VBQ0UsYUFBQTtFQUNBLHVCQUFBO0VBQ0EsZUFBQTtFQUVBLGVBQUE7RUFDQSxpQkFBQTtFQUNBLGNBQUE7QUF2Qko7QUEwQkU7RUFDRSxXQUFBO0VBQ0EsYUFBQTtFQUNBLGFBQUE7RUFFQSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxtQ0FBQTtFQUNBLGtCQUFBO0FBekJKO0FBNEJFO0VBQ0UsYUFBQTtFQUNBLG1CQUFBO0VBQ0EseUJBQUE7RUFDQSxlQUFBO0FBMUJKO0FBNkJFO0VBQ0UsV0FBQTtFQUNBLGdDQUFBO0VBQ0EsZ0JBQUE7RUFDQSxtQkFBQTtBQTNCSjtBQThCRTtFQUNFLGFBQUE7RUFDQSw4QkFBQTtFQUNBLG1CQUFBO0VBQ0EsZUFBQTtFQUNBLGlCQUFBO0VBQ0EsZ0JBQUE7RUFDQSxtQkFBQTtBQTVCSjtBQStCRTtFQUNFLHFCQUFBO0VBQ0EseUJBQUE7RUFDQSxtQkFBQTtFQUNBLHNCQUFBO0VBQ0EsbUJBQUE7RUFDQSxxQkFBQTtBQTdCSjtBQWdDRTtFQUNFLDBEQUFBO0FBOUJKO0FBZ0NJO0VBQ0UsWUFBQTtBQTlCTjs7QUFtQ0E7RUFDRSxrQkFBQTtFQUNBLHVCQUFBO0FBaENGOztBQW1DQTtFQUNFLHVDQUFBO0FBaENGOztBQW1DQTtFQUNFLDBEQUFBO0FBaENGOztBQW1DQTtFQUNFLFlBQUE7RUFDQSxnQkFBQTtBQWhDRjtBQWtDRTtFQUNFLGVBQUE7QUFoQ0oiLCJzb3VyY2VzQ29udGVudCI6WyIuZ2lmdC1jYXJkLW1vZGFsIHtcbiAgJl9faGVhZGVyIHtcbiAgICBwYWRkaW5nLWxlZnQ6IDE2cHggIWltcG9ydGFudDtcbiAgICBwYWRkaW5nLXJpZ2h0OiAxNnB4ICFpbXBvcnRhbnQ7XG4gICAgaW9uLWJ1dHRvbjo6cGFydChuYXRpdmUpIHtcbiAgICAgIHBhZGRpbmc6IDA7XG4gICAgfVxuICB9XG5cbiAgJl9fY2xvc2UtYnRuIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGp1c3RpZnktY29udGVudDogZmxleC1lbmQ7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBtYXJnaW46IDA7XG4gICAgcGFkZGluZy10b3A6IDE2cHg7XG4gICAgcGFkZGluZy1ib3R0b206IDE2cHg7XG4gICAgaW9uLWltZyB7XG4gICAgICBtYXJnaW4tbGVmdDogYXV0bztcbiAgICB9XG4gIH1cblxuICAmX190aXRsZSB7XG4gICAgZm9udC13ZWlnaHQ6IDYwMDtcbiAgICBmb250LXNpemU6IDE4cHg7XG4gICAgbGluZS1oZWlnaHQ6IDI4cHg7XG4gICAgcGFkZGluZy1ib3R0b206IDE2cHg7XG4gIH1cblxuICAmX19jb250ZW50IHtcbiAgICBwYWRkaW5nOiAyNHB4IDE2cHg7XG4gIH1cblxuICAmX19vcHRpb24tdGl0bGUge1xuICAgIGZvbnQtc2l6ZTogMTZweDtcbiAgICBsaW5lLWhlaWdodDogMjRweDtcbiAgICBmb250LXdlaWdodDogNTAwO1xuICB9XG5cbiAgJl9fb3B0aW9uLWNvbmRpdGlvbiB7XG4gICAgZm9udC1zaXplOiAxMnB4O1xuICAgIGxpbmUtaGVpZ2h0OiAxNnB4O1xuICAgIGNvbG9yOiAjNjQ3MjgxO1xuICAgIG1hcmdpbi1ib3R0b206IDE2cHg7XG4gIH1cblxuICAmX19zdHlsZXMtaW1nIHtcbiAgICB3aWR0aDogMTQwcHg7XG4gICAgaGVpZ2h0OiA3OHB4O1xuICAgIGJvcmRlcjogMnB4IHNvbGlkICNkOGQ4ZDg7XG4gICAgYm9yZGVyLXJhZGl1czogOHB4O1xuXG4gICAgZGlzcGxheTogZ3JpZDtcbiAgICBwbGFjZS1pdGVtczogY2VudGVyO1xuXG4gICAgaW1nIHtcbiAgICAgIHdpZHRoOiA5MHB4O1xuICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICB9XG4gIH1cblxuICAmX19hbW91bnQge1xuICAgIGRpc3BsYXk6IGdyaWQ7XG4gICAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiAxZnIgMWZyO1xuICAgIGdhcDogMTJweDtcbiAgfVxuXG4gICZfX2Ftb3VudC1pdGVtIHtcbiAgICAtLWJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xuICAgIC0tYmFja2dyb3VuZC1hY3RpdmF0ZWQ6IHRyYW5zcGFyZW50O1xuICAgIGhlaWdodDogNDhweDtcbiAgICBib3JkZXI6IDJweCBzb2xpZCAjZDhkOGQ4O1xuICAgIGJvcmRlci1yYWRpdXM6IDhweDtcblxuICAgIGZvbnQtc2l6ZTogMTY7XG4gICAgZm9udC13ZWlnaHQ6IDUwMDtcbiAgICBjb2xvcjogIzEyMTIxMjtcblxuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgfVxuXG4gICZfX2Ftb3VudC1xdWFudGl0eSB7XG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xuICAgIGhlaWdodDogNDhweDtcblxuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1hcm91bmQ7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcblxuICAgIGJvcmRlci1yYWRpdXM6IDUwcHg7XG4gICAgYm9yZGVyOiAycHggc29saWQgdmFyKC0tbWFnLWJvcmRlcik7XG5cbiAgICBmb250LXNpemU6IDE0cHg7XG4gICAgZm9udC13ZWlnaHQ6IDUwMDtcbiAgICBjb2xvcjogIzEyMTIxMjtcblxuICAgIHBhZGRpbmc6IDEwcHggMDtcbiAgICBtYXJnaW4tdG9wOiAyOHB4O1xuICAgIG1hcmdpbi1ib3R0b206IDhweDtcblxuICAgICYtLWRpc2FibGUge1xuICAgICAgb3BhY2l0eTogMC41O1xuICAgIH1cblxuICAgIGlvbi1pY29uIHtcbiAgICAgIGNvbG9yOiAjMTIxMjEyO1xuICAgICAgZm9udC1zaXplOiAyMnB4O1xuICAgIH1cblxuICAgICYtLXF1YW50aXR5IHtcbiAgICAgIHRleHQtYWxpZ246IGNlbnRlcjtcblxuICAgICAgc3BhbiB7XG4gICAgICAgIGRpc3BsYXk6IGJsb2NrO1xuICAgICAgICBmb250LXNpemU6IDE0cHg7XG4gICAgICB9XG4gICAgfVxuICB9XG5cbiAgJl9fYW1vdW50LWNvbmRpdGlvbiB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICBtYXJnaW4tdG9wOiA4cHg7XG5cbiAgICBmb250LXNpemU6IDEycHg7XG4gICAgbGluZS1oZWlnaHQ6IDE2cHg7XG4gICAgY29sb3I6ICM2NDcyODE7XG4gIH1cblxuICAmX19tZXNzYWdlIHtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBoZWlnaHQ6IDE1MHB4O1xuICAgIHBhZGRpbmc6IDE2cHg7XG5cbiAgICBmb250LXNpemU6IDE2cHg7XG4gICAgbGluZS1oZWlnaHQ6IDI0cHg7XG4gICAgYm9yZGVyOiAxcHggc29saWQgdmFyKC0tbWFnLWJvcmRlcik7XG4gICAgYm9yZGVyLXJhZGl1czogOHB4O1xuICB9XG5cbiAgJl9fbWVzc2FnZS1jb25kaXRpb24ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGZsZXgtZW5kO1xuICAgIG1hcmdpbi10b3A6IDhweDtcbiAgfVxuXG4gICZfX29wdGlvbi1saW5lIHtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgI2VlZWVlZTtcbiAgICBtYXJnaW4tdG9wOiAzMnB4O1xuICAgIG1hcmdpbi1ib3R0b206IDMycHg7XG4gIH1cblxuICAmX190b3RhbC1wcmljZSB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IHNwYWNlLWJldHdlZW47XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBmb250LXNpemU6IDE4cHg7XG4gICAgbGluZS1oZWlnaHQ6IDI4cHg7XG4gICAgZm9udC13ZWlnaHQ6IDYwMDtcbiAgICBtYXJnaW4tYm90dG9tOiAxNnB4O1xuICB9XG5cbiAgJl9fdG9vbGJhciB7XG4gICAgcGFkZGluZzogMCAhaW1wb3J0YW50O1xuICAgIC0tYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XG4gICAgLS1wYWRkaW5nLXRvcDogMTZweDtcbiAgICAtLXBhZGRpbmctYm90dG9tOiAxNnB4O1xuICAgIC0tcGFkZGluZy1lbmQ6IDE2cHg7XG4gICAgLS1wYWRkaW5nLXN0YXJ0OiAxNnB4O1xuICB9XG5cbiAgJl9fc3VibWl0LWJ0biB7XG4gICAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctYnJhbmQtZm91bmRhdGlvbi1wcmltYXJ5LCAjMDA4MDAwKTtcblxuICAgICY6OnBhcnQobmF0aXZlKSB7XG4gICAgICBoZWlnaHQ6IDQ4cHg7XG4gICAgfVxuICB9XG59XG5cbnN3aXBlci1zbGlkZSB7XG4gIG1hcmdpbi1yaWdodDogMTJweDtcbiAgd2lkdGg6IDE0MHB4ICFpbXBvcnRhbnQ7XG59XG5cbmlvbi1jb250ZW50IHtcbiAgYm9yZGVyLXRvcDogMXB4IHNvbGlkIHZhcigtLW1hZy1ib3JkZXIpO1xufVxuXG4uc2VsZWN0ZWQge1xuICBib3JkZXItY29sb3I6IHZhcigtLW1hZy1icmFuZC1mb3VuZGF0aW9uLXByaW1hcnksICMwMDgwMDApO1xufVxuXG5idXR0b24ge1xuICBib3JkZXI6IG5vbmU7XG4gIGJhY2tncm91bmQ6IG5vbmU7XG5cbiAgaW9uLWljb24ge1xuICAgIGZvbnQtc2l6ZTogMTZweDtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 75498:
/*!******************************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/parity-product/parity-product-flavor/parity-product-flavor.ts ***!
  \******************************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ParityProductFlavorComponent: () => (/* binding */ ParityProductFlavorComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _model_util__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../../model/util */ 38372);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../../../utils/pipes/safe-html/safe-html */ 93943);








const _c0 = a0 => ({
  "product-parity__item": true,
  "product-parity__item--selected": a0
});
function ParityProductFlavorComponent_swiper_slide_5_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "ion-img", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const product_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("src", product_r2.MediaAssets.Images[0].ImgUrlOriginal);
  }
}
function ParityProductFlavorComponent_swiper_slide_5_div_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipe"](2, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpipeBind1"](2, 1, ctx_r2.magImg), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeHtml"]);
  }
}
function ParityProductFlavorComponent_swiper_slide_5_span_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const product_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate1"]("(", product_r2 == null ? null : product_r2.PricePerUnitItem, ")");
  }
}
function ParityProductFlavorComponent_swiper_slide_5_ion_text_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "ion-text")(1, "span", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const product_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate2"](" ", product_r2 == null ? null : product_r2.DisplaySalePrice, " ", product_r2 == null ? null : product_r2.DisplayPricingUnit, " ");
  }
}
function ParityProductFlavorComponent_swiper_slide_5_ion_text_13_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const product_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate2"](" ", product_r2 == null ? null : product_r2.DisplayPrice, " ", product_r2 == null ? null : product_r2.DisplayPricingUnit, " ");
  }
}
function ParityProductFlavorComponent_swiper_slide_5_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "swiper-slide")(1, "button", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function ParityProductFlavorComponent_swiper_slide_5_Template_button_click_1_listener() {
      const product_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.onSelectProduct(product_r2));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](2, ParityProductFlavorComponent_swiper_slide_5_div_2_Template, 2, 1, "div", 6)(3, ParityProductFlavorComponent_swiper_slide_5_div_3_Template, 3, 3, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "div", 8)(5, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](7, "div", 9)(8, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](9);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](10, ParityProductFlavorComponent_swiper_slide_5_span_10_Template, 2, 1, "span", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](11, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](12, ParityProductFlavorComponent_swiper_slide_5_ion_text_12_Template, 3, 2, "ion-text", 10)(13, ParityProductFlavorComponent_swiper_slide_5_ion_text_13_Template, 2, 2, "ion-text", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    const product_r2 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction1"](8, _c0, ctx_r2.selectedProduct.Id === product_r2.Id));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", product_r2 == null ? null : product_r2.MediaAssets == null ? null : product_r2.MediaAssets.Images[0] == null ? null : product_r2.MediaAssets.Images[0].ImgUrlOriginal);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !(product_r2 == null ? null : product_r2.MediaAssets == null ? null : product_r2.MediaAssets.Images[0] == null ? null : product_r2.MediaAssets.Images[0].ImgUrlOriginal));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"]((product_r2 == null ? null : product_r2.DisplayName == null ? null : product_r2.DisplayName.En) || (product_r2 == null ? null : product_r2.Name == null ? null : product_r2.Name.En));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate1"]("", product_r2 == null ? null : product_r2.Unit, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", product_r2 == null ? null : product_r2.PricePerUnitItem);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", product_r2.DisplaySalePrice);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", !product_r2.DisplaySalePrice);
  }
}
class ParityProductFlavorComponent {
  router;
  route;
  selecteđId;
  listProduct;
  storeCode;
  selectedProductUpc;
  parityName;
  changeFlavor = new _angular_core__WEBPACK_IMPORTED_MODULE_2__.EventEmitter();
  magImg = `<mag-img src></mag-img>`;
  selectedProduct;
  listFormattedProduct;
  slidesPreView = 0;
  // @Output() onChangePriceCard: EventEmitter<string> = new EventEmitter(); ---- TODO
  constructor(router, route) {
    this.router = router;
    this.route = route;
  }
  ngOnInit() {
    window.addEventListener('resize', () => this._initSwiper());
    this._initSwiper();
    this.mappingProduct();
    this.selectedProduct = this.listFormattedProduct.find(product => product?.Upc === this.selectedProductUpc) || this.listFormattedProduct[0];
  }
  ngOnDestroy() {
    window.removeEventListener('resize', () => {
      console.log();
    });
  }
  _initSwiper() {
    this.slidesPreView = window.innerWidth < 767 ? 1.75 : 3.25;
  }
  mappingProduct() {
    this.listFormattedProduct = this.listProduct.map(product => {
      // Filter store and map the prices
      const filteredStore = product?.Stores?.[0];
      const storePrices = filteredStore?.Prices?.sort((p1, p2) => p1?.Price - p2?.Price);
      const [salePrice, regularPrice] = storePrices?.length > 1 ? [storePrices[0], storePrices[1]] : storePrices?.length === 1 ? [undefined, storePrices[0]] : [undefined, undefined];
      return {
        ...product,
        DisplaySalePrice: salePrice?.DisplayPrice,
        DisplayPrice: regularPrice?.DisplayPrice,
        DisplayPricingUnit: _model_util__WEBPACK_IMPORTED_MODULE_0__.pricingUnit[regularPrice?.PricingUnit],
        PricingUnit: salePrice?.PricingUnit || regularPrice?.PricingUnit,
        PricePerUnitItem: salePrice?.PricePerUnitItem || regularPrice?.PricePerUnitItem
      };
    });
  }
  onSelectProduct(product) {
    this.selectedProduct = product;
    this.changeFlavor.emit(product);
    // console.log('Selected Flavor: ', this.selectedProduct);
  }
  static ɵfac = function ParityProductFlavorComponent_Factory(t) {
    return new (t || ParityProductFlavorComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.ActivatedRoute));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: ParityProductFlavorComponent,
    selectors: [["parity-product-flavor"]],
    inputs: {
      selecteđId: "selecte\u0111Id",
      listProduct: "listProduct",
      storeCode: "storeCode",
      selectedProductUpc: "selectedProductUpc",
      parityName: "parityName"
    },
    outputs: {
      changeFlavor: "changeFlavor"
    },
    decls: 6,
    vars: 5,
    consts: [[1, "product-parity"], [1, "product-parity__name"], [1, "product-parity__slides-wrapper"], [1, "product-parity__container", 3, "slidesPerView", "spaceBetween"], [4, "ngFor", "ngForOf"], [3, "click", "ngClass"], ["class", "product-parity__img", 4, "ngIf"], ["class", "product-parity__default-img", 4, "ngIf"], [1, "product-parity__title"], [1, "product-parity__sizing"], [4, "ngIf"], [1, "product-parity__price"], [1, "product-parity__img"], [3, "src"], [1, "product-parity__default-img"], [3, "innerHTML"], [1, "product-detail__sale-price"]],
    template: function ParityProductFlavorComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "div", 2)(4, "swiper-container", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](5, ParityProductFlavorComponent_swiper_slide_5_Template, 14, 10, "swiper-slide", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate2"]("", ctx.parityName, " (", ctx.listFormattedProduct == null ? null : ctx.listFormattedProduct.length, " Available)");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("slidesPerView", ctx.slidesPreView)("spaceBetween", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx.listFormattedProduct);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_4__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_4__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_5__.IonText, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_1__.SafeHtmlPipe],
    styles: [".product-parity[_ngcontent-%COMP%] {\n  margin: 32px 0;\n}\n.product-parity__container[_ngcontent-%COMP%]   swiper-slide[_ngcontent-%COMP%] {\n  height: auto;\n}\n.product-parity__container[_ngcontent-%COMP%]   swiper-slide[_ngcontent-%COMP%]   .product-parity__item[_ngcontent-%COMP%] {\n  height: 100%;\n}\n.product-parity__name[_ngcontent-%COMP%] {\n  margin-bottom: 16px;\n  color: var(--mag-color-text, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px); \n\n}\n.product-parity__item[_ngcontent-%COMP%] {\n  min-height: 260px;\n  border: 2px solid var(--mag-color-border-primary, #d8d8d8);\n  border-radius: 8px;\n  padding: 16px;\n  background-color: transparent;\n}\n.product-parity__item--selected[_ngcontent-%COMP%] {\n  border: 2px solid var(--mag-color-border-brand, #008000);\n}\n.product-parity__img[_ngcontent-%COMP%] {\n  margin: auto;\n  width: -moz-fit-content;\n  width: fit-content;\n}\n.product-parity__img[_ngcontent-%COMP%]   ion-img[_ngcontent-%COMP%] {\n  max-width: 160px;\n  height: 160px;\n  object-fit: contain;\n}\n.product-parity__title[_ngcontent-%COMP%], .product-parity__sizing[_ngcontent-%COMP%], .product-parity__price[_ngcontent-%COMP%] {\n  text-align: left;\n}\n.product-parity__title[_ngcontent-%COMP%] {\n  margin-top: 12px;\n  color: var(--mag-color-text, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend\");\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-headlines-small-line-height, 24px); \n\n}\n.product-parity__sizing[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-subtext-font-size, 12px);\n  font-style: normal;\n  font-weight: var(--mag-typography-subtext-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-subtext-line-height, 16px); \n\n}\n.product-parity__price[_ngcontent-%COMP%] {\n  margin-top: 12px;\n  color: var(--mag-color-text-pricing, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend\");\n  font-size: var(--mag-typography-deal-small-font-size, 18px);\n  font-style: normal;\n  font-weight: var(--mag-typography-deal-font-weight, 500);\n  line-height: var(--mag-typography-deal-small-line-height, 24px); \n\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wYXJpdHktcHJvZHVjdC9wYXJpdHktcHJvZHVjdC1mbGF2b3IvcGFyaXR5LXByb2R1Y3QtZmxhdm9yLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxjQUFBO0FBQ0Y7QUFDSTtFQUNFLFlBQUE7QUFDTjtBQUFNO0VBQ0UsWUFBQTtBQUVSO0FBRUU7RUFDRSxtQkFBQTtFQUNBLHFDQUFBO0VBQ0Esd0RBQUE7RUFDQSxnRUFBQTtFQUNBLGtCQUFBO0VBQ0EsbUVBQUE7RUFDQSxvRUFBQSxFQUFBLGFBQUE7QUFBSjtBQUdFO0VBQ0UsaUJBQUE7RUFDQSwwREFBQTtFQUNBLGtCQUFBO0VBQ0EsYUFBQTtFQUNBLDZCQUFBO0FBREo7QUFJRTtFQUNFLHdEQUFBO0FBRko7QUFLRTtFQUNFLFlBQUE7RUFDQSx1QkFBQTtFQUFBLGtCQUFBO0FBSEo7QUFJSTtFQUNFLGdCQUFBO0VBQ0EsYUFBQTtFQUNBLG1CQUFBO0FBRk47QUFNRTtFQUdFLGdCQUFBO0FBTko7QUFTRTtFQUNFLGdCQUFBO0VBQ0EscUNBQUE7RUFDQSx3REFBQTtFQUNBLGdFQUFBO0VBQ0Esa0JBQUE7RUFDQSxtRUFBQTtFQUNBLG9FQUFBLEVBQUEsYUFBQTtBQVBKO0FBVUU7RUFDRSwwQ0FBQTtFQUNBLGlFQUFBO0VBQ0Esd0RBQUE7RUFDQSxrQkFBQTtFQUNBLHNFQUFBO0VBQ0EsNERBQUEsRUFBQSxhQUFBO0FBUko7QUFVRTtFQUNFLGdCQUFBO0VBQ0EsNkNBQUE7RUFDQSxpRUFBQTtFQUNBLDJEQUFBO0VBQ0Esa0JBQUE7RUFDQSx3REFBQTtFQUNBLCtEQUFBLEVBQUEsYUFBQTtBQVJKIiwic291cmNlc0NvbnRlbnQiOlsiLnByb2R1Y3QtcGFyaXR5IHtcbiAgbWFyZ2luOiAzMnB4IDA7XG4gICZfX2NvbnRhaW5lciB7XG4gICAgc3dpcGVyLXNsaWRlIHtcbiAgICAgIGhlaWdodDogYXV0bztcbiAgICAgIC5wcm9kdWN0LXBhcml0eV9faXRlbSB7XG4gICAgICAgIGhlaWdodDogMTAwJTtcbiAgICAgIH1cbiAgICB9XG4gIH1cbiAgJl9fbmFtZSB7XG4gICAgbWFyZ2luLWJvdHRvbTogMTZweDtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQsICMxMjEyMTIpO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1saW5lLWhlaWdodCwgMjRweCk7IC8qIDEzMy4zMzMlICovXG4gIH1cblxuICAmX19pdGVtIHtcbiAgICBtaW4taGVpZ2h0OiAyNjBweDtcbiAgICBib3JkZXI6IDJweCBzb2xpZCB2YXIoLS1tYWctY29sb3ItYm9yZGVyLXByaW1hcnksICNkOGQ4ZDgpO1xuICAgIGJvcmRlci1yYWRpdXM6IDhweDtcbiAgICBwYWRkaW5nOiAxNnB4O1xuICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50O1xuICB9XG5cbiAgJl9faXRlbS0tc2VsZWN0ZWQge1xuICAgIGJvcmRlcjogMnB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItYnJhbmQsICMwMDgwMDApO1xuICB9XG5cbiAgJl9faW1nIHtcbiAgICBtYXJnaW46IGF1dG87XG4gICAgd2lkdGg6IGZpdC1jb250ZW50O1xuICAgIGlvbi1pbWcge1xuICAgICAgbWF4LXdpZHRoOiAxNjBweDtcbiAgICAgIGhlaWdodDogMTYwcHg7XG4gICAgICBvYmplY3QtZml0OiBjb250YWluOyAvLyBvciBjb3ZlciwgZGVwZW5kaW5nIG9uIHlvdXIgZGVzaWduIHByZWZlcmVuY2VcbiAgICB9XG4gIH1cblxuICAmX190aXRsZSxcbiAgJl9fc2l6aW5nLFxuICAmX19wcmljZSB7XG4gICAgdGV4dC1hbGlnbjogbGVmdDtcbiAgfVxuXG4gICZfX3RpdGxlIHtcbiAgICBtYXJnaW4tdG9wOiAxMnB4O1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dCwgIzEyMTIxMik7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC1zaXplLCAxOHB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXdlaWdodCwgNTAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTsgLyogMTMzLjMzMyUgKi9cbiAgfVxuXG4gICZfX3NpemluZyB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWluZm8sICM2NDcyODEpO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgJ0xleGVuZCcpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXNpemUsIDEycHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWxpbmUtaGVpZ2h0LCAxNnB4KTsgLyogMTMzLjMzMyUgKi9cbiAgfVxuICAmX19wcmljZSB7XG4gICAgbWFyZ2luLXRvcDogMTJweDtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpY2luZywgIzEyMTIxMik7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kJyk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kZWFsLXNtYWxsLWZvbnQtc2l6ZSwgMThweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kZWFsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kZWFsLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTsgLyogMTMzLjMzMyUgKi9cbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 96034:
/*!**************************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/parity-product/parity-product-size/parity-product-size.ts ***!
  \**************************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ParityProductSizeComponent: () => (/* binding */ ParityProductSizeComponent)
/* harmony export */ });
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ionic/angular */ 37401);







const _c0 = (a0, a1) => ({
  "product-parity__product-item": true,
  "product-parity__product-item--selected": a0,
  "product-parity__product-item--first": a1
});
function ParityProductSizeComponent_div_5_ion_button_10_ion_icon_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](0, "ion-icon", 15);
  }
}
function ParityProductSizeComponent_div_5_ion_button_10_ion_icon_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](0, "ion-icon", 16);
  }
}
function ParityProductSizeComponent_div_5_ion_button_10_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "ion-button", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function ParityProductSizeComponent_div_5_ion_button_10_Template_ion_button_click_0_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r4);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵresetView"](ctx_r2.onClickDropdowIcon($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](1, ParityProductSizeComponent_div_5_ion_button_10_ion_icon_1_Template, 1, 0, "ion-icon", 13)(2, ParityProductSizeComponent_div_5_ion_button_10_ion_icon_2_Template, 1, 0, "ion-icon", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", !ctx_r2.isExpand);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx_r2.isExpand);
  }
}
function ParityProductSizeComponent_div_5_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 4)(1, "ion-button", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](2, "ion-img", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "ion-button", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function ParityProductSizeComponent_div_5_Template_ion_button_click_3_listener() {
      const product_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵresetView"](ctx_r2.onSelectProduct(product_r2));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](4, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](6, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](8, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](9);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](10, ParityProductSizeComponent_div_5_ion_button_10_Template, 3, 2, "ion-button", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const product_r2 = ctx.$implicit;
    const index_r5 = ctx.index;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction2"](6, _c0, ctx_r2.selectedProduct.id === product_r2.id, index_r5 === 0));
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("src", product_r2.imageUrl);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](product_r2 == null ? null : product_r2.imageName);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](product_r2 == null ? null : product_r2.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](product_r2 == null ? null : product_r2.price);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", index_r5 === 0);
  }
}
class ParityProductSizeComponent {
  router;
  utils;
  route;
  parityName = 'Sizes (3 Available)';
  listProduct = [{
    id: '1',
    imageName: 'Mercatus Photo Cakes',
    name: 'Sheet Cake - 1/4 Sheet',
    imageUrl: 'assets/img/ecom-v2/parity-prod-size-1.png',
    price: '$19.99 ea'
  }, {
    id: '2',
    imageName: 'Mercatus Photo Cakes',
    name: 'Sheet Cake - 1/2 Sheet',
    imageUrl: 'assets/img/ecom-v2/parity-prod-size-2.png',
    price: '$1.29 ea'
  }, {
    id: '3',
    imageName: 'Mercatus Photo Cakes',
    name: 'Sheet Cake - Full Sheet',
    imageUrl: 'assets/img/ecom-v2/parity-prod-size-3.png',
    price: '$1.29 ea'
  }];
  selectedProduct;
  isExpand = false;
  constructor(router, utils, route) {
    this.router = router;
    this.utils = utils;
    this.route = route;
  }
  ngOnInit() {
    this.selectedProduct = this.listProduct.find(p => p.id === '1');
  }
  onSelectProduct(product) {
    this.selectedProduct = product;
    console.log('Selected Size: ', this.selectedProduct);
  }
  onClickDropdowIcon(event) {
    event.stopPropagation();
    this.isExpand = !this.isExpand;
  }
  static ɵfac = function ParityProductSizeComponent_Factory(t) {
    return new (t || ParityProductSizeComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__.ActivatedRoute));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
    type: ParityProductSizeComponent,
    selectors: [["parity-product-size"]],
    inputs: {
      parityName: "parityName",
      listProduct: "listProduct"
    },
    decls: 6,
    vars: 2,
    consts: [[1, "product-parity"], [1, "product-parity__title"], [1, "product-parity__product-list"], [3, "ngClass", 4, "ngFor", "ngForOf"], [3, "ngClass"], ["fill", "clear", 1, "product-parity__img"], [3, "src"], ["fill", "clear", 1, "product-parity__informations", 3, "click"], [1, "product-parity__image-name"], [1, "product-parity__name"], [1, "product-parity__price"], ["fill", "clear", "class", "product-parity__dropdow-icon", 3, "click", 4, "ngIf"], ["fill", "clear", 1, "product-parity__dropdow-icon", 3, "click"], ["name", "chevron-down-outline", 4, "ngIf"], ["name", "chevron-up-outline", 4, "ngIf"], ["name", "chevron-down-outline"], ["name", "chevron-up-outline"]],
    template: function ParityProductSizeComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](4, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](5, ParityProductSizeComponent_div_5_Template, 11, 9, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](ctx.parityName);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngForOf", ctx.isExpand ? ctx.listProduct : ctx.listProduct.slice(0, 1));
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_3__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_3__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_3__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_4__.IonImg],
    styles: [".product-parity__title[_ngcontent-%COMP%] {\n  font-size: 18px;\n  font-weight: 600;\n  line-height: 32px;\n  margin-bottom: 16px;\n}\n.product-parity__product-item[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: 12px;\n  border-top: 1px solid #d8d8d8;\n  border-left: 1px solid #d8d8d8;\n  border-right: 1px solid #d8d8d8;\n  padding: 14px 22px;\n}\n.product-parity__product-item[_ngcontent-%COMP%]:last-child {\n  border-bottom: 1px solid #d8d8d8;\n  border-bottom-left-radius: 8px;\n  border-bottom-right-radius: 8px;\n}\n.product-parity__product-item--selected[_ngcontent-%COMP%] {\n  border-color: #008000;\n  border-bottom: 1px solid #008000 !important;\n}\n.product-parity__product-item--first[_ngcontent-%COMP%] {\n  border-top-left-radius: 8px;\n  border-top-right-radius: 8px;\n}\n.product-parity__img[_ngcontent-%COMP%] {\n  width: 72px;\n  height: 72px;\n}\n.product-parity__img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  object-fit: contain;\n}\n.product-parity__informations[_ngcontent-%COMP%] {\n  flex: 1;\n  font-size: 16px;\n  line-height: 24px;\n  font-weight: 500;\n}\n.product-parity__image-name[_ngcontent-%COMP%] {\n  font-size: 12px;\n  line-height: 16px;\n  font-weight: 400;\n}\n.product-parity__dropdow-icon[_ngcontent-%COMP%] {\n  width: 16px;\n  min-width: 16px;\n  height: 100%;\n  display: flex;\n  align-items: center;\n  justify-content: center;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wYXJpdHktcHJvZHVjdC9wYXJpdHktcHJvZHVjdC1zaXplL3Bhcml0eS1wcm9kdWN0LXNpemUuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDRTtFQUNFLGVBQUE7RUFDQSxnQkFBQTtFQUNBLGlCQUFBO0VBRUEsbUJBQUE7QUFESjtBQVNFO0VBQ0UsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsU0FBQTtFQUVBLDZCQUFBO0VBQ0EsOEJBQUE7RUFDQSwrQkFBQTtFQVFBLGtCQUFBO0FBZko7QUFTSTtFQUNFLGdDQUFBO0VBQ0EsOEJBQUE7RUFDQSwrQkFBQTtBQVBOO0FBWUk7RUFDRSxxQkFBQTtFQUNBLDJDQUFBO0FBVk47QUFZSTtFQUNFLDJCQUFBO0VBQ0EsNEJBQUE7QUFWTjtBQWNFO0VBQ0UsV0FBQTtFQUNBLFlBQUE7QUFaSjtBQWNJO0VBQ0UsV0FBQTtFQUNBLFlBQUE7RUFDQSxtQkFBQTtBQVpOO0FBZ0JFO0VBQ0UsT0FBQTtFQUNBLGVBQUE7RUFDQSxpQkFBQTtFQUNBLGdCQUFBO0FBZEo7QUFpQkU7RUFDRSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxnQkFBQTtBQWZKO0FBa0JFO0VBQ0UsV0FBQTtFQUNBLGVBQUE7RUFDQSxZQUFBO0VBRUEsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsdUJBQUE7QUFqQkoiLCJzb3VyY2VzQ29udGVudCI6WyIucHJvZHVjdC1wYXJpdHkge1xuICAmX190aXRsZSB7XG4gICAgZm9udC1zaXplOiAxOHB4O1xuICAgIGZvbnQtd2VpZ2h0OiA2MDA7XG4gICAgbGluZS1oZWlnaHQ6IDMycHg7XG5cbiAgICBtYXJnaW4tYm90dG9tOiAxNnB4O1xuICB9XG5cbiAgJl9fcHJvZHVjdC1saXN0IHtcbiAgICAvLyBib3JkZXI6IDFweCBzb2xpZCAjZDhkOGQ4O1xuICAgIC8vIGJvcmRlci1yYWRpdXM6IDhweDtcbiAgfVxuXG4gICZfX3Byb2R1Y3QtaXRlbSB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGdhcDogMTJweDtcblxuICAgIGJvcmRlci10b3A6IDFweCBzb2xpZCAjZDhkOGQ4O1xuICAgIGJvcmRlci1sZWZ0OiAxcHggc29saWQgI2Q4ZDhkODtcbiAgICBib3JkZXItcmlnaHQ6IDFweCBzb2xpZCAjZDhkOGQ4O1xuXG4gICAgJjpsYXN0LWNoaWxkIHtcbiAgICAgIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCAjZDhkOGQ4O1xuICAgICAgYm9yZGVyLWJvdHRvbS1sZWZ0LXJhZGl1czogOHB4O1xuICAgICAgYm9yZGVyLWJvdHRvbS1yaWdodC1yYWRpdXM6IDhweDtcbiAgICB9XG5cbiAgICBwYWRkaW5nOiAxNHB4IDIycHg7XG5cbiAgICAmLS1zZWxlY3RlZCB7XG4gICAgICBib3JkZXItY29sb3I6ICMwMDgwMDA7XG4gICAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgIzAwODAwMCAhaW1wb3J0YW50O1xuICAgIH1cbiAgICAmLS1maXJzdCB7XG4gICAgICBib3JkZXItdG9wLWxlZnQtcmFkaXVzOiA4cHg7XG4gICAgICBib3JkZXItdG9wLXJpZ2h0LXJhZGl1czogOHB4O1xuICAgIH1cbiAgfVxuXG4gICZfX2ltZyB7XG4gICAgd2lkdGg6IDcycHg7XG4gICAgaGVpZ2h0OiA3MnB4O1xuXG4gICAgaW1nIHtcbiAgICAgIHdpZHRoOiAxMDAlO1xuICAgICAgaGVpZ2h0OiAxMDAlO1xuICAgICAgb2JqZWN0LWZpdDogY29udGFpbjtcbiAgICB9XG4gIH1cblxuICAmX19pbmZvcm1hdGlvbnMge1xuICAgIGZsZXg6IDE7XG4gICAgZm9udC1zaXplOiAxNnB4O1xuICAgIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICAgIGZvbnQtd2VpZ2h0OiA1MDA7XG4gIH1cblxuICAmX19pbWFnZS1uYW1lIHtcbiAgICBmb250LXNpemU6IDEycHg7XG4gICAgbGluZS1oZWlnaHQ6IDE2cHg7XG4gICAgZm9udC13ZWlnaHQ6IDQwMDtcbiAgfVxuXG4gICZfX2Ryb3Bkb3ctaWNvbiB7XG4gICAgd2lkdGg6IDE2cHg7XG4gICAgbWluLXdpZHRoOiAxNnB4O1xuICAgIGhlaWdodDogMTAwJTtcblxuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 70556:
/*!*************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/price-multiple-cards/price-multiple-cards.ts ***!
  \*************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   PriceMultipleCardsComponent: () => (/* binding */ PriceMultipleCardsComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ 52575);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ionic/angular */ 37401);









const _c0 = a0 => ({
  "price-list__card-item": true,
  "price-list__card-item--selected": a0
});
function PriceMultipleCardsComponent_ng_container_0_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](ctx_r0.renderPriceList.DisplayName.En);
  }
}
function PriceMultipleCardsComponent_ng_container_0_div_2_div_1_div_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const item_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](item_r3.DisplayName.En);
  }
}
function PriceMultipleCardsComponent_ng_container_0_div_2_div_1_div_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipe"](2, "currency");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const item_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"](" Est. ", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipeBind4"](2, 1, item_r3.PriceModifier, "USD", "symbol", "1.2-2"), " ");
  }
}
function PriceMultipleCardsComponent_ng_container_0_div_2_div_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div")(1, "ion-button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function PriceMultipleCardsComponent_ng_container_0_div_2_div_1_Template_ion_button_click_1_listener() {
      const item_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r2).$implicit;
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵresetView"](ctx_r0.changePriceCard(item_r3));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](2, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](3, PriceMultipleCardsComponent_ng_container_0_div_2_div_1_div_3_Template, 2, 1, "div", 8)(4, PriceMultipleCardsComponent_ng_container_0_div_2_div_1_div_4_Template, 3, 6, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    const item_r3 = ctx.$implicit;
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](3, _c0, (item_r3 == null ? null : item_r3.Id) === (ctx_r0.selectedPrice == null ? null : ctx_r0.selectedPrice.Id)));
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", item_r3 == null ? null : item_r3.DisplayName == null ? null : item_r3.DisplayName.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", item_r3 == null ? null : item_r3.PriceModifier);
  }
}
function PriceMultipleCardsComponent_ng_container_0_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](1, PriceMultipleCardsComponent_ng_container_0_div_2_div_1_Template, 5, 5, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngForOf", ctx_r0.renderPriceList.Options);
  }
}
function PriceMultipleCardsComponent_ng_container_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](1, PriceMultipleCardsComponent_ng_container_0_div_1_Template, 2, 1, "div", 1)(2, PriceMultipleCardsComponent_ng_container_0_div_2_Template, 2, 1, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx_r0.renderPriceList == null ? null : ctx_r0.renderPriceList.DisplayName == null ? null : ctx_r0.renderPriceList.DisplayName.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx_r0.renderPriceList == null ? null : ctx_r0.renderPriceList.Options);
  }
}
class PriceMultipleCardsComponent {
  router;
  utils;
  route;
  rawPriceList;
  selectedPrice;
  renderPriceList;
  priceChangeSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__.Subject();
  priceChangeSubscription;
  handleChangePriceCard = new _angular_core__WEBPACK_IMPORTED_MODULE_1__.EventEmitter();
  constructor(router, utils, route) {
    this.router = router;
    this.utils = utils;
    this.route = route;
  }
  ngOnInit() {
    this.priceChangeSubscription = this.priceChangeSubject.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_3__.debounceTime)(300)).subscribe(formatPrices => {
      this.handleChangePriceCard.emit(formatPrices ?? null);
    });
    if (this.rawPriceList?.length) {
      this.renderPriceList = this.rawPriceList[0];
      this.selectedPrice = this.renderPriceList?.Options[0];
      this.formatSelectedPrice(this.selectedPrice);
    }
  }
  ngOnDestroy() {
    // Unsubscribe from the price change subscription
    if (this.priceChangeSubscription) {
      this.priceChangeSubscription.unsubscribe();
    }
  }
  formatSelectedPrice(price) {
    const formatPrices = this.rawPriceList?.map(item => {
      return {
        ...item,
        Options: item?.Options?.filter(option => option?.Id === price?.Id)
      };
    });
    this.priceChangeSubject.next(formatPrices);
  }
  changePriceCard(price) {
    this.selectedPrice = price;
    this.formatSelectedPrice(price);
  }
  static ɵfac = function PriceMultipleCardsComponent_Factory(t) {
    return new (t || PriceMultipleCardsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_0__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__.ActivatedRoute));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
    type: PriceMultipleCardsComponent,
    selectors: [["price-multiple-cards"]],
    inputs: {
      rawPriceList: "rawPriceList",
      selectedPrice: "selectedPrice"
    },
    outputs: {
      handleChangePriceCard: "handleChangePriceCard"
    },
    decls: 1,
    vars: 1,
    consts: [[4, "ngIf"], ["class", "price-list__title", 4, "ngIf"], ["class", "price-list__cards", 4, "ngIf"], [1, "price-list__title"], [1, "price-list__cards"], [4, "ngFor", "ngForOf"], ["fill", "clear", 3, "click", "ngClass"], [1, "price-list__wrapper"], ["class", "price-list__size", 4, "ngIf"], ["class", "price-list__est", 4, "ngIf"], [1, "price-list__size"], [1, "price-list__est"]],
    template: function PriceMultipleCardsComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](0, PriceMultipleCardsComponent_ng_container_0_Template, 3, 2, "ng-container", 0);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.renderPriceList);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_5__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_5__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_5__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_6__.IonButton, _angular_common__WEBPACK_IMPORTED_MODULE_5__.CurrencyPipe],
    styles: [".price-list__title[_ngcontent-%COMP%] {\n  display: inline-block;\n  font-size: 18px;\n  line-height: 22px;\n  font-weight: 400;\n  color: var(--mag-text);\n  margin-bottom: 16px;\n}\n.price-list__cards[_ngcontent-%COMP%] {\n  display: flex;\n  flex-wrap: wrap;\n  gap: 16px;\n}\n.price-list__card-item[_ngcontent-%COMP%] {\n  height: 80px;\n  border: 2px solid var(--mag-border);\n  border-radius: 8px;\n  color: var(--mag-text);\n  padding: 12px 16px;\n  display: flex;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n}\n.price-list__card-item--selected[_ngcontent-%COMP%] {\n  border: 2px solid var(--mag-color-border-brand, green);\n}\n.price-list__size[_ngcontent-%COMP%] {\n  font-size: 16px;\n  font-weight: 400;\n  line-height: 24px;\n}\n.price-list__est[_ngcontent-%COMP%] {\n  font-size: 14px;\n  font-weight: 300;\n  line-height: 20px;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wcmljZS1tdWx0aXBsZS1jYXJkcy9wcmljZS1tdWx0aXBsZS1jYXJkcy5zY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUNFO0VBQ0UscUJBQUE7RUFDQSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxnQkFBQTtFQUNBLHNCQUFBO0VBQ0EsbUJBQUE7QUFBSjtBQUdFO0VBQ0UsYUFBQTtFQUNBLGVBQUE7RUFDQSxTQUFBO0FBREo7QUFJRTtFQUNFLFlBQUE7RUFDQSxtQ0FBQTtFQUNBLGtCQUFBO0VBQ0Esc0JBQUE7RUFDQSxrQkFBQTtFQUNBLGFBQUE7RUFDQSxzQkFBQTtFQUNBLHVCQUFBO0VBQ0EsbUJBQUE7QUFGSjtBQUlJO0VBQ0Usc0RBQUE7QUFGTjtBQU1FO0VBQ0UsZUFBQTtFQUNBLGdCQUFBO0VBQ0EsaUJBQUE7QUFKSjtBQU9FO0VBQ0UsZUFBQTtFQUNBLGdCQUFBO0VBQ0EsaUJBQUE7QUFMSiIsInNvdXJjZXNDb250ZW50IjpbIi5wcmljZS1saXN0IHtcbiAgJl9fdGl0bGUge1xuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcbiAgICBmb250LXNpemU6IDE4cHg7XG4gICAgbGluZS1oZWlnaHQ6IDIycHg7XG4gICAgZm9udC13ZWlnaHQ6IDQwMDtcbiAgICBjb2xvcjogdmFyKC0tbWFnLXRleHQpO1xuICAgIG1hcmdpbi1ib3R0b206IDE2cHg7XG4gIH1cblxuICAmX19jYXJkcyB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBmbGV4LXdyYXA6IHdyYXA7XG4gICAgZ2FwOiAxNnB4O1xuICB9XG5cbiAgJl9fY2FyZC1pdGVtIHtcbiAgICBoZWlnaHQ6IDgwcHg7XG4gICAgYm9yZGVyOiAycHggc29saWQgdmFyKC0tbWFnLWJvcmRlcik7XG4gICAgYm9yZGVyLXJhZGl1czogOHB4O1xuICAgIGNvbG9yOiB2YXIoLS1tYWctdGV4dCk7XG4gICAgcGFkZGluZzogMTJweCAxNnB4O1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuXG4gICAgJi0tc2VsZWN0ZWQge1xuICAgICAgYm9yZGVyOiAycHggc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1icmFuZCwgZ3JlZW4pO1xuICAgIH1cbiAgfVxuXG4gICZfX3NpemUge1xuICAgIGZvbnQtc2l6ZTogMTZweDtcbiAgICBmb250LXdlaWdodDogNDAwO1xuICAgIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICB9XG5cbiAgJl9fZXN0IHtcbiAgICBmb250LXNpemU6IDE0cHg7XG4gICAgZm9udC13ZWlnaHQ6IDMwMDtcbiAgICBsaW5lLWhlaWdodDogMjBweDtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 39494:
/*!***********************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/product-added/product-added.ts ***!
  \***********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductAddedComponent: () => (/* binding */ ProductAddedComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _product_options_modal_product_options_modal__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../product-options-modal/product-options-modal */ 79658);
/* harmony import */ var _gift_card_options_modal_gift_card_options_modal__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../gift-card-options-modal/gift-card-options-modal */ 84742);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs */ 75797);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 2510);
/* harmony import */ var _model_util__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/util */ 38372);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ 60316);














function ProductAddedComponent_div_0_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](1, "Already in Cart");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const o_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate2"](" ", o_r2 == null ? null : o_r2.OptionSetDisplayName, ": ", o_r2 == null ? null : o_r2.DisplayName == null ? null : o_r2.DisplayName.En, " ");
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](4, "currency");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const o_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate2"](" ", o_r2 == null ? null : o_r2.OptionSetDisplayName, ": ", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind4"](4, 2, o_r2 == null ? null : o_r2.PriceModifier, "USD", "symbol", "1.2-2"), " ");
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_ng_container_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const o_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate2"]("", o_r2.OptionSetDisplayName, ": ", o_r2.DisplayValue, "");
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_ng_container_1_Template, 4, 2, "ng-container", 9)(2, ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_ng_container_2_Template, 5, 7, "ng-container", 9)(3, ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_ng_container_3_Template, 4, 2, "ng-container", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const o_r2 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (o_r2 == null ? null : o_r2.OptionSetDisplayName) === "Style" && (o_r2 == null ? null : o_r2.DisplayName == null ? null : o_r2.DisplayName.En));
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (o_r2 == null ? null : o_r2.OptionSetDisplayName) === "Amount" && (o_r2 == null ? null : o_r2.PriceModifier));
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (o_r2 == null ? null : o_r2.OptionSetDisplayName) && (o_r2 == null ? null : o_r2.DisplayValue));
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_div_1_Template, 4, 3, "div", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const product_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2).$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngForOf", product_r3 == null ? null : product_r3.seletedOptions);
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_2_div_1_ng_container_2_div_1_Template, 2, 1, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "ion-button", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function ProductAddedComponent_div_0_div_2_div_1_ng_container_2_Template_ion_button_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r1);
      const product_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
      const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r3.openGiftCardOptionsModal(product_r3));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3, " Edit ");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const product_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", product_r3 == null ? null : product_r3.seletedOptions == null ? null : product_r3.seletedOptions.length);
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_div_2_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const o_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate2"](" ", o_r6 == null ? null : o_r6.OptionSetDisplayName, ": ", o_r6 == null ? null : o_r6.DisplayName == null ? null : o_r6.DisplayName.En, " ");
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_div_2_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](1, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const o_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate2"]("", o_r6.OptionSetDisplayName, ": ", o_r6.DisplayValue, "");
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_div_2_ng_container_1_Template, 4, 2, "ng-container", 9)(2, ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_div_2_ng_container_2_Template, 4, 2, "ng-container", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const o_r6 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (o_r6 == null ? null : o_r6.OptionSetDisplayName) && (o_r6 == null ? null : o_r6.DisplayName == null ? null : o_r6.DisplayName.En));
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (o_r6 == null ? null : o_r6.OptionSetDisplayName) && (o_r6 == null ? null : o_r6.DisplayValue));
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](1, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](2, ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_div_2_Template, 3, 2, "div", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const product_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](2).$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngForOf", product_r3 == null ? null : product_r3.seletedOptions);
  }
}
function ProductAddedComponent_div_0_div_2_div_1_ng_container_3_Template(rf, ctx) {
  if (rf & 1) {
    const _r5 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_2_div_1_ng_container_3_ng_container_1_Template, 3, 1, "ng-container", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](2, "ion-button", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵlistener"]("click", function ProductAddedComponent_div_0_div_2_div_1_ng_container_3_Template_ion_button_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵrestoreView"](_r5);
      const product_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
      const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵresetView"](ctx_r3.openProductOptionsModal(product_r3));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](3, " Edit ");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const product_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", product_r3 == null ? null : product_r3.seletedOptions == null ? null : product_r3.seletedOptions.length);
  }
}
function ProductAddedComponent_div_0_div_2_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 7)(1, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](2, ProductAddedComponent_div_0_div_2_div_1_ng_container_2_Template, 4, 1, "ng-container", 9)(3, ProductAddedComponent_div_0_div_2_div_1_ng_container_3_Template, 4, 1, "ng-container", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](4, "div", 10)(5, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelement"](6, "mag-product-cta", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](7, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](9, "currency");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]()()();
  }
  if (rf & 2) {
    const product_r3 = ctx.$implicit;
    const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (product_r3 == null ? null : product_r3.productType) === "GiftCard");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", (product_r3 == null ? null : product_r3.productType) !== "GiftCard");
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("buttonViewMode", ctx_r3.btnMode)("selectedOptions", product_r3 == null ? null : product_r3.rawSelectedOptionsets)("product", ctx_r3.configData == null ? null : ctx_r3.configData.rawProduct)("isFullWidth", true);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtextInterpolate1"]("Total: ", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind4"](9, 7, product_r3 == null ? null : product_r3.totalPrice, "USD", "symbol", "1.2-2"), "");
  }
}
function ProductAddedComponent_div_0_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_2_div_1_Template, 10, 12, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const inCartProducts_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵnextContext"]().ngIf;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngForOf", inCartProducts_r7);
  }
}
function ProductAddedComponent_div_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementStart"](0, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](1, ProductAddedComponent_div_0_div_1_Template, 2, 0, "div", 2)(2, ProductAddedComponent_div_0_div_2_Template, 2, 1, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const inCartProducts_r7 = ctx.ngIf;
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", inCartProducts_r7 == null ? null : inCartProducts_r7.length);
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", inCartProducts_r7 == null ? null : inCartProducts_r7.length);
  }
}
// import { escape } from 'lodash';
class ProductAddedComponent {
  router;
  utils;
  route;
  modalCtrl;
  configData;
  set inCartProducts(value) {
    if (value) {
      this.inCartProductSubject.next(this.transformData(value));
    }
  }
  inCartProductSubject = new rxjs__WEBPACK_IMPORTED_MODULE_6__.BehaviorSubject([]);
  inCartProducts$ = this.inCartProductSubject.asObservable();
  subscriptions = new rxjs__WEBPACK_IMPORTED_MODULE_7__.Subscription();
  productType;
  btnMode = 'CART';
  constructor(router, utils, route, modalCtrl) {
    this.router = router;
    this.utils = utils;
    this.route = route;
    this.modalCtrl = modalCtrl;
  }
  // Lifecycle hooks
  ngOnInit() {
    this.productType = this.configData?.productType;
  }
  ngOnDestroy() {
    this.subscriptions.unsubscribe();
  }
  ngOnChanges(changes) {
    if (changes.configData) {
      this.productType = this.configData?.productType;
    }
    if (changes?.inCartProducts && changes?.inCartProducts?.currentValue) {
      this.inCartProductSubject.next(this.transformData(changes.inCartProducts.currentValue));
    }
  }
  // Data Retrieval and Handling
  transformData(products) {
    if (!products) return;
    products.forEach(item => {
      item['seletedOptions'] = (0,_model_util__WEBPACK_IMPORTED_MODULE_4__.getOptionSetsByType)(item?.rawSelectedOptionsets, item?.productType);
    });
    return products;
  }
  renderData(option) {
    if (!option?.OptionSetDisplayName) {
      return option?.DisplayName?.En + ':' + option?.Value;
    }
    switch (option?.OptionSetDisplayName) {
      case 'Style':
        return option?.OptionSetDisplayName + ':' + option?.DisplayName?.En;
      case 'Amount':
        return option?.OptionSetDisplayName + ':' + option?.PriceModifier;
    }
  }
  // Modal functions
  openGiftCardOptionsModal(product) {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        productOptionSet,
        regularPrice,
        productName,
        shoppingMode,
        rawProduct,
        productId,
        storeCode
      } = _this.configData;
      const modal = yield _this.modalCtrl.create({
        cssClass: 'gift-card-options-modal',
        component: _gift_card_options_modal_gift_card_options_modal__WEBPACK_IMPORTED_MODULE_3__.GiftCardOptionsModalComponent,
        componentProps: {
          giftCardOptions: productOptionSet,
          productName: productName,
          totalPrice: regularPrice,
          isEdit: true,
          rawProduct: rawProduct,
          shoppingMode: shoppingMode,
          productId: productId,
          storeCode: storeCode,
          selectedOptionSets: product?.rawSelectedOptionsets,
          quantity: product?.quantity,
          cartItemId: product?.cartItemId
        },
        breakpoints: [0, 0.5, 1],
        initialBreakpoint: 1,
        handle: false
      });
      modal.onDidDismiss().then(detail => {
        console.log('Gift card options selected  ====>', detail);
      });
      return yield modal.present();
    })();
  }
  openProductOptionsModal(product) {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        defaultImage,
        productOptionSet,
        regularPrice,
        productName,
        shoppingMode,
        rawProduct,
        productId,
        storeCode
      } = _this2.configData;
      const modal = yield _this2.modalCtrl.create({
        cssClass: 'product-options-modal',
        component: _product_options_modal_product_options_modal__WEBPACK_IMPORTED_MODULE_2__.ProductOptionsModalComponent,
        componentProps: {
          productOptionSet: productOptionSet,
          regularPrice: regularPrice,
          productName: productName,
          shoppingMode: shoppingMode,
          rawProduct: rawProduct,
          productId: productId,
          storeCode: storeCode,
          isEdit: true,
          defaultImage: defaultImage,
          selectedOptionSets: product?.rawSelectedOptionsets,
          quantity: product?.quantity,
          cartItemId: product?.cartItemId
        },
        breakpoints: [0, 0.5, 1],
        initialBreakpoint: 1,
        handle: false
      });
      modal.onDidDismiss().then(detail => {
        console.log('Options selecteds  ====>', detail);
      });
      return yield modal.present();
    })();
  }
  static ɵfac = function ProductAddedComponent_Factory(t) {
    return new (t || ProductAddedComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_9__.ModalController));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineComponent"]({
    type: ProductAddedComponent,
    selectors: [["product-added"]],
    inputs: {
      configData: "configData",
      inCartProducts: "inCartProducts"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵNgOnChangesFeature"]],
    decls: 2,
    vars: 3,
    consts: [["class", "cart-product", 4, "ngIf"], [1, "cart-product"], ["class", "cart-product__title", 4, "ngIf"], ["class", "cart-product__list", 4, "ngIf"], [1, "cart-product__title"], [1, "cart-product__list"], ["class", "cart-product__item", 4, "ngFor", "ngForOf"], [1, "cart-product__item"], [1, "cart-product__option-wrapper"], [4, "ngIf"], [1, "cart-product__information"], [1, "cart-product__quantity"], [3, "buttonViewMode", "selectedOptions", "product", "isFullWidth"], [1, "cart-product__total"], ["class", "cart-product__option-list", 4, "ngIf"], ["fill", "clear", 1, "cart-product__edit-option", 3, "click"], [1, "cart-product__option-list"], ["class", "cart-product__option-item", 4, "ngFor", "ngForOf"], [1, "cart-product__option-item"], [1, "cart-product__dot"], [1, "cart-product__option-item-title"]],
    template: function ProductAddedComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵtemplate"](0, ProductAddedComponent_div_0_Template, 3, 2, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipe"](1, "async");
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵproperty"]("ngIf", _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵpipeBind1"](1, 1, ctx.inCartProducts$));
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_10__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_10__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonButton, _angular_common__WEBPACK_IMPORTED_MODULE_10__.AsyncPipe, _angular_common__WEBPACK_IMPORTED_MODULE_10__.CurrencyPipe],
    styles: [".cart-product[_ngcontent-%COMP%] {\n  font-size: 14px;\n  line-height: 24px;\n  font-weight: 500;\n}\n.cart-product__title[_ngcontent-%COMP%] {\n  margin-bottom: 16px;\n  font-size: var(--mag-typography-headlines-small-font-size, 18px);\n  font-weight: var(--mag-typography-headlines-small-font-weight, 500);\n  line-height: var(--mag-typography-body-small-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n}\n.cart-product__list[_ngcontent-%COMP%] {\n  padding-left: 16px;\n  padding-right: 16px;\n  border: 1px solid #d8d8d8;\n  border-radius: 8px;\n}\n.cart-product__item[_ngcontent-%COMP%] {\n  padding: 24px 0px;\n}\n.cart-product__item[_ngcontent-%COMP%]:not(:last-child) {\n  border-bottom: 1px solid #d8d8d8;\n}\n.cart-product__option-wrapper[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n  gap: 16px;\n  margin-bottom: 16px;\n}\n.cart-product__option-list[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n}\n.cart-product__option-item[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-weight: var(--mag-typography-body-small-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-small-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n  flex: 1;\n  display: flex;\n  align-items: flex-start;\n  gap: 8px;\n}\n.cart-product__option-item[_ngcontent-%COMP%]:not(:last-child) {\n  margin-bottom: 2px;\n}\n.cart-product__dot[_ngcontent-%COMP%] {\n  display: inline-block;\n  width: 5px;\n  min-width: 5px;\n  height: 5px;\n  border-radius: 50%;\n  background: #000000;\n  margin-top: 7px;\n}\n.cart-product__edit-option[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 24px);\n  color: var(--mag-color-text-button-text-brand, #008000);\n}\n.cart-product__information[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: 16px;\n  justify-content: flex-start;\n}\n.cart-product__quantity[_ngcontent-%COMP%] {\n  width: 150px;\n}\n.cart-product__total[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  color: var(--mag-color-text-primary, #121212);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wcm9kdWN0LWFkZGVkL3Byb2R1Y3QtYWRkZWQuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGVBQUE7RUFDQSxpQkFBQTtFQUNBLGdCQUFBO0FBQ0Y7QUFBRTtFQUNFLG1CQUFBO0VBQ0EsZ0VBQUE7RUFDQSxtRUFBQTtFQUNBLCtEQUFBO0VBQ0EsNkNBQUE7QUFFSjtBQUNFO0VBQ0Usa0JBQUE7RUFDQSxtQkFBQTtFQUNBLHlCQUFBO0VBQ0Esa0JBQUE7QUFDSjtBQUVFO0VBQ0UsaUJBQUE7QUFBSjtBQUVJO0VBQ0UsZ0NBQUE7QUFBTjtBQUlFO0VBQ0UsYUFBQTtFQUNBLDhCQUFBO0VBQ0EsU0FBQTtFQUVBLG1CQUFBO0FBSEo7QUFNRTtFQUNFLGFBQUE7RUFDQSxzQkFBQTtBQUpKO0FBT0U7RUFDRSwyREFBQTtFQUNBLHNFQUFBO0VBQ0EsK0RBQUE7RUFDQSw2Q0FBQTtFQUVBLE9BQUE7RUFDQSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxRQUFBO0FBTko7QUFRSTtFQUNFLGtCQUFBO0FBTk47QUFVRTtFQUNFLHFCQUFBO0VBQ0EsVUFBQTtFQUNBLGNBQUE7RUFDQSxXQUFBO0VBQ0Esa0JBQUE7RUFDQSxtQkFBQTtFQUNBLGVBQUE7QUFSSjtBQVdFO0VBQ0Usb0VBQUE7RUFDQSxpRkFBQTtFQUNBLHdFQUFBO0VBQ0EsdURBQUE7QUFUSjtBQVlFO0VBQ0UsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsU0FBQTtFQUNBLDJCQUFBO0FBVko7QUFhRTtFQUNFLFlBQUE7QUFYSjtBQWNFO0VBQ0UsNERBQUE7RUFDQSwwRUFBQTtFQUNBLGdFQUFBO0VBQ0EsNkNBQUE7QUFaSiIsInNvdXJjZXNDb250ZW50IjpbIi5jYXJ0LXByb2R1Y3Qge1xuICBmb250LXNpemU6IDE0cHg7XG4gIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICBmb250LXdlaWdodDogNTAwO1xuICAmX190aXRsZSB7XG4gICAgbWFyZ2luLWJvdHRvbTogMTZweDtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWhlYWRsaW5lcy1zbWFsbC1mb250LXNpemUsIDE4cHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtc21hbGwtZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgfVxuXG4gICZfX2xpc3Qge1xuICAgIHBhZGRpbmctbGVmdDogMTZweDtcbiAgICBwYWRkaW5nLXJpZ2h0OiAxNnB4O1xuICAgIGJvcmRlcjogMXB4IHNvbGlkICNkOGQ4ZDg7XG4gICAgYm9yZGVyLXJhZGl1czogOHB4O1xuICB9XG5cbiAgJl9faXRlbSB7XG4gICAgcGFkZGluZzogMjRweCAwcHg7XG5cbiAgICAmOm5vdCg6bGFzdC1jaGlsZCkge1xuICAgICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkICNkOGQ4ZDg7XG4gICAgfVxuICB9XG5cbiAgJl9fb3B0aW9uLXdyYXBwZXIge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuICAgIGdhcDogMTZweDtcblxuICAgIG1hcmdpbi1ib3R0b206IDE2cHg7XG4gIH1cblxuICAmX19vcHRpb24tbGlzdCB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICB9XG5cbiAgJl9fb3B0aW9uLWl0ZW0ge1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1zbWFsbC1mb250LXNpemUsIDE0cHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtbGluZS1oZWlnaHQsIDI0cHgpO1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcblxuICAgIGZsZXg6IDE7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogZmxleC1zdGFydDtcbiAgICBnYXA6IDhweDtcblxuICAgICY6bm90KDpsYXN0LWNoaWxkKSB7XG4gICAgICBtYXJnaW4tYm90dG9tOiAycHg7XG4gICAgfVxuICB9XG5cbiAgJl9fZG90IHtcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XG4gICAgd2lkdGg6IDVweDtcbiAgICBtaW4td2lkdGg6IDVweDtcbiAgICBoZWlnaHQ6IDVweDtcbiAgICBib3JkZXItcmFkaXVzOiA1MCU7XG4gICAgYmFja2dyb3VuZDogIzAwMDAwMDtcbiAgICBtYXJnaW4tdG9wOiA3cHg7XG4gIH1cblxuICAmX19lZGl0LW9wdGlvbiB7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWZvbnQtc2l6ZSwgMTRweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbC1zbWFsbC1lbXBoYXNpemVkLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtYnV0dG9uLXRleHQtYnJhbmQsICMwMDgwMDApO1xuICB9XG5cbiAgJl9faW5mb3JtYXRpb24ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBnYXA6IDE2cHg7XG4gICAganVzdGlmeS1jb250ZW50OiBmbGV4LXN0YXJ0O1xuICB9XG5cbiAgJl9fcXVhbnRpdHkge1xuICAgIHdpZHRoOiAxNTBweDtcbiAgfVxuXG4gICZfX3RvdGFsIHtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LWVtcGhhc2l6ZWQsIDQwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gIH1cbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 15534:
/*!*********************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/product-content-collapse/product-content-collapse.ts ***!
  \*********************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductContentCollapseComponent: () => (/* binding */ ProductContentCollapseComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ 90852);





const _c0 = a0 => ({
  "product-content-collapse__des-content--blur": a0
});
function ProductContentCollapseComponent_div_1_span_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"]("", ctx_r0.title, ": ");
  }
}
function ProductContentCollapseComponent_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](1, ProductContentCollapseComponent_div_1_span_1_Template, 2, 1, "span", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](2, "ion-text", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipe"](3, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx_r0.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngClass", ctx_r0.contentClass)("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipeBind1"](3, 3, ctx_r0.content), _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsanitizeHtml"]);
  }
}
function ProductContentCollapseComponent_button_2_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "button", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵlistener"]("click", function ProductContentCollapseComponent_button_2_Template_button_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵrestoreView"](_r2);
      const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵresetView"](ctx_r0.changeDesView());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate1"](" ", ctx_r0.isReadMore ? _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipeBind1"](2, 1, "productDetail.readMore") : _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpipeBind1"](3, 3, "productDetail.readLess"), "\n");
  }
}
class ProductContentCollapseComponent {
  content;
  title = '';
  type = '';
  contentClass;
  isReadMore = true;
  hideReadMore = false;
  contentClasses = {};
  ngOnInit() {
    this.hideReadMore = this.content?.length < 250; // TODO
    this.contentClass = this.computeContentClasses();
  }
  ngOnDestroy() {
    this.isReadMore = true;
    this.hideReadMore = false;
  }
  computeContentClasses() {
    const isValidType = !!this.type;
    const style = {
      'product-content-collapse__content': this.isReadMore && !this.hideReadMore
    };
    if (!isValidType) {
      return {
        'product-content-collapse__content': this.isReadMore && !this.hideReadMore
      };
    }
    style[`product-content-collapse__content--${this.type}`] = true;
    return style;
  }
  changeDesView() {
    this.isReadMore = !this.isReadMore;
    this.contentClass = this.computeContentClasses();
  }
  static ɵfac = function ProductContentCollapseComponent_Factory(t) {
    return new (t || ProductContentCollapseComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({
    type: ProductContentCollapseComponent,
    selectors: [["product-content-collapse"]],
    inputs: {
      content: "content",
      title: "title",
      type: "type"
    },
    decls: 3,
    vars: 5,
    consts: [[1, "product-content-collapse__des-content", 3, "ngClass"], [4, "ngIf"], ["class", "product-content-collapse__read-more", 3, "click", 4, "ngIf"], [3, "ngClass", "innerHTML"], [1, "product-content-collapse__read-more", 3, "click"]],
    template: function ProductContentCollapseComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](1, ProductContentCollapseComponent_div_1_Template, 4, 5, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](2, ProductContentCollapseComponent_button_2_Template, 4, 5, "button", 2);
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpureFunction1"](3, _c0, ctx.isReadMore && !ctx.hideReadMore));
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.content == null ? null : ctx.content.length);
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", !ctx.hideReadMore);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_2__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_2__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_3__.IonText, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_0__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__.TranslatePipe],
    styles: [".product-content-collapse__des-content[_ngcontent-%COMP%] {\n  position: relative;\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px); \n\n  margin-top: var(--mag-spacing-300, 24px);\n}\n.product-content-collapse__des-content--blur[_ngcontent-%COMP%]:after {\n  position: absolute;\n  content: \"\";\n  filter: blur(10px);\n  height: 24px;\n  background: #ffffff;\n  left: -10px;\n  right: -10px;\n  bottom: 0;\n}\n.product-content-collapse__content[_ngcontent-%COMP%] {\n  overflow: hidden;\n  display: -webkit-box;\n  -webkit-line-clamp: 4;\n  -webkit-box-orient: vertical;\n}\n.product-content-collapse__read-more[_ngcontent-%COMP%] {\n  background: transparent;\n  border: none;\n  color: var(--mag-color-text-button-text-brand, #008000);\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 20px); \n\n  margin-bottom: var(--mag-spacing-300, 24px);\n}\n.product-content-collapse__content--declaimer[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  \n\n  font-family: var(--mag-typography-platform-font-family, Lexend);\n  font-size: var(--mag-typography-subtext-font-size, 12px);\n  font-style: normal;\n  font-weight: var(--mag-typography-subtext-font-weight-regular, 300);\n  line-height: var(--mag-typography-subtext-line-height, 16px); \n\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wcm9kdWN0LWNvbnRlbnQtY29sbGFwc2UvcHJvZHVjdC1jb250ZW50LWNvbGxhcHNlLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQ0U7RUFDRSxrQkFBQTtFQUNBLDREQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQSxFQUFBLFNBQUE7RUFFQSx3Q0FBQTtBQURKO0FBR0k7RUFDRSxrQkFBQTtFQUNBLFdBQUE7RUFDQSxrQkFBQTtFQUNBLFlBQUE7RUFDQSxtQkFBQTtFQUNBLFdBQUE7RUFDQSxZQUFBO0VBQ0EsU0FBQTtBQUROO0FBS0U7RUFDRSxnQkFBQTtFQUNBLG9CQUFBO0VBQ0EscUJBQUE7RUFDQSw0QkFBQTtBQUhKO0FBTUU7RUFDRSx1QkFBQTtFQUNBLFlBQUE7RUFDQSx1REFBQTtFQUNBLG9FQUFBO0VBQ0EsaUZBQUE7RUFDQSx3RUFBQSxFQUFBLGFBQUE7RUFFQSwyQ0FBQTtBQUxKO0FBUUU7RUFDRSwwQ0FBQTtFQUNBLG9CQUFBO0VBQ0EsK0RBQUE7RUFDQSx3REFBQTtFQUNBLGtCQUFBO0VBQ0EsbUVBQUE7RUFDQSw0REFBQSxFQUFBLGFBQUE7QUFOSiIsInNvdXJjZXNDb250ZW50IjpbIi5wcm9kdWN0LWNvbnRlbnQtY29sbGFwc2Uge1xuICAmX19kZXMtY29udGVudCB7XG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpOyAvKiAxNTAlICovXG5cbiAgICBtYXJnaW4tdG9wOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpO1xuXG4gICAgJi0tYmx1cjphZnRlciB7XG4gICAgICBwb3NpdGlvbjogYWJzb2x1dGU7XG4gICAgICBjb250ZW50OiAnJztcbiAgICAgIGZpbHRlcjogYmx1cigxMHB4KTtcbiAgICAgIGhlaWdodDogMjRweDtcbiAgICAgIGJhY2tncm91bmQ6ICNmZmZmZmY7XG4gICAgICBsZWZ0OiAtMTBweDtcbiAgICAgIHJpZ2h0OiAtMTBweDtcbiAgICAgIGJvdHRvbTogMDtcbiAgICB9XG4gIH1cblxuICAmX19jb250ZW50IHtcbiAgICBvdmVyZmxvdzogaGlkZGVuO1xuICAgIGRpc3BsYXk6IC13ZWJraXQtYm94O1xuICAgIC13ZWJraXQtbGluZS1jbGFtcDogNDtcbiAgICAtd2Via2l0LWJveC1vcmllbnQ6IHZlcnRpY2FsO1xuICB9XG5cbiAgJl9fcmVhZC1tb3JlIHtcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcbiAgICBib3JkZXI6IG5vbmU7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJ1dHRvbi10ZXh0LWJyYW5kLCAjMDA4MDAwKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtc21hbGwtZm9udC1zaXplLCAxNHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYnV0dG9uLWxhYmVsLXNtYWxsLWVtcGhhc2l6ZWQtZm9udC13ZWlnaHQsIDUwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtc21hbGwtbGluZS1oZWlnaHQsIDIwcHgpOyAvKiAxNDIuODU3JSAqL1xuXG4gICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcbiAgfVxuXG4gICZfX2NvbnRlbnQtLWRlY2xhaW1lciB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWluZm8sICM2NDcyODEpO1xuICAgIC8qIFN1YnRleHQvUmVndWxhciAqL1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXN1YnRleHQtZm9udC1zaXplLCAxMnB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXN1YnRleHQtZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1saW5lLWhlaWdodCwgMTZweCk7IC8qIDEzMy4zMzMlICovXG4gIH1cbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 79658:
/*!***************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/product-options-modal/product-options-modal.ts ***!
  \***************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductOptionsModalComponent: () => (/* binding */ ProductOptionsModalComponent)
/* harmony export */ });
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _model_util__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../model/util */ 38372);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ 75797);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! rxjs */ 52575);
/* harmony import */ var _providers_product_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../providers/product.service */ 13487);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _product_options_selector_product_options_selector__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../product-options-selector/product-options-selector */ 68771);
/* harmony import */ var _custom_photos_custom_photos__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../custom-photos/custom-photos */ 73418);













function ProductOptionsModalComponent_div_8_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](0, "div", 13)(1, "product-options-selector", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵlistener"]("handleChangeOption", function ProductOptionsModalComponent_div_8_Template_product_options_selector_handleChangeOption_1_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵrestoreView"](_r1);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵresetView"](ctx_r1.onChangeOption($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const option_r3 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("productOptions", option_r3);
  }
}
class ProductOptionsModalComponent {
  modalCtrl;
  productService;
  utils;
  productOptionSet;
  selectedOptionSets;
  regularPrice;
  quantity;
  rawProduct;
  productName;
  isEdit = false;
  defaultImage;
  inCartProducts = [];
  cartItemId;
  totalVal;
  btnMode = 'MODAL';
  submitOptions = [];
  allOptionSetsWithSelectedValue;
  renderOptionSets = [];
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_7__.Subject();
  seletedOptions$ = new rxjs__WEBPACK_IMPORTED_MODULE_8__.BehaviorSubject([]);
  optionPhotos$ = new rxjs__WEBPACK_IMPORTED_MODULE_8__.BehaviorSubject([]);
  constructor(modalCtrl, productService, utils) {
    this.modalCtrl = modalCtrl;
    this.productService = productService;
    this.utils = utils;
  }
  // Lifecycle Hooks
  ngOnInit() {
    try {
      this.subscribeToSelectedOptions();
      if (this.defaultImage) {
        this.defaultImage = JSON.parse(this.defaultImage)[0];
      }
      this.regularPrice = parseFloat(this.regularPrice?.replace(/\$/g, '')) || 0;
      this.allOptionSetsWithSelectedValue = (0,_model_util__WEBPACK_IMPORTED_MODULE_1__.formatData)(this.productOptionSet, this.isEdit, this.selectedOptionSets);
      this.prepareRenderOptionSets(this.productOptionSet, this.allOptionSetsWithSelectedValue);
      window.addEventListener('actionSuccess', event => this.handleActionSuccess(event));
    } catch (err) {
      console.error(err);
    }
  }
  handleActionSuccess(event) {
    if (event?.detail) {
      this.closeModal();
    }
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
    window.removeEventListener('actionSuccess', event => this.handleActionSuccess(event));
  }
  subscribeToSelectedOptions() {
    this.seletedOptions$.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_9__.takeUntil)(this._destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_10__.debounceTime)(300)).subscribe(optionSets => {
      if (optionSets) {
        this.setPhotos(optionSets);
        this.renderOptionSets = optionSets;
        this.totalVal = (0,_model_util__WEBPACK_IMPORTED_MODULE_1__.getTotalOptionsPrices)(optionSets, this.regularPrice) * (this.quantity || 1);
        this.transformDataForSubmit(optionSets);
      }
    });
  }
  prepareRenderOptionSets(optionSetsGroup, allOptionSetsWithSelectedValue) {
    const rs = (0,_model_util__WEBPACK_IMPORTED_MODULE_1__.getRenderOptionSets)((0,lodash__WEBPACK_IMPORTED_MODULE_0__.cloneDeep)(optionSetsGroup), (0,lodash__WEBPACK_IMPORTED_MODULE_0__.cloneDeep)(allOptionSetsWithSelectedValue));
    this.seletedOptions$.next(rs);
  }
  setPhotos(optionSets) {
    // Scan all option sets from (Final render data) to get SelectedOptionImage, SelectedOptionValue, ParentDisplayOrder.
    // Z-index is determine by ParentDisplayOrder * 100 + idx.
    if (!optionSets) return;
    const photos = (0,_model_util__WEBPACK_IMPORTED_MODULE_1__.getOptionSetsPhotos)(optionSets);
    if (photos?.length) {
      this.defaultImage = null;
    }
    this.optionPhotos$.next(photos);
  }
  transformDataForSubmit(optionSets) {
    const submitOptionSets = (0,_model_util__WEBPACK_IMPORTED_MODULE_1__.getSubmitOptionSets)((0,lodash__WEBPACK_IMPORTED_MODULE_0__.cloneDeep)(optionSets));
    const submitOptionSetsGroup = (0,_model_util__WEBPACK_IMPORTED_MODULE_1__.getSubmitOptionSetsGroup)(submitOptionSets, (0,lodash__WEBPACK_IMPORTED_MODULE_0__.cloneDeep)(this.productOptionSet));
    if (submitOptionSetsGroup?.length) {
      this.submitOptions = submitOptionSetsGroup;
    }
  }
  onChangeOption(optionSet) {
    const foundOptionSet = this.allOptionSetsWithSelectedValue.find(item => item.Id === optionSet.Id);
    if (foundOptionSet) {
      Object.assign(foundOptionSet, optionSet);
    }
    this.prepareRenderOptionSets(this.productOptionSet, this.allOptionSetsWithSelectedValue);
  }
  // Modal functions
  closeModal() {
    return this.modalCtrl.dismiss();
  }
  static ɵfac = function ProductOptionsModalComponent_Factory(t) {
    return new (t || ProductOptionsModalComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_11__.ModalController), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_providers_product_service__WEBPACK_IMPORTED_MODULE_2__.ProductService), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_3__.Utils));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineComponent"]({
    type: ProductOptionsModalComponent,
    selectors: [["product-options-modal"]],
    inputs: {
      productOptionSet: "productOptionSet",
      selectedOptionSets: "selectedOptionSets",
      regularPrice: "regularPrice",
      quantity: "quantity",
      rawProduct: "rawProduct",
      productName: "productName",
      isEdit: "isEdit",
      defaultImage: "defaultImage",
      inCartProducts: "inCartProducts",
      cartItemId: "cartItemId"
    },
    decls: 19,
    vars: 16,
    consts: [[1, "product-modal__header"], ["tabindex", "0", 1, "product-modal__close-btn", 3, "click", "keydown"], ["src", "assets/icon/close-modal-ico.svg"], [1, "product-modal__title"], [1, "product-modal__content"], [3, "photos$", "imageRenderedUrl"], ["class", "product-modal__option-selector", 4, "ngFor", "ngForOf"], [1, "product-modal__toolbar"], [1, "product-modal__total-price"], [1, "product-modal__total-price-text"], [1, "product-modal__total-price-value"], [1, "btn-add"], [3, "buttonViewMode", "selectedOptions", "product", "isEditOption", "productOptionInCartId", "isFullWidth"], [1, "product-modal__option-selector"], [3, "handleChangeOption", "productOptions"]],
    template: function ProductOptionsModalComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](0, "ion-header", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵlistener"]("click", function ProductOptionsModalComponent_Template_div_click_1_listener() {
          return ctx.closeModal();
        })("keydown", function ProductOptionsModalComponent_Template_div_keydown_1_listener() {
          return ctx.closeModal();
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](2, "ion-img", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](5, "ion-content")(6, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](7, "custom-photos", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtemplate"](8, ProductOptionsModalComponent_div_8_Template, 2, 1, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](9, "ion-footer")(10, "ion-toolbar", 7)(11, "div", 8)(12, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtext"](13, "Total");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](14, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtext"](15);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵpipe"](16, "currency");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](17, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](18, "mag-product-cta", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtextInterpolate"](ctx.productName);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("photos$", ctx.optionPhotos$)("imageRenderedUrl", ctx.defaultImage);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("ngForOf", ctx.renderOptionSets);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵpipeBind4"](16, 11, ctx.totalVal, "USD", "symbol", "1.2-2"));
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("buttonViewMode", ctx.btnMode)("selectedOptions", ctx.submitOptions)("product", ctx.rawProduct)("isEditOption", ctx.isEdit)("productOptionInCartId", ctx.cartItemId)("isFullWidth", true);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_12__.NgForOf, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonFooter, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_11__.IonToolbar, _product_options_selector_product_options_selector__WEBPACK_IMPORTED_MODULE_4__.ProductOptionsSelectorComponent, _custom_photos_custom_photos__WEBPACK_IMPORTED_MODULE_5__.CustomPhotosComponent, _angular_common__WEBPACK_IMPORTED_MODULE_12__.CurrencyPipe],
    styles: [".product-modal__header[_ngcontent-%COMP%] {\n  padding-left: 16px !important;\n  padding-right: 16px !important;\n}\n.product-modal__close-btn[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: flex-end;\n  align-items: center;\n  padding-top: 16px;\n  padding-bottom: 16px;\n}\n.product-modal__title[_ngcontent-%COMP%] {\n  font-weight: 600;\n  font-size: 18px;\n  line-height: 28px;\n  padding-bottom: 16px;\n}\n.product-modal__content[_ngcontent-%COMP%] {\n  padding-left: 16px !important;\n  padding-right: 16px !important;\n  padding-top: 16px;\n}\n.product-modal__wrapper[_ngcontent-%COMP%] {\n  position: sticky;\n  top: 0px;\n  background: white;\n  z-index: 999;\n  transition: opacity 0.5s ease-out;\n  opacity: 1;\n}\n.product-modal__option-selector[_ngcontent-%COMP%]:not(:last-child) {\n  border-bottom: 1px solid var(--mag-border);\n}\n.product-modal__total-price[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: space-between;\n  align-items: center;\n  font-size: 18px;\n  line-height: 28px;\n  font-weight: 600;\n  margin-bottom: 16px;\n}\n.product-modal__toolbar[_ngcontent-%COMP%] {\n  padding: 0 !important;\n  --background: transparent;\n  --padding-top: 16px;\n  --padding-bottom: 16px;\n  --padding-end: 16px;\n  --padding-start: 16px;\n}\n.product-modal__submit-btn[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n}\n.product-modal__submit-btn[_ngcontent-%COMP%]::part(native) {\n  height: 48px;\n}\n\nion-content[_ngcontent-%COMP%] {\n  border-top: 1px solid var(--mag-border);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wcm9kdWN0LW9wdGlvbnMtbW9kYWwvcHJvZHVjdC1vcHRpb25zLW1vZGFsLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQ0U7RUFDRSw2QkFBQTtFQUNBLDhCQUFBO0FBQUo7QUFHRTtFQUNFLGFBQUE7RUFDQSx5QkFBQTtFQUNBLG1CQUFBO0VBQ0EsaUJBQUE7RUFDQSxvQkFBQTtBQURKO0FBSUU7RUFDRSxnQkFBQTtFQUNBLGVBQUE7RUFDQSxpQkFBQTtFQUNBLG9CQUFBO0FBRko7QUFLRTtFQUNFLDZCQUFBO0VBQ0EsOEJBQUE7RUFDQSxpQkFBQTtBQUhKO0FBTUU7RUFDRSxnQkFBQTtFQUNBLFFBQUE7RUFDQSxpQkFBQTtFQUNBLFlBQUE7RUFDQSxpQ0FBQTtFQUNBLFVBQUE7QUFKSjtBQU9FO0VBQ0UsMENBQUE7QUFMSjtBQVFFO0VBQ0UsYUFBQTtFQUNBLDhCQUFBO0VBQ0EsbUJBQUE7RUFDQSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxnQkFBQTtFQUNBLG1CQUFBO0FBTko7QUFpQkU7RUFDRSxxQkFBQTtFQUNBLHlCQUFBO0VBQ0EsbUJBQUE7RUFDQSxzQkFBQTtFQUNBLG1CQUFBO0VBQ0EscUJBQUE7QUFmSjtBQWtCRTtFQUNFLDBEQUFBO0FBaEJKO0FBa0JJO0VBQ0UsWUFBQTtBQWhCTjs7QUFxQkE7RUFDRSx1Q0FBQTtBQWxCRiIsInNvdXJjZXNDb250ZW50IjpbIi5wcm9kdWN0LW1vZGFsIHtcbiAgJl9faGVhZGVyIHtcbiAgICBwYWRkaW5nLWxlZnQ6IDE2cHggIWltcG9ydGFudDtcbiAgICBwYWRkaW5nLXJpZ2h0OiAxNnB4ICFpbXBvcnRhbnQ7XG4gIH1cblxuICAmX19jbG9zZS1idG4ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBmbGV4LWVuZDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIHBhZGRpbmctdG9wOiAxNnB4O1xuICAgIHBhZGRpbmctYm90dG9tOiAxNnB4O1xuICB9XG5cbiAgJl9fdGl0bGUge1xuICAgIGZvbnQtd2VpZ2h0OiA2MDA7XG4gICAgZm9udC1zaXplOiAxOHB4O1xuICAgIGxpbmUtaGVpZ2h0OiAyOHB4O1xuICAgIHBhZGRpbmctYm90dG9tOiAxNnB4O1xuICB9XG5cbiAgJl9fY29udGVudCB7XG4gICAgcGFkZGluZy1sZWZ0OiAxNnB4ICFpbXBvcnRhbnQ7XG4gICAgcGFkZGluZy1yaWdodDogMTZweCAhaW1wb3J0YW50O1xuICAgIHBhZGRpbmctdG9wOiAxNnB4O1xuICB9XG5cbiAgJl9fd3JhcHBlciB7XG4gICAgcG9zaXRpb246IHN0aWNreTtcbiAgICB0b3A6IDBweDtcbiAgICBiYWNrZ3JvdW5kOiB3aGl0ZTtcbiAgICB6LWluZGV4OiA5OTk7XG4gICAgdHJhbnNpdGlvbjogb3BhY2l0eSAwLjVzIGVhc2Utb3V0O1xuICAgIG9wYWNpdHk6IDE7XG4gIH1cblxuICAmX19vcHRpb24tc2VsZWN0b3I6bm90KDpsYXN0LWNoaWxkKSB7XG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIHZhcigtLW1hZy1ib3JkZXIpO1xuICB9XG5cbiAgJl9fdG90YWwtcHJpY2Uge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgZm9udC1zaXplOiAxOHB4O1xuICAgIGxpbmUtaGVpZ2h0OiAyOHB4O1xuICAgIGZvbnQtd2VpZ2h0OiA2MDA7XG4gICAgbWFyZ2luLWJvdHRvbTogMTZweDtcblxuICAgICYtdGV4dCB7XG4gICAgICAvLyBTdHlsZXMgZm9yIHRvdGFsIHByaWNlIHRleHQgaWYgbmVlZGVkXG4gICAgfVxuXG4gICAgJi12YWx1ZSB7XG4gICAgICAvLyBTdHlsZXMgZm9yIHRvdGFsIHByaWNlIHZhbHVlIGlmIG5lZWRlZFxuICAgIH1cbiAgfVxuXG4gICZfX3Rvb2xiYXIge1xuICAgIHBhZGRpbmc6IDAgIWltcG9ydGFudDtcbiAgICAtLWJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xuICAgIC0tcGFkZGluZy10b3A6IDE2cHg7XG4gICAgLS1wYWRkaW5nLWJvdHRvbTogMTZweDtcbiAgICAtLXBhZGRpbmctZW5kOiAxNnB4O1xuICAgIC0tcGFkZGluZy1zdGFydDogMTZweDtcbiAgfVxuXG4gICZfX3N1Ym1pdC1idG4ge1xuICAgIC0tYmFja2dyb3VuZDogdmFyKC0tbWFnLWJyYW5kLWZvdW5kYXRpb24tcHJpbWFyeSwgIzAwODAwMCk7XG5cbiAgICAmOjpwYXJ0KG5hdGl2ZSkge1xuICAgICAgaGVpZ2h0OiA0OHB4O1xuICAgIH1cbiAgfVxufVxuXG5pb24tY29udGVudCB7XG4gIGJvcmRlci10b3A6IDFweCBzb2xpZCB2YXIoLS1tYWctYm9yZGVyKTtcbn1cbiJdLCJzb3VyY2VSb290IjoiIn0= */"]
  });
}

/***/ }),

/***/ 68771:
/*!*********************************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/components/product-options-selector/product-options-selector.ts ***!
  \*********************************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductOptionsSelectorComponent: () => (/* binding */ ProductOptionsSelectorComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _model_util__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../model/util */ 38372);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs */ 52575);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);








const _c0 = a0 => ({
  "background-image": a0
});
const _c1 = a0 => ({
  "color-active": a0
});
const _c2 = a0 => ({
  "option__single-check--selected": a0
});
const _c3 = () => ({
  cssClass: "popover-product-options"
});
function ProductOptionsSelectorComponent_ng_container_5_div_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function ProductOptionsSelectorComponent_ng_container_5_div_1_Template_div_click_0_listener() {
      const option_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(option_r2));
    })("keydown", function ProductOptionsSelectorComponent_ng_container_5_div_1_Template_div_keydown_0_listener() {
      const option_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(option_r2));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const option_r2 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction1"](2, _c0, "url(" + (option_r2 == null ? null : option_r2.IconUrl) + ")"))("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction1"](4, _c1, (ctx_r2.selectedOptions[0] == null ? null : ctx_r2.selectedOptions[0].Id) === (option_r2 == null ? null : option_r2.Id)));
  }
}
function ProductOptionsSelectorComponent_ng_container_5_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, ProductOptionsSelectorComponent_ng_container_5_div_1_Template, 1, 6, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.Options);
  }
}
function ProductOptionsSelectorComponent_ng_container_6_div_1_div_1_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "div", 13);
  }
}
function ProductOptionsSelectorComponent_ng_container_6_div_1_div_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function ProductOptionsSelectorComponent_ng_container_6_div_1_div_1_Template_div_click_0_listener() {
      const option_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r4).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(option_r5));
    })("keydown", function ProductOptionsSelectorComponent_ng_container_6_div_1_div_1_Template_div_keydown_0_listener() {
      const option_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r4).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(option_r5));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](1, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](2, ProductOptionsSelectorComponent_ng_container_6_div_1_div_1_div_2_Template, 1, 0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const option_r5 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction1"](3, _c2, (ctx_r2.selectedOptions[0] == null ? null : ctx_r2.selectedOptions[0].Id) === (option_r5 == null ? null : option_r5.Id)));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx_r2.selectedOptions[0] == null ? null : ctx_r2.selectedOptions[0].Id) === (option_r5 == null ? null : option_r5.Id));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](option_r5 == null ? null : option_r5.DisplayName == null ? null : option_r5.DisplayName.En);
  }
}
function ProductOptionsSelectorComponent_ng_container_6_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, ProductOptionsSelectorComponent_ng_container_6_div_1_div_1_Template, 5, 5, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.Options);
  }
}
function ProductOptionsSelectorComponent_ng_container_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, ProductOptionsSelectorComponent_ng_container_6_div_1_Template, 2, 1, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.Options);
  }
}
function ProductOptionsSelectorComponent_ng_container_7_div_1_div_1_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "ion-checkbox", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const option_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]().$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpropertyInterpolate"]("checked", ctx_r2.detectCheckBox(option_r7 == null ? null : option_r7.Id));
  }
}
function ProductOptionsSelectorComponent_ng_container_7_div_1_div_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("click", function ProductOptionsSelectorComponent_ng_container_7_div_1_div_1_Template_div_click_0_listener() {
      const option_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r6).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(option_r7));
    })("keydown", function ProductOptionsSelectorComponent_ng_container_7_div_1_div_1_Template_div_keydown_0_listener() {
      const option_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r6).$implicit;
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(option_r7));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, ProductOptionsSelectorComponent_ng_container_7_div_1_div_1_div_1_Template, 2, 1, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const option_r7 = ctx.$implicit;
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx_r2.productOptions == null ? null : ctx_r2.productOptions.DisplayType) === "checkbox");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](option_r7 == null ? null : option_r7.DisplayName == null ? null : option_r7.DisplayName.En);
  }
}
function ProductOptionsSelectorComponent_ng_container_7_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, ProductOptionsSelectorComponent_ng_container_7_div_1_div_1_Template, 4, 2, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.Options);
  }
}
function ProductOptionsSelectorComponent_ng_container_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, ProductOptionsSelectorComponent_ng_container_7_div_1_Template, 2, 1, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.Options);
  }
}
function ProductOptionsSelectorComponent_ng_container_8_ion_select_option_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "ion-select-option", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const option_r9 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("value", option_r9 == null ? null : option_r9.Id);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate1"](" ", option_r9 == null ? null : option_r9.DisplayName == null ? null : option_r9.DisplayName.En, " ");
  }
}
function ProductOptionsSelectorComponent_ng_container_8_Template(rf, ctx) {
  if (rf & 1) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](1, "div", 7)(2, "ion-select", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("ionChange", function ProductOptionsSelectorComponent_ng_container_8_Template_ion_select_ionChange_2_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r8);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.selectOption(ctx_r2.productOptions, $event == null ? null : $event.detail == null ? null : $event.detail.value));
    })("click", function ProductOptionsSelectorComponent_ng_container_8_Template_ion_select_click_2_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r8);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.ionSelectOptionFocus());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3, " > ");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](4, ProductOptionsSelectorComponent_ng_container_8_ion_select_option_4_Template, 2, 2, "ion-select-option", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("value", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.SelectedOptionValue)("interfaceOptions", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction0"](3, _c3));
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngForOf", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.Options);
  }
}
function ProductOptionsSelectorComponent_ng_container_9_Template(rf, ctx) {
  if (rf & 1) {
    const _r10 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](1, "div", 7)(2, "textarea", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("ngModelChange", function ProductOptionsSelectorComponent_ng_container_9_Template_textarea_ngModelChange_2_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r10);
      const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r2.hanldeChangeMesage($event, ctx_r2.productOptions));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "div", 21)(4, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](5, " Maximum of 50 characters ");
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]()()();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngModel", ctx_r2.productOptions == null ? null : ctx_r2.productOptions.SelectedOptionValue);
  }
}
class ProductOptionsSelectorComponent {
  productOptions;
  handleChangeOption = new _angular_core__WEBPACK_IMPORTED_MODULE_2__.EventEmitter();
  selectedOptions = [];
  message = '';
  optionChangeSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__.Subject();
  subscription;
  updatedOptionSet;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_3__.Subject();
  // Lifecycle hooks
  ngOnInit() {
    this.optionChangeSubject.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_4__.takeUntil)(this._destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_5__.debounceTime)(500) // Adjust the debounce time as needed
    ).subscribe(expected => {
      this.handleChangeOption.emit((0,lodash__WEBPACK_IMPORTED_MODULE_0__.cloneDeep)(expected));
    });
    this.setSelectedOptions();
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  // Data Retrieval and Handling
  setSelectedOptions() {
    if (!this.productOptions) return;
    this.selectedOptions = []; // Clear previously selected options
    switch (this.productOptions?.DisplayType) {
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.SELECT:
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.RADIO:
        {
          const selectedValue = this.productOptions?.SelectedOptionValue;
          if (selectedValue) {
            this.selectedOptions.push({
              Id: selectedValue
            });
          }
          break;
        }
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.CHECKBOX:
        this.productOptions?.SelectedValues?.forEach(val => {
          if (val) this.selectedOptions.push({
            Id: val
          });
        });
        break;
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.INPUT:
        this.message = this.productOptions?.SelectedOptionValue;
        break;
    }
  }
  ionSelectOptionFocus() {
    setTimeout(() => {
      const optionsEl = document.querySelectorAll('.popover-product-options .item ion-label');
      if (optionsEl) {
        optionsEl.forEach(optionEl => {
          if (optionEl.innerHTML && optionEl.innerHTML.length > 35) {
            optionEl.classList.add('ion-option-text-wrap');
          }
        });
      }
    }, 50);
  }
  hanldeChangeMesage(e, option) {
    this.message = e;
    this.selectOption(option);
  }
  detectCheckBox(optionId) {
    if (!this.selectedOptions) return;
    return this.selectedOptions?.findIndex(item => item?.Id === optionId) > -1;
  }
  selectOption(option, optionId) {
    this.selectedOptions = this.selectedOptions.filter(item => item?.Id != null);
    const updatedOptionSet = (0,lodash__WEBPACK_IMPORTED_MODULE_0__.cloneDeep)(this.productOptions);
    switch (updatedOptionSet.DisplayType) {
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.RADIO:
        updatedOptionSet.SelectedOptionValue = option?.Id;
        updatedOptionSet.SelectedOptionImage = option?.ImageUrl;
        break;
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.SELECT:
        {
          const foundOption = option?.Options?.find(item => item?.Id === optionId);
          if (!foundOption) return;
          updatedOptionSet.SelectedOptionValue = foundOption?.Id;
          updatedOptionSet.SelectedOptionImage = foundOption?.ImageUrl;
          break;
        }
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.CHECKBOX:
        {
          const itemIndex = this.selectedOptions.findIndex(item => item?.Id === option?.Id);
          if (itemIndex === -1) {
            this.selectedOptions.push({
              Id: option?.Id
            });
          } else {
            this.selectedOptions.splice(itemIndex, 1);
          }
          const optionsMap = new Map(updatedOptionSet.Options.map(option => [option.Id, option]));
          const foundOptions = this.selectedOptions.map(item => optionsMap.get(item.Id)).filter(Boolean);
          updatedOptionSet.SelectedOptionValue = foundOptions?.[foundOptions?.length - 1]?.Id;
          updatedOptionSet.SelectedOptionImage = foundOptions?.[foundOptions?.length - 1]?.ImageUrl;
          updatedOptionSet.SelectedValues = foundOptions?.map(option => option?.Id);
          break;
        }
      case _model_util__WEBPACK_IMPORTED_MODULE_1__.DisplayTypes.INPUT:
        updatedOptionSet.SelectedOptionValue = this.message;
        break;
    }
    this.optionChangeSubject.next(updatedOptionSet);
  }
  static ɵfac = function ProductOptionsSelectorComponent_Factory(t) {
    return new (t || ProductOptionsSelectorComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: ProductOptionsSelectorComponent,
    selectors: [["product-options-selector"]],
    inputs: {
      productOptions: "productOptions"
    },
    outputs: {
      handleChangeOption: "handleChangeOption"
    },
    decls: 10,
    vars: 7,
    consts: [[1, "option"], [1, "option__title"], [1, "option__condition"], [4, "ngIf"], ["class", "color-radio", "tabindex", "0", 3, "ngStyle", "ngClass", "click", "keydown", 4, "ngFor", "ngForOf"], ["tabindex", "0", 1, "color-radio", 3, "click", "keydown", "ngStyle", "ngClass"], ["class", "option__list", 4, "ngIf"], [1, "option__list"], ["tabindex", "0", "class", "option__list-item", 3, "click", "keydown", 4, "ngFor", "ngForOf"], ["tabindex", "0", 1, "option__list-item", 3, "click", "keydown"], [1, "option__single-check", 3, "ngClass"], ["class", "option__single-check--checked", 4, "ngIf"], [1, "option__name"], [1, "option__single-check--checked"], ["class", "option__multi-check", 4, "ngIf"], [1, "option__multi-check"], [3, "checked"], ["interface", "popover", 3, "ionChange", "click", "value", "interfaceOptions"], [3, "value", 4, "ngFor", "ngForOf"], [3, "value"], ["maxlength", "50", 1, "option__message", 3, "ngModelChange", "ngModel"], [1, "option__message-condition"]],
    template: function ProductOptionsSelectorComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](5, ProductOptionsSelectorComponent_ng_container_5_Template, 2, 1, "ng-container", 3)(6, ProductOptionsSelectorComponent_ng_container_6_Template, 2, 1, "ng-container", 3)(7, ProductOptionsSelectorComponent_ng_container_7_Template, 2, 1, "ng-container", 3)(8, ProductOptionsSelectorComponent_ng_container_8_Template, 5, 4, "ng-container", 3)(9, ProductOptionsSelectorComponent_ng_container_9_Template, 6, 1, "ng-container", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"](ctx.productOptions == null ? null : ctx.productOptions.DisplayName == null ? null : ctx.productOptions.DisplayName.En);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtextInterpolate"]((ctx.productOptions == null ? null : ctx.productOptions.IsRequired) ? "Required" : "Optional");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx.productOptions == null ? null : ctx.productOptions.DisplayType) === "radio" && (ctx.productOptions == null ? null : ctx.productOptions.Options == null ? null : ctx.productOptions.Options[0] == null ? null : ctx.productOptions.Options[0].IconUrl));
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx.productOptions == null ? null : ctx.productOptions.DisplayType) === "radio" && !(ctx.productOptions == null ? null : ctx.productOptions.Options == null ? null : ctx.productOptions.Options[0] == null ? null : ctx.productOptions.Options[0].IconUrl));
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx.productOptions == null ? null : ctx.productOptions.DisplayType) === "checkbox");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx.productOptions == null ? null : ctx.productOptions.DisplayType) === "select");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngIf", (ctx.productOptions == null ? null : ctx.productOptions.DisplayType) === "input");
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_6__.NgClass, _angular_common__WEBPACK_IMPORTED_MODULE_6__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_6__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_6__.NgStyle, _angular_forms__WEBPACK_IMPORTED_MODULE_7__.DefaultValueAccessor, _angular_forms__WEBPACK_IMPORTED_MODULE_7__.NgControlStatus, _angular_forms__WEBPACK_IMPORTED_MODULE_7__.MaxLengthValidator, _angular_forms__WEBPACK_IMPORTED_MODULE_7__.NgModel, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonCheckbox, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonSelect, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonSelectOption, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.BooleanValueAccessor, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.SelectValueAccessor],
    styles: [".option[_ngcontent-%COMP%] {\n  box-sizing: border-box;\n  padding: 32px 0px;\n}\n.option__title[_ngcontent-%COMP%] {\n  font-size: 16px;\n  line-height: 24px;\n  font-weight: 500;\n}\n.option__condition[_ngcontent-%COMP%] {\n  font-size: 12px;\n  line-height: 16px;\n  color: #647281;\n  margin-bottom: 16px;\n}\n.option__list[_ngcontent-%COMP%] {\n  box-sizing: border-box;\n}\n.option__list-item[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: 12px;\n  font-size: 16px;\n  font-weight: 300;\n  line-height: 24px;\n  margin-bottom: 32px;\n}\n.option__list-item[_ngcontent-%COMP%]:last-child {\n  margin-bottom: 0px;\n}\n.option__single-check[_ngcontent-%COMP%] {\n  width: 24px;\n  height: 24px;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  border-radius: 12px;\n  border: 1px solid #767676;\n}\n.option__single-check--checked[_ngcontent-%COMP%] {\n  width: 12px;\n  height: 12px;\n  border-radius: 6px;\n  background: var(--mag-brand-foundation-primary, #008000);\n}\n.option__single-check--selected[_ngcontent-%COMP%] {\n  border: 2px solid var(--mag-brand-foundation-primary, #008000);\n}\n.option__multi-check[_ngcontent-%COMP%] {\n  width: 24px;\n  height: 24px;\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}\n.option__message[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 150px;\n  padding: 16px;\n  font-size: 16px;\n  line-height: 24px;\n  border: 1px solid var(--mag-border);\n  border-radius: 8px;\n}\n.option__message-condition[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  justify-content: flex-end;\n  margin-top: 8px;\n}\n\nion-checkbox[_ngcontent-%COMP%] {\n  --size: 24px;\n  --checkbox-background-checked: var(--mag-brand-foundation-primary, #008000);\n}\nion-checkbox[_ngcontent-%COMP%]::part(container) {\n  border-radius: 4px;\n  border: 1px solid #767676;\n}\n\nion-select[_ngcontent-%COMP%] {\n  min-height: inherit;\n  margin-top: -6px;\n  --padding-top: 3px;\n  --padding-bottom: 3px;\n  text-align: center;\n  border-radius: 5px;\n  border: 1px solid var(--mag-color-border-selector, #767676);\n}\n\n.popover-product-options[_ngcontent-%COMP%]   ion-backdrop[_ngcontent-%COMP%] {\n  background-color: black;\n}\n.popover-product-options[_ngcontent-%COMP%]   .popover-content[_ngcontent-%COMP%] {\n  left: unset;\n  width: auto;\n  max-width: 100%;\n}\n.popover-product-options[_ngcontent-%COMP%]   .ion-option-text-wrap[_ngcontent-%COMP%] {\n  white-space: normal !important;\n}\n\n.color-radio[_ngcontent-%COMP%] {\n  width: 28px;\n  height: 28px;\n  display: inline-flex;\n  margin: 0 8px;\n  border: 1px solid var(--mag-color-border-selector, #767676);\n  border-radius: 30px;\n  background-color: var(--mag-color-border-selector, #767676);\n  background-size: cover;\n}\n\n.color-active[_ngcontent-%COMP%] {\n  border: 2px solid var(--mag-brand-foundation-primary, #008000) !important;\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvY29tcG9uZW50cy9wcm9kdWN0LW9wdGlvbnMtc2VsZWN0b3IvcHJvZHVjdC1vcHRpb25zLXNlbGVjdG9yLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxzQkFBQTtFQUNBLGlCQUFBO0FBQ0Y7QUFDRTtFQUNFLGVBQUE7RUFDQSxpQkFBQTtFQUNBLGdCQUFBO0FBQ0o7QUFFRTtFQUNFLGVBQUE7RUFDQSxpQkFBQTtFQUNBLGNBQUE7RUFDQSxtQkFBQTtBQUFKO0FBR0U7RUFDRSxzQkFBQTtBQURKO0FBR0k7RUFDRSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSxTQUFBO0VBQ0EsZUFBQTtFQUNBLGdCQUFBO0VBQ0EsaUJBQUE7RUFDQSxtQkFBQTtBQUROO0FBR007RUFDRSxrQkFBQTtBQURSO0FBTUU7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLGFBQUE7RUFDQSx1QkFBQTtFQUNBLG1CQUFBO0VBQ0EsbUJBQUE7RUFDQSx5QkFBQTtBQUpKO0FBTUk7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLGtCQUFBO0VBQ0Esd0RBQUE7QUFKTjtBQU9JO0VBQ0UsOERBQUE7QUFMTjtBQVNFO0VBQ0UsV0FBQTtFQUNBLFlBQUE7RUFDQSxhQUFBO0VBQ0EsdUJBQUE7RUFDQSxtQkFBQTtBQVBKO0FBVUU7RUFDRSxXQUFBO0VBQ0EsYUFBQTtFQUNBLGFBQUE7RUFFQSxlQUFBO0VBQ0EsaUJBQUE7RUFDQSxtQ0FBQTtFQUNBLGtCQUFBO0FBVEo7QUFZRTtFQUNFLGFBQUE7RUFDQSxtQkFBQTtFQUNBLHlCQUFBO0VBQ0EsZUFBQTtBQVZKOztBQWNBO0VBQ0UsWUFBQTtFQUNBLDJFQUFBO0FBWEY7QUFhRTtFQUNFLGtCQUFBO0VBQ0EseUJBQUE7QUFYSjs7QUFlQTtFQUNFLG1CQUFBO0VBQ0EsZ0JBQUE7RUFDQSxrQkFBQTtFQUNBLHFCQUFBO0VBQ0Esa0JBQUE7RUFDQSxrQkFBQTtFQUNBLDJEQUFBO0FBWkY7O0FBZ0JFO0VBQ0UsdUJBQUE7QUFiSjtBQWdCRTtFQUVFLFdBQUE7RUFDQSxXQUFBO0VBQ0EsZUFBQTtBQWZKO0FBaUJFO0VBQ0UsOEJBQUE7QUFmSjs7QUFtQkE7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLG9CQUFBO0VBQ0EsYUFBQTtFQUNBLDJEQUFBO0VBQ0EsbUJBQUE7RUFDQSwyREFBQTtFQUNBLHNCQUFBO0FBaEJGOztBQW1CQTtFQUNFLHlFQUFBO0FBaEJGIiwic291cmNlc0NvbnRlbnQiOlsiLm9wdGlvbiB7XG4gIGJveC1zaXppbmc6IGJvcmRlci1ib3g7XG4gIHBhZGRpbmc6IDMycHggMHB4O1xuXG4gICZfX3RpdGxlIHtcbiAgICBmb250LXNpemU6IDE2cHg7XG4gICAgbGluZS1oZWlnaHQ6IDI0cHg7XG4gICAgZm9udC13ZWlnaHQ6IDUwMDtcbiAgfVxuXG4gICZfX2NvbmRpdGlvbiB7XG4gICAgZm9udC1zaXplOiAxMnB4O1xuICAgIGxpbmUtaGVpZ2h0OiAxNnB4O1xuICAgIGNvbG9yOiAjNjQ3MjgxO1xuICAgIG1hcmdpbi1ib3R0b206IDE2cHg7XG4gIH1cblxuICAmX19saXN0IHtcbiAgICBib3gtc2l6aW5nOiBib3JkZXItYm94O1xuXG4gICAgJi1pdGVtIHtcbiAgICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgICAgZ2FwOiAxMnB4O1xuICAgICAgZm9udC1zaXplOiAxNnB4O1xuICAgICAgZm9udC13ZWlnaHQ6IDMwMDtcbiAgICAgIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICAgICAgbWFyZ2luLWJvdHRvbTogMzJweDtcblxuICAgICAgJjpsYXN0LWNoaWxkIHtcbiAgICAgICAgbWFyZ2luLWJvdHRvbTogMHB4O1xuICAgICAgfVxuICAgIH1cbiAgfVxuXG4gICZfX3NpbmdsZS1jaGVjayB7XG4gICAgd2lkdGg6IDI0cHg7XG4gICAgaGVpZ2h0OiAyNHB4O1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBib3JkZXItcmFkaXVzOiAxMnB4O1xuICAgIGJvcmRlcjogMXB4IHNvbGlkICM3Njc2NzY7XG5cbiAgICAmLS1jaGVja2VkIHtcbiAgICAgIHdpZHRoOiAxMnB4O1xuICAgICAgaGVpZ2h0OiAxMnB4O1xuICAgICAgYm9yZGVyLXJhZGl1czogNnB4O1xuICAgICAgYmFja2dyb3VuZDogdmFyKC0tbWFnLWJyYW5kLWZvdW5kYXRpb24tcHJpbWFyeSwgIzAwODAwMCk7XG4gICAgfVxuXG4gICAgJi0tc2VsZWN0ZWQge1xuICAgICAgYm9yZGVyOiAycHggc29saWQgdmFyKC0tbWFnLWJyYW5kLWZvdW5kYXRpb24tcHJpbWFyeSwgIzAwODAwMCk7XG4gICAgfVxuICB9XG5cbiAgJl9fbXVsdGktY2hlY2sge1xuICAgIHdpZHRoOiAyNHB4O1xuICAgIGhlaWdodDogMjRweDtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gIH1cblxuICAmX19tZXNzYWdlIHtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBoZWlnaHQ6IDE1MHB4O1xuICAgIHBhZGRpbmc6IDE2cHg7XG5cbiAgICBmb250LXNpemU6IDE2cHg7XG4gICAgbGluZS1oZWlnaHQ6IDI0cHg7XG4gICAgYm9yZGVyOiAxcHggc29saWQgdmFyKC0tbWFnLWJvcmRlcik7XG4gICAgYm9yZGVyLXJhZGl1czogOHB4O1xuICB9XG5cbiAgJl9fbWVzc2FnZS1jb25kaXRpb24ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGZsZXgtZW5kO1xuICAgIG1hcmdpbi10b3A6IDhweDtcbiAgfVxufVxuXG5pb24tY2hlY2tib3gge1xuICAtLXNpemU6IDI0cHg7XG4gIC0tY2hlY2tib3gtYmFja2dyb3VuZC1jaGVja2VkOiB2YXIoLS1tYWctYnJhbmQtZm91bmRhdGlvbi1wcmltYXJ5LCAjMDA4MDAwKTtcblxuICAmOjpwYXJ0KGNvbnRhaW5lcikge1xuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcbiAgICBib3JkZXI6IDFweCBzb2xpZCAjNzY3Njc2O1xuICB9XG59XG5cbmlvbi1zZWxlY3Qge1xuICBtaW4taGVpZ2h0OiBpbmhlcml0O1xuICBtYXJnaW4tdG9wOiAtNnB4O1xuICAtLXBhZGRpbmctdG9wOiAzcHg7XG4gIC0tcGFkZGluZy1ib3R0b206IDNweDtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xuICBib3JkZXItcmFkaXVzOiA1cHg7XG4gIGJvcmRlcjogMXB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItc2VsZWN0b3IsICM3Njc2NzYpO1xufVxuXG4ucG9wb3Zlci1wcm9kdWN0LW9wdGlvbnMge1xuICBpb24tYmFja2Ryb3Age1xuICAgIGJhY2tncm91bmQtY29sb3I6IGJsYWNrO1xuICB9XG5cbiAgLnBvcG92ZXItY29udGVudCB7XG4gICAgLy8gcmlnaHQ6IDAgIWltcG9ydGFudDtcbiAgICBsZWZ0OiB1bnNldDtcbiAgICB3aWR0aDogYXV0bztcbiAgICBtYXgtd2lkdGg6IDEwMCU7XG4gIH1cbiAgLmlvbi1vcHRpb24tdGV4dC13cmFwIHtcbiAgICB3aGl0ZS1zcGFjZTogbm9ybWFsICFpbXBvcnRhbnQ7XG4gIH1cbn1cblxuLmNvbG9yLXJhZGlvIHtcbiAgd2lkdGg6IDI4cHg7XG4gIGhlaWdodDogMjhweDtcbiAgZGlzcGxheTogaW5saW5lLWZsZXg7XG4gIG1hcmdpbjogMCA4cHg7XG4gIGJvcmRlcjogMXB4IHNvbGlkIHZhcigtLW1hZy1jb2xvci1ib3JkZXItc2VsZWN0b3IsICM3Njc2NzYpO1xuICBib3JkZXItcmFkaXVzOiAzMHB4O1xuICBiYWNrZ3JvdW5kLWNvbG9yOiB2YXIoLS1tYWctY29sb3ItYm9yZGVyLXNlbGVjdG9yLCAjNzY3Njc2KTtcbiAgYmFja2dyb3VuZC1zaXplOiBjb3Zlcjtcbn1cblxuLmNvbG9yLWFjdGl2ZSB7XG4gIGJvcmRlcjogMnB4IHNvbGlkIHZhcigtLW1hZy1icmFuZC1mb3VuZGF0aW9uLXByaW1hcnksICMwMDgwMDApICFpbXBvcnRhbnQ7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 50237:
/*!*******************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/model/enum.ts ***!
  \*******************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   enumAssociateWith: () => (/* binding */ enumAssociateWith),
/* harmony export */   enumConditionType: () => (/* binding */ enumConditionType),
/* harmony export */   enumConsolidatedField: () => (/* binding */ enumConsolidatedField),
/* harmony export */   enumDealRibbon: () => (/* binding */ enumDealRibbon),
/* harmony export */   enumDiscountType: () => (/* binding */ enumDiscountType),
/* harmony export */   enumEffectType: () => (/* binding */ enumEffectType)
/* harmony export */ });
var enumConsolidatedField;
(function (enumConsolidatedField) {
  enumConsolidatedField[enumConsolidatedField["StoreCoupon"] = 1] = "StoreCoupon";
  enumConsolidatedField[enumConsolidatedField["PromoCode"] = 2] = "PromoCode";
  enumConsolidatedField[enumConsolidatedField["Sale"] = 3] = "Sale";
  enumConsolidatedField[enumConsolidatedField["LoyaltyReward"] = 4] = "LoyaltyReward";
})(enumConsolidatedField || (enumConsolidatedField = {}));
var enumDealRibbon;
(function (enumDealRibbon) {
  enumDealRibbon[enumDealRibbon["BundleAndSave"] = 1] = "BundleAndSave";
  enumDealRibbon[enumDealRibbon["BonusItem"] = 2] = "BonusItem";
  enumDealRibbon[enumDealRibbon["SpendAndGet"] = 3] = "SpendAndGet";
  enumDealRibbon[enumDealRibbon["AmountOff"] = 4] = "AmountOff";
  enumDealRibbon[enumDealRibbon["PercentOff"] = 5] = "PercentOff";
})(enumDealRibbon || (enumDealRibbon = {}));
var enumEffectType;
(function (enumEffectType) {
  enumEffectType[enumEffectType["Discount"] = 1] = "Discount";
  enumEffectType[enumEffectType["DiscountNextOrder"] = 2] = "DiscountNextOrder";
  enumEffectType[enumEffectType["Points"] = 3] = "Points";
  enumEffectType[enumEffectType["GiftCard"] = 4] = "GiftCard";
})(enumEffectType || (enumEffectType = {}));
var enumDiscountType;
(function (enumDiscountType) {
  enumDiscountType[enumDiscountType["FixedAmountOff"] = 1] = "FixedAmountOff";
  enumDiscountType[enumDiscountType["PercentOff"] = 2] = "PercentOff";
  enumDiscountType[enumDiscountType["PercentEarned"] = 3] = "PercentEarned";
  enumDiscountType[enumDiscountType["Free"] = 4] = "Free";
  enumDiscountType[enumDiscountType["NewPrice"] = 5] = "NewPrice";
  enumDiscountType[enumDiscountType["QuantityAwarded"] = 6] = "QuantityAwarded";
  enumDiscountType[enumDiscountType["Points"] = 7] = "Points";
  enumDiscountType[enumDiscountType["ExternalPromotion"] = 8] = "ExternalPromotion";
})(enumDiscountType || (enumDiscountType = {}));
var enumConditionType;
(function (enumConditionType) {
  enumConditionType[enumConditionType["Quantity"] = 1] = "Quantity";
  enumConditionType[enumConditionType["Amount"] = 2] = "Amount";
  enumConditionType[enumConditionType["Quantity1AtPrice"] = 3] = "Quantity1AtPrice";
})(enumConditionType || (enumConditionType = {}));
var enumAssociateWith;
(function (enumAssociateWith) {
  enumAssociateWith[enumAssociateWith["ItemLevel"] = 1] = "ItemLevel";
  enumAssociateWith[enumAssociateWith["CartLevel"] = 2] = "CartLevel";
})(enumAssociateWith || (enumAssociateWith = {}));

/***/ }),

/***/ 38372:
/*!*******************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/model/util.ts ***!
  \*******************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DisplayTypes: () => (/* binding */ DisplayTypes),
/* harmony export */   checkOptionSetToDisplay: () => (/* binding */ checkOptionSetToDisplay),
/* harmony export */   decodeJsonFromString: () => (/* binding */ decodeJsonFromString),
/* harmony export */   flattenOptionSets: () => (/* binding */ flattenOptionSets),
/* harmony export */   formatData: () => (/* binding */ formatData),
/* harmony export */   formatGiftCard: () => (/* binding */ formatGiftCard),
/* harmony export */   formatSubmitGiftCardOptionSet: () => (/* binding */ formatSubmitGiftCardOptionSet),
/* harmony export */   formatSubmitOptionSet: () => (/* binding */ formatSubmitOptionSet),
/* harmony export */   getOptionSetsByType: () => (/* binding */ getOptionSetsByType),
/* harmony export */   getOptionSetsPhotos: () => (/* binding */ getOptionSetsPhotos),
/* harmony export */   getOptionsByType: () => (/* binding */ getOptionsByType),
/* harmony export */   getOptionsSet: () => (/* binding */ getOptionsSet),
/* harmony export */   getProductPrice: () => (/* binding */ getProductPrice),
/* harmony export */   getRenderOptionSets: () => (/* binding */ getRenderOptionSets),
/* harmony export */   getSelectedOption: () => (/* binding */ getSelectedOption),
/* harmony export */   getSubmitOptionSets: () => (/* binding */ getSubmitOptionSets),
/* harmony export */   getSubmitOptionSetsForGiftCard: () => (/* binding */ getSubmitOptionSetsForGiftCard),
/* harmony export */   getSubmitOptionSetsGroup: () => (/* binding */ getSubmitOptionSetsGroup),
/* harmony export */   getTotalOptionsPrices: () => (/* binding */ getTotalOptionsPrices),
/* harmony export */   pricingUnit: () => (/* binding */ pricingUnit),
/* harmony export */   renderLeadTime: () => (/* binding */ renderLeadTime),
/* harmony export */   setSelectedVal: () => (/* binding */ setSelectedVal)
/* harmony export */ });
/* harmony import */ var lodash_find__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! lodash/find */ 21313);
/* harmony import */ var lodash_find__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(lodash_find__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var lodash_isEqual__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! lodash/isEqual */ 35280);
/* harmony import */ var lodash_isEqual__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(lodash_isEqual__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _rsApp_modules_interfaces_product_interface__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/interfaces/product.interface */ 66563);




const renderLeadTime = minutes => {
  if (minutes === null || minutes <= 0) {
    return null;
  }
  const leadTimeStr = [];
  const week = 7 * 24 * 60;
  const day = 24 * 60;
  const hour = 60;
  const wValue = Math.floor(minutes / week);
  if (wValue > 0) {
    leadTimeStr.push(`${wValue} week${wValue > 1 ? 's' : ''}`);
    minutes -= wValue * week;
  }
  const dValue = Math.floor(minutes / day);
  if (dValue > 0) {
    leadTimeStr.push(`${dValue} day${dValue > 1 ? 's' : ''}`);
    minutes -= dValue * day;
  }
  const hValue = Math.floor(minutes / hour);
  if (hValue > 0) {
    leadTimeStr.push(`${hValue} hour${hValue > 1 ? 's' : ''}`);
    minutes -= hValue * hour;
  }
  if (minutes > 0) {
    leadTimeStr.push(`${minutes} minute${minutes > 1 ? 's' : ''}`);
  }
  return leadTimeStr.join(' ');
};
const pricingUnit = {
  each: 'ea',
  grams: 'g',
  kilograms: 'kg',
  miligrams: 'mg',
  ounces: 'oz',
  pound: 'lb'
};
const decodeJsonFromString = data => {
  return data.replace(/&quot;/g, '"');
};
var Operators;
(function (Operators) {
  Operators["AND"] = "and";
  Operators["OR"] = "or";
})(Operators || (Operators = {}));
const setUpOptionImage = option => {
  if (!option) return;
  option = JSON.parse(option);
  return option?.ResizedImageUrl || option?.OptionImageUrl || option?.ImageUrl;
};
const setSelectedVal = optionSet => {
  if (!optionSet) return;
  let selectedValue = null;
  let selectedImage = null;
  if (optionSet?.DisplayType === DisplayTypes.INPUT) {
    optionSet.SelectedOptionValue = '';
    optionSet.SelectedOptionImage = null;
  } else {
    if (optionSet.Options[0]) {
      const selectOption = optionSet.Options[0];
      const obj = Object.assign(selectOption, {});
      if (selectOption) {
        selectedValue = selectOption.Id;
        selectedImage = setUpOptionImage(JSON.stringify(obj));
      }
    }
  }
  optionSet.SelectedOptionValue = optionSet?.IsRequired ? selectedValue : null;
  optionSet.SelectedOptionImage = optionSet?.IsRequired ? selectedImage : null;
  if (optionSet.DisplayType === DisplayTypes.CHECKBOX) {
    optionSet.SelectedValues = [optionSet?.Options?.[0]?.Id];
  }
  return optionSet;
};
const calculateUnitPriceWithOptions = (basePrice, optionSets) => {
  if (basePrice == null || !optionSets) return;
  const optionPrices = optionSets?.flatMap(optionSet => {
    if (optionSet?.DisplayType === DisplayTypes.CHECKBOX) {
      return optionSet?.Options?.filter(option => optionSet?.SelectedValues?.includes(option?.Code)) || [];
    } else {
      return optionSet?.Options?.filter(option => option?.Id === optionSet?.SelectedOptionValue) || [];
    }
  }) || [];
  let total = basePrice;
  optionPrices?.forEach(option => {
    if (option) {
      total += option?.PriceModifier || 0;
      total += option?.PricePercentageModifier ? option?.PricePercentageModifier * basePrice / 100 : 0;
    }
  });
  return total;
};
const flattenOptionSets = clonedOptionSetGroups => {
  if (!clonedOptionSetGroups) return;
  return clonedOptionSetGroups.flatMap(group => {
    if (group?.IsParent) return group.OptionSets;
    return group;
  });
};
const addParentDisplayOrder = (allOptionSets, clonedOptionSetGroups) => {
  if (!allOptionSets || !clonedOptionSetGroups) return;
  return allOptionSets.map(optionSet => {
    const parentGroup = clonedOptionSetGroups.find(group => group.Id === optionSet.ParentCode);
    return {
      ...optionSet,
      ParentDisplayOrder: parentGroup?.DisplayOrder || null
    };
  });
};
/**
 * Checks if the optionSet should be displayed
 * based on its display conditions and current selected options.
 */
const checkOptionSetToDisplay = (optionSet, allOptionSets) => {
  const conditions = optionSet?.DisplayCondition;
  if (!conditions?.length) return true;
  const isDisplay = conditions.reduce((acc, current) => combineDisplayConditions(acc, current, allOptionSets), null);
  return isDisplay;
};
/**
 * Combine the results of multiple display conditions using the given operator.
 *
 * @param {boolean|null} acc The result of the previous conditions.
 * @param {any} current The current condition to evaluate.
 * @param {any[]} allOptionSets All the option sets.
 * @returns {boolean|null} The result of all the conditions.
 */
const applyOperator = (combineMatch, currentMatch, operator) => {
  if (combineMatch === null) return currentMatch;
  switch (operator) {
    case Operators.OR:
      return combineMatch || currentMatch;
    case Operators.AND:
      return combineMatch && currentMatch;
  }
};
const combineDisplayConditions = (acc, current, allOptionSets) => {
  if (!current?.OptionSetCode || !current?.OptionCode) {
    // If the current condition  is not found or its OptionId, OptionSetId is missing/null, return false combined with previous result
    return applyOperator(acc, false, current?.Operator);
  }
  const targetOptionSet = lodash_find__WEBPACK_IMPORTED_MODULE_0___default()(allOptionSets, {
    Code: current.OptionSetCode
  });
  if (!targetOptionSet?.Code) {
    // If the option set is not found or its Id is missing/null/undefined, return false combined with previous result
    return applyOperator(acc, false, current?.Operator);
  }
  if (!targetOptionSet?.SelectedOptionValue) {
    return applyOperator(acc, true, current?.Operator);
  }
  const targetOption = lodash_find__WEBPACK_IMPORTED_MODULE_0___default()(targetOptionSet.Options, {
    Code: targetOptionSet.SelectedOptionValue
  });
  if (!targetOption?.Code) {
    // If that option is not found or its Id is missing/null/undefined, return false combined with previous result
    return applyOperator(acc, false, current?.Operator);
  }
  // Compare if the selected option matches the current condition exactly by OptionSetId, OptionId, and OptionDisplayName
  const isMatch = lodash_isEqual__WEBPACK_IMPORTED_MODULE_1___default()({
    OptionSetCode: targetOptionSet.Code,
    OptionCode: targetOption.Code,
    OptionDisplayName: targetOption.DisplayName?.En
  }, {
    OptionSetCode: current.OptionSetCode,
    OptionCode: current.OptionCode,
    OptionDisplayName: current.OptionDisplayName
  });
  return applyOperator(acc, isMatch, current.Operator);
};
const buildMasterList = (displayableOptionSetGroups, allOptionSets) => {
  if (!displayableOptionSetGroups) return;
  return displayableOptionSetGroups.flatMap(group => {
    return group.OptionSets.filter(optionSet => checkOptionSetToDisplay(optionSet, allOptionSets));
  });
};
const createDisplayableGroups = (clonedOptionSetGroups, optionSetsWithSelectedValues) => {
  const optionSetsByParentCode = optionSetsWithSelectedValues.reduce((acc, optionSet) => {
    const parentCode = optionSet?.ParentCode;
    if (parentCode != null) {
      acc[parentCode] = acc[parentCode] || [];
      acc[parentCode].push(optionSet);
    }
    return acc;
  }, {});
  return clonedOptionSetGroups.reduce((acc, group) => {
    const optionSets = optionSetsByParentCode[group?.Code] || [];
    const isDisplay = checkOptionSetToDisplay(group, optionSetsWithSelectedValues);
    if (isDisplay) {
      acc.push({
        ...group,
        OptionSets: optionSets,
        isDisplay: true
      });
    }
    return acc;
  }, []);
};
const createGroupMap = optionSetsGroup => {
  return new Map(optionSetsGroup.map(group => [group.Code, {
    Id: group.Id,
    Code: group.Code,
    Name: group.Name,
    OptionSets: []
  }]));
};
const composeSubmitOptionSets = (optionSets, optionSetsGroupMap) => {
  for (const optionSet of optionSets) {
    if (optionSetsGroupMap.has(optionSet.ParentCode)) {
      optionSetsGroupMap.get(optionSet.ParentCode)?.OptionSets.push(formatSubmitOptionSet(optionSet));
    }
  }
  return Array.from(optionSetsGroupMap.values()).filter(group => group.OptionSets.length > 0);
};
const formatSubmitOptionSet = optionSet => {
  if (optionSet.DisplayType === DisplayTypes.INPUT && optionSet.Value) {
    return {
      Id: optionSet.Id,
      Name: optionSet.Name,
      Value: optionSet.Value
    };
  }
  return {
    Id: optionSet.Id,
    Name: optionSet.Name,
    Options: optionSet.Options?.map(({
      Id,
      Name
    }) => ({
      Id,
      Name
    })) || []
  };
};
const composeSubmitOptions = (option, SelectedOptionValue) => {
  switch (option?.DisplayType) {
    case DisplayTypes.CHECKBOX:
      {
        const optionsMap = new Map(option?.Options.map(option => [option.Id, option]));
        const foundOptions = option?.SelectedValues.map(item => optionsMap.get(item)) // Fast lookup
        .filter(Boolean);
        return foundOptions;
      }
    case DisplayTypes.RADIO:
    case DisplayTypes.SELECT:
      return option?.Options?.filter(option => option?.Id == SelectedOptionValue) || [option?.Options[0]];
  }
};
const composeSubmitGiftcardOptions = (option, SelectedOptionValue) => {
  switch (option?.DisplayType) {
    case DisplayTypes.CHECKBOX:
      {
        const optionsMap = new Map(option?.Options.map(option => [option.Id, option]));
        const foundOptions = option?.SelectedValues.map(item => optionsMap.get(item)) // Fast lookup
        .filter(Boolean);
        return foundOptions;
      }
    case DisplayTypes.RADIO:
    case DisplayTypes.SELECT:
      return checkCustumVal(option, SelectedOptionValue);
    // return option?.Options?.filter((option) => option?.Id == SelectedOptionValue) || [option?.Options[0]];
  }
};
const checkCustumVal = (optionSet, selectedOptionValue) => {
  if (selectedOptionValue) {
    const option = optionSet?.Options?.find(option => {
      return option?.Id == selectedOptionValue;
    });
    if (option?.Tags?.includes('customvalue') && optionSet?.CustumOptionValue) {
      option.Value = optionSet?.CustumOptionValue;
    }
    return [option];
  } else {
    return [optionSet?.Options[0]];
  }
};
const DisplayTypes = {
  RADIO: 'radio',
  CHECKBOX: 'checkbox',
  SELECT: 'select',
  INPUT: 'input',
  GIFTCARD: 'GiftCard',
  VISUAL: 'Visual'
};
/** Main custom cakes utils **/
const formatData = (rawOptionSetsGroups, isEdit, selectedOptionSets) => {
  if (!rawOptionSetsGroups) return;
  const allOptionSets = flattenOptionSets((0,lodash__WEBPACK_IMPORTED_MODULE_2__.cloneDeep)(rawOptionSetsGroups));
  const orderedOptionSets = addParentDisplayOrder(allOptionSets, (0,lodash__WEBPACK_IMPORTED_MODULE_2__.cloneDeep)(rawOptionSetsGroups));
  const optionSetsWithSelectedValues = orderedOptionSets?.map(setSelectedVal);
  if (isEdit && selectedOptionSets?.length > 0) {
    const transformedOptionSets = (0,lodash__WEBPACK_IMPORTED_MODULE_2__.cloneDeep)(selectedOptionSets)?.flatMap(item => item?.OptionSets);
    transformedOptionSets?.forEach(item => {
      const optionSet = optionSetsWithSelectedValues?.find(optionSet => optionSet?.Id === item?.Id);
      optionSet.SelectedOptionValue = optionSet?.DisplayType == DisplayTypes.INPUT ? item?.Value : item?.Options[0]?.Id;
      optionSet.SelectedOptionImage = item?.Options[0]?.ImageUrl;
    });
  }
  return optionSetsWithSelectedValues;
};
const getRenderOptionSets = (optionSetGroups, selectedOptionSets) => {
  if (!optionSetGroups || !selectedOptionSets) return;
  const displayableOptionSetGroups = createDisplayableGroups(optionSetGroups, selectedOptionSets);
  return buildMasterList(displayableOptionSetGroups, selectedOptionSets);
};
const getTotalOptionsPrices = (optionSets, price) => {
  if (!optionSets) return;
  const unitPriceWithOptions = calculateUnitPriceWithOptions(price, optionSets);
  if (unitPriceWithOptions == null) return;
  return unitPriceWithOptions;
};
const getOptionSetsPhotos = optionSets => {
  if (!optionSets) return;
  const photosMap = new Map();
  // Iterate over each step in wizardData
  optionSets.forEach((optionSet, idx) => {
    // Skip invalid OptionSets
    if (!optionSet) return;
    const {
      SelectedOptionImage,
      SelectedOptionValue,
      ParentDisplayOrder
    } = optionSet;
    // Filter out error images
    if (typeof SelectedOptionImage === 'string' && !SelectedOptionImage.includes('get-resized-image/1/')) {
      // Use a map to ensure uniqueness
      if (!photosMap.has(SelectedOptionImage)) {
        photosMap.set(SelectedOptionImage, {
          optionId: SelectedOptionValue,
          imageUrl: SelectedOptionImage,
          zIndex: ParentDisplayOrder * 100 + idx
        });
      }
    }
  });
  return Array.from(photosMap?.values());
};
const getSubmitOptionSets = optionSets => {
  return optionSets?.map(item => {
    const inputOption = {
      ...item,
      Value: item.SelectedOptionValue
    };
    const defaultOption = {
      ...item,
      Options: composeSubmitOptions(item, item?.SelectedOptionValue)
    };
    if (item?.DisplayType == DisplayTypes.INPUT && item?.SelectedOptionValue) {
      return inputOption;
    }
    if (item?.DisplayType != DisplayTypes.INPUT && item?.SelectedOptionValue) {
      return defaultOption;
    }
  })?.filter(Boolean);
};
const getOptionsSet = item => {
  if (item?.DisplayType == DisplayTypes.INPUT && item?.SelectedOptionValue) {
    const inputOption = {
      ...item,
      Value: item.SelectedOptionValue
    };
    return inputOption;
  }
  if (item?.DisplayType != DisplayTypes.INPUT && item?.SelectedOptionValue) {
    const defaultOption = {
      ...item,
      Options: composeSubmitGiftcardOptions(item, item.SelectedOptionValue)
    };
    return defaultOption;
  }
};
const getSubmitOptionSetsForGiftCard = giftCardOptions => {
  return giftCardOptions?.map(item => {
    if (item?.IsParent) {
      return {
        ...item,
        OptionSets: getSubmitOptionSetsForGiftCard(item.OptionSets)
      };
    } else {
      return getOptionsSet(item);
    }
  })?.filter(Boolean);
};
const getSubmitOptionSetsGroup = (submitOptionSets, rawOptionSetsGroups) => {
  // Create a map of option sets groups
  const optionSetsGroupMap = createGroupMap(rawOptionSetsGroups);
  return composeSubmitOptionSets(submitOptionSets, optionSetsGroupMap);
};
//Get selected optionsets from product in cart by type (GiftCard, Visual)
const getOptionSetsByType = (items, type) => {
  if (!Array.isArray(items) || !type) return;
  const cloneItems = flattenOptionSets((0,lodash__WEBPACK_IMPORTED_MODULE_2__.cloneDeep)(items));
  const selectedData = [];
  cloneItems?.forEach(optionSet => {
    if (!optionSet) return;
    selectedData.push(optionSet.DisplayType === DisplayTypes.INPUT ? extractInput(optionSet) : extractOptions(optionSet));
  });
  return selectedData.flat();
};
/** Main custom cakes utils **/
const extractInput = optionSet => ({
  OptionSetDisplayName: optionSet.DisplayName?.En,
  DisplayValue: optionSet.DisplayValue
});
const detectCustumValue = (option, optionSet) => {
  if (option.Tags.includes('customvalue')) {
    return {
      OptionSetDisplayName: option.DisplayName?.En,
      DisplayValue: option.DisplayValue
    };
  } else {
    return {
      ...option,
      OptionSetDisplayName: optionSet.DisplayName?.En
    };
  }
};
const extractOptions = optionSet => {
  return optionSet.Options?.length && optionSet.Options?.map(option => detectCustumValue(option, optionSet));
};
/** Main Gift Cards utils **/
const formatSubmitGiftCardOptionSet = optionSet => {
  if (!optionSet) return;
  if (optionSet.DisplayType === DisplayTypes.INPUT && optionSet.Value) {
    return {
      Id: optionSet.Id,
      Name: optionSet.Name,
      Value: optionSet.Value
    };
  }
  if (optionSet?.OptionSets?.length > 0) {
    const optionSets = optionSet?.OptionSets?.map(option => formatSubmitGiftCardOptionSet(option));
    return {
      Id: optionSet.Id,
      Name: optionSet.Name,
      OptionSets: optionSets
    };
  } else {
    return {
      Id: optionSet.Id,
      Name: optionSet.Name,
      Options: optionSet.Options?.map(({
        Id,
        Name,
        Value
      }) => ({
        ...(Id && {
          Id
        }),
        ...(Name && {
          Name
        }),
        ...(Value && {
          Value
        })
      })) || []
    };
  }
};
const formatGiftCard = (optionSets, isEdit, selectedOptionSets) => {
  const rs = optionSets?.map(setSelectedVal);
  const allOptionSetsWithSelectedValue = rs?.map(optionSet => {
    if (optionSet?.IsParent) {
      return {
        ...optionSet,
        OptionSets: formatGiftCard(optionSet?.OptionSets, isEdit, selectedOptionSets)
      };
    }
    return {
      ...optionSet,
      Options: optionSet.Options?.map(option => {
        return {
          ...option,
          ParentCode: optionSet?.Code,
          ParentId: optionSet?.Id
        };
      })
    };
  });
  if (!isEdit) return allOptionSetsWithSelectedValue;
  const optionSetsWithSelectedvalue = getSelectedOption(allOptionSetsWithSelectedValue, selectedOptionSets);
  return optionSetsWithSelectedvalue;
};
const getSelectedOption = (optionSets, selectedOptionSets) => {
  return optionSets.map(optionSet => {
    const item = selectedOptionSets.find(s => s.Id === optionSet.Id);
    if (optionSet.IsParent) {
      return {
        ...optionSet,
        OptionSets: getSelectedOption(optionSet.OptionSets || [], item?.OptionSets)
      };
    }
    if (!item) return optionSet;
    let updated = {
      ...optionSet,
      SelectedOptionValue: optionSet?.DisplayType == DisplayTypes.INPUT ? item?.DisplayValue : item?.Options?.[0]?.Id,
      SelectedOptionImage: item?.Options?.[0]?.ImageUrl
    };
    if (item?.Options?.[0]?.Tags.includes('customvalue') && item?.Options?.[0]?.Value) {
      updated = {
        ...updated,
        CustumOptionValue: item.Options[0].Value
      };
    }
    return updated;
  });
};
const getOptionsByType = (optionSets, type) => {
  if (!optionSets) return;
  const giftCardStyles = optionSets?.find(optionSet => optionSet?.DisplayType === DisplayTypes.RADIO && optionSet?.Options?.[0]?.IconUrl);
  const giftCardAmounts = optionSets?.find(optionSet => optionSet?.DisplayType === DisplayTypes.RADIO && !optionSet?.Options[0]?.IconUrl);
  const giftCardMessage = optionSets?.find(optionSet => optionSet?.DisplayType === DisplayTypes.INPUT);
  const rs = {
    giftCardStyles: giftCardStyles,
    giftCardAmounts: giftCardAmounts,
    giftCardMessage: giftCardMessage
  };
  return rs[type];
};
/** Main Gift Cards utils **/
const getProductPrice = (product, currentStore) => {
  if (!product || !currentStore) return null;
  const data = {
    salePrice: 0,
    price: 0
  };
  const matchedStore = product.Stores?.find(store => store?.StoreCode?.toString() === currentStore?.StoreCode?.toString());
  matchedStore?.Prices?.forEach(price => {
    if (price.PriceType === _rsApp_modules_interfaces_product_interface__WEBPACK_IMPORTED_MODULE_3__.PRICE_TYPE.SalePrice) {
      data.salePrice = price.Price;
    } else {
      data.price = price.Price;
    }
  });
  return data;
};

/***/ }),

/***/ 84100:
/*!********************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/pages/product-detail/product-detail.ts ***!
  \********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductDetailPageComponent: () => (/* binding */ ProductDetailPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _providers_product_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../providers/product.service */ 13487);
/* harmony import */ var _product_module__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../product.module */ 55441);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! rxjs */ 64334);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! rxjs */ 19999);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! rxjs */ 95429);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! rxjs */ 98764);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! rxjs */ 56196);
/* harmony import */ var _rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/store/store.module */ 74233);
/* harmony import */ var _model_util__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../model/util */ 38372);
/* harmony import */ var _providers_product_deal_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../providers/product-deal.service */ 33316);
/* harmony import */ var _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @rsApp/modules/utils/enum/enum */ 24457);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! lodash */ 46227);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var _rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @rsApp/modules/utils/providers/app-setting */ 90829);
/* harmony import */ var _rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @rsApp/modules/utils/constants/constants */ 29665);
/* harmony import */ var _ionic_storage__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ionic/storage */ 60850);
/* harmony import */ var _rsApp_modules_utils_providers_google_tracker_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @rsApp/modules/utils/providers/google-tracker.service */ 16324);
/* harmony import */ var _rsApp_modules_utils_providers_rs_tracker_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @rsApp/modules/utils/providers/rs-tracker.service */ 32980);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_tracker_service__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp-tracker.service */ 81527);
/* harmony import */ var _rsApp_modules_auth_v2_providers_auth_v2_service__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/auth-v2.service */ 19683);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_ecom_v2_shopping_list_providers_shopping_list_service__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @rsApp/modules/ecom-v2/shopping-list/providers/shopping-list.service */ 29119);
/* harmony import */ var _rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @rsApp/modules/utils/providers/route-tracker.service */ 68674);
/* harmony import */ var _model_enum__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../model/enum */ 50237);
/* harmony import */ var _rsApp_modules_ecom_v2_edit_order_service__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @rsApp/modules/ecom-v2/edit-order.service */ 49826);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _components_price_multiple_cards_price_multiple_cards__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ../../components/price-multiple-cards/price-multiple-cards */ 70556);
/* harmony import */ var _components_product_added_product_added__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ../../components/product-added/product-added */ 39494);
/* harmony import */ var _components_parity_product_parity_product_flavor_parity_product_flavor__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ../../components/parity-product/parity-product-flavor/parity-product-flavor */ 75498);
/* harmony import */ var _components_product_content_collapse_product_content_collapse__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ../../components/product-content-collapse/product-content-collapse */ 15534);
/* harmony import */ var _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ../../../../utils/pipes/safe-html/safe-html */ 93943);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! @ngx-translate/core */ 90852);



















































const _c0 = a0 => ({
  age: a0
});
function ProductDetailPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "widget-layout", 13);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("objectId", "product/" + (ctx_r1.product == null ? null : ctx_r1.product.Upc))("slug", ctx_r1.router.url);
  }
}
function ProductDetailPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "widget-layout", 14);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("objectId", "product/" + (ctx_r1.product == null ? null : ctx_r1.product.Upc))("slug", ctx_r1.router.url);
  }
}
function ProductDetailPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "widget-layout", 15);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("objectId", "product/" + (ctx_r1.product == null ? null : ctx_r1.product.Upc))("slug", ctx_r1.router.url);
  }
}
function ProductDetailPageComponent_ng_container_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](1, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](2, "ion-spinner", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementContainerEnd"]();
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 59);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "div", 60);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](2, 1, ctx_r1.magGallery), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵsanitizeHtml"]);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "div", 60);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "safeHtml");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("innerHTML", _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](2, 1, ctx_r1.magImg), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵsanitizeHtml"]);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 62)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"]((ctx_r1.product == null ? null : ctx_r1.product.DisplayName == null ? null : ctx_r1.product.DisplayName.En) || (ctx_r1.product.Name == null ? null : ctx_r1.product.Name.En));
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_4_span_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate1"]("(", ctx_r1.product == null ? null : ctx_r1.product.PricePerUnitItem, ")");
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_4_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 63)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](3, ProductDetailPageComponent_ng_template_7_div_1_div_4_span_3_Template, 2, 1, "span", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate1"]("", ctx_r1.product.Unit, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.PricePerUnitItem);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_6_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 64)(1, "ion-text");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](3, "ion-icon", 65);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](ctx_r1.product.LoyaltyProgramIndicator);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 66);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-deal-terms", 67);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("offer", ctx_r1.productOffers[0]);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_span_10_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-attribute", 68);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpropertyInterpolate1"]("name", "Ready in ", ctx_r1.productLeadTime, "");
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_span_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-attribute", 69);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_span_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-attribute", 70);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_span_13_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-attribute", 71);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_14_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 72);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-notification", 73);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("message", _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind2"](2, 1, "productDetail.legalAge", _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpureFunction1"](4, _c0, ctx_r1.product == null ? null : ctx_r1.product.AgeRestrictedValue)));
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_15_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 72);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-notification", 73);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("message", _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](2, 1, "productDetail.requiredPrep"));
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_16_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 74)(1, "div", 75)(2, "div", 76);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](3, "ion-icon", 77);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](4, "div", 78)(5, "h3", 79);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](7, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](8, "p", 80);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](9);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](10, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()()()();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](7, 2, "productDetail.itemNotAdd"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](10, 4, "productDetail.itemNotAdddesc"));
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_17_Template(rf, ctx) {
  if (rf & 1) {
    const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 81)(1, "parity-product-flavor", 82);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵlistener"]("changeFlavor", function ProductDetailPageComponent_ng_template_7_div_1_div_17_Template_parity_product_flavor_changeFlavor_1_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵrestoreView"](_r3);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵresetView"](ctx_r1.changeFlavorProduct($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("parityName", ctx_r1.product == null ? null : ctx_r1.product.Parity == null ? null : ctx_r1.product.Parity.Characteristic)("selectedProductUpc", ctx_r1.product == null ? null : ctx_r1.product.Upc)("listProduct", ctx_r1.product == null ? null : ctx_r1.product.Parity == null ? null : ctx_r1.product.Parity.Products)("storeCode", ctx_r1.store.StoreCode);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_18_Template(rf, ctx) {
  if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 83)(1, "price-multiple-cards", 84);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵlistener"]("handleChangePriceCard", function ProductDetailPageComponent_ng_template_7_div_1_div_18_Template_price_multiple_cards_handleChangePriceCard_1_listener($event) {
      _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵrestoreView"](_r4);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
      return _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵresetView"](ctx_r1.handleChangePriceCard($event));
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("rawPriceList", ctx_r1.product == null ? null : ctx_r1.product.OptionSets);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_19_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 85);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "product-added", 86);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("configData", ctx_r1.addedProductConfig)("inCartProducts", ctx_r1.inCartProducts);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_20_mag_offer_information_card_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "mag-offer-information-card", 89);
  }
  if (rf & 2) {
    const offer_r5 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("offer", offer_r5);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_20_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 87);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](1, ProductDetailPageComponent_ng_template_7_div_1_div_20_mag_offer_information_card_1_Template, 1, 1, "mag-offer-information-card", 88);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngForOf", ctx_r1.productOffers);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_21_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 90)(1, "div", 91);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](2, "mag-shopping-list-button-container", 92, 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("product", ctx_r1.product);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_22_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 93);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-product-promo", 94);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("promoList", ctx_r1.product == null ? null : ctx_r1.product.PromoCollections);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_39_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate3"](" ", ctx_r1.categoryDepartment, " ", ctx_r1.categoryDepartment && (ctx_r1.product == null ? null : ctx_r1.product.Department) ? ", " : "", " ", ctx_r1.product == null ? null : ctx_r1.product.Department, " ");
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_46_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "product-content-collapse", 95);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("content", ctx_r1.product == null ? null : ctx_r1.product.ShortDescription == null ? null : ctx_r1.product.ShortDescription.En);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_47_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "product-content-collapse", 96);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("content", ctx_r1.product == null ? null : ctx_r1.product.Instructions == null ? null : ctx_r1.product.Instructions.En);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_48_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "product-content-collapse", 97);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("content", ctx_r1.product == null ? null : ctx_r1.product.HazardPrecautionaryStatement);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_49_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](1, "div", 99);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementContainerEnd"]();
  }
  if (rf & 2) {
    const attr_r6 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](attr_r6 == null ? null : attr_r6.Name);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_49_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](1, ProductDetailPageComponent_ng_template_7_div_1_div_49_ng_container_1_Template, 3, 1, "ng-container", 98);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngForOf", ctx_r1.productRes == null ? null : ctx_r1.productRes.Attributes);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_50_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "product-content-collapse", 95);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("content", ctx_r1.product == null ? null : ctx_r1.product.FullDescription == null ? null : ctx_r1.product.FullDescription.En);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_51_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "product-content-collapse", 100);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("content", ctx_r1.productDeclaimer);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_52_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 101);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-product-promo-list", 94);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("promoList", ctx_r1.product == null ? null : ctx_r1.product.PromoCollections);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_53_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 101);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-product-card-list", 102);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpropertyInterpolate"]("rawData", ctx_r1.similarProducts);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_ion_img_59_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "ion-img", 103);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("src", ctx_r1.product.Nutritional);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_mag_nutrition_facts_60_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "mag-nutrition-facts", 104);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("rawData", ctx_r1.product.Nutrients)("servingInfo", ctx_r1.product == null ? null : ctx_r1.product.NutrientOverview);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_div_61_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 105)(1, "div", 106);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](4, "div", 107);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](3, 2, "productDetail.ingredients"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](ctx_r1.product.Ingredients);
  }
}
function ProductDetailPageComponent_ng_template_7_div_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](1, ProductDetailPageComponent_ng_template_7_div_1_div_1_Template, 3, 3, "div", 22)(2, ProductDetailPageComponent_ng_template_7_div_1_div_2_Template, 3, 3, "div", 23)(3, ProductDetailPageComponent_ng_template_7_div_1_div_3_Template, 3, 1, "div", 24)(4, ProductDetailPageComponent_ng_template_7_div_1_div_4_Template, 4, 2, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](5, "mag-price-ribbons", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](6, ProductDetailPageComponent_ng_template_7_div_1_div_6_Template, 4, 1, "div", 27)(7, ProductDetailPageComponent_ng_template_7_div_1_div_7_Template, 2, 1, "div", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](8, "div", 29)(9, "div", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](10, ProductDetailPageComponent_ng_template_7_div_1_span_10_Template, 2, 2, "span", 31)(11, ProductDetailPageComponent_ng_template_7_div_1_span_11_Template, 2, 0, "span", 31)(12, ProductDetailPageComponent_ng_template_7_div_1_span_12_Template, 2, 0, "span", 31)(13, ProductDetailPageComponent_ng_template_7_div_1_span_13_Template, 2, 0, "span", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](14, ProductDetailPageComponent_ng_template_7_div_1_div_14_Template, 3, 6, "div", 32)(15, ProductDetailPageComponent_ng_template_7_div_1_div_15_Template, 3, 3, "div", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](16, ProductDetailPageComponent_ng_template_7_div_1_div_16_Template, 11, 6, "div", 33)(17, ProductDetailPageComponent_ng_template_7_div_1_div_17_Template, 2, 4, "div", 34)(18, ProductDetailPageComponent_ng_template_7_div_1_div_18_Template, 2, 1, "div", 35)(19, ProductDetailPageComponent_ng_template_7_div_1_div_19_Template, 2, 2, "div", 36)(20, ProductDetailPageComponent_ng_template_7_div_1_div_20_Template, 2, 1, "div", 37)(21, ProductDetailPageComponent_ng_template_7_div_1_div_21_Template, 4, 1, "div", 38)(22, ProductDetailPageComponent_ng_template_7_div_1_div_22_Template, 2, 1, "div", 39);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](23, "div", 40)(24, "div", 41);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](25);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](26, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](27, "div", 42);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](28, "div", 43)(29, "div", 44)(30, "div", 45);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](31);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](32, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](33, "div", 46);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](34);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](35, "div", 47)(36, "div", 45);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](37);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](38, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](39, ProductDetailPageComponent_ng_template_7_div_1_div_39_Template, 2, 3, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](40, "div", 44)(41, "div", 45);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](42);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](43, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](44, "div", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](45);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()()();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](46, ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_46_Template, 1, 1, "product-content-collapse", 50)(47, ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_47_Template, 1, 1, "product-content-collapse", 51)(48, ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_48_Template, 1, 1, "product-content-collapse", 52)(49, ProductDetailPageComponent_ng_template_7_div_1_div_49_Template, 2, 1, "div", 31)(50, ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_50_Template, 1, 1, "product-content-collapse", 50)(51, ProductDetailPageComponent_ng_template_7_div_1_product_content_collapse_51_Template, 1, 1, "product-content-collapse", 53);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](52, ProductDetailPageComponent_ng_template_7_div_1_div_52_Template, 2, 1, "div", 54)(53, ProductDetailPageComponent_ng_template_7_div_1_div_53_Template, 2, 1, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](54, "div", 55)(55, "div", 41);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](56);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](57, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](58, "div", 42);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](59, ProductDetailPageComponent_ng_template_7_div_1_ion_img_59_Template, 1, 1, "ion-img", 56)(60, ProductDetailPageComponent_ng_template_7_div_1_mag_nutrition_facts_60_Template, 1, 2, "mag-nutrition-facts", 57)(61, ProductDetailPageComponent_ng_template_7_div_1_div_61_Template, 6, 4, "div", 58);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.Images);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", !(ctx_r1.product == null ? null : ctx_r1.product.Images));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", (ctx_r1.product == null ? null : ctx_r1.product.DisplayName) || (ctx_r1.product == null ? null : ctx_r1.product.Name));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.isDisplayUnitPrice);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("product", ctx_r1.productRes);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.LoyaltyProgramIndicator);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", (ctx_r1.productOffers == null ? null : ctx_r1.productOffers.length) === 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.productLeadTime);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.productStore == null ? null : ctx_r1.productStore.EbtSnapEligibility);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", (ctx_r1.productStore == null ? null : ctx_r1.productStore.EbtSnapEligibility) && (ctx_r1.productStore == null ? null : ctx_r1.productStore.EbtCashEligibility));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.AgeRestricted);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.AgeRestricted);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.productLeadTime);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.isEditMode);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.Parity);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.isPriceMultiplier && ctx_r1.product);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.inCartProducts && ctx_r1.addedProductConfig);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", (ctx_r1.productOffers == null ? null : ctx_r1.productOffers.length) > 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.isShoppingList === false);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.PromoCollections);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](26, 39, "productDetail.prodDes"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](32, 41, "productDetail.brand"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate1"](" ", ctx_r1.product == null ? null : ctx_r1.product.Brand, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](38, 43, "productDetail.department"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.categoryDepartment || (ctx_r1.product == null ? null : ctx_r1.product.Department));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](43, 45, "productDetail.prodCode"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](ctx_r1.product == null ? null : ctx_r1.product.Upc);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.ShortDescription == null ? null : ctx_r1.product.ShortDescription.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.Instructions == null ? null : ctx_r1.product.Instructions.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.HazardPrecautionaryStatement);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.productRes == null ? null : ctx_r1.productRes.Attributes == null ? null : ctx_r1.productRes.Attributes.length);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.FullDescription == null ? null : ctx_r1.product.FullDescription.En);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", !(ctx_r1.product == null ? null : ctx_r1.product.FullDescription == null ? null : ctx_r1.product.FullDescription.En) && ctx_r1.productDeclaimer);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.PromoCollections);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.similarProducts);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](57, 47, "productDetail.nutritionInfo"));
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.Nutritional);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.Nutrients);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product == null ? null : ctx_r1.product.Ingredients);
  }
}
function ProductDetailPageComponent_ng_template_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](0, "widget-layout", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](1, ProductDetailPageComponent_ng_template_7_div_1_Template, 62, 49, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](2, "widget-layout", 20);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("objectId", "product/" + (ctx_r1.product == null ? null : ctx_r1.product.Upc))("slug", ctx_r1.router.url);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx_r1.product);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("objectId", "product/" + (ctx_r1.product == null ? null : ctx_r1.product.Upc))("slug", ctx_r1.router.url);
  }
}
function ProductDetailPageComponent_div_11_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 108);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](2, 1, "productDetail.instoreOnly"));
  }
}
function ProductDetailPageComponent_div_12_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 108);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](2, 1, "productDetail.currentUnavailable"), " ");
  }
}
function ProductDetailPageComponent_div_13_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "div", 109);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelement"](1, "mag-product-cta", 110);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("buttonViewMode", ctx_r1.btnMode)("selectedOptions", ctx_r1.selectedOptions)("product", ctx_r1.productRes)("isFullWidth", true)("showMissPromotionFullWidth", false);
  }
}
function ProductDetailPageComponent_ion_button_14_Template(rf, ctx) {
  if (rf & 1) {
    const _r7 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](0, "ion-button", 111);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵlistener"]("click", function ProductDetailPageComponent_ion_button_14_Template_ion_button_click_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵrestoreView"](_r7);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵnextContext"]();
      return _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵresetView"](ctx_r1.openSelectOptionModal());
    });
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵpipeBind1"](2, 1, "productDetail.select"));
  }
}
class ProductDetailPageComponent {
  router;
  utils;
  route;
  productService;
  productDealService;
  modalCtrl;
  cStore;
  navCtrl;
  appSettings;
  storage;
  googleTracking;
  rsTracking;
  dxpTracking;
  auth;
  cre;
  routeTracker;
  shoppingListSvc;
  ngZone;
  storeService;
  shoppingCartService;
  productRes;
  product;
  similarProducts;
  slug;
  isProductWithOption = false;
  isGiftCard = false;
  store;
  productDes;
  isInstoreOnly = false;
  productStore;
  productLeadTime;
  buttonName = 'Add to Cart';
  inCartProducts;
  shoppingMode;
  addedProductConfig = {};
  isEdit = false;
  selectedOptionSets = [];
  itemId = '';
  productOffers;
  JSON = JSON;
  quantity;
  isPriceMultiplier = false;
  magQuanityBtn;
  magGallery;
  productDeclaimer;
  isDisplayUnitPrice = true;
  selectedOptions;
  btnMode = 'DETAIL';
  isButtonQuantityReady;
  categoryDepartment;
  magImg = '<mag-img src></mag-img>';
  loaded;
  isShoppingList = false;
  isAddedShoppingList = false;
  currentUser;
  isEditMode = false;
  isLoading = false;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_29__.Subject();
  _initCompleted$ = new rxjs__WEBPACK_IMPORTED_MODULE_29__.Subject();
  messageHandler = event => {
    this.handleMessage(event);
  };
  systemService;
  isUnavailable = false;
  constructor(router, utils, route, productService, productDealService, modalCtrl, cStore, navCtrl, appSettings, storage, googleTracking, rsTracking, dxpTracking, auth, cre, routeTracker, shoppingListSvc, ngZone, storeService, shoppingCartService) {
    this.router = router;
    this.utils = utils;
    this.route = route;
    this.productService = productService;
    this.productDealService = productDealService;
    this.modalCtrl = modalCtrl;
    this.cStore = cStore;
    this.navCtrl = navCtrl;
    this.appSettings = appSettings;
    this.storage = storage;
    this.googleTracking = googleTracking;
    this.rsTracking = rsTracking;
    this.dxpTracking = dxpTracking;
    this.auth = auth;
    this.cre = cre;
    this.routeTracker = routeTracker;
    this.shoppingListSvc = shoppingListSvc;
    this.ngZone = ngZone;
    this.storeService = storeService;
    this.shoppingCartService = shoppingCartService;
    this.route.params.subscribe(param => {
      const {
        slug
      } = param;
      this.slug = slug;
    });
  }
  onMessage(event) {
    this.messageHandler(event);
  }
  ngOnInit() {
    this._initCompleted$.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_30__.take)(1), (0,rxjs__WEBPACK_IMPORTED_MODULE_31__.takeUntil)(this._destroy$)).subscribe(() => {
      this.getProductDeclaimer();
      this.loadSimilarProducts();
      this.shoppingListSvc.handleGetShoppingListByUserId();
      this.shoppingListSvc.getCurrentShoppingList().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_31__.takeUntil)(this._destroy$)).subscribe({
        next: currentShoppingList => {
          if (currentShoppingList && this.product) {
            const productInList = currentShoppingList.Items?.find(item => item.ProductId === this.product.ProductId);
            this.ngZone.run(() => {
              this.isAddedShoppingList = !!productInList;
            });
          }
        },
        error: err => console.warn(err)
      });
    });
  }
  initData() {
    (0,rxjs__WEBPACK_IMPORTED_MODULE_32__.combineLatest)([this.shoppingCartService.cartObs(), (0,rxjs__WEBPACK_IMPORTED_MODULE_33__.from)(this.init())]).pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_31__.takeUntil)(this._destroy$), (0,rxjs__WEBPACK_IMPORTED_MODULE_34__.tap)(([editOrder, product]) => {
      if (editOrder && product) {
        this.isValidLeadTime();
      }
    })).subscribe(() => {
      this._initCompleted$.next();
      this._initCompleted$.complete();
    });
  }
  ionViewWillEnter() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        _this.currentUser = _this.cre.currentUser;
        _this.initData();
      } catch (error) {
        console.error(error);
      }
    })();
  }
  ionViewDidLeave() {
    this._destroy$.next(true);
    this._destroy$.complete();
  }
  init() {
    var _this2 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this2.store = yield _this2.cStore.getStore();
      if (!_this2.store) {
        console.warn('Store not found');
        return;
      }
      yield _this2.refreshProductOffers();
      yield _this2.getStoreSystemServices();
      _this2.productStore = _this2.productRes && _this2.productRes.Stores?.find(item => String(item?.StoreCode) === String(_this2.store?.StoreCode));
      _this2.mappingProduct(_this2.productRes);
      _this2.isInstoreOnly = !_this2.product?.IsOutOfStock && !_this2.product?.Pickup && !_this2.product?.Delivery && !_this2.product?.Mail;
      _this2.productLeadTime = (0,_model_util__WEBPACK_IMPORTED_MODULE_5__.renderLeadTime)(_this2.product?.LeadTime);
      _this2.categoryDepartment = _this2.product?.Categories?.find(category => category?.Level === 1)?.CategoryName;
      _this2.detectProductType();
      _this2.updateMagQuantityButton(null);
      _this2.updateMagGallery();
      _this2.handleEventTracking();
      _this2.isProductUnavailable();
      _this2.isShoppingList = !(yield _this2.routeTracker.checkIsAvaiableCheckoutProductSvc(_this2.productRes));
      if (_this2.isProductWithOption) {
        _this2.subscribeRouteParams();
      }
      _this2.loaded = true;
      _this2.utils.hideLoading();
      return _this2.product;
    })();
  }
  isValidLeadTime() {
    var _this3 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const {
        isEditMode,
        getExpireTimeEditOrder
      } = _this3.shoppingCartService;
      const {
        LeadTime
      } = _this3.product;
      if (!isEditMode() || !LeadTime) return _this3.isEditMode = false;
      const expTime = yield getExpireTimeEditOrder();
      if (LeadTime >= expTime) return _this3.isEditMode = true;
    })();
  }
  handleEventTracking() {
    const priceProduct = this.googleTracking.getPriceFromProduct(this.productRes);
    const data = this.googleTracking.convertProductData(this.productRes);
    this.googleTracking.gtagTrackViewItem(data);
    this.rsTracking.trackProductView(this.product);
    this.dxpTracking.handlePushDxpTracking('trackViewProduct', {
      Price: priceProduct?.salePrice ? priceProduct?.salePrice : priceProduct?.price,
      Name: this.productRes?.Name?.En,
      UPC: this.productRes?.Upc,
      BrandName: this.productRes?.BrandName?.BrandName,
      Category: this.productRes?.Categories?.map(category => category.CategoryName).join(', ')
    });
  }
  handleMessage(event) {
    var _this4 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (event?.data?.action === _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_7__.ActionType.MagReloadItemInCart && _this4.isProductWithOption) {
        yield _this4.refreshCart();
      }
    })();
  }
  applyLocale(message) {
    var _this5 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (!message) return;
      const parsedMessage = JSON.parse(message);
      const currentLocale = yield _this5.storage.get(_rsApp_modules_utils_constants_constants__WEBPACK_IMPORTED_MODULE_10__.LOCAL_LOCALE_KEY);
      const transfromLocale = currentLocale && (0,lodash__WEBPACK_IMPORTED_MODULE_8__.upperFirst)(currentLocale);
      return parsedMessage?.[transfromLocale];
    })();
  }
  getProductDeclaimer() {
    var _this6 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const res = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this6.appSettings.getSettingValue('Product_Disclaimer'));
        const localizeMessage = res && (yield _this6.applyLocale(res));
        if (!localizeMessage) return;
        _this6.productDeclaimer = localizeMessage;
      } catch (error) {
        console.error('Error fetching product disclaimer:', error);
      }
    })();
  }
  updateMagQuantityButton(optionSet) {
    this.selectedOptions = optionSet ? [...optionSet] : null;
    this.isButtonQuantityReady = true;
  }
  updateMagGallery() {
    const isProductOnSale = this.product?.IsOnSale || this.productStore?.Prices?.some(x => x.PriceType === 'SalePrice') || false;
    if (!this.product?.Images) {
      this.magImg = `<mag-img display-sale-tag='${isProductOnSale}' src></mag-img>`;
      return;
    }
    this.magGallery = `<mag-gallery display-sale-tag='${isProductOnSale}' image-string='${this.product?.Images}'></mag-gallery>`;
  }
  handleChangePriceCard(optionSet) {
    if (!optionSet) {
      console.error('optionSet not found');
      return;
    }
    this.updateMagQuantityButton(optionSet);
  }
  isCustomer() {
    return this.auth?.cre?.currentUser;
  }
  loadCartsPreview() {
    var _this7 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const guestCartIds = _this7.productService.getGuestCartIds();
        const isCustomer = _this7.isCustomer();
        if (!guestCartIds && !isCustomer) {
          console.warn('Failed to loadCartsPreview', guestCartIds, isCustomer);
          return;
        }
        const cartPreview = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this7.productService.getMultiCartPreview(guestCartIds));
        return cartPreview?.Items?.filter(item => item?.Upc === _this7.slug);
      } catch (error) {
        console.error('Error: getMultiCartPreview', error);
      }
    })();
  }
  getCartData() {
    var _this8 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const cartData = yield _this8.loadCartsPreview();
        if (!cartData) {
          console.warn('Failed to loadCartsPreview', cartData);
          return;
        }
        const formatCartData = cartData?.map(item => {
          return {
            cartItemId: item?.Id,
            rawSelectedOptionsets: item?.OptionSets,
            productType: item?.ProductType,
            totalPrice: item?.TotalPrice,
            quantity: item?.Quantity
          };
        });
        if (!formatCartData) return;
        return formatCartData;
      } catch (err) {
        console.error(err);
      }
    })();
  }
  refreshCart() {
    var _this9 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const data = yield _this9.getCartData();
      _this9.ngZone.run(() => {
        if (data) {
          _this9.inCartProducts = data;
        }
        _this9.addedProductConfig = _this9.configOptionsModal();
        _this9.utils.hideLoading();
      });
    })();
  }
  detectEditModeFromCart() {
    if (!this.isEdit || !this.itemId) return;
    const productFromEdit = this.inCartProducts?.find(item => item?.cartItemId === this.itemId);
    this.quantity = productFromEdit?.quantity;
    this.selectedOptionSets = productFromEdit?.rawSelectedOptionsets;
    if (this.selectedOptionSets?.length) {
      this.openSelectOptionModal();
    }
  }
  subscribeRouteParams() {
    var _this0 = this;
    this.route.params.pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_31__.takeUntil)(this._destroy$)).subscribe(/*#__PURE__*/function () {
      var _ref = (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* (param) {
        const {
          itemId
        } = param;
        yield _this0.refreshCart();
        if (itemId) {
          _this0.itemId = itemId;
          _this0.isEdit = true;
          _this0.detectEditModeFromCart();
          _this0.isEdit = false;
        }
      });
      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }());
  }
  configOptionsModal() {
    const config = {
      productOptionSet: this.product?.OptionSets,
      regularPrice: this.product?.DisplayPrice,
      productName: this.product?.DisplayName?.En || this.product?.Name?.En,
      shoppingMode: this.shoppingMode,
      rawProduct: this.productRes,
      productId: this.product?.ProductId,
      storeCode: this.store?.StoreCode,
      productType: this.product?.ProductType,
      defaultImage: this.product?.Images
    };
    return config;
  }
  loadSimilarProducts() {
    var _this1 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const products = _this1.productRes && (yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this1.productService.getSimilarProducts(_this1.productRes?.Upc, _this1.store?.StoreCode)));
        if (!products || !products.length) return;
        _this1.similarProducts = JSON.stringify(products);
        _this1.getOffersForSimilarProduct(products);
      } catch (error) {
        console.error('Error: loadSimilarProducts', error);
      }
    })();
  }
  mappingProduct(productRes) {
    const {
      Name,
      DisplayName,
      Brands,
      Unit,
      MediaAssets,
      FullDescription,
      ShortDescription,
      Instructions,
      MinPurchaseQuantity,
      MaxPurchaseQuantity,
      Upc,
      AgeRestricted,
      AgeRestrictedValue,
      Pickup,
      Delivery,
      IsOutOfStockAllStore,
      LeadTime,
      Parity,
      ProductType,
      OptionSets,
      Nutritional,
      ProductId,
      IsDynamicSize,
      Categories,
      HazardPrecautionaryStatement,
      LoyaltyProgramIndicator,
      PromoCollections,
      Stores,
      Mail,
      Nutrients,
      NutrientOverview,
      Ingredients
    } = productRes;
    const priceItem = this.productStore?.Prices?.find(priceItem => priceItem?.PriceType === 'Price');
    const salePriceItem = this.productStore?.Prices?.find(priceItem => priceItem?.PriceType === 'SalePrice');
    const images = MediaAssets?.Images?.map(img => {
      return img.ImgUrlOriginal;
    });
    const productServiceId = Stores?.[0]?.Services?.[0]?.ServiceId;
    const AisleDisplayName = this.productStore?.Locations?.[0]?.AisleDisplayName;
    this.product = {
      Name,
      DisplayName,
      Images: images && images?.length > 0 ? JSON.stringify(images) : null,
      DisplaySalePrice: salePriceItem && salePriceItem?.DisplayPrice,
      PricingUnit: salePriceItem?.PricingUnit || priceItem?.PricingUnit,
      PricePerUnitItem: salePriceItem?.PricePerUnitItem || priceItem?.PricePerUnitItem,
      Unit,
      HazardPrecautionaryStatement,
      DisplayPrice: priceItem?.DisplayPrice,
      DisplayPricingUnit: _model_util__WEBPACK_IMPORTED_MODULE_5__.pricingUnit[priceItem?.PricingUnit],
      MinPurchaseQuantity,
      MaxPurchaseQuantity,
      Brand: Brands?.length > 0 ? Brands[0]?.BrandName : '',
      Department: AisleDisplayName ? `Aisle ${AisleDisplayName}` : null,
      Upc,
      FullDescription,
      ShortDescription,
      Instructions,
      AgeRestricted,
      AgeRestrictedValue,
      Pickup,
      Delivery,
      IsOutOfStock: this.productStore?.IsOutOfStock,
      IsOutOfStockAllStore,
      LeadTime,
      Parity,
      ProductType,
      OptionSets,
      Nutritional,
      Nutrients,
      NutrientOverview,
      ProductId: ProductId,
      IsDynamicSize: IsDynamicSize,
      Categories,
      LoyaltyProgramIndicator,
      PromoCollections,
      ProductServiceId: productServiceId,
      Mail: Mail,
      Ingredients
    };
  }
  detectProductType() {
    this.isPriceMultiplier = false;
    this.isProductWithOption = false;
    if (this.product?.IsDynamicSize || this.product?.ProductType === 'GiftCard') {
      this.isDisplayUnitPrice = false;
    }
    if (this.product?.OptionSets?.length === 1 && this.product?.IsDynamicSize) {
      this.isPriceMultiplier = true;
    }
    if (this.product?.OptionSets?.length && !this.product?.IsDynamicSize) {
      this.isProductWithOption = true;
    }
  }
  openSelectOptionModal() {
    if (this.product?.ProductType === 'GiftCard') {
      // Gift Card Product
      return this.openGiftCardOptionsModal();
    }
    // Regular Product
    return this.openProductOptionsModal();
  }
  openProductOptionsModal() {
    var _this10 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const modal = yield _this10.modalCtrl.create({
        cssClass: 'product-options-modal',
        component: _product_module__WEBPACK_IMPORTED_MODULE_3__.ProductOptionsModalComponent,
        componentProps: {
          productOptionSet: _this10.product?.OptionSets,
          regularPrice: _this10.product?.DisplayPrice,
          productName: _this10.product?.DisplayName?.En || _this10.product?.Name?.En,
          shoppingMode: _this10.shoppingMode,
          rawProduct: _this10.productRes,
          productId: _this10.product?.ProductId,
          storeCode: _this10.store?.StoreCode,
          isEdit: _this10.isEdit,
          selectedOptionSets: _this10.selectedOptionSets,
          defaultImage: _this10.product?.Images,
          quantity: _this10.quantity,
          cartItemId: _this10.itemId?.length && _this10.itemId
        },
        breakpoints: [0, 0.5, 1],
        initialBreakpoint: 1,
        handle: false
      });
      modal.onDidDismiss().then();
      return yield modal.present();
    })();
  }
  openGiftCardOptionsModal() {
    var _this11 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const modal = yield _this11.modalCtrl.create({
        cssClass: 'gift-card-options-modal',
        component: _product_module__WEBPACK_IMPORTED_MODULE_3__.GiftCardOptionsModalComponent,
        componentProps: {
          giftCardOptions: _this11.product?.OptionSets,
          productName: _this11.product?.DisplayName?.En || _this11.product?.Name?.En,
          isEdit: _this11.isEdit,
          selectedOptionSets: _this11.selectedOptionSets,
          isInstoreOnly: _this11.isInstoreOnly,
          rawProduct: _this11.productRes,
          IsOutOfStock: _this11.product?.IsOutOfStock,
          shoppingMode: _this11.shoppingMode,
          productId: _this11.product?.ProductId,
          storeCode: _this11.store.StoreCode,
          quantity: _this11.quantity,
          defaultImage: _this11.product?.Images,
          cartItemId: _this11.itemId?.length && _this11.itemId
        },
        breakpoints: [0, 0.5, 1],
        initialBreakpoint: 1,
        handle: false
      });
      modal.onDidDismiss().then(detail => {
        console.log('Gift card options selected  ====>', detail);
      });
      return yield modal.present();
    })();
  }
  goCart() {
    this.router.navigate(['/cart']);
  }
  changeFlavorProduct(product) {
    var _this12 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this12.utils.showLoading();
      if (product) _this12.navCtrl.navigateForward([`/product/product-detail/${product.Upc}`], {
        replaceUrl: true,
        animated: false
      });
      _this12.slug = product?.Upc;
    })();
  }
  addToList() {
    var _this13 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      if (!_this13.currentUser) {
        _this13.router.navigateByUrl('/sign-in', {
          replaceUrl: true
        });
        return;
      }
      _this13.isLoading = true;
      try {
        yield _this13.shoppingListSvc.handleAddItemToCurrentShoppingList(_this13.product);
        const payload = {
          action: _rsApp_modules_utils_enum_enum__WEBPACK_IMPORTED_MODULE_7__.ActionType.MagRefreshShoppingList
        };
        window.postMessage(payload, window.location.origin);
      } catch (err) {
        console.warn('Error adding to list', err);
      } finally {
        _this13.isLoading = false;
      }
    })();
  }
  getPageName() {
    return 'ProductDetailPage';
  }
  getOffersForSimilarProduct(products) {
    var _this14 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const upcs = products.map(x => x.Upc).filter(Boolean);
      try {
        const {
          ProductMappings,
          Offers
        } = (yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this14.productDealService.getOfferInfosByUpcs(upcs, _this14.store.StoreCode))) || {};
        if (!ProductMappings || !Offers) return;
        const offersByUpc = Object.fromEntries(ProductMappings?.map(item => [item.Upc, item.OfferIds]));
        const list = products.map(x => {
          const offerIds = offersByUpc[x.Upc];
          if (offerIds?.length) {
            x.Offers = Offers.filter(offer => offerIds.includes(offer.Id));
          }
          return x;
        });
        _this14.similarProducts = JSON.stringify(list);
      } catch (error) {
        console.log('Fail fetching offers for similar products :', error);
      }
    })();
  }
  refreshProductOffers() {
    var _this15 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this15.productRes = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this15.productService.getProductByUPC(_this15.slug, _this15.store?.StoreCode, false, _this15.currentUser));
      // this.productOffers = this.productRes?.Offers;
      // don't need await offer load done
      (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this15.productDealService.getOfferInfosByUpcs([_this15.slug], _this15.store?.StoreCode)).then(rs => {
        if (rs?.Offers) {
          const offers = rs?.Offers;
          _this15.productOffers = offers?.filter(x => x.DiscountType !== _model_enum__WEBPACK_IMPORTED_MODULE_19__.enumDiscountType.ExternalPromotion && !(x.DiscountType === _model_enum__WEBPACK_IMPORTED_MODULE_19__.enumDiscountType.NewPrice && x.EffectValue === 0));
        }
      });
    })();
  }
  getStoreSystemServices() {
    var _this16 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      try {
        const res = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this16.storeService.getStoreSystemServices(true));
        if (res?.length > 0) {
          _this16.systemService = res.find(service => (0,_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.toBoolean)(service?.SettingAttributes?.is_default_shop_path?.Value));
        }
      } catch (error) {
        console.error('Error fetching system services', error);
      }
    })();
  }
  isProductUnavailable() {
    var _this17 = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      const productServiceId = _this17.product?.ProductServiceId;
      const storeService = _this17.store?.StoreServices?.find(service => service?.ServiceId === productServiceId);
      // Check fulfillment method support by product
      const productSupportPickup = String(_this17.product?.Pickup) === 'true';
      const productSupportDelivery = String(_this17.product?.Delivery) === 'true';
      const productDeliveryOnly = !productSupportPickup && productSupportDelivery;
      const productPickupOnly = productSupportPickup && !productSupportDelivery;
      // Check fulfillment method support by system service
      const allService = yield (0,rxjs__WEBPACK_IMPORTED_MODULE_35__.firstValueFrom)(_this17.storeService.getStoreSystemServices());
      const systemService = _this17.storeService.getSystemServiceById(productServiceId, allService);
      const {
        EnabledDelivery: SystemServiceSupportDelivery,
        EnabledPickup: SystemServiceSupportPickup
      } = systemService ?? {};
      const serviceDeliveryOnly = SystemServiceSupportDelivery && !SystemServiceSupportPickup;
      const servicePickupOnly = SystemServiceSupportPickup && !SystemServiceSupportDelivery;
      // Check out of stock
      const outOfStock = !!_this17.product?.IsOutOfStock || !!_this17.product?.IsOutOfStockAllStore;
      // Check if no service found
      const noServiceFound = !productServiceId || !storeService?.ServiceId;
      // Check if no service support product
      const noServiceSupportProduct = serviceDeliveryOnly && productPickupOnly || servicePickupOnly && productDeliveryOnly;
      _this17.isUnavailable = outOfStock || noServiceFound || noServiceSupportProduct;
    })();
  }
  backPage() {
    this.navCtrl.back();
  }
  static ɵfac = function ProductDetailPageComponent_Factory(t) {
    return new (t || ProductDetailPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_36__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_36__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_providers_product_service__WEBPACK_IMPORTED_MODULE_2__.ProductService), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_providers_product_deal_service__WEBPACK_IMPORTED_MODULE_6__.ProductDealService), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_37__.ModalController), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_4__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_38__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_app_setting__WEBPACK_IMPORTED_MODULE_9__.AppSettings), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_ionic_storage__WEBPACK_IMPORTED_MODULE_11__.Storage), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_google_tracker_service__WEBPACK_IMPORTED_MODULE_12__.GoogleAnalyticTracker), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_rs_tracker_service__WEBPACK_IMPORTED_MODULE_13__.RSTracker), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_tracker_service__WEBPACK_IMPORTED_MODULE_14__.DXPTracker), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_auth_v2_service__WEBPACK_IMPORTED_MODULE_15__.AuthService), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_16__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_route_tracker_service__WEBPACK_IMPORTED_MODULE_18__.RouteTrackerService), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_ecom_v2_shopping_list_providers_shopping_list_service__WEBPACK_IMPORTED_MODULE_17__.ShoppingListService), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_28__.NgZone), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_store_store_module__WEBPACK_IMPORTED_MODULE_4__.StoreService), _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdirectiveInject"](_rsApp_modules_ecom_v2_edit_order_service__WEBPACK_IMPORTED_MODULE_20__.EditOrderService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵdefineComponent"]({
    type: ProductDetailPageComponent,
    selectors: [["product-detail"]],
    hostBindings: function ProductDetailPageComponent_HostBindings(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵlistener"]("message", function ProductDetailPageComponent_message_HostBindingHandler($event) {
          return ctx.onMessage($event);
        }, false, _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵresolveWindow"]);
      }
    },
    decls: 15,
    vars: 11,
    consts: [["loadedContent", ""], ["magShoppingListIcon", ""], ["type", "product", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "product", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "product", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader", "isShowBackButton"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", 1, "custom-back-btn", 3, "click"], [1, "ion-padding"], [4, "ngIf", "ngIfElse"], [1, "custom-toolbar"], ["class", "custom-toolbar__unavailable", 4, "ngIf"], ["class", "btn-add", 4, "ngIf"], ["expand", "block", 3, "click", 4, "ngIf"], ["type", "product", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "product", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "product", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "loading-container"], ["name", "crescent"], ["type", "product", "zoneName", "Top", 3, "objectId", "slug"], ["class", "product-detail", 4, "ngIf"], ["type", "product", "zoneName", "Bottom", 3, "objectId", "slug"], [1, "product-detail"], ["class", "product-detail__img", 4, "ngIf"], ["class", "product-detail__default-img", 4, "ngIf"], ["class", "product-detail__title", 4, "ngIf"], ["class", "product-detail__sizing", 4, "ngIf"], ["mode", "detail", 3, "product"], ["class", "product-detail__loyalty-indicator", 4, "ngIf"], ["class", "product-detail__quantity-rules", 4, "ngIf"], [1, "product-detail__tags", "mb-4"], [1, "product-detail__tags--item"], [4, "ngIf"], ["class", "product-detail__tags--attribute", 4, "ngIf"], ["class", "product-detail__box mb-4", 4, "ngIf"], ["class", "product-detail__parity mb-4", 4, "ngIf"], ["class", "product-detail__price-multiple mb-4", 4, "ngIf"], ["class", "product-detail__product-added mb-4", 4, "ngIf"], ["class", "mb-4 product-detail__coupon", 4, "ngIf"], ["class", "product-detail__actions mb-4", 4, "ngIf"], ["class", "product-detail__promo", 4, "ngIf"], [1, "product-detail__description"], [1, "product-detail__session-title"], [1, "product-detail__session-line"], [1, "product-detail__description-content"], [1, "description-content-item", "description-content-item--bg-diff"], [1, "description-content-item__name"], [1, "description-content-item__value", "description-content-item__value--underline"], [1, "description-content-item"], ["class", "description-content-item__value", 4, "ngIf"], [1, "description-content-item__value"], ["type", "default", 3, "content", 4, "ngIf"], ["title", "Instructions", "type", "default", 3, "content", 4, "ngIf"], ["title", "Warning", "type", "default", 3, "content", 4, "ngIf"], ["type", "declaimer", 3, "content", 4, "ngIf"], ["class", "product-detail__related mb-4", 4, "ngIf"], [1, "product-detail__nutrition"], ["class", "product-detail__session-image", 3, "src", 4, "ngIf"], [3, "rawData", "servingInfo", 4, "ngIf"], ["class", "product-detail__ingredients mb-4", 4, "ngIf"], [1, "product-detail__img"], [3, "innerHTML"], [1, "product-detail__default-img"], [1, "product-detail__title"], [1, "product-detail__sizing"], [1, "product-detail__loyalty-indicator"], ["src", "../assets/icon/phone-ring.svg"], [1, "product-detail__quantity-rules"], ["mode", "detail", 3, "offer"], [3, "name"], ["name", "SNAP"], ["name", "EBT Cash"], ["name", "ID Required"], [1, "product-detail__tags--attribute"], ["type", "info", 3, "message"], [1, "product-detail__box", "mb-4"], [1, "product-detail__warning"], [1, "product-detail__warning-icon"], ["src", "assets/icon/warning-ico.svg"], [1, "product-detail__warning-text"], [1, "product-detail__warning-header"], [1, "product-detail__warning-desc"], [1, "product-detail__parity", "mb-4"], [3, "changeFlavor", "parityName", "selectedProductUpc", "listProduct", "storeCode"], [1, "product-detail__price-multiple", "mb-4"], [3, "handleChangePriceCard", "rawPriceList"], [1, "product-detail__product-added", "mb-4"], [3, "configData", "inCartProducts"], [1, "mb-4", "product-detail__coupon"], ["mode", "full", 3, "offer", 4, "ngFor", "ngForOf"], ["mode", "full", 3, "offer"], [1, "product-detail__actions", "mb-4"], [1, "product-detail__add-to-list"], ["button-view-mode", "DETAIL", "mode", "icon", 3, "product"], [1, "product-detail__promo"], [3, "promoList"], ["type", "default", 3, "content"], ["title", "Instructions", "type", "default", 3, "content"], ["title", "Warning", "type", "default", 3, "content"], [4, "ngFor", "ngForOf"], [1, "product-detail__attribute"], ["type", "declaimer", 3, "content"], [1, "product-detail__related", "mb-4"], ["header", "Related Products", "list-type", "1", 3, "rawData"], [1, "product-detail__session-image", 3, "src"], [3, "rawData", "servingInfo"], [1, "product-detail__ingredients", "mb-4"], [1, "product-detail__ingredients-title"], [1, "product-detail__ingredients-content"], [1, "custom-toolbar__unavailable"], [1, "btn-add"], [3, "buttonViewMode", "selectedOptions", "product", "isFullWidth", "showMissPromotionFullWidth"], ["expand", "block", 3, "click"]],
    template: function ProductDetailPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵgetCurrentView"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](0, ProductDetailPageComponent_widget_layout_0_Template, 1, 2, "widget-layout", 2)(1, ProductDetailPageComponent_widget_layout_1_Template, 1, 2, "widget-layout", 3)(2, ProductDetailPageComponent_widget_layout_2_Template, 1, 2, "widget-layout", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](3, "app-header", 5)(4, "ion-back-button", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵlistener"]("click", function ProductDetailPageComponent_Template_ion_back_button_click_4_listener() {
          _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵrestoreView"](_r1);
          return _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵresetView"](ctx.backPage());
        });
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](5, "ion-content", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](6, ProductDetailPageComponent_ng_container_6_Template, 3, 0, "ng-container", 8)(7, ProductDetailPageComponent_ng_template_7_Template, 3, 5, "ng-template", null, 0, _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementStart"](9, "ion-footer")(10, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵtemplate"](11, ProductDetailPageComponent_div_11_Template, 3, 3, "div", 10)(12, ProductDetailPageComponent_div_12_Template, 3, 3, "div", 10)(13, ProductDetailPageComponent_div_13_Template, 2, 5, "div", 11)(14, ProductDetailPageComponent_ion_button_14_Template, 3, 3, "ion-button", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵelementEnd"]()();
      }
      if (rf & 2) {
        const loadedContent_r8 = _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵreference"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("isSimpleHeader", true)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", !ctx.loaded)("ngIfElse", loadedContent_r8);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.isInstoreOnly);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.isUnavailable || ctx.isEditMode);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.product && !ctx.isProductWithOption && ctx.isButtonQuantityReady);
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_28__["ɵɵproperty"]("ngIf", ctx.product && ctx.isProductWithOption);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_39__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_39__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonButton, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonFooter, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonIcon, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonImg, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonSpinner, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonText, _ionic_angular__WEBPACK_IMPORTED_MODULE_37__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_21__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_22__.HeaderComponent, _components_price_multiple_cards_price_multiple_cards__WEBPACK_IMPORTED_MODULE_23__.PriceMultipleCardsComponent, _components_product_added_product_added__WEBPACK_IMPORTED_MODULE_24__.ProductAddedComponent, _components_parity_product_parity_product_flavor_parity_product_flavor__WEBPACK_IMPORTED_MODULE_25__.ParityProductFlavorComponent, _components_product_content_collapse_product_content_collapse__WEBPACK_IMPORTED_MODULE_26__.ProductContentCollapseComponent, _utils_pipes_safe_html_safe_html__WEBPACK_IMPORTED_MODULE_27__.SafeHtmlPipe, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_40__.TranslatePipe],
    styles: ["ion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%] {\n  --background: var(--mag-brand-foundation-primary, #008000);\n  --background-activated: none;\n}\nion-footer[_ngcontent-%COMP%]   ion-button[_ngcontent-%COMP%]::part(native) {\n  height: var(--mag-spacing-600, 48px);\n}\n\nion-content[_ngcontent-%COMP%] {\n  --background: var(--mag-color-surface-primary, #fff);\n  --padding-top: var(--mag-spacing-400, 32px);\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n\n.product-detail[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n}\n.product-detail__img[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n.product-detail__img[_ngcontent-%COMP%]   img[_ngcontent-%COMP%] {\n  width: 343px;\n  height: 343px;\n  object-fit: contain;\n}\n.product-detail__title[_ngcontent-%COMP%] {\n  font-family: var(--mag-typography-font-family, Lato);\n  font-size: var(--mag-typography-headlines-large-font-size, 24px);\n  font-weight: var(--mag-typography-headlines-large-font-weight, 600);\n  line-height: var(--mag-typography-headlines-large-line-height, 32px);\n}\n.product-detail__sizing[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.product-detail__buy-again[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 32px;\n  font-size: var(--mag-typography-subtext-font-size, 12px);\n  font-weight: var(--mag-typography-subtext-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-subtext-line-height, 16px);\n  display: flex;\n  align-items: center;\n  gap: 2px;\n  margin-bottom: 32px;\n}\n.product-detail__buy-again-tag[_ngcontent-%COMP%] {\n  height: 24px;\n  padding: var(--mag-spacing-50, 4px) var(--mag-spacing-100, 8px);\n  border-radius: 8px;\n  color: var(--mag-color-text-primary, #121212);\n  font-weight: var(--mag-typography-subtext-font-weight-emphasized, 400);\n  background: var(--mag-mag-surface-info);\n}\n.product-detail__buy-again-last-purchased[_ngcontent-%COMP%] {\n  color: var(--mag-mag-text-info);\n  font-weight: var(--mag-typography-subtext-font-weight-emphasized, 400);\n}\n.product-detail__loyalty-indicator[_ngcontent-%COMP%] {\n  display: flex;\n  gap: var(--mag-spacing-100, 8px);\n  color: var(--mag-color-text-pricing-deal, #da0808);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  margin-top: var(--mag-spacing-100, 8px);\n  gap: var(--mag-spacing-100, 8px);\n}\n.product-detail__loyalty-indicator[_ngcontent-%COMP%]   ion-icon[_ngcontent-%COMP%] {\n  font-size: 24px;\n}\n.product-detail__sale-tag[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-100, 8px);\n}\n.product-detail__deal-ribbons[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-400, 32px);\n  margin-bottom: var(--mag-spacing-100, 8px);\n  display: flex;\n  gap: var(--mag-spacing-50, 4px);\n}\n.product-detail__price[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-deal-large-font-size, 28px);\n  font-weight: var(--mag-typography-deal-font-weight, 500);\n  line-height: var(--mag-typography-deal-large-line-height, 36px);\n  margin-top: var(--mag-spacing-50, 4px);\n  margin-bottom: var(--mag-spacing-100, 8px);\n}\n.product-detail__sale-price[_ngcontent-%COMP%] {\n  color: var(--mag-color-surface-deal, #da0808);\n  margin-right: var(--mag-spacing-200, 16px);\n}\n.product-detail__sale-price--decoration[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  text-decoration: line-through;\n  color: var(--mag-color-text-primary, #121212);\n}\n.product-detail__loyalty-program[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: 8px;\n  font-size: 16px;\n  line-height: 24px;\n  color: var(--mag-mag-text-alert);\n  margin-bottom: var(--mag-spacing-100, 8px);\n}\n.product-detail__loyalty-program[_ngcontent-%COMP%]   ion-img[_ngcontent-%COMP%] {\n  width: 24px;\n  height: 24px;\n}\n.product-detail__quantity-rules[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.product-detail__actions[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 68px;\n  margin-top: var(--mag-spacing-400, 32px);\n  display: flex;\n  align-items: center;\n  justify-content: space-between;\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 20px);\n  border-bottom: 1px solid #eeeeee;\n  border-top: 1px solid #eeeeee;\n}\n.product-detail__add-to-list[_ngcontent-%COMP%], .product-detail__added-to-list[_ngcontent-%COMP%], .product-detail__share[_ngcontent-%COMP%] {\n  height: 100%;\n  flex: 1;\n  display: flex;\n  align-items: center;\n  justify-content: center;\n  gap: var(--mag-spacing-100, 8px);\n}\n.product-detail__added-to-list[_ngcontent-%COMP%], .product-detail__add-to-list[_ngcontent-%COMP%] {\n  background: transparent;\n}\n.product-detail__added-to-list-image[_ngcontent-%COMP%] {\n  width: 16px;\n  height: 16px;\n  color: var(--mag-color-text-button-text-brand, #008000);\n}\n.product-detail__add-to-list-text[_ngcontent-%COMP%], .product-detail__added-to-list-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-button-labels-small-font-size, 14px);\n  font-style: normal;\n  font-weight: var(--mag-typography-button-label-small-emphasized-font-weight, 500);\n  line-height: var(--mag-typography-button-labels-small-line-height, 20px);\n}\n.product-detail__added-to-list-text[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-brand, #008000);\n}\n.product-detail__session-title[_ngcontent-%COMP%] {\n  font-size: var(--mag-typography-headlines-medium-font-size, 20px);\n  font-weight: var(--mag-typography-headlines-medium-font-weight, 500);\n  line-height: var(--mag-typography-headlines-medium-line-height, 28px);\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n.product-detail__session-line[_ngcontent-%COMP%] {\n  width: 100%;\n  border-bottom: 1px solid #eeeeee;\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n.product-detail__session-image[_ngcontent-%COMP%] {\n  max-width: 343px;\n}\n.product-detail__tags[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-150, 12px);\n}\n.product-detail__tags--attribute[_ngcontent-%COMP%] {\n  margin-top: var(--spacing-400, 32px);\n}\n.product-detail__tags--item[_ngcontent-%COMP%] {\n  display: flex;\n  gap: 4px;\n}\n.product-detail__description-content[_ngcontent-%COMP%] {\n  max-width: 480px;\n}\n.product-detail[_ngcontent-%COMP%]   .description-content-item[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: var(--mag-spacing-400, 32px);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  padding: var(--mag-spacing-200, 16px);\n}\n.product-detail[_ngcontent-%COMP%]   .description-content-item__value[_ngcontent-%COMP%] {\n  flex-basis: 50%;\n}\n.product-detail[_ngcontent-%COMP%]   .description-content-item__value--underline[_ngcontent-%COMP%] {\n  text-decoration: underline;\n}\n.product-detail[_ngcontent-%COMP%]   .description-content-item__name[_ngcontent-%COMP%] {\n  flex-basis: 50%;\n}\n.product-detail[_ngcontent-%COMP%]   .description-content-item--bg-diff[_ngcontent-%COMP%] {\n  background: #f7f8f9;\n}\n.product-detail__des-content[_ngcontent-%COMP%] {\n  position: relative;\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  margin-top: var(--mag-spacing-300, 24px);\n}\n.product-detail__des-content--blur[_ngcontent-%COMP%]:after {\n  position: absolute;\n  content: \"\";\n  filter: blur(10px);\n  height: 24px;\n  background: #ffffff;\n  left: -10px;\n  right: -10px;\n  bottom: 0;\n}\n.product-detail__attribute[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  border-radius: var(--mag-border-radius-small, 4px);\n  background: var(--mag-color-surface-info, #e5f5f9);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-caption-font-size, 11px);\n  font-style: normal;\n  font-weight: var(--mag-typography-caption-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-caption-line-height, 14px);\n  width: -moz-fit-content;\n  width: fit-content;\n  display: flex;\n  padding: var(--mag-spacing-25, 2px) var(--mag-spacing-50, 4px);\n  align-items: flex-start;\n  gap: 10px;\n  margin: 5px 5px 5px 0;\n}\n.product-detail__declaimer[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-subtext-font-size, 12px);\n  font-style: normal;\n  font-weight: var(--mag-typography-subtext-font-weight-regular, 300);\n  line-height: var(--mag-typography-subtext-line-height, 16px);\n}\n.product-detail__tag[_ngcontent-%COMP%] {\n  display: flex;\n  align-items: center;\n  gap: 4px;\n  margin: var(--mag-spacing-300, 24px) 0px;\n}\n.product-detail__sale-info[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-info, #647281);\n  font-size: var(--mag-typography-subtext-font-size, 12px);\n  font-weight: var(--mag-typography-subtext-font-weight-regular, 300);\n  line-height: var(--mag-typography-subtext-line-height, 16px);\n}\n.product-detail__related[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-600, 48px);\n}\n.product-detail__nutrition[_ngcontent-%COMP%] {\n  margin-top: var(--mag-spacing-600, 48px);\n}\n.product-detail__ingredients-title[_ngcontent-%COMP%] {\n  margin: var(--mag-spacing-300, 24px) 0px;\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.product-detail__ingredients-content[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n.product-detail__coupon[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  gap: var(--mag-spacing-200, 16px);\n}\n.product-detail__warning[_ngcontent-%COMP%] {\n  display: flex;\n  padding: var(--mag-spacing-150, 12px);\n  align-items: flex-start;\n  gap: var(--mag-spacing-100, 8px);\n  align-self: stretch;\n  border-radius: var(--mag-border-radius-medium, 8px);\n  background: var(--mag-color-surface-warning, #fff7e5);\n}\n.product-detail__warning-icon[_ngcontent-%COMP%] {\n  display: flex;\n  width: 24px;\n  height: 24px;\n  padding: 2.5px;\n  flex-direction: column;\n  justify-content: center;\n  align-items: center;\n  gap: 10px;\n}\n.product-detail__warning-text[_ngcontent-%COMP%] {\n  display: flex;\n  flex-direction: column;\n  align-items: flex-start;\n  gap: var(--mag-spacing-25, 2px);\n  flex: 1 0 0;\n}\n.product-detail__warning-header[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-emphasized, 400);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n  margin: 0;\n}\n.product-detail__warning-desc[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, \"Lexend, Arial, sans-serif\");\n  font-size: var(--mag-typography-body-small-font-size, 14px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-small-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-small-line-height, 20px);\n  margin: 0;\n}\n.product-detail__warning__promo[_ngcontent-%COMP%] {\n  margin: var(--mag-spacing-400, 32px) 0 var(--mag-spacing-600, 48px);\n}\n\n.custom-toolbar[_ngcontent-%COMP%] {\n  background: var(--mag-color-surface-primary, #fff);\n  padding: var(--mag-spacing-200, 16px);\n  border-top: 1px solid var(--mag-color-border-divider, #eeeeee);\n}\n.custom-toolbar__unavailable[_ngcontent-%COMP%] {\n  display: flex;\n  justify-content: flex-start;\n  align-items: flex-start;\n  color: var(--mag-color-text-secondary, #555);\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n\n.mb-4[_ngcontent-%COMP%] {\n  margin-bottom: var(--mag-spacing-400, 32px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvcGFnZXMvcHJvZHVjdC1kZXRhaWwvcHJvZHVjdC1kZXRhaWwuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFDRTtFQUNFLDBEQUFBO0VBQ0EsNEJBQUE7QUFBSjtBQUdFO0VBQ0Usb0NBQUE7QUFESjs7QUFLQTtFQUNFLG9EQUFBO0VBQ0EsMkNBQUE7RUFDQSw2Q0FBQTtFQUNBLDJDQUFBO0FBRkY7O0FBS0E7RUFDRSw2Q0FBQTtBQUZGO0FBSUU7RUFDRSwyQ0FBQTtBQUZKO0FBSUk7RUFDRSxZQUFBO0VBQ0EsYUFBQTtFQUNBLG1CQUFBO0FBRk47QUFNRTtFQUNFLG9EQUFBO0VBQ0EsZ0VBQUE7RUFDQSxtRUFBQTtFQUNBLG9FQUFBO0FBSko7QUFPRTtFQUNFLDBDQUFBO0VBQ0EsNERBQUE7RUFDQSwwRUFBQTtFQUNBLGdFQUFBO0FBTEo7QUFRRTtFQUNFLFdBQUE7RUFDQSxZQUFBO0VBQ0Esd0RBQUE7RUFDQSxzRUFBQTtFQUNBLDREQUFBO0VBRUEsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsUUFBQTtFQUVBLG1CQUFBO0FBUko7QUFVSTtFQUNFLFlBQUE7RUFDQSwrREFBQTtFQUNBLGtCQUFBO0VBRUEsNkNBQUE7RUFDQSxzRUFBQTtFQUVBLHVDQUFBO0FBVk47QUFhSTtFQUNFLCtCQUFBO0VBQ0Esc0VBQUE7QUFYTjtBQWVFO0VBQ0UsYUFBQTtFQUNBLGdDQUFBO0VBQ0Esa0RBQUE7RUFDQSxrQkFBQTtFQUNBLDBFQUFBO0VBQ0EsNERBQUE7RUFDQSxnRUFBQTtFQUNBLHVDQUFBO0VBQ0EsZ0NBQUE7QUFiSjtBQWVJO0VBQ0UsZUFBQTtBQWJOO0FBaUJFO0VBQ0UsMENBQUE7QUFmSjtBQWtCRTtFQUNFLHdDQUFBO0VBQ0EsMENBQUE7RUFDQSxhQUFBO0VBQ0EsK0JBQUE7QUFoQko7QUFtQkU7RUFDRSwyREFBQTtFQUNBLHdEQUFBO0VBQ0EsK0RBQUE7RUFFQSxzQ0FBQTtFQUNBLDBDQUFBO0FBbEJKO0FBcUJFO0VBQ0UsNkNBQUE7RUFDQSwwQ0FBQTtBQW5CSjtBQXFCSTtFQUNFLDREQUFBO0VBQ0EsMEVBQUE7RUFDQSxnRUFBQTtFQUNBLDZCQUFBO0VBQ0EsNkNBQUE7QUFuQk47QUF1QkU7RUFDRSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSxRQUFBO0VBRUEsZUFBQTtFQUNBLGlCQUFBO0VBQ0EsZ0NBQUE7RUFFQSwwQ0FBQTtBQXZCSjtBQXlCSTtFQUNFLFdBQUE7RUFDQSxZQUFBO0FBdkJOO0FBMkJFO0VBQ0UsMENBQUE7RUFDQSw0REFBQTtFQUNBLDBFQUFBO0VBQ0EsZ0VBQUE7QUF6Qko7QUE0QkU7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLHdDQUFBO0VBRUEsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsOEJBQUE7RUFFQSxvRUFBQTtFQUNBLGlGQUFBO0VBQ0Esd0VBQUE7RUFDQSxnQ0FBQTtFQUNBLDZCQUFBO0FBNUJKO0FBK0JFO0VBR0UsWUFBQTtFQUNBLE9BQUE7RUFDQSxhQUFBO0VBQ0EsbUJBQUE7RUFDQSx1QkFBQTtFQUNBLGdDQUFBO0FBL0JKO0FBa0NFO0VBR0UsdUJBQUE7QUFsQ0o7QUFxQ0U7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLHVEQUFBO0FBbkNKO0FBc0NFO0VBRUUsNkNBQUE7RUFDQSwyRUFBQTtFQUNBLG9FQUFBO0VBQ0Esa0JBQUE7RUFDQSxpRkFBQTtFQUNBLHdFQUFBO0FBckNKO0FBd0NFO0VBQ0UsMkNBQUE7QUF0Q0o7QUF5Q0U7RUFDRSxpRUFBQTtFQUNBLG9FQUFBO0VBQ0EscUVBQUE7RUFFQSwyQ0FBQTtBQXhDSjtBQTJDRTtFQUNFLFdBQUE7RUFDQSxnQ0FBQTtFQUNBLDJDQUFBO0FBekNKO0FBNENFO0VBQ0UsZ0JBQUE7QUExQ0o7QUE2Q0U7RUFDRSx3Q0FBQTtBQTNDSjtBQTZDSTtFQUNFLG9DQUFBO0FBM0NOO0FBOENJO0VBQ0UsYUFBQTtFQUNBLFFBQUE7QUE1Q047QUFnREU7RUFDRSxnQkFBQTtBQTlDSjtBQWlERTtFQUNFLGFBQUE7RUFDQSxtQkFBQTtFQUNBLGlDQUFBO0VBRUEsNERBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0VBRUEscUNBQUE7QUFqREo7QUFtREk7RUFDRSxlQUFBO0FBakROO0FBbURNO0VBQ0UsMEJBQUE7QUFqRFI7QUFxREk7RUFDRSxlQUFBO0FBbkROO0FBc0RJO0VBQ0UsbUJBQUE7QUFwRE47QUF3REU7RUFDRSxrQkFBQTtFQUNBLDREQUFBO0VBQ0EsdUVBQUE7RUFDQSxnRUFBQTtFQUVBLHdDQUFBO0FBdkRKO0FBeURJO0VBQ0Usa0JBQUE7RUFDQSxXQUFBO0VBQ0Esa0JBQUE7RUFDQSxZQUFBO0VBQ0EsbUJBQUE7RUFDQSxXQUFBO0VBQ0EsWUFBQTtFQUNBLFNBQUE7QUF2RE47QUEyREU7RUFDRSw2Q0FBQTtFQUNBLGtEQUFBO0VBQ0Esa0RBQUE7RUFDQSxvRkFBQTtFQUNBLHdEQUFBO0VBQ0Esa0JBQUE7RUFDQSxzRUFBQTtFQUNBLDREQUFBO0VBQ0EsdUJBQUE7RUFBQSxrQkFBQTtFQUNBLGFBQUE7RUFDQSw4REFBQTtFQUNBLHVCQUFBO0VBQ0EsU0FBQTtFQUNBLHFCQUFBO0FBekRKO0FBNERFO0VBQ0UsMENBQUE7RUFDQSxvRkFBQTtFQUNBLHdEQUFBO0VBQ0Esa0JBQUE7RUFDQSxtRUFBQTtFQUNBLDREQUFBO0FBMURKO0FBNkRFO0VBQ0UsYUFBQTtFQUNBLG1CQUFBO0VBQ0EsUUFBQTtFQUVBLHdDQUFBO0FBNURKO0FBK0RFO0VBQ0UsMENBQUE7RUFDQSx3REFBQTtFQUNBLG1FQUFBO0VBQ0EsNERBQUE7QUE3REo7QUFnRUU7RUFDRSx3Q0FBQTtBQTlESjtBQWlFRTtFQUNFLHdDQUFBO0FBL0RKO0FBbUVJO0VBQ0Usd0NBQUE7RUFDQSw2Q0FBQTtFQUNBLG9GQUFBO0VBQ0EsNERBQUE7RUFDQSxrQkFBQTtFQUNBLHVFQUFBO0VBQ0EsZ0VBQUE7QUFqRU47QUFvRUk7RUFDRSw2Q0FBQTtFQUNBLG9GQUFBO0VBQ0EsNERBQUE7RUFDQSxrQkFBQTtFQUNBLHVFQUFBO0VBQ0EsZ0VBQUE7QUFsRU47QUFzRUU7RUFDRSxhQUFBO0VBQ0Esc0JBQUE7RUFDQSxpQ0FBQTtBQXBFSjtBQXVFRTtFQUNFLGFBQUE7RUFDQSxxQ0FBQTtFQUNBLHVCQUFBO0VBQ0EsZ0NBQUE7RUFDQSxtQkFBQTtFQUNBLG1EQUFBO0VBQ0EscURBQUE7QUFyRUo7QUF1RUk7RUFDRSxhQUFBO0VBQ0EsV0FBQTtFQUNBLFlBQUE7RUFDQSxjQUFBO0VBQ0Esc0JBQUE7RUFDQSx1QkFBQTtFQUNBLG1CQUFBO0VBQ0EsU0FBQTtBQXJFTjtBQXdFSTtFQUNFLGFBQUE7RUFDQSxzQkFBQTtFQUNBLHVCQUFBO0VBQ0EsK0JBQUE7RUFDQSxXQUFBO0FBdEVOO0FBeUVJO0VBQ0UsNkNBQUE7RUFDQSxvRkFBQTtFQUNBLDREQUFBO0VBQ0Esa0JBQUE7RUFDQSwwRUFBQTtFQUNBLGdFQUFBO0VBQ0EsU0FBQTtBQXZFTjtBQTBFSTtFQUNFLDZDQUFBO0VBQ0Esb0ZBQUE7RUFDQSwyREFBQTtFQUNBLGtCQUFBO0VBQ0Esc0VBQUE7RUFDQSwrREFBQTtFQUNBLFNBQUE7QUF4RU47QUEyRUk7RUFDRSxtRUFBQTtBQXpFTjs7QUE4RUE7RUFDRSxrREFBQTtFQUNBLHFDQUFBO0VBQ0EsOERBQUE7QUEzRUY7QUE2RUU7RUFDRSxhQUFBO0VBQ0EsMkJBQUE7RUFDQSx1QkFBQTtFQUNBLDRDQUFBO0VBQ0EsMkNBQUE7QUEzRUo7O0FBK0VBO0VBQ0UsMkNBQUE7QUE1RUYiLCJzb3VyY2VzQ29udGVudCI6WyJpb24tZm9vdGVyIHtcbiAgaW9uLWJ1dHRvbiB7XG4gICAgLS1iYWNrZ3JvdW5kOiB2YXIoLS1tYWctYnJhbmQtZm91bmRhdGlvbi1wcmltYXJ5LCAjMDA4MDAwKTtcbiAgICAtLWJhY2tncm91bmQtYWN0aXZhdGVkOiBub25lO1xuICB9XG5cbiAgaW9uLWJ1dHRvbjo6cGFydChuYXRpdmUpIHtcbiAgICBoZWlnaHQ6IHZhcigtLW1hZy1zcGFjaW5nLTYwMCwgNDhweCk7XG4gIH1cbn1cblxuaW9uLWNvbnRlbnQge1xuICAtLWJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICAtLXBhZGRpbmctdG9wOiB2YXIoLS1tYWctc3BhY2luZy00MDAsIDMycHgpO1xuICAtLXBhZGRpbmctc3RhcnQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIC0tcGFkZGluZy1lbmQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG5cbi5wcm9kdWN0LWRldGFpbCB7XG4gIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcblxuICAmX19pbWcge1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG5cbiAgICBpbWcge1xuICAgICAgd2lkdGg6IDM0M3B4O1xuICAgICAgaGVpZ2h0OiAzNDNweDtcbiAgICAgIG9iamVjdC1maXQ6IGNvbnRhaW47XG4gICAgfVxuICB9XG5cbiAgJl9fdGl0bGUge1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgTGF0byk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtZm9udC1zaXplLCAyNHB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLWxhcmdlLWZvbnQtd2VpZ2h0LCA2MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbGFyZ2UtbGluZS1oZWlnaHQsIDMycHgpO1xuICB9XG5cbiAgJl9fc2l6aW5nIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtaW5mbywgIzY0NzI4MSk7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXNpemUsIDE2cHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gIH1cblxuICAmX19idXktYWdhaW4ge1xuICAgIHdpZHRoOiAxMDAlO1xuICAgIGhlaWdodDogMzJweDtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXN1YnRleHQtZm9udC1zaXplLCAxMnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWxpbmUtaGVpZ2h0LCAxNnB4KTtcblxuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBnYXA6IDJweDtcblxuICAgIG1hcmdpbi1ib3R0b206IDMycHg7XG5cbiAgICAmLXRhZyB7XG4gICAgICBoZWlnaHQ6IDI0cHg7XG4gICAgICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy01MCwgNHB4KSB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgICBib3JkZXItcmFkaXVzOiA4cHg7XG5cbiAgICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWZvbnQtd2VpZ2h0LWVtcGhhc2l6ZWQsIDQwMCk7XG5cbiAgICAgIGJhY2tncm91bmQ6IHZhcigtLW1hZy1tYWctc3VyZmFjZS1pbmZvKTtcbiAgICB9XG5cbiAgICAmLWxhc3QtcHVyY2hhc2VkIHtcbiAgICAgIGNvbG9yOiB2YXIoLS1tYWctbWFnLXRleHQtaW5mbyk7XG4gICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIH1cbiAgfVxuXG4gICZfX2xveWFsdHktaW5kaWNhdG9yIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGdhcDogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmljaW5nLWRlYWwsICNkYTA4MDgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtZW1waGFzaXplZCwgNDAwKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICBtYXJnaW4tdG9wOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG5cbiAgICBpb24taWNvbiB7XG4gICAgICBmb250LXNpemU6IDI0cHg7XG4gICAgfVxuICB9XG5cbiAgJl9fc2FsZS10YWcge1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTEwMCwgOHB4KTtcbiAgfVxuXG4gICZfX2RlYWwtcmliYm9ucyB7XG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KTtcbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLTUwLCA0cHgpO1xuICB9XG5cbiAgJl9fcHJpY2Uge1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktZGVhbC1sYXJnZS1mb250LXNpemUsIDI4cHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kZWFsLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kZWFsLWxhcmdlLWxpbmUtaGVpZ2h0LCAzNnB4KTtcblxuICAgIG1hcmdpbi10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTUwLCA0cHgpO1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTEwMCwgOHB4KTtcbiAgfVxuXG4gICZfX3NhbGUtcHJpY2Uge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3Itc3VyZmFjZS1kZWFsLCAjZGEwODA4KTtcbiAgICBtYXJnaW4tcmlnaHQ6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG5cbiAgICAmLS1kZWNvcmF0aW9uIHtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICAgIHRleHQtZGVjb3JhdGlvbjogbGluZS10aHJvdWdoO1xuICAgICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIH1cbiAgfVxuXG4gICZfX2xveWFsdHktcHJvZ3JhbSB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGdhcDogOHB4O1xuXG4gICAgZm9udC1zaXplOiAxNnB4O1xuICAgIGxpbmUtaGVpZ2h0OiAyNHB4O1xuICAgIGNvbG9yOiB2YXIoLS1tYWctbWFnLXRleHQtYWxlcnQpO1xuXG4gICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuXG4gICAgaW9uLWltZyB7XG4gICAgICB3aWR0aDogMjRweDtcbiAgICAgIGhlaWdodDogMjRweDtcbiAgICB9XG4gIH1cblxuICAmX19xdWFudGl0eS1ydWxlcyB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWluZm8sICM2NDcyODEpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtZW1waGFzaXplZCwgNDAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuICB9XG5cbiAgJl9fYWN0aW9ucyB7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgaGVpZ2h0OiA2OHB4O1xuICAgIG1hcmdpbi10b3A6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG5cbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAganVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO1xuXG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWZvbnQtc2l6ZSwgMTRweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbC1zbWFsbC1lbXBoYXNpemVkLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbiAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgI2VlZWVlZTtcbiAgICBib3JkZXItdG9wOiAxcHggc29saWQgI2VlZWVlZTtcbiAgfVxuXG4gICZfX2FkZC10by1saXN0LFxuICAmX19hZGRlZC10by1saXN0LFxuICAmX19zaGFyZSB7XG4gICAgaGVpZ2h0OiAxMDAlO1xuICAgIGZsZXg6IDE7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgIGdhcDogdmFyKC0tbWFnLXNwYWNpbmctMTAwLCA4cHgpO1xuICB9XG5cbiAgJl9fYWRkZWQtdG8tbGlzdCxcbiAgJl9fYWRkLXRvLWxpc3Qge1xuICAgIC8vIGJvcmRlci1yaWdodDogMXB4IHNvbGlkICNlZWVlZWU7XG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XG4gIH1cblxuICAmX19hZGRlZC10by1saXN0LWltYWdlIHtcbiAgICB3aWR0aDogMTZweDtcbiAgICBoZWlnaHQ6IDE2cHg7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJ1dHRvbi10ZXh0LWJyYW5kLCAjMDA4MDAwKTtcbiAgfVxuXG4gICZfX2FkZC10by1saXN0LXRleHQsXG4gICZfX2FkZGVkLXRvLWxpc3QtdGV4dCB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1mb250LWZhbWlseSwgJ0xleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYnKTtcbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbHMtc21hbGwtZm9udC1zaXplLCAxNHB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJ1dHRvbi1sYWJlbC1zbWFsbC1lbXBoYXNpemVkLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1idXR0b24tbGFiZWxzLXNtYWxsLWxpbmUtaGVpZ2h0LCAyMHB4KTtcbiAgfVxuXG4gICZfX2FkZGVkLXRvLWxpc3QtdGV4dCB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWJyYW5kLCAjMDA4MDAwKTtcbiAgfVxuXG4gICZfX3Nlc3Npb24tdGl0bGUge1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktaGVhZGxpbmVzLW1lZGl1bS1mb250LXNpemUsIDIwcHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWZvbnQtd2VpZ2h0LCA1MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1oZWFkbGluZXMtbWVkaXVtLWxpbmUtaGVpZ2h0LCAyOHB4KTtcblxuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIH1cblxuICAmX19zZXNzaW9uLWxpbmUge1xuICAgIHdpZHRoOiAxMDAlO1xuICAgIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCAjZWVlZWVlO1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG4gIH1cblxuICAmX19zZXNzaW9uLWltYWdlIHtcbiAgICBtYXgtd2lkdGg6IDM0M3B4O1xuICB9XG5cbiAgJl9fdGFncyB7XG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMTUwLCAxMnB4KTtcblxuICAgICYtLWF0dHJpYnV0ZSB7XG4gICAgICBtYXJnaW4tdG9wOiB2YXIoLS1zcGFjaW5nLTQwMCwgMzJweCk7XG4gICAgfVxuXG4gICAgJi0taXRlbSB7XG4gICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgZ2FwOiA0cHg7XG4gICAgfVxuICB9XG5cbiAgJl9fZGVzY3JpcHRpb24tY29udGVudCB7XG4gICAgbWF4LXdpZHRoOiA0ODBweDtcbiAgfVxuXG4gIC5kZXNjcmlwdGlvbi1jb250ZW50LWl0ZW0ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG5cbiAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcblxuICAgIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG5cbiAgICAmX192YWx1ZSB7XG4gICAgICBmbGV4LWJhc2lzOiA1MCU7XG5cbiAgICAgICYtLXVuZGVybGluZSB7XG4gICAgICAgIHRleHQtZGVjb3JhdGlvbjogdW5kZXJsaW5lO1xuICAgICAgfVxuICAgIH1cblxuICAgICZfX25hbWUge1xuICAgICAgZmxleC1iYXNpczogNTAlO1xuICAgIH1cblxuICAgICYtLWJnLWRpZmYge1xuICAgICAgYmFja2dyb3VuZDogI2Y3ZjhmOTtcbiAgICB9XG4gIH1cblxuICAmX19kZXMtY29udGVudCB7XG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICBsaW5lLWhlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tbGluZS1oZWlnaHQsIDI0cHgpO1xuXG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KTtcblxuICAgICYtLWJsdXI6YWZ0ZXIge1xuICAgICAgcG9zaXRpb246IGFic29sdXRlO1xuICAgICAgY29udGVudDogJyc7XG4gICAgICBmaWx0ZXI6IGJsdXIoMTBweCk7XG4gICAgICBoZWlnaHQ6IDI0cHg7XG4gICAgICBiYWNrZ3JvdW5kOiAjZmZmZmZmO1xuICAgICAgbGVmdDogLTEwcHg7XG4gICAgICByaWdodDogLTEwcHg7XG4gICAgICBib3R0b206IDA7XG4gICAgfVxuICB9XG5cbiAgJl9fYXR0cmlidXRlIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgYm9yZGVyLXJhZGl1czogdmFyKC0tbWFnLWJvcmRlci1yYWRpdXMtc21hbGwsIDRweCk7XG4gICAgYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2UtaW5mbywgI2U1ZjVmOSk7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kLCBBcmlhbCwgc2Fucy1zZXJpZicpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktY2FwdGlvbi1mb250LXNpemUsIDExcHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktY2FwdGlvbi1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1jYXB0aW9uLWxpbmUtaGVpZ2h0LCAxNHB4KTtcbiAgICB3aWR0aDogZml0LWNvbnRlbnQ7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy0yNSwgMnB4KSB2YXIoLS1tYWctc3BhY2luZy01MCwgNHB4KTtcbiAgICBhbGlnbi1pdGVtczogZmxleC1zdGFydDtcbiAgICBnYXA6IDEwcHg7XG4gICAgbWFyZ2luOiA1cHggNXB4IDVweCAwO1xuICB9XG5cbiAgJl9fZGVjbGFpbWVyIHtcbiAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtaW5mbywgIzY0NzI4MSk7XG4gICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kLCBBcmlhbCwgc2Fucy1zZXJpZicpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXNpemUsIDEycHgpO1xuICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWxpbmUtaGVpZ2h0LCAxNnB4KTtcbiAgfVxuXG4gICZfX3RhZyB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGdhcDogNHB4O1xuXG4gICAgbWFyZ2luOiB2YXIoLS1tYWctc3BhY2luZy0zMDAsIDI0cHgpIDBweDtcbiAgfVxuXG4gICZfX3NhbGUtaW5mbyB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LWluZm8sICM2NDcyODEpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktc3VidGV4dC1mb250LXNpemUsIDEycHgpO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1zdWJ0ZXh0LWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXN1YnRleHQtbGluZS1oZWlnaHQsIDE2cHgpO1xuICB9XG5cbiAgJl9fcmVsYXRlZCB7XG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctNjAwLCA0OHB4KTtcbiAgfVxuXG4gICZfX251dHJpdGlvbiB7XG4gICAgbWFyZ2luLXRvcDogdmFyKC0tbWFnLXNwYWNpbmctNjAwLCA0OHB4KTtcbiAgfVxuXG4gICZfX2luZ3JlZGllbnRzIHtcbiAgICAmLXRpdGxlIHtcbiAgICAgIG1hcmdpbjogdmFyKC0tbWFnLXNwYWNpbmctMzAwLCAyNHB4KSAwcHg7XG4gICAgICBjb2xvcjogdmFyKC0tbWFnLWNvbG9yLXRleHQtcHJpbWFyeSwgIzEyMTIxMik7XG4gICAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksICdMZXhlbmQsIEFyaWFsLCBzYW5zLXNlcmlmJyk7XG4gICAgICBmb250LXNpemU6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtc2l6ZSwgMTZweCk7XG4gICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC13ZWlnaHQtcmVndWxhciwgMzAwKTtcbiAgICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1saW5lLWhlaWdodCwgMjRweCk7XG4gICAgfVxuXG4gICAgJi1jb250ZW50IHtcbiAgICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgJ0xleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYnKTtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICB9XG4gIH1cblxuICAmX19jb3Vwb24ge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBnYXA6IHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG4gIH1cblxuICAmX193YXJuaW5nIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIHBhZGRpbmc6IHZhcigtLW1hZy1zcGFjaW5nLTE1MCwgMTJweCk7XG4gICAgYWxpZ24taXRlbXM6IGZsZXgtc3RhcnQ7XG4gICAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0xMDAsIDhweCk7XG4gICAgYWxpZ24tc2VsZjogc3RyZXRjaDtcbiAgICBib3JkZXItcmFkaXVzOiB2YXIoLS1tYWctYm9yZGVyLXJhZGl1cy1tZWRpdW0sIDhweCk7XG4gICAgYmFja2dyb3VuZDogdmFyKC0tbWFnLWNvbG9yLXN1cmZhY2Utd2FybmluZywgI2ZmZjdlNSk7XG5cbiAgICAmLWljb24ge1xuICAgICAgZGlzcGxheTogZmxleDtcbiAgICAgIHdpZHRoOiAyNHB4O1xuICAgICAgaGVpZ2h0OiAyNHB4O1xuICAgICAgcGFkZGluZzogMi41cHg7XG4gICAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICAgICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgICAgZ2FwOiAxMHB4O1xuICAgIH1cblxuICAgICYtdGV4dCB7XG4gICAgICBkaXNwbGF5OiBmbGV4O1xuICAgICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICAgIGFsaWduLWl0ZW1zOiBmbGV4LXN0YXJ0O1xuICAgICAgZ2FwOiB2YXIoLS1tYWctc3BhY2luZy0yNSwgMnB4KTtcbiAgICAgIGZsZXg6IDEgMCAwO1xuICAgIH1cblxuICAgICYtaGVhZGVyIHtcbiAgICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgJ0xleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYnKTtcbiAgICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICAgIGZvbnQtc3R5bGU6IG5vcm1hbDtcbiAgICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LW1lZGl1bS1mb250LXdlaWdodC1lbXBoYXNpemVkLCA0MDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgICAgIG1hcmdpbjogMDtcbiAgICB9XG5cbiAgICAmLWRlc2Mge1xuICAgICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgICAgZm9udC1mYW1pbHk6IHZhcigtLW1hZy10eXBvZ3JhcGh5LXBsYXRmb3JtLWZvbnQtZmFtaWx5LCAnTGV4ZW5kLCBBcmlhbCwgc2Fucy1zZXJpZicpO1xuICAgICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1ib2R5LXNtYWxsLWZvbnQtc2l6ZSwgMTRweCk7XG4gICAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgICBmb250LXdlaWdodDogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1zbWFsbC1mb250LXdlaWdodC1yZWd1bGFyLCAzMDApO1xuICAgICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktc21hbGwtbGluZS1oZWlnaHQsIDIwcHgpO1xuICAgICAgbWFyZ2luOiAwO1xuICAgIH1cblxuICAgICZfX3Byb21vIHtcbiAgICAgIG1hcmdpbjogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KSAwIHZhcigtLW1hZy1zcGFjaW5nLTYwMCwgNDhweCk7XG4gICAgfVxuICB9XG59XG5cbi5jdXN0b20tdG9vbGJhciB7XG4gIGJhY2tncm91bmQ6IHZhcigtLW1hZy1jb2xvci1zdXJmYWNlLXByaW1hcnksICNmZmYpO1xuICBwYWRkaW5nOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICBib3JkZXItdG9wOiAxcHggc29saWQgdmFyKC0tbWFnLWNvbG9yLWJvcmRlci1kaXZpZGVyLCAjZWVlZWVlKTtcblxuICAmX191bmF2YWlsYWJsZSB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGZsZXgtc3RhcnQ7XG4gICAgYWxpZ24taXRlbXM6IGZsZXgtc3RhcnQ7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXNlY29uZGFyeSwgIzU1NSk7XG4gICAgbWFyZ2luLWJvdHRvbTogdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcbiAgfVxufVxuXG4ubWItNCB7XG4gIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTQwMCwgMzJweCk7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 82076:
/*!********************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/pages/product-endcap/product-endcap.ts ***!
  \********************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductEndcapPageComponent: () => (/* binding */ ProductEndcapPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/utils/providers/utils */ 32618);
/* harmony import */ var _rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/auth-v2/providers/credential.service */ 89767);
/* harmony import */ var _rsApp_modules_store_providers_current_store_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @rsApp/modules/store/providers/current-store.service */ 68775);
/* harmony import */ var _rsApp_modules_utils_providers_widget_layout_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @rsApp/modules/utils/providers/widget-layout.service */ 81759);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @pscoped/ngx-pub-sub */ 2055);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);

















class ProductEndcapPageComponent {
  router;
  utils;
  cre;
  modalCtrl;
  route;
  cStore;
  navCtrl;
  events;
  layoutSvc;
  loaded = true;
  endcapCode;
  objectId = null;
  constructor(router, utils, cre, modalCtrl, route, cStore, navCtrl, events, layoutSvc) {
    this.router = router;
    this.utils = utils;
    this.cre = cre;
    this.modalCtrl = modalCtrl;
    this.route = route;
    this.cStore = cStore;
    this.navCtrl = navCtrl;
    this.events = events;
    this.layoutSvc = layoutSvc;
    const params = this.route.snapshot.paramMap;
    this.endcapCode = params.get('endcapCode');
    this.objectId = `endcap/${this.endcapCode}`;
  }
  backToHomeDefault() {
    this.navCtrl.navigateRoot(['/tabs/home']);
  }
  ionViewWillEnter() {
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {})();
  } // this.loadPageSEO();
  // this.loaded = false;
  ionViewDidEnter() {
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {})();
  } // this.loaded = true;
  // loadPageSEO() {
  //   this.layoutSvc.getSEOGetByObjectIdClient(this.objectId, "encap").subscribe((rs: IPageMetadata) => {
  //     this.myTitle = rs ? rs.Title : 'Endcap';
  //   });
  // }
  getPageName() {
    return 'EndcapPage';
  }
  static ɵfac = function ProductEndcapPageComponent_Factory(t) {
    return new (t || ProductEndcapPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_utils__WEBPACK_IMPORTED_MODULE_1__.Utils), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_auth_v2_providers_credential_service__WEBPACK_IMPORTED_MODULE_2__.Credential), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_8__.ModalController), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_store_providers_current_store_service__WEBPACK_IMPORTED_MODULE_3__.CurrentStore), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_9__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_pscoped_ngx_pub_sub__WEBPACK_IMPORTED_MODULE_10__.NgxPubSubService), _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_widget_layout_service__WEBPACK_IMPORTED_MODULE_4__.WidgetLayoutService));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵdefineComponent"]({
    type: ProductEndcapPageComponent,
    selectors: [["page-product-endcap"]],
    decls: 10,
    vars: 10,
    consts: [["type", "endcap", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "endcap", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "endcap", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "ion-no-line"], ["slot", "start"], ["defaultHref", "/tabs/home", "text", "", "icon", "md-arrow-back", "color", "dark"], ["type", "endcap", "zoneName", "Top", 3, "objectId", "slug"], ["type", "endcap", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function ProductEndcapPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](0, "widget-layout", 0)(1, "widget-layout", 1)(2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](3, "ion-header")(4, "ion-toolbar", 3)(5, "ion-buttons", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](6, "ion-back-button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]()()();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementStart"](7, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelement"](8, "widget-layout", 6)(9, "widget-layout", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("objectId", ctx.objectId)("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("objectId", ctx.objectId)("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("objectId", ctx.objectId)("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("objectId", ctx.objectId)("slug", ctx.router.url);
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_6__["ɵɵproperty"]("objectId", ctx.objectId)("slug", ctx.router.url);
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonButtons, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonContent, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonHeader, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonToolbar, _ionic_angular__WEBPACK_IMPORTED_MODULE_8__.IonBackButton, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_5__.WidgetLayoutComponent],
    styles: ["ion-content[_ngcontent-%COMP%] {\n  --padding-start: var(--mag-spacing-200, 16px);\n  --padding-end: var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvcGFnZXMvcHJvZHVjdC1lbmRjYXAvcHJvZHVjdC1lbmRjYXAuc2NzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLDZDQUFBO0VBQ0EsMkNBQUE7QUFDRiIsInNvdXJjZXNDb250ZW50IjpbImlvbi1jb250ZW50IHtcbiAgLS1wYWRkaW5nLXN0YXJ0OiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICAtLXBhZGRpbmctZW5kOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 29488:
/*!******************************************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/pages/product-search-list/product-search-list.ts ***!
  \******************************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductSearchListPageComponent: () => (/* binding */ ProductSearchListPageComponent)
/* harmony export */ });
/* harmony import */ var _Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js */ 89204);
/* harmony import */ var _rsApp_modules_browse_provider_category_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @rsApp/modules/browse/provider/category.service */ 39548);
/* harmony import */ var _rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @rsApp/modules/utils/providers/dxp.component.service */ 72431);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! rxjs */ 10819);
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! rxjs */ 33900);
/* harmony import */ var _providers_product_search_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../providers/product-search.service */ 84898);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ionic/angular */ 78205);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../../utils/components/widget-layout/widget-layout.component */ 32605);
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../../header/header.component */ 55074);
/* harmony import */ var _header_components_search_search_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../../header/components/search/search.component */ 64269);



















function ProductSearchListPageComponent_widget_layout_0_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "widget-layout", 8);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("objectId", "search-product/" + ctx_r0.keyword)("slug", ctx_r0.slug);
  }
}
function ProductSearchListPageComponent_widget_layout_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "widget-layout", 9);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("objectId", "search-product/" + ctx_r0.keyword)("slug", ctx_r0.slug);
  }
}
function ProductSearchListPageComponent_widget_layout_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "widget-layout", 10);
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("objectId", "search-product/" + ctx_r0.keyword)("slug", ctx_r0.slug);
  }
}
function ProductSearchListPageComponent_div_7_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](1, "widget-layout", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("objectId", "search-product/" + ctx_r0.keyword)("slug", ctx_r0.slug);
  }
}
function ProductSearchListPageComponent_div_8_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](1, "mag-search-container", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("keyword", ctx_r0.keywordClone)("queryParams", ctx_r0.queryParams);
  }
}
function ProductSearchListPageComponent_div_9_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](1, "widget-layout", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
  }
  if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("objectId", "search-product/" + ctx_r0.keyword)("slug", ctx_r0.slug);
  }
}
class ProductSearchListPageComponent {
  route;
  dxpComponentService;
  categoryService;
  router;
  cdr;
  productSearchService;
  navCtrl;
  location;
  slug;
  loaded;
  magProductSearchList = '';
  keyword;
  keywordClone;
  queryParams;
  _destroy$ = new rxjs__WEBPACK_IMPORTED_MODULE_8__.Subject();
  constructor(route, dxpComponentService, categoryService, router, cdr, productSearchService, navCtrl, location) {
    this.route = route;
    this.dxpComponentService = dxpComponentService;
    this.categoryService = categoryService;
    this.router = router;
    this.cdr = cdr;
    this.productSearchService = productSearchService;
    this.navCtrl = navCtrl;
    this.location = location;
    this.getRouteParams();
  }
  ngOnInit() {
    var _this = this;
    return (0,_Users_rs_m1_Projects_DXP_NextMobile_node_modules_babel_runtime_helpers_esm_asyncToGenerator_js__WEBPACK_IMPORTED_MODULE_0__["default"])(function* () {
      _this.slug = _this.router.url;
      yield _this.dxpComponentService.onConnected();
      _this.productSearchService.getCriterias().pipe((0,rxjs__WEBPACK_IMPORTED_MODULE_9__.takeUntil)(_this._destroy$)).subscribe(criterias => {
        if (!criterias) {
          return;
        }
        _this.updateQueryParams(criterias);
      });
    })();
  }
  ngOnDestroy() {
    this._destroy$.next(true);
    this._destroy$.complete();
    this.productSearchService.clearKeyWord();
  }
  getRouteParams() {
    const hasValue = v => v != null && v !== '';
    const queryParams = Object.fromEntries(Object.entries(this.route.snapshot.queryParams).filter(([, v]) => hasValue(v)));
    if (Object.keys(queryParams).length) {
      this.productSearchService.setCriterias(queryParams);
    }
  }
  changeKeyword(keyword) {
    const kw = keyword;
    if (this.keywordClone != kw) {
      this.loaded = false;
      this.cdr.detectChanges();
      this.keywordClone = kw;
      this.keyword = kw.replace(/\s+/g, '-'); // Remove spacing kw to get widget-layout
      this.loaded = true;
    }
  }
  updateQueryParams(params) {
    const cats = this.parseParam(params?.cats);
    const brands = this.parseParam(params?.brands);
    const queryParams = {
      Categories: cats.length ? cats : null,
      Brands: brands.length ? brands : null
    };
    this.queryParams = JSON.stringify(queryParams);
    this.slug = this.router.url;
    this.changeKeyword(params?.keyword || '');
  }
  parseParam(param) {
    return param ? Array.isArray(param) ? param : typeof param === 'string' ? param.split(';') : [param] : [];
  }
  static ɵfac = function ProductSearchListPageComponent_Factory(t) {
    return new (t || ProductSearchListPageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_10__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_utils_providers_dxp_component_service__WEBPACK_IMPORTED_MODULE_2__.DxpComponentService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_rsApp_modules_browse_provider_category_service__WEBPACK_IMPORTED_MODULE_1__.CategoryService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_10__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_7__.ChangeDetectorRef), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_providers_product_search_service__WEBPACK_IMPORTED_MODULE_3__.ProductSearchService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_ionic_angular__WEBPACK_IMPORTED_MODULE_11__.NavController), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_common__WEBPACK_IMPORTED_MODULE_12__.Location));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineComponent"]({
    type: ProductSearchListPageComponent,
    selectors: [["app-products-search-list"]],
    decls: 10,
    vars: 9,
    consts: [["type", "search-product", "zoneName", "Sticky", 3, "objectId", "slug", 4, "ngIf"], ["type", "search-product", "zoneName", "Fixed Top", 3, "objectId", "slug", 4, "ngIf"], ["type", "search-product", "zoneName", "Fixed Center", 3, "objectId", "slug", 4, "ngIf"], [3, "isSimpleHeader"], [1, "header-simple__container"], [3, "isLocalSearch", "isShowBackButton"], ["class", "widget-layout", 4, "ngIf"], ["class", "mag-product-search-list", 4, "ngIf"], ["type", "search-product", "zoneName", "Sticky", 3, "objectId", "slug"], ["type", "search-product", "zoneName", "Fixed Top", 3, "objectId", "slug"], ["type", "search-product", "zoneName", "Fixed Center", 3, "objectId", "slug"], [1, "widget-layout"], ["type", "search-product", "zoneName", "Top", 3, "objectId", "slug"], [1, "mag-product-search-list"], [1, "hydrated", 3, "keyword", "queryParams"], ["type", "search-product", "zoneName", "Bottom", 3, "objectId", "slug"]],
    template: function ProductSearchListPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](0, ProductSearchListPageComponent_widget_layout_0_Template, 1, 2, "widget-layout", 0)(1, ProductSearchListPageComponent_widget_layout_1_Template, 1, 2, "widget-layout", 1)(2, ProductSearchListPageComponent_widget_layout_2_Template, 1, 2, "widget-layout", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](3, "app-header", 3)(4, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](5, "app-search", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]()();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](6, "ion-content");
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](7, ProductSearchListPageComponent_div_7_Template, 2, 2, "div", 6)(8, ProductSearchListPageComponent_div_8_Template, 2, 2, "div", 7)(9, ProductSearchListPageComponent_div_9_Template, 2, 2, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("isSimpleHeader", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("isLocalSearch", false)("isShowBackButton", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.loaded);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.loaded);
      }
    },
    dependencies: [_angular_common__WEBPACK_IMPORTED_MODULE_12__.NgIf, _ionic_angular__WEBPACK_IMPORTED_MODULE_13__.IonContent, _utils_components_widget_layout_widget_layout_component__WEBPACK_IMPORTED_MODULE_4__.WidgetLayoutComponent, _header_header_component__WEBPACK_IMPORTED_MODULE_5__.HeaderComponent, _header_components_search_search_component__WEBPACK_IMPORTED_MODULE_6__.SearchComponent],
    styles: [".widget-layout[_ngcontent-%COMP%] {\n  padding: 0 var(--mag-spacing-200, 16px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9lY29tLXYyL3Byb2R1Y3QvcGFnZXMvcHJvZHVjdC1zZWFyY2gtbGlzdC9wcm9kdWN0LXNlYXJjaC1saXN0LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBR0E7RUFDRSx1Q0FBQTtBQUZGIiwic291cmNlc0NvbnRlbnQiOlsiLm1hZy1wcm9kdWN0LXNlYXJjaC1saXN0IHtcbn1cblxuLndpZGdldC1sYXlvdXQge1xuICBwYWRkaW5nOiAwIHZhcigtLW1hZy1zcGFjaW5nLTIwMCwgMTZweCk7XG59XG4iXSwic291cmNlUm9vdCI6IiJ9 */"]
  });
}

/***/ }),

/***/ 2112:
/*!*******************************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/product-routing.module.ts ***!
  \*******************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   ProductRoutingModule: () => (/* binding */ ProductRoutingModule),
/* harmony export */   "default": () => (__WEBPACK_DEFAULT_EXPORT__)
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _product_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./product.module */ 55441);
/* harmony import */ var _pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./pages/product-detail/product-detail */ 84100);
/* harmony import */ var _pages_product_search_list_product_search_list__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/product-search-list/product-search-list */ 29488);
/* harmony import */ var _pages_product_endcap_product_endcap__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./pages/product-endcap/product-endcap */ 82076);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 37580);







const routes = [{
  path: '',
  component: _pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_1__.ProductDetailPageComponent,
  data: {
    hideTab: true
  }
}, {
  path: 'product-detail/:slug',
  component: _pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_1__.ProductDetailPageComponent,
  data: {
    hideTab: true
  }
}, {
  path: 'product-search-list',
  component: _pages_product_search_list_product_search_list__WEBPACK_IMPORTED_MODULE_2__.ProductSearchListPageComponent,
  data: {
    hideTab: true
  }
}, {
  path: 'endcap/:endcapCode',
  component: _pages_product_endcap_product_endcap__WEBPACK_IMPORTED_MODULE_3__.ProductEndcapPageComponent,
  data: {
    hideTab: true
  }
}];
/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (routes);
class ProductRoutingModule {
  static ɵfac = function ProductRoutingModule_Factory(t) {
    return new (t || ProductRoutingModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineNgModule"]({
    type: ProductRoutingModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule.forChild(routes), _product_module__WEBPACK_IMPORTED_MODULE_0__.ProductModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵsetNgModuleScope"](ProductRoutingModule, {
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterModule, _product_module__WEBPACK_IMPORTED_MODULE_0__.ProductModule]
  });
})();

/***/ }),

/***/ 55441:
/*!***********************************************************!*\
  !*** ./src/app/modules/ecom-v2/product/product.module.ts ***!
  \***********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   GiftCardOptionsModalComponent: () => (/* reexport safe */ _components_gift_card_options_modal_gift_card_options_modal__WEBPACK_IMPORTED_MODULE_8__.GiftCardOptionsModalComponent),
/* harmony export */   ParityProductFlavorComponent: () => (/* reexport safe */ _components_parity_product_parity_product_flavor_parity_product_flavor__WEBPACK_IMPORTED_MODULE_7__.ParityProductFlavorComponent),
/* harmony export */   ParityProductSizeComponent: () => (/* reexport safe */ _components_parity_product_parity_product_size_parity_product_size__WEBPACK_IMPORTED_MODULE_9__.ParityProductSizeComponent),
/* harmony export */   PriceMultipleCardsComponent: () => (/* reexport safe */ _components_price_multiple_cards_price_multiple_cards__WEBPACK_IMPORTED_MODULE_3__.PriceMultipleCardsComponent),
/* harmony export */   ProductAddedComponent: () => (/* reexport safe */ _components_product_added_product_added__WEBPACK_IMPORTED_MODULE_6__.ProductAddedComponent),
/* harmony export */   ProductContentCollapseComponent: () => (/* reexport safe */ _components_product_content_collapse_product_content_collapse__WEBPACK_IMPORTED_MODULE_16__.ProductContentCollapseComponent),
/* harmony export */   ProductDetailPageComponent: () => (/* reexport safe */ _pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_2__.ProductDetailPageComponent),
/* harmony export */   ProductModule: () => (/* binding */ ProductModule),
/* harmony export */   ProductOptionsModalComponent: () => (/* reexport safe */ _components_product_options_modal_product_options_modal__WEBPACK_IMPORTED_MODULE_4__.ProductOptionsModalComponent),
/* harmony export */   ProductOptionsSelectorComponent: () => (/* reexport safe */ _components_product_options_selector_product_options_selector__WEBPACK_IMPORTED_MODULE_5__.ProductOptionsSelectorComponent)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var ngx_moment__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ngx-moment */ 70519);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../utils/utils.module */ 50777);
/* harmony import */ var _product_services_module__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./product-services.module */ 65188);
/* harmony import */ var _pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./pages/product-detail/product-detail */ 84100);
/* harmony import */ var _components_price_multiple_cards_price_multiple_cards__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/price-multiple-cards/price-multiple-cards */ 70556);
/* harmony import */ var _components_product_options_modal_product_options_modal__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/product-options-modal/product-options-modal */ 79658);
/* harmony import */ var _components_product_options_selector_product_options_selector__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/product-options-selector/product-options-selector */ 68771);
/* harmony import */ var _components_product_added_product_added__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/product-added/product-added */ 39494);
/* harmony import */ var _components_parity_product_parity_product_flavor_parity_product_flavor__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./components/parity-product/parity-product-flavor/parity-product-flavor */ 75498);
/* harmony import */ var _components_gift_card_options_modal_gift_card_options_modal__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/gift-card-options-modal/gift-card-options-modal */ 84742);
/* harmony import */ var _components_parity_product_parity_product_size_parity_product_size__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./components/parity-product/parity-product-size/parity-product-size */ 96034);
/* harmony import */ var _pages_product_search_list_product_search_list__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./pages/product-search-list/product-search-list */ 29488);
/* harmony import */ var _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @rsApp/modules/header/header.component.module */ 88770);
/* harmony import */ var _components_custom_photos_custom_photos__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./components/custom-photos/custom-photos */ 73418);
/* harmony import */ var _components_custom_img_custom_img__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./components/custom-img/custom-img */ 46318);
/* harmony import */ var _rsApp_modules_browse_category_service_module__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @rsApp/modules/browse/category-service.module */ 70079);
/* harmony import */ var _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @rsApp/modules/shared/shared.module */ 70541);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _components_product_content_collapse_product_content_collapse__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./components/product-content-collapse/product-content-collapse */ 15534);
/* harmony import */ var _pages_product_endcap_product_endcap__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./pages/product-endcap/product-endcap */ 82076);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/core */ 37580);


























class ProductModule {
  static ɵfac = function ProductModule_Factory(t) {
    return new (t || ProductModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdefineNgModule"]({
    type: ProductModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵdefineInjector"]({
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_19__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_20__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_21__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_22__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_23__.RouterModule, _product_services_module__WEBPACK_IMPORTED_MODULE_1__.ProductServiceModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_11__.HeaderComponentModule, _rsApp_modules_browse_category_service_module__WEBPACK_IMPORTED_MODULE_14__.CategoryServiceModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_15__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_24__.TranslateModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_18__["ɵɵsetNgModuleScope"](ProductModule, {
    declarations: [_pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_2__.ProductDetailPageComponent, _components_price_multiple_cards_price_multiple_cards__WEBPACK_IMPORTED_MODULE_3__.PriceMultipleCardsComponent, _components_product_options_modal_product_options_modal__WEBPACK_IMPORTED_MODULE_4__.ProductOptionsModalComponent, _components_product_options_selector_product_options_selector__WEBPACK_IMPORTED_MODULE_5__.ProductOptionsSelectorComponent, _components_product_added_product_added__WEBPACK_IMPORTED_MODULE_6__.ProductAddedComponent, _components_parity_product_parity_product_flavor_parity_product_flavor__WEBPACK_IMPORTED_MODULE_7__.ParityProductFlavorComponent, _components_parity_product_parity_product_size_parity_product_size__WEBPACK_IMPORTED_MODULE_9__.ParityProductSizeComponent, _components_gift_card_options_modal_gift_card_options_modal__WEBPACK_IMPORTED_MODULE_8__.GiftCardOptionsModalComponent, _pages_product_search_list_product_search_list__WEBPACK_IMPORTED_MODULE_10__.ProductSearchListPageComponent, _components_custom_photos_custom_photos__WEBPACK_IMPORTED_MODULE_12__.CustomPhotosComponent, _components_custom_img_custom_img__WEBPACK_IMPORTED_MODULE_13__.CustomImgComponent, _components_product_content_collapse_product_content_collapse__WEBPACK_IMPORTED_MODULE_16__.ProductContentCollapseComponent, _pages_product_endcap_product_endcap__WEBPACK_IMPORTED_MODULE_17__.ProductEndcapPageComponent],
    imports: [_angular_common__WEBPACK_IMPORTED_MODULE_19__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_20__.FormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_21__.IonicModule, ngx_moment__WEBPACK_IMPORTED_MODULE_22__.MomentModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _angular_router__WEBPACK_IMPORTED_MODULE_23__.RouterModule, _product_services_module__WEBPACK_IMPORTED_MODULE_1__.ProductServiceModule, _rsApp_modules_header_header_component_module__WEBPACK_IMPORTED_MODULE_11__.HeaderComponentModule, _rsApp_modules_browse_category_service_module__WEBPACK_IMPORTED_MODULE_14__.CategoryServiceModule, _rsApp_modules_shared_shared_module__WEBPACK_IMPORTED_MODULE_15__.SharedModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_24__.TranslateModule],
    exports: [_pages_product_detail_product_detail__WEBPACK_IMPORTED_MODULE_2__.ProductDetailPageComponent, _components_price_multiple_cards_price_multiple_cards__WEBPACK_IMPORTED_MODULE_3__.PriceMultipleCardsComponent, _components_product_options_modal_product_options_modal__WEBPACK_IMPORTED_MODULE_4__.ProductOptionsModalComponent, _components_product_options_selector_product_options_selector__WEBPACK_IMPORTED_MODULE_5__.ProductOptionsSelectorComponent, _components_product_added_product_added__WEBPACK_IMPORTED_MODULE_6__.ProductAddedComponent, _components_parity_product_parity_product_flavor_parity_product_flavor__WEBPACK_IMPORTED_MODULE_7__.ParityProductFlavorComponent, _components_parity_product_parity_product_size_parity_product_size__WEBPACK_IMPORTED_MODULE_9__.ParityProductSizeComponent, _components_gift_card_options_modal_gift_card_options_modal__WEBPACK_IMPORTED_MODULE_8__.GiftCardOptionsModalComponent, _pages_product_search_list_product_search_list__WEBPACK_IMPORTED_MODULE_10__.ProductSearchListPageComponent, _components_product_content_collapse_product_content_collapse__WEBPACK_IMPORTED_MODULE_16__.ProductContentCollapseComponent]
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
//# sourceMappingURL=default-src_app_modules_ecom-v2_product_product-routing_module_ts.js.map