package E;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* renamed from: E.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0022w implements InterfaceC0023x {

    /* renamed from: c, reason: collision with root package name */
    public final ScrollFeedbackProvider f260c;

    public C0022w(NestedScrollView nestedScrollView) {
        this.f260c = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // E.InterfaceC0023x
    public final void onScrollLimit(int i2, int i3, int i4, boolean z) {
        this.f260c.onScrollLimit(i2, i3, i4, z);
    }

    @Override // E.InterfaceC0023x
    public final void onScrollProgress(int i2, int i3, int i4, int i5) {
        this.f260c.onScrollProgress(i2, i3, i4, i5);
    }
}
