package l;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import i.AbstractC0203a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k implements MenuItem {

    /* renamed from: A, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f2859A;

    /* renamed from: a, reason: collision with root package name */
    public final int f2861a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2862b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2863c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2864d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f2865e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f2866f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f2867g;

    /* renamed from: h, reason: collision with root package name */
    public char f2868h;

    /* renamed from: j, reason: collision with root package name */
    public char f2870j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f2872l;

    /* renamed from: n, reason: collision with root package name */
    public final j f2874n;

    /* renamed from: o, reason: collision with root package name */
    public t f2875o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f2876r;
    public View z;

    /* renamed from: i, reason: collision with root package name */
    public int f2869i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f2871k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f2873m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f2877s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f2878t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2879u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2880v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2881w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f2882x = 16;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2860B = false;
    public int y = 0;

    public k(j jVar, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f2874n = jVar;
        this.f2861a = i3;
        this.f2862b = i2;
        this.f2863c = i4;
        this.f2864d = i5;
        this.f2865e = charSequence;
    }

    public static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    public final Drawable b(Drawable drawable) {
        if (drawable != null && this.f2881w && (this.f2879u || this.f2880v)) {
            drawable = drawable.mutate();
            if (this.f2879u) {
                drawable.setTintList(this.f2877s);
            }
            if (this.f2880v) {
                drawable.setTintMode(this.f2878t);
            }
            this.f2881w = false;
        }
        return drawable;
    }

    public final k c(CharSequence charSequence) {
        this.q = charSequence;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f2859A;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f2874n.d(this);
    }

    public final void d(boolean z) {
        if (z) {
            this.f2882x |= 32;
        } else {
            this.f2882x &= -33;
        }
    }

    public final k e(CharSequence charSequence) {
        this.f2876r = charSequence;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if ((this.y & 8) != 0 && this.z != null) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.f2859A;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.f2874n.f(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f2871k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f2870j;
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f2862b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f2872l;
        if (drawable != null) {
            return b(drawable);
        }
        int i2 = this.f2873m;
        if (i2 != 0) {
            Drawable a2 = AbstractC0203a.a(this.f2874n.f2841a, i2);
            this.f2873m = 0;
            this.f2872l = a2;
            return b(a2);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f2877s;
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f2878t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f2867g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f2861a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f2869i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f2868h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f2863c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f2875o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f2865e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2866f;
        if (charSequence == null) {
            return this.f2865e;
        }
        return charSequence;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f2876r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        if (this.f2875o != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f2860B;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f2882x & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f2882x & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f2882x & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        if ((this.f2882x & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i2;
        this.z = view;
        if (view != null && view.getId() == -1 && (i2 = this.f2861a) > 0) {
            view.setId(i2);
        }
        j jVar = this.f2874n;
        jVar.f2851k = true;
        jVar.o(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.f2870j == c2) {
            return this;
        }
        this.f2870j = Character.toLowerCase(c2);
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i2 = this.f2882x;
        int i3 = (z ? 1 : 0) | (i2 & (-2));
        this.f2882x = i3;
        if (i2 != i3) {
            this.f2874n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        boolean z2;
        int i2;
        int i3 = this.f2882x;
        int i4 = 2;
        if ((i3 & 4) != 0) {
            j jVar = this.f2874n;
            ArrayList arrayList = jVar.f2846f;
            int size = arrayList.size();
            jVar.s();
            for (int i5 = 0; i5 < size; i5++) {
                k kVar = (k) arrayList.get(i5);
                if (kVar.f2862b == this.f2862b && (kVar.f2882x & 4) != 0 && kVar.isCheckable()) {
                    if (kVar == this) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i6 = kVar.f2882x;
                    int i7 = i6 & (-3);
                    if (z2) {
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    int i8 = i2 | i7;
                    kVar.f2882x = i8;
                    if (i6 != i8) {
                        kVar.f2874n.o(false);
                    }
                }
            }
            jVar.r();
            return this;
        }
        int i9 = i3 & (-3);
        if (!z) {
            i4 = 0;
        }
        int i10 = i9 | i4;
        this.f2882x = i10;
        if (i3 != i10) {
            this.f2874n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        c(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2882x |= 16;
        } else {
            this.f2882x &= -17;
        }
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f2873m = 0;
        this.f2872l = drawable;
        this.f2881w = true;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2877s = colorStateList;
        this.f2879u = true;
        this.f2881w = true;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2878t = mode;
        this.f2880v = true;
        this.f2881w = true;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f2867g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        if (this.f2868h == c2) {
            return this;
        }
        this.f2868h = c2;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f2859A = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3) {
        this.f2868h = c2;
        this.f2870j = Character.toLowerCase(c3);
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = i2;
        j jVar = this.f2874n;
        jVar.f2851k = true;
        jVar.o(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f2865e = charSequence;
        this.f2874n.o(false);
        t tVar = this.f2875o;
        if (tVar != null) {
            tVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2866f = charSequence;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        e(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i2;
        int i3 = this.f2882x;
        int i4 = i3 & (-9);
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        int i5 = i2 | i4;
        this.f2882x = i5;
        if (i3 != i5) {
            j jVar = this.f2874n;
            jVar.f2848h = true;
            jVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f2865e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f2870j == c2 && this.f2871k == i2) {
            return this;
        }
        this.f2870j = Character.toLowerCase(c2);
        this.f2871k = KeyEvent.normalizeMetaState(i2);
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f2868h == c2 && this.f2869i == i2) {
            return this;
        }
        this.f2868h = c2;
        this.f2869i = KeyEvent.normalizeMetaState(i2);
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f2868h = c2;
        this.f2869i = KeyEvent.normalizeMetaState(i2);
        this.f2870j = Character.toLowerCase(c3);
        this.f2871k = KeyEvent.normalizeMetaState(i3);
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.f2872l = null;
        this.f2873m = i2;
        this.f2881w = true;
        this.f2874n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        setTitle(this.f2874n.f2841a.getString(i2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        int i3;
        Context context = this.f2874n.f2841a;
        View inflate = LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false);
        this.z = inflate;
        if (inflate != null && inflate.getId() == -1 && (i3 = this.f2861a) > 0) {
            inflate.setId(i3);
        }
        j jVar = this.f2874n;
        jVar.f2851k = true;
        jVar.o(true);
        return this;
    }
}
