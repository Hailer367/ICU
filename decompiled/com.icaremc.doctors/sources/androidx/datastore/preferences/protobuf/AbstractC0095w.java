package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0095w extends AbstractC0074a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0095w> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected d0 unknownFields;

    public AbstractC0095w() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.f1408f;
    }

    public static AbstractC0095w d(Class cls) {
        AbstractC0095w abstractC0095w = defaultInstanceMap.get(cls);
        if (abstractC0095w == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0095w = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (abstractC0095w == null) {
            AbstractC0095w abstractC0095w2 = (AbstractC0095w) ((AbstractC0095w) j0.d(cls)).c(6);
            if (abstractC0095w2 != null) {
                defaultInstanceMap.put(cls, abstractC0095w2);
                return abstractC0095w2;
            }
            throw new IllegalStateException();
        }
        return abstractC0095w;
    }

    public static Object e(Method method, AbstractC0095w abstractC0095w, Object... objArr) {
        try {
            return method.invoke(abstractC0095w, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static final boolean f(AbstractC0095w abstractC0095w, boolean z) {
        byte byteValue = ((Byte) abstractC0095w.c(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        T t2 = T.f1374c;
        t2.getClass();
        boolean e2 = t2.a(abstractC0095w.getClass()).e(abstractC0095w);
        if (z) {
            abstractC0095w.c(2);
        }
        return e2;
    }

    public static void j(Class cls, AbstractC0095w abstractC0095w) {
        abstractC0095w.h();
        defaultInstanceMap.put(cls, abstractC0095w);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0074a
    public final int a(W w2) {
        int h2;
        int h3;
        if (g()) {
            if (w2 == null) {
                T t2 = T.f1374c;
                t2.getClass();
                h3 = t2.a(getClass()).h(this);
            } else {
                h3 = w2.h(this);
            }
            if (h3 >= 0) {
                return h3;
            }
            throw new IllegalStateException(O.a.c(h3, "serialized size must be non-negative, was "));
        }
        int i2 = this.memoizedSerializedSize;
        if ((i2 & Api.BaseClientBuilder.API_PRIORITY_OTHER) != Integer.MAX_VALUE) {
            return i2 & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (w2 == null) {
            T t3 = T.f1374c;
            t3.getClass();
            h2 = t3.a(getClass()).h(this);
        } else {
            h2 = w2.h(this);
        }
        k(h2);
        return h2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0074a
    public final void b(C0086m c0086m) {
        T t2 = T.f1374c;
        t2.getClass();
        W a2 = t2.a(getClass());
        F f2 = c0086m.f1454f;
        if (f2 == null) {
            f2 = new F(c0086m);
        }
        a2.b(this, f2);
    }

    public abstract Object c(int i2);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        T t2 = T.f1374c;
        t2.getClass();
        return t2.a(getClass()).f(this, (AbstractC0095w) obj);
    }

    public final boolean g() {
        if ((this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final void h() {
        this.memoizedSerializedSize &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int hashCode() {
        if (g()) {
            T t2 = T.f1374c;
            t2.getClass();
            return t2.a(getClass()).c(this);
        }
        if (this.memoizedHashCode == 0) {
            T t3 = T.f1374c;
            t3.getClass();
            this.memoizedHashCode = t3.a(getClass()).c(this);
        }
        return this.memoizedHashCode;
    }

    public final AbstractC0095w i() {
        return (AbstractC0095w) c(4);
    }

    public final void k(int i2) {
        if (i2 >= 0) {
            this.memoizedSerializedSize = (i2 & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
            return;
        }
        throw new IllegalStateException(O.a.c(i2, "serialized size must be non-negative, was "));
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = M.f1353a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        M.c(this, sb, 0);
        return sb.toString();
    }
}
