package H1;

import I.InterfaceC0071z;
import android.os.Bundle;
import android.util.Base64;
import f0.InterfaceC0284d;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import s.InterfaceC0625b;
import s2.C0641m;
import s2.InterfaceC0632d;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.x;

/* loaded from: classes.dex */
public final class f implements InterfaceC0071z, R0.a, InterfaceC0284d, InterfaceC0632d, InterfaceC0642n, InterfaceC0625b {

    /* renamed from: f, reason: collision with root package name */
    public static f f660f;

    /* renamed from: g, reason: collision with root package name */
    public static f f661g;

    /* renamed from: h, reason: collision with root package name */
    public static volatile f f662h;

    public /* synthetic */ f(Object obj) {
    }

    @Override // R0.a
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // s.InterfaceC0625b
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.browser.trusted.displaymode.KEY_ID", 0);
        return bundle;
    }

    public String c(List list) {
        T2.h.e(list, "list");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        T2.h.d(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    @Override // s2.InterfaceC0632d
    public void h(ByteBuffer byteBuffer, j2.g gVar) {
        x.f6165b.getClass();
        x.c(byteBuffer);
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        ((r2.i) interfaceC0643o).success(null);
    }

    @Override // f0.InterfaceC0284d
    public void k() {
    }

    @Override // f0.InterfaceC0284d
    public void m(int i4, Object obj) {
    }

    @Override // I.InterfaceC0071z
    public void onScrollLimit(int i4, int i5, int i6, boolean z) {
    }

    @Override // I.InterfaceC0071z
    public void onScrollProgress(int i4, int i5, int i6, int i7) {
    }
}
