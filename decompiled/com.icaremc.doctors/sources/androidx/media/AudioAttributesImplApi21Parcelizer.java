package androidx.media;

import android.media.AudioAttributes;
import g0.AbstractC0200a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0200a abstractC0200a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f1867a = (AudioAttributes) abstractC0200a.g(audioAttributesImplApi21.f1867a, 1);
        audioAttributesImplApi21.f1868b = abstractC0200a.f(audioAttributesImplApi21.f1868b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0200a abstractC0200a) {
        abstractC0200a.getClass();
        abstractC0200a.k(audioAttributesImplApi21.f1867a, 1);
        abstractC0200a.j(audioAttributesImplApi21.f1868b, 2);
    }
}
