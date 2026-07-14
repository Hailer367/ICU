package com.google.android.play.core.ktx;

import c1.l;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
final class AppUpdatePassthroughListener implements InstallStateUpdatedListener {
    private final l disposeAction;
    private final InstallStateUpdatedListener listener;

    public AppUpdatePassthroughListener(InstallStateUpdatedListener listener, l disposeAction) {
        h.e(listener, "listener");
        h.e(disposeAction, "disposeAction");
        this.listener = listener;
        this.disposeAction = disposeAction;
    }

    public final l getDisposeAction() {
        return this.disposeAction;
    }

    public final InstallStateUpdatedListener getListener() {
        return this.listener;
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(InstallState state) {
        h.e(state, "state");
        this.listener.onStateUpdate(state);
        int installStatus = state.installStatus();
        if (installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6) {
            this.disposeAction.invoke(this);
        }
    }
}
