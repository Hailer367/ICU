package com.pichillilorenzo.flutter_inappwebview_android.types;

import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import java.util.HashMap;
import java.util.Map;
import r2.k;

/* loaded from: classes.dex */
public class URLCredential {
    private Long id;
    private String password;
    private Long protectionSpaceId;
    private String username;

    public URLCredential(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            URLCredential uRLCredential = (URLCredential) obj;
            String str = this.username;
            if (str == null ? uRLCredential.username != null : !str.equals(uRLCredential.username)) {
                return false;
            }
            String str2 = this.password;
            String str3 = uRLCredential.password;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public Long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getProtectionSpaceId() {
        return this.protectionSpaceId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i4;
        String str = this.username;
        int i5 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        String str2 = this.password;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }

    public void setId(Long l3) {
        this.id = l3;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProtectionSpaceId(Long l3) {
        this.protectionSpaceId = l3;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME, this.username);
        hashMap.put(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD, this.password);
        hashMap.put("certificates", null);
        hashMap.put("persistence", null);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("URLCredential{username='");
        sb.append(this.username);
        sb.append("', password='");
        return k.c(sb, this.password, "'}");
    }

    public URLCredential(Long l3, String str, String str2, Long l4) {
        this.id = l3;
        this.username = str;
        this.password = str2;
        this.protectionSpaceId = l4;
    }
}
