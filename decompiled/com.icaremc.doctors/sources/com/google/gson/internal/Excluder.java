package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;

    public Excluder() {
        List<ExclusionStrategy> list = Collections.EMPTY_LIST;
        this.serializationStrategies = list;
        this.deserializationStrategies = list;
    }

    private static boolean isInnerClass(Class<?> cls) {
        if (cls.isMemberClass() && !ReflectionHelper.isStatic(cls)) {
            return true;
        }
        return false;
    }

    private boolean isValidSince(Since since) {
        if (since == null) {
            return true;
        }
        if (this.version >= since.value()) {
            return true;
        }
        return false;
    }

    private boolean isValidUntil(Until until) {
        if (until == null) {
            return true;
        }
        if (this.version < until.value()) {
            return true;
        }
        return false;
    }

    private boolean isValidVersion(Since since, Until until) {
        if (isValidSince(since) && isValidUntil(until)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (!excludeClass && !excludeClass2) {
            return null;
        }
        return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
            private volatile TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) {
                if (excludeClass2) {
                    jsonReader.skipValue();
                    return null;
                }
                return delegate().read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t2) {
                if (excludeClass) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t2);
                }
            }
        };
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m2clone = m2clone();
        m2clone.serializeInnerClasses = false;
        return m2clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        List<ExclusionStrategy> list;
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && isInnerClass(cls)) {
            return true;
        }
        if (!z && !Enum.class.isAssignableFrom(cls) && ReflectionHelper.isAnonymousOrNonStaticLocal(cls)) {
            return true;
        }
        if (z) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeField(Field field, boolean z) {
        List<ExclusionStrategy> list;
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? !expose.deserialize() : !expose.serialize()))) || excludeClass(field.getType(), z)) {
            return true;
        }
        if (z) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            Iterator<ExclusionStrategy> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m2clone = m2clone();
        m2clone.requireExpose = true;
        return m2clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder m2clone = m2clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            m2clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            m2clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return m2clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m2clone = m2clone();
        m2clone.modifiers = 0;
        for (int i2 : iArr) {
            m2clone.modifiers = i2 | m2clone.modifiers;
        }
        return m2clone;
    }

    public Excluder withVersion(double d2) {
        Excluder m2clone = m2clone();
        m2clone.version = d2;
        return m2clone;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m2clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
