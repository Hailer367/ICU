package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class Z extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public static Z f1826c;

    /* renamed from: b, reason: collision with root package name */
    public final Application f1827b;

    public Z(Application application) {
        this.f1827b = application;
    }

    @Override // androidx.lifecycle.b0, androidx.lifecycle.a0
    public final X a(Class cls) {
        Application application = this.f1827b;
        if (application != null) {
            return c(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.a0
    public final X b(Class cls, T.c cVar) {
        if (this.f1827b != null) {
            return a(cls);
        }
        Application application = (Application) cVar.f768a.get(Y.f1824a);
        if (application != null) {
            return c(cls, application);
        }
        if (!AbstractC0131a.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
    }

    public final X c(Class cls, Application application) {
        if (AbstractC0131a.class.isAssignableFrom(cls)) {
            try {
                X x2 = (X) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.h.d(x2, "{\n                try {\n…          }\n            }");
                return x2;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
        return super.a(cls);
    }
}
