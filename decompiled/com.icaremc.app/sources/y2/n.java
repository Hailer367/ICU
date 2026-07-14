package y2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class n extends o {

    /* renamed from: d, reason: collision with root package name */
    public final JobInfo f6628d;

    /* renamed from: e, reason: collision with root package name */
    public final JobScheduler f6629e;

    public n(Context context, ComponentName componentName, int i4) {
        super(componentName);
        b(i4);
        this.f6628d = new JobInfo.Builder(i4, componentName).setOverrideDeadline(0L).build();
        this.f6629e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // y2.o
    public final void a(Intent intent) {
        this.f6629e.enqueue(this.f6628d, io.flutter.plugin.editing.i.c(intent));
    }
}
