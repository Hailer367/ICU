package G0;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public interface a extends Future {
    void addListener(Runnable runnable, Executor executor);
}
