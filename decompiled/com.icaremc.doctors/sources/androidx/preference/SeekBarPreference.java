package androidx.preference;

import X.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: j, reason: collision with root package name */
    public final int f1883j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1884k;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f833i, R.attr.seekBarPreferenceStyle, 0);
        int i2 = obtainStyledAttributes.getInt(3, 0);
        int i3 = obtainStyledAttributes.getInt(1, 100);
        i3 = i3 < i2 ? i2 : i3;
        if (i3 != this.f1883j) {
            this.f1883j = i3;
        }
        int i4 = obtainStyledAttributes.getInt(4, 0);
        if (i4 != this.f1884k) {
            this.f1884k = Math.min(this.f1883j - i2, Math.abs(i4));
        }
        obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }
}
