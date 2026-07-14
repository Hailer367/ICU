package j$.time.format;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public String f2570a;

    /* renamed from: b, reason: collision with root package name */
    public String f2571b;

    /* renamed from: c, reason: collision with root package name */
    public final char f2572c;

    /* renamed from: d, reason: collision with root package name */
    public k f2573d;

    /* renamed from: e, reason: collision with root package name */
    public k f2574e;

    public boolean b(char c2, char c3) {
        return c2 == c3;
    }

    public k(String str, String str2, k kVar) {
        this.f2570a = str;
        this.f2571b = str2;
        this.f2573d = kVar;
        if (str.isEmpty()) {
            this.f2572c = (char) 65535;
        } else {
            this.f2572c = this.f2570a.charAt(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        r0 = r0.f2574e;
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
    
        if (b(r0.f2572c, r5.charAt(r2)) == false) goto L14;
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
            java.lang.String r2 = r4.f2570a
            int r2 = r2.length()
            int r2 = r2 + r0
            j$.time.format.k r0 = r4.f2573d
            if (r0 == 0) goto L37
            if (r2 == r1) goto L37
        L1d:
            char r1 = r0.f2572c
            char r3 = r5.charAt(r2)
            boolean r1 = r4.b(r1, r3)
            if (r1 == 0) goto L33
            r6.setIndex(r2)
            java.lang.String r5 = r0.c(r5, r6)
            if (r5 == 0) goto L37
            return r5
        L33:
            j$.time.format.k r0 = r0.f2574e
            if (r0 != 0) goto L1d
        L37:
            r6.setIndex(r2)
            java.lang.String r5 = r4.f2571b
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.k.c(java.lang.CharSequence, java.text.ParsePosition):java.lang.String");
    }

    public k d(String str, String str2, k kVar) {
        return new k(str, str2, kVar);
    }

    public boolean e(CharSequence charSequence, int i2, int i3) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f2570a, i2);
        }
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
            if (!b(this.f2570a.charAt(i4), charSequence.charAt(i2))) {
                return false;
            }
            i2 = i7;
            length = i5;
            i4 = i6;
        }
    }

    public final boolean a(String str, String str2) {
        int i2 = 0;
        while (i2 < str.length() && i2 < this.f2570a.length() && b(str.charAt(i2), this.f2570a.charAt(i2))) {
            i2++;
        }
        if (i2 == this.f2570a.length()) {
            if (i2 < str.length()) {
                String substring = str.substring(i2);
                for (k kVar = this.f2573d; kVar != null; kVar = kVar.f2574e) {
                    if (b(kVar.f2572c, substring.charAt(0))) {
                        return kVar.a(substring, str2);
                    }
                }
                k d2 = d(substring, str2, null);
                d2.f2574e = this.f2573d;
                this.f2573d = d2;
                return true;
            }
            this.f2571b = str2;
            return true;
        }
        k d3 = d(this.f2570a.substring(i2), this.f2571b, this.f2573d);
        this.f2570a = str.substring(0, i2);
        this.f2573d = d3;
        if (i2 < str.length()) {
            this.f2573d.f2574e = d(str.substring(i2), str2, null);
            this.f2571b = null;
            return true;
        }
        this.f2571b = str2;
        return true;
    }
}
