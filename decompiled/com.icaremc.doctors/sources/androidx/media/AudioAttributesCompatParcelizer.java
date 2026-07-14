package androidx.media;

import g0.AbstractC0200a;
import g0.c;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0200a abstractC0200a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        c cVar = audioAttributesCompat.f1866a;
        if (abstractC0200a.e(1)) {
            cVar = abstractC0200a.h();
        }
        audioAttributesCompat.f1866a = (AudioAttributesImpl) cVar;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0200a abstractC0200a) {
        abstractC0200a.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f1866a;
        abstractC0200a.i(1);
        abstractC0200a.l(audioAttributesImpl);
    }
}
