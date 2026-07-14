package io.flutter.plugin.platform;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class u extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public final C0377a f4394f;

    /* renamed from: g, reason: collision with root package name */
    public final View f4395g;

    public u(Context context, C0377a c0377a, View view) {
        super(context);
        this.f4394f = c0377a;
        this.f4395g = view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.j jVar = this.f4394f.f4320a;
        if (jVar == null) {
            return false;
        }
        return jVar.a(this.f4395g, view, accessibilityEvent);
    }
}
