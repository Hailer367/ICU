package j$.time.format;

/* loaded from: classes2.dex */
public final class m implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f4673a;

    public m(String str) {
        this.f4673a = str;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        sb.append(this.f4673a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i4) {
        if (i4 > charSequence.length() || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.f4673a;
        return !pVar.g(charSequence, i4, str, 0, str.length()) ? ~i4 : str.length() + i4;
    }

    public final String toString() {
        return "'" + this.f4673a.replace("'", "''") + "'";
    }
}
