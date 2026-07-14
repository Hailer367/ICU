package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import com.icaremc.app.R;

/* renamed from: o.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0543t {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f5707b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static C0543t f5708c;

    /* renamed from: a, reason: collision with root package name */
    public U0 f5709a;

    public static synchronized C0543t a() {
        C0543t c0543t;
        synchronized (C0543t.class) {
            try {
                if (f5708c == null) {
                    c();
                }
                c0543t = f5708c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0543t;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [o.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [I0.h, java.lang.Object] */
    public static synchronized void c() {
        synchronized (C0543t.class) {
            if (f5708c == null) {
                ?? obj = new Object();
                f5708c = obj;
                obj.f5709a = U0.b();
                U0 u0 = f5708c.f5709a;
                ?? obj2 = new Object();
                obj2.f819a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                obj2.f820b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                obj2.f821c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                obj2.f822d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                obj2.f823e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                obj2.f824f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                synchronized (u0) {
                    u0.f5533e = obj2;
                }
            }
        }
    }

    public static void d(Drawable drawable, o1 o1Var, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = U0.f5526f;
        int[] state = drawable.getState();
        int[] iArr2 = AbstractC0546u0.f5713a;
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = o1Var.f5678d;
            if (!z && !o1Var.f5677c) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilter = null;
            if (z) {
                colorStateList = o1Var.f5675a;
            } else {
                colorStateList = null;
            }
            if (o1Var.f5677c) {
                mode = o1Var.f5676b;
            } else {
                mode = U0.f5526f;
            }
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = U0.e(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public final synchronized Drawable b(Context context, int i4) {
        return this.f5709a.c(context, i4);
    }
}
