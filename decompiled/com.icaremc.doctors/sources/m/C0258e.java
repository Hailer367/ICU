package m;

import android.content.Context;
import android.view.View;
import com.icaremc.doctors.R;

/* renamed from: m.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0258e extends l.n {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f3126l = 1;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0261h f3127m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0258e(C0261h c0261h, Context context, l.j jVar, View view) {
        super(context, jVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.f3127m = c0261h;
        this.f2890f = 8388613;
        F.h hVar = c0261h.f3170x;
        this.f2892h = hVar;
        l.l lVar = this.f2893i;
        if (lVar != null) {
            lVar.d(hVar);
        }
    }

    @Override // l.n
    public final void c() {
        switch (this.f3126l) {
            case 0:
                C0261h c0261h = this.f3127m;
                c0261h.f3167u = null;
                c0261h.getClass();
                super.c();
                return;
            default:
                C0261h c0261h2 = this.f3127m;
                l.j jVar = c0261h2.f3153e;
                if (jVar != null) {
                    jVar.c(true);
                }
                c0261h2.f3166t = null;
                super.c();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0258e(C0261h c0261h, Context context, l.t tVar, View view) {
        super(context, tVar, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.f3127m = c0261h;
        if ((tVar.f2914w.f2882x & 32) != 32) {
            View view2 = c0261h.f3158j;
            this.f2889e = view2 == null ? c0261h.f3157i : view2;
        }
        F.h hVar = c0261h.f3170x;
        this.f2892h = hVar;
        l.l lVar = this.f2893i;
        if (lVar != null) {
            lVar.d(hVar);
        }
    }
}
