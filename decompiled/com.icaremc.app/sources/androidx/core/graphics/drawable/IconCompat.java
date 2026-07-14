package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import k3.b;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2508a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2509b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2510c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2511d;

    /* renamed from: e, reason: collision with root package name */
    public int f2512e;

    /* renamed from: f, reason: collision with root package name */
    public int f2513f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2514g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2515h;

    /* renamed from: i, reason: collision with root package name */
    public String f2516i;

    /* renamed from: j, reason: collision with root package name */
    public String f2517j;

    public IconCompat() {
        this.f2508a = -1;
        this.f2510c = null;
        this.f2511d = null;
        this.f2512e = 0;
        this.f2513f = 0;
        this.f2514g = null;
        this.f2515h = k;
        this.f2516i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i4 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i4);
        iconCompat.f2512e = bundle.getInt("int1");
        iconCompat.f2513f = bundle.getInt("int2");
        iconCompat.f2517j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f2514g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f2515h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i4) {
            case -1:
            case 1:
            case 5:
                iconCompat.f2509b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i4);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f2509b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f2509b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat b(Icon icon) {
        icon.getClass();
        int n3 = b.n(icon);
        if (n3 != 2) {
            if (n3 != 4) {
                if (n3 != 6) {
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.f2509b = icon;
                    return iconCompat;
                }
                Uri o3 = b.o(icon);
                o3.getClass();
                String uri = o3.toString();
                uri.getClass();
                IconCompat iconCompat2 = new IconCompat(6);
                iconCompat2.f2509b = uri;
                return iconCompat2;
            }
            Uri o4 = b.o(icon);
            o4.getClass();
            String uri2 = o4.toString();
            uri2.getClass();
            IconCompat iconCompat3 = new IconCompat(4);
            iconCompat3.f2509b = uri2;
            return iconCompat3;
        }
        return e(null, b.m(icon), b.l(icon));
    }

    public static Bitmap c(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f4 = min;
        float f5 = 0.5f * f4;
        float f6 = 0.9166667f * f5;
        if (z) {
            float f7 = 0.010416667f * f4;
            paint.setColor(0);
            paint.setShadowLayer(f7, 0.0f, f4 * 0.020833334f, 1023410176);
            canvas.drawCircle(f5, f5, f6, paint);
            paint.setShadowLayer(f7, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f5, f5, f6, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f5, f5, f6, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat d(Bitmap bitmap) {
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f2509b = bitmap;
        return iconCompat;
    }

    public static IconCompat e(Resources resources, String str, int i4) {
        str.getClass();
        if (i4 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2512e = i4;
            if (resources != null) {
                try {
                    iconCompat.f2509b = resources.getResourceName(i4);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2509b = str;
            }
            iconCompat.f2517j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int f() {
        int i4 = this.f2508a;
        if (i4 == -1) {
            return b.l(this.f2509b);
        }
        if (i4 == 2) {
            return this.f2512e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final Uri g() {
        int i4 = this.f2508a;
        if (i4 == -1) {
            return b.o(this.f2509b);
        }
        if (i4 != 4 && i4 != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f2509b);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Icon h(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.h(android.content.Context):android.graphics.drawable.Icon");
    }

    public final String toString() {
        String str;
        if (this.f2508a == -1) {
            return String.valueOf(this.f2509b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f2508a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f2508a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2509b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2509b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2517j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(f())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2512e);
                if (this.f2513f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2513f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2509b);
                break;
        }
        if (this.f2514g != null) {
            sb.append(" tint=");
            sb.append(this.f2514g);
        }
        if (this.f2515h != k) {
            sb.append(" mode=");
            sb.append(this.f2515h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i4) {
        this.f2510c = null;
        this.f2511d = null;
        this.f2512e = 0;
        this.f2513f = 0;
        this.f2514g = null;
        this.f2515h = k;
        this.f2516i = null;
        this.f2508a = i4;
    }
}
