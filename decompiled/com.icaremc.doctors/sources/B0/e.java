package B0;

import E.C0012l;
import android.app.job.JobParameters;
import android.graphics.Typeface;
import androidx.fragment.app.M;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import d.t;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import m.C0271s;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f86c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f87d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f88e;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f86c = i2;
        this.f87d = obj;
        this.f88e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f86c;
        Object obj = this.f88e;
        Object obj2 = this.f87d;
        switch (i2) {
            case 0:
                int i3 = JobInfoSchedulerService.f1994c;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                return;
            case 1:
                M m2 = (M) obj2;
                m2.getLifecycle().a(new C0012l(1, (t) obj, m2));
                return;
            case 2:
                FlutterFirebaseCorePlugin.lambda$delete$8((String) obj2, (TaskCompletionSource) obj);
                return;
            case 3:
                FlutterFirebasePluginRegistry.b((FirebaseApp) obj2, (TaskCompletionSource) obj);
                return;
            default:
                ((C0271s) obj2).b((Typeface) obj);
                return;
        }
    }
}
