package C0;

import B0.m;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import s0.C0301c;

/* loaded from: classes.dex */
public final class j implements d, D0.c, c {

    /* renamed from: h, reason: collision with root package name */
    public static final C0301c f154h = new C0301c("proto");

    /* renamed from: c, reason: collision with root package name */
    public final l f155c;

    /* renamed from: d, reason: collision with root package name */
    public final A0.f f156d;

    /* renamed from: e, reason: collision with root package name */
    public final A0.f f157e;

    /* renamed from: f, reason: collision with root package name */
    public final a f158f;

    /* renamed from: g, reason: collision with root package name */
    public final P0.a f159g;

    public j(A0.f fVar, A0.f fVar2, a aVar, l lVar, P0.a aVar2) {
        this.f155c = lVar;
        this.f156d = fVar;
        this.f157e = fVar2;
        this.f158f = aVar;
        this.f159g = aVar2;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, v0.j jVar) {
        Long valueOf;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(jVar.f3913a, String.valueOf(F0.a.a(jVar.f3915c))));
        byte[] bArr = jVar.f3914b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            if (!query.moveToNext()) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(query.getLong(0));
            }
            return valueOf;
        } finally {
            query.close();
        }
    }

    public static String g(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f144a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object h(Cursor cursor, h hVar) {
        try {
            return hVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        l lVar = this.f155c;
        Objects.requireNonNull(lVar);
        A0.f fVar = this.f157e;
        long j2 = fVar.j();
        while (true) {
            try {
                return lVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e2) {
                if (fVar.j() < this.f158f.f141c + j2) {
                    SystemClock.sleep(50L);
                } else {
                    throw new RuntimeException("Timed out while trying to open db.", e2);
                }
            }
        }
    }

    public final Object c(h hVar) {
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            Object apply = hVar.apply(a2);
            a2.setTransactionSuccessful();
            return apply;
        } finally {
            a2.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f155c.close();
    }

    public final ArrayList d(SQLiteDatabase sQLiteDatabase, v0.j jVar, int i2) {
        ArrayList arrayList = new ArrayList();
        Long b2 = b(sQLiteDatabase, jVar);
        if (b2 == null) {
            return arrayList;
        }
        h(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{b2.toString()}, null, null, null, String.valueOf(i2)), new A0.b(this, (Object) arrayList, jVar, 2));
        return arrayList;
    }

    public final void e(long j2, y0.c cVar, String str) {
        c(new m(j2, str, cVar));
    }

    public final Object f(D0.b bVar) {
        SQLiteDatabase a2 = a();
        A0.f fVar = this.f157e;
        long j2 = fVar.j();
        while (true) {
            try {
                a2.beginTransaction();
                try {
                    Object a3 = bVar.a();
                    a2.setTransactionSuccessful();
                    return a3;
                } finally {
                    a2.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e2) {
                if (fVar.j() < this.f158f.f141c + j2) {
                    SystemClock.sleep(50L);
                } else {
                    throw new RuntimeException("Timed out while trying to acquire the lock.", e2);
                }
            }
        }
    }
}
