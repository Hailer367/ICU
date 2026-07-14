package E;

import android.graphics.Rect;
import java.util.List;

/* loaded from: classes.dex */
public abstract class V {

    /* renamed from: a, reason: collision with root package name */
    public final Rect[][] f190a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect[][] f191b;

    public V() {
        this(new k0());
    }

    public abstract k0 b();

    public void c(k0 k0Var) {
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            List<Rect> e2 = k0Var.f234a.e(i2);
            int u2 = android.support.v4.media.session.a.u(i2);
            this.f190a[u2] = (Rect[]) e2.toArray(new Rect[e2.size()]);
            if (i2 != 8) {
                List<Rect> f2 = k0Var.f234a.f(i2);
                this.f191b[u2] = (Rect[]) f2.toArray(new Rect[f2.size()]);
            }
        }
    }

    public V(k0 k0Var) {
        this.f190a = new Rect[10];
        this.f191b = new Rect[10];
        c(k0Var);
    }

    public final void a() {
    }
}
