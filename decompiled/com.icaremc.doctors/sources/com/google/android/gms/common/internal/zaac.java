package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* loaded from: classes.dex */
public final class zaac extends RemoteCreator {
    private static final zaac zaa = new zaac();

    private zaac() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i2, int i3) {
        zaac zaacVar = zaa;
        try {
            zaaa zaaaVar = new zaaa(1, i2, i3, null);
            return (View) ObjectWrapper.unwrap(((zap) zaacVar.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zaaaVar));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 42 + String.valueOf(i3).length());
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof zap) {
            return (zap) queryLocalInterface;
        }
        return new zap(iBinder);
    }
}
