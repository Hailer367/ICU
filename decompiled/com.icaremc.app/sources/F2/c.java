package F2;

import android.widget.Toast$Callback;

/* loaded from: classes.dex */
public final class c extends Toast$Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E0.a f549a;

    public c(E0.a aVar) {
        this.f549a = aVar;
    }

    public final void onToastHidden() {
        super.onToastHidden();
        this.f549a.f460h = null;
    }
}
