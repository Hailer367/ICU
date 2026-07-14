package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.icaremc.app.R;
import e0.AbstractC0274b;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: m, reason: collision with root package name */
    public final int f3064m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3065n;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0274b.f3594i, R.attr.seekBarPreferenceStyle, 0);
        int i4 = obtainStyledAttributes.getInt(3, 0);
        int i5 = obtainStyledAttributes.getInt(1, 100);
        i5 = i5 < i4 ? i4 : i5;
        if (i5 != this.f3064m) {
            this.f3064m = i5;
        }
        int i6 = obtainStyledAttributes.getInt(4, 0);
        if (i6 != this.f3065n) {
            this.f3065n = Math.min(this.f3064m - i4, Math.abs(i6));
        }
        obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.getBoolean(5, false);
        obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInt(i4, 0));
    }
}
