package r;

import android.net.Uri;
import android.os.Bundle;

/* renamed from: r.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0609d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5977f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Uri f5978g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f5979h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Bundle f5980i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ BinderC0612g f5981j;

    public RunnableC0609d(BinderC0612g binderC0612g, int i4, Uri uri, boolean z, Bundle bundle) {
        this.f5981j = binderC0612g;
        this.f5977f = i4;
        this.f5978g = uri;
        this.f5979h = z;
        this.f5980i = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5981j.f5993g.onRelationshipValidationResult(this.f5977f, this.f5978g, this.f5979h, this.f5980i);
    }
}
