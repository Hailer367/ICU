package n0;

import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.h;
import l0.i;
import l0.k;

/* loaded from: classes.dex */
public final class f implements D.a, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3302a;

    /* renamed from: c, reason: collision with root package name */
    public k f3304c;

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantLock f3303b = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f3305d = new LinkedHashSet();

    public f(Context context) {
        this.f3302a = context;
    }

    @Override // D.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo value) {
        h.e(value, "value");
        ReentrantLock reentrantLock = this.f3303b;
        reentrantLock.lock();
        try {
            this.f3304c = e.b(this.f3302a, value);
            Iterator it = this.f3305d.iterator();
            while (it.hasNext()) {
                ((D.a) it.next()).accept(this.f3304c);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(i iVar) {
        ReentrantLock reentrantLock = this.f3303b;
        reentrantLock.lock();
        try {
            k kVar = this.f3304c;
            if (kVar != null) {
                iVar.accept(kVar);
            }
            this.f3305d.add(iVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
