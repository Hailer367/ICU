package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2993a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f2994b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f2995c = false;

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public void b() {
    }
}
