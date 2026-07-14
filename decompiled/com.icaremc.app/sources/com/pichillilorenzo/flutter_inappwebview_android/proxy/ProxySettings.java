package com.pichillilorenzo.flutter_inappwebview_android.proxy;

import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.ProxyRuleExt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p0.AbstractC0564c;

/* loaded from: classes.dex */
public class ProxySettings implements ISettings<AbstractC0564c> {
    List<String> bypassRules = new ArrayList();
    List<String> directs = new ArrayList();
    List<ProxyRuleExt> proxyRules = new ArrayList();
    Boolean bypassSimpleHostnames = null;
    Boolean removeImplicitRules = null;
    Boolean reverseBypassEnabled = Boolean.FALSE;

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<AbstractC0564c> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        ArrayList arrayList = new ArrayList();
        Iterator<ProxyRuleExt> it = this.proxyRules.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toMap());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bypassRules", this.bypassRules);
        hashMap.put("directs", this.directs);
        hashMap.put("proxyRules", arrayList);
        hashMap.put("bypassSimpleHostnames", this.bypassSimpleHostnames);
        hashMap.put("removeImplicitRules", this.removeImplicitRules);
        hashMap.put("reverseBypassEnabled", this.reverseBypassEnabled);
        return hashMap;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(AbstractC0564c abstractC0564c) {
        toMap();
        new ArrayList();
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0029. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<AbstractC0564c> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                char c4 = 65535;
                switch (key.hashCode()) {
                    case -2059288826:
                        if (key.equals("bypassSimpleHostnames")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1872895191:
                        if (key.equals("proxyRules")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -1033831049:
                        if (key.equals("reverseBypassEnabled")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case -940646418:
                        if (key.equals("removeImplicitRules")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 1021951215:
                        if (key.equals("bypassRules")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 1670504874:
                        if (key.equals("directs")) {
                            c4 = 5;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        this.bypassSimpleHostnames = (Boolean) value;
                        break;
                    case 1:
                        this.proxyRules = new ArrayList();
                        Iterator it = ((List) value).iterator();
                        while (it.hasNext()) {
                            ProxyRuleExt fromMap = ProxyRuleExt.fromMap((Map) it.next());
                            if (fromMap != null) {
                                this.proxyRules.add(fromMap);
                            }
                        }
                        break;
                    case 2:
                        this.reverseBypassEnabled = (Boolean) value;
                        break;
                    case 3:
                        this.removeImplicitRules = (Boolean) value;
                        break;
                    case 4:
                        this.bypassRules = (List) value;
                        break;
                    case 5:
                        this.directs = (List) value;
                        break;
                }
            }
        }
        return this;
    }
}
