package B2;

import a.AbstractC0141a;
import android.content.Context;
import android.util.Log;
import b3.AbstractC0245u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q1.AbstractC0602b;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public final class K implements o2.c, InterfaceC0012f {

    /* renamed from: f, reason: collision with root package name */
    public Context f172f;

    /* renamed from: g, reason: collision with root package name */
    public A2.t f173g;

    /* renamed from: h, reason: collision with root package name */
    public final H1.f f174h = new Object();

    public static final Object g(K k, String str, String str2, M2.h hVar) {
        S.d U3 = AbstractC0602b.U(str);
        Context context = k.f172f;
        if (context != null) {
            Object p3 = AbstractC0141a.p(L.a(context), new C0016j(U3, str2, null), hVar);
            if (p3 == L2.a.f1019f) {
                return p3;
            }
            return H2.i.f681a;
        }
        T2.h.g("context");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c0, code lost:
    
        if (r13 == r6) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00c2, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        if (r13 == r6) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00c0 -> B:11:0x00c3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(B2.K r11, java.util.List r12, M2.c r13) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B2.K.h(B2.K, java.util.List, M2.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T2.p, java.lang.Object] */
    @Override // B2.InterfaceC0012f
    public final Double a(String str, C0013g c0013g) {
        ?? obj = new Object();
        AbstractC0245u.i(new r(str, this, obj, null));
        return (Double) obj.f1645f;
    }

    @Override // B2.InterfaceC0012f
    public final void b(String str, boolean z, C0013g c0013g) {
        AbstractC0245u.i(new C(str, this, z, null));
    }

    @Override // B2.InterfaceC0012f
    public final void c(String str, String str2, C0013g c0013g) {
        AbstractC0245u.i(new J(this, str, str2, null));
    }

    @Override // B2.InterfaceC0012f
    public final List d(List list, C0013g c0013g) {
        return I2.e.I(((Map) AbstractC0245u.i(new u(this, list, null))).keySet());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T2.p, java.lang.Object] */
    @Override // B2.InterfaceC0012f
    public final Long e(String str, C0013g c0013g) {
        ?? obj = new Object();
        AbstractC0245u.i(new t(str, this, obj, null));
        return (Long) obj.f1645f;
    }

    @Override // B2.InterfaceC0012f
    public final void f(List list, C0013g c0013g) {
        AbstractC0245u.i(new C0015i(this, list, null));
    }

    @Override // B2.InterfaceC0012f
    public final void i(String str, String str2, C0013g c0013g) {
        AbstractC0245u.i(new G(this, str, str2, null));
    }

    @Override // B2.InterfaceC0012f
    public final void k(String str, double d4, C0013g c0013g) {
        AbstractC0245u.i(new F(str, this, d4, null));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T2.p, java.lang.Object] */
    @Override // B2.InterfaceC0012f
    public final Boolean l(String str, C0013g c0013g) {
        ?? obj = new Object();
        AbstractC0245u.i(new C0021o(str, this, obj, null));
        return (Boolean) obj.f1645f;
    }

    @Override // B2.InterfaceC0012f
    public final ArrayList o(String str, C0013g c0013g) {
        List list;
        String s3 = s(str, c0013g);
        if (s3 != null && !s3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!") && s3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") && (list = (List) L.c(s3, this.f174h)) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof String) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        T2.h.e(bVar, "binding");
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        T2.h.d(interfaceC0634f, "getBinaryMessenger(...)");
        Context context = bVar.f5785a;
        T2.h.d(context, "getApplicationContext(...)");
        this.f172f = context;
        try {
            InterfaceC0012f.f194b.getClass();
            C0011e.b(interfaceC0634f, this, "data_store");
            this.f173g = new A2.t(interfaceC0634f, context, this.f174h);
        } catch (Exception e4) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e4);
        }
        new C0007a().onAttachedToEngine(bVar);
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        T2.h.e(bVar, "binding");
        InterfaceC0634f interfaceC0634f = bVar.f5787c;
        T2.h.d(interfaceC0634f, "getBinaryMessenger(...)");
        InterfaceC0012f.f194b.getClass();
        C0011e.b(interfaceC0634f, null, "data_store");
        A2.t tVar = this.f173g;
        if (tVar != null) {
            C0011e.b((InterfaceC0634f) tVar.f99g, null, "shared_preferences");
        }
        this.f173g = null;
    }

    @Override // B2.InterfaceC0012f
    public final void r(String str, long j4, C0013g c0013g) {
        AbstractC0245u.i(new I(str, this, j4, null));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T2.p, java.lang.Object] */
    @Override // B2.InterfaceC0012f
    public final String s(String str, C0013g c0013g) {
        ?? obj = new Object();
        AbstractC0245u.i(new x(str, this, obj, null));
        return (String) obj.f1645f;
    }

    @Override // B2.InterfaceC0012f
    public final void t(String str, List list, C0013g c0013g) {
        AbstractC0245u.i(new D(this, str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu".concat(this.f174h.c(list)), null));
    }

    @Override // B2.InterfaceC0012f
    public final O v(String str, C0013g c0013g) {
        String s3 = s(str, c0013g);
        if (s3 == null) {
            return null;
        }
        if (s3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!")) {
            return new O(s3, M.JSON_ENCODED);
        }
        if (s3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
            return new O(null, M.PLATFORM_ENCODED);
        }
        return new O(null, M.UNEXPECTED_STRING);
    }

    @Override // B2.InterfaceC0012f
    public final Map w(List list, C0013g c0013g) {
        return (Map) AbstractC0245u.i(new C0017k(this, list, null));
    }
}
