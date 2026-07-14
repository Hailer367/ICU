package r;

import android.os.Bundle;

/* renamed from: r.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0611f implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5986f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5987g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5988h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5989i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5990j;
    public final /* synthetic */ Bundle k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ BinderC0612g f5991l;

    public RunnableC0611f(BinderC0612g binderC0612g, int i4, int i5, int i6, int i7, int i8, Bundle bundle) {
        this.f5991l = binderC0612g;
        this.f5986f = i4;
        this.f5987g = i5;
        this.f5988h = i6;
        this.f5989i = i7;
        this.f5990j = i8;
        this.k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5991l.f5993g.onActivityLayout(this.f5986f, this.f5987g, this.f5988h, this.f5989i, this.f5990j, this.k);
    }
}
