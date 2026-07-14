package androidx.preference;

import android.content.Context;
import android.support.v4.media.session.a;
import android.util.AttributeSet;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, a.m(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle), 0);
    }
}
