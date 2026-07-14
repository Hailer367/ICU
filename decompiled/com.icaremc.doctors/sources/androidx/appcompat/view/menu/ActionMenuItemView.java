package androidx.appcompat.view.menu;

import a.AbstractC0051a;
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
import h.AbstractC0201a;
import l.a;
import l.b;
import l.i;
import l.j;
import l.k;
import l.q;
import m.C0273u;
import m.InterfaceC0262i;

/* loaded from: classes.dex */
public class ActionMenuItemView extends C0273u implements q, View.OnClickListener, InterfaceC0262i {

    /* renamed from: g, reason: collision with root package name */
    public k f1058g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f1059h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f1060i;

    /* renamed from: j, reason: collision with root package name */
    public i f1061j;

    /* renamed from: k, reason: collision with root package name */
    public a f1062k;

    /* renamed from: l, reason: collision with root package name */
    public b f1063l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1064m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1065n;

    /* renamed from: o, reason: collision with root package name */
    public final int f1066o;
    public int p;
    public final int q;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f1064m = d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0201a.f2300c, 0, 0);
        this.f1066o = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }

    @Override // m.InterfaceC0262i
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // l.q
    public final void b(k kVar) {
        int i2;
        this.f1058g = kVar;
        setIcon(kVar.getIcon());
        setTitle(kVar.getTitleCondensed());
        setId(kVar.f2861a);
        if (kVar.isVisible()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        setEnabled(kVar.isEnabled());
        if (kVar.hasSubMenu() && this.f1062k == null) {
            this.f1062k = new a(this);
        }
    }

    @Override // m.InterfaceC0262i
    public final boolean c() {
        if (!TextUtils.isEmpty(getText()) && this.f1058g.getIcon() == null) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (i2 < 480) {
            if ((i2 < 640 || i3 < 480) && configuration.orientation != 2) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final void e() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1059h);
        if (this.f1060i != null && ((this.f1058g.y & 4) != 4 || (!this.f1064m && !this.f1065n))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence3 = null;
        if (z3) {
            charSequence = this.f1059h;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence4 = this.f1058g.q;
        if (TextUtils.isEmpty(charSequence4)) {
            if (z3) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f1058g.f2865e;
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(charSequence4);
        }
        CharSequence charSequence5 = this.f1058g.f2876r;
        if (TextUtils.isEmpty(charSequence5)) {
            if (!z3) {
                charSequence3 = this.f1058g.f2865e;
            }
            AbstractC0051a.O(charSequence3, this);
            return;
        }
        AbstractC0051a.O(charSequence5, this);
    }

    @Override // l.q
    public k getItemData() {
        return this.f1058g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i iVar = this.f1061j;
        if (iVar != null) {
            iVar.a(this.f1058g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1064m = d();
        e();
    }

    @Override // m.C0273u, android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i5 = this.p) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int i6 = this.f1066o;
        if (mode == Integer.MIN_VALUE) {
            i4 = Math.min(size, i6);
        } else {
            i4 = i6;
        }
        if (mode != 1073741824 && i6 > 0 && measuredWidth < i4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
        }
        if (isEmpty && this.f1060i != null) {
            super.setPadding((getMeasuredWidth() - this.f1060i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.f1058g.hasSubMenu() && (aVar = this.f1062k) != null && aVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1065n != z) {
            this.f1065n = z;
            k kVar = this.f1058g;
            if (kVar != null) {
                j jVar = kVar.f2874n;
                jVar.f2851k = true;
                jVar.o(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1060i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.q;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public void setItemInvoker(i iVar) {
        this.f1061j = iVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
        this.p = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f1063l = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1059h = charSequence;
        e();
    }
}
