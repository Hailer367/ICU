package I;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import java.util.List;
import java.util.Locale;

/* renamed from: I.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0050d implements InterfaceC0049c, InterfaceC0051e {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f724f;

    /* renamed from: g, reason: collision with root package name */
    public Object f725g;

    /* renamed from: h, reason: collision with root package name */
    public int f726h;

    /* renamed from: i, reason: collision with root package name */
    public int f727i;

    /* renamed from: j, reason: collision with root package name */
    public Comparable f728j;
    public Object k;

    public /* synthetic */ C0050d() {
        this.f724f = 0;
    }

    public static String d(u1.f fVar) {
        fVar.a();
        u1.g gVar = fVar.f6223c;
        String str = gVar.f6235e;
        if (str != null) {
            return str;
        }
        fVar.a();
        String str2 = gVar.f6232b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] split = str2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public synchronized String a() {
        try {
            if (((String) this.f728j) == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f728j;
    }

    @Override // I.InterfaceC0051e
    public ClipData b() {
        return (ClipData) this.f725g;
    }

    @Override // I.InterfaceC0049c
    public C0052f build() {
        return new C0052f(new C0050d(this));
    }

    @Override // I.InterfaceC0049c
    public void c(Uri uri) {
        this.f728j = uri;
    }

    @Override // I.InterfaceC0049c
    public void e(int i4) {
        this.f727i = i4;
    }

    public PackageInfo f(String str) {
        try {
            return ((Context) this.f725g).getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e4) {
            Log.w("FirebaseMessaging", "Failed to find package " + e4);
            return null;
        }
    }

    public boolean g() {
        int i4;
        synchronized (this) {
            i4 = this.f727i;
            if (i4 == 0) {
                PackageManager packageManager = ((Context) this.f725g).getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
                    i4 = 0;
                } else {
                    if (!d1.b.b()) {
                        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                        intent.setPackage("com.google.android.gms");
                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            this.f727i = 1;
                            i4 = 1;
                        }
                    }
                    Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
                    if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                        this.f727i = 2;
                        i4 = 2;
                    } else {
                        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
                        if (d1.b.b()) {
                            this.f727i = 2;
                        } else {
                            this.f727i = 1;
                        }
                        i4 = this.f727i;
                    }
                }
            }
        }
        if (i4 != 0) {
            return true;
        }
        return false;
    }

    public synchronized void h() {
        PackageInfo f4 = f(((Context) this.f725g).getPackageName());
        if (f4 != null) {
            this.f728j = Integer.toString(f4.versionCode);
            this.k = f4.versionName;
        }
    }

    @Override // I.InterfaceC0051e
    public int i() {
        return this.f727i;
    }

    @Override // I.InterfaceC0051e
    public ContentInfo l() {
        return null;
    }

    @Override // I.InterfaceC0051e
    public int q() {
        return this.f726h;
    }

    @Override // I.InterfaceC0049c
    public void setExtras(Bundle bundle) {
        this.k = bundle;
    }

    public String toString() {
        String str;
        String valueOf;
        String str2;
        switch (this.f724f) {
            case 1:
                Uri uri = (Uri) this.f728j;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.f725g).getDescription());
                sb.append(", source=");
                int i4 = this.f726h;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 != 4) {
                                    if (i4 != 5) {
                                        str = String.valueOf(i4);
                                    } else {
                                        str = "SOURCE_PROCESS_TEXT";
                                    }
                                } else {
                                    str = "SOURCE_AUTOFILL";
                                }
                            } else {
                                str = "SOURCE_DRAG_AND_DROP";
                            }
                        } else {
                            str = "SOURCE_INPUT_METHOD";
                        }
                    } else {
                        str = "SOURCE_CLIPBOARD";
                    }
                } else {
                    str = "SOURCE_APP";
                }
                sb.append(str);
                sb.append(", flags=");
                int i5 = this.f727i;
                if ((i5 & 1) != 0) {
                    valueOf = "FLAG_CONVERT_TO_PLAIN_TEXT";
                } else {
                    valueOf = String.valueOf(i5);
                }
                sb.append(valueOf);
                String str3 = "";
                if (uri == null) {
                    str2 = "";
                } else {
                    str2 = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str2);
                if (((Bundle) this.k) != null) {
                    str3 = ", hasExtras";
                }
                return r2.k.c(sb, str3, "}");
            default:
                return super.toString();
        }
    }

    public C0050d(Context context) {
        this.f724f = 2;
        this.f727i = 0;
        this.f725g = context;
    }

    public C0050d(C0050d c0050d) {
        this.f724f = 1;
        ClipData clipData = (ClipData) c0050d.f725g;
        clipData.getClass();
        this.f725g = clipData;
        int i4 = c0050d.f726h;
        if (i4 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i4 <= 5) {
            this.f726h = i4;
            int i5 = c0050d.f727i;
            if ((i5 & 1) == i5) {
                this.f727i = i5;
                this.f728j = (Uri) c0050d.f728j;
                this.k = (Bundle) c0050d.k;
                return;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i5) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
    }
}
