package j;

import I.InterfaceC0066u;
import I.T;
import I.a0;
import I.b0;
import I.c0;
import I.d0;
import I.e0;
import I.f0;
import I.g0;
import I.h0;
import I.r0;
import I.v0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.icaremc.app.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import n.InterfaceC0448A;
import o.E1;

/* renamed from: j.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0422q implements InterfaceC0066u, InterfaceC0448A {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LayoutInflaterFactory2C0393A f5004f;

    public /* synthetic */ C0422q(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A) {
        this.f5004f = layoutInflaterFactory2C0393A;
    }

    @Override // n.InterfaceC0448A
    public void a(n.n nVar, boolean z) {
        this.f5004f.s(nVar);
    }

    @Override // n.InterfaceC0448A
    public boolean c(n.n nVar) {
        Window.Callback callback = this.f5004f.f4865q.getCallback();
        if (callback != null) {
            callback.onMenuOpened(108, nVar);
            return true;
        }
        return true;
    }

    @Override // I.InterfaceC0066u
    public v0 d(View view, v0 v0Var) {
        int i4;
        boolean z;
        v0 v0Var2;
        h0 a0Var;
        int i5;
        boolean z3;
        int i6;
        int i7;
        boolean z4;
        boolean z5;
        int color;
        r0 r0Var = v0Var.f788a;
        int i8 = r0Var.l().f125b;
        LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A = this.f5004f;
        Context context = layoutInflaterFactory2C0393A.f4864p;
        int i9 = r0Var.l().f125b;
        ActionBarContextView actionBarContextView = layoutInflaterFactory2C0393A.f4826A;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutInflaterFactory2C0393A.f4826A.getLayoutParams();
            if (layoutInflaterFactory2C0393A.f4826A.isShown()) {
                if (layoutInflaterFactory2C0393A.f4858h0 == null) {
                    layoutInflaterFactory2C0393A.f4858h0 = new Rect();
                    layoutInflaterFactory2C0393A.f4859i0 = new Rect();
                }
                Rect rect = layoutInflaterFactory2C0393A.f4858h0;
                Rect rect2 = layoutInflaterFactory2C0393A.f4859i0;
                rect.set(r0Var.l().f124a, r0Var.l().f125b, r0Var.l().f126c, r0Var.l().f127d);
                ViewGroup viewGroup = layoutInflaterFactory2C0393A.f4831F;
                Method method = E1.f5440a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e4) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e4);
                    }
                }
                int i10 = rect.top;
                int i11 = rect.left;
                int i12 = rect.right;
                ViewGroup viewGroup2 = layoutInflaterFactory2C0393A.f4831F;
                WeakHashMap weakHashMap = T.f702a;
                v0 a4 = I.L.a(viewGroup2);
                if (a4 == null) {
                    i6 = 0;
                } else {
                    i6 = a4.f788a.l().f124a;
                }
                if (a4 == null) {
                    i7 = 0;
                } else {
                    i7 = a4.f788a.l().f126c;
                }
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z4 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z4 = true;
                }
                if (i10 > 0 && layoutInflaterFactory2C0393A.f4833H == null) {
                    View view2 = new View(context);
                    layoutInflaterFactory2C0393A.f4833H = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i6;
                    layoutParams.rightMargin = i7;
                    layoutInflaterFactory2C0393A.f4831F.addView(layoutInflaterFactory2C0393A.f4833H, -1, layoutParams);
                } else {
                    View view3 = layoutInflaterFactory2C0393A.f4833H;
                    if (view3 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != i6 || marginLayoutParams2.rightMargin != i7) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = i6;
                            marginLayoutParams2.rightMargin = i7;
                            layoutInflaterFactory2C0393A.f4833H.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view4 = layoutInflaterFactory2C0393A.f4833H;
                if (view4 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5 && view4.getVisibility() != 0) {
                    View view5 = layoutInflaterFactory2C0393A.f4833H;
                    if ((view5.getWindowSystemUiVisibility() & 8192) != 0) {
                        color = context.getColor(R.color.abc_decor_view_status_guard_light);
                    } else {
                        color = context.getColor(R.color.abc_decor_view_status_guard);
                    }
                    view5.setBackgroundColor(color);
                }
                if (!layoutInflaterFactory2C0393A.f4838M && z5) {
                    i9 = 0;
                }
                z3 = z4;
                z = z5;
                i4 = 0;
            } else {
                i4 = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                    z3 = true;
                } else {
                    z = false;
                    z3 = false;
                }
            }
            if (z3) {
                layoutInflaterFactory2C0393A.f4826A.setLayoutParams(marginLayoutParams);
            }
        } else {
            i4 = 0;
            z = false;
        }
        View view6 = layoutInflaterFactory2C0393A.f4833H;
        if (view6 != null) {
            if (z) {
                i5 = i4;
            } else {
                i5 = 8;
            }
            view6.setVisibility(i5);
        }
        if (i8 != i9) {
            int i15 = r0Var.l().f124a;
            int i16 = r0Var.l().f126c;
            int i17 = r0Var.l().f127d;
            int i18 = Build.VERSION.SDK_INT;
            if (i18 >= 36) {
                a0Var = new g0(v0Var);
            } else if (i18 >= 35) {
                a0Var = new f0(v0Var);
            } else if (i18 >= 34) {
                a0Var = new e0(v0Var);
            } else if (i18 >= 31) {
                a0Var = new d0(v0Var);
            } else if (i18 >= 30) {
                a0Var = new c0(v0Var);
            } else if (i18 >= 29) {
                a0Var = new b0(v0Var);
            } else {
                a0Var = new a0(v0Var);
            }
            a0Var.h(B.c.b(i15, i9, i16, i17));
            v0Var2 = a0Var.b();
        } else {
            v0Var2 = v0Var;
        }
        WeakHashMap weakHashMap2 = T.f702a;
        WindowInsets b4 = v0Var2.b();
        if (b4 != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(b4);
            if (!onApplyWindowInsets.equals(b4)) {
                return v0.c(onApplyWindowInsets, view);
            }
            return v0Var2;
        }
        return v0Var2;
    }
}
