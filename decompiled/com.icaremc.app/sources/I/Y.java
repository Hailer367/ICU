package I;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class Y {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f712a;

    public Y(View view) {
        this.f712a = new WeakReference(view);
    }

    public final void a(float f4) {
        View view = (View) this.f712a.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
    }

    public final void b() {
        View view = (View) this.f712a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j4) {
        View view = (View) this.f712a.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
    }

    public final void d(Z z) {
        View view = (View) this.f712a.get();
        if (view != null) {
            if (z != null) {
                view.animate().setListener(new X(z, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f4) {
        View view = (View) this.f712a.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
    }
}
