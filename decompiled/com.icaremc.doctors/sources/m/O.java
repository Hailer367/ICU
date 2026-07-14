package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.icaremc.doctors.R;
import f0.AbstractC0197a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import r.AbstractC0296h;
import r.C0295g;
import s.AbstractC0298a;

/* loaded from: classes.dex */
public final class O {

    /* renamed from: g, reason: collision with root package name */
    public static O f3089g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f3091a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f3092b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f3093c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3094d;

    /* renamed from: e, reason: collision with root package name */
    public C0267n f3095e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f3088f = PorterDuff.Mode.SRC_IN;

    /* renamed from: h, reason: collision with root package name */
    public static final N f3090h = new r.i(6);

    public static synchronized O b() {
        O o2;
        synchronized (O.class) {
            try {
                if (f3089g == null) {
                    f3089g = new O();
                }
                o2 = f3089g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return o2;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (O.class) {
            N n2 = f3090h;
            n2.getClass();
            int i3 = (31 + i2) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) n2.get(Integer.valueOf(mode.hashCode() + i3));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i2) {
        Drawable drawable;
        if (this.f3093c == null) {
            this.f3093c = new TypedValue();
        }
        TypedValue typedValue = this.f3093c;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            C0295g c0295g = (C0295g) this.f3092b.get(context);
            drawable = null;
            if (c0295g != null) {
                WeakReference weakReference = (WeakReference) c0295g.b(j2);
                if (weakReference != null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                    if (constantState != null) {
                        drawable = constantState.newDrawable(context.getResources());
                    } else {
                        int b2 = AbstractC0298a.b(c0295g.f3566d, c0295g.f3568f, j2);
                        if (b2 >= 0) {
                            Object[] objArr = c0295g.f3567e;
                            Object obj = objArr[b2];
                            Object obj2 = AbstractC0296h.f3569a;
                            if (obj != obj2) {
                                objArr[b2] = obj2;
                                c0295g.f3565c = true;
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
        if (this.f3095e != null && i2 == R.drawable.abc_cab_background_top_material) {
            layerDrawable = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            synchronized (this) {
                try {
                    Drawable.ConstantState constantState2 = layerDrawable.getConstantState();
                    if (constantState2 != null) {
                        C0295g c0295g2 = (C0295g) this.f3092b.get(context);
                        if (c0295g2 == null) {
                            c0295g2 = new C0295g();
                            this.f3092b.put(context, c0295g2);
                        }
                        c0295g2.d(j2, new WeakReference(constantState2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return layerDrawable;
        }
        return layerDrawable;
    }

    public final synchronized Drawable c(Context context, int i2) {
        return d(context, i2);
    }

    public final synchronized Drawable d(Context context, int i2) {
        Drawable a2;
        try {
            if (!this.f3094d) {
                this.f3094d = true;
                Drawable c2 = c(context, R.drawable.abc_vector_test);
                if (c2 == null || (!(c2 instanceof AbstractC0197a) && !"android.graphics.drawable.VectorDrawable".equals(c2.getClass().getName()))) {
                    this.f3094d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            a2 = a(context, i2);
            if (a2 == null) {
                a2 = context.getDrawable(i2);
            }
            if (a2 != null) {
                a2 = g(context, i2, a2);
            }
            if (a2 != null) {
                Rect rect = AbstractC0277y.f3279a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return a2;
    }

    public final synchronized ColorStateList f(Context context, int i2) {
        ColorStateList colorStateList;
        r.k kVar;
        Object obj;
        WeakHashMap weakHashMap = this.f3091a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap != null && (kVar = (r.k) weakHashMap.get(context)) != null) {
            int a2 = AbstractC0298a.a(kVar.f3576e, i2, kVar.f3574c);
            if (a2 < 0 || (obj = kVar.f3575d[a2]) == AbstractC0296h.f3570b) {
                obj = null;
            }
            colorStateList = (ColorStateList) obj;
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            C0267n c0267n = this.f3095e;
            if (c0267n != null) {
                colorStateList2 = c0267n.e(context, i2);
            }
            if (colorStateList2 != null) {
                if (this.f3091a == null) {
                    this.f3091a = new WeakHashMap();
                }
                r.k kVar2 = (r.k) this.f3091a.get(context);
                if (kVar2 == null) {
                    kVar2 = new r.k();
                    this.f3091a.put(context, kVar2);
                }
                kVar2.a(i2, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r9, int r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.O.g(android.content.Context, int, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
