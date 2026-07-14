package m2;

import P1.r;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: m2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0443a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5190a = C0447e.class.getName().concat(".aot-shared-library-name");

    /* renamed from: b, reason: collision with root package name */
    public static final String f5191b = C0447e.class.getName().concat(".vm-snapshot-data");

    /* renamed from: c, reason: collision with root package name */
    public static final String f5192c = C0447e.class.getName().concat(".isolate-snapshot-data");

    /* renamed from: d, reason: collision with root package name */
    public static final String f5193d = C0447e.class.getName().concat(".flutter-assets-dir");

    public static r a(Context context) {
        String string;
        String string2;
        int i4;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            String str = null;
            if (bundle == null) {
                string = null;
            } else {
                string = bundle.getString(f5190a, null);
            }
            Bundle bundle2 = applicationInfo.metaData;
            if (bundle2 != null) {
                bundle2.getString(f5191b, null);
            }
            Bundle bundle3 = applicationInfo.metaData;
            if (bundle3 != null) {
                bundle3.getString(f5192c, null);
            }
            Bundle bundle4 = applicationInfo.metaData;
            if (bundle4 == null) {
                string2 = null;
            } else {
                string2 = bundle4.getString(f5193d, null);
            }
            Bundle bundle5 = applicationInfo.metaData;
            boolean z = true;
            if (bundle5 != null && (i4 = bundle5.getInt("io.flutter.network-policy", 0)) > 0) {
                JSONArray jSONArray = new JSONArray();
                try {
                    XmlResourceParser xml = context.getResources().getXml(i4);
                    xml.next();
                    for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                        if (eventType == 2) {
                            if (xml.getName().equals("domain-config")) {
                                b(xml, jSONArray, false);
                            }
                        }
                    }
                    str = jSONArray.toString();
                } catch (IOException | XmlPullParserException unused) {
                }
            }
            String str2 = applicationInfo.nativeLibraryDir;
            Bundle bundle6 = applicationInfo.metaData;
            if (bundle6 != null) {
                z = bundle6.getBoolean("io.flutter.automatically-register-plugins", true);
            }
            return new r(string, string2, str, str2, z);
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void b(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", z);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    boolean attributeBooleanValue2 = xmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
                    xmlResourceParser.next();
                    if (xmlResourceParser.getEventType() == 4) {
                        String trim = xmlResourceParser.getText().trim();
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(trim);
                        jSONArray2.put(attributeBooleanValue2);
                        jSONArray2.put(attributeBooleanValue);
                        jSONArray.put(jSONArray2);
                        xmlResourceParser.next();
                        if (xmlResourceParser.getEventType() != 3) {
                            throw new IllegalStateException("Expected end of domain tag");
                        }
                    } else {
                        throw new IllegalStateException("Expected text");
                    }
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    b(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    String name = xmlResourceParser.getName();
                    int eventType = xmlResourceParser.getEventType();
                    while (true) {
                        if (eventType != 3 || xmlResourceParser.getName() != name) {
                            eventType = xmlResourceParser.next();
                        }
                    }
                }
            } else if (next == 3) {
                return;
            }
        }
    }
}
