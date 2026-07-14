package io.flutter.plugins.sharedpreferences;

import android.util.Log;
import com.google.firebase.encoders.json.BuildConfig;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.sharedpreferences.Messages;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Messages {

    /* loaded from: classes.dex */
    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    /* loaded from: classes.dex */
    public static class PigeonCodec extends StandardMessageCodec {
        public static final PigeonCodec INSTANCE = new PigeonCodec();

        private PigeonCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b2, ByteBuffer byteBuffer) {
            return super.readValueOfType(b2, byteBuffer);
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            super.writeValue(byteArrayOutputStream, obj);
        }
    }

    /* loaded from: classes.dex */
    public interface SharedPreferencesApi {
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, sharedPreferencesApi.remove((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.setBool((String) arrayList2.get(0), (Boolean) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.setString((String) arrayList2.get(0), (String) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$3(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.setInt((String) arrayList2.get(0), (Long) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$4(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.setDouble((String) arrayList2.get(0), (Double) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$5(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.setEncodedStringList((String) arrayList2.get(0), (String) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$6(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.setDeprecatedStringList((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$7(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.clear((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$8(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, sharedPreferencesApi.getAll((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setUp(BinaryMessenger binaryMessenger, SharedPreferencesApi sharedPreferencesApi) {
            setUp(binaryMessenger, BuildConfig.FLAVOR, sharedPreferencesApi);
        }

        Boolean clear(String str, List<String> list);

        Map<String, Object> getAll(String str, List<String> list);

        Boolean remove(String str);

        Boolean setBool(String str, Boolean bool);

        Boolean setDeprecatedStringList(String str, List<String> list);

        Boolean setDouble(String str, Double d2);

        Boolean setEncodedStringList(String str, String str2);

        Boolean setInt(String str, Long l2);

        Boolean setString(String str, String str2);

        static void setUp(BinaryMessenger binaryMessenger, String str, final SharedPreferencesApi sharedPreferencesApi) {
            String concat = str.isEmpty() ? BuildConfig.FLAVOR : ".".concat(str);
            BinaryMessenger.TaskQueue makeBackgroundTaskQueue = binaryMessenger.makeBackgroundTaskQueue();
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.remove", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i2 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i2) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setBool", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i3 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i3) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setString", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i4 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i4) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setInt", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i5 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDouble", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i6 = 4;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setEncodedStringList", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i7 = 5;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDeprecatedStringList", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i8 = 6;
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.clear", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i9 = 7;
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.getAll", concat), getCodec(), makeBackgroundTaskQueue);
            if (sharedPreferencesApi != null) {
                final int i10 = 8;
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler(sharedPreferencesApi) { // from class: io.flutter.plugins.sharedpreferences.a

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.SharedPreferencesApi f2448b;

                    {
                        this.f2448b = sharedPreferencesApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                Messages.SharedPreferencesApi.lambda$setUp$0(this.f2448b, obj, reply);
                                return;
                            case 1:
                                Messages.SharedPreferencesApi.lambda$setUp$1(this.f2448b, obj, reply);
                                return;
                            case 2:
                                Messages.SharedPreferencesApi.lambda$setUp$2(this.f2448b, obj, reply);
                                return;
                            case 3:
                                Messages.SharedPreferencesApi.lambda$setUp$3(this.f2448b, obj, reply);
                                return;
                            case 4:
                                Messages.SharedPreferencesApi.lambda$setUp$4(this.f2448b, obj, reply);
                                return;
                            case 5:
                                Messages.SharedPreferencesApi.lambda$setUp$5(this.f2448b, obj, reply);
                                return;
                            case 6:
                                Messages.SharedPreferencesApi.lambda$setUp$6(this.f2448b, obj, reply);
                                return;
                            case 7:
                                Messages.SharedPreferencesApi.lambda$setUp$7(this.f2448b, obj, reply);
                                return;
                            default:
                                Messages.SharedPreferencesApi.lambda$setUp$8(this.f2448b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
        }
    }

    public static ArrayList<Object> wrapError(Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
            return arrayList;
        }
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
