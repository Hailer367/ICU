package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import A0.g;
import B0.e;
import B0.n;
import F0.a;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import v0.j;
import v0.q;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1994c = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        q.b(getApplicationContext());
        g a2 = j.a();
        a2.n(string);
        a2.f32f = a.b(i2);
        if (string2 != null) {
            a2.f31e = Base64.decode(string2, 0);
        }
        n nVar = q.a().f3933d;
        nVar.f119e.execute(new B0.g(nVar, a2.a(), i3, new e(0, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
