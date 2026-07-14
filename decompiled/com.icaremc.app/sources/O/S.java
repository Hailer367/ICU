package O;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import r0.C0619a;

/* loaded from: classes.dex */
public final class S extends T2.i implements S2.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1138g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1139h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ S(int i4, Object obj) {
        super(0);
        this.f1138g = i4;
        this.f1139h = obj;
    }

    @Override // S2.a
    public final Object a() {
        boolean z;
        switch (this.f1138g) {
            case 0:
                Object obj = T.f1141d;
                File file = (File) this.f1139h;
                synchronized (obj) {
                    T.f1140c.remove(file.getAbsolutePath());
                }
                return H2.i.f681a;
            case 1:
                File file2 = (File) ((Q.a) this.f1139h).a();
                String name = file2.getName();
                T2.h.d(name, "getName(...)");
                String str = "";
                int lastIndexOf = name.lastIndexOf(46, a3.h.C(name));
                if (lastIndexOf != -1) {
                    str = name.substring(lastIndexOf + 1, name.length());
                    T2.h.d(str, "substring(...)");
                }
                if (str.equals("preferences_pb")) {
                    File absoluteFile = file2.getAbsoluteFile();
                    T2.h.d(absoluteFile, "file.absoluteFile");
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file2 + " does not match required extension for Preferences file: preferences_pb").toString());
            case 2:
                return androidx.lifecycle.M.e((androidx.lifecycle.Y) this.f1139h);
            case 3:
                C0619a c0619a = (C0619a) this.f1139h;
                Class<?> loadClass = c0619a.f6015a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                T2.h.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                Method declaredMethod = loadClass.getDeclaredMethod("getWindowExtensions", null);
                Class<?> loadClass2 = c0619a.f6015a.loadClass("androidx.window.extensions.WindowExtensions");
                T2.h.d(loadClass2, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                T2.h.d(declaredMethod, "getWindowExtensionsMethod");
                if (declaredMethod.getReturnType().equals(loadClass2) && Modifier.isPublic(declaredMethod.getModifiers())) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                s0.h hVar = (s0.h) this.f1139h;
                return BigInteger.valueOf(hVar.f6141f).shiftLeft(32).or(BigInteger.valueOf(hVar.f6142g)).shiftLeft(32).or(BigInteger.valueOf(hVar.f6143h));
        }
    }
}
