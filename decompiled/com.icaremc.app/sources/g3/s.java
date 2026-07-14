package g3;

import a.AbstractC0141a;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3808a = 0;

    static {
        Object f4;
        Object f5;
        Exception exc = new Exception();
        String simpleName = AbstractC0141a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            f4 = M2.a.class.getCanonicalName();
        } catch (Throwable th) {
            f4 = k3.b.f(th);
        }
        if (H2.f.a(f4) != null) {
            f4 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            f5 = s.class.getCanonicalName();
        } catch (Throwable th2) {
            f5 = k3.b.f(th2);
        }
        if (H2.f.a(f5) != null) {
            f5 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
