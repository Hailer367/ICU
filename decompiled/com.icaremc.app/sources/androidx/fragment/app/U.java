package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class U extends androidx.lifecycle.S {

    /* renamed from: j, reason: collision with root package name */
    public static final T f2782j = new T(0);

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2786g;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f2783d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f2784e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f2785f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public boolean f2787h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2788i = false;

    public U(boolean z) {
        this.f2786g = z;
    }

    @Override // androidx.lifecycle.S
    public final void b() {
        if (P.J(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2787h = true;
    }

    public final void c(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t, boolean z) {
        if (P.J(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + abstractComponentCallbacksC0187t);
        }
        e(abstractComponentCallbacksC0187t.f2928j, z);
    }

    public final void d(String str, boolean z) {
        if (P.J(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        e(str, z);
    }

    public final void e(String str, boolean z) {
        HashMap hashMap = this.f2784e;
        U u3 = (U) hashMap.get(str);
        if (u3 != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(u3.f2784e.keySet());
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    u3.d((String) obj, true);
                }
            }
            u3.b();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f2785f;
        androidx.lifecycle.X x3 = (androidx.lifecycle.X) hashMap2.get(str);
        if (x3 != null) {
            x3.a();
            hashMap2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && U.class == obj.getClass()) {
            U u3 = (U) obj;
            if (this.f2783d.equals(u3.f2783d) && this.f2784e.equals(u3.f2784e) && this.f2785f.equals(u3.f2785f)) {
                return true;
            }
        }
        return false;
    }

    public final void f(AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t) {
        if (this.f2788i) {
            if (P.J(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f2783d.remove(abstractComponentCallbacksC0187t.f2928j) != null && P.J(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + abstractComponentCallbacksC0187t);
        }
    }

    public final int hashCode() {
        return this.f2785f.hashCode() + ((this.f2784e.hashCode() + (this.f2783d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f2783d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f2784e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f2785f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
