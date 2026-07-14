package Q;

import T2.h;
import T2.i;
import android.content.Context;
import android.content.SharedPreferences;
import h2.m;
import java.io.File;
import v0.C0679b;
import w0.InterfaceC0695a;

/* loaded from: classes.dex */
public final class a extends i implements S2.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1478g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1479h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f1480i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i4, Object obj, Object obj2) {
        super(0);
        this.f1478g = i4;
        this.f1479h = obj;
        this.f1480i = obj2;
    }

    @Override // S2.a
    public final Object a() {
        switch (this.f1478g) {
            case 0:
                SharedPreferences sharedPreferences = ((Context) this.f1479h).getSharedPreferences((String) this.f1480i, 0);
                h.d(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
                return sharedPreferences;
            case 1:
                Context context = (Context) this.f1479h;
                h.d(context, "applicationContext");
                String str = ((R.b) this.f1480i).f1515a;
                h.e(str, "name");
                String concat = str.concat(".preferences_pb");
                h.e(concat, "fileName");
                return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat(concat));
            default:
                ((InterfaceC0695a) ((C0679b) this.f1479h).f6267g).a((m) this.f1480i);
                return H2.i.f681a;
        }
    }
}
