package a0;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;

/* renamed from: a0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0066h implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        boolean z;
        boolean z2;
        C0068j c0068j = (C0068j) obj;
        C0068j c0068j2 = (C0068j) obj2;
        RecyclerView recyclerView = c0068j.f982d;
        if (recyclerView == null) {
            z = true;
        } else {
            z = false;
        }
        if (c0068j2.f982d == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            if (recyclerView != null) {
                return -1;
            }
        } else {
            boolean z3 = c0068j.f979a;
            if (z3 != c0068j2.f979a) {
                if (z3) {
                    return -1;
                }
            } else {
                int i2 = c0068j2.f980b - c0068j.f980b;
                if (i2 != 0) {
                    return i2;
                }
                int i3 = c0068j.f981c - c0068j2.f981c;
                if (i3 == 0) {
                    return 0;
                }
                return i3;
            }
        }
        return 1;
    }
}
