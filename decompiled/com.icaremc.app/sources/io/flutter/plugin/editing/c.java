package io.flutter.plugin.editing;

import A2.t;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import h2.p;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.s;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import s2.C0644p;

/* loaded from: classes.dex */
public final class c extends BaseInputConnection implements e {

    /* renamed from: a, reason: collision with root package name */
    public final p f4250a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4251b;

    /* renamed from: c, reason: collision with root package name */
    public final s f4252c;

    /* renamed from: d, reason: collision with root package name */
    public final f f4253d;

    /* renamed from: e, reason: collision with root package name */
    public final EditorInfo f4254e;

    /* renamed from: f, reason: collision with root package name */
    public ExtractedTextRequest f4255f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4256g;

    /* renamed from: h, reason: collision with root package name */
    public CursorAnchorInfo.Builder f4257h;

    /* renamed from: i, reason: collision with root package name */
    public final ExtractedText f4258i;

    /* renamed from: j, reason: collision with root package name */
    public final InputMethodManager f4259j;
    public final DynamicLayout k;

    /* renamed from: l, reason: collision with root package name */
    public final R1.c f4260l;

    /* renamed from: m, reason: collision with root package name */
    public final t f4261m;

    /* renamed from: n, reason: collision with root package name */
    public int f4262n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(p pVar, int i4, s sVar, t tVar, f fVar, EditorInfo editorInfo) {
        super(pVar, true);
        FlutterJNI flutterJNI = new FlutterJNI();
        this.f4256g = false;
        this.f4258i = new ExtractedText();
        this.f4262n = 0;
        this.f4250a = pVar;
        this.f4251b = i4;
        this.f4252c = sVar;
        this.f4253d = fVar;
        fVar.a(this);
        this.f4254e = editorInfo;
        this.f4261m = tVar;
        this.f4260l = new R1.c(27, flutterJNI);
        this.k = new DynamicLayout(fVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f4259j = (InputMethodManager) pVar.getContext().getSystemService("input_method");
    }

    @Override // io.flutter.plugin.editing.e
    public final void a(boolean z) {
        f fVar = this.f4253d;
        fVar.getClass();
        int selectionStart = Selection.getSelectionStart(fVar);
        int selectionEnd = Selection.getSelectionEnd(fVar);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(fVar);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(fVar);
        InputMethodManager inputMethodManager = this.f4259j;
        p pVar = this.f4250a;
        inputMethodManager.updateSelection(pVar, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
        ExtractedTextRequest extractedTextRequest = this.f4255f;
        if (extractedTextRequest != null) {
            inputMethodManager.updateExtractedText(pVar, extractedTextRequest.token, c(extractedTextRequest));
        }
        if (this.f4256g) {
            inputMethodManager.updateCursorAnchorInfo(pVar, b());
        }
    }

    public final CursorAnchorInfo b() {
        CursorAnchorInfo.Builder builder = this.f4257h;
        if (builder == null) {
            this.f4257h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        CursorAnchorInfo.Builder builder2 = this.f4257h;
        f fVar = this.f4253d;
        fVar.getClass();
        int selectionStart = Selection.getSelectionStart(fVar);
        fVar.getClass();
        builder2.setSelectionRange(selectionStart, Selection.getSelectionEnd(fVar));
        fVar.getClass();
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(fVar);
        fVar.getClass();
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(fVar);
        if (composingSpanStart >= 0 && composingSpanEnd > composingSpanStart) {
            this.f4257h.setComposingText(composingSpanStart, fVar.toString().subSequence(composingSpanStart, composingSpanEnd));
        } else {
            this.f4257h.setComposingText(-1, "");
        }
        return this.f4257h.build();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        this.f4253d.b();
        this.f4262n++;
        return super.beginBatchEdit();
    }

    public final ExtractedText c(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f4258i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        CharSequence charSequence = this.f4253d;
        charSequence.getClass();
        extractedText.selectionStart = Selection.getSelectionStart(charSequence);
        charSequence.getClass();
        extractedText.selectionEnd = Selection.getSelectionEnd(charSequence);
        if (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) {
            charSequence = charSequence.toString();
        }
        extractedText.text = charSequence;
        return extractedText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final void closeConnection() {
        super.closeConnection();
        this.f4253d.e(this);
        while (this.f4262n > 0) {
            endBatchEdit();
            this.f4262n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i4, Bundle bundle) {
        ClipDescription description;
        Uri contentUri;
        ClipDescription description2;
        int i5;
        if (Build.VERSION.SDK_INT >= 25 && (i4 & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                description = inputContentInfo.getDescription();
                if (description.getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    contentUri = inputContentInfo.getContentUri();
                    description2 = inputContentInfo.getDescription();
                    String mimeType = description2.getMimeType(0);
                    Context context = this.f4250a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[65536];
                                while (true) {
                                    try {
                                        i5 = openInputStream.read(bArr);
                                    } catch (IOException unused) {
                                        i5 = -1;
                                    }
                                    if (i5 == -1) {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("mimeType", mimeType);
                                        hashMap.put("data", byteArray);
                                        hashMap.put("uri", contentUri.toString());
                                        ((C0644p) this.f4252c.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(this.f4251b), "TextInputAction.commitContent", hashMap), null);
                                        inputContentInfo.releasePermission();
                                        return true;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i5);
                                }
                            }
                        } catch (FileNotFoundException unused2) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused3) {
            }
        }
        return false;
    }

    public final boolean d(boolean z, boolean z3) {
        int charCount;
        int charCount2;
        int charCount3;
        int charCount4;
        int min;
        int codePointBefore;
        int charCount5;
        int charCount6;
        int i4;
        int i5;
        int charCount7;
        f fVar = this.f4253d;
        int selectionStart = Selection.getSelectionStart(fVar);
        int selectionEnd = Selection.getSelectionEnd(fVar);
        int i6 = 0;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        R1.c cVar = this.f4260l;
        if (z) {
            FlutterJNI flutterJNI = (FlutterJNI) cVar.f1532g;
            if (selectionEnd <= 1 || (charCount6 = selectionEnd - (charCount5 = Character.charCount((codePointBefore = Character.codePointBefore(fVar, selectionEnd))))) == 0) {
                i5 = 0;
            } else {
                if (codePointBefore == 10) {
                    if (Character.codePointBefore(fVar, charCount6) == 13) {
                        charCount5++;
                    }
                } else if (flutterJNI.isCodePointRegionalIndicator(codePointBefore)) {
                    int codePointBefore2 = Character.codePointBefore(fVar, charCount6);
                    int charCount8 = charCount6 - Character.charCount(codePointBefore2);
                    int i7 = 1;
                    while (charCount8 > 0 && flutterJNI.isCodePointRegionalIndicator(codePointBefore2)) {
                        codePointBefore2 = Character.codePointBefore(fVar, charCount8);
                        charCount8 -= Character.charCount(codePointBefore2);
                        i7++;
                    }
                    if (i7 % 2 == 0) {
                        charCount5 += 2;
                    }
                } else if (codePointBefore == 8419) {
                    int codePointBefore3 = Character.codePointBefore(fVar, charCount6);
                    int charCount9 = charCount6 - Character.charCount(codePointBefore3);
                    if (charCount9 > 0 && flutterJNI.isCodePointVariantSelector(codePointBefore3)) {
                        int codePointBefore4 = Character.codePointBefore(fVar, charCount9);
                        if (R1.c.m(codePointBefore4)) {
                            charCount7 = Character.charCount(codePointBefore4) + Character.charCount(codePointBefore3);
                            charCount5 += charCount7;
                        }
                    } else if (R1.c.m(codePointBefore3)) {
                        charCount7 = Character.charCount(codePointBefore3);
                        charCount5 += charCount7;
                    }
                } else {
                    if (codePointBefore == 917631) {
                        int codePointBefore5 = Character.codePointBefore(fVar, charCount6);
                        charCount6 -= Character.charCount(codePointBefore5);
                        codePointBefore = codePointBefore5;
                        while (charCount6 > 0 && 917536 <= codePointBefore && codePointBefore <= 917630) {
                            charCount5 += Character.charCount(codePointBefore);
                            codePointBefore = Character.codePointBefore(fVar, charCount6);
                            charCount6 -= Character.charCount(codePointBefore);
                        }
                        if (!flutterJNI.isCodePointEmoji(codePointBefore)) {
                            i5 = selectionEnd - 2;
                        } else {
                            charCount5 += Character.charCount(codePointBefore);
                        }
                    }
                    if (flutterJNI.isCodePointVariantSelector(codePointBefore)) {
                        codePointBefore = Character.codePointBefore(fVar, charCount6);
                        if (flutterJNI.isCodePointEmoji(codePointBefore)) {
                            charCount5 += Character.charCount(codePointBefore);
                            charCount6 -= charCount5;
                        }
                    }
                    if (flutterJNI.isCodePointEmoji(codePointBefore)) {
                        boolean z4 = false;
                        int i8 = 0;
                        while (true) {
                            if (z4) {
                                charCount5 = Character.charCount(codePointBefore) + i8 + 1 + charCount5;
                                z4 = false;
                            }
                            if (flutterJNI.isCodePointEmojiModifier(codePointBefore)) {
                                int codePointBefore6 = Character.codePointBefore(fVar, charCount6);
                                int charCount10 = charCount6 - Character.charCount(codePointBefore6);
                                if (charCount10 > 0 && flutterJNI.isCodePointVariantSelector(codePointBefore6)) {
                                    codePointBefore6 = Character.codePointBefore(fVar, charCount10);
                                    if (flutterJNI.isCodePointEmoji(codePointBefore6)) {
                                        i4 = Character.charCount(codePointBefore6);
                                        Character.charCount(codePointBefore6);
                                    }
                                } else {
                                    i4 = 0;
                                }
                                if (flutterJNI.isCodePointEmojiModifierBase(codePointBefore6)) {
                                    charCount5 += Character.charCount(codePointBefore6) + i4;
                                }
                            } else {
                                if (charCount6 > 0) {
                                    int codePointBefore7 = Character.codePointBefore(fVar, charCount6);
                                    charCount6 -= Character.charCount(codePointBefore7);
                                    if (codePointBefore7 == 8205) {
                                        int codePointBefore8 = Character.codePointBefore(fVar, charCount6);
                                        charCount6 -= Character.charCount(codePointBefore8);
                                        if (charCount6 > 0 && flutterJNI.isCodePointVariantSelector(codePointBefore8)) {
                                            codePointBefore8 = Character.codePointBefore(fVar, charCount6);
                                            i8 = Character.charCount(codePointBefore8);
                                            charCount6 -= Character.charCount(codePointBefore8);
                                        } else {
                                            i8 = 0;
                                        }
                                        codePointBefore = codePointBefore8;
                                        z4 = true;
                                        if (charCount6 != 0 || !z4 || !flutterJNI.isCodePointEmoji(codePointBefore)) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        codePointBefore = codePointBefore7;
                                    }
                                }
                                i8 = 0;
                                if (charCount6 != 0) {
                                    break;
                                }
                            }
                        }
                    }
                }
                i5 = selectionEnd - charCount5;
            }
            min = Math.max(i5, 0);
        } else {
            FlutterJNI flutterJNI2 = (FlutterJNI) cVar.f1532g;
            int length = fVar.length();
            int i9 = length - 1;
            if (selectionEnd >= i9) {
                i6 = length;
            } else {
                int codePointAt = Character.codePointAt(fVar, selectionEnd);
                int charCount11 = Character.charCount(codePointAt);
                int i10 = selectionEnd + charCount11;
                if (i10 != 0) {
                    if (codePointAt == 10) {
                        if (Character.codePointAt(fVar, i10) == 13) {
                            charCount11++;
                        }
                    } else if (flutterJNI2.isCodePointRegionalIndicator(codePointAt)) {
                        if (i10 < i9 && flutterJNI2.isCodePointRegionalIndicator(Character.codePointAt(fVar, i10))) {
                            int i11 = selectionEnd;
                            while (i11 > 0 && flutterJNI2.isCodePointRegionalIndicator(Character.codePointBefore(fVar, selectionEnd))) {
                                i11 -= Character.charCount(Character.codePointBefore(fVar, selectionEnd));
                                i6++;
                            }
                            if (i6 % 2 == 0) {
                                charCount11 += 2;
                            }
                        } else {
                            i6 = i10;
                        }
                    } else {
                        if (R1.c.m(codePointAt)) {
                            charCount11 += Character.charCount(codePointAt);
                        }
                        if (codePointAt == 8419) {
                            int codePointBefore9 = Character.codePointBefore(fVar, i10);
                            int charCount12 = Character.charCount(codePointBefore9) + i10;
                            if (charCount12 < length && flutterJNI2.isCodePointVariantSelector(codePointBefore9)) {
                                int codePointAt2 = Character.codePointAt(fVar, charCount12);
                                if (R1.c.m(codePointAt2)) {
                                    charCount2 = Character.charCount(codePointBefore9);
                                    charCount3 = Character.charCount(codePointAt2);
                                    charCount11 += charCount3 + charCount2;
                                }
                            } else if (R1.c.m(codePointBefore9)) {
                                charCount = Character.charCount(codePointBefore9);
                                charCount11 += charCount;
                            }
                        } else if (flutterJNI2.isCodePointEmoji(codePointAt)) {
                            boolean z5 = false;
                            int i12 = 0;
                            while (true) {
                                if (z5) {
                                    charCount11 = Character.charCount(codePointAt) + i12 + 1 + charCount11;
                                    z5 = false;
                                }
                                if (flutterJNI2.isCodePointEmojiModifier(codePointAt)) {
                                    break;
                                }
                                if (i10 < length) {
                                    int codePointAt3 = Character.codePointAt(fVar, i10);
                                    int charCount13 = Character.charCount(codePointAt3) + i10;
                                    if (codePointAt3 == 8419) {
                                        int codePointBefore10 = Character.codePointBefore(fVar, charCount13);
                                        int charCount14 = Character.charCount(codePointBefore10) + charCount13;
                                        if (charCount14 < length && flutterJNI2.isCodePointVariantSelector(codePointBefore10)) {
                                            int codePointAt4 = Character.codePointAt(fVar, charCount14);
                                            if (R1.c.m(codePointAt4)) {
                                                charCount2 = Character.charCount(codePointBefore10);
                                                charCount3 = Character.charCount(codePointAt4);
                                            }
                                        } else if (R1.c.m(codePointBefore10)) {
                                            charCount = Character.charCount(codePointBefore10);
                                        }
                                    } else {
                                        if (flutterJNI2.isCodePointEmojiModifier(codePointAt3)) {
                                            charCount4 = Character.charCount(codePointAt3);
                                            break;
                                        }
                                        if (flutterJNI2.isCodePointVariantSelector(codePointAt3)) {
                                            charCount4 = Character.charCount(codePointAt3);
                                            break;
                                        }
                                        if (codePointAt3 == 8205) {
                                            int codePointAt5 = Character.codePointAt(fVar, charCount13);
                                            int charCount15 = Character.charCount(codePointAt5) + charCount13;
                                            if (charCount15 < length && flutterJNI2.isCodePointVariantSelector(codePointAt5)) {
                                                int codePointAt6 = Character.codePointAt(fVar, charCount15);
                                                int charCount16 = Character.charCount(codePointAt6);
                                                int charCount17 = Character.charCount(codePointAt6) + charCount15;
                                                i12 = charCount16;
                                                i10 = charCount17;
                                                codePointAt = codePointAt6;
                                                z5 = true;
                                                if (i10 < length || !z5 || !flutterJNI2.isCodePointEmoji(codePointAt)) {
                                                    break;
                                                }
                                            } else {
                                                codePointAt = codePointAt5;
                                                i10 = charCount15;
                                                z5 = true;
                                            }
                                        } else {
                                            codePointAt = codePointAt3;
                                            i10 = charCount13;
                                        }
                                    }
                                }
                                i12 = 0;
                                if (i10 < length) {
                                    break;
                                    break;
                                }
                            }
                            charCount11 += charCount4;
                        }
                    }
                    i6 = selectionEnd + charCount11;
                }
            }
            min = Math.min(i6, fVar.length());
        }
        if (selectionStart == selectionEnd && !z3) {
            setSelection(min, min);
            return true;
        }
        setSelection(selectionStart, min);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i4, int i5) {
        f fVar = this.f4253d;
        fVar.getClass();
        if (Selection.getSelectionStart(fVar) == -1) {
            return true;
        }
        return super.deleteSurroundingText(i4, i5);
    }

    public final boolean e(boolean z, boolean z3) {
        f fVar = this.f4253d;
        int selectionStart = Selection.getSelectionStart(fVar);
        int selectionEnd = Selection.getSelectionEnd(fVar);
        boolean z4 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z3) {
            z4 = true;
        }
        beginBatchEdit();
        DynamicLayout dynamicLayout = this.k;
        if (z4) {
            if (z) {
                Selection.moveUp(fVar, dynamicLayout);
            } else {
                Selection.moveDown(fVar, dynamicLayout);
            }
            int selectionStart2 = Selection.getSelectionStart(fVar);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(fVar, dynamicLayout);
            } else {
                Selection.extendDown(fVar, dynamicLayout);
            }
            setSelection(Selection.getSelectionStart(fVar), Selection.getSelectionEnd(fVar));
        }
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f4262n--;
        this.f4253d.c();
        return endBatchEdit;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public final Editable getEditable() {
        return this.f4253d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i4) {
        ExtractedTextRequest extractedTextRequest2;
        boolean z = true;
        if ((i4 & 1) == 0) {
            z = false;
        }
        if (z) {
            extractedTextRequest2 = extractedTextRequest;
        } else {
            extractedTextRequest2 = null;
        }
        this.f4255f = extractedTextRequest2;
        return c(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i4) {
        beginBatchEdit();
        boolean z = true;
        f fVar = this.f4253d;
        if (i4 == 16908319) {
            setSelection(0, fVar.length());
        } else {
            p pVar = this.f4250a;
            if (i4 == 16908320) {
                int selectionStart = Selection.getSelectionStart(fVar);
                int selectionEnd = Selection.getSelectionEnd(fVar);
                if (selectionStart != selectionEnd) {
                    int min = Math.min(selectionStart, selectionEnd);
                    int max = Math.max(selectionStart, selectionEnd);
                    ((ClipboardManager) pVar.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", fVar.subSequence(min, max)));
                    fVar.delete(min, max);
                    setSelection(min, min);
                }
            } else if (i4 == 16908321) {
                int selectionStart2 = Selection.getSelectionStart(fVar);
                int selectionEnd2 = Selection.getSelectionEnd(fVar);
                if (selectionStart2 != selectionEnd2) {
                    ((ClipboardManager) pVar.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", fVar.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
                }
            } else if (i4 == 16908322) {
                ClipData primaryClip = ((ClipboardManager) pVar.getContext().getSystemService("clipboard")).getPrimaryClip();
                if (primaryClip != null) {
                    CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(pVar.getContext());
                    int max2 = Math.max(0, Selection.getSelectionStart(fVar));
                    int max3 = Math.max(0, Selection.getSelectionEnd(fVar));
                    int min2 = Math.min(max2, max3);
                    int max4 = Math.max(max2, max3);
                    if (min2 != max4) {
                        fVar.delete(min2, max4);
                    }
                    fVar.insert(min2, coerceToText);
                    int length = coerceToText.length() + min2;
                    setSelection(length, length);
                }
            } else {
                z = false;
            }
        }
        endBatchEdit();
        return z;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i4) {
        int i5 = this.f4251b;
        s sVar = this.f4252c;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                if (i4 != 7) {
                                    ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.done"), null);
                                } else {
                                    ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.previous"), null);
                                }
                            } else {
                                ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.next"), null);
                            }
                        } else {
                            ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.send"), null);
                        }
                    } else {
                        ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.search"), null);
                    }
                } else {
                    ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.go"), null);
                }
            } else {
                ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.newline"), null);
            }
        } else {
            ((C0644p) sVar.f4390g).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.unspecified"), null);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        s sVar = this.f4252c;
        sVar.getClass();
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
            hashMap.put("data", hashMap2);
        }
        ((C0644p) sVar.f4390g).a("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(this.f4251b), hashMap), null);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i4) {
        boolean z;
        if ((i4 & 1) != 0) {
            this.f4259j.updateCursorAnchorInfo(this.f4250a, b());
        }
        if ((i4 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f4256g = z;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f4261m.M(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i4) {
        boolean composingText;
        beginBatchEdit();
        if (charSequence.length() == 0) {
            composingText = super.commitText(charSequence, i4);
        } else {
            composingText = super.setComposingText(charSequence, i4);
        }
        endBatchEdit();
        return composingText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setSelection(int i4, int i5) {
        beginBatchEdit();
        boolean selection = super.setSelection(i4, i5);
        endBatchEdit();
        return selection;
    }
}
