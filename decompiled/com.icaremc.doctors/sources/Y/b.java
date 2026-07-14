package Y;

import android.content.res.AssetManager;
import android.os.Build;
import io.flutter.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f841a;

    /* renamed from: b, reason: collision with root package name */
    public final e f842b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f843c;

    /* renamed from: d, reason: collision with root package name */
    public final File f844d;

    /* renamed from: e, reason: collision with root package name */
    public final String f845e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f846f = false;

    /* renamed from: g, reason: collision with root package name */
    public c[] f847g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f848h;

    public b(AssetManager assetManager, Executor executor, e eVar, String str, File file) {
        byte[] bArr;
        this.f841a = executor;
        this.f842b = eVar;
        this.f845e = str;
        this.f844d = file;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            bArr = f.f861d;
        } else {
            switch (i2) {
                case 24:
                case Build.API_LEVELS.API_25 /* 25 */:
                    bArr = f.f865h;
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    bArr = f.f864g;
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    bArr = f.f863f;
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                case Build.API_LEVELS.API_29 /* 29 */:
                case Build.API_LEVELS.API_30 /* 30 */:
                    bArr = f.f862e;
                    break;
                default:
                    bArr = null;
                    break;
            }
        }
        this.f843c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f842b.e();
                return null;
            }
            return null;
        }
    }

    public final void b(int i2, Serializable serializable) {
        this.f841a.execute(new a(this, i2, serializable, 0));
    }
}
