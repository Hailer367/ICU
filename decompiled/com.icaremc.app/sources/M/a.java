package M;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import h2.p;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.j;
import o.j1;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1021a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1022b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Handler handler, int i4) {
        super(handler);
        this.f1021a = i4;
        this.f1022b = obj;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f1021a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        Cursor cursor;
        switch (this.f1021a) {
            case 0:
                j1 j1Var = (j1) this.f1022b;
                if (!j1Var.f1026g || (cursor = j1Var.f1027h) == null || cursor.isClosed()) {
                    return;
                }
                j1Var.f1025f = j1Var.f1027h.requery();
                return;
            case 1:
                super.onChange(z);
                p pVar = (p) this.f1022b;
                if (pVar.f4031o == null) {
                    return;
                }
                pVar.d();
                return;
            default:
                onChange(z, null);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(j1 j1Var) {
        super(new Handler());
        this.f1021a = 0;
        this.f1022b = j1Var;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        switch (this.f1021a) {
            case 2:
                j jVar = (j) this.f1022b;
                if (jVar.f4528u) {
                    return;
                }
                if (Settings.Global.getFloat(jVar.f4514f, "transition_animation_scale", 1.0f) == 0.0f) {
                    jVar.f4519l |= 4;
                } else {
                    jVar.f4519l &= -5;
                }
                ((FlutterJNI) jVar.f4510b.f100h).setAccessibilityFeatures(jVar.f4519l);
                return;
            default:
                super.onChange(z, uri);
                return;
        }
    }
}
