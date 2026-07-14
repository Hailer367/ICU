package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Q extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1561c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1562d;

    /* renamed from: e, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1563e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1564f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(Context context, AttributeSet attrs, h0 h0Var) {
        super(context, attrs);
        View view;
        String str;
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(attrs, "attrs");
        this.f1561c = new ArrayList();
        this.f1562d = new ArrayList();
        this.f1564f = true;
        String classAttribute = attrs.getClassAttribute();
        int i2 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, Q.a.f711b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        H C2 = h0Var.C(id);
        if (classAttribute != null && C2 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag ".concat(string);
                } else {
                    str = BuildConfig.FLAVOR;
                }
                throw new IllegalStateException(O.a.g("FragmentContainerView must have an android:id to add Fragment ", classAttribute, str));
            }
            C0100a0 H2 = h0Var.H();
            context.getClassLoader();
            H instantiate = H.instantiate(H2.f1581a.f1652v.f1567d, classAttribute, null);
            kotlin.jvm.internal.h.d(instantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            instantiate.mFragmentId = id;
            instantiate.mContainerId = id;
            instantiate.mTag = string;
            instantiate.mFragmentManager = h0Var;
            instantiate.mHost = h0Var.f1652v;
            instantiate.onInflate(context, attrs, (Bundle) null);
            C0099a c0099a = new C0099a(h0Var);
            c0099a.f1749o = true;
            instantiate.mContainer = this;
            c0099a.c(getId(), instantiate, string);
            if (!c0099a.f1741g) {
                c0099a.p.A(c0099a, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        ArrayList d2 = h0Var.f1635c.d();
        int size = d2.size();
        while (i2 < size) {
            Object obj = d2.get(i2);
            i2++;
            o0 o0Var = (o0) obj;
            H h2 = o0Var.f1711c;
            if (h2.mContainerId == getId() && (view = h2.mView) != null && view.getParent() == null) {
                h2.mContainer = this;
                o0Var.b();
            }
        }
    }

    public final void a(View view) {
        if (this.f1562d.contains(view)) {
            this.f1561c.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int i2, ViewGroup.LayoutParams layoutParams) {
        H h2;
        kotlin.jvm.internal.h.e(child, "child");
        Object tag = child.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof H) {
            h2 = (H) tag;
        } else {
            h2 = null;
        }
        if (h2 != null) {
            super.addView(child, i2, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2;
        WindowInsets a2;
        kotlin.jvm.internal.h.e(insets, "insets");
        E.k0 a3 = E.k0.a(null, insets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1563e;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, insets);
            kotlin.jvm.internal.h.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            a3 = E.k0.a(null, onApplyWindowInsets);
        } else {
            Field field = E.J.f180a;
            E.g0 g0Var = a3.f234a;
            if (g0Var instanceof E.W) {
                windowInsets = ((E.W) g0Var).f195c;
            } else {
                windowInsets = null;
            }
            if (windowInsets != null && !windowInsets.equals(windowInsets)) {
                a3 = E.k0.a(this, windowInsets);
            }
        }
        E.g0 g0Var2 = a3.f234a;
        if (!g0Var2.o()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                Field field2 = E.J.f180a;
                if (g0Var2 instanceof E.W) {
                    windowInsets2 = ((E.W) g0Var2).f195c;
                } else {
                    windowInsets2 = null;
                }
                if (windowInsets2 != null) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        a2 = E.H.a(childAt, windowInsets2);
                    } else {
                        a2 = E.C.a(childAt, windowInsets2);
                    }
                    if (!a2.equals(windowInsets2)) {
                        E.k0.a(childAt, a2);
                    }
                }
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.h.e(canvas, "canvas");
        if (this.f1564f) {
            ArrayList arrayList = this.f1561c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View child, long j2) {
        kotlin.jvm.internal.h.e(canvas, "canvas");
        kotlin.jvm.internal.h.e(child, "child");
        if (this.f1564f) {
            ArrayList arrayList = this.f1561c;
            if (!arrayList.isEmpty() && arrayList.contains(child)) {
                return false;
            }
        }
        return super.drawChild(canvas, child, j2);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        kotlin.jvm.internal.h.e(view, "view");
        this.f1562d.remove(view);
        if (this.f1561c.remove(view)) {
            this.f1564f = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends H> F getFragment() {
        M m2;
        H h2;
        h0 supportFragmentManager;
        View view = this;
        while (true) {
            m2 = null;
            if (view != null) {
                Object tag = view.getTag(R.id.fragment_container_view_tag);
                if (tag instanceof H) {
                    h2 = (H) tag;
                } else {
                    h2 = null;
                }
                if (h2 != null) {
                    break;
                }
                Object parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    view = null;
                }
            } else {
                h2 = null;
                break;
            }
        }
        if (h2 != null) {
            if (h2.isAdded()) {
                supportFragmentManager = h2.getChildFragmentManager();
            } else {
                throw new IllegalStateException("The Fragment " + h2 + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
        } else {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof M) {
                    m2 = (M) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (m2 != null) {
                supportFragmentManager = m2.getSupportFragmentManager();
            } else {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
        }
        return (F) supportFragmentManager.C(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.h.e(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View view = getChildAt(childCount);
                kotlin.jvm.internal.h.d(view, "view");
                a(view);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        kotlin.jvm.internal.h.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i2) {
        View view = getChildAt(i2);
        kotlin.jvm.internal.h.d(view, "view");
        a(view);
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        kotlin.jvm.internal.h.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View view = getChildAt(i5);
            kotlin.jvm.internal.h.d(view, "view");
            a(view);
        }
        super.removeViews(i2, i3);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View view = getChildAt(i5);
            kotlin.jvm.internal.h.d(view, "view");
            a(view);
        }
        super.removeViewsInLayout(i2, i3);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.f1564f = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        kotlin.jvm.internal.h.e(listener, "listener");
        this.f1563e = listener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        kotlin.jvm.internal.h.e(view, "view");
        if (view.getParent() == this) {
            this.f1562d.add(view);
        }
        super.startViewTransition(view);
    }
}
