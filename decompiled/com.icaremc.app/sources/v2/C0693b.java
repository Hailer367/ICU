package v2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import io.flutter.plugin.platform.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import o.B1;
import o2.c;
import p2.InterfaceC0586a;
import r2.i;
import s2.InterfaceC0643o;
import s2.InterfaceC0646r;

/* renamed from: v2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0693b implements c, InterfaceC0586a, InterfaceC0646r {

    /* renamed from: f, reason: collision with root package name */
    public final PackageManager f6289f;

    /* renamed from: g, reason: collision with root package name */
    public p2.b f6290g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f6291h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f6292i = new HashMap();

    public C0693b(s sVar) {
        this.f6289f = (PackageManager) sVar.f4390g;
        sVar.f4391h = this;
    }

    public final void a(String str, String str2, boolean z, i iVar) {
        if (this.f6290g == null) {
            iVar.error("error", "Plugin not bound to an Activity", null);
            return;
        }
        HashMap hashMap = this.f6291h;
        if (hashMap == null) {
            iVar.error("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) hashMap.get(str);
        if (resolveInfo == null) {
            iVar.error("error", "Text processing activity not found", null);
            return;
        }
        int hashCode = iVar.hashCode();
        this.f6292i.put(Integer.valueOf(hashCode), iVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z);
        ((Activity) ((B1) this.f6290g).f5414f).startActivityForResult(intent, hashCode);
    }

    public final HashMap b() {
        List<ResolveInfo> queryIntentActivities;
        PackageManager.ResolveInfoFlags of;
        HashMap hashMap = this.f6291h;
        PackageManager packageManager = this.f6289f;
        if (hashMap == null) {
            this.f6291h = new HashMap();
            Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
            if (Build.VERSION.SDK_INT >= 33) {
                of = PackageManager.ResolveInfoFlags.of(0L);
                queryIntentActivities = packageManager.queryIntentActivities(type, of);
            } else {
                queryIntentActivities = packageManager.queryIntentActivities(type, 0);
            }
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.name;
                resolveInfo.loadLabel(packageManager).toString();
                this.f6291h.put(str, resolveInfo);
            }
        }
        HashMap hashMap2 = new HashMap();
        for (String str2 : this.f6291h.keySet()) {
            hashMap2.put(str2, ((ResolveInfo) this.f6291h.get(str2)).loadLabel(packageManager).toString());
        }
        return hashMap2;
    }

    @Override // s2.InterfaceC0646r
    public final boolean onActivityResult(int i4, int i5, Intent intent) {
        String str;
        Integer valueOf = Integer.valueOf(i4);
        HashMap hashMap = this.f6292i;
        if (!hashMap.containsKey(valueOf)) {
            return false;
        }
        if (i5 == -1) {
            str = intent.getStringExtra("android.intent.extra.PROCESS_TEXT");
        } else {
            str = null;
        }
        ((InterfaceC0643o) hashMap.remove(Integer.valueOf(i4))).success(str);
        return true;
    }

    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(p2.b bVar) {
        this.f6290g = bVar;
        ((B1) bVar).a(this);
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        ((HashSet) ((B1) this.f6290g).f5417i).remove(this);
        this.f6290g = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        ((HashSet) ((B1) this.f6290g).f5417i).remove(this);
        this.f6290g = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(p2.b bVar) {
        this.f6290g = bVar;
        ((B1) bVar).a(this);
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
    }
}
