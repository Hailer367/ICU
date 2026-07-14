package androidx.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0165w extends AbstractC0144a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0165w> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected d0 unknownFields;

    public AbstractC0165w() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.f2626f;
    }

    public static AbstractC0165w d(Class cls) {
        AbstractC0165w abstractC0165w = defaultInstanceMap.get(cls);
        if (abstractC0165w == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0165w = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (abstractC0165w == null) {
            AbstractC0165w abstractC0165w2 = (AbstractC0165w) ((AbstractC0165w) j0.d(cls)).c(6);
            if (abstractC0165w2 != null) {
                defaultInstanceMap.put(cls, abstractC0165w2);
                return abstractC0165w2;
            }
            throw new IllegalStateException();
        }
        return abstractC0165w;
    }

    public static Object e(Method method, AbstractC0165w abstractC0165w, Object... objArr) {
        try {
            return method.invoke(abstractC0165w, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static final boolean f(AbstractC0165w abstractC0165w, boolean z) {
        byte byteValue = ((Byte) abstractC0165w.c(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        T t3 = T.f2593c;
        t3.getClass();
        boolean e4 = t3.a(abstractC0165w.getClass()).e(abstractC0165w);
        if (z) {
            abstractC0165w.c(2);
        }
        return e4;
    }

    public static void j(Class cls, AbstractC0165w abstractC0165w) {
        abstractC0165w.h();
        defaultInstanceMap.put(cls, abstractC0165w);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0144a
    public final int a(W w2) {
        int h3;
        int h4;
        if (g()) {
            if (w2 == null) {
                T t3 = T.f2593c;
                t3.getClass();
                h4 = t3.a(getClass()).h(this);
            } else {
                h4 = w2.h(this);
            }
            if (h4 >= 0) {
                return h4;
            }
            throw new IllegalStateException(A2.i.g(h4, "serialized size must be non-negative, was "));
        }
        int i4 = this.memoizedSerializedSize;
        if ((i4 & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i4 & Integer.MAX_VALUE;
        }
        if (w2 == null) {
            T t4 = T.f2593c;
            t4.getClass();
            h3 = t4.a(getClass()).h(this);
        } else {
            h3 = w2.h(this);
        }
        k(h3);
        return h3;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0144a
    public final void b(C0156m c0156m) {
        T t3 = T.f2593c;
        t3.getClass();
        W a4 = t3.a(getClass());
        F f4 = c0156m.f2671d;
        if (f4 == null) {
            f4 = new F(c0156m);
        }
        a4.b(this, f4);
    }

    public abstract Object c(int i4);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        T t3 = T.f2593c;
        t3.getClass();
        return t3.a(getClass()).f(this, (AbstractC0165w) obj);
    }

    public final boolean g() {
        if ((this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final void h() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (g()) {
            T t3 = T.f2593c;
            t3.getClass();
            return t3.a(getClass()).c(this);
        }
        if (this.memoizedHashCode == 0) {
            T t4 = T.f2593c;
            t4.getClass();
            this.memoizedHashCode = t4.a(getClass()).c(this);
        }
        return this.memoizedHashCode;
    }

    public final AbstractC0165w i() {
        return (AbstractC0165w) c(4);
    }

    public final void k(int i4) {
        if (i4 >= 0) {
            this.memoizedSerializedSize = (i4 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
            return;
        }
        throw new IllegalStateException(A2.i.g(i4, "serialized size must be non-negative, was "));
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = M.f2573a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        M.c(this, sb, 0);
        return sb.toString();
    }
}
