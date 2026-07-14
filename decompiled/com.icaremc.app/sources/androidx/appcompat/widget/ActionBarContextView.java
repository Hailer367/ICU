package androidx.appcompat.widget;

import I.T;
import I.Y;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import i.AbstractC0357a;
import j.ViewOnClickListenerC0408c;
import java.util.WeakHashMap;
import m.AbstractC0438b;
import n.D;
import n.n;
import o.C0500a;
import o.C0515f;
import o.C0523j;
import o.E1;

/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    public final C0500a f2299f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f2300g;

    /* renamed from: h, reason: collision with root package name */
    public ActionMenuView f2301h;

    /* renamed from: i, reason: collision with root package name */
    public C0523j f2302i;

    /* renamed from: j, reason: collision with root package name */
    public int f2303j;
    public Y k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2304l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2305m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f2306n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f2307o;

    /* renamed from: p, reason: collision with root package name */
    public View f2308p;

    /* renamed from: q, reason: collision with root package name */
    public View f2309q;

    /* renamed from: r, reason: collision with root package name */
    public View f2310r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout f2311s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f2312t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f2313u;

    /* renamed from: v, reason: collision with root package name */
    public final int f2314v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2315w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2316x;

    /* renamed from: y, reason: collision with root package name */
    public final int f2317y;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        Drawable drawable;
        int resourceId;
        this.f2299f = new C0500a(this);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f2300g = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f2300g = context;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0357a.f4069d, R.attr.actionModeStyle, 0);
        if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
            drawable = AbstractC0286a.o(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(0);
        }
        WeakHashMap weakHashMap = T.f702a;
        setBackground(drawable);
        this.f2314v = obtainStyledAttributes.getResourceId(5, 0);
        this.f2315w = obtainStyledAttributes.getResourceId(4, 0);
        this.f2303j = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.f2317y = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public static int f(View view, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), i5);
        return Math.max(0, i4 - view.getMeasuredWidth());
    }

    public static int g(View view, int i4, int i5, int i6, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = ((i6 - measuredHeight) / 2) + i5;
        if (z) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        if (z) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public final void c(AbstractC0438b abstractC0438b) {
        View view = this.f2308p;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f2317y, (ViewGroup) this, false);
            this.f2308p = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f2308p);
        }
        View findViewById = this.f2308p.findViewById(R.id.action_mode_close_button);
        this.f2309q = findViewById;
        findViewById.setOnClickListener(new ViewOnClickListenerC0408c(1, abstractC0438b));
        n c4 = abstractC0438b.c();
        C0523j c0523j = this.f2302i;
        if (c0523j != null) {
            c0523j.c();
            C0515f c0515f = c0523j.f5619y;
            if (c0515f != null && c0515f.b()) {
                c0515f.f5369i.dismiss();
            }
        }
        C0523j c0523j2 = new C0523j(getContext());
        this.f2302i = c0523j2;
        c0523j2.f5611q = true;
        c0523j2.f5612r = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c4.b(this.f2302i, this.f2300g);
        C0523j c0523j3 = this.f2302i;
        D d4 = c0523j3.f5607m;
        if (d4 == null) {
            D d5 = (D) c0523j3.f5604i.inflate(c0523j3.k, (ViewGroup) this, false);
            c0523j3.f5607m = d5;
            d5.a(c0523j3.f5603h);
            c0523j3.d();
        }
        D d6 = c0523j3.f5607m;
        if (d4 != d6) {
            ((ActionMenuView) d6).setPresenter(c0523j3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) d6;
        this.f2301h = actionMenuView;
        WeakHashMap weakHashMap = T.f702a;
        actionMenuView.setBackground(null);
        addView(this.f2301h, layoutParams);
    }

    public final void d() {
        int i4;
        if (this.f2311s == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2311s = linearLayout;
            this.f2312t = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f2313u = (TextView) this.f2311s.findViewById(R.id.action_bar_subtitle);
            int i5 = this.f2314v;
            if (i5 != 0) {
                this.f2312t.setTextAppearance(getContext(), i5);
            }
            int i6 = this.f2315w;
            if (i6 != 0) {
                this.f2313u.setTextAppearance(getContext(), i6);
            }
        }
        this.f2312t.setText(this.f2306n);
        this.f2313u.setText(this.f2307o);
        boolean isEmpty = TextUtils.isEmpty(this.f2306n);
        boolean isEmpty2 = TextUtils.isEmpty(this.f2307o);
        TextView textView = this.f2313u;
        int i7 = 8;
        if (!isEmpty2) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        LinearLayout linearLayout2 = this.f2311s;
        if (!isEmpty || !isEmpty2) {
            i7 = 0;
        }
        linearLayout2.setVisibility(i7);
        if (this.f2311s.getParent() == null) {
            addView(this.f2311s);
        }
    }

    public final void e() {
        removeAllViews();
        this.f2310r = null;
        this.f2301h = null;
        this.f2302i = null;
        View view = this.f2309q;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        if (this.k != null) {
            return this.f2299f.f5554b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f2303j;
    }

    public CharSequence getSubtitle() {
        return this.f2307o;
    }

    public CharSequence getTitle() {
        return this.f2306n;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i4) {
        if (i4 != getVisibility()) {
            Y y3 = this.k;
            if (y3 != null) {
                y3.b();
            }
            super.setVisibility(i4);
        }
    }

    public final Y i(long j4, int i4) {
        Y y3 = this.k;
        if (y3 != null) {
            y3.b();
        }
        C0500a c0500a = this.f2299f;
        if (i4 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            Y a4 = T.a(this);
            a4.a(1.0f);
            a4.c(j4);
            c0500a.f5555c.k = a4;
            c0500a.f5554b = i4;
            a4.d(c0500a);
            return a4;
        }
        Y a5 = T.a(this);
        a5.a(0.0f);
        a5.c(j4);
        c0500a.f5555c.k = a5;
        c0500a.f5554b = i4;
        a5.d(c0500a);
        return a5;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int i4;
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC0357a.f4066a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        C0523j c0523j = this.f2302i;
        if (c0523j != null) {
            Configuration configuration2 = c0523j.f5602g.getResources().getConfiguration();
            int i5 = configuration2.screenWidthDp;
            int i6 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp <= 600 && i5 <= 600 && ((i5 <= 960 || i6 <= 720) && (i5 <= 720 || i6 <= 960))) {
                if (i5 < 500 && ((i5 <= 640 || i6 <= 480) && (i5 <= 480 || i6 <= 640))) {
                    if (i5 >= 360) {
                        i4 = 3;
                    } else {
                        i4 = 2;
                    }
                } else {
                    i4 = 4;
                }
            } else {
                i4 = 5;
            }
            c0523j.f5615u = i4;
            n nVar = c0523j.f5603h;
            if (nVar != null) {
                nVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0523j c0523j = this.f2302i;
        if (c0523j != null) {
            c0523j.c();
            C0515f c0515f = this.f2302i.f5619y;
            if (c0515f != null && c0515f.b()) {
                c0515f.f5369i.dismiss();
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2305m = false;
        }
        if (!this.f2305m) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f2305m = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f2305m = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i4, int i5, int i6, int i7) {
        int paddingLeft;
        int paddingRight;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean a4 = E1.a(this);
        if (a4) {
            paddingLeft = (i6 - i4) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2308p;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2308p.getLayoutParams();
            if (a4) {
                i8 = marginLayoutParams.rightMargin;
            } else {
                i8 = marginLayoutParams.leftMargin;
            }
            if (a4) {
                i9 = marginLayoutParams.leftMargin;
            } else {
                i9 = marginLayoutParams.rightMargin;
            }
            if (a4) {
                i10 = paddingLeft - i8;
            } else {
                i10 = paddingLeft + i8;
            }
            int g4 = g(this.f2308p, i10, paddingTop, paddingTop2, a4) + i10;
            if (a4) {
                i11 = g4 - i9;
            } else {
                i11 = g4 + i9;
            }
            paddingLeft = i11;
        }
        LinearLayout linearLayout = this.f2311s;
        if (linearLayout != null && this.f2310r == null && linearLayout.getVisibility() != 8) {
            paddingLeft += g(this.f2311s, paddingLeft, paddingTop, paddingTop2, a4);
        }
        View view2 = this.f2310r;
        if (view2 != null) {
            g(view2, paddingLeft, paddingTop, paddingTop2, a4);
        }
        if (a4) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i6 - i4) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f2301h;
        if (actionMenuView != null) {
            g(actionMenuView, paddingRight, paddingTop, paddingTop2, !a4);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        boolean z;
        int i7;
        int i8 = 1073741824;
        if (View.MeasureSpec.getMode(i4) == 1073741824) {
            if (View.MeasureSpec.getMode(i5) != 0) {
                int size = View.MeasureSpec.getSize(i4);
                int i9 = this.f2303j;
                if (i9 <= 0) {
                    i9 = View.MeasureSpec.getSize(i5);
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i10 = i9 - paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
                View view = this.f2308p;
                if (view != null) {
                    int f4 = f(view, paddingLeft, makeMeasureSpec);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2308p.getLayoutParams();
                    paddingLeft = f4 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f2301h;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = f(this.f2301h, paddingLeft, makeMeasureSpec);
                }
                LinearLayout linearLayout = this.f2311s;
                if (linearLayout != null && this.f2310r == null) {
                    if (this.f2316x) {
                        this.f2311s.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f2311s.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f2311s;
                        if (z) {
                            i7 = 0;
                        } else {
                            i7 = 8;
                        }
                        linearLayout2.setVisibility(i7);
                    } else {
                        paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
                    }
                }
                View view2 = this.f2310r;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i11 = layoutParams.width;
                    if (i11 != -2) {
                        i6 = 1073741824;
                    } else {
                        i6 = Integer.MIN_VALUE;
                    }
                    if (i11 >= 0) {
                        paddingLeft = Math.min(i11, paddingLeft);
                    }
                    int i12 = layoutParams.height;
                    if (i12 == -2) {
                        i8 = Integer.MIN_VALUE;
                    }
                    if (i12 >= 0) {
                        i10 = Math.min(i12, i10);
                    }
                    this.f2310r.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i10, i8));
                }
                if (this.f2303j <= 0) {
                    int childCount = getChildCount();
                    int i13 = 0;
                    for (int i14 = 0; i14 < childCount; i14++) {
                        int measuredHeight = getChildAt(i14).getMeasuredHeight() + paddingBottom;
                        if (measuredHeight > i13) {
                            i13 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i13);
                    return;
                }
                setMeasuredDimension(size, i9);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2304l = false;
        }
        if (!this.f2304l) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f2304l = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f2304l = false;
        return true;
    }

    public void setContentHeight(int i4) {
        this.f2303j = i4;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2310r;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2310r = view;
        if (view != null && (linearLayout = this.f2311s) != null) {
            removeView(linearLayout);
            this.f2311s = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2307o = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2306n = charSequence;
        d();
        T.j(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f2316x) {
            requestLayout();
        }
        this.f2316x = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
