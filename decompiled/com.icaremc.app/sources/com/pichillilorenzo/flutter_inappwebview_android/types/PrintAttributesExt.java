package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.print.PrintAttributes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PrintAttributesExt {
    private int colorMode;
    private Integer duplex;
    private MarginsExt margins;
    private MediaSizeExt mediaSize;
    private Integer orientation;
    private ResolutionExt resolution;

    public static PrintAttributesExt fromPrintAttributes(PrintAttributes printAttributes) {
        if (printAttributes == null) {
            return null;
        }
        PrintAttributesExt printAttributesExt = new PrintAttributesExt();
        printAttributesExt.colorMode = printAttributes.getColorMode();
        printAttributesExt.duplex = Integer.valueOf(printAttributes.getDuplexMode());
        PrintAttributes.MediaSize mediaSize = printAttributes.getMediaSize();
        if (mediaSize != null) {
            printAttributesExt.mediaSize = MediaSizeExt.fromMediaSize(mediaSize);
            printAttributesExt.orientation = Integer.valueOf(!mediaSize.isPortrait() ? 1 : 0);
        }
        printAttributesExt.resolution = ResolutionExt.fromResolution(printAttributes.getResolution());
        printAttributesExt.margins = MarginsExt.fromMargins(printAttributes.getMinMargins());
        return printAttributesExt;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map;
        Map<String, Object> map2;
        HashMap hashMap = new HashMap();
        hashMap.put("colorMode", Integer.valueOf(this.colorMode));
        hashMap.put("duplex", this.duplex);
        hashMap.put("orientation", this.orientation);
        MediaSizeExt mediaSizeExt = this.mediaSize;
        Map<String, Object> map3 = null;
        if (mediaSizeExt != null) {
            map = mediaSizeExt.toMap();
        } else {
            map = null;
        }
        hashMap.put("mediaSize", map);
        ResolutionExt resolutionExt = this.resolution;
        if (resolutionExt != null) {
            map2 = resolutionExt.toMap();
        } else {
            map2 = null;
        }
        hashMap.put("resolution", map2);
        MarginsExt marginsExt = this.margins;
        if (marginsExt != null) {
            map3 = marginsExt.toMap();
        }
        hashMap.put("margins", map3);
        return hashMap;
    }
}
