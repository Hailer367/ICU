package h0;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* renamed from: h0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0322j implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public static final ThreadLocal f3908j = new ThreadLocal();
    public static final V1.k k = new V1.k(1);

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3909f;

    /* renamed from: g, reason: collision with root package name */
    public long f3910g;

    /* renamed from: h, reason: collision with root package name */
    public long f3911h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f3912i;

    public final void a(RecyclerView recyclerView, int i4, int i5) {
        if (recyclerView.f3125r && this.f3910g == 0) {
            this.f3910g = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        C0320h c0320h = recyclerView.f3103b0;
        c0320h.f3900a = i4;
        c0320h.f3901b = i5;
    }

    public final void b(long j4) {
        C0321i c0321i;
        RecyclerView recyclerView;
        ArrayList arrayList = this.f3912i;
        ArrayList arrayList2 = this.f3909f;
        int size = arrayList2.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = (RecyclerView) arrayList2.get(i5);
            int windowVisibility = recyclerView2.getWindowVisibility();
            C0320h c0320h = recyclerView2.f3103b0;
            if (windowVisibility == 0) {
                c0320h.f3902c = 0;
                i4 += c0320h.f3902c;
            }
        }
        arrayList.ensureCapacity(i4);
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList2.get(i6);
            if (recyclerView3.getWindowVisibility() == 0) {
                C0320h c0320h2 = recyclerView3.f3103b0;
                Math.abs(c0320h2.f3900a);
                Math.abs(c0320h2.f3901b);
                if (c0320h2.f3902c * 2 > 0) {
                    if (arrayList.size() <= 0) {
                        arrayList.add(new Object());
                    }
                    throw null;
                }
            }
        }
        Collections.sort(arrayList, k);
        if (arrayList.size() > 0 && (recyclerView = (c0321i = (C0321i) arrayList.get(0)).f3906d) != null) {
            int i7 = c0321i.f3907e;
            if (recyclerView.f3113i.L() <= 0) {
                C0298A c0298a = recyclerView.f3107f;
                try {
                    recyclerView.f3081B++;
                    c0298a.a(i7);
                    throw null;
                } catch (Throwable th) {
                    int i8 = recyclerView.f3081B - 1;
                    recyclerView.f3081B = i8;
                    if (i8 < 1) {
                        recyclerView.f3081B = 0;
                    }
                    throw th;
                }
            }
            RecyclerView.j(recyclerView.f3113i.K(0));
            throw null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f3909f;
        try {
            int i4 = E.g.f456a;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long j4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i5);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j4 = Math.max(recyclerView.getDrawingTime(), j4);
                    }
                }
                if (j4 != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j4) + this.f3911h);
                }
            }
            this.f3910g = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.f3910g = 0L;
            int i6 = E.g.f456a;
            Trace.endSection();
            throw th;
        }
    }
}
