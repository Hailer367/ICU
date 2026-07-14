package com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh;

import R.j;
import android.graphics.Color;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import java.util.HashMap;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class PullToRefreshChannelDelegate extends ChannelDelegateImpl {
    private PullToRefreshLayout pullToRefreshView;

    public PullToRefreshChannelDelegate(PullToRefreshLayout pullToRefreshLayout, C0644p c0644p) {
        super(c0644p);
        this.pullToRefreshView = pullToRefreshLayout;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.pullToRefreshView = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        char c4;
        String str = c0641m.f6155a;
        str.getClass();
        boolean z = true;
        switch (str.hashCode()) {
            case -1790841290:
                if (str.equals("setSlingshotDistance")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 154556713:
                if (str.equals("setRefreshing")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 1235582893:
                if (str.equals("getDefaultSlingshotDistance")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 1364071551:
                if (str.equals("setEnabled")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1389555745:
                if (str.equals("setColor")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 1743806995:
                if (str.equals("setBackgroundColor")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 1807783361:
                if (str.equals("setDistanceToTriggerSync")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 1849446385:
                if (str.equals("isRefreshing")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 1984958339:
                if (str.equals("setSize")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 2105594551:
                if (str.equals("isEnabled")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setSlingshotDistance(((Integer) c0641m.a("slingshotDistance")).intValue());
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 1:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setRefreshing(((Boolean) c0641m.a("refreshing")).booleanValue());
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 2:
                interfaceC0643o.success(-1);
                return;
            case 3:
                if (this.pullToRefreshView != null) {
                    Boolean bool = (Boolean) c0641m.a("enabled");
                    PullToRefreshLayout pullToRefreshLayout = this.pullToRefreshView;
                    pullToRefreshLayout.settings.enabled = bool;
                    pullToRefreshLayout.setEnabled(bool.booleanValue());
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 4:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setColorSchemeColors(Color.parseColor((String) c0641m.a("color")));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 5:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setProgressBackgroundColorSchemeColor(Color.parseColor((String) c0641m.a("color")));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 6:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setDistanceToTriggerSync(((Integer) c0641m.a("distanceToTriggerSync")).intValue());
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                PullToRefreshLayout pullToRefreshLayout2 = this.pullToRefreshView;
                if (pullToRefreshLayout2 == null || !pullToRefreshLayout2.isRefreshing()) {
                    z = false;
                }
                interfaceC0643o.success(Boolean.valueOf(z));
                return;
            case j.BYTES_FIELD_NUMBER /* 8 */:
                if (this.pullToRefreshView != null) {
                    this.pullToRefreshView.setSize(((Integer) c0641m.a("size")).intValue());
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case '\t':
                PullToRefreshLayout pullToRefreshLayout3 = this.pullToRefreshView;
                if (pullToRefreshLayout3 != null) {
                    interfaceC0643o.success(Boolean.valueOf(pullToRefreshLayout3.isEnabled()));
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }

    public void onRefresh() {
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onRefresh", new HashMap(), null);
    }
}
