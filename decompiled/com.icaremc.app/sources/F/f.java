package F;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f489a;

    /* renamed from: b, reason: collision with root package name */
    public final String f490b;

    /* renamed from: c, reason: collision with root package name */
    public final String f491c;

    /* renamed from: d, reason: collision with root package name */
    public final List f492d;

    /* renamed from: e, reason: collision with root package name */
    public final String f493e;

    /* renamed from: f, reason: collision with root package name */
    public final String f494f;

    /* renamed from: g, reason: collision with root package name */
    public final String f495g;

    public f(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f489a = str;
        str2.getClass();
        this.f490b = str2;
        this.f491c = str3;
        list.getClass();
        this.f492d = list;
        this.f493e = str4;
        this.f494f = str5;
        this.f495g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f489a + ", mProviderPackage: " + this.f490b + ", mQuery: " + this.f491c + ", mSystemFont: " + this.f493e + ", mVariationSettings: " + this.f494f + ", mCertificates:");
        int i4 = 0;
        while (true) {
            List list = this.f492d;
            if (i4 < list.size()) {
                sb.append(" [");
                List list2 = (List) list.get(i4);
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString((byte[]) list2.get(i5), 0));
                    sb.append("\"");
                }
                sb.append(" ]");
                i4++;
            } else {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
        }
    }
}
