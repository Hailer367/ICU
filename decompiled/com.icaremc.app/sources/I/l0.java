package I;

import android.graphics.Insets;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class l0 extends k0 {

    /* renamed from: s, reason: collision with root package name */
    public B.c f765s;

    /* renamed from: t, reason: collision with root package name */
    public B.c f766t;

    /* renamed from: u, reason: collision with root package name */
    public B.c f767u;

    public l0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var, windowInsets);
        this.f765s = null;
        this.f766t = null;
        this.f767u = null;
    }

    @Override // I.r0
    public B.c i() {
        Insets mandatorySystemGestureInsets;
        if (this.f766t == null) {
            mandatorySystemGestureInsets = this.f751c.getMandatorySystemGestureInsets();
            this.f766t = B.c.c(mandatorySystemGestureInsets);
        }
        return this.f766t;
    }

    @Override // I.r0
    public B.c k() {
        Insets systemGestureInsets;
        if (this.f765s == null) {
            systemGestureInsets = this.f751c.getSystemGestureInsets();
            this.f765s = B.c.c(systemGestureInsets);
        }
        return this.f765s;
    }

    @Override // I.r0
    public B.c m() {
        Insets tappableElementInsets;
        if (this.f767u == null) {
            tappableElementInsets = this.f751c.getTappableElementInsets();
            this.f767u = B.c.c(tappableElementInsets);
        }
        return this.f767u;
    }

    @Override // I.i0, I.r0
    public v0 p(int i4, int i5, int i6, int i7) {
        WindowInsets inset;
        inset = this.f751c.inset(i4, i5, i6, i7);
        return v0.c(inset, null);
    }

    @Override // I.j0, I.r0
    public void w(B.c cVar) {
    }
}
