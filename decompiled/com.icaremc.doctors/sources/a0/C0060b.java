package a0;

/* renamed from: a0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0060b {

    /* renamed from: a, reason: collision with root package name */
    public long f937a = 0;

    /* renamed from: b, reason: collision with root package name */
    public C0060b f938b;

    public final int a(int i2) {
        C0060b c0060b = this.f938b;
        if (c0060b == null) {
            if (i2 >= 64) {
                return Long.bitCount(this.f937a);
            }
            return Long.bitCount(this.f937a & ((1 << i2) - 1));
        }
        if (i2 < 64) {
            return Long.bitCount(this.f937a & ((1 << i2) - 1));
        }
        return Long.bitCount(this.f937a) + c0060b.a(i2 - 64);
    }

    public final boolean b(int i2) {
        if (i2 >= 64) {
            if (this.f938b == null) {
                this.f938b = new C0060b();
            }
            return this.f938b.b(i2 - 64);
        }
        if ((this.f937a & (1 << i2)) != 0) {
            return true;
        }
        return false;
    }

    public final void c() {
        this.f937a = 0L;
        C0060b c0060b = this.f938b;
        if (c0060b != null) {
            c0060b.c();
        }
    }

    public final String toString() {
        if (this.f938b == null) {
            return Long.toBinaryString(this.f937a);
        }
        return this.f938b.toString() + "xx" + Long.toBinaryString(this.f937a);
    }
}
