package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: v0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0332e implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0332e f3899a = new Object();

    /* JADX WARN: Type inference failed for: r0v0, types: [v0.e, java.lang.Object] */
    static {
        FieldDescriptor.of("clientMetrics");
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        if (obj == null) {
            throw null;
        }
        throw new ClassCastException();
    }
}
