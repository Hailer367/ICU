package y2;

import android.content.ComponentName;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f6630a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6631b;

    /* renamed from: c, reason: collision with root package name */
    public int f6632c;

    public o(ComponentName componentName) {
        this.f6630a = componentName;
    }

    public abstract void a(Intent intent);

    public final void b(int i4) {
        if (!this.f6631b) {
            this.f6631b = true;
            this.f6632c = i4;
        } else {
            if (this.f6632c == i4) {
                return;
            }
            throw new IllegalArgumentException("Given job ID " + i4 + " is different than previous " + this.f6632c);
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
