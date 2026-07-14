package V0;

import a.AbstractC0051a;
import com.google.firebase.messaging.Constants;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a implements T0.d, d, Serializable {
    private final T0.d completion;

    public a(T0.d dVar) {
        this.completion = dVar;
    }

    public T0.d create(T0.d completion) {
        kotlin.jvm.internal.h.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // V0.d
    public d getCallerFrame() {
        T0.d dVar = this.completion;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    public final T0.d getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int i2;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Object obj;
        Integer num;
        int i3;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str2 = null;
        if (eVar == null || eVar.v() < 1) {
            return null;
        }
        int i4 = -1;
        try {
            Field declaredField = getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(this);
            if (obj2 instanceof Integer) {
                num = (Integer) obj2;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            i2 = i3 - 1;
        } catch (Exception unused) {
            i2 = -1;
        }
        if (i2 >= 0) {
            i4 = eVar.l()[i2];
        }
        f fVar = g.f788b;
        f fVar2 = g.f787a;
        if (fVar == null) {
            try {
                f fVar3 = new f(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                g.f788b = fVar3;
                fVar = fVar3;
            } catch (Exception unused2) {
                g.f788b = fVar2;
                fVar = fVar2;
            }
        }
        if (fVar != fVar2 && (method = fVar.f784a) != null && (invoke = method.invoke(getClass(), null)) != null && (method2 = fVar.f785b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = fVar.f786c;
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
        return new StackTraceElement(str, eVar.m(), eVar.f(), i4);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // T0.d
    public final void resumeWith(Object obj) {
        T0.d dVar = this;
        while (true) {
            a aVar = (a) dVar;
            T0.d dVar2 = aVar.completion;
            kotlin.jvm.internal.h.b(dVar2);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == U0.a.f780c) {
                    return;
                }
            } catch (Throwable th) {
                obj = AbstractC0051a.j(th);
            }
            aVar.releaseIntercepted();
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
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public T0.d create(Object obj, T0.d completion) {
        kotlin.jvm.internal.h.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
