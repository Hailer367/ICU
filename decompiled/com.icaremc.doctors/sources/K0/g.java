package K0;

import android.app.Activity;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* loaded from: classes.dex */
public final class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPluginBinding f584a;

    public g(ActivityPluginBinding activityPluginBinding) {
        this.f584a = activityPluginBinding;
    }

    @Override // K0.a
    public final void a(h hVar) {
        this.f584a.addActivityResultListener(hVar);
    }

    @Override // K0.a
    public final Activity b() {
        Activity activity = this.f584a.getActivity();
        kotlin.jvm.internal.h.d(activity, "getActivity(...)");
        return activity;
    }
}
