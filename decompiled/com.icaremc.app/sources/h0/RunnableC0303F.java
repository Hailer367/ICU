package h0;

import I.T;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* renamed from: h0.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0303F implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public int f3829f;

    /* renamed from: g, reason: collision with root package name */
    public int f3830g;

    /* renamed from: h, reason: collision with root package name */
    public OverScroller f3831h;

    /* renamed from: i, reason: collision with root package name */
    public Interpolator f3832i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3833j;
    public boolean k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f3834l;

    public RunnableC0303F(RecyclerView recyclerView) {
        this.f3834l = recyclerView;
        InterpolatorC0328p interpolatorC0328p = RecyclerView.f3079p0;
        this.f3832i = interpolatorC0328p;
        this.f3833j = false;
        this.k = false;
        this.f3831h = new OverScroller(recyclerView.getContext(), interpolatorC0328p);
    }

    public final void a() {
        if (this.f3833j) {
            this.k = true;
            return;
        }
        RecyclerView recyclerView = this.f3834l;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = T.f702a;
        recyclerView.postOnAnimation(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4;
        int i5;
        boolean awakenScrollBars;
        boolean z;
        boolean z3;
        boolean z4;
        RecyclerView recyclerView = this.f3834l;
        if (recyclerView.f3121n == null) {
            recyclerView.removeCallbacks(this);
            this.f3831h.abortAnimation();
            return;
        }
        this.k = false;
        this.f3833j = true;
        recyclerView.d();
        OverScroller overScroller = this.f3831h;
        recyclerView.f3121n.getClass();
        if (overScroller.computeScrollOffset()) {
            int[] iArr = recyclerView.f3114i0;
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i6 = currX - this.f3829f;
            int i7 = currY - this.f3830g;
            this.f3829f = currX;
            this.f3830g = currY;
            if (recyclerView.f(i6, i7, iArr, null, 1)) {
                i4 = i6 - iArr[0];
                i5 = i7 - iArr[1];
            } else {
                i4 = i6;
                i5 = i7;
            }
            if (!recyclerView.f3122o.isEmpty()) {
                recyclerView.invalidate();
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.c(i4, i5);
            }
            recyclerView.g(null, 1);
            awakenScrollBars = recyclerView.awakenScrollBars();
            if (!awakenScrollBars) {
                recyclerView.invalidate();
            }
            if (i5 != 0 && recyclerView.f3121n.c() && i5 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (i4 != 0 && recyclerView.f3121n.b() && i4 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i4 != 0 || i5 != 0) && !z3 && !z) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!overScroller.isFinished() && (z4 || recyclerView.k())) {
                a();
                RunnableC0322j runnableC0322j = recyclerView.f3102a0;
                if (runnableC0322j != null) {
                    runnableC0322j.a(recyclerView, i4, i5);
                }
            } else {
                recyclerView.setScrollState(0);
                C0320h c0320h = recyclerView.f3103b0;
                c0320h.getClass();
                c0320h.f3902c = 0;
                recyclerView.s(1);
            }
        }
        this.f3833j = false;
        if (this.k) {
            a();
        }
    }
}
