package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import A0.g;
import B0.n;
import F0.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import v0.j;
import v0.q;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1993a = 0;

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.Runnable] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        q.b(context);
        g a2 = j.a();
        a2.n(queryParameter);
        a2.f32f = a.b(intValue);
        if (queryParameter2 != null) {
            a2.f31e = Base64.decode(queryParameter2, 0);
        }
        n nVar = q.a().f3933d;
        nVar.f119e.execute(new B0.g(nVar, a2.a(), i2, new Object()));
    }
}
