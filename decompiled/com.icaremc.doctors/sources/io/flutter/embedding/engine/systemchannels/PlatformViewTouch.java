package io.flutter.embedding.engine.systemchannels;

/* loaded from: classes.dex */
public class PlatformViewTouch {
    public final int action;
    public final int buttonState;
    public final int deviceId;
    public final Number downTime;
    public final int edgeFlags;
    public final Number eventTime;
    public final int flags;
    public final int metaState;
    public final long motionEventId;
    public final int pointerCount;
    public final Object rawPointerCoords;
    public final Object rawPointerPropertiesList;
    public final int source;
    public final int viewId;
    public final float xPrecision;
    public final float yPrecision;

    public PlatformViewTouch(int i2, Number number, Number number2, int i3, int i4, Object obj, Object obj2, int i5, int i6, float f2, float f3, int i7, int i8, int i9, int i10, long j2) {
        this.viewId = i2;
        this.downTime = number;
        this.eventTime = number2;
        this.action = i3;
        this.pointerCount = i4;
        this.rawPointerPropertiesList = obj;
        this.rawPointerCoords = obj2;
        this.metaState = i5;
        this.buttonState = i6;
        this.xPrecision = f2;
        this.yPrecision = f3;
        this.deviceId = i7;
        this.edgeFlags = i8;
        this.source = i9;
        this.flags = i10;
        this.motionEventId = j2;
    }
}
