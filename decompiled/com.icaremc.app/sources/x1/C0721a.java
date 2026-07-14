package x1;

import D2.J;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import q1.AbstractC0602b;

/* renamed from: x1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0721a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6455a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f6456b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f6457c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6458d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6459e;

    /* renamed from: f, reason: collision with root package name */
    public final c f6460f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f6461g;

    public C0721a(String str, Set set, Set set2, int i4, int i5, c cVar, Set set3) {
        this.f6455a = str;
        this.f6456b = Collections.unmodifiableSet(set);
        this.f6457c = Collections.unmodifiableSet(set2);
        this.f6458d = i4;
        this.f6459e = i5;
        this.f6460f = cVar;
        this.f6461g = Collections.unmodifiableSet(set3);
    }

    public static r2.c a(o oVar) {
        return new r2.c(oVar, new o[0]);
    }

    public static C0721a b(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(o.a(cls));
        for (Class cls2 : clsArr) {
            AbstractC0602b.h(cls2, "Null interface");
            hashSet.add(o.a(cls2));
        }
        return new C0721a(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new J(21, obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f6456b.toArray()) + ">{" + this.f6458d + ", type=" + this.f6459e + ", deps=" + Arrays.toString(this.f6457c.toArray()) + "}";
    }
}
