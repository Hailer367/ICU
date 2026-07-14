package io.flutter.plugins.sharedpreferences;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MessagesAsyncPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b2, ByteBuffer buffer) {
        List<? extends Object> list;
        List<? extends Object> list2;
        h.e(buffer, "buffer");
        if (b2 == -127) {
            Long l2 = (Long) readValue(buffer);
            if (l2 == null) {
                return null;
            }
            return StringListLookupResultType.Companion.ofRaw((int) l2.longValue());
        }
        if (b2 == -126) {
            Object readValue = readValue(buffer);
            if (readValue instanceof List) {
                list2 = (List) readValue;
            } else {
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            return SharedPreferencesPigeonOptions.Companion.fromList(list2);
        }
        if (b2 == -125) {
            Object readValue2 = readValue(buffer);
            if (readValue2 instanceof List) {
                list = (List) readValue2;
            } else {
                list = null;
            }
            if (list == null) {
                return null;
            }
            return StringListResult.Companion.fromList(list);
        }
        return super.readValueOfType(b2, buffer);
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        h.e(stream, "stream");
        if (obj instanceof StringListLookupResultType) {
            stream.write(129);
            writeValue(stream, Long.valueOf(((StringListLookupResultType) obj).getRaw()));
        } else if (obj instanceof SharedPreferencesPigeonOptions) {
            stream.write(130);
            writeValue(stream, ((SharedPreferencesPigeonOptions) obj).toList());
        } else if (obj instanceof StringListResult) {
            stream.write(131);
            writeValue(stream, ((StringListResult) obj).toList());
        } else {
            super.writeValue(stream, obj);
        }
    }
}
