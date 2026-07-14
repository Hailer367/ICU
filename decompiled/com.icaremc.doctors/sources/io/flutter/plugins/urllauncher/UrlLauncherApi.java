package io.flutter.plugins.urllauncher;

import Q0.c;
import Q0.h;
import f.C0189e;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface UrlLauncherApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final c codec$delegate = new h(new C0189e(3));

        private Companion() {
        }

        public static final MessagesPigeonCodec codec_delegate$lambda$0() {
            return new MessagesPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, UrlLauncherApi urlLauncherApi, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = com.google.firebase.encoders.json.BuildConfig.FLAVOR;
            }
            companion.setUp(binaryMessenger, urlLauncherApi, str);
        }

        public static final void setUp$lambda$0$0(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            kotlin.jvm.internal.h.e(reply, "reply");
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
            try {
                wrapError = android.support.v4.media.session.a.y(Boolean.valueOf(urlLauncherApi.canLaunchUrl((String) obj2)));
            } catch (Throwable th) {
                wrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        public static final void setUp$lambda$1$0(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            kotlin.jvm.internal.h.e(reply, "reply");
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.h.c(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Map<String, String> map = (Map) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.h.c(obj4, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                wrapError = android.support.v4.media.session.a.y(Boolean.valueOf(urlLauncherApi.launchUrl(str, map, ((Boolean) obj4).booleanValue())));
            } catch (Throwable th) {
                wrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        public static final void setUp$lambda$2$0(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            kotlin.jvm.internal.h.e(reply, "reply");
            kotlin.jvm.internal.h.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.h.c(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.h.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj3).booleanValue();
            Object obj4 = list.get(2);
            kotlin.jvm.internal.h.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.WebViewOptions");
            WebViewOptions webViewOptions = (WebViewOptions) obj4;
            Object obj5 = list.get(3);
            kotlin.jvm.internal.h.c(obj5, "null cannot be cast to non-null type io.flutter.plugins.urllauncher.BrowserOptions");
            try {
                wrapError = android.support.v4.media.session.a.y(Boolean.valueOf(urlLauncherApi.openUrlInApp(str, booleanValue, webViewOptions, (BrowserOptions) obj5)));
            } catch (Throwable th) {
                wrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        public static final void setUp$lambda$3$0(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            kotlin.jvm.internal.h.e(reply, "reply");
            try {
                wrapError = android.support.v4.media.session.a.y(Boolean.valueOf(urlLauncherApi.supportsCustomTabs()));
            } catch (Throwable th) {
                wrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        public static final void setUp$lambda$4$0(UrlLauncherApi urlLauncherApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> wrapError;
            kotlin.jvm.internal.h.e(reply, "reply");
            try {
                urlLauncherApi.closeWebView();
                wrapError = android.support.v4.media.session.a.y(null);
            } catch (Throwable th) {
                wrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(wrapError);
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) ((h) codec$delegate).a();
        }

        public final void setUp(BinaryMessenger binaryMessenger, UrlLauncherApi urlLauncherApi) {
            kotlin.jvm.internal.h.e(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, urlLauncherApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, UrlLauncherApi urlLauncherApi, String messageChannelSuffix) {
            kotlin.jvm.internal.h.e(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.h.e(messageChannelSuffix, "messageChannelSuffix");
            String concat = messageChannelSuffix.length() > 0 ? ".".concat(messageChannelSuffix) : com.google.firebase.encoders.json.BuildConfig.FLAVOR;
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl", concat), getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel.setMessageHandler(new a(0, urlLauncherApi));
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl", concat), getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel2.setMessageHandler(new a(1, urlLauncherApi));
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp", concat), getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel3.setMessageHandler(new a(2, urlLauncherApi));
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs", concat), getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel4.setMessageHandler(new a(3, urlLauncherApi));
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, O.a.m("dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView", concat), getCodec());
            if (urlLauncherApi != null) {
                basicMessageChannel5.setMessageHandler(new a(4, urlLauncherApi));
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
        }
    }

    boolean canLaunchUrl(String str);

    void closeWebView();

    boolean launchUrl(String str, Map<String, String> map, boolean z);

    boolean openUrlInApp(String str, boolean z, WebViewOptions webViewOptions, BrowserOptions browserOptions);

    boolean supportsCustomTabs();
}
