package io.flutter.plugins.imagepicker;

import Q0.g;
import a.AbstractC0051a;
import c1.l;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class ResultUtilsKt {
    public static final <T> void completeWithError(l callback, Throwable failure) {
        h.e(callback, "callback");
        h.e(failure, "failure");
        callback.invoke(new g(AbstractC0051a.j(failure)));
    }

    public static final <T> void completeWithValue(l callback, T t2) {
        h.e(callback, "callback");
        callback.invoke(new g(t2));
    }
}
