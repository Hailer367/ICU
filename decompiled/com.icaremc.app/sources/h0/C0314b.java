package h0;

/* renamed from: h0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0314b {

    /* renamed from: a, reason: collision with root package name */
    public long f3861a = 0;

    /* renamed from: b, reason: collision with root package name */
    public C0314b f3862b;

    public final int a(int i4) {
        C0314b c0314b = this.f3862b;
        if (c0314b == null) {
            if (i4 >= 64) {
                return Long.bitCount(this.f3861a);
            }
            return Long.bitCount(this.f3861a & ((1 << i4) - 1));
        }
        if (i4 < 64) {
            return Long.bitCount(this.f3861a & ((1 << i4) - 1));
        }
        return Long.bitCount(this.f3861a) + c0314b.a(i4 - 64);
    }

    public final boolean b(int i4) {
        if (i4 >= 64) {
            if (this.f3862b == null) {
                this.f3862b = new C0314b();
            }
            return this.f3862b.b(i4 - 64);
        }
        if ((this.f3861a & (1 << i4)) != 0) {
            return true;
        }
        return false;
    }

    public final void c() {
        this.f3861a = 0L;
        C0314b c0314b = this.f3862b;
        if (c0314b != null) {
            c0314b.c();
        }
    }

    public final String toString() {
        if (this.f3862b == null) {
            return Long.toBinaryString(this.f3861a);
        }
        return this.f3862b.toString() + "xx" + Long.toBinaryString(this.f3861a);
    }
}
