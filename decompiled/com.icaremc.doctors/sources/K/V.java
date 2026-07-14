package K;

import com.google.firebase.encoders.json.BuildConfig;
import java.io.File;
import java.math.BigInteger;

/* loaded from: classes.dex */
public final class V extends kotlin.jvm.internal.i implements c1.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f427c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f428d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ V(int i2, Object obj) {
        super(0);
        this.f427c = i2;
        this.f428d = obj;
    }

    @Override // c1.a
    public final Object invoke() {
        switch (this.f427c) {
            case 0:
                Object obj = W.f430d;
                File file = (File) this.f428d;
                synchronized (obj) {
                    W.f429c.remove(file.getAbsolutePath());
                }
                return Q0.j.f722a;
            case 1:
                File file2 = (File) ((M.a) this.f428d).invoke();
                String name = file2.getName();
                kotlin.jvm.internal.h.d(name, "getName(...)");
                String str = BuildConfig.FLAVOR;
                int lastIndexOf = name.lastIndexOf(46, k1.h.N(name));
                if (lastIndexOf != -1) {
                    str = name.substring(lastIndexOf + 1, name.length());
                    kotlin.jvm.internal.h.d(str, "substring(...)");
                }
                if (str.equals("preferences_pb")) {
                    File absoluteFile = file2.getAbsoluteFile();
                    kotlin.jvm.internal.h.d(absoluteFile, "file.absoluteFile");
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file2 + " does not match required extension for Preferences file: preferences_pb").toString());
            case 2:
                return androidx.lifecycle.S.e((androidx.lifecycle.d0) this.f428d);
            default:
                i0.h hVar = (i0.h) this.f428d;
                return BigInteger.valueOf(hVar.f2348c).shiftLeft(32).or(BigInteger.valueOf(hVar.f2349d)).shiftLeft(32).or(BigInteger.valueOf(hVar.f2350e));
        }
    }
}
