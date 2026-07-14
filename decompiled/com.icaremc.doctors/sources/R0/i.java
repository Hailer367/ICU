package R0;

import a.AbstractC0051a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class i extends AbstractC0051a {
    public static void X(int i2, int i3, int i4, int[] iArr, int[] destination) {
        kotlin.jvm.internal.h.e(iArr, "<this>");
        kotlin.jvm.internal.h.e(destination, "destination");
        System.arraycopy(iArr, i3, destination, i2, i4 - i3);
    }

    public static void Y(Object[] objArr, Object[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.h.e(objArr, "<this>");
        kotlin.jvm.internal.h.e(destination, "destination");
        System.arraycopy(objArr, i3, destination, i2, i4 - i3);
    }

    public static /* synthetic */ void Z(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        Y(objArr, objArr2, 0, i2, i3);
    }

    public static Object[] a0(Object[] objArr, int i2, int i3) {
        kotlin.jvm.internal.h.e(objArr, "<this>");
        int length = objArr.length;
        if (i3 <= length) {
            Object[] copyOfRange = Arrays.copyOfRange(objArr, i2, i3);
            kotlin.jvm.internal.h.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + length + ").");
    }

    public static Object b0(Object[] objArr) {
        kotlin.jvm.internal.h.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static List c0(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            if (length != 1) {
                return new ArrayList(new g(objArr, false));
            }
            return android.support.v4.media.session.a.y(objArr[0]);
        }
        return r.f750c;
    }
}
