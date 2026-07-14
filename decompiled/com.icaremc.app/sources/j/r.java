package j;

import android.view.Window;
import n.InterfaceC0448A;
import o.InterfaceC0534o0;

/* loaded from: classes.dex */
public final class r implements InterfaceC0534o0, InterfaceC0448A {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LayoutInflaterFactory2C0393A f5005f;

    public /* synthetic */ r(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A) {
        this.f5005f = layoutInflaterFactory2C0393A;
    }

    @Override // n.InterfaceC0448A
    public void a(n.n nVar, boolean z) {
        boolean z3;
        int i4;
        z zVar;
        n.n k = nVar.k();
        int i5 = 0;
        if (k != nVar) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            nVar = k;
        }
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.f5005f;
        z[] zVarArr = layoutInflaterFactory2C0393A.f4841Q;
        if (zVarArr != null) {
            i4 = zVarArr.length;
        } else {
            i4 = 0;
        }
        while (true) {
            if (i5 < i4) {
                zVar = zVarArr[i5];
                if (zVar != null && zVar.f5026h == nVar) {
                    break;
                } else {
                    i5++;
                }
            } else {
                zVar = null;
                break;
            }
        }
        if (zVar != null) {
            if (z3) {
                layoutInflaterFactory2C0393A.r(zVar.f5019a, zVar, k);
                layoutInflaterFactory2C0393A.t(zVar, true);
            } else {
                layoutInflaterFactory2C0393A.t(zVar, z);
            }
        }
    }

    @Override // n.InterfaceC0448A
    public boolean c(n.n nVar) {
        Window.Callback callback;
        if (nVar == nVar.k()) {
            LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.f5005f;
            if (layoutInflaterFactory2C0393A.f4836K && (callback = layoutInflaterFactory2C0393A.f4865q.getCallback()) != null && !layoutInflaterFactory2C0393A.f4846V) {
                callback.onMenuOpened(108, nVar);
                return true;
            }
            return true;
        }
        return true;
    }
}
