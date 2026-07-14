package B0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import m.C0267n;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements D0.b, C0.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f109a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f110b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f111c;

    public /* synthetic */ l(int i2, Object obj, Object obj2) {
        this.f109a = i2;
        this.f110b = obj;
        this.f111c = obj2;
    }

    @Override // D0.b
    public Object a() {
        switch (this.f109a) {
            case 0:
                n nVar = (n) this.f110b;
                Iterable iterable = (Iterable) this.f111c;
                C0.j jVar = (C0.j) nVar.f117c;
                jVar.getClass();
                if (iterable.iterator().hasNext()) {
                    jVar.a().compileStatement("DELETE FROM events WHERE _id in " + C0.j.g(iterable)).execute();
                    return null;
                }
                return null;
            default:
                n nVar2 = (n) this.f110b;
                for (Map.Entry entry : ((HashMap) this.f111c).entrySet()) {
                    ((C0.j) nVar2.f123i).e(((Integer) entry.getValue()).intValue(), y0.c.INVALID_PAYLOD, (String) entry.getKey());
                }
                return null;
        }
    }

    @Override // C0.h
    public Object apply(Object obj) {
        C0.j jVar = (C0.j) this.f110b;
        v0.j jVar2 = (v0.j) this.f111c;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        C0.a aVar = jVar.f158f;
        ArrayList d2 = jVar.d(sQLiteDatabase, jVar2, aVar.f140b);
        for (s0.d dVar : s0.d.values()) {
            if (dVar != jVar2.f3915c) {
                int size = aVar.f140b - d2.size();
                if (size <= 0) {
                    break;
                }
                A0.g a2 = v0.j.a();
                a2.n(jVar2.f3913a);
                if (dVar != null) {
                    a2.f32f = dVar;
                    a2.f31e = jVar2.f3914b;
                    d2.addAll(jVar.d(sQLiteDatabase, a2.a(), size));
                } else {
                    throw new NullPointerException("Null priority");
                }
            }
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < d2.size(); i2++) {
            sb.append(((C0.b) d2.get(i2)).f144a);
            if (i2 < d2.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                long j2 = query.getLong(0);
                Set set = (Set) hashMap.get(Long.valueOf(j2));
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(Long.valueOf(j2), set);
                }
                set.add(new C0.i(query.getString(1), query.getString(2)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        ListIterator listIterator = d2.listIterator();
        while (listIterator.hasNext()) {
            C0.b bVar = (C0.b) listIterator.next();
            long j3 = bVar.f144a;
            if (hashMap.containsKey(Long.valueOf(j3))) {
                C0267n c2 = bVar.f146c.c();
                for (C0.i iVar : (Set) hashMap.get(Long.valueOf(j3))) {
                    c2.a(iVar.f152a, iVar.f153b);
                }
                listIterator.set(new C0.b(j3, bVar.f145b, c2.c()));
            }
        }
        return d2;
    }
}
