package f;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0195k implements Parcelable {
    public static final Parcelable.Creator<C0195k> CREATOR = new H.g(20);

    /* renamed from: c, reason: collision with root package name */
    public final IntentSender f2272c;

    /* renamed from: d, reason: collision with root package name */
    public final Intent f2273d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2274e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2275f;

    public C0195k(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f2272c = intentSender;
        this.f2273d = intent;
        this.f2274e = i2;
        this.f2275f = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i2) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeParcelable(this.f2272c, i2);
        dest.writeParcelable(this.f2273d, i2);
        dest.writeInt(this.f2274e);
        dest.writeInt(this.f2275f);
    }
}
