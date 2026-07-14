package io.flutter.plugins.firebase.messaging;

import androidx.lifecycle.C;

/* loaded from: classes.dex */
public class FlutterFirebaseTokenLiveData extends C {
    private static FlutterFirebaseTokenLiveData instance;

    public static FlutterFirebaseTokenLiveData getInstance() {
        if (instance == null) {
            instance = new FlutterFirebaseTokenLiveData();
        }
        return instance;
    }

    public void postToken(String str) {
        postValue(str);
    }
}
