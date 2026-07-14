package x;

import android.graphics.Color;

/* renamed from: x.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0343a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3958a = 0;

    static {
        new ThreadLocal();
    }

    public static int a(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int i4 = 255 - (((255 - alpha2) * (255 - alpha)) / 255);
        return Color.argb(i4, b(Color.red(i2), alpha2, Color.red(i3), alpha, i4), b(Color.green(i2), alpha2, Color.green(i3), alpha, i4), b(Color.blue(i2), alpha2, Color.blue(i3), alpha, i4));
    }

    public static int b(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((255 - i3) * (i4 * i5)) + ((i2 * 255) * i3)) / (i6 * 255);
    }
}
