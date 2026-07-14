package F;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class g implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f496a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f497b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f498c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f499d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f500e;

    public /* synthetic */ g(String str, Context context, Object obj, int i4, int i5) {
        this.f496a = i5;
        this.f497b = str;
        this.f498c = context;
        this.f500e = obj;
        this.f499d = i4;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f496a) {
            case 0:
                Object[] objArr = {(f) this.f500e};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                return j.b(this.f497b, this.f498c, Collections.unmodifiableList(arrayList), this.f499d);
            default:
                try {
                    return j.b(this.f497b, this.f498c, (ArrayList) this.f500e, this.f499d);
                } catch (Throwable unused) {
                    return new i(-3);
                }
        }
    }
}
