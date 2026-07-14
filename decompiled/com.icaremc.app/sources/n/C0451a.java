package n;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0451a implements D.a {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f5231a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f5232b;

    /* renamed from: c, reason: collision with root package name */
    public Intent f5233c;

    /* renamed from: d, reason: collision with root package name */
    public char f5234d;

    /* renamed from: e, reason: collision with root package name */
    public int f5235e;

    /* renamed from: f, reason: collision with root package name */
    public char f5236f;

    /* renamed from: g, reason: collision with root package name */
    public int f5237g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f5238h;

    /* renamed from: i, reason: collision with root package name */
    public Context f5239i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f5240j;
    public CharSequence k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f5241l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f5242m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5243n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5244o;

    /* renamed from: p, reason: collision with root package name */
    public int f5245p;

    @Override // D.a
    public final D.a a(r rVar) {
        throw new UnsupportedOperationException();
    }

    @Override // D.a
    public final r b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f5238h;
        if (drawable != null) {
            if (this.f5243n || this.f5244o) {
                this.f5238h = drawable;
                Drawable mutate = drawable.mutate();
                this.f5238h = mutate;
                if (this.f5243n) {
                    mutate.setTintList(this.f5241l);
                }
                if (this.f5244o) {
                    this.f5238h.setTintMode(this.f5242m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f5237g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f5236f;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f5240j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f5238h;
    }

    @Override // D.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f5241l;
    }

    @Override // D.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f5242m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f5233c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f5235e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f5234d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5231a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5232b;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f5231a;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f5245p & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f5245p & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f5245p & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        if ((this.f5245p & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        this.f5236f = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.f5245p = (z ? 1 : 0) | (this.f5245p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i4;
        int i5 = this.f5245p & (-3);
        if (z) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        this.f5245p = i4 | i5;
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setContentDescription(CharSequence charSequence) {
        this.f5240j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        int i4;
        int i5 = this.f5245p & (-17);
        if (z) {
            i4 = 16;
        } else {
            i4 = 0;
        }
        this.f5245p = i4 | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5238h = drawable;
        c();
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5241l = colorStateList;
        this.f5243n = true;
        c();
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5242m = mode;
        this.f5244o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f5233c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        this.f5234d = c4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f5234d = c4;
        this.f5236f = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5231a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5232b = charSequence;
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setTooltipText(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i4 = 8;
        int i5 = this.f5245p & 8;
        if (z) {
            i4 = 0;
        }
        this.f5245p = i5 | i4;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        this.f5236f = Character.toLowerCase(c4);
        this.f5237g = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f5240j = charSequence;
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        this.f5234d = c4;
        this.f5235e = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        this.f5231a = this.f5239i.getResources().getString(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f5238h = this.f5239i.getDrawable(i4);
        c();
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f5234d = c4;
        this.f5235e = KeyEvent.normalizeMetaState(i4);
        this.f5236f = Character.toLowerCase(c5);
        this.f5237g = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        return this;
    }
}
