package x;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import io.flutter.plugin.platform.C0381e;
import java.util.ArrayList;

/* renamed from: x.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0700A extends B {

    /* renamed from: h, reason: collision with root package name */
    public boolean f6300h;

    /* renamed from: j, reason: collision with root package name */
    public IconCompat f6302j;
    public IconCompat k;

    /* renamed from: l, reason: collision with root package name */
    public IconCompat f6303l;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f6297e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f6298f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public int f6299g = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6301i = true;

    public static IconCompat e(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable instanceof Icon) {
                return IconCompat.b((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.d((Bitmap) parcelable);
            }
            return null;
        }
        return null;
    }

    @Override // x.B
    public final void a(Bundle bundle) {
        Context context;
        super.a(bundle);
        if (Build.VERSION.SDK_INT < 36) {
            ArrayList arrayList = this.f6297e;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    z zVar = (z) arrayList.get(i4);
                    if (zVar.f6438a > 0) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("length", zVar.f6438a);
                        bundle2.putInt("id", zVar.f6439b);
                        bundle2.putInt("colorInt", zVar.f6440c);
                        arrayList2.add(bundle2);
                    }
                }
            }
            bundle.putParcelableArrayList("android.progressSegments", arrayList2);
            ArrayList arrayList3 = this.f6298f;
            ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                    y yVar = (y) arrayList3.get(i5);
                    if (yVar.f6435a >= 0) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("position", yVar.f6435a);
                        bundle3.putInt("id", yVar.f6436b);
                        bundle3.putInt("colorInt", yVar.f6437c);
                        arrayList4.add(bundle3);
                    }
                }
            }
            bundle.putParcelableArrayList("android.progressPoints", arrayList4);
            bundle.putInt("android.progress", this.f6299g);
            bundle.putBoolean("android.progressIndeterminate", this.f6300h);
            bundle.putInt("android.progressMax", f());
            bundle.putBoolean("android.styledByProgress", this.f6301i);
            C0712l c0712l = this.f6304a;
            if (c0712l != null) {
                context = c0712l.f6391a;
            } else {
                context = null;
            }
            if (context != null) {
                IconCompat iconCompat = this.f6302j;
                if (iconCompat != null) {
                    bundle.putParcelable("android.progressTrackerIcon", iconCompat.h(context));
                } else {
                    bundle.remove("android.progressTrackerIcon");
                }
                IconCompat iconCompat2 = this.k;
                if (iconCompat2 != null) {
                    bundle.putParcelable("android.progressStartIcon", iconCompat2.h(context));
                } else {
                    bundle.remove("android.progressStartIcon");
                }
                IconCompat iconCompat3 = this.f6303l;
                if (iconCompat3 != null) {
                    bundle.putParcelable("android.progressEndIcon", iconCompat3.h(context));
                } else {
                    bundle.remove("android.progressEndIcon");
                }
            }
        }
    }

    @Override // x.B
    public final void b(C0381e c0381e) {
        Icon icon;
        Icon icon2;
        Notification.Builder builder = (Notification.Builder) c0381e.f4327c;
        if (Build.VERSION.SDK_INT >= 36) {
            Context context = c0381e.f4326b;
            Notification.ProgressStyle progressStyle = new Notification.ProgressStyle();
            x.h(progressStyle, this.f6301i);
            x.a(progressStyle, this.f6299g);
            x.c(progressStyle, this.f6300h);
            IconCompat iconCompat = this.k;
            Icon icon3 = null;
            if (iconCompat != null) {
                icon = iconCompat.h(context);
            } else {
                icon = null;
            }
            x.f(progressStyle, icon);
            IconCompat iconCompat2 = this.f6303l;
            if (iconCompat2 != null) {
                icon2 = iconCompat2.h(context);
            } else {
                icon2 = null;
            }
            x.b(progressStyle, icon2);
            IconCompat iconCompat3 = this.f6302j;
            if (iconCompat3 != null) {
                icon3 = iconCompat3.h(context);
            }
            x.g(progressStyle, icon3);
            x.d(progressStyle, this.f6298f);
            x.e(progressStyle, this.f6297e);
            builder.setStyle(progressStyle);
            return;
        }
        int f4 = f();
        builder.setProgress(f4, Math.min(this.f6299g, f4), this.f6300h);
    }

    @Override // x.B
    public final String c() {
        return "androidx.core.app.NotificationCompat$ProgressStyle";
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [x.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [x.y, java.lang.Object] */
    @Override // x.B
    public final void d(Bundle bundle) {
        ArrayList parcelableArrayList;
        ArrayList parcelableArrayList2;
        super.d(bundle);
        if (Build.VERSION.SDK_INT >= 34) {
            parcelableArrayList = E.c.b("android.progressSegments", bundle);
        } else {
            parcelableArrayList = bundle.getParcelableArrayList("android.progressSegments");
        }
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i4);
                int i5 = bundle2.getInt("length");
                if (i5 > 0) {
                    int i6 = bundle2.getInt("id");
                    int i7 = bundle2.getInt("colorInt", 0);
                    ?? obj = new Object();
                    obj.f6438a = i5;
                    obj.f6439b = i6;
                    obj.f6440c = i7;
                    arrayList.add(obj);
                }
            }
        }
        this.f6297e = arrayList;
        this.f6299g = bundle.getInt("android.progress", 0);
        this.f6300h = bundle.getBoolean("android.progressIndeterminate", false);
        this.f6301i = bundle.getBoolean("android.styledByProgress", true);
        if (Build.VERSION.SDK_INT >= 34) {
            parcelableArrayList2 = E.c.b("android.progressPoints", bundle);
        } else {
            parcelableArrayList2 = bundle.getParcelableArrayList("android.progressPoints");
        }
        ArrayList arrayList2 = new ArrayList();
        if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty()) {
            for (int i8 = 0; i8 < parcelableArrayList2.size(); i8++) {
                Bundle bundle3 = (Bundle) parcelableArrayList2.get(i8);
                int i9 = bundle3.getInt("position");
                if (i9 >= 0) {
                    int i10 = bundle3.getInt("id");
                    int i11 = bundle3.getInt("colorInt", 0);
                    ?? obj2 = new Object();
                    obj2.f6435a = i9;
                    obj2.f6436b = i10;
                    obj2.f6437c = i11;
                    arrayList2.add(obj2);
                }
            }
        }
        this.f6298f = arrayList2;
        this.f6302j = e((Parcelable) k3.b.j(bundle, "android.progressTrackerIcon", Icon.class));
        this.k = e((Parcelable) k3.b.j(bundle, "android.progressStartIcon", Icon.class));
        this.f6303l = e((Parcelable) k3.b.j(bundle, "android.progressEndIcon", Icon.class));
    }

    public final int f() {
        ArrayList arrayList = this.f6297e;
        if (arrayList != null && !arrayList.isEmpty()) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                int i7 = ((z) arrayList.get(i6)).f6438a;
                if (i7 > 0) {
                    try {
                        i5 = Math.addExact(i5, i7);
                        i4++;
                    } catch (ArithmeticException unused) {
                        return 100;
                    }
                }
            }
            if (i4 != 0) {
                return i5;
            }
        }
        return 100;
    }
}
