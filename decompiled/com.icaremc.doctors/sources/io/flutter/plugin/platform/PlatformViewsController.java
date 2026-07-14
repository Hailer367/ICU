package io.flutter.plugin.platform;

import B0.o;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    private static Class[] VIEW_TYPES_REQUIRE_NON_TLHC = {SurfaceView.class};
    private static boolean enableImageRenderTarget = true;
    private static boolean enableSurfaceProducerRenderTarget = true;
    private AndroidTouchProcessor androidTouchProcessor;
    private Context context;
    private FlutterView flutterView;
    private PlatformViewsChannel platformViewsChannel;
    private TextInputPlugin textInputPlugin;
    TextureRegistry textureRegistry;
    private FlutterJNI flutterJNI = null;
    private int nextOverlayLayerId = 0;
    private boolean flutterViewConvertedToImageView = false;
    private boolean synchronizeToNativeViewHierarchy = true;
    private boolean usesSoftwareRendering = false;
    final PlatformViewsChannel.PlatformViewsHandler channelHandler = new AnonymousClass1();
    private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();
    private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    final HashMap<Context, View> contextToEmbeddedView = new HashMap<>();
    private final SparseArray<PlatformOverlayView> overlayLayerViews = new SparseArray<>();
    private final HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private final HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    private final SparseArray<PlatformViewWrapper> viewWrappers = new SparseArray<>();
    private final SparseArray<PlatformView> platformViews = new SparseArray<>();
    private final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* renamed from: io.flutter.plugin.platform.PlatformViewsController$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements PlatformViewsChannel.PlatformViewsHandler {
        public AnonymousClass1() {
        }

        public /* synthetic */ void lambda$resize$0(VirtualDisplayController virtualDisplayController, float f2, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            PlatformViewsController.this.unlockInputConnection(virtualDisplayController);
            if (PlatformViewsController.this.context != null) {
                f2 = PlatformViewsController.this.getDisplayDensity();
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(virtualDisplayController.getRenderTargetWidth(), f2), PlatformViewsController.this.toLogicalPixels(virtualDisplayController.getRenderTargetHeight(), f2)));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void clearFocus(int i2) {
            View view;
            if (PlatformViewsController.this.usesVirtualDisplay(i2)) {
                view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2)).getView();
            } else {
                PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
                if (platformView == null) {
                    Log.e(PlatformViewsController.TAG, "Clearing focus on an unknown view with id: " + i2);
                    return;
                }
                view = platformView.getView();
            }
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Clearing focus on a null view with id: " + i2);
                return;
            }
            view.clearFocus();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void createForPlatformViewLayer(PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.enforceMinimumAndroidApiVersion(19);
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            PlatformViewsController.this.throwIfHCPPEnabled();
            PlatformViewsController.this.configureForHybridComposition(PlatformViewsController.this.createPlatformView(platformViewCreationRequest, false), platformViewCreationRequest);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        @SuppressLint({"NewApi"})
        public long createForTextureLayer(PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            int i2 = platformViewCreationRequest.viewId;
            if (PlatformViewsController.this.viewWrappers.get(i2) == null) {
                PlatformViewsController platformViewsController = PlatformViewsController.this;
                if (platformViewsController.textureRegistry != null) {
                    if (platformViewsController.flutterView != null) {
                        PlatformView createPlatformView = PlatformViewsController.this.createPlatformView(platformViewCreationRequest, true);
                        View view = createPlatformView.getView();
                        if (view.getParent() == null) {
                            if (ViewUtils.hasChildViewOfType(view, PlatformViewsController.VIEW_TYPES_REQUIRE_NON_TLHC)) {
                                if (platformViewCreationRequest.displayMode == PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK) {
                                    PlatformViewsController.this.configureForHybridComposition(createPlatformView, platformViewCreationRequest);
                                    return -2L;
                                }
                                if (!PlatformViewsController.this.usesSoftwareRendering) {
                                    return PlatformViewsController.this.configureForVirtualDisplay(createPlatformView, platformViewCreationRequest);
                                }
                            }
                            return PlatformViewsController.this.configureForTextureLayerComposition(createPlatformView, platformViewCreationRequest);
                        }
                        throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
                    }
                    throw new IllegalStateException(O.a.c(i2, "Flutter view is null. This means the platform views controller doesn't have an attached view, view id: "));
                }
                throw new IllegalStateException(O.a.c(i2, "Texture registry is null. This means that platform views controller was detached, view id: "));
            }
            throw new IllegalStateException(O.a.c(i2, "Trying to create an already created platform view, view id: "));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void createPlatformViewHcpp(PlatformViewCreationRequest platformViewCreationRequest) {
            throw new IllegalStateException("Trying to create an HC++ platform view from within PlatformViewsController1. Request: " + platformViewCreationRequest);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void dispose(int i2) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Disposing unknown platform view with id: " + i2);
                return;
            }
            if (platformView.getView() != null) {
                View view = platformView.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            PlatformViewsController.this.platformViews.remove(i2);
            try {
                platformView.dispose();
            } catch (RuntimeException e2) {
                Log.e(PlatformViewsController.TAG, "Disposing platform view threw an exception", e2);
            }
            if (PlatformViewsController.this.usesVirtualDisplay(i2)) {
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2));
                View view2 = virtualDisplayController.getView();
                if (view2 != null) {
                    PlatformViewsController.this.contextToEmbeddedView.remove(view2.getContext());
                }
                virtualDisplayController.dispose();
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(i2));
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i2);
            if (platformViewWrapper != null) {
                platformViewWrapper.removeAllViews();
                platformViewWrapper.release();
                platformViewWrapper.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup2 = (ViewGroup) platformViewWrapper.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(platformViewWrapper);
                }
                PlatformViewsController.this.viewWrappers.remove(i2);
                return;
            }
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i2);
            if (flutterMutatorView != null) {
                flutterMutatorView.removeAllViews();
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup3 = (ViewGroup) flutterMutatorView.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(flutterMutatorView);
                }
                PlatformViewsController.this.platformViewParent.remove(i2);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public boolean isHcppEnabled() {
            return false;
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void offset(int i2, double d2, double d3) {
            if (PlatformViewsController.this.usesVirtualDisplay(i2)) {
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i2);
            if (platformViewWrapper != null) {
                int physicalPixels = PlatformViewsController.this.toPhysicalPixels(d2);
                int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(d3);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
                layoutParams.topMargin = physicalPixels;
                layoutParams.leftMargin = physicalPixels2;
                platformViewWrapper.setLayoutParams(layoutParams);
                return;
            }
            Log.e(PlatformViewsController.TAG, "Setting offset for unknown platform view with id: " + i2);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void onTouch(PlatformViewTouch platformViewTouch) {
            int i2 = platformViewTouch.viewId;
            float f2 = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            if (PlatformViewsController.this.usesVirtualDisplay(i2)) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f2, platformViewTouch, true));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to an unknown view with id: " + i2);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to a null view with id: " + i2);
                return;
            }
            view.dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f2, platformViewTouch, false));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void resize(PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, final PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            int physicalPixels = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
            int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
            int i2 = platformViewResizeRequest.viewId;
            if (PlatformViewsController.this.usesVirtualDisplay(i2)) {
                final float displayDensity = PlatformViewsController.this.getDisplayDensity();
                final VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2));
                PlatformViewsController.this.lockInputConnection(virtualDisplayController);
                virtualDisplayController.resize(physicalPixels, physicalPixels2, new Runnable() { // from class: io.flutter.plugin.platform.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlatformViewsController.AnonymousClass1.this.lambda$resize$0(virtualDisplayController, displayDensity, platformViewBufferResized);
                    }
                });
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i2);
            if (platformView != null && platformViewWrapper != null) {
                if (physicalPixels > platformViewWrapper.getRenderTargetWidth() || physicalPixels2 > platformViewWrapper.getRenderTargetHeight()) {
                    platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
                }
                ViewGroup.LayoutParams layoutParams = platformViewWrapper.getLayoutParams();
                layoutParams.width = physicalPixels;
                layoutParams.height = physicalPixels2;
                platformViewWrapper.setLayoutParams(layoutParams);
                View view = platformView.getView();
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    layoutParams2.width = physicalPixels;
                    layoutParams2.height = physicalPixels2;
                    view.setLayoutParams(layoutParams2);
                }
                platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getRenderTargetWidth()), PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getRenderTargetHeight())));
                return;
            }
            Log.e(PlatformViewsController.TAG, "Resizing unknown platform view with id: " + i2);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void setDirection(int i2, int i3) {
            View view;
            if (PlatformViewsController.validateDirection(i3)) {
                if (PlatformViewsController.this.usesVirtualDisplay(i2)) {
                    view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i2)).getView();
                } else {
                    PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i2);
                    if (platformView == null) {
                        Log.e(PlatformViewsController.TAG, "Setting direction to an unknown view with id: " + i2);
                        return;
                    }
                    view = platformView.getView();
                }
                if (view == null) {
                    Log.e(PlatformViewsController.TAG, "Setting direction to a null view with id: " + i2);
                    return;
                }
                view.setLayoutDirection(i3);
                return;
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i3 + "(view id: " + i2 + ")");
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void synchronizeToNativeViewHierarchy(boolean z) {
            PlatformViewsController.this.synchronizeToNativeViewHierarchy = z;
        }
    }

    public void configureForHybridComposition(PlatformView platformView, PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(19);
        Log.i(TAG, "Using hybrid composition for platform view: " + platformViewCreationRequest.viewId);
        throwIfHCPPEnabled();
    }

    public long configureForVirtualDisplay(PlatformView platformView, PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(20);
        Log.i(TAG, "Hosting view in a virtual display for platform view: " + platformViewCreationRequest.viewId);
        PlatformViewRenderTarget makePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
        VirtualDisplayController create = VirtualDisplayController.create(this.context, this.accessibilityEventsDelegate, platformView, makePlatformViewRenderTarget, toPhysicalPixels(platformViewCreationRequest.logicalWidth), toPhysicalPixels(platformViewCreationRequest.logicalHeight), platformViewCreationRequest.viewId, null, new d(this, platformViewCreationRequest, 1));
        if (create != null) {
            this.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), create);
            View view = platformView.getView();
            this.contextToEmbeddedView.put(view.getContext(), view);
            return makePlatformViewRenderTarget.getId();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
    }

    private void diposeAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
    }

    public void enforceMinimumAndroidApiVersion(int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= i2) {
        } else {
            throw new IllegalStateException(O.a.d("Trying to use platform views with API ", i3, ", required API level is: ", i2));
        }
    }

    public void ensureValidRequest(PlatformViewCreationRequest platformViewCreationRequest) {
        if (validateDirection(platformViewCreationRequest.direction)) {
            return;
        }
        throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
    }

    private void finishFrame(boolean z) {
        for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
            int keyAt = this.overlayLayerViews.keyAt(i2);
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i2);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                this.flutterView.attachOverlaySurfaceToRender(valueAt);
                z &= valueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
                this.flutterView.removeView(valueAt);
            }
        }
        for (int i3 = 0; i3 < this.platformViewParent.size(); i3++) {
            int keyAt2 = this.platformViewParent.keyAt(i3);
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(keyAt2);
            if (this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) && (z || !this.synchronizeToNativeViewHierarchy)) {
                flutterMutatorView.setVisibility(0);
            } else {
                flutterMutatorView.setVisibility(8);
            }
        }
    }

    public float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    private void initializeRootImageViewIfNeeded() {
        if (this.synchronizeToNativeViewHierarchy && !this.flutterViewConvertedToImageView) {
            this.flutterView.convertToImageView();
            this.flutterViewConvertedToImageView = true;
        }
    }

    public /* synthetic */ void lambda$configureForTextureLayerComposition$1(PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(platformViewCreationRequest.viewId);
        }
    }

    public /* synthetic */ void lambda$configureForVirtualDisplay$0(PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
        }
    }

    public /* synthetic */ void lambda$initializePlatformViewIfNeeded$2(int i2, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(i2);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i2);
        }
    }

    public /* synthetic */ void lambda$onEndFrame$3() {
        finishFrame(false);
    }

    public void lockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.lockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionLocked();
    }

    private static PlatformViewRenderTarget makePlatformViewRenderTarget(TextureRegistry textureRegistry) {
        int i2;
        TextureRegistry.SurfaceLifecycle surfaceLifecycle;
        if (enableSurfaceProducerRenderTarget && (i2 = Build.VERSION.SDK_INT) >= 29) {
            if (i2 <= 34) {
                surfaceLifecycle = TextureRegistry.SurfaceLifecycle.resetInBackground;
            } else {
                surfaceLifecycle = TextureRegistry.SurfaceLifecycle.manual;
            }
            TextureRegistry.SurfaceProducer createSurfaceProducer = textureRegistry.createSurfaceProducer(surfaceLifecycle);
            Log.i(TAG, "PlatformView is using SurfaceProducer backend");
            return new SurfaceProducerPlatformViewRenderTarget(createSurfaceProducer);
        }
        if (enableImageRenderTarget && Build.VERSION.SDK_INT >= 29) {
            TextureRegistry.ImageTextureEntry createImageTexture = textureRegistry.createImageTexture();
            Log.i(TAG, "PlatformView is using ImageReader backend");
            return new ImageReaderPlatformViewRenderTarget(createImageTexture);
        }
        TextureRegistry.SurfaceTextureEntry createSurfaceTexture = textureRegistry.createSurfaceTexture();
        Log.i(TAG, "PlatformView is using SurfaceTexture backend");
        return new SurfaceTexturePlatformViewRenderTarget(createSurfaceTexture);
    }

    private void maybeInvokeOnFlutterViewAttached(PlatformView platformView) {
        FlutterView flutterView = this.flutterView;
        if (flutterView == null) {
            Log.i(TAG, "null flutterView");
        } else {
            platformView.onFlutterViewAttached(flutterView);
        }
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f2) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        double d2 = f2;
        pointerCoords.toolMajor = (float) (((Double) list.get(3)).doubleValue() * d2);
        pointerCoords.toolMinor = (float) (((Double) list.get(4)).doubleValue() * d2);
        pointerCoords.touchMajor = (float) (((Double) list.get(5)).doubleValue() * d2);
        pointerCoords.touchMinor = (float) (((Double) list.get(6)).doubleValue() * d2);
        pointerCoords.x = (float) (((Double) list.get(7)).doubleValue() * d2);
        pointerCoords.y = (float) (((Double) list.get(8)).doubleValue() * d2);
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(parsePointerCoords(it.next(), f2));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(parsePointerProperties(it.next()));
        }
        return arrayList;
    }

    private void removeOverlaySurfaces() {
        if (this.flutterView == null) {
            Log.e(TAG, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
            this.flutterView.removeView(this.overlayLayerViews.valueAt(i2));
        }
        this.overlayLayerViews.clear();
    }

    public void throwIfHCPPEnabled() {
        if (!this.flutterJNI.IsSurfaceControlEnabled()) {
        } else {
            throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
        }
    }

    public int toLogicalPixels(double d2, float f2) {
        return (int) Math.round(d2 / f2);
    }

    public int toPhysicalPixels(double d2) {
        return (int) Math.round(d2 * getDisplayDensity());
    }

    private static void translateMotionEvent(MotionEvent motionEvent, MotionEvent.PointerCoords[] pointerCoordsArr) {
        if (pointerCoordsArr.length < 1) {
            return;
        }
        motionEvent.offsetLocation(pointerCoordsArr[0].x - motionEvent.getX(), pointerCoordsArr[0].y - motionEvent.getY());
    }

    public void unlockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.unlockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionUnlocked();
    }

    public static boolean validateDirection(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public void attach(Context context, TextureRegistry textureRegistry, DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context;
            this.textureRegistry = textureRegistry;
            this.platformViewsChannel = new PlatformViewsChannel(dartExecutor);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        this.textInputPlugin = textInputPlugin;
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(FlutterView flutterView) {
        this.flutterView = flutterView;
        for (int i2 = 0; i2 < this.viewWrappers.size(); i2++) {
            this.flutterView.addView(this.viewWrappers.valueAt(i2));
        }
        for (int i3 = 0; i3 < this.platformViewParent.size(); i3++) {
            this.flutterView.addView(this.platformViewParent.valueAt(i3));
        }
        for (int i4 = 0; i4 < this.platformViews.size(); i4++) {
            this.platformViews.valueAt(i4).onFlutterViewAttached(this.flutterView);
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.contextToEmbeddedView.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.contextToEmbeddedView.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public long configureForTextureLayerComposition(PlatformView platformView, PlatformViewCreationRequest platformViewCreationRequest) {
        PlatformViewWrapper platformViewWrapper;
        long j2;
        enforceMinimumAndroidApiVersion(23);
        Log.i(TAG, "Hosting view in view hierarchy for platform view: " + platformViewCreationRequest.viewId);
        int physicalPixels = toPhysicalPixels(platformViewCreationRequest.logicalWidth);
        int physicalPixels2 = toPhysicalPixels(platformViewCreationRequest.logicalHeight);
        if (this.usesSoftwareRendering) {
            platformViewWrapper = new PlatformViewWrapper(this.context);
            j2 = -1;
        } else {
            PlatformViewRenderTarget makePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
            PlatformViewWrapper platformViewWrapper2 = new PlatformViewWrapper(this.context, makePlatformViewRenderTarget);
            long id = makePlatformViewRenderTarget.getId();
            platformViewWrapper = platformViewWrapper2;
            j2 = id;
        }
        platformViewWrapper.setTouchProcessor(this.androidTouchProcessor);
        platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(physicalPixels, physicalPixels2);
        int physicalPixels3 = toPhysicalPixels(platformViewCreationRequest.logicalTop);
        int physicalPixels4 = toPhysicalPixels(platformViewCreationRequest.logicalLeft);
        layoutParams.topMargin = physicalPixels3;
        layoutParams.leftMargin = physicalPixels4;
        platformViewWrapper.setLayoutParams(layoutParams);
        View view = platformView.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(physicalPixels, physicalPixels2));
        view.setImportantForAccessibility(4);
        platformViewWrapper.addView(view);
        platformViewWrapper.setOnDescendantFocusChangeListener(new d(this, platformViewCreationRequest, 0));
        this.flutterView.addView(platformViewWrapper);
        this.viewWrappers.append(platformViewCreationRequest.viewId, platformViewWrapper);
        maybeInvokeOnFlutterViewAttached(platformView);
        return j2;
    }

    public FlutterOverlaySurface createOverlaySurface(PlatformOverlayView platformOverlayView) {
        int i2 = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i2 + 1;
        this.overlayLayerViews.put(i2, platformOverlayView);
        return new FlutterOverlaySurface(i2, platformOverlayView.getSurface());
    }

    public PlatformView createPlatformView(PlatformViewCreationRequest platformViewCreationRequest, boolean z) {
        Object obj;
        Context context;
        PlatformViewFactory factory = this.registry.getFactory(platformViewCreationRequest.viewType);
        if (factory != null) {
            if (platformViewCreationRequest.params != null) {
                obj = factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
            } else {
                obj = null;
            }
            if (z) {
                context = new MutableContextWrapper(this.context);
            } else {
                context = this.context;
            }
            PlatformView create = factory.create(context, platformViewCreationRequest.viewId, obj);
            View view = create.getView();
            if (view != null) {
                view.setLayoutDirection(platformViewCreationRequest.direction);
                this.platformViews.put(platformViewCreationRequest.viewId, create);
                maybeInvokeOnFlutterViewAttached(create);
                return create;
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
    }

    public void destroyOverlaySurfaces() {
        for (int i2 = 0; i2 < this.overlayLayerViews.size(); i2++) {
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i2);
            valueAt.detachFromRenderer();
            valueAt.closeImageReader();
        }
    }

    public void detach() {
        PlatformViewsChannel platformViewsChannel = this.platformViewsChannel;
        if (platformViewsChannel != null) {
            platformViewsChannel.setPlatformViewsHandler(null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibilityBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge(null);
    }

    public void detachFromView() {
        for (int i2 = 0; i2 < this.viewWrappers.size(); i2++) {
            this.flutterView.removeView(this.viewWrappers.valueAt(i2));
        }
        for (int i3 = 0; i3 < this.platformViewParent.size(); i3++) {
            this.flutterView.removeView(this.platformViewParent.valueAt(i3));
        }
        destroyOverlaySurfaces();
        removeOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
        for (int i4 = 0; i4 < this.platformViews.size(); i4++) {
            this.platformViews.valueAt(i4).onFlutterViewDetached();
        }
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public void disposePlatformView(int i2) {
        this.channelHandler.dispose(i2);
    }

    public SparseArray<PlatformOverlayView> getOverlayLayerViews() {
        return this.overlayLayerViews;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public View getPlatformViewById(int i2) {
        if (usesVirtualDisplay(i2)) {
            return this.vdControllers.get(Integer.valueOf(i2)).getView();
        }
        PlatformView platformView = this.platformViews.get(i2);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public PlatformViewsChannel getPlatformViewsChannel() {
        return this.platformViewsChannel;
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    public boolean initializePlatformViewIfNeeded(int i2) {
        PlatformView platformView = this.platformViews.get(i2);
        if (platformView == null) {
            return false;
        }
        if (this.platformViewParent.get(i2) != null) {
            return true;
        }
        View view = platformView.getView();
        if (view != null) {
            if (view.getParent() == null) {
                Context context = this.context;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                flutterMutatorView.setOnDescendantFocusChangeListener(new c(this, i2, 0));
                this.platformViewParent.put(i2, flutterMutatorView);
                view.setImportantForAccessibility(4);
                flutterMutatorView.addView(view);
                this.flutterView.addView(flutterMutatorView);
                return true;
            }
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onDetachedFromJNI() {
        diposeAllViews();
    }

    public void onDisplayOverlaySurface(int i2, int i3, int i4, int i5, int i6) {
        if (this.overlayLayerViews.get(i2) != null) {
            initializeRootImageViewIfNeeded();
            PlatformOverlayView platformOverlayView = this.overlayLayerViews.get(i2);
            if (platformOverlayView.getParent() == null) {
                this.flutterView.addView(platformOverlayView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
            layoutParams.leftMargin = i3;
            layoutParams.topMargin = i4;
            platformOverlayView.setLayoutParams(layoutParams);
            platformOverlayView.setVisibility(0);
            platformOverlayView.bringToFront();
            this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i2));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i2 + ") doesn't exist");
    }

    public void onDisplayPlatformView(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        if (!initializePlatformViewIfNeeded(i2)) {
            return;
        }
        FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i2);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i3, i4, i5, i6);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i8);
        View view = this.platformViews.get(i2).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i2));
    }

    public void onEndFrame() {
        boolean z = false;
        if (this.flutterViewConvertedToImageView && this.currentFrameUsedPlatformViewIds.isEmpty()) {
            this.flutterViewConvertedToImageView = false;
            this.flutterView.revertImageView(new o(5, this));
        } else {
            if (this.flutterViewConvertedToImageView && this.flutterView.acquireLatestImageViewFrame()) {
                z = true;
            }
            finishFrame(z);
        }
    }

    public void onPreEngineRestart() {
        diposeAllViews();
    }

    public void onResume() {
        Iterator<VirtualDisplayController> it = this.vdControllers.values().iterator();
        while (it.hasNext()) {
            it.next().resetSurface();
        }
    }

    public void onTrimMemory(int i2) {
        if (i2 >= 40) {
            Iterator<VirtualDisplayController> it = this.vdControllers.values().iterator();
            while (it.hasNext()) {
                it.next().clearSurface();
            }
        }
    }

    public void setFlutterJNI(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public void setSoftwareRendering(boolean z) {
        this.usesSoftwareRendering = z;
    }

    public MotionEvent toMotionEvent(float f2, PlatformViewTouch platformViewTouch, boolean z) {
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId));
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, f2).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]);
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]);
        if (!z && pop != null) {
            if (pop.getPointerCount() == platformViewTouch.pointerCount && pop.getAction() == platformViewTouch.action) {
                translateMotionEvent(pop, pointerCoordsArr);
                return pop;
            }
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), platformViewTouch.action, platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(int i2) {
        return this.vdControllers.containsKey(Integer.valueOf(i2));
    }

    public int toLogicalPixels(double d2) {
        return toLogicalPixels(d2, getDisplayDensity());
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new PlatformOverlayView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), this.accessibilityEventsDelegate));
    }
}
