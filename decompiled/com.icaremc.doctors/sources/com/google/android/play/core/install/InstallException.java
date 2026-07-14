package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.install.model.InstallErrorCode;
import java.util.Locale;

/* loaded from: classes.dex */
public class InstallException extends ApiException {
    public InstallException(@InstallErrorCode int i2) {
        super(new Status(i2, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i2), com.google.android.play.core.install.model.zza.zza(i2))));
        if (i2 != 0) {
        } else {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }

    @InstallErrorCode
    public int getErrorCode() {
        return super.getStatusCode();
    }
}
