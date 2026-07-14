package K;

import a.AbstractC0051a;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: K.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0032g extends V0.h implements c1.l {

    /* renamed from: c, reason: collision with root package name */
    public int f476c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ M.d f477d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0032g(M.d dVar, T0.d dVar2) {
        super(1, dVar2);
        this.f477d = dVar;
    }

    @Override // V0.a
    public final T0.d create(T0.d dVar) {
        return new C0032g(this.f477d, dVar);
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        return ((C0032g) create((T0.d) obj)).invokeSuspend(Q0.j.f722a);
    }

    @Override // V0.a
    public final Object invokeSuspend(Object obj) {
        U0.a aVar = U0.a.f780c;
        int i2 = this.f476c;
        Q0.j jVar = Q0.j.f722a;
        if (i2 != 0) {
            if (i2 == 1) {
                AbstractC0051a.V(obj);
                return jVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC0051a.V(obj);
        this.f476c = 1;
        M.d dVar = this.f477d;
        SharedPreferences.Editor edit = ((SharedPreferences) dVar.f607e.a()).edit();
        LinkedHashSet linkedHashSet = dVar.f608f;
        if (linkedHashSet == null) {
            edit.clear();
        } else {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                edit.remove((String) it.next());
            }
        }
        if (edit.commit()) {
            if (((SharedPreferences) dVar.f607e.a()).getAll().isEmpty()) {
                Context context = dVar.f605c;
                String str = dVar.f606d;
                if (str != null) {
                    M.b.a(context, str);
                }
            }
            if (linkedHashSet != null) {
                linkedHashSet.clear();
            }
            if (jVar == aVar) {
                return aVar;
            }
            return jVar;
        }
        throw new IOException("Unable to delete migrated keys from SharedPreferences.");
    }
}
