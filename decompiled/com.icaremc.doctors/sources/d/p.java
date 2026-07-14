package d;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class p {
    private boolean isEnabled;
    private final List<o> eventHandlers = new ArrayList();
    private final CopyOnWriteArrayList<AutoCloseable> closeables = new CopyOnWriteArrayList<>();

    public p(boolean z) {
        this.isEnabled = z;
    }

    public final void addCloseable$activity(AutoCloseable closeable) {
        kotlin.jvm.internal.h.e(closeable, "closeable");
        this.closeables.add(closeable);
    }

    public final o createNavigationEventHandler$activity(W.e info) {
        kotlin.jvm.internal.h.e(info, "info");
        o oVar = new o(this, info);
        this.eventHandlers.add(oVar);
        return oVar;
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(C0172a backEvent) {
        kotlin.jvm.internal.h.e(backEvent, "backEvent");
    }

    public void handleOnBackStarted(C0172a backEvent) {
        kotlin.jvm.internal.h.e(backEvent, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        boolean isTerminated;
        Iterator<AutoCloseable> it = this.closeables.iterator();
        kotlin.jvm.internal.h.d(it, "iterator(...)");
        while (it.hasNext()) {
            AutoCloseable next = it.next();
            if (next instanceof AutoCloseable) {
                next.close();
            } else if (next instanceof ExecutorService) {
                ExecutorService executorService = (ExecutorService) next;
                if (executorService != ForkJoinPool.commonPool() && !(isTerminated = executorService.isTerminated())) {
                    executorService.shutdown();
                    boolean z = false;
                    while (!isTerminated) {
                        try {
                            isTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                        } catch (InterruptedException unused) {
                            if (!z) {
                                executorService.shutdownNow();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (next instanceof TypedArray) {
                ((TypedArray) next).recycle();
            } else if (next instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) next).release();
            } else if (next instanceof MediaDrm) {
                ((MediaDrm) next).release();
            } else {
                throw new IllegalArgumentException();
            }
        }
        this.closeables.clear();
        Iterator<o> it2 = this.eventHandlers.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.eventHandlers.clear();
    }

    public final void removeCloseable$activity(AutoCloseable closeable) {
        kotlin.jvm.internal.h.e(closeable, "closeable");
        this.closeables.remove(closeable);
    }

    public final void setEnabled(boolean z) {
        boolean z2;
        W.g gVar;
        this.isEnabled = z;
        for (o oVar : this.eventHandlers) {
            if (oVar.f2146g && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (oVar.f2143d != z2) {
                oVar.f2143d = z2;
                W.c cVar = oVar.f2144e;
                if (cVar != null && (gVar = cVar.f795b) != null) {
                    gVar.b();
                }
            }
        }
    }

    public void handleOnBackCancelled() {
    }
}
