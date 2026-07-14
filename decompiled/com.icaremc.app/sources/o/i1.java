package o;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5594a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f5595b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f5596c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f5597d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f5598e;

    public i1(View view) {
        this.f5594a = (TextView) view.findViewById(R.id.text1);
        this.f5595b = (TextView) view.findViewById(R.id.text2);
        this.f5596c = (ImageView) view.findViewById(R.id.icon1);
        this.f5597d = (ImageView) view.findViewById(R.id.icon2);
        this.f5598e = (ImageView) view.findViewById(com.icaremc.app.R.id.edit_query);
    }
}
