package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.view.View;
import h2.AbstractActivityC0349b;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: i, reason: collision with root package name */
    public static final A f4309i = new VirtualDisplay.Callback();

    /* renamed from: a, reason: collision with root package name */
    public SingleViewPresentation f4310a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4311b;

    /* renamed from: c, reason: collision with root package name */
    public final C0377a f4312c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4313d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4314e;

    /* renamed from: f, reason: collision with root package name */
    public final i f4315f;

    /* renamed from: g, reason: collision with root package name */
    public final n f4316g;

    /* renamed from: h, reason: collision with root package name */
    public VirtualDisplay f4317h;

    public E(AbstractActivityC0349b abstractActivityC0349b, C0377a c0377a, VirtualDisplay virtualDisplay, InterfaceC0382f interfaceC0382f, i iVar, n nVar, int i4) {
        this.f4311b = abstractActivityC0349b;
        this.f4312c = c0377a;
        this.f4315f = iVar;
        this.f4316g = nVar;
        this.f4314e = i4;
        this.f4317h = virtualDisplay;
        this.f4313d = abstractActivityC0349b.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(abstractActivityC0349b, this.f4317h.getDisplay(), interfaceC0382f, c0377a, i4, nVar);
        this.f4310a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public final View a() {
        SingleViewPresentation singleViewPresentation = this.f4310a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }
}
