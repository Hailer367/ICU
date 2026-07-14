package C0;

import android.content.Context;

/* loaded from: classes.dex */
public final class e implements x0.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f147c;

    /* renamed from: d, reason: collision with root package name */
    public final P0.a f148d;

    public /* synthetic */ e(P0.a aVar, int i2) {
        this.f147c = i2;
        this.f148d = aVar;
    }

    @Override // P0.a
    public final Object get() {
        switch (this.f147c) {
            case 0:
                String packageName = ((Context) this.f148d.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            default:
                return new l((Context) this.f148d.get(), Integer.valueOf(l.f162f).intValue(), "com.google.android.datatransport.events");
        }
    }
}
