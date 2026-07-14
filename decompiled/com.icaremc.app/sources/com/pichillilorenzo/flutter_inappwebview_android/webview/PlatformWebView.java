package com.pichillilorenzo.flutter_inappwebview_android.webview;

import android.annotation.SuppressLint;
import android.view.View;
import io.flutter.plugin.platform.InterfaceC0382f;
import java.util.HashMap;

/* loaded from: classes.dex */
public interface PlatformWebView extends InterfaceC0382f {
    @Override // io.flutter.plugin.platform.InterfaceC0382f
    /* synthetic */ void dispose();

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    /* synthetic */ View getView();

    void makeInitialLoad(HashMap<String, Object> hashMap);

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onFlutterViewAttached(View view) {
    }

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onFlutterViewDetached() {
    }

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onInputConnectionLocked() {
    }

    @Override // io.flutter.plugin.platform.InterfaceC0382f
    @SuppressLint({"NewApi"})
    /* bridge */ /* synthetic */ default void onInputConnectionUnlocked() {
    }
}
