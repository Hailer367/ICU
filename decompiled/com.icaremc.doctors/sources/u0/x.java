package u0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public static final x f3882c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ x[] f3883d;

    /* JADX WARN: Type inference failed for: r0v0, types: [u0.x, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [u0.x, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [u0.x, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [u0.x, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [u0.x, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [u0.x, java.lang.Enum, java.lang.Object] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f3882c = r02;
        ?? r1 = new Enum("UNMETERED_ONLY", 1);
        ?? r2 = new Enum("UNMETERED_OR_DAILY", 2);
        ?? r3 = new Enum("FAST_IF_RADIO_AWAKE", 3);
        ?? r4 = new Enum("NEVER", 4);
        ?? r5 = new Enum("UNRECOGNIZED", 5);
        f3883d = new x[]{r02, r1, r2, r3, r4, r5};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, r02);
        sparseArray.put(1, r1);
        sparseArray.put(2, r2);
        sparseArray.put(3, r3);
        sparseArray.put(4, r4);
        sparseArray.put(-1, r5);
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f3883d.clone();
    }
}
