package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Q {

    /* renamed from: a, reason: collision with root package name */
    public static final List f2991a = I2.f.C(Application.class, J.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List f2992b = android.support.v4.media.session.a.p(J.class);

    public static final Constructor a(Class cls, List list) {
        T2.h.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        T2.h.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            T2.h.d(parameterTypes, "constructor.parameterTypes");
            List a02 = I2.d.a0(parameterTypes);
            if (list.equals(a02)) {
                return constructor;
            }
            if (list.size() == a02.size() && a02.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final S b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (S) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Failed to access " + cls, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e6.getCause());
        }
    }
}
