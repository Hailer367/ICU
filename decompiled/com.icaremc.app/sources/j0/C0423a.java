package j0;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.icaremc.app.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: j0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0423a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C0423a f5034d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f5035e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f5038c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f5037b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f5036a = new HashMap();

    public C0423a(Context context) {
        this.f5038c = context.getApplicationContext();
    }

    public static C0423a c(Context context) {
        if (f5034d == null) {
            synchronized (f5035e) {
                try {
                    if (f5034d == null) {
                        f5034d = new C0423a(context);
                    }
                } finally {
                }
            }
        }
        return f5034d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f5038c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f5037b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (InterfaceC0424b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        HashMap hashMap = this.f5036a;
        if (k3.b.s()) {
            try {
                Trace.beginSection(k3.b.B(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                try {
                    InterfaceC0424b interfaceC0424b = (InterfaceC0424b) cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class> a4 = interfaceC0424b.a();
                    if (!a4.isEmpty()) {
                        for (Class cls2 : a4) {
                            if (!hashMap.containsKey(cls2)) {
                                b(cls2, hashSet);
                            }
                        }
                    }
                    obj = interfaceC0424b.b(this.f5038c);
                    hashSet.remove(cls);
                    hashMap.put(cls, obj);
                } catch (Throwable th2) {
                    throw new RuntimeException(th2);
                }
            } else {
                obj = hashMap.get(cls);
            }
            Trace.endSection();
            return obj;
        }
        throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
    }
}
