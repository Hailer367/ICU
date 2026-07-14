package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.Log;
import io.flutter.embedding.android.KeyData;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.android.KeyboardMap;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class KeyEmbedderResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyEmbedderResponder";
    private final BinaryMessenger messenger;
    private final HashMap<Long, Long> pressingRecords = new HashMap<>();
    private final HashMap<Long, KeyboardMap.TogglingGoal> togglingGoals = new HashMap<>();
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();

    /* renamed from: io.flutter.embedding.android.KeyEmbedderResponder$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$KeyData$Type;

        static {
            int[] iArr = new int[KeyData.Type.values().length];
            $SwitchMap$io$flutter$embedding$android$KeyData$Type = iArr;
            try {
                iArr[KeyData.Type.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$KeyData$Type[KeyData.Type.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$KeyData$Type[KeyData.Type.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public KeyEmbedderResponder(BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        for (KeyboardMap.TogglingGoal togglingGoal : KeyboardMap.getTogglingGoals()) {
            this.togglingGoals.put(Long.valueOf(togglingGoal.logicalKey), togglingGoal);
        }
    }

    private static KeyData.Type getEventType(KeyEvent keyEvent) {
        boolean z;
        if (keyEvent.getRepeatCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        int action = keyEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                return KeyData.Type.kUp;
            }
            throw new AssertionError("Unexpected event type");
        }
        if (z) {
            return KeyData.Type.kRepeat;
        }
        return KeyData.Type.kDown;
    }

    private Long getLogicalKey(KeyEvent keyEvent) {
        Long l2 = KeyboardMap.keyCodeToLogical.get(Long.valueOf(keyEvent.getKeyCode()));
        if (l2 != null) {
            return l2;
        }
        return Long.valueOf(keyOfPlane(keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
    }

    private Long getPhysicalKey(KeyEvent keyEvent) {
        long scanCode = keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(keyOfPlane(keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
        }
        Long l2 = KeyboardMap.scanCodeToPhysical.get(Long.valueOf(scanCode));
        if (l2 != null) {
            return l2;
        }
        return Long.valueOf(keyOfPlane(keyEvent.getScanCode(), KeyboardMap.kAndroidPlane));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013a A[LOOP:2: B:62:0x0138->B:63:0x013a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean handleEventImpl(android.view.KeyEvent r16, io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback r17) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.handleEventImpl(android.view.KeyEvent, io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback):boolean");
    }

    private static long keyOfPlane(long j2, long j3) {
        return (j2 & KeyboardMap.kValueMask) | j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendKeyEvent$2(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, ByteBuffer byteBuffer) {
        boolean z;
        Boolean bool = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                if (byteBuffer.get() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            }
        } else {
            Log.w(TAG, "A null reply was received when sending a key event to the framework.");
        }
        onKeyEventHandledCallback.onKeyEventHandled(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$0(KeyboardMap.KeyPair keyPair, long j2, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j2), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$1(KeyboardMap.KeyPair keyPair, long j2, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j2), keyEvent.getEventTime());
    }

    private void sendKeyEvent(KeyData keyData, final KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        BinaryMessenger.BinaryReply binaryReply;
        if (onKeyEventHandledCallback == null) {
            binaryReply = null;
        } else {
            binaryReply = new BinaryMessenger.BinaryReply() { // from class: io.flutter.embedding.android.d
                @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
                public final void reply(ByteBuffer byteBuffer) {
                    KeyEmbedderResponder.lambda$sendKeyEvent$2(KeyboardManager.Responder.OnKeyEventHandledCallback.this, byteBuffer);
                }
            };
        }
        this.messenger.send(KeyData.CHANNEL, keyData.toBytes(), binaryReply);
    }

    private void synthesizeEvent(boolean z, Long l2, Long l3, long j2) {
        KeyData.Type type;
        KeyData keyData = new KeyData();
        keyData.timestamp = j2;
        if (z) {
            type = KeyData.Type.kDown;
        } else {
            type = KeyData.Type.kUp;
        }
        keyData.type = type;
        keyData.logicalKey = l2.longValue();
        keyData.physicalKey = l3.longValue();
        keyData.character = null;
        keyData.synthesized = true;
        keyData.deviceType = KeyData.DeviceType.kKeyboard;
        if (l3.longValue() != 0 && l2.longValue() != 0) {
            if (!z) {
                l2 = null;
            }
            updatePressingState(l3, l2);
        }
        sendKeyEvent(keyData, null);
    }

    public Map<Long, Long> getPressedState() {
        return Collections.unmodifiableMap(this.pressingRecords);
    }

    @Override // io.flutter.embedding.android.KeyboardManager.Responder
    public void handleEvent(KeyEvent keyEvent, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        if (!handleEventImpl(keyEvent, onKeyEventHandledCallback)) {
            synthesizeEvent(true, 0L, 0L, 0L);
            onKeyEventHandledCallback.onKeyEventHandled(true);
        }
    }

    public void synchronizePressingKey(KeyboardMap.PressingGoal pressingGoal, boolean z, long j2, long j3, KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        KeyboardMap.KeyPair[] keyPairArr = pressingGoal.keys;
        boolean[] zArr = new boolean[keyPairArr.length];
        Boolean[] boolArr = new Boolean[keyPairArr.length];
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            KeyboardMap.KeyPair[] keyPairArr2 = pressingGoal.keys;
            boolean z3 = true;
            if (i2 >= keyPairArr2.length) {
                break;
            }
            KeyboardMap.KeyPair keyPair = keyPairArr2[i2];
            boolean containsKey = this.pressingRecords.containsKey(Long.valueOf(keyPair.physicalKey));
            zArr[i2] = containsKey;
            if (keyPair.logicalKey == j2) {
                int i3 = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$KeyData$Type[getEventType(keyEvent).ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            if (!z) {
                                arrayList.add(new e(this, keyPair, j3, keyEvent, 1));
                            }
                            boolArr[i2] = Boolean.valueOf(zArr[i2]);
                        }
                    } else {
                        boolArr[i2] = Boolean.valueOf(zArr[i2]);
                    }
                    i2++;
                } else {
                    boolArr[i2] = Boolean.FALSE;
                    if (!z) {
                        arrayList.add(new e(this, keyPair, j3, keyEvent, 0));
                    }
                }
            } else if (!z2 && !containsKey) {
                z3 = false;
            }
            z2 = z3;
            i2++;
        }
        if (z) {
            for (int i4 = 0; i4 < pressingGoal.keys.length; i4++) {
                if (boolArr[i4] == null) {
                    if (z2) {
                        boolArr[i4] = Boolean.valueOf(zArr[i4]);
                    } else {
                        boolArr[i4] = Boolean.TRUE;
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i5 = 0; i5 < pressingGoal.keys.length; i5++) {
                if (boolArr[i5] == null) {
                    boolArr[i5] = Boolean.FALSE;
                }
            }
        }
        for (int i6 = 0; i6 < pressingGoal.keys.length; i6++) {
            if (zArr[i6] != boolArr[i6].booleanValue()) {
                KeyboardMap.KeyPair keyPair2 = pressingGoal.keys[i6];
                synthesizeEvent(boolArr[i6].booleanValue(), Long.valueOf(keyPair2.logicalKey), Long.valueOf(keyPair2.physicalKey), keyEvent.getEventTime());
            }
        }
    }

    public void synchronizeTogglingKey(KeyboardMap.TogglingGoal togglingGoal, boolean z, long j2, KeyEvent keyEvent) {
        if (togglingGoal.logicalKey != j2 && togglingGoal.enabled != z) {
            boolean containsKey = this.pressingRecords.containsKey(Long.valueOf(togglingGoal.physicalKey));
            boolean z2 = !containsKey;
            if (!containsKey) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(z2, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
            if (containsKey) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(containsKey, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
        }
    }

    public void updatePressingState(Long l2, Long l3) {
        if (l3 != null) {
            if (this.pressingRecords.put(l2, l3) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.pressingRecords.remove(l2) != null) {
        } else {
            throw new AssertionError("The key was empty");
        }
    }
}
