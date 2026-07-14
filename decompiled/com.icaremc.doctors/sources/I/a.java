package I;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import m.e0;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f312a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e0 e0Var) {
        super(new Handler());
        this.f312a = e0Var;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        Cursor cursor;
        e0 e0Var = this.f312a;
        if (e0Var.f316d && (cursor = e0Var.f317e) != null && !cursor.isClosed()) {
            e0Var.f315c = e0Var.f317e.requery();
        }
    }
}
