package f0;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* renamed from: f0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0281a {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f3662a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0284d f3663b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3664c;

    /* renamed from: d, reason: collision with root package name */
    public final File f3665d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3666e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3667f = false;

    /* renamed from: g, reason: collision with root package name */
    public C0282b[] f3668g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f3669h;

    public C0281a(AssetManager assetManager, Executor executor, InterfaceC0284d interfaceC0284d, String str, File file) {
        byte[] bArr;
        this.f3662a = executor;
        this.f3663b = interfaceC0284d;
        this.f3666e = str;
        this.f3665d = file;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            bArr = AbstractC0285e.f3682d;
        } else {
            switch (i4) {
                case 24:
                case 25:
                    bArr = AbstractC0285e.f3686h;
                    break;
                case 26:
                    bArr = AbstractC0285e.f3685g;
                    break;
                case 27:
                    bArr = AbstractC0285e.f3684f;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = AbstractC0285e.f3683e;
                    break;
                default:
                    bArr = null;
                    break;
            }
        }
        this.f3664c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f3663b.k();
                return null;
            }
            return null;
        }
    }

    public final void b(int i4, Serializable serializable) {
        this.f3662a.execute(new e.j(this, i4, serializable, 2));
    }
}
