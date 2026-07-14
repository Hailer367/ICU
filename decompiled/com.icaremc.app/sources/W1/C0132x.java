package W1;

import b2.C0223a;
import java.lang.reflect.Field;

/* renamed from: W1.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0132x extends AbstractC0131w {

    /* renamed from: b, reason: collision with root package name */
    public final V1.p f1979b;

    public C0132x(V1.p pVar, C0133y c0133y) {
        super(c0133y);
        this.f1979b = pVar;
    }

    @Override // W1.AbstractC0131w
    public final Object d() {
        return this.f1979b.g();
    }

    @Override // W1.AbstractC0131w
    public final void f(Object obj, C0223a c0223a, C0130v c0130v) {
        Field field = c0130v.f1971b;
        Object b4 = c0130v.f1975f.b(c0223a);
        if (b4 == null && c0130v.f1976g) {
            return;
        }
        if (!c0130v.f1977h) {
            field.set(obj, b4);
            return;
        }
        throw new RuntimeException(r2.k.d("Cannot set value of 'static final' ", Y1.c.d(field, false)));
    }

    @Override // W1.AbstractC0131w
    public final Object e(Object obj) {
        return obj;
    }
}
