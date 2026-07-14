package n;

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
import f1.AbstractC0286a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class q implements D.a {

    /* renamed from: A, reason: collision with root package name */
    public r f5323A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f5324B;

    /* renamed from: a, reason: collision with root package name */
    public final int f5326a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5327b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5328c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5329d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f5330e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f5331f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f5332g;

    /* renamed from: h, reason: collision with root package name */
    public char f5333h;

    /* renamed from: j, reason: collision with root package name */
    public char f5335j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f5336l;

    /* renamed from: n, reason: collision with root package name */
    public final n f5338n;

    /* renamed from: o, reason: collision with root package name */
    public H f5339o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f5340p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f5341q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f5342r;

    /* renamed from: y, reason: collision with root package name */
    public int f5349y;
    public View z;

    /* renamed from: i, reason: collision with root package name */
    public int f5334i = 4096;
    public int k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f5337m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f5343s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f5344t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5345u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5346v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5347w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f5348x = 16;

    /* renamed from: C, reason: collision with root package name */
    public boolean f5325C = false;

    public q(n nVar, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        this.f5338n = nVar;
        this.f5326a = i5;
        this.f5327b = i4;
        this.f5328c = i6;
        this.f5329d = i7;
        this.f5330e = charSequence;
        this.f5349y = i8;
    }

    public static void c(StringBuilder sb, int i4, int i5, String str) {
        if ((i4 & i5) == i5) {
            sb.append(str);
        }
    }

    @Override // D.a
    public final D.a a(r rVar) {
        this.z = null;
        this.f5323A = rVar;
        this.f5338n.p(true);
        r rVar2 = this.f5323A;
        if (rVar2 != null) {
            rVar2.f5351b = new p(0, this);
            rVar2.f5350a.setVisibilityListener(rVar2);
        }
        return this;
    }

    @Override // D.a
    public final r b() {
        return this.f5323A;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f5349y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f5324B;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f5338n.d(this);
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f5347w && (this.f5345u || this.f5346v)) {
            drawable = drawable.mutate();
            if (this.f5345u) {
                drawable.setTintList(this.f5343s);
            }
            if (this.f5346v) {
                drawable.setTintMode(this.f5344t);
            }
            this.f5347w = false;
        }
        return drawable;
    }

    public final boolean e() {
        r rVar;
        if ((this.f5349y & 8) != 0) {
            if (this.z == null && (rVar = this.f5323A) != null) {
                this.z = rVar.a(this);
            }
            if (this.z != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (e()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.f5324B;
            if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
                return false;
            }
            return this.f5338n.f(this);
        }
        return false;
    }

    public final void f(boolean z) {
        if (z) {
            this.f5348x |= 32;
        } else {
            this.f5348x &= -33;
        }
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
        r rVar = this.f5323A;
        if (rVar != null) {
            View a4 = rVar.a(this);
            this.z = a4;
            return a4;
        }
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f5335j;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f5341q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f5327b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f5336l;
        if (drawable != null) {
            return d(drawable);
        }
        int i4 = this.f5337m;
        if (i4 != 0) {
            Drawable o3 = AbstractC0286a.o(this.f5338n.f5294a, i4);
            this.f5337m = 0;
            this.f5336l = o3;
            return d(o3);
        }
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f5343s;
    }

    @Override // D.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f5344t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f5332g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f5326a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f5334i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f5333h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f5328c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f5339o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f5330e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5331f;
        if (charSequence == null) {
            return this.f5330e;
        }
        return charSequence;
    }

    @Override // D.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f5342r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        if (this.f5339o != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f5325C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        if ((this.f5348x & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        if ((this.f5348x & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        if ((this.f5348x & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        r rVar = this.f5323A;
        if (rVar != null && rVar.f5350a.overridesItemVisibility()) {
            if ((this.f5348x & 8) == 0 && this.f5323A.f5350a.isVisible()) {
                return true;
            }
            return false;
        }
        if ((this.f5348x & 8) == 0) {
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
        int i4;
        this.z = view;
        this.f5323A = null;
        if (view != null && view.getId() == -1 && (i4 = this.f5326a) > 0) {
            view.setId(i4);
        }
        n nVar = this.f5338n;
        nVar.k = true;
        nVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4) {
        if (this.f5335j == c4) {
            return this;
        }
        this.f5335j = Character.toLowerCase(c4);
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i4 = this.f5348x;
        int i5 = (z ? 1 : 0) | (i4 & (-2));
        this.f5348x = i5;
        if (i4 != i5) {
            this.f5338n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        boolean z3;
        int i4;
        int i5 = this.f5348x;
        int i6 = 2;
        if ((i5 & 4) != 0) {
            n nVar = this.f5338n;
            ArrayList arrayList = nVar.f5299f;
            int size = arrayList.size();
            nVar.w();
            for (int i7 = 0; i7 < size; i7++) {
                q qVar = (q) arrayList.get(i7);
                if (qVar.f5327b == this.f5327b && (qVar.f5348x & 4) != 0 && qVar.isCheckable()) {
                    if (qVar == this) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i8 = qVar.f5348x;
                    int i9 = i8 & (-3);
                    if (z3) {
                        i4 = 2;
                    } else {
                        i4 = 0;
                    }
                    int i10 = i4 | i9;
                    qVar.f5348x = i10;
                    if (i8 != i10) {
                        qVar.f5338n.p(false);
                    }
                }
            }
            nVar.v();
            return this;
        }
        int i11 = i5 & (-3);
        if (!z) {
            i6 = 0;
        }
        int i12 = i11 | i6;
        this.f5348x = i12;
        if (i5 != i12) {
            this.f5338n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.f5348x |= 16;
        } else {
            this.f5348x &= -17;
        }
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f5337m = 0;
        this.f5336l = drawable;
        this.f5347w = true;
        this.f5338n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5343s = colorStateList;
        this.f5345u = true;
        this.f5347w = true;
        this.f5338n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5344t = mode;
        this.f5346v = true;
        this.f5347w = true;
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f5332g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4) {
        if (this.f5333h == c4) {
            return this;
        }
        this.f5333h = c4;
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5324B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5340p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5) {
        this.f5333h = c4;
        this.f5335j = Character.toLowerCase(c5);
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f5349y = i4;
        n nVar = this.f5338n;
        nVar.k = true;
        nVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f5330e = charSequence;
        this.f5338n.p(false);
        H h3 = this.f5339o;
        if (h3 != null) {
            h3.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5331f = charSequence;
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i4;
        int i5 = this.f5348x;
        int i6 = i5 & (-9);
        if (z) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        int i7 = i4 | i6;
        this.f5348x = i7;
        if (i5 != i7) {
            n nVar = this.f5338n;
            nVar.f5301h = true;
            nVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f5330e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setContentDescription(CharSequence charSequence) {
        this.f5341q = charSequence;
        this.f5338n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final D.a setTooltipText(CharSequence charSequence) {
        this.f5342r = charSequence;
        this.f5338n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c4, int i4) {
        if (this.f5335j == c4 && this.k == i4) {
            return this;
        }
        this.f5335j = Character.toLowerCase(c4);
        this.k = KeyEvent.normalizeMetaState(i4);
        this.f5338n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c4, int i4) {
        if (this.f5333h == c4 && this.f5334i == i4) {
            return this;
        }
        this.f5333h = c4;
        this.f5334i = KeyEvent.normalizeMetaState(i4);
        this.f5338n.p(false);
        return this;
    }

    @Override // D.a, android.view.MenuItem
    public final MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f5333h = c4;
        this.f5334i = KeyEvent.normalizeMetaState(i4);
        this.f5335j = Character.toLowerCase(c5);
        this.k = KeyEvent.normalizeMetaState(i5);
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i4) {
        this.f5336l = null;
        this.f5337m = i4;
        this.f5347w = true;
        this.f5338n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i4) {
        setTitle(this.f5338n.f5294a.getString(i4));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i4) {
        int i5;
        Context context = this.f5338n.f5294a;
        View inflate = LayoutInflater.from(context).inflate(i4, (ViewGroup) new LinearLayout(context), false);
        this.z = inflate;
        this.f5323A = null;
        if (inflate != null && inflate.getId() == -1 && (i5 = this.f5326a) > 0) {
            inflate.setId(i5);
        }
        n nVar = this.f5338n;
        nVar.k = true;
        nVar.p(true);
        return this;
    }
}
