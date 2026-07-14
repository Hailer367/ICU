package s2;

import P1.y;
import android.util.Log;
import java.nio.ByteBuffer;

/* renamed from: s2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0629a implements InterfaceC0633e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6146a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6147b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6148c;

    public /* synthetic */ C0629a(int i4, Object obj, Object obj2) {
        this.f6146a = i4;
        this.f6148c = obj;
        this.f6147b = obj2;
    }

    @Override // s2.InterfaceC0633e
    public final void a(ByteBuffer byteBuffer) {
        switch (this.f6146a) {
            case 0:
                y yVar = (y) this.f6148c;
                try {
                    ((InterfaceC0631c) this.f6147b).t(((InterfaceC0640l) yVar.f1471h).b(byteBuffer));
                    return;
                } catch (RuntimeException e4) {
                    Log.e("BasicMessageChannel#" + ((String) yVar.f1469f), "Failed to handle message reply", e4);
                    return;
                }
            default:
                C0644p c0644p = (C0644p) this.f6148c;
                InterfaceC0643o interfaceC0643o = (InterfaceC0643o) this.f6147b;
                try {
                    if (byteBuffer == null) {
                        interfaceC0643o.notImplemented();
                    } else {
                        try {
                            interfaceC0643o.success(c0644p.f6159c.e(byteBuffer));
                        } catch (C0637i e5) {
                            interfaceC0643o.error(e5.f6151f, e5.getMessage(), e5.f6152g);
                        }
                    }
                    return;
                } catch (RuntimeException e6) {
                    Log.e("MethodChannel#" + c0644p.f6158b, "Failed to handle method call result", e6);
                    return;
                }
        }
    }
}
