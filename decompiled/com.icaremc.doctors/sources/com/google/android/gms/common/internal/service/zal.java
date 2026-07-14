package com.google.android.gms.common.internal.service;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zal extends com.google.android.gms.internal.base.zab implements zam {
    public zal() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 == 1) {
            int readInt = parcel.readInt();
            com.google.android.gms.internal.base.zac.zad(parcel);
            zab(readInt);
            return true;
        }
        return false;
    }
}
