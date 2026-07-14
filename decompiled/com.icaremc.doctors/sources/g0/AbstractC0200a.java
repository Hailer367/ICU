package g0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import r.C0293e;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0200a {

    /* renamed from: a, reason: collision with root package name */
    public final C0293e f2287a;

    /* renamed from: b, reason: collision with root package name */
    public final C0293e f2288b;

    /* renamed from: c, reason: collision with root package name */
    public final C0293e f2289c;

    public AbstractC0200a(C0293e c0293e, C0293e c0293e2, C0293e c0293e3) {
        this.f2287a = c0293e;
        this.f2288b = c0293e2;
        this.f2289c = c0293e3;
    }

    public abstract b a();

    public final Class b(Class cls) {
        String name = cls.getName();
        C0293e c0293e = this.f2289c;
        Class cls2 = (Class) c0293e.get(name);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
            c0293e.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public final Method c(String str) {
        C0293e c0293e = this.f2287a;
        Method method = (Method) c0293e.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC0200a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0200a.class);
            c0293e.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        C0293e c0293e = this.f2288b;
        Method method = (Method) c0293e.get(name);
        if (method == null) {
            Class b2 = b(cls);
            System.currentTimeMillis();
            Method declaredMethod = b2.getDeclaredMethod("write", cls, AbstractC0200a.class);
            c0293e.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public abstract boolean e(int i2);

    public final int f(int i2, int i3) {
        if (!e(i3)) {
            return i2;
        }
        return ((b) this).f2291e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i2) {
        if (!e(i2)) {
            return parcelable;
        }
        return ((b) this).f2291e.readParcelable(b.class.getClassLoader());
    }

    public final c h() {
        String readString = ((b) this).f2291e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (c) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public abstract void i(int i2);

    public final void j(int i2, int i3) {
        i(i3);
        ((b) this).f2291e.writeInt(i2);
    }

    public final void k(Parcelable parcelable, int i2) {
        i(i2);
        ((b) this).f2291e.writeParcelable(parcelable, 0);
    }

    public final void l(c cVar) {
        if (cVar == null) {
            ((b) this).f2291e.writeString(null);
            return;
        }
        try {
            ((b) this).f2291e.writeString(b(cVar.getClass()).getName());
            b a2 = a();
            try {
                d(cVar.getClass()).invoke(null, cVar, a2);
                Parcel parcel = a2.f2291e;
                int i2 = a2.f2295i;
                if (i2 >= 0) {
                    int i3 = a2.f2290d.get(i2);
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i3);
                    parcel.writeInt(dataPosition - i3);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
            } catch (InvocationTargetException e5) {
                if (e5.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e5.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
            }
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(cVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e6);
        }
    }
}
