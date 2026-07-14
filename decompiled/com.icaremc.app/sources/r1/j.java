package r1;

import p1.C0580i;

/* loaded from: classes.dex */
public abstract class j implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final C0580i f6024f;

    public j() {
        this.f6024f = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e4) {
            C0580i c0580i = this.f6024f;
            if (c0580i != null) {
                c0580i.c(e4);
            }
        }
    }

    public j(C0580i c0580i) {
        this.f6024f = c0580i;
    }
}
