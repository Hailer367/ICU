package B;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class l extends k {
    @Override // B.k
    public final Font g0(F.l lVar) {
        String str;
        Font d4;
        Uri uri = lVar.f511a;
        boolean equals = Objects.equals(uri.getScheme(), "systemfont");
        String str2 = lVar.f515e;
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
            if (create != null && (d4 = f.d(create)) != null) {
                if (TextUtils.isEmpty(str2)) {
                    return d4;
                }
                try {
                    return new Font.Builder(d4).setFontVariationSettings(str2).build();
                } catch (IOException unused) {
                    Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            }
        }
        return null;
    }
}
