package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.icaremc.app.R;

/* renamed from: o.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0469E extends RatingBar {

    /* renamed from: f, reason: collision with root package name */
    public final C0465C f5439f;

    public C0469E(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        m1.a(this, getContext());
        C0465C c0465c = new C0465C(this);
        this.f5439f = c0465c;
        c0465c.b(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        Bitmap bitmap = (Bitmap) this.f5439f.f5423c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i4, 0), getMeasuredHeight());
        }
    }
}
