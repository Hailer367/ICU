package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class F {

    /* renamed from: b, reason: collision with root package name */
    public static final C0092t f1342b = new C0092t(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f1343a;

    public F(C0086m c0086m) {
        AbstractC0097y.a(c0086m, "output");
        this.f1343a = c0086m;
        c0086m.f1454f = this;
    }

    public void a(int i2, Object obj, W w2) {
        C0086m c0086m = (C0086m) this.f1343a;
        c0086m.n0(i2, 3);
        w2.b((AbstractC0074a) obj, c0086m.f1454f);
        c0086m.n0(i2, 4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.datastore.preferences.protobuf.E] */
    public F() {
        L l2;
        T t2 = T.f1374c;
        try {
            l2 = (L) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            l2 = f1342b;
        }
        L[] lArr = {C0092t.f1490b, l2};
        ?? obj = new Object();
        obj.f1341a = lArr;
        Charset charset = AbstractC0097y.f1494a;
        this.f1343a = obj;
    }
}
