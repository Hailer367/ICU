package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.icaremc.doctors.R;

/* renamed from: m.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0268o {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f3205b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static C0268o f3206c;

    /* renamed from: a, reason: collision with root package name */
    public O f3207a;

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, m.o] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, m.n] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v9, types: [int[], java.io.Serializable] */
    public static synchronized void b() {
        synchronized (C0268o.class) {
            if (f3206c == null) {
                ?? obj = new Object();
                f3206c = obj;
                obj.f3207a = O.b();
                O o2 = f3206c.f3207a;
                ?? obj2 = new Object();
                obj2.f3197a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                obj2.f3198b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                obj2.f3199c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
                obj2.f3200d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                obj2.f3201e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                obj2.f3202f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                synchronized (o2) {
                    o2.f3095e = obj2;
                }
            }
        }
    }

    public static void c(Drawable drawable, h0 h0Var, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = O.f3088f;
        if (AbstractC0277y.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = h0Var.f3174d;
        if (!z && !h0Var.f3173c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilter = null;
        if (z) {
            colorStateList = h0Var.f3171a;
        } else {
            colorStateList = null;
        }
        if (h0Var.f3173c) {
            mode = h0Var.f3172b;
        } else {
            mode = O.f3088f;
        }
        if (colorStateList != null && mode != null) {
            porterDuffColorFilter = O.e(colorStateList.getColorForState(iArr, 0), mode);
        }
        drawable.setColorFilter(porterDuffColorFilter);
    }

    public final synchronized Drawable a(Context context, int i2) {
        return this.f3207a.c(context, i2);
    }
}
