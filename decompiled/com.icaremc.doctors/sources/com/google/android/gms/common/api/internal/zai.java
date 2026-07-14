package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zai {
    public final int zac;

    public zai(int i2) {
        this.zac = i2;
    }

    public static /* synthetic */ Status zai(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zaaa zaaaVar, boolean z);

    public abstract void zag(zabk zabkVar);
}
