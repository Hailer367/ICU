package androidx.window.layout.adapter.sidecar;

import T2.h;
import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.WeakHashMap;
import y0.AbstractC0730b;
import y0.C0735g;

/* loaded from: classes.dex */
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    /* renamed from: b, reason: collision with root package name */
    public SidecarDeviceState f3194b;

    /* renamed from: d, reason: collision with root package name */
    public final C0735g f3196d;

    /* renamed from: e, reason: collision with root package name */
    public final SidecarInterface.SidecarCallback f3197e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3193a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f3195c = new WeakHashMap();

    public DistinctElementSidecarCallback(C0735g c0735g, SidecarInterface.SidecarCallback sidecarCallback) {
        this.f3196d = c0735g;
        this.f3197e = sidecarCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x001f, code lost:
    
        if (y0.AbstractC0730b.b(r2) == y0.AbstractC0730b.b(r4)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L3
            return
        L3:
            java.lang.Object r0 = r3.f3193a
            monitor-enter(r0)
            y0.g r1 = r3.f3196d     // Catch: java.lang.Throwable -> L23
            androidx.window.sidecar.SidecarDeviceState r2 = r3.f3194b     // Catch: java.lang.Throwable -> L23
            r1.getClass()     // Catch: java.lang.Throwable -> L23
            boolean r1 = T2.h.a(r2, r4)     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L14
            goto L21
        L14:
            if (r2 != 0) goto L17
            goto L25
        L17:
            int r1 = y0.AbstractC0730b.b(r2)     // Catch: java.lang.Throwable -> L23
            int r2 = y0.AbstractC0730b.b(r4)     // Catch: java.lang.Throwable -> L23
            if (r1 != r2) goto L25
        L21:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            return
        L23:
            r4 = move-exception
            goto L2e
        L25:
            r3.f3194b = r4     // Catch: java.lang.Throwable -> L23
            androidx.window.sidecar.SidecarInterface$SidecarCallback r1 = r3.f3197e     // Catch: java.lang.Throwable -> L23
            r1.onDeviceStateChanged(r4)     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            return
        L2e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.adapter.sidecar.DistinctElementSidecarCallback.onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState):void");
    }

    public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        boolean b4;
        synchronized (this.f3193a) {
            try {
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo2 = (SidecarWindowLayoutInfo) this.f3195c.get(iBinder);
                this.f3196d.getClass();
                if (h.a(sidecarWindowLayoutInfo2, sidecarWindowLayoutInfo)) {
                    b4 = true;
                } else {
                    if (sidecarWindowLayoutInfo2 != null && sidecarWindowLayoutInfo != null) {
                        b4 = C0735g.b(AbstractC0730b.c(sidecarWindowLayoutInfo2), AbstractC0730b.c(sidecarWindowLayoutInfo));
                    }
                    b4 = false;
                }
                if (b4) {
                    return;
                }
                this.f3195c.put(iBinder, sidecarWindowLayoutInfo);
                this.f3197e.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } finally {
            }
        }
    }
}
