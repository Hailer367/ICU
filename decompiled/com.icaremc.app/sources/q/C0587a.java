package q;

import java.util.HashMap;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0587a extends C0592f {

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f5838j = new HashMap();

    @Override // q.C0592f
    public final C0589c a(Object obj) {
        return (C0589c) this.f5838j.get(obj);
    }

    @Override // q.C0592f
    public final Object b(Object obj) {
        Object b4 = super.b(obj);
        this.f5838j.remove(obj);
        return b4;
    }
}
