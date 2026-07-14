package j$.time.format;

/* loaded from: classes2.dex */
public class h implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final long[] f2558f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f2559a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2560b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2561c;

    /* renamed from: d, reason: collision with root package name */
    public final y f2562d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2563e;

    public h(j$.time.temporal.q qVar, int i2, int i3, y yVar) {
        this.f2559a = qVar;
        this.f2560b = i2;
        this.f2561c = i3;
        this.f2562d = yVar;
        this.f2563e = 0;
    }

    public h(j$.time.temporal.q qVar, int i2, int i3, y yVar, int i4) {
        this.f2559a = qVar;
        this.f2560b = i2;
        this.f2561c = i3;
        this.f2562d = yVar;
        this.f2563e = i4;
    }

    public h b() {
        if (this.f2563e == -1) {
            return this;
        }
        return new h(this.f2559a, this.f2560b, this.f2561c, this.f2562d, -1);
    }

    public h c(int i2) {
        return new h(this.f2559a, this.f2560b, this.f2561c, this.f2562d, this.f2563e + i2);
    }

    @Override // j$.time.format.e
    public boolean s(s sVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f2559a;
        Long a2 = sVar.a(qVar);
        if (a2 == null) {
            return false;
        }
        long longValue = a2.longValue();
        v vVar = sVar.f2596b.f2545c;
        String l2 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l2.length();
        int i2 = this.f2561c;
        if (length > i2) {
            throw new RuntimeException("Field " + qVar + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i2);
        }
        vVar.getClass();
        int i3 = this.f2560b;
        y yVar = this.f2562d;
        if (longValue >= 0) {
            int i4 = b.f2550a[yVar.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    sb.append('+');
                }
            } else if (i3 < 19 && longValue >= f2558f[i3]) {
                sb.append('+');
            }
        } else {
            int i5 = b.f2550a[yVar.ordinal()];
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                sb.append('-');
            } else if (i5 == 4) {
                throw new RuntimeException("Field " + qVar + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i6 = 0; i6 < i3 - l2.length(); i6++) {
            sb.append('0');
        }
        sb.append(l2);
        return true;
    }

    public boolean a(p pVar) {
        int i2 = this.f2563e;
        if (i2 != -1) {
            return i2 > 0 && this.f2560b == this.f2561c && this.f2562d == y.NOT_NEGATIVE;
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
        int i2 = this.f2561c;
        j$.time.temporal.q qVar = this.f2559a;
        y yVar = this.f2562d;
        int i3 = this.f2560b;
        if (i3 == 1 && i2 == 19 && yVar == y.NORMAL) {
            return "Value(" + qVar + ")";
        }
        if (i3 == i2 && yVar == y.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i3 + ")";
        }
        return "Value(" + qVar + "," + i3 + "," + i2 + "," + yVar + ")";
    }
}
