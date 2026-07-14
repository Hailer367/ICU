package m;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class G implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3060c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ J f3061d;

    public /* synthetic */ G(J j2, int i2) {
        this.f3060c = i2;
        this.f3061d = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f3060c;
        J j2 = this.f3061d;
        switch (i2) {
            case 0:
                L l2 = j2.f3066e;
                if (l2 != null) {
                    l2.setListSelectionHidden(true);
                    l2.requestLayout();
                    return;
                }
                return;
            default:
                L l3 = j2.f3066e;
                if (l3 != null) {
                    Field field = E.J.f180a;
                    if (l3.isAttachedToWindow() && j2.f3066e.getCount() > j2.f3066e.getChildCount() && j2.f3066e.getChildCount() <= Integer.MAX_VALUE) {
                        j2.f3083x.setInputMethodMode(2);
                        j2.show();
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
