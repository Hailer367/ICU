package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import A2.t;
import I0.j;
import I0.s;
import O0.f;
import O0.l;
import S0.a;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f3350f = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i4 = jobParameters.getExtras().getInt("priority");
        int i5 = jobParameters.getExtras().getInt("attemptNumber");
        s.b(getApplicationContext());
        t a4 = j.a();
        a4.W(string);
        a4.f101i = a.b(i4);
        if (string2 != null) {
            a4.f100h = Base64.decode(string2, 0);
        }
        l lVar = s.a().f854d;
        lVar.f1301e.execute(new f(lVar, a4.x(), i5, new A.j(2, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
