package y2;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public final JobWorkItem f6623a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f6624b;

    public l(m mVar, JobWorkItem jobWorkItem) {
        this.f6624b = mVar;
        this.f6623a = jobWorkItem;
    }

    @Override // y2.k
    public final void a() {
        synchronized (this.f6624b.f6626b) {
            JobParameters jobParameters = this.f6624b.f6627c;
            if (jobParameters != null) {
                try {
                    jobParameters.completeWork(this.f6623a);
                } catch (IllegalArgumentException e4) {
                    Log.e("JobServiceEngineImpl", "IllegalArgumentException: Failed to run mParams.completeWork(mJobWork)!", e4);
                } catch (SecurityException e5) {
                    Log.e("JobServiceEngineImpl", "SecurityException: Failed to run mParams.completeWork(mJobWork)!", e5);
                }
            }
        }
    }

    @Override // y2.k
    public final Intent getIntent() {
        Intent intent;
        intent = this.f6623a.getIntent();
        return intent;
    }
}
