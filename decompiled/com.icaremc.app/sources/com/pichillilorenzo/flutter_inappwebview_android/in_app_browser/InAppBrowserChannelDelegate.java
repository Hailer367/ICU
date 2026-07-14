package com.pichillilorenzo.flutter_inappwebview_android.in_app_browser;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.InAppBrowserMenuItem;
import java.util.HashMap;
import s2.C0644p;

/* loaded from: classes.dex */
public class InAppBrowserChannelDelegate extends ChannelDelegateImpl {
    public InAppBrowserChannelDelegate(C0644p c0644p) {
        super(c0644p);
    }

    public void onBrowserCreated() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onBrowserCreated", new HashMap(), null);
    }

    public void onExit() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onExit", new HashMap(), null);
    }

    public void onMenuItemClicked(InAppBrowserMenuItem inAppBrowserMenuItem) {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(inAppBrowserMenuItem.getId()));
        channel.a("onMenuItemClicked", hashMap, null);
    }
}
