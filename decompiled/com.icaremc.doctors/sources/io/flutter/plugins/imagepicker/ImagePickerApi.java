package io.flutter.plugins.imagepicker;

import Q0.g;
import Q0.h;
import Q0.j;
import c1.l;
import com.google.firebase.encoders.json.BuildConfig;
import f.C0189e;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.imagepicker.ImagePickerApi;
import java.util.List;

/* loaded from: classes.dex */
public interface ImagePickerApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Q0.c codec$delegate = new h(new C0189e(1));

        private Companion() {
        }

        public static final MessagesPigeonCodec codec_delegate$lambda$0() {
            return new MessagesPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, ImagePickerApi imagePickerApi, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = BuildConfig.FLAVOR;
            }
            companion.setUp(binaryMessenger, imagePickerApi, str);
        }

        public static final void setUp$lambda$0$0(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.h.e(reply, "reply");
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.SourceSpecification");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.ImageSelectionOptions");
            Object obj4 = list.get(2);
            kotlin.jvm.internal.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.GeneralOptions");
            imagePickerApi.pickImages((SourceSpecification) obj2, (ImageSelectionOptions) obj3, (GeneralOptions) obj4, new a(reply, 2));
        }

        public static final j setUp$lambda$0$0$0(BasicMessageChannel.Reply reply, g gVar) {
            Throwable a2 = g.a(gVar.f717c);
            if (a2 != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(a2));
            } else {
                Object obj = gVar.f717c;
                if (obj instanceof Q0.f) {
                    obj = null;
                }
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult((List) obj));
            }
            return j.f722a;
        }

        public static final void setUp$lambda$1$0(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.h.e(reply, "reply");
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.SourceSpecification");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.VideoSelectionOptions");
            Object obj4 = list.get(2);
            kotlin.jvm.internal.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.GeneralOptions");
            imagePickerApi.pickVideos((SourceSpecification) obj2, (VideoSelectionOptions) obj3, (GeneralOptions) obj4, new a(reply, 0));
        }

        public static final j setUp$lambda$1$0$0(BasicMessageChannel.Reply reply, g gVar) {
            Throwable a2 = g.a(gVar.f717c);
            if (a2 != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(a2));
            } else {
                Object obj = gVar.f717c;
                if (obj instanceof Q0.f) {
                    obj = null;
                }
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult((List) obj));
            }
            return j.f722a;
        }

        public static final void setUp$lambda$2$0(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.h.e(reply, "reply");
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.MediaSelectionOptions");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.h.c(obj3, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.GeneralOptions");
            imagePickerApi.pickMedia((MediaSelectionOptions) obj2, (GeneralOptions) obj3, new a(reply, 1));
        }

        public static final j setUp$lambda$2$0$0(BasicMessageChannel.Reply reply, g gVar) {
            Throwable a2 = g.a(gVar.f717c);
            if (a2 != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(a2));
            } else {
                Object obj = gVar.f717c;
                if (obj instanceof Q0.f) {
                    obj = null;
                }
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult((List) obj));
            }
            return j.f722a;
        }

        public static final void setUp$lambda$3$0(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            kotlin.jvm.internal.h.e(reply, "reply");
            try {
                wrapError = android.support.v4.media.session.a.y(imagePickerApi.retrieveLostResults());
            } catch (Throwable th) {
                wrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) ((h) codec$delegate).a();
        }

        public final void setUp(BinaryMessenger binaryMessenger, ImagePickerApi imagePickerApi) {
            kotlin.jvm.internal.h.e(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, imagePickerApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final ImagePickerApi imagePickerApi, String messageChannelSuffix) {
            kotlin.jvm.internal.h.e(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.h.e(messageChannelSuffix, "messageChannelSuffix");
            String concat = messageChannelSuffix.length() > 0 ? ".".concat(messageChannelSuffix) : BuildConfig.FLAVOR;
            BinaryMessenger.TaskQueue makeBackgroundTaskQueue = binaryMessenger.makeBackgroundTaskQueue();
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickImages", concat), getCodec(), makeBackgroundTaskQueue);
            if (imagePickerApi != null) {
                final int i2 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.b
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i2) {
                            case 0:
                                ImagePickerApi.Companion.setUp$lambda$0$0(imagePickerApi, obj, reply);
                                return;
                            case 1:
                                ImagePickerApi.Companion.setUp$lambda$1$0(imagePickerApi, obj, reply);
                                return;
                            case 2:
                                ImagePickerApi.Companion.setUp$lambda$2$0(imagePickerApi, obj, reply);
                                return;
                            default:
                                ImagePickerApi.Companion.setUp$lambda$3$0(imagePickerApi, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickVideos", concat), getCodec(), makeBackgroundTaskQueue);
            if (imagePickerApi != null) {
                final int i3 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.b
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i3) {
                            case 0:
                                ImagePickerApi.Companion.setUp$lambda$0$0(imagePickerApi, obj, reply);
                                return;
                            case 1:
                                ImagePickerApi.Companion.setUp$lambda$1$0(imagePickerApi, obj, reply);
                                return;
                            case 2:
                                ImagePickerApi.Companion.setUp$lambda$2$0(imagePickerApi, obj, reply);
                                return;
                            default:
                                ImagePickerApi.Companion.setUp$lambda$3$0(imagePickerApi, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickMedia", concat), getCodec());
            if (imagePickerApi != null) {
                final int i4 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.b
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i4) {
                            case 0:
                                ImagePickerApi.Companion.setUp$lambda$0$0(imagePickerApi, obj, reply);
                                return;
                            case 1:
                                ImagePickerApi.Companion.setUp$lambda$1$0(imagePickerApi, obj, reply);
                                return;
                            case 2:
                                ImagePickerApi.Companion.setUp$lambda$2$0(imagePickerApi, obj, reply);
                                return;
                            default:
                                ImagePickerApi.Companion.setUp$lambda$3$0(imagePickerApi, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.image_picker_android.ImagePickerApi.retrieveLostResults", concat), getCodec(), makeBackgroundTaskQueue);
            if (imagePickerApi != null) {
                final int i5 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.b
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                ImagePickerApi.Companion.setUp$lambda$0$0(imagePickerApi, obj, reply);
                                return;
                            case 1:
                                ImagePickerApi.Companion.setUp$lambda$1$0(imagePickerApi, obj, reply);
                                return;
                            case 2:
                                ImagePickerApi.Companion.setUp$lambda$2$0(imagePickerApi, obj, reply);
                                return;
                            default:
                                ImagePickerApi.Companion.setUp$lambda$3$0(imagePickerApi, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
        }
    }

    void pickImages(SourceSpecification sourceSpecification, ImageSelectionOptions imageSelectionOptions, GeneralOptions generalOptions, l lVar);

    void pickMedia(MediaSelectionOptions mediaSelectionOptions, GeneralOptions generalOptions, l lVar);

    void pickVideos(SourceSpecification sourceSpecification, VideoSelectionOptions videoSelectionOptions, GeneralOptions generalOptions, l lVar);

    CacheRetrievalResult retrieveLostResults();
}
