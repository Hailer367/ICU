package B;

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
import q1.AbstractC0602b;

/* loaded from: classes.dex */
public class k extends AbstractC0602b {
    public static Font e0(FontFamily fontFamily, int i4) {
        int i5;
        int i6;
        if ((i4 & 1) != 0) {
            i5 = 700;
        } else {
            i5 = 400;
        }
        if ((i4 & 2) != 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        FontStyle fontStyle = new FontStyle(i5, i6);
        Font font = fontFamily.getFont(0);
        int h02 = h0(fontStyle, font.getStyle());
        for (int i7 = 1; i7 < fontFamily.getSize(); i7++) {
            Font font2 = fontFamily.getFont(i7);
            int h03 = h0(fontStyle, font2.getStyle());
            if (h03 < h02) {
                font = font2;
                h02 = h03;
            }
        }
        return font;
    }

    public static int h0(FontStyle fontStyle, FontStyle fontStyle2) {
        int i4;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i4 = 0;
        } else {
            i4 = 2;
        }
        return abs + i4;
    }

    public final FontFamily f0(F.l[] lVarArr, ContentResolver contentResolver) {
        Font font;
        String str;
        ParcelFileDescriptor openFileDescriptor;
        FontFamily.Builder builder = null;
        for (F.l lVar : lVarArr) {
            if (Objects.equals(lVar.f511a.getScheme(), "systemfont")) {
                font = g0(lVar);
            } else {
                try {
                    Uri uri = lVar.f511a;
                    str = lVar.f515e;
                    openFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e4) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e4);
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    font = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(openFileDescriptor).setWeight(lVar.f513c).setSlant(lVar.f514d ? 1 : 0).setTtcIndex(lVar.f512b);
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

    public Font g0(F.l lVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // q1.AbstractC0602b
    public final Typeface k(Context context, A.e eVar, Resources resources, int i4) {
        try {
            FontFamily.Builder builder = null;
            for (A.f fVar : eVar.f14a) {
                try {
                    Font build = new Font.Builder(resources, fVar.f20f).setWeight(fVar.f16b).setSlant(fVar.f17c ? 1 : 0).setTtcIndex(fVar.f19e).setFontVariationSettings(fVar.f18d).build();
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
            return new Typeface.CustomFallbackBuilder(build2).setStyle(e0(build2, i4).getStyle()).build();
        } catch (Exception e4) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e4);
            return null;
        }
    }

    @Override // q1.AbstractC0602b
    public final Typeface l(Context context, F.l[] lVarArr, int i4) {
        try {
            FontFamily f02 = f0(lVarArr, context.getContentResolver());
            if (f02 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(f02).setStyle(e0(f02, i4).getStyle()).build();
        } catch (Exception e4) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e4);
            return null;
        }
    }

    @Override // q1.AbstractC0602b
    public final Typeface m(Context context, List list, int i4) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily f02 = f0((F.l[]) list.get(0), contentResolver);
            if (f02 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(f02);
            for (int i5 = 1; i5 < list.size(); i5++) {
                FontFamily f03 = f0((F.l[]) list.get(i5), contentResolver);
                if (f03 != null) {
                    customFallbackBuilder.addCustomFallback(f03);
                }
            }
            return customFallbackBuilder.setStyle(e0(f02, i4).getStyle()).build();
        } catch (Exception e4) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e4);
            return null;
        }
    }

    @Override // q1.AbstractC0602b
    public final Typeface n(Context context, Resources resources, int i4, String str, int i5) {
        try {
            Font build = new Font.Builder(resources, i4).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e4) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e4);
            return null;
        }
    }
}
