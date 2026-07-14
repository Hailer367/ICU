package T2;

/* loaded from: classes.dex */
public final class l extends m implements Y2.c, S2.p {
    @Override // T2.c
    public final Y2.a d() {
        q.f1646a.getClass();
        return this;
    }

    @Override // S2.p
    public final Object e(Object obj, Object obj2) {
        i();
        throw null;
    }

    public final void i() {
        if (!this.f1642l) {
            Y2.a h3 = h();
            if (h3 != this) {
                ((l) ((Y2.c) h3)).i();
                return;
            }
            throw new Error("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
    }
}
