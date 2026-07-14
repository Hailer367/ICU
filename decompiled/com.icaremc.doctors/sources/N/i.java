package N;

/* loaded from: classes.dex */
public abstract /* synthetic */ class i {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f620a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static /* synthetic */ boolean a(int i2, int i3) {
        if (i2 != 0) {
            return i2 == i3;
        }
        throw null;
    }

    public static /* synthetic */ int b(int i2) {
        if (i2 != 0) {
            return i2 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] c(int i2) {
        int[] iArr = new int[i2];
        System.arraycopy(f620a, 0, iArr, 0, i2);
        return iArr;
    }
}
