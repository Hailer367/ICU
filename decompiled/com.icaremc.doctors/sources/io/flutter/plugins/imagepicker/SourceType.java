package io.flutter.plugins.imagepicker;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class SourceType {
    private static final /* synthetic */ W0.a $ENTRIES;
    private static final /* synthetic */ SourceType[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final SourceType CAMERA = new SourceType("CAMERA", 0, 0);
    public static final SourceType GALLERY = new SourceType("GALLERY", 1, 1);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final SourceType ofRaw(int i2) {
            for (SourceType sourceType : SourceType.values()) {
                if (sourceType.getRaw() == i2) {
                    return sourceType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SourceType[] $values() {
        return new SourceType[]{CAMERA, GALLERY};
    }

    static {
        SourceType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = AbstractC0051a.t($values);
        Companion = new Companion(null);
    }

    private SourceType(String str, int i2, int i3) {
        this.raw = i3;
    }

    public static W0.a getEntries() {
        return $ENTRIES;
    }

    public static SourceType valueOf(String str) {
        return (SourceType) Enum.valueOf(SourceType.class, str);
    }

    public static SourceType[] values() {
        return (SourceType[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
