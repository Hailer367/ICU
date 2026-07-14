package j$.time.format;

/* loaded from: classes2.dex */
public final class j extends k {
    @Override // j$.time.format.k
    public final k d(String str, String str2, k kVar) {
        return new k(str, str2, kVar);
    }

    @Override // j$.time.format.k
    public final boolean b(char c2, char c3) {
        return p.b(c2, c3);
    }

    @Override // j$.time.format.k
    public final boolean e(CharSequence charSequence, int i2, int i3) {
        int length = this.f2570a.length();
        if (length > i3 - i2) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i6 = i4 + 1;
            int i7 = i2 + 1;
            if (!p.b(this.f2570a.charAt(i4), charSequence.charAt(i2))) {
                return false;
            }
            i2 = i7;
            length = i5;
            i4 = i6;
        }
    }
}
