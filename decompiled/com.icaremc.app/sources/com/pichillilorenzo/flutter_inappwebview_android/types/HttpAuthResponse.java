package com.pichillilorenzo.flutter_inappwebview_android.types;

import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpAuthResponse {
    private Integer action;
    private String password;
    boolean permanentPersistence;
    private String username;

    public HttpAuthResponse(String str, String str2, boolean z, Integer num) {
        this.username = str;
        this.password = str2;
        this.permanentPersistence = z;
        this.action = num;
    }

    public static HttpAuthResponse fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new HttpAuthResponse((String) map.get(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME), (String) map.get(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD), ((Boolean) map.get("permanentPersistence")).booleanValue(), (Integer) map.get("action"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            HttpAuthResponse httpAuthResponse = (HttpAuthResponse) obj;
            if (this.permanentPersistence != httpAuthResponse.permanentPersistence || !this.username.equals(httpAuthResponse.username) || !this.password.equals(httpAuthResponse.password)) {
                return false;
            }
            Integer num = this.action;
            Integer num2 = httpAuthResponse.action;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public Integer getAction() {
        return this.action;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((this.password.hashCode() + (this.username.hashCode() * 31)) * 31) + (this.permanentPersistence ? 1 : 0)) * 31;
        Integer num = this.action;
        if (num != null) {
            i4 = num.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    public boolean isPermanentPersistence() {
        return this.permanentPersistence;
    }

    public void setAction(Integer num) {
        this.action = num;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPermanentPersistence(boolean z) {
        this.permanentPersistence = z;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return "HttpAuthResponse{username='" + this.username + "', password='" + this.password + "', permanentPersistence=" + this.permanentPersistence + ", action=" + this.action + '}';
    }
}
