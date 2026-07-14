package I;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class k0 extends j0 {
    public k0(v0 v0Var, WindowInsets windowInsets) {
        super(v0Var, windowInsets);
    }

    @Override // I.r0
    public v0 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f751c.consumeDisplayCutout();
        return v0.c(consumeDisplayCutout, null);
    }

    @Override // I.i0, I.r0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        if (Objects.equals(this.f751c, k0Var.f751c) && Objects.equals(this.f755g, k0Var.f755g) && i0.L(this.f756h, k0Var.f756h)) {
            return true;
        }
        return false;
    }

    @Override // I.r0
    public C0054h g() {
        DisplayCutout displayCutout;
        displayCutout = this.f751c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0054h(displayCutout);
    }

    @Override // I.r0
    public int hashCode() {
        return this.f751c.hashCode();
    }
}
