package t;

import java.util.ConcurrentModificationException;
import u.AbstractC0665a;

/* renamed from: t.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0659h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f6186a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6187b = new Object();

    public static final void a(C0657f c0657f, int i4) {
        c0657f.f6179f = new int[i4];
        c0657f.f6180g = new Object[i4];
    }

    public static final int b(C0657f c0657f, Object obj, int i4) {
        int i5 = c0657f.f6181h;
        if (i5 == 0) {
            return -1;
        }
        try {
            int a4 = AbstractC0665a.a(i5, i4, c0657f.f6179f);
            if (a4 < 0 || T2.h.a(obj, c0657f.f6180g[a4])) {
                return a4;
            }
            int i6 = a4 + 1;
            while (i6 < i5 && c0657f.f6179f[i6] == i4) {
                if (T2.h.a(obj, c0657f.f6180g[i6])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = a4 - 1; i7 >= 0 && c0657f.f6179f[i7] == i4; i7--) {
                if (T2.h.a(obj, c0657f.f6180g[i7])) {
                    return i7;
                }
            }
            return ~i6;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
