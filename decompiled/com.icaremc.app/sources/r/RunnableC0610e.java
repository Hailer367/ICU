package r;

import android.os.Bundle;

/* renamed from: r.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0610e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5982f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5983g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Bundle f5984h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ BinderC0612g f5985i;

    public RunnableC0610e(BinderC0612g binderC0612g, int i4, int i5, Bundle bundle) {
        this.f5985i = binderC0612g;
        this.f5982f = i4;
        this.f5983g = i5;
        this.f5984h = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5985i.f5993g.onActivityResized(this.f5982f, this.f5983g, this.f5984h);
    }
}
