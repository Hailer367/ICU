package E;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class Y extends X {
    public Y(k0 k0Var, WindowInsets windowInsets) {
        super(k0Var, windowInsets);
    }

    @Override // E.g0
    public k0 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f195c.consumeDisplayCutout();
        return k0.a(null, consumeDisplayCutout);
    }

    @Override // E.W, E.g0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y = (Y) obj;
        if (Objects.equals(this.f195c, y.f195c) && Objects.equals(this.f199g, y.f199g) && W.K(this.f200h, y.f200h)) {
            return true;
        }
        return false;
    }

    @Override // E.g0
    public C0006f g() {
        DisplayCutout displayCutout;
        displayCutout = this.f195c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0006f(displayCutout);
    }

    @Override // E.g0
    public int hashCode() {
        return this.f195c.hashCode();
    }
}
