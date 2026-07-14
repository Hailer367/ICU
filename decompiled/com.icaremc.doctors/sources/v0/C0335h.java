package v0;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.concurrent.Executors;
import y0.C0345a;

/* renamed from: v0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0335h implements Configurator, x0.b {

    /* renamed from: c, reason: collision with root package name */
    public static final C0335h f3906c = new Object();

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig encoderConfig) {
        encoderConfig.registerEncoder(o.class, C0332e.f3899a);
        encoderConfig.registerEncoder(C0345a.class, C0328a.f3886a);
        encoderConfig.registerEncoder(y0.g.class, C0334g.f3903a);
        encoderConfig.registerEncoder(y0.e.class, C0331d.f3896a);
        encoderConfig.registerEncoder(y0.d.class, C0330c.f3893a);
        encoderConfig.registerEncoder(y0.b.class, C0329b.f3891a);
        encoderConfig.registerEncoder(y0.f.class, C0333f.f3900a);
    }

    @Override // P0.a
    public Object get() {
        return new A.f(2, Executors.newSingleThreadExecutor());
    }
}
