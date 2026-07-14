package H1;

import android.content.Context;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import x1.C0721a;
import x1.o;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements J1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f650a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f651b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f652c;

    public /* synthetic */ c(int i4, Object obj, Object obj2) {
        this.f650a = i4;
        this.f651b = obj;
        this.f652c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [I0.h, java.lang.Object] */
    @Override // J1.a
    public final Object get() {
        boolean z;
        switch (this.f650a) {
            case 0:
                return new j((Context) this.f651b, (String) this.f652c);
            case 1:
                u1.f fVar = (u1.f) this.f652c;
                return new O1.a((Context) this.f651b, fVar.f(), (G1.b) fVar.f6224d.a(G1.b.class));
            default:
                x1.d dVar = (x1.d) this.f651b;
                C0721a c0721a = (C0721a) this.f652c;
                x1.c cVar = c0721a.f6460f;
                ?? obj = new Object();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = new HashSet();
                HashSet hashSet5 = new HashSet();
                Set<x1.g> set = c0721a.f6457c;
                Set set2 = c0721a.f6461g;
                for (x1.g gVar : set) {
                    int i4 = gVar.f6477c;
                    int i5 = gVar.f6476b;
                    if (i4 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    o oVar = gVar.f6475a;
                    if (z) {
                        if (i5 == 2) {
                            hashSet4.add(oVar);
                        } else {
                            hashSet.add(oVar);
                        }
                    } else if (i4 == 2) {
                        hashSet3.add(oVar);
                    } else if (i5 == 2) {
                        hashSet5.add(oVar);
                    } else {
                        hashSet2.add(oVar);
                    }
                }
                if (!set2.isEmpty()) {
                    hashSet.add(o.a(G1.b.class));
                }
                obj.f819a = Collections.unmodifiableSet(hashSet);
                obj.f820b = Collections.unmodifiableSet(hashSet2);
                Collections.unmodifiableSet(hashSet3);
                obj.f821c = Collections.unmodifiableSet(hashSet4);
                obj.f822d = Collections.unmodifiableSet(hashSet5);
                obj.f823e = set2;
                obj.f824f = dVar;
                return cVar.a(obj);
        }
    }

    public /* synthetic */ c(u1.f fVar, Context context) {
        this.f650a = 1;
        this.f652c = fVar;
        this.f651b = context;
    }
}
