package G;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f550a;

    /* renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f551b;

    /* renamed from: c, reason: collision with root package name */
    public final int f552c;

    /* renamed from: d, reason: collision with root package name */
    public final int f553d;

    public c(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i4, int i5) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = b.i(textPaint).setBreakStrategy(i4);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i5);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f550a = textPaint;
        this.f551b = textDirectionHeuristic;
        this.f552c = i4;
        this.f553d = i5;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                int i4 = cVar.f552c;
                TextPaint textPaint = cVar.f550a;
                if (this.f552c == i4 && this.f553d == cVar.f553d) {
                    TextPaint textPaint2 = this.f550a;
                    if (textPaint2.getTextSize() == textPaint.getTextSize() && textPaint2.getTextScaleX() == textPaint.getTextScaleX() && textPaint2.getTextSkewX() == textPaint.getTextSkewX() && textPaint2.getLetterSpacing() == textPaint.getLetterSpacing() && TextUtils.equals(textPaint2.getFontFeatureSettings(), textPaint.getFontFeatureSettings()) && textPaint2.getFlags() == textPaint.getFlags() && textPaint2.getTextLocales().equals(textPaint.getTextLocales())) {
                        if (textPaint2.getTypeface() == null) {
                            if (textPaint.getTypeface() != null) {
                                return false;
                            }
                        } else if (!textPaint2.getTypeface().equals(textPaint.getTypeface())) {
                            return false;
                        }
                        if (this.f551b == cVar.f551b) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f550a;
        return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f551b, Integer.valueOf(this.f552c), Integer.valueOf(this.f553d));
    }

    public final String toString() {
        String fontVariationSettings;
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f550a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        int i4 = Build.VERSION.SDK_INT;
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i4 >= 26) {
            StringBuilder sb3 = new StringBuilder(", variationSettings=");
            fontVariationSettings = textPaint.getFontVariationSettings();
            sb3.append(fontVariationSettings);
            sb.append(sb3.toString());
        }
        sb.append(", textDir=" + this.f551b);
        sb.append(", breakStrategy=" + this.f552c);
        sb.append(", hyphenationFrequency=" + this.f553d);
        sb.append("}");
        return sb.toString();
    }

    public c(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f550a = textPaint;
        textDirection = params.getTextDirection();
        this.f551b = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f552c = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f553d = hyphenationFrequency;
    }
}
