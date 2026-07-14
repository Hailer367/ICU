package s0;

import A2.i;
import I2.m;
import P1.x;
import S2.l;
import android.util.Log;
import f1.AbstractC0286a;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class f extends AbstractC0286a {

    /* renamed from: d, reason: collision with root package name */
    public final Object f6134d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6135e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6136f;

    /* renamed from: g, reason: collision with root package name */
    public final x f6137g;

    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Throwable, java.lang.Exception, P1.x] */
    public f(Object obj, String str, C0628a c0628a, int i4) {
        Collection collection;
        T2.h.e(obj, "value");
        i.m(i4, "verificationMode");
        this.f6134d = obj;
        this.f6135e = str;
        this.f6136f = i4;
        String d4 = AbstractC0286a.d(obj, str);
        T2.h.e(d4, "message");
        ?? exc = new Exception(d4);
        StackTraceElement[] stackTrace = exc.getStackTrace();
        T2.h.d(stackTrace, "stackTrace");
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length >= 0) {
            if (length == 0) {
                collection = m.f862f;
            } else {
                int length2 = stackTrace.length;
                if (length >= length2) {
                    collection = I2.d.a0(stackTrace);
                } else if (length == 1) {
                    collection = android.support.v4.media.session.a.p(stackTrace[length2 - 1]);
                } else {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i5 = length2 - length; i5 < length2; i5++) {
                        arrayList.add(stackTrace[i5]);
                    }
                    collection = arrayList;
                }
            }
            exc.setStackTrace((StackTraceElement[]) collection.toArray(new StackTraceElement[0]));
            this.f6137g = exc;
            return;
        }
        throw new IllegalArgumentException(("Requested element count " + length + " is less than zero.").toString());
    }

    @Override // f1.AbstractC0286a
    public final Object b() {
        int b4 = R.i.b(this.f6136f);
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 == 2) {
                    return null;
                }
                throw new RuntimeException();
            }
            String d4 = AbstractC0286a.d(this.f6134d, this.f6135e);
            T2.h.e(d4, "message");
            Log.d("g", d4);
            return null;
        }
        throw this.f6137g;
    }

    @Override // f1.AbstractC0286a
    public final AbstractC0286a E(String str, l lVar) {
        return this;
    }
}
