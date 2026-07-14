package h0;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* renamed from: h0.L, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0309L {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3850a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f3851b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f3852c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public final int f3853d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f3854e;

    public C0309L(StaggeredGridLayoutManager staggeredGridLayoutManager, int i4) {
        this.f3854e = staggeredGridLayoutManager;
        this.f3853d = i4;
    }

    public final int a(int i4) {
        int i5 = this.f3852c;
        if (i5 != Integer.MIN_VALUE) {
            return i5;
        }
        if (this.f3850a.size() == 0) {
            return i4;
        }
        View view = (View) this.f3850a.get(r3.size() - 1);
        C0306I c0306i = (C0306I) view.getLayoutParams();
        this.f3852c = this.f3854e.f3135j.b(view);
        c0306i.getClass();
        return this.f3852c;
    }
}
