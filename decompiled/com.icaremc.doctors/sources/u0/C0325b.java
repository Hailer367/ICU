package u0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0325b implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0325b f3808a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3809b = FieldDescriptor.of("sdkVersion");

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3810c = FieldDescriptor.of("model");

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f3811d = FieldDescriptor.of("hardware");

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f3812e = FieldDescriptor.of("device");

    /* renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f3813f = FieldDescriptor.of("product");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f3814g = FieldDescriptor.of("osBuild");

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f3815h = FieldDescriptor.of("manufacturer");

    /* renamed from: i, reason: collision with root package name */
    public static final FieldDescriptor f3816i = FieldDescriptor.of("fingerprint");

    /* renamed from: j, reason: collision with root package name */
    public static final FieldDescriptor f3817j = FieldDescriptor.of("locale");

    /* renamed from: k, reason: collision with root package name */
    public static final FieldDescriptor f3818k = FieldDescriptor.of("country");

    /* renamed from: l, reason: collision with root package name */
    public static final FieldDescriptor f3819l = FieldDescriptor.of("mccMnc");

    /* renamed from: m, reason: collision with root package name */
    public static final FieldDescriptor f3820m = FieldDescriptor.of("applicationBuild");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        i iVar = (i) ((AbstractC0324a) obj);
        objectEncoderContext2.add(f3809b, iVar.f3846a);
        objectEncoderContext2.add(f3810c, iVar.f3847b);
        objectEncoderContext2.add(f3811d, iVar.f3848c);
        objectEncoderContext2.add(f3812e, iVar.f3849d);
        objectEncoderContext2.add(f3813f, iVar.f3850e);
        objectEncoderContext2.add(f3814g, iVar.f3851f);
        objectEncoderContext2.add(f3815h, iVar.f3852g);
        objectEncoderContext2.add(f3816i, iVar.f3853h);
        objectEncoderContext2.add(f3817j, iVar.f3854i);
        objectEncoderContext2.add(f3818k, iVar.f3855j);
        objectEncoderContext2.add(f3819l, iVar.f3856k);
        objectEncoderContext2.add(f3820m, iVar.f3857l);
    }
}
