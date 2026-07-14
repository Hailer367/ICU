package e0;

import E.J;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.RunnableC0117l;
import androidx.fragment.app.z0;
import com.icaremc.doctors.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class n extends z0 {
    @Override // androidx.fragment.app.z0
    public final void a(Object obj, View view) {
        ((s) obj).b(view);
    }

    @Override // androidx.fragment.app.z0
    public final void b(Object obj, ArrayList arrayList) {
        s sVar;
        s sVar2 = (s) obj;
        if (sVar2 != null) {
            int i2 = 0;
            if (sVar2 instanceof x) {
                x xVar = (x) sVar2;
                int size = xVar.f2243x.size();
                while (i2 < size) {
                    if (i2 >= 0 && i2 < xVar.f2243x.size()) {
                        sVar = (s) xVar.f2243x.get(i2);
                    } else {
                        sVar = null;
                    }
                    b(sVar, arrayList);
                    i2++;
                }
                return;
            }
            if (z0.h(sVar2.f2220e) && z0.h(sVar2.f2221f)) {
                int size2 = arrayList.size();
                while (i2 < size2) {
                    sVar2.b((View) arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.ViewTreeObserver$OnPreDrawListener, java.lang.Object, android.view.View$OnAttachStateChangeListener, e0.v] */
    @Override // androidx.fragment.app.z0
    public final void c(ViewGroup viewGroup, Object obj) {
        s sVar = (s) obj;
        ArrayList arrayList = w.f2240c;
        if (!arrayList.contains(viewGroup)) {
            Field field = J.f180a;
            if (viewGroup.isLaidOut()) {
                arrayList.add(viewGroup);
                if (sVar == null) {
                    sVar = w.f2238a;
                }
                s clone = sVar.clone();
                ArrayList arrayList2 = (ArrayList) w.a().get(viewGroup);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    int size = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        ((s) obj2).v(viewGroup);
                    }
                }
                if (clone != null) {
                    clone.i(viewGroup, true);
                }
                if (viewGroup.getTag(R.id.transition_current_scene) == null) {
                    viewGroup.setTag(R.id.transition_current_scene, null);
                    if (clone != null) {
                        ?? obj3 = new Object();
                        obj3.f2236c = clone;
                        obj3.f2237d = viewGroup;
                        viewGroup.addOnAttachStateChangeListener(obj3);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(obj3);
                        return;
                    }
                    return;
                }
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.fragment.app.z0
    public final boolean e(Object obj) {
        return obj instanceof s;
    }

    @Override // androidx.fragment.app.z0
    public final Object f(Object obj) {
        if (obj != null) {
            return ((s) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.z0
    public final Object j(Object obj, Object obj2, Object obj3) {
        s sVar = (s) obj;
        s sVar2 = (s) obj2;
        s sVar3 = (s) obj3;
        if (sVar != null && sVar2 != null) {
            x xVar = new x();
            xVar.H(sVar);
            xVar.H(sVar2);
            xVar.y = false;
            sVar = xVar;
        } else if (sVar == null) {
            if (sVar2 != null) {
                sVar = sVar2;
            } else {
                sVar = null;
            }
        }
        if (sVar3 != null) {
            x xVar2 = new x();
            if (sVar != null) {
                xVar2.H(sVar);
            }
            xVar2.H(sVar3);
            return xVar2;
        }
        return sVar;
    }

    @Override // androidx.fragment.app.z0
    public final Object k(Object obj, Object obj2) {
        x xVar = new x();
        if (obj != null) {
            xVar.H((s) obj);
        }
        xVar.H((s) obj2);
        return xVar;
    }

    @Override // androidx.fragment.app.z0
    public final void l(Object obj, View view, ArrayList arrayList) {
        ((s) obj).a(new k(view, arrayList));
    }

    @Override // androidx.fragment.app.z0
    public final void m(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((s) obj).a(new l(this, obj2, arrayList, obj3, arrayList2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [a.a, java.lang.Object] */
    @Override // androidx.fragment.app.z0
    public final void n(Object obj, Rect rect) {
        ((s) obj).A(new Object());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [a.a, java.lang.Object] */
    @Override // androidx.fragment.app.z0
    public final void o(Object obj, View view) {
        if (view != null) {
            z0.g(view, new Rect());
            ((s) obj).A(new Object());
        }
    }

    @Override // androidx.fragment.app.z0
    public final void p(Object obj, A.e eVar, RunnableC0117l runnableC0117l) {
        s sVar = (s) obj;
        F.h hVar = new F.h(11, sVar);
        synchronized (eVar) {
            while (eVar.f3c) {
                try {
                    try {
                        eVar.wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (eVar.f2b != hVar) {
                eVar.f2b = hVar;
                if (eVar.f1a) {
                    ((s) hVar.f274d).d();
                }
            }
        }
        sVar.a(new m(runnableC0117l));
    }

    @Override // androidx.fragment.app.z0
    public final void q(Object obj, View view, ArrayList arrayList) {
        x xVar = (x) obj;
        ArrayList arrayList2 = xVar.f2221f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            z0.d(arrayList2, (View) arrayList.get(i2));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(xVar, arrayList);
    }

    @Override // androidx.fragment.app.z0
    public final void r(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        x xVar = (x) obj;
        if (xVar != null) {
            ArrayList arrayList3 = xVar.f2221f;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            t(xVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.z0
    public final Object s(Object obj) {
        if (obj == null) {
            return null;
        }
        x xVar = new x();
        xVar.H((s) obj);
        return xVar;
    }

    public final void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        int size;
        s sVar;
        s sVar2 = (s) obj;
        int i2 = 0;
        if (sVar2 instanceof x) {
            x xVar = (x) sVar2;
            int size2 = xVar.f2243x.size();
            while (i2 < size2) {
                if (i2 >= 0 && i2 < xVar.f2243x.size()) {
                    sVar = (s) xVar.f2243x.get(i2);
                } else {
                    sVar = null;
                }
                t(sVar, arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (z0.h(sVar2.f2220e)) {
            ArrayList arrayList3 = sVar2.f2221f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i2 < size) {
                    sVar2.b((View) arrayList2.get(i2));
                    i2++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    sVar2.x((View) arrayList.get(size3));
                }
            }
        }
    }
}
