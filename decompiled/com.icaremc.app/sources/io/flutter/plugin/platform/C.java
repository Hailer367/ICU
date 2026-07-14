package io.flutter.plugin.platform;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import y0.C0738j;

/* loaded from: classes.dex */
public final class C implements View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4304f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4305g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f4306h;

    public C(View view, o oVar) {
        this.f4305g = view;
        this.f4306h = oVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        IBinder iBinder;
        Window window;
        WindowManager.LayoutParams attributes;
        switch (this.f4304f) {
            case 0:
                View view2 = (View) this.f4305g;
                view2.getViewTreeObserver().addOnDrawListener(new D(view2, new B(0, this)));
                view2.removeOnAttachStateChangeListener(this);
                return;
            default:
                T2.h.e(view, "view");
                view.removeOnAttachStateChangeListener(this);
                Activity activity = (Activity) ((WeakReference) this.f4306h).get();
                if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                    iBinder = attributes.token;
                } else {
                    iBinder = null;
                }
                if (activity != null && iBinder != null) {
                    ((C0738j) this.f4305g).c(iBinder, activity);
                    return;
                }
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f4304f) {
            case 0:
                return;
            default:
                T2.h.e(view, "view");
                return;
        }
    }

    public C(C0738j c0738j, Activity activity) {
        T2.h.e(c0738j, "sidecarCompat");
        this.f4305g = c0738j;
        this.f4306h = new WeakReference(activity);
    }

    private final void a(View view) {
    }
}
