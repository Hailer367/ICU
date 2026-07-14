package o;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;

/* renamed from: o.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0518g0 {
    public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i4, TextView textView, TextPaint textPaint) {
        return new StaticLayout(charSequence, textPaint, i4, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
    }

    public static int b(TextView textView) {
        return textView.getMaxLines();
    }
}
