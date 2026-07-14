package h0;

import I.T;
import android.R;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: h0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0319g {

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f3876x = {R.attr.state_pressed};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f3877y = new int[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f3878a;

    /* renamed from: b, reason: collision with root package name */
    public final StateListDrawable f3879b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f3880c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3881d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3882e;

    /* renamed from: f, reason: collision with root package name */
    public final StateListDrawable f3883f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f3884g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3885h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3886i;

    /* renamed from: j, reason: collision with root package name */
    public float f3887j;
    public float k;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f3890n;

    /* renamed from: u, reason: collision with root package name */
    public final ValueAnimator f3897u;

    /* renamed from: v, reason: collision with root package name */
    public int f3898v;

    /* renamed from: w, reason: collision with root package name */
    public final F.b f3899w;

    /* renamed from: l, reason: collision with root package name */
    public int f3888l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f3889m = 0;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3891o = false;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f3892p = false;

    /* renamed from: q, reason: collision with root package name */
    public int f3893q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f3894r = 0;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f3895s = new int[2];

    /* renamed from: t, reason: collision with root package name */
    public final int[] f3896t = new int[2];

    public C0319g(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i4, int i5, int i6) {
        boolean z;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f3897u = ofFloat;
        this.f3898v = 0;
        F.b bVar = new F.b(11, this);
        this.f3899w = bVar;
        Object obj = new Object();
        this.f3879b = stateListDrawable;
        this.f3880c = drawable;
        this.f3883f = stateListDrawable2;
        this.f3884g = drawable2;
        this.f3881d = Math.max(i4, stateListDrawable.getIntrinsicWidth());
        this.f3882e = Math.max(i4, drawable.getIntrinsicWidth());
        this.f3885h = Math.max(i4, stateListDrawable2.getIntrinsicWidth());
        this.f3886i = Math.max(i4, drawable2.getIntrinsicWidth());
        this.f3878a = i6;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new C0317e(this));
        ofFloat.addUpdateListener(new C0318f(this));
        RecyclerView recyclerView2 = this.f3890n;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.f3122o;
            AbstractC0333u abstractC0333u = recyclerView2.f3121n;
            if (abstractC0333u != null) {
                abstractC0333u.a("Cannot remove item decoration during a scroll  or layout");
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
            RecyclerView recyclerView3 = this.f3890n;
            recyclerView3.f3123p.remove(this);
            if (recyclerView3.f3124q == this) {
                recyclerView3.f3124q = null;
            }
            ArrayList arrayList2 = this.f3890n.f3105d0;
            if (arrayList2 != null) {
                arrayList2.remove(obj);
            }
            this.f3890n.removeCallbacks(bVar);
        }
        this.f3890n = recyclerView;
        ArrayList arrayList3 = recyclerView.f3122o;
        AbstractC0333u abstractC0333u2 = recyclerView.f3121n;
        if (abstractC0333u2 != null) {
            abstractC0333u2.a("Cannot add item decoration during a scroll  or layout");
        }
        if (arrayList3.isEmpty()) {
            recyclerView.setWillNotDraw(false);
        }
        arrayList3.add(this);
        recyclerView.m();
        recyclerView.requestLayout();
        this.f3890n.f3123p.add(this);
        RecyclerView recyclerView4 = this.f3890n;
        if (recyclerView4.f3105d0 == null) {
            recyclerView4.f3105d0 = new ArrayList();
        }
        recyclerView4.f3105d0.add(obj);
    }

    public static int d(float f4, float f5, int[] iArr, int i4, int i5, int i6) {
        int i7 = iArr[1] - iArr[0];
        if (i7 != 0) {
            int i8 = i4 - i6;
            int i9 = (int) (((f5 - f4) / i7) * i8);
            int i10 = i5 + i9;
            if (i10 < i8 && i10 >= 0) {
                return i9;
            }
        }
        return 0;
    }

    public final boolean a(float f4, float f5) {
        if (f5 >= this.f3889m - this.f3885h && f4 >= 0 - (0 / 2) && f4 <= (0 / 2) + 0) {
            return true;
        }
        return false;
    }

    public final boolean b(float f4, float f5) {
        WeakHashMap weakHashMap = T.f702a;
        int layoutDirection = this.f3890n.getLayoutDirection();
        int i4 = this.f3881d;
        if (layoutDirection != 1 ? f4 >= this.f3888l - i4 : f4 <= i4 / 2) {
            int i5 = 0 / 2;
            if (f5 >= 0 - i5 && f5 <= i5 + 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(MotionEvent motionEvent) {
        int i4 = this.f3893q;
        if (i4 == 1) {
            boolean b4 = b(motionEvent.getX(), motionEvent.getY());
            boolean a4 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0) {
                if (b4 || a4) {
                    if (a4) {
                        this.f3894r = 1;
                        this.k = (int) motionEvent.getX();
                    } else if (b4) {
                        this.f3894r = 2;
                        this.f3887j = (int) motionEvent.getY();
                    }
                    e(2);
                    return true;
                }
                return false;
            }
            return false;
        }
        if (i4 == 2) {
            return true;
        }
        return false;
    }

    public final void e(int i4) {
        F.b bVar = this.f3899w;
        StateListDrawable stateListDrawable = this.f3879b;
        if (i4 == 2 && this.f3893q != 2) {
            stateListDrawable.setState(f3876x);
            this.f3890n.removeCallbacks(bVar);
        }
        if (i4 == 0) {
            this.f3890n.invalidate();
        } else {
            f();
        }
        if (this.f3893q == 2 && i4 != 2) {
            stateListDrawable.setState(f3877y);
            this.f3890n.removeCallbacks(bVar);
            this.f3890n.postDelayed(bVar, 1200);
        } else if (i4 == 1) {
            this.f3890n.removeCallbacks(bVar);
            this.f3890n.postDelayed(bVar, 1500);
        }
        this.f3893q = i4;
    }

    public final void f() {
        int i4 = this.f3898v;
        ValueAnimator valueAnimator = this.f3897u;
        if (i4 != 0) {
            if (i4 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f3898v = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
