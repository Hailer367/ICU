package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f3049a;

    /* renamed from: b, reason: collision with root package name */
    public int f3050b = -1;

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f3049a.equals(((AudioAttributesImplApi21) obj).f3049a);
    }

    public final int hashCode() {
        return this.f3049a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3049a;
    }
}
