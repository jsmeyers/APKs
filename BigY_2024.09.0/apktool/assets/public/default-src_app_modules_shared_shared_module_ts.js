"use strict";
(self["webpackChunkapp"] = self["webpackChunkapp"] || []).push([["default-src_app_modules_shared_shared_module_ts"],{

/***/ 29499:
/*!************************************************************************!*\
  !*** ./src/app/modules/shared/components/dxp-img/dxp-img.component.ts ***!
  \************************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DXPImageComponent: () => (/* binding */ DXPImageComponent)
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
function DXPImageComponent_ng_container_1_img_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "img", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("load", function DXPImageComponent_ng_container_1_img_1_Template_img_load_0_listener() {
      _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵrestoreView"](_r1);
      const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
      return _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵresetView"](ctx_r1.onLoad());
    })("error", function DXPImageComponent_ng_container_1_img_1_Template_img_error_0_listener() {
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
function DXPImageComponent_ng_container_1_div_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "div", 6);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles);
  }
}
function DXPImageComponent_ng_container_1_img_3_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "img", 7);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles)("src", ctx_r1.default, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeUrl"])("alt", ctx_r1.alt)("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](4, _c2, ctx_r1.isFit, ctx_r1.isCover, ctx_r1.isContain));
  }
}
function DXPImageComponent_ng_container_1_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, DXPImageComponent_ng_container_1_img_1_Template, 1, 9, "img", 2)(2, DXPImageComponent_ng_container_1_div_2_Template, 1, 1, "div", 3)(3, DXPImageComponent_ng_container_1_img_3_Template, 1, 8, "img", 4);
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
function DXPImageComponent_ng_container_2_img_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "img", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵlistener"]("error", function DXPImageComponent_ng_container_2_img_1_Template_img_error_0_listener() {
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
function DXPImageComponent_ng_container_2_img_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](0, "img", 7);
  }
  if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵproperty"]("ngStyle", ctx_r1.styles)("src", ctx_r1.default, _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsanitizeUrl"])("alt", ctx_r1.alt)("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpureFunction3"](4, _c2, ctx_r1.isFit, ctx_r1.isCover, ctx_r1.isContain));
  }
}
function DXPImageComponent_ng_container_2_Template(rf, ctx) {
  if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementContainerStart"](0);
    _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, DXPImageComponent_ng_container_2_img_1_Template, 1, 8, "img", 8)(2, DXPImageComponent_ng_container_2_img_2_Template, 1, 8, "img", 4);
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
class DXPImageComponent {
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
  static ɵfac = function DXPImageComponent_Factory(t) {
    return new (t || DXPImageComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_core__WEBPACK_IMPORTED_MODULE_2__.ChangeDetectorRef));
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({
    type: DXPImageComponent,
    selectors: [["dxp-img"]],
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
    template: function DXPImageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtemplate"](1, DXPImageComponent_ng_container_1_Template, 4, 3, "ng-container", 1)(2, DXPImageComponent_ng_container_2_Template, 3, 2, "ng-container", 1);
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
    styles: [".container[_ngcontent-%COMP%] {\n  position: relative;\n  height: 100%;\n  width: 100%;\n  text-align: center;\n}\n\nimg[_ngcontent-%COMP%] {\n  max-width: 100%;\n  max-height: 100%;\n}\n\n.container.full-width[_ngcontent-%COMP%]   img.fit[_ngcontent-%COMP%] {\n  max-height: none;\n  width: 100%;\n}\n\n.container.full-height[_ngcontent-%COMP%]   img.fit[_ngcontent-%COMP%] {\n  max-width: none;\n  height: 100%;\n}\n\n.container[_ngcontent-%COMP%]   img.cover.fit[_ngcontent-%COMP%] {\n  height: 100%;\n  width: 100%;\n  object-fit: cover;\n}\n\nimg.cover[_ngcontent-%COMP%] {\n  object-fit: cover;\n}\n\nimg.contain[_ngcontent-%COMP%] {\n  object-fit: contain !important;\n}\n\nimg.fit[_ngcontent-%COMP%], img.cover[_ngcontent-%COMP%] {\n  position: absolute;\n  top: 50%;\n  left: 50%;\n  transform: translate(-50%, -50%);\n}\n\n.img-loading[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  border-radius: 6px;\n  animation: _ngcontent-%COMP%_image-loading 2s infinite;\n  background: linear-gradient(to right, #eff1f3 4%, #e2e2e2 25%, #eff1f3 36%);\n  background-size: 1000px 100%;\n  opacity: 0.8;\n}\n\n@keyframes _ngcontent-%COMP%_image-loading {\n  0% {\n    background-position: -1000px 0;\n  }\n  100% {\n    background-position: 1000px 0;\n  }\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9zaGFyZWQvY29tcG9uZW50cy9keHAtaW1nL2R4cC1pbWcuY29tcG9uZW50LnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxrQkFBQTtFQUNBLFlBQUE7RUFDQSxXQUFBO0VBQ0Esa0JBQUE7QUFDRjs7QUFDQTtFQUNFLGVBQUE7RUFDQSxnQkFBQTtBQUVGOztBQUFBO0VBQ0UsZ0JBQUE7RUFDQSxXQUFBO0FBR0Y7O0FBQUE7RUFDRSxlQUFBO0VBQ0EsWUFBQTtBQUdGOztBQUFBO0VBQ0UsWUFBQTtFQUNBLFdBQUE7RUFDQSxpQkFBQTtBQUdGOztBQURBO0VBQ0UsaUJBQUE7QUFJRjs7QUFGQTtFQUNFLDhCQUFBO0FBS0Y7O0FBSEE7O0VBRUUsa0JBQUE7RUFDQSxRQUFBO0VBQ0EsU0FBQTtFQUNBLGdDQUFBO0FBTUY7O0FBSEE7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLGtCQUFBO0VBQ0Esb0NBQUE7RUFDQSwyRUFBQTtFQUNBLDRCQUFBO0VBQ0EsWUFBQTtBQU1GOztBQUhBO0VBQ0U7SUFDRSw4QkFBQTtFQU1GO0VBSkE7SUFDRSw2QkFBQTtFQU1GO0FBQ0YiLCJzb3VyY2VzQ29udGVudCI6WyIuY29udGFpbmVyIHtcbiAgcG9zaXRpb246IHJlbGF0aXZlO1xuICBoZWlnaHQ6IDEwMCU7XG4gIHdpZHRoOiAxMDAlO1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG59XG5pbWcge1xuICBtYXgtd2lkdGg6IDEwMCU7XG4gIG1heC1oZWlnaHQ6IDEwMCU7XG59XG4uY29udGFpbmVyLmZ1bGwtd2lkdGggaW1nLmZpdCB7XG4gIG1heC1oZWlnaHQ6IG5vbmU7XG4gIHdpZHRoOiAxMDAlO1xufVxuXG4uY29udGFpbmVyLmZ1bGwtaGVpZ2h0IGltZy5maXQge1xuICBtYXgtd2lkdGg6IG5vbmU7XG4gIGhlaWdodDogMTAwJTtcbn1cblxuLmNvbnRhaW5lciBpbWcuY292ZXIuZml0IHtcbiAgaGVpZ2h0OiAxMDAlO1xuICB3aWR0aDogMTAwJTtcbiAgb2JqZWN0LWZpdDogY292ZXI7XG59XG5pbWcuY292ZXIge1xuICBvYmplY3QtZml0OiBjb3Zlcjtcbn1cbmltZy5jb250YWluIHtcbiAgb2JqZWN0LWZpdDogY29udGFpbiAhaW1wb3J0YW50O1xufVxuaW1nLmZpdCxcbmltZy5jb3ZlciB7XG4gIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgdG9wOiA1MCU7XG4gIGxlZnQ6IDUwJTtcbiAgdHJhbnNmb3JtOiB0cmFuc2xhdGUoLTUwJSwgLTUwJSk7XG59XG5cbi5pbWctbG9hZGluZyB7XG4gIHdpZHRoOiAxMDAlO1xuICBoZWlnaHQ6IDEwMCU7XG4gIGJvcmRlci1yYWRpdXM6IDZweDtcbiAgYW5pbWF0aW9uOiBpbWFnZS1sb2FkaW5nIDJzIGluZmluaXRlO1xuICBiYWNrZ3JvdW5kOiBsaW5lYXItZ3JhZGllbnQodG8gcmlnaHQsICNlZmYxZjMgNCUsICNlMmUyZTIgMjUlLCAjZWZmMWYzIDM2JSk7XG4gIGJhY2tncm91bmQtc2l6ZTogMTAwMHB4IDEwMCU7XG4gIG9wYWNpdHk6IDAuODtcbn1cblxuQGtleWZyYW1lcyBpbWFnZS1sb2FkaW5nIHtcbiAgMCUge1xuICAgIGJhY2tncm91bmQtcG9zaXRpb246IC0xMDAwcHggMDtcbiAgfVxuICAxMDAlIHtcbiAgICBiYWNrZ3JvdW5kLXBvc2l0aW9uOiAxMDAwcHggMDtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 9217:
/*!************************************************************!*\
  !*** ./src/app/modules/shared/page/not-found/not-found.ts ***!
  \************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   NotFoundPageComponent: () => (/* binding */ NotFoundPageComponent)
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ 90852);



class NotFoundPageComponent {
  static ɵfac = function NotFoundPageComponent_Factory(t) {
    return new (t || NotFoundPageComponent)();
  };
  static ɵcmp = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
    type: NotFoundPageComponent,
    selectors: [["page-not-found"]],
    decls: 9,
    vars: 6,
    consts: [[1, "container"], [1, "not-found"], ["src", "assets/imgs/404.svg", 1, "not-found__image"], [1, "not-found__title"], [1, "not-found__description"]],
    template: function NotFoundPageComponent_Template(rf, ctx) {
      if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0)(1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "ion-img", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "p", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](5, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "p", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](8, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]()()();
      }
      if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](5, 2, "common.notFoundTitle"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](8, 4, "common.notFoundDescription"));
      }
    },
    dependencies: [_ionic_angular__WEBPACK_IMPORTED_MODULE_1__.IonImg, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__.TranslatePipe],
    styles: [".not-found[_ngcontent-%COMP%] {\n  padding: var(--mag-spacing-400, 32px) var(--mag-spacing-200, 16px) var(--mag-spacing-1000, 80px) var(--mag-spacing-200, 16px);\n}\n.not-found__image[_ngcontent-%COMP%] {\n  width: 100%;\n  height: 100%;\n  object-fit: cover;\n  margin-bottom: var(--mag-spacing-150, 12px);\n}\n.not-found__title[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend, Arial, sans-serif);\n  font-size: var(--mag-typography-display-large-font-size, 32px);\n  font-style: normal;\n  font-weight: var(--mag-typography-display-large-font-weight, 600);\n  line-height: var(--mag-typography-display-large-line-height, 40px);\n  margin-bottom: var(--mag-spacing-200, 16px);\n}\n.not-found__description[_ngcontent-%COMP%] {\n  color: var(--mag-color-text-primary, #121212);\n  font-family: var(--mag-typography-platform-font-family, Lexend, Arial, sans-serif);\n  font-size: var(--mag-typography-body-medium-font-size, 16px);\n  font-style: normal;\n  font-weight: var(--mag-typography-body-medium-font-weight-regular, 300);\n  line-height: var(--mag-typography-body-medium-line-height, 24px);\n}\n/*# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8uL3NyYy9hcHAvbW9kdWxlcy9zaGFyZWQvcGFnZS9ub3QtZm91bmQvbm90LWZvdW5kLnNjc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSw2SEFBQTtBQUNGO0FBRUU7RUFDRSxXQUFBO0VBQ0EsWUFBQTtFQUNBLGlCQUFBO0VBQ0EsMkNBQUE7QUFBSjtBQUdFO0VBQ0UsNkNBQUE7RUFDQSxrRkFBQTtFQUNBLDhEQUFBO0VBQ0Esa0JBQUE7RUFDQSxpRUFBQTtFQUNBLGtFQUFBO0VBQ0EsMkNBQUE7QUFESjtBQUlFO0VBQ0UsNkNBQUE7RUFDQSxrRkFBQTtFQUNBLDREQUFBO0VBQ0Esa0JBQUE7RUFDQSx1RUFBQTtFQUNBLGdFQUFBO0FBRkoiLCJzb3VyY2VzQ29udGVudCI6WyIubm90LWZvdW5kIHtcbiAgcGFkZGluZzogdmFyKC0tbWFnLXNwYWNpbmctNDAwLCAzMnB4KSB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpIHZhcigtLW1hZy1zcGFjaW5nLTEwMDAsIDgwcHgpXG4gICAgdmFyKC0tbWFnLXNwYWNpbmctMjAwLCAxNnB4KTtcblxuICAmX19pbWFnZSB7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgaGVpZ2h0OiAxMDAlO1xuICAgIG9iamVjdC1maXQ6IGNvdmVyO1xuICAgIG1hcmdpbi1ib3R0b206IHZhcigtLW1hZy1zcGFjaW5nLTE1MCwgMTJweCk7XG4gIH1cblxuICAmX190aXRsZSB7XG4gICAgY29sb3I6IHZhcigtLW1hZy1jb2xvci10ZXh0LXByaW1hcnksICMxMjEyMTIpO1xuICAgIGZvbnQtZmFtaWx5OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1wbGF0Zm9ybS1mb250LWZhbWlseSwgTGV4ZW5kLCBBcmlhbCwgc2Fucy1zZXJpZik7XG4gICAgZm9udC1zaXplOiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LWxhcmdlLWZvbnQtc2l6ZSwgMzJweCk7XG4gICAgZm9udC1zdHlsZTogbm9ybWFsO1xuICAgIGZvbnQtd2VpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LWxhcmdlLWZvbnQtd2VpZ2h0LCA2MDApO1xuICAgIGxpbmUtaGVpZ2h0OiB2YXIoLS1tYWctdHlwb2dyYXBoeS1kaXNwbGF5LWxhcmdlLWxpbmUtaGVpZ2h0LCA0MHB4KTtcbiAgICBtYXJnaW4tYm90dG9tOiB2YXIoLS1tYWctc3BhY2luZy0yMDAsIDE2cHgpO1xuICB9XG5cbiAgJl9fZGVzY3JpcHRpb24ge1xuICAgIGNvbG9yOiB2YXIoLS1tYWctY29sb3ItdGV4dC1wcmltYXJ5LCAjMTIxMjEyKTtcbiAgICBmb250LWZhbWlseTogdmFyKC0tbWFnLXR5cG9ncmFwaHktcGxhdGZvcm0tZm9udC1mYW1pbHksIExleGVuZCwgQXJpYWwsIHNhbnMtc2VyaWYpO1xuICAgIGZvbnQtc2l6ZTogdmFyKC0tbWFnLXR5cG9ncmFwaHktYm9keS1tZWRpdW0tZm9udC1zaXplLCAxNnB4KTtcbiAgICBmb250LXN0eWxlOiBub3JtYWw7XG4gICAgZm9udC13ZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWZvbnQtd2VpZ2h0LXJlZ3VsYXIsIDMwMCk7XG4gICAgbGluZS1oZWlnaHQ6IHZhcigtLW1hZy10eXBvZ3JhcGh5LWJvZHktbWVkaXVtLWxpbmUtaGVpZ2h0LCAyNHB4KTtcbiAgfVxufVxuIl0sInNvdXJjZVJvb3QiOiIifQ== */"]
  });
}

/***/ }),

/***/ 70541:
/*!*************************************************!*\
  !*** ./src/app/modules/shared/shared.module.ts ***!
  \*************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   SharedModule: () => (/* binding */ SharedModule)
/* harmony export */ });
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 60316);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ 95072);
/* harmony import */ var _ionic_angular__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ionic/angular */ 37401);
/* harmony import */ var _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../utils/utils.module */ 50777);
/* harmony import */ var _maskito_angular__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @maskito/angular */ 54483);
/* harmony import */ var _utils_validator_date_validator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../utils/validator/date.validator */ 55975);
/* harmony import */ var _utils_validator_must_match_validator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../utils/validator/must-match.validator */ 47926);
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @ngx-translate/core */ 90852);
/* harmony import */ var _page_not_found_not_found__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./page/not-found/not-found */ 9217);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _components_dxp_img_dxp_img_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/dxp-img/dxp-img.component */ 29499);












class SharedModule {
  static ɵfac = function SharedModule_Factory(t) {
    return new (t || SharedModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineNgModule"]({
    type: SharedModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineInjector"]({
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _angular_common__WEBPACK_IMPORTED_MODULE_7__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.FormsModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.ReactiveFormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonicModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _utils_validator_must_match_validator__WEBPACK_IMPORTED_MODULE_2__.MustMatchModule, _utils_validator_date_validator__WEBPACK_IMPORTED_MODULE_1__.DateValidatorModule, _maskito_angular__WEBPACK_IMPORTED_MODULE_10__.MaskitoModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_11__.TranslateModule]
  });
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵsetNgModuleScope"](SharedModule, {
    declarations: [_components_dxp_img_dxp_img_component__WEBPACK_IMPORTED_MODULE_4__.DXPImageComponent, _page_not_found_not_found__WEBPACK_IMPORTED_MODULE_3__.NotFoundPageComponent],
    imports: [_angular_router__WEBPACK_IMPORTED_MODULE_6__.RouterModule, _angular_common__WEBPACK_IMPORTED_MODULE_7__.CommonModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.FormsModule, _angular_forms__WEBPACK_IMPORTED_MODULE_8__.ReactiveFormsModule, _ionic_angular__WEBPACK_IMPORTED_MODULE_9__.IonicModule, _utils_utils_module__WEBPACK_IMPORTED_MODULE_0__.UtilsModule, _utils_validator_must_match_validator__WEBPACK_IMPORTED_MODULE_2__.MustMatchModule, _utils_validator_date_validator__WEBPACK_IMPORTED_MODULE_1__.DateValidatorModule, _maskito_angular__WEBPACK_IMPORTED_MODULE_10__.MaskitoModule, _ngx_translate_core__WEBPACK_IMPORTED_MODULE_11__.TranslateModule],
    exports: [_components_dxp_img_dxp_img_component__WEBPACK_IMPORTED_MODULE_4__.DXPImageComponent, _page_not_found_not_found__WEBPACK_IMPORTED_MODULE_3__.NotFoundPageComponent]
  });
})();

/***/ }),

/***/ 55975:
/*!***********************************************************!*\
  !*** ./src/app/modules/utils/validator/date.validator.ts ***!
  \***********************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   DateValidator: () => (/* binding */ DateValidator),
/* harmony export */   DateValidatorModule: () => (/* binding */ DateValidatorModule),
/* harmony export */   dateValidtorFn: () => (/* binding */ dateValidtorFn)
/* harmony export */ });
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! moment */ 39545);
/* harmony import */ var moment__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(moment__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 37580);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ 34456);
// import { AbstractControl, Validators, ValidatorFn } from '@angular/forms';
// export const date: ValidatorFn = (control: AbstractControl): {[key: string]: boolean} => {
//   if (isPresent(Validators.required(control))) return null;
//   let v: string = control.value;
//   return isDate(v) ? null : {date: true};
// };




const dateValidtorFn = dateFormat => {
  return c => {
    const val = c.value;
    if (!val) {
      return null;
    }
    const isDate = moment__WEBPACK_IMPORTED_MODULE_0__(val, dateFormat, true).isValid();
    return isDate ? null : {
      date: true
    };
  };
};
const DATE_VALIDATOR = {
  provide: _angular_forms__WEBPACK_IMPORTED_MODULE_1__.NG_VALIDATORS,
  useExisting: (0,_angular_core__WEBPACK_IMPORTED_MODULE_2__.forwardRef)(() => DateValidator),
  multi: true
};
class DateValidator {
  date;
  validator;
  ngOnInit() {
    this.validator = dateValidtorFn(this.date || 'MM/DD/YYYY');
  }
  validate(c) {
    return this.validator(c);
  }
  static ɵfac = function DateValidator_Factory(t) {
    return new (t || DateValidator)();
  };
  static ɵdir = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineDirective"]({
    type: DateValidator,
    selectors: [["", "date", "", "formControlName", ""], ["", "date", "", "formControl", ""], ["", "date", "", "ngModel", ""]],
    inputs: {
      date: "date"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵProvidersFeature"]([DATE_VALIDATOR])]
  });
}
class DateValidatorModule {
  static ɵfac = function DateValidatorModule_Factory(t) {
    return new (t || DateValidatorModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineNgModule"]({
    type: DateValidatorModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineInjector"]({});
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵsetNgModuleScope"](DateValidatorModule, {
    declarations: [DateValidator],
    exports: [DateValidator]
  });
})();

/***/ }),

/***/ 47926:
/*!*****************************************************************!*\
  !*** ./src/app/modules/utils/validator/must-match.validator.ts ***!
  \*****************************************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   MustMatchDirective: () => (/* binding */ MustMatchDirective),
/* harmony export */   MustMatchModule: () => (/* binding */ MustMatchModule)
/* harmony export */ });
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ 34456);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 37580);


class MustMatchDirective {
  mustMatch = [];
  validate(formGroup) {
    // return MustMatch(this.mustMatch[0], this.mustMatch[1])(formGroup);
    const controlName = this.mustMatch[0],
      matchingControlName = this.mustMatch[1];
    const control = formGroup.controls[controlName];
    const matchingControl = formGroup.controls[matchingControlName];
    // return null if controls haven't initialised yet
    if (!control || !matchingControl) {
      return null;
    }
    // return null if another validator has already found an error on the matchingControl
    if (matchingControl.errors && !matchingControl.errors.mustMatch) {
      return null;
    }
    // set error on matchingControl if validation fails
    if (control.value !== matchingControl.value) {
      matchingControl.setErrors({
        mustMatch: true
      });
    } else {
      matchingControl.setErrors(null);
    }
  }
  static ɵfac = function MustMatchDirective_Factory(t) {
    return new (t || MustMatchDirective)();
  };
  static ɵdir = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineDirective"]({
    type: MustMatchDirective,
    selectors: [["", "mustMatch", ""]],
    inputs: {
      mustMatch: "mustMatch"
    },
    features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([{
      provide: _angular_forms__WEBPACK_IMPORTED_MODULE_1__.NG_VALIDATORS,
      useExisting: MustMatchDirective,
      multi: true
    }])]
  });
}
class MustMatchModule {
  static ɵfac = function MustMatchModule_Factory(t) {
    return new (t || MustMatchModule)();
  };
  static ɵmod = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
    type: MustMatchModule
  });
  static ɵinj = /*@__PURE__*/_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({});
}
(function () {
  (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](MustMatchModule, {
    declarations: [MustMatchDirective],
    exports: [MustMatchDirective]
  });
})();

/***/ })

}]);
//# sourceMappingURL=default-src_app_modules_shared_shared_module_ts.js.map