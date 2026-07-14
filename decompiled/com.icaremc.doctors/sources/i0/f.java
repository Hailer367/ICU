package i0;

import R0.r;
import a.AbstractC0051a;
import android.util.Log;
import c1.l;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class f extends AbstractC0051a {

    /* renamed from: f, reason: collision with root package name */
    public final Object f2340f;

    /* renamed from: g, reason: collision with root package name */
    public final String f2341g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2342h;

    /* renamed from: i, reason: collision with root package name */
    public final i f2343i;

    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Throwable, i0.i, java.lang.Exception] */
    public f(Object value, String str, C0204a c0204a, int i2) {
        Collection collection;
        kotlin.jvm.internal.h.e(value, "value");
        O.a.k(i2, "verificationMode");
        this.f2340f = value;
        this.f2341g = str;
        this.f2342h = i2;
        String message = AbstractC0051a.o(value, str);
        kotlin.jvm.internal.h.e(message, "message");
        ?? exc = new Exception(message);
        StackTraceElement[] stackTrace = exc.getStackTrace();
        kotlin.jvm.internal.h.d(stackTrace, "stackTrace");
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length >= 0) {
            if (length == 0) {
                collection = r.f750c;
            } else {
                int length2 = stackTrace.length;
                if (length >= length2) {
                    collection = R0.i.c0(stackTrace);
                } else if (length == 1) {
                    collection = android.support.v4.media.session.a.y(stackTrace[length2 - 1]);
                } else {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i3 = length2 - length; i3 < length2; i3++) {
                        arrayList.add(stackTrace[i3]);
                    }
                    collection = arrayList;
                }
            }
            exc.setStackTrace((StackTraceElement[]) collection.toArray(new StackTraceElement[0]));
            this.f2343i = exc;
            return;
        }
        throw new IllegalArgumentException(("Requested element count " + length + " is less than zero.").toString());
    }

    @Override // a.AbstractC0051a
    public final Object f() {
        int b2 = N.i.b(this.f2342h);
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 == 2) {
                    return null;
                }
                throw new RuntimeException();
            }
            String message = AbstractC0051a.o(this.f2340f, this.f2341g);
            kotlin.jvm.internal.h.e(message, "message");
            Log.d("g", message);
            return null;
        }
        throw this.f2343i;
    }

    @Override // a.AbstractC0051a
    public final AbstractC0051a L(String str, l lVar) {
        return this;
    }
}
