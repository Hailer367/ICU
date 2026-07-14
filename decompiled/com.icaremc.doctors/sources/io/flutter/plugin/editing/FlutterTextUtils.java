package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FlutterTextUtils {
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    private final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    public int getOffsetAfter(CharSequence charSequence, int i2) {
        int charCount;
        int charCount2;
        int charCount3;
        int length = charSequence.length();
        int i3 = length - 1;
        if (i2 >= i3) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i2);
        int charCount4 = Character.charCount(codePointAt);
        int i4 = i2 + charCount4;
        int i5 = 0;
        if (i4 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i4) == 13) {
                charCount4++;
            }
            return i2 + charCount4;
        }
        if (isRegionalIndicatorSymbol(codePointAt)) {
            if (i4 < i3 && isRegionalIndicatorSymbol(Character.codePointAt(charSequence, i4))) {
                int i6 = i2;
                while (i6 > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(charSequence, i2))) {
                    i6 -= Character.charCount(Character.codePointBefore(charSequence, i2));
                    i5++;
                }
                if (i5 % 2 == 0) {
                    charCount4 += 2;
                }
                return i2 + charCount4;
            }
            return i4;
        }
        if (isKeycapBase(codePointAt)) {
            charCount4 += Character.charCount(codePointAt);
        }
        if (codePointAt == 8419) {
            int codePointBefore = Character.codePointBefore(charSequence, i4);
            int charCount5 = Character.charCount(codePointBefore) + i4;
            if (charCount5 < length && isVariationSelector(codePointBefore)) {
                int codePointAt2 = Character.codePointAt(charSequence, charCount5);
                if (isKeycapBase(codePointAt2)) {
                    charCount3 = Character.charCount(codePointAt2) + Character.charCount(codePointBefore);
                    charCount4 += charCount3;
                }
                return i2 + charCount4;
            }
            if (isKeycapBase(codePointBefore)) {
                charCount3 = Character.charCount(codePointBefore);
                charCount4 += charCount3;
            }
            return i2 + charCount4;
        }
        if (isEmoji(codePointAt)) {
            boolean z = false;
            int i7 = 0;
            do {
                if (z) {
                    charCount4 = Character.charCount(codePointAt) + i7 + 1 + charCount4;
                    z = false;
                }
                if (isEmojiModifier(codePointAt)) {
                    break;
                }
                if (i4 < length) {
                    codePointAt = Character.codePointAt(charSequence, i4);
                    int charCount6 = Character.charCount(codePointAt) + i4;
                    if (codePointAt == 8419) {
                        int codePointBefore2 = Character.codePointBefore(charSequence, charCount6);
                        int charCount7 = Character.charCount(codePointBefore2) + charCount6;
                        if (charCount7 < length && isVariationSelector(codePointBefore2)) {
                            int codePointAt3 = Character.codePointAt(charSequence, charCount7);
                            if (isKeycapBase(codePointAt3)) {
                                charCount = Character.charCount(codePointAt3) + Character.charCount(codePointBefore2);
                                charCount4 += charCount;
                            }
                            return i2 + charCount4;
                        }
                        if (isKeycapBase(codePointBefore2)) {
                            charCount = Character.charCount(codePointBefore2);
                            charCount4 += charCount;
                        }
                        return i2 + charCount4;
                    }
                    if (isEmojiModifier(codePointAt)) {
                        charCount2 = Character.charCount(codePointAt);
                    } else if (isVariationSelector(codePointAt)) {
                        charCount2 = Character.charCount(codePointAt);
                    } else if (codePointAt == 8205) {
                        codePointAt = Character.codePointAt(charSequence, charCount6);
                        i4 = Character.charCount(codePointAt) + charCount6;
                        if (i4 < length && isVariationSelector(codePointAt)) {
                            codePointAt = Character.codePointAt(charSequence, i4);
                            int charCount8 = Character.charCount(codePointAt);
                            i4 = Character.charCount(codePointAt) + i4;
                            i7 = charCount8;
                        } else {
                            i7 = 0;
                        }
                        z = true;
                        if (i4 < length || !z) {
                            break;
                            break;
                        }
                    } else {
                        i4 = charCount6;
                    }
                    charCount4 += charCount2;
                    break;
                }
                i7 = 0;
                if (i4 < length) {
                    break;
                }
            } while (isEmoji(codePointAt));
        }
        return i2 + charCount4;
    }

    public int getOffsetBefore(CharSequence charSequence, int i2) {
        int codePointBefore;
        int charCount;
        int charCount2;
        int charCount3;
        int i3 = 0;
        int i4 = 1;
        if (i2 <= 1 || (charCount2 = i2 - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i2))))) == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            if (Character.codePointBefore(charSequence, charCount2) == 13) {
                charCount++;
            }
            return i2 - charCount;
        }
        if (isRegionalIndicatorSymbol(codePointBefore)) {
            int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
            int charCount4 = charCount2 - Character.charCount(codePointBefore2);
            while (charCount4 > 0 && isRegionalIndicatorSymbol(codePointBefore2)) {
                codePointBefore2 = Character.codePointBefore(charSequence, charCount4);
                charCount4 -= Character.charCount(codePointBefore2);
                i4++;
            }
            if (i4 % 2 == 0) {
                charCount += 2;
            }
            return i2 - charCount;
        }
        if (codePointBefore == 8419) {
            int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
            int charCount5 = charCount2 - Character.charCount(codePointBefore3);
            if (charCount5 > 0 && isVariationSelector(codePointBefore3)) {
                int codePointBefore4 = Character.codePointBefore(charSequence, charCount5);
                if (isKeycapBase(codePointBefore4)) {
                    charCount3 = Character.charCount(codePointBefore4) + Character.charCount(codePointBefore3);
                    charCount += charCount3;
                }
                return i2 - charCount;
            }
            if (isKeycapBase(codePointBefore3)) {
                charCount3 = Character.charCount(codePointBefore3);
                charCount += charCount3;
            }
            return i2 - charCount;
        }
        if (codePointBefore == 917631) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            int charCount6 = Character.charCount(codePointBefore);
            while (true) {
                charCount2 -= charCount6;
                if (charCount2 <= 0 || !isTagSpecChar(codePointBefore)) {
                    break;
                }
                charCount += Character.charCount(codePointBefore);
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                charCount6 = Character.charCount(codePointBefore);
            }
            if (!isEmoji(codePointBefore)) {
                return i2 - 2;
            }
            charCount += Character.charCount(codePointBefore);
        }
        if (isVariationSelector(codePointBefore)) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            if (!isEmoji(codePointBefore)) {
                return i2 - charCount;
            }
            charCount += Character.charCount(codePointBefore);
            charCount2 -= charCount;
        }
        if (isEmoji(codePointBefore)) {
            boolean z = false;
            int i5 = 0;
            while (true) {
                if (z) {
                    charCount = Character.charCount(codePointBefore) + i5 + 1 + charCount;
                    z = false;
                }
                if (isEmojiModifier(codePointBefore)) {
                    int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                    int charCount7 = charCount2 - Character.charCount(codePointBefore5);
                    if (charCount7 > 0 && isVariationSelector(codePointBefore5)) {
                        codePointBefore5 = Character.codePointBefore(charSequence, charCount7);
                        if (!isEmoji(codePointBefore5)) {
                            return i2 - charCount;
                        }
                        i3 = Character.charCount(codePointBefore5);
                        Character.charCount(codePointBefore5);
                    }
                    if (isEmojiModifierBase(codePointBefore5)) {
                        charCount += Character.charCount(codePointBefore5) + i3;
                    }
                } else {
                    if (charCount2 > 0) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        charCount2 -= Character.charCount(codePointBefore);
                        if (codePointBefore == 8205) {
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount2 -= Character.charCount(codePointBefore);
                            if (charCount2 > 0 && isVariationSelector(codePointBefore)) {
                                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                int charCount8 = Character.charCount(codePointBefore);
                                charCount2 -= Character.charCount(codePointBefore);
                                i5 = charCount8;
                            } else {
                                i5 = 0;
                            }
                            z = true;
                            if (charCount2 != 0 || !z || !isEmoji(codePointBefore)) {
                                break;
                                break;
                            }
                        }
                    }
                    i5 = 0;
                    if (charCount2 != 0) {
                        break;
                    }
                }
            }
        }
        return i2 - charCount;
    }

    public boolean isEmoji(int i2) {
        return this.flutterJNI.isCodePointEmoji(i2);
    }

    public boolean isEmojiModifier(int i2) {
        return this.flutterJNI.isCodePointEmojiModifier(i2);
    }

    public boolean isEmojiModifierBase(int i2) {
        return this.flutterJNI.isCodePointEmojiModifierBase(i2);
    }

    public boolean isKeycapBase(int i2) {
        return (48 <= i2 && i2 <= 57) || i2 == 35 || i2 == 42;
    }

    public boolean isRegionalIndicatorSymbol(int i2) {
        return this.flutterJNI.isCodePointRegionalIndicator(i2);
    }

    public boolean isTagSpecChar(int i2) {
        return 917536 <= i2 && i2 <= 917630;
    }

    public boolean isVariationSelector(int i2) {
        return this.flutterJNI.isCodePointVariantSelector(i2);
    }
}
