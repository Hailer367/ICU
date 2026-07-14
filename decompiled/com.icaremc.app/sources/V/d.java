package V;

import T.k;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f1658a;

    /* renamed from: b, reason: collision with root package name */
    public c f1659b;

    public d(TextView textView) {
        this.f1658a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i4, int i5, Spanned spanned, int i6, int i7) {
        TextView textView = this.f1658a;
        if (!textView.isInEditMode()) {
            int b4 = k.a().b();
            if (b4 != 0) {
                if (b4 != 1) {
                    if (b4 != 3) {
                        return charSequence;
                    }
                } else {
                    if ((i7 != 0 || i6 != 0 || spanned.length() != 0 || charSequence != textView.getText()) && charSequence != null) {
                        if (i4 != 0 || i5 != charSequence.length()) {
                            charSequence = charSequence.subSequence(i4, i5);
                        }
                        return k.a().e(charSequence, 0, charSequence.length());
                    }
                    return charSequence;
                }
            }
            k a4 = k.a();
            if (this.f1659b == null) {
                this.f1659b = new c(textView, this);
            }
            a4.f(this.f1659b);
            return charSequence;
        }
        return charSequence;
    }
}
