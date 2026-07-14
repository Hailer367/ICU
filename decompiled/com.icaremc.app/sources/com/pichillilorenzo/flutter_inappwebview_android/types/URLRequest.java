package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class URLRequest {
    private byte[] body;
    private Map<String, String> headers;
    private String method;
    private String url;

    public URLRequest(String str, String str2, byte[] bArr, Map<String, String> map) {
        this.url = str;
        this.method = str2;
        this.body = bArr;
        this.headers = map;
    }

    public static URLRequest fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        String str = (String) map.get("url");
        if (str == null) {
            str = "about:blank";
        }
        return new URLRequest(str, (String) map.get("method"), (byte[]) map.get("body"), (Map) map.get("headers"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            URLRequest uRLRequest = (URLRequest) obj;
            String str = this.url;
            if (str == null ? uRLRequest.url != null : !str.equals(uRLRequest.url)) {
                return false;
            }
            String str2 = this.method;
            if (str2 == null ? uRLRequest.method != null : !str2.equals(uRLRequest.method)) {
                return false;
            }
            if (!Arrays.equals(this.body, uRLRequest.body)) {
                return false;
            }
            Map<String, String> map = this.headers;
            Map<String, String> map2 = uRLRequest.headers;
            if (map != null) {
                return map.equals(map2);
            }
            if (map2 == null) {
                return true;
            }
        }
        return false;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i4;
        int i5;
        String str = this.url;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = i4 * 31;
        String str2 = this.method;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int hashCode = (Arrays.hashCode(this.body) + ((i7 + i5) * 31)) * 31;
        Map<String, String> map = this.headers;
        if (map != null) {
            i6 = map.hashCode();
        }
        return hashCode + i6;
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.url);
        hashMap.put("method", this.method);
        hashMap.put("headers", this.headers);
        hashMap.put("body", this.body);
        hashMap.put("allowsCellularAccess", null);
        hashMap.put("allowsConstrainedNetworkAccess", null);
        hashMap.put("allowsExpensiveNetworkAccess", null);
        hashMap.put("cachePolicy", null);
        hashMap.put("httpShouldHandleCookies", null);
        hashMap.put("httpShouldUsePipelining", null);
        hashMap.put("networkServiceType", null);
        hashMap.put("timeoutInterval", null);
        hashMap.put("mainDocumentURL", null);
        hashMap.put("assumesHTTP3Capable", null);
        hashMap.put("attribution", null);
        return hashMap;
    }

    public String toString() {
        return "URLRequest{url='" + this.url + "', method='" + this.method + "', body=" + Arrays.toString(this.body) + ", headers=" + this.headers + '}';
    }
}
