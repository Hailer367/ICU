package io.flutter.plugins.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.util.Log;
import com.google.firebase.messaging.RemoteMessage;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FlutterFirebaseMessagingReceiver extends BroadcastReceiver {
    private static final String TAG = "FLTFireMsgReceiver";
    static HashMap<String, RemoteMessage> notifications = new HashMap<>();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2;
        Log.d(TAG, "broadcast received for message");
        if (ContextHolder.getApplicationContext() == null) {
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            } else {
                context2 = context;
            }
            ContextHolder.setApplicationContext(context2);
        }
        if (intent.getExtras() == null) {
            Log.d(TAG, "broadcast received but intent contained no extras to process RemoteMessage. Operation cancelled.");
            return;
        }
        RemoteMessage remoteMessage = new RemoteMessage(intent.getExtras());
        if (remoteMessage.getNotification() != null) {
            notifications.put(remoteMessage.getMessageId(), remoteMessage);
            FlutterFirebaseMessagingStore.getInstance().storeFirebaseMessage(remoteMessage);
        }
        if (FlutterFirebaseMessagingUtils.isApplicationForeground(context)) {
            FlutterFirebaseRemoteMessageLiveData.getInstance().postRemoteMessage(remoteMessage);
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) FlutterFirebaseMessagingBackgroundService.class);
        Parcel obtain = Parcel.obtain();
        boolean z = false;
        remoteMessage.writeToParcel(obtain, 0);
        intent2.putExtra("notification", obtain.marshall());
        if (remoteMessage.getOriginalPriority() == 1) {
            z = true;
        }
        FlutterFirebaseMessagingBackgroundService.enqueueMessageProcessing(context, intent2, z);
    }
}
