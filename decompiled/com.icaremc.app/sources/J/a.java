package J;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: f, reason: collision with root package name */
    public final int f865f;

    /* renamed from: g, reason: collision with root package name */
    public final f f866g;

    /* renamed from: h, reason: collision with root package name */
    public final int f867h;

    public a(int i4, f fVar, int i5) {
        this.f865f = i4;
        this.f866g = fVar;
        this.f867h = i5;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f865f);
        this.f866g.f875a.performAction(this.f867h, bundle);
    }
}
