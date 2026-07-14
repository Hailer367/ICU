package androidx.preference;

import A0.f;
import X.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import com.google.firebase.encoders.json.BuildConfig;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence[] f1874j;

    /* renamed from: k, reason: collision with root package name */
    public final String f1875k;

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f828d, i2, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.f1874j = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        if (obtainStyledAttributes.getTextArray(3) == null) {
            obtainStyledAttributes.getTextArray(1);
        }
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            if (f.f27e == null) {
                f.f27e = new f(6);
            }
            this.f1882i = f.f27e;
            b();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.f830f, i2, 0);
        String string = obtainStyledAttributes2.getString(33);
        this.f1875k = string == null ? obtainStyledAttributes2.getString(7) : string;
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence a() {
        f fVar = this.f1882i;
        if (fVar != null) {
            return fVar.m(this);
        }
        CharSequence a2 = super.a();
        String str = this.f1875k;
        if (str != null) {
            String format = String.format(str, BuildConfig.FLAVOR);
            if (!TextUtils.equals(format, a2)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return format;
            }
        }
        return a2;
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v4.media.session.a.m(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
