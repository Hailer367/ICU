package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k0 extends androidx.lifecycle.X {

    /* renamed from: j, reason: collision with root package name */
    public static final U.b f1666j = new U.b(1);

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1670g;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1667d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f1668e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f1669f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public boolean f1671h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1672i = false;

    public k0(boolean z) {
        this.f1670g = z;
    }

    @Override // androidx.lifecycle.X
    public final void b() {
        if (h0.K(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1671h = true;
    }

    public final void c(H h2) {
        if (this.f1672i) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = h2.mWho;
        HashMap hashMap = this.f1667d;
        if (!hashMap.containsKey(str)) {
            hashMap.put(h2.mWho, h2);
            if (h0.K(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + h2);
            }
        }
    }

    public final void d(H h2, boolean z) {
        if (h0.K(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + h2);
        }
        f(h2.mWho, z);
    }

    public final void e(String str, boolean z) {
        if (h0.K(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        f(str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k0.class == obj.getClass()) {
            k0 k0Var = (k0) obj;
            if (this.f1667d.equals(k0Var.f1667d) && this.f1668e.equals(k0Var.f1668e) && this.f1669f.equals(k0Var.f1669f)) {
                return true;
            }
        }
        return false;
    }

    public final void f(String str, boolean z) {
        HashMap hashMap = this.f1668e;
        k0 k0Var = (k0) hashMap.get(str);
        if (k0Var != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(k0Var.f1668e.keySet());
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    k0Var.e((String) obj, true);
                }
            }
            k0Var.b();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f1669f;
        androidx.lifecycle.c0 c0Var = (androidx.lifecycle.c0) hashMap2.get(str);
        if (c0Var != null) {
            c0Var.a();
            hashMap2.remove(str);
        }
    }

    public final void g(H h2) {
        if (this.f1672i) {
            if (h0.K(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f1667d.remove(h2.mWho) != null && h0.K(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + h2);
        }
    }

    public final int hashCode() {
        return this.f1669f.hashCode() + ((this.f1668e.hashCode() + (this.f1667d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1667d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1668e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1669f.keySet().iterator();
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
