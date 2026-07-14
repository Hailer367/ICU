package m;

import a.AbstractC0051a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.icaremc.doctors.R;

/* renamed from: m.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0260g extends C0270q implements InterfaceC0262i {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0261h f3149e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0260g(C0261h c0261h, Context context) {
        super(context, R.attr.actionOverflowButtonStyle);
        this.f3149e = c0261h;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        AbstractC0051a.O(getContentDescription(), this);
        setOnTouchListener(new l.a(this, this));
    }

    @Override // m.InterfaceC0262i
    public final boolean a() {
        return false;
    }

    @Override // m.InterfaceC0262i
    public final boolean c() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f3149e.k();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
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
