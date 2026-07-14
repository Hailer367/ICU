package x;

import B.m;
import a.AbstractC0051a;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import w.C0337b;
import w.C0338c;

/* loaded from: classes.dex */
public class i extends AbstractC0051a {
    public static Font X(FontFamily fontFamily, int i2) {
        int i3;
        int i4;
        if ((i2 & 1) != 0) {
            i3 = 700;
        } else {
            i3 = 400;
        }
        if ((i2 & 2) != 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        FontStyle fontStyle = new FontStyle(i3, i4);
        Font font = fontFamily.getFont(0);
        int a02 = a0(fontStyle, font.getStyle());
        for (int i5 = 1; i5 < fontFamily.getSize(); i5++) {
            Font font2 = fontFamily.getFont(i5);
            int a03 = a0(fontStyle, font2.getStyle());
            if (a03 < a02) {
                font = font2;
                a02 = a03;
            }
        }
        return font;
    }

    public static int a0(FontStyle fontStyle, FontStyle fontStyle2) {
        int i2;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        return abs + i2;
    }

    public final FontFamily Y(m[] mVarArr, ContentResolver contentResolver) {
        Font font;
        String str;
        ParcelFileDescriptor openFileDescriptor;
        FontFamily.Builder builder = null;
        for (m mVar : mVarArr) {
            if (Objects.equals(mVar.f68a.getScheme(), "systemfont")) {
                font = Z(mVar);
            } else {
                try {
                    Uri uri = mVar.f68a;
                    str = mVar.f72e;
                    openFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e2) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e2);
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    font = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(openFileDescriptor).setWeight(mVar.f70c).setSlant(mVar.f71d ? 1 : 0).setTtcIndex(mVar.f69b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        font = ttcIndex.build();
                        openFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                }
            }
            if (font != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(font);
                } else {
                    builder.addFont(font);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font Z(m mVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // a.AbstractC0051a
    public final Typeface k(Context context, C0337b c0337b, Resources resources, int i2) {
        try {
            FontFamily.Builder builder = null;
            for (C0338c c0338c : c0337b.f3934a) {
                try {
                    Font build = new Font.Builder(resources, c0338c.f3940f).setWeight(c0338c.f3936b).setSlant(c0338c.f3937c ? 1 : 0).setTtcIndex(c0338c.f3939e).setFontVariationSettings(c0338c.f3938d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(X(build2, i2).getStyle()).build();
        } catch (Exception e2) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e2);
            return null;
        }
    }

    @Override // a.AbstractC0051a
    public final Typeface l(Context context, m[] mVarArr, int i2) {
        try {
            FontFamily Y2 = Y(mVarArr, context.getContentResolver());
            if (Y2 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(Y2).setStyle(X(Y2, i2).getStyle()).build();
        } catch (Exception e2) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e2);
            return null;
        }
    }

    @Override // a.AbstractC0051a
    public final Typeface m(Context context, List list, int i2) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily Y2 = Y((m[]) list.get(0), contentResolver);
            if (Y2 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(Y2);
            for (int i3 = 1; i3 < list.size(); i3++) {
                FontFamily Y3 = Y((m[]) list.get(i3), contentResolver);
                if (Y3 != null) {
                    customFallbackBuilder.addCustomFallback(Y3);
                }
            }
            return customFallbackBuilder.setStyle(X(Y2, i2).getStyle()).build();
        } catch (Exception e2) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e2);
            return null;
        }
    }

    @Override // a.AbstractC0051a
    public final Typeface n(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e2) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e2);
            return null;
        }
    }
}
