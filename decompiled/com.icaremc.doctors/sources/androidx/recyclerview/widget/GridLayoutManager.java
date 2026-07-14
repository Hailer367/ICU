package androidx.recyclerview.widget;

import F.h;
import O.a;
import a0.C0053B;
import a0.C0056E;
import a0.C0070l;
import a0.v;
import a0.w;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public final int p;
    public final h q;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.p = -1;
        new SparseIntArray();
        new SparseIntArray();
        h hVar = new h(8);
        this.q = hVar;
        new Rect();
        int i4 = v.w(context, attributeSet, i2, i3).f992c;
        if (i4 == this.p) {
            return;
        }
        if (i4 >= 1) {
            this.p = i4;
            ((SparseIntArray) hVar.f274d).clear();
            H();
            return;
        }
        throw new IllegalArgumentException(a.c(i4, "Span count should be at least 1. Provided "));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Q(boolean z) {
        if (!z) {
            super.Q(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final int R(C0053B c0053b, C0056E c0056e, int i2) {
        int b2;
        boolean z = c0056e.f900c;
        h hVar = this.q;
        if (!z) {
            hVar.getClass();
            return h.l(i2, this.p);
        }
        RecyclerView recyclerView = c0053b.f896f;
        C0056E c0056e2 = recyclerView.f1920W;
        if (i2 >= 0 && i2 < c0056e2.a()) {
            if (!c0056e2.f900c) {
                b2 = i2;
            } else {
                b2 = recyclerView.f1927e.b(i2, 0);
            }
            if (b2 == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
                return 0;
            }
            hVar.getClass();
            return h.l(b2, this.p);
        }
        throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + c0056e2.a() + recyclerView.h());
    }

    @Override // a0.v
    public final boolean d(w wVar) {
        return wVar instanceof C0070l;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, a0.v
    public final w l() {
        if (this.f1887h == 0) {
            return new w(-2, -1);
        }
        return new w(-1, -2);
    }

    @Override // a0.v
    public final w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    @Override // a0.v
    public final w n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new w((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new w(layoutParams);
    }

    @Override // a0.v
    public final int q(C0053B c0053b, C0056E c0056e) {
        if (this.f1887h == 1) {
            return this.p;
        }
        if (c0056e.a() < 1) {
            return 0;
        }
        return R(c0053b, c0056e, c0056e.a() - 1) + 1;
    }

    @Override // a0.v
    public final int x(C0053B c0053b, C0056E c0056e) {
        if (this.f1887h == 0) {
            return this.p;
        }
        if (c0056e.a() < 1) {
            return 0;
        }
        return R(c0053b, c0056e, c0056e.a() - 1) + 1;
    }
}
