package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.icaremc.app.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import n0.AbstractC0459a;
import t.AbstractC0659h;
import t.C0658g;
import t.C0660i;
import t.C0662k;
import u.AbstractC0665a;

/* loaded from: classes.dex */
public final class U0 {

    /* renamed from: g, reason: collision with root package name */
    public static U0 f5527g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f5529a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f5530b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f5531c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5532d;

    /* renamed from: e, reason: collision with root package name */
    public I0.h f5533e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f5526f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final T0 f5528h = new C0660i(6);

    public static synchronized U0 b() {
        U0 u0;
        synchronized (U0.class) {
            try {
                if (f5527g == null) {
                    f5527g = new U0();
                }
                u0 = f5527g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return u0;
    }

    public static synchronized PorterDuffColorFilter e(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (U0.class) {
            T0 t02 = f5528h;
            t02.getClass();
            int i5 = (31 + i4) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) t02.a(Integer.valueOf(mode.hashCode() + i5));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i4, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i4) {
        Drawable drawable;
        Object obj;
        if (this.f5531c == null) {
            this.f5531c = new TypedValue();
        }
        TypedValue typedValue = this.f5531c;
        context.getResources().getValue(i4, typedValue, true);
        long j4 = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            C0658g c0658g = (C0658g) this.f5530b.get(context);
            drawable = null;
            if (c0658g != null) {
                int b4 = AbstractC0665a.b(c0658g.f6183g, c0658g.f6185i, j4);
                if (b4 < 0 || (obj = c0658g.f6184h[b4]) == AbstractC0659h.f6186a) {
                    obj = null;
                }
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference != null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                    if (constantState != null) {
                        drawable = constantState.newDrawable(context.getResources());
                    } else {
                        int b5 = AbstractC0665a.b(c0658g.f6183g, c0658g.f6185i, j4);
                        if (b5 >= 0) {
                            Object[] objArr = c0658g.f6184h;
                            Object obj2 = objArr[b5];
                            Object obj3 = AbstractC0659h.f6186a;
                            if (obj2 != obj3) {
                                objArr[b5] = obj3;
                                c0658g.f6182f = true;
                            }
                        }
                    }
                }
            }
        }
        if (drawable != null) {
            return drawable;
        }
        LayerDrawable layerDrawable = null;
        if (this.f5533e != null) {
            if (i4 == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i4 == R.drawable.abc_ratingbar_material) {
                layerDrawable = I0.h.l(this, context, R.dimen.abc_star_big);
            } else if (i4 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawable = I0.h.l(this, context, R.dimen.abc_star_medium);
            } else if (i4 == R.drawable.abc_ratingbar_small_material) {
                layerDrawable = I0.h.l(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            synchronized (this) {
                try {
                    Drawable.ConstantState constantState2 = layerDrawable.getConstantState();
                    if (constantState2 != null) {
                        C0658g c0658g2 = (C0658g) this.f5530b.get(context);
                        if (c0658g2 == null) {
                            c0658g2 = new C0658g();
                            this.f5530b.put(context, c0658g2);
                        }
                        c0658g2.a(j4, new WeakReference(constantState2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return layerDrawable;
        }
        return layerDrawable;
    }

    public final synchronized Drawable c(Context context, int i4) {
        return d(context, i4, false);
    }

    public final synchronized Drawable d(Context context, int i4, boolean z) {
        Drawable a4;
        try {
            if (!this.f5532d) {
                this.f5532d = true;
                Drawable c4 = c(context, R.drawable.abc_vector_test);
                if (c4 == null || (!(c4 instanceof AbstractC0459a) && !"android.graphics.drawable.VectorDrawable".equals(c4.getClass().getName()))) {
                    this.f5532d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            a4 = a(context, i4);
            if (a4 == null) {
                a4 = context.getDrawable(i4);
            }
            if (a4 != null) {
                a4 = g(context, i4, z, a4);
            }
            if (a4 != null) {
                AbstractC0546u0.a(a4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a4;
    }

    public final synchronized ColorStateList f(Context context, int i4) {
        ColorStateList colorStateList;
        C0662k c0662k;
        Object obj;
        WeakHashMap weakHashMap = this.f5529a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap != null && (c0662k = (C0662k) weakHashMap.get(context)) != null) {
            int a4 = AbstractC0665a.a(c0662k.f6199h, i4, c0662k.f6197f);
            if (a4 < 0 || (obj = c0662k.f6198g[a4]) == AbstractC0659h.f6187b) {
                obj = null;
            }
            colorStateList = (ColorStateList) obj;
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            I0.h hVar = this.f5533e;
            if (hVar != null) {
                colorStateList2 = hVar.m(context, i4);
            }
            if (colorStateList2 != null) {
                if (this.f5529a == null) {
                    this.f5529a = new WeakHashMap();
                }
                C0662k c0662k2 = (C0662k) this.f5529a.get(context);
                if (c0662k2 == null) {
                    c0662k2 = new C0662k();
                    this.f5529a.put(context, c0662k2);
                }
                c0662k2.a(i4, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r10, int r11, boolean r12, android.graphics.drawable.Drawable r13) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.U0.g(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
