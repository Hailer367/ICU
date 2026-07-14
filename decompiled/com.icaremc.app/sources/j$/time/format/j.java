package j$.time.format;

/* loaded from: classes2.dex */
public final class j extends k {
    @Override // j$.time.format.k
    public final k d(String str, String str2, k kVar) {
        return new k(str, str2, kVar);
    }

    @Override // j$.time.format.k
    public final boolean b(char c4, char c5) {
        return p.b(c4, c5);
    }

    @Override // j$.time.format.k
    public final boolean e(CharSequence charSequence, int i4, int i5) {
        int length = this.f4667a.length();
        if (length > i5 - i4) {
            return false;
        }
        int i6 = 0;
        while (true) {
            int i7 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i8 = i6 + 1;
            int i9 = i4 + 1;
            if (!p.b(this.f4667a.charAt(i6), charSequence.charAt(i4))) {
                return false;
            }
            i4 = i9;
            length = i7;
            i6 = i8;
        }
    }
}
