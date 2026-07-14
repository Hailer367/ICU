package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    public Lazy(T t2) {
        this.instance = UNINITIALIZED;
        this.instance = t2;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t2;
        T t3 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t3 == obj) {
            synchronized (this) {
                try {
                    t2 = (T) this.instance;
                    if (t2 == obj) {
                        t2 = this.provider.get();
                        this.instance = t2;
                        this.provider = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return t2;
        }
        return t3;
    }

    public boolean isInitialized() {
        if (this.instance != UNINITIALIZED) {
            return true;
        }
        return false;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
