package B;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f54b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f55c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f56d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f57e;

    public /* synthetic */ h(String str, Context context, Object obj, int i2, int i3) {
        this.f53a = i3;
        this.f54b = str;
        this.f55c = context;
        this.f57e = obj;
        this.f56d = i2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f53a) {
            case 0:
                Object[] objArr = {(g) this.f57e};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                return k.b(this.f54b, this.f55c, Collections.unmodifiableList(arrayList), this.f56d);
            default:
                try {
                    return k.b(this.f54b, this.f55c, (ArrayList) this.f57e, this.f56d);
                } catch (Throwable unused) {
                    return new j(-3);
                }
        }
    }
}
