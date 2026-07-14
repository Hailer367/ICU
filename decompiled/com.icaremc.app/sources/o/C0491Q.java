package o;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.icaremc.app.R;
import n.ViewTreeObserverOnGlobalLayoutListenerC0454d;

/* renamed from: o.Q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0491Q extends AbstractC0486M0 implements InterfaceC0493T {

    /* renamed from: G, reason: collision with root package name */
    public CharSequence f5506G;

    /* renamed from: H, reason: collision with root package name */
    public C0487N f5507H;

    /* renamed from: I, reason: collision with root package name */
    public final Rect f5508I;

    /* renamed from: J, reason: collision with root package name */
    public int f5509J;

    /* renamed from: K, reason: collision with root package name */
    public final /* synthetic */ C0494U f5510K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0491Q(C0494U c0494u, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle);
        this.f5510K = c0494u;
        this.f5508I = new Rect();
        this.f5494t = c0494u;
        this.f5479C = true;
        this.f5480D.setFocusable(true);
        this.f5495u = new C0489O(0, this);
    }

    @Override // o.InterfaceC0493T
    public final void g(CharSequence charSequence) {
        this.f5506G = charSequence;
    }

    @Override // o.InterfaceC0493T
    public final void j(int i4) {
        this.f5509J = i4;
    }

    @Override // o.InterfaceC0493T
    public final void l(int i4, int i5) {
        ViewTreeObserver viewTreeObserver;
        C0463B c0463b = this.f5480D;
        boolean isShowing = c0463b.isShowing();
        s();
        this.f5480D.setInputMethodMode(2);
        c();
        C0462A0 c0462a0 = this.f5483h;
        c0462a0.setChoiceMode(1);
        AbstractC0481K.d(c0462a0, i4);
        AbstractC0481K.c(c0462a0, i5);
        C0494U c0494u = this.f5510K;
        int selectedItemPosition = c0494u.getSelectedItemPosition();
        C0462A0 c0462a02 = this.f5483h;
        if (c0463b.isShowing() && c0462a02 != null) {
            c0462a02.setListSelectionHidden(false);
            c0462a02.setSelection(selectedItemPosition);
            if (c0462a02.getChoiceMode() != 0) {
                c0462a02.setItemChecked(selectedItemPosition, true);
            }
        }
        if (!isShowing && (viewTreeObserver = c0494u.getViewTreeObserver()) != null) {
            ViewTreeObserverOnGlobalLayoutListenerC0454d viewTreeObserverOnGlobalLayoutListenerC0454d = new ViewTreeObserverOnGlobalLayoutListenerC0454d(3, this);
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0454d);
            this.f5480D.setOnDismissListener(new C0490P(this, viewTreeObserverOnGlobalLayoutListenerC0454d));
        }
    }

    @Override // o.InterfaceC0493T
    public final CharSequence n() {
        return this.f5506G;
    }

    @Override // o.AbstractC0486M0, o.InterfaceC0493T
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.f5507H = (C0487N) listAdapter;
    }

    public final void s() {
        int i4;
        int i5;
        C0494U c0494u = this.f5510K;
        Rect rect = c0494u.f5525m;
        C0463B c0463b = this.f5480D;
        Drawable background = c0463b.getBackground();
        if (background != null) {
            background.getPadding(rect);
            if (E1.a(c0494u)) {
                i4 = rect.right;
            } else {
                i4 = -rect.left;
            }
        } else {
            i4 = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = c0494u.getPaddingLeft();
        int paddingRight = c0494u.getPaddingRight();
        int width = c0494u.getWidth();
        int i6 = c0494u.f5524l;
        if (i6 == -2) {
            int a4 = c0494u.a(this.f5507H, c0463b.getBackground());
            int i7 = (c0494u.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (a4 > i7) {
                a4 = i7;
            }
            r(Math.max(a4, (width - paddingLeft) - paddingRight));
        } else if (i6 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i6);
        }
        if (E1.a(c0494u)) {
            i5 = (((width - paddingRight) - this.f5485j) - this.f5509J) + i4;
        } else {
            i5 = paddingLeft + this.f5509J + i4;
        }
        this.k = i5;
    }
}
