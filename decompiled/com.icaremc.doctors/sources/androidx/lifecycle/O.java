package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import b0.InterfaceC0162d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class O {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f1797f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1798a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1799b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1800c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f1801d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0162d f1802e;

    public O(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1798a = linkedHashMap;
        this.f1799b = new LinkedHashMap();
        this.f1800c = new LinkedHashMap();
        this.f1801d = new LinkedHashMap();
        this.f1802e = new N(0, this);
        linkedHashMap.putAll(hashMap);
    }

    public static Bundle a(O o2) {
        Map map;
        D d2;
        LinkedHashMap linkedHashMap = o2.f1798a;
        LinkedHashMap linkedHashMap2 = o2.f1799b;
        kotlin.jvm.internal.h.e(linkedHashMap2, "<this>");
        int size = linkedHashMap2.size();
        if (size != 0) {
            if (size != 1) {
                map = new LinkedHashMap(linkedHashMap2);
            } else {
                kotlin.jvm.internal.h.e(linkedHashMap2, "<this>");
                Map.Entry entry = (Map.Entry) linkedHashMap2.entrySet().iterator().next();
                map = Collections.singletonMap(entry.getKey(), entry.getValue());
                kotlin.jvm.internal.h.d(map, "with(...)");
            }
        } else {
            map = R0.s.f751c;
        }
        Iterator it = map.entrySet().iterator();
        while (true) {
            int i2 = 0;
            if (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                String key = (String) entry2.getKey();
                Object a2 = ((InterfaceC0162d) entry2.getValue()).a();
                kotlin.jvm.internal.h.e(key, "key");
                if (a2 != null) {
                    while (i2 < 29) {
                        Class cls = f1797f[i2];
                        kotlin.jvm.internal.h.b(cls);
                        if (!cls.isInstance(a2)) {
                            i2++;
                        }
                    }
                    throw new IllegalArgumentException("Can't put value with type " + a2.getClass() + " into saved state");
                }
                Object obj = o2.f1800c.get(key);
                if (obj instanceof D) {
                    d2 = (D) obj;
                } else {
                    d2 = null;
                }
                if (d2 != null) {
                    d2.setValue(a2);
                } else {
                    linkedHashMap.put(key, a2);
                }
                o1.r rVar = (o1.r) o2.f1801d.get(key);
                if (rVar != null) {
                    o1.v vVar = (o1.v) rVar;
                    if (a2 == null) {
                        a2 = p1.k.f3488a;
                    }
                    vVar.c(null, a2);
                }
            } else {
                Set<String> keySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                Q0.e[] eVarArr = {new Q0.e("keys", arrayList), new Q0.e("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i2 < 2) {
                    Q0.e eVar = eVarArr[i2];
                    String str2 = (String) eVar.f714c;
                    Object obj2 = eVar.f715d;
                    if (obj2 == null) {
                        bundle.putString(str2, null);
                    } else if (obj2 instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj2).booleanValue());
                    } else if (obj2 instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj2).byteValue());
                    } else if (obj2 instanceof Character) {
                        bundle.putChar(str2, ((Character) obj2).charValue());
                    } else if (obj2 instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj2).doubleValue());
                    } else if (obj2 instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj2).floatValue());
                    } else if (obj2 instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj2).intValue());
                    } else if (obj2 instanceof Long) {
                        bundle.putLong(str2, ((Number) obj2).longValue());
                    } else if (obj2 instanceof Short) {
                        bundle.putShort(str2, ((Number) obj2).shortValue());
                    } else if (obj2 instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj2);
                    } else if (obj2 instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj2);
                    } else if (obj2 instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj2);
                    } else if (obj2 instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj2);
                    } else if (obj2 instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj2);
                    } else if (obj2 instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj2);
                    } else if (obj2 instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj2);
                    } else if (obj2 instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj2);
                    } else if (obj2 instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj2);
                    } else if (obj2 instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj2);
                    } else if (obj2 instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj2);
                    } else if (obj2 instanceof Object[]) {
                        Class<?> componentType = obj2.getClass().getComponentType();
                        kotlin.jvm.internal.h.b(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj2);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj2);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj2);
                        } else if (Serializable.class.isAssignableFrom(componentType)) {
                            bundle.putSerializable(str2, (Serializable) obj2);
                        } else {
                            throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                    } else if (obj2 instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj2);
                    } else if (obj2 instanceof IBinder) {
                        bundle.putBinder(str2, (IBinder) obj2);
                    } else if (obj2 instanceof Size) {
                        bundle.putSize(str2, (Size) obj2);
                    } else if (obj2 instanceof SizeF) {
                        bundle.putSizeF(str2, (SizeF) obj2);
                    } else {
                        throw new IllegalArgumentException("Illegal value type " + obj2.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                    }
                    i2++;
                }
                return bundle;
            }
        }
    }

    public O() {
        this.f1798a = new LinkedHashMap();
        this.f1799b = new LinkedHashMap();
        this.f1800c = new LinkedHashMap();
        this.f1801d = new LinkedHashMap();
        this.f1802e = new N(0, this);
    }
}
