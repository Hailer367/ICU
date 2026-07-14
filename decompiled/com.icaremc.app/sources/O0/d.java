package O0;

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
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1269a;

    /* renamed from: b, reason: collision with root package name */
    public final P0.d f1270b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1271c;

    public d(Context context, P0.d dVar, b bVar) {
        this.f1269a = context;
        this.f1270b = dVar;
        this.f1271c = bVar;
    }

    public final void a(I0.j jVar, int i4, boolean z) {
        Long l3;
        Context context = this.f1269a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = jVar.f831a;
        String str2 = jVar.f831a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        F0.d dVar = jVar.f833c;
        adler32.update(allocate.putInt(S0.a.a(dVar)).array());
        byte[] bArr = jVar.f832b;
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
                int i5 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i5 >= i4) {
                        AbstractC0602b.r("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", jVar);
                        return;
                    }
                }
            }
        }
        Cursor rawQuery = ((P0.h) this.f1270b).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(S0.a.a(dVar))});
        try {
            if (rawQuery.moveToNext()) {
                l3 = Long.valueOf(rawQuery.getLong(0));
            } else {
                l3 = 0L;
            }
            rawQuery.close();
            long longValue = l3.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            b bVar = this.f1271c;
            builder.setMinimumLatency(bVar.a(dVar, longValue, i4));
            Set set = ((c) bVar.f1265b.get(dVar)).f1268c;
            if (set.contains(e.f1272f)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(e.f1274h)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(e.f1273g)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i4);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", S0.a.a(dVar));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {jVar, Integer.valueOf(value), Long.valueOf(bVar.a(dVar, longValue, i4)), l3, Integer.valueOf(i4)};
            String G3 = AbstractC0602b.G("JobInfoScheduler");
            if (Log.isLoggable(G3, 3)) {
                Log.d(G3, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }
}
