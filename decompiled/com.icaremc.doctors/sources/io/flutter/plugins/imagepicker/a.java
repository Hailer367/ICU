package io.flutter.plugins.imagepicker;

import Q0.g;
import c1.l;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.ImagePickerApi;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2433c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BasicMessageChannel.Reply f2434d;

    public /* synthetic */ a(BasicMessageChannel.Reply reply, int i2) {
        this.f2433c = i2;
        this.f2434d = reply;
    }

    @Override // c1.l
    public final Object invoke(Object obj) {
        switch (this.f2433c) {
            case 0:
                return ImagePickerApi.Companion.c(this.f2434d, (g) obj);
            case 1:
                return ImagePickerApi.Companion.f(this.f2434d, (g) obj);
            default:
                return ImagePickerApi.Companion.e(this.f2434d, (g) obj);
        }
    }
}
