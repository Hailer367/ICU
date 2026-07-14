package d;

import androidx.fragment.app.M;

/* renamed from: d.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0173b implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2116c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ M f2117d;

    public /* synthetic */ RunnableC0173b(M m2, int i2) {
        this.f2116c = i2;
        this.f2117d = m2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2116c) {
            case 0:
                k.d(this.f2117d);
                return;
            default:
                this.f2117d.invalidateMenu();
                return;
        }
    }
}
