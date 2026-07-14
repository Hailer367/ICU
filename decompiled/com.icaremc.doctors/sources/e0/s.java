package e0;

import E.J;
import a.AbstractC0051a;
import android.animation.Animator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.firebase.encoders.json.BuildConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import r.AbstractC0296h;
import r.C0293e;
import r.C0295g;
import s.AbstractC0298a;

/* loaded from: classes.dex */
public abstract class s implements Cloneable {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f2215u = {2, 1, 3, 4};

    /* renamed from: v, reason: collision with root package name */
    public static final A0.f f2216v = new A0.f(18);

    /* renamed from: w, reason: collision with root package name */
    public static final ThreadLocal f2217w = new ThreadLocal();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f2226k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f2227l;

    /* renamed from: s, reason: collision with root package name */
    public AbstractC0051a f2232s;

    /* renamed from: c, reason: collision with root package name */
    public final String f2218c = getClass().getName();

    /* renamed from: d, reason: collision with root package name */
    public long f2219d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f2220e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2221f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public B0.q f2222g = new B0.q(3);

    /* renamed from: h, reason: collision with root package name */
    public B0.q f2223h = new B0.q(3);

    /* renamed from: i, reason: collision with root package name */
    public x f2224i = null;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f2225j = f2215u;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2228m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public int f2229n = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2230o = false;
    public boolean p = false;
    public ArrayList q = null;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f2231r = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public A0.f f2233t = f2216v;

    public static void c(B0.q qVar, View view, z zVar) {
        C0293e c0293e = (C0293e) qVar.f130c;
        C0293e c0293e2 = (C0293e) qVar.f133f;
        SparseArray sparseArray = (SparseArray) qVar.f131d;
        C0295g c0295g = (C0295g) qVar.f132e;
        c0293e.put(view, zVar);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        Field field = J.f180a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            if (c0293e2.containsKey(transitionName)) {
                c0293e2.put(transitionName, null);
            } else {
                c0293e2.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c0295g.f3565c) {
                    int i2 = c0295g.f3568f;
                    long[] jArr = c0295g.f3566d;
                    Object[] objArr = c0295g.f3567e;
                    int i3 = 0;
                    for (int i4 = 0; i4 < i2; i4++) {
                        Object obj = objArr[i4];
                        if (obj != AbstractC0296h.f3569a) {
                            if (i4 != i3) {
                                jArr[i3] = jArr[i4];
                                objArr[i3] = obj;
                                objArr[i4] = null;
                            }
                            i3++;
                        }
                    }
                    c0295g.f3565c = false;
                    c0295g.f3568f = i3;
                }
                if (AbstractC0298a.b(c0295g.f3566d, c0295g.f3568f, itemIdAtPosition) >= 0) {
                    View view2 = (View) c0295g.b(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        c0295g.d(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                c0295g.d(itemIdAtPosition, view);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [r.e, java.lang.Object, r.j] */
    public static C0293e p() {
        ThreadLocal threadLocal = f2217w;
        C0293e c0293e = (C0293e) threadLocal.get();
        if (c0293e == null) {
            ?? jVar = new r.j(0);
            threadLocal.set(jVar);
            return jVar;
        }
        return c0293e;
    }

    public static boolean u(z zVar, z zVar2, String str) {
        Object obj = zVar.f2247a.get(str);
        Object obj2 = zVar2.f2247a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(AbstractC0051a abstractC0051a) {
        this.f2232s = abstractC0051a;
    }

    public void C(A0.f fVar) {
        if (fVar == null) {
            this.f2233t = f2216v;
        } else {
            this.f2233t = fVar;
        }
    }

    public void E(long j2) {
        this.f2219d = j2;
    }

    public final void F() {
        if (this.f2229n == 0) {
            ArrayList arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.q.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((r) arrayList2.get(i2)).a(this);
                }
            }
            this.p = false;
        }
        this.f2229n++;
    }

    public String G(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2219d != -1) {
            str2 = str2 + "dly(" + this.f2219d + ") ";
        }
        ArrayList arrayList = this.f2220e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2221f;
        if (size <= 0 && arrayList2.size() <= 0) {
            return str2;
        }
        String f2 = O.a.f(str2, "tgts(");
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 > 0) {
                    f2 = O.a.f(f2, ", ");
                }
                f2 = f2 + arrayList.get(i2);
            }
        }
        if (arrayList2.size() > 0) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (i3 > 0) {
                    f2 = O.a.f(f2, ", ");
                }
                f2 = f2 + arrayList2.get(i3);
            }
        }
        return O.a.f(f2, ")");
    }

    public void a(r rVar) {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(rVar);
    }

    public void b(View view) {
        this.f2221f.add(view);
    }

    public void d() {
        ArrayList arrayList = this.f2228m;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = this.q;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.q.clone();
            int size2 = arrayList3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((r) arrayList3.get(i2)).e();
            }
        }
    }

    public abstract void e(z zVar);

    public final void f(View view, boolean z) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                z zVar = new z(view);
                if (z) {
                    h(zVar);
                } else {
                    e(zVar);
                }
                zVar.f2249c.add(this);
                g(zVar);
                if (z) {
                    c(this.f2222g, view, zVar);
                } else {
                    c(this.f2223h, view, zVar);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    f(viewGroup.getChildAt(i2), z);
                }
            }
        }
    }

    public abstract void h(z zVar);

    public final void i(ViewGroup viewGroup, boolean z) {
        j(z);
        ArrayList arrayList = this.f2220e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2221f;
        if (size <= 0 && arrayList2.size() <= 0) {
            f(viewGroup, z);
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i2)).intValue());
            if (findViewById != null) {
                z zVar = new z(findViewById);
                if (z) {
                    h(zVar);
                } else {
                    e(zVar);
                }
                zVar.f2249c.add(this);
                g(zVar);
                if (z) {
                    c(this.f2222g, findViewById, zVar);
                } else {
                    c(this.f2223h, findViewById, zVar);
                }
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            View view = (View) arrayList2.get(i3);
            z zVar2 = new z(view);
            if (z) {
                h(zVar2);
            } else {
                e(zVar2);
            }
            zVar2.f2249c.add(this);
            g(zVar2);
            if (z) {
                c(this.f2222g, view, zVar2);
            } else {
                c(this.f2223h, view, zVar2);
            }
        }
    }

    public final void j(boolean z) {
        if (z) {
            ((C0293e) this.f2222g.f130c).clear();
            ((SparseArray) this.f2222g.f131d).clear();
            ((C0295g) this.f2222g.f132e).a();
        } else {
            ((C0293e) this.f2223h.f130c).clear();
            ((SparseArray) this.f2223h.f131d).clear();
            ((C0295g) this.f2223h.f132e).a();
        }
    }

    @Override // 
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public s clone() {
        try {
            s sVar = (s) super.clone();
            sVar.f2231r = new ArrayList();
            sVar.f2222g = new B0.q(3);
            sVar.f2223h = new B0.q(3);
            sVar.f2226k = null;
            sVar.f2227l = null;
            return sVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator l(ViewGroup viewGroup, z zVar, z zVar2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [e0.q, java.lang.Object] */
    public void m(ViewGroup viewGroup, B0.q qVar, B0.q qVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator l2;
        int i2;
        int i3;
        View view;
        z zVar;
        Animator animator;
        z zVar2;
        C0293e p = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            z zVar3 = (z) arrayList.get(i4);
            z zVar4 = (z) arrayList2.get(i4);
            if (zVar3 != null && !zVar3.f2249c.contains(this)) {
                zVar3 = null;
            }
            if (zVar4 != null && !zVar4.f2249c.contains(this)) {
                zVar4 = null;
            }
            if ((zVar3 == null && zVar4 == null) || ((zVar3 != null && zVar4 != null && !s(zVar3, zVar4)) || (l2 = l(viewGroup, zVar3, zVar4)) == null)) {
                i2 = size;
                i3 = i4;
            } else {
                String str = this.f2218c;
                if (zVar4 != null) {
                    view = zVar4.f2248b;
                    String[] q = q();
                    if (q != null && q.length > 0) {
                        zVar2 = new z(view);
                        z zVar5 = (z) ((C0293e) qVar2.f130c).get(view);
                        i2 = size;
                        if (zVar5 != null) {
                            int i5 = 0;
                            while (i5 < q.length) {
                                String str2 = q[i5];
                                zVar2.f2247a.put(str2, zVar5.f2247a.get(str2));
                                i5++;
                                i4 = i4;
                                zVar5 = zVar5;
                            }
                        }
                        i3 = i4;
                        int i6 = p.f3573e;
                        int i7 = 0;
                        while (true) {
                            if (i7 < i6) {
                                q qVar3 = (q) p.get((Animator) p.f(i7));
                                if (qVar3.f2212c != null && qVar3.f2210a == view && qVar3.f2211b.equals(str) && qVar3.f2212c.equals(zVar2)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            } else {
                                animator = l2;
                                break;
                            }
                        }
                    } else {
                        i2 = size;
                        i3 = i4;
                        animator = l2;
                        zVar2 = null;
                    }
                    l2 = animator;
                    zVar = zVar2;
                } else {
                    i2 = size;
                    i3 = i4;
                    view = zVar3.f2248b;
                    zVar = null;
                }
                if (l2 != null) {
                    B b2 = A.f2157a;
                    G g2 = new G(viewGroup);
                    ?? obj = new Object();
                    obj.f2210a = view;
                    obj.f2211b = str;
                    obj.f2212c = zVar;
                    obj.f2213d = g2;
                    obj.f2214e = this;
                    p.put(l2, obj);
                    this.f2231r.add(l2);
                }
            }
            i4 = i3 + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator2 = (Animator) this.f2231r.get(sparseIntArray.keyAt(i8));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i8) - Long.MAX_VALUE));
            }
        }
    }

    public final void n() {
        int i2 = this.f2229n - 1;
        this.f2229n = i2;
        if (i2 == 0) {
            ArrayList arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.q.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((r) arrayList2.get(i3)).b(this);
                }
            }
            for (int i4 = 0; i4 < ((C0295g) this.f2222g.f132e).e(); i4++) {
                View view = (View) ((C0295g) this.f2222g.f132e).f(i4);
                if (view != null) {
                    Field field = J.f180a;
                    view.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < ((C0295g) this.f2223h.f132e).e(); i5++) {
                View view2 = (View) ((C0295g) this.f2223h.f132e).f(i5);
                if (view2 != null) {
                    Field field2 = J.f180a;
                    view2.setHasTransientState(false);
                }
            }
            this.p = true;
        }
    }

    public final z o(View view, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        x xVar = this.f2224i;
        if (xVar != null) {
            return xVar.o(view, z);
        }
        if (z) {
            arrayList = this.f2226k;
        } else {
            arrayList = this.f2227l;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    z zVar = (z) arrayList.get(i2);
                    if (zVar != null) {
                        if (zVar.f2248b == view) {
                            break;
                        }
                        i2++;
                    } else {
                        return null;
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 >= 0) {
                if (z) {
                    arrayList2 = this.f2227l;
                } else {
                    arrayList2 = this.f2226k;
                }
                return (z) arrayList2.get(i2);
            }
            return null;
        }
        return null;
    }

    public String[] q() {
        return null;
    }

    public final z r(View view, boolean z) {
        B0.q qVar;
        x xVar = this.f2224i;
        if (xVar != null) {
            return xVar.r(view, z);
        }
        if (z) {
            qVar = this.f2222g;
        } else {
            qVar = this.f2223h;
        }
        return (z) ((C0293e) qVar.f130c).get(view);
    }

    public boolean s(z zVar, z zVar2) {
        if (zVar != null && zVar2 != null) {
            String[] q = q();
            if (q != null) {
                for (String str : q) {
                    if (u(zVar, zVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = zVar.f2247a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(zVar, zVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f2220e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2221f;
        if ((size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return G(BuildConfig.FLAVOR);
    }

    public void v(View view) {
        if (!this.p) {
            ArrayList arrayList = this.f2228m;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Animator) arrayList.get(size)).pause();
            }
            ArrayList arrayList2 = this.q;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = (ArrayList) this.q.clone();
                int size2 = arrayList3.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((r) arrayList3.get(i2)).c();
                }
            }
            this.f2230o = true;
        }
    }

    public void w(r rVar) {
        ArrayList arrayList = this.q;
        if (arrayList != null) {
            arrayList.remove(rVar);
            if (this.q.size() == 0) {
                this.q = null;
            }
        }
    }

    public void x(View view) {
        this.f2221f.remove(view);
    }

    public void y(View view) {
        if (this.f2230o) {
            if (!this.p) {
                ArrayList arrayList = this.f2228m;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Animator) arrayList.get(size)).resume();
                }
                ArrayList arrayList2 = this.q;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ArrayList arrayList3 = (ArrayList) this.q.clone();
                    int size2 = arrayList3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((r) arrayList3.get(i2)).d();
                    }
                }
            }
            this.f2230o = false;
        }
    }

    public void z() {
        F();
        C0293e p = p();
        ArrayList arrayList = this.f2231r;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Animator animator = (Animator) obj;
            if (p.containsKey(animator)) {
                F();
                if (animator != null) {
                    animator.addListener(new o(this, p));
                    long j2 = this.f2219d;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    animator.addListener(new p(0, this));
                    animator.start();
                }
            }
        }
        this.f2231r.clear();
        n();
    }

    public void B() {
    }

    public void D() {
    }

    public void g(z zVar) {
    }
}
