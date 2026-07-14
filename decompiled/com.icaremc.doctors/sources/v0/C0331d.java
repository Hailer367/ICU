package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: v0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0331d implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0331d f3896a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3897b = O.a.b(1, FieldDescriptor.builder("logSource"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3898c = O.a.b(2, FieldDescriptor.builder("logEventDropped"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        y0.e eVar = (y0.e) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f3897b, eVar.f4002a);
        objectEncoderContext2.add(f3898c, eVar.f4003b);
    }
}
