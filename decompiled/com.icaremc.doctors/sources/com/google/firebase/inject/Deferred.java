package com.google.firebase.inject;

import com.google.firebase.annotations.DeferredApi;

/* loaded from: classes.dex */
public interface Deferred<T> {

    /* loaded from: classes.dex */
    public interface DeferredHandler<T> {
        @DeferredApi
        void handle(Provider<T> provider);
    }

    void whenAvailable(DeferredHandler<T> deferredHandler);
}
