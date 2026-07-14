package io.flutter.plugins.imagepicker;

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
        List<? extends Object> list3;
        List<? extends Object> list4;
        List<? extends Object> list5;
        List<? extends Object> list6;
        List<? extends Object> list7;
        h.e(buffer, "buffer");
        if (b2 == -127) {
            Long l2 = (Long) readValue(buffer);
            if (l2 == null) {
                return null;
            }
            return SourceCamera.Companion.ofRaw((int) l2.longValue());
        }
        if (b2 == -126) {
            Long l3 = (Long) readValue(buffer);
            if (l3 == null) {
                return null;
            }
            return SourceType.Companion.ofRaw((int) l3.longValue());
        }
        if (b2 == -125) {
            Long l4 = (Long) readValue(buffer);
            if (l4 == null) {
                return null;
            }
            return CacheRetrievalType.Companion.ofRaw((int) l4.longValue());
        }
        if (b2 == -124) {
            Object readValue = readValue(buffer);
            if (readValue instanceof List) {
                list7 = (List) readValue;
            } else {
                list7 = null;
            }
            if (list7 == null) {
                return null;
            }
            return GeneralOptions.Companion.fromList(list7);
        }
        if (b2 == -123) {
            Object readValue2 = readValue(buffer);
            if (readValue2 instanceof List) {
                list6 = (List) readValue2;
            } else {
                list6 = null;
            }
            if (list6 == null) {
                return null;
            }
            return ImageSelectionOptions.Companion.fromList(list6);
        }
        if (b2 == -122) {
            Object readValue3 = readValue(buffer);
            if (readValue3 instanceof List) {
                list5 = (List) readValue3;
            } else {
                list5 = null;
            }
            if (list5 == null) {
                return null;
            }
            return MediaSelectionOptions.Companion.fromList(list5);
        }
        if (b2 == -121) {
            Object readValue4 = readValue(buffer);
            if (readValue4 instanceof List) {
                list4 = (List) readValue4;
            } else {
                list4 = null;
            }
            if (list4 == null) {
                return null;
            }
            return VideoSelectionOptions.Companion.fromList(list4);
        }
        if (b2 == -120) {
            Object readValue5 = readValue(buffer);
            if (readValue5 instanceof List) {
                list3 = (List) readValue5;
            } else {
                list3 = null;
            }
            if (list3 == null) {
                return null;
            }
            return SourceSpecification.Companion.fromList(list3);
        }
        if (b2 == -119) {
            Object readValue6 = readValue(buffer);
            if (readValue6 instanceof List) {
                list2 = (List) readValue6;
            } else {
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            return CacheRetrievalError.Companion.fromList(list2);
        }
        if (b2 == -118) {
            Object readValue7 = readValue(buffer);
            if (readValue7 instanceof List) {
                list = (List) readValue7;
            } else {
                list = null;
            }
            if (list == null) {
                return null;
            }
            return CacheRetrievalResult.Companion.fromList(list);
        }
        return super.readValueOfType(b2, buffer);
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        h.e(stream, "stream");
        if (obj instanceof SourceCamera) {
            stream.write(129);
            writeValue(stream, Long.valueOf(((SourceCamera) obj).getRaw()));
            return;
        }
        if (obj instanceof SourceType) {
            stream.write(130);
            writeValue(stream, Long.valueOf(((SourceType) obj).getRaw()));
            return;
        }
        if (obj instanceof CacheRetrievalType) {
            stream.write(131);
            writeValue(stream, Long.valueOf(((CacheRetrievalType) obj).getRaw()));
            return;
        }
        if (obj instanceof GeneralOptions) {
            stream.write(132);
            writeValue(stream, ((GeneralOptions) obj).toList());
            return;
        }
        if (obj instanceof ImageSelectionOptions) {
            stream.write(133);
            writeValue(stream, ((ImageSelectionOptions) obj).toList());
            return;
        }
        if (obj instanceof MediaSelectionOptions) {
            stream.write(134);
            writeValue(stream, ((MediaSelectionOptions) obj).toList());
            return;
        }
        if (obj instanceof VideoSelectionOptions) {
            stream.write(135);
            writeValue(stream, ((VideoSelectionOptions) obj).toList());
            return;
        }
        if (obj instanceof SourceSpecification) {
            stream.write(136);
            writeValue(stream, ((SourceSpecification) obj).toList());
        } else if (obj instanceof CacheRetrievalError) {
            stream.write(137);
            writeValue(stream, ((CacheRetrievalError) obj).toList());
        } else if (obj instanceof CacheRetrievalResult) {
            stream.write(138);
            writeValue(stream, ((CacheRetrievalResult) obj).toList());
        } else {
            super.writeValue(stream, obj);
        }
    }
}
