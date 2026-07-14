package h2;

import android.view.KeyCharacterMap;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public int f4059a = 0;

    public final Character a(int i4) {
        char c4 = (char) i4;
        if ((Integer.MIN_VALUE & i4) != 0) {
            int i5 = i4 & Integer.MAX_VALUE;
            int i6 = this.f4059a;
            if (i6 != 0) {
                this.f4059a = KeyCharacterMap.getDeadChar(i6, i5);
            } else {
                this.f4059a = i5;
            }
        } else {
            int i7 = this.f4059a;
            if (i7 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i7, i4);
                if (deadChar > 0) {
                    c4 = (char) deadChar;
                }
                this.f4059a = 0;
            }
        }
        return Character.valueOf(c4);
    }
}
