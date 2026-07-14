package Z0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* loaded from: classes.dex */
public final class n extends AbstractC0142a {
    public static final Parcelable.Creator<n> CREATOR = new L.g(10);

    /* renamed from: f, reason: collision with root package name */
    public final int f2159f;

    /* renamed from: g, reason: collision with root package name */
    public final Account f2160g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2161h;

    /* renamed from: i, reason: collision with root package name */
    public final GoogleSignInAccount f2162i;

    public n(int i4, Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this.f2159f = i4;
        this.f2160g = account;
        this.f2161h = i5;
        this.f2162i = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f2159f);
        AbstractC0141a.L(parcel, 2, this.f2160g, i4);
        AbstractC0141a.P(parcel, 3, 4);
        parcel.writeInt(this.f2161h);
        AbstractC0141a.L(parcel, 4, this.f2162i, i4);
        AbstractC0141a.S(parcel, Q2);
    }
}
