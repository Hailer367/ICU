package j$.time.format;

/* loaded from: classes2.dex */
public class h implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final long[] f4655f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f4656a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4657b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4658c;

    /* renamed from: d, reason: collision with root package name */
    public final y f4659d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4660e;

    public h(j$.time.temporal.q qVar, int i4, int i5, y yVar) {
        this.f4656a = qVar;
        this.f4657b = i4;
        this.f4658c = i5;
        this.f4659d = yVar;
        this.f4660e = 0;
    }

    public h(j$.time.temporal.q qVar, int i4, int i5, y yVar, int i6) {
        this.f4656a = qVar;
        this.f4657b = i4;
        this.f4658c = i5;
        this.f4659d = yVar;
        this.f4660e = i6;
    }

    public h b() {
        if (this.f4660e == -1) {
            return this;
        }
        return new h(this.f4656a, this.f4657b, this.f4658c, this.f4659d, -1);
    }

    public h c(int i4) {
        return new h(this.f4656a, this.f4657b, this.f4658c, this.f4659d, this.f4660e + i4);
    }

    @Override // j$.time.format.e
    public boolean s(s sVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f4656a;
        Long a4 = sVar.a(qVar);
        if (a4 == null) {
            return false;
        }
        long longValue = a4.longValue();
        v vVar = sVar.f4693b.f4642c;
        String l3 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l3.length();
        int i4 = this.f4658c;
        if (length > i4) {
            throw new RuntimeException("Field " + qVar + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i4);
        }
        vVar.getClass();
        int i5 = this.f4657b;
        y yVar = this.f4659d;
        if (longValue >= 0) {
            int i6 = b.f4647a[yVar.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    sb.append('+');
                }
            } else if (i5 < 19 && longValue >= f4655f[i5]) {
                sb.append('+');
            }
        } else {
            int i7 = b.f4647a[yVar.ordinal()];
            if (i7 == 1 || i7 == 2 || i7 == 3) {
                sb.append('-');
            } else if (i7 == 4) {
                throw new RuntimeException("Field " + qVar + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i8 = 0; i8 < i5 - l3.length(); i8++) {
            sb.append('0');
        }
        sb.append(l3);
        return true;
    }

    public boolean a(p pVar) {
        int i4 = this.f4660e;
        if (i4 != -1) {
            return i4 > 0 && this.f4657b == this.f4658c && this.f4659d == y.NOT_NEGATIVE;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0135, code lost:
    
        r6 = r12;
        r4 = r20;
     */
    @Override // j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int A(j$.time.format.p r28, java.lang.CharSequence r29, int r30) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.h.A(j$.time.format.p, java.lang.CharSequence, int):int");
    }

    public String toString() {
        int i4 = this.f4658c;
        j$.time.temporal.q qVar = this.f4656a;
        y yVar = this.f4659d;
        int i5 = this.f4657b;
        if (i5 == 1 && i4 == 19 && yVar == y.NORMAL) {
            return "Value(" + qVar + ")";
        }
        if (i5 == i4 && yVar == y.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i5 + ")";
        }
        return "Value(" + qVar + "," + i5 + "," + i4 + "," + yVar + ")";
    }
}
