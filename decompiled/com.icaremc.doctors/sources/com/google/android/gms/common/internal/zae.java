package com.google.android.gms.common.internal;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class zae {
    public final Set zaa;

    public zae(Set set) {
        Preconditions.checkNotNull(set);
        this.zaa = Collections.unmodifiableSet(set);
    }
}
