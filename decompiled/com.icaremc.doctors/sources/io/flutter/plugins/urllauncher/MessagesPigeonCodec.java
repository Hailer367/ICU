package io.flutter.plugins.urllauncher;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MessagesPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b2, ByteBuffer buffer) {
        List<? extends Object> list;
        List<? extends Object> list2;
        h.e(buffer, "buffer");
        if (b2 == -127) {
            Object readValue = readValue(buffer);
            if (readValue instanceof List) {
                list2 = (List) readValue;
            } else {
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            return WebViewOptions.Companion.fromList(list2);
        }
        if (b2 == -126) {
            Object readValue2 = readValue(buffer);
            if (readValue2 instanceof List) {
                list = (List) readValue2;
            } else {
                list = null;
            }
            if (list == null) {
                return null;
            }
            return BrowserOptions.Companion.fromList(list);
        }
        return super.readValueOfType(b2, buffer);
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        h.e(stream, "stream");
        if (obj instanceof WebViewOptions) {
            stream.write(129);
            writeValue(stream, ((WebViewOptions) obj).toList());
        } else if (obj instanceof BrowserOptions) {
            stream.write(130);
            writeValue(stream, ((BrowserOptions) obj).toList());
        } else {
            super.writeValue(stream, obj);
        }
    }
}
