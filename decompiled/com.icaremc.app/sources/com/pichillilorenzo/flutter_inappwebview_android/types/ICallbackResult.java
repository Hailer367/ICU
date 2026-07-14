package com.pichillilorenzo.flutter_inappwebview_android.types;

import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public interface ICallbackResult<T> extends InterfaceC0643o {
    T decodeResult(Object obj);

    void defaultBehaviour(T t3);

    @Override // s2.InterfaceC0643o
    /* synthetic */ void error(String str, String str2, Object obj);

    boolean nonNullSuccess(T t3);

    @Override // s2.InterfaceC0643o
    /* synthetic */ void notImplemented();

    boolean nullSuccess();

    @Override // s2.InterfaceC0643o
    /* synthetic */ void success(Object obj);
}
