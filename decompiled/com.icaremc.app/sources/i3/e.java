package i3;

import b3.AbstractC0242q;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: i, reason: collision with root package name */
    public static final e f4174i;

    /* JADX WARN: Type inference failed for: r0v0, types: [i3.e, i3.h, b3.q] */
    static {
        int i4 = k.f4182c;
        int i5 = k.f4183d;
        long j4 = k.f4184e;
        String str = k.f4180a;
        ?? abstractC0242q = new AbstractC0242q();
        abstractC0242q.f4176h = new c(i4, i5, j4, str);
        f4174i = abstractC0242q;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // b3.AbstractC0242q
    public final String toString() {
        return "Dispatchers.Default";
    }
}
