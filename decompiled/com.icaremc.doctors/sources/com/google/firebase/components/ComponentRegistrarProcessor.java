package com.google.firebase.components;

import java.util.List;

/* loaded from: classes.dex */
public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new Object();

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
