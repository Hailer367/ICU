package e;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0208o;
import androidx.lifecycle.C0214v;
import androidx.lifecycle.EnumC0206m;
import androidx.lifecycle.InterfaceC0212t;
import com.icaremc.app.R;
import i0.C0362e;
import i0.C0363f;
import i0.InterfaceC0364g;

/* loaded from: classes.dex */
public class n extends Dialog implements InterfaceC0212t, u, InterfaceC0364g {

    /* renamed from: f, reason: collision with root package name */
    public C0214v f3566f;

    /* renamed from: g, reason: collision with root package name */
    public final C0363f f3567g;

    /* renamed from: h, reason: collision with root package name */
    public final H2.g f3568h;

    /* renamed from: i, reason: collision with root package name */
    public final H2.g f3569i;

    public n(Context context, int i4) {
        super(context, i4);
        this.f3567g = new C0363f(this);
        final int i5 = 0;
        this.f3568h = new H2.g(new S2.a(this) { // from class: e.m

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ n f3565g;

            {
                this.f3565g = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, d0.e] */
            @Override // S2.a
            public final Object a() {
                switch (i5) {
                    case 0:
                        ?? obj = new Object();
                        this.f3565g.getOnBackPressedDispatcher().a().f3580c.a(obj);
                        return obj;
                    default:
                        return new t(new A.k(9, this.f3565g));
                }
            }
        });
        final int i6 = 1;
        this.f3569i = new H2.g(new S2.a(this) { // from class: e.m

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ n f3565g;

            {
                this.f3565g = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, d0.e] */
            @Override // S2.a
            public final Object a() {
                switch (i6) {
                    case 0:
                        ?? obj = new Object();
                        this.f3565g.getOnBackPressedDispatcher().a().f3580c.a(obj);
                        return obj;
                    default:
                        return new t(new A.k(9, this.f3565g));
                }
            }
        });
    }

    public static void a(n nVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        T2.h.e(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        T2.h.b(window);
        View decorView = window.getDecorView();
        T2.h.d(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        T2.h.b(window2);
        View decorView2 = window2.getDecorView();
        T2.h.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        T2.h.b(window3);
        View decorView3 = window3.getDecorView();
        T2.h.d(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        T2.h.b(window4);
        View decorView4 = window4.getDecorView();
        T2.h.d(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // androidx.lifecycle.InterfaceC0212t
    public final AbstractC0208o getLifecycle() {
        C0214v c0214v = this.f3566f;
        if (c0214v == null) {
            C0214v c0214v2 = new C0214v(this);
            this.f3566f = c0214v2;
            return c0214v2;
        }
        return c0214v;
    }

    @Override // e.u
    public final t getOnBackPressedDispatcher() {
        return (t) this.f3569i.a();
    }

    @Override // i0.InterfaceC0364g
    public final C0362e getSavedStateRegistry() {
        return this.f3567g.f4101b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((d0.a) this.f3568h.a()).a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            t onBackPressedDispatcher = getOnBackPressedDispatcher();
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            T2.h.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            onBackPressedDispatcher.b(onBackInvokedDispatcher);
        }
        this.f3567g.b(bundle);
        C0214v c0214v = this.f3566f;
        if (c0214v == null) {
            c0214v = new C0214v(this);
            this.f3566f = c0214v;
        }
        c0214v.e(EnumC0206m.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        T2.h.d(onSaveInstanceState, "onSaveInstanceState(...)");
        this.f3567g.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        C0214v c0214v = this.f3566f;
        if (c0214v == null) {
            c0214v = new C0214v(this);
            this.f3566f = c0214v;
        }
        c0214v.e(EnumC0206m.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        C0214v c0214v = this.f3566f;
        if (c0214v == null) {
            c0214v = new C0214v(this);
            this.f3566f = c0214v;
        }
        c0214v.e(EnumC0206m.ON_DESTROY);
        this.f3566f = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i4) {
        b();
        super.setContentView(i4);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        T2.h.e(view, "view");
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        T2.h.e(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}
