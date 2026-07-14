package io.flutter.plugins.imagepicker;

import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class VideoSelectionOptions {
    public static final Companion Companion = new Companion(null);
    private final Long maxDurationSeconds;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final VideoSelectionOptions fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            return new VideoSelectionOptions((Long) pigeonVar_list.get(0));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoSelectionOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VideoSelectionOptions copy$default(VideoSelectionOptions videoSelectionOptions, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l2 = videoSelectionOptions.maxDurationSeconds;
        }
        return videoSelectionOptions.copy(l2);
    }

    public final Long component1() {
        return this.maxDurationSeconds;
    }

    public final VideoSelectionOptions copy(Long l2) {
        return new VideoSelectionOptions(l2);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(VideoSelectionOptions.class)) {
            if (this == obj) {
                return true;
            }
            return MessagesPigeonUtils.INSTANCE.deepEquals(this.maxDurationSeconds, ((VideoSelectionOptions) obj).maxDurationSeconds);
        }
        return false;
    }

    public final Long getMaxDurationSeconds() {
        return this.maxDurationSeconds;
    }

    public int hashCode() {
        return (VideoSelectionOptions.class.hashCode() * 31) + MessagesPigeonUtils.INSTANCE.deepHash(this.maxDurationSeconds);
    }

    public final List<Object> toList() {
        return android.support.v4.media.session.a.y(this.maxDurationSeconds);
    }

    public String toString() {
        return "VideoSelectionOptions(maxDurationSeconds=" + this.maxDurationSeconds + ")";
    }

    public VideoSelectionOptions(Long l2) {
        this.maxDurationSeconds = l2;
    }

    public /* synthetic */ VideoSelectionOptions(Long l2, int i2, kotlin.jvm.internal.e eVar) {
        this((i2 & 1) != 0 ? null : l2);
    }
}
