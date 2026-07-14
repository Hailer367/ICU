package A2;

import D2.EnumC0031j;
import D2.EnumC0043w;
import D2.EnumC0044x;
import D2.O;
import D2.i0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import s2.C0649u;
import s2.C0650v;

/* loaded from: classes.dex */
public class A extends C0650v {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f49d;

    public /* synthetic */ A(int i4) {
        this.f49d = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [A2.c] */
    /* JADX WARN: Type inference failed for: r3v2, types: [A2.D] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [A2.B] */
    /* JADX WARN: Type inference failed for: r7v21, types: [A2.c[]] */
    /* JADX WARN: Type inference failed for: r7v23, types: [A2.D[]] */
    /* JADX WARN: Type inference failed for: r7v25, types: [A2.B[]] */
    @Override // s2.C0650v
    public Object f(byte b4, ByteBuffer byteBuffer) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        List list7;
        Object obj;
        List list8;
        List list9;
        switch (this.f49d) {
            case 0:
                T2.h.e(byteBuffer, "buffer");
                int i4 = 0;
                if (b4 == -127) {
                    Long l3 = (Long) e(byteBuffer);
                    if (l3 == null) {
                        return null;
                    }
                    int longValue = (int) l3.longValue();
                    B.f50g.getClass();
                    ?? values = B.values();
                    int length = values.length;
                    while (i4 < length) {
                        obj = values[i4];
                        if (obj.f52f != longValue) {
                            i4++;
                        }
                    }
                    return null;
                }
                if (b4 == -126) {
                    Long l4 = (Long) e(byteBuffer);
                    if (l4 == null) {
                        return null;
                    }
                    int longValue2 = (int) l4.longValue();
                    D.f55g.getClass();
                    ?? values2 = D.values();
                    int length2 = values2.length;
                    while (i4 < length2) {
                        obj = values2[i4];
                        if (obj.f57f != longValue2) {
                            i4++;
                        }
                    }
                    return null;
                }
                if (b4 == -125) {
                    Long l5 = (Long) e(byteBuffer);
                    if (l5 == null) {
                        return null;
                    }
                    int longValue3 = (int) l5.longValue();
                    EnumC0004c.f64g.getClass();
                    ?? values3 = EnumC0004c.values();
                    int length3 = values3.length;
                    while (i4 < length3) {
                        obj = values3[i4];
                        if (obj.f68f != longValue3) {
                            i4++;
                        }
                    }
                    return null;
                }
                if (b4 == -124) {
                    Object e4 = e(byteBuffer);
                    if (e4 instanceof List) {
                        list7 = (List) e4;
                    } else {
                        list7 = null;
                    }
                    if (list7 == null) {
                        return null;
                    }
                    Object obj2 = list7.get(0);
                    T2.h.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue = ((Boolean) obj2).booleanValue();
                    Object obj3 = list7.get(1);
                    T2.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new C0006e(booleanValue, ((Boolean) obj3).booleanValue(), (Long) list7.get(2));
                }
                if (b4 == -123) {
                    Object e5 = e(byteBuffer);
                    if (e5 instanceof List) {
                        list6 = (List) e5;
                    } else {
                        list6 = null;
                    }
                    if (list6 == null) {
                        return null;
                    }
                    Double d4 = (Double) list6.get(0);
                    Double d5 = (Double) list6.get(1);
                    Object obj4 = list6.get(2);
                    T2.h.c(obj4, "null cannot be cast to non-null type kotlin.Long");
                    return new y(d4, d5, ((Long) obj4).longValue());
                }
                if (b4 == -122) {
                    Object e6 = e(byteBuffer);
                    if (e6 instanceof List) {
                        list5 = (List) e6;
                    } else {
                        list5 = null;
                    }
                    if (list5 == null) {
                        return null;
                    }
                    Object obj5 = list5.get(0);
                    T2.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.ImageSelectionOptions");
                    return new z((y) obj5);
                }
                if (b4 == -121) {
                    Object e7 = e(byteBuffer);
                    if (e7 instanceof List) {
                        list4 = (List) e7;
                    } else {
                        list4 = null;
                    }
                    if (list4 == null) {
                        return null;
                    }
                    return new E((Long) list4.get(0));
                }
                if (b4 == -120) {
                    Object e8 = e(byteBuffer);
                    if (e8 instanceof List) {
                        list3 = (List) e8;
                    } else {
                        list3 = null;
                    }
                    if (list3 == null) {
                        return null;
                    }
                    Object obj6 = list3.get(0);
                    T2.h.c(obj6, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.SourceType");
                    return new C((D) obj6, (B) list3.get(1));
                }
                if (b4 == -119) {
                    Object e9 = e(byteBuffer);
                    if (e9 instanceof List) {
                        list2 = (List) e9;
                    } else {
                        list2 = null;
                    }
                    if (list2 == null) {
                        return null;
                    }
                    Object obj7 = list2.get(0);
                    T2.h.c(obj7, "null cannot be cast to non-null type kotlin.String");
                    return new C0002a((String) obj7, (String) list2.get(1));
                }
                if (b4 == -118) {
                    Object e10 = e(byteBuffer);
                    if (e10 instanceof List) {
                        list = (List) e10;
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        return null;
                    }
                    Object obj8 = list.get(0);
                    T2.h.c(obj8, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.CacheRetrievalType");
                    C0002a c0002a = (C0002a) list.get(1);
                    Object obj9 = list.get(2);
                    T2.h.c(obj9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    return new C0003b((EnumC0004c) obj8, c0002a, (List) obj9);
                }
                return super.f(b4, byteBuffer);
                return obj;
            case 1:
                T2.h.e(byteBuffer, "buffer");
                if (b4 == -127) {
                    Object e11 = e(byteBuffer);
                    if (e11 instanceof List) {
                        list9 = (List) e11;
                    } else {
                        list9 = null;
                    }
                    if (list9 == null) {
                        return null;
                    }
                    Object obj10 = list9.get(0);
                    T2.h.c(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue2 = ((Boolean) obj10).booleanValue();
                    Object obj11 = list9.get(1);
                    T2.h.c(obj11, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue3 = ((Boolean) obj11).booleanValue();
                    Object obj12 = list9.get(2);
                    T2.h.c(obj12, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    return new C2.l(booleanValue2, booleanValue3, (Map) obj12);
                }
                if (b4 == -126) {
                    Object e12 = e(byteBuffer);
                    if (e12 instanceof List) {
                        list8 = (List) e12;
                    } else {
                        list8 = null;
                    }
                    if (list8 == null) {
                        return null;
                    }
                    Object obj13 = list8.get(0);
                    T2.h.c(obj13, "null cannot be cast to non-null type kotlin.Boolean");
                    return new C2.a(((Boolean) obj13).booleanValue());
                }
                return super.f(b4, byteBuffer);
            default:
                T2.h.e(byteBuffer, "buffer");
                int i5 = 0;
                if (b4 == -127) {
                    Long l6 = (Long) e(byteBuffer);
                    if (l6 != null) {
                        int longValue4 = (int) l6.longValue();
                        D2.r.f427g.getClass();
                        D2.r[] values4 = D2.r.values();
                        int length4 = values4.length;
                        while (i5 < length4) {
                            D2.r rVar = values4[i5];
                            if (rVar.f432f != longValue4) {
                                i5++;
                            } else {
                                return rVar;
                            }
                        }
                    }
                } else if (b4 == -126) {
                    Long l7 = (Long) e(byteBuffer);
                    if (l7 != null) {
                        int longValue5 = (int) l7.longValue();
                        EnumC0031j.f405g.getClass();
                        EnumC0031j[] values5 = EnumC0031j.values();
                        int length5 = values5.length;
                        while (i5 < length5) {
                            EnumC0031j enumC0031j = values5[i5];
                            if (enumC0031j.f412f != longValue5) {
                                i5++;
                            } else {
                                return enumC0031j;
                            }
                        }
                    }
                } else if (b4 == -125) {
                    Long l8 = (Long) e(byteBuffer);
                    if (l8 != null) {
                        int longValue6 = (int) l8.longValue();
                        EnumC0044x.f442g.getClass();
                        EnumC0044x[] values6 = EnumC0044x.values();
                        int length6 = values6.length;
                        while (i5 < length6) {
                            EnumC0044x enumC0044x = values6[i5];
                            if (enumC0044x.f445f != longValue6) {
                                i5++;
                            } else {
                                return enumC0044x;
                            }
                        }
                    }
                } else if (b4 == -124) {
                    Long l9 = (Long) e(byteBuffer);
                    if (l9 != null) {
                        int longValue7 = (int) l9.longValue();
                        O.f307g.getClass();
                        O[] values7 = O.values();
                        int length7 = values7.length;
                        while (i5 < length7) {
                            O o3 = values7[i5];
                            if (o3.f315f != longValue7) {
                                i5++;
                            } else {
                                return o3;
                            }
                        }
                    }
                } else if (b4 == -123) {
                    Long l10 = (Long) e(byteBuffer);
                    if (l10 != null) {
                        int longValue8 = (int) l10.longValue();
                        EnumC0043w.f439g.getClass();
                        EnumC0043w[] values8 = EnumC0043w.values();
                        int length8 = values8.length;
                        while (i5 < length8) {
                            EnumC0043w enumC0043w = values8[i5];
                            if (enumC0043w.f441f != longValue8) {
                                i5++;
                            } else {
                                return enumC0043w;
                            }
                        }
                    }
                } else if (b4 == -122) {
                    Long l11 = (Long) e(byteBuffer);
                    if (l11 != null) {
                        int longValue9 = (int) l11.longValue();
                        i0.f402g.getClass();
                        i0[] values9 = i0.values();
                        int length9 = values9.length;
                        while (i5 < length9) {
                            i0 i0Var = values9[i5];
                            if (i0Var.f404f != longValue9) {
                                i5++;
                            } else {
                                return i0Var;
                            }
                        }
                    }
                } else {
                    return super.f(b4, byteBuffer);
                }
                return null;
        }
    }

    @Override // s2.C0650v
    public void k(C0649u c0649u, Object obj) {
        switch (this.f49d) {
            case 0:
                if (obj instanceof B) {
                    c0649u.write(129);
                    k(c0649u, Long.valueOf(((B) obj).f52f));
                    return;
                }
                if (obj instanceof D) {
                    c0649u.write(130);
                    k(c0649u, Long.valueOf(((D) obj).f57f));
                    return;
                }
                if (obj instanceof EnumC0004c) {
                    c0649u.write(131);
                    k(c0649u, Long.valueOf(((EnumC0004c) obj).f68f));
                    return;
                }
                if (obj instanceof C0006e) {
                    c0649u.write(132);
                    C0006e c0006e = (C0006e) obj;
                    k(c0649u, I2.f.C(Boolean.valueOf(c0006e.f71a), Boolean.valueOf(c0006e.f72b), c0006e.f73c));
                    return;
                }
                if (obj instanceof y) {
                    c0649u.write(133);
                    y yVar = (y) obj;
                    k(c0649u, I2.f.C(yVar.f118a, yVar.f119b, Long.valueOf(yVar.f120c)));
                    return;
                }
                if (obj instanceof z) {
                    c0649u.write(134);
                    k(c0649u, android.support.v4.media.session.a.p(((z) obj).f121a));
                    return;
                }
                if (obj instanceof E) {
                    c0649u.write(135);
                    k(c0649u, android.support.v4.media.session.a.p(((E) obj).f58a));
                    return;
                }
                if (obj instanceof C) {
                    c0649u.write(136);
                    C c4 = (C) obj;
                    k(c0649u, I2.f.C(c4.f53a, c4.f54b));
                    return;
                } else if (obj instanceof C0002a) {
                    c0649u.write(137);
                    C0002a c0002a = (C0002a) obj;
                    k(c0649u, I2.f.C(c0002a.f59a, c0002a.f60b));
                    return;
                } else {
                    if (obj instanceof C0003b) {
                        c0649u.write(138);
                        C0003b c0003b = (C0003b) obj;
                        k(c0649u, I2.f.C(c0003b.f61a, c0003b.f62b, c0003b.f63c));
                        return;
                    }
                    super.k(c0649u, obj);
                    return;
                }
            case 1:
                if (obj instanceof C2.l) {
                    c0649u.write(129);
                    C2.l lVar = (C2.l) obj;
                    k(c0649u, I2.f.C(Boolean.valueOf(lVar.f272a), Boolean.valueOf(lVar.f273b), lVar.f274c));
                    return;
                } else if (obj instanceof C2.a) {
                    c0649u.write(130);
                    k(c0649u, android.support.v4.media.session.a.p(Boolean.valueOf(((C2.a) obj).f257a)));
                    return;
                } else {
                    super.k(c0649u, obj);
                    return;
                }
            default:
                if (obj instanceof D2.r) {
                    c0649u.write(129);
                    k(c0649u, Long.valueOf(((D2.r) obj).f432f));
                    return;
                }
                if (obj instanceof EnumC0031j) {
                    c0649u.write(130);
                    k(c0649u, Long.valueOf(((EnumC0031j) obj).f412f));
                    return;
                }
                if (obj instanceof EnumC0044x) {
                    c0649u.write(131);
                    k(c0649u, Long.valueOf(((EnumC0044x) obj).f445f));
                    return;
                }
                if (obj instanceof O) {
                    c0649u.write(132);
                    k(c0649u, Long.valueOf(((O) obj).f315f));
                    return;
                } else if (obj instanceof EnumC0043w) {
                    c0649u.write(133);
                    k(c0649u, Long.valueOf(((EnumC0043w) obj).f441f));
                    return;
                } else if (obj instanceof i0) {
                    c0649u.write(134);
                    k(c0649u, Long.valueOf(((i0) obj).f404f));
                    return;
                } else {
                    super.k(c0649u, obj);
                    return;
                }
        }
    }
}
