package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

@KeepForSdk
/* loaded from: classes.dex */
public class ListenerHolders {
    private final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l2, Looper looper, String str) {
        Preconditions.checkNotNull(l2, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l2, str);
    }

    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l2, String str) {
        Preconditions.checkNotNull(l2, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l2, str);
    }

    public final ListenerHolder zaa(Object obj, Looper looper, String str) {
        Set set = this.zaa;
        ListenerHolder createListenerHolder = createListenerHolder(obj, looper, "NO_TYPE");
        set.add(createListenerHolder);
        return createListenerHolder;
    }

    public final void zab() {
        Set set = this.zaa;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).clear();
        }
        set.clear();
    }

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l2, Executor executor, String str) {
        Preconditions.checkNotNull(l2, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l2, str);
    }
}
