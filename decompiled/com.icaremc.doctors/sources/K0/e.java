package K0;

import Q0.j;
import R0.u;
import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import c1.l;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f580c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f581d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f582e;

    public /* synthetic */ e(h hVar, Object obj, int i2) {
        this.f580c = i2;
        this.f581d = hVar;
        this.f582e = obj;
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        h hVar;
        Integer num;
        switch (this.f580c) {
            case 0:
                Activity activity = (Activity) this.f582e;
                AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
                if (appUpdateInfo.updateAvailability() == 3 && (num = (hVar = this.f581d).f591i) != null && num.intValue() == 1) {
                    try {
                        AppUpdateManager appUpdateManager = hVar.f593k;
                        if (appUpdateManager != null) {
                            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, activity, AppUpdateOptions.defaultOptions(1), 1276);
                        }
                    } catch (IntentSender.SendIntentException e2) {
                        Log.e("in_app_update", "Could not start update flow", e2);
                    }
                }
                return j.f722a;
            default:
                MethodChannel.Result result = (MethodChannel.Result) this.f582e;
                AppUpdateInfo appUpdateInfo2 = (AppUpdateInfo) obj;
                this.f581d.f592j = appUpdateInfo2;
                Q0.e eVar = new Q0.e("updateAvailability", Integer.valueOf(appUpdateInfo2.updateAvailability()));
                Q0.e eVar2 = new Q0.e("immediateAllowed", Boolean.valueOf(appUpdateInfo2.isUpdateTypeAllowed(1)));
                Set<Integer> failedUpdatePreconditions = appUpdateInfo2.getFailedUpdatePreconditions(AppUpdateOptions.defaultOptions(1));
                kotlin.jvm.internal.h.d(failedUpdatePreconditions, "getFailedUpdatePreconditions(...)");
                ArrayList arrayList = new ArrayList(R0.l.O(failedUpdatePreconditions));
                for (Integer num2 : failedUpdatePreconditions) {
                    num2.getClass();
                    arrayList.add(num2);
                }
                Q0.e eVar3 = new Q0.e("immediateAllowedPreconditions", R0.j.U(arrayList));
                Q0.e eVar4 = new Q0.e("flexibleAllowed", Boolean.valueOf(appUpdateInfo2.isUpdateTypeAllowed(0)));
                Set<Integer> failedUpdatePreconditions2 = appUpdateInfo2.getFailedUpdatePreconditions(AppUpdateOptions.defaultOptions(0));
                kotlin.jvm.internal.h.d(failedUpdatePreconditions2, "getFailedUpdatePreconditions(...)");
                ArrayList arrayList2 = new ArrayList(R0.l.O(failedUpdatePreconditions2));
                for (Integer num3 : failedUpdatePreconditions2) {
                    num3.getClass();
                    arrayList2.add(num3);
                }
                Q0.e[] eVarArr = {eVar, eVar2, eVar3, eVar4, new Q0.e("flexibleAllowedPreconditions", R0.j.U(arrayList2)), new Q0.e("availableVersionCode", Integer.valueOf(appUpdateInfo2.availableVersionCode())), new Q0.e("installStatus", Integer.valueOf(appUpdateInfo2.installStatus())), new Q0.e("packageName", appUpdateInfo2.packageName()), new Q0.e("clientVersionStalenessDays", appUpdateInfo2.clientVersionStalenessDays()), new Q0.e("updatePriority", Integer.valueOf(appUpdateInfo2.updatePriority()))};
                LinkedHashMap linkedHashMap = new LinkedHashMap(u.X(10));
                for (int i2 = 0; i2 < 10; i2++) {
                    Q0.e eVar5 = eVarArr[i2];
                    linkedHashMap.put(eVar5.f714c, eVar5.f715d);
                }
                result.success(linkedHashMap);
                return j.f722a;
        }
    }
}
