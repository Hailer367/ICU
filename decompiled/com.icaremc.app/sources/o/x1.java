package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.icaremc.app.R;
import i.AbstractC0357a;

/* loaded from: classes.dex */
public final class x1 implements InterfaceC0538q0 {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f5734a;

    /* renamed from: b, reason: collision with root package name */
    public int f5735b;

    /* renamed from: c, reason: collision with root package name */
    public final View f5736c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f5737d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f5738e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f5739f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5740g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f5741h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f5742i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f5743j;
    public Window.Callback k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5744l;

    /* renamed from: m, reason: collision with root package name */
    public C0523j f5745m;

    /* renamed from: n, reason: collision with root package name */
    public final int f5746n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f5747o;

    public x1(Toolbar toolbar, boolean z) {
        boolean z3;
        Drawable drawable;
        this.f5746n = 0;
        this.f5734a = toolbar;
        this.f5741h = toolbar.getTitle();
        this.f5742i = toolbar.getSubtitle();
        if (this.f5741h != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f5740g = z3;
        this.f5739f = toolbar.getNavigationIcon();
        A2.t P = A2.t.P(toolbar.getContext(), null, AbstractC0357a.f4066a, R.attr.actionBarStyle);
        TypedArray typedArray = (TypedArray) P.f100h;
        int i4 = 15;
        this.f5747o = P.H(15);
        if (z) {
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.f5740g = true;
                Toolbar toolbar2 = this.f5734a;
                this.f5741h = text;
                if ((this.f5735b & 8) != 0) {
                    toolbar2.setTitle(text);
                    if (this.f5740g) {
                        I.T.j(toolbar2.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.f5742i = text2;
                if ((this.f5735b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable H3 = P.H(20);
            if (H3 != null) {
                this.f5738e = H3;
                c();
            }
            Drawable H4 = P.H(17);
            if (H4 != null) {
                this.f5737d = H4;
                c();
            }
            if (this.f5739f == null && (drawable = this.f5747o) != null) {
                this.f5739f = drawable;
                Toolbar toolbar3 = this.f5734a;
                if ((this.f5735b & 4) != 0) {
                    toolbar3.setNavigationIcon(drawable);
                } else {
                    toolbar3.setNavigationIcon((Drawable) null);
                }
            }
            a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f5736c;
                if (view != null && (this.f5735b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f5736c = inflate;
                if (inflate != null && (this.f5735b & 16) != 0) {
                    toolbar.addView(inflate);
                }
                a(this.f5735b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.d();
                toolbar.f2492y.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f2484q = resourceId2;
                C0516f0 c0516f0 = toolbar.f2475g;
                if (c0516f0 != null) {
                    c0516f0.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f2485r = resourceId3;
                C0516f0 c0516f02 = toolbar.f2476h;
                if (c0516f02 != null) {
                    c0516f02.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f5747o = toolbar.getNavigationIcon();
            } else {
                i4 = 11;
            }
            this.f5735b = i4;
        }
        P.T();
        if (R.string.abc_action_bar_up_description != this.f5746n) {
            this.f5746n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i5 = this.f5746n;
                this.f5743j = i5 != 0 ? toolbar.getContext().getString(i5) : null;
                b();
            }
        }
        this.f5743j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new w1(this));
    }

    public final void a(int i4) {
        View view;
        int i5 = this.f5735b ^ i4;
        this.f5735b = i4;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i4 & 4) != 0) {
                    b();
                }
                int i6 = this.f5735b & 4;
                Toolbar toolbar = this.f5734a;
                if (i6 != 0) {
                    Drawable drawable = this.f5739f;
                    if (drawable == null) {
                        drawable = this.f5747o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i5 & 3) != 0) {
                c();
            }
            int i7 = i5 & 8;
            Toolbar toolbar2 = this.f5734a;
            if (i7 != 0) {
                if ((i4 & 8) != 0) {
                    toolbar2.setTitle(this.f5741h);
                    toolbar2.setSubtitle(this.f5742i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i5 & 16) != 0 && (view = this.f5736c) != null) {
                if ((i4 & 16) != 0) {
                    toolbar2.addView(view);
                } else {
                    toolbar2.removeView(view);
                }
            }
        }
    }

    public final void b() {
        if ((this.f5735b & 4) != 0) {
            boolean isEmpty = TextUtils.isEmpty(this.f5743j);
            Toolbar toolbar = this.f5734a;
            if (isEmpty) {
                toolbar.setNavigationContentDescription(this.f5746n);
            } else {
                toolbar.setNavigationContentDescription(this.f5743j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i4 = this.f5735b;
        if ((i4 & 2) != 0) {
            if ((i4 & 1) != 0) {
                drawable = this.f5738e;
                if (drawable == null) {
                    drawable = this.f5737d;
                }
            } else {
                drawable = this.f5737d;
            }
        } else {
            drawable = null;
        }
        this.f5734a.setLogo(drawable);
    }
}
