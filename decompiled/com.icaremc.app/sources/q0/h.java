package q0;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.IsomorphicObjectBoundaryInterface;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5868a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IsomorphicObjectBoundaryInterface f5869b;

    public /* synthetic */ h(IsomorphicObjectBoundaryInterface isomorphicObjectBoundaryInterface, int i4) {
        this.f5868a = i4;
        this.f5869b = isomorphicObjectBoundaryInterface;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [q0.E, java.lang.Object] */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f5868a) {
            case 0:
                return new i((JsReplyProxyBoundaryInterface) this.f5869b);
            default:
                WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) this.f5869b;
                ?? obj = new Object();
                obj.f5859a = webViewRendererBoundaryInterface;
                return obj;
        }
    }
}
