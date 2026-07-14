package O;

import K.o0;
import a.AbstractC0051a;
import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0095w;
import androidx.datastore.preferences.protobuf.AbstractC0097y;
import androidx.datastore.preferences.protobuf.C0080g;
import androidx.datastore.preferences.protobuf.C0086m;
import androidx.datastore.preferences.protobuf.InterfaceC0096x;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f634a = new Object();

    public final c a(FileInputStream fileInputStream) {
        int i2;
        byte[] bArr;
        try {
            N.e o2 = N.e.o(fileInputStream);
            c cVar = new c(false);
            f[] pairs = (f[]) Arrays.copyOf(new f[0], 0);
            kotlin.jvm.internal.h.e(pairs, "pairs");
            cVar.c();
            if (pairs.length <= 0) {
                Map m2 = o2.m();
                kotlin.jvm.internal.h.d(m2, "preferencesProto.preferencesMap");
                for (Map.Entry entry : m2.entrySet()) {
                    String name = (String) entry.getKey();
                    N.j value = (N.j) entry.getValue();
                    kotlin.jvm.internal.h.d(name, "name");
                    kotlin.jvm.internal.h.d(value, "value");
                    int C2 = value.C();
                    if (C2 == 0) {
                        i2 = -1;
                    } else {
                        i2 = h.f633a[N.i.b(C2)];
                    }
                    switch (i2) {
                        case -1:
                            throw new IOException("Value case is null.", null);
                        case 0:
                        default:
                            throw new RuntimeException();
                        case 1:
                            cVar.f(AbstractC0051a.b(name), Boolean.valueOf(value.t()));
                            break;
                        case 2:
                            cVar.f(new e(name), Float.valueOf(value.x()));
                            break;
                        case 3:
                            cVar.f(new e(name), Double.valueOf(value.w()));
                            break;
                        case 4:
                            cVar.f(new e(name), Integer.valueOf(value.y()));
                            break;
                        case 5:
                            cVar.f(AbstractC0051a.F(name), Long.valueOf(value.z()));
                            break;
                        case 6:
                            e T2 = AbstractC0051a.T(name);
                            String A2 = value.A();
                            kotlin.jvm.internal.h.d(A2, "value.string");
                            cVar.f(T2, A2);
                            break;
                        case 7:
                            e U2 = AbstractC0051a.U(name);
                            InterfaceC0096x n2 = value.B().n();
                            kotlin.jvm.internal.h.d(n2, "value.stringSet.stringsList");
                            cVar.f(U2, R0.j.W(n2));
                            break;
                        case 8:
                            e eVar = new e(name);
                            C0080g u2 = value.u();
                            int size = u2.size();
                            if (size == 0) {
                                bArr = AbstractC0097y.f1495b;
                            } else {
                                byte[] bArr2 = new byte[size];
                                u2.d(bArr2, size);
                                bArr = bArr2;
                            }
                            kotlin.jvm.internal.h.d(bArr, "value.bytes.toByteArray()");
                            cVar.f(eVar, bArr);
                            break;
                        case 9:
                            throw new IOException("Value not set.", null);
                    }
                }
                return new c(new LinkedHashMap(cVar.a()), true);
            }
            f fVar = pairs[0];
            throw null;
        } catch (A e2) {
            throw new IOException("Unable to parse preferences proto.", e2);
        }
    }

    public final void b(Object obj, o0 o0Var) {
        AbstractC0095w a2;
        Map a3 = ((g) obj).a();
        N.c n2 = N.e.n();
        for (Map.Entry entry : a3.entrySet()) {
            e eVar = (e) entry.getKey();
            Object value = entry.getValue();
            String str = eVar.f632a;
            if (value instanceof Boolean) {
                N.h D2 = N.j.D();
                boolean booleanValue = ((Boolean) value).booleanValue();
                D2.c();
                N.j.q((N.j) D2.f1493d, booleanValue);
                a2 = D2.a();
            } else if (value instanceof Float) {
                N.h D3 = N.j.D();
                float floatValue = ((Number) value).floatValue();
                D3.c();
                N.j.r((N.j) D3.f1493d, floatValue);
                a2 = D3.a();
            } else if (value instanceof Double) {
                N.h D4 = N.j.D();
                double doubleValue = ((Number) value).doubleValue();
                D4.c();
                N.j.o((N.j) D4.f1493d, doubleValue);
                a2 = D4.a();
            } else if (value instanceof Integer) {
                N.h D5 = N.j.D();
                int intValue = ((Number) value).intValue();
                D5.c();
                N.j.s((N.j) D5.f1493d, intValue);
                a2 = D5.a();
            } else if (value instanceof Long) {
                N.h D6 = N.j.D();
                long longValue = ((Number) value).longValue();
                D6.c();
                N.j.l((N.j) D6.f1493d, longValue);
                a2 = D6.a();
            } else if (value instanceof String) {
                N.h D7 = N.j.D();
                D7.c();
                N.j.m((N.j) D7.f1493d, (String) value);
                a2 = D7.a();
            } else if (value instanceof Set) {
                N.h D8 = N.j.D();
                N.f o2 = N.g.o();
                kotlin.jvm.internal.h.c(value, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                o2.c();
                N.g.l((N.g) o2.f1493d, (Set) value);
                D8.c();
                N.j.n((N.j) D8.f1493d, (N.g) o2.a());
                a2 = D8.a();
            } else if (value instanceof byte[]) {
                N.h D9 = N.j.D();
                byte[] bArr = (byte[]) value;
                C0080g c0080g = C0080g.f1417e;
                C0080g c2 = C0080g.c(bArr, 0, bArr.length);
                D9.c();
                N.j.p((N.j) D9.f1493d, c2);
                a2 = D9.a();
            } else {
                throw new IllegalStateException("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
            }
            n2.getClass();
            str.getClass();
            n2.c();
            N.e.l((N.e) n2.f1493d).put(str, (N.j) a2);
        }
        N.e eVar2 = (N.e) n2.a();
        int a4 = eVar2.a(null);
        Logger logger = C0086m.f1452k;
        if (a4 > 4096) {
            a4 = 4096;
        }
        C0086m c0086m = new C0086m(o0Var, a4);
        eVar2.b(c0086m);
        if (c0086m.f1457i > 0) {
            c0086m.X();
        }
    }
}
