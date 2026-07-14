package androidx.fragment.app;

import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class n0 implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1705c;

    public n0(View view) {
        this.f1705c = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        View view2 = this.f1705c;
        view2.removeOnAttachStateChangeListener(this);
        Field field = E.J.f180a;
        view2.requestApplyInsets();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
