package io.flutter.plugins.imagepicker;

import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class MediaSelectionOptions {
    public static final Companion Companion = new Companion(null);
    private final ImageSelectionOptions imageSelectionOptions;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final MediaSelectionOptions fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.ImageSelectionOptions");
            return new MediaSelectionOptions((ImageSelectionOptions) obj);
        }

        private Companion() {
        }
    }

    public MediaSelectionOptions(ImageSelectionOptions imageSelectionOptions) {
        h.e(imageSelectionOptions, "imageSelectionOptions");
        this.imageSelectionOptions = imageSelectionOptions;
    }

    public static /* synthetic */ MediaSelectionOptions copy$default(MediaSelectionOptions mediaSelectionOptions, ImageSelectionOptions imageSelectionOptions, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            imageSelectionOptions = mediaSelectionOptions.imageSelectionOptions;
        }
        return mediaSelectionOptions.copy(imageSelectionOptions);
    }

    public final ImageSelectionOptions component1() {
        return this.imageSelectionOptions;
    }

    public final MediaSelectionOptions copy(ImageSelectionOptions imageSelectionOptions) {
        h.e(imageSelectionOptions, "imageSelectionOptions");
        return new MediaSelectionOptions(imageSelectionOptions);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(MediaSelectionOptions.class)) {
            if (this == obj) {
                return true;
            }
            return MessagesPigeonUtils.INSTANCE.deepEquals(this.imageSelectionOptions, ((MediaSelectionOptions) obj).imageSelectionOptions);
        }
        return false;
    }

    public final ImageSelectionOptions getImageSelectionOptions() {
        return this.imageSelectionOptions;
    }

    public int hashCode() {
        return (MediaSelectionOptions.class.hashCode() * 31) + MessagesPigeonUtils.INSTANCE.deepHash(this.imageSelectionOptions);
    }

    public final List<Object> toList() {
        return android.support.v4.media.session.a.y(this.imageSelectionOptions);
    }

    public String toString() {
        return "MediaSelectionOptions(imageSelectionOptions=" + this.imageSelectionOptions + ")";
    }
}
