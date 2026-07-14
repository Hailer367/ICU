package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements ImagePickerDelegate.OnPathReadyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2444a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f2445b;

    public /* synthetic */ e(ImagePickerDelegate imagePickerDelegate, int i2) {
        this.f2444a = i2;
        this.f2445b = imagePickerDelegate;
    }

    @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.OnPathReadyListener
    public final void onPathReady(String str) {
        switch (this.f2444a) {
            case 0:
                ImagePickerDelegate.e(this.f2445b, str);
                return;
            default:
                ImagePickerDelegate.g(this.f2445b, str);
                return;
        }
    }
}
