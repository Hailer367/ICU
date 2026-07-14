package B0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements D0.b, C0.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f113b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f114c;

    public /* synthetic */ m(long j2, Object obj, Object obj2) {
        this.f113b = obj;
        this.f114c = obj2;
        this.f112a = j2;
    }

    @Override // D0.b
    public Object a() {
        n nVar = (n) this.f113b;
        v0.j jVar = (v0.j) this.f114c;
        C0.d dVar = nVar.f117c;
        long j2 = nVar.f121g.j() + this.f112a;
        C0.j jVar2 = (C0.j) dVar;
        jVar2.getClass();
        jVar2.c(new C0.g(j2, jVar));
        return null;
    }

    @Override // C0.h
    public Object apply(Object obj) {
        boolean z;
        String str = (String) this.f113b;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i2 = ((y0.c) this.f114c).f3998c;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i2)});
        try {
            if (rawQuery.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            rawQuery.close();
            long j2 = this.f112a;
            if (!z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_source", str);
                contentValues.put("reason", Integer.valueOf(i2));
                contentValues.put("events_dropped_count", Long.valueOf(j2));
                sQLiteDatabase.insert("log_event_dropped", null, contentValues);
                return null;
            }
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i2)});
            return null;
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }
}
