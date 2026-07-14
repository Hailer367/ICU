package k1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements Iterator, d1.a {

    /* renamed from: c, reason: collision with root package name */
    public final String f2775c;

    /* renamed from: d, reason: collision with root package name */
    public int f2776d;

    /* renamed from: e, reason: collision with root package name */
    public int f2777e;

    /* renamed from: f, reason: collision with root package name */
    public int f2778f;

    /* renamed from: g, reason: collision with root package name */
    public int f2779g;

    public a(String str) {
        this.f2775c = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2;
        int i3 = this.f2776d;
        if (i3 != 0) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        int i4 = 2;
        if (this.f2779g < 0) {
            this.f2776d = 2;
            return false;
        }
        String str = this.f2775c;
        int length = str.length();
        int length2 = str.length();
        for (int i5 = this.f2777e; i5 < length2; i5++) {
            char charAt = str.charAt(i5);
            if (charAt == '\n' || charAt == '\r') {
                if (charAt != '\r' || (i2 = i5 + 1) >= str.length() || str.charAt(i2) != '\n') {
                    i4 = 1;
                }
                length = i5;
                this.f2776d = 1;
                this.f2779g = i4;
                this.f2778f = length;
                return true;
            }
        }
        i4 = -1;
        this.f2776d = 1;
        this.f2779g = i4;
        this.f2778f = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f2776d = 0;
            int i2 = this.f2778f;
            int i3 = this.f2777e;
            this.f2777e = this.f2779g + i2;
            return this.f2775c.subSequence(i3, i2).toString();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
