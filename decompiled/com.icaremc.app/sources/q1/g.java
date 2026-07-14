package q1;

import android.os.Bundle;
import n.p;
import p1.C0580i;

/* loaded from: classes.dex */
public abstract class g extends j1.g implements r1.h {

    /* renamed from: g, reason: collision with root package name */
    public final p f5958g;

    /* renamed from: h, reason: collision with root package name */
    public final C0580i f5959h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ j f5960i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(j jVar, p pVar, C0580i c0580i) {
        super(2);
        this.f5960i = jVar;
        attachInterface(this, "com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
        this.f5958g = pVar;
        this.f5959h = c0580i;
    }

    @Override // r1.h
    public void b(Bundle bundle) {
        this.f5960i.f5964a.c(this.f5959h);
        this.f5958g.o("onRequestInfo", new Object[0]);
    }

    @Override // r1.h
    public void e(Bundle bundle) {
        this.f5960i.f5964a.c(this.f5959h);
        this.f5958g.o("onCompleteUpdate", new Object[0]);
    }
}
