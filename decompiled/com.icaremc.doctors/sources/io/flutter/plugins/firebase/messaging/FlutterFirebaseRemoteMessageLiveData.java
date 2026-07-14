package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.C;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: classes.dex */
public class FlutterFirebaseRemoteMessageLiveData extends C {
    private static FlutterFirebaseRemoteMessageLiveData instance;

    public static FlutterFirebaseRemoteMessageLiveData getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseRemoteMessageLiveData();
        }
        return instance;
    }

    public void postRemoteMessage(RemoteMessage remoteMessage) {
        postValue(remoteMessage);
    }
}
