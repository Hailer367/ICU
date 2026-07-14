package androidx.media;

import o0.AbstractC0557a;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0557a abstractC0557a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3051a = abstractC0557a.f(audioAttributesImplBase.f3051a, 1);
        audioAttributesImplBase.f3052b = abstractC0557a.f(audioAttributesImplBase.f3052b, 2);
        audioAttributesImplBase.f3053c = abstractC0557a.f(audioAttributesImplBase.f3053c, 3);
        audioAttributesImplBase.f3054d = abstractC0557a.f(audioAttributesImplBase.f3054d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0557a abstractC0557a) {
        abstractC0557a.getClass();
        abstractC0557a.j(audioAttributesImplBase.f3051a, 1);
        abstractC0557a.j(audioAttributesImplBase.f3052b, 2);
        abstractC0557a.j(audioAttributesImplBase.f3053c, 3);
        abstractC0557a.j(audioAttributesImplBase.f3054d, 4);
    }
}
