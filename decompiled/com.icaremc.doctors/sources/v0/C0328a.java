package v0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import y0.C0345a;

/* renamed from: v0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0328a implements ObjectEncoder {

    /* renamed from: a, reason: collision with root package name */
    public static final C0328a f3886a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f3887b = O.a.b(1, FieldDescriptor.builder("window"));

    /* renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f3888c = O.a.b(2, FieldDescriptor.builder("logSourceMetrics"));

    /* renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f3889d = O.a.b(3, FieldDescriptor.builder("globalMetrics"));

    /* renamed from: e, reason: collision with root package name */
    public static final FieldDescriptor f3890e = O.a.b(4, FieldDescriptor.builder("appNamespace"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        C0345a c0345a = (C0345a) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f3887b, c0345a.f3985a);
        objectEncoderContext2.add(f3888c, c0345a.f3986b);
        objectEncoderContext2.add(f3889d, c0345a.f3987c);
        objectEncoderContext2.add(f3890e, c0345a.f3988d);
    }
}
