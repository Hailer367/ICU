package o0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import t.C0656e;

/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0557a {

    /* renamed from: a, reason: collision with root package name */
    public final C0656e f5759a;

    /* renamed from: b, reason: collision with root package name */
    public final C0656e f5760b;

    /* renamed from: c, reason: collision with root package name */
    public final C0656e f5761c;

    public AbstractC0557a(C0656e c0656e, C0656e c0656e2, C0656e c0656e3) {
        this.f5759a = c0656e;
        this.f5760b = c0656e2;
        this.f5761c = c0656e3;
    }

    public abstract C0558b a();

    public final Class b(Class cls) {
        String name = cls.getName();
        C0656e c0656e = this.f5761c;
        Class cls2 = (Class) c0656e.get(name);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
            c0656e.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public final Method c(String str) {
        C0656e c0656e = this.f5759a;
        Method method = (Method) c0656e.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC0557a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0557a.class);
            c0656e.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        C0656e c0656e = this.f5760b;
        Method method = (Method) c0656e.get(name);
        if (method == null) {
            Class b4 = b(cls);
            System.currentTimeMillis();
            Method declaredMethod = b4.getDeclaredMethod("write", cls, AbstractC0557a.class);
            c0656e.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public abstract boolean e(int i4);

    public final int f(int i4, int i5) {
        if (!e(i5)) {
            return i4;
        }
        return ((C0558b) this).f5763e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i4) {
        if (!e(i4)) {
            return parcelable;
        }
        return ((C0558b) this).f5763e.readParcelable(C0558b.class.getClassLoader());
    }

    public final InterfaceC0559c h() {
        String readString = ((C0558b) this).f5763e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (InterfaceC0559c) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e7.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
        }
    }

    public abstract void i(int i4);

    public final void j(int i4, int i5) {
        i(i5);
        ((C0558b) this).f5763e.writeInt(i4);
    }

    public final void k(Parcelable parcelable, int i4) {
        i(i4);
        ((C0558b) this).f5763e.writeParcelable(parcelable, 0);
    }

    public final void l(InterfaceC0559c interfaceC0559c) {
        if (interfaceC0559c == null) {
            ((C0558b) this).f5763e.writeString(null);
            return;
        }
        try {
            ((C0558b) this).f5763e.writeString(b(interfaceC0559c.getClass()).getName());
            C0558b a4 = a();
            try {
                d(interfaceC0559c.getClass()).invoke(null, interfaceC0559c, a4);
                Parcel parcel = a4.f5763e;
                int i4 = a4.f5767i;
                if (i4 >= 0) {
                    int i5 = a4.f5762d.get(i4);
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i5);
                    parcel.writeInt(dataPosition - i5);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
            } catch (InvocationTargetException e7) {
                if (e7.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e7.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(interfaceC0559c.getClass().getSimpleName().concat(" does not have a Parcelizer"), e8);
        }
    }
}
