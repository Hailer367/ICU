package B;

import android.graphics.Typeface;
import androidx.appcompat.widget.ActionMenuView;
import java.lang.ref.WeakReference;
import l1.AbstractC0240s;
import l1.AbstractC0244w;
import m.C0258e;
import m.C0261h;
import m.C0271s;
import m.C0272t;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f33c;

    /* renamed from: d, reason: collision with root package name */
    public Object f34d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f35e;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f33c = i2;
        this.f34d = obj;
        this.f35e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f33c) {
            case 0:
                F.h hVar = (F.h) this.f34d;
                Typeface typeface = (Typeface) this.f35e;
                C0271s c0271s = (C0271s) hVar.f274d;
                if (c0271s != null) {
                    c0271s.b(typeface);
                    return;
                }
                return;
            case 1:
                ((i) this.f34d).accept(this.f35e);
                return;
            case 2:
                C0258e c0258e = (C0258e) this.f34d;
                C0261h c0261h = (C0261h) this.f35e;
                ActionMenuView actionMenuView = c0261h.f3157i;
                if (actionMenuView != null && actionMenuView.getWindowToken() != null) {
                    if (!c0258e.b()) {
                        if (c0258e.f2889e != null) {
                            c0258e.d(0, 0, false, false);
                        }
                    }
                    c0261h.f3166t = c0258e;
                }
                c0261h.f3168v = null;
                return;
            case 3:
                C0272t c0272t = (C0272t) ((WeakReference) this.f34d).get();
                if (c0272t != null) {
                    Typeface typeface2 = (Typeface) this.f35e;
                    if (c0272t.f3261m) {
                        c0272t.f3249a.setTypeface(typeface2);
                        c0272t.f3260l = typeface2;
                        return;
                    }
                    return;
                }
                return;
            default:
                q1.g gVar = (q1.g) this.f35e;
                AbstractC0240s abstractC0240s = gVar.f3521e;
                int i2 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f34d).run();
                    } catch (Throwable th) {
                        AbstractC0244w.d(T0.j.f774c, th);
                    }
                    Runnable i3 = gVar.i();
                    if (i3 != null) {
                        this.f34d = i3;
                        i2++;
                        if (i2 >= 16 && abstractC0240s.f(gVar)) {
                            abstractC0240s.e(gVar, this);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                break;
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i2, boolean z) {
        this.f33c = i2;
        this.f35e = obj;
        this.f34d = obj2;
    }
}
