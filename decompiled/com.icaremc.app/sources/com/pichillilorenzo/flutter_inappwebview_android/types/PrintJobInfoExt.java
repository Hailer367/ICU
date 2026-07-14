package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.print.PrintJobInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PrintJobInfoExt {
    private PrintAttributesExt attributes;
    private int copies;
    private long creationTime;
    private String label;
    private Integer numberOfPages;
    private String printerId;
    private int state;

    public static PrintJobInfoExt fromPrintJobInfo(PrintJobInfo printJobInfo) {
        Integer num;
        String str = null;
        if (printJobInfo == null) {
            return null;
        }
        PrintJobInfoExt printJobInfoExt = new PrintJobInfoExt();
        printJobInfoExt.state = printJobInfo.getState();
        printJobInfoExt.copies = printJobInfo.getCopies();
        if (printJobInfo.getPages() != null) {
            num = Integer.valueOf(printJobInfo.getPages().length);
        } else {
            num = null;
        }
        printJobInfoExt.numberOfPages = num;
        printJobInfoExt.creationTime = printJobInfo.getCreationTime();
        printJobInfoExt.label = printJobInfo.getLabel();
        if (printJobInfo.getPrinterId() != null) {
            str = printJobInfo.getPrinterId().getLocalId();
        }
        printJobInfoExt.printerId = str;
        printJobInfoExt.attributes = PrintAttributesExt.fromPrintAttributes(printJobInfo.getAttributes());
        return printJobInfoExt;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map;
        HashMap hashMap = new HashMap();
        hashMap.put("state", Integer.valueOf(this.state));
        hashMap.put("copies", Integer.valueOf(this.copies));
        hashMap.put("numberOfPages", this.numberOfPages);
        hashMap.put("creationTime", Long.valueOf(this.creationTime));
        hashMap.put("label", this.label);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("id", this.printerId);
        hashMap.put("printer", hashMap2);
        PrintAttributesExt printAttributesExt = this.attributes;
        if (printAttributesExt != null) {
            map = printAttributesExt.toMap();
        } else {
            map = null;
        }
        hashMap.put("attributes", map);
        return hashMap;
    }
}
