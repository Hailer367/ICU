package q0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import p0.AbstractC0565d;

/* loaded from: classes.dex */
public final class w extends C0597b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5895e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(int i4, String str, String str2) {
        super(2, str, str2);
        this.f5895e = i4;
    }

    @Override // q0.AbstractC0598c
    public final boolean b() {
        PackageInfo c4;
        long j4;
        switch (this.f5895e) {
            case 0:
                if (!super.b() || (c4 = p0.w.c()) == null) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    j4 = C.b.e(c4);
                } else {
                    j4 = c4.versionCode;
                }
                if (j4 < 636700000) {
                    return false;
                }
                return true;
            case 1:
                if (!super.b() || !AbstractC0565d.a("MULTI_PROCESS")) {
                    return false;
                }
                Uri uri = p0.w.f5818a;
                if (x.f5896A.b()) {
                    return z.f5932a.getStatics().isMultiProcessEnabled();
                }
                throw x.a();
            default:
                if (!AbstractC0565d.a("MULTI_PROFILE")) {
                    return false;
                }
                return super.b();
        }
    }
}
