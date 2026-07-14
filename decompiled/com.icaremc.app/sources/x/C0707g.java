package x;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* renamed from: x.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0707g {

    /* renamed from: a, reason: collision with root package name */
    public final IconCompat f6357a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f6358b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f6359c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6360d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f6361e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f6362f;

    /* renamed from: g, reason: collision with root package name */
    public int f6363g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6364h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6365i;

    public C0707g(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        this.f6360d = true;
        this.f6364h = true;
        this.f6357a = iconCompat;
        this.f6358b = C0712l.b(charSequence);
        this.f6359c = pendingIntent;
        this.f6361e = bundle;
        this.f6362f = null;
        this.f6360d = true;
        this.f6363g = 0;
        this.f6364h = true;
        this.f6365i = false;
    }

    public final C0708h a() {
        K[] kArr;
        CharSequence[] charSequenceArr;
        if (!this.f6365i || this.f6359c != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = this.f6362f;
            if (arrayList3 != null) {
                int size = arrayList3.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList3.get(i4);
                    i4++;
                    K k = (K) obj;
                    if (!k.f6339c && (((charSequenceArr = k.f6338b) == null || charSequenceArr.length == 0) && !k.f6341e.isEmpty())) {
                        arrayList.add(k);
                    } else {
                        arrayList2.add(k);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
            }
            if (arrayList2.isEmpty()) {
                kArr = null;
            } else {
                kArr = (K[]) arrayList2.toArray(new K[arrayList2.size()]);
            }
            return new C0708h(this.f6357a, this.f6358b, this.f6359c, this.f6361e, kArr, this.f6360d, this.f6363g, this.f6364h, this.f6365i);
        }
        throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
    }
}
