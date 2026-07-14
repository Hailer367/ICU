package o;

import android.content.Context;
import android.view.View;
import com.icaremc.app.R;

/* renamed from: o.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0515f extends n.z {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f5575l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0523j f5576m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0515f(C0523j c0523j, Context context, n.n nVar, View view) {
        super(context, nVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.f5576m = c0523j;
        this.f5366f = 8388613;
        j.O o3 = c0523j.f5600B;
        this.f5368h = o3;
        n.w wVar = this.f5369i;
        if (wVar != null) {
            wVar.j(o3);
        }
    }

    @Override // n.z
    public final void c() {
        switch (this.f5575l) {
            case 0:
                C0523j c0523j = this.f5576m;
                c0523j.f5619y = null;
                c0523j.getClass();
                super.c();
                return;
            default:
                C0523j c0523j2 = this.f5576m;
                n.n nVar = c0523j2.f5603h;
                if (nVar != null) {
                    nVar.c(true);
                }
                c0523j2.f5618x = null;
                super.c();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0515f(C0523j c0523j, Context context, n.H h3, View view) {
        super(context, h3, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.f5576m = c0523j;
        if ((h3.f5230B.f5348x & 32) != 32) {
            View view2 = c0523j.f5608n;
            this.f5365e = view2 == null ? (View) c0523j.f5607m : view2;
        }
        j.O o3 = c0523j.f5600B;
        this.f5368h = o3;
        n.w wVar = this.f5369i;
        if (wVar != null) {
            wVar.j(o3);
        }
    }
}
