package d;

/* renamed from: d.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0172a {

    /* renamed from: a, reason: collision with root package name */
    public final float f2111a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2112b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2113c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2114d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2115e;

    public C0172a(W.b navigationEvent) {
        kotlin.jvm.internal.h.e(navigationEvent, "navigationEvent");
        float f2 = navigationEvent.f791c;
        float f3 = navigationEvent.f792d;
        float f4 = navigationEvent.f790b;
        int i2 = navigationEvent.f789a;
        long j2 = navigationEvent.f793e;
        this.f2111a = f2;
        this.f2112b = f3;
        this.f2113c = f4;
        this.f2114d = i2;
        this.f2115e = j2;
    }

    public final String toString() {
        return "BackEventCompat(touchX=" + this.f2111a + ", touchY=" + this.f2112b + ", progress=" + this.f2113c + ", swipeEdge=" + this.f2114d + ", frameTimeMillis=" + this.f2115e + ')';
    }
}
