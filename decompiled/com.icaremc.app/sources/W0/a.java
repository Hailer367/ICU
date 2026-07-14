package W0;

import Z0.r;
import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a extends AbstractC0142a {

    /* renamed from: f, reason: collision with root package name */
    public final int f1847f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1848g;

    /* renamed from: h, reason: collision with root package name */
    public final PendingIntent f1849h;

    /* renamed from: i, reason: collision with root package name */
    public final String f1850i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f1851j;
    public static final a k = new a(0, null, null);
    public static final Parcelable.Creator<a> CREATOR = new L.g(3);

    public a(int i4, int i5, PendingIntent pendingIntent, String str, Integer num) {
        this.f1847f = i4;
        this.f1848g = i5;
        this.f1849h = pendingIntent;
        this.f1850i = str;
        this.f1851j = num;
    }

    public static String a(int i4) {
        if (i4 != 99) {
            if (i4 != 1500) {
                switch (i4) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        return "NETWORK_ERROR";
                    case R.j.BYTES_FIELD_NUMBER /* 8 */:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i4) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            case 22:
                                return "RESOLUTION_ACTIVITY_NOT_FOUND";
                            case 23:
                                return "API_DISABLED";
                            case 24:
                                return "API_DISABLED_FOR_CONNECTION";
                            case 25:
                                return "API_INSTALL_REQUIRED";
                            default:
                                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 20);
                                sb.append("UNKNOWN_ERROR_CODE(");
                                sb.append(i4);
                                sb.append(")");
                                return sb.toString();
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f1848g == aVar.f1848g && r.g(this.f1849h, aVar.f1849h) && r.g(this.f1850i, aVar.f1850i) && r.g(this.f1851j, aVar.f1851j)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1848g), this.f1849h, this.f1850i, this.f1851j});
    }

    public final String toString() {
        E0.a aVar = new E0.a(this);
        aVar.e(a(this.f1848g), "statusCode");
        aVar.e(this.f1849h, "resolution");
        aVar.e(this.f1850i, "message");
        aVar.e(this.f1851j, "clientMethodKey");
        return aVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f1847f);
        AbstractC0141a.P(parcel, 2, 4);
        parcel.writeInt(this.f1848g);
        AbstractC0141a.L(parcel, 3, this.f1849h, i4);
        AbstractC0141a.M(parcel, 4, this.f1850i);
        Integer num = this.f1851j;
        if (num != null) {
            AbstractC0141a.P(parcel, 5, 4);
            parcel.writeInt(num.intValue());
        }
        AbstractC0141a.S(parcel, Q2);
    }

    public a(int i4, PendingIntent pendingIntent, String str) {
        this(1, i4, pendingIntent, str, null);
    }
}
