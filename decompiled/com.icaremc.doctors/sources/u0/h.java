package u0;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* loaded from: classes.dex */
public final class h implements Configurator {

    /* renamed from: c, reason: collision with root package name */
    public static final h f3845c = new Object();

    @Override // com.google.firebase.encoders.config.Configurator
    public final void configure(EncoderConfig encoderConfig) {
        C0326c c0326c = C0326c.f3821a;
        encoderConfig.registerEncoder(p.class, c0326c);
        encoderConfig.registerEncoder(j.class, c0326c);
        f fVar = f.f3834a;
        encoderConfig.registerEncoder(t.class, fVar);
        encoderConfig.registerEncoder(m.class, fVar);
        d dVar = d.f3823a;
        encoderConfig.registerEncoder(r.class, dVar);
        encoderConfig.registerEncoder(k.class, dVar);
        C0325b c0325b = C0325b.f3808a;
        encoderConfig.registerEncoder(AbstractC0324a.class, c0325b);
        encoderConfig.registerEncoder(i.class, c0325b);
        e eVar = e.f3826a;
        encoderConfig.registerEncoder(s.class, eVar);
        encoderConfig.registerEncoder(l.class, eVar);
        g gVar = g.f3842a;
        encoderConfig.registerEncoder(w.class, gVar);
        encoderConfig.registerEncoder(o.class, gVar);
    }
}
