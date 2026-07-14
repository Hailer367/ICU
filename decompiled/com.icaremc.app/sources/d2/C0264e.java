package d2;

import java.util.HashMap;
import p1.AbstractC0579h;
import p1.InterfaceC0574c;
import p1.InterfaceC0575d;
import r2.i;

/* renamed from: d2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0264e implements InterfaceC0575d, InterfaceC0574c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f3483f;

    public /* synthetic */ C0264e(i iVar) {
        this.f3483f = iVar;
    }

    @Override // p1.InterfaceC0575d
    public void c(Exception exc) {
        this.f3483f.error("TASK_FAILURE", exc.getMessage(), null);
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        String str;
        boolean f4 = abstractC0579h.f();
        i iVar = this.f3483f;
        if (f4) {
            iVar.success(abstractC0579h.d());
            return;
        }
        Exception c4 = abstractC0579h.c();
        if (c4 != null) {
            str = c4.getMessage();
        } else {
            str = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code", "unknown");
        if (c4 != null) {
            hashMap.put("message", c4.getMessage());
        } else {
            hashMap.put("message", "An unknown error has occurred.");
        }
        iVar.error("firebase_messaging", str, hashMap);
    }
}
