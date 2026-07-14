package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1719a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1720b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1721c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public k0 f1722d;

    public final void a(H h2) {
        if (!this.f1719a.contains(h2)) {
            synchronized (this.f1719a) {
                this.f1719a.add(h2);
            }
            h2.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + h2);
    }

    public final H b(String str) {
        o0 o0Var = (o0) this.f1720b.get(str);
        if (o0Var != null) {
            return o0Var.f1711c;
        }
        return null;
    }

    public final H c(String str) {
        H findFragmentByWho;
        for (o0 o0Var : this.f1720b.values()) {
            if (o0Var != null && (findFragmentByWho = o0Var.f1711c.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (o0 o0Var : this.f1720b.values()) {
            if (o0Var != null) {
                arrayList.add(o0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (o0 o0Var : this.f1720b.values()) {
            if (o0Var != null) {
                arrayList.add(o0Var.f1711c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f1719a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f1719a) {
            arrayList = new ArrayList(this.f1719a);
        }
        return arrayList;
    }

    public final void g(o0 o0Var) {
        H h2 = o0Var.f1711c;
        String str = h2.mWho;
        HashMap hashMap = this.f1720b;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(h2.mWho, o0Var);
        if (h2.mRetainInstanceChangedWhileDetached) {
            if (h2.mRetainInstance) {
                this.f1722d.c(h2);
            } else {
                this.f1722d.g(h2);
            }
            h2.mRetainInstanceChangedWhileDetached = false;
        }
        if (h0.K(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + h2);
        }
    }

    public final void h(o0 o0Var) {
        H h2 = o0Var.f1711c;
        if (h2.mRetainInstance) {
            this.f1722d.g(h2);
        }
        String str = h2.mWho;
        HashMap hashMap = this.f1720b;
        if (hashMap.get(str) == o0Var && ((o0) hashMap.put(h2.mWho, null)) != null && h0.K(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + h2);
        }
    }

    public final Bundle i(Bundle bundle, String str) {
        HashMap hashMap = this.f1721c;
        if (bundle != null) {
            return (Bundle) hashMap.put(str, bundle);
        }
        return (Bundle) hashMap.remove(str);
    }
}
