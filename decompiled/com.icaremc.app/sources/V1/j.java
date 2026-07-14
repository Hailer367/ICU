package V1;

/* loaded from: classes.dex */
public final class j extends Number {

    /* renamed from: f, reason: collision with root package name */
    public final String f1740f;

    public j(String str) {
        this.f1740f = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f1740f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            return this.f1740f.equals(((j) obj).f1740f);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f1740f);
    }

    public final int hashCode() {
        return this.f1740f.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f1740f;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return d.j(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f1740f;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return d.j(str).longValue();
        }
    }

    public final String toString() {
        return this.f1740f;
    }
}
