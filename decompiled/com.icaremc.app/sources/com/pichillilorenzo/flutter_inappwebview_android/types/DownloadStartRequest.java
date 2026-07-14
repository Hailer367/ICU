package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.HashMap;
import java.util.Map;
import r2.k;

/* loaded from: classes.dex */
public class DownloadStartRequest {
    private String contentDisposition;
    private long contentLength;
    private String mimeType;
    private String suggestedFilename;
    private String textEncodingName;
    private String url;
    private String userAgent;

    public DownloadStartRequest(String str, String str2, String str3, String str4, long j4, String str5, String str6) {
        this.url = str;
        this.userAgent = str2;
        this.contentDisposition = str3;
        this.mimeType = str4;
        this.contentLength = j4;
        this.suggestedFilename = str5;
        this.textEncodingName = str6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DownloadStartRequest downloadStartRequest = (DownloadStartRequest) obj;
            if (this.contentLength != downloadStartRequest.contentLength || !this.url.equals(downloadStartRequest.url) || !this.userAgent.equals(downloadStartRequest.userAgent) || !this.contentDisposition.equals(downloadStartRequest.contentDisposition) || !this.mimeType.equals(downloadStartRequest.mimeType)) {
                return false;
            }
            String str = this.suggestedFilename;
            if (str == null ? downloadStartRequest.suggestedFilename != null : !str.equals(downloadStartRequest.suggestedFilename)) {
                return false;
            }
            String str2 = this.textEncodingName;
            String str3 = downloadStartRequest.textEncodingName;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSuggestedFilename() {
        return this.suggestedFilename;
    }

    public String getTextEncodingName() {
        return this.textEncodingName;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        int i4;
        int hashCode = (this.mimeType.hashCode() + ((this.contentDisposition.hashCode() + ((this.userAgent.hashCode() + (this.url.hashCode() * 31)) * 31)) * 31)) * 31;
        long j4 = this.contentLength;
        int i5 = (hashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        String str = this.suggestedFilename;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = (i5 + i4) * 31;
        String str2 = this.textEncodingName;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return i7 + i6;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public void setContentLength(long j4) {
        this.contentLength = j4;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSuggestedFilename(String str) {
        this.suggestedFilename = str;
    }

    public void setTextEncodingName(String str) {
        this.textEncodingName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.url);
        hashMap.put("userAgent", this.userAgent);
        hashMap.put("contentDisposition", this.contentDisposition);
        hashMap.put("mimeType", this.mimeType);
        hashMap.put("contentLength", Long.valueOf(this.contentLength));
        hashMap.put("suggestedFilename", this.suggestedFilename);
        hashMap.put("textEncodingName", this.textEncodingName);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadStartRequest{url='");
        sb.append(this.url);
        sb.append("', userAgent='");
        sb.append(this.userAgent);
        sb.append("', contentDisposition='");
        sb.append(this.contentDisposition);
        sb.append("', mimeType='");
        sb.append(this.mimeType);
        sb.append("', contentLength=");
        sb.append(this.contentLength);
        sb.append(", suggestedFilename='");
        sb.append(this.suggestedFilename);
        sb.append("', textEncodingName='");
        return k.c(sb, this.textEncodingName, "'}");
    }
}
