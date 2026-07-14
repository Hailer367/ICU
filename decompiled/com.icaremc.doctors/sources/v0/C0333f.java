package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: v0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0333f implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0333f f3900a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3901b = O.a.b(1, FieldDescriptor.builder("currentCacheSizeBytes"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3902c = O.a.b(2, FieldDescriptor.builder("maxCacheSizeBytes"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        y0.f fVar = (y0.f) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f3901b, fVar.f4004a);
        objectEncoderContext2.add(f3902c, fVar.f4005b);
    }
}
