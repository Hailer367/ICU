package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: v0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0330c implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0330c f3893a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3894b = O.a.b(1, FieldDescriptor.builder("eventsDroppedCount"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3895c = O.a.b(3, FieldDescriptor.builder("reason"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        y0.d dVar = (y0.d) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f3894b, dVar.f3999a);
        objectEncoderContext2.add(f3895c, dVar.f4000b);
    }
}
