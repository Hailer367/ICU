package io.flutter.plugins.urllauncher;

import R0.k;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class WebViewOptions {
    public static final Companion Companion = new Companion(null);
    private final boolean enableDomStorage;
    private final boolean enableJavaScript;
    private final Map<String, String> headers;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final WebViewOptions fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = pigeonVar_list.get(1);
            h.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue2 = ((Boolean) obj2).booleanValue();
            Object obj3 = pigeonVar_list.get(2);
            h.c(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            return new WebViewOptions(booleanValue, booleanValue2, (Map) obj3);
        }

        private Companion() {
        }
    }

    public WebViewOptions(boolean z, boolean z2, Map<String, String> headers) {
        h.e(headers, "headers");
        this.enableJavaScript = z;
        this.enableDomStorage = z2;
        this.headers = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewOptions copy$default(WebViewOptions webViewOptions, boolean z, boolean z2, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = webViewOptions.enableJavaScript;
        }
        if ((i2 & 2) != 0) {
            z2 = webViewOptions.enableDomStorage;
        }
        if ((i2 & 4) != 0) {
            map = webViewOptions.headers;
        }
        return webViewOptions.copy(z, z2, map);
    }

    public final boolean component1() {
        return this.enableJavaScript;
    }

    public final boolean component2() {
        return this.enableDomStorage;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final WebViewOptions copy(boolean z, boolean z2, Map<String, String> headers) {
        h.e(headers, "headers");
        return new WebViewOptions(z, z2, headers);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(WebViewOptions.class)) {
            if (this == obj) {
                return true;
            }
            WebViewOptions webViewOptions = (WebViewOptions) obj;
            MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
            if (messagesPigeonUtils.deepEquals(Boolean.valueOf(this.enableJavaScript), Boolean.valueOf(webViewOptions.enableJavaScript)) && messagesPigeonUtils.deepEquals(Boolean.valueOf(this.enableDomStorage), Boolean.valueOf(webViewOptions.enableDomStorage)) && messagesPigeonUtils.deepEquals(this.headers, webViewOptions.headers)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getEnableDomStorage() {
        return this.enableDomStorage;
    }

    public final boolean getEnableJavaScript() {
        return this.enableJavaScript;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        int hashCode = WebViewOptions.class.hashCode() * 31;
        MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
        return ((((hashCode + messagesPigeonUtils.deepHash(Boolean.valueOf(this.enableJavaScript))) * 31) + messagesPigeonUtils.deepHash(Boolean.valueOf(this.enableDomStorage))) * 31) + messagesPigeonUtils.deepHash(this.headers);
    }

    public final List<Object> toList() {
        return k.N(Boolean.valueOf(this.enableJavaScript), Boolean.valueOf(this.enableDomStorage), this.headers);
    }

    public String toString() {
        return "WebViewOptions(enableJavaScript=" + this.enableJavaScript + ", enableDomStorage=" + this.enableDomStorage + ", headers=" + this.headers + ")";
    }
}
