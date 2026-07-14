package k;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* renamed from: k.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class MenuItemOnMenuItemClickListenerC0218b implements MenuItem.OnMenuItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final Class[] f2738c = {MenuItem.class};

    /* renamed from: a, reason: collision with root package name */
    public Object f2739a;

    /* renamed from: b, reason: collision with root package name */
    public Method f2740b;

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Object obj = this.f2739a;
        Method method = this.f2740b;
        try {
            if (method.getReturnType() == Boolean.TYPE) {
                return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
            }
            method.invoke(obj, menuItem);
            return true;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
