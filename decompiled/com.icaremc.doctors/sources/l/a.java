package l;

import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.view.menu.ActionMenuItemView;
import m.C0258e;
import m.C0259f;
import m.C0260g;
import m.RunnableC0250C;

/* loaded from: classes.dex */
public final class a implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final float f2791c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2792d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2793e;

    /* renamed from: f, reason: collision with root package name */
    public final View f2794f;

    /* renamed from: g, reason: collision with root package name */
    public RunnableC0250C f2795g;

    /* renamed from: h, reason: collision with root package name */
    public RunnableC0250C f2796h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2797i;

    /* renamed from: j, reason: collision with root package name */
    public int f2798j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f2799k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f2800l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f2801m;

    public a(View view) {
        this.f2799k = new int[2];
        this.f2794f = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2791c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2792d = tapTimeout;
        this.f2793e = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        RunnableC0250C runnableC0250C = this.f2796h;
        View view = this.f2794f;
        if (runnableC0250C != null) {
            view.removeCallbacks(runnableC0250C);
        }
        RunnableC0250C runnableC0250C2 = this.f2795g;
        if (runnableC0250C2 != null) {
            view.removeCallbacks(runnableC0250C2);
        }
    }

    public final l b() {
        C0258e c0258e;
        switch (this.f2800l) {
            case 0:
                b bVar = ((ActionMenuItemView) this.f2801m).f1063l;
                if (bVar != null && (c0258e = ((C0259f) bVar).f3141a.f3167u) != null) {
                    return c0258e.a();
                }
                return null;
            default:
                C0258e c0258e2 = ((C0260g) this.f2801m).f3149e.f3166t;
                if (c0258e2 == null) {
                    return null;
                }
                return c0258e2.a();
        }
    }

    public final boolean c() {
        l b2;
        switch (this.f2800l) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f2801m;
                i iVar = actionMenuItemView.f1061j;
                if (iVar != null && iVar.a(actionMenuItemView.f1058g) && (b2 = b()) != null && b2.i()) {
                    return true;
                }
                return false;
            default:
                ((C0260g) this.f2801m).f3149e.k();
                return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        if (r14 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009f, code lost:
    
        if (r4 != 3) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f2797i = false;
        this.f2798j = -1;
        RunnableC0250C runnableC0250C = this.f2795g;
        if (runnableC0250C != null) {
            this.f2794f.removeCallbacks(runnableC0250C);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(ActionMenuItemView actionMenuItemView) {
        this((View) actionMenuItemView);
        this.f2800l = 0;
        this.f2801m = actionMenuItemView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(C0260g c0260g, C0260g c0260g2) {
        this(c0260g2);
        this.f2800l = 1;
        this.f2801m = c0260g;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
