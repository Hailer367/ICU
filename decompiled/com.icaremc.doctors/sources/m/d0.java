package m;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f3121a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f3122b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f3123c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f3124d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f3125e;

    public d0(View view) {
        this.f3121a = (TextView) view.findViewById(R.id.text1);
        this.f3122b = (TextView) view.findViewById(R.id.text2);
        this.f3123c = (ImageView) view.findViewById(R.id.icon1);
        this.f3124d = (ImageView) view.findViewById(R.id.icon2);
        this.f3125e = (ImageView) view.findViewById(com.icaremc.doctors.R.id.edit_query);
    }
}
