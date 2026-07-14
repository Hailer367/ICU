package l;

import E.J;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.icaremc.doctors.R;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2885a;

    /* renamed from: b, reason: collision with root package name */
    public final j f2886b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2887c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2888d;

    /* renamed from: e, reason: collision with root package name */
    public View f2889e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2891g;

    /* renamed from: h, reason: collision with root package name */
    public o f2892h;

    /* renamed from: i, reason: collision with root package name */
    public l f2893i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f2894j;

    /* renamed from: f, reason: collision with root package name */
    public int f2890f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final m f2895k = new m(this);

    public n(Context context, j jVar, View view, boolean z, int i2, int i3) {
        this.f2885a = context;
        this.f2886b = jVar;
        this.f2889e = view;
        this.f2887c = z;
        this.f2888d = i2;
    }

    public final l a() {
        l sVar;
        if (this.f2893i == null) {
            Context context = this.f2885a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                sVar = new g(context, this.f2889e, this.f2888d, this.f2887c);
            } else {
                sVar = new s(this.f2885a, this.f2886b, this.f2889e, this.f2888d, this.f2887c);
            }
            sVar.k(this.f2886b);
            sVar.q(this.f2895k);
            sVar.m(this.f2889e);
            sVar.d(this.f2892h);
            sVar.n(this.f2891g);
            sVar.o(this.f2890f);
            this.f2893i = sVar;
        }
        return this.f2893i;
    }

    public final boolean b() {
        l lVar = this.f2893i;
        if (lVar != null && lVar.i()) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f2893i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2894j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i2, int i3, boolean z, boolean z2) {
        l a2 = a();
        a2.r(z2);
        if (z) {
            int i4 = this.f2890f;
            View view = this.f2889e;
            Field field = J.f180a;
            if ((Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f2889e.getWidth();
            }
            a2.p(i2);
            a2.s(i3);
            int i5 = (int) ((this.f2885a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.f2883c = new Rect(i2 - i5, i3 - i5, i2 + i5, i3 + i5);
        }
        a2.show();
    }
}
