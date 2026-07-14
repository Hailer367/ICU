package j$.time.format;

/* loaded from: classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final char f4648a;

    public c(char c4) {
        this.f4648a = c4;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        sb.append(this.f4648a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i4) {
        if (i4 == charSequence.length()) {
            return ~i4;
        }
        char charAt = charSequence.charAt(i4);
        char c4 = this.f4648a;
        return (charAt == c4 || (!pVar.f4685b && (Character.toUpperCase(charAt) == Character.toUpperCase(c4) || Character.toLowerCase(charAt) == Character.toLowerCase(c4)))) ? i4 + 1 : ~i4;
    }

    public final String toString() {
        char c4 = this.f4648a;
        if (c4 == '\'') {
            return "''";
        }
        return "'" + c4 + "'";
    }
}
