package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.icaremc.app.R;

/* renamed from: o.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0473G extends SeekBar {

    /* renamed from: f, reason: collision with root package name */
    public final C0475H f5456f;

    public C0473G(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        m1.a(this, getContext());
        C0475H c0475h = new C0475H(this);
        this.f5456f = c0475h;
        c0475h.b(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0475H c0475h = this.f5456f;
        C0473G c0473g = c0475h.f5459e;
        Drawable drawable = c0475h.f5460f;
        if (drawable != null && drawable.isStateful() && drawable.setState(c0473g.getDrawableState())) {
            c0473g.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5456f.f5460f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5456f.g(canvas);
    }
}
