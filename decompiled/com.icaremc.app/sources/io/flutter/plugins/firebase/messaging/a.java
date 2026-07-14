package io.flutter.plugins.firebase.messaging;

import A2.t;
import F.b;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import y2.i;
import y2.j;
import y2.m;
import y2.n;
import y2.o;

/* loaded from: classes.dex */
public abstract class a extends Service {
    public static final Object k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final HashMap f4412l = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public m f4413f;

    /* renamed from: g, reason: collision with root package name */
    public o f4414g;

    /* renamed from: h, reason: collision with root package name */
    public t f4415h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4416i = false;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f4417j = new ArrayList();

    public static o b(Context context, ComponentName componentName, boolean z, int i4, boolean z3) {
        o iVar;
        Object obj = new Object();
        HashMap hashMap = f4412l;
        o oVar = (o) hashMap.get(obj);
        if (oVar == null) {
            if (Build.VERSION.SDK_INT >= 26 && !z3) {
                if (z) {
                    iVar = new n(context, componentName, i4);
                } else {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
            } else {
                iVar = new i(context, componentName);
            }
            hashMap.put(obj, iVar);
            return iVar;
        }
        return oVar;
    }

    public final void a(boolean z) {
        if (this.f4415h == null) {
            this.f4415h = new t(this);
            o oVar = this.f4414g;
            if (oVar != null && z) {
                oVar.d();
            }
            t tVar = this.f4415h;
            ((ExecutorService) tVar.f99g).execute(new b(20, tVar));
        }
    }

    public final void c() {
        ArrayList arrayList = this.f4417j;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f4415h = null;
                    ArrayList arrayList2 = this.f4417j;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        a(false);
                    } else if (!this.f4416i) {
                        this.f4414g.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        IBinder binder;
        m mVar = this.f4413f;
        if (mVar != null) {
            binder = mVar.getBinder();
            return binder;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4413f = new m(this);
            this.f4414g = null;
        }
        this.f4414g = b(this, new ComponentName(this, getClass()), false, 0, true);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        t tVar = this.f4415h;
        if (tVar != null) {
            ((a) tVar.f101i).c();
        }
        synchronized (this.f4417j) {
            this.f4416i = true;
            this.f4414g.c();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i4, int i5) {
        this.f4414g.e();
        synchronized (this.f4417j) {
            ArrayList arrayList = this.f4417j;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new j(this, intent, i5));
            a(true);
        }
        return 3;
    }
}
