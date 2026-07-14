package j$.time.format;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public String f4667a;

    /* renamed from: b, reason: collision with root package name */
    public String f4668b;

    /* renamed from: c, reason: collision with root package name */
    public final char f4669c;

    /* renamed from: d, reason: collision with root package name */
    public k f4670d;

    /* renamed from: e, reason: collision with root package name */
    public k f4671e;

    public boolean b(char c4, char c5) {
        return c4 == c5;
    }

    public k(String str, String str2, k kVar) {
        this.f4667a = str;
        this.f4668b = str2;
        this.f4670d = kVar;
        if (str.isEmpty()) {
            this.f4669c = (char) 65535;
        } else {
            this.f4669c = this.f4667a.charAt(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        r0 = r0.f4671e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        r6.setIndex(r2);
        r5 = r0.c(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r5 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r2 != r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (b(r0.f4669c, r5.charAt(r2)) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c(java.lang.CharSequence r5, java.text.ParsePosition r6) {
        /*
            r4 = this;
            int r0 = r6.getIndex()
            int r1 = r5.length()
            boolean r2 = r4.e(r5, r0, r1)
            if (r2 != 0) goto L10
            r5 = 0
            return r5
        L10:
            java.lang.String r2 = r4.f4667a
            int r2 = r2.length()
            int r2 = r2 + r0
            j$.time.format.k r0 = r4.f4670d
            if (r0 == 0) goto L37
            if (r2 == r1) goto L37
        L1d:
            char r1 = r0.f4669c
            char r3 = r5.charAt(r2)
            boolean r1 = r4.b(r1, r3)
            if (r1 == 0) goto L33
            r6.setIndex(r2)
            java.lang.String r5 = r0.c(r5, r6)
            if (r5 == 0) goto L37
            return r5
        L33:
            j$.time.format.k r0 = r0.f4671e
            if (r0 != 0) goto L1d
        L37:
            r6.setIndex(r2)
            java.lang.String r5 = r4.f4668b
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.k.c(java.lang.CharSequence, java.text.ParsePosition):java.lang.String");
    }

    public k d(String str, String str2, k kVar) {
        return new k(str, str2, kVar);
    }

    public boolean e(CharSequence charSequence, int i4, int i5) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f4667a, i4);
        }
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
            if (!b(this.f4667a.charAt(i6), charSequence.charAt(i4))) {
                return false;
            }
            i4 = i9;
            length = i7;
            i6 = i8;
        }
    }

    public final boolean a(String str, String str2) {
        int i4 = 0;
        while (i4 < str.length() && i4 < this.f4667a.length() && b(str.charAt(i4), this.f4667a.charAt(i4))) {
            i4++;
        }
        if (i4 == this.f4667a.length()) {
            if (i4 < str.length()) {
                String substring = str.substring(i4);
                for (k kVar = this.f4670d; kVar != null; kVar = kVar.f4671e) {
                    if (b(kVar.f4669c, substring.charAt(0))) {
                        return kVar.a(substring, str2);
                    }
                }
                k d4 = d(substring, str2, null);
                d4.f4671e = this.f4670d;
                this.f4670d = d4;
                return true;
            }
            this.f4668b = str2;
            return true;
        }
        k d5 = d(this.f4667a.substring(i4), this.f4668b, this.f4670d);
        this.f4667a = str.substring(0, i4);
        this.f4670d = d5;
        if (i4 < str.length()) {
            this.f4670d.f4671e = d(str.substring(i4), str2, null);
            this.f4668b = null;
            return true;
        }
        this.f4668b = str2;
        return true;
    }
}
