package m;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import io.flutter.plugin.platform.s;
import java.lang.ref.WeakReference;
import o.C0523j;

/* loaded from: classes.dex */
public final class f extends AbstractC0438b implements n.l {

    /* renamed from: h, reason: collision with root package name */
    public Context f5139h;

    /* renamed from: i, reason: collision with root package name */
    public ActionBarContextView f5140i;

    /* renamed from: j, reason: collision with root package name */
    public s f5141j;
    public WeakReference k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5142l;

    /* renamed from: m, reason: collision with root package name */
    public n.n f5143m;

    @Override // m.AbstractC0438b
    public final void a() {
        if (this.f5142l) {
            return;
        }
        this.f5142l = true;
        this.f5141j.k(this);
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
        return this.f5143m;
    }

    @Override // m.AbstractC0438b
    public final MenuInflater d() {
        return new j(this.f5140i.getContext());
    }

    @Override // m.AbstractC0438b
    public final CharSequence e() {
        return this.f5140i.getSubtitle();
    }

    @Override // m.AbstractC0438b
    public final CharSequence f() {
        return this.f5140i.getTitle();
    }

    @Override // m.AbstractC0438b
    public final void g() {
        this.f5141j.r(this, this.f5143m);
    }

    @Override // n.l
    public final boolean h(n.n nVar, MenuItem menuItem) {
        return ((InterfaceC0437a) this.f5141j.f4390g).u(this, menuItem);
    }

    @Override // n.l
    public final void i(n.n nVar) {
        g();
        C0523j c0523j = this.f5140i.f2302i;
        if (c0523j != null) {
            c0523j.l();
        }
    }

    @Override // m.AbstractC0438b
    public final boolean j() {
        return this.f5140i.f2316x;
    }

    @Override // m.AbstractC0438b
    public final void k(View view) {
        WeakReference weakReference;
        this.f5140i.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference(view);
        } else {
            weakReference = null;
        }
        this.k = weakReference;
    }

    @Override // m.AbstractC0438b
    public final void l(int i4) {
        m(this.f5139h.getString(i4));
    }

    @Override // m.AbstractC0438b
    public final void m(CharSequence charSequence) {
        this.f5140i.setSubtitle(charSequence);
    }

    @Override // m.AbstractC0438b
    public final void n(int i4) {
        o(this.f5139h.getString(i4));
    }

    @Override // m.AbstractC0438b
    public final void o(CharSequence charSequence) {
        this.f5140i.setTitle(charSequence);
    }

    @Override // m.AbstractC0438b
    public final void p(boolean z) {
        this.f5132g = z;
        this.f5140i.setTitleOptional(z);
    }
}
