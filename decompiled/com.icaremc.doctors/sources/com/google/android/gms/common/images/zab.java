package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zab implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final zag zab;

    public zab(ImageManager imageManager, zag zagVar) {
        Objects.requireNonNull(imageManager);
        this.zaa = imageManager;
        this.zab = zagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        HashSet hashSet;
        HashSet hashSet2;
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager imageManager = this.zaa;
        Map zah = imageManager.zah();
        zag zagVar = this.zab;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) zah.get(zagVar);
        if (imageReceiver != null) {
            imageManager.zah().remove(zagVar);
            imageReceiver.zab(zagVar);
        }
        Uri uri = zagVar.zaa.zaa;
        if (uri == null) {
            zagVar.zac(imageManager.zad(), imageManager.zag(), true);
            return;
        }
        Long l2 = (Long) imageManager.zaj().get(uri);
        if (l2 != null) {
            if (SystemClock.elapsedRealtime() - l2.longValue() < 3600000) {
                zagVar.zac(imageManager.zad(), imageManager.zag(), true);
                return;
            }
            imageManager.zaj().remove(uri);
        }
        zagVar.zaa(null, false, true, false);
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) imageManager.zai().get(uri);
        if (imageReceiver2 == null) {
            imageReceiver2 = new ImageManager.ImageReceiver(imageManager, uri);
            imageManager.zai().put(uri, imageReceiver2);
        }
        imageReceiver2.zaa(zagVar);
        if (!(zagVar instanceof zaf)) {
            imageManager.zah().put(zagVar, imageReceiver2);
        }
        obj = ImageManager.zaa;
        synchronized (obj) {
            try {
                hashSet = ImageManager.zab;
                if (!hashSet.contains(uri)) {
                    hashSet2 = ImageManager.zab;
                    hashSet2.add(uri);
                    imageReceiver2.zac();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
