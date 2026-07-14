package io.flutter.plugins.imagepicker;

import a.AbstractC0051a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class SourceCamera {
    private static final /* synthetic */ W0.a $ENTRIES;
    private static final /* synthetic */ SourceCamera[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final SourceCamera REAR = new SourceCamera("REAR", 0, 0);
    public static final SourceCamera FRONT = new SourceCamera("FRONT", 1, 1);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final SourceCamera ofRaw(int i2) {
            for (SourceCamera sourceCamera : SourceCamera.values()) {
                if (sourceCamera.getRaw() == i2) {
                    return sourceCamera;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SourceCamera[] $values() {
        return new SourceCamera[]{REAR, FRONT};
    }

    static {
        SourceCamera[] $values = $values();
        $VALUES = $values;
        $ENTRIES = AbstractC0051a.t($values);
        Companion = new Companion(null);
    }

    private SourceCamera(String str, int i2, int i3) {
        this.raw = i3;
    }

    public static W0.a getEntries() {
        return $ENTRIES;
    }

    public static SourceCamera valueOf(String str) {
        return (SourceCamera) Enum.valueOf(SourceCamera.class, str);
    }

    public static SourceCamera[] values() {
        return (SourceCamera[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
