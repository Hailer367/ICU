package e0;

import android.view.ViewGroup;

/* renamed from: e0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0182e extends t {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2182a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f2183b;

    public C0182e(ViewGroup viewGroup) {
        this.f2183b = viewGroup;
    }

    @Override // e0.r
    public final void b(s sVar) {
        if (!this.f2182a) {
            android.support.v4.media.session.a.H(this.f2183b, false);
        }
        sVar.w(this);
    }

    @Override // e0.t, e0.r
    public final void c() {
        android.support.v4.media.session.a.H(this.f2183b, false);
    }

    @Override // e0.t, e0.r
    public final void d() {
        android.support.v4.media.session.a.H(this.f2183b, true);
    }

    @Override // e0.t, e0.r
    public final void e() {
        android.support.v4.media.session.a.H(this.f2183b, false);
        this.f2182a = true;
    }
}
