package j$.time.format;

/* loaded from: classes2.dex */
public final class m implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2576a;

    public m(String str) {
        this.f2576a = str;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        sb.append(this.f2576a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i2) {
        if (i2 > charSequence.length() || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.f2576a;
        return !pVar.g(charSequence, i2, str, 0, str.length()) ? ~i2 : str.length() + i2;
    }

    public final String toString() {
        return "'" + this.f2576a.replace("'", "''") + "'";
    }
}
