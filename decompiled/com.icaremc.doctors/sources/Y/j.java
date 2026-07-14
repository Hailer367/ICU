package Y;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f871a;

    /* renamed from: b, reason: collision with root package name */
    public final int f872b;

    /* renamed from: c, reason: collision with root package name */
    public final long f873c;

    /* renamed from: d, reason: collision with root package name */
    public final long f874d;

    public j(int i2, int i3, long j2, long j3) {
        this.f871a = i2;
        this.f872b = i3;
        this.f873c = j2;
        this.f874d = j3;
    }

    public static j a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            j jVar = new j(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return jVar;
        } finally {
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f871a);
            dataOutputStream.writeInt(this.f872b);
            dataOutputStream.writeLong(this.f873c);
            dataOutputStream.writeLong(this.f874d);
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
        if (obj != null && (obj instanceof j)) {
            j jVar = (j) obj;
            if (this.f872b == jVar.f872b && this.f873c == jVar.f873c && this.f871a == jVar.f871a && this.f874d == jVar.f874d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f872b), Long.valueOf(this.f873c), Integer.valueOf(this.f871a), Long.valueOf(this.f874d));
    }
}
