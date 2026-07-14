package androidx.media;

import android.media.AudioAttributes;
import o0.AbstractC0557a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC0557a abstractC0557a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f3049a = (AudioAttributes) abstractC0557a.g(audioAttributesImplApi26.f3049a, 1);
        audioAttributesImplApi26.f3050b = abstractC0557a.f(audioAttributesImplApi26.f3050b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC0557a abstractC0557a) {
        abstractC0557a.getClass();
        abstractC0557a.k(audioAttributesImplApi26.f3049a, 1);
        abstractC0557a.j(audioAttributesImplApi26.f3050b, 2);
    }
}
