package y2;

import android.content.Intent;

/* loaded from: classes.dex */
public final class j implements k {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f6620a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6621b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ io.flutter.plugins.firebase.messaging.a f6622c;

    public j(io.flutter.plugins.firebase.messaging.a aVar, Intent intent, int i4) {
        this.f6622c = aVar;
        this.f6620a = intent;
        this.f6621b = i4;
    }

    @Override // y2.k
    public final void a() {
        this.f6622c.stopSelf(this.f6621b);
    }

    @Override // y2.k
    public final Intent getIntent() {
        return this.f6620a;
    }
}
