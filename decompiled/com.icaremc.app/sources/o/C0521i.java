package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.icaremc.app.R;
import f1.AbstractC0286a;
import n.C0452b;

/* renamed from: o.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0521i extends C0555z implements InterfaceC0525k {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ C0523j f5593i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0521i(C0523j c0523j, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f5593i = c0523j;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        AbstractC0286a.H(this, getContentDescription());
        setOnTouchListener(new C0452b(this, this));
    }

    @Override // o.InterfaceC0525k
    public final boolean b() {
        return false;
    }

    @Override // o.InterfaceC0525k
    public final boolean c() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f5593i.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i4, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i4, i5, i6, i7);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
        }
        return frame;
    }
}
