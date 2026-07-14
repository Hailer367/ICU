package androidx.fragment.app;

/* renamed from: androidx.fragment.app.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0100a0 {

    /* renamed from: b, reason: collision with root package name */
    public static final r.j f1580b = new r.j(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f1581a;

    public C0100a0(h0 h0Var) {
        this.f1581a = h0Var;
    }

    public static Class a(String str, ClassLoader classLoader) {
        r.j jVar = f1580b;
        r.j jVar2 = (r.j) jVar.get(classLoader);
        if (jVar2 == null) {
            jVar2 = new r.j(0);
            jVar.put(classLoader, jVar2);
        }
        Class cls = (Class) jVar2.get(str);
        if (cls == null) {
            Class<?> cls2 = Class.forName(str, false, classLoader);
            jVar2.put(str, cls2);
            return cls2;
        }
        return cls;
    }

    public static Class b(String str, ClassLoader classLoader) {
        try {
            return a(str, classLoader);
        } catch (ClassCastException e2) {
            throw new RuntimeException(O.a.g("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(O.a.g("Unable to instantiate fragment ", str, ": make sure class name exists"), e3);
        }
    }
}
