package io.flutter.plugins.sharedpreferences;

import a.AbstractC0051a;
import kotlin.jvm.internal.e;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class StringListLookupResultType {
    private static final /* synthetic */ W0.a $ENTRIES;
    private static final /* synthetic */ StringListLookupResultType[] $VALUES;
    public static final Companion Companion;
    private final int raw;
    public static final StringListLookupResultType PLATFORM_ENCODED = new StringListLookupResultType("PLATFORM_ENCODED", 0, 0);
    public static final StringListLookupResultType JSON_ENCODED = new StringListLookupResultType("JSON_ENCODED", 1, 1);
    public static final StringListLookupResultType UNEXPECTED_STRING = new StringListLookupResultType("UNEXPECTED_STRING", 2, 2);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final StringListLookupResultType ofRaw(int i2) {
            for (StringListLookupResultType stringListLookupResultType : StringListLookupResultType.values()) {
                if (stringListLookupResultType.getRaw() == i2) {
                    return stringListLookupResultType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ StringListLookupResultType[] $values() {
        return new StringListLookupResultType[]{PLATFORM_ENCODED, JSON_ENCODED, UNEXPECTED_STRING};
    }

    static {
        StringListLookupResultType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = AbstractC0051a.t($values);
        Companion = new Companion(null);
    }

    private StringListLookupResultType(String str, int i2, int i3) {
        this.raw = i3;
    }

    public static W0.a getEntries() {
        return $ENTRIES;
    }

    public static StringListLookupResultType valueOf(String str) {
        return (StringListLookupResultType) Enum.valueOf(StringListLookupResultType.class, str);
    }

    public static StringListLookupResultType[] values() {
        return (StringListLookupResultType[]) $VALUES.clone();
    }

    public final int getRaw() {
        return this.raw;
    }
}
