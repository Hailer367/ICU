package P0;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements f {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f1324f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ I0.j f1325g;

    public /* synthetic */ e(long j4, I0.j jVar) {
        this.f1324f = j4;
        this.f1325g = jVar;
    }

    @Override // P0.f
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f1324f));
        I0.j jVar = this.f1325g;
        String str = jVar.f831a;
        F0.d dVar = jVar.f833c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(S0.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", jVar.f831a);
            contentValues.put("priority", Integer.valueOf(S0.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
