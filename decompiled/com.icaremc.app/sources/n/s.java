package n;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import m.InterfaceC0439c;

/* loaded from: classes.dex */
public final class s extends FrameLayout implements InterfaceC0439c {

    /* renamed from: f, reason: collision with root package name */
    public final CollapsibleActionView f5352f;

    /* JADX WARN: Multi-variable type inference failed */
    public s(View view) {
        super(view.getContext());
        this.f5352f = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // m.InterfaceC0439c
    public final void onActionViewCollapsed() {
        this.f5352f.onActionViewCollapsed();
    }

    @Override // m.InterfaceC0439c
    public final void onActionViewExpanded() {
        this.f5352f.onActionViewExpanded();
    }
}
