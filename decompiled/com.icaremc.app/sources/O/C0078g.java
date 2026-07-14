package O;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: O.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0078g extends M2.h implements S2.l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1189j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1190l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0078g(Object obj, K2.d dVar, int i4) {
        super(1, dVar);
        this.f1189j = i4;
        this.f1190l = obj;
    }

    @Override // S2.l
    public final Object f(Object obj) {
        K2.d dVar = (K2.d) obj;
        switch (this.f1189j) {
            case 0:
                return new C0078g((Q.d) this.f1190l, dVar, 0).k(H2.i.f681a);
            default:
                return new C0078g((F) this.f1190l, dVar, 1).k(H2.i.f681a);
        }
    }

    @Override // M2.a
    public final Object k(Object obj) {
        Context context;
        String str;
        switch (this.f1189j) {
            case 0:
                int i4 = this.k;
                H2.i iVar = H2.i.f681a;
                if (i4 != 0) {
                    if (i4 == 1) {
                        k3.b.A(obj);
                        return iVar;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k3.b.A(obj);
                Q.d dVar = (Q.d) this.f1190l;
                this.k = 1;
                SharedPreferences.Editor edit = ((SharedPreferences) dVar.f1488e.a()).edit();
                LinkedHashSet linkedHashSet = dVar.f1489f;
                if (linkedHashSet == null) {
                    edit.clear();
                } else {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        edit.remove((String) it.next());
                    }
                }
                if (edit.commit()) {
                    if (((SharedPreferences) dVar.f1488e.a()).getAll().isEmpty() && (context = dVar.f1486c) != null && (str = dVar.f1487d) != null) {
                        Q.b.a(context, str);
                    }
                    if (linkedHashSet != null) {
                        linkedHashSet.clear();
                    }
                    L2.a aVar = L2.a.f1019f;
                    if (iVar == aVar) {
                        return aVar;
                    }
                    return iVar;
                }
                throw new IOException("Unable to delete migrated keys from SharedPreferences.");
            default:
                int i5 = this.k;
                if (i5 != 0) {
                    if (i5 == 1) {
                        k3.b.A(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k3.b.A(obj);
                F f4 = (F) this.f1190l;
                this.k = 1;
                Object f5 = f4.f(this);
                L2.a aVar2 = L2.a.f1019f;
                if (f5 == aVar2) {
                    return aVar2;
                }
                return f5;
        }
    }
}
