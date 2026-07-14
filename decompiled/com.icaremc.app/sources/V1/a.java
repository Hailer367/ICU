package V1;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a implements GenericArrayType, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Type f1720f;

    public a(Type type) {
        Objects.requireNonNull(type);
        this.f1720f = d.a(type);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof GenericArrayType) && d.e(this, (GenericArrayType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f1720f;
    }

    public final int hashCode() {
        return this.f1720f.hashCode();
    }

    public final String toString() {
        return d.l(this.f1720f) + "[]";
    }
}
