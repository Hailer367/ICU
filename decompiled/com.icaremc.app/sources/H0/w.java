package H0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    public static final w f644f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ w[] f645g;

    /* JADX WARN: Type inference failed for: r0v0, types: [H0.w, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [H0.w, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [H0.w, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [H0.w, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [H0.w, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [H0.w, java.lang.Enum, java.lang.Object] */
    static {
        ?? r02 = new Enum("DEFAULT", 0);
        f644f = r02;
        ?? r12 = new Enum("UNMETERED_ONLY", 1);
        ?? r22 = new Enum("UNMETERED_OR_DAILY", 2);
        ?? r3 = new Enum("FAST_IF_RADIO_AWAKE", 3);
        ?? r4 = new Enum("NEVER", 4);
        ?? r5 = new Enum("UNRECOGNIZED", 5);
        f645g = new w[]{r02, r12, r22, r3, r4, r5};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, r02);
        sparseArray.put(1, r12);
        sparseArray.put(2, r22);
        sparseArray.put(3, r3);
        sparseArray.put(4, r4);
        sparseArray.put(-1, r5);
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f645g.clone();
    }
}
