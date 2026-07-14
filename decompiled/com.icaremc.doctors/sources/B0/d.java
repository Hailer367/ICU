package B0;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f83a;

    /* renamed from: b, reason: collision with root package name */
    public final C0.d f84b;

    /* renamed from: c, reason: collision with root package name */
    public final b f85c;

    public d(Context context, C0.d dVar, b bVar) {
        this.f83a = context;
        this.f84b = dVar;
        this.f85c = bVar;
    }

    public final void a(v0.j jVar, int i2, boolean z) {
        Long l2;
        Context context = this.f83a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = jVar.f3913a;
        String str2 = jVar.f3913a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        s0.d dVar = jVar.f3915c;
        adler32.update(allocate.putInt(F0.a.a(dVar)).array());
        byte[] bArr = jVar.f3914b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i3 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i3 >= i2) {
                        android.support.v4.media.session.a.j("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", jVar);
                        return;
                    }
                }
            }
        }
        Cursor rawQuery = ((C0.j) this.f84b).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(F0.a.a(dVar))});
        try {
            if (rawQuery.moveToNext()) {
                l2 = Long.valueOf(rawQuery.getLong(0));
            } else {
                l2 = 0L;
            }
            rawQuery.close();
            long longValue = l2.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            b bVar = this.f85c;
            builder.setMinimumLatency(bVar.a(dVar, longValue, i2));
            Set set = ((c) bVar.f79b.get(dVar)).f82c;
            if (set.contains(f.f89c)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(f.f91e)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(f.f90d)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i2);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", F0.a.a(dVar));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {jVar, Integer.valueOf(value), Long.valueOf(bVar.a(dVar, longValue, i2)), l2, Integer.valueOf(i2)};
            String p = android.support.v4.media.session.a.p("JobInfoScheduler");
            if (Log.isLoggable(p, 3)) {
                Log.d(p, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }
}
