package C0;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f150a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0.j f151b;

    public /* synthetic */ g(long j2, v0.j jVar) {
        this.f150a = j2;
        this.f151b = jVar;
    }

    @Override // C0.h
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f150a));
        v0.j jVar = this.f151b;
        String str = jVar.f3913a;
        s0.d dVar = jVar.f3915c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(F0.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", jVar.f3913a);
            contentValues.put("priority", Integer.valueOf(F0.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
