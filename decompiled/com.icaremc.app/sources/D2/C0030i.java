package D2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import f1.AbstractC0286a;
import java.util.ArrayList;

/* renamed from: D2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0030i {

    /* renamed from: a, reason: collision with root package name */
    public final L f401a;

    public C0030i(L l3, int i4) {
        switch (i4) {
            case 1:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            case 2:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            case 3:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            case 4:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            case 5:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            case 6:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            case R.j.DOUBLE_FIELD_NUMBER /* 7 */:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
            default:
                T2.h.e(l3, "pigeonRegistrar");
                this.f401a = l3;
                return;
        }
    }

    public h0 a() {
        DisplayManager displayManager = (DisplayManager) ((Context) this.f401a.f299i).getSystemService("display");
        ArrayList P = AbstractC0286a.P(displayManager);
        h0 h0Var = new h0(this);
        ArrayList P3 = AbstractC0286a.P(displayManager);
        P3.removeAll(P);
        if (!P3.isEmpty()) {
            int size = P3.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = P3.get(i4);
                i4++;
                displayManager.unregisterDisplayListener((DisplayManager.DisplayListener) obj);
                displayManager.registerDisplayListener(new C0035n(P3, displayManager, 0), null);
            }
        }
        return h0Var;
    }
}
