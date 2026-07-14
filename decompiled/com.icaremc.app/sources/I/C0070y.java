package I;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* renamed from: I.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0070y implements InterfaceC0071z {

    /* renamed from: f, reason: collision with root package name */
    public final ScrollFeedbackProvider f796f;

    public C0070y(NestedScrollView nestedScrollView) {
        this.f796f = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // I.InterfaceC0071z
    public final void onScrollLimit(int i4, int i5, int i6, boolean z) {
        this.f796f.onScrollLimit(i4, i5, i6, z);
    }

    @Override // I.InterfaceC0071z
    public final void onScrollProgress(int i4, int i5, int i6, int i7) {
        this.f796f.onScrollProgress(i4, i5, i6, i7);
    }
}
