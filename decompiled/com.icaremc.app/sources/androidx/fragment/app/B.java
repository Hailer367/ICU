package androidx.fragment.app;

import I.v0;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.icaremc.app.R;
import j.AbstractActivityC0416k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class B extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2711f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2712g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f2713h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2714i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(Context context, AttributeSet attributeSet, P p3) {
        super(context, attributeSet);
        AbstractActivityC0416k abstractActivityC0416k;
        String str;
        T2.h.e(context, "context");
        T2.h.e(attributeSet, "attrs");
        this.f2711f = new ArrayList();
        this.f2712g = new ArrayList();
        this.f2714i = true;
        String classAttribute = attributeSet.getClassAttribute();
        int i4 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.a.f1988b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        AbstractComponentCallbacksC0187t C3 = p3.C(id);
        if (classAttribute != null && C3 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag ".concat(string);
                } else {
                    str = "";
                }
                throw new IllegalStateException(r2.k.b("FragmentContainerView must have an android:id to add Fragment ", classAttribute, str));
            }
            I G3 = p3.G();
            context.getClassLoader();
            AbstractComponentCallbacksC0187t a4 = G3.a(classAttribute);
            T2.h.d(a4, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a4.f2904B = id;
            a4.f2905C = id;
            a4.f2906D = string;
            a4.f2941x = p3;
            C0191x c0191x = p3.f2770v;
            a4.f2942y = c0191x;
            a4.f2911I = true;
            if (c0191x == null) {
                abstractActivityC0416k = null;
            } else {
                abstractActivityC0416k = c0191x.f2948f;
            }
            if (abstractActivityC0416k != null) {
                a4.f2911I = true;
            }
            C0169a c0169a = new C0169a(p3);
            c0169a.f2829o = true;
            a4.f2912J = this;
            c0169a.e(getId(), a4, string);
            if (!c0169a.f2822g) {
                P p4 = c0169a.f2830p;
                if (p4.f2770v != null && !p4.f2743I) {
                    p4.z(true);
                    c0169a.a(p4.f2745K, p4.f2746L);
                    p4.f2751b = true;
                    try {
                        p4.T(p4.f2745K, p4.f2746L);
                        p4.d();
                        p4.e0();
                        p4.v();
                        ((HashMap) p4.f2752c.f1470g).values().removeAll(Collections.singleton(null));
                    } catch (Throwable th) {
                        p4.d();
                        throw th;
                    }
                }
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList h3 = p3.f2752c.h();
        int size = h3.size();
        while (i4 < size) {
            Object obj = h3.get(i4);
            i4++;
            int i5 = ((X) obj).f2804c.f2905C;
            getId();
        }
    }

    public final void a(View view) {
        if (this.f2712g.contains(view)) {
            this.f2711f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t;
        T2.h.e(view, "child");
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof AbstractComponentCallbacksC0187t) {
            abstractComponentCallbacksC0187t = (AbstractComponentCallbacksC0187t) tag;
        } else {
            abstractComponentCallbacksC0187t = null;
        }
        if (abstractComponentCallbacksC0187t != null) {
            super.addView(view, i4, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        v0 v0Var;
        T2.h.e(windowInsets, "insets");
        v0 c4 = v0.c(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2713h;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            T2.h.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            v0Var = v0.c(onApplyWindowInsets, null);
        } else {
            WeakHashMap weakHashMap = I.T.f702a;
            WindowInsets b4 = c4.b();
            if (b4 != null) {
                onApplyWindowInsets(b4);
                if (!b4.equals(b4)) {
                    c4 = v0.c(b4, this);
                }
            }
            v0Var = c4;
        }
        if (!v0Var.f788a.q()) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                I.T.b(getChildAt(i4), v0Var);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        T2.h.e(canvas, "canvas");
        if (this.f2714i) {
            ArrayList arrayList = this.f2711f;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        T2.h.e(canvas, "canvas");
        T2.h.e(view, "child");
        if (this.f2714i) {
            ArrayList arrayList = this.f2711f;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        T2.h.e(view, "view");
        this.f2712g.remove(view);
        if (this.f2711f.remove(view)) {
            this.f2714i = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends AbstractComponentCallbacksC0187t> F getFragment() {
        AbstractActivityC0192y abstractActivityC0192y;
        AbstractComponentCallbacksC0187t abstractComponentCallbacksC0187t;
        P supportFragmentManager;
        View view = this;
        while (true) {
            abstractActivityC0192y = null;
            if (view != null) {
                Object tag = view.getTag(R.id.fragment_container_view_tag);
                if (tag instanceof AbstractComponentCallbacksC0187t) {
                    abstractComponentCallbacksC0187t = (AbstractComponentCallbacksC0187t) tag;
                } else {
                    abstractComponentCallbacksC0187t = null;
                }
                if (abstractComponentCallbacksC0187t != null) {
                    break;
                }
                Object parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    view = null;
                }
            } else {
                abstractComponentCallbacksC0187t = null;
                break;
            }
        }
        if (abstractComponentCallbacksC0187t != null) {
            if (abstractComponentCallbacksC0187t.f2942y != null && abstractComponentCallbacksC0187t.f2933p) {
                supportFragmentManager = abstractComponentCallbacksC0187t.c();
            } else {
                throw new IllegalStateException("The Fragment " + abstractComponentCallbacksC0187t + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
        } else {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof AbstractActivityC0192y) {
                    abstractActivityC0192y = (AbstractActivityC0192y) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (abstractActivityC0192y != null) {
                supportFragmentManager = abstractActivityC0192y.getSupportFragmentManager();
            } else {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
        }
        return (F) supportFragmentManager.C(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        T2.h.e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                T2.h.d(childAt, "view");
                a(childAt);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        T2.h.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i4) {
        View childAt = getChildAt(i4);
        T2.h.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i4);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        T2.h.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i4, int i5) {
        int i6 = i4 + i5;
        for (int i7 = i4; i7 < i6; i7++) {
            View childAt = getChildAt(i7);
            T2.h.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i4, int i5) {
        int i6 = i4 + i5;
        for (int i7 = i4; i7 < i6; i7++) {
            View childAt = getChildAt(i7);
            T2.h.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i4, i5);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.f2714i = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        T2.h.e(onApplyWindowInsetsListener, "listener");
        this.f2713h = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        T2.h.e(view, "view");
        if (view.getParent() == this) {
            this.f2712g.add(view);
        }
        super.startViewTransition(view);
    }
}
