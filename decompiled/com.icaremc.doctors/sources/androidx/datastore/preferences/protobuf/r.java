package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1465c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Y f1466a = Y.f();

    /* renamed from: b, reason: collision with root package name */
    public boolean f1467b;

    static {
        new r(0);
    }

    public r() {
    }

    public static void b(C0086m c0086m, r0 r0Var, int i2, Object obj) {
        if (r0Var == r0.f1469f) {
            c0086m.n0(i2, 3);
            ((AbstractC0074a) obj).b(c0086m);
            c0086m.n0(i2, 4);
            return;
        }
        c0086m.n0(i2, r0Var.f1473d);
        switch (r0Var.ordinal()) {
            case 0:
                c0086m.h0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                c0086m.f0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                c0086m.r0(((Long) obj).longValue());
                return;
            case 3:
                c0086m.r0(((Long) obj).longValue());
                return;
            case 4:
                c0086m.j0(((Integer) obj).intValue());
                return;
            case 5:
                c0086m.h0(((Long) obj).longValue());
                return;
            case 6:
                c0086m.f0(((Integer) obj).intValue());
                return;
            case 7:
                c0086m.Z(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                return;
            case 8:
                if (obj instanceof C0080g) {
                    c0086m.d0((C0080g) obj);
                    return;
                } else {
                    c0086m.m0((String) obj);
                    return;
                }
            case 9:
                ((AbstractC0074a) obj).b(c0086m);
                return;
            case 10:
                AbstractC0074a abstractC0074a = (AbstractC0074a) obj;
                c0086m.getClass();
                c0086m.p0(((AbstractC0095w) abstractC0074a).a(null));
                abstractC0074a.b(c0086m);
                return;
            case 11:
                if (obj instanceof C0080g) {
                    c0086m.d0((C0080g) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                c0086m.p0(length);
                c0086m.a0(bArr, 0, length);
                return;
            case 12:
                c0086m.p0(((Integer) obj).intValue());
                return;
            case 13:
                c0086m.j0(((Integer) obj).intValue());
                return;
            case 14:
                c0086m.f0(((Integer) obj).intValue());
                return;
            case 15:
                c0086m.h0(((Long) obj).longValue());
                return;
            case 16:
                int intValue = ((Integer) obj).intValue();
                c0086m.p0((intValue >> 31) ^ (intValue << 1));
                return;
            case 17:
                long longValue = ((Long) obj).longValue();
                c0086m.r0((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
    }

    public final void a() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (this.f1467b) {
            return;
        }
        Y y = this.f1466a;
        int size = y.f1388c.size();
        for (int i2 = 0; i2 < size; i2++) {
            Map.Entry c2 = y.c(i2);
            if (c2.getValue() instanceof AbstractC0095w) {
                AbstractC0095w abstractC0095w = (AbstractC0095w) c2.getValue();
                abstractC0095w.getClass();
                T t2 = T.f1374c;
                t2.getClass();
                t2.a(abstractC0095w.getClass()).d(abstractC0095w);
                abstractC0095w.h();
            }
        }
        if (!y.f1390e) {
            if (y.f1388c.size() <= 0) {
                Iterator it = y.d().iterator();
                if (it.hasNext()) {
                    ((Map.Entry) it.next()).getKey().getClass();
                    throw new ClassCastException();
                }
            } else {
                y.c(0).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!y.f1390e) {
            if (y.f1389d.isEmpty()) {
                unmodifiableMap = Collections.EMPTY_MAP;
            } else {
                unmodifiableMap = Collections.unmodifiableMap(y.f1389d);
            }
            y.f1389d = unmodifiableMap;
            if (y.f1392g.isEmpty()) {
                unmodifiableMap2 = Collections.EMPTY_MAP;
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(y.f1392g);
            }
            y.f1392g = unmodifiableMap2;
            y.f1390e = true;
        }
        this.f1467b = true;
    }

    public final Object clone() {
        r rVar = new r();
        Y y = this.f1466a;
        if (y.f1388c.size() <= 0) {
            Iterator it = y.d().iterator();
            if (!it.hasNext()) {
                return rVar;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getKey() == null) {
                entry.getValue();
                throw null;
            }
            throw new ClassCastException();
        }
        Map.Entry c2 = y.c(0);
        if (c2.getKey() == null) {
            c2.getValue();
            throw null;
        }
        throw new ClassCastException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        return this.f1466a.equals(((r) obj).f1466a);
    }

    public final int hashCode() {
        return this.f1466a.hashCode();
    }

    public r(int i2) {
        a();
        a();
    }
}
