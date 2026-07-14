package io.flutter.plugins.imagepicker;

import R0.k;
import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class SourceSpecification {
    public static final Companion Companion = new Companion(null);
    private final SourceCamera camera;
    private final SourceType type;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final SourceSpecification fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.SourceType");
            return new SourceSpecification((SourceType) obj, (SourceCamera) pigeonVar_list.get(1));
        }

        private Companion() {
        }
    }

    public SourceSpecification(SourceType type, SourceCamera sourceCamera) {
        h.e(type, "type");
        this.type = type;
        this.camera = sourceCamera;
    }

    public static /* synthetic */ SourceSpecification copy$default(SourceSpecification sourceSpecification, SourceType sourceType, SourceCamera sourceCamera, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sourceType = sourceSpecification.type;
        }
        if ((i2 & 2) != 0) {
            sourceCamera = sourceSpecification.camera;
        }
        return sourceSpecification.copy(sourceType, sourceCamera);
    }

    public final SourceType component1() {
        return this.type;
    }

    public final SourceCamera component2() {
        return this.camera;
    }

    public final SourceSpecification copy(SourceType type, SourceCamera sourceCamera) {
        h.e(type, "type");
        return new SourceSpecification(type, sourceCamera);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(SourceSpecification.class)) {
            if (this == obj) {
                return true;
            }
            SourceSpecification sourceSpecification = (SourceSpecification) obj;
            MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
            if (messagesPigeonUtils.deepEquals(this.type, sourceSpecification.type) && messagesPigeonUtils.deepEquals(this.camera, sourceSpecification.camera)) {
                return true;
            }
        }
        return false;
    }

    public final SourceCamera getCamera() {
        return this.camera;
    }

    public final SourceType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = SourceSpecification.class.hashCode() * 31;
        MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
        return ((hashCode + messagesPigeonUtils.deepHash(this.type)) * 31) + messagesPigeonUtils.deepHash(this.camera);
    }

    public final List<Object> toList() {
        return k.N(this.type, this.camera);
    }

    public String toString() {
        return "SourceSpecification(type=" + this.type + ", camera=" + this.camera + ")";
    }

    public /* synthetic */ SourceSpecification(SourceType sourceType, SourceCamera sourceCamera, int i2, kotlin.jvm.internal.e eVar) {
        this(sourceType, (i2 & 2) != 0 ? null : sourceCamera);
    }
}
