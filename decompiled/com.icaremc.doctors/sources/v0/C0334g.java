package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: v0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0334g implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0334g f3903a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3904b = O.a.b(1, FieldDescriptor.builder("startMs"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3905c = O.a.b(2, FieldDescriptor.builder("endMs"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        y0.g gVar = (y0.g) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f3904b, gVar.f4006a);
        objectEncoderContext2.add(f3905c, gVar.f4007b);
    }
}
