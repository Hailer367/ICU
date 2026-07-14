package H1;

import D2.C0029h;
import android.content.Context;
import android.os.Build;
import b3.AbstractC0245u;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import q1.AbstractC0602b;
import r2.k;
import z1.C0751d;
import z1.C0752e;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final S.d f667b = AbstractC0602b.K("fire-global");

    /* renamed from: c, reason: collision with root package name */
    public static final S.d f668c = AbstractC0602b.K("fire-count");

    /* renamed from: d, reason: collision with root package name */
    public static final S.d f669d = AbstractC0602b.U("last-used-date");

    /* renamed from: a, reason: collision with root package name */
    public final z1.h f670a;

    public j(Context context, String str) {
        this.f670a = new z1.h(context, k.d("FirebaseHeartBeat", str));
    }

    public final synchronized ArrayList a() {
        try {
            ArrayList arrayList = new ArrayList();
            String b4 = b(System.currentTimeMillis());
            z1.h hVar = this.f670a;
            hVar.getClass();
            for (Map.Entry entry : ((Map) AbstractC0245u.i(new C0751d(hVar, null))).entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(b4);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new a(((S.d) entry.getKey()).f1538a, new ArrayList(hashSet)));
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                this.f670a.a(new C0029h(currentTimeMillis, 1));
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String b(long j4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j4)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j4));
    }

    public final synchronized S.d c(S.b bVar, String str) {
        for (Map.Entry entry : bVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return AbstractC0602b.V(((S.d) entry.getKey()).f1538a);
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void d(S.b bVar, String str) {
        try {
            S.d c4 = c(bVar, str);
            if (c4 == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) AbstractC0602b.D(bVar, c4, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                bVar.d(c4);
            } else {
                bVar.f(c4, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean e(S.d dVar, long j4) {
        long longValue;
        z1.h hVar = this.f670a;
        hVar.getClass();
        T2.h.e(dVar, "key");
        longValue = ((Long) AbstractC0245u.i(new C0752e(hVar, dVar, null))).longValue();
        synchronized (this) {
        }
        if (b(longValue).equals(b(j4))) {
            return false;
        }
        z1.h hVar2 = this.f670a;
        Long valueOf = Long.valueOf(j4);
        hVar2.getClass();
        return true;
    }
}
