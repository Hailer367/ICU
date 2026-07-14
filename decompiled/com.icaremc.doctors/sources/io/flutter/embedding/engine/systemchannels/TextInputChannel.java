package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.editing.TextEditingDelta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    public final MethodChannel channel;
    final MethodChannel.MethodCallHandler parsingMethodHandler;
    private TextInputMethodHandler textInputMethodHandler;

    /* loaded from: classes.dex */
    public static class Configuration {
        public final String actionLabel;
        public final boolean autocorrect;
        public final Autofill autofill;
        public final String[] contentCommitMimeTypes;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        public final Configuration[] fields;
        public final Locale[] hintLocales;
        public final Integer inputAction;
        public final InputType inputType;
        public final boolean obscureText;
        public final TextCapitalization textCapitalization;

        /* loaded from: classes.dex */
        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(String str, String[] strArr, String str2, TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }

            public static Autofill fromJson(JSONObject jSONObject) {
                String string;
                String string2 = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                if (jSONObject.isNull("hintText")) {
                    string = null;
                } else {
                    string = jSONObject.getString("hintText");
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    strArr[i2] = translateAutofillHint(jSONArray.getString(i2));
                }
                return new Autofill(string2, strArr, string, TextEditState.fromJson(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x00a6, code lost:
            
                if (r17.equals("familyName") == false) goto L7;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String translateAutofillHint(java.lang.String r17) {
                /*
                    Method dump skipped, instructions count: 806
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill.translateAutofillHint(java.lang.String):java.lang.String");
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TextCapitalization textCapitalization, InputType inputType, Integer num, String str, Autofill autofill, String[] strArr, Configuration[] configurationArr, Locale[] localeArr) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.enableIMEPersonalizedLearning = z4;
            this.enableDeltaModel = z5;
            this.textCapitalization = textCapitalization;
            this.inputType = inputType;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill;
            this.contentCommitMimeTypes = strArr;
            this.fields = configurationArr;
            this.hintLocales = localeArr;
        }

        public static Configuration fromJson(JSONObject jSONObject) {
            Configuration[] configurationArr;
            JSONArray jSONArray;
            Locale[] localeArr;
            String string;
            String string2 = jSONObject.getString("inputAction");
            if (string2 != null) {
                Autofill autofill = null;
                if (!jSONObject.isNull("fields")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("fields");
                    int length = jSONArray2.length();
                    Configuration[] configurationArr2 = new Configuration[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        configurationArr2[i2] = fromJson(jSONArray2.getJSONObject(i2));
                    }
                    configurationArr = configurationArr2;
                } else {
                    configurationArr = null;
                }
                Integer inputActionFromTextInputAction = inputActionFromTextInputAction(string2);
                ArrayList arrayList = new ArrayList();
                if (jSONObject.isNull("contentCommitMimeTypes")) {
                    jSONArray = null;
                } else {
                    jSONArray = jSONObject.getJSONArray("contentCommitMimeTypes");
                }
                if (jSONArray != null) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        arrayList.add(jSONArray.optString(i3));
                    }
                }
                if (!jSONObject.isNull("hintLocales")) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("hintLocales");
                    Locale[] localeArr2 = new Locale[jSONArray3.length()];
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        localeArr2[i4] = Locale.forLanguageTag(jSONArray3.optString(i4));
                    }
                    localeArr = localeArr2;
                } else {
                    localeArr = null;
                }
                boolean optBoolean = jSONObject.optBoolean("obscureText");
                boolean optBoolean2 = jSONObject.optBoolean("autocorrect", true);
                boolean optBoolean3 = jSONObject.optBoolean("enableSuggestions");
                boolean optBoolean4 = jSONObject.optBoolean("enableIMEPersonalizedLearning");
                boolean optBoolean5 = jSONObject.optBoolean("enableDeltaModel");
                TextCapitalization fromValue = TextCapitalization.fromValue(jSONObject.getString("textCapitalization"));
                InputType fromJson = InputType.fromJson(jSONObject.getJSONObject("inputType"));
                if (jSONObject.isNull("actionLabel")) {
                    string = null;
                } else {
                    string = jSONObject.getString("actionLabel");
                }
                if (!jSONObject.isNull("autofill")) {
                    autofill = Autofill.fromJson(jSONObject.getJSONObject("autofill"));
                }
                return new Configuration(optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5, fromValue, fromJson, inputActionFromTextInputAction, string, autofill, (String[]) arrayList.toArray(new String[arrayList.size()]), configurationArr, localeArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007a, code lost:
        
            if (r11.equals("TextInputAction.unspecified") == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.Integer inputActionFromTextInputAction(java.lang.String r11) {
            /*
                r0 = 0
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
                r11.getClass()
                int r2 = r11.hashCode()
                r3 = 7
                r4 = 6
                r5 = 5
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 1
                r10 = -1
                switch(r2) {
                    case -810971940: goto L74;
                    case -737377923: goto L69;
                    case -737089298: goto L5e;
                    case -737080013: goto L53;
                    case -736940669: goto L48;
                    case 469250275: goto L3d;
                    case 1241689507: goto L32;
                    case 1539450297: goto L27;
                    case 2110497650: goto L1a;
                    default: goto L17;
                }
            L17:
                r0 = r10
                goto L7d
            L1a:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L23
                goto L17
            L23:
                r0 = 8
                goto L7d
            L27:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L30
                goto L17
            L30:
                r0 = r3
                goto L7d
            L32:
                java.lang.String r0 = "TextInputAction.go"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L3b
                goto L17
            L3b:
                r0 = r4
                goto L7d
            L3d:
                java.lang.String r0 = "TextInputAction.search"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L46
                goto L17
            L46:
                r0 = r5
                goto L7d
            L48:
                java.lang.String r0 = "TextInputAction.send"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L51
                goto L17
            L51:
                r0 = r6
                goto L7d
            L53:
                java.lang.String r0 = "TextInputAction.none"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L5c
                goto L17
            L5c:
                r0 = r7
                goto L7d
            L5e:
                java.lang.String r0 = "TextInputAction.next"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L67
                goto L17
            L67:
                r0 = r8
                goto L7d
            L69:
                java.lang.String r0 = "TextInputAction.done"
                boolean r11 = r11.equals(r0)
                if (r11 != 0) goto L72
                goto L17
            L72:
                r0 = r9
                goto L7d
            L74:
                java.lang.String r2 = "TextInputAction.unspecified"
                boolean r11 = r11.equals(r2)
                if (r11 != 0) goto L7d
                goto L17
            L7d:
                switch(r0) {
                    case 0: goto La4;
                    case 1: goto L9f;
                    case 2: goto L9a;
                    case 3: goto L95;
                    case 4: goto L90;
                    case 5: goto L8b;
                    case 6: goto L86;
                    case 7: goto L95;
                    case 8: goto L81;
                    default: goto L80;
                }
            L80:
                return r1
            L81:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
                return r11
            L86:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
                return r11
            L8b:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
                return r11
            L90:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
                return r11
            L95:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
                return r11
            L9a:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
                return r11
            L9f:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
                return r11
            La4:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.inputActionFromTextInputAction(java.lang.String):java.lang.Integer");
        }
    }

    /* loaded from: classes.dex */
    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        public final TextInputType type;

        public InputType(TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }

        public static InputType fromJson(JSONObject jSONObject) {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* loaded from: classes.dex */
    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");

        private final String encodedName;

        TextCapitalization(String str) {
            this.encodedName = str;
        }

        public static TextCapitalization fromValue(String str) {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such TextCapitalization: ", str));
        }
    }

    /* loaded from: classes.dex */
    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        public final String text;

        public TextEditState(String str, int i2, int i3, int i4, int i5) {
            if ((i2 == -1 && i3 == -1) || (i2 >= 0 && i3 >= 0)) {
                if ((i4 == -1 && i5 == -1) || (i4 >= 0 && i4 <= i5)) {
                    if (i5 <= str.length()) {
                        if (i2 <= str.length()) {
                            if (i3 <= str.length()) {
                                this.text = str;
                                this.selectionStart = i2;
                                this.selectionEnd = i3;
                                this.composingStart = i4;
                                this.composingEnd = i5;
                                return;
                            }
                            throw new IndexOutOfBoundsException(O.a.c(i3, "invalid selection end: "));
                        }
                        throw new IndexOutOfBoundsException(O.a.c(i2, "invalid selection start: "));
                    }
                    throw new IndexOutOfBoundsException(O.a.c(i4, "invalid composing start: "));
                }
                throw new IndexOutOfBoundsException("invalid composing range: (" + i4 + ", " + i5 + ")");
            }
            throw new IndexOutOfBoundsException("invalid selection: (" + i2 + ", " + i3 + ")");
        }

        public static TextEditState fromJson(JSONObject jSONObject) {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i2 = this.composingStart;
            if (i2 >= 0 && this.composingEnd > i2) {
                return true;
            }
            return false;
        }

        public boolean hasSelection() {
            if (this.selectionStart >= 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i2, Configuration configuration);

        void setEditableSizeAndTransform(double d2, double d3, double[] dArr);

        void setEditingState(TextEditState textEditState);

        void setPlatformViewClient(int i2, boolean z);

        void show();
    }

    /* loaded from: classes.dex */
    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none"),
        WEB_SEARCH("TextInputType.webSearch"),
        TWITTER("TextInputType.twitter");

        private final String encodedName;

        TextInputType(String str) {
            this.encodedName = str;
        }

        public static TextInputType fromValue(String str) {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException(O.a.m("No such TextInputType: ", str));
        }
    }

    public TextInputChannel(DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.TextInputChannel.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Bundle bundle;
                if (TextInputChannel.this.textInputMethodHandler != null) {
                    String str = methodCall.method;
                    Object obj = methodCall.arguments;
                    Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                    str.getClass();
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case -1779068172:
                            if (str.equals("TextInput.setPlatformViewClient")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1015421462:
                            if (str.equals("TextInput.setEditingState")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -37561188:
                            if (str.equals("TextInput.setClient")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 270476819:
                            if (str.equals("TextInput.hide")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 270803918:
                            if (str.equals("TextInput.show")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 649192816:
                            if (str.equals("TextInput.sendAppPrivateCommand")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1204752139:
                            if (str.equals("TextInput.setEditableSizeAndTransform")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 1727570905:
                            if (str.equals("TextInput.finishAutofillContext")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case 1904427655:
                            if (str.equals("TextInput.clearClient")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                        case 2113369584:
                            if (str.equals("TextInput.requestAutofill")) {
                                c2 = '\t';
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            try {
                                JSONObject jSONObject = (JSONObject) obj;
                                TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                                result.success(null);
                                return;
                            } catch (JSONException e2) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e2.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (JSONException e3) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e3.getMessage(), null);
                                return;
                            }
                        case 2:
                            try {
                                JSONArray jSONArray = (JSONArray) obj;
                                TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e4) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e4.getMessage(), null);
                                return;
                            }
                        case 3:
                            TextInputChannel.this.textInputMethodHandler.hide();
                            result.success(null);
                            return;
                        case 4:
                            TextInputChannel.this.textInputMethodHandler.show();
                            result.success(null);
                            return;
                        case 5:
                            try {
                                JSONObject jSONObject2 = (JSONObject) obj;
                                String string = jSONObject2.getString("action");
                                String string2 = jSONObject2.getString(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                                if (string2 != null && !string2.isEmpty()) {
                                    bundle = new Bundle();
                                    bundle.putString(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, string2);
                                } else {
                                    bundle = null;
                                }
                                TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                                result.success(null);
                                return;
                            } catch (JSONException e5) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e5.getMessage(), null);
                                return;
                            }
                        case 6:
                            try {
                                JSONObject jSONObject3 = (JSONObject) obj;
                                double d2 = jSONObject3.getDouble("width");
                                double d3 = jSONObject3.getDouble("height");
                                JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                                double[] dArr = new double[16];
                                for (int i2 = 0; i2 < 16; i2++) {
                                    dArr[i2] = jSONArray2.getDouble(i2);
                                }
                                TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d2, d3, dArr);
                                result.success(null);
                                return;
                            } catch (JSONException e6) {
                                result.error(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e6.getMessage(), null);
                                return;
                            }
                        case 7:
                            TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                            result.success(null);
                            return;
                        case '\b':
                            TextInputChannel.this.textInputMethodHandler.clearClient();
                            result.success(null);
                            return;
                        case '\t':
                            TextInputChannel.this.textInputMethodHandler.requestAutofill();
                            result.success(null);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    private static HashMap<Object, Object> createEditingDeltaJSON(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            TextEditingDelta textEditingDelta = arrayList.get(i2);
            i2++;
            jSONArray.put(textEditingDelta.toJSON());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> createEditingStateJSON(String str, int i2, int i3, int i4, int i5) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i2));
        hashMap.put("selectionExtent", Integer.valueOf(i3));
        hashMap.put("composingBase", Integer.valueOf(i4));
        hashMap.put("composingExtent", Integer.valueOf(i5));
        return hashMap;
    }

    public void commitContent(int i2, Map<String, Object> map) {
        Log.v(TAG, "Sending 'commitContent' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.commitContent", map));
    }

    public void done(int i2) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.done"));
    }

    public void go(int i2) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.go"));
    }

    public void newline(int i2) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.newline"));
    }

    public void next(int i2) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.next"));
    }

    public void performPrivateCommand(int i2, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, hashMap2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i2), hashMap));
    }

    public void previous(int i2) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.previous"));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    }

    public void search(int i2) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.search"));
    }

    public void send(int i2) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.send"));
    }

    public void setTextInputMethodHandler(TextInputMethodHandler textInputMethodHandler) {
        this.textInputMethodHandler = textInputMethodHandler;
    }

    public void unspecifiedAction(int i2) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.unspecified"));
    }

    public void updateEditingState(int i2, String str, int i3, int i4, int i5, int i6) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i3 + "\nSelection end: " + i4 + "\nComposing start: " + i5 + "\nComposing end: " + i6);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i2), createEditingStateJSON(str, i3, i4, i5, i6)));
    }

    public void updateEditingStateWithDeltas(int i2, ArrayList<TextEditingDelta> arrayList) {
        Log.v(TAG, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i2), createEditingDeltaJSON(arrayList)));
    }

    public void updateEditingStateWithTag(int i2, HashMap<String, TextEditState> hashMap) {
        Log.v(TAG, "Sending message to update editing state for " + hashMap.size() + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, TextEditState> entry : hashMap.entrySet()) {
            TextEditState value = entry.getValue();
            hashMap2.put(entry.getKey(), createEditingStateJSON(value.text, value.selectionStart, value.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i2), hashMap2));
    }
}
