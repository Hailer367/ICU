package W1;

import b2.C0223a;
import b2.C0224b;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* renamed from: W1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0111b extends T1.s {

    /* renamed from: c, reason: collision with root package name */
    public static final C0110a f1902c = new C0110a();

    /* renamed from: a, reason: collision with root package name */
    public final Class f1903a;

    /* renamed from: b, reason: collision with root package name */
    public final r f1904b;

    public C0111b(T1.e eVar, T1.s sVar, Class cls) {
        this.f1904b = new r(eVar, sVar, cls);
        this.f1903a = cls;
    }

    @Override // T1.s
    public final Object b(C0223a c0223a) {
        if (c0223a.x() == 9) {
            c0223a.t();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        c0223a.a();
        while (c0223a.k()) {
            arrayList.add(((T1.s) this.f1904b.f1961c).b(c0223a));
        }
        c0223a.e();
        int size = arrayList.size();
        Class cls = this.f1903a;
        if (cls.isPrimitive()) {
            Object newInstance = Array.newInstance((Class<?>) cls, size);
            for (int i4 = 0; i4 < size; i4++) {
                Array.set(newInstance, i4, arrayList.get(i4));
            }
            return newInstance;
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
    }

    @Override // T1.s
    public final void c(C0224b c0224b, Object obj) {
        if (obj == null) {
            c0224b.i();
            return;
        }
        c0224b.b();
        int length = Array.getLength(obj);
        for (int i4 = 0; i4 < length; i4++) {
            this.f1904b.c(c0224b, Array.get(obj, i4));
        }
        c0224b.e();
    }
}
