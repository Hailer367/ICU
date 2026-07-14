package io.flutter.plugin.platform;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.view.Surface;
import android.view.SurfaceControl;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ Typeface.CustomFallbackBuilder c(FontFamily fontFamily) {
        return new Typeface.CustomFallbackBuilder(fontFamily);
    }

    public static /* synthetic */ FontFamily.Builder e(Font font) {
        return new FontFamily.Builder(font);
    }

    public static /* synthetic */ Surface g(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* synthetic */ SurfaceControl.Builder h() {
        return new SurfaceControl.Builder();
    }

    public static /* synthetic */ SurfaceControl.Transaction i() {
        return new SurfaceControl.Transaction();
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction k(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }
}
