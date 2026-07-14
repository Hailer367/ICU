package n;

import I.T;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.icaremc.app.R;
import java.util.WeakHashMap;
import o.AbstractC0486M0;
import o.C0462A0;
import o.S0;

/* loaded from: classes.dex */
public final class G extends w implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: g, reason: collision with root package name */
    public final Context f5211g;

    /* renamed from: h, reason: collision with root package name */
    public final n f5212h;

    /* renamed from: i, reason: collision with root package name */
    public final k f5213i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5214j;
    public final int k;

    /* renamed from: l, reason: collision with root package name */
    public final int f5215l;

    /* renamed from: m, reason: collision with root package name */
    public final S0 f5216m;

    /* renamed from: n, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0454d f5217n;

    /* renamed from: o, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0455e f5218o;

    /* renamed from: p, reason: collision with root package name */
    public PopupWindow.OnDismissListener f5219p;

    /* renamed from: q, reason: collision with root package name */
    public View f5220q;

    /* renamed from: r, reason: collision with root package name */
    public View f5221r;

    /* renamed from: s, reason: collision with root package name */
    public InterfaceC0448A f5222s;

    /* renamed from: t, reason: collision with root package name */
    public ViewTreeObserver f5223t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5224u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5225v;

    /* renamed from: w, reason: collision with root package name */
    public int f5226w;

    /* renamed from: x, reason: collision with root package name */
    public int f5227x = 0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f5228y;

    /* JADX WARN: Type inference failed for: r6v1, types: [o.M0, o.S0] */
    public G(Context context, n nVar, View view, int i4, boolean z) {
        int i5 = 1;
        this.f5217n = new ViewTreeObserverOnGlobalLayoutListenerC0454d(i5, this);
        this.f5218o = new ViewOnAttachStateChangeListenerC0455e(this, i5);
        this.f5211g = context;
        this.f5212h = nVar;
        this.f5214j = z;
        this.f5213i = new k(nVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.f5215l = i4;
        Resources resources = context.getResources();
        this.k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f5220q = view;
        this.f5216m = new AbstractC0486M0(context, null, i4);
        nVar.b(this, context);
    }

    @Override // n.InterfaceC0449B
    public final void a(n nVar, boolean z) {
        if (nVar == this.f5212h) {
            dismiss();
            InterfaceC0448A interfaceC0448A = this.f5222s;
            if (interfaceC0448A != null) {
                interfaceC0448A.a(nVar, z);
            }
        }
    }

    @Override // n.F
    public final boolean b() {
        if (!this.f5224u && this.f5216m.f5480D.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // n.F
    public final void c() {
        View view;
        boolean z;
        Rect rect;
        if (b()) {
            return;
        }
        if (!this.f5224u && (view = this.f5220q) != null) {
            this.f5221r = view;
            S0 s02 = this.f5216m;
            s02.f5480D.setOnDismissListener(this);
            s02.f5495u = this;
            s02.f5479C = true;
            s02.f5480D.setFocusable(true);
            View view2 = this.f5221r;
            if (this.f5223t == null) {
                z = true;
            } else {
                z = false;
            }
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            this.f5223t = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f5217n);
            }
            view2.addOnAttachStateChangeListener(this.f5218o);
            s02.f5494t = view2;
            s02.f5491q = this.f5227x;
            boolean z3 = this.f5225v;
            Context context = this.f5211g;
            k kVar = this.f5213i;
            if (!z3) {
                this.f5226w = w.m(kVar, context, this.k);
                this.f5225v = true;
            }
            s02.r(this.f5226w);
            s02.f5480D.setInputMethodMode(2);
            Rect rect2 = this.f5359f;
            if (rect2 != null) {
                rect = new Rect(rect2);
            } else {
                rect = null;
            }
            s02.f5478B = rect;
            s02.c();
            C0462A0 c0462a0 = s02.f5483h;
            c0462a0.setOnKeyListener(this);
            if (this.f5228y) {
                n nVar = this.f5212h;
                if (nVar.f5305m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c0462a0, false);
                    TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                    if (textView != null) {
                        textView.setText(nVar.f5305m);
                    }
                    frameLayout.setEnabled(false);
                    c0462a0.addHeaderView(frameLayout, null, false);
                }
            }
            s02.p(kVar);
            s02.c();
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // n.InterfaceC0449B
    public final void d() {
        this.f5225v = false;
        k kVar = this.f5213i;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // n.F
    public final void dismiss() {
        if (b()) {
            this.f5216m.dismiss();
        }
    }

    @Override // n.F
    public final C0462A0 f() {
        return this.f5216m.f5483h;
    }

    @Override // n.InterfaceC0449B
    public final boolean h(H h3) {
        boolean z;
        if (h3.hasVisibleItems()) {
            z zVar = new z(this.f5211g, h3, this.f5221r, this.f5214j, this.f5215l, 0);
            InterfaceC0448A interfaceC0448A = this.f5222s;
            zVar.f5368h = interfaceC0448A;
            w wVar = zVar.f5369i;
            if (wVar != null) {
                wVar.j(interfaceC0448A);
            }
            int size = h3.f5299f.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    MenuItem item = h3.getItem(i4);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i4++;
                } else {
                    z = false;
                    break;
                }
            }
            zVar.f5367g = z;
            w wVar2 = zVar.f5369i;
            if (wVar2 != null) {
                wVar2.o(z);
            }
            zVar.f5370j = this.f5219p;
            this.f5219p = null;
            this.f5212h.c(false);
            S0 s02 = this.f5216m;
            int i5 = s02.k;
            int m3 = s02.m();
            int i6 = this.f5227x;
            View view = this.f5220q;
            WeakHashMap weakHashMap = T.f702a;
            if ((Gravity.getAbsoluteGravity(i6, view.getLayoutDirection()) & 7) == 5) {
                i5 += this.f5220q.getWidth();
            }
            if (!zVar.b()) {
                if (zVar.f5365e != null) {
                    zVar.d(i5, m3, true, true);
                }
            }
            InterfaceC0448A interfaceC0448A2 = this.f5222s;
            if (interfaceC0448A2 != null) {
                interfaceC0448A2.c(h3);
            }
            return true;
        }
        return false;
    }

    @Override // n.InterfaceC0449B
    public final boolean i() {
        return false;
    }

    @Override // n.InterfaceC0449B
    public final void j(InterfaceC0448A interfaceC0448A) {
        this.f5222s = interfaceC0448A;
    }

    @Override // n.w
    public final void n(View view) {
        this.f5220q = view;
    }

    @Override // n.w
    public final void o(boolean z) {
        this.f5213i.f5291h = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f5224u = true;
        this.f5212h.c(true);
        ViewTreeObserver viewTreeObserver = this.f5223t;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f5223t = this.f5221r.getViewTreeObserver();
            }
            this.f5223t.removeGlobalOnLayoutListener(this.f5217n);
            this.f5223t = null;
        }
        this.f5221r.removeOnAttachStateChangeListener(this.f5218o);
        PopupWindow.OnDismissListener onDismissListener = this.f5219p;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i4 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // n.w
    public final void p(int i4) {
        this.f5227x = i4;
    }

    @Override // n.w
    public final void q(int i4) {
        this.f5216m.k = i4;
    }

    @Override // n.w
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f5219p = onDismissListener;
    }

    @Override // n.w
    public final void s(boolean z) {
        this.f5228y = z;
    }

    @Override // n.w
    public final void t(int i4) {
        this.f5216m.i(i4);
    }

    @Override // n.w
    public final void l(n nVar) {
    }
}
