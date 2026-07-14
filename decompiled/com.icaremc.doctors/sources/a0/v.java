package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public A0.g f1006a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f1007b;

    /* renamed from: c, reason: collision with root package name */
    public final B.c f1008c;

    /* renamed from: d, reason: collision with root package name */
    public final B.c f1009d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1010e;

    /* renamed from: f, reason: collision with root package name */
    public int f1011f;

    /* renamed from: g, reason: collision with root package name */
    public int f1012g;

    public v() {
        u uVar = new u(this, 0);
        u uVar2 = new u(this, 1);
        this.f1008c = new B.c(uVar);
        this.f1009d = new B.c(uVar2);
        this.f1010e = false;
    }

    public static int e(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return Math.max(i3, i4);
            }
            return size;
        }
        return Math.min(size, Math.max(i3, i4));
    }

    public static void v(View view) {
        ((w) view.getLayoutParams()).getClass();
        throw null;
    }

    public static C0071m w(Context context, AttributeSet attributeSet, int i2, int i3) {
        C0071m c0071m = new C0071m(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z.a.f882a, i2, i3);
        c0071m.f991b = obtainStyledAttributes.getInt(0, 1);
        c0071m.f992c = obtainStyledAttributes.getInt(9, 1);
        c0071m.f993d = obtainStyledAttributes.getBoolean(8, false);
        c0071m.f994e = obtainStyledAttributes.getBoolean(10, false);
        obtainStyledAttributes.recycle();
        return c0071m;
    }

    public void A(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f1007b;
        C0053B c0053b = recyclerView.f1923c;
        C0056E c0056e = recyclerView.f1920W;
        if (recyclerView != null && accessibilityEvent != null) {
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1007b.canScrollVertically(-1) && !this.f1007b.canScrollHorizontally(-1) && !this.f1007b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            this.f1007b.getClass();
        }
    }

    public abstract void B(Parcelable parcelable);

    public abstract Parcelable C();

    public final void E() {
        int p = p() - 1;
        if (p < 0) {
            return;
        }
        RecyclerView.j(o(p));
        throw null;
    }

    public final void F(C0053B c0053b) {
        ArrayList arrayList = c0053b.f891a;
        int size = arrayList.size();
        int i2 = size - 1;
        if (i2 < 0) {
            arrayList.clear();
            if (size > 0) {
                this.f1007b.invalidate();
                return;
            }
            return;
        }
        arrayList.get(i2).getClass();
        throw new ClassCastException();
    }

    public final boolean G(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        int s2 = s();
        int u2 = u();
        int t2 = this.f1011f - t();
        int r2 = this.f1012g - r();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = rect.width() + left;
        int height = rect.height() + top;
        int i2 = left - s2;
        int min = Math.min(0, i2);
        int i3 = top - u2;
        int min2 = Math.min(0, i3);
        int i4 = width - t2;
        int max = Math.max(0, i4);
        int max2 = Math.max(0, height - r2);
        RecyclerView recyclerView2 = this.f1007b;
        Field field = E.J.f180a;
        if (recyclerView2.getLayoutDirection() == 1) {
            if (max == 0) {
                max = Math.max(min, i4);
            }
        } else {
            if (min == 0) {
                min = Math.min(i2, max);
            }
            max = min;
        }
        if (min2 == 0) {
            min2 = Math.min(i3, max2);
        }
        int[] iArr = {max, min2};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (z2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int s3 = s();
            int u3 = u();
            int t3 = this.f1011f - t();
            int r3 = this.f1012g - r();
            Rect rect2 = this.f1007b.f1935i;
            int[] iArr2 = RecyclerView.f1895j0;
            w wVar = (w) focusedChild.getLayoutParams();
            Rect rect3 = wVar.f1013a;
            z3 = false;
            z4 = true;
            rect2.set((focusedChild.getLeft() - rect3.left) - ((ViewGroup.MarginLayoutParams) wVar).leftMargin, (focusedChild.getTop() - rect3.top) - ((ViewGroup.MarginLayoutParams) wVar).topMargin, focusedChild.getRight() + rect3.right + ((ViewGroup.MarginLayoutParams) wVar).rightMargin, focusedChild.getBottom() + rect3.bottom + ((ViewGroup.MarginLayoutParams) wVar).bottomMargin);
            if (rect2.left - i5 >= t3 || rect2.right - i5 <= s3 || rect2.top - i6 >= r3 || rect2.bottom - i6 <= u3) {
                return false;
            }
        } else {
            z3 = false;
            z4 = true;
        }
        if (i5 == 0 && i6 == 0) {
            return z3;
        }
        if (z) {
            recyclerView.scrollBy(i5, i6);
            return z4;
        }
        recyclerView.r(i5, i6);
        return z4;
    }

    public final void H() {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final void I(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f1007b = null;
            this.f1006a = null;
            this.f1011f = 0;
            this.f1012g = 0;
            return;
        }
        this.f1007b = recyclerView;
        this.f1006a = recyclerView.f1929f;
        this.f1011f = recyclerView.getWidth();
        this.f1012g = recyclerView.getHeight();
    }

    public abstract void a(String str);

    public abstract boolean b();

    public abstract boolean c();

    public boolean d(w wVar) {
        if (wVar != null) {
            return true;
        }
        return false;
    }

    public abstract int f(C0056E c0056e);

    public abstract void g(C0056E c0056e);

    public abstract int h(C0056E c0056e);

    public abstract int i(C0056E c0056e);

    public abstract void j(C0056E c0056e);

    public abstract int k(C0056E c0056e);

    public abstract w l();

    public w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    public w n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof w) {
            return new w((w) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new w((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new w(layoutParams);
    }

    public final View o(int i2) {
        A0.g gVar = this.f1006a;
        if (gVar != null) {
            C0060b c0060b = (C0060b) gVar.f31e;
            int i3 = -1;
            if (i2 >= 0) {
                int childCount = ((RecyclerView) ((F.h) gVar.f30d).f274d).getChildCount();
                int i4 = i2;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    int a2 = i2 - (i4 - c0060b.a(i4));
                    if (a2 == 0) {
                        i3 = i4;
                        while (c0060b.b(i3)) {
                            i3++;
                        }
                    } else {
                        i4 += a2;
                    }
                }
            }
            return ((RecyclerView) ((F.h) gVar.f30d).f274d).getChildAt(i3);
        }
        return null;
    }

    public final int p() {
        A0.g gVar = this.f1006a;
        if (gVar != null) {
            return ((RecyclerView) ((F.h) gVar.f30d).f274d).getChildCount() - ((ArrayList) gVar.f32f).size();
        }
        return 0;
    }

    public int q(C0053B c0053b, C0056E c0056e) {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            recyclerView.getClass();
            return 1;
        }
        return 1;
    }

    public final int r() {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int s() {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int t() {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int u() {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int x(C0053B c0053b, C0056E c0056e) {
        RecyclerView recyclerView = this.f1007b;
        if (recyclerView != null) {
            recyclerView.getClass();
            return 1;
        }
        return 1;
    }

    public abstract boolean y();

    public abstract void z(RecyclerView recyclerView);

    public void D(int i2) {
    }
}
