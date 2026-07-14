package A2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s2.InterfaceC0646r;
import s2.InterfaceC0648t;
import y.AbstractC0727c;

/* loaded from: classes.dex */
public final class u implements InterfaceC0646r, InterfaceC0648t {

    /* renamed from: f, reason: collision with root package name */
    public final String f102f;

    /* renamed from: g, reason: collision with root package name */
    public final Activity f103g;

    /* renamed from: h, reason: collision with root package name */
    public final x f104h;

    /* renamed from: i, reason: collision with root package name */
    public final l f105i;

    /* renamed from: j, reason: collision with root package name */
    public final q f106j;
    public final R1.c k;

    /* renamed from: l, reason: collision with root package name */
    public final Z0.g f107l;

    /* renamed from: m, reason: collision with root package name */
    public final ExecutorService f108m;

    /* renamed from: n, reason: collision with root package name */
    public int f109n;

    /* renamed from: o, reason: collision with root package name */
    public Uri f110o;

    /* renamed from: p, reason: collision with root package name */
    public t f111p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f112q;

    /* JADX WARN: Type inference failed for: r2v1, types: [Z0.g, java.lang.Object] */
    public u(Activity activity, x xVar, l lVar) {
        q qVar = new q(0, activity);
        R1.c cVar = new R1.c(1, activity);
        ?? obj = new Object();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f112q = new Object();
        this.f103g = activity;
        this.f104h = xVar;
        this.f102f = activity.getPackageName() + ".flutter.image_provider";
        this.f106j = qVar;
        this.k = cVar;
        this.f107l = obj;
        this.f105i = lVar;
        this.f108m = newSingleThreadExecutor;
    }

    public static void a(S2.l lVar) {
        k3.b.c(lVar, new C0005d("already_active", "Image picker is already active"));
    }

    public final void b(String str, String str2) {
        S2.l lVar;
        synchronized (this.f112q) {
            t tVar = this.f111p;
            if (tVar != null) {
                lVar = (S2.l) tVar.f101i;
            } else {
                lVar = null;
            }
            this.f111p = null;
        }
        if (lVar == null) {
            this.f105i.c(null, str, str2);
        } else {
            k3.b.c(lVar, new C0005d(str, str2));
        }
    }

    public final void c(ArrayList arrayList) {
        S2.l lVar;
        synchronized (this.f112q) {
            t tVar = this.f111p;
            if (tVar != null) {
                lVar = (S2.l) tVar.f101i;
            } else {
                lVar = null;
            }
            this.f111p = null;
        }
        if (lVar == null) {
            this.f105i.c(arrayList, null, null);
        } else {
            lVar.f(new H2.f(arrayList));
        }
    }

    public final void d(String str) {
        S2.l lVar;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        synchronized (this.f112q) {
            t tVar = this.f111p;
            if (tVar != null) {
                lVar = (S2.l) tVar.f101i;
            } else {
                lVar = null;
            }
            this.f111p = null;
        }
        if (lVar == null) {
            if (!arrayList.isEmpty()) {
                this.f105i.c(arrayList, null, null);
                return;
            }
            return;
        }
        lVar.f(new H2.f(arrayList));
    }

    public final ArrayList e(Intent intent, boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        Uri data = intent.getData();
        Z0.g gVar = this.f107l;
        Activity activity = this.f103g;
        if (data == null) {
            if (intent.getClipData() != null) {
                for (int i4 = 0; i4 < intent.getClipData().getItemCount(); i4++) {
                    Uri uri = intent.getClipData().getItemAt(i4).getUri();
                    if (uri != null) {
                        gVar.getClass();
                        String e4 = Z0.g.e(activity, uri);
                        if (e4 != null) {
                            if (z) {
                                str = activity.getContentResolver().getType(uri);
                            } else {
                                str = null;
                            }
                            arrayList.add(new s(e4, str));
                        }
                    }
                }
                return arrayList;
            }
        } else {
            gVar.getClass();
            String e5 = Z0.g.e(activity, data);
            if (e5 != null) {
                arrayList.add(new s(e5, null));
                return arrayList;
            }
        }
        return null;
    }

    public final void f(Intent intent, Uri uri) {
        List<ResolveInfo> queryIntentActivities;
        PackageManager.ResolveInfoFlags of;
        Activity activity = this.f103g;
        PackageManager packageManager = activity.getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            of = PackageManager.ResolveInfoFlags.of(65536L);
            queryIntentActivities = packageManager.queryIntentActivities(intent, of);
        } else {
            queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            activity.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
        }
    }

    public final void g(ArrayList arrayList) {
        y yVar;
        synchronized (this.f112q) {
            t tVar = this.f111p;
            if (tVar != null) {
                yVar = (y) tVar.f99g;
            } else {
                yVar = null;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        if (yVar != null) {
            while (i4 < arrayList.size()) {
                s sVar = (s) arrayList.get(i4);
                String str = sVar.f95a;
                String str2 = sVar.f96b;
                if (str2 == null || !str2.startsWith("video/")) {
                    str = this.f104h.b(sVar.f95a, yVar.f118a, yVar.f119b, (int) yVar.f120c);
                }
                arrayList2.add(str);
                i4++;
            }
            c(arrayList2);
            return;
        }
        while (i4 < arrayList.size()) {
            arrayList2.add(((s) arrayList.get(i4)).f95a);
            i4++;
        }
        c(arrayList2);
    }

    public final void h() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.f109n == 2) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
        }
        String uuid = UUID.randomUUID().toString();
        Activity activity = this.f103g;
        File cacheDir = activity.getCacheDir();
        try {
            cacheDir.mkdirs();
            File createTempFile = File.createTempFile(uuid, ".jpg", cacheDir);
            this.f110o = Uri.parse("file:" + createTempFile.getAbsolutePath());
            Uri uriForFile = AbstractC0727c.getUriForFile((Activity) this.k.f1532g, this.f102f, createTempFile);
            intent.putExtra("output", uriForFile);
            f(intent, uriForFile);
            try {
                try {
                    activity.startActivityForResult(intent, 2343);
                } catch (ActivityNotFoundException unused) {
                    createTempFile.delete();
                    b("no_available_camera", "No cameras available for taking pictures.");
                }
            } catch (SecurityException e4) {
                e4.printStackTrace();
                b("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final void i() {
        E e4;
        Long l3;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        synchronized (this.f112q) {
            t tVar = this.f111p;
            if (tVar != null) {
                e4 = (E) tVar.f100h;
            } else {
                e4 = null;
            }
        }
        if (e4 != null && (l3 = e4.f58a) != null) {
            intent.putExtra("android.intent.extra.durationLimit", l3.intValue());
        }
        if (this.f109n == 2) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
        }
        String uuid = UUID.randomUUID().toString();
        File cacheDir = this.f103g.getCacheDir();
        try {
            cacheDir.mkdirs();
            File createTempFile = File.createTempFile(uuid, ".mp4", cacheDir);
            this.f110o = Uri.parse("file:" + createTempFile.getAbsolutePath());
            Uri uriForFile = AbstractC0727c.getUriForFile((Activity) this.k.f1532g, this.f102f, createTempFile);
            intent.putExtra("output", uriForFile);
            f(intent, uriForFile);
            try {
                try {
                    this.f103g.startActivityForResult(intent, 2353);
                } catch (ActivityNotFoundException unused) {
                    createTempFile.delete();
                    b("no_available_camera", "No cameras available for taking pictures.");
                }
            } catch (SecurityException e5) {
                e5.printStackTrace();
                b("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (IOException e6) {
            throw new RuntimeException(e6);
        }
    }

    public final boolean j() {
        PackageInfo packageInfo;
        PackageManager.PackageInfoFlags of;
        q qVar = this.f106j;
        if (qVar == null) {
            return false;
        }
        Activity activity = (Activity) qVar.f93g;
        try {
            PackageManager packageManager = activity.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                String packageName = activity.getPackageName();
                of = PackageManager.PackageInfoFlags.of(4096L);
                packageInfo = packageManager.getPackageInfo(packageName, of);
            } else {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 4096);
            }
            return Arrays.asList(packageInfo.requestedPermissions).contains("android.permission.CAMERA");
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final boolean k(y yVar, E e4, S2.l lVar) {
        synchronized (this.f112q) {
            try {
                if (this.f111p != null) {
                    return false;
                }
                this.f111p = new t(yVar, e4, lVar, 0);
                this.f105i.b();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0010. Please report as an issue. */
    @Override // s2.InterfaceC0646r
    public final boolean onActivityResult(int i4, final int i5, final Intent intent) {
        Runnable runnable;
        if (i4 != 2342) {
            if (i4 != 2343) {
                if (i4 != 2352) {
                    if (i4 != 2353) {
                        switch (i4) {
                            case 2346:
                                final int i6 = 1;
                                runnable = new Runnable(this) { // from class: A2.n

                                    /* renamed from: g, reason: collision with root package name */
                                    public final /* synthetic */ u f84g;

                                    {
                                        this.f84g = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Intent intent2;
                                        Intent intent3;
                                        Intent intent4;
                                        Intent intent5;
                                        Intent intent6;
                                        switch (i6) {
                                            case 0:
                                                u uVar = this.f84g;
                                                uVar.getClass();
                                                if (i5 == -1 && (intent2 = intent) != null) {
                                                    ArrayList e4 = uVar.e(intent2, false);
                                                    if (e4 == null) {
                                                        uVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                                        return;
                                                    } else {
                                                        uVar.g(e4);
                                                        return;
                                                    }
                                                }
                                                uVar.d(null);
                                                return;
                                            case 1:
                                                u uVar2 = this.f84g;
                                                uVar2.getClass();
                                                if (i5 == -1 && (intent3 = intent) != null) {
                                                    ArrayList e5 = uVar2.e(intent3, false);
                                                    if (e5 == null) {
                                                        uVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                                        return;
                                                    } else {
                                                        uVar2.g(e5);
                                                        return;
                                                    }
                                                }
                                                uVar2.d(null);
                                                return;
                                            case 2:
                                                u uVar3 = this.f84g;
                                                uVar3.getClass();
                                                if (i5 == -1 && (intent4 = intent) != null) {
                                                    ArrayList e6 = uVar3.e(intent4, false);
                                                    if (e6 == null) {
                                                        uVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                                        return;
                                                    } else {
                                                        uVar3.g(e6);
                                                        return;
                                                    }
                                                }
                                                uVar3.d(null);
                                                return;
                                            case 3:
                                                u uVar4 = this.f84g;
                                                uVar4.getClass();
                                                if (i5 == -1 && (intent5 = intent) != null) {
                                                    ArrayList e7 = uVar4.e(intent5, true);
                                                    if (e7 == null) {
                                                        uVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                                        return;
                                                    } else {
                                                        uVar4.g(e7);
                                                        return;
                                                    }
                                                }
                                                uVar4.d(null);
                                                return;
                                            default:
                                                u uVar5 = this.f84g;
                                                uVar5.getClass();
                                                if (i5 == -1 && (intent6 = intent) != null) {
                                                    ArrayList e8 = uVar5.e(intent6, false);
                                                    if (e8 != null && e8.size() >= 1) {
                                                        uVar5.d(((s) e8.get(0)).f95a);
                                                        return;
                                                    } else {
                                                        uVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                                        return;
                                                    }
                                                }
                                                uVar5.d(null);
                                                return;
                                        }
                                    }
                                };
                                break;
                            case 2347:
                                final int i7 = 3;
                                runnable = new Runnable(this) { // from class: A2.n

                                    /* renamed from: g, reason: collision with root package name */
                                    public final /* synthetic */ u f84g;

                                    {
                                        this.f84g = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Intent intent2;
                                        Intent intent3;
                                        Intent intent4;
                                        Intent intent5;
                                        Intent intent6;
                                        switch (i7) {
                                            case 0:
                                                u uVar = this.f84g;
                                                uVar.getClass();
                                                if (i5 == -1 && (intent2 = intent) != null) {
                                                    ArrayList e4 = uVar.e(intent2, false);
                                                    if (e4 == null) {
                                                        uVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                                        return;
                                                    } else {
                                                        uVar.g(e4);
                                                        return;
                                                    }
                                                }
                                                uVar.d(null);
                                                return;
                                            case 1:
                                                u uVar2 = this.f84g;
                                                uVar2.getClass();
                                                if (i5 == -1 && (intent3 = intent) != null) {
                                                    ArrayList e5 = uVar2.e(intent3, false);
                                                    if (e5 == null) {
                                                        uVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                                        return;
                                                    } else {
                                                        uVar2.g(e5);
                                                        return;
                                                    }
                                                }
                                                uVar2.d(null);
                                                return;
                                            case 2:
                                                u uVar3 = this.f84g;
                                                uVar3.getClass();
                                                if (i5 == -1 && (intent4 = intent) != null) {
                                                    ArrayList e6 = uVar3.e(intent4, false);
                                                    if (e6 == null) {
                                                        uVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                                        return;
                                                    } else {
                                                        uVar3.g(e6);
                                                        return;
                                                    }
                                                }
                                                uVar3.d(null);
                                                return;
                                            case 3:
                                                u uVar4 = this.f84g;
                                                uVar4.getClass();
                                                if (i5 == -1 && (intent5 = intent) != null) {
                                                    ArrayList e7 = uVar4.e(intent5, true);
                                                    if (e7 == null) {
                                                        uVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                                        return;
                                                    } else {
                                                        uVar4.g(e7);
                                                        return;
                                                    }
                                                }
                                                uVar4.d(null);
                                                return;
                                            default:
                                                u uVar5 = this.f84g;
                                                uVar5.getClass();
                                                if (i5 == -1 && (intent6 = intent) != null) {
                                                    ArrayList e8 = uVar5.e(intent6, false);
                                                    if (e8 != null && e8.size() >= 1) {
                                                        uVar5.d(((s) e8.get(0)).f95a);
                                                        return;
                                                    } else {
                                                        uVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                                        return;
                                                    }
                                                }
                                                uVar5.d(null);
                                                return;
                                        }
                                    }
                                };
                                break;
                            case 2348:
                                final int i8 = 2;
                                runnable = new Runnable(this) { // from class: A2.n

                                    /* renamed from: g, reason: collision with root package name */
                                    public final /* synthetic */ u f84g;

                                    {
                                        this.f84g = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Intent intent2;
                                        Intent intent3;
                                        Intent intent4;
                                        Intent intent5;
                                        Intent intent6;
                                        switch (i8) {
                                            case 0:
                                                u uVar = this.f84g;
                                                uVar.getClass();
                                                if (i5 == -1 && (intent2 = intent) != null) {
                                                    ArrayList e4 = uVar.e(intent2, false);
                                                    if (e4 == null) {
                                                        uVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                                        return;
                                                    } else {
                                                        uVar.g(e4);
                                                        return;
                                                    }
                                                }
                                                uVar.d(null);
                                                return;
                                            case 1:
                                                u uVar2 = this.f84g;
                                                uVar2.getClass();
                                                if (i5 == -1 && (intent3 = intent) != null) {
                                                    ArrayList e5 = uVar2.e(intent3, false);
                                                    if (e5 == null) {
                                                        uVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                                        return;
                                                    } else {
                                                        uVar2.g(e5);
                                                        return;
                                                    }
                                                }
                                                uVar2.d(null);
                                                return;
                                            case 2:
                                                u uVar3 = this.f84g;
                                                uVar3.getClass();
                                                if (i5 == -1 && (intent4 = intent) != null) {
                                                    ArrayList e6 = uVar3.e(intent4, false);
                                                    if (e6 == null) {
                                                        uVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                                        return;
                                                    } else {
                                                        uVar3.g(e6);
                                                        return;
                                                    }
                                                }
                                                uVar3.d(null);
                                                return;
                                            case 3:
                                                u uVar4 = this.f84g;
                                                uVar4.getClass();
                                                if (i5 == -1 && (intent5 = intent) != null) {
                                                    ArrayList e7 = uVar4.e(intent5, true);
                                                    if (e7 == null) {
                                                        uVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                                        return;
                                                    } else {
                                                        uVar4.g(e7);
                                                        return;
                                                    }
                                                }
                                                uVar4.d(null);
                                                return;
                                            default:
                                                u uVar5 = this.f84g;
                                                uVar5.getClass();
                                                if (i5 == -1 && (intent6 = intent) != null) {
                                                    ArrayList e8 = uVar5.e(intent6, false);
                                                    if (e8 != null && e8.size() >= 1) {
                                                        uVar5.d(((s) e8.get(0)).f95a);
                                                        return;
                                                    } else {
                                                        uVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                                        return;
                                                    }
                                                }
                                                uVar5.d(null);
                                                return;
                                        }
                                    }
                                };
                                break;
                            default:
                                return false;
                        }
                    } else {
                        runnable = new o(this, i5, 1);
                    }
                } else {
                    final int i9 = 4;
                    runnable = new Runnable(this) { // from class: A2.n

                        /* renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ u f84g;

                        {
                            this.f84g = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Intent intent2;
                            Intent intent3;
                            Intent intent4;
                            Intent intent5;
                            Intent intent6;
                            switch (i9) {
                                case 0:
                                    u uVar = this.f84g;
                                    uVar.getClass();
                                    if (i5 == -1 && (intent2 = intent) != null) {
                                        ArrayList e4 = uVar.e(intent2, false);
                                        if (e4 == null) {
                                            uVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                            return;
                                        } else {
                                            uVar.g(e4);
                                            return;
                                        }
                                    }
                                    uVar.d(null);
                                    return;
                                case 1:
                                    u uVar2 = this.f84g;
                                    uVar2.getClass();
                                    if (i5 == -1 && (intent3 = intent) != null) {
                                        ArrayList e5 = uVar2.e(intent3, false);
                                        if (e5 == null) {
                                            uVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                            return;
                                        } else {
                                            uVar2.g(e5);
                                            return;
                                        }
                                    }
                                    uVar2.d(null);
                                    return;
                                case 2:
                                    u uVar3 = this.f84g;
                                    uVar3.getClass();
                                    if (i5 == -1 && (intent4 = intent) != null) {
                                        ArrayList e6 = uVar3.e(intent4, false);
                                        if (e6 == null) {
                                            uVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                            return;
                                        } else {
                                            uVar3.g(e6);
                                            return;
                                        }
                                    }
                                    uVar3.d(null);
                                    return;
                                case 3:
                                    u uVar4 = this.f84g;
                                    uVar4.getClass();
                                    if (i5 == -1 && (intent5 = intent) != null) {
                                        ArrayList e7 = uVar4.e(intent5, true);
                                        if (e7 == null) {
                                            uVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                            return;
                                        } else {
                                            uVar4.g(e7);
                                            return;
                                        }
                                    }
                                    uVar4.d(null);
                                    return;
                                default:
                                    u uVar5 = this.f84g;
                                    uVar5.getClass();
                                    if (i5 == -1 && (intent6 = intent) != null) {
                                        ArrayList e8 = uVar5.e(intent6, false);
                                        if (e8 != null && e8.size() >= 1) {
                                            uVar5.d(((s) e8.get(0)).f95a);
                                            return;
                                        } else {
                                            uVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                            return;
                                        }
                                    }
                                    uVar5.d(null);
                                    return;
                            }
                        }
                    };
                }
            } else {
                runnable = new o(this, i5, 0);
            }
        } else {
            final int i10 = 0;
            runnable = new Runnable(this) { // from class: A2.n

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ u f84g;

                {
                    this.f84g = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Intent intent2;
                    Intent intent3;
                    Intent intent4;
                    Intent intent5;
                    Intent intent6;
                    switch (i10) {
                        case 0:
                            u uVar = this.f84g;
                            uVar.getClass();
                            if (i5 == -1 && (intent2 = intent) != null) {
                                ArrayList e4 = uVar.e(intent2, false);
                                if (e4 == null) {
                                    uVar.b("no_valid_image_uri", "Cannot find the selected image.");
                                    return;
                                } else {
                                    uVar.g(e4);
                                    return;
                                }
                            }
                            uVar.d(null);
                            return;
                        case 1:
                            u uVar2 = this.f84g;
                            uVar2.getClass();
                            if (i5 == -1 && (intent3 = intent) != null) {
                                ArrayList e5 = uVar2.e(intent3, false);
                                if (e5 == null) {
                                    uVar2.b("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                                    return;
                                } else {
                                    uVar2.g(e5);
                                    return;
                                }
                            }
                            uVar2.d(null);
                            return;
                        case 2:
                            u uVar3 = this.f84g;
                            uVar3.getClass();
                            if (i5 == -1 && (intent4 = intent) != null) {
                                ArrayList e6 = uVar3.e(intent4, false);
                                if (e6 == null) {
                                    uVar3.b("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                                    return;
                                } else {
                                    uVar3.g(e6);
                                    return;
                                }
                            }
                            uVar3.d(null);
                            return;
                        case 3:
                            u uVar4 = this.f84g;
                            uVar4.getClass();
                            if (i5 == -1 && (intent5 = intent) != null) {
                                ArrayList e7 = uVar4.e(intent5, true);
                                if (e7 == null) {
                                    uVar4.b("no_valid_media_uri", "Cannot find the selected media.");
                                    return;
                                } else {
                                    uVar4.g(e7);
                                    return;
                                }
                            }
                            uVar4.d(null);
                            return;
                        default:
                            u uVar5 = this.f84g;
                            uVar5.getClass();
                            if (i5 == -1 && (intent6 = intent) != null) {
                                ArrayList e8 = uVar5.e(intent6, false);
                                if (e8 != null && e8.size() >= 1) {
                                    uVar5.d(((s) e8.get(0)).f95a);
                                    return;
                                } else {
                                    uVar5.b("no_valid_video_uri", "Cannot find the selected video.");
                                    return;
                                }
                            }
                            uVar5.d(null);
                            return;
                    }
                }
            };
        }
        this.f108m.execute(runnable);
        return true;
    }

    @Override // s2.InterfaceC0648t
    public final boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        boolean z;
        if (iArr.length > 0 && iArr[0] == 0) {
            z = true;
        } else {
            z = false;
        }
        if (i4 != 2345) {
            if (i4 != 2355) {
                return false;
            }
            if (z) {
                i();
            }
        } else if (z) {
            h();
        }
        if (!z && (i4 == 2345 || i4 == 2355)) {
            b("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }
}
