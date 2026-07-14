package c0;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.icaremc.doctors.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: c0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0170a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C0170a f1987d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f1988e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f1991c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f1990b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1989a = new HashMap();

    public C0170a(Context context) {
        this.f1991c = context.getApplicationContext();
    }

    public static C0170a c(Context context) {
        if (f1987d == null) {
            synchronized (f1988e) {
                try {
                    if (f1987d == null) {
                        f1987d = new C0170a(context);
                    }
                } finally {
                }
            }
        }
        return f1987d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f1991c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f1990b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (InterfaceC0171b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final void b(Class cls, HashSet hashSet) {
        HashMap hashMap = this.f1989a;
        if (android.support.v4.media.session.a.w()) {
            try {
                Trace.beginSection(android.support.v4.media.session.a.J(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                try {
                    InterfaceC0171b interfaceC0171b = (InterfaceC0171b) cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class> a2 = interfaceC0171b.a();
                    if (!a2.isEmpty()) {
                        for (Class cls2 : a2) {
                            if (!hashMap.containsKey(cls2)) {
                                b(cls2, hashSet);
                            }
                        }
                    }
                    Object b2 = interfaceC0171b.b(this.f1991c);
                    hashSet.remove(cls);
                    hashMap.put(cls, b2);
                } catch (Throwable th2) {
                    throw new RuntimeException(th2);
                }
            } else {
                hashMap.get(cls);
            }
            Trace.endSection();
            return;
        }
        throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
    }
}
