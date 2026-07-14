package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3001a = new LinkedHashMap();

    public final void a() {
        for (S s3 : this.f3001a.values()) {
            s3.f2995c = true;
            HashMap hashMap = s3.f2993a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        Iterator it = s3.f2993a.values().iterator();
                        while (it.hasNext()) {
                            S.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = s3.f2994b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = s3.f2994b.iterator();
                        while (it2.hasNext()) {
                            S.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
                s3.f2994b.clear();
            }
            s3.b();
        }
        this.f3001a.clear();
    }
}
