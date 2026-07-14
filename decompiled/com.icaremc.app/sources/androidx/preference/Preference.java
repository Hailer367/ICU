package androidx.preference;

import A.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.icaremc.app.R;
import e0.AbstractC0274b;
import e0.InterfaceC0273a;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: f, reason: collision with root package name */
    public final Context f3058f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3059g;

    /* renamed from: h, reason: collision with root package name */
    public final CharSequence f3060h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f3061i;

    /* renamed from: j, reason: collision with root package name */
    public final String f3062j;
    public final Object k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC0273a f3063l;

    public Preference(Context context, AttributeSet attributeSet, int i4) {
        this.f3059g = Integer.MAX_VALUE;
        this.f3058f = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0274b.f3591f, i4, 0);
        obtainStyledAttributes.getResourceId(23, obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(26);
        this.f3062j = string == null ? obtainStyledAttributes.getString(6) : string;
        CharSequence text = obtainStyledAttributes.getText(34);
        this.f3060h = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(33);
        this.f3061i = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.f3059g = obtainStyledAttributes.getInt(28, obtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
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
            this.k = c(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.k = c(obtainStyledAttributes, 11);
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
        InterfaceC0273a interfaceC0273a = this.f3063l;
        if (interfaceC0273a != null) {
            return interfaceC0273a.b(this);
        }
        return this.f3061i;
    }

    public void b() {
    }

    public Object c(TypedArray typedArray, int i4) {
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i4 = preference2.f3059g;
        CharSequence charSequence = preference2.f3060h;
        int i5 = this.f3059g;
        if (i5 != i4) {
            return i5 - i4;
        }
        CharSequence charSequence2 = this.f3060h;
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
        CharSequence charSequence = this.f3060h;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence a4 = a();
        if (!TextUtils.isEmpty(a4)) {
            sb.append(a4);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
