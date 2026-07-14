package androidx.media;

import android.media.AudioAttributes;
import g0.AbstractC0200a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC0200a abstractC0200a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f1867a = (AudioAttributes) abstractC0200a.g(audioAttributesImplApi26.f1867a, 1);
        audioAttributesImplApi26.f1868b = abstractC0200a.f(audioAttributesImplApi26.f1868b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC0200a abstractC0200a) {
        abstractC0200a.getClass();
        abstractC0200a.k(audioAttributesImplApi26.f1867a, 1);
        abstractC0200a.j(audioAttributesImplApi26.f1868b, 2);
    }
}
