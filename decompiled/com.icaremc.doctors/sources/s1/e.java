package s1;

import l1.AbstractC0240s;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: f, reason: collision with root package name */
    public static final e f3617f;

    /* JADX WARN: Type inference failed for: r0v0, types: [s1.e, l1.s, s1.h] */
    static {
        int i2 = k.f3625c;
        int i3 = k.f3626d;
        long j2 = k.f3627e;
        String str = k.f3623a;
        ?? abstractC0240s = new AbstractC0240s();
        abstractC0240s.f3619e = new c(i2, i3, j2, str);
        f3617f = abstractC0240s;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // l1.AbstractC0240s
    public final String toString() {
        return "Dispatchers.Default";
    }
}
