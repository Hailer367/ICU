package l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.icaremc.doctors.R;
import java.lang.reflect.Field;
import m.J;
import m.L;
import m.M;

/* loaded from: classes.dex */
public final class s extends l implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: d, reason: collision with root package name */
    public final Context f2896d;

    /* renamed from: e, reason: collision with root package name */
    public final j f2897e;

    /* renamed from: f, reason: collision with root package name */
    public final h f2898f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2899g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2900h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2901i;

    /* renamed from: j, reason: collision with root package name */
    public final M f2902j;

    /* renamed from: k, reason: collision with root package name */
    public final c f2903k;

    /* renamed from: l, reason: collision with root package name */
    public final d f2904l;

    /* renamed from: m, reason: collision with root package name */
    public PopupWindow.OnDismissListener f2905m;

    /* renamed from: n, reason: collision with root package name */
    public View f2906n;

    /* renamed from: o, reason: collision with root package name */
    public View f2907o;
    public o p;
    public ViewTreeObserver q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2908r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2909s;

    /* renamed from: t, reason: collision with root package name */
    public int f2910t;

    /* renamed from: u, reason: collision with root package name */
    public int f2911u = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2912v;

    /* JADX WARN: Type inference failed for: r6v1, types: [m.J, m.M] */
    public s(Context context, j jVar, View view, int i2, boolean z) {
        int i3 = 1;
        this.f2903k = new c(this, i3);
        this.f2904l = new d(this, i3);
        this.f2896d = context;
        this.f2897e = jVar;
        this.f2899g = z;
        this.f2898f = new h(jVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.f2901i = i2;
        Resources resources = context.getResources();
        this.f2900h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2906n = view;
        this.f2902j = new J(context, i2);
        jVar.b(this, context);
    }

    @Override // l.p
    public final void a(j jVar, boolean z) {
        if (jVar == this.f2897e) {
            dismiss();
            o oVar = this.p;
            if (oVar != null) {
                oVar.a(jVar, z);
            }
        }
    }

    @Override // l.p
    public final void b() {
        this.f2909s = false;
        h hVar = this.f2898f;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // l.r
    public final ListView c() {
        return this.f2902j.f3066e;
    }

    @Override // l.p
    public final void d(o oVar) {
        this.p = oVar;
    }

    @Override // l.r
    public final void dismiss() {
        if (i()) {
            this.f2902j.dismiss();
        }
    }

    @Override // l.p
    public final boolean g() {
        return false;
    }

    @Override // l.p
    public final boolean h(t tVar) {
        boolean z;
        int i2;
        if (tVar.hasVisibleItems()) {
            n nVar = new n(this.f2896d, tVar, this.f2907o, this.f2899g, this.f2901i, 0);
            o oVar = this.p;
            nVar.f2892h = oVar;
            l lVar = nVar.f2893i;
            if (lVar != null) {
                lVar.d(oVar);
            }
            int size = tVar.f2846f.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    MenuItem item = tVar.getItem(i3);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    z = false;
                    break;
                }
            }
            nVar.f2891g = z;
            l lVar2 = nVar.f2893i;
            if (lVar2 != null) {
                lVar2.n(z);
            }
            nVar.f2894j = this.f2905m;
            this.f2905m = null;
            this.f2897e.c(false);
            M m2 = this.f2902j;
            int i4 = m2.f3068g;
            if (!m2.f3070i) {
                i2 = 0;
            } else {
                i2 = m2.f3069h;
            }
            int i5 = this.f2911u;
            View view = this.f2906n;
            Field field = E.J.f180a;
            if ((Gravity.getAbsoluteGravity(i5, view.getLayoutDirection()) & 7) == 5) {
                i4 += this.f2906n.getWidth();
            }
            if (!nVar.b()) {
                if (nVar.f2889e != null) {
                    nVar.d(i4, i2, true, true);
                }
            }
            o oVar2 = this.p;
            if (oVar2 != null) {
                oVar2.c(tVar);
            }
            return true;
        }
        return false;
    }

    @Override // l.r
    public final boolean i() {
        if (!this.f2908r && this.f2902j.f3083x.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // l.l
    public final void m(View view) {
        this.f2906n = view;
    }

    @Override // l.l
    public final void n(boolean z) {
        this.f2898f.f2836e = z;
    }

    @Override // l.l
    public final void o(int i2) {
        this.f2911u = i2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2908r = true;
        this.f2897e.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.f2907o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.f2903k);
            this.q = null;
        }
        this.f2907o.removeOnAttachStateChangeListener(this.f2904l);
        PopupWindow.OnDismissListener onDismissListener = this.f2905m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i2 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // l.l
    public final void p(int i2) {
        this.f2902j.f3068g = i2;
    }

    @Override // l.l
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.f2905m = onDismissListener;
    }

    @Override // l.l
    public final void r(boolean z) {
        this.f2912v = z;
    }

    @Override // l.l
    public final void s(int i2) {
        M m2 = this.f2902j;
        m2.f3069h = i2;
        m2.f3070i = true;
    }

    @Override // l.r
    public final void show() {
        View view;
        boolean z;
        Rect rect;
        if (i()) {
            return;
        }
        if (!this.f2908r && (view = this.f2906n) != null) {
            this.f2907o = view;
            M m2 = this.f2902j;
            m2.f3083x.setOnDismissListener(this);
            m2.f3076o = this;
            m2.f3082w = true;
            m2.f3083x.setFocusable(true);
            View view2 = this.f2907o;
            if (this.q == null) {
                z = true;
            } else {
                z = false;
            }
            ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
            this.q = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f2903k);
            }
            view2.addOnAttachStateChangeListener(this.f2904l);
            m2.f3075n = view2;
            m2.f3073l = this.f2911u;
            boolean z2 = this.f2909s;
            Context context = this.f2896d;
            h hVar = this.f2898f;
            if (!z2) {
                this.f2910t = l.l(hVar, context, this.f2900h);
                this.f2909s = true;
            }
            int i2 = this.f2910t;
            Rect rect2 = m2.f3080u;
            Drawable background = m2.f3083x.getBackground();
            if (background != null) {
                background.getPadding(rect2);
                m2.f3067f = rect2.left + rect2.right + i2;
            } else {
                m2.f3067f = i2;
            }
            m2.f3083x.setInputMethodMode(2);
            Rect rect3 = this.f2883c;
            if (rect3 != null) {
                rect = new Rect(rect3);
            } else {
                rect = null;
            }
            m2.f3081v = rect;
            m2.show();
            L l2 = m2.f3066e;
            l2.setOnKeyListener(this);
            if (this.f2912v) {
                j jVar = this.f2897e;
                if (jVar.f2852l != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) l2, false);
                    TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                    if (textView != null) {
                        textView.setText(jVar.f2852l);
                    }
                    frameLayout.setEnabled(false);
                    l2.addHeaderView(frameLayout, null, false);
                }
            }
            m2.a(hVar);
            m2.show();
            return;
        }
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // l.l
    public final void k(j jVar) {
    }
}
