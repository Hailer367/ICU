package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class f extends h {

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4651g;

    @Override // j$.time.format.h, j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i4) {
        boolean z = pVar.f4686c;
        DateTimeFormatter dateTimeFormatter = pVar.f4684a;
        int i5 = (z || a(pVar)) ? this.f4657b : 0;
        int i6 = (pVar.f4686c || a(pVar)) ? this.f4658c : 9;
        int length = charSequence.length();
        if (i4 != length) {
            if (this.f4651g) {
                char charAt = charSequence.charAt(i4);
                dateTimeFormatter.f4642c.getClass();
                if (charAt == '.') {
                    i4++;
                } else if (i5 > 0) {
                    return ~i4;
                }
            }
            int i7 = i4;
            int i8 = i5 + i7;
            if (i8 > length) {
                return ~i7;
            }
            int min = Math.min(i6 + i7, length);
            int i9 = 0;
            int i10 = i7;
            while (true) {
                if (i10 >= min) {
                    break;
                }
                int i11 = i10 + 1;
                char charAt2 = charSequence.charAt(i10);
                dateTimeFormatter.f4642c.getClass();
                int i12 = charAt2 - '0';
                if (i12 < 0 || i12 > 9) {
                    i12 = -1;
                }
                if (i12 >= 0) {
                    i9 = (i9 * 10) + i12;
                    i10 = i11;
                } else if (i11 < i8) {
                    return ~i7;
                }
            }
            BigDecimal movePointLeft = new BigDecimal(i9).movePointLeft(i10 - i7);
            j$.time.temporal.u I3 = this.f4656a.I();
            BigDecimal valueOf = BigDecimal.valueOf(I3.f4772a);
            return pVar.f(this.f4656a, movePointLeft.multiply(BigDecimal.valueOf(I3.f4775d).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i7, i10);
        }
        if (i5 > 0) {
            return ~i4;
        }
        return i4;
    }

    @Override // j$.time.format.h
    public final boolean a(p pVar) {
        return pVar.f4686c && this.f4657b == this.f4658c && !this.f4651g;
    }

    public f(j$.time.temporal.q qVar) {
        this(qVar, 0, 9, true, 0);
        Objects.requireNonNull(qVar, "field");
        j$.time.temporal.u I3 = qVar.I();
        if (I3.f4772a != I3.f4773b || I3.f4774c != I3.f4775d) {
            throw new IllegalArgumentException(j$.time.d.a("Field must have a fixed set of values: ", qVar));
        }
    }

    public f(j$.time.temporal.q qVar, int i4, int i5, boolean z, int i6) {
        super(qVar, i4, i5, y.NOT_NEGATIVE, i6);
        this.f4651g = z;
    }

    @Override // j$.time.format.h
    public final h b() {
        if (this.f4660e == -1) {
            return this;
        }
        return new f(this.f4656a, this.f4657b, this.f4658c, this.f4651g, -1);
    }

    @Override // j$.time.format.h
    public final h c(int i4) {
        return new f(this.f4656a, this.f4657b, this.f4658c, this.f4651g, this.f4660e + i4);
    }

    @Override // j$.time.format.h, j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f4656a;
        Long a4 = sVar.a(qVar);
        if (a4 == null) {
            return false;
        }
        v vVar = sVar.f4693b.f4642c;
        long longValue = a4.longValue();
        j$.time.temporal.u I3 = qVar.I();
        I3.b(longValue, qVar);
        BigDecimal valueOf = BigDecimal.valueOf(I3.f4772a);
        BigDecimal add = BigDecimal.valueOf(I3.f4775d).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z = this.f4651g;
        int i4 = this.f4657b;
        if (scale != 0) {
            String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i4), this.f4658c), roundingMode).toPlainString().substring(2);
            vVar.getClass();
            if (z) {
                sb.append('.');
            }
            sb.append(substring);
            return true;
        }
        if (i4 > 0) {
            if (z) {
                vVar.getClass();
                sb.append('.');
            }
            for (int i5 = 0; i5 < i4; i5++) {
                vVar.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.h
    public final String toString() {
        return "Fraction(" + this.f4656a + "," + this.f4657b + "," + this.f4658c + (this.f4651g ? ",DecimalPoint" : "") + ")";
    }
}
