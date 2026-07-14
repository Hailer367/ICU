package androidx.fragment.app;

import java.util.ArrayList;

/* renamed from: androidx.fragment.app.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0127w implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1765c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1766d;

    public /* synthetic */ RunnableC0127w(int i2, Object obj) {
        this.f1765c = i2;
        this.f1766d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1765c) {
            case 0:
                H h2 = (H) this.f1766d;
                A0 a02 = h2.mViewLifecycleOwner;
                a02.f1501g.b(h2.mSavedViewRegistryState);
                h2.mSavedViewRegistryState = null;
                return;
            default:
                s0.a(4, (ArrayList) this.f1766d);
                return;
        }
    }
}
