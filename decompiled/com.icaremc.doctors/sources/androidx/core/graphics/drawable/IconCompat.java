package androidx.core.graphics.drawable;

import a.AbstractC0051a;
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

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f1288k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f1289a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1290b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1291c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f1292d;

    /* renamed from: e, reason: collision with root package name */
    public int f1293e;

    /* renamed from: f, reason: collision with root package name */
    public int f1294f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1295g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1296h;

    /* renamed from: i, reason: collision with root package name */
    public String f1297i;

    /* renamed from: j, reason: collision with root package name */
    public String f1298j;

    public IconCompat() {
        this.f1289a = -1;
        this.f1291c = null;
        this.f1292d = null;
        this.f1293e = 0;
        this.f1294f = 0;
        this.f1295g = null;
        this.f1296h = f1288k;
        this.f1297i = null;
    }

    public static IconCompat a(Bundle bundle) {
        int i2 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i2);
        iconCompat.f1293e = bundle.getInt("int1");
        iconCompat.f1294f = bundle.getInt("int2");
        iconCompat.f1298j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f1295g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f1296h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i2) {
            case -1:
            case 1:
            case 5:
                iconCompat.f1290b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i2);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f1290b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f1290b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat b(Icon icon) {
        icon.getClass();
        int D2 = AbstractC0051a.D(icon);
        if (D2 != 2) {
            if (D2 != 4) {
                if (D2 != 6) {
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.f1290b = icon;
                    return iconCompat;
                }
                Uri E2 = AbstractC0051a.E(icon);
                E2.getClass();
                String uri = E2.toString();
                uri.getClass();
                IconCompat iconCompat2 = new IconCompat(6);
                iconCompat2.f1290b = uri;
                return iconCompat2;
            }
            Uri E3 = AbstractC0051a.E(icon);
            E3.getClass();
            String uri2 = E3.toString();
            uri2.getClass();
            IconCompat iconCompat3 = new IconCompat(4);
            iconCompat3.f1290b = uri2;
            return iconCompat3;
        }
        return e(null, AbstractC0051a.B(icon), AbstractC0051a.A(icon));
    }

    public static Bitmap c(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat d(Bitmap bitmap) {
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f1290b = bitmap;
        return iconCompat;
    }

    public static IconCompat e(Resources resources, String str, int i2) {
        str.getClass();
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1293e = i2;
            if (resources != null) {
                try {
                    iconCompat.f1290b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1290b = str;
            }
            iconCompat.f1298j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int f() {
        int i2 = this.f1289a;
        if (i2 == -1) {
            return AbstractC0051a.A(this.f1290b);
        }
        if (i2 == 2) {
            return this.f1293e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final Uri g() {
        int i2 = this.f1289a;
        if (i2 == -1) {
            return AbstractC0051a.E(this.f1290b);
        }
        if (i2 != 4 && i2 != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f1290b);
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
        if (this.f1289a == -1) {
            return String.valueOf(this.f1290b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f1289a) {
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
        switch (this.f1289a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1290b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1290b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1298j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(f())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1293e);
                if (this.f1294f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1294f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1290b);
                break;
        }
        if (this.f1295g != null) {
            sb.append(" tint=");
            sb.append(this.f1295g);
        }
        if (this.f1296h != f1288k) {
            sb.append(" mode=");
            sb.append(this.f1296h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i2) {
        this.f1291c = null;
        this.f1292d = null;
        this.f1293e = 0;
        this.f1294f = 0;
        this.f1295g = null;
        this.f1296h = f1288k;
        this.f1297i = null;
        this.f1289a = i2;
    }
}
