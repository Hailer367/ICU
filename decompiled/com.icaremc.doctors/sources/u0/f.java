package u0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class f implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3834a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3835b = FieldDescriptor.of("requestTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3836c = FieldDescriptor.of("requestUptimeMs");

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f3837d = FieldDescriptor.of("clientInfo");

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f3838e = FieldDescriptor.of("logSource");

    /* renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f3839f = FieldDescriptor.of("logSourceName");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f3840g = FieldDescriptor.of("logEvent");

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f3841h = FieldDescriptor.of("qosTier");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        m mVar = (m) ((t) obj);
        objectEncoderContext2.add(f3835b, mVar.f3867a);
        objectEncoderContext2.add(f3836c, mVar.f3868b);
        objectEncoderContext2.add(f3837d, mVar.f3869c);
        objectEncoderContext2.add(f3838e, mVar.f3870d);
        objectEncoderContext2.add(f3839f, mVar.f3871e);
        objectEncoderContext2.add(f3840g, mVar.f3872f);
        objectEncoderContext2.add(f3841h, x.f3882c);
    }
}
