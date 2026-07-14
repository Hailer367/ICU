package S;

import O.l0;
import R.i;
import R.j;
import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0165w;
import androidx.datastore.preferences.protobuf.AbstractC0167y;
import androidx.datastore.preferences.protobuf.C0150g;
import androidx.datastore.preferences.protobuf.C0156m;
import androidx.datastore.preferences.protobuf.InterfaceC0166x;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f1540a = new Object();

    public final b a(FileInputStream fileInputStream) {
        int i4;
        byte[] bArr;
        try {
            R.e o3 = R.e.o(fileInputStream);
            b bVar = new b(false);
            e[] eVarArr = (e[]) Arrays.copyOf(new e[0], 0);
            T2.h.e(eVarArr, "pairs");
            bVar.b();
            if (eVarArr.length <= 0) {
                Map m3 = o3.m();
                T2.h.d(m3, "preferencesProto.preferencesMap");
                for (Map.Entry entry : m3.entrySet()) {
                    String str = (String) entry.getKey();
                    j jVar = (j) entry.getValue();
                    T2.h.d(str, "name");
                    T2.h.d(jVar, "value");
                    int C3 = jVar.C();
                    if (C3 == 0) {
                        i4 = -1;
                    } else {
                        i4 = f.f1539a[i.b(C3)];
                    }
                    switch (i4) {
                        case -1:
                            throw new IOException("Value case is null.", null);
                        case 0:
                        default:
                            throw new RuntimeException();
                        case 1:
                            bVar.f(AbstractC0602b.e(str), Boolean.valueOf(jVar.t()));
                            break;
                        case 2:
                            bVar.f(new d(str), Float.valueOf(jVar.x()));
                            break;
                        case 3:
                            bVar.f(new d(str), Double.valueOf(jVar.w()));
                            break;
                        case 4:
                            bVar.f(new d(str), Integer.valueOf(jVar.y()));
                            break;
                        case 5:
                            bVar.f(AbstractC0602b.K(str), Long.valueOf(jVar.z()));
                            break;
                        case 6:
                            d U3 = AbstractC0602b.U(str);
                            String A3 = jVar.A();
                            T2.h.d(A3, "value.string");
                            bVar.f(U3, A3);
                            break;
                        case j.DOUBLE_FIELD_NUMBER /* 7 */:
                            d V3 = AbstractC0602b.V(str);
                            InterfaceC0166x n3 = jVar.B().n();
                            T2.h.d(n3, "value.stringSet.stringsList");
                            bVar.f(V3, I2.e.K(n3));
                            break;
                        case j.BYTES_FIELD_NUMBER /* 8 */:
                            d dVar = new d(str);
                            C0150g u3 = jVar.u();
                            int size = u3.size();
                            if (size == 0) {
                                bArr = AbstractC0167y.f2710b;
                            } else {
                                byte[] bArr2 = new byte[size];
                                u3.d(bArr2, size);
                                bArr = bArr2;
                            }
                            T2.h.d(bArr, "value.bytes.toByteArray()");
                            bVar.f(dVar, bArr);
                            break;
                        case 9:
                            throw new IOException("Value not set.", null);
                    }
                }
                return new b(new LinkedHashMap(bVar.a()), true);
            }
            e eVar = eVarArr[0];
            throw null;
        } catch (A e4) {
            throw new IOException("Unable to parse preferences proto.", e4);
        }
    }

    public final void b(Object obj, l0 l0Var) {
        AbstractC0165w a4;
        Map a5 = ((b) obj).a();
        R.c n3 = R.e.n();
        for (Map.Entry entry : a5.entrySet()) {
            d dVar = (d) entry.getKey();
            Object value = entry.getValue();
            String str = dVar.f1538a;
            if (value instanceof Boolean) {
                R.h D3 = j.D();
                boolean booleanValue = ((Boolean) value).booleanValue();
                D3.c();
                j.q((j) D3.f2708g, booleanValue);
                a4 = D3.a();
            } else if (value instanceof Float) {
                R.h D4 = j.D();
                float floatValue = ((Number) value).floatValue();
                D4.c();
                j.r((j) D4.f2708g, floatValue);
                a4 = D4.a();
            } else if (value instanceof Double) {
                R.h D5 = j.D();
                double doubleValue = ((Number) value).doubleValue();
                D5.c();
                j.o((j) D5.f2708g, doubleValue);
                a4 = D5.a();
            } else if (value instanceof Integer) {
                R.h D6 = j.D();
                int intValue = ((Number) value).intValue();
                D6.c();
                j.s((j) D6.f2708g, intValue);
                a4 = D6.a();
            } else if (value instanceof Long) {
                R.h D7 = j.D();
                long longValue = ((Number) value).longValue();
                D7.c();
                j.l((j) D7.f2708g, longValue);
                a4 = D7.a();
            } else if (value instanceof String) {
                R.h D8 = j.D();
                D8.c();
                j.m((j) D8.f2708g, (String) value);
                a4 = D8.a();
            } else if (value instanceof Set) {
                R.h D9 = j.D();
                R.f o3 = R.g.o();
                T2.h.c(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                o3.c();
                R.g.l((R.g) o3.f2708g, (Set) value);
                D9.c();
                j.n((j) D9.f2708g, (R.g) o3.a());
                a4 = D9.a();
            } else if (value instanceof byte[]) {
                R.h D10 = j.D();
                byte[] bArr = (byte[]) value;
                C0150g c0150g = C0150g.f2634h;
                C0150g c4 = C0150g.c(bArr, 0, bArr.length);
                D10.c();
                j.p((j) D10.f2708g, c4);
                a4 = D10.a();
            } else {
                throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
            }
            n3.getClass();
            str.getClass();
            n3.c();
            R.e.l((R.e) n3.f2708g).put(str, (j) a4);
        }
        R.e eVar = (R.e) n3.a();
        int a6 = eVar.a(null);
        Logger logger = C0156m.f2669i;
        if (a6 > 4096) {
            a6 = 4096;
        }
        C0156m c0156m = new C0156m(l0Var, a6);
        eVar.b(c0156m);
        if (c0156m.f2674g > 0) {
            c0156m.a0();
        }
    }
}
