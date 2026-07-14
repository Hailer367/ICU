package androidx.lifecycle;

/* loaded from: classes.dex */
public class W implements V {

    /* renamed from: a, reason: collision with root package name */
    public static W f3000a;

    @Override // androidx.lifecycle.V
    public S a(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
            T2.h.d(newInstance, "{\n                modelC…wInstance()\n            }");
            return (S) newInstance;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        }
    }
}
