package T2;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements Y2.a, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public transient Y2.a f1630f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1631g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f1632h;

    /* renamed from: i, reason: collision with root package name */
    public final String f1633i;

    /* renamed from: j, reason: collision with root package name */
    public final String f1634j;
    public final boolean k;

    public c(Object obj, Class cls, String str, String str2, boolean z) {
        this.f1631g = obj;
        this.f1632h = cls;
        this.f1633i = str;
        this.f1634j = str2;
        this.k = z;
    }

    public abstract Y2.a d();

    public final d g() {
        boolean z = this.k;
        Class cls = this.f1632h;
        if (z) {
            q.f1646a.getClass();
            return new j(cls);
        }
        return q.a(cls);
    }
}
