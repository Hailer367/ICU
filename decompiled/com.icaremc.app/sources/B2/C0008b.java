package B2;

import java.nio.ByteBuffer;
import java.util.List;
import s2.C0649u;
import s2.C0650v;

/* renamed from: B2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0008b extends C0650v {

    /* renamed from: e, reason: collision with root package name */
    public static final C0008b f186e = new C0008b(0);

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f187d;

    public /* synthetic */ C0008b(int i4) {
        this.f187d = i4;
    }

    @Override // s2.C0650v
    public Object f(byte b4, ByteBuffer byteBuffer) {
        List list;
        List list2;
        switch (this.f187d) {
            case 1:
                T2.h.e(byteBuffer, "buffer");
                if (b4 == -127) {
                    Long l3 = (Long) e(byteBuffer);
                    if (l3 == null) {
                        return null;
                    }
                    int longValue = (int) l3.longValue();
                    M.f177g.getClass();
                    for (M m3 : M.values()) {
                        if (m3.f181f == longValue) {
                            return m3;
                        }
                    }
                    return null;
                }
                if (b4 == -126) {
                    Object e4 = e(byteBuffer);
                    if (e4 instanceof List) {
                        list2 = (List) e4;
                    } else {
                        list2 = null;
                    }
                    if (list2 == null) {
                        return null;
                    }
                    String str = (String) list2.get(0);
                    Object obj = list2.get(1);
                    T2.h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    return new C0013g(str, ((Boolean) obj).booleanValue());
                }
                if (b4 == -125) {
                    Object e5 = e(byteBuffer);
                    if (e5 instanceof List) {
                        list = (List) e5;
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        return null;
                    }
                    String str2 = (String) list.get(0);
                    Object obj2 = list.get(1);
                    T2.h.c(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType");
                    return new O(str2, (M) obj2);
                }
                return super.f(b4, byteBuffer);
            default:
                return super.f(b4, byteBuffer);
        }
    }

    @Override // s2.C0650v
    public void k(C0649u c0649u, Object obj) {
        switch (this.f187d) {
            case 1:
                if (obj instanceof M) {
                    c0649u.write(129);
                    k(c0649u, Long.valueOf(((M) obj).f181f));
                    return;
                } else if (obj instanceof C0013g) {
                    c0649u.write(130);
                    k(c0649u, ((C0013g) obj).a());
                    return;
                } else {
                    if (obj instanceof O) {
                        c0649u.write(131);
                        O o3 = (O) obj;
                        k(c0649u, I2.f.C(o3.f182a, o3.f183b));
                        return;
                    }
                    super.k(c0649u, obj);
                    return;
                }
            default:
                super.k(c0649u, obj);
                return;
        }
    }
}
