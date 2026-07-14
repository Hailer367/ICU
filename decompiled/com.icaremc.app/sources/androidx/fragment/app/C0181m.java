package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.icaremc.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: androidx.fragment.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0181m {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f2868a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2869b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2870c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2871d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2872e;

    public C0181m(ViewGroup viewGroup) {
        T2.h.e(viewGroup, "container");
        this.f2868a = viewGroup;
        this.f2869b = new ArrayList();
        this.f2870c = new ArrayList();
    }

    public static final C0181m e(ViewGroup viewGroup, P p3) {
        T2.h.e(viewGroup, "container");
        T2.h.e(p3, "fragmentManager");
        T2.h.d(p3.H(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof C0181m) {
            return (C0181m) tag;
        }
        C0181m c0181m = new C0181m(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0181m);
        return c0181m;
    }

    public final void a(c0 c0Var) {
        T2.h.e(c0Var, "operation");
        if (!c0Var.f2852b) {
        } else {
            throw null;
        }
    }

    public final void b(ArrayList arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            if (!listIterator.hasPrevious()) {
                if (P.J(2)) {
                    Log.v("FragmentManager", "Executing operations from " + ((Object) null) + " to " + ((Object) null));
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (!arrayList.isEmpty()) {
                    ((c0) arrayList.get(arrayList.size() - 1)).getClass();
                    if (arrayList.size() <= 0) {
                        if (arrayList.size() > 0) {
                            c0 c0Var = (c0) arrayList.get(0);
                            arrayList2.add(new C0175g(c0Var, z));
                            c0Var.getClass();
                            new android.support.v4.media.session.a(c0Var);
                            if (z) {
                                throw null;
                            }
                            throw null;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        int size = arrayList3.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Object obj = arrayList3.get(i4);
                            i4++;
                            if (!((C0180l) obj).o()) {
                                arrayList4.add(obj);
                            }
                        }
                        ArrayList arrayList5 = new ArrayList();
                        int size2 = arrayList4.size();
                        int i5 = 0;
                        while (i5 < size2) {
                            Object obj2 = arrayList4.get(i5);
                            i5++;
                            ((C0180l) obj2).getClass();
                        }
                        int size3 = arrayList5.size();
                        int i6 = 0;
                        while (i6 < size3) {
                            Object obj3 = arrayList5.get(i6);
                            i6++;
                            ((C0180l) obj3).getClass();
                        }
                        ArrayList arrayList6 = new ArrayList();
                        ArrayList arrayList7 = new ArrayList();
                        if (arrayList2.size() <= 0) {
                            arrayList7.isEmpty();
                            int size4 = arrayList2.size();
                            int i7 = 0;
                            while (i7 < size4) {
                                Object obj4 = arrayList2.get(i7);
                                i7++;
                                C0175g c0175g = (C0175g) obj4;
                                Context context = this.f2868a.getContext();
                                c0175g.getClass();
                                T2.h.d(context, "context");
                                E0.a C3 = c0175g.C(context);
                                if (C3 != null) {
                                    if (((AnimatorSet) C3.f460h) == null) {
                                        arrayList6.add(c0175g);
                                    } else {
                                        throw null;
                                    }
                                }
                            }
                            if (arrayList6.size() <= 0) {
                                return;
                            }
                            ((C0175g) arrayList6.get(0)).getClass();
                            throw null;
                        }
                        ((C0175g) arrayList2.get(0)).getClass();
                        throw null;
                    }
                    ((c0) arrayList.get(0)).getClass();
                    throw null;
                }
                throw new NoSuchElementException("List is empty.");
            }
            ((c0) listIterator.previous()).getClass();
            throw null;
        }
        ((c0) it.next()).getClass();
        throw null;
    }

    public final void c() {
        if (this.f2872e) {
            return;
        }
        int i4 = 0;
        if (!this.f2868a.isAttachedToWindow()) {
            d();
            this.f2871d = false;
            return;
        }
        synchronized (this.f2869b) {
            try {
                if (this.f2869b.isEmpty()) {
                    ArrayList J3 = I2.e.J(this.f2870c);
                    this.f2870c.clear();
                    int size = J3.size();
                    while (i4 < size) {
                        Object obj = J3.get(i4);
                        i4++;
                        c0 c0Var = (c0) obj;
                        if (P.J(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + c0Var + " with no incoming pendingOperations");
                        }
                        ViewGroup viewGroup = this.f2868a;
                        c0Var.getClass();
                        T2.h.e(viewGroup, "container");
                        c0Var.a(viewGroup);
                        this.f2870c.add(c0Var);
                    }
                } else {
                    ArrayList J4 = I2.e.J(this.f2870c);
                    this.f2870c.clear();
                    if (J4.size() > 0) {
                        c0 c0Var2 = (c0) J4.get(0);
                        if (P.J(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + c0Var2);
                        }
                        c0Var2.getClass();
                        throw null;
                    }
                    g();
                    ArrayList J5 = I2.e.J(this.f2869b);
                    if (J5.isEmpty()) {
                        return;
                    }
                    this.f2869b.clear();
                    this.f2870c.addAll(J5);
                    if (P.J(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    b(J5, this.f2871d);
                    if (J5.size() <= 0) {
                        ArrayList arrayList = new ArrayList();
                        int size2 = J5.size();
                        int i5 = 0;
                        while (i5 < size2) {
                            Object obj2 = J5.get(i5);
                            i5++;
                            ((c0) obj2).getClass();
                            I2.k.E(arrayList, null);
                        }
                        if (!arrayList.isEmpty()) {
                            f(J5);
                            int size3 = J5.size();
                            for (int i6 = 0; i6 < size3; i6++) {
                                a((c0) J5.get(i6));
                            }
                        }
                        this.f2871d = false;
                        if (P.J(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                        }
                    } else {
                        ((c0) J5.get(0)).getClass();
                        throw null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        String str;
        String str2;
        if (P.J(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.f2868a.isAttachedToWindow();
        synchronized (this.f2869b) {
            try {
                g();
                f(this.f2869b);
                ArrayList J3 = I2.e.J(this.f2870c);
                int size = J3.size();
                int i4 = 0;
                int i5 = 0;
                while (i5 < size) {
                    Object obj = J3.get(i5);
                    i5++;
                    c0 c0Var = (c0) obj;
                    if (P.J(2)) {
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f2868a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + c0Var);
                    }
                    c0Var.a(this.f2868a);
                }
                ArrayList J4 = I2.e.J(this.f2869b);
                int size2 = J4.size();
                while (i4 < size2) {
                    Object obj2 = J4.get(i4);
                    i4++;
                    c0 c0Var2 = (c0) obj2;
                    if (P.J(2)) {
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f2868a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + c0Var2);
                    }
                    c0Var2.a(this.f2868a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(List list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            c0 c0Var = (c0) list.get(i4);
            c0Var.getClass();
            if (!c0Var.f2851a) {
                c0Var.f2851a = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((c0) it.next()).getClass();
            I2.k.E(arrayList, null);
        }
        List I3 = I2.e.I(I2.e.K(arrayList));
        int size2 = I3.size();
        for (int i5 = 0; i5 < size2; i5++) {
            b0 b0Var = (b0) I3.get(i5);
            b0Var.getClass();
            ViewGroup viewGroup = this.f2868a;
            T2.h.e(viewGroup, "container");
            if (!b0Var.f2848a) {
                b0Var.c(viewGroup);
            }
            b0Var.f2848a = true;
        }
    }

    public final void g() {
        ArrayList arrayList = this.f2869b;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((c0) obj).getClass();
        }
    }
}
