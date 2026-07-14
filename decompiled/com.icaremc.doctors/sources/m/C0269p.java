package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.icaremc.doctors.R;
import i.AbstractC0203a;

/* renamed from: m.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0269p extends ImageButton {

    /* renamed from: c, reason: collision with root package name */
    public final C0266m f3221c;

    /* renamed from: d, reason: collision with root package name */
    public final B.c f3222d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0269p(Context context) {
        super(context, null, R.attr.toolbarNavigationButtonStyle);
        g0.a(context);
        C0266m c0266m = new C0266m(this);
        this.f3221c = c0266m;
        c0266m.b(null, R.attr.toolbarNavigationButtonStyle);
        B.c cVar = new B.c(this);
        this.f3222d = cVar;
        cVar.d(R.attr.toolbarNavigationButtonStyle);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0266m c0266m = this.f3221c;
        if (c0266m != null) {
            c0266m.a();
        }
        B.c cVar = this.f3222d;
        if (cVar != null) {
            cVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        h0 h0Var;
        C0266m c0266m = this.f3221c;
        if (c0266m == null || (h0Var = c0266m.f3195e) == null) {
            return null;
        }
        return h0Var.f3171a;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        h0 h0Var;
        C0266m c0266m = this.f3221c;
        if (c0266m == null || (h0Var = c0266m.f3195e) == null) {
            return null;
        }
        return h0Var.f3172b;
    }

    public ColorStateList getSupportImageTintList() {
        h0 h0Var;
        B.c cVar = this.f3222d;
        if (cVar == null || (h0Var = (h0) cVar.f40e) == null) {
            return null;
        }
        return h0Var.f3171a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        h0 h0Var;
        B.c cVar = this.f3222d;
        if (cVar == null || (h0Var = (h0) cVar.f40e) == null) {
            return null;
        }
        return h0Var.f3172b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        if (!(((ImageView) this.f3222d.f39d).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0266m c0266m = this.f3221c;
        if (c0266m != null) {
            c0266m.f3193c = -1;
            c0266m.d(null);
            c0266m.a();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0266m c0266m = this.f3221c;
        if (c0266m != null) {
            c0266m.c(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        B.c cVar = this.f3222d;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        B.c cVar = this.f3222d;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        B.c cVar = this.f3222d;
        ImageView imageView = (ImageView) cVar.f39d;
        if (i2 != 0) {
            Drawable a2 = AbstractC0203a.a(imageView.getContext(), i2);
            if (a2 != null) {
                Rect rect = AbstractC0277y.f3279a;
            }
            imageView.setImageDrawable(a2);
        } else {
            imageView.setImageDrawable(null);
        }
        cVar.a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        B.c cVar = this.f3222d;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0266m c0266m = this.f3221c;
        if (c0266m != null) {
            c0266m.e(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0266m c0266m = this.f3221c;
        if (c0266m != null) {
            c0266m.f(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        B.c cVar = this.f3222d;
        if (cVar != null) {
            if (((h0) cVar.f40e) == null) {
                cVar.f40e = new Object();
            }
            h0 h0Var = (h0) cVar.f40e;
            h0Var.f3171a = colorStateList;
            h0Var.f3174d = true;
            cVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        B.c cVar = this.f3222d;
        if (cVar != null) {
            if (((h0) cVar.f40e) == null) {
                cVar.f40e = new Object();
            }
            h0 h0Var = (h0) cVar.f40e;
            h0Var.f3172b = mode;
            h0Var.f3173c = true;
            cVar.a();
        }
    }
}
