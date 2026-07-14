package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.Map;

/* loaded from: classes.dex */
public class JsPromptResponse {
    private Integer action;
    private String cancelButtonTitle;
    private String confirmButtonTitle;
    private String defaultValue;
    private boolean handledByClient;
    private String message;
    private String value;

    public JsPromptResponse(String str, String str2, String str3, String str4, boolean z, String str5, Integer num) {
        this.message = str;
        this.defaultValue = str2;
        this.confirmButtonTitle = str3;
        this.cancelButtonTitle = str4;
        this.handledByClient = z;
        this.value = str5;
        this.action = num;
    }

    public static JsPromptResponse fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JsPromptResponse((String) map.get("message"), (String) map.get("defaultValue"), (String) map.get("confirmButtonTitle"), (String) map.get("cancelButtonTitle"), ((Boolean) map.get("handledByClient")).booleanValue(), (String) map.get("value"), (Integer) map.get("action"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            JsPromptResponse jsPromptResponse = (JsPromptResponse) obj;
            if (this.handledByClient != jsPromptResponse.handledByClient) {
                return false;
            }
            String str = this.message;
            if (str == null ? jsPromptResponse.message != null : !str.equals(jsPromptResponse.message)) {
                return false;
            }
            String str2 = this.defaultValue;
            if (str2 == null ? jsPromptResponse.defaultValue != null : !str2.equals(jsPromptResponse.defaultValue)) {
                return false;
            }
            String str3 = this.confirmButtonTitle;
            if (str3 == null ? jsPromptResponse.confirmButtonTitle != null : !str3.equals(jsPromptResponse.confirmButtonTitle)) {
                return false;
            }
            String str4 = this.cancelButtonTitle;
            if (str4 == null ? jsPromptResponse.cancelButtonTitle != null : !str4.equals(jsPromptResponse.cancelButtonTitle)) {
                return false;
            }
            String str5 = this.value;
            if (str5 == null ? jsPromptResponse.value != null : !str5.equals(jsPromptResponse.value)) {
                return false;
            }
            Integer num = this.action;
            Integer num2 = jsPromptResponse.action;
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

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getMessage() {
        return this.message;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String str = this.message;
        int i9 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i10 = i4 * 31;
        String str2 = this.defaultValue;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i11 = (i10 + i5) * 31;
        String str3 = this.confirmButtonTitle;
        if (str3 != null) {
            i6 = str3.hashCode();
        } else {
            i6 = 0;
        }
        int i12 = (i11 + i6) * 31;
        String str4 = this.cancelButtonTitle;
        if (str4 != null) {
            i7 = str4.hashCode();
        } else {
            i7 = 0;
        }
        int i13 = (((i12 + i7) * 31) + (this.handledByClient ? 1 : 0)) * 31;
        String str5 = this.value;
        if (str5 != null) {
            i8 = str5.hashCode();
        } else {
            i8 = 0;
        }
        int i14 = (i13 + i8) * 31;
        Integer num = this.action;
        if (num != null) {
            i9 = num.hashCode();
        }
        return i14 + i9;
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

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setHandledByClient(boolean z) {
        this.handledByClient = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "JsPromptResponse{message='" + this.message + "', defaultValue='" + this.defaultValue + "', confirmButtonTitle='" + this.confirmButtonTitle + "', cancelButtonTitle='" + this.cancelButtonTitle + "', handledByClient=" + this.handledByClient + ", value='" + this.value + "', action=" + this.action + '}';
    }
}
