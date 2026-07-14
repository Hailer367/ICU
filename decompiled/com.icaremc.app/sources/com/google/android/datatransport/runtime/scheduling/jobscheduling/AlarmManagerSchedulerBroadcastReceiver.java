package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import A2.t;
import I0.j;
import I0.s;
import O0.f;
import O0.l;
import S0.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3349a = 0;

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.Runnable] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i4 = intent.getExtras().getInt("attemptNumber");
        s.b(context);
        t a4 = j.a();
        a4.W(queryParameter);
        a4.f101i = a.b(intValue);
        if (queryParameter2 != null) {
            a4.f100h = Base64.decode(queryParameter2, 0);
        }
        l lVar = s.a().f854d;
        lVar.f1301e.execute(new f(lVar, a4.x(), i4, new Object()));
    }
}
