package h2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;
import q1.AbstractC0602b;

/* renamed from: h2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0354g extends View implements io.flutter.embedding.engine.renderer.m {

    /* renamed from: f, reason: collision with root package name */
    public ImageReader f3991f;

    /* renamed from: g, reason: collision with root package name */
    public Image f3992g;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap f3993h;

    /* renamed from: i, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f3994i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3995j;
    public final int k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3996l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0354g(Context context, int i4, int i5, int i6) {
        super(context, null);
        ImageReader f4 = f(i4, i5);
        this.f3995j = false;
        this.f3996l = false;
        this.f3991f = f4;
        this.k = i6;
        setAlpha(0.0f);
        this.f3995j = AbstractC0602b.I(getContext());
    }

    public static ImageReader f(int i4, int i5) {
        ImageReader newInstance;
        if (i4 <= 0) {
            Locale locale = Locale.US;
            Log.w("FlutterImageView", "ImageReader width must be greater than 0, but given width=" + i4 + ", set width=1");
            i4 = 1;
        }
        if (i5 <= 0) {
            Locale locale2 = Locale.US;
            Log.w("FlutterImageView", "ImageReader height must be greater than 0, but given height=" + i5 + ", set height=1");
            i5 = 1;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            newInstance = ImageReader.newInstance(i4, i5, 1, 3, 768L);
            return newInstance;
        }
        return ImageReader.newInstance(i4, i5, 1, 3);
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void a() {
        if (!this.f3996l) {
            return;
        }
        setAlpha(0.0f);
        e();
        this.f3993h = null;
        Image image = this.f3992g;
        if (image != null) {
            image.close();
            this.f3992g = null;
        }
        invalidate();
        this.f3996l = false;
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void c(io.flutter.embedding.engine.renderer.j jVar) {
        if (R.i.b(this.k) == 0) {
            Surface surface = this.f3991f.getSurface();
            jVar.f4235c = surface;
            jVar.f4233a.onSurfaceWindowChanged(surface);
        }
        setAlpha(1.0f);
        this.f3994i = jVar;
        this.f3996l = true;
    }

    public final boolean e() {
        if (this.f3996l) {
            Image acquireLatestImage = this.f3991f.acquireLatestImage();
            if (acquireLatestImage != null) {
                Image image = this.f3992g;
                if (image != null) {
                    image.close();
                    this.f3992g = null;
                }
                this.f3992g = acquireLatestImage;
                invalidate();
            }
            if (acquireLatestImage != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void g(int i4, int i5) {
        if (this.f3994i != null) {
            if (i4 == this.f3991f.getWidth() && i5 == this.f3991f.getHeight()) {
                return;
            }
            Image image = this.f3992g;
            if (image != null) {
                image.close();
                this.f3992g = null;
            }
            this.f3991f.close();
            this.f3991f = f(i4, i5);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public io.flutter.embedding.engine.renderer.j getAttachedRenderer() {
        return this.f3994i;
    }

    public ImageReader getImageReader() {
        return this.f3991f;
    }

    public Surface getSurface() {
        return this.f3991f.getSurface();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        HardwareBuffer hardwareBuffer;
        ColorSpace colorSpace;
        Bitmap wrapHardwareBuffer;
        ColorSpace.Named unused;
        super.onDraw(canvas);
        Image image = this.f3992g;
        if (image != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                hardwareBuffer = image.getHardwareBuffer();
                unused = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
                this.f3993h = wrapHardwareBuffer;
                hardwareBuffer.close();
            } else {
                Image.Plane[] planes = image.getPlanes();
                if (planes.length == 1) {
                    Image.Plane plane = planes[0];
                    int rowStride = plane.getRowStride() / plane.getPixelStride();
                    int height = this.f3992g.getHeight();
                    Bitmap bitmap = this.f3993h;
                    if (bitmap == null || bitmap.getWidth() != rowStride || this.f3993h.getHeight() != height) {
                        this.f3993h = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
                    }
                    ByteBuffer buffer = plane.getBuffer();
                    buffer.rewind();
                    this.f3993h.copyPixelsFromBuffer(buffer);
                }
            }
        }
        Bitmap bitmap2 = this.f3993h;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        if (this.f3995j) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            int size2 = View.MeasureSpec.getSize(i5);
            int i7 = 0;
            if (mode2 == 0) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            int max = Math.max(size2, i6);
            if (mode == 0) {
                i7 = 1;
            }
            setMeasuredDimension(Math.max(size, i7), max);
            return;
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        if ((i4 != this.f3991f.getWidth() || i5 != this.f3991f.getHeight()) && this.k == 1 && this.f3996l) {
            g(i4, i5);
            io.flutter.embedding.engine.renderer.j jVar = this.f3994i;
            Surface surface = this.f3991f.getSurface();
            jVar.f4235c = surface;
            jVar.f4233a.onSurfaceWindowChanged(surface);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void b() {
    }

    @Override // io.flutter.embedding.engine.renderer.m
    public final void d() {
    }
}
