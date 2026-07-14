package androidx.lifecycle;

/* loaded from: classes.dex */
public class b0 implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public static b0 f1830a;

    @Override // androidx.lifecycle.a0
    public X a(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
            kotlin.jvm.internal.h.d(newInstance, "{\n                modelC…wInstance()\n            }");
            return (X) newInstance;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }
}
