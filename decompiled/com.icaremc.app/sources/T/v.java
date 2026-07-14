package T;

import P1.y;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class v extends ReplacementSpan {

    /* renamed from: g, reason: collision with root package name */
    public final o f1597g;

    /* renamed from: f, reason: collision with root package name */
    public final Paint.FontMetricsInt f1596f = new Paint.FontMetricsInt();

    /* renamed from: h, reason: collision with root package name */
    public float f1598h = 1.0f;

    public v(o oVar) {
        android.support.v4.media.session.a.h(oVar, "metadata cannot be null");
        this.f1597g = oVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i4, int i5, float f4, int i6, int i7, int i8, Paint paint) {
        k.a().getClass();
        o oVar = this.f1597g;
        y yVar = oVar.f1570b;
        Typeface typeface = (Typeface) yVar.f1472i;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) yVar.f1470g, oVar.f1569a * 2, 2, f4, i7, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
        short s3;
        Paint.FontMetricsInt fontMetricsInt2 = this.f1596f;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        o oVar = this.f1597g;
        U.a b4 = oVar.b();
        int a4 = b4.a(14);
        short s4 = 0;
        if (a4 != 0) {
            s3 = ((ByteBuffer) b4.f694d).getShort(a4 + b4.f691a);
        } else {
            s3 = 0;
        }
        this.f1598h = abs / s3;
        U.a b5 = oVar.b();
        int a5 = b5.a(14);
        if (a5 != 0) {
            ((ByteBuffer) b5.f694d).getShort(a5 + b5.f691a);
        }
        U.a b6 = oVar.b();
        int a6 = b6.a(12);
        if (a6 != 0) {
            s4 = ((ByteBuffer) b6.f694d).getShort(a6 + b6.f691a);
        }
        short s5 = (short) (s4 * this.f1598h);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s5;
    }
}
