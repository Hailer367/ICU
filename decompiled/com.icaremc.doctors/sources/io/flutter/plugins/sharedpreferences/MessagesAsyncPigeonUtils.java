package io.flutter.plugins.sharedpreferences;

import R0.k;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessagesAsyncPigeonUtils {
    public static final MessagesAsyncPigeonUtils INSTANCE = new MessagesAsyncPigeonUtils();

    private MessagesAsyncPigeonUtils() {
    }

    public final boolean deepEquals(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (objArr.length == objArr2.length) {
                Iterable aVar = new h1.a(0, objArr.length - 1, 1);
                if (!(aVar instanceof Collection) || !((Collection) aVar).isEmpty()) {
                    Iterator it = aVar.iterator();
                    while (((h1.b) it).f2326e) {
                        int nextInt = ((h1.b) it).nextInt();
                        if (!INSTANCE.deepEquals(objArr[nextInt], objArr2[nextInt])) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() == list2.size()) {
                Collection collection = (Collection) obj;
                h.e(collection, "<this>");
                Iterable aVar2 = new h1.a(0, collection.size() - 1, 1);
                if (!(aVar2 instanceof Collection) || !((Collection) aVar2).isEmpty()) {
                    Iterator it2 = aVar2.iterator();
                    while (((h1.b) it2).f2326e) {
                        int nextInt2 = ((h1.b) it2).nextInt();
                        if (!INSTANCE.deepEquals(list.get(nextInt2), list2.get(nextInt2))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof Map) && (obj2 instanceof Map)) {
            Map map = (Map) obj;
            Map map2 = (Map) obj2;
            if (map.size() == map2.size()) {
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (map2.containsKey(entry.getKey()) && INSTANCE.deepEquals(entry.getValue(), map2.get(entry.getKey()))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return h.a(obj, obj2);
    }

    public final List<Object> wrapError(Throwable exception) {
        h.e(exception, "exception");
        if (exception instanceof SharedPreferencesError) {
            SharedPreferencesError sharedPreferencesError = (SharedPreferencesError) exception;
            return k.N(sharedPreferencesError.getCode(), sharedPreferencesError.getMessage(), sharedPreferencesError.getDetails());
        }
        return k.N(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object obj) {
        return android.support.v4.media.session.a.y(obj);
    }
}
