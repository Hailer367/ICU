package com.google.firebase.util;

import R0.j;
import R0.l;
import com.google.firebase.encoders.json.BuildConfig;
import f1.d;
import h1.a;
import h1.b;
import h1.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class RandomUtilKt {
    private static final String ALPHANUMERIC_ALPHABET = "23456789abcdefghjkmnpqrstvwxyz";

    private static /* synthetic */ void getALPHANUMERIC_ALPHABET$annotations() {
    }

    public static final String nextAlphanumericString(d dVar, int i2) {
        a aVar;
        h.e(dVar, "<this>");
        if (i2 >= 0) {
            if (i2 <= Integer.MIN_VALUE) {
                aVar = c.f2328f;
            } else {
                aVar = new a(0, i2 - 1, 1);
            }
            ArrayList arrayList = new ArrayList(l.O(aVar));
            Iterator it = aVar.iterator();
            while (((b) it).f2326e) {
                ((b) it).nextInt();
                arrayList.add(Character.valueOf(ALPHANUMERIC_ALPHABET.charAt(dVar.a(30))));
            }
            return j.S(arrayList, BuildConfig.FLAVOR, null, null, null, 62);
        }
        throw new IllegalArgumentException(O.a.c(i2, "invalid length: ").toString());
    }
}
