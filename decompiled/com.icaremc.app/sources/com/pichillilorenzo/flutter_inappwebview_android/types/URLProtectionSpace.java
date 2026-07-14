package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class URLProtectionSpace {
    private String host;
    private Long id;
    private int port;
    private String protocol;
    private String realm;
    private SslCertificate sslCertificate;
    private SslError sslError;

    public URLProtectionSpace(String str, String str2, String str3, int i4, SslCertificate sslCertificate, SslError sslError) {
        this.host = str;
        this.protocol = str2;
        this.realm = str3;
        this.port = i4;
        this.sslCertificate = sslCertificate;
        this.sslError = sslError;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            URLProtectionSpace uRLProtectionSpace = (URLProtectionSpace) obj;
            if (this.port != uRLProtectionSpace.port || !this.host.equals(uRLProtectionSpace.host) || !this.protocol.equals(uRLProtectionSpace.protocol)) {
                return false;
            }
            String str = this.realm;
            if (str == null ? uRLProtectionSpace.realm != null : !str.equals(uRLProtectionSpace.realm)) {
                return false;
            }
            SslCertificate sslCertificate = this.sslCertificate;
            if (sslCertificate == null ? uRLProtectionSpace.sslCertificate != null : !sslCertificate.equals(uRLProtectionSpace.sslCertificate)) {
                return false;
            }
            SslError sslError = this.sslError;
            SslError sslError2 = uRLProtectionSpace.sslError;
            if (sslError != null) {
                return sslError.equals(sslError2);
            }
            if (sslError2 == null) {
                return true;
            }
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public Long getId() {
        return this.id;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRealm() {
        return this.realm;
    }

    public SslCertificate getSslCertificate() {
        return this.sslCertificate;
    }

    public SslError getSslError() {
        return this.sslError;
    }

    public int hashCode() {
        int i4;
        int i5;
        int hashCode = (this.protocol.hashCode() + (this.host.hashCode() * 31)) * 31;
        String str = this.realm;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = (((hashCode + i4) * 31) + this.port) * 31;
        SslCertificate sslCertificate = this.sslCertificate;
        if (sslCertificate != null) {
            i5 = sslCertificate.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        SslError sslError = this.sslError;
        if (sslError != null) {
            i6 = sslError.hashCode();
        }
        return i8 + i6;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(Long l3) {
        this.id = l3;
    }

    public void setPort(int i4) {
        this.port = i4;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setRealm(String str) {
        this.realm = str;
    }

    public void setSslCertificate(SslCertificate sslCertificate) {
        this.sslCertificate = sslCertificate;
    }

    public void setSslError(SslError sslError) {
        this.sslError = sslError;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, this.host);
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL, this.protocol);
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, this.realm);
        hashMap.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT, Integer.valueOf(this.port));
        hashMap.put("sslCertificate", SslCertificateExt.toMap(this.sslCertificate));
        hashMap.put("sslError", SslErrorExt.toMap(this.sslError));
        hashMap.put("authenticationMethod", null);
        hashMap.put("distinguishedNames", null);
        hashMap.put("receivesCredentialSecurely", null);
        hashMap.put("isProxy", null);
        hashMap.put("proxyType", null);
        return hashMap;
    }

    public String toString() {
        return "URLProtectionSpace{host='" + this.host + "', protocol='" + this.protocol + "', realm='" + this.realm + "', port=" + this.port + ", sslCertificate=" + this.sslCertificate + ", sslError=" + this.sslError + '}';
    }

    public URLProtectionSpace(Long l3, String str, String str2, String str3, int i4) {
        this.id = l3;
        this.host = str;
        this.protocol = str2;
        this.realm = str3;
        this.port = i4;
    }
}
