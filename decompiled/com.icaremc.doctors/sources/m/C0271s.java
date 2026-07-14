package m;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* renamed from: m.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0271s {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f3245a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3246b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3247c;

    public C0271s(C0272t c0272t, int i2, int i3) {
        this.f3245a = new WeakReference(c0272t);
        this.f3246b = i2;
        this.f3247c = i3;
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).post(new B0.o(7, this));
    }

    public final void b(Typeface typeface) {
        int i2;
        boolean z;
        WeakReference weakReference = this.f3245a;
        C0272t c0272t = (C0272t) weakReference.get();
        if (c0272t == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f3246b) != -1) {
            if ((this.f3247c & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            typeface = Typeface.create(typeface, i2, z);
        }
        c0272t.f3249a.post(new B.a(3, weakReference, typeface));
    }
}
