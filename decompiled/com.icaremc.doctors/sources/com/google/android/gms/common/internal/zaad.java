package com.google.android.gms.common.internal;

import O.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.common.util.DeviceProperties;

/* loaded from: classes.dex */
public final class zaad extends Button {
    public zaad(Context context, AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int zab(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return i5;
                }
                throw new IllegalStateException(a.h(new StringBuilder(String.valueOf(i2).length() + 22), "Unknown color scheme: ", i2));
            }
            return i4;
        }
        return i3;
    }

    public final void zaa(Resources resources, int i2, int i3) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i4 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i4);
        setMinWidth(i4);
        int i5 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark;
        int i6 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light;
        int zab = zab(i3, i5, i6, i6);
        int i7 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_dark;
        int i8 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_light;
        int zab2 = zab(i3, i7, i8, i8);
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 21);
                sb.append("Unknown button size: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            }
        } else {
            zab = zab2;
        }
        Drawable drawable = resources.getDrawable(zab);
        drawable.setTintList(resources.getColorStateList(com.google.android.gms.base.R.color.common_google_signin_btn_tint));
        drawable.setTintMode(PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawable);
        int i9 = com.google.android.gms.base.R.color.common_google_signin_btn_text_dark;
        int i10 = com.google.android.gms.base.R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i3, i9, i10, i10))));
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    setText((CharSequence) null);
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 21);
                    sb2.append("Unknown button size: ");
                    sb2.append(i2);
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text_long));
            }
        } else {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text));
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
