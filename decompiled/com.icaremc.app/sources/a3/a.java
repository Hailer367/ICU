package a3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class a implements Iterator, U2.a {

    /* renamed from: f, reason: collision with root package name */
    public final String f2219f;

    /* renamed from: g, reason: collision with root package name */
    public int f2220g;

    /* renamed from: h, reason: collision with root package name */
    public int f2221h;

    /* renamed from: i, reason: collision with root package name */
    public int f2222i;

    /* renamed from: j, reason: collision with root package name */
    public int f2223j;

    public a(String str) {
        this.f2219f = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i4;
        int i5 = this.f2220g;
        if (i5 != 0) {
            if (i5 != 1) {
                return false;
            }
            return true;
        }
        int i6 = 2;
        if (this.f2223j < 0) {
            this.f2220g = 2;
            return false;
        }
        String str = this.f2219f;
        int length = str.length();
        int length2 = str.length();
        for (int i7 = this.f2221h; i7 < length2; i7++) {
            char charAt = str.charAt(i7);
            if (charAt == '\n' || charAt == '\r') {
                if (charAt != '\r' || (i4 = i7 + 1) >= str.length() || str.charAt(i4) != '\n') {
                    i6 = 1;
                }
                length = i7;
                this.f2220g = 1;
                this.f2223j = i6;
                this.f2222i = length;
                return true;
            }
        }
        i6 = -1;
        this.f2220g = 1;
        this.f2223j = i6;
        this.f2222i = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f2220g = 0;
            int i4 = this.f2222i;
            int i5 = this.f2221h;
            this.f2221h = this.f2223j + i4;
            return this.f2219f.subSequence(i5, i4).toString();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
