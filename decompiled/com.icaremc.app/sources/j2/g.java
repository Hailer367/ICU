package j2;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import s2.InterfaceC0633e;

/* loaded from: classes.dex */
public final class g implements InterfaceC0633e {

    /* renamed from: a, reason: collision with root package name */
    public final FlutterJNI f5071a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5072b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f5073c = new AtomicBoolean(false);

    public g(FlutterJNI flutterJNI, int i4) {
        this.f5071a = flutterJNI;
        this.f5072b = i4;
    }

    @Override // s2.InterfaceC0633e
    public final void a(ByteBuffer byteBuffer) {
        if (!this.f5073c.getAndSet(true)) {
            int i4 = this.f5072b;
            FlutterJNI flutterJNI = this.f5071a;
            if (byteBuffer == null) {
                flutterJNI.invokePlatformMessageEmptyResponseCallback(i4);
                return;
            } else {
                flutterJNI.invokePlatformMessageResponseCallback(i4, byteBuffer, byteBuffer.position());
                return;
            }
        }
        throw new IllegalStateException("Reply already submitted");
    }
}
