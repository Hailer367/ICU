package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class KeyData {
    private static final int BYTES_PER_FIELD = 8;
    public static final String CHANNEL = "flutter/keydata";
    private static final int FIELD_COUNT = 6;
    private static final String TAG = "KeyData";
    String character;
    DeviceType deviceType;
    long logicalKey;
    long physicalKey;
    boolean synthesized;
    long timestamp;
    Type type;

    /* loaded from: classes.dex */
    public enum DeviceType {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);

        private final long value;

        DeviceType(long j2) {
            this.value = j2;
        }

        public static DeviceType fromLong(long j2) {
            int i2 = (int) j2;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                return kHdmi;
                            }
                            throw new AssertionError("Unexpected DeviceType value");
                        }
                        return kJoystick;
                    }
                    return kGamepad;
                }
                return kDirectionalPad;
            }
            return kKeyboard;
        }

        public long getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        kDown(0),
        kUp(1),
        kRepeat(2);

        private long value;

        Type(long j2) {
            this.value = j2;
        }

        public static Type fromLong(long j2) {
            int i2 = (int) j2;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return kRepeat;
                    }
                    throw new AssertionError("Unexpected Type value");
                }
                return kUp;
            }
            return kDown;
        }

        public long getValue() {
            return this.value;
        }
    }

    public KeyData() {
    }

    public ByteBuffer toBytes() {
        byte[] bytes;
        int length;
        long j2;
        try {
            String str = this.character;
            if (str == null) {
                bytes = null;
            } else {
                bytes = str.getBytes("UTF-8");
            }
            if (bytes == null) {
                length = 0;
            } else {
                length = bytes.length;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 56);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.timestamp);
            allocateDirect.putLong(this.type.getValue());
            allocateDirect.putLong(this.physicalKey);
            allocateDirect.putLong(this.logicalKey);
            if (this.synthesized) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            allocateDirect.putLong(j2);
            allocateDirect.putLong(this.deviceType.getValue());
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }

    public KeyData(ByteBuffer byteBuffer) {
        long j2 = byteBuffer.getLong();
        this.timestamp = byteBuffer.getLong();
        this.type = Type.fromLong(byteBuffer.getLong());
        this.physicalKey = byteBuffer.getLong();
        this.logicalKey = byteBuffer.getLong();
        this.synthesized = byteBuffer.getLong() != 0;
        this.deviceType = DeviceType.fromLong(byteBuffer.getLong());
        if (byteBuffer.remaining() == j2) {
            this.character = null;
            if (j2 != 0) {
                int i2 = (int) j2;
                byte[] bArr = new byte[i2];
                byteBuffer.get(bArr, 0, i2);
                try {
                    this.character = new String(bArr, "UTF-8");
                    return;
                } catch (UnsupportedEncodingException unused) {
                    throw new AssertionError("UTF-8 unsupported");
                }
            }
            return;
        }
        throw new AssertionError(String.format("Unexpected char length: charSize is %d while buffer has position %d, capacity %d, limit %d", Long.valueOf(j2), Integer.valueOf(byteBuffer.position()), Integer.valueOf(byteBuffer.capacity()), Integer.valueOf(byteBuffer.limit())));
    }
}
