package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class zae extends Drawable.ConstantState {
    private zae() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return zaf.zaa();
    }

    public /* synthetic */ zae(byte[] bArr) {
    }
}
