package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1833a = new LinkedHashMap();

    public final void a() {
        for (X x2 : this.f1833a.values()) {
            x2.f1823c = true;
            HashMap hashMap = x2.f1821a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        Iterator it = x2.f1821a.values().iterator();
                        while (it.hasNext()) {
                            X.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = x2.f1822b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = x2.f1822b.iterator();
                        while (it2.hasNext()) {
                            X.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
                x2.f1822b.clear();
            }
            x2.b();
        }
        this.f1833a.clear();
    }
}
