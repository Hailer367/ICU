package y2;

import I0.q;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p1.AbstractC0581j;
import p1.C0580i;
import p1.C0583l;
import p1.C0585n;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6596f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map f6597g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0580i f6598h;

    public /* synthetic */ d(Map map, C0580i c0580i, int i4) {
        this.f6596f = i4;
        this.f6597g = map;
        this.f6598h = c0580i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6596f) {
            case 0:
                Map map = this.f6597g;
                C0580i c0580i = this.f6598h;
                try {
                    FirebaseMessaging c4 = FirebaseMessaging.c();
                    Object obj = map.get("topic");
                    Objects.requireNonNull(obj);
                    C0585n c0585n = c4.f3416h;
                    P1.o oVar = new P1.o((String) obj, 1);
                    c0585n.getClass();
                    q qVar = AbstractC0581j.f5822a;
                    C0585n c0585n2 = new C0585n();
                    c0585n.f5833b.b(new C0583l(qVar, oVar, c0585n2));
                    c0585n.p();
                    AbstractC0602b.c(c0585n2);
                    c0580i.b(null);
                    return;
                } catch (Exception e4) {
                    c0580i.a(e4);
                    return;
                }
            case 1:
                Map map2 = this.f6597g;
                C0580i c0580i2 = this.f6598h;
                try {
                    FirebaseMessaging c5 = FirebaseMessaging.c();
                    Object obj2 = map2.get("enabled");
                    Objects.requireNonNull(obj2);
                    boolean booleanValue = ((Boolean) obj2).booleanValue();
                    c5.getClass();
                    u1.f d4 = u1.f.d();
                    d4.a();
                    d4.f6221a.getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", booleanValue).apply();
                    AbstractC0602b.Q(c5.f3410b, c5.f3411c, c5.j());
                    c0580i2.b(null);
                    return;
                } catch (Exception e5) {
                    c0580i2.a(e5);
                    return;
                }
            case 2:
                Map map3 = this.f6597g;
                C0580i c0580i3 = this.f6598h;
                try {
                    FirebaseMessaging c6 = FirebaseMessaging.c();
                    Object obj3 = map3.get("enabled");
                    Objects.requireNonNull(obj3);
                    c6.i(((Boolean) obj3).booleanValue());
                    HashMap hashMap = new HashMap();
                    hashMap.put("isAutoInitEnabled", Boolean.valueOf(c6.f3413e.b()));
                    c0580i3.b(hashMap);
                    return;
                } catch (Exception e6) {
                    c0580i3.a(e6);
                    return;
                }
            case 3:
                Map map4 = this.f6597g;
                C0580i c0580i4 = this.f6598h;
                try {
                    FirebaseMessaging c7 = FirebaseMessaging.c();
                    Object obj4 = map4.get("topic");
                    Objects.requireNonNull(obj4);
                    C0585n c0585n3 = c7.f3416h;
                    P1.o oVar2 = new P1.o((String) obj4, 0);
                    c0585n3.getClass();
                    q qVar2 = AbstractC0581j.f5822a;
                    C0585n c0585n4 = new C0585n();
                    c0585n3.f5833b.b(new C0583l(qVar2, oVar2, c0585n4));
                    c0585n3.p();
                    AbstractC0602b.c(c0585n4);
                    c0580i4.b(null);
                    return;
                } catch (Exception e7) {
                    c0580i4.a(e7);
                    return;
                }
            default:
                Map map5 = this.f6597g;
                C0580i c0580i5 = this.f6598h;
                try {
                    FirebaseMessaging.c().h(k3.b.k(map5));
                    c0580i5.b(null);
                    return;
                } catch (Exception e8) {
                    c0580i5.a(e8);
                    return;
                }
        }
    }

    public /* synthetic */ d(f fVar, Map map, C0580i c0580i) {
        this.f6596f = 2;
        this.f6597g = map;
        this.f6598h = c0580i;
    }
}
