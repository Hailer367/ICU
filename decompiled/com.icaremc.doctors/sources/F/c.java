package F;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SyncFence;
import android.media.Image;
import android.media.ImageReader;
import android.provider.MediaStore;
import android.view.SurfaceControl;
import java.util.List;

/* loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static /* bridge */ /* synthetic */ int a() {
        return MediaStore.getPickImagesMaxLimit();
    }

    public static /* bridge */ /* synthetic */ SyncFence e(Image image) {
        return image.getFence();
    }

    public static /* synthetic */ ImageReader.Builder f(int i2, int i3) {
        return new ImageReader.Builder(i2, i3);
    }

    public static /* bridge */ /* synthetic */ ImageReader g(ImageReader.Builder builder) {
        return builder.build();
    }

    public static /* bridge */ /* synthetic */ List n(PackageManager packageManager, Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        return packageManager.queryIntentActivities(intent, resolveInfoFlags);
    }

    public static /* synthetic */ void o() {
    }

    public static /* bridge */ /* synthetic */ void p(SyncFence syncFence) {
        syncFence.awaitForever();
    }

    public static /* bridge */ /* synthetic */ void q(ImageReader.Builder builder) {
        builder.setMaxImages(7);
    }

    public static /* bridge */ /* synthetic */ void r(SurfaceControl.Builder builder) {
        builder.setHidden(false);
    }

    public static /* bridge */ /* synthetic */ PackageManager.ResolveInfoFlags w() {
        return PackageManager.ResolveInfoFlags.of(65536L);
    }

    public static /* bridge */ /* synthetic */ void x(ImageReader.Builder builder) {
        builder.setImageFormat(34);
    }

    public static /* bridge */ /* synthetic */ void z(ImageReader.Builder builder) {
        builder.setUsage(256L);
    }
}
