package io.flutter.plugin.editing;

import E.D;
import E.J;
import E.k0;
import G.b;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.ScribeChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback;
import io.flutter.plugin.editing.ListenableEditingState;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.platform.PlatformViewsController2;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {
    private static final String TAG = "TextInputPlugin";
    private final AutofillManager afm;
    private SparseArray<TextInputChannel.Configuration> autofillConfiguration;
    private TextInputChannel.Configuration configuration;
    private ImeSyncDeferringInsetsCallback imeSyncCallback;
    private InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    private boolean isInputConnectionLocked;
    private Rect lastClientRect;
    private InputConnection lastInputConnection;
    private ListenableEditingState mEditable;
    private final InputMethodManager mImm;
    private TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
    private boolean mRestartInputPending;
    private final View mView;
    private PlatformViewsController platformViewsController;
    private PlatformViewsController2 platformViewsController2;
    private final ScribeChannel scribeChannel;
    private final TextInputChannel textInputChannel;

    /* loaded from: classes.dex */
    public static class InputTarget {
        int id;
        Type type;

        /* loaded from: classes.dex */
        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public InputTarget(Type type, int i2) {
            this.type = type;
            this.id = i2;
        }
    }

    /* loaded from: classes.dex */
    public interface MinMax {
        void inspect(double d2, double d3);
    }

    @SuppressLint({"NewApi"})
    public TextInputPlugin(View view, TextInputChannel textInputChannel, ScribeChannel scribeChannel, PlatformViewsController platformViewsController, PlatformViewsController2 platformViewsController2) {
        this.mView = view;
        this.mEditable = new ListenableEditingState(null, view);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.afm = com.dexterous.flutterlocalnotifications.a.i(view.getContext().getSystemService(a.h()));
        } else {
            this.afm = null;
        }
        if (i2 >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
            this.imeSyncCallback.setImeVisibilityListener(new ImeSyncDeferringInsetsCallback.ImeVisibilityListener() { // from class: io.flutter.plugin.editing.TextInputPlugin.1
                @Override // io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback.ImeVisibilityListener
                public void onImeVisibilityChanged(boolean z) {
                    if (!z) {
                        TextInputPlugin.this.mImm.restartInput(TextInputPlugin.this.mView);
                    }
                }
            });
        }
        this.textInputChannel = textInputChannel;
        textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() { // from class: io.flutter.plugin.editing.TextInputPlugin.2
            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void finishAutofillContext(boolean z) {
                if (Build.VERSION.SDK_INT >= 26 && TextInputPlugin.this.afm != null) {
                    if (z) {
                        TextInputPlugin.this.afm.commit();
                    } else {
                        TextInputPlugin.this.afm.cancel();
                    }
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                if (TextInputPlugin.this.inputTarget.type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                    TextInputPlugin.this.notifyViewExited();
                } else {
                    TextInputPlugin textInputPlugin = TextInputPlugin.this;
                    textInputPlugin.hideTextInput(textInputPlugin.mView);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void requestAutofill() {
                TextInputPlugin.this.notifyViewEntered();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i3, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(i3, configuration);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditableSizeAndTransform(double d2, double d3, double[] dArr) {
                TextInputPlugin.this.saveEditableSizeAndTransform(d2, d3, dArr);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i3, boolean z) {
                TextInputPlugin.this.setPlatformViewTextInputClient(i3, z);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }
        });
        textInputChannel.requestExistingInputState();
        this.scribeChannel = scribeChannel;
        this.platformViewsController = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
        this.platformViewsController2 = platformViewsController2;
        platformViewsController2.attachTextInputPlugin(this);
    }

    private static boolean composingChanged(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i2 = textEditState.composingEnd - textEditState.composingStart;
        if (i2 != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (textEditState.text.charAt(textEditState.composingStart + i3) != textEditState2.text.charAt(textEditState2.composingStart + i3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTextInput(View view) {
        notifyViewExited();
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int inputTypeFromTextInputType(io.flutter.embedding.engine.systemchannels.TextInputChannel.InputType r1, boolean r2, boolean r3, boolean r4, boolean r5, io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization r6) {
        /*
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r5 = r1.type
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r0 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.DATETIME
            if (r5 != r0) goto L8
            r1 = 4
            return r1
        L8:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r0 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.NUMBER
            if (r5 != r0) goto L1c
            boolean r2 = r1.isSigned
            if (r2 == 0) goto L13
            r2 = 4098(0x1002, float:5.743E-42)
            goto L14
        L13:
            r2 = 2
        L14:
            boolean r1 = r1.isDecimal
            if (r1 == 0) goto L1b
            r1 = r2 | 8192(0x2000, float:1.148E-41)
            return r1
        L1b:
            return r2
        L1c:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.PHONE
            if (r5 != r1) goto L22
            r1 = 3
            return r1
        L22:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.NONE
            if (r5 != r1) goto L28
            r1 = 0
            return r1
        L28:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.MULTILINE
            if (r5 != r1) goto L30
            r1 = 131073(0x20001, float:1.83672E-40)
            goto L5e
        L30:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.EMAIL_ADDRESS
            if (r5 == r1) goto L5c
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.TWITTER
            if (r5 != r1) goto L39
            goto L5c
        L39:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.URL
            if (r5 == r1) goto L59
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.WEB_SEARCH
            if (r5 != r1) goto L42
            goto L59
        L42:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.VISIBLE_PASSWORD
            if (r5 != r1) goto L49
            r1 = 145(0x91, float:2.03E-43)
            goto L5e
        L49:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.NAME
            if (r5 != r1) goto L50
            r1 = 97
            goto L5e
        L50:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextInputType r1 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputType.POSTAL_ADDRESS
            if (r5 != r1) goto L57
            r1 = 113(0x71, float:1.58E-43)
            goto L5e
        L57:
            r1 = 1
            goto L5e
        L59:
            r1 = 17
            goto L5e
        L5c:
            r1 = 33
        L5e:
            if (r2 == 0) goto L65
            r2 = 524416(0x80080, float:7.34863E-40)
        L63:
            r1 = r1 | r2
            goto L71
        L65:
            if (r3 == 0) goto L6b
            r2 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 | r2
        L6b:
            if (r4 != 0) goto L71
            r2 = 524432(0x80090, float:7.34886E-40)
            goto L63
        L71:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization r2 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization.CHARACTERS
            if (r6 != r2) goto L78
            r1 = r1 | 4096(0x1000, float:5.74E-42)
            return r1
        L78:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization r2 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization.WORDS
            if (r6 != r2) goto L7f
            r1 = r1 | 8192(0x2000, float:1.148E-41)
            return r1
        L7f:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization r2 = io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization.SENTENCES
            if (r6 != r2) goto L85
            r1 = r1 | 16384(0x4000, float:2.2959E-41)
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.TextInputPlugin.inputTypeFromTextInputType(io.flutter.embedding.engine.systemchannels.TextInputChannel$InputType, boolean, boolean, boolean, boolean, io.flutter.embedding.engine.systemchannels.TextInputChannel$TextCapitalization):int");
    }

    private boolean needsAutofill() {
        if (this.autofillConfiguration != null) {
            return true;
        }
        return false;
    }

    private void notifyValueChanged(String str) {
        AutofillValue forText;
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            String str2 = this.configuration.autofill.uniqueIdentifier;
            AutofillManager autofillManager = this.afm;
            View view = this.mView;
            int hashCode = str2.hashCode();
            forText = AutofillValue.forText(str);
            autofillManager.notifyValueChanged(view, hashCode, forText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewEntered() {
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            int[] iArr = new int[2];
            this.mView.getLocationOnScreen(iArr);
            Rect rect = new Rect(this.lastClientRect);
            rect.offset(iArr[0], iArr[1]);
            this.afm.notifyViewEntered(this.mView, str.hashCode(), rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewExited() {
        TextInputChannel.Configuration configuration;
        if (Build.VERSION.SDK_INT >= 26 && this.afm != null && (configuration = this.configuration) != null && configuration.autofill != null && needsAutofill()) {
            this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveEditableSizeAndTransform(double d2, double d3, final double[] dArr) {
        final boolean z;
        final double[] dArr2 = new double[4];
        if (dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d) {
            z = true;
        } else {
            z = false;
        }
        double d4 = dArr[12];
        double d5 = dArr[15];
        double d6 = d4 / d5;
        dArr2[1] = d6;
        dArr2[0] = d6;
        double d7 = dArr[13] / d5;
        dArr2[3] = d7;
        dArr2[2] = d7;
        MinMax minMax = new MinMax() { // from class: io.flutter.plugin.editing.TextInputPlugin.3
            @Override // io.flutter.plugin.editing.TextInputPlugin.MinMax
            public void inspect(double d8, double d9) {
                double d10 = 1.0d;
                if (!z) {
                    double[] dArr3 = dArr;
                    d10 = 1.0d / (((dArr3[7] * d9) + (dArr3[3] * d8)) + dArr3[15]);
                }
                double[] dArr4 = dArr;
                double d11 = ((dArr4[4] * d9) + (dArr4[0] * d8) + dArr4[12]) * d10;
                double d12 = ((dArr4[5] * d9) + (dArr4[1] * d8) + dArr4[13]) * d10;
                double[] dArr5 = dArr2;
                if (d11 < dArr5[0]) {
                    dArr5[0] = d11;
                } else if (d11 > dArr5[1]) {
                    dArr5[1] = d11;
                }
                if (d12 < dArr5[2]) {
                    dArr5[2] = d12;
                } else if (d12 > dArr5[3]) {
                    dArr5[3] = d12;
                }
            }
        };
        minMax.inspect(d2, 0.0d);
        minMax.inspect(d2, d3);
        minMax.inspect(0.0d, d3);
        double d8 = this.mView.getContext().getResources().getDisplayMetrics().density;
        this.lastClientRect = new Rect((int) (dArr2[0] * d8), (int) (dArr2[2] * d8), (int) Math.ceil(dArr2[1] * d8), (int) Math.ceil(dArr2[3] * d8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i2, boolean z) {
        if (z) {
            this.mView.requestFocus();
            this.inputTarget = new InputTarget(InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW, i2);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
            return;
        }
        this.inputTarget = new InputTarget(InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW, i2);
        this.lastInputConnection = null;
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration) {
        AutofillValue forText;
        if (Build.VERSION.SDK_INT >= 26) {
            if (configuration != null && configuration.autofill != null) {
                TextInputChannel.Configuration[] configurationArr = configuration.fields;
                SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
                this.autofillConfiguration = sparseArray;
                if (configurationArr == null) {
                    sparseArray.put(configuration.autofill.uniqueIdentifier.hashCode(), configuration);
                    return;
                }
                for (TextInputChannel.Configuration configuration2 : configurationArr) {
                    TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
                    if (autofill != null) {
                        this.autofillConfiguration.put(autofill.uniqueIdentifier.hashCode(), configuration2);
                        AutofillManager autofillManager = this.afm;
                        View view = this.mView;
                        int hashCode = autofill.uniqueIdentifier.hashCode();
                        forText = AutofillValue.forText(autofill.editState.text);
                        autofillManager.notifyValueChanged(view, hashCode, forText);
                    }
                }
                return;
            }
            this.autofillConfiguration = null;
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration configuration;
        TextInputChannel.Configuration.Autofill autofill;
        TextInputChannel.Configuration.Autofill autofill2;
        CharSequence textValue;
        if (Build.VERSION.SDK_INT >= 26 && (configuration = this.configuration) != null && this.autofillConfiguration != null && (autofill = configuration.autofill) != null) {
            HashMap<String, TextInputChannel.TextEditState> hashMap = new HashMap<>();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                TextInputChannel.Configuration configuration2 = this.autofillConfiguration.get(sparseArray.keyAt(i2));
                if (configuration2 != null && (autofill2 = configuration2.autofill) != null) {
                    textValue = com.dexterous.flutterlocalnotifications.a.j(sparseArray.valueAt(i2)).getTextValue();
                    String charSequence = textValue.toString();
                    TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                        this.mEditable.setEditingState(textEditState);
                    } else {
                        hashMap.put(autofill2.uniqueIdentifier, textEditState);
                    }
                }
            }
            this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, hashMap);
        }
    }

    public void clearPlatformViewClient(int i2) {
        InputTarget inputTarget = this.inputTarget;
        InputTarget.Type type = inputTarget.type;
        if ((type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW || type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) && inputTarget.id == i2) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            notifyViewExited();
            this.mImm.hideSoftInputFromWindow(this.mView.getApplicationWindowToken(), 0);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    public void clearTextInputClient() {
        if (this.inputTarget.type != InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.mEditable.removeEditingStateListener(this);
            notifyViewExited();
            this.configuration = null;
            updateAutofillConfigurationIfNeeded(null);
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
            this.lastClientRect = null;
            View view = this.mView;
            Field field = J.f180a;
            k0 a2 = D.a(view);
            if (a2 != null && !a2.f234a.q(8)) {
                this.mImm.restartInput(this.mView);
            }
        }
    }

    public InputConnection createInputConnection(View view, KeyboardManager keyboardManager, EditorInfo editorInfo) {
        int intValue;
        InputTarget inputTarget = this.inputTarget;
        InputTarget.Type type = inputTarget.type;
        if (type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        }
        if (type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        }
        if (type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            if (this.isInputConnectionLocked) {
                return this.lastInputConnection;
            }
            InputConnection onCreateInputConnection = this.platformViewsController.getPlatformViewById(inputTarget.id).onCreateInputConnection(editorInfo);
            this.lastInputConnection = onCreateInputConnection;
            return onCreateInputConnection;
        }
        TextInputChannel.Configuration configuration = this.configuration;
        int inputTypeFromTextInputType = inputTypeFromTextInputType(configuration.inputType, configuration.obscureText, configuration.autocorrect, configuration.enableSuggestions, configuration.enableIMEPersonalizedLearning, configuration.textCapitalization);
        editorInfo.inputType = inputTypeFromTextInputType;
        editorInfo.imeOptions = 33554432;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && !this.configuration.enableIMEPersonalizedLearning) {
            editorInfo.imeOptions = 50331648;
        }
        Integer num = this.configuration.inputAction;
        if (num == null) {
            if ((inputTypeFromTextInputType & 131072) != 0) {
                intValue = 1;
            } else {
                intValue = 6;
            }
        } else {
            intValue = num.intValue();
        }
        TextInputChannel.Configuration configuration2 = this.configuration;
        String str = configuration2.actionLabel;
        if (str != null) {
            editorInfo.actionLabel = str;
            editorInfo.actionId = intValue;
        }
        editorInfo.imeOptions = intValue | editorInfo.imeOptions;
        if (configuration2.hintLocales != null) {
            editorInfo.hintLocales = new LocaleList(this.configuration.hintLocales);
        }
        String[] strArr = this.configuration.contentCommitMimeTypes;
        if (strArr != null) {
            if (i2 >= 25) {
                editorInfo.contentMimeTypes = strArr;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
            }
        }
        if (i2 >= 34) {
            if (i2 >= 35) {
                b.b(editorInfo);
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", true);
        }
        InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, this.scribeChannel, keyboardManager, this.mEditable, editorInfo);
        editorInfo.initialSelStart = this.mEditable.getSelectionStart();
        editorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
        this.lastInputConnection = inputConnectionAdaptor;
        return inputConnectionAdaptor;
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
        this.platformViewsController2.detachTextInputPlugin();
        this.textInputChannel.setTextInputMethodHandler(null);
        notifyViewExited();
        this.mEditable.removeEditingStateListener(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r5 == r9.composingEnd) goto L23;
     */
    @Override // io.flutter.plugin.editing.ListenableEditingState.EditingStateWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didChangeEditingState(boolean r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            if (r8 == 0) goto Lb
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.lang.String r8 = r8.toString()
            r7.notifyValueChanged(r8)
        Lb:
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r2 = r8.getSelectionStart()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r3 = r8.getSelectionEnd()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r4 = r8.getComposingStart()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r5 = r8.getComposingEnd()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.util.ArrayList r8 = r8.extractBatchTextEditingDeltas()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r9 = r7.mLastKnownFrameworkTextEditingState
            if (r9 == 0) goto La4
            io.flutter.plugin.editing.ListenableEditingState r9 = r7.mEditable
            java.lang.String r9 = r9.toString()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r10 = r7.mLastKnownFrameworkTextEditingState
            java.lang.String r10 = r10.text
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L50
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r9 = r7.mLastKnownFrameworkTextEditingState
            int r10 = r9.selectionStart
            if (r2 != r10) goto L50
            int r10 = r9.selectionEnd
            if (r3 != r10) goto L50
            int r10 = r9.composingStart
            if (r4 != r10) goto L50
            int r9 = r9.composingEnd
            if (r5 != r9) goto L50
            goto La4
        L50:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "send EditingState to flutter: "
            r9.<init>(r10)
            io.flutter.plugin.editing.ListenableEditingState r10 = r7.mEditable
            java.lang.String r10 = r10.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "TextInputPlugin"
            io.flutter.Log.v(r10, r9)
            io.flutter.embedding.engine.systemchannels.TextInputChannel$Configuration r9 = r7.configuration
            boolean r9 = r9.enableDeltaModel
            if (r9 == 0) goto L7e
            io.flutter.embedding.engine.systemchannels.TextInputChannel r9 = r7.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r10 = r7.inputTarget
            int r10 = r10.id
            r9.updateEditingStateWithDeltas(r10, r8)
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            r8.clearBatchDeltas()
            goto L96
        L7e:
            io.flutter.embedding.engine.systemchannels.TextInputChannel r0 = r7.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r8 = r7.inputTarget
            int r1 = r8.id
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.lang.String r8 = r8.toString()
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r8
            r0.updateEditingState(r1, r2, r3, r4, r5, r6)
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
        L96:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r0 = new io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.lang.String r1 = r8.toString()
            r0.<init>(r1, r2, r3, r4, r5)
            r7.mLastKnownFrameworkTextEditingState = r0
            return
        La4:
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            r8.clearBatchDeltas()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.TextInputPlugin.didChangeEditingState(boolean, boolean, boolean):void");
    }

    public Editable getEditable() {
        return this.mEditable;
    }

    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        return this.imeSyncCallback;
    }

    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (getInputMethodManager().isAcceptingText() && (inputConnection = this.lastInputConnection) != null) {
            if (inputConnection instanceof InputConnectionAdaptor) {
                return ((InputConnectionAdaptor) inputConnection).handleKeyEvent(keyEvent);
            }
            return inputConnection.sendKeyEvent(keyEvent);
        }
        return false;
    }

    public void lockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i2) {
        AutofillId autofillId;
        AutofillValue forText;
        Rect rect;
        AutofillValue forText2;
        if (Build.VERSION.SDK_INT >= 26 && needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            autofillId = viewStructure.getAutofillId();
            for (int i3 = 0; i3 < this.autofillConfiguration.size(); i3++) {
                int keyAt = this.autofillConfiguration.keyAt(i3);
                TextInputChannel.Configuration.Autofill autofill = this.autofillConfiguration.valueAt(i3).autofill;
                if (autofill != null) {
                    viewStructure.addChildCount(1);
                    ViewStructure newChild = viewStructure.newChild(i3);
                    newChild.setAutofillId(autofillId, keyAt);
                    String[] strArr = autofill.hints;
                    if (strArr.length > 0) {
                        newChild.setAutofillHints(strArr);
                    }
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    String str2 = autofill.hintText;
                    if (str2 != null) {
                        newChild.setHint(str2);
                    }
                    if (str.hashCode() == keyAt && (rect = this.lastClientRect) != null) {
                        newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.lastClientRect.height());
                        forText2 = AutofillValue.forText(this.mEditable);
                        newChild.setAutofillValue(forText2);
                    } else {
                        newChild.setDimens(0, 0, 0, 0, 1, 1);
                        forText = AutofillValue.forText(autofill.editState.text);
                        newChild.setAutofillValue(forText);
                    }
                }
            }
        }
    }

    public void sendTextInputAppPrivateCommand(String str, Bundle bundle) {
        this.mImm.sendAppPrivateCommand(this.mView, str, bundle);
    }

    public void setTextInputClient(int i2, TextInputChannel.Configuration configuration) {
        TextInputChannel.TextEditState textEditState;
        notifyViewExited();
        this.configuration = configuration;
        this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i2);
        this.mEditable.removeEditingStateListener(this);
        TextInputChannel.Configuration.Autofill autofill = configuration.autofill;
        if (autofill != null) {
            textEditState = autofill.editState;
        } else {
            textEditState = null;
        }
        this.mEditable = new ListenableEditingState(textEditState, this.mView);
        updateAutofillConfigurationIfNeeded(configuration);
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
        this.mEditable.addEditingStateListener(this);
    }

    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.mRestartInputPending && (textEditState2 = this.mLastKnownFrameworkTextEditingState) != null && textEditState2.hasComposing()) {
            boolean composingChanged = composingChanged(this.mLastKnownFrameworkTextEditingState, textEditState);
            this.mRestartInputPending = composingChanged;
            if (composingChanged) {
                Log.i(TAG, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.mLastKnownFrameworkTextEditingState = textEditState;
        this.mEditable.setEditingState(textEditState);
        if (this.mRestartInputPending) {
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
        }
    }

    public void showTextInput(View view) {
        TextInputChannel.InputType inputType;
        TextInputChannel.Configuration configuration = this.configuration;
        if (configuration != null && (inputType = configuration.inputType) != null && inputType.type == TextInputChannel.TextInputType.NONE) {
            hideTextInput(view);
        } else {
            view.requestFocus();
            this.mImm.showSoftInput(view, 0);
        }
    }

    public void unlockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = false;
        }
    }
}
