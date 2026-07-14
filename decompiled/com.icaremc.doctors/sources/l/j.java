package l;

import E.AbstractC0005e;
import E.K;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Build;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m.InterfaceC0264k;

/* loaded from: classes.dex */
public class j implements Menu {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f2840u = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f2841a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f2842b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2843c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2844d;

    /* renamed from: e, reason: collision with root package name */
    public F.h f2845e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2846f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2847g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2848h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f2849i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2850j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2851k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2852l;

    /* renamed from: s, reason: collision with root package name */
    public k f2857s;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2853m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2854n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2855o = false;
    public boolean p = false;
    public final ArrayList q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f2856r = new CopyOnWriteArrayList();

    /* renamed from: t, reason: collision with root package name */
    public boolean f2858t = false;

    public j(Context context) {
        boolean z;
        boolean z2 = false;
        this.f2841a = context;
        Resources resources = context.getResources();
        this.f2842b = resources;
        this.f2846f = new ArrayList();
        this.f2847g = new ArrayList();
        this.f2848h = true;
        this.f2849i = new ArrayList();
        this.f2850j = new ArrayList();
        this.f2851k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = K.f182a;
            if (Build.VERSION.SDK_INT >= 28) {
                z = AbstractC0005e.r(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                if (identifier != 0 && resources2.getBoolean(identifier)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                z2 = true;
            }
        }
        this.f2844d = z2;
    }

    public final k a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = ((-65536) & i4) >> 16;
        if (i6 >= 0 && i6 < 6) {
            int i7 = (f2840u[i6] << 16) | (65535 & i4);
            k kVar = new k(this, i2, i3, i4, i7, charSequence);
            ArrayList arrayList = this.f2846f;
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (((k) arrayList.get(size)).f2864d <= i7) {
                        i5 = size + 1;
                        break;
                    }
                    size--;
                } else {
                    i5 = 0;
                    break;
                }
            }
            arrayList.add(i5, kVar);
            o(true);
            return kVar;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        Intent intent2;
        int i7;
        PackageManager packageManager = this.f2841a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i6 = queryIntentActivityOptions.size();
        } else {
            i6 = 0;
        }
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i8 = 0; i8 < i6; i8++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            if (i9 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i9];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            k a2 = a(i2, i3, i4, resolveInfo.loadLabel(packageManager));
            a2.setIcon(resolveInfo.loadIcon(packageManager));
            a2.f2867g = intent3;
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = a2;
            }
        }
        return i6;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(p pVar, Context context) {
        this.f2856r.add(new WeakReference(pVar));
        pVar.f(context, this);
        this.f2851k = true;
    }

    public final void c(boolean z) {
        if (this.p) {
            return;
        }
        this.p = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2856r;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                pVar.a(this, z);
            }
        }
        this.p = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        k kVar = this.f2857s;
        if (kVar != null) {
            d(kVar);
        }
        this.f2846f.clear();
        o(true);
    }

    public final void clearHeader() {
        this.f2852l = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(k kVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2856r;
        boolean z = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f2857s == kVar) {
            s();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                p pVar = (p) weakReference.get();
                if (pVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z = pVar.j(kVar);
                    if (z) {
                        break;
                    }
                }
            }
            r();
            if (z) {
                this.f2857s = null;
            }
        }
        return z;
    }

    public boolean e(j jVar, MenuItem menuItem) {
        InterfaceC0264k interfaceC0264k;
        F.h hVar = this.f2845e;
        if (hVar != null && (interfaceC0264k = ((ActionMenuView) hVar.f274d).z) != null) {
            ((Toolbar) ((F.h) interfaceC0264k).f274d).getClass();
            return false;
        }
        return false;
    }

    public boolean f(k kVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2856r;
        boolean z = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        s();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z = pVar.e(kVar);
                if (z) {
                    break;
                }
            }
        }
        r();
        if (z) {
            this.f2857s = kVar;
        }
        return z;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i2) {
        MenuItem findItem;
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) arrayList.get(i3);
            if (kVar.f2861a == i2) {
                return kVar;
            }
            if (kVar.hasSubMenu() && (findItem = kVar.f2875o.findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final k g(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList arrayList = this.q;
        arrayList.clear();
        h(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (k) arrayList.get(0);
        }
        boolean m2 = m();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) arrayList.get(i3);
            if (m2) {
                c2 = kVar.f2870j;
            } else {
                c2 = kVar.f2868h;
            }
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (m2 && c2 == '\b' && i2 == 67))) {
                return kVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i2) {
        return (MenuItem) this.f2846f.get(i2);
    }

    public final void h(List list, int i2, KeyEvent keyEvent) {
        char c2;
        int i3;
        boolean m2 = m();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            ArrayList arrayList = this.f2846f;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                k kVar = (k) arrayList.get(i4);
                if (kVar.hasSubMenu()) {
                    kVar.f2875o.h(list, i2, keyEvent);
                }
                if (m2) {
                    c2 = kVar.f2870j;
                } else {
                    c2 = kVar.f2868h;
                }
                if (m2) {
                    i3 = kVar.f2871k;
                } else {
                    i3 = kVar.f2869i;
                }
                if ((modifiers & 69647) == (i3 & 69647) && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c2 == cArr[0] || c2 == cArr[2] || (m2 && c2 == '\b' && i2 == 67)) && kVar.isEnabled()) {
                        list.add(kVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((k) arrayList.get(i2)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList k2 = k();
        if (!this.f2851k) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2856r;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z |= pVar.g();
            }
        }
        ArrayList arrayList = this.f2849i;
        ArrayList arrayList2 = this.f2850j;
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            int size = k2.size();
            for (int i2 = 0; i2 < size; i2++) {
                k kVar = (k) k2.get(i2);
                if ((kVar.f2882x & 32) == 32) {
                    arrayList.add(kVar);
                } else {
                    arrayList2.add(kVar);
                }
            }
        } else {
            arrayList.clear();
            arrayList2.clear();
            arrayList2.addAll(k());
        }
        this.f2851k = false;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        if (g(i2, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public final ArrayList k() {
        boolean z = this.f2848h;
        ArrayList arrayList = this.f2847g;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f2846f;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = (k) arrayList2.get(i2);
            if (kVar.isVisible()) {
                arrayList.add(kVar);
            }
        }
        this.f2848h = false;
        this.f2851k = true;
        return arrayList;
    }

    public boolean l() {
        return this.f2858t;
    }

    public boolean m() {
        return this.f2843c;
    }

    public boolean n() {
        return this.f2844d;
    }

    public final void o(boolean z) {
        if (!this.f2853m) {
            if (z) {
                this.f2848h = true;
                this.f2851k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f2856r;
            if (!copyOnWriteArrayList.isEmpty()) {
                s();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    p pVar = (p) weakReference.get();
                    if (pVar == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        pVar.b();
                    }
                }
                r();
                return;
            }
            return;
        }
        this.f2854n = true;
        if (z) {
            this.f2855o = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MenuItem r6, l.l r7, int r8) {
        /*
            r5 = this;
            l.k r6 = (l.k) r6
            r0 = 0
            if (r6 == 0) goto Laf
            boolean r1 = r6.isEnabled()
            if (r1 != 0) goto Ld
            goto Laf
        Ld:
            l.j r1 = r6.f2874n
            android.view.MenuItem$OnMenuItemClickListener r2 = r6.p
            r3 = 1
            if (r2 == 0) goto L1c
            boolean r2 = r2.onMenuItemClick(r6)
            if (r2 == 0) goto L1c
        L1a:
            r1 = r3
            goto L36
        L1c:
            boolean r2 = r1.e(r1, r6)
            if (r2 == 0) goto L23
            goto L1a
        L23:
            android.content.Intent r2 = r6.f2867g
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f2841a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            r1 = r0
        L36:
            int r2 = r6.y
            r2 = r2 & 8
            if (r2 == 0) goto L4b
            android.view.View r2 = r6.z
            if (r2 == 0) goto L4b
            boolean r6 = r6.expandActionView()
            r1 = r1 | r6
            if (r1 == 0) goto Lae
            r5.c(r3)
            goto Lae
        L4b:
            boolean r2 = r6.hasSubMenu()
            if (r2 != 0) goto L59
            r6 = r8 & 1
            if (r6 != 0) goto Lae
            r5.c(r3)
            goto Lae
        L59:
            r8 = r8 & 4
            if (r8 != 0) goto L60
            r5.c(r0)
        L60:
            boolean r8 = r6.hasSubMenu()
            if (r8 != 0) goto L74
            l.t r8 = new l.t
            android.content.Context r2 = r5.f2841a
            r8.<init>(r2, r5, r6)
            r6.f2875o = r8
            java.lang.CharSequence r2 = r6.f2865e
            r8.setHeaderTitle(r2)
        L74:
            l.t r6 = r6.f2875o
            java.util.concurrent.CopyOnWriteArrayList r8 = r5.f2856r
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto L7f
            goto La8
        L7f:
            if (r7 == 0) goto L85
            boolean r0 = r7.h(r6)
        L85:
            java.util.Iterator r7 = r8.iterator()
        L89:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto La8
            java.lang.Object r2 = r7.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            l.p r4 = (l.p) r4
            if (r4 != 0) goto La1
            r8.remove(r2)
            goto L89
        La1:
            if (r0 != 0) goto L89
            boolean r0 = r4.h(r6)
            goto L89
        La8:
            r1 = r1 | r0
            if (r1 != 0) goto Lae
            r5.c(r3)
        Lae:
            return r1
        Laf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.j.p(android.view.MenuItem, l.l, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i2, int i3) {
        return p(findItem(i2), null, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        boolean z;
        k g2 = g(i2, keyEvent);
        if (g2 != null) {
            z = p(g2, null, i3);
        } else {
            z = false;
        }
        if ((i3 & 2) != 0) {
            c(true);
        }
        return z;
    }

    public final void q(int i2, CharSequence charSequence, int i3, View view) {
        if (view != null) {
            this.f2852l = null;
        } else {
            if (i2 > 0) {
                this.f2852l = this.f2842b.getText(i2);
            } else if (charSequence != null) {
                this.f2852l = charSequence;
            }
            if (i3 > 0) {
                this.f2841a.getDrawable(i3);
            }
        }
        o(false);
    }

    public final void r() {
        this.f2853m = false;
        if (this.f2854n) {
            this.f2854n = false;
            o(this.f2855o);
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i2) {
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                if (((k) arrayList.get(i4)).f2862b == i2) {
                    break;
                } else {
                    i4++;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 >= 0) {
            int size2 = arrayList.size() - i4;
            while (true) {
                int i5 = i3 + 1;
                if (i3 >= size2 || ((k) arrayList.get(i4)).f2862b != i2) {
                    break;
                }
                if (i4 >= 0) {
                    ArrayList arrayList2 = this.f2846f;
                    if (i4 < arrayList2.size()) {
                        arrayList2.remove(i4);
                    }
                }
                i3 = i5;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i2) {
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (((k) arrayList.get(i3)).f2861a == i2) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            ArrayList arrayList2 = this.f2846f;
            if (i3 < arrayList2.size()) {
                arrayList2.remove(i3);
                o(true);
            }
        }
    }

    public final void s() {
        if (!this.f2853m) {
            this.f2853m = true;
            this.f2854n = false;
            this.f2855o = false;
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i2, boolean z, boolean z2) {
        int i3;
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            k kVar = (k) arrayList.get(i4);
            if (kVar.f2862b == i2) {
                int i5 = kVar.f2882x & (-5);
                if (z2) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                kVar.f2882x = i5 | i3;
                kVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f2858t = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i2, boolean z) {
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) arrayList.get(i3);
            if (kVar.f2862b == i2) {
                kVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i2, boolean z) {
        int i3;
        ArrayList arrayList = this.f2846f;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            k kVar = (k) arrayList.get(i4);
            if (kVar.f2862b == i2) {
                int i5 = kVar.f2882x;
                int i6 = i5 & (-9);
                if (z) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                int i7 = i6 | i3;
                kVar.f2882x = i7;
                if (i5 != i7) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            o(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f2843c = z;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f2846f.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2) {
        return a(0, 0, 0, this.f2842b.getString(i2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f2842b.getString(i2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        k a2 = a(i2, i3, i4, charSequence);
        t tVar = new t(this.f2841a, this, a2);
        a2.f2875o = tVar;
        tVar.setHeaderTitle(a2.f2865e);
        return tVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f2842b.getString(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f2842b.getString(i5));
    }

    public j j() {
        return this;
    }
}
