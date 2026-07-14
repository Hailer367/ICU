package n2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import h2.AbstractActivityC0349b;
import h2.C0348a;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.platform.j;
import java.util.Iterator;

/* renamed from: n2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0460a extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public FlutterMutatorsStack f5382f;

    /* renamed from: g, reason: collision with root package name */
    public final float f5383g;

    /* renamed from: h, reason: collision with root package name */
    public int f5384h;

    /* renamed from: i, reason: collision with root package name */
    public int f5385i;

    /* renamed from: j, reason: collision with root package name */
    public final C0348a f5386j;
    public final Paint k;

    /* renamed from: l, reason: collision with root package name */
    public j f5387l;

    public C0460a(AbstractActivityC0349b abstractActivityC0349b, float f4, C0348a c0348a) {
        super(abstractActivityC0349b, null);
        this.f5383g = f4;
        this.f5386j = c0348a;
        this.k = new Paint();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f5382f.getFinalMatrix());
        float f4 = this.f5383g;
        matrix.preScale(1.0f / f4, 1.0f / f4);
        matrix.postTranslate(-this.f5384h, -this.f5385i);
        return matrix;
    }

    public final void a() {
        j jVar;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (jVar = this.f5387l) != null) {
            this.f5387l = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(jVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f5382f.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f5384h, -this.f5385i);
            canvas.clipPath(path);
        }
        int finalOpacity = (int) (this.f5382f.getFinalOpacity() * 255.0f);
        Paint paint = this.k;
        if (paint.getAlpha() != finalOpacity) {
            paint.setAlpha((int) (this.f5382f.getFinalOpacity() * 255.0f));
            setLayerType(2, paint);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0348a c0348a = this.f5386j;
        if (c0348a == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(getLeft(), getTop());
        c0348a.d(motionEvent, matrix);
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

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        a();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f5387l == null) {
            j jVar = new j(onFocusChangeListener, this);
            this.f5387l = jVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(jVar);
        }
    }
}
