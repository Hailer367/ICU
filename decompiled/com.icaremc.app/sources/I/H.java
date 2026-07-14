package I;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class H {

    /* renamed from: a, reason: collision with root package name */
    public int f691a;

    /* renamed from: b, reason: collision with root package name */
    public int f692b;

    /* renamed from: c, reason: collision with root package name */
    public int f693c;

    /* renamed from: d, reason: collision with root package name */
    public Object f694d;

    /* JADX WARN: Type inference failed for: r0v1, types: [H1.f, java.lang.Object] */
    public H() {
        if (H1.f.f661g == null) {
            H1.f.f661g = new Object();
        }
    }

    public int a(int i4) {
        if (i4 < this.f693c) {
            return ((ByteBuffer) this.f694d).getShort(this.f692b + i4);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        C0048b c0048b;
        if (Build.VERSION.SDK_INT >= this.f692b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f692b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.f691a);
            if (!((Class) this.f694d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate d4 = T.d(view);
            if (d4 == null) {
                c0048b = null;
            } else if (d4 instanceof C0047a) {
                c0048b = ((C0047a) d4).f713a;
            } else {
                c0048b = new C0048b(d4);
            }
            if (c0048b == null) {
                c0048b = new C0048b();
            }
            T.i(view, c0048b);
            view.setTag(this.f691a, obj);
            T.f(view, this.f693c);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
