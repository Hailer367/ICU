package I2;

import a.AbstractC0141a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class d extends AbstractC0141a {
    public static void V(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        T2.h.e(iArr, "<this>");
        T2.h.e(iArr2, "destination");
        System.arraycopy(iArr, i5, iArr2, i4, i6 - i5);
    }

    public static void W(Object[] objArr, Object[] objArr2, int i4, int i5, int i6) {
        T2.h.e(objArr, "<this>");
        T2.h.e(objArr2, "destination");
        System.arraycopy(objArr, i5, objArr2, i4, i6 - i5);
    }

    public static /* synthetic */ void X(Object[] objArr, Object[] objArr2, int i4, int i5, int i6) {
        if ((i6 & 4) != 0) {
            i4 = 0;
        }
        W(objArr, objArr2, 0, i4, i5);
    }

    public static Object[] Y(Object[] objArr, int i4, int i5) {
        T2.h.e(objArr, "<this>");
        int length = objArr.length;
        if (i5 <= length) {
            Object[] copyOfRange = Arrays.copyOfRange(objArr, i4, i5);
            T2.h.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + length + ").");
    }

    public static Object Z(Object[] objArr) {
        T2.h.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static List a0(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            if (length != 1) {
                return new ArrayList(new b(objArr, false));
            }
            return android.support.v4.media.session.a.p(objArr[0]);
        }
        return m.f862f;
    }
}
