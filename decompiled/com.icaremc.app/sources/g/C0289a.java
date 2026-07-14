package g;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: g.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0289a implements Parcelable {
    public static final Parcelable.Creator<C0289a> CREATOR = new androidx.swiperefreshlayout.widget.k(2);

    /* renamed from: f, reason: collision with root package name */
    public final int f3740f;

    /* renamed from: g, reason: collision with root package name */
    public final Intent f3741g;

    public C0289a(Intent intent, int i4) {
        this.f3740f = i4;
        this.f3741g = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i4 = this.f3740f;
        if (i4 != -1) {
            if (i4 != 0) {
                str = String.valueOf(i4);
            } else {
                str = "RESULT_CANCELED";
            }
        } else {
            str = "RESULT_OK";
        }
        sb.append(str);
        sb.append(", data=");
        sb.append(this.f3741g);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5;
        T2.h.e(parcel, "dest");
        parcel.writeInt(this.f3740f);
        Intent intent = this.f3741g;
        if (intent == null) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        parcel.writeInt(i5);
        if (intent != null) {
            intent.writeToParcel(parcel, i4);
        }
    }
}
