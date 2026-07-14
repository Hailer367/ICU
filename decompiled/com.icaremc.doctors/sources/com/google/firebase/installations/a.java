package com.google.firebase.installations;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2059c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f2060d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f2061e;

    public /* synthetic */ a(FirebaseInstallations firebaseInstallations, boolean z, int i2) {
        this.f2059c = i2;
        this.f2060d = firebaseInstallations;
        this.f2061e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2059c) {
            case 0:
                FirebaseInstallations.c(this.f2060d, this.f2061e);
                return;
            default:
                FirebaseInstallations.b(this.f2060d, this.f2061e);
                return;
        }
    }
}
