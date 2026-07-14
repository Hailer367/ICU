package m;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final class o0 implements InterfaceC0276x {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f3208a;

    /* renamed from: b, reason: collision with root package name */
    public int f3209b;

    /* renamed from: c, reason: collision with root package name */
    public View f3210c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f3211d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f3212e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f3213f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3214g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f3215h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f3216i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f3217j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f3218k;

    /* renamed from: l, reason: collision with root package name */
    public int f3219l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f3220m;

    public final void a(int i2) {
        View view;
        Toolbar toolbar = this.f3208a;
        int i3 = this.f3209b ^ i2;
        this.f3209b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    b();
                }
                Toolbar toolbar2 = this.f3208a;
                if ((this.f3209b & 4) != 0) {
                    Drawable drawable = this.f3213f;
                    if (drawable == null) {
                        drawable = this.f3220m;
                    }
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            if ((i3 & 3) != 0) {
                c();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    toolbar.setTitle(this.f3215h);
                    toolbar.setSubtitle(this.f3216i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.f3210c) != null) {
                if ((i2 & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
        }
    }

    public final void b() {
        Toolbar toolbar = this.f3208a;
        if ((this.f3209b & 4) != 0) {
            if (TextUtils.isEmpty(this.f3217j)) {
                toolbar.setNavigationContentDescription(this.f3219l);
            } else {
                toolbar.setNavigationContentDescription(this.f3217j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i2 = this.f3209b;
        if ((i2 & 2) != 0) {
            if ((i2 & 1) != 0) {
                drawable = this.f3212e;
                if (drawable == null) {
                    drawable = this.f3211d;
                }
            } else {
                drawable = this.f3211d;
            }
        } else {
            drawable = null;
        }
        this.f3208a.setLogo(drawable);
    }
}
