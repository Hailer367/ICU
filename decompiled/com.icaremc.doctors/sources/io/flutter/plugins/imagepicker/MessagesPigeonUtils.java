package io.flutter.plugins.imagepicker;

import R0.k;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessagesPigeonUtils {
    public static final MessagesPigeonUtils INSTANCE = new MessagesPigeonUtils();

    private MessagesPigeonUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x013e, code lost:
    
        if (deepEquals(r2.getValue(), r5.getValue()) == false) goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean deepEquals(java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.MessagesPigeonUtils.deepEquals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int deepHash(Object obj) {
        int i2 = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.hashCode((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.hashCode((long[]) obj);
        }
        int i3 = 1;
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length;
            while (i2 < length) {
                i3 = (i3 * 31) + doubleHash(dArr[i2]);
                i2++;
            }
            return i3;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length;
            while (i2 < length2) {
                i3 = (i3 * 31) + floatHash(fArr[i2]);
                i2++;
            }
            return i3;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length3 = objArr.length;
            while (i2 < length3) {
                i3 = (i3 * 31) + deepHash(objArr[i2]);
                i2++;
            }
            return i3;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i3 = (i3 * 31) + deepHash(it.next());
            }
            return i3;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                i2 += deepHash(entry.getValue()) ^ (deepHash(entry.getKey()) * 31);
            }
            return i2;
        }
        if (obj instanceof Double) {
            return doubleHash(((Number) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return floatHash(((Number) obj).floatValue());
        }
        return obj.hashCode();
    }

    public final boolean doubleEquals(double d2, double d3) {
        double d4;
        double d5 = 0.0d;
        if (d2 == 0.0d) {
            d4 = 0.0d;
        } else {
            d4 = d2;
        }
        if (d3 != 0.0d) {
            d5 = d3;
        }
        if (d4 != d5) {
            if (Double.isNaN(d2) && Double.isNaN(d3)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int doubleHash(double d2) {
        if (d2 == 0.0d) {
            d2 = 0.0d;
        }
        long doubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final boolean floatEquals(float f2, float f3) {
        float f4;
        float f5 = 0.0f;
        if (f2 == 0.0f) {
            f4 = 0.0f;
        } else {
            f4 = f2;
        }
        if (f3 != 0.0f) {
            f5 = f3;
        }
        if (f4 != f5) {
            if (Float.isNaN(f2) && Float.isNaN(f3)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int floatHash(float f2) {
        if (f2 == 0.0f) {
            f2 = 0.0f;
        }
        return Float.floatToIntBits(f2);
    }

    public final List<Object> wrapError(Throwable exception) {
        h.e(exception, "exception");
        if (exception instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) exception;
            return k.N(flutterError.getCode(), flutterError.getMessage(), flutterError.getDetails());
        }
        return k.N(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object obj) {
        return android.support.v4.media.session.a.y(obj);
    }
}
