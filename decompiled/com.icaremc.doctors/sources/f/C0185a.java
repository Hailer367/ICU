package f;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0185a implements Parcelable {
    public static final Parcelable.Creator<C0185a> CREATOR = new H.g(19);

    /* renamed from: c, reason: collision with root package name */
    public final int f2250c;

    /* renamed from: d, reason: collision with root package name */
    public final Intent f2251d;

    public C0185a(int i2, Intent intent) {
        this.f2250c = i2;
        this.f2251d = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i2 = this.f2250c;
        if (i2 != -1) {
            if (i2 != 0) {
                str = String.valueOf(i2);
            } else {
                str = "RESULT_CANCELED";
            }
        } else {
            str = "RESULT_OK";
        }
        sb.append(str);
        sb.append(", data=");
        sb.append(this.f2251d);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i2) {
        int i3;
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.f2250c);
        Intent intent = this.f2251d;
        if (intent == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        dest.writeInt(i3);
        if (intent != null) {
            intent.writeToParcel(dest, i2);
        }
    }
}
