package r;

import android.os.Bundle;

/* renamed from: r.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0608c implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5973f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f5974g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Bundle f5975h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ BinderC0612g f5976i;

    public /* synthetic */ RunnableC0608c(BinderC0612g binderC0612g, String str, Bundle bundle, int i4) {
        this.f5973f = i4;
        this.f5976i = binderC0612g;
        this.f5974g = str;
        this.f5975h = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5973f) {
            case 0:
                this.f5976i.f5993g.extraCallback(this.f5974g, this.f5975h);
                return;
            default:
                this.f5976i.f5993g.onPostMessage(this.f5974g, this.f5975h);
                return;
        }
    }
}
