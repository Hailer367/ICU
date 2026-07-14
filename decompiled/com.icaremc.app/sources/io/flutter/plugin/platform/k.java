package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import h2.AbstractActivityC0349b;
import h2.C0348a;

/* loaded from: classes.dex */
public final class k extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public int f4333f;

    /* renamed from: g, reason: collision with root package name */
    public int f4334g;

    /* renamed from: h, reason: collision with root package name */
    public int f4335h;

    /* renamed from: i, reason: collision with root package name */
    public int f4336i;

    /* renamed from: j, reason: collision with root package name */
    public C0348a f4337j;
    public i k;

    /* renamed from: l, reason: collision with root package name */
    public j f4338l;

    public k(AbstractActivityC0349b abstractActivityC0349b) {
        super(abstractActivityC0349b);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        i iVar = this.k;
        if (iVar == null) {
            super.draw(canvas);
            Log.e("PlatformViewWrapper", "Platform view cannot be composed without a RenderTarget.");
            return;
        }
        Surface surface = iVar.getSurface();
        if (!surface.isValid()) {
            Log.e("PlatformViewWrapper", "Platform view cannot be composed without a valid RenderTarget surface.");
            return;
        }
        Canvas lockHardwareCanvas = surface.lockHardwareCanvas();
        if (lockHardwareCanvas == null) {
            invalidate();
            return;
        }
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            super.draw(lockHardwareCanvas);
        } finally {
            this.k.scheduleFrame();
            surface.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public ViewTreeObserver.OnGlobalFocusChangeListener getActiveFocusListener() {
        return this.f4338l;
    }

    public int getRenderTargetHeight() {
        i iVar = this.k;
        if (iVar != null) {
            return iVar.getHeight();
        }
        return 0;
    }

    public int getRenderTargetWidth() {
        i iVar = this.k;
        if (iVar != null) {
            return iVar.getWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4337j == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                matrix.postTranslate(this.f4335h, this.f4336i);
            } else {
                matrix.postTranslate(this.f4333f, this.f4334g);
                this.f4333f = this.f4335h;
                this.f4334g = this.f4336i;
            }
        } else {
            int i4 = this.f4335h;
            this.f4333f = i4;
            int i5 = this.f4336i;
            this.f4334g = i5;
            matrix.postTranslate(i4, i5);
        }
        this.f4337j.d(motionEvent, matrix);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getImportantForAccessibility() == 4) {
            return false;
        }
        return super.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        this.f4335h = layoutParams.leftMargin;
        this.f4336i = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        j jVar;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (jVar = this.f4338l) != null) {
            this.f4338l = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(jVar);
        }
        ViewTreeObserver viewTreeObserver2 = getViewTreeObserver();
        if (viewTreeObserver2.isAlive() && this.f4338l == null) {
            j jVar2 = new j(this, onFocusChangeListener);
            this.f4338l = jVar2;
            viewTreeObserver2.addOnGlobalFocusChangeListener(jVar2);
        }
    }

    public void setTouchProcessor(C0348a c0348a) {
        this.f4337j = c0348a;
    }
}
