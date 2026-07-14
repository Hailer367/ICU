package androidx.recyclerview.widget;

import A2.i;
import R1.c;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import h0.AbstractC0333u;
import h0.C0298A;
import h0.C0301D;
import h0.C0323k;
import h0.C0334v;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: p, reason: collision with root package name */
    public final int f3068p;

    /* renamed from: q, reason: collision with root package name */
    public final c f3069q;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f3068p = -1;
        new SparseIntArray();
        new SparseIntArray();
        c cVar = new c(22);
        this.f3069q = cVar;
        new Rect();
        int i6 = AbstractC0333u.w(context, attributeSet, i4, i5).f3918c;
        if (i6 == this.f3068p) {
            return;
        }
        if (i6 >= 1) {
            this.f3068p = i6;
            ((SparseIntArray) cVar.f1532g).clear();
            H();
            return;
        }
        throw new IllegalArgumentException(i.g(i6, "Span count should be at least 1. Provided "));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Q(boolean z) {
        if (!z) {
            super.Q(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final int R(C0298A c0298a, C0301D c0301d, int i4) {
        int E3;
        boolean z = c0301d.f3826c;
        c cVar = this.f3069q;
        if (!z) {
            cVar.getClass();
            return c.l(i4, this.f3068p);
        }
        RecyclerView recyclerView = (RecyclerView) c0298a.k;
        C0301D c0301d2 = recyclerView.f3104c0;
        if (i4 >= 0 && i4 < c0301d2.a()) {
            if (!c0301d2.f3826c) {
                E3 = i4;
            } else {
                E3 = recyclerView.f3111h.E(i4, 0);
            }
            if (E3 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i4);
                return 0;
            }
            cVar.getClass();
            return c.l(E3, this.f3068p);
        }
        throw new IndexOutOfBoundsException("invalid position " + i4 + ". State item count is " + c0301d2.a() + recyclerView.h());
    }

    @Override // h0.AbstractC0333u
    public final boolean d(C0334v c0334v) {
        return c0334v instanceof C0323k;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, h0.AbstractC0333u
    public final C0334v l() {
        if (this.f3070h == 0) {
            return new C0334v(-2, -1);
        }
        return new C0334v(-1, -2);
    }

    @Override // h0.AbstractC0333u
    public final C0334v m(Context context, AttributeSet attributeSet) {
        return new C0334v(context, attributeSet);
    }

    @Override // h0.AbstractC0333u
    public final C0334v n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0334v((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0334v(layoutParams);
    }

    @Override // h0.AbstractC0333u
    public final int q(C0298A c0298a, C0301D c0301d) {
        if (this.f3070h == 1) {
            return this.f3068p;
        }
        if (c0301d.a() < 1) {
            return 0;
        }
        return R(c0298a, c0301d, c0301d.a() - 1) + 1;
    }

    @Override // h0.AbstractC0333u
    public final int x(C0298A c0298a, C0301D c0301d) {
        if (this.f3070h == 0) {
            return this.f3068p;
        }
        if (c0301d.a() < 1) {
            return 0;
        }
        return R(c0298a, c0301d, c0301d.a() - 1) + 1;
    }
}
