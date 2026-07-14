package io.flutter.plugin.platform;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class v extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final InputMethodManager f4396a;

    public v(Context context, InputMethodManager inputMethodManager) {
        super(context);
        this.f4396a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createDisplayContext(Display display) {
        return new v(super.createDisplayContext(display), this.f4396a);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("input_method".equals(str)) {
            return this.f4396a;
        }
        return super.getSystemService(str);
    }
}
