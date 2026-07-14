package E;

import android.graphics.Insets;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class Z extends Y {

    /* renamed from: s, reason: collision with root package name */
    public x.b f206s;

    /* renamed from: t, reason: collision with root package name */
    public x.b f207t;

    /* renamed from: u, reason: collision with root package name */
    public x.b f208u;

    public Z(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var, windowInsets);
        this.f206s = null;
        this.f207t = null;
        this.f208u = null;
    }

    @Override // E.g0
    public x.b h() {
        Insets mandatorySystemGestureInsets;
        if (this.f207t == null) {
            mandatorySystemGestureInsets = this.f195c.getMandatorySystemGestureInsets();
            this.f207t = x.b.b(mandatorySystemGestureInsets);
        }
        return this.f207t;
    }

    @Override // E.g0
    public x.b j() {
        Insets systemGestureInsets;
        if (this.f206s == null) {
            systemGestureInsets = this.f195c.getSystemGestureInsets();
            this.f206s = x.b.b(systemGestureInsets);
        }
        return this.f206s;
    }

    @Override // E.g0
    public x.b l() {
        Insets tappableElementInsets;
        if (this.f208u == null) {
            tappableElementInsets = this.f195c.getTappableElementInsets();
            this.f208u = x.b.b(tappableElementInsets);
        }
        return this.f208u;
    }

    @Override // E.X, E.g0
    public void u(x.b bVar) {
    }
}
