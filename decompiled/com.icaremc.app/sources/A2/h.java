package A2;

import D2.C0022a;
import android.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements S2.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f77f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ io.flutter.plugin.platform.s f78g;

    public /* synthetic */ h(io.flutter.plugin.platform.s sVar, int i4) {
        this.f77f = i4;
        this.f78g = sVar;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        List C3;
        List C4;
        List C5;
        List C6;
        List C7;
        H2.f fVar = (H2.f) obj;
        switch (this.f77f) {
            case 0:
                Throwable a4 = H2.f.a(fVar.f676f);
                Object obj2 = null;
                io.flutter.plugin.platform.s sVar = this.f78g;
                if (a4 != null) {
                    if (a4 instanceof C0005d) {
                        C0005d c0005d = (C0005d) a4;
                        C3 = I2.f.C(c0005d.f69f, c0005d.f70g, null);
                    } else {
                        C3 = I2.f.C(a4.getClass().getSimpleName(), a4.toString(), i.i("Cause: ", a4.getCause(), ", Stacktrace: ", Log.getStackTraceString(a4)));
                    }
                    sVar.t(C3);
                } else {
                    Object obj3 = fVar.f676f;
                    if (!(obj3 instanceof H2.e)) {
                        obj2 = obj3;
                    }
                    sVar.t(android.support.v4.media.session.a.p((List) obj2));
                }
                return H2.i.f681a;
            case 1:
                Throwable a5 = H2.f.a(fVar.f676f);
                Object obj4 = null;
                io.flutter.plugin.platform.s sVar2 = this.f78g;
                if (a5 != null) {
                    if (a5 instanceof C0005d) {
                        C0005d c0005d2 = (C0005d) a5;
                        C4 = I2.f.C(c0005d2.f69f, c0005d2.f70g, null);
                    } else {
                        C4 = I2.f.C(a5.getClass().getSimpleName(), a5.toString(), i.i("Cause: ", a5.getCause(), ", Stacktrace: ", Log.getStackTraceString(a5)));
                    }
                    sVar2.t(C4);
                } else {
                    Object obj5 = fVar.f676f;
                    if (!(obj5 instanceof H2.e)) {
                        obj4 = obj5;
                    }
                    sVar2.t(android.support.v4.media.session.a.p((List) obj4));
                }
                return H2.i.f681a;
            case 2:
                Throwable a6 = H2.f.a(fVar.f676f);
                Object obj6 = null;
                io.flutter.plugin.platform.s sVar3 = this.f78g;
                if (a6 != null) {
                    if (a6 instanceof C0005d) {
                        C0005d c0005d3 = (C0005d) a6;
                        C5 = I2.f.C(c0005d3.f69f, c0005d3.f70g, null);
                    } else {
                        C5 = I2.f.C(a6.getClass().getSimpleName(), a6.toString(), i.i("Cause: ", a6.getCause(), ", Stacktrace: ", Log.getStackTraceString(a6)));
                    }
                    sVar3.t(C5);
                } else {
                    Object obj7 = fVar.f676f;
                    if (!(obj7 instanceof H2.e)) {
                        obj6 = obj7;
                    }
                    sVar3.t(android.support.v4.media.session.a.p((List) obj6));
                }
                return H2.i.f681a;
            case 3:
                Throwable a7 = H2.f.a(fVar.f676f);
                io.flutter.plugin.platform.s sVar4 = this.f78g;
                if (a7 != null) {
                    if (a7 instanceof C0022a) {
                        C0022a c0022a = (C0022a) a7;
                        C6 = I2.f.C(c0022a.f349f, c0022a.f350g, c0022a.f351h);
                    } else {
                        C6 = I2.f.C(a7.getClass().getSimpleName(), a7.toString(), i.i("Cause: ", a7.getCause(), ", Stacktrace: ", Log.getStackTraceString(a7)));
                    }
                    sVar4.t(C6);
                } else {
                    Object obj8 = fVar.f676f;
                    if (obj8 instanceof H2.e) {
                        obj8 = null;
                    }
                    sVar4.t(android.support.v4.media.session.a.p((Boolean) obj8));
                }
                return H2.i.f681a;
            default:
                Throwable a8 = H2.f.a(fVar.f676f);
                io.flutter.plugin.platform.s sVar5 = this.f78g;
                if (a8 != null) {
                    if (a8 instanceof C0022a) {
                        C0022a c0022a2 = (C0022a) a8;
                        C7 = I2.f.C(c0022a2.f349f, c0022a2.f350g, c0022a2.f351h);
                    } else {
                        C7 = I2.f.C(a8.getClass().getSimpleName(), a8.toString(), i.i("Cause: ", a8.getCause(), ", Stacktrace: ", Log.getStackTraceString(a8)));
                    }
                    sVar5.t(C7);
                } else {
                    Object obj9 = fVar.f676f;
                    if (obj9 instanceof H2.e) {
                        obj9 = null;
                    }
                    sVar5.t(android.support.v4.media.session.a.p((String) obj9));
                }
                return H2.i.f681a;
        }
    }
}
