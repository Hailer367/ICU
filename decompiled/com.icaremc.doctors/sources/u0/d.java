package u0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class d implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3823a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3824b = FieldDescriptor.of("clientType");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3825c = FieldDescriptor.of("androidClientInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        k kVar = (k) ((r) obj);
        kVar.getClass();
        objectEncoderContext2.add(f3824b, q.f3876c);
        objectEncoderContext2.add(f3825c, kVar.f3859a);
    }
}
