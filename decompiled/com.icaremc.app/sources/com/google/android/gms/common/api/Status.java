package com.google.android.gms.common.api;

import L.g;
import R.j;
import W0.a;
import Z0.r;
import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Status extends AbstractC0142a implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new g(6);

    /* renamed from: f, reason: collision with root package name */
    public final int f3366f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3367g;

    /* renamed from: h, reason: collision with root package name */
    public final PendingIntent f3368h;

    /* renamed from: i, reason: collision with root package name */
    public final a f3369i;

    public Status(int i4, String str, PendingIntent pendingIntent, a aVar) {
        this.f3366f = i4;
        this.f3367g = str;
        this.f3368h = pendingIntent;
        this.f3369i = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f3366f != status.f3366f || !r.g(this.f3367g, status.f3367g) || !r.g(this.f3368h, status.f3368h) || !r.g(this.f3369i, status.f3369i)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3366f), this.f3367g, this.f3368h, this.f3369i});
    }

    public final String toString() {
        E0.a aVar = new E0.a(this);
        String str = this.f3367g;
        if (str == null) {
            int i4 = this.f3366f;
            switch (i4) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 21);
                    sb.append("unknown status code: ");
                    sb.append(i4);
                    str = sb.toString();
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case j.DOUBLE_FIELD_NUMBER /* 7 */:
                    str = "NETWORK_ERROR";
                    break;
                case j.BYTES_FIELD_NUMBER /* 8 */:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = "TIMEOUT";
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        aVar.e(str, "statusCode");
        aVar.e(this.f3368h, "resolution");
        return aVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f3366f);
        AbstractC0141a.M(parcel, 2, this.f3367g);
        AbstractC0141a.L(parcel, 3, this.f3368h, i4);
        AbstractC0141a.L(parcel, 4, this.f3369i, i4);
        AbstractC0141a.S(parcel, Q2);
    }
}
