package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2045a;

    public /* synthetic */ a(int i2) {
        this.f2045a = i2;
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        switch (this.f2045a) {
            case 0:
                ProtobufDataEncoderContext.a((Map.Entry) obj, objectEncoderContext);
                return;
            default:
                ProtobufEncoder.Builder.a(obj, objectEncoderContext);
                return;
        }
    }
}
