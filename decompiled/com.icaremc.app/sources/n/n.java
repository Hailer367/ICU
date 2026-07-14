package n;

import I.U;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class n implements Menu {
    public static final int[] z = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f5294a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f5295b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5296c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5297d;

    /* renamed from: e, reason: collision with root package name */
    public l f5298e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f5299f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f5300g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5301h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f5302i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f5303j;
    public boolean k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f5305m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f5306n;

    /* renamed from: o, reason: collision with root package name */
    public View f5307o;

    /* renamed from: w, reason: collision with root package name */
    public q f5315w;

    /* renamed from: y, reason: collision with root package name */
    public boolean f5317y;

    /* renamed from: l, reason: collision with root package name */
    public int f5304l = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5308p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5309q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5310r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5311s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5312t = false;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f5313u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList f5314v = new CopyOnWriteArrayList();

    /* renamed from: x, reason: collision with root package name */
    public boolean f5316x = false;

    public n(Context context) {
        boolean z3;
        boolean z4 = false;
        this.f5294a = context;
        Resources resources = context.getResources();
        this.f5295b = resources;
        this.f5299f = new ArrayList();
        this.f5300g = new ArrayList();
        this.f5301h = true;
        this.f5302i = new ArrayList();
        this.f5303j = new ArrayList();
        this.k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = U.f707a;
            if (Build.VERSION.SDK_INT >= 28) {
                z3 = C.b.s(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                if (identifier != 0 && resources2.getBoolean(identifier)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                z4 = true;
            }
        }
        this.f5297d = z4;
    }

    public final q a(int i4, int i5, int i6, CharSequence charSequence) {
        int i7;
        int i8 = ((-65536) & i6) >> 16;
        if (i8 >= 0 && i8 < 6) {
            int i9 = (z[i8] << 16) | (65535 & i6);
            q qVar = new q(this, i4, i5, i6, i9, charSequence, this.f5304l);
            ArrayList arrayList = this.f5299f;
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (((q) arrayList.get(size)).f5329d <= i9) {
                        i7 = size + 1;
                        break;
                    }
                    size--;
                } else {
                    i7 = 0;
                    break;
                }
            }
            arrayList.add(i7, qVar);
            p(true);
            return qVar;
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        int i8;
        Intent intent2;
        int i9;
        PackageManager packageManager = this.f5294a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i8 = queryIntentActivityOptions.size();
        } else {
            i8 = 0;
        }
        if ((i7 & 1) == 0) {
            removeGroup(i4);
        }
        for (int i10 = 0; i10 < i8; i10++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            if (i11 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i11];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            q a4 = a(i4, i5, i6, resolveInfo.loadLabel(packageManager));
            a4.setIcon(resolveInfo.loadIcon(packageManager));
            a4.f5332g = intent3;
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = a4;
            }
        }
        return i8;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(InterfaceC0449B interfaceC0449B, Context context) {
        this.f5314v.add(new WeakReference(interfaceC0449B));
        interfaceC0449B.g(context, this);
        this.k = true;
    }

    public final void c(boolean z3) {
        if (this.f5312t) {
            return;
        }
        this.f5312t = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5314v;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0449B interfaceC0449B = (InterfaceC0449B) weakReference.get();
            if (interfaceC0449B == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC0449B.a(this, z3);
            }
        }
        this.f5312t = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        q qVar = this.f5315w;
        if (qVar != null) {
            d(qVar);
        }
        this.f5299f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f5306n = null;
        this.f5305m = null;
        this.f5307o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5314v;
        boolean z3 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f5315w == qVar) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                InterfaceC0449B interfaceC0449B = (InterfaceC0449B) weakReference.get();
                if (interfaceC0449B == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z3 = interfaceC0449B.k(qVar);
                    if (z3) {
                        break;
                    }
                }
            }
            v();
            if (z3) {
                this.f5315w = null;
            }
        }
        return z3;
    }

    public boolean e(n nVar, MenuItem menuItem) {
        l lVar = this.f5298e;
        if (lVar != null && lVar.h(nVar, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean f(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5314v;
        boolean z3 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0449B interfaceC0449B = (InterfaceC0449B) weakReference.get();
            if (interfaceC0449B == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z3 = interfaceC0449B.e(qVar);
                if (z3) {
                    break;
                }
            }
        }
        v();
        if (z3) {
            this.f5315w = qVar;
        }
        return z3;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i4) {
        MenuItem findItem;
        ArrayList arrayList = this.f5299f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            q qVar = (q) arrayList.get(i5);
            if (qVar.f5326a == i4) {
                return qVar;
            }
            if (qVar.hasSubMenu() && (findItem = qVar.f5339o.findItem(i4)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final q g(int i4, KeyEvent keyEvent) {
        char c4;
        ArrayList arrayList = this.f5313u;
        arrayList.clear();
        h(arrayList, i4, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (q) arrayList.get(0);
        }
        boolean n3 = n();
        for (int i5 = 0; i5 < size; i5++) {
            q qVar = (q) arrayList.get(i5);
            if (n3) {
                c4 = qVar.f5335j;
            } else {
                c4 = qVar.f5333h;
            }
            char[] cArr = keyData.meta;
            if ((c4 == cArr[0] && (metaState & 2) == 0) || ((c4 == cArr[2] && (metaState & 2) != 0) || (n3 && c4 == '\b' && i4 == 67))) {
                return qVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i4) {
        return (MenuItem) this.f5299f.get(i4);
    }

    public final void h(List list, int i4, KeyEvent keyEvent) {
        char c4;
        int i5;
        boolean n3 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i4 == 67) {
            ArrayList arrayList = this.f5299f;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                q qVar = (q) arrayList.get(i6);
                if (qVar.hasSubMenu()) {
                    qVar.f5339o.h(list, i4, keyEvent);
                }
                if (n3) {
                    c4 = qVar.f5335j;
                } else {
                    c4 = qVar.f5333h;
                }
                if (n3) {
                    i5 = qVar.k;
                } else {
                    i5 = qVar.f5334i;
                }
                if ((modifiers & 69647) == (i5 & 69647) && c4 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c4 == cArr[0] || c4 == cArr[2] || (n3 && c4 == '\b' && i4 == 67)) && qVar.isEnabled()) {
                        list.add(qVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (!this.f5317y) {
            ArrayList arrayList = this.f5299f;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((q) arrayList.get(i4)).isVisible()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void i() {
        ArrayList l3 = l();
        if (!this.k) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5314v;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0449B interfaceC0449B = (InterfaceC0449B) weakReference.get();
            if (interfaceC0449B == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z3 |= interfaceC0449B.i();
            }
        }
        ArrayList arrayList = this.f5302i;
        ArrayList arrayList2 = this.f5303j;
        if (z3) {
            arrayList.clear();
            arrayList2.clear();
            int size = l3.size();
            for (int i4 = 0; i4 < size; i4++) {
                q qVar = (q) l3.get(i4);
                if ((qVar.f5348x & 32) == 32) {
                    arrayList.add(qVar);
                } else {
                    arrayList2.add(qVar);
                }
            }
        } else {
            arrayList.clear();
            arrayList2.clear();
            arrayList2.addAll(l());
        }
        this.k = false;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        if (g(i4, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z3 = this.f5301h;
        ArrayList arrayList = this.f5300g;
        if (!z3) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f5299f;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            q qVar = (q) arrayList2.get(i4);
            if (qVar.isVisible()) {
                arrayList.add(qVar);
            }
        }
        this.f5301h = false;
        this.k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f5316x;
    }

    public boolean n() {
        return this.f5296c;
    }

    public boolean o() {
        return this.f5297d;
    }

    public final void p(boolean z3) {
        if (!this.f5308p) {
            if (z3) {
                this.f5301h = true;
                this.k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f5314v;
            if (!copyOnWriteArrayList.isEmpty()) {
                w();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    InterfaceC0449B interfaceC0449B = (InterfaceC0449B) weakReference.get();
                    if (interfaceC0449B == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        interfaceC0449B.d();
                    }
                }
                v();
                return;
            }
            return;
        }
        this.f5309q = true;
        if (z3) {
            this.f5310r = true;
        }
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i4, int i5) {
        return q(findItem(i4), null, i5);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        boolean z3;
        q g4 = g(i4, keyEvent);
        if (g4 != null) {
            z3 = q(g4, null, i5);
        } else {
            z3 = false;
        }
        if ((i5 & 2) != 0) {
            c(true);
        }
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, n.InterfaceC0449B r8, int r9) {
        /*
            r6 = this;
            n.q r7 = (n.q) r7
            r0 = 0
            if (r7 == 0) goto Ld2
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ld2
        Ld:
            n.n r1 = r7.f5338n
            android.view.MenuItem$OnMenuItemClickListener r2 = r7.f5340p
            r3 = 1
            if (r2 == 0) goto L1c
            boolean r2 = r2.onMenuItemClick(r7)
            if (r2 == 0) goto L1c
        L1a:
            r1 = r3
            goto L43
        L1c:
            boolean r2 = r1.e(r1, r7)
            if (r2 == 0) goto L23
            goto L1a
        L23:
            android.content.Intent r2 = r7.f5332g
            if (r2 == 0) goto L35
            android.content.Context r1 = r1.f5294a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r2)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L1a
        L2d:
            r1 = move-exception
            java.lang.String r2 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r2, r4, r1)
        L35:
            n.r r1 = r7.f5323A
            if (r1 == 0) goto L42
            android.view.ActionProvider r1 = r1.f5350a
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L42
            goto L1a
        L42:
            r1 = r0
        L43:
            n.r r2 = r7.f5323A
            if (r2 == 0) goto L51
            android.view.ActionProvider r4 = r2.f5350a
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L51
            r4 = r3
            goto L52
        L51:
            r4 = r0
        L52:
            boolean r5 = r7.e()
            if (r5 == 0) goto L64
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld1
            r6.c(r3)
            goto Ld1
        L64:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L75
            if (r4 == 0) goto L6d
            goto L75
        L6d:
            r7 = r9 & 1
            if (r7 != 0) goto Ld1
            r6.c(r3)
            goto Ld1
        L75:
            r9 = r9 & 4
            if (r9 != 0) goto L7c
            r6.c(r0)
        L7c:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L90
            n.H r9 = new n.H
            android.content.Context r5 = r6.f5294a
            r9.<init>(r5, r6, r7)
            r7.f5339o = r9
            java.lang.CharSequence r5 = r7.f5330e
            r9.setHeaderTitle(r5)
        L90:
            n.H r7 = r7.f5339o
            if (r4 == 0) goto L99
            android.view.ActionProvider r9 = r2.f5350a
            r9.onPrepareSubMenu(r7)
        L99:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f5314v
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto La2
            goto Lcb
        La2:
            if (r8 == 0) goto La8
            boolean r0 = r8.h(r7)
        La8:
            java.util.Iterator r8 = r9.iterator()
        Lac:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lcb
            java.lang.Object r2 = r8.next()
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            java.lang.Object r4 = r2.get()
            n.B r4 = (n.InterfaceC0449B) r4
            if (r4 != 0) goto Lc4
            r9.remove(r2)
            goto Lac
        Lc4:
            if (r0 != 0) goto Lac
            boolean r0 = r4.h(r7)
            goto Lac
        Lcb:
            r1 = r1 | r0
            if (r1 != 0) goto Ld1
            r6.c(r3)
        Ld1:
            return r1
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n.n.q(android.view.MenuItem, n.B, int):boolean");
    }

    public final void r(InterfaceC0449B interfaceC0449B) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5314v;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            InterfaceC0449B interfaceC0449B2 = (InterfaceC0449B) weakReference.get();
            if (interfaceC0449B2 == null || interfaceC0449B2 == interfaceC0449B) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i4) {
        ArrayList arrayList = this.f5299f;
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 < size) {
                if (((q) arrayList.get(i6)).f5327b == i4) {
                    break;
                } else {
                    i6++;
                }
            } else {
                i6 = -1;
                break;
            }
        }
        if (i6 >= 0) {
            int size2 = arrayList.size() - i6;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= size2 || ((q) arrayList.get(i6)).f5327b != i4) {
                    break;
                }
                if (i6 >= 0) {
                    ArrayList arrayList2 = this.f5299f;
                    if (i6 < arrayList2.size()) {
                        arrayList2.remove(i6);
                    }
                }
                i5 = i7;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i4) {
        ArrayList arrayList = this.f5299f;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                if (((q) arrayList.get(i5)).f5326a == i4) {
                    break;
                } else {
                    i5++;
                }
            } else {
                i5 = -1;
                break;
            }
        }
        if (i5 >= 0) {
            ArrayList arrayList2 = this.f5299f;
            if (i5 < arrayList2.size()) {
                arrayList2.remove(i5);
                p(true);
            }
        }
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = this.f5299f.size();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItem item = getItem(i4);
                View actionView = item.getActionView();
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((H) item.getSubMenu()).s(bundle);
                }
            }
            int i5 = bundle.getInt("android:menu:expandedactionview");
            if (i5 > 0 && (findItem = findItem(i5)) != null) {
                findItem.expandActionView();
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i4, boolean z3, boolean z4) {
        int i5;
        ArrayList arrayList = this.f5299f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.f5327b == i4) {
                int i7 = qVar.f5348x & (-5);
                if (z4) {
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                qVar.f5348x = i7 | i5;
                qVar.setCheckable(z3);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z3) {
        this.f5316x = z3;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i4, boolean z3) {
        ArrayList arrayList = this.f5299f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            q qVar = (q) arrayList.get(i5);
            if (qVar.f5327b == i4) {
                qVar.setEnabled(z3);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i4, boolean z3) {
        int i5;
        ArrayList arrayList = this.f5299f;
        int size = arrayList.size();
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) arrayList.get(i6);
            if (qVar.f5327b == i4) {
                int i7 = qVar.f5348x;
                int i8 = i7 & (-9);
                if (z3) {
                    i5 = 0;
                } else {
                    i5 = 8;
                }
                int i9 = i8 | i5;
                qVar.f5348x = i9;
                if (i7 != i9) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.f5296c = z3;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5299f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f5299f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((H) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i4, CharSequence charSequence, int i5, Drawable drawable, View view) {
        if (view != null) {
            this.f5307o = view;
            this.f5305m = null;
            this.f5306n = null;
        } else {
            if (i4 > 0) {
                this.f5305m = this.f5295b.getText(i4);
            } else if (charSequence != null) {
                this.f5305m = charSequence;
            }
            if (i5 > 0) {
                this.f5306n = this.f5294a.getDrawable(i5);
            } else if (drawable != null) {
                this.f5306n = drawable;
            }
            this.f5307o = null;
        }
        p(false);
    }

    public final void v() {
        this.f5308p = false;
        if (this.f5309q) {
            this.f5309q = false;
            p(this.f5310r);
        }
    }

    public final void w() {
        if (!this.f5308p) {
            this.f5308p = true;
            this.f5309q = false;
            this.f5310r = false;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4) {
        return a(0, 0, 0, this.f5295b.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4) {
        return addSubMenu(0, 0, 0, this.f5295b.getString(i4));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return a(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        q a4 = a(i4, i5, i6, charSequence);
        H h3 = new H(this.f5294a, this, a4);
        a4.f5339o = h3;
        h3.setHeaderTitle(a4.f5330e);
        return h3;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i4, int i5, int i6, int i7) {
        return a(i4, i5, i6, this.f5295b.getString(i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return addSubMenu(i4, i5, i6, this.f5295b.getString(i7));
    }

    public n k() {
        return this;
    }
}
