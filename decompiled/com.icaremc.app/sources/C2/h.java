package C2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.install.zza;
import d2.C0261b;
import io.flutter.plugins.urllauncher.WebViewActivity;
import j.x;
import java.util.HashSet;
import java.util.Iterator;
import n.p;
import q1.C0603c;

/* loaded from: classes.dex */
public final class h extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f268a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f269b;

    public /* synthetic */ h(int i4, Object obj) {
        this.f268a = i4;
        this.f269b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f268a) {
            case 0:
                if ("close action".equals(intent.getAction())) {
                    ((WebViewActivity) this.f269b).finish();
                    return;
                }
                return;
            case 1:
                ((x) this.f269b).g();
                return;
            default:
                C0603c c0603c = (C0603c) this.f269b;
                if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
                    c0603c.f5944a.l("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
                    return;
                }
                c0603c.f5944a.l("List of extras in received intent:", new Object[0]);
                for (String str : intent.getExtras().keySet()) {
                    c0603c.f5944a.l("Key: %s; value: %s", str, intent.getExtras().get(str));
                }
                p pVar = c0603c.f5944a;
                pVar.l("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
                pVar.l("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
                pVar.l("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
                zza zzaVar = new zza(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
                c0603c.f5944a.l("ListenerRegistryBroadcastReceiver.onReceive: %s", zzaVar);
                synchronized (c0603c) {
                    Iterator it = new HashSet(c0603c.f5947d).iterator();
                    while (it.hasNext()) {
                        ((C0261b) it.next()).a(zzaVar);
                    }
                }
                return;
        }
    }
}
