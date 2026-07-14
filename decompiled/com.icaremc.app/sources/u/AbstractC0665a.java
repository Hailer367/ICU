package u;

import T2.h;

/* renamed from: u.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0665a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6206a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Object[] f6207b = new Object[0];

    public static final int a(int i4, int i5, int[] iArr) {
        h.e(iArr, "array");
        int i6 = i4 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i5) {
                i7 = i8 + 1;
            } else if (i9 > i5) {
                i6 = i8 - 1;
            } else {
                return i8;
            }
        }
        return ~i7;
    }

    public static final int b(long[] jArr, int i4, long j4) {
        h.e(jArr, "array");
        int i5 = i4 - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            long j5 = jArr[i7];
            if (j5 < j4) {
                i6 = i7 + 1;
            } else if (j5 > j4) {
                i5 = i7 - 1;
            } else {
                return i7;
            }
        }
        return ~i6;
    }
}
