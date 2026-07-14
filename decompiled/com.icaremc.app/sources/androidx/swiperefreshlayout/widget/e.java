package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public final class e extends Drawable implements Animatable {

    /* renamed from: l, reason: collision with root package name */
    public static final LinearInterpolator f3170l = new LinearInterpolator();

    /* renamed from: m, reason: collision with root package name */
    public static final Z.a f3171m = new Z.a(Z.a.f2085c);

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f3172n = {-16777216};

    /* renamed from: f, reason: collision with root package name */
    public final d f3173f;

    /* renamed from: g, reason: collision with root package name */
    public float f3174g;

    /* renamed from: h, reason: collision with root package name */
    public final Resources f3175h;

    /* renamed from: i, reason: collision with root package name */
    public final ValueAnimator f3176i;

    /* renamed from: j, reason: collision with root package name */
    public float f3177j;
    public boolean k;

    public e(Context context) {
        context.getClass();
        this.f3175h = context.getResources();
        d dVar = new d();
        this.f3173f = dVar;
        dVar.f3158i = f3172n;
        dVar.a(0);
        dVar.f3157h = 2.5f;
        dVar.f3151b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, dVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3170l);
        ofFloat.addListener(new c(this, dVar));
        this.f3176i = ofFloat;
    }

    public static void d(float f4, d dVar) {
        if (f4 > 0.75f) {
            float f5 = (f4 - 0.75f) / 0.25f;
            int[] iArr = dVar.f3158i;
            int i4 = dVar.f3159j;
            int i5 = iArr[i4];
            int i6 = iArr[(i4 + 1) % iArr.length];
            dVar.f3169u = ((((i5 >> 24) & 255) + ((int) ((((i6 >> 24) & 255) - r1) * f5))) << 24) | ((((i5 >> 16) & 255) + ((int) ((((i6 >> 16) & 255) - r3) * f5))) << 16) | ((((i5 >> 8) & 255) + ((int) ((((i6 >> 8) & 255) - r4) * f5))) << 8) | ((i5 & 255) + ((int) (f5 * ((i6 & 255) - r2))));
            return;
        }
        dVar.f3169u = dVar.f3158i[dVar.f3159j];
    }

    public final void a(float f4, d dVar, boolean z) {
        float interpolation;
        float f5;
        if (this.k) {
            d(f4, dVar);
            float floor = (float) (Math.floor(dVar.f3161m / 0.8f) + 1.0d);
            float f6 = dVar.k;
            float f7 = dVar.f3160l;
            dVar.f3154e = (((f7 - 0.01f) - f6) * f4) + f6;
            dVar.f3155f = f7;
            float f8 = dVar.f3161m;
            dVar.f3156g = ((floor - f8) * f4) + f8;
            return;
        }
        if (f4 == 1.0f && !z) {
            return;
        }
        float f9 = dVar.f3161m;
        Z.a aVar = f3171m;
        if (f4 < 0.5f) {
            interpolation = dVar.k;
            f5 = (aVar.getInterpolation(f4 / 0.5f) * 0.79f) + 0.01f + interpolation;
        } else {
            float f10 = dVar.k + 0.79f;
            interpolation = f10 - (((1.0f - aVar.getInterpolation((f4 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            f5 = f10;
        }
        float f11 = (0.20999998f * f4) + f9;
        float f12 = (f4 + this.f3177j) * 216.0f;
        dVar.f3154e = interpolation;
        dVar.f3155f = f5;
        dVar.f3156g = f11;
        this.f3174g = f12;
    }

    public final void b(float f4, float f5, float f6, float f7) {
        float f8 = this.f3175h.getDisplayMetrics().density;
        float f9 = f5 * f8;
        d dVar = this.f3173f;
        dVar.f3157h = f9;
        dVar.f3151b.setStrokeWidth(f9);
        dVar.f3165q = f4 * f8;
        dVar.a(0);
        dVar.f3166r = (int) (f6 * f8);
        dVar.f3167s = (int) (f7 * f8);
    }

    public final void c(int i4) {
        if (i4 == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3174g, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f3173f;
        Paint paint = dVar.f3151b;
        RectF rectF = dVar.f3150a;
        float f4 = dVar.f3165q;
        float f5 = (dVar.f3157h / 2.0f) + f4;
        if (f4 <= 0.0f) {
            f5 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((dVar.f3166r * dVar.f3164p) / 2.0f, dVar.f3157h / 2.0f);
        }
        rectF.set(bounds.centerX() - f5, bounds.centerY() - f5, bounds.centerX() + f5, bounds.centerY() + f5);
        float f6 = dVar.f3154e;
        float f7 = dVar.f3156g;
        float f8 = (f6 + f7) * 360.0f;
        float f9 = ((dVar.f3155f + f7) * 360.0f) - f8;
        paint.setColor(dVar.f3169u);
        paint.setAlpha(dVar.f3168t);
        float f10 = dVar.f3157h / 2.0f;
        rectF.inset(f10, f10);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f3153d);
        float f11 = -f10;
        rectF.inset(f11, f11);
        canvas.drawArc(rectF, f8, f9, false, paint);
        Paint paint2 = dVar.f3152c;
        if (dVar.f3162n) {
            Path path = dVar.f3163o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f3163o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f12 = (dVar.f3166r * dVar.f3164p) / 2.0f;
            dVar.f3163o.moveTo(0.0f, 0.0f);
            dVar.f3163o.lineTo(dVar.f3166r * dVar.f3164p, 0.0f);
            Path path3 = dVar.f3163o;
            float f13 = dVar.f3166r;
            float f14 = dVar.f3164p;
            path3.lineTo((f13 * f14) / 2.0f, dVar.f3167s * f14);
            dVar.f3163o.offset((rectF.centerX() + min) - f12, (dVar.f3157h / 2.0f) + rectF.centerY());
            dVar.f3163o.close();
            paint2.setColor(dVar.f3169u);
            paint2.setAlpha(dVar.f3168t);
            canvas.save();
            canvas.rotate(f8 + f9, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f3163o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f3173f.f3168t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f3176i.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f3173f.f3168t = i4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3173f.f3151b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f3176i.cancel();
        d dVar = this.f3173f;
        float f4 = dVar.f3154e;
        dVar.k = f4;
        float f5 = dVar.f3155f;
        dVar.f3160l = f5;
        dVar.f3161m = dVar.f3156g;
        if (f5 != f4) {
            this.k = true;
            this.f3176i.setDuration(666L);
            this.f3176i.start();
            return;
        }
        dVar.a(0);
        dVar.k = 0.0f;
        dVar.f3160l = 0.0f;
        dVar.f3161m = 0.0f;
        dVar.f3154e = 0.0f;
        dVar.f3155f = 0.0f;
        dVar.f3156g = 0.0f;
        this.f3176i.setDuration(1332L);
        this.f3176i.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f3176i.cancel();
        this.f3174g = 0.0f;
        d dVar = this.f3173f;
        if (dVar.f3162n) {
            dVar.f3162n = false;
        }
        dVar.a(0);
        dVar.k = 0.0f;
        dVar.f3160l = 0.0f;
        dVar.f3161m = 0.0f;
        dVar.f3154e = 0.0f;
        dVar.f3155f = 0.0f;
        dVar.f3156g = 0.0f;
        invalidateSelf();
    }
}
