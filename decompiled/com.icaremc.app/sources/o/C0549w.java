package o;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import i.AbstractC0357a;
import q1.AbstractC0602b;

/* renamed from: o.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0549w {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5723a;

    /* renamed from: b, reason: collision with root package name */
    public final A2.q f5724b;

    public C0549w(TextView textView) {
        this.f5723a = textView;
        this.f5724b = new A2.q(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((AbstractC0602b) this.f5724b.f93g).C(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = this.f5723a.getContext().obtainStyledAttributes(attributeSet, AbstractC0357a.f4074i, i4, 0);
        try {
            boolean z = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            d(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z) {
        ((AbstractC0602b) this.f5724b.f93g).O(z);
    }

    public final void d(boolean z) {
        ((AbstractC0602b) this.f5724b.f93g).P(z);
    }
}
