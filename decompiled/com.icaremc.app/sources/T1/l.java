package T1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes.dex */
public final class l extends h {

    /* renamed from: f, reason: collision with root package name */
    public final Serializable f1622f;

    public l(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f1622f = bool;
    }

    public static boolean g(l lVar) {
        Serializable serializable = lVar.f1622f;
        if (serializable instanceof Number) {
            Number number = (Number) serializable;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // T1.h
    public final boolean a() {
        Serializable serializable = this.f1622f;
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).booleanValue();
        }
        return Boolean.parseBoolean(c());
    }

    @Override // T1.h
    public final String c() {
        Serializable serializable = this.f1622f;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return f().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final BigInteger d() {
        Serializable serializable = this.f1622f;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (g(this)) {
            return BigInteger.valueOf(f().longValue());
        }
        String c4 = c();
        V1.d.d(c4);
        return new BigInteger(c4);
    }

    public final double e() {
        if (this.f1622f instanceof Number) {
            return f().doubleValue();
        }
        return Double.parseDouble(c());
    }

    public final boolean equals(Object obj) {
        BigDecimal j4;
        BigDecimal j5;
        if (this != obj) {
            if (obj != null && l.class == obj.getClass()) {
                l lVar = (l) obj;
                Serializable serializable = lVar.f1622f;
                Serializable serializable2 = this.f1622f;
                if (serializable2 == null) {
                    if (serializable == null) {
                        return true;
                    }
                    return false;
                }
                if (g(this) && g(lVar)) {
                    if (!(serializable2 instanceof BigInteger) && !(serializable instanceof BigInteger)) {
                        if (f().longValue() == lVar.f().longValue()) {
                            return true;
                        }
                        return false;
                    }
                    return d().equals(lVar.d());
                }
                if ((serializable2 instanceof Number) && (serializable instanceof Number)) {
                    if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
                        if (serializable2 instanceof BigDecimal) {
                            j4 = (BigDecimal) serializable2;
                        } else {
                            j4 = V1.d.j(c());
                        }
                        if (serializable instanceof BigDecimal) {
                            j5 = (BigDecimal) serializable;
                        } else {
                            j5 = V1.d.j(lVar.c());
                        }
                        if (j4.compareTo(j5) == 0) {
                            return true;
                        }
                        return false;
                    }
                    double e4 = e();
                    double e5 = lVar.e();
                    if (e4 != e5) {
                        if (Double.isNaN(e4) && Double.isNaN(e5)) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                return serializable2.equals(serializable);
            }
            return false;
        }
        return true;
    }

    public final Number f() {
        Serializable serializable = this.f1622f;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new V1.j((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.f1622f;
        if (serializable == null) {
            return 31;
        }
        if (g(this)) {
            doubleToLongBits = f().longValue();
        } else if (serializable instanceof Number) {
            doubleToLongBits = Double.doubleToLongBits(f().doubleValue());
        } else {
            return serializable.hashCode();
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public l(Number number) {
        Objects.requireNonNull(number);
        this.f1622f = number;
    }

    public l(String str) {
        Objects.requireNonNull(str);
        this.f1622f = str;
    }
}
