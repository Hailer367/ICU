package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.Map;

/* loaded from: classes.dex */
public class JsConfirmResponse {
    private Integer action;
    private String cancelButtonTitle;
    private String confirmButtonTitle;
    private boolean handledByClient;
    private String message;

    public JsConfirmResponse(String str, String str2, String str3, boolean z, Integer num) {
        this.message = str;
        this.confirmButtonTitle = str2;
        this.cancelButtonTitle = str3;
        this.handledByClient = z;
        this.action = num;
    }

    public static JsConfirmResponse fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JsConfirmResponse((String) map.get("message"), (String) map.get("confirmButtonTitle"), (String) map.get("cancelButtonTitle"), ((Boolean) map.get("handledByClient")).booleanValue(), (Integer) map.get("action"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            JsConfirmResponse jsConfirmResponse = (JsConfirmResponse) obj;
            if (this.handledByClient != jsConfirmResponse.handledByClient) {
                return false;
            }
            String str = this.message;
            if (str == null ? jsConfirmResponse.message != null : !str.equals(jsConfirmResponse.message)) {
                return false;
            }
            String str2 = this.confirmButtonTitle;
            if (str2 == null ? jsConfirmResponse.confirmButtonTitle != null : !str2.equals(jsConfirmResponse.confirmButtonTitle)) {
                return false;
            }
            String str3 = this.cancelButtonTitle;
            if (str3 == null ? jsConfirmResponse.cancelButtonTitle != null : !str3.equals(jsConfirmResponse.cancelButtonTitle)) {
                return false;
            }
            Integer num = this.action;
            Integer num2 = jsConfirmResponse.action;
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

    public String getCancelButtonTitle() {
        return this.cancelButtonTitle;
    }

    public String getConfirmButtonTitle() {
        return this.confirmButtonTitle;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        String str = this.message;
        int i7 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = i4 * 31;
        String str2 = this.confirmButtonTitle;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (i8 + i5) * 31;
        String str3 = this.cancelButtonTitle;
        if (str3 != null) {
            i6 = str3.hashCode();
        } else {
            i6 = 0;
        }
        int i10 = (((i9 + i6) * 31) + (this.handledByClient ? 1 : 0)) * 31;
        Integer num = this.action;
        if (num != null) {
            i7 = num.hashCode();
        }
        return i10 + i7;
    }

    public boolean isHandledByClient() {
        return this.handledByClient;
    }

    public void setAction(Integer num) {
        this.action = num;
    }

    public void setCancelButtonTitle(String str) {
        this.cancelButtonTitle = str;
    }

    public void setConfirmButtonTitle(String str) {
        this.confirmButtonTitle = str;
    }

    public void setHandledByClient(boolean z) {
        this.handledByClient = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "JsConfirmResponse{message='" + this.message + "', confirmButtonTitle='" + this.confirmButtonTitle + "', cancelButtonTitle='" + this.cancelButtonTitle + "', handledByClient=" + this.handledByClient + ", action=" + this.action + '}';
    }
}
