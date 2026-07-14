package W0;

import R0.e;
import java.io.Serializable;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class b extends e implements a, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Enum[] f824c;

    public b(Enum[] entries) {
        h.e(entries, "entries");
        this.f824c = entries;
    }

    @Override // R0.e
    public final int a() {
        return this.f824c.length;
    }

    @Override // R0.e, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        Enum r02;
        if (obj instanceof Enum) {
            Enum element = (Enum) obj;
            h.e(element, "element");
            int ordinal = element.ordinal();
            Enum[] enumArr = this.f824c;
            h.e(enumArr, "<this>");
            if (ordinal >= 0 && ordinal < enumArr.length) {
                r02 = enumArr[ordinal];
            } else {
                r02 = null;
            }
            if (r02 == element) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        Enum[] enumArr = this.f824c;
        int length = enumArr.length;
        if (i2 >= 0 && i2 < length) {
            return enumArr[i2];
        }
        throw new IndexOutOfBoundsException(O.a.d("index: ", i2, ", size: ", length));
    }

    @Override // R0.e, java.util.List
    public final int indexOf(Object obj) {
        Enum r2;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        h.e(element, "element");
        int ordinal = element.ordinal();
        Enum[] enumArr = this.f824c;
        h.e(enumArr, "<this>");
        if (ordinal >= 0 && ordinal < enumArr.length) {
            r2 = enumArr[ordinal];
        } else {
            r2 = null;
        }
        if (r2 != element) {
            return -1;
        }
        return ordinal;
    }

    @Override // R0.e, java.util.List
    public final int lastIndexOf(Object obj) {
        Enum r2;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        h.e(element, "element");
        int ordinal = element.ordinal();
        Enum[] enumArr = this.f824c;
        h.e(enumArr, "<this>");
        if (ordinal >= 0 && ordinal < enumArr.length) {
            r2 = enumArr[ordinal];
        } else {
            r2 = null;
        }
        if (r2 != element) {
            return -1;
        }
        return ordinal;
    }
}
