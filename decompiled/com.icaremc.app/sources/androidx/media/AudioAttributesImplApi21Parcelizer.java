package androidx.media;

import android.media.AudioAttributes;
import o0.AbstractC0557a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0557a abstractC0557a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f3049a = (AudioAttributes) abstractC0557a.g(audioAttributesImplApi21.f3049a, 1);
        audioAttributesImplApi21.f3050b = abstractC0557a.f(audioAttributesImplApi21.f3050b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0557a abstractC0557a) {
        abstractC0557a.getClass();
        abstractC0557a.k(audioAttributesImplApi21.f3049a, 1);
        abstractC0557a.j(audioAttributesImplApi21.f3050b, 2);
    }
}
