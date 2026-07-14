package f0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f3692a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3693b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3694c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3695d;

    public i(int i4, int i5, long j4, long j5) {
        this.f3692a = i4;
        this.f3693b = i5;
        this.f3694c = j4;
        this.f3695d = j5;
    }

    public static i a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            i iVar = new i(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return iVar;
        } finally {
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f3692a);
            dataOutputStream.writeInt(this.f3693b);
            dataOutputStream.writeLong(this.f3694c);
            dataOutputStream.writeLong(this.f3695d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof i)) {
            i iVar = (i) obj;
            if (this.f3693b == iVar.f3693b && this.f3694c == iVar.f3694c && this.f3692a == iVar.f3692a && this.f3695d == iVar.f3695d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3693b), Long.valueOf(this.f3694c), Integer.valueOf(this.f3692a), Long.valueOf(this.f3695d));
    }
}
