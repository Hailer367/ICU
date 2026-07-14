package p0;

import android.webkit.TracingController;
import q0.C0597b;
import q0.z;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final q0.o f5805a;

    /* JADX WARN: Type inference failed for: r0v0, types: [q0.o, java.lang.Object] */
    static {
        TracingController tracingController;
        ?? obj = new Object();
        C0597b c0597b = q0.x.f5926u;
        if (c0597b.a()) {
            tracingController = TracingController.getInstance();
            obj.f5882a = tracingController;
            obj.f5883b = null;
        } else if (c0597b.b()) {
            obj.f5882a = null;
            obj.f5883b = z.f5932a.getTracingController();
        } else {
            throw q0.x.a();
        }
        f5805a = obj;
    }
}
