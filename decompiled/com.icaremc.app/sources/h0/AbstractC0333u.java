package h0;

import I.T;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import g0.AbstractC0293a;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: h0.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0333u {

    /* renamed from: a, reason: collision with root package name */
    public A2.t f3930a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f3931b;

    /* renamed from: c, reason: collision with root package name */
    public final E0.a f3932c;

    /* renamed from: d, reason: collision with root package name */
    public final E0.a f3933d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3934e;

    /* renamed from: f, reason: collision with root package name */
    public int f3935f;

    /* renamed from: g, reason: collision with root package name */
    public int f3936g;

    public AbstractC0333u() {
        R1.c cVar = new R1.c(23, this);
        A2.q qVar = new A2.q(24, this);
        this.f3932c = new E0.a((InterfaceC0311N) cVar);
        this.f3933d = new E0.a((InterfaceC0311N) qVar);
        this.f3934e = false;
    }

    public static int e(int i4, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return Math.max(i5, i6);
            }
            return size;
        }
        return Math.min(size, Math.max(i5, i6));
    }

    public static void v(View view) {
        ((C0334v) view.getLayoutParams()).getClass();
        throw null;
    }

    public static C0325m w(Context context, AttributeSet attributeSet, int i4, int i5) {
        C0325m c0325m = new C0325m(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0293a.f3767a, i4, i5);
        c0325m.f3917b = obtainStyledAttributes.getInt(0, 1);
        c0325m.f3918c = obtainStyledAttributes.getInt(9, 1);
        c0325m.f3919d = obtainStyledAttributes.getBoolean(8, false);
        c0325m.f3920e = obtainStyledAttributes.getBoolean(10, false);
        obtainStyledAttributes.recycle();
        return c0325m;
    }

    public void A(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f3931b;
        C0298A c0298a = recyclerView.f3107f;
        C0301D c0301d = recyclerView.f3104c0;
        if (recyclerView != null && accessibilityEvent != null) {
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f3931b.canScrollVertically(-1) && !this.f3931b.canScrollHorizontally(-1) && !this.f3931b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            this.f3931b.getClass();
        }
    }

    public abstract void B(Parcelable parcelable);

    public abstract Parcelable C();

    public final void E() {
        int p3 = p() - 1;
        if (p3 < 0) {
            return;
        }
        RecyclerView.j(o(p3));
        throw null;
    }

    public final void F(C0298A c0298a) {
        ArrayList arrayList = (ArrayList) c0298a.f3820h;
        int size = arrayList.size();
        int i4 = size - 1;
        if (i4 < 0) {
            arrayList.clear();
            if (size > 0) {
                this.f3931b.invalidate();
                return;
            }
            return;
        }
        throw A2.i.f(arrayList, i4);
    }

    public final boolean G(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z3) {
        boolean z4;
        boolean z5;
        int s3 = s();
        int u3 = u();
        int t3 = this.f3935f - t();
        int r3 = this.f3936g - r();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = rect.width() + left;
        int height = rect.height() + top;
        int i4 = left - s3;
        int min = Math.min(0, i4);
        int i5 = top - u3;
        int min2 = Math.min(0, i5);
        int i6 = width - t3;
        int max = Math.max(0, i6);
        int max2 = Math.max(0, height - r3);
        RecyclerView recyclerView2 = this.f3931b;
        WeakHashMap weakHashMap = T.f702a;
        if (recyclerView2.getLayoutDirection() == 1) {
            if (max == 0) {
                max = Math.max(min, i6);
            }
        } else {
            if (min == 0) {
                min = Math.min(i4, max);
            }
            max = min;
        }
        if (min2 == 0) {
            min2 = Math.min(i5, max2);
        }
        int[] iArr = {max, min2};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (z3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int s4 = s();
            int u4 = u();
            int t4 = this.f3935f - t();
            int r4 = this.f3936g - r();
            Rect rect2 = this.f3931b.f3118l;
            int[] iArr2 = RecyclerView.m0;
            C0334v c0334v = (C0334v) focusedChild.getLayoutParams();
            Rect rect3 = c0334v.f3937a;
            z4 = false;
            z5 = true;
            rect2.set((focusedChild.getLeft() - rect3.left) - ((ViewGroup.MarginLayoutParams) c0334v).leftMargin, (focusedChild.getTop() - rect3.top) - ((ViewGroup.MarginLayoutParams) c0334v).topMargin, focusedChild.getRight() + rect3.right + ((ViewGroup.MarginLayoutParams) c0334v).rightMargin, focusedChild.getBottom() + rect3.bottom + ((ViewGroup.MarginLayoutParams) c0334v).bottomMargin);
            if (rect2.left - i7 >= t4 || rect2.right - i7 <= s4 || rect2.top - i8 >= r4 || rect2.bottom - i8 <= u4) {
                return false;
            }
        } else {
            z4 = false;
            z5 = true;
        }
        if (i7 == 0 && i8 == 0) {
            return z4;
        }
        if (z) {
            recyclerView.scrollBy(i7, i8);
            return z5;
        }
        recyclerView.r(i7, i8);
        return z5;
    }

    public final void H() {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void I(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f3931b = null;
            this.f3930a = null;
            this.f3935f = 0;
            this.f3936g = 0;
            return;
        }
        this.f3931b = recyclerView;
        this.f3930a = recyclerView.f3113i;
        this.f3935f = recyclerView.getWidth();
        this.f3936g = recyclerView.getHeight();
    }

    public abstract void a(String str);

    public abstract boolean b();

    public abstract boolean c();

    public boolean d(C0334v c0334v) {
        if (c0334v != null) {
            return true;
        }
        return false;
    }

    public abstract int f(C0301D c0301d);

    public abstract void g(C0301D c0301d);

    public abstract int h(C0301D c0301d);

    public abstract int i(C0301D c0301d);

    public abstract void j(C0301D c0301d);

    public abstract int k(C0301D c0301d);

    public abstract C0334v l();

    public C0334v m(Context context, AttributeSet attributeSet) {
        return new C0334v(context, attributeSet);
    }

    public C0334v n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0334v) {
            return new C0334v((C0334v) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0334v((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0334v(layoutParams);
    }

    public final View o(int i4) {
        A2.t tVar = this.f3930a;
        if (tVar != null) {
            C0314b c0314b = (C0314b) tVar.f100h;
            int i5 = -1;
            if (i4 >= 0) {
                int childCount = ((RecyclerView) ((A2.q) tVar.f99g).f93g).getChildCount();
                int i6 = i4;
                while (true) {
                    if (i6 >= childCount) {
                        break;
                    }
                    int a4 = i4 - (i6 - c0314b.a(i6));
                    if (a4 == 0) {
                        i5 = i6;
                        while (c0314b.b(i5)) {
                            i5++;
                        }
                    } else {
                        i6 += a4;
                    }
                }
            }
            return ((RecyclerView) ((A2.q) tVar.f99g).f93g).getChildAt(i5);
        }
        return null;
    }

    public final int p() {
        A2.t tVar = this.f3930a;
        if (tVar != null) {
            return ((RecyclerView) ((A2.q) tVar.f99g).f93g).getChildCount() - ((ArrayList) tVar.f101i).size();
        }
        return 0;
    }

    public int q(C0298A c0298a, C0301D c0301d) {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            recyclerView.getClass();
            return 1;
        }
        return 1;
    }

    public final int r() {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int s() {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int t() {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int u() {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int x(C0298A c0298a, C0301D c0301d) {
        RecyclerView recyclerView = this.f3931b;
        if (recyclerView != null) {
            recyclerView.getClass();
            return 1;
        }
        return 1;
    }

    public abstract boolean y();

    public abstract void z(RecyclerView recyclerView);

    public void D(int i4) {
    }
}
