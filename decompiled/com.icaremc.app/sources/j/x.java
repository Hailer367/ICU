package j;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import t.C0661j;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public Object f5016a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5017b;

    public x(Context context) {
        this.f5016a = context;
    }

    public void c() {
        C2.h hVar = (C2.h) this.f5016a;
        if (hVar != null) {
            try {
                ((LayoutInflaterFactory2C0393A) this.f5017b).f4864p.unregisterReceiver(hVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f5016a = null;
        }
    }

    public abstract IntentFilter d();

    public abstract int e();

    public MenuItem f(MenuItem menuItem) {
        if (menuItem instanceof D.a) {
            D.a aVar = (D.a) menuItem;
            if (((C0661j) this.f5017b) == null) {
                this.f5017b = new C0661j(0);
            }
            MenuItem menuItem2 = (MenuItem) ((C0661j) this.f5017b).get(aVar);
            if (menuItem2 == null) {
                n.v vVar = new n.v((Context) this.f5016a, aVar);
                ((C0661j) this.f5017b).put(aVar, vVar);
                return vVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    public abstract void g();

    public void h() {
        c();
        IntentFilter d4 = d();
        if (d4.countActions() == 0) {
            return;
        }
        if (((C2.h) this.f5016a) == null) {
            this.f5016a = new C2.h(1, this);
        }
        ((LayoutInflaterFactory2C0393A) this.f5017b).f4864p.registerReceiver((C2.h) this.f5016a, d4);
    }

    public x(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A) {
        this.f5017b = layoutInflaterFactory2C0393A;
    }
}
