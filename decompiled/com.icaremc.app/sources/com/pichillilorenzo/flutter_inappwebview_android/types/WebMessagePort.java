package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import com.pichillilorenzo.flutter_inappwebview_android.webview.InAppWebViewInterface;
import com.pichillilorenzo.flutter_inappwebview_android.webview.web_message.WebMessageChannel;
import java.util.ArrayList;
import java.util.List;
import r2.k;

/* loaded from: classes.dex */
public class WebMessagePort {
    public String name;
    public WebMessageChannel webMessageChannel;
    public boolean isClosed = false;
    public boolean isTransferred = false;
    public boolean isStarted = false;

    public WebMessagePort(String str, WebMessageChannel webMessageChannel) {
        this.name = str;
        this.webMessageChannel = webMessageChannel;
    }

    public void close(final ValueCallback<Void> valueCallback) {
        InAppWebViewInterface inAppWebViewInterface;
        if (!this.isTransferred) {
            this.isClosed = true;
            WebMessageChannel webMessageChannel = this.webMessageChannel;
            if (webMessageChannel == null || (inAppWebViewInterface = webMessageChannel.webView) == null) {
                inAppWebViewInterface = null;
            }
            if (inAppWebViewInterface != null) {
                StringBuilder sb = new StringBuilder("(function() {  var webMessageChannel = window.flutter_inappwebview._webMessageChannels['");
                sb.append(this.webMessageChannel.id);
                sb.append("'];  if (webMessageChannel != null) {      webMessageChannel.");
                inAppWebViewInterface.evaluateJavascript(k.c(sb, this.name, ".close();  }})();"), null, new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePort.3
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str) {
                        valueCallback.onReceiveValue(null);
                    }
                });
                return;
            }
            valueCallback.onReceiveValue(null);
            return;
        }
        throw new Exception("Port is already transferred");
    }

    public void dispose() {
        this.isClosed = true;
        this.webMessageChannel = null;
    }

    public void postMessage(WebMessage webMessage, final ValueCallback<Void> valueCallback) {
        InAppWebViewInterface inAppWebViewInterface;
        String str;
        if (!this.isClosed && !this.isTransferred) {
            WebMessageChannel webMessageChannel = this.webMessageChannel;
            if (webMessageChannel == null || (inAppWebViewInterface = webMessageChannel.webView) == null) {
                inAppWebViewInterface = null;
            }
            if (inAppWebViewInterface != null) {
                List<WebMessagePort> list = webMessage.ports;
                String str2 = "null";
                if (list == null) {
                    str = "null";
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (WebMessagePort webMessagePort : list) {
                        if (webMessagePort != this) {
                            if (!webMessagePort.isStarted) {
                                if (!webMessagePort.isClosed && !webMessagePort.isTransferred) {
                                    webMessagePort.isTransferred = true;
                                    arrayList.add("window.flutter_inappwebview._webMessageChannels['" + this.webMessageChannel.id + "']." + webMessagePort.name);
                                } else {
                                    throw new Exception("Port is already closed or transferred");
                                }
                            } else {
                                throw new Exception("Port is already started");
                            }
                        } else {
                            throw new Exception("Source port cannot be transferred");
                        }
                    }
                    str = "[" + TextUtils.join(", ", arrayList) + "]";
                }
                String str3 = webMessage.data;
                if (str3 != null) {
                    str2 = Util.replaceAll(str3, "'", "\\'");
                }
                StringBuilder sb = new StringBuilder("(function() {  var webMessageChannel = window.flutter_inappwebview._webMessageChannels['");
                sb.append(this.webMessageChannel.id);
                sb.append("'];  if (webMessageChannel != null) {      webMessageChannel.");
                sb.append(this.name);
                sb.append(".postMessage('");
                sb.append(str2);
                sb.append("', ");
                inAppWebViewInterface.evaluateJavascript(k.c(sb, str, ");  }})();"), null, new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePort.2
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str4) {
                        valueCallback.onReceiveValue(null);
                    }
                });
            } else {
                valueCallback.onReceiveValue(null);
            }
            webMessage.dispose();
            return;
        }
        throw new Exception("Port is already closed or transferred");
    }

    public void setWebMessageCallback(final ValueCallback<Void> valueCallback) {
        InAppWebViewInterface inAppWebViewInterface;
        if (!this.isClosed && !this.isTransferred) {
            this.isStarted = true;
            WebMessageChannel webMessageChannel = this.webMessageChannel;
            if (webMessageChannel == null || (inAppWebViewInterface = webMessageChannel.webView) == null) {
                inAppWebViewInterface = null;
            }
            if (inAppWebViewInterface != null) {
                inAppWebViewInterface.evaluateJavascript("(function() {  var webMessageChannel = window.flutter_inappwebview._webMessageChannels['" + this.webMessageChannel.id + "'];  if (webMessageChannel != null) {      webMessageChannel." + this.name + ".onmessage = function (event) {          window.flutter_inappwebview.callHandler('onWebMessagePortMessageReceived', {              'webMessageChannelId': '" + this.webMessageChannel.id + "',              'index': " + (1 ^ (this.name.equals("port1") ? 1 : 0)) + ",              'message': event.data          });      }  }})();", null, new ValueCallback<String>() { // from class: com.pichillilorenzo.flutter_inappwebview_android.types.WebMessagePort.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str) {
                        ValueCallback valueCallback2 = valueCallback;
                        if (valueCallback2 != null) {
                            valueCallback2.onReceiveValue(null);
                        }
                    }
                });
                return;
            }
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        throw new Exception("Port is already closed or transferred");
    }
}
