package I;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class Q {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static C0052f b(View view, C0052f c0052f) {
        ContentInfo l3 = c0052f.f729a.l();
        Objects.requireNonNull(l3);
        ContentInfo performReceiveContent = view.performReceiveContent(l3);
        if (performReceiveContent == null) {
            return null;
        }
        if (performReceiveContent == l3) {
            return c0052f;
        }
        return new C0052f(new A2.q(performReceiveContent));
    }
}
