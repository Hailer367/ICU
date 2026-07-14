package com.pichillilorenzo.flutter_inappwebview_android.types;

/* loaded from: classes.dex */
public class BaseCallbackResultImpl<T> implements ICallbackResult<T> {
    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public T decodeResult(Object obj) {
        return null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public void defaultBehaviour(T t3) {
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, s2.InterfaceC0643o
    public void error(String str, String str2, Object obj) {
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public boolean nonNullSuccess(T t3) {
        return true;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, s2.InterfaceC0643o
    public void notImplemented() {
        defaultBehaviour(null);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult
    public boolean nullSuccess() {
        return true;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ICallbackResult, s2.InterfaceC0643o
    public void success(Object obj) {
        boolean nonNullSuccess;
        T decodeResult = decodeResult(obj);
        if (decodeResult == null) {
            nonNullSuccess = nullSuccess();
        } else {
            nonNullSuccess = nonNullSuccess(decodeResult);
        }
        if (nonNullSuccess) {
            defaultBehaviour(decodeResult);
        }
    }
}
