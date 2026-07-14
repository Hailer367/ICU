package M2;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a implements K2.d, d, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final K2.d f1050f;

    public a(K2.d dVar) {
        this.f1050f = dVar;
    }

    @Override // M2.d
    public d d() {
        K2.d dVar = this.f1050f;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    public K2.d i(K2.d dVar, Object obj) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement j() {
        int i4;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Object obj;
        Integer num;
        int i5;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar == null || eVar.v() < 1) {
            return null;
        }
        int i6 = -1;
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(this);
            if (obj2 instanceof Integer) {
                num = (Integer) obj2;
            } else {
                num = null;
            }
            if (num != null) {
                i5 = num.intValue();
            } else {
                i5 = 0;
            }
            i4 = i5 - 1;
        } catch (Exception unused) {
            i4 = -1;
        }
        if (i4 >= 0) {
            i6 = eVar.l()[i4];
        }
        f fVar = g.f1058b;
        f fVar2 = g.f1057a;
        if (fVar == null) {
            try {
                f fVar3 = new f(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                g.f1058b = fVar3;
                fVar = fVar3;
            } catch (Exception unused2) {
                g.f1058b = fVar2;
                fVar = fVar2;
            }
        }
        if (fVar != fVar2 && (method = fVar.f1054a) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = fVar.f1055b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = fVar.f1056c;
            if (method3 != null) {
                obj = method3.invoke(invoke2, null);
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                str2 = (String) obj;
            }
        }
        if (str2 == null) {
            str = eVar.c();
        } else {
            str = str2 + '/' + eVar.c();
        }
        return new StackTraceElement(str, eVar.m(), eVar.f(), i6);
    }

    public abstract Object k(Object obj);

    @Override // K2.d
    public final void resumeWith(Object obj) {
        K2.d dVar = this;
        while (true) {
            a aVar = (a) dVar;
            K2.d dVar2 = aVar.f1050f;
            T2.h.b(dVar2);
            try {
                obj = aVar.k(obj);
                if (obj == L2.a.f1019f) {
                    return;
                }
            } catch (Throwable th) {
                obj = k3.b.f(th);
            }
            aVar.m();
            if (dVar2 instanceof a) {
                dVar = dVar2;
            } else {
                dVar2.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object j4 = j();
        if (j4 == null) {
            j4 = getClass().getName();
        }
        sb.append(j4);
        return sb.toString();
    }

    public void m() {
    }
}
