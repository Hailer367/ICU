package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2682c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Y f2683a = Y.f();

    /* renamed from: b, reason: collision with root package name */
    public boolean f2684b;

    static {
        new r(0);
    }

    public r() {
    }

    public static void b(C0156m c0156m, r0 r0Var, int i4, Object obj) {
        if (r0Var == r0.f2686i) {
            c0156m.q0(i4, 3);
            ((AbstractC0144a) obj).b(c0156m);
            c0156m.q0(i4, 4);
            return;
        }
        c0156m.q0(i4, r0Var.f2689g);
        switch (r0Var.ordinal()) {
            case 0:
                c0156m.k0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                c0156m.i0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                c0156m.u0(((Long) obj).longValue());
                return;
            case 3:
                c0156m.u0(((Long) obj).longValue());
                return;
            case 4:
                c0156m.m0(((Integer) obj).intValue());
                return;
            case 5:
                c0156m.k0(((Long) obj).longValue());
                return;
            case 6:
                c0156m.i0(((Integer) obj).intValue());
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                c0156m.c0(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                return;
            case R.j.BYTES_FIELD_NUMBER /* 8 */:
                if (obj instanceof C0150g) {
                    c0156m.g0((C0150g) obj);
                    return;
                } else {
                    c0156m.p0((String) obj);
                    return;
                }
            case 9:
                ((AbstractC0144a) obj).b(c0156m);
                return;
            case 10:
                AbstractC0144a abstractC0144a = (AbstractC0144a) obj;
                c0156m.getClass();
                c0156m.s0(((AbstractC0165w) abstractC0144a).a(null));
                abstractC0144a.b(c0156m);
                return;
            case 11:
                if (obj instanceof C0150g) {
                    c0156m.g0((C0150g) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                c0156m.s0(length);
                c0156m.d0(bArr, 0, length);
                return;
            case 12:
                c0156m.s0(((Integer) obj).intValue());
                return;
            case 13:
                c0156m.m0(((Integer) obj).intValue());
                return;
            case 14:
                c0156m.i0(((Integer) obj).intValue());
                return;
            case 15:
                c0156m.k0(((Long) obj).longValue());
                return;
            case 16:
                int intValue = ((Integer) obj).intValue();
                c0156m.s0((intValue >> 31) ^ (intValue << 1));
                return;
            case 17:
                long longValue = ((Long) obj).longValue();
                c0156m.u0((longValue >> 63) ^ (longValue << 1));
                return;
            default:
                return;
        }
    }

    public final void a() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (this.f2684b) {
            return;
        }
        Y y3 = this.f2683a;
        int size = y3.f2606f.size();
        for (int i4 = 0; i4 < size; i4++) {
            Map.Entry c4 = y3.c(i4);
            if (c4.getValue() instanceof AbstractC0165w) {
                AbstractC0165w abstractC0165w = (AbstractC0165w) c4.getValue();
                abstractC0165w.getClass();
                T t3 = T.f2593c;
                t3.getClass();
                t3.a(abstractC0165w.getClass()).d(abstractC0165w);
                abstractC0165w.h();
            }
        }
        if (!y3.f2608h) {
            if (y3.f2606f.size() <= 0) {
                Iterator it = y3.d().iterator();
                if (it.hasNext()) {
                    ((Map.Entry) it.next()).getKey().getClass();
                    throw new ClassCastException();
                }
            } else {
                y3.c(0).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!y3.f2608h) {
            if (y3.f2607g.isEmpty()) {
                unmodifiableMap = Collections.EMPTY_MAP;
            } else {
                unmodifiableMap = Collections.unmodifiableMap(y3.f2607g);
            }
            y3.f2607g = unmodifiableMap;
            if (y3.f2610j.isEmpty()) {
                unmodifiableMap2 = Collections.EMPTY_MAP;
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(y3.f2610j);
            }
            y3.f2610j = unmodifiableMap2;
            y3.f2608h = true;
        }
        this.f2684b = true;
    }

    public final Object clone() {
        r rVar = new r();
        Y y3 = this.f2683a;
        if (y3.f2606f.size() <= 0) {
            Iterator it = y3.d().iterator();
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
        Map.Entry c4 = y3.c(0);
        if (c4.getKey() == null) {
            c4.getValue();
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
        return this.f2683a.equals(((r) obj).f2683a);
    }

    public final int hashCode() {
        return this.f2683a.hashCode();
    }

    public r(int i4) {
        a();
        a();
    }
}
