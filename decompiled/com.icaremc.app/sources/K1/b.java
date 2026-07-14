package K1;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements J1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f912a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f913b;

    public /* synthetic */ b(int i4, Object obj) {
        this.f912a = i4;
        this.f913b = obj;
    }

    @Override // J1.a
    public final Object get() {
        switch (this.f912a) {
            case 0:
                return new L1.c((u1.f) this.f913b);
            case 1:
                String str = (String) this.f913b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new RuntimeException("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(r2.k.b("Could not instantiate ", str, "."), e4);
                } catch (InstantiationException e5) {
                    throw new RuntimeException(r2.k.b("Could not instantiate ", str, "."), e5);
                } catch (NoSuchMethodException e6) {
                    throw new RuntimeException(r2.k.d("Could not instantiate ", str), e6);
                } catch (InvocationTargetException e7) {
                    throw new RuntimeException(r2.k.d("Could not instantiate ", str), e7);
                }
            default:
                return (ComponentRegistrar) this.f913b;
        }
    }
}
