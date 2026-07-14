package androidx.media;

import g0.AbstractC0200a;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0200a abstractC0200a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1869a = abstractC0200a.f(audioAttributesImplBase.f1869a, 1);
        audioAttributesImplBase.f1870b = abstractC0200a.f(audioAttributesImplBase.f1870b, 2);
        audioAttributesImplBase.f1871c = abstractC0200a.f(audioAttributesImplBase.f1871c, 3);
        audioAttributesImplBase.f1872d = abstractC0200a.f(audioAttributesImplBase.f1872d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0200a abstractC0200a) {
        abstractC0200a.getClass();
        abstractC0200a.j(audioAttributesImplBase.f1869a, 1);
        abstractC0200a.j(audioAttributesImplBase.f1870b, 2);
        abstractC0200a.j(audioAttributesImplBase.f1871c, 3);
        abstractC0200a.j(audioAttributesImplBase.f1872d, 4);
    }
}
