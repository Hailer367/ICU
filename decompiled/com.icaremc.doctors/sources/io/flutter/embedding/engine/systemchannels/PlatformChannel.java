package io.flutter.embedding.engine.systemchannels;

import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    public final MethodChannel channel;
    final MethodChannel.MethodCallHandler parsingMethodCallHandler;
    private PlatformMessageHandler platformMessageHandler;

    /* loaded from: classes.dex */
    public static class AppSwitcherDescription {
        public final int color;
        public final String label;

        public AppSwitcherDescription(int i2, String str) {
            this.color = i2;
            this.label = str;
        }
    }

    /* loaded from: classes.dex */
    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");

        private String encodedName;

        Brightness(String str) {
            this.encodedName = str;
        }

        public static Brightness fromValue(String str) {
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such Brightness: ", str));
        }
    }

    /* loaded from: classes.dex */
    public enum ClipboardContentFormat {
        PLAIN_TEXT("text/plain");

        private String encodedName;

        ClipboardContentFormat(String str) {
            this.encodedName = str;
        }

        public static ClipboardContentFormat fromValue(String str) {
            for (ClipboardContentFormat clipboardContentFormat : values()) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such ClipboardContentFormat: ", str));
        }
    }

    /* loaded from: classes.dex */
    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");

        private String encodedName;

        DeviceOrientation(String str) {
            this.encodedName = str;
        }

        public static DeviceOrientation fromValue(String str) {
            for (DeviceOrientation deviceOrientation : values()) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such DeviceOrientation: ", str));
        }
    }

    /* loaded from: classes.dex */
    public enum HapticFeedbackType {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick"),
        SUCCESS_NOTIFICATION("HapticFeedbackType.successNotification"),
        WARNING_NOTIFICATION("HapticFeedbackType.warningNotification"),
        ERROR_NOTIFICATION("HapticFeedbackType.errorNotification");

        private final String encodedName;

        HapticFeedbackType(String str) {
            this.encodedName = str;
        }

        public static HapticFeedbackType fromValue(String str) {
            for (HapticFeedbackType hapticFeedbackType : values()) {
                String str2 = hapticFeedbackType.encodedName;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such HapticFeedbackType: ", str));
        }
    }

    /* loaded from: classes.dex */
    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        CharSequence getClipboardData(ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(String str);

        default void setFrameworkHandlesBack(boolean z) {
        }

        void setPreferredOrientations(int i2);

        void setSystemUiChangeListener();

        void setSystemUiOverlayStyle(SystemChromeStyle systemChromeStyle);

        void share(String str);

        void showSystemOverlays(List<SystemUiOverlay> list);

        void showSystemUiMode(SystemUiMode systemUiMode);

        void vibrateHapticFeedback(HapticFeedbackType hapticFeedbackType);
    }

    /* loaded from: classes.dex */
    public enum SoundType {
        CLICK("SystemSoundType.click"),
        TICK("SystemSoundType.tick"),
        ALERT("SystemSoundType.alert");

        private final String encodedName;

        SoundType(String str) {
            this.encodedName = str;
        }

        public static SoundType fromValue(String str) {
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such SoundType: ", str));
        }
    }

    /* loaded from: classes.dex */
    public static class SystemChromeStyle {
        public final Integer statusBarColor;
        public final Brightness statusBarIconBrightness;
        public final Integer systemNavigationBarColor;
        public final Boolean systemNavigationBarContrastEnforced;
        public final Integer systemNavigationBarDividerColor;
        public final Brightness systemNavigationBarIconBrightness;
        public final Boolean systemStatusBarContrastEnforced;

        public SystemChromeStyle(Integer num, Brightness brightness, Boolean bool, Integer num2, Brightness brightness2, Integer num3, Boolean bool2) {
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemStatusBarContrastEnforced = bool;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
            this.systemNavigationBarContrastEnforced = bool2;
        }
    }

    /* loaded from: classes.dex */
    public enum SystemUiMode {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");

        private String encodedName;

        SystemUiMode(String str) {
            this.encodedName = str;
        }

        public static SystemUiMode fromValue(String str) {
            for (SystemUiMode systemUiMode : values()) {
                if (systemUiMode.encodedName.equals(str)) {
                    return systemUiMode;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such SystemUiMode: ", str));
        }
    }

    /* loaded from: classes.dex */
    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");

        private String encodedName;

        SystemUiOverlay(String str) {
            this.encodedName = str;
        }

        public static SystemUiOverlay fromValue(String str) {
            for (SystemUiOverlay systemUiOverlay : values()) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such SystemUiOverlay: ", str));
        }
    }

    public PlatformChannel(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformChannel.1
            /* JADX WARN: Removed duplicated region for block: B:25:0x013e A[Catch: JSONException -> 0x003f, TryCatch #8 {JSONException -> 0x003f, blocks: (B:5:0x002b, B:6:0x002f, B:11:0x00df, B:14:0x00e4, B:16:0x00f4, B:18:0x010d, B:20:0x0121, B:30:0x0125, B:23:0x0132, B:25:0x013e, B:27:0x014b, B:32:0x012a, B:33:0x0150, B:35:0x015e, B:37:0x0194, B:39:0x01a2, B:49:0x0233, B:42:0x024f, B:81:0x018b, B:88:0x01c9, B:74:0x01eb, B:60:0x020b, B:67:0x022b, B:53:0x0247, B:46:0x0263, B:90:0x0034, B:93:0x0042, B:96:0x004d, B:99:0x0059, B:102:0x0065, B:105:0x0070, B:108:0x007b, B:111:0x0085, B:114:0x008f, B:117:0x0099, B:120:0x00a3, B:123:0x00ad, B:126:0x00b8, B:129:0x00c3, B:132:0x00ce, B:56:0x01f4), top: B:4:0x002b, inners: #0, #5, #6, #10 }] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x014b A[Catch: JSONException -> 0x003f, TryCatch #8 {JSONException -> 0x003f, blocks: (B:5:0x002b, B:6:0x002f, B:11:0x00df, B:14:0x00e4, B:16:0x00f4, B:18:0x010d, B:20:0x0121, B:30:0x0125, B:23:0x0132, B:25:0x013e, B:27:0x014b, B:32:0x012a, B:33:0x0150, B:35:0x015e, B:37:0x0194, B:39:0x01a2, B:49:0x0233, B:42:0x024f, B:81:0x018b, B:88:0x01c9, B:74:0x01eb, B:60:0x020b, B:67:0x022b, B:53:0x0247, B:46:0x0263, B:90:0x0034, B:93:0x0042, B:96:0x004d, B:99:0x0059, B:102:0x0065, B:105:0x0070, B:108:0x007b, B:111:0x0085, B:114:0x008f, B:117:0x0099, B:120:0x00a3, B:123:0x00ad, B:126:0x00b8, B:129:0x00c3, B:132:0x00ce, B:56:0x01f4), top: B:4:0x002b, inners: #0, #5, #6, #10 }] */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onMethodCall(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
                /*
                    Method dump skipped, instructions count: 738
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.parsingMethodCallHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppSwitcherDescription decodeAppSwitcherDescription(JSONObject jSONObject) {
        int i2 = jSONObject.getInt("primaryColor");
        if (i2 != 0) {
            i2 |= -16777216;
        }
        return new AppSwitcherDescription(i2, jSONObject.getString(Constants.ScionAnalytics.PARAM_LABEL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0039. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int decodeOrientations(org.json.JSONArray r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r8.length()
            r5 = 2
            r6 = 1
            if (r1 >= r4) goto L33
            java.lang.String r4 = r8.getString(r1)
            io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.fromValue(r4)
            int r4 = r4.ordinal()
            if (r4 == 0) goto L2b
            if (r4 == r6) goto L28
            if (r4 == r5) goto L25
            r5 = 3
            if (r4 == r5) goto L22
            goto L2d
        L22:
            r2 = r2 | 8
            goto L2d
        L25:
            r2 = r2 | 2
            goto L2d
        L28:
            r2 = r2 | 4
            goto L2d
        L2b:
            r2 = r2 | 1
        L2d:
            if (r3 != 0) goto L30
            r3 = r2
        L30:
            int r1 = r1 + 1
            goto L4
        L33:
            if (r2 == 0) goto L53
            r8 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L52;
                case 3: goto L48;
                case 4: goto L47;
                case 5: goto L45;
                case 6: goto L48;
                case 7: goto L48;
                case 8: goto L44;
                case 9: goto L48;
                case 10: goto L41;
                case 11: goto L40;
                case 12: goto L48;
                case 13: goto L48;
                case 14: goto L48;
                case 15: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L4f
        L3d:
            r8 = 13
            return r8
        L40:
            return r5
        L41:
            r8 = 11
            return r8
        L44:
            return r1
        L45:
            r8 = 12
        L47:
            return r8
        L48:
            if (r3 == r5) goto L52
            r0 = 4
            if (r3 == r0) goto L51
            if (r3 == r1) goto L50
        L4f:
            return r6
        L50:
            return r1
        L51:
            return r8
        L52:
            return r0
        L53:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.decodeOrientations(org.json.JSONArray):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SystemChromeStyle decodeSystemChromeStyle(JSONObject jSONObject) {
        Integer num;
        Brightness brightness;
        Boolean bool;
        Integer num2;
        Brightness brightness2;
        Integer num3;
        Boolean bool2 = null;
        if (!jSONObject.isNull("statusBarColor")) {
            num = Integer.valueOf(jSONObject.getInt("statusBarColor"));
        } else {
            num = null;
        }
        if (!jSONObject.isNull("statusBarIconBrightness")) {
            brightness = Brightness.fromValue(jSONObject.getString("statusBarIconBrightness"));
        } else {
            brightness = null;
        }
        if (!jSONObject.isNull("systemStatusBarContrastEnforced")) {
            bool = Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced"));
        } else {
            bool = null;
        }
        if (!jSONObject.isNull("systemNavigationBarColor")) {
            num2 = Integer.valueOf(jSONObject.getInt("systemNavigationBarColor"));
        } else {
            num2 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarIconBrightness")) {
            brightness2 = Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness"));
        } else {
            brightness2 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarDividerColor")) {
            num3 = Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor"));
        } else {
            num3 = null;
        }
        if (!jSONObject.isNull("systemNavigationBarContrastEnforced")) {
            bool2 = Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced"));
        }
        return new SystemChromeStyle(num, brightness, bool, num2, brightness2, num3, bool2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SystemUiMode decodeSystemUiMode(String str) {
        int ordinal = SystemUiMode.fromValue(str).ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        return SystemUiMode.EDGE_TO_EDGE;
                    }
                    return SystemUiMode.EDGE_TO_EDGE;
                }
                return SystemUiMode.IMMERSIVE_STICKY;
            }
            return SystemUiMode.IMMERSIVE;
        }
        return SystemUiMode.LEAN_BACK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SystemUiOverlay> decodeSystemUiOverlays(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            int ordinal = SystemUiOverlay.fromValue(jSONArray.getString(i2)).ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
                }
            } else {
                arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
            }
        }
        return arrayList;
    }

    public void setPlatformMessageHandler(PlatformMessageHandler platformMessageHandler) {
        this.platformMessageHandler = platformMessageHandler;
    }

    public void systemChromeChanged(boolean z) {
        Log.v(TAG, "Sending 'systemUIChange' message.");
        this.channel.invokeMethod("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z)));
    }
}
