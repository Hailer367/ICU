package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p0.AbstractC0565d;
import p0.n;

/* loaded from: classes.dex */
public class WebMessageCompatExt {
    private Object data;
    private List<WebMessagePortCompatExt> ports;
    private int type;

    public WebMessageCompatExt(Object obj, int i4, List<WebMessagePortCompatExt> list) {
        this.data = obj;
        this.type = i4;
        this.ports = list;
    }

    public static WebMessageCompatExt fromMap(Map<String, Object> map) {
        ArrayList arrayList = null;
        if (map == null) {
            return null;
        }
        Object obj = map.get("data");
        Integer num = (Integer) map.get("type");
        List list = (List) map.get("ports");
        if (list != null && !list.isEmpty()) {
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(WebMessagePortCompatExt.fromMap((Map) it.next()));
            }
        }
        return new WebMessageCompatExt(obj, num.intValue(), arrayList);
    }

    public static WebMessageCompatExt fromMapWebMessageCompat(n nVar) {
        Object obj;
        if (AbstractC0565d.a("WEB_MESSAGE_ARRAY_BUFFER") && nVar.f5809d == 1) {
            nVar.a(1);
            obj = nVar.f5808c;
            Objects.requireNonNull(obj);
        } else {
            nVar.a(0);
            obj = nVar.f5807b;
        }
        return new WebMessageCompatExt(obj, nVar.f5809d, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebMessageCompatExt webMessageCompatExt = (WebMessageCompatExt) obj;
        if (this.type != webMessageCompatExt.type || !Objects.equals(this.data, webMessageCompatExt.data)) {
            return false;
        }
        return Objects.equals(this.ports, webMessageCompatExt.ports);
    }

    public Object getData() {
        return this.data;
    }

    public List<WebMessagePortCompatExt> getPorts() {
        return this.ports;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i4;
        Object obj = this.data;
        int i5 = 0;
        if (obj != null) {
            i4 = obj.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = ((i4 * 31) + this.type) * 31;
        List<WebMessagePortCompatExt> list = this.ports;
        if (list != null) {
            i5 = list.hashCode();
        }
        return i6 + i5;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setPorts(List<WebMessagePortCompatExt> list) {
        this.ports = list;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.data);
        hashMap.put("type", Integer.valueOf(this.type));
        return hashMap;
    }

    public String toString() {
        return "WebMessageCompatExt{data=" + this.data + ", type=" + this.type + ", ports=" + this.ports + '}';
    }
}
