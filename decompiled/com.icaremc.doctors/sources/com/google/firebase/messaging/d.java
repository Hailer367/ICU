package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2071c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2072d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2073e;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f2071c = i2;
        this.f2072d = obj;
        this.f2073e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2071c) {
            case 0:
                FcmLifecycleCallbacks.a((FcmLifecycleCallbacks) this.f2072d, (Intent) this.f2073e);
                return;
            default:
                ImageDownload.a((ImageDownload) this.f2072d, (TaskCompletionSource) this.f2073e);
                return;
        }
    }
}
