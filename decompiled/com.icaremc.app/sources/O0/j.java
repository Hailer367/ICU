package O0;

import A2.t;
import P1.AbstractServiceC0103g;
import P1.C0106j;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Trace;
import com.google.firebase.FirebaseCommonRegistrar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p1.AbstractC0579h;
import p1.InterfaceC0572a;
import p1.InterfaceC0574c;
import t.C0656e;
import x1.C0721a;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Q0.b, P0.f, InterfaceC0574c, InterfaceC0572a, x1.c {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1291f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1292g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1293h;

    public /* synthetic */ j(int i4, Object obj, Object obj2) {
        this.f1291f = i4;
        this.f1292g = obj;
        this.f1293h = obj2;
    }

    @Override // x1.c
    public Object a(I0.h hVar) {
        String valueOf;
        switch (this.f1291f) {
            case 5:
                String str = (String) this.f1292g;
                V1.f fVar = (V1.f) this.f1293h;
                Context context = (Context) hVar.a(Context.class);
                switch (fVar.f1729f) {
                    case 2:
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if (applicationInfo != null) {
                            valueOf = String.valueOf(applicationInfo.targetSdkVersion);
                            break;
                        }
                        valueOf = "";
                        break;
                    case 3:
                        ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                        if (applicationInfo2 != null) {
                            valueOf = String.valueOf(applicationInfo2.minSdkVersion);
                            break;
                        }
                        valueOf = "";
                        break;
                    case 4:
                        int i4 = Build.VERSION.SDK_INT;
                        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                            valueOf = "tv";
                            break;
                        } else if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                            valueOf = "watch";
                            break;
                        } else if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                            valueOf = "auto";
                            break;
                        } else {
                            if (i4 >= 26 && context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                                valueOf = "embedded";
                                break;
                            }
                            valueOf = "";
                            break;
                        }
                    default:
                        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                        if (installerPackageName != null) {
                            valueOf = FirebaseCommonRegistrar.a(installerPackageName);
                            break;
                        }
                        valueOf = "";
                        break;
                }
                return new R1.a(str, valueOf);
            default:
                String str2 = (String) this.f1292g;
                C0721a c0721a = (C0721a) this.f1293h;
                try {
                    Trace.beginSection(str2);
                    return c0721a.f6460f.a(hVar);
                } finally {
                    Trace.endSection();
                }
        }
    }

    @Override // P0.f
    public Object apply(Object obj) {
        P0.h hVar = (P0.h) this.f1292g;
        I0.j jVar = (I0.j) this.f1293h;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        P0.a aVar = hVar.f1331i;
        ArrayList d4 = hVar.d(sQLiteDatabase, jVar, aVar.f1317b);
        for (F0.d dVar : F0.d.values()) {
            if (dVar != jVar.f833c) {
                int size = aVar.f1317b - d4.size();
                if (size <= 0) {
                    break;
                }
                t a4 = I0.j.a();
                a4.W(jVar.f831a);
                if (dVar != null) {
                    a4.f101i = dVar;
                    a4.f100h = jVar.f832b;
                    d4.addAll(hVar.d(sQLiteDatabase, a4.x(), size));
                } else {
                    throw new NullPointerException("Null priority");
                }
            }
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i4 = 0; i4 < d4.size(); i4++) {
            sb.append(((P0.b) d4.get(i4)).f1321a);
            if (i4 < d4.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                long j4 = query.getLong(0);
                Set set = (Set) hashMap.get(Long.valueOf(j4));
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(Long.valueOf(j4), set);
                }
                set.add(new P0.g(query.getString(1), query.getString(2)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        ListIterator listIterator = d4.listIterator();
        while (listIterator.hasNext()) {
            P0.b bVar = (P0.b) listIterator.next();
            long j5 = bVar.f1321a;
            if (hashMap.containsKey(Long.valueOf(j5))) {
                I0.h c4 = bVar.f1323c.c();
                for (P0.g gVar : (Set) hashMap.get(Long.valueOf(j5))) {
                    c4.g(gVar.f1326a, gVar.f1327b);
                }
                listIterator.set(new P0.b(j5, bVar.f1322b, c4.i()));
            }
        }
        return d4;
    }

    @Override // p1.InterfaceC0572a
    public Object b(AbstractC0579h abstractC0579h) {
        C0106j c0106j = (C0106j) this.f1292g;
        String str = (String) this.f1293h;
        synchronized (c0106j) {
            ((C0656e) c0106j.f1424b).remove(str);
        }
        return abstractC0579h;
    }

    @Override // Q0.b
    public Object d() {
        switch (this.f1291f) {
            case 0:
                l lVar = (l) this.f1292g;
                Iterable iterable = (Iterable) this.f1293h;
                P0.h hVar = (P0.h) lVar.f1299c;
                hVar.getClass();
                if (iterable.iterator().hasNext()) {
                    hVar.a().compileStatement("DELETE FROM events WHERE _id in " + P0.h.g(iterable)).execute();
                    return null;
                }
                return null;
            default:
                l lVar2 = (l) this.f1292g;
                for (Map.Entry entry : ((HashMap) this.f1293h).entrySet()) {
                    ((P0.h) lVar2.f1305i).e(((Integer) entry.getValue()).intValue(), L0.c.INVALID_PAYLOD, (String) entry.getKey());
                }
                return null;
        }
    }

    @Override // p1.InterfaceC0574c
    public void q(AbstractC0579h abstractC0579h) {
        ((AbstractServiceC0103g) this.f1292g).a((Intent) this.f1293h);
    }
}
