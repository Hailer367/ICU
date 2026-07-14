package com.pichillilorenzo.flutter_inappwebview_android.print_job;

import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.MediaSizeExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.ResolutionExt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PrintJobSettings implements ISettings<PrintJobController> {
    public static final String LOG_TAG = "PrintJobSettings";
    public Integer colorMode;
    public Integer duplexMode;
    public Boolean handledByClient = Boolean.FALSE;
    public String jobName;
    public MediaSizeExt mediaSize;
    public Integer orientation;
    public ResolutionExt resolution;

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<PrintJobController> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        hashMap.put("handledByClient", this.handledByClient);
        hashMap.put("jobName", this.jobName);
        hashMap.put("orientation", this.orientation);
        MediaSizeExt mediaSizeExt = this.mediaSize;
        Map<String, Object> map2 = null;
        if (mediaSizeExt != null) {
            map = mediaSizeExt.toMap();
        } else {
            map = null;
        }
        hashMap.put("mediaSize", map);
        hashMap.put("colorMode", this.colorMode);
        hashMap.put("duplexMode", this.duplexMode);
        ResolutionExt resolutionExt = this.resolution;
        if (resolutionExt != null) {
            map2 = resolutionExt.toMap();
        }
        hashMap.put("resolution", map2);
        return hashMap;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(PrintJobController printJobController) {
        return toMap();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0029. Please report as an issue. */
    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<PrintJobController> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                char c4 = 65535;
                switch (key.hashCode()) {
                    case -1600030548:
                        if (key.equals("resolution")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1498106493:
                        if (key.equals("duplexMode")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -1439500848:
                        if (key.equals("orientation")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case -1438096408:
                        if (key.equals("jobName")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case -244986274:
                        if (key.equals("handledByClient")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 1980724134:
                        if (key.equals("colorMode")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 2140418565:
                        if (key.equals("mediaSize")) {
                            c4 = 6;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        this.resolution = ResolutionExt.fromMap((Map) value);
                        break;
                    case 1:
                        this.duplexMode = (Integer) value;
                        break;
                    case 2:
                        this.orientation = (Integer) value;
                        break;
                    case 3:
                        this.jobName = (String) value;
                        break;
                    case 4:
                        this.handledByClient = (Boolean) value;
                        break;
                    case 5:
                        this.colorMode = (Integer) value;
                        break;
                    case 6:
                        this.mediaSize = MediaSizeExt.fromMap((Map) value);
                        break;
                }
            }
        }
        return this;
    }
}
