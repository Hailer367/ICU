package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r.C0294f;
import r.j;

@KeepForSdk
/* loaded from: classes.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.EMPTY_LIST;
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k2, V v2, K k3, V v3, K k4, V v4) {
        Map zzb = zzb(3, false);
        zzb.put(k2, v2);
        zzb.put(k3, v3);
        zzb.put(k4, v4);
        return Collections.unmodifiableMap(zzb);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length == length2) {
            if (length != 0) {
                if (length != 1) {
                    Map zzb = zzb(length, false);
                    for (int i2 = 0; i2 < kArr.length; i2++) {
                        zzb.put(kArr[i2], vArr[i2]);
                    }
                    return Collections.unmodifiableMap(zzb);
                }
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            return Collections.EMPTY_MAP;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 44 + String.valueOf(length2).length());
        sb.append("Key and values array lengths not equal: ");
        sb.append(length);
        sb.append(" != ");
        sb.append(length2);
        throw new IllegalArgumentException(sb.toString());
    }

    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i2) {
        if (i2 == 0) {
            return new C0294f(0);
        }
        return zza(i2, true);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T t2, T t3, T t4) {
        Set zza = zza(3, false);
        zza.add(t2);
        zza.add(t3);
        zza.add(t4);
        return Collections.unmodifiableSet(zza);
    }

    private static Set zza(int i2, boolean z) {
        int i3;
        float f2;
        if (true != z) {
            i3 = 256;
        } else {
            i3 = 128;
        }
        if (i2 <= i3) {
            return new C0294f(i2);
        }
        if (true != z) {
            f2 = 1.0f;
        } else {
            f2 = 0.75f;
        }
        return new HashSet(i2, f2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Map, r.j] */
    private static Map zzb(int i2, boolean z) {
        if (i2 <= 256) {
            return new j(i2);
        }
        return new HashMap(i2, 1.0f);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T t2) {
        return Collections.singletonList(t2);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        Map zzb = zzb(6, false);
        zzb.put(k2, v2);
        zzb.put(k3, v3);
        zzb.put(k4, v4);
        zzb.put(k5, v5);
        zzb.put(k6, v6);
        zzb.put(k7, v7);
        return Collections.unmodifiableMap(zzb);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.EMPTY_SET;
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t2 = tArr[0];
            T t3 = tArr[1];
            Set zza = zza(2, false);
            zza.add(t2);
            zza.add(t3);
            return Collections.unmodifiableSet(zza);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set zza2 = zza(length, false);
            Collections.addAll(zza2, tArr);
            return Collections.unmodifiableSet(zza2);
        }
        T t4 = tArr[0];
        T t5 = tArr[1];
        T t6 = tArr[2];
        T t7 = tArr[3];
        Set zza3 = zza(4, false);
        zza3.add(t4);
        zza3.add(t5);
        zza3.add(t6);
        zza3.add(t7);
        return Collections.unmodifiableSet(zza3);
    }
}
