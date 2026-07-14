package com.google.android.gms.common.api;

import L.g;
import Z0.r;
import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* loaded from: classes.dex */
public final class Scope extends AbstractC0142a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new g(5);

    /* renamed from: f, reason: collision with root package name */
    public final int f3364f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3365g;

    public Scope(int i4, String str) {
        r.d(str, "scopeUri must not be null or empty");
        this.f3364f = i4;
        this.f3365g = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f3365g.equals(((Scope) obj).f3365g);
    }

    public final int hashCode() {
        return this.f3365g.hashCode();
    }

    public final String toString() {
        return this.f3365g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        AbstractC0141a.P(parcel, 1, 4);
        parcel.writeInt(this.f3364f);
        AbstractC0141a.M(parcel, 2, this.f3365g);
        AbstractC0141a.S(parcel, Q2);
    }
}
