package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PermissionResponse {
    private Integer action;
    private List<String> resources;

    public PermissionResponse(List<String> list, Integer num) {
        this.resources = list;
        this.action = num;
    }

    public static PermissionResponse fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new PermissionResponse((List) map.get("resources"), (Integer) map.get("action"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PermissionResponse permissionResponse = (PermissionResponse) obj;
            if (!this.resources.equals(permissionResponse.resources)) {
                return false;
            }
            Integer num = this.action;
            Integer num2 = permissionResponse.action;
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

    public List<String> getResources() {
        return this.resources;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.resources.hashCode() * 31;
        Integer num = this.action;
        if (num != null) {
            i4 = num.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    public void setAction(Integer num) {
        this.action = num;
    }

    public void setResources(List<String> list) {
        this.resources = list;
    }

    public String toString() {
        return "PermissionResponse{resources=" + this.resources + ", action=" + this.action + '}';
    }
}
