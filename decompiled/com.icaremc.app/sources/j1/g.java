package j1;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class g extends Binder implements IInterface {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5051f;

    public /* synthetic */ g(int i4) {
        this.f5051f = i4;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i4 = this.f5051f;
        return this;
    }

    public boolean h(int i4, Parcel parcel, Parcel parcel2) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        if (super.onTransact(r5, r6, r7, r8) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        if (super.onTransact(r5, r6, r7, r8) != false) goto L7;
     */
    @Override // android.os.Binder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.g.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }

    public g(String str) {
        this.f5051f = 0;
        attachInterface(this, str);
    }
}
