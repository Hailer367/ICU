package g;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new androidx.swiperefreshlayout.widget.k(3);

    /* renamed from: f, reason: collision with root package name */
    public final IntentSender f3760f;

    /* renamed from: g, reason: collision with root package name */
    public final Intent f3761g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3762h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3763i;

    public j(IntentSender intentSender, Intent intent, int i4, int i5) {
        this.f3760f = intentSender;
        this.f3761g = intent;
        this.f3762h = i4;
        this.f3763i = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        T2.h.e(parcel, "dest");
        parcel.writeParcelable(this.f3760f, i4);
        parcel.writeParcelable(this.f3761g, i4);
        parcel.writeInt(this.f3762h);
        parcel.writeInt(this.f3763i);
    }
}
