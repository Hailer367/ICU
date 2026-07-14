package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;

/* loaded from: classes.dex */
public class FlutterSurfaceView extends SurfaceView implements RenderSurface {
    private static final String TAG = "FlutterSurfaceView";
    private FlutterRenderer flutterRenderer;
    private boolean isContentSizingEnabled;
    private boolean isPaused;
    private boolean isSurfaceAvailableForRendering;
    private final boolean renderTransparently;
    private final SurfaceHolder.Callback surfaceCallback;
    private final SurfaceHolderCallbackCompat surfaceHolderCallbackCompat;

    /* renamed from: io.flutter.embedding.android.FlutterSurfaceView$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements SurfaceHolder.Callback {
        public AnonymousClass1() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.surfaceChanged()");
            if (FlutterSurfaceView.this.shouldNotify()) {
                FlutterSurfaceView.this.changeSurfaceSize(i3, i4);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.startRenderingToSurface()");
            FlutterSurfaceView.this.isSurfaceAvailableForRendering = true;
            if (FlutterSurfaceView.this.shouldNotify()) {
                FlutterSurfaceView.this.connectSurfaceToRenderer();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.stopRenderingToSurface()");
            FlutterSurfaceView.this.isSurfaceAvailableForRendering = false;
            if (FlutterSurfaceView.this.shouldNotify()) {
                FlutterSurfaceView.this.disconnectSurfaceFromRenderer();
            }
        }
    }

    public FlutterSurfaceView(Context context) {
        this(context, null, false);
    }

    public void changeSurfaceSize(int i2, int i3) {
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Notifying FlutterRenderer that Android surface size has changed to " + i2 + " x " + i3);
            this.flutterRenderer.surfaceChanged(i2, i3);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    public void connectSurfaceToRenderer() {
        if (this.flutterRenderer != null && getHolder() != null) {
            this.flutterRenderer.startRenderingToSurface(getHolder().getSurface(), this.isPaused);
            return;
        }
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
    }

    public void disconnectSurfaceFromRenderer() {
        FlutterRenderer flutterRenderer = this.flutterRenderer;
        if (flutterRenderer != null) {
            flutterRenderer.stopRenderingToSurface();
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }

    private void init() {
        if (this.renderTransparently) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        this.isContentSizingEnabled = ContentSizingFlag.isEnabled(getContext());
        getHolder().addCallback(this.surfaceHolderCallbackCompat);
    }

    public boolean shouldNotify() {
        if (this.flutterRenderer != null && !this.isPaused) {
            return true;
        }
        return false;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        Log.v(TAG, "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
        }
        this.flutterRenderer = flutterRenderer;
        this.surfaceHolderCallbackCompat.onAttachToRenderer(flutterRenderer);
        resume();
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        Log.v(TAG, "Detaching from FlutterRenderer.");
        if (this.flutterRenderer != null) {
            if (getWindowToken() != null) {
                Log.v(TAG, "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            this.surfaceHolderCallbackCompat.onDetachFromRenderer();
            this.flutterRenderer = null;
            return;
        }
        Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i2 = iArr[0];
        region.op(i2, iArr[1], (getRight() + i2) - getLeft(), (getBottom() + iArr[1]) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    public boolean isSurfaceAvailableForRendering() {
        return this.isSurfaceAvailableForRendering;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.isContentSizingEnabled) {
            FlutterMeasureSpec.onMeasure(i2, i3, new b(1, this));
        } else {
            super.onMeasure(i2, i3);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void pause() {
        if (this.flutterRenderer == null) {
            Log.w(TAG, "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.isPaused = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void resume() {
        if (this.flutterRenderer == null) {
            Log.w(TAG, "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.surfaceHolderCallbackCompat.onResume();
        if (isSurfaceAvailableForRendering()) {
            Log.v(TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
        this.isPaused = false;
    }

    public FlutterSurfaceView(Context context, boolean z) {
        this(context, null, z);
    }

    public FlutterSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    private FlutterSurfaceView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.isSurfaceAvailableForRendering = false;
        this.isPaused = false;
        this.isContentSizingEnabled = false;
        AnonymousClass1 anonymousClass1 = new SurfaceHolder.Callback() { // from class: io.flutter.embedding.android.FlutterSurfaceView.1
            public AnonymousClass1() {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.surfaceChanged()");
                if (FlutterSurfaceView.this.shouldNotify()) {
                    FlutterSurfaceView.this.changeSurfaceSize(i3, i4);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.startRenderingToSurface()");
                FlutterSurfaceView.this.isSurfaceAvailableForRendering = true;
                if (FlutterSurfaceView.this.shouldNotify()) {
                    FlutterSurfaceView.this.connectSurfaceToRenderer();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.stopRenderingToSurface()");
                FlutterSurfaceView.this.isSurfaceAvailableForRendering = false;
                if (FlutterSurfaceView.this.shouldNotify()) {
                    FlutterSurfaceView.this.disconnectSurfaceFromRenderer();
                }
            }
        };
        this.surfaceCallback = anonymousClass1;
        this.renderTransparently = z;
        this.surfaceHolderCallbackCompat = new SurfaceHolderCallbackCompat(anonymousClass1, this, this.flutterRenderer);
        init();
    }
}
