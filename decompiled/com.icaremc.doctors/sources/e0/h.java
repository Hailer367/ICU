package e0;

import android.view.View;

/* loaded from: classes.dex */
public final class h extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2195a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2196b;

    public /* synthetic */ h() {
        this.f2195a = 2;
    }

    @Override // e0.t, e0.r
    public void a(s sVar) {
        switch (this.f2195a) {
            case 2:
                x xVar = (x) this.f2196b;
                if (!xVar.f2241A) {
                    xVar.F();
                    xVar.f2241A = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // e0.r
    public final void b(s sVar) {
        switch (this.f2195a) {
            case 0:
                View view = (View) this.f2196b;
                B b2 = A.f2157a;
                b2.P(view, 1.0f);
                b2.getClass();
                sVar.w(this);
                return;
            case 1:
                ((s) this.f2196b).z();
                sVar.w(this);
                return;
            default:
                x xVar = (x) this.f2196b;
                int i2 = xVar.z - 1;
                xVar.z = i2;
                if (i2 == 0) {
                    xVar.f2241A = false;
                    xVar.n();
                }
                sVar.w(this);
                return;
        }
    }

    public /* synthetic */ h(int i2, Object obj) {
        this.f2195a = i2;
        this.f2196b = obj;
    }
}
