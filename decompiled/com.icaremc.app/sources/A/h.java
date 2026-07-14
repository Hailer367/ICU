package A;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f25a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f26b;

    /* renamed from: c, reason: collision with root package name */
    public final int f27c;

    public h(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        int hashCode;
        this.f25a = colorStateList;
        this.f26b = configuration;
        if (theme == null) {
            hashCode = 0;
        } else {
            hashCode = theme.hashCode();
        }
        this.f27c = hashCode;
    }
}
