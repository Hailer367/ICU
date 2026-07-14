package o;

import android.text.StaticLayout;
import android.widget.TextView;

/* renamed from: o.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0528l0 {
    public abstract void a(StaticLayout.Builder builder, TextView textView);

    public boolean b(TextView textView) {
        return ((Boolean) C0530m0.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
    }
}
