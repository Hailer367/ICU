package io.flutter.view;

import android.view.View;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final View f4542a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4543b;

    public o(View view, int i4) {
        this.f4542a = view;
        this.f4543b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f4543b == oVar.f4543b && this.f4542a.equals(oVar.f4542a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f4542a.hashCode() + 31) * 31) + this.f4543b;
    }
}
