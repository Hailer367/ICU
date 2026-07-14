package N0;

import F0.d;
import I0.i;
import I0.j;
import P0.f;
import P0.h;
import P1.A;
import P1.C0106j;
import P1.z;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import p1.C0585n;
import p1.InterfaceC0578g;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Q0.b, f, InterfaceC0578g {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1063f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1064g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1065h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1066i;

    public /* synthetic */ a(h hVar, Object obj, j jVar, int i4) {
        this.f1063f = i4;
        this.f1065h = hVar;
        this.f1066i = obj;
        this.f1064g = jVar;
    }

    @Override // p1.InterfaceC0578g
    public C0585n a(Object obj) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f1065h;
        String str = (String) this.f1064g;
        z zVar = (z) this.f1066i;
        String str2 = (String) obj;
        A d4 = FirebaseMessaging.d(firebaseMessaging.f3410b);
        String e4 = firebaseMessaging.e();
        String a4 = firebaseMessaging.f3417i.a();
        synchronized (d4) {
            String a5 = z.a(str2, a4, System.currentTimeMillis());
            if (a5 != null) {
                SharedPreferences.Editor edit = d4.f1340a.edit();
                edit.putString(A.a(e4, str), a5);
                edit.commit();
            }
        }
        if (zVar == null || !str2.equals(zVar.f1474a)) {
            u1.f fVar = firebaseMessaging.f3409a;
            fVar.a();
            if ("[DEFAULT]".equals(fVar.f6222b)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                    fVar.a();
                    sb.append(fVar.f6222b);
                    Log.d("FirebaseMessaging", sb.toString());
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", str2);
                new C0106j(firebaseMessaging.f3410b).b(intent);
            }
        }
        return AbstractC0602b.A(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1, types: [I0.h, java.lang.Object] */
    @Override // P0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N0.a.apply(java.lang.Object):java.lang.Object");
    }

    @Override // Q0.b
    public Object d() {
        b bVar = (b) this.f1065h;
        j jVar = (j) this.f1064g;
        i iVar = (i) this.f1066i;
        h hVar = (h) bVar.f1071d;
        hVar.getClass();
        d dVar = jVar.f833c;
        String str = iVar.f825a;
        String str2 = jVar.f831a;
        String G3 = AbstractC0602b.G("SQLiteEventStore");
        if (Log.isLoggable(G3, 3)) {
            Log.d(G3, "Storing event with priority=" + dVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) hVar.c(new a(hVar, (Object) iVar, jVar, 2))).getClass();
        bVar.f1068a.a(jVar, 1, false);
        return null;
    }

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i4) {
        this.f1063f = i4;
        this.f1065h = obj;
        this.f1064g = obj2;
        this.f1066i = obj3;
    }
}
