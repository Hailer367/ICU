package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import i0.InterfaceC0361d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class J {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f2969f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2970a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2971b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2972c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2973d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0361d f2974e;

    public J(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f2970a = linkedHashMap;
        this.f2971b = new LinkedHashMap();
        this.f2972c = new LinkedHashMap();
        this.f2973d = new LinkedHashMap();
        this.f2974e = new I(0, this);
        linkedHashMap.putAll(hashMap);
    }

    public static Bundle a(J j4) {
        Map map;
        LinkedHashMap linkedHashMap = j4.f2970a;
        LinkedHashMap linkedHashMap2 = j4.f2971b;
        T2.h.e(linkedHashMap2, "<this>");
        int size = linkedHashMap2.size();
        if (size != 0) {
            if (size != 1) {
                map = new LinkedHashMap(linkedHashMap2);
            } else {
                T2.h.e(linkedHashMap2, "<this>");
                Map.Entry entry = (Map.Entry) linkedHashMap2.entrySet().iterator().next();
                map = Collections.singletonMap(entry.getKey(), entry.getValue());
                T2.h.d(map, "with(...)");
            }
        } else {
            map = I2.n.f863f;
        }
        Iterator it = map.entrySet().iterator();
        while (true) {
            z zVar = null;
            int i4 = 0;
            if (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                String str = (String) entry2.getKey();
                Bundle a4 = ((InterfaceC0361d) entry2.getValue()).a();
                T2.h.e(str, "key");
                if (a4 != null) {
                    while (i4 < 29) {
                        Class cls = f2969f[i4];
                        T2.h.b(cls);
                        if (!cls.isInstance(a4)) {
                            i4++;
                        }
                    }
                    throw new IllegalArgumentException("Can't put value with type " + a4.getClass() + " into saved state");
                }
                Object obj = j4.f2972c.get(str);
                if (obj instanceof z) {
                    zVar = (z) obj;
                }
                if (zVar != null) {
                    zVar.f(a4);
                } else {
                    linkedHashMap.put(str, a4);
                }
                e3.o oVar = (e3.o) j4.f2973d.get(str);
                if (oVar != null) {
                    ((e3.r) oVar).b(a4);
                }
            } else {
                Set<String> keySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str2 : keySet) {
                    arrayList.add(str2);
                    arrayList2.add(linkedHashMap.get(str2));
                }
                H2.d[] dVarArr = {new H2.d("keys", arrayList), new H2.d("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i4 < 2) {
                    H2.d dVar = dVarArr[i4];
                    String str3 = (String) dVar.f673f;
                    Object obj2 = dVar.f674g;
                    if (obj2 == null) {
                        bundle.putString(str3, null);
                    } else if (obj2 instanceof Boolean) {
                        bundle.putBoolean(str3, ((Boolean) obj2).booleanValue());
                    } else if (obj2 instanceof Byte) {
                        bundle.putByte(str3, ((Number) obj2).byteValue());
                    } else if (obj2 instanceof Character) {
                        bundle.putChar(str3, ((Character) obj2).charValue());
                    } else if (obj2 instanceof Double) {
                        bundle.putDouble(str3, ((Number) obj2).doubleValue());
                    } else if (obj2 instanceof Float) {
                        bundle.putFloat(str3, ((Number) obj2).floatValue());
                    } else if (obj2 instanceof Integer) {
                        bundle.putInt(str3, ((Number) obj2).intValue());
                    } else if (obj2 instanceof Long) {
                        bundle.putLong(str3, ((Number) obj2).longValue());
                    } else if (obj2 instanceof Short) {
                        bundle.putShort(str3, ((Number) obj2).shortValue());
                    } else if (obj2 instanceof Bundle) {
                        bundle.putBundle(str3, (Bundle) obj2);
                    } else if (obj2 instanceof CharSequence) {
                        bundle.putCharSequence(str3, (CharSequence) obj2);
                    } else if (obj2 instanceof Parcelable) {
                        bundle.putParcelable(str3, (Parcelable) obj2);
                    } else if (obj2 instanceof boolean[]) {
                        bundle.putBooleanArray(str3, (boolean[]) obj2);
                    } else if (obj2 instanceof byte[]) {
                        bundle.putByteArray(str3, (byte[]) obj2);
                    } else if (obj2 instanceof char[]) {
                        bundle.putCharArray(str3, (char[]) obj2);
                    } else if (obj2 instanceof double[]) {
                        bundle.putDoubleArray(str3, (double[]) obj2);
                    } else if (obj2 instanceof float[]) {
                        bundle.putFloatArray(str3, (float[]) obj2);
                    } else if (obj2 instanceof int[]) {
                        bundle.putIntArray(str3, (int[]) obj2);
                    } else if (obj2 instanceof long[]) {
                        bundle.putLongArray(str3, (long[]) obj2);
                    } else if (obj2 instanceof short[]) {
                        bundle.putShortArray(str3, (short[]) obj2);
                    } else if (obj2 instanceof Object[]) {
                        Class<?> componentType = obj2.getClass().getComponentType();
                        T2.h.b(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str3, (Parcelable[]) obj2);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str3, (String[]) obj2);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str3, (CharSequence[]) obj2);
                        } else if (Serializable.class.isAssignableFrom(componentType)) {
                            bundle.putSerializable(str3, (Serializable) obj2);
                        } else {
                            throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str3 + '\"');
                        }
                    } else if (obj2 instanceof Serializable) {
                        bundle.putSerializable(str3, (Serializable) obj2);
                    } else if (obj2 instanceof IBinder) {
                        bundle.putBinder(str3, (IBinder) obj2);
                    } else if (obj2 instanceof Size) {
                        bundle.putSize(str3, (Size) obj2);
                    } else if (obj2 instanceof SizeF) {
                        bundle.putSizeF(str3, (SizeF) obj2);
                    } else {
                        throw new IllegalArgumentException("Illegal value type " + obj2.getClass().getCanonicalName() + " for key \"" + str3 + '\"');
                    }
                    i4++;
                }
                return bundle;
            }
        }
    }

    public J() {
        this.f2970a = new LinkedHashMap();
        this.f2971b = new LinkedHashMap();
        this.f2972c = new LinkedHashMap();
        this.f2973d = new LinkedHashMap();
        this.f2974e = new I(0, this);
    }
}
