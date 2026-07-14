package m;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import n.q;
import n.r;
import n.v;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f5149A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f5150B;

    /* renamed from: E, reason: collision with root package name */
    public final /* synthetic */ j f5153E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f5154a;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5161h;

    /* renamed from: i, reason: collision with root package name */
    public int f5162i;

    /* renamed from: j, reason: collision with root package name */
    public int f5163j;
    public CharSequence k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f5164l;

    /* renamed from: m, reason: collision with root package name */
    public int f5165m;

    /* renamed from: n, reason: collision with root package name */
    public char f5166n;

    /* renamed from: o, reason: collision with root package name */
    public int f5167o;

    /* renamed from: p, reason: collision with root package name */
    public char f5168p;

    /* renamed from: q, reason: collision with root package name */
    public int f5169q;

    /* renamed from: r, reason: collision with root package name */
    public int f5170r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5171s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5172t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5173u;

    /* renamed from: v, reason: collision with root package name */
    public int f5174v;

    /* renamed from: w, reason: collision with root package name */
    public int f5175w;

    /* renamed from: x, reason: collision with root package name */
    public String f5176x;

    /* renamed from: y, reason: collision with root package name */
    public String f5177y;
    public r z;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f5151C = null;

    /* renamed from: D, reason: collision with root package name */
    public PorterDuff.Mode f5152D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f5155b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f5156c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f5157d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f5158e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5159f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5160g = true;

    public i(j jVar, Menu menu) {
        this.f5153E = jVar;
        this.f5154a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f5153E.f5182c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e4) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e4);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [android.view.MenuItem$OnMenuItemClickListener, m.h, java.lang.Object] */
    public final void b(MenuItem menuItem) {
        boolean z;
        MenuItem enabled = menuItem.setChecked(this.f5171s).setVisible(this.f5172t).setEnabled(this.f5173u);
        boolean z3 = false;
        if (this.f5170r >= 1) {
            z = true;
        } else {
            z = false;
        }
        enabled.setCheckable(z).setTitleCondensed(this.f5164l).setIcon(this.f5165m);
        int i4 = this.f5174v;
        if (i4 >= 0) {
            menuItem.setShowAsAction(i4);
        }
        String str = this.f5177y;
        j jVar = this.f5153E;
        if (str != null) {
            if (!jVar.f5182c.isRestricted()) {
                if (jVar.f5183d == null) {
                    jVar.f5183d = j.a(jVar.f5182c);
                }
                Object obj = jVar.f5183d;
                String str2 = this.f5177y;
                ?? obj2 = new Object();
                obj2.f5147a = obj;
                Class<?> cls = obj.getClass();
                try {
                    obj2.f5148b = cls.getMethod(str2, h.f5146c);
                    menuItem.setOnMenuItemClickListener(obj2);
                } catch (Exception e4) {
                    InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str2 + " in class " + cls.getName());
                    inflateException.initCause(e4);
                    throw inflateException;
                }
            } else {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
        }
        if (this.f5170r >= 2) {
            if (menuItem instanceof q) {
                q qVar = (q) menuItem;
                qVar.f5348x = (qVar.f5348x & (-5)) | 4;
            } else if (menuItem instanceof v) {
                v vVar = (v) menuItem;
                D.a aVar = vVar.f5357c;
                try {
                    if (vVar.f5358d == null) {
                        vVar.f5358d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    vVar.f5358d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e5) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e5);
                }
            }
        }
        String str3 = this.f5176x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, j.f5178e, jVar.f5180a));
            z3 = true;
        }
        int i5 = this.f5175w;
        if (i5 > 0) {
            if (!z3) {
                menuItem.setActionView(i5);
            } else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        r rVar = this.z;
        if (rVar != null) {
            if (menuItem instanceof D.a) {
                ((D.a) menuItem).a(rVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.f5149A;
        boolean z4 = menuItem instanceof D.a;
        if (z4) {
            ((D.a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            C.a.m(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f5150B;
        if (z4) {
            ((D.a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            C.a.u(menuItem, charSequence2);
        }
        char c4 = this.f5166n;
        int i6 = this.f5167o;
        if (z4) {
            ((D.a) menuItem).setAlphabeticShortcut(c4, i6);
        } else if (Build.VERSION.SDK_INT >= 26) {
            C.a.j(menuItem, c4, i6);
        }
        char c5 = this.f5168p;
        int i7 = this.f5169q;
        if (z4) {
            ((D.a) menuItem).setNumericShortcut(c5, i7);
        } else if (Build.VERSION.SDK_INT >= 26) {
            C.a.q(menuItem, c5, i7);
        }
        PorterDuff.Mode mode = this.f5152D;
        if (mode != null) {
            if (z4) {
                ((D.a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                C.a.p(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f5151C;
        if (colorStateList != null) {
            if (z4) {
                ((D.a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                C.a.o(menuItem, colorStateList);
            }
        }
    }
}
