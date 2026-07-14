package D2;

import android.hardware.display.DisplayManager;
import java.util.ArrayList;

/* renamed from: D2.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0035n implements DisplayManager.DisplayListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f417a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayManager f418b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f419c;

    public /* synthetic */ C0035n(Object obj, DisplayManager displayManager, int i4) {
        this.f417a = i4;
        this.f419c = obj;
        this.f418b = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i4) {
        switch (this.f417a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f419c;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((DisplayManager.DisplayListener) obj).onDisplayAdded(i4);
                }
                return;
            default:
                return;
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i4) {
        switch (this.f417a) {
            case 0:
                if (this.f418b.getDisplay(i4) != null) {
                    ArrayList arrayList = (ArrayList) this.f419c;
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        ((DisplayManager.DisplayListener) obj).onDisplayChanged(i4);
                    }
                    return;
                }
                return;
            default:
                if (i4 == 0) {
                    float refreshRate = this.f418b.getDisplay(0).getRefreshRate();
                    io.flutter.view.t tVar = (io.flutter.view.t) this.f419c;
                    tVar.f4548a = (long) (1.0E9d / refreshRate);
                    tVar.f4549b.setRefreshRateFPS(refreshRate);
                    return;
                }
                return;
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i4) {
        switch (this.f417a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f419c;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((DisplayManager.DisplayListener) obj).onDisplayRemoved(i4);
                }
                return;
            default:
                return;
        }
    }

    private final void a(int i4) {
    }

    private final void b(int i4) {
    }
}
