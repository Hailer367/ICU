package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ForegroundService extends Service {
    private static int orCombineFlags(ArrayList<Integer> arrayList) {
        int intValue = arrayList.get(0).intValue();
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            intValue |= arrayList.get(i2).intValue();
        }
        return intValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ForegroundServiceStartParameter foregroundServiceStartParameter;
        Serializable serializableExtra;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            serializableExtra = intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA, ForegroundServiceStartParameter.class);
            foregroundServiceStartParameter = (ForegroundServiceStartParameter) serializableExtra;
        } else {
            foregroundServiceStartParameter = (ForegroundServiceStartParameter) intent.getSerializableExtra(ForegroundServiceStartParameter.EXTRA);
        }
        Notification createNotification = FlutterLocalNotificationsPlugin.createNotification(this, foregroundServiceStartParameter.notificationData);
        if (foregroundServiceStartParameter.foregroundServiceTypes != null && i4 >= 29) {
            startForeground(foregroundServiceStartParameter.notificationData.id.intValue(), createNotification, orCombineFlags(foregroundServiceStartParameter.foregroundServiceTypes));
        } else {
            startForeground(foregroundServiceStartParameter.notificationData.id.intValue(), createNotification);
        }
        return foregroundServiceStartParameter.startMode;
    }
}
