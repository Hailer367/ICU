package y2;

import A2.t;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;

/* loaded from: classes.dex */
public final class m extends JobServiceEngine {

    /* renamed from: a, reason: collision with root package name */
    public final io.flutter.plugins.firebase.messaging.a f6625a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6626b;

    /* renamed from: c, reason: collision with root package name */
    public JobParameters f6627c;

    public m(io.flutter.plugins.firebase.messaging.a aVar) {
        super(aVar);
        this.f6626b = new Object();
        this.f6625a = aVar;
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        this.f6627c = jobParameters;
        this.f6625a.a(false);
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        t tVar = this.f6625a.f4415h;
        if (tVar != null) {
            ((io.flutter.plugins.firebase.messaging.a) tVar.f101i).c();
        }
        synchronized (this.f6626b) {
            this.f6627c = null;
        }
        return true;
    }
}
