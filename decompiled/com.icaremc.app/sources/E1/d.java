package E1;

import C1.f;
import C1.g;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d implements D1.a {

    /* renamed from: f, reason: collision with root package name */
    public static final b f466f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f467g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f469a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f470b;

    /* renamed from: c, reason: collision with root package name */
    public final a f471c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f472d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f465e = new a(0);

    /* renamed from: h, reason: collision with root package name */
    public static final c f468h = new Object();

    /* JADX WARN: Type inference failed for: r0v1, types: [E1.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [E1.b] */
    /* JADX WARN: Type inference failed for: r0v3, types: [E1.c, java.lang.Object] */
    static {
        final int i4 = 0;
        f466f = new f() { // from class: E1.b
            @Override // C1.a
            public final void a(Object obj, Object obj2) {
                switch (i4) {
                    case 0:
                        ((g) obj2).d((String) obj);
                        return;
                    default:
                        ((g) obj2).e(((Boolean) obj).booleanValue());
                        return;
                }
            }
        };
        final int i5 = 1;
        f467g = new f() { // from class: E1.b
            @Override // C1.a
            public final void a(Object obj, Object obj2) {
                switch (i5) {
                    case 0:
                        ((g) obj2).d((String) obj);
                        return;
                    default:
                        ((g) obj2).e(((Boolean) obj).booleanValue());
                        return;
                }
            }
        };
    }

    public d() {
        HashMap hashMap = new HashMap();
        this.f469a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f470b = hashMap2;
        this.f471c = f465e;
        this.f472d = false;
        hashMap2.put(String.class, f466f);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, f467g);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, f468h);
        hashMap.remove(Date.class);
    }

    public final D1.a a(Class cls, C1.d dVar) {
        this.f469a.put(cls, dVar);
        this.f470b.remove(cls);
        return this;
    }
}
