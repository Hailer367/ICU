package j$.time.format;

import com.google.firebase.encoders.json.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class f extends h {

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2554g;

    @Override // j$.time.format.h, j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i2) {
        boolean z = pVar.f2589c;
        DateTimeFormatter dateTimeFormatter = pVar.f2587a;
        int i3 = (z || a(pVar)) ? this.f2560b : 0;
        int i4 = (pVar.f2589c || a(pVar)) ? this.f2561c : 9;
        int length = charSequence.length();
        if (i2 != length) {
            if (this.f2554g) {
                char charAt = charSequence.charAt(i2);
                dateTimeFormatter.f2545c.getClass();
                if (charAt == '.') {
                    i2++;
                } else if (i3 > 0) {
                    return ~i2;
                }
            }
            int i5 = i2;
            int i6 = i3 + i5;
            if (i6 > length) {
                return ~i5;
            }
            int min = Math.min(i4 + i5, length);
            int i7 = 0;
            int i8 = i5;
            while (true) {
                if (i8 >= min) {
                    break;
                }
                int i9 = i8 + 1;
                char charAt2 = charSequence.charAt(i8);
                dateTimeFormatter.f2545c.getClass();
                int i10 = charAt2 - '0';
                if (i10 < 0 || i10 > 9) {
                    i10 = -1;
                }
                if (i10 >= 0) {
                    i7 = (i7 * 10) + i10;
                    i8 = i9;
                } else if (i9 < i6) {
                    return ~i5;
                }
            }
            BigDecimal movePointLeft = new BigDecimal(i7).movePointLeft(i8 - i5);
            j$.time.temporal.u I2 = this.f2559a.I();
            BigDecimal valueOf = BigDecimal.valueOf(I2.f2675a);
            return pVar.f(this.f2559a, movePointLeft.multiply(BigDecimal.valueOf(I2.f2678d).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i5, i8);
        }
        if (i3 > 0) {
            return ~i2;
        }
        return i2;
    }

    @Override // j$.time.format.h
    public final boolean a(p pVar) {
        return pVar.f2589c && this.f2560b == this.f2561c && !this.f2554g;
    }

    public f(j$.time.temporal.q qVar) {
        this(qVar, 0, 9, true, 0);
        Objects.requireNonNull(qVar, "field");
        j$.time.temporal.u I2 = qVar.I();
        if (I2.f2675a != I2.f2676b || I2.f2677c != I2.f2678d) {
            throw new IllegalArgumentException(j$.time.d.a("Field must have a fixed set of values: ", qVar));
        }
    }

    public f(j$.time.temporal.q qVar, int i2, int i3, boolean z, int i4) {
        super(qVar, i2, i3, y.NOT_NEGATIVE, i4);
        this.f2554g = z;
    }

    @Override // j$.time.format.h
    public final h b() {
        if (this.f2563e == -1) {
            return this;
        }
        return new f(this.f2559a, this.f2560b, this.f2561c, this.f2554g, -1);
    }

    @Override // j$.time.format.h
    public final h c(int i2) {
        return new f(this.f2559a, this.f2560b, this.f2561c, this.f2554g, this.f2563e + i2);
    }

    @Override // j$.time.format.h, j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f2559a;
        Long a2 = sVar.a(qVar);
        if (a2 == null) {
            return false;
        }
        v vVar = sVar.f2596b.f2545c;
        long longValue = a2.longValue();
        j$.time.temporal.u I2 = qVar.I();
        I2.b(longValue, qVar);
        BigDecimal valueOf = BigDecimal.valueOf(I2.f2675a);
        BigDecimal add = BigDecimal.valueOf(I2.f2678d).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z = this.f2554g;
        int i2 = this.f2560b;
        if (scale != 0) {
            String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i2), this.f2561c), roundingMode).toPlainString().substring(2);
            vVar.getClass();
            if (z) {
                sb.append('.');
            }
            sb.append(substring);
            return true;
        }
        if (i2 > 0) {
            if (z) {
                vVar.getClass();
                sb.append('.');
            }
            for (int i3 = 0; i3 < i2; i3++) {
                vVar.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.h
    public final String toString() {
        return "Fraction(" + this.f2559a + "," + this.f2560b + "," + this.f2561c + (this.f2554g ? ",DecimalPoint" : BuildConfig.FLAVOR) + ")";
    }
}
