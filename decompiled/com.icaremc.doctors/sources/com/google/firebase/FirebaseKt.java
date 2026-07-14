package com.google.firebase;

import android.content.Context;
import com.google.firebase.components.Component;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.h;
import l1.AbstractC0240s;

/* loaded from: classes.dex */
public final class FirebaseKt {
    public static final FirebaseApp app(Firebase firebase, String name) {
        h.e(firebase, "<this>");
        h.e(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        h.d(firebaseApp, "getInstance(...)");
        return firebaseApp;
    }

    private static final <T extends Annotation> Component<AbstractC0240s> coroutineDispatcher() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        h.e(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        h.d(firebaseApp, "getInstance(...)");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        h.e(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        h.d(options, "getOptions(...)");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        h.e(firebase, "<this>");
        h.e(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options) {
        h.e(firebase, "<this>");
        h.e(context, "context");
        h.e(options, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options);
        h.d(initializeApp, "initializeApp(...)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options, String name) {
        h.e(firebase, "<this>");
        h.e(context, "context");
        h.e(options, "options");
        h.e(name, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options, name);
        h.d(initializeApp, "initializeApp(...)");
        return initializeApp;
    }
}
