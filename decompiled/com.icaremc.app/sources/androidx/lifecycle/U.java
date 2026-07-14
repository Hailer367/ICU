package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class U extends W {

    /* renamed from: c, reason: collision with root package name */
    public static U f2998c;

    /* renamed from: b, reason: collision with root package name */
    public final Application f2999b;

    public U(Application application) {
        this.f2999b = application;
    }

    @Override // androidx.lifecycle.W, androidx.lifecycle.V
    public final S a(Class cls) {
        Application application = this.f2999b;
        if (application != null) {
            return c(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.V
    public final S b(Class cls, a0.c cVar) {
        if (this.f2999b != null) {
            return a(cls);
        }
        Application application = (Application) cVar.f2215a.get(T.f2996a);
        if (application != null) {
            return c(cls, application);
        }
        if (!AbstractC0194a.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
    }

    public final S c(Class cls, Application application) {
        if (AbstractC0194a.class.isAssignableFrom(cls)) {
            try {
                S s3 = (S) cls.getConstructor(Application.class).newInstance(application);
                T2.h.d(s3, "{\n                try {\n…          }\n            }");
                return s3;
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            }
        }
        return super.a(cls);
    }
}
