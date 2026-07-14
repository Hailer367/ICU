package B;

import android.content.ClipData;
import android.graphics.fonts.Font;
import android.view.ContentInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static /* synthetic */ Font.Builder g(Font font) {
        return new Font.Builder(font);
    }

    public static /* synthetic */ ContentInfo.Builder l(ClipData clipData, int i4) {
        return new ContentInfo.Builder(clipData, i4);
    }

    public static /* bridge */ /* synthetic */ ContentInfo n(Object obj) {
        return (ContentInfo) obj;
    }
}
