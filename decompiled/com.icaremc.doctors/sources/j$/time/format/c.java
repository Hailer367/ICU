package j$.time.format;

/* loaded from: classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final char f2551a;

    public c(char c2) {
        this.f2551a = c2;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        sb.append(this.f2551a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i2) {
        if (i2 == charSequence.length()) {
            return ~i2;
        }
        char charAt = charSequence.charAt(i2);
        char c2 = this.f2551a;
        return (charAt == c2 || (!pVar.f2588b && (Character.toUpperCase(charAt) == Character.toUpperCase(c2) || Character.toLowerCase(charAt) == Character.toLowerCase(c2)))) ? i2 + 1 : ~i2;
    }

    public final String toString() {
        char c2 = this.f2551a;
        if (c2 == '\'') {
            return "''";
        }
        return "'" + c2 + "'";
    }
}
