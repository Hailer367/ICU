package a0;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* renamed from: a0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0069k implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f984g = new ThreadLocal();

    /* renamed from: h, reason: collision with root package name */
    public static final C0066h f985h = new Object();

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f986c;

    /* renamed from: d, reason: collision with root package name */
    public long f987d;

    /* renamed from: e, reason: collision with root package name */
    public long f988e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f989f;

    public final void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.f1942o && this.f987d == 0) {
            this.f987d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        C0067i c0067i = recyclerView.f1919V;
        c0067i.f976a = i2;
        c0067i.f977b = i3;
    }

    public final void b(long j2) {
        C0068j c0068j;
        RecyclerView recyclerView;
        ArrayList arrayList = this.f989f;
        ArrayList arrayList2 = this.f986c;
        int size = arrayList2.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView2 = (RecyclerView) arrayList2.get(i3);
            int windowVisibility = recyclerView2.getWindowVisibility();
            C0067i c0067i = recyclerView2.f1919V;
            if (windowVisibility == 0) {
                c0067i.f978c = 0;
                i2 += c0067i.f978c;
            }
        }
        arrayList.ensureCapacity(i2);
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList2.get(i4);
            if (recyclerView3.getWindowVisibility() == 0) {
                C0067i c0067i2 = recyclerView3.f1919V;
                Math.abs(c0067i2.f976a);
                Math.abs(c0067i2.f977b);
                if (c0067i2.f978c * 2 > 0) {
                    if (arrayList.size() <= 0) {
                        arrayList.add(new Object());
                    }
                    throw null;
                }
            }
        }
        Collections.sort(arrayList, f985h);
        if (arrayList.size() > 0 && (recyclerView = (c0068j = (C0068j) arrayList.get(0)).f982d) != null) {
            int i5 = c0068j.f983e;
            if (recyclerView.f1929f.h() <= 0) {
                C0053B c0053b = recyclerView.f1923c;
                try {
                    recyclerView.y++;
                    c0053b.a(i5);
                    throw null;
                } catch (Throwable th) {
                    int i6 = recyclerView.y - 1;
                    recyclerView.y = i6;
                    if (i6 < 1) {
                        recyclerView.y = 0;
                    }
                    throw th;
                }
            }
            RecyclerView.j(recyclerView.f1929f.g(0));
            throw null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f986c;
        try {
            int i2 = A.h.f6a;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long j2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i3);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j2) + this.f988e);
                }
            }
            this.f987d = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.f987d = 0L;
            int i4 = A.h.f6a;
            Trace.endSection();
            throw th;
        }
    }
}
