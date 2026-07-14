package com.pichillilorenzo.flutter_inappwebview_android.print_job;

import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.PrintJobInfoExt;
import java.util.Map;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class PrintJobChannelDelegate extends ChannelDelegateImpl {
    private PrintJobController printJobController;

    public PrintJobChannelDelegate(PrintJobController printJobController, C0644p c0644p) {
        super(c0644p);
        this.printJobController = printJobController;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.printJobController = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    c4 = 0;
                    break;
                }
                break;
            case -75444956:
                if (str.equals("getInfo")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1097506319:
                if (str.equals("restart")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1671767583:
                if (str.equals("dispose")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                PrintJobController printJobController = this.printJobController;
                if (printJobController != null) {
                    printJobController.cancel();
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 1:
                PrintJobController printJobController2 = this.printJobController;
                Map<String, Object> map = null;
                if (printJobController2 != null) {
                    PrintJobInfoExt info = printJobController2.getInfo();
                    if (info != null) {
                        map = info.toMap();
                    }
                    interfaceC0643o.success(map);
                    return;
                }
                interfaceC0643o.success(null);
                return;
            case 2:
                PrintJobController printJobController3 = this.printJobController;
                if (printJobController3 != null) {
                    printJobController3.restart();
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 3:
                PrintJobController printJobController4 = this.printJobController;
                if (printJobController4 != null) {
                    printJobController4.dispose();
                    interfaceC0643o.success(Boolean.TRUE);
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
}
