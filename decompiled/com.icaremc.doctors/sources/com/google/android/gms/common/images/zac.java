package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class zac implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final Bitmap zac;
    private final CountDownLatch zad;

    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        Objects.requireNonNull(imageManager);
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = bitmap;
        this.zad = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        HashSet hashSet;
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager imageManager = this.zaa;
        Map zai = imageManager.zai();
        Uri uri = this.zab;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) zai.remove(uri);
        if (imageReceiver != null) {
            ArrayList zad = imageReceiver.zad();
            int size = zad.size();
            for (int i2 = 0; i2 < size; i2++) {
                zag zagVar = (zag) zad.get(i2);
                Bitmap bitmap = this.zac;
                if (bitmap != null) {
                    zagVar.zab(imageManager.zad(), bitmap, false);
                } else {
                    imageManager.zaj().put(uri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zagVar.zac(imageManager.zad(), imageManager.zag(), false);
                }
                if (!(zagVar instanceof zaf)) {
                    imageManager.zah().remove(zagVar);
                }
            }
        }
        this.zad.countDown();
        obj = ImageManager.zaa;
        synchronized (obj) {
            hashSet = ImageManager.zab;
            hashSet.remove(uri);
        }
    }
}
