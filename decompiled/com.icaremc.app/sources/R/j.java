package R;

import androidx.datastore.preferences.protobuf.AbstractC0163u;
import androidx.datastore.preferences.protobuf.AbstractC0165w;
import androidx.datastore.preferences.protobuf.C0150g;
import androidx.datastore.preferences.protobuf.S;
import androidx.datastore.preferences.protobuf.V;

/* loaded from: classes.dex */
public final class j extends AbstractC0165w {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final j DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile S PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        AbstractC0165w.j(j.class, jVar);
    }

    public static h D() {
        return (h) ((AbstractC0163u) DEFAULT_INSTANCE.c(5));
    }

    public static void l(j jVar, long j4) {
        jVar.valueCase_ = 4;
        jVar.value_ = Long.valueOf(j4);
    }

    public static void m(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.valueCase_ = 5;
        jVar.value_ = str;
    }

    public static void n(j jVar, g gVar) {
        jVar.getClass();
        jVar.value_ = gVar;
        jVar.valueCase_ = 6;
    }

    public static void o(j jVar, double d4) {
        jVar.valueCase_ = 7;
        jVar.value_ = Double.valueOf(d4);
    }

    public static void p(j jVar, C0150g c0150g) {
        jVar.getClass();
        jVar.valueCase_ = 8;
        jVar.value_ = c0150g;
    }

    public static void q(j jVar, boolean z) {
        jVar.valueCase_ = 1;
        jVar.value_ = Boolean.valueOf(z);
    }

    public static void r(j jVar, float f4) {
        jVar.valueCase_ = 2;
        jVar.value_ = Float.valueOf(f4);
    }

    public static void s(j jVar, int i4) {
        jVar.valueCase_ = 3;
        jVar.value_ = Integer.valueOf(i4);
    }

    public static j v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        if (this.valueCase_ == 5) {
            return (String) this.value_;
        }
        return "";
    }

    public final g B() {
        if (this.valueCase_ == 6) {
            return (g) this.value_;
        }
        return g.m();
    }

    public final int C() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case DOUBLE_FIELD_NUMBER /* 7 */:
                return 7;
            case BYTES_FIELD_NUMBER /* 8 */:
                return 8;
            default:
                return 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object, androidx.datastore.preferences.protobuf.S] */
    @Override // androidx.datastore.preferences.protobuf.AbstractC0165w
    public final Object c(int i4) {
        S s3;
        switch (i.b(i4)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new V(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", g.class});
            case 3:
                return new j();
            case 4:
                return new AbstractC0163u(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                S s4 = PARSER;
                if (s4 == null) {
                    synchronized (j.class) {
                        try {
                            S s5 = PARSER;
                            s3 = s5;
                            if (s5 == null) {
                                ?? obj = new Object();
                                PARSER = obj;
                                s3 = obj;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return s3;
                }
                return s4;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final C0150g u() {
        if (this.valueCase_ == 8) {
            return (C0150g) this.value_;
        }
        return C0150g.f2634h;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
