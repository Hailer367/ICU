package androidx.appcompat.view.menu;

import A2.t;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import n.D;
import n.m;
import n.n;
import n.q;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements m, D, AdapterView.OnItemClickListener {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f2273g = {R.attr.background, R.attr.divider};

    /* renamed from: f, reason: collision with root package name */
    public n f2274f;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        t P = t.P(context, attributeSet, f2273g, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) P.f100h;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(P.H(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(P.H(1));
        }
        P.T();
    }

    @Override // n.D
    public final void a(n nVar) {
        this.f2274f = nVar;
    }

    @Override // n.m
    public final boolean b(q qVar) {
        return this.f2274f.q(qVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        b((q) getAdapter().getItem(i4));
    }
}
