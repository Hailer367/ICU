package r2;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import q1.AbstractC0602b;
import x1.C0721a;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f6050a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6051b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6052c;

    /* renamed from: d, reason: collision with root package name */
    public final Serializable f6053d;

    /* renamed from: e, reason: collision with root package name */
    public final Serializable f6054e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6055f;

    /* renamed from: g, reason: collision with root package name */
    public final Serializable f6056g;

    public c(Class cls, Class[] clsArr) {
        this.f6052c = null;
        HashSet hashSet = new HashSet();
        this.f6053d = hashSet;
        this.f6054e = new HashSet();
        this.f6050a = 0;
        this.f6051b = 0;
        this.f6056g = new HashSet();
        hashSet.add(x1.o.a(cls));
        for (Class cls2 : clsArr) {
            AbstractC0602b.h(cls2, "Null interface");
            ((HashSet) this.f6053d).add(x1.o.a(cls2));
        }
    }

    public void a(x1.g gVar) {
        if (!((HashSet) this.f6053d).contains(gVar.f6475a)) {
            ((HashSet) this.f6054e).add(gVar);
            return;
        }
        throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
    }

    public C0721a b() {
        boolean z;
        if (((x1.c) this.f6055f) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new C0721a((String) this.f6052c, new HashSet((HashSet) this.f6053d), new HashSet((HashSet) this.f6054e), this.f6050a, this.f6051b, (x1.c) this.f6055f, (HashSet) this.f6056g);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public c(x1.o oVar, x1.o[] oVarArr) {
        this.f6052c = null;
        HashSet hashSet = new HashSet();
        this.f6053d = hashSet;
        this.f6054e = new HashSet();
        this.f6050a = 0;
        this.f6051b = 0;
        this.f6056g = new HashSet();
        hashSet.add(oVar);
        for (x1.o oVar2 : oVarArr) {
            AbstractC0602b.h(oVar2, "Null interface");
        }
        Collections.addAll((HashSet) this.f6053d, oVarArr);
    }

    public c(Integer num, int i4, Boolean bool, Integer num2, int i5, Integer num3, Boolean bool2) {
        this.f6052c = num;
        this.f6050a = i4;
        this.f6055f = bool;
        this.f6053d = num2;
        this.f6051b = i5;
        this.f6054e = num3;
        this.f6056g = bool2;
    }
}
