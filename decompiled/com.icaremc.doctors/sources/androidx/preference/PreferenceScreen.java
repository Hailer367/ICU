package androidx.preference;

import android.content.Context;
import android.support.v4.media.session.a;
import android.util.AttributeSet;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, a.m(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle), 0);
    }
}
