package io.flutter.plugins.imagepicker;

import R0.k;
import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class GeneralOptions {
    public static final Companion Companion = new Companion(null);
    private final boolean allowMultiple;
    private final Long limit;
    private final boolean usePhotoPicker;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final GeneralOptions fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = pigeonVar_list.get(1);
            h.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            return new GeneralOptions(booleanValue, ((Boolean) obj2).booleanValue(), (Long) pigeonVar_list.get(2));
        }

        private Companion() {
        }
    }

    public GeneralOptions(boolean z, boolean z2, Long l2) {
        this.allowMultiple = z;
        this.usePhotoPicker = z2;
        this.limit = l2;
    }

    public static /* synthetic */ GeneralOptions copy$default(GeneralOptions generalOptions, boolean z, boolean z2, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = generalOptions.allowMultiple;
        }
        if ((i2 & 2) != 0) {
            z2 = generalOptions.usePhotoPicker;
        }
        if ((i2 & 4) != 0) {
            l2 = generalOptions.limit;
        }
        return generalOptions.copy(z, z2, l2);
    }

    public final boolean component1() {
        return this.allowMultiple;
    }

    public final boolean component2() {
        return this.usePhotoPicker;
    }

    public final Long component3() {
        return this.limit;
    }

    public final GeneralOptions copy(boolean z, boolean z2, Long l2) {
        return new GeneralOptions(z, z2, l2);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(GeneralOptions.class)) {
            if (this == obj) {
                return true;
            }
            GeneralOptions generalOptions = (GeneralOptions) obj;
            MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
            if (messagesPigeonUtils.deepEquals(Boolean.valueOf(this.allowMultiple), Boolean.valueOf(generalOptions.allowMultiple)) && messagesPigeonUtils.deepEquals(Boolean.valueOf(this.usePhotoPicker), Boolean.valueOf(generalOptions.usePhotoPicker)) && messagesPigeonUtils.deepEquals(this.limit, generalOptions.limit)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getAllowMultiple() {
        return this.allowMultiple;
    }

    public final Long getLimit() {
        return this.limit;
    }

    public final boolean getUsePhotoPicker() {
        return this.usePhotoPicker;
    }

    public int hashCode() {
        int hashCode = GeneralOptions.class.hashCode() * 31;
        MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
        return ((((hashCode + messagesPigeonUtils.deepHash(Boolean.valueOf(this.allowMultiple))) * 31) + messagesPigeonUtils.deepHash(Boolean.valueOf(this.usePhotoPicker))) * 31) + messagesPigeonUtils.deepHash(this.limit);
    }

    public final List<Object> toList() {
        return k.N(Boolean.valueOf(this.allowMultiple), Boolean.valueOf(this.usePhotoPicker), this.limit);
    }

    public String toString() {
        return "GeneralOptions(allowMultiple=" + this.allowMultiple + ", usePhotoPicker=" + this.usePhotoPicker + ", limit=" + this.limit + ")";
    }

    public /* synthetic */ GeneralOptions(boolean z, boolean z2, Long l2, int i2, kotlin.jvm.internal.e eVar) {
        this(z, z2, (i2 & 4) != 0 ? null : l2);
    }
}
