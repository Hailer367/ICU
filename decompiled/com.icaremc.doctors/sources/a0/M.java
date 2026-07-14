package a0;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f926a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f927b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f928c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public final int f929d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f930e;

    public M(StaggeredGridLayoutManager staggeredGridLayoutManager, int i2) {
        this.f930e = staggeredGridLayoutManager;
        this.f929d = i2;
    }

    public final int a(int i2) {
        int i3 = this.f928c;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (this.f926a.size() == 0) {
            return i2;
        }
        View view = (View) this.f926a.get(r3.size() - 1);
        J j2 = (J) view.getLayoutParams();
        this.f928c = this.f930e.f1952j.b(view);
        j2.getClass();
        return this.f928c;
    }
}
