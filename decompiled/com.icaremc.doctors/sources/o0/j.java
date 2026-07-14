package o0;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class j implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final k f3378c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f3379d;

    public j(k sidecarCompat, Activity activity) {
        kotlin.jvm.internal.h.e(sidecarCompat, "sidecarCompat");
        this.f3378c = sidecarCompat;
        this.f3379d = new WeakReference(activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        IBinder iBinder;
        Window window;
        WindowManager.LayoutParams attributes;
        kotlin.jvm.internal.h.e(view, "view");
        view.removeOnAttachStateChangeListener(this);
        Activity activity = (Activity) this.f3379d.get();
        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            iBinder = attributes.token;
        } else {
            iBinder = null;
        }
        if (activity == null || iBinder == null) {
            return;
        }
        this.f3378c.c(iBinder, activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        kotlin.jvm.internal.h.e(view, "view");
    }
}
