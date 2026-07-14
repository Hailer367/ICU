package u0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class g implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3842a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3843b = FieldDescriptor.of("networkType");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3844c = FieldDescriptor.of("mobileSubtype");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        o oVar = (o) ((w) obj);
        objectEncoderContext2.add(f3843b, oVar.f3874a);
        objectEncoderContext2.add(f3844c, oVar.f3875b);
    }
}
