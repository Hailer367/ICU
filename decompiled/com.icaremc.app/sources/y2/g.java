package y2;

import D2.J;
import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import p1.C0580i;
import s2.InterfaceC0648t;

/* loaded from: classes.dex */
public final class g implements InterfaceC0648t {

    /* renamed from: g, reason: collision with root package name */
    public O0.j f6611g;

    /* renamed from: f, reason: collision with root package name */
    public final Object f6610f = new Object();

    /* renamed from: h, reason: collision with root package name */
    public boolean f6612h = false;

    public final void a(Activity activity, O0.j jVar, J j4) {
        if (activity == null) {
            ((C0580i) j4.f294g).a(new Exception("Unable to detect current Android Activity."));
            return;
        }
        synchronized (this.f6610f) {
            if (this.f6612h) {
                ((C0580i) j4.f294g).a(new Exception("A request for permissions is already running, please wait for it to finish before doing another request."));
                return;
            }
            this.f6612h = true;
            this.f6611g = jVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.POST_NOTIFICATIONS");
            android.support.v4.media.session.a.u(activity, (String[]) arrayList.toArray(new String[0]), 240);
        }
    }

    @Override // s2.InterfaceC0648t
    public final boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        O0.j jVar;
        synchronized (this.f6610f) {
            int i5 = 0;
            if (this.f6612h && i4 == 240 && (jVar = this.f6611g) != null) {
                this.f6611g = null;
                this.f6612h = false;
                if (iArr.length > 0 && iArr[0] == 0) {
                    i5 = 1;
                }
                HashMap hashMap = (HashMap) jVar.f1292g;
                C0580i c0580i = (C0580i) jVar.f1293h;
                hashMap.put("authorizationStatus", Integer.valueOf(i5));
                c0580i.b(hashMap);
                return true;
            }
            return false;
        }
    }
}
