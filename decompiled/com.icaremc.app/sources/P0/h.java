package P0;

import O0.k;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
public final class h implements d, Q0.c, c {
    public static final F0.c k = new F0.c("proto");

    /* renamed from: f, reason: collision with root package name */
    public final j f1328f;

    /* renamed from: g, reason: collision with root package name */
    public final R0.a f1329g;

    /* renamed from: h, reason: collision with root package name */
    public final R0.a f1330h;

    /* renamed from: i, reason: collision with root package name */
    public final a f1331i;

    /* renamed from: j, reason: collision with root package name */
    public final G2.a f1332j;

    public h(R0.a aVar, R0.a aVar2, a aVar3, j jVar, G2.a aVar4) {
        this.f1328f = jVar;
        this.f1329g = aVar;
        this.f1330h = aVar2;
        this.f1331i = aVar3;
        this.f1332j = aVar4;
    }

    public static Long b(SQLiteDatabase sQLiteDatabase, I0.j jVar) {
        Long valueOf;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(jVar.f831a, String.valueOf(S0.a.a(jVar.f833c))));
        byte[] bArr = jVar.f832b;
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
            sb.append(((b) it.next()).f1321a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object h(Cursor cursor, f fVar) {
        try {
            return fVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        j jVar = this.f1328f;
        Objects.requireNonNull(jVar);
        R0.a aVar = this.f1330h;
        long a4 = aVar.a();
        while (true) {
            try {
                return jVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e4) {
                if (aVar.a() < this.f1331i.f1318c + a4) {
                    SystemClock.sleep(50L);
                } else {
                    throw new RuntimeException("Timed out while trying to open db.", e4);
                }
            }
        }
    }

    public final Object c(f fVar) {
        SQLiteDatabase a4 = a();
        a4.beginTransaction();
        try {
            Object apply = fVar.apply(a4);
            a4.setTransactionSuccessful();
            return apply;
        } finally {
            a4.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1328f.close();
    }

    public final ArrayList d(SQLiteDatabase sQLiteDatabase, I0.j jVar, int i4) {
        ArrayList arrayList = new ArrayList();
        Long b4 = b(sQLiteDatabase, jVar);
        if (b4 == null) {
            return arrayList;
        }
        h(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{b4.toString()}, null, null, null, String.valueOf(i4)), new N0.a(this, (Object) arrayList, jVar, 1));
        return arrayList;
    }

    public final void e(long j4, L0.c cVar, String str) {
        c(new k(j4, str, cVar));
    }

    public final Object f(Q0.b bVar) {
        SQLiteDatabase a4 = a();
        R0.a aVar = this.f1330h;
        long a5 = aVar.a();
        while (true) {
            try {
                a4.beginTransaction();
                try {
                    Object d4 = bVar.d();
                    a4.setTransactionSuccessful();
                    return d4;
                } finally {
                    a4.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e4) {
                if (aVar.a() < this.f1331i.f1318c + a5) {
                    SystemClock.sleep(50L);
                } else {
                    throw new RuntimeException("Timed out while trying to acquire the lock.", e4);
                }
            }
        }
    }
}
