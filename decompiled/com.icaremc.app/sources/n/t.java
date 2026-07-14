package n;

import android.view.MenuItem;

/* loaded from: classes.dex */
public final class t implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f5353a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f5354b;

    public t(v vVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5354b = vVar;
        this.f5353a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f5353a.onMenuItemActionCollapse(this.f5354b.f(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f5353a.onMenuItemActionExpand(this.f5354b.f(menuItem));
    }
}
