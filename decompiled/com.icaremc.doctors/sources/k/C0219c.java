package k;

import E.AbstractC0015o;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import l.k;

/* renamed from: k.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0219c {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f2741A;

    /* renamed from: D, reason: collision with root package name */
    public final /* synthetic */ C0220d f2744D;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f2745a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2752h;

    /* renamed from: i, reason: collision with root package name */
    public int f2753i;

    /* renamed from: j, reason: collision with root package name */
    public int f2754j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f2755k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2756l;

    /* renamed from: m, reason: collision with root package name */
    public int f2757m;

    /* renamed from: n, reason: collision with root package name */
    public char f2758n;

    /* renamed from: o, reason: collision with root package name */
    public int f2759o;
    public char p;
    public int q;

    /* renamed from: r, reason: collision with root package name */
    public int f2760r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2761s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2762t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2763u;

    /* renamed from: v, reason: collision with root package name */
    public int f2764v;

    /* renamed from: w, reason: collision with root package name */
    public int f2765w;

    /* renamed from: x, reason: collision with root package name */
    public String f2766x;
    public String y;
    public CharSequence z;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f2742B = null;

    /* renamed from: C, reason: collision with root package name */
    public PorterDuff.Mode f2743C = null;

    /* renamed from: b, reason: collision with root package name */
    public int f2746b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f2747c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f2748d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f2749e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2750f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2751g = true;

    public C0219c(C0220d c0220d, Menu menu) {
        this.f2744D = c0220d;
        this.f2745a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f2744D.f2771c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e2) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.view.MenuItem$OnMenuItemClickListener, java.lang.Object, k.b] */
    public final void b(MenuItem menuItem) {
        boolean z;
        MenuItem enabled = menuItem.setChecked(this.f2761s).setVisible(this.f2762t).setEnabled(this.f2763u);
        boolean z2 = false;
        if (this.f2760r >= 1) {
            z = true;
        } else {
            z = false;
        }
        enabled.setCheckable(z).setTitleCondensed(this.f2756l).setIcon(this.f2757m);
        int i2 = this.f2764v;
        if (i2 >= 0) {
            menuItem.setShowAsAction(i2);
        }
        String str = this.y;
        C0220d c0220d = this.f2744D;
        if (str != null) {
            if (!c0220d.f2771c.isRestricted()) {
                if (c0220d.f2772d == null) {
                    c0220d.f2772d = C0220d.a(c0220d.f2771c);
                }
                Object obj = c0220d.f2772d;
                String str2 = this.y;
                ?? obj2 = new Object();
                obj2.f2739a = obj;
                Class<?> cls = obj.getClass();
                try {
                    obj2.f2740b = cls.getMethod(str2, MenuItemOnMenuItemClickListenerC0218b.f2738c);
                    menuItem.setOnMenuItemClickListener(obj2);
                } catch (Exception e2) {
                    InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str2 + " in class " + cls.getName());
                    inflateException.initCause(e2);
                    throw inflateException;
                }
            } else {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
        }
        boolean z3 = menuItem instanceof k;
        if (z3) {
        }
        if (this.f2760r >= 2 && z3) {
            k kVar = (k) menuItem;
            kVar.f2882x = (kVar.f2882x & (-5)) | 4;
        }
        String str3 = this.f2766x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, C0220d.f2767e, c0220d.f2769a));
            z2 = true;
        }
        int i3 = this.f2765w;
        if (i3 > 0) {
            if (!z2) {
                menuItem.setActionView(i3);
            } else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        CharSequence charSequence = this.z;
        boolean z4 = menuItem instanceof k;
        if (z4) {
            ((k) menuItem).c(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0015o.m(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f2741A;
        if (z4) {
            ((k) menuItem).e(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0015o.u(menuItem, charSequence2);
        }
        char c2 = this.f2758n;
        int i4 = this.f2759o;
        if (z4) {
            ((k) menuItem).setAlphabeticShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0015o.j(menuItem, c2, i4);
        }
        char c3 = this.p;
        int i5 = this.q;
        if (z4) {
            ((k) menuItem).setNumericShortcut(c3, i5);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0015o.q(menuItem, c3, i5);
        }
        PorterDuff.Mode mode = this.f2743C;
        if (mode != null) {
            if (z4) {
                ((k) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC0015o.p(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f2742B;
        if (colorStateList != null) {
            if (z4) {
                ((k) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC0015o.o(menuItem, colorStateList);
            }
        }
    }
}
