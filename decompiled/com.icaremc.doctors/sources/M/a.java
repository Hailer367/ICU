package M;

import Q0.j;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class a extends i implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f596c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f597d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f598e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        super(0);
        this.f596c = i2;
        this.f597d = obj;
        this.f598e = obj2;
    }

    @Override // c1.a
    public final Object invoke() {
        switch (this.f596c) {
            case 0:
                SharedPreferences sharedPreferences = ((Context) this.f597d).getSharedPreferences((String) this.f598e, 0);
                h.d(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
                return sharedPreferences;
            case 1:
                Context applicationContext = (Context) this.f597d;
                h.d(applicationContext, "applicationContext");
                String name = ((N.b) this.f598e).f613a;
                h.e(name, "name");
                String fileName = name.concat(".preferences_pb");
                h.e(fileName, "fileName");
                return new File(applicationContext.getApplicationContext().getFilesDir(), "datastore/".concat(fileName));
            default:
                ((m0.a) ((l0.b) this.f597d).f2924c).b((l0.i) this.f598e);
                return j.f722a;
        }
    }
}
