package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import f1.AbstractC0286a;

/* renamed from: o.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0555z extends ImageView {

    /* renamed from: f, reason: collision with root package name */
    public final C0533o f5753f;

    /* renamed from: g, reason: collision with root package name */
    public final C0553y f5754g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5755h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0555z(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        n1.a(context);
        this.f5755h = false;
        m1.a(this, getContext());
        C0533o c0533o = new C0533o(this);
        this.f5753f = c0533o;
        c0533o.d(attributeSet, i4);
        C0553y c0553y = new C0553y(this);
        this.f5754g = c0553y;
        c0553y.c(attributeSet, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            c0533o.a();
        }
        C0553y c0553y = this.f5754g;
        if (c0553y != null) {
            c0553y.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            return c0533o.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            return c0533o.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        o1 o1Var;
        C0553y c0553y = this.f5754g;
        if (c0553y == null || (o1Var = (o1) c0553y.f5750c) == null) {
            return null;
        }
        return o1Var.f5675a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        o1 o1Var;
        C0553y c0553y = this.f5754g;
        if (c0553y == null || (o1Var = (o1) c0553y.f5750c) == null) {
            return null;
        }
        return o1Var.f5676b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        if (!(((ImageView) this.f5754g.f5749b).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            c0533o.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            c0533o.f(i4);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0553y c0553y = this.f5754g;
        if (c0553y != null) {
            c0553y.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0553y c0553y = this.f5754g;
        if (c0553y != null && drawable != null && !this.f5755h) {
            c0553y.f5748a = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (c0553y != null) {
            c0553y.a();
            if (!this.f5755h) {
                ImageView imageView = (ImageView) c0553y.f5749b;
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setLevel(c0553y.f5748a);
                }
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i4) {
        super.setImageLevel(i4);
        this.f5755h = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        C0553y c0553y = this.f5754g;
        if (c0553y != null) {
            ImageView imageView = (ImageView) c0553y.f5749b;
            if (i4 != 0) {
                Drawable o3 = AbstractC0286a.o(imageView.getContext(), i4);
                if (o3 != null) {
                    AbstractC0546u0.a(o3);
                }
                imageView.setImageDrawable(o3);
            } else {
                imageView.setImageDrawable(null);
            }
            c0553y.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0553y c0553y = this.f5754g;
        if (c0553y != null) {
            c0553y.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            c0533o.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0533o c0533o = this.f5753f;
        if (c0533o != null) {
            c0533o.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0553y c0553y = this.f5754g;
        if (c0553y != null) {
            if (((o1) c0553y.f5750c) == null) {
                c0553y.f5750c = new Object();
            }
            o1 o1Var = (o1) c0553y.f5750c;
            o1Var.f5675a = colorStateList;
            o1Var.f5678d = true;
            c0553y.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0553y c0553y = this.f5754g;
        if (c0553y != null) {
            if (((o1) c0553y.f5750c) == null) {
                c0553y.f5750c = new Object();
            }
            o1 o1Var = (o1) c0553y.f5750c;
            o1Var.f5676b = mode;
            o1Var.f5677c = true;
            c0553y.a();
        }
    }
}
