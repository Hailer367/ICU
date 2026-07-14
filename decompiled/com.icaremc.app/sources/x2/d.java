package x2;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d implements o2.c, l, j {

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f6504h = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public Context f6505f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6506g = false;

    /* JADX WARN: Type inference failed for: r7v0, types: [x2.f, java.lang.Object] */
    public static f c(u1.g gVar) {
        String str = gVar.f6231a;
        String str2 = gVar.f6232b;
        String str3 = gVar.f6235e;
        if (str3 == null) {
            str3 = null;
        }
        String str4 = gVar.f6237g;
        if (str4 == null) {
            str4 = null;
        }
        String str5 = gVar.f6233c;
        String str6 = gVar.f6236f;
        String str7 = gVar.f6234d;
        ?? obj = new Object();
        if (str != null) {
            obj.f6509a = str;
            if (str2 != null) {
                obj.f6510b = str2;
                if (str3 != null) {
                    obj.f6511c = str3;
                    if (str4 != null) {
                        obj.f6512d = str4;
                        obj.f6513e = null;
                        obj.f6514f = str5;
                        obj.f6515g = str6;
                        obj.f6516h = null;
                        obj.f6517i = str7;
                        obj.f6518j = null;
                        obj.k = null;
                        obj.f6519l = null;
                        obj.f6520m = null;
                        obj.f6521n = null;
                        return obj;
                    }
                    throw new IllegalStateException("Nonnull field \"projectId\" is null.");
                }
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            throw new IllegalStateException("Nonnull field \"appId\" is null.");
        }
        throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
    }

    @Override // o2.c
    public final void onAttachedToEngine(o2.b bVar) {
        l.a(bVar.f5787c, this);
        j.b(bVar.f5787c, this);
        this.f6505f = bVar.f5785a;
    }

    @Override // o2.c
    public final void onDetachedFromEngine(o2.b bVar) {
        this.f6505f = null;
        l.a(bVar.f5787c, null);
        j.b(bVar.f5787c, null);
    }
}
