package f;

import io.flutter.plugins.imagepicker.ImagePickerApi;
import io.flutter.plugins.imagepicker.MessagesPigeonCodec;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import io.flutter.plugins.urllauncher.UrlLauncherApi;

/* renamed from: f.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0189e implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2256c;

    public /* synthetic */ C0189e(int i2) {
        this.f2256c = i2;
    }

    @Override // c1.a
    public final Object invoke() {
        MessagesPigeonCodec codec_delegate$lambda$0;
        io.flutter.plugins.urllauncher.MessagesPigeonCodec codec_delegate$lambda$02;
        switch (this.f2256c) {
            case 0:
                return Integer.valueOf(f1.d.f2280a.a(2147418112) + 65536);
            case 1:
                codec_delegate$lambda$0 = ImagePickerApi.Companion.codec_delegate$lambda$0();
                return codec_delegate$lambda$0;
            case 2:
                return SharedPreferencesAsyncApi.Companion.k();
            default:
                codec_delegate$lambda$02 = UrlLauncherApi.Companion.codec_delegate$lambda$0();
                return codec_delegate$lambda$02;
        }
    }
}
