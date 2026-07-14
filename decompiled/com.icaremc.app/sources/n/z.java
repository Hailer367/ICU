package n;

import I.T;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.icaremc.app.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5361a;

    /* renamed from: b, reason: collision with root package name */
    public final n f5362b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5363c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5364d;

    /* renamed from: e, reason: collision with root package name */
    public View f5365e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5367g;

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC0448A f5368h;

    /* renamed from: i, reason: collision with root package name */
    public w f5369i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f5370j;

    /* renamed from: f, reason: collision with root package name */
    public int f5366f = 8388611;
    public final x k = new x(this);

    public z(Context context, n nVar, View view, boolean z, int i4, int i5) {
        this.f5361a = context;
        this.f5362b = nVar;
        this.f5365e = view;
        this.f5363c = z;
        this.f5364d = i4;
    }

    public final w a() {
        w g4;
        if (this.f5369i == null) {
            Context context = this.f5361a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            y.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                g4 = new ViewOnKeyListenerC0458h(context, this.f5365e, this.f5364d, this.f5363c);
            } else {
                g4 = new G(this.f5361a, this.f5362b, this.f5365e, this.f5364d, this.f5363c);
            }
            g4.l(this.f5362b);
            g4.r(this.k);
            g4.n(this.f5365e);
            g4.j(this.f5368h);
            g4.o(this.f5367g);
            g4.p(this.f5366f);
            this.f5369i = g4;
        }
        return this.f5369i;
    }

    public final boolean b() {
        w wVar = this.f5369i;
        if (wVar != null && wVar.b()) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f5369i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f5370j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i4, int i5, boolean z, boolean z3) {
        w a4 = a();
        a4.s(z3);
        if (z) {
            int i6 = this.f5366f;
            View view = this.f5365e;
            WeakHashMap weakHashMap = T.f702a;
            if ((Gravity.getAbsoluteGravity(i6, view.getLayoutDirection()) & 7) == 5) {
                i4 -= this.f5365e.getWidth();
            }
            a4.q(i4);
            a4.t(i5);
            int i7 = (int) ((this.f5361a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a4.f5359f = new Rect(i4 - i7, i5 - i7, i4 + i7, i5 + i7);
        }
        a4.c();
    }
}
