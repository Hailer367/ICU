package androidx.preference;

import A.b;
import Z0.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import com.icaremc.app.R;
import e0.AbstractC0274b;
import e0.InterfaceC0273a;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence[] f3056m;

    /* renamed from: n, reason: collision with root package name */
    public final String f3057n;

    /* JADX WARN: Type inference failed for: r2v9, types: [Z0.g, java.lang.Object] */
    public ListPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0274b.f3589d, i4, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.f3056m = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        if (obtainStyledAttributes.getTextArray(3) == null) {
            obtainStyledAttributes.getTextArray(1);
        }
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            if (g.f2140g == null) {
                g.f2140g = new Object();
            }
            this.f3063l = g.f2140g;
            b();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0274b.f3591f, i4, 0);
        String string = obtainStyledAttributes2.getString(33);
        this.f3057n = string == null ? obtainStyledAttributes2.getString(7) : string;
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence a() {
        InterfaceC0273a interfaceC0273a = this.f3063l;
        if (interfaceC0273a != null) {
            return interfaceC0273a.b(this);
        }
        CharSequence a4 = super.a();
        String str = this.f3057n;
        if (str != null) {
            String format = String.format(str, "");
            if (!TextUtils.equals(format, a4)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return format;
            }
        }
        return a4;
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i4) {
        return typedArray.getString(i4);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
