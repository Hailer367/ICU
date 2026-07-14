package Q;

import H2.g;
import R.k;
import R.l;
import T2.h;
import android.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final l f1484a;

    /* renamed from: b, reason: collision with root package name */
    public final k f1485b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f1486c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1487d;

    /* renamed from: e, reason: collision with root package name */
    public final g f1488e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f1489f;

    public d(Context context, String str, Set set, l lVar, k kVar) {
        LinkedHashSet linkedHashSet;
        h.e(context, "context");
        h.e(str, "sharedPreferencesName");
        h.e(set, "keysToMigrate");
        a aVar = new a(0, context, str);
        this.f1484a = lVar;
        this.f1485b = kVar;
        this.f1486c = context;
        this.f1487d = str;
        this.f1488e = new g(aVar);
        if (set == e.f1490a) {
            linkedHashSet = null;
        } else {
            linkedHashSet = new LinkedHashSet(set);
        }
        this.f1489f = linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (r5.isEmpty() == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r5, M2.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof Q.c
            if (r0 == 0) goto L13
            r0 = r6
            Q.c r0 = (Q.c) r0
            int r1 = r0.f1483l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1483l = r1
            goto L18
        L13:
            Q.c r0 = new Q.c
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f1482j
            int r1 = r0.f1483l
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            Q.d r5 = r0.f1481i
            k3.b.A(r6)
            goto L42
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            k3.b.A(r6)
            r0.f1481i = r4
            r0.f1483l = r2
            R.l r6 = r4.f1484a
            java.lang.Object r6 = r6.e(r5, r0)
            L2.a r5 = L2.a.f1019f
            if (r6 != r5) goto L41
            return r5
        L41:
            r5 = r4
        L42:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4d
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4d:
            java.util.LinkedHashSet r6 = r5.f1489f
            H2.g r5 = r5.f1488e
            r0 = 0
            if (r6 != 0) goto L6c
            java.lang.Object r5 = r5.a()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            T2.h.d(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L6a
            goto L8f
        L6a:
            r2 = r0
            goto L8f
        L6c:
            java.lang.Object r5 = r5.a()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L79
            goto L6a
        L79:
            java.util.Iterator r6 = r6.iterator()
        L7d:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6a
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L7d
        L8f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.d.a(java.lang.Object, M2.c):java.lang.Object");
    }
}
