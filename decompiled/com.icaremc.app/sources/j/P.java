package j;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import m.AbstractC0438b;
import m.InterfaceC0437a;
import o.C0523j;

/* loaded from: classes.dex */
public final class P extends AbstractC0438b implements n.l {

    /* renamed from: h, reason: collision with root package name */
    public final Context f4912h;

    /* renamed from: i, reason: collision with root package name */
    public final n.n f4913i;

    /* renamed from: j, reason: collision with root package name */
    public io.flutter.plugin.platform.s f4914j;
    public WeakReference k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Q f4915l;

    public P(Q q2, Context context, io.flutter.plugin.platform.s sVar) {
        this.f4915l = q2;
        this.f4912h = context;
        this.f4914j = sVar;
        n.n nVar = new n.n(context);
        nVar.f5304l = 1;
        this.f4913i = nVar;
        nVar.f5298e = this;
    }

    @Override // m.AbstractC0438b
    public final void a() {
        Q q2 = this.f4915l;
        if (q2.f4925i != this) {
            return;
        }
        boolean z = q2.f4931p;
        boolean z3 = q2.f4932q;
        if (!z && !z3) {
            this.f4914j.k(this);
        } else {
            q2.f4926j = this;
            q2.k = this.f4914j;
        }
        this.f4914j = null;
        q2.v(false);
        ActionBarContextView actionBarContextView = q2.f4922f;
        if (actionBarContextView.f2308p == null) {
            actionBarContextView.e();
        }
        q2.f4919c.setHideOnContentScrollEnabled(q2.f4937v);
        q2.f4925i = null;
    }

    @Override // m.AbstractC0438b
    public final View b() {
        WeakReference weakReference = this.k;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // m.AbstractC0438b
    public final n.n c() {
        return this.f4913i;
    }

    @Override // m.AbstractC0438b
    public final MenuInflater d() {
        return new m.j(this.f4912h);
    }

    @Override // m.AbstractC0438b
    public final CharSequence e() {
        return this.f4915l.f4922f.getSubtitle();
    }

    @Override // m.AbstractC0438b
    public final CharSequence f() {
        return this.f4915l.f4922f.getTitle();
    }

    @Override // m.AbstractC0438b
    public final void g() {
        if (this.f4915l.f4925i != this) {
            return;
        }
        n.n nVar = this.f4913i;
        nVar.w();
        try {
            this.f4914j.r(this, nVar);
        } finally {
            nVar.v();
        }
    }

    @Override // n.l
    public final boolean h(n.n nVar, MenuItem menuItem) {
        io.flutter.plugin.platform.s sVar = this.f4914j;
        if (sVar != null) {
            return ((InterfaceC0437a) sVar.f4390g).u(this, menuItem);
        }
        return false;
    }

    @Override // n.l
    public final void i(n.n nVar) {
        if (this.f4914j != null) {
            g();
            C0523j c0523j = this.f4915l.f4922f.f2302i;
            if (c0523j != null) {
                c0523j.l();
            }
        }
    }

    @Override // m.AbstractC0438b
    public final boolean j() {
        return this.f4915l.f4922f.f2316x;
    }

    @Override // m.AbstractC0438b
    public final void k(View view) {
        this.f4915l.f4922f.setCustomView(view);
        this.k = new WeakReference(view);
    }

    @Override // m.AbstractC0438b
    public final void l(int i4) {
        m(this.f4915l.f4917a.getResources().getString(i4));
    }

    @Override // m.AbstractC0438b
    public final void m(CharSequence charSequence) {
        this.f4915l.f4922f.setSubtitle(charSequence);
    }

    @Override // m.AbstractC0438b
    public final void n(int i4) {
        o(this.f4915l.f4917a.getResources().getString(i4));
    }

    @Override // m.AbstractC0438b
    public final void o(CharSequence charSequence) {
        this.f4915l.f4922f.setTitle(charSequence);
    }

    @Override // m.AbstractC0438b
    public final void p(boolean z) {
        this.f5132g = z;
        this.f4915l.f4922f.setTitleOptional(z);
    }
}
