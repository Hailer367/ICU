package com.google.gson.internal;

import B0.h;
import C0.f;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z;
        this.reflectionFilters = list;
    }

    public static String checkInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + TroubleshootingGuide.createUrl("r8-abstract-class");
        }
        return null;
    }

    public static /* synthetic */ Object lambda$get$2(String str) {
        throw new JsonIOException(str);
    }

    public static /* synthetic */ Object lambda$get$3(String str) {
        throw new JsonIOException(str);
    }

    public static /* synthetic */ Object lambda$newDefaultConstructor$6(String str) {
        throw new JsonIOException(str);
    }

    public static /* synthetic */ Object lambda$newDefaultConstructor$7(String str) {
        throw new JsonIOException(str);
    }

    public static /* synthetic */ Object lambda$newDefaultConstructor$8(Constructor constructor) {
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e2) {
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e4.getCause());
        }
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$10() {
        return new LinkedHashSet();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$11() {
        return new ArrayDeque();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$12() {
        return new ArrayList();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$13() {
        return new ConcurrentSkipListMap();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$14() {
        return new ConcurrentHashMap();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$15() {
        return new TreeMap();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$16() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$17() {
        return new LinkedTreeMap();
    }

    public static /* synthetic */ Object lambda$newDefaultImplementationConstructor$9() {
        return new TreeSet();
    }

    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$4(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
    }

    public static /* synthetic */ Object lambda$newSpecialCollectionConstructor$5(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new JsonIOException("Invalid EnumMap type: " + type.toString());
        }
        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
    }

    public static /* synthetic */ Object lambda$newUnsafeAllocator$18(Class cls) {
        try {
            return UnsafeAllocator.INSTANCE.newInstance(cls);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
        }
    }

    public static /* synthetic */ Object lambda$newUnsafeAllocator$19(String str) {
        throw new JsonIOException(str);
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String tryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult != filterResult2 && (!ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new c("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.", 2);
            }
            if (filterResult == filterResult2 && (tryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) != null) {
                return new c(tryMakeAccessible, 3);
            }
            return new h(9, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new f(12);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new f(13);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new f(14);
            }
            return new f(15);
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new f(16);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f(17);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new f(18);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new f(19);
            }
            return new f(11);
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(final Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            final int i2 = 0;
            return new ObjectConstructor() { // from class: com.google.gson.internal.a
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    Object lambda$newSpecialCollectionConstructor$4;
                    Object lambda$newSpecialCollectionConstructor$5;
                    switch (i2) {
                        case 0:
                            lambda$newSpecialCollectionConstructor$4 = ConstructorConstructor.lambda$newSpecialCollectionConstructor$4(type);
                            return lambda$newSpecialCollectionConstructor$4;
                        default:
                            lambda$newSpecialCollectionConstructor$5 = ConstructorConstructor.lambda$newSpecialCollectionConstructor$5(type);
                            return lambda$newSpecialCollectionConstructor$5;
                    }
                }
            };
        }
        if (cls == EnumMap.class) {
            final int i3 = 1;
            return new ObjectConstructor() { // from class: com.google.gson.internal.a
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    Object lambda$newSpecialCollectionConstructor$4;
                    Object lambda$newSpecialCollectionConstructor$5;
                    switch (i3) {
                        case 0:
                            lambda$newSpecialCollectionConstructor$4 = ConstructorConstructor.lambda$newSpecialCollectionConstructor$4(type);
                            return lambda$newSpecialCollectionConstructor$4;
                        default:
                            lambda$newSpecialCollectionConstructor$5 = ConstructorConstructor.lambda$newSpecialCollectionConstructor$5(type);
                            return lambda$newSpecialCollectionConstructor$5;
                    }
                }
            };
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new h(8, cls);
        }
        String str = "Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (cls.getDeclaredConstructors().length == 0) {
            str = O.a.f(str, " Or adjust your R8 configuration to keep the no-args constructor of the class.");
        }
        return new c(str, 4);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            final int i2 = 0;
            return new ObjectConstructor() { // from class: com.google.gson.internal.b
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    Object createInstance;
                    Object createInstance2;
                    switch (i2) {
                        case 0:
                            createInstance = instanceCreator.createInstance(type);
                            return createInstance;
                        default:
                            createInstance2 = instanceCreator.createInstance(type);
                            return createInstance2;
                    }
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            final int i3 = 1;
            return new ObjectConstructor() { // from class: com.google.gson.internal.b
                @Override // com.google.gson.internal.ObjectConstructor
                public final Object construct() {
                    Object createInstance;
                    Object createInstance2;
                    switch (i3) {
                        case 0:
                            createInstance = instanceCreator2.createInstance(type);
                            return createInstance;
                        default:
                            createInstance2 = instanceCreator2.createInstance(type);
                            return createInstance2;
                    }
                }
            };
        }
        ObjectConstructor<T> newSpecialCollectionConstructor = newSpecialCollectionConstructor(type, rawType);
        if (newSpecialCollectionConstructor != null) {
            return newSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        if (newDefaultImplementationConstructor != null) {
            return newDefaultImplementationConstructor;
        }
        String checkInstantiable = checkInstantiable(rawType);
        if (checkInstantiable != null) {
            return new c(checkInstantiable, 0);
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new c("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.", 1);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
