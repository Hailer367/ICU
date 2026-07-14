package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: v0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0329b implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0329b f3891a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3892b = O.a.b(1, FieldDescriptor.builder("storageMetrics"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f3892b, ((y0.b) obj).f3989a);
    }
}
