package F;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: c, reason: collision with root package name */
    public final int f262c;

    /* renamed from: d, reason: collision with root package name */
    public final g f263d;

    /* renamed from: e, reason: collision with root package name */
    public final int f264e;

    public a(int i2, g gVar, int i3) {
        this.f262c = i2;
        this.f263d = gVar;
        this.f264e = i3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f262c);
        this.f263d.f272a.performAction(this.f264e, bundle);
    }
}
