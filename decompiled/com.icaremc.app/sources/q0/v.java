package q0;

import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class v extends AbstractC0598c {

    /* renamed from: d, reason: collision with root package name */
    public final Pattern f5894d;

    public v() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.f5894d = Pattern.compile("\\A\\d+");
    }

    @Override // q0.AbstractC0598c
    public final boolean a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }

    @Override // q0.AbstractC0598c
    public final boolean b() {
        boolean b4 = super.b();
        if (b4 && Build.VERSION.SDK_INT < 29) {
            PackageInfo c4 = p0.w.c();
            if (c4 == null) {
                return false;
            }
            Matcher matcher = this.f5894d.matcher(c4.versionName);
            if (!matcher.find() || Integer.parseInt(c4.versionName.substring(matcher.start(), matcher.end())) < 105) {
                return false;
            }
            return true;
        }
        return b4;
    }
}
