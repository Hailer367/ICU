package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.webkit.WebResourceError;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import p0.AbstractC0565d;
import p0.p;
import q0.C0595C;
import q0.t;
import q0.y;
import r2.k;

/* loaded from: classes.dex */
public class WebResourceErrorExt {
    private String description;
    private int type;

    public WebResourceErrorExt(int i4, String str) {
        this.type = i4;
        this.description = str;
    }

    public static WebResourceErrorExt fromWebResourceError(WebResourceError webResourceError) {
        return new WebResourceErrorExt(webResourceError.getErrorCode(), webResourceError.getDescription().toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebResourceErrorExt webResourceErrorExt = (WebResourceErrorExt) obj;
        if (this.type != webResourceErrorExt.type) {
            return false;
        }
        return this.description.equals(webResourceErrorExt.description);
    }

    public String getDescription() {
        return this.description;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.description.hashCode() + (this.type * 31);
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(getType()));
        hashMap.put("description", getDescription());
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WebResourceErrorExt{type=");
        sb.append(this.type);
        sb.append(", description='");
        return k.c(sb, this.description, "'}");
    }

    public static WebResourceErrorExt fromWebResourceError(p pVar) {
        int i4;
        String str;
        if (AbstractC0565d.a("WEB_RESOURCE_ERROR_GET_CODE")) {
            t tVar = (t) pVar;
            if (tVar.f5892a == null) {
                C0595C c0595c = y.f5931a;
                tVar.f5892a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) c0595c.f5856b).convertWebResourceError(Proxy.getInvocationHandler(tVar.f5893b));
            }
            i4 = tVar.f5892a.getErrorCode();
        } else {
            i4 = -1;
        }
        if (AbstractC0565d.a("WEB_RESOURCE_ERROR_GET_DESCRIPTION")) {
            t tVar2 = (t) pVar;
            if (tVar2.f5892a == null) {
                C0595C c0595c2 = y.f5931a;
                tVar2.f5892a = (WebResourceError) ((WebkitToCompatConverterBoundaryInterface) c0595c2.f5856b).convertWebResourceError(Proxy.getInvocationHandler(tVar2.f5893b));
            }
            str = tVar2.f5892a.getDescription().toString();
        } else {
            str = "";
        }
        return new WebResourceErrorExt(i4, str);
    }
}
