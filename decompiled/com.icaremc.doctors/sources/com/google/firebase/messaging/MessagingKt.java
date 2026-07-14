package com.google.firebase.messaging;

import com.google.firebase.Firebase;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: classes.dex */
public final class MessagingKt {
    public static final FirebaseMessaging getMessaging(Firebase firebase) {
        kotlin.jvm.internal.h.e(firebase, "<this>");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        kotlin.jvm.internal.h.d(firebaseMessaging, "getInstance(...)");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(String to, c1.l init) {
        kotlin.jvm.internal.h.e(to, "to");
        kotlin.jvm.internal.h.e(init, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(to);
        init.invoke(builder);
        RemoteMessage build = builder.build();
        kotlin.jvm.internal.h.d(build, "build(...)");
        return build;
    }
}
