package com.pichillilorenzo.flutter_inappwebview_android.find_interaction;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.FindSession;
import java.util.HashMap;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class FindInteractionChannelDelegate extends ChannelDelegateImpl {
    private FindInteractionController findInteractionController;

    public FindInteractionChannelDelegate(FindInteractionController findInteractionController, C0644p c0644p) {
        super(c0644p);
        this.findInteractionController = findInteractionController;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.findInteractionController = null;
    }

    public void onFindResultReceived(int i4, int i5, boolean z) {
        FindInteractionController findInteractionController;
        C0644p channel = getChannel();
        if (channel == null) {
            return;
        }
        if (z && (findInteractionController = this.findInteractionController) != null && findInteractionController.webView != null) {
            findInteractionController.activeFindSession = new FindSession(i5, i4);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("activeMatchOrdinal", Integer.valueOf(i4));
        hashMap.put("numberOfMatches", Integer.valueOf(i5));
        hashMap.put("isDoneCounting", Boolean.valueOf(z));
        channel.a("onFindResultReceived", hashMap, null);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        FindSession findSession;
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1008221461:
                if (str.equals("getSearchText")) {
                    c4 = 0;
                    break;
                }
                break;
            case -853211864:
                if (str.equals("findAll")) {
                    c4 = 1;
                    break;
                }
                break;
            case -679382964:
                if (str.equals("findNext")) {
                    c4 = 2;
                    break;
                }
                break;
            case -234090249:
                if (str.equals("setSearchText")) {
                    c4 = 3;
                    break;
                }
                break;
            case 817048102:
                if (str.equals("clearMatches")) {
                    c4 = 4;
                    break;
                }
                break;
            case 2137531137:
                if (str.equals("getActiveFindSession")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                FindInteractionController findInteractionController = this.findInteractionController;
                if (findInteractionController != null) {
                    interfaceC0643o.success(findInteractionController.searchText);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 1:
                if (this.findInteractionController != null) {
                    this.findInteractionController.findAll((String) c0641m.a("find"));
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 2:
                if (this.findInteractionController != null) {
                    this.findInteractionController.findNext(((Boolean) c0641m.a("forward")).booleanValue());
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 3:
                FindInteractionController findInteractionController2 = this.findInteractionController;
                if (findInteractionController2 != null) {
                    findInteractionController2.searchText = (String) c0641m.a("searchText");
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 4:
                FindInteractionController findInteractionController3 = this.findInteractionController;
                if (findInteractionController3 != null) {
                    findInteractionController3.clearMatches();
                }
                interfaceC0643o.success(Boolean.TRUE);
                return;
            case 5:
                FindInteractionController findInteractionController4 = this.findInteractionController;
                if (findInteractionController4 != null && (findSession = findInteractionController4.activeFindSession) != null) {
                    interfaceC0643o.success(findSession.toMap());
                    return;
                } else {
                    interfaceC0643o.success(null);
                    return;
                }
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }
}
