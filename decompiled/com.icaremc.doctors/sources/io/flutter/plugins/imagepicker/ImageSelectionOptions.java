package io.flutter.plugins.imagepicker;

import R0.k;
import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class ImageSelectionOptions {
    public static final Companion Companion = new Companion(null);
    private final Double maxHeight;
    private final Double maxWidth;
    private final long quality;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final ImageSelectionOptions fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Double d2 = (Double) pigeonVar_list.get(0);
            Double d3 = (Double) pigeonVar_list.get(1);
            Object obj = pigeonVar_list.get(2);
            h.c(obj, "null cannot be cast to non-null type kotlin.Long");
            return new ImageSelectionOptions(d2, d3, ((Long) obj).longValue());
        }

        private Companion() {
        }
    }

    public ImageSelectionOptions(Double d2, Double d3, long j2) {
        this.maxWidth = d2;
        this.maxHeight = d3;
        this.quality = j2;
    }

    public static /* synthetic */ ImageSelectionOptions copy$default(ImageSelectionOptions imageSelectionOptions, Double d2, Double d3, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = imageSelectionOptions.maxWidth;
        }
        if ((i2 & 2) != 0) {
            d3 = imageSelectionOptions.maxHeight;
        }
        if ((i2 & 4) != 0) {
            j2 = imageSelectionOptions.quality;
        }
        return imageSelectionOptions.copy(d2, d3, j2);
    }

    public final Double component1() {
        return this.maxWidth;
    }

    public final Double component2() {
        return this.maxHeight;
    }

    public final long component3() {
        return this.quality;
    }

    public final ImageSelectionOptions copy(Double d2, Double d3, long j2) {
        return new ImageSelectionOptions(d2, d3, j2);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(ImageSelectionOptions.class)) {
            if (this == obj) {
                return true;
            }
            ImageSelectionOptions imageSelectionOptions = (ImageSelectionOptions) obj;
            MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
            if (messagesPigeonUtils.deepEquals(this.maxWidth, imageSelectionOptions.maxWidth) && messagesPigeonUtils.deepEquals(this.maxHeight, imageSelectionOptions.maxHeight) && messagesPigeonUtils.deepEquals(Long.valueOf(this.quality), Long.valueOf(imageSelectionOptions.quality))) {
                return true;
            }
        }
        return false;
    }

    public final Double getMaxHeight() {
        return this.maxHeight;
    }

    public final Double getMaxWidth() {
        return this.maxWidth;
    }

    public final long getQuality() {
        return this.quality;
    }

    public int hashCode() {
        int hashCode = ImageSelectionOptions.class.hashCode() * 31;
        MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
        return ((((hashCode + messagesPigeonUtils.deepHash(this.maxWidth)) * 31) + messagesPigeonUtils.deepHash(this.maxHeight)) * 31) + messagesPigeonUtils.deepHash(Long.valueOf(this.quality));
    }

    public final List<Object> toList() {
        return k.N(this.maxWidth, this.maxHeight, Long.valueOf(this.quality));
    }

    public String toString() {
        return "ImageSelectionOptions(maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ", quality=" + this.quality + ")";
    }

    public /* synthetic */ ImageSelectionOptions(Double d2, Double d3, long j2, int i2, kotlin.jvm.internal.e eVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : d3, j2);
    }
}
