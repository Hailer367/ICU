package io.flutter.plugin.editing;

import com.google.firebase.encoders.json.BuildConfig;
import io.flutter.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class TextEditingDelta {
    private static final String TAG = "TextEditingDelta";
    private int deltaEnd;
    private int deltaStart;
    private CharSequence deltaText;
    private int newComposingEnd;
    private int newComposingStart;
    private int newSelectionEnd;
    private int newSelectionStart;
    private CharSequence oldText;

    public TextEditingDelta(CharSequence charSequence, int i2, int i3, CharSequence charSequence2, int i4, int i5, int i6, int i7) {
        this.newSelectionStart = i4;
        this.newSelectionEnd = i5;
        this.newComposingStart = i6;
        this.newComposingEnd = i7;
        setDeltas(charSequence, charSequence2.toString(), i2, i3);
    }

    private void setDeltas(CharSequence charSequence, CharSequence charSequence2, int i2, int i3) {
        this.oldText = charSequence;
        this.deltaText = charSequence2;
        this.deltaStart = i2;
        this.deltaEnd = i3;
    }

    public int getDeltaEnd() {
        return this.deltaEnd;
    }

    public int getDeltaStart() {
        return this.deltaStart;
    }

    public CharSequence getDeltaText() {
        return this.deltaText;
    }

    public int getNewComposingEnd() {
        return this.newComposingEnd;
    }

    public int getNewComposingStart() {
        return this.newComposingStart;
    }

    public int getNewSelectionEnd() {
        return this.newSelectionEnd;
    }

    public int getNewSelectionStart() {
        return this.newSelectionStart;
    }

    public CharSequence getOldText() {
        return this.oldText;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.oldText.toString());
            jSONObject.put("deltaText", this.deltaText.toString());
            jSONObject.put("deltaStart", this.deltaStart);
            jSONObject.put("deltaEnd", this.deltaEnd);
            jSONObject.put("selectionBase", this.newSelectionStart);
            jSONObject.put("selectionExtent", this.newSelectionEnd);
            jSONObject.put("composingBase", this.newComposingStart);
            jSONObject.put("composingExtent", this.newComposingEnd);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e(TAG, "unable to create JSONObject: " + e2);
            return jSONObject;
        }
    }

    public TextEditingDelta(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        this.newSelectionStart = i2;
        this.newSelectionEnd = i3;
        this.newComposingStart = i4;
        this.newComposingEnd = i5;
        setDeltas(charSequence, BuildConfig.FLAVOR, -1, -1);
    }
}
