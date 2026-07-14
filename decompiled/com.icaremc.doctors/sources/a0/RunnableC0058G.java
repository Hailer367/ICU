package a0;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

/* renamed from: a0.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0058G implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public int f903c;

    /* renamed from: d, reason: collision with root package name */
    public int f904d;

    /* renamed from: e, reason: collision with root package name */
    public OverScroller f905e;

    /* renamed from: f, reason: collision with root package name */
    public Interpolator f906f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f907g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f908h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f909i;

    public RunnableC0058G(RecyclerView recyclerView) {
        this.f909i = recyclerView;
        p pVar = RecyclerView.f1898m0;
        this.f906f = pVar;
        this.f907g = false;
        this.f908h = false;
        this.f905e = new OverScroller(recyclerView.getContext(), pVar);
    }

    public final void a() {
        if (this.f907g) {
            this.f908h = true;
            return;
        }
        RecyclerView recyclerView = this.f909i;
        recyclerView.removeCallbacks(this);
        Field field = E.J.f180a;
        recyclerView.postOnAnimation(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        boolean awakenScrollBars;
        boolean z;
        boolean z2;
        boolean z3;
        RecyclerView recyclerView = this.f909i;
        if (recyclerView.f1938k == null) {
            recyclerView.removeCallbacks(this);
            this.f905e.abortAnimation();
            return;
        }
        this.f908h = false;
        this.f907g = true;
        recyclerView.d();
        OverScroller overScroller = this.f905e;
        recyclerView.f1938k.getClass();
        if (overScroller.computeScrollOffset()) {
            int[] iArr = recyclerView.f1930f0;
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i4 = currX - this.f903c;
            int i5 = currY - this.f904d;
            this.f903c = currX;
            this.f904d = currY;
            if (recyclerView.f(i4, i5, 1, iArr, null)) {
                i2 = i4 - iArr[0];
                i3 = i5 - iArr[1];
            } else {
                i2 = i4;
                i3 = i5;
            }
            if (!recyclerView.f1939l.isEmpty()) {
                recyclerView.invalidate();
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.c(i2, i3);
            }
            recyclerView.g(null, 1);
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            if (i3 != 0 && recyclerView.f1938k.c() && i3 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (i2 != 0 && recyclerView.f1938k.b() && i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i2 != 0 || i3 != 0) && !z2 && !z) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!overScroller.isFinished() && (z3 || recyclerView.k())) {
                a();
                RunnableC0069k runnableC0069k = recyclerView.f1918U;
                if (runnableC0069k != null) {
                    runnableC0069k.a(recyclerView, i2, i3);
                }
            } else {
                recyclerView.setScrollState(0);
                C0067i c0067i = recyclerView.f1919V;
                c0067i.getClass();
                c0067i.f978c = 0;
                recyclerView.s(1);
            }
        }
        this.f907g = false;
        if (this.f908h) {
            a();
        }
    }
}
