package B;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f46a;

    /* renamed from: b, reason: collision with root package name */
    public final String f47b;

    /* renamed from: c, reason: collision with root package name */
    public final String f48c;

    /* renamed from: d, reason: collision with root package name */
    public final List f49d;

    /* renamed from: e, reason: collision with root package name */
    public final String f50e;

    /* renamed from: f, reason: collision with root package name */
    public final String f51f;

    /* renamed from: g, reason: collision with root package name */
    public final String f52g;

    public g(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f46a = str;
        str2.getClass();
        this.f47b = str2;
        this.f48c = str3;
        list.getClass();
        this.f49d = list;
        this.f50e = str4;
        this.f51f = str5;
        this.f52g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f46a + ", mProviderPackage: " + this.f47b + ", mQuery: " + this.f48c + ", mSystemFont: " + this.f50e + ", mVariationSettings: " + this.f51f + ", mCertificates:");
        int i2 = 0;
        while (true) {
            List list = this.f49d;
            if (i2 < list.size()) {
                sb.append(" [");
                List list2 = (List) list.get(i2);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString((byte[]) list2.get(i3), 0));
                    sb.append("\"");
                }
                sb.append(" ]");
                i2++;
            } else {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
        }
    }
}
