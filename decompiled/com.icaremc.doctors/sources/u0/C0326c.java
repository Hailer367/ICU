package u0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: u0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0326c implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0326c f3821a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3822b = FieldDescriptor.of("logRequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f3822b, ((j) ((p) obj)).f3858a);
    }
}
