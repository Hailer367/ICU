package o;

import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: o.D0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0468D0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final float f5431f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5432g;

    /* renamed from: h, reason: collision with root package name */
    public final int f5433h;

    /* renamed from: i, reason: collision with root package name */
    public final View f5434i;

    /* renamed from: j, reason: collision with root package name */
    public RunnableC0466C0 f5435j;
    public RunnableC0466C0 k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5436l;

    /* renamed from: m, reason: collision with root package name */
    public int f5437m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f5438n = new int[2];

    public AbstractViewOnTouchListenerC0468D0(View view) {
        this.f5434i = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f5431f = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f5432g = tapTimeout;
        this.f5433h = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        RunnableC0466C0 runnableC0466C0 = this.k;
        View view = this.f5434i;
        if (runnableC0466C0 != null) {
            view.removeCallbacks(runnableC0466C0);
        }
        RunnableC0466C0 runnableC0466C02 = this.f5435j;
        if (runnableC0466C02 != null) {
            view.removeCallbacks(runnableC0466C02);
        }
    }

    public abstract n.F b();

    public abstract boolean c();

    public boolean d() {
        n.F b4 = b();
        if (b4 != null && b4.b()) {
            b4.dismiss();
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.AbstractViewOnTouchListenerC0468D0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f5436l = false;
        this.f5437m = -1;
        RunnableC0466C0 runnableC0466C0 = this.f5435j;
        if (runnableC0466C0 != null) {
            this.f5434i.removeCallbacks(runnableC0466C0);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
