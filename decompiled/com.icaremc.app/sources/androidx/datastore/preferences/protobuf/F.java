package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: b, reason: collision with root package name */
    public static final C0162t f2562b = new C0162t(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f2563a;

    public F(C0156m c0156m) {
        AbstractC0167y.a(c0156m, "output");
        this.f2563a = c0156m;
        c0156m.f2671d = this;
    }

    public void a(int i4, Object obj, W w2) {
        C0156m c0156m = (C0156m) this.f2563a;
        c0156m.q0(i4, 3);
        w2.b((AbstractC0144a) obj, c0156m.f2671d);
        c0156m.q0(i4, 4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.datastore.preferences.protobuf.E] */
    public F() {
        L l3;
        T t3 = T.f2593c;
        try {
            l3 = (L) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            l3 = f2562b;
        }
        L[] lArr = {C0162t.f2705b, l3};
        ?? obj = new Object();
        obj.f2561a = lArr;
        Charset charset = AbstractC0167y.f2709a;
        this.f2563a = obj;
    }
}
