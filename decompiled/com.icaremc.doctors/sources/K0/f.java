package K0;

import android.app.Activity;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* loaded from: classes.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPluginBinding f583a;

    public f(ActivityPluginBinding activityPluginBinding) {
        this.f583a = activityPluginBinding;
    }

    @Override // K0.a
    public final void a(h hVar) {
        this.f583a.addActivityResultListener(hVar);
    }

    @Override // K0.a
    public final Activity b() {
        Activity activity = this.f583a.getActivity();
        kotlin.jvm.internal.h.d(activity, "getActivity(...)");
        return activity;
    }
}
