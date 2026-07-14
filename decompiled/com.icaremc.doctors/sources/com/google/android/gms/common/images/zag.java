package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zaj;

/* loaded from: classes.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i2) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i2;
    }

    public abstract void zaa(Drawable drawable, boolean z, boolean z2, boolean z3);

    public final void zab(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }

    public final void zac(Context context, zaj zajVar, boolean z) {
        Drawable drawable;
        int i2 = this.zab;
        if (i2 != 0) {
            drawable = context.getResources().getDrawable(i2);
        } else {
            drawable = null;
        }
        zaa(drawable, z, false, false);
    }
}
