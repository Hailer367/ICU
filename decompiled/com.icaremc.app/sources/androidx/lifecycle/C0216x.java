package androidx.lifecycle;

/* renamed from: androidx.lifecycle.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0216x {

    /* renamed from: a, reason: collision with root package name */
    public final A f3033a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3034b;

    /* renamed from: c, reason: collision with root package name */
    public int f3035c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0217y f3036d;

    public C0216x(AbstractC0217y abstractC0217y, A a4) {
        this.f3036d = abstractC0217y;
        this.f3033a = a4;
    }

    public final void a(boolean z) {
        int i4;
        if (z != this.f3034b) {
            this.f3034b = z;
            if (z) {
                i4 = 1;
            } else {
                i4 = -1;
            }
            AbstractC0217y abstractC0217y = this.f3036d;
            int i5 = abstractC0217y.f3039c;
            abstractC0217y.f3039c = i4 + i5;
            if (!abstractC0217y.f3040d) {
                abstractC0217y.f3040d = true;
                while (true) {
                    try {
                        int i6 = abstractC0217y.f3039c;
                        if (i5 == i6) {
                            break;
                        } else {
                            i5 = i6;
                        }
                    } finally {
                        abstractC0217y.f3040d = false;
                    }
                }
            }
            if (this.f3034b) {
                abstractC0217y.b(this);
            }
        }
    }
}
