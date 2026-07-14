package com.dexterous.flutterlocalnotifications;

import T1.s;
import T1.t;
import W1.r;
import a2.C0143a;
import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;

@Keep
/* loaded from: classes.dex */
public final class RuntimeTypeAdapterFactory<T> implements t {
    private final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    private final String typeFieldName;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str != null && cls != null) {
            this.baseType = cls;
            this.typeFieldName = str;
            return;
        }
        throw null;
    }

    public static /* bridge */ /* synthetic */ Class a(RuntimeTypeAdapterFactory runtimeTypeAdapterFactory) {
        return runtimeTypeAdapterFactory.baseType;
    }

    public static /* bridge */ /* synthetic */ Map b(RuntimeTypeAdapterFactory runtimeTypeAdapterFactory) {
        return runtimeTypeAdapterFactory.subtypeToLabel;
    }

    public static /* bridge */ /* synthetic */ String c(RuntimeTypeAdapterFactory runtimeTypeAdapterFactory) {
        return runtimeTypeAdapterFactory.typeFieldName;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // T1.t
    public <R> s create(T1.e eVar, C0143a<R> c0143a) {
        if (c0143a.f2216a != this.baseType) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.labelToSubtype.entrySet()) {
            s d4 = eVar.d(this, new C0143a(entry.getValue()));
            linkedHashMap.put(entry.getKey(), d4);
            linkedHashMap2.put(entry.getValue(), d4);
        }
        return new r(this, linkedHashMap, linkedHashMap2).a();
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls != null && str != null) {
            if (!this.subtypeToLabel.containsKey(cls) && !this.labelToSubtype.containsKey(str)) {
                this.labelToSubtype.put(str, cls);
                this.subtypeToLabel.put(cls, str);
                return this;
            }
            throw new IllegalArgumentException("types and labels must be unique");
        }
        throw null;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type");
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }
}
