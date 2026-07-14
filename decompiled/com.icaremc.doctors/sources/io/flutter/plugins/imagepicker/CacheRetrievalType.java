package io.flutter.plugins.imagepicker;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CacheRetrievalType {
    private static final /* synthetic */ W0.a $ENTRIES;
    private static final /* synthetic */ CacheRetrievalType[] $VALUES;
    public static final Companion Companion;
    public static final CacheRetrievalType IMAGE = new CacheRetrievalType("IMAGE", 0, 0);
    public static final CacheRetrievalType VIDEO = new CacheRetrievalType("VIDEO", 1, 1);
    private final int raw;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final CacheRetrievalType ofRaw(int i2) {
            for (CacheRetrievalType cacheRetrievalType : CacheRetrievalType.values()) {
                if (cacheRetrievalType.getRaw() == i2) {
                    return cacheRetrievalType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ CacheRetrievalType[] $values() {
        return new CacheRetrievalType[]{IMAGE, VIDEO};
    }

    static {
        CacheRetrievalType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = AbstractC0051a.t($values);
        Companion = new Companion(null);
    }

    private CacheRetrievalType(String str, int i2, int i3) {
        this.raw = i3;
    }

    public static W0.a getEntries() {
        return $ENTRIES;
    }

    public static CacheRetrievalType valueOf(String str) {
        return (CacheRetrievalType) Enum.valueOf(CacheRetrievalType.class, str);
    }

    public static CacheRetrievalType[] values() {
        return (CacheRetrievalType[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
