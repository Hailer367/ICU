package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import n.AbstractC0453c;
import n.C0452b;
import n.InterfaceC0450C;
import n.m;
import n.n;
import n.q;
import o.C0516f0;
import o.InterfaceC0525k;

/* loaded from: classes.dex */
public class ActionMenuItemView extends C0516f0 implements InterfaceC0450C, View.OnClickListener, InterfaceC0525k {

    /* renamed from: m, reason: collision with root package name */
    public q f2262m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f2263n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f2264o;

    /* renamed from: p, reason: collision with root package name */
    public m f2265p;

    /* renamed from: q, reason: collision with root package name */
    public C0452b f2266q;

    /* renamed from: r, reason: collision with root package name */
    public AbstractC0453c f2267r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2268s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2269t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2270u;

    /* renamed from: v, reason: collision with root package name */
    public int f2271v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2272w;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f2268s = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4068c, 0, 0);
        this.f2270u = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f2272w = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2271v = -1;
        setSaveEnabled(false);
    }

    @Override // n.InterfaceC0450C
    public final void a(q qVar) {
        int i4;
        this.f2262m = qVar;
        setIcon(qVar.getIcon());
        setTitle(qVar.getTitleCondensed());
        setId(qVar.f5326a);
        if (qVar.isVisible()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        setVisibility(i4);
        setEnabled(qVar.isEnabled());
        if (qVar.hasSubMenu() && this.f2266q == null) {
            this.f2266q = new C0452b(this);
        }
    }

    @Override // o.InterfaceC0525k
    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // o.InterfaceC0525k
    public final boolean c() {
        if (!TextUtils.isEmpty(getText()) && this.f2262m.getIcon() == null) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (i4 < 480) {
            if ((i4 < 640 || i5 < 480) && configuration.orientation != 2) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final void g() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z = true;
        boolean z3 = !TextUtils.isEmpty(this.f2263n);
        if (this.f2264o != null && ((this.f2262m.f5349y & 4) != 4 || (!this.f2268s && !this.f2269t))) {
            z = false;
        }
        boolean z4 = z3 & z;
        CharSequence charSequence3 = null;
        if (z4) {
            charSequence = this.f2263n;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence4 = this.f2262m.f5341q;
        if (TextUtils.isEmpty(charSequence4)) {
            if (z4) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f2262m.f5330e;
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(charSequence4);
        }
        CharSequence charSequence5 = this.f2262m.f5342r;
        if (TextUtils.isEmpty(charSequence5)) {
            if (!z4) {
                charSequence3 = this.f2262m.f5330e;
            }
            AbstractC0286a.H(this, charSequence3);
            return;
        }
        AbstractC0286a.H(this, charSequence5);
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // n.InterfaceC0450C
    public q getItemData() {
        return this.f2262m;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar = this.f2265p;
        if (mVar != null) {
            mVar.b(this.f2262m);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2268s = f();
        g();
    }

    @Override // o.C0516f0, android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i7 = this.f2271v) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int measuredWidth = getMeasuredWidth();
        int i8 = this.f2270u;
        if (mode == Integer.MIN_VALUE) {
            i6 = Math.min(size, i8);
        } else {
            i6 = i8;
        }
        if (mode != 1073741824 && i8 > 0 && measuredWidth < i6) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
        }
        if (isEmpty && this.f2264o != null) {
            super.setPadding((getMeasuredWidth() - this.f2264o.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0452b c0452b;
        if (this.f2262m.hasSubMenu() && (c0452b = this.f2266q) != null && c0452b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f2269t != z) {
            this.f2269t = z;
            q qVar = this.f2262m;
            if (qVar != null) {
                n nVar = qVar.f5338n;
                nVar.k = true;
                nVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2264o = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i4 = this.f2272w;
            if (intrinsicWidth > i4) {
                intrinsicHeight = (int) (intrinsicHeight * (i4 / intrinsicWidth));
                intrinsicWidth = i4;
            }
            if (intrinsicHeight > i4) {
                intrinsicWidth = (int) (intrinsicWidth * (i4 / intrinsicHeight));
            } else {
                i4 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i4);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(m mVar) {
        this.f2265p = mVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i4, int i5, int i6, int i7) {
        this.f2271v = i4;
        super.setPadding(i4, i5, i6, i7);
    }

    public void setPopupCallback(AbstractC0453c abstractC0453c) {
        this.f2267r = abstractC0453c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2263n = charSequence;
        g();
    }
}
