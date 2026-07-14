package e0;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f2198a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2199b;

    public k(View view, ArrayList arrayList) {
        this.f2198a = view;
        this.f2199b = arrayList;
    }

    @Override // e0.r
    public final void a(s sVar) {
        sVar.w(this);
        sVar.a(this);
    }

    @Override // e0.r
    public final void b(s sVar) {
        sVar.w(this);
        this.f2198a.setVisibility(8);
        ArrayList arrayList = this.f2199b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((View) arrayList.get(i2)).setVisibility(0);
        }
    }

    @Override // e0.r
    public final void c() {
    }

    @Override // e0.r
    public final void d() {
    }

    @Override // e0.r
    public final void e() {
    }
}
