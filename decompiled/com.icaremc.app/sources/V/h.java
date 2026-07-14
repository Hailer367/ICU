package V;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class h extends T.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1666a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f1667b;

    public h(EditText editText) {
        this.f1667b = new WeakReference(editText);
    }

    @Override // T.h
    public void a() {
        switch (this.f1666a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.f1667b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // T.h
    public final void b() {
        switch (this.f1666a) {
            case 0:
                i.a((EditText) this.f1667b.get(), 1);
                return;
            default:
                SwitchCompat switchCompat = (SwitchCompat) this.f1667b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    return;
                }
                return;
        }
    }

    public h(SwitchCompat switchCompat) {
        this.f1667b = new WeakReference(switchCompat);
    }
}
