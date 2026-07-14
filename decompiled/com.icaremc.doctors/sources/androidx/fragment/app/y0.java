package androidx.fragment.app;

import android.view.View;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1771c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1772d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1773e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1774f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1775g;

    public y0(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1771c = i2;
        this.f1772d = arrayList;
        this.f1773e = arrayList2;
        this.f1774f = arrayList3;
        this.f1775g = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i2 = 0; i2 < this.f1771c; i2++) {
            View view = (View) this.f1772d.get(i2);
            String str = (String) this.f1773e.get(i2);
            Field field = E.J.f180a;
            view.setTransitionName(str);
            ((View) this.f1774f.get(i2)).setTransitionName((String) this.f1775g.get(i2));
        }
    }
}
