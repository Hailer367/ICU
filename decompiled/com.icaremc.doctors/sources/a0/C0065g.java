package a0;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* renamed from: a0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0065g {

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f954x = {R.attr.state_pressed};
    public static final int[] y = new int[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f955a;

    /* renamed from: b, reason: collision with root package name */
    public final StateListDrawable f956b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f957c;

    /* renamed from: d, reason: collision with root package name */
    public final int f958d;

    /* renamed from: e, reason: collision with root package name */
    public final int f959e;

    /* renamed from: f, reason: collision with root package name */
    public final StateListDrawable f960f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f961g;

    /* renamed from: h, reason: collision with root package name */
    public final int f962h;

    /* renamed from: i, reason: collision with root package name */
    public final int f963i;

    /* renamed from: j, reason: collision with root package name */
    public float f964j;

    /* renamed from: k, reason: collision with root package name */
    public float f965k;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f968n;

    /* renamed from: u, reason: collision with root package name */
    public final ValueAnimator f973u;

    /* renamed from: v, reason: collision with root package name */
    public int f974v;

    /* renamed from: w, reason: collision with root package name */
    public final B.b f975w;

    /* renamed from: l, reason: collision with root package name */
    public int f966l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f967m = 0;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f969o = false;
    public final boolean p = false;
    public int q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f970r = 0;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f971s = new int[2];

    /* renamed from: t, reason: collision with root package name */
    public final int[] f972t = new int[2];

    public C0065g(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        boolean z;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f973u = ofFloat;
        this.f974v = 0;
        B.b bVar = new B.b(2, this);
        this.f975w = bVar;
        Object obj = new Object();
        this.f956b = stateListDrawable;
        this.f957c = drawable;
        this.f960f = stateListDrawable2;
        this.f961g = drawable2;
        this.f958d = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f959e = Math.max(i2, drawable.getIntrinsicWidth());
        this.f962h = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f963i = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f955a = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new C0063e(this));
        ofFloat.addUpdateListener(new C0064f(this));
        RecyclerView recyclerView2 = this.f968n;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.f1939l;
            v vVar = recyclerView2.f1938k;
            if (vVar != null) {
                vVar.a("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                if (recyclerView2.getOverScrollMode() == 2) {
                    z = true;
                } else {
                    z = false;
                }
                recyclerView2.setWillNotDraw(z);
            }
            recyclerView2.m();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f968n;
            recyclerView3.f1940m.remove(this);
            if (recyclerView3.f1941n == this) {
                recyclerView3.f1941n = null;
            }
            ArrayList arrayList2 = this.f968n.f1921a0;
            if (arrayList2 != null) {
                arrayList2.remove(obj);
            }
            this.f968n.removeCallbacks(bVar);
        }
        this.f968n = recyclerView;
        ArrayList arrayList3 = recyclerView.f1939l;
        v vVar2 = recyclerView.f1938k;
        if (vVar2 != null) {
            vVar2.a("Cannot add item decoration during a scroll  or layout");
        }
        if (arrayList3.isEmpty()) {
            recyclerView.setWillNotDraw(false);
        }
        arrayList3.add(this);
        recyclerView.m();
        recyclerView.requestLayout();
        this.f968n.f1940m.add(this);
        RecyclerView recyclerView4 = this.f968n;
        if (recyclerView4.f1921a0 == null) {
            recyclerView4.f1921a0 = new ArrayList();
        }
        recyclerView4.f1921a0.add(obj);
    }

    public static int d(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 != 0) {
            int i6 = i2 - i4;
            int i7 = (int) (((f3 - f2) / i5) * i6);
            int i8 = i3 + i7;
            if (i8 < i6 && i8 >= 0) {
                return i7;
            }
        }
        return 0;
    }

    public final boolean a(float f2, float f3) {
        if (f3 >= this.f967m - this.f962h && f2 >= 0 - (0 / 2) && f2 <= (0 / 2) + 0) {
            return true;
        }
        return false;
    }

    public final boolean b(float f2, float f3) {
        Field field = E.J.f180a;
        int layoutDirection = this.f968n.getLayoutDirection();
        int i2 = this.f958d;
        if (layoutDirection != 1 ? f2 >= this.f966l - i2 : f2 <= i2 / 2) {
            int i3 = 0 / 2;
            if (f3 >= 0 - i3 && f3 <= i3 + 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(MotionEvent motionEvent) {
        int i2 = this.q;
        if (i2 == 1) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0) {
                if (b2 || a2) {
                    if (a2) {
                        this.f970r = 1;
                        this.f965k = (int) motionEvent.getX();
                    } else if (b2) {
                        this.f970r = 2;
                        this.f964j = (int) motionEvent.getY();
                    }
                    e(2);
                    return true;
                }
                return false;
            }
            return false;
        }
        if (i2 == 2) {
            return true;
        }
        return false;
    }

    public final void e(int i2) {
        B.b bVar = this.f975w;
        StateListDrawable stateListDrawable = this.f956b;
        if (i2 == 2 && this.q != 2) {
            stateListDrawable.setState(f954x);
            this.f968n.removeCallbacks(bVar);
        }
        if (i2 == 0) {
            this.f968n.invalidate();
        } else {
            f();
        }
        if (this.q == 2 && i2 != 2) {
            stateListDrawable.setState(y);
            this.f968n.removeCallbacks(bVar);
            this.f968n.postDelayed(bVar, 1200);
        } else if (i2 == 1) {
            this.f968n.removeCallbacks(bVar);
            this.f968n.postDelayed(bVar, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.q = i2;
    }

    public final void f() {
        int i2 = this.f974v;
        ValueAnimator valueAnimator = this.f973u;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f974v = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
