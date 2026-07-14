package n1;

import a.AbstractC0141a;
import a1.AbstractC0142a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.swiperefreshlayout.widget.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends AbstractC0142a {
    public static final Parcelable.Creator<d> CREATOR = new k(8);

    /* renamed from: f, reason: collision with root package name */
    public final List f5377f;

    /* renamed from: g, reason: collision with root package name */
    public final String f5378g;

    public d(String str, ArrayList arrayList) {
        this.f5377f = arrayList;
        this.f5378g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int Q2 = AbstractC0141a.Q(parcel, 20293);
        List<String> list = this.f5377f;
        if (list != null) {
            int Q3 = AbstractC0141a.Q(parcel, 1);
            parcel.writeStringList(list);
            AbstractC0141a.S(parcel, Q3);
        }
        AbstractC0141a.M(parcel, 2, this.f5378g);
        AbstractC0141a.S(parcel, Q2);
    }
}
