package n;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import o.AbstractViewOnTouchListenerC0468D0;
import o.C0515f;
import o.C0517g;
import o.C0521i;
import o.C0523j;

/* renamed from: n.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0452b extends AbstractViewOnTouchListenerC0468D0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5246o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ View f5247p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0452b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f5247p = actionMenuItemView;
    }

    @Override // o.AbstractViewOnTouchListenerC0468D0
    public final F b() {
        C0515f c0515f;
        switch (this.f5246o) {
            case 0:
                AbstractC0453c abstractC0453c = ((ActionMenuItemView) this.f5247p).f2267r;
                if (abstractC0453c != null && (c0515f = ((C0517g) abstractC0453c).f5583a.f5619y) != null) {
                    return c0515f.a();
                }
                return null;
            default:
                C0515f c0515f2 = ((C0521i) this.f5247p).f5593i.f5618x;
                if (c0515f2 == null) {
                    return null;
                }
                return c0515f2.a();
        }
    }

    @Override // o.AbstractViewOnTouchListenerC0468D0
    public final boolean c() {
        F b4;
        switch (this.f5246o) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f5247p;
                m mVar = actionMenuItemView.f2265p;
                if (mVar != null && mVar.b(actionMenuItemView.f2262m) && (b4 = b()) != null && b4.b()) {
                    return true;
                }
                return false;
            default:
                ((C0521i) this.f5247p).f5593i.l();
                return true;
        }
    }

    @Override // o.AbstractViewOnTouchListenerC0468D0
    public boolean d() {
        switch (this.f5246o) {
            case 1:
                C0523j c0523j = ((C0521i) this.f5247p).f5593i;
                if (c0523j.z != null) {
                    return false;
                }
                c0523j.c();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0452b(C0521i c0521i, C0521i c0521i2) {
        super(c0521i2);
        this.f5247p = c0521i;
    }
}
