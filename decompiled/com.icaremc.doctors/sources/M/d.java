package M;

import N.k;
import N.l;
import Q0.h;
import android.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final l f603a;

    /* renamed from: b, reason: collision with root package name */
    public final k f604b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f605c;

    /* renamed from: d, reason: collision with root package name */
    public final String f606d;

    /* renamed from: e, reason: collision with root package name */
    public final h f607e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f608f;

    public d(Context context, String sharedPreferencesName, Set keysToMigrate, l lVar, k kVar) {
        LinkedHashSet linkedHashSet;
        kotlin.jvm.internal.h.e(sharedPreferencesName, "sharedPreferencesName");
        kotlin.jvm.internal.h.e(keysToMigrate, "keysToMigrate");
        a aVar = new a(0, context, sharedPreferencesName);
        this.f603a = lVar;
        this.f604b = kVar;
        this.f605c = context;
        this.f606d = sharedPreferencesName;
        this.f607e = new h(aVar);
        if (keysToMigrate == e.f609a) {
            linkedHashSet = null;
        } else {
            linkedHashSet = new LinkedHashSet(keysToMigrate);
        }
        this.f608f = linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (r5.isEmpty() == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r5, V0.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof M.c
            if (r0 == 0) goto L13
            r0 = r6
            M.c r0 = (M.c) r0
            int r1 = r0.f602f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f602f = r1
            goto L18
        L13:
            M.c r0 = new M.c
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f600d
            U0.a r1 = U0.a.f780c
            int r2 = r0.f602f
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            M.d r5 = r0.f599c
            a.AbstractC0051a.V(r6)
            goto L42
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            a.AbstractC0051a.V(r6)
            r0.f599c = r4
            r0.f602f = r3
            N.l r6 = r4.f603a
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            r5 = r4
        L42:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4d
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4d:
            java.util.LinkedHashSet r6 = r5.f608f
            Q0.h r5 = r5.f607e
            r0 = 0
            if (r6 != 0) goto L6c
            java.lang.Object r5 = r5.a()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            kotlin.jvm.internal.h.d(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L6a
            goto L8f
        L6a:
            r3 = r0
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
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: M.d.a(java.lang.Object, V0.c):java.lang.Object");
    }
}
