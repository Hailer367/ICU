package o;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import f1.AbstractC0286a;
import i.AbstractC0357a;

/* renamed from: o.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0553y {

    /* renamed from: a, reason: collision with root package name */
    public int f5748a = 0;

    /* renamed from: b, reason: collision with root package name */
    public KeyEvent.Callback f5749b;

    /* renamed from: c, reason: collision with root package name */
    public Object f5750c;

    public C0553y(ImageView imageView) {
        this.f5749b = imageView;
    }

    public void a() {
        o1 o1Var;
        ImageView imageView = (ImageView) this.f5749b;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            AbstractC0546u0.a(drawable);
        }
        if (drawable != null && (o1Var = (o1) this.f5750c) != null) {
            C0543t.d(drawable, o1Var, imageView.getDrawableState());
        }
    }

    public int b() {
        int contentSensitivity;
        int i4 = this.f5748a;
        if (Build.VERSION.SDK_INT >= 35) {
            View findViewById = ((Activity) this.f5749b).findViewById(i4);
            if (findViewById != null) {
                contentSensitivity = findViewById.getContentSensitivity();
                return contentSensitivity;
            }
            throw new IllegalArgumentException("FlutterView with ID " + i4 + "not found");
        }
        return 2;
    }

    public void c(AttributeSet attributeSet, int i4) {
        int resourceId;
        ImageView imageView = (ImageView) this.f5749b;
        Context context = imageView.getContext();
        int[] iArr = AbstractC0357a.f4071f;
        A2.t P = A2.t.P(context, attributeSet, iArr, i4);
        TypedArray typedArray = (TypedArray) P.f100h;
        I.T.h(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) P.f100h, i4);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = AbstractC0286a.o(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC0546u0.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(P.G(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(AbstractC0546u0.c(typedArray.getInt(3, -1), null));
            }
            P.T();
        } catch (Throwable th) {
            P.T();
            throw th;
        }
    }

    public void d(int i4) {
        int contentSensitivity;
        int i5 = this.f5748a;
        if (Build.VERSION.SDK_INT >= 35) {
            View findViewById = ((Activity) this.f5749b).findViewById(i5);
            if (findViewById != null) {
                contentSensitivity = findViewById.getContentSensitivity();
                if (contentSensitivity != i4) {
                    findViewById.setContentSensitivity(i4);
                    findViewById.invalidate();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("FlutterView with ID " + i5 + "not found");
        }
        throw new IllegalStateException("isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.");
    }
}
