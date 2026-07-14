package androidx.media;

import android.util.SparseIntArray;
import g0.c;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1865b = 0;

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f1866a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f1866a;
        if (audioAttributesImpl == null) {
            if (audioAttributesCompat.f1866a != null) {
                return false;
            }
            return true;
        }
        return audioAttributesImpl.equals(audioAttributesCompat.f1866a);
    }

    public final int hashCode() {
        return this.f1866a.hashCode();
    }

    public final String toString() {
        return this.f1866a.toString();
    }
}
