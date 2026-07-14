package q0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* loaded from: classes.dex */
public final class p implements WebMessageBoundaryInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f5884b = {"WEB_MESSAGE_ARRAY_BUFFER"};

    /* renamed from: a, reason: collision with root package name */
    public final p0.n f5885a;

    public p(p0.n nVar) {
        this.f5885a = nVar;
    }

    public static p0.n a(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        InvocationHandler[] ports = webMessageBoundaryInterface.getPorts();
        p0.o[] oVarArr = new p0.o[ports.length];
        for (int i4 = 0; i4 < ports.length; i4++) {
            oVarArr[i4] = new s(ports[i4]);
        }
        if (x.f5922q.b()) {
            WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) k3.b.b(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
            int type = webMessagePayloadBoundaryInterface.getType();
            if (type != 0) {
                if (type != 1) {
                    return null;
                }
                return new p0.n(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), oVarArr);
            }
            return new p0.n(webMessagePayloadBoundaryInterface.getAsString(), oVarArr);
        }
        return new p0.n(webMessageBoundaryInterface.getData(), oVarArr);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final String getData() {
        p0.n nVar = this.f5885a;
        nVar.a(0);
        return nVar.f5807b;
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final InvocationHandler getMessagePayload() {
        q qVar;
        p0.n nVar = this.f5885a;
        int i4 = nVar.f5809d;
        if (i4 != 0) {
            if (i4 == 1) {
                nVar.a(1);
                byte[] bArr = nVar.f5808c;
                Objects.requireNonNull(bArr);
                qVar = new q(bArr);
            } else {
                throw new IllegalStateException("Unknown web message payload type: " + i4);
            }
        } else {
            nVar.a(0);
            qVar = new q(nVar.f5807b);
        }
        return new k3.a(qVar);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public final InvocationHandler[] getPorts() {
        p0.o[] oVarArr = this.f5885a.f5806a;
        if (oVarArr == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[oVarArr.length];
        for (int i4 = 0; i4 < oVarArr.length; i4++) {
            invocationHandlerArr[i4] = Proxy.getInvocationHandler(((s) oVarArr[i4]).c());
        }
        return invocationHandlerArr;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return f5884b;
    }
}
