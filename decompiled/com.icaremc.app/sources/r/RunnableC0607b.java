package r;

import android.os.Bundle;

/* renamed from: r.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0607b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5970f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Bundle f5971g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ BinderC0612g f5972h;

    public /* synthetic */ RunnableC0607b(int i4, Bundle bundle, BinderC0612g binderC0612g) {
        this.f5970f = i4;
        this.f5972h = binderC0612g;
        this.f5971g = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5970f) {
            case 0:
                this.f5972h.f5993g.onUnminimized(this.f5971g);
                return;
            case 1:
                this.f5972h.f5993g.onMessageChannelReady(this.f5971g);
                return;
            case 2:
                this.f5972h.f5993g.onWarmupCompleted(this.f5971g);
                return;
            default:
                this.f5972h.f5993g.onMinimized(this.f5971g);
                return;
        }
    }
}
