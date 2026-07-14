package androidx.preference;

import A0.f;
import X.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.common.api.Api;
import com.icaremc.doctors.R;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: c, reason: collision with root package name */
    public final Context f1876c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1877d;

    /* renamed from: e, reason: collision with root package name */
    public final CharSequence f1878e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f1879f;

    /* renamed from: g, reason: collision with root package name */
    public final String f1880g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1881h;

    /* renamed from: i, reason: collision with root package name */
    public f f1882i;

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this.f1877d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f1876c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f830f, i2, 0);
        obtainStyledAttributes.getResourceId(23, obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(26);
        this.f1880g = string == null ? obtainStyledAttributes.getString(6) : string;
        CharSequence text = obtainStyledAttributes.getText(34);
        this.f1878e = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(33);
        this.f1879f = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.f1877d = obtainStyledAttributes.getInt(28, obtainStyledAttributes.getInt(8, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        if (obtainStyledAttributes.getString(22) == null) {
            obtainStyledAttributes.getString(13);
        }
        obtainStyledAttributes.getResourceId(27, obtainStyledAttributes.getResourceId(3, R.layout.preference));
        obtainStyledAttributes.getResourceId(35, obtainStyledAttributes.getResourceId(9, 0));
        obtainStyledAttributes.getBoolean(21, obtainStyledAttributes.getBoolean(2, true));
        boolean z = obtainStyledAttributes.getBoolean(30, obtainStyledAttributes.getBoolean(5, true));
        obtainStyledAttributes.getBoolean(29, obtainStyledAttributes.getBoolean(1, true));
        if (obtainStyledAttributes.getString(19) == null) {
            obtainStyledAttributes.getString(10);
        }
        obtainStyledAttributes.getBoolean(16, obtainStyledAttributes.getBoolean(16, z));
        obtainStyledAttributes.getBoolean(17, obtainStyledAttributes.getBoolean(17, z));
        if (obtainStyledAttributes.hasValue(18)) {
            this.f1881h = c(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.f1881h = c(obtainStyledAttributes, 11);
        }
        obtainStyledAttributes.getBoolean(31, obtainStyledAttributes.getBoolean(12, true));
        if (obtainStyledAttributes.hasValue(32)) {
            obtainStyledAttributes.getBoolean(32, obtainStyledAttributes.getBoolean(14, true));
        }
        obtainStyledAttributes.getBoolean(24, obtainStyledAttributes.getBoolean(15, false));
        obtainStyledAttributes.getBoolean(25, obtainStyledAttributes.getBoolean(25, true));
        obtainStyledAttributes.getBoolean(20, obtainStyledAttributes.getBoolean(20, false));
        obtainStyledAttributes.recycle();
    }

    public CharSequence a() {
        f fVar = this.f1882i;
        if (fVar != null) {
            return fVar.m(this);
        }
        return this.f1879f;
    }

    public void b() {
    }

    public Object c(TypedArray typedArray, int i2) {
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i2 = preference2.f1877d;
        CharSequence charSequence = preference2.f1878e;
        int i3 = this.f1877d;
        if (i3 != i2) {
            return i3 - i2;
        }
        CharSequence charSequence2 = this.f1878e;
        if (charSequence2 == charSequence) {
            return 0;
        }
        if (charSequence2 == null) {
            return 1;
        }
        if (charSequence == null) {
            return -1;
        }
        return charSequence2.toString().compareToIgnoreCase(charSequence.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f1878e;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            sb.append(a2);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v4.media.session.a.m(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
