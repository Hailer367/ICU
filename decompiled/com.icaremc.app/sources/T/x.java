package T;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class x implements Spannable {

    /* renamed from: f, reason: collision with root package name */
    public boolean f1599f = false;

    /* renamed from: g, reason: collision with root package name */
    public Spannable f1600g;

    public x(Spannable spannable) {
        this.f1600g = spannable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [Z0.g] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final void a() {
        ?? r12;
        Spannable spannable = this.f1600g;
        if (!this.f1599f) {
            if (Build.VERSION.SDK_INT < 28) {
                r12 = new Object();
            } else {
                r12 = new Object();
            }
            if (r12.g(spannable)) {
                this.f1600g = new SpannableString(spannable);
            }
        }
        this.f1599f = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i4) {
        return this.f1600g.charAt(i4);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f1600g.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f1600g.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f1600g.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f1600g.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f1600g.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i4, int i5, Class cls) {
        return this.f1600g.getSpans(i4, i5, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1600g.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i4, int i5, Class cls) {
        return this.f1600g.nextSpanTransition(i4, i5, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f1600g.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i4, int i5, int i6) {
        a();
        this.f1600g.setSpan(obj, i4, i5, i6);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i4, int i5) {
        return this.f1600g.subSequence(i4, i5);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f1600g.toString();
    }

    public x(CharSequence charSequence) {
        this.f1600g = new SpannableString(charSequence);
    }
}
