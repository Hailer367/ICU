package V0;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class a extends AbstractC0142a {
    public static final Parcelable.Creator<a> CREATOR = new c(0);

    /* renamed from: f, reason: collision with root package name */
    public final Intent f1672f;

    public a(Intent intent) {
        this.f1672f = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.L(parcel, 1, this.f1672f, i4);
        AbstractC0141a.S(parcel, Q2);
    }
}
