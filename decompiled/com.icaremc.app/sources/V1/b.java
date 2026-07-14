package V1;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b implements ParameterizedType, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Type f1721f;

    /* renamed from: g, reason: collision with root package name */
    public final Type f1722g;

    /* renamed from: h, reason: collision with root package name */
    public final Type[] f1723h;

    public b(Type type, Class cls, Type... typeArr) {
        Type a4;
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            throw new IllegalArgumentException("Must specify owner type for " + cls);
        }
        if (type == null) {
            a4 = null;
        } else {
            a4 = d.a(type);
        }
        this.f1721f = a4;
        this.f1722g = d.a(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f1723h = typeArr2;
        int length = typeArr2.length;
        for (int i4 = 0; i4 < length; i4++) {
            Objects.requireNonNull(this.f1723h[i4]);
            d.c(this.f1723h[i4]);
            Type[] typeArr3 = this.f1723h;
            typeArr3[i4] = d.a(typeArr3[i4]);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ParameterizedType) && d.e(this, (ParameterizedType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f1723h.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f1721f;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f1722g;
    }

    public final int hashCode() {
        int i4;
        int hashCode = Arrays.hashCode(this.f1723h) ^ this.f1722g.hashCode();
        Type type = this.f1721f;
        if (type != null) {
            i4 = type.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode ^ i4;
    }

    public final String toString() {
        Type[] typeArr = this.f1723h;
        int length = typeArr.length;
        Type type = this.f1722g;
        if (length == 0) {
            return d.l(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(d.l(type));
        sb.append("<");
        sb.append(d.l(typeArr[0]));
        for (int i4 = 1; i4 < length; i4++) {
            sb.append(", ");
            sb.append(d.l(typeArr[i4]));
        }
        sb.append(">");
        return sb.toString();
    }
}
