package io.flutter.plugin.platform;

import D2.K;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import n2.C0460a;
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class j implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4330f = 1;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ View.OnFocusChangeListener f4331g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f4332h;

    public j(View.OnFocusChangeListener onFocusChangeListener, C0460a c0460a) {
        this.f4331g = onFocusChangeListener;
        this.f4332h = c0460a;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        switch (this.f4330f) {
            case 0:
                k kVar = (k) this.f4332h;
                this.f4331g.onFocusChange(kVar, AbstractC0602b.W(kVar, new K(11)));
                return;
            default:
                C0460a c0460a = (C0460a) this.f4332h;
                this.f4331g.onFocusChange(c0460a, AbstractC0602b.W(c0460a, new K(11)));
                return;
        }
    }

    public j(k kVar, View.OnFocusChangeListener onFocusChangeListener) {
        this.f4332h = kVar;
        this.f4331g = onFocusChangeListener;
    }
}
