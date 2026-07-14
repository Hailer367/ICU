package A2;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import androidx.lifecycle.AbstractC0208o;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import o.B1;
import p2.InterfaceC0586a;
import s2.InterfaceC0634f;

/* loaded from: classes.dex */
public class w implements o2.c, InterfaceC0586a, k {

    /* renamed from: f, reason: collision with root package name */
    public o2.b f115f;

    /* renamed from: g, reason: collision with root package name */
    public B1 f116g;

    public final C0003b a() {
        u uVar;
        boolean z;
        C0003b c0003b;
        l lVar;
        EnumC0004c enumC0004c;
        Set<String> stringSet;
        B1 b12 = this.f116g;
        if (b12 != null && ((Activity) b12.f5415g) != null) {
            uVar = (u) b12.f5416h;
        } else {
            uVar = null;
        }
        if (uVar != null) {
            l lVar2 = uVar.f105i;
            lVar2.getClass();
            HashMap hashMap = new HashMap();
            int i4 = 0;
            SharedPreferences sharedPreferences = lVar2.f82a.getSharedPreferences("flutter_image_picker_shared_preference", 0);
            boolean z3 = true;
            if (sharedPreferences.contains("flutter_image_picker_image_path") && (stringSet = sharedPreferences.getStringSet("flutter_image_picker_image_path", null)) != null) {
                hashMap.put("pathList", new ArrayList(stringSet));
                z = true;
            } else {
                z = false;
            }
            if (sharedPreferences.contains("flutter_image_picker_error_code")) {
                hashMap.put("error", new C0002a(sharedPreferences.getString("flutter_image_picker_error_code", ""), sharedPreferences.getString("flutter_image_picker_error_message", null)));
            } else {
                z3 = z;
            }
            int i5 = 100;
            if (z3) {
                if (sharedPreferences.contains("flutter_image_picker_type")) {
                    if (sharedPreferences.getString("flutter_image_picker_type", "").equals("video")) {
                        enumC0004c = EnumC0004c.VIDEO;
                    } else {
                        enumC0004c = EnumC0004c.IMAGE;
                    }
                    hashMap.put("type", enumC0004c);
                }
                c0003b = null;
                lVar = lVar2;
                if (sharedPreferences.contains("flutter_image_picker_max_width")) {
                    hashMap.put("maxWidth", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_width", 0L))));
                }
                if (sharedPreferences.contains("flutter_image_picker_max_height")) {
                    hashMap.put("maxHeight", Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong("flutter_image_picker_max_height", 0L))));
                }
                hashMap.put("imageQuality", Integer.valueOf(sharedPreferences.getInt("flutter_image_picker_image_quality", 100)));
            } else {
                c0003b = null;
                lVar = lVar2;
            }
            if (hashMap.isEmpty()) {
                return c0003b;
            }
            EnumC0004c enumC0004c2 = (EnumC0004c) hashMap.get("type");
            ArrayList arrayList = (ArrayList) hashMap.get("pathList");
            if (enumC0004c2 != null && arrayList != null) {
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    String str = (String) obj;
                    Double d4 = (Double) hashMap.get("maxWidth");
                    Double d5 = (Double) hashMap.get("maxHeight");
                    Integer num = (Integer) hashMap.get("imageQuality");
                    if (num != null) {
                        i5 = num.intValue();
                    }
                    arrayList2.add(uVar.f104h.b(str, d4, d5, i5));
                    i5 = 100;
                }
                lVar.b();
                return new C0003b(enumC0004c2, (C0002a) hashMap.get("error"), arrayList2);
            }
            lVar.b();
            return c0003b;
        }
        throw new C0005d("no_activity", "image_picker plugin requires a foreground activity.");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, W0.g] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, o.B1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [A2.l, java.lang.Object] */
    @Override // p2.InterfaceC0586a
    public final void onAttachedToActivity(p2.b bVar) {
        o2.b bVar2 = this.f115f;
        InterfaceC0634f interfaceC0634f = bVar2.f5787c;
        Application application = (Application) bVar2.f5785a;
        B1 b12 = (B1) bVar;
        Activity activity = (Activity) b12.f5414f;
        ?? obj = new Object();
        obj.f5414f = application;
        obj.f5415g = activity;
        obj.f5418j = bVar;
        obj.k = interfaceC0634f;
        ?? obj2 = new Object();
        obj2.f82a = activity;
        obj.f5416h = new u(activity, new x(activity, (W0.g) new Object()), obj2);
        k.f81a.getClass();
        j.a(interfaceC0634f, this);
        obj.f5417i = new v(this, activity);
        b12.a((u) obj.f5416h);
        ((HashSet) b12.f5416h).add((u) obj.f5416h);
        AbstractC0208o lifecycle = ((HiddenLifecycleReference) b12.f5415g).getLifecycle();
        obj.f5419l = lifecycle;
        lifecycle.a((v) obj.f5417i);
        this.f116g = obj;
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        this.f115f = bVar;
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivity() {
        B1 b12 = this.f116g;
        if (b12 != null) {
            p2.b bVar = (p2.b) b12.f5418j;
            if (bVar != null) {
                ((HashSet) ((B1) bVar).f5417i).remove((u) b12.f5416h);
                p2.b bVar2 = (p2.b) b12.f5418j;
                ((HashSet) ((B1) bVar2).f5416h).remove((u) b12.f5416h);
                b12.f5418j = null;
            }
            AbstractC0208o abstractC0208o = (AbstractC0208o) b12.f5419l;
            if (abstractC0208o != null) {
                abstractC0208o.b((v) b12.f5417i);
                b12.f5419l = null;
            }
            InterfaceC0634f interfaceC0634f = (InterfaceC0634f) b12.k;
            k.f81a.getClass();
            j.a(interfaceC0634f, null);
            Application application = (Application) b12.f5414f;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks((v) b12.f5417i);
                b12.f5414f = null;
            }
            b12.f5415g = null;
            b12.f5417i = null;
            b12.f5416h = null;
            this.f116g = null;
        }
    }

    @Override // p2.InterfaceC0586a
    public final void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        this.f115f = null;
    }

    @Override // p2.InterfaceC0586a
    public final void onReattachedToActivityForConfigChanges(p2.b bVar) {
        onAttachedToActivity(bVar);
    }
}
