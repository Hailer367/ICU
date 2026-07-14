package V1;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c implements WildcardType, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public final Type f1724f;

    /* renamed from: g, reason: collision with root package name */
    public final Type f1725g;

    public c(Type[] typeArr, Type[] typeArr2) {
        boolean z;
        boolean z3;
        if (typeArr2.length <= 1) {
            z = true;
        } else {
            z = false;
        }
        d.b(z);
        if (typeArr.length == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        d.b(z3);
        if (typeArr2.length == 1) {
            Objects.requireNonNull(typeArr2[0]);
            d.c(typeArr2[0]);
            d.b(typeArr[0] == Object.class);
            this.f1725g = d.a(typeArr2[0]);
            this.f1724f = Object.class;
            return;
        }
        Objects.requireNonNull(typeArr[0]);
        d.c(typeArr[0]);
        this.f1725g = null;
        this.f1724f = d.a(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof WildcardType) && d.e(this, (WildcardType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f1725g;
        if (type != null) {
            return new Type[]{type};
        }
        return d.f1726a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f1724f};
    }

    public final int hashCode() {
        int i4;
        Type type = this.f1725g;
        if (type != null) {
            i4 = type.hashCode() + 31;
        } else {
            i4 = 1;
        }
        return i4 ^ (this.f1724f.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f1725g;
        if (type != null) {
            return "? super " + d.l(type);
        }
        Type type2 = this.f1724f;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + d.l(type2);
    }
}
