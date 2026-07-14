package O0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import n.p;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Q0.b, y1.g {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1286f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f1287g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1288h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1289i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1290j;

    public /* synthetic */ i(l lVar, Iterable iterable, I0.j jVar, long j4) {
        this.f1286f = 0;
        this.f1288h = lVar;
        this.f1289i = iterable;
        this.f1290j = jVar;
        this.f1287g = j4;
    }

    @Override // y1.g
    public ScheduledFuture a(final p pVar) {
        switch (this.f1286f) {
            case 1:
                y1.f fVar = (y1.f) this.f1288h;
                Runnable runnable = (Runnable) this.f1289i;
                return fVar.f6577g.schedule(new y1.d(fVar, runnable, pVar, 1), this.f1287g, (TimeUnit) this.f1290j);
            default:
                final y1.f fVar2 = (y1.f) this.f1288h;
                final Callable callable = (Callable) this.f1289i;
                return fVar2.f6577g.schedule(new Callable() { // from class: y1.e
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return f.this.f6576f.submit(new A.j(13, callable, pVar));
                    }
                }, this.f1287g, (TimeUnit) this.f1290j);
        }
    }

    @Override // Q0.b
    public Object d() {
        l lVar = (l) this.f1288h;
        Iterable iterable = (Iterable) this.f1289i;
        I0.j jVar = (I0.j) this.f1290j;
        P0.h hVar = (P0.h) lVar.f1299c;
        hVar.getClass();
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + P0.h.g(iterable);
            SQLiteDatabase a4 = hVar.a();
            a4.beginTransaction();
            try {
                a4.compileStatement(str).execute();
                Cursor rawQuery = a4.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (rawQuery.moveToNext()) {
                    try {
                        hVar.e(rawQuery.getInt(0), L0.c.MAX_RETRIES_REACHED, rawQuery.getString(1));
                    } catch (Throwable th) {
                        rawQuery.close();
                        throw th;
                    }
                }
                rawQuery.close();
                a4.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                a4.setTransactionSuccessful();
            } finally {
                a4.endTransaction();
            }
        }
        hVar.c(new P0.e(lVar.f1303g.a() + this.f1287g, jVar));
        return null;
    }

    public /* synthetic */ i(y1.f fVar, Object obj, long j4, TimeUnit timeUnit, int i4) {
        this.f1286f = i4;
        this.f1288h = fVar;
        this.f1289i = obj;
        this.f1287g = j4;
        this.f1290j = timeUnit;
    }
}
