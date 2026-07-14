package io.flutter.plugin.platform;

import android.content.Context;
import s2.C0650v;
import s2.InterfaceC0640l;

/* loaded from: classes.dex */
public abstract class g {
    private final InterfaceC0640l createArgsCodec = C0650v.f6160a;

    public abstract InterfaceC0382f create(Context context, int i4, Object obj);

    public final InterfaceC0640l getCreateArgsCodec() {
        return this.createArgsCodec;
    }
}
