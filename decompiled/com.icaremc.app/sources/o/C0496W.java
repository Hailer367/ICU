package o;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: o.W, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0496W {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5534a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5535b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WeakReference f5536c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0507c0 f5537d;

    public C0496W(C0507c0 c0507c0, int i4, int i5, WeakReference weakReference) {
        this.f5537d = c0507c0;
        this.f5534a = i4;
        this.f5535b = i5;
        this.f5536c = weakReference;
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).post(new A.k(0, this));
    }

    public final void b(Typeface typeface) {
        int i4;
        boolean z;
        if (Build.VERSION.SDK_INT >= 28 && (i4 = this.f5534a) != -1) {
            if ((this.f5535b & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            typeface = AbstractC0504b0.a(typeface, i4, z);
        }
        C0507c0 c0507c0 = this.f5537d;
        if (c0507c0.f5572m) {
            c0507c0.f5571l = typeface;
            TextView textView = (TextView) this.f5536c.get();
            if (textView != null) {
                WeakHashMap weakHashMap = I.T.f702a;
                if (textView.isAttachedToWindow()) {
                    textView.post(new RunnableC0497X(textView, typeface, c0507c0.f5570j));
                } else {
                    textView.setTypeface(typeface, c0507c0.f5570j);
                }
            }
        }
    }
}
