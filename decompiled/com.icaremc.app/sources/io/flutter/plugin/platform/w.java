package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;

/* loaded from: classes.dex */
public final class w extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final F f4397a;

    /* renamed from: b, reason: collision with root package name */
    public F f4398b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f4399c;

    public w(Context context, F f4, Context context2) {
        super(context);
        this.f4397a = f4;
        this.f4399c = context2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("window".equals(str)) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i4 = 0; i4 < stackTrace.length && i4 < 11; i4++) {
                if (stackTrace[i4].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i4].getMethodName().equals("<init>")) {
                    return this.f4399c.getSystemService(str);
                }
            }
            if (this.f4398b == null) {
                this.f4398b = this.f4397a;
            }
            return this.f4398b;
        }
        return super.getSystemService(str);
    }
}
