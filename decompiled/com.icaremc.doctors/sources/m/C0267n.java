package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;
import i.AbstractC0203a;
import java.io.Serializable;
import java.util.HashMap;
import x.AbstractC0343a;

/* renamed from: m.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0267n {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f3197a;

    /* renamed from: b, reason: collision with root package name */
    public Serializable f3198b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3199c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f3200d;

    /* renamed from: e, reason: collision with root package name */
    public Serializable f3201e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3202f;

    public static boolean b(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList d(Context context, int i2) {
        int b2 = f0.b(context, R.attr.colorControlHighlight);
        int a2 = f0.a(context, R.attr.colorButtonNormal);
        int[] iArr = f0.f3143b;
        int[] iArr2 = f0.f3145d;
        int a3 = AbstractC0343a.a(b2, i2);
        return new ColorStateList(new int[][]{iArr, iArr2, f0.f3144c, f0.f3147f}, new int[]{a2, a3, AbstractC0343a.a(b2, i2), i2});
    }

    public static void f(Drawable drawable, int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter e2;
        if (AbstractC0277y.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = C0268o.f3205b;
        }
        PorterDuff.Mode mode2 = C0268o.f3205b;
        synchronized (C0268o.class) {
            e2 = O.e(i2, mode);
        }
        drawable.setColorFilter(e2);
    }

    public void a(String str, String str2) {
        HashMap hashMap = (HashMap) this.f3202f;
        if (hashMap != null) {
            hashMap.put(str, str2);
            return;
        }
        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }

    public v0.i c() {
        String str;
        if (((String) this.f3197a) == null) {
            str = " transportName";
        } else {
            str = BuildConfig.FLAVOR;
        }
        if (((v0.m) this.f3199c) == null) {
            str = str.concat(" encodedPayload");
        }
        if (((Long) this.f3200d) == null) {
            str = O.a.f(str, " eventMillis");
        }
        if (((Long) this.f3201e) == null) {
            str = O.a.f(str, " uptimeMillis");
        }
        if (((HashMap) this.f3202f) == null) {
            str = O.a.f(str, " autoMetadata");
        }
        if (str.isEmpty()) {
            return new v0.i((String) this.f3197a, (Integer) this.f3198b, (v0.m) this.f3199c, ((Long) this.f3200d).longValue(), ((Long) this.f3201e).longValue(), (HashMap) this.f3202f);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public ColorStateList e(Context context, int i2) {
        if (i2 == R.drawable.abc_edit_text_material) {
            Object obj = AbstractC0203a.f2329a;
            return context.getColorStateList(R.color.abc_tint_edittext);
        }
        if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
            Object obj2 = AbstractC0203a.f2329a;
            return context.getColorStateList(R.color.abc_tint_switch_track);
        }
        if (i2 == R.drawable.abc_switch_thumb_material) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            ColorStateList c2 = f0.c(context, R.attr.colorSwitchThumbNormal);
            if (c2 != null && c2.isStateful()) {
                int[] iArr3 = f0.f3143b;
                iArr[0] = iArr3;
                iArr2[0] = c2.getColorForState(iArr3, 0);
                iArr[1] = f0.f3146e;
                iArr2[1] = f0.b(context, R.attr.colorControlActivated);
                iArr[2] = f0.f3147f;
                iArr2[2] = c2.getDefaultColor();
            } else {
                iArr[0] = f0.f3143b;
                iArr2[0] = f0.a(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = f0.f3146e;
                iArr2[1] = f0.b(context, R.attr.colorControlActivated);
                iArr[2] = f0.f3147f;
                iArr2[2] = f0.b(context, R.attr.colorSwitchThumbNormal);
            }
            return new ColorStateList(iArr, iArr2);
        }
        if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
            return d(context, f0.b(context, R.attr.colorButtonNormal));
        }
        if (i2 == R.drawable.abc_btn_borderless_material) {
            return d(context, 0);
        }
        if (i2 == R.drawable.abc_btn_colored_material) {
            return d(context, f0.b(context, R.attr.colorAccent));
        }
        if (i2 != R.drawable.abc_spinner_mtrl_am_alpha && i2 != R.drawable.abc_spinner_textfield_background_material) {
            if (b((int[]) this.f3198b, i2)) {
                return f0.c(context, R.attr.colorControlNormal);
            }
            if (b((int[]) this.f3201e, i2)) {
                Object obj3 = AbstractC0203a.f2329a;
                return context.getColorStateList(R.color.abc_tint_default);
            }
            if (b((int[]) this.f3202f, i2)) {
                Object obj4 = AbstractC0203a.f2329a;
                return context.getColorStateList(R.color.abc_tint_btn_checkable);
            }
            if (i2 == R.drawable.abc_seekbar_thumb_material) {
                Object obj5 = AbstractC0203a.f2329a;
                return context.getColorStateList(R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        Object obj6 = AbstractC0203a.f2329a;
        return context.getColorStateList(R.color.abc_tint_spinner);
    }
}
