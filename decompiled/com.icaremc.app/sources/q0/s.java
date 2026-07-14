package q0;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* loaded from: classes.dex */
public final class s extends p0.o {

    /* renamed from: a, reason: collision with root package name */
    public WebMessagePort f5890a;

    /* renamed from: b, reason: collision with root package name */
    public WebMessagePortBoundaryInterface f5891b;

    public s(WebMessagePort webMessagePort) {
        this.f5890a = webMessagePort;
    }

    public static WebMessage b(p0.n nVar) {
        WebMessagePort[] webMessagePortArr;
        nVar.a(0);
        String str = nVar.f5807b;
        p0.o[] oVarArr = nVar.f5806a;
        if (oVarArr == null) {
            webMessagePortArr = null;
        } else {
            int length = oVarArr.length;
            WebMessagePort[] webMessagePortArr2 = new WebMessagePort[length];
            for (int i4 = 0; i4 < length; i4++) {
                webMessagePortArr2[i4] = ((s) oVarArr[i4]).d();
            }
            webMessagePortArr = webMessagePortArr2;
        }
        return new WebMessage(str, webMessagePortArr);
    }

    @Override // p0.o
    public final void a(p0.n nVar) {
        C0597b c0597b = x.f5921p;
        int i4 = nVar.f5809d;
        if (i4 == 0) {
            d().postMessage(b(nVar));
        } else {
            if (c0597b.b() && (i4 == 0 || (i4 == 1 && x.f5922q.b()))) {
                c().postMessage(new k3.a(new p(nVar)));
                return;
            }
            throw x.a();
        }
    }

    public final WebMessagePortBoundaryInterface c() {
        if (this.f5891b == null) {
            C0595C c0595c = y.f5931a;
            this.f5891b = (WebMessagePortBoundaryInterface) k3.b.b(WebMessagePortBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertWebMessagePort(this.f5890a));
        }
        return this.f5891b;
    }

    public final WebMessagePort d() {
        if (this.f5890a == null) {
            C0595C c0595c = y.f5931a;
            this.f5890a = (WebMessagePort) ((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertWebMessagePort(Proxy.getInvocationHandler(this.f5891b));
        }
        return this.f5890a;
    }

    public s(InvocationHandler invocationHandler) {
        this.f5891b = (WebMessagePortBoundaryInterface) k3.b.b(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
