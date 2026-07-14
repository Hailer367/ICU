package x;

import B.m;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j extends i {
    @Override // x.i
    public final Font Z(m mVar) {
        String str;
        Font d2;
        Uri uri = mVar.f68a;
        boolean equals = Objects.equals(uri.getScheme(), "systemfont");
        String str2 = mVar.f72e;
        if (equals) {
            str = uri.getAuthority();
        } else {
            str = null;
        }
        if (str != null) {
            Typeface create = Typeface.create(str, 0);
            Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
            if (create == null || create.equals(create2)) {
                create = null;
            }
            if (create != null && (d2 = d.d(create)) != null) {
                if (TextUtils.isEmpty(str2)) {
                    return d2;
                }
                try {
                    return new Font.Builder(d2).setFontVariationSettings(str2).build();
                } catch (IOException unused) {
                    Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            }
        }
        return null;
    }
}
