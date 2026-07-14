package x2;

import com.google.firebase.messaging.FirebaseMessaging;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.Map;
import p1.C0580i;
import q1.AbstractC0602b;

/* renamed from: x2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0724c implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f6501f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u1.f f6502g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0580i f6503h;

    public /* synthetic */ RunnableC0724c(u1.f fVar, C0580i c0580i, int i4) {
        this.f6501f = i4;
        this.f6502g = fVar;
        this.f6503h = c0580i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [x2.g, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        switch (this.f6501f) {
            case 0:
                u1.f fVar = this.f6502g;
                C0580i c0580i = this.f6503h;
                HashMap hashMap = d.f6504h;
                try {
                    fVar.a();
                    String str = fVar.f6222b;
                    fVar.a();
                    f c4 = d.c(fVar.f6223c);
                    fVar.a();
                    O1.a aVar = (O1.a) fVar.f6227g.get();
                    synchronized (aVar) {
                        z = aVar.f1313d;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    Map map = (Map) AbstractC0602b.c(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(fVar));
                    ?? obj = new Object();
                    if (str != null) {
                        obj.f6522a = str;
                        obj.f6523b = c4;
                        obj.f6524c = valueOf;
                        if (map != null) {
                            obj.f6525d = map;
                            c0580i.b(obj);
                            return;
                        }
                        throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
                    }
                    throw new IllegalStateException("Nonnull field \"name\" is null.");
                } catch (Exception e4) {
                    c0580i.a(e4);
                    return;
                }
            case 1:
                FlutterFirebasePluginRegistry.lambda$getPluginConstantsForFirebaseApp$0(this.f6502g, this.f6503h);
                return;
            default:
                u1.f fVar2 = this.f6502g;
                C0580i c0580i2 = this.f6503h;
                try {
                    HashMap hashMap2 = new HashMap();
                    fVar2.a();
                    if (fVar2.f6222b.equals("[DEFAULT]")) {
                        hashMap2.put("AUTO_INIT_ENABLED", Boolean.valueOf(FirebaseMessaging.c().f3413e.b()));
                    }
                    c0580i2.b(hashMap2);
                    return;
                } catch (Exception e5) {
                    c0580i2.a(e5);
                    return;
                }
        }
    }

    public /* synthetic */ RunnableC0724c(d dVar, u1.f fVar, C0580i c0580i) {
        this.f6501f = 0;
        this.f6502g = fVar;
        this.f6503h = c0580i;
    }
}
