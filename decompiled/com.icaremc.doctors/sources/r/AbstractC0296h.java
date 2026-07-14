package r;

import java.util.ConcurrentModificationException;
import s.AbstractC0298a;

/* renamed from: r.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0296h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3569a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f3570b = new Object();

    public static final void a(C0294f c0294f, int i2) {
        c0294f.f3562c = new int[i2];
        c0294f.f3563d = new Object[i2];
    }

    public static final int b(C0294f c0294f, Object obj, int i2) {
        int i3 = c0294f.f3564e;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a2 = AbstractC0298a.a(i3, i2, c0294f.f3562c);
            if (a2 < 0 || kotlin.jvm.internal.h.a(obj, c0294f.f3563d[a2])) {
                return a2;
            }
            int i4 = a2 + 1;
            while (i4 < i3 && c0294f.f3562c[i4] == i2) {
                if (kotlin.jvm.internal.h.a(obj, c0294f.f3563d[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = a2 - 1; i5 >= 0 && c0294f.f3562c[i5] == i2; i5--) {
                if (kotlin.jvm.internal.h.a(obj, c0294f.f3563d[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
