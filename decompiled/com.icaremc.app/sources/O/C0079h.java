package O;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: O.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0079h extends M2.h implements S2.p {

    /* renamed from: j, reason: collision with root package name */
    public Iterator f1195j;
    public Q.d k;

    /* renamed from: l, reason: collision with root package name */
    public Object f1196l;

    /* renamed from: m, reason: collision with root package name */
    public int f1197m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f1198n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ List f1199o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1200p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0079h(List list, ArrayList arrayList, K2.d dVar) {
        super(2, dVar);
        this.f1199o = list;
        this.f1200p = arrayList;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        return ((C0079h) i((K2.d) obj2, obj)).k(H2.i.f681a);
    }

    @Override // M2.a
    public final K2.d i(K2.d dVar, Object obj) {
        C0079h c0079h = new C0079h(this.f1199o, this.f1200p, dVar);
        c0079h.f1198n = obj;
        return c0079h;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    @Override // M2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.f1197m
            r1 = 2
            r2 = 1
            L2.a r3 = L2.a.f1019f
            if (r0 == 0) goto L2f
            if (r0 == r2) goto L1e
            if (r0 != r1) goto L16
            java.util.Iterator r0 = r10.f1195j
            java.lang.Object r4 = r10.f1198n
            java.util.List r4 = (java.util.List) r4
            k3.b.A(r11)
            goto L3c
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            java.lang.Object r0 = r10.f1196l
            Q.d r4 = r10.k
            java.util.Iterator r5 = r10.f1195j
            java.lang.Object r6 = r10.f1198n
            java.util.List r6 = (java.util.List) r6
            k3.b.A(r11)
            r9 = r6
            r6 = r4
            r4 = r9
            goto L5e
        L2f:
            k3.b.A(r11)
            java.lang.Object r11 = r10.f1198n
            java.util.List r0 = r10.f1199o
            java.util.Iterator r0 = r0.iterator()
            java.util.ArrayList r4 = r10.f1200p
        L3c:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L96
            java.lang.Object r5 = r0.next()
            Q.d r5 = (Q.d) r5
            r10.f1198n = r4
            r10.f1195j = r0
            r10.k = r5
            r10.f1196l = r11
            r10.f1197m = r2
            java.lang.Object r6 = r5.a(r11, r10)
            if (r6 != r3) goto L59
            goto L91
        L59:
            r9 = r0
            r0 = r11
            r11 = r6
            r6 = r5
            r5 = r9
        L5e:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L94
            O.g r11 = new O.g
            r7 = 0
            r8 = 0
            r11.<init>(r6, r8, r7)
            r4.add(r11)
            r10.f1198n = r4
            r10.f1195j = r5
            r10.k = r8
            r10.f1196l = r8
            r10.f1197m = r1
            R.k r11 = r6.f1485b
            Q.f r7 = new Q.f
            H2.g r8 = r6.f1488e
            java.lang.Object r8 = r8.a()
            android.content.SharedPreferences r8 = (android.content.SharedPreferences) r8
            java.util.LinkedHashSet r6 = r6.f1489f
            r7.<init>(r8, r6)
            java.lang.Object r11 = r11.c(r7, r0, r10)
            if (r11 != r3) goto L92
        L91:
            return r3
        L92:
            r0 = r5
            goto L3c
        L94:
            r11 = r0
            goto L92
        L96:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: O.C0079h.k(java.lang.Object):java.lang.Object");
    }
}
