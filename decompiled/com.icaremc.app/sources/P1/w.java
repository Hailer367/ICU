package P1;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import t.C0656e;
import t.C0661j;

/* loaded from: classes.dex */
public final class w extends AbstractC0142a {
    public static final Parcelable.Creator<w> CREATOR = new L.g(1);

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f1465f;

    /* renamed from: g, reason: collision with root package name */
    public C0656e f1466g;

    /* renamed from: h, reason: collision with root package name */
    public v f1467h;

    public w(Bundle bundle) {
        this.f1465f = bundle;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [t.j, t.e] */
    public final HashMap a() {
        if (this.f1466g == null) {
            ?? c0661j = new C0661j(0);
            Bundle bundle = this.f1465f;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        c0661j.put(str, str2);
                    }
                }
            }
            this.f1466g = c0661j;
        }
        return new HashMap(this.f1466g);
    }

    public final String b() {
        Bundle bundle = this.f1465f;
        String string = bundle.getString("google.message_id");
        if (string == null) {
            return bundle.getString("message_id");
        }
        return string;
    }

    public final v c() {
        if (this.f1467h == null) {
            Bundle bundle = this.f1465f;
            if (A2.q.I(bundle)) {
                this.f1467h = new v(new A2.q(bundle));
            }
        }
        return this.f1467h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.K(parcel, 2, this.f1465f);
        AbstractC0141a.S(parcel, Q2);
    }
}
