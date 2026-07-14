package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import f1.AbstractC0286a;
import n.ViewTreeObserverOnGlobalLayoutListenerC0454d;

/* renamed from: o.U, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0494U extends Spinner {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f5518n = {R.attr.spinnerMode};

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5519f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f5520g;

    /* renamed from: h, reason: collision with root package name */
    public final C0477I f5521h;

    /* renamed from: i, reason: collision with root package name */
    public SpinnerAdapter f5522i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5523j;
    public final InterfaceC0493T k;

    /* renamed from: l, reason: collision with root package name */
    public int f5524l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f5525m;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        if (r7 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0494U(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130903344(0x7f030130, float:1.7413503E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.f5525m = r1
            android.content.Context r1 = r12.getContext()
            o.m1.a(r12, r1)
            int[] r1 = i.AbstractC0357a.f4086v
            A2.t r2 = A2.t.P(r13, r14, r1, r0)
            java.lang.Object r3 = r2.f100h
            android.content.res.TypedArray r3 = (android.content.res.TypedArray) r3
            o.o r4 = new o.o
            r4.<init>(r12)
            r12.f5519f = r4
            r4 = 4
            r5 = 0
            int r4 = r3.getResourceId(r4, r5)
            if (r4 == 0) goto L35
            m.e r6 = new m.e
            r6.<init>(r13, r4)
            r12.f5520g = r6
            goto L37
        L35:
            r12.f5520g = r13
        L37:
            r4 = -1
            r6 = 0
            int[] r7 = o.C0494U.f5518n     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            boolean r8 = r7.hasValue(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            if (r8 == 0) goto L50
            int r4 = r7.getInt(r5, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            goto L50
        L4a:
            r13 = move-exception
            r6 = r7
            goto Ld5
        L4e:
            r8 = move-exception
            goto L59
        L50:
            r7.recycle()
            goto L63
        L54:
            r13 = move-exception
            goto Ld5
        L57:
            r8 = move-exception
            r7 = r6
        L59:
            java.lang.String r9 = "AppCompatSpinner"
            java.lang.String r10 = "Could not read android:spinnerMode"
            android.util.Log.i(r9, r10, r8)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L63
            goto L50
        L63:
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L9d
            if (r4 == r8) goto L6a
            goto Laa
        L6a:
            o.Q r4 = new o.Q
            android.content.Context r9 = r12.f5520g
            r4.<init>(r12, r9, r14)
            android.content.Context r9 = r12.f5520g
            A2.t r1 = A2.t.P(r9, r14, r1, r0)
            java.lang.Object r9 = r1.f100h
            android.content.res.TypedArray r9 = (android.content.res.TypedArray) r9
            r10 = 3
            r11 = -2
            int r9 = r9.getLayoutDimension(r10, r11)
            r12.f5524l = r9
            android.graphics.drawable.Drawable r9 = r1.H(r8)
            r4.h(r9)
            java.lang.String r7 = r3.getString(r7)
            r4.f5506G = r7
            r1.T()
            r12.k = r4
            o.I r1 = new o.I
            r1.<init>(r12, r12, r4)
            r12.f5521h = r1
            goto Laa
        L9d:
            o.M r1 = new o.M
            r1.<init>(r12)
            r12.k = r1
            java.lang.String r4 = r3.getString(r7)
            r1.f5473h = r4
        Laa:
            java.lang.CharSequence[] r1 = r3.getTextArray(r5)
            if (r1 == 0) goto Lc1
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r13, r4, r1)
            r13 = 2131427401(0x7f0b0049, float:1.8476417E38)
            r3.setDropDownViewResource(r13)
            r12.setAdapter(r3)
        Lc1:
            r2.T()
            r12.f5523j = r8
            android.widget.SpinnerAdapter r13 = r12.f5522i
            if (r13 == 0) goto Lcf
            r12.setAdapter(r13)
            r12.f5522i = r6
        Lcf:
            o.o r13 = r12.f5519f
            r13.d(r14, r0)
            return
        Ld5:
            if (r6 == 0) goto Lda
            r6.recycle()
        Lda:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0494U.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i4 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i5 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i5 = Math.max(i5, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.f5525m;
            drawable.getPadding(rect);
            return rect.left + rect.right + i5;
        }
        return i5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            c0533o.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            return interfaceC0493T.a();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            return interfaceC0493T.m();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.k != null) {
            return this.f5524l;
        }
        return super.getDropDownWidth();
    }

    public final InterfaceC0493T getInternalPopup() {
        return this.k;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            return interfaceC0493T.d();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f5520g;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            return interfaceC0493T.n();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null && interfaceC0493T.b()) {
            interfaceC0493T.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.k != null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i4)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        C0492S c0492s = (C0492S) parcelable;
        super.onRestoreInstanceState(c0492s.getSuperState());
        if (c0492s.f5515f && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0454d(2, this));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, o.S] */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null && interfaceC0493T.b()) {
            z = true;
        } else {
            z = false;
        }
        baseSavedState.f5515f = z;
        return baseSavedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0477I c0477i = this.f5521h;
        if (c0477i != null && c0477i.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            if (!interfaceC0493T.b()) {
                this.k.l(AbstractC0481K.b(this), AbstractC0481K.a(this));
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i4) {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            interfaceC0493T.j(i4);
            interfaceC0493T.k(i4);
        } else {
            super.setDropDownHorizontalOffset(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i4) {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            interfaceC0493T.i(i4);
        } else {
            super.setDropDownVerticalOffset(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i4) {
        if (this.k != null) {
            this.f5524l = i4;
        } else {
            super.setDropDownWidth(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            interfaceC0493T.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i4) {
        setPopupBackgroundDrawable(AbstractC0286a.o(getPopupContext(), i4));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != null) {
            interfaceC0493T.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5519f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.ListAdapter, java.lang.Object, o.N] */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f5523j) {
            this.f5522i = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        InterfaceC0493T interfaceC0493T = this.k;
        if (interfaceC0493T != 0) {
            Context context = this.f5520g;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            ?? obj = new Object();
            obj.f5500f = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                obj.f5501g = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                AbstractC0483L.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            interfaceC0493T.p(obj);
        }
    }
}
