package com.pichillilorenzo.flutter_inappwebview_android.types;

import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class ChannelDelegateImpl implements IChannelDelegate {
    private C0644p channel;

    public ChannelDelegateImpl(C0644p c0644p) {
        this.channel = c0644p;
        c0644p.b(this);
    }

    public void dispose() {
        C0644p c0644p = this.channel;
        if (c0644p != null) {
            c0644p.b(null);
            this.channel = null;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate
    public C0644p getChannel() {
        return this.channel;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
    }
}
