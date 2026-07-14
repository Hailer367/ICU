package q0;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import p0.AbstractC0565d;

/* loaded from: classes.dex */
public final class r extends WebMessagePort.WebMessageCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0565d f5889a;

    public r(AbstractC0565d abstractC0565d) {
        this.f5889a = abstractC0565d;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        p0.o[] oVarArr;
        s sVar = new s(webMessagePort);
        String data = webMessage.getData();
        WebMessagePort[] ports = webMessage.getPorts();
        if (ports == null) {
            oVarArr = null;
        } else {
            p0.o[] oVarArr2 = new p0.o[ports.length];
            for (int i4 = 0; i4 < ports.length; i4++) {
                oVarArr2[i4] = new s(ports[i4]);
            }
            oVarArr = oVarArr2;
        }
        this.f5889a.onMessage(sVar, new p0.n(data, oVarArr));
    }
}
