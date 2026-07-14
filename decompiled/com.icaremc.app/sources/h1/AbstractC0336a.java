package h1;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: h1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0336a implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    public final IBinder f3941f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3942g;

    public AbstractC0336a(IBinder iBinder, String str) {
        this.f3941f = iBinder;
        this.f3942g = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3941f;
    }
}
