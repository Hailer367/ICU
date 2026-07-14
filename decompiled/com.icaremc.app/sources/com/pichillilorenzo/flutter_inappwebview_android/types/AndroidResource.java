package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import r2.k;

/* loaded from: classes.dex */
public class AndroidResource {
    private String defPackage;
    private String defType;
    private String name;

    public AndroidResource(String str, String str2, String str3) {
        this.name = str;
        this.defType = str2;
        this.defPackage = str3;
    }

    public static AndroidResource fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new AndroidResource((String) map.get("name"), (String) map.get("defType"), (String) map.get("defPackage"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AndroidResource androidResource = (AndroidResource) obj;
            if (!this.name.equals(androidResource.name)) {
                return false;
            }
            String str = this.defType;
            if (str == null ? androidResource.defType != null : !str.equals(androidResource.defType)) {
                return false;
            }
            String str2 = this.defPackage;
            String str3 = androidResource.defPackage;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String getDefPackage() {
        return this.defPackage;
    }

    public String getDefType() {
        return this.defType;
    }

    public int getIdentifier(Context context) {
        return context.getResources().getIdentifier(this.name, this.defType, this.defPackage);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.name.hashCode() * 31;
        String str = this.defType;
        int i5 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = (hashCode + i4) * 31;
        String str2 = this.defPackage;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }

    public void setDefPackage(String str) {
        this.defPackage = str;
    }

    public void setDefType(String str) {
        this.defType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.name);
        hashMap.put("defType", this.defType);
        hashMap.put("defPackage", this.defPackage);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AndroidResource{name='");
        sb.append(this.name);
        sb.append("', type='");
        sb.append(this.defType);
        sb.append("', defPackage='");
        return k.c(sb, this.defPackage, "'}");
    }
}
