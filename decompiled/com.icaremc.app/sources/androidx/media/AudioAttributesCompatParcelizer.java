package androidx.media;

import o0.AbstractC0557a;
import o0.InterfaceC0559c;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0557a abstractC0557a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        InterfaceC0559c interfaceC0559c = audioAttributesCompat.f3048a;
        if (abstractC0557a.e(1)) {
            interfaceC0559c = abstractC0557a.h();
        }
        audioAttributesCompat.f3048a = (AudioAttributesImpl) interfaceC0559c;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0557a abstractC0557a) {
        abstractC0557a.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f3048a;
        abstractC0557a.i(1);
        abstractC0557a.l(audioAttributesImpl);
    }
}
