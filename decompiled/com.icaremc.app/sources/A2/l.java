package A2;

import D2.L;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public Context f82a;

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object, o.B1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [I0.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [P1.y, java.lang.Object] */
    public I0.k a() {
        Context context = this.f82a;
        if (context != null) {
            ?? obj = new Object();
            obj.f834f = K0.a.a(I0.n.f841a);
            R1.c cVar = new R1.c(6, context);
            obj.f835g = cVar;
            obj.f836h = K0.a.a(new E0.a(4, cVar, new R1.c(5, cVar)));
            R1.c cVar2 = obj.f835g;
            int i4 = 9;
            obj.f837i = new q(i4, cVar2);
            G2.a a4 = K0.a.a(new E0.a(7, obj.f837i, K0.a.a(new R1.c(i4, cVar2))));
            obj.f838j = a4;
            Object obj2 = new Object();
            R1.c cVar3 = obj.f835g;
            t tVar = new t(cVar3, a4, obj2, 10);
            G2.a aVar = obj.f834f;
            G2.a aVar2 = obj.f836h;
            L l3 = new L(aVar, aVar2, tVar, a4, a4);
            ?? obj3 = new Object();
            obj3.f5414f = cVar3;
            obj3.f5415g = aVar2;
            obj3.f5416h = a4;
            obj3.f5417i = tVar;
            obj3.f5418j = aVar;
            obj3.k = a4;
            obj3.f5419l = a4;
            ?? obj4 = new Object();
            obj4.f1469f = aVar;
            obj4.f1470g = a4;
            obj4.f1471h = tVar;
            obj4.f1472i = a4;
            obj.k = K0.a.a(new t(l3, (Object) obj3, (Object) obj4, 8));
            return obj;
        }
        throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
    }

    public void b() {
        this.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit().clear().apply();
    }

    public void c(ArrayList arrayList, String str, String str2) {
        SharedPreferences.Editor edit = this.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0).edit();
        if (arrayList != null) {
            edit.putStringSet("flutter_image_picker_image_path", new HashSet(arrayList));
        }
        if (str != null) {
            edit.putString("flutter_image_picker_error_code", str);
        }
        if (str2 != null) {
            edit.putString("flutter_image_picker_error_message", str2);
        }
        edit.apply();
    }
}
