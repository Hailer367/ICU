package y1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public static final j f6584f;

    /* renamed from: g, reason: collision with root package name */
    public static final Handler f6585g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ j[] f6586h;

    /* JADX WARN: Type inference failed for: r0v0, types: [y1.j, java.lang.Enum] */
    static {
        ?? r02 = new Enum("INSTANCE", 0);
        f6584f = r02;
        f6586h = new j[]{r02};
        f6585g = new Handler(Looper.getMainLooper());
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f6586h.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f6585g.post(runnable);
    }
}
