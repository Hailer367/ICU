package io.flutter.plugin.platform;

import android.view.MotionEvent;
import h2.C0354g;

/* renamed from: io.flutter.plugin.platform.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0379c extends C0354g {

    /* renamed from: m, reason: collision with root package name */
    public C0377a f4322m;

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        boolean f4;
        C0377a c0377a = this.f4322m;
        if (c0377a != null) {
            io.flutter.view.j jVar = c0377a.f4320a;
            if (jVar == null) {
                f4 = false;
            } else {
                f4 = jVar.f(motionEvent, true);
            }
            if (f4) {
                return true;
            }
        }
        return super.onHoverEvent(motionEvent);
    }
}
