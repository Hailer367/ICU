package l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public final class t extends j implements SubMenu {

    /* renamed from: v, reason: collision with root package name */
    public final j f2913v;

    /* renamed from: w, reason: collision with root package name */
    public final k f2914w;

    public t(Context context, j jVar, k kVar) {
        super(context);
        this.f2913v = jVar;
        this.f2914w = kVar;
    }

    @Override // l.j
    public final boolean d(k kVar) {
        return this.f2913v.d(kVar);
    }

    @Override // l.j
    public final boolean e(j jVar, MenuItem menuItem) {
        super.e(jVar, menuItem);
        if (this.f2913v.e(jVar, menuItem)) {
            return true;
        }
        return false;
    }

    @Override // l.j
    public final boolean f(k kVar) {
        return this.f2913v.f(kVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f2914w;
    }

    @Override // l.j
    public final j j() {
        return this.f2913v.j();
    }

    @Override // l.j
    public final boolean l() {
        return this.f2913v.l();
    }

    @Override // l.j
    public final boolean m() {
        return this.f2913v.m();
    }

    @Override // l.j
    public final boolean n() {
        return this.f2913v.n();
    }

    @Override // l.j, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.f2913v.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        q(0, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        q(0, charSequence, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        q(0, null, 0, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f2914w.setIcon(drawable);
        return this;
    }

    @Override // l.j, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f2913v.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i2) {
        q(0, null, i2, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i2) {
        q(i2, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i2) {
        this.f2914w.setIcon(i2);
        return this;
    }
}
