package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class X {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1821a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f1822b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f1823c = false;

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void b() {
    }
}
