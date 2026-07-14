package e0;

import android.view.View;
import android.view.ViewGroup;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public final class D extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2164b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f2165c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f2166d;

    public D(i iVar, ViewGroup viewGroup, View view, View view2) {
        this.f2166d = iVar;
        this.f2163a = viewGroup;
        this.f2164b = view;
        this.f2165c = view2;
    }

    @Override // e0.r
    public final void b(s sVar) {
        this.f2165c.setTag(R.id.save_overlay_view, null);
        this.f2163a.getOverlay().remove(this.f2164b);
        sVar.w(this);
    }

    @Override // e0.t, e0.r
    public final void c() {
        this.f2163a.getOverlay().remove(this.f2164b);
    }

    @Override // e0.t, e0.r
    public final void d() {
        View view = this.f2164b;
        if (view.getParent() == null) {
            this.f2163a.getOverlay().add(view);
        } else {
            this.f2166d.d();
        }
    }
}
