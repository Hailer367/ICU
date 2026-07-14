package u;

import a.AbstractC0051a;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class y extends z {

    /* renamed from: h, reason: collision with root package name */
    public boolean f3799h;

    /* renamed from: j, reason: collision with root package name */
    public IconCompat f3801j;

    /* renamed from: k, reason: collision with root package name */
    public IconCompat f3802k;

    /* renamed from: l, reason: collision with root package name */
    public IconCompat f3803l;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3796e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3797f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public int f3798g = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3800i = true;

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

    @Override // u.z
    public final void a(Bundle bundle) {
        Context context;
        super.a(bundle);
        if (Build.VERSION.SDK_INT < 36) {
            ArrayList arrayList = this.f3796e;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    x xVar = (x) arrayList.get(i2);
                    if (xVar.f3793a > 0) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("length", xVar.f3793a);
                        bundle2.putInt("id", xVar.f3794b);
                        bundle2.putInt("colorInt", xVar.f3795c);
                        arrayList2.add(bundle2);
                    }
                }
            }
            bundle.putParcelableArrayList("android.progressSegments", arrayList2);
            ArrayList arrayList3 = this.f3797f;
            ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                    w wVar = (w) arrayList3.get(i3);
                    if (wVar.f3790a >= 0) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("position", wVar.f3790a);
                        bundle3.putInt("id", wVar.f3791b);
                        bundle3.putInt("colorInt", wVar.f3792c);
                        arrayList4.add(bundle3);
                    }
                }
            }
            bundle.putParcelableArrayList("android.progressPoints", arrayList4);
            bundle.putInt("android.progress", this.f3798g);
            bundle.putBoolean("android.progressIndeterminate", this.f3799h);
            bundle.putInt("android.progressMax", f());
            bundle.putBoolean("android.styledByProgress", this.f3800i);
            C0319j c0319j = this.f3804a;
            if (c0319j != null) {
                context = c0319j.f3747a;
            } else {
                context = null;
            }
            if (context != null) {
                IconCompat iconCompat = this.f3801j;
                if (iconCompat != null) {
                    bundle.putParcelable("android.progressTrackerIcon", iconCompat.h(context));
                } else {
                    bundle.remove("android.progressTrackerIcon");
                }
                IconCompat iconCompat2 = this.f3802k;
                if (iconCompat2 != null) {
                    bundle.putParcelable("android.progressStartIcon", iconCompat2.h(context));
                } else {
                    bundle.remove("android.progressStartIcon");
                }
                IconCompat iconCompat3 = this.f3803l;
                if (iconCompat3 != null) {
                    bundle.putParcelable("android.progressEndIcon", iconCompat3.h(context));
                } else {
                    bundle.remove("android.progressEndIcon");
                }
            }
        }
    }

    @Override // u.z
    public final void b(C0308C c0308c) {
        Icon icon;
        Icon icon2;
        Notification.Builder builder = c0308c.f3674b;
        if (Build.VERSION.SDK_INT >= 36) {
            Context context = c0308c.f3673a;
            Notification.ProgressStyle progressStyle = new Notification.ProgressStyle();
            v.h(progressStyle, this.f3800i);
            v.a(progressStyle, this.f3798g);
            v.c(progressStyle, this.f3799h);
            IconCompat iconCompat = this.f3802k;
            Icon icon3 = null;
            if (iconCompat != null) {
                icon = iconCompat.h(context);
            } else {
                icon = null;
            }
            v.f(progressStyle, icon);
            IconCompat iconCompat2 = this.f3803l;
            if (iconCompat2 != null) {
                icon2 = iconCompat2.h(context);
            } else {
                icon2 = null;
            }
            v.b(progressStyle, icon2);
            IconCompat iconCompat3 = this.f3801j;
            if (iconCompat3 != null) {
                icon3 = iconCompat3.h(context);
            }
            v.g(progressStyle, icon3);
            v.d(progressStyle, this.f3797f);
            v.e(progressStyle, this.f3796e);
            builder.setStyle(progressStyle);
            return;
        }
        int f2 = f();
        builder.setProgress(f2, Math.min(this.f3798g, f2), this.f3799h);
    }

    @Override // u.z
    public final String c() {
        return "androidx.core.app.NotificationCompat$ProgressStyle";
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, u.x] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, u.w] */
    @Override // u.z
    public final void d(Bundle bundle) {
        ArrayList parcelableArrayList;
        ArrayList parcelableArrayList2;
        super.d(bundle);
        if (Build.VERSION.SDK_INT >= 34) {
            parcelableArrayList = A.d.b(bundle, "android.progressSegments");
        } else {
            parcelableArrayList = bundle.getParcelableArrayList("android.progressSegments");
        }
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i2);
                int i3 = bundle2.getInt("length");
                if (i3 > 0) {
                    int i4 = bundle2.getInt("id");
                    int i5 = bundle2.getInt("colorInt", 0);
                    ?? obj = new Object();
                    obj.f3793a = i3;
                    obj.f3794b = i4;
                    obj.f3795c = i5;
                    arrayList.add(obj);
                }
            }
        }
        this.f3796e = arrayList;
        this.f3798g = bundle.getInt("android.progress", 0);
        this.f3799h = bundle.getBoolean("android.progressIndeterminate", false);
        this.f3800i = bundle.getBoolean("android.styledByProgress", true);
        if (Build.VERSION.SDK_INT >= 34) {
            parcelableArrayList2 = A.d.b(bundle, "android.progressPoints");
        } else {
            parcelableArrayList2 = bundle.getParcelableArrayList("android.progressPoints");
        }
        ArrayList arrayList2 = new ArrayList();
        if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty()) {
            for (int i6 = 0; i6 < parcelableArrayList2.size(); i6++) {
                Bundle bundle3 = (Bundle) parcelableArrayList2.get(i6);
                int i7 = bundle3.getInt("position");
                if (i7 >= 0) {
                    int i8 = bundle3.getInt("id");
                    int i9 = bundle3.getInt("colorInt", 0);
                    ?? obj2 = new Object();
                    obj2.f3790a = i7;
                    obj2.f3791b = i8;
                    obj2.f3792c = i9;
                    arrayList2.add(obj2);
                }
            }
        }
        this.f3797f = arrayList2;
        this.f3801j = e((Parcelable) AbstractC0051a.z(bundle, "android.progressTrackerIcon", Icon.class));
        this.f3802k = e((Parcelable) AbstractC0051a.z(bundle, "android.progressStartIcon", Icon.class));
        this.f3803l = e((Parcelable) AbstractC0051a.z(bundle, "android.progressEndIcon", Icon.class));
    }

    public final int f() {
        ArrayList arrayList = this.f3796e;
        if (arrayList != null && !arrayList.isEmpty()) {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                int i5 = ((x) arrayList.get(i4)).f3793a;
                if (i5 > 0) {
                    try {
                        i3 = Math.addExact(i3, i5);
                        i2++;
                    } catch (ArithmeticException unused) {
                        return 100;
                    }
                }
            }
            if (i2 != 0) {
                return i3;
            }
        }
        return 100;
    }
}
