package d;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0146p;
import androidx.lifecycle.C0152w;
import androidx.lifecycle.EnumC0144n;
import androidx.lifecycle.InterfaceC0150u;
import b0.C0163e;
import b0.C0164f;
import b0.InterfaceC0165g;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public final class m extends Dialog implements InterfaceC0150u, u, InterfaceC0165g {

    /* renamed from: c, reason: collision with root package name */
    public C0152w f2132c;

    /* renamed from: d, reason: collision with root package name */
    public final C0164f f2133d;

    /* renamed from: e, reason: collision with root package name */
    public final Q0.h f2134e;

    /* renamed from: f, reason: collision with root package name */
    public final Q0.h f2135f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, int i2) {
        super(context, i2);
        kotlin.jvm.internal.h.e(context, "context");
        this.f2133d = new C0164f(this);
        final int i3 = 0;
        this.f2134e = new Q0.h(new c1.a(this) { // from class: d.l

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ m f2131d;

            {
                this.f2131d = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, W.f] */
            @Override // c1.a
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        ?? obj = new Object();
                        this.f2131d.getOnBackPressedDispatcher().b().f2149c.a(obj);
                        return obj;
                    default:
                        return new t(new B0.o(4, this.f2131d));
                }
            }
        });
        final int i4 = 1;
        this.f2135f = new Q0.h(new c1.a(this) { // from class: d.l

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ m f2131d;

            {
                this.f2131d = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, W.f] */
            @Override // c1.a
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        ?? obj = new Object();
                        this.f2131d.getOnBackPressedDispatcher().b().f2149c.a(obj);
                        return obj;
                    default:
                        return new t(new B0.o(4, this.f2131d));
                }
            }
        });
    }

    public static void a(m mVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.h.e(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        kotlin.jvm.internal.h.b(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.h.d(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.h.b(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.h.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.h.b(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.h.d(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        kotlin.jvm.internal.h.b(window4);
        View decorView4 = window4.getDecorView();
        kotlin.jvm.internal.h.d(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // androidx.lifecycle.InterfaceC0150u
    public final AbstractC0146p getLifecycle() {
        C0152w c0152w = this.f2132c;
        if (c0152w == null) {
            C0152w c0152w2 = new C0152w(this);
            this.f2132c = c0152w2;
            return c0152w2;
        }
        return c0152w;
    }

    @Override // d.u
    public final t getOnBackPressedDispatcher() {
        return (t) this.f2135f.a();
    }

    @Override // b0.InterfaceC0165g
    public final C0163e getSavedStateRegistry() {
        return this.f2133d.f1980b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((W.a) this.f2134e.a()).a();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            t onBackPressedDispatcher = getOnBackPressedDispatcher();
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.h.d(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            onBackPressedDispatcher.c(onBackInvokedDispatcher);
        }
        this.f2133d.b(bundle);
        C0152w c0152w = this.f2132c;
        if (c0152w == null) {
            c0152w = new C0152w(this);
            this.f2132c = c0152w;
        }
        c0152w.e(EnumC0144n.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.h.d(onSaveInstanceState, "onSaveInstanceState(...)");
        this.f2133d.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        C0152w c0152w = this.f2132c;
        if (c0152w == null) {
            c0152w = new C0152w(this);
            this.f2132c = c0152w;
        }
        c0152w.e(EnumC0144n.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        C0152w c0152w = this.f2132c;
        if (c0152w == null) {
            c0152w = new C0152w(this);
            this.f2132c = c0152w;
        }
        c0152w.e(EnumC0144n.ON_DESTROY);
        this.f2132c = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public final void setContentView(int i2) {
        b();
        super.setContentView(i2);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        kotlin.jvm.internal.h.e(view, "view");
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.h.e(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}
