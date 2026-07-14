package q1;

import android.app.PendingIntent;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import n.p;
import p1.C0580i;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: j, reason: collision with root package name */
    public final String f5961j;
    public final /* synthetic */ j k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, C0580i c0580i, String str) {
        super(jVar, new p("OnRequestInstallCallback"), c0580i);
        this.k = jVar;
        this.f5961j = str;
    }

    @Override // q1.g, r1.h
    public final void b(Bundle bundle) {
        Integer valueOf;
        super.b(bundle);
        int i4 = bundle.getInt("error.code", -2);
        C0580i c0580i = this.f5959h;
        if (i4 != 0) {
            c0580i.c(new X0.i(bundle.getInt("error.code", -2)));
            return;
        }
        int i5 = bundle.getInt("version.code", -1);
        int i6 = bundle.getInt("update.availability");
        int i7 = bundle.getInt("install.status", 0);
        if (bundle.getInt("client.version.staleness", -1) == -1) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(bundle.getInt("client.version.staleness"));
        }
        Integer num = valueOf;
        int i8 = bundle.getInt("in.app.update.priority", 0);
        bundle.getLong("bytes.downloaded");
        bundle.getLong("total.bytes.to.download");
        long j4 = bundle.getLong("additional.size.required");
        k kVar = this.k.f5967d;
        kVar.getClass();
        long a4 = k.a(new File(kVar.f5968a.getFilesDir(), "assetpacks"));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap hashMap = new HashMap();
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent");
        HashSet hashSet = new HashSet();
        if (integerArrayList != null) {
            hashSet.addAll(integerArrayList);
        }
        hashMap.put("blocking.destructive.intent", hashSet);
        ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent");
        HashSet hashSet2 = new HashSet();
        if (integerArrayList2 != null) {
            hashSet2.addAll(integerArrayList2);
        }
        hashMap.put("nonblocking.destructive.intent", hashSet2);
        ArrayList<Integer> integerArrayList3 = bundle.getIntegerArrayList("update.precondition.failures:blocking.intent");
        HashSet hashSet3 = new HashSet();
        if (integerArrayList3 != null) {
            hashSet3.addAll(integerArrayList3);
        }
        hashMap.put("blocking.intent", hashSet3);
        ArrayList<Integer> integerArrayList4 = bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent");
        HashSet hashSet4 = new HashSet();
        if (integerArrayList4 != null) {
            hashSet4.addAll(integerArrayList4);
        }
        hashMap.put("nonblocking.intent", hashSet4);
        c0580i.d(new C0601a(this.f5961j, i5, i6, i7, num, i8, j4, a4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, hashMap));
    }
}
