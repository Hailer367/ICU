package O0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Q0.b, P0.f {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f1294f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1295g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1296h;

    public /* synthetic */ k(long j4, Object obj, Object obj2) {
        this.f1295g = obj;
        this.f1296h = obj2;
        this.f1294f = j4;
    }

    @Override // P0.f
    public Object apply(Object obj) {
        boolean z;
        String str = (String) this.f1295g;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i4 = ((L0.c) this.f1296h).f990f;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i4)});
        try {
            if (rawQuery.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            rawQuery.close();
            long j4 = this.f1294f;
            if (!z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_source", str);
                contentValues.put("reason", Integer.valueOf(i4));
                contentValues.put("events_dropped_count", Long.valueOf(j4));
                sQLiteDatabase.insert("log_event_dropped", null, contentValues);
                return null;
            }
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j4 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i4)});
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // Q0.b
    public Object d() {
        l lVar = (l) this.f1295g;
        I0.j jVar = (I0.j) this.f1296h;
        P0.d dVar = lVar.f1299c;
        long a4 = lVar.f1303g.a() + this.f1294f;
        P0.h hVar = (P0.h) dVar;
        hVar.getClass();
        hVar.c(new P0.e(a4, jVar));
        return null;
    }
}
