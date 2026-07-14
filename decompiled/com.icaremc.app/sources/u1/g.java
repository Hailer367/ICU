package u1;

import Z0.r;
import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f6231a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6232b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6233c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6234d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6235e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6236f;

    /* renamed from: g, reason: collision with root package name */
    public final String f6237g;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        boolean z;
        int i4 = d1.c.f3472a;
        if (str != null && !str.trim().isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.f6232b = str;
            this.f6231a = str2;
            this.f6233c = str3;
            this.f6234d = str4;
            this.f6235e = str5;
            this.f6236f = str6;
            this.f6237g = str7;
            return;
        }
        throw new IllegalStateException("ApplicationId must be set.");
    }

    public static g a(Context context) {
        E0.a aVar = new E0.a(context);
        String A3 = aVar.A("google_app_id");
        if (TextUtils.isEmpty(A3)) {
            return null;
        }
        return new g(A3, aVar.A("google_api_key"), aVar.A("firebase_database_url"), aVar.A("ga_trackingId"), aVar.A("gcm_defaultSenderId"), aVar.A("google_storage_bucket"), aVar.A("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!r.g(this.f6232b, gVar.f6232b) || !r.g(this.f6231a, gVar.f6231a) || !r.g(this.f6233c, gVar.f6233c) || !r.g(this.f6234d, gVar.f6234d) || !r.g(this.f6235e, gVar.f6235e) || !r.g(this.f6236f, gVar.f6236f) || !r.g(this.f6237g, gVar.f6237g)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6232b, this.f6231a, this.f6233c, this.f6234d, this.f6235e, this.f6236f, this.f6237g});
    }

    public final String toString() {
        E0.a aVar = new E0.a(this);
        aVar.e(this.f6232b, "applicationId");
        aVar.e(this.f6231a, "apiKey");
        aVar.e(this.f6233c, "databaseUrl");
        aVar.e(this.f6235e, "gcmSenderId");
        aVar.e(this.f6236f, "storageBucket");
        aVar.e(this.f6237g, "projectId");
        return aVar.toString();
    }
}
