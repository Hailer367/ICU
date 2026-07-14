package u0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* loaded from: classes.dex */
public final class e implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final e f3826a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3827b = FieldDescriptor.of("eventTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3828c = FieldDescriptor.of("eventCode");

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f3829d = FieldDescriptor.of("eventUptimeMs");

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f3830e = FieldDescriptor.of("sourceExtension");

    /* renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f3831f = FieldDescriptor.of("sourceExtensionJsonProto3");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f3832g = FieldDescriptor.of("timezoneOffsetSeconds");

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f3833h = FieldDescriptor.of("networkConnectionInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        l lVar = (l) ((s) obj);
        objectEncoderContext2.add(f3827b, lVar.f3860a);
        objectEncoderContext2.add(f3828c, lVar.f3861b);
        objectEncoderContext2.add(f3829d, lVar.f3862c);
        objectEncoderContext2.add(f3830e, lVar.f3863d);
        objectEncoderContext2.add(f3831f, lVar.f3864e);
        objectEncoderContext2.add(f3832g, lVar.f3865f);
        objectEncoderContext2.add(f3833h, lVar.f3866g);
    }
}
