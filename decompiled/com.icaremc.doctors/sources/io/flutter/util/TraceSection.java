package io.flutter.util;

import android.os.Build;
import android.os.Trace;
import android.support.v4.media.session.a;
import d0.AbstractC0175a;

/* loaded from: classes.dex */
public final class TraceSection implements AutoCloseable {
    private TraceSection(String str) {
        begin(str);
    }

    public static void begin(String str) {
        Trace.beginSection(a.J(cropSectionName(str)));
    }

    public static void beginAsyncSection(String str, int i2) {
        String cropSectionName = cropSectionName(str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0175a.a(a.J(cropSectionName), i2);
            return;
        }
        String J2 = a.J(cropSectionName);
        try {
            if (a.f1055c == null) {
                a.f1055c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            a.f1055c.invoke(null, Long.valueOf(a.f1053a), J2, Integer.valueOf(i2));
        } catch (Exception e2) {
            a.t("asyncTraceBegin", e2);
        }
    }

    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() {
        Trace.endSection();
    }

    public static void endAsyncSection(String str, int i2) {
        String cropSectionName = cropSectionName(str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0175a.b(a.J(cropSectionName), i2);
            return;
        }
        String J2 = a.J(cropSectionName);
        try {
            if (a.f1056d == null) {
                a.f1056d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            a.f1056d.invoke(null, Long.valueOf(a.f1053a), J2, Integer.valueOf(i2));
        } catch (Exception e2) {
            a.t("asyncTraceEnd", e2);
        }
    }

    public static TraceSection scoped(String str) {
        return new TraceSection(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end();
    }
}
