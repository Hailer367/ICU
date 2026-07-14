package io.flutter.plugins.urllauncher;

import C.a;
import C2.h;
import C2.i;
import C2.k;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WebViewActivity extends Activity {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f4418j = 0;

    /* renamed from: h, reason: collision with root package name */
    public WebView f4421h;

    /* renamed from: f, reason: collision with root package name */
    public final h f4419f = new h(0, this);

    /* renamed from: g, reason: collision with root package name */
    public final i f4420g = new WebViewClient();

    /* renamed from: i, reason: collision with root package name */
    public final IntentFilter f4422i = new IntentFilter("close action");

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        Map<String, String> map;
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f4421h = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("url");
        boolean booleanExtra = intent.getBooleanExtra("enableJavaScript", false);
        boolean booleanExtra2 = intent.getBooleanExtra("enableDomStorage", false);
        Bundle bundleExtra = intent.getBundleExtra("com.android.browser.headers");
        if (bundleExtra == null) {
            map = Collections.EMPTY_MAP;
        } else {
            HashMap hashMap = new HashMap();
            for (String str : bundleExtra.keySet()) {
                hashMap.put(str, bundleExtra.getString(str));
            }
            map = hashMap;
        }
        this.f4421h.loadUrl(stringExtra, map);
        this.f4421h.getSettings().setJavaScriptEnabled(booleanExtra);
        this.f4421h.getSettings().setDomStorageEnabled(booleanExtra2);
        this.f4421h.setWebViewClient(this.f4420g);
        this.f4421h.getSettings().setSupportMultipleWindows(true);
        this.f4421h.setWebChromeClient(new k(this));
        int i4 = Build.VERSION.SDK_INT;
        BroadcastReceiver broadcastReceiver = this.f4419f;
        IntentFilter intentFilter = this.f4422i;
        if (i4 >= 33) {
            a.h(this, broadcastReceiver, intentFilter);
        } else if (i4 >= 26) {
            a.g(this, broadcastReceiver, intentFilter);
        } else {
            registerReceiver(broadcastReceiver, intentFilter, null, null);
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f4419f);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4 && this.f4421h.canGoBack()) {
            this.f4421h.goBack();
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }
}
