package K;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: K.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0033h extends V0.h implements c1.p {

    /* renamed from: c, reason: collision with root package name */
    public Iterator f480c;

    /* renamed from: d, reason: collision with root package name */
    public M.d f481d;

    /* renamed from: e, reason: collision with root package name */
    public Object f482e;

    /* renamed from: f, reason: collision with root package name */
    public int f483f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f484g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f485h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ArrayList f486i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0033h(List list, ArrayList arrayList, T0.d dVar) {
        super(2, dVar);
        this.f485h = list;
        this.f486i = arrayList;
    }

    @Override // V0.a
    public final T0.d create(Object obj, T0.d dVar) {
        C0033h c0033h = new C0033h(this.f485h, this.f486i, dVar);
        c0033h.f484g = obj;
        return c0033h;
    }

    @Override // c1.p
    public final Object invoke(Object obj, Object obj2) {
        return ((C0033h) create(obj, (T0.d) obj2)).invokeSuspend(Q0.j.f722a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    @Override // V0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            U0.a r0 = U0.a.f780c
            int r1 = r10.f483f
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.util.Iterator r1 = r10.f480c
            java.lang.Object r4 = r10.f484g
            java.util.List r4 = (java.util.List) r4
            a.AbstractC0051a.V(r11)
            goto L3c
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            java.lang.Object r1 = r10.f482e
            M.d r4 = r10.f481d
            java.util.Iterator r5 = r10.f480c
            java.lang.Object r6 = r10.f484g
            java.util.List r6 = (java.util.List) r6
            a.AbstractC0051a.V(r11)
            r9 = r6
            r6 = r4
            r4 = r9
            goto L5e
        L2f:
            a.AbstractC0051a.V(r11)
            java.lang.Object r11 = r10.f484g
            java.util.List r1 = r10.f485h
            java.util.Iterator r1 = r1.iterator()
            java.util.ArrayList r4 = r10.f486i
        L3c:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L95
            java.lang.Object r5 = r1.next()
            M.d r5 = (M.d) r5
            r10.f484g = r4
            r10.f480c = r1
            r10.f481d = r5
            r10.f482e = r11
            r10.f483f = r3
            java.lang.Object r6 = r5.a(r11, r10)
            if (r6 != r0) goto L59
            goto L90
        L59:
            r9 = r1
            r1 = r11
            r11 = r6
            r6 = r5
            r5 = r9
        L5e:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L93
            K.g r11 = new K.g
            r7 = 0
            r11.<init>(r6, r7)
            r4.add(r11)
            r10.f484g = r4
            r10.f480c = r5
            r10.f481d = r7
            r10.f482e = r7
            r10.f483f = r2
            N.k r11 = r6.f604b
            M.f r7 = new M.f
            Q0.h r8 = r6.f607e
            java.lang.Object r8 = r8.a()
            android.content.SharedPreferences r8 = (android.content.SharedPreferences) r8
            java.util.LinkedHashSet r6 = r6.f608f
            r7.<init>(r8, r6)
            java.lang.Object r11 = r11.a(r7, r1, r10)
            if (r11 != r0) goto L91
        L90:
            return r0
        L91:
            r1 = r5
            goto L3c
        L93:
            r11 = r1
            goto L91
        L95:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: K.C0033h.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
