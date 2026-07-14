package K0;

import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements InstallStateUpdatedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f578a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f579b;

    public /* synthetic */ d(h hVar, int i2) {
        this.f578a = i2;
        this.f579b = hVar;
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(InstallState installState) {
        InstallState installState2 = installState;
        switch (this.f578a) {
            case 0:
                kotlin.jvm.internal.h.e(installState2, "installState");
                int installStatus = installState2.installStatus();
                EventChannel.EventSink eventSink = this.f579b.f588f;
                if (eventSink != null) {
                    eventSink.success(Integer.valueOf(installStatus));
                    return;
                }
                return;
            default:
                kotlin.jvm.internal.h.e(installState2, "state");
                int installStatus2 = installState2.installStatus();
                h hVar = this.f579b;
                EventChannel.EventSink eventSink2 = hVar.f588f;
                if (eventSink2 != null) {
                    eventSink2.success(Integer.valueOf(installStatus2));
                }
                if (installState2.installStatus() == 11) {
                    MethodChannel.Result result = hVar.f590h;
                    if (result != null) {
                        result.success(null);
                    }
                    hVar.f590h = null;
                    return;
                }
                if (installState2.installErrorCode() != 0) {
                    MethodChannel.Result result2 = hVar.f590h;
                    if (result2 != null) {
                        result2.error("Error during installation", String.valueOf(installState2.installErrorCode()), null);
                    }
                    hVar.f590h = null;
                    return;
                }
                return;
        }
    }
}
