package u1;

import Z0.r;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Trace;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import t.C0655d;
import t.C0656e;
import t.C0661j;
import x1.C0721a;
import x1.k;
import y1.j;

/* loaded from: classes.dex */
public final class f {
    public static final Object k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final C0656e f6220l = new C0661j(0);

    /* renamed from: a, reason: collision with root package name */
    public final Context f6221a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6222b;

    /* renamed from: c, reason: collision with root package name */
    public final g f6223c;

    /* renamed from: d, reason: collision with root package name */
    public final x1.d f6224d;

    /* renamed from: g, reason: collision with root package name */
    public final k f6227g;

    /* renamed from: h, reason: collision with root package name */
    public final J1.a f6228h;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f6225e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f6226f = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f6229i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f6230j = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, W0.g] */
    public f(Context context, String str, g gVar) {
        ?? arrayList;
        this.f6221a = context;
        r.c(str);
        this.f6222b = str;
        this.f6223c = gVar;
        C0666a c0666a = FirebaseInitProvider.f3420f;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new K1.b(1, (String) it.next()));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        j jVar = j.f6584f;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        int i4 = 2;
        arrayList3.add(new K1.b(i4, new FirebaseCommonRegistrar()));
        arrayList3.add(new K1.b(i4, new ExecutorsRegistrar()));
        arrayList4.add(C0721a.b(context, Context.class, new Class[0]));
        arrayList4.add(C0721a.b(this, f.class, new Class[0]));
        arrayList4.add(C0721a.b(gVar, g.class, new Class[0]));
        ?? obj = new Object();
        if (((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked() && FirebaseInitProvider.f3421g.get()) {
            arrayList4.add(C0721a.b(c0666a, C0666a.class, new Class[0]));
        }
        x1.d dVar = new x1.d(arrayList3, arrayList4, obj);
        this.f6224d = dVar;
        Trace.endSection();
        this.f6227g = new k(new H1.c(this, context));
        this.f6228h = dVar.d(H1.e.class);
        c cVar = new c(this);
        a();
        if (this.f6225e.get()) {
            Y0.c.f2021j.f2022f.get();
        }
        this.f6229i.add(cVar);
        Trace.endSection();
    }

    public static ArrayList c() {
        ArrayList arrayList = new ArrayList();
        synchronized (k) {
            try {
                Iterator it = ((C0655d) f6220l.values()).iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    fVar.a();
                    arrayList.add(fVar.f6222b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static f d() {
        f fVar;
        synchronized (k) {
            try {
                fVar = (f) f6220l.get("[DEFAULT]");
                if (fVar != null) {
                    ((H1.e) fVar.f6228h.get()).b();
                } else {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + d1.b.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static f e(String str) {
        f fVar;
        String str2;
        synchronized (k) {
            try {
                fVar = (f) f6220l.get(str.trim());
                if (fVar != null) {
                    ((H1.e) fVar.f6228h.get()).b();
                } else {
                    ArrayList c4 = c();
                    if (c4.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", c4);
                    }
                    throw new IllegalStateException("FirebaseApp with name " + str + " doesn't exist. " + str2);
                }
            } finally {
            }
        }
        return fVar;
    }

    public static f h(Context context) {
        synchronized (k) {
            try {
                if (f6220l.containsKey("[DEFAULT]")) {
                    return d();
                }
                g a4 = g.a(context);
                if (a4 == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return i(context, "[DEFAULT]", a4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f i(Context context, String str, g gVar) {
        f fVar;
        AtomicReference atomicReference = d.f6217a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = d.f6217a;
            if (atomicReference2.get() == null) {
                Object obj = new Object();
                while (true) {
                    if (atomicReference2.compareAndSet(null, obj)) {
                        Y0.c.a(application);
                        Y0.c cVar = Y0.c.f2021j;
                        cVar.getClass();
                        synchronized (cVar) {
                            cVar.f2024h.add(obj);
                        }
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (k) {
            C0656e c0656e = f6220l;
            String str2 = "FirebaseApp name " + trim + " already exists!";
            if (!c0656e.containsKey(trim)) {
                r.f(context, "Application context cannot be null.");
                fVar = new f(context, trim, gVar);
                c0656e.put(trim, fVar);
            } else {
                throw new IllegalStateException(String.valueOf(str2));
            }
        }
        fVar.g();
        return fVar;
    }

    public final void a() {
        if (!this.f6226f.get()) {
        } else {
            throw new IllegalStateException("FirebaseApp was deleted");
        }
    }

    public final void b() {
        if (this.f6226f.compareAndSet(false, true)) {
            synchronized (k) {
                f6220l.remove(this.f6222b);
            }
            Iterator it = this.f6230j.iterator();
            if (!it.hasNext()) {
                return;
            }
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        fVar.a();
        return this.f6222b.equals(fVar.f6222b);
    }

    public final String f() {
        String encodeToString;
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f6222b.getBytes(Charset.defaultCharset());
        String str = null;
        if (bytes == null) {
            encodeToString = null;
        } else {
            encodeToString = Base64.encodeToString(bytes, 11);
        }
        sb.append(encodeToString);
        sb.append("+");
        a();
        byte[] bytes2 = this.f6223c.f6232b.getBytes(Charset.defaultCharset());
        if (bytes2 != null) {
            str = Base64.encodeToString(bytes2, 11);
        }
        sb.append(str);
        return sb.toString();
    }

    public final void g() {
        HashMap hashMap;
        if (!((UserManager) this.f6221a.getSystemService(UserManager.class)).isUserUnlocked()) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f6222b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f6221a;
            AtomicReference atomicReference = e.f6218b;
            if (atomicReference.get() == null) {
                e eVar = new e(context);
                while (!atomicReference.compareAndSet(null, eVar)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f6222b);
        Log.i("FirebaseApp", sb2.toString());
        x1.d dVar = this.f6224d;
        a();
        boolean equals = "[DEFAULT]".equals(this.f6222b);
        AtomicReference atomicReference2 = dVar.f6468f;
        Boolean valueOf = Boolean.valueOf(equals);
        while (true) {
            if (atomicReference2.compareAndSet(null, valueOf)) {
                synchronized (dVar) {
                    hashMap = new HashMap(dVar.f6463a);
                }
                dVar.g(hashMap, equals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((H1.e) this.f6228h.get()).b();
    }

    public final int hashCode() {
        return this.f6222b.hashCode();
    }

    public final void j(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f6229i.iterator();
        while (it.hasNext()) {
            f fVar = ((c) it.next()).f6216a;
            if (!z) {
                ((H1.e) fVar.f6228h.get()).b();
            }
        }
    }

    public final void k(Boolean bool) {
        a();
        O1.a aVar = (O1.a) this.f6227g.get();
        synchronized (aVar) {
            try {
                if (bool == null) {
                    aVar.f1311b.edit().remove("firebase_data_collection_default_enabled").apply();
                    aVar.b(aVar.a());
                } else {
                    boolean equals = Boolean.TRUE.equals(bool);
                    aVar.f1311b.edit().putBoolean("firebase_data_collection_default_enabled", equals).apply();
                    aVar.b(equals);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        E0.a aVar = new E0.a((Object) this);
        aVar.e(this.f6222b, "name");
        aVar.e(this.f6223c, "options");
        return aVar.toString();
    }
}
