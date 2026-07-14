package m;

import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class M extends J implements K {

    /* renamed from: B, reason: collision with root package name */
    public static final Method f3086B;

    /* renamed from: A, reason: collision with root package name */
    public F.h f3087A;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f3086B = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // m.K
    public final void b(l.j jVar, l.k kVar) {
        F.h hVar = this.f3087A;
        if (hVar != null) {
            hVar.b(jVar, kVar);
        }
    }

    @Override // m.K
    public final void d(l.j jVar, MenuItem menuItem) {
        F.h hVar = this.f3087A;
        if (hVar != null) {
            hVar.d(jVar, menuItem);
        }
    }
}
