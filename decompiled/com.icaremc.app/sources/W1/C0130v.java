package W1;

import b2.C0224b;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: W1.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0130v {

    /* renamed from: a, reason: collision with root package name */
    public final String f1970a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f1971b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1972c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Method f1973d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ T1.s f1974e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ T1.s f1975f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f1976g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f1977h;

    public C0130v(String str, Field field, Method method, T1.s sVar, T1.s sVar2, boolean z, boolean z3) {
        this.f1973d = method;
        this.f1974e = sVar;
        this.f1975f = sVar2;
        this.f1976g = z;
        this.f1977h = z3;
        this.f1970a = str;
        this.f1971b = field;
        this.f1972c = field.getName();
    }

    public final void a(C0224b c0224b, Object obj) {
        Object obj2;
        Method method = this.f1973d;
        if (method != null) {
            try {
                obj2 = method.invoke(obj, null);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(r2.k.b("Accessor ", Y1.c.d(method, false), " threw exception"), e4.getCause());
            }
        } else {
            obj2 = this.f1971b.get(obj);
        }
        if (obj2 == obj) {
            return;
        }
        c0224b.g(this.f1970a);
        this.f1974e.c(c0224b, obj2);
    }
}
