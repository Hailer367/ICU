package com.dexterous.flutterlocalnotifications;

import E.AbstractC0015o;
import a.AbstractC0051a;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.graphics.drawable.IconCompat;
import com.dexterous.flutterlocalnotifications.isolate.IsolatePreferences;
import com.dexterous.flutterlocalnotifications.models.BitmapSource;
import com.dexterous.flutterlocalnotifications.models.DateTimeComponents;
import com.dexterous.flutterlocalnotifications.models.IconSource;
import com.dexterous.flutterlocalnotifications.models.MessageDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationAction;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelAction;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationChannelGroupDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import com.dexterous.flutterlocalnotifications.models.NotificationStyle;
import com.dexterous.flutterlocalnotifications.models.PersonDetails;
import com.dexterous.flutterlocalnotifications.models.RepeatInterval;
import com.dexterous.flutterlocalnotifications.models.ScheduleMode;
import com.dexterous.flutterlocalnotifications.models.ScheduledNotificationRepeatFrequency;
import com.dexterous.flutterlocalnotifications.models.SoundSource;
import com.dexterous.flutterlocalnotifications.models.styles.BigPictureStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.BigTextStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.DefaultStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.InboxStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.MessagingStyleInformation;
import com.dexterous.flutterlocalnotifications.models.styles.StyleInformation;
import com.dexterous.flutterlocalnotifications.utils.BooleanUtils;
import com.dexterous.flutterlocalnotifications.utils.LongUtils;
import com.dexterous.flutterlocalnotifications.utils.StringUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.flutter.Build;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.C0314e;
import u.C0318i;
import u.C0319j;
import u.H;
import u.K;
import u.M;
import u.t;
import u.u;
import u.z;

@Keep
/* loaded from: classes.dex */
public class FlutterLocalNotificationsPlugin implements MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, FlutterPlugin, ActivityAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ACTION_ID = "actionId";
    private static final String ARE_NOTIFICATIONS_ENABLED_METHOD = "areNotificationsEnabled";
    private static final String CALLBACK_HANDLE = "callback_handle";
    private static final String CANCEL_ALL_METHOD = "cancelAll";
    private static final String CANCEL_ALL_PENDING_NOTIFICATIONS_METHOD = "cancelAllPendingNotifications";
    private static final String CANCEL_ID = "id";
    private static final String CANCEL_METHOD = "cancel";
    static final String CANCEL_NOTIFICATION = "cancelNotification";
    private static final String CANCEL_TAG = "tag";
    private static final String CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD = "canScheduleExactNotifications";
    private static final String CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD = "createNotificationChannelGroup";
    private static final String CREATE_NOTIFICATION_CHANNEL_METHOD = "createNotificationChannel";
    private static final String DEFAULT_ICON = "defaultIcon";
    private static final String DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD = "deleteNotificationChannelGroup";
    private static final String DELETE_NOTIFICATION_CHANNEL_METHOD = "deleteNotificationChannel";
    private static final String DISPATCHER_HANDLE = "dispatcher_handle";
    private static final String DRAWABLE = "drawable";
    private static final String EXACT_ALARMS_PERMISSION_ERROR_CODE = "exact_alarms_not_permitted";
    static final int EXACT_ALARM_PERMISSION_REQUEST_CODE = 2;
    static final int FULL_SCREEN_INTENT_PERMISSION_REQUEST_CODE = 3;
    private static final String GET_ACTIVE_NOTIFICATIONS_ERROR_MESSAGE = "Android version must be 6.0 or newer to use getActiveNotifications";
    private static final String GET_ACTIVE_NOTIFICATIONS_METHOD = "getActiveNotifications";
    private static final String GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE = "getActiveNotificationMessagingStyleError";
    private static final String GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD = "getActiveNotificationMessagingStyle";
    private static final String GET_CALLBACK_HANDLE_METHOD = "getCallbackHandle";
    private static final String GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD = "getNotificationAppLaunchDetails";
    private static final String GET_NOTIFICATION_CHANNELS_ERROR_CODE = "getNotificationChannelsError";
    private static final String GET_NOTIFICATION_CHANNELS_METHOD = "getNotificationChannels";
    private static final String HAS_NOTIFICATION_POLICY_ACCESS_METHOD = "hasNotificationPolicyAccess";
    private static final String INITIALIZE_METHOD = "initialize";
    private static final String INPUT = "input";
    private static final String INPUT_RESULT = "FlutterLocalNotificationsPluginInputResult";
    private static final String INVALID_BIG_PICTURE_ERROR_CODE = "invalid_big_picture";
    private static final String INVALID_DRAWABLE_RESOURCE_ERROR_MESSAGE = "The resource %s could not be found. Please make sure it has been added as a drawable resource to your Android head project.";
    private static final String INVALID_ICON_ERROR_CODE = "invalid_icon";
    private static final String INVALID_LARGE_ICON_ERROR_CODE = "invalid_large_icon";
    private static final String INVALID_LED_DETAILS_ERROR_CODE = "invalid_led_details";
    private static final String INVALID_LED_DETAILS_ERROR_MESSAGE = "Must specify both ledOnMs and ledOffMs to configure the blink cycle on older versions of Android before Oreo";
    private static final String INVALID_RAW_RESOURCE_ERROR_MESSAGE = "The resource %s could not be found. Please make sure it has been added as a raw resource to your Android head project.";
    private static final String INVALID_SOUND_ERROR_CODE = "invalid_sound";
    private static final String METHOD_CHANNEL = "dexterous.com/flutter/local_notifications";
    static String NOTIFICATION_DETAILS = "notificationDetails";
    static final String NOTIFICATION_ID = "notificationId";
    private static final String NOTIFICATION_LAUNCHED_APP = "notificationLaunchedApp";
    static final int NOTIFICATION_PERMISSION_REQUEST_CODE = 1;
    static final int NOTIFICATION_POLICY_ACCESS_REQUEST_CODE = 4;
    private static final String NOTIFICATION_RESPONSE_TYPE = "notificationResponseType";
    static final String NOTIFICATION_TAG = "notificationTag";
    static final String PAYLOAD = "payload";
    private static final String PENDING_NOTIFICATION_REQUESTS_METHOD = "pendingNotificationRequests";
    private static final String PERIODICALLY_SHOW_METHOD = "periodicallyShow";
    private static final String PERIODICALLY_SHOW_WITH_DURATION_METHOD = "periodicallyShowWithDuration";
    private static final String PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE = "permissionRequestInProgress";
    private static final String PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE = "Another permission request is already in progress";
    private static final String REQUEST_EXACT_ALARMS_PERMISSION_METHOD = "requestExactAlarmsPermission";
    private static final String REQUEST_FULL_SCREEN_INTENT_PERMISSION_METHOD = "requestFullScreenIntentPermission";
    private static final String REQUEST_NOTIFICATIONS_PERMISSION_METHOD = "requestNotificationsPermission";
    private static final String REQUEST_NOTIFICATION_POLICY_ACCESS_METHOD = "requestNotificationPolicyAccess";
    private static final String SCHEDULED_NOTIFICATIONS = "scheduled_notifications";
    private static final String SELECT_FOREGROUND_NOTIFICATION_ACTION = "SELECT_FOREGROUND_NOTIFICATION";
    private static final String SELECT_NOTIFICATION = "SELECT_NOTIFICATION";
    private static final String SHARED_PREFERENCES_KEY = "notification_plugin_cache";
    private static final String SHOW_METHOD = "show";
    private static final String START_FOREGROUND_SERVICE = "startForegroundService";
    private static final String STOP_FOREGROUND_SERVICE = "stopForegroundService";
    private static final String TAG = "FLTLocalNotifPlugin";
    private static final String UNSUPPORTED_OS_VERSION_ERROR_CODE = "unsupported_os_version";
    private static final String ZONED_SCHEDULE_METHOD = "zonedSchedule";
    static Gson gson;
    private Context applicationContext;
    private PermissionRequestListener callback;
    private MethodChannel channel;
    private Activity mainActivity;
    private PermissionRequestProgress permissionRequestProgress = PermissionRequestProgress.None;

    /* renamed from: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource;
        static final /* synthetic */ int[] $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle;
        static final /* synthetic */ int[] $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval;

        static {
            int[] iArr = new int[NotificationStyle.values().length];
            $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle = iArr;
            try {
                iArr[NotificationStyle.BigPicture.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.BigText.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.Inbox.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.Messaging.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[NotificationStyle.Media.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[IconSource.values().length];
            $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource = iArr2;
            try {
                iArr2[IconSource.DrawableResource.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.BitmapFilePath.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.ContentUri.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.FlutterBitmapAsset.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[IconSource.ByteArray.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr3 = new int[RepeatInterval.values().length];
            $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval = iArr3;
            try {
                iArr3[RepeatInterval.EveryMinute.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[RepeatInterval.Hourly.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[RepeatInterval.Daily.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[RepeatInterval.Weekly.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ExactAlarmPermissionException extends PluginException {
        public ExactAlarmPermissionException() {
            super(FlutterLocalNotificationsPlugin.EXACT_ALARMS_PERMISSION_ERROR_CODE, "Exact alarms are not permitted");
        }
    }

    /* loaded from: classes.dex */
    public enum PermissionRequestProgress {
        None,
        RequestingNotificationPermission,
        RequestingNotificationPolicyAccess,
        RequestingExactAlarmsPermission,
        RequestingFullScreenIntentPermission
    }

    /* loaded from: classes.dex */
    public static class PluginException extends RuntimeException {
        public final String code;

        public PluginException(String str, String str2) {
            super(str2);
            this.code = str;
        }
    }

    private static void applyGrouping(NotificationDetails notificationDetails, C0319j c0319j) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.groupKey).booleanValue()) {
            c0319j.f3763s = notificationDetails.groupKey;
            if (BooleanUtils.getValue(notificationDetails.setAsGroupSummary)) {
                c0319j.f3764t = true;
            }
            c0319j.f3742E = notificationDetails.groupAlertBehavior.intValue();
        }
    }

    private void areNotificationsEnabled(MethodChannel.Result result) {
        result.success(Boolean.valueOf(getNotificationManager(this.applicationContext).f3699b.areNotificationsEnabled()));
    }

    public static Gson buildGson() {
        if (gson == null) {
            gson = new GsonBuilder().registerTypeAdapter(ScheduleMode.class, new ScheduleMode.Deserializer()).registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(StyleInformation.class).registerSubtype(DefaultStyleInformation.class).registerSubtype(BigTextStyleInformation.class).registerSubtype(BigPictureStyleInformation.class).registerSubtype(InboxStyleInformation.class).registerSubtype(MessagingStyleInformation.class)).create();
        }
        return gson;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [u.K, java.lang.Object] */
    private static K buildPerson(Context context, PersonDetails personDetails) {
        IconCompat iconCompat;
        IconSource iconSource;
        String str = null;
        if (personDetails == null) {
            return null;
        }
        boolean value = BooleanUtils.getValue(personDetails.bot);
        Object obj = personDetails.icon;
        if (obj != null && (iconSource = personDetails.iconBitmapSource) != null) {
            iconCompat = getIconFromSource(context, obj, iconSource);
        } else {
            iconCompat = null;
        }
        boolean value2 = BooleanUtils.getValue(personDetails.important);
        String str2 = personDetails.key;
        if (str2 == null) {
            str2 = null;
        }
        String str3 = personDetails.name;
        if (str3 == null) {
            str3 = null;
        }
        String str4 = personDetails.uri;
        if (str4 != null) {
            str = str4;
        }
        ?? obj2 = new Object();
        obj2.f3700a = str3;
        obj2.f3701b = iconCompat;
        obj2.f3702c = str;
        obj2.f3703d = str2;
        obj2.f3704e = value;
        obj2.f3705f = value2;
        return obj2;
    }

    private static long calculateNextNotificationTrigger(long j2, long j3) {
        while (j2 < System.currentTimeMillis()) {
            j2 += j3;
        }
        return j2;
    }

    private static long calculateRepeatIntervalMilliseconds(NotificationDetails notificationDetails) {
        if (notificationDetails.repeatIntervalMilliseconds != null) {
            return r0.intValue();
        }
        int i2 = AnonymousClass6.$SwitchMap$com$dexterous$flutterlocalnotifications$models$RepeatInterval[notificationDetails.repeatInterval.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return 0L;
                    }
                    return 604800000L;
                }
                return 86400000L;
            }
            return 3600000L;
        }
        return 60000L;
    }

    private static Boolean canCreateNotificationChannel(Context context, NotificationChannelDetails notificationChannelDetails) {
        NotificationChannel notificationChannel;
        boolean z;
        NotificationChannelAction notificationChannelAction;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationChannel = ((NotificationManager) context.getSystemService("notification")).getNotificationChannel(notificationChannelDetails.id);
            if ((notificationChannel == null && ((notificationChannelAction = notificationChannelDetails.channelAction) == null || notificationChannelAction == NotificationChannelAction.CreateIfNotExists)) || (notificationChannel != null && notificationChannelDetails.channelAction == NotificationChannelAction.Update)) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return Boolean.FALSE;
    }

    private void cancel(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments();
        cancelNotification((Integer) map.get(CANCEL_ID), (String) map.get(CANCEL_TAG));
        result.success(null);
    }

    private void cancelAllNotifications(MethodChannel.Result result) {
        getNotificationManager(this.applicationContext).f3699b.cancelAll();
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        if (loadScheduledNotifications != null && !loadScheduledNotifications.isEmpty()) {
            Intent intent = new Intent(this.applicationContext, (Class<?>) ScheduledNotificationReceiver.class);
            int size = loadScheduledNotifications.size();
            int i2 = 0;
            while (i2 < size) {
                NotificationDetails notificationDetails = loadScheduledNotifications.get(i2);
                i2++;
                getAlarmManager(this.applicationContext).cancel(getBroadcastPendingIntent(this.applicationContext, notificationDetails.id.intValue(), intent));
            }
            saveScheduledNotifications(this.applicationContext, new ArrayList());
            result.success(null);
            return;
        }
        result.success(null);
    }

    private void cancelAllPendingNotifications(MethodChannel.Result result) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        if (loadScheduledNotifications != null && !loadScheduledNotifications.isEmpty()) {
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            Intent intent = new Intent(this.applicationContext, (Class<?>) ScheduledNotificationReceiver.class);
            int size = loadScheduledNotifications.size();
            int i2 = 0;
            while (i2 < size) {
                NotificationDetails notificationDetails = loadScheduledNotifications.get(i2);
                i2++;
                alarmManager.cancel(getBroadcastPendingIntent(this.applicationContext, notificationDetails.id.intValue(), intent));
            }
            saveScheduledNotifications(this.applicationContext, new ArrayList());
            result.success(null);
            return;
        }
        result.success(null);
    }

    private void cancelNotification(Integer num, String str) {
        getAlarmManager(this.applicationContext).cancel(getBroadcastPendingIntent(this.applicationContext, num.intValue(), new Intent(this.applicationContext, (Class<?>) ScheduledNotificationReceiver.class)));
        H notificationManager = getNotificationManager(this.applicationContext);
        if (str == null) {
            notificationManager.a(num.intValue(), null);
        } else {
            notificationManager.a(num.intValue(), str);
        }
        removeNotificationFromCache(this.applicationContext, num);
    }

    private static byte[] castObjectToByteArray(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            byte[] bArr = new byte[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                bArr[i2] = (byte) ((Double) arrayList.get(i2)).intValue();
            }
            return bArr;
        }
        return (byte[]) obj;
    }

    private static void checkCanScheduleExactAlarms(AlarmManager alarmManager) {
        boolean canScheduleExactAlarms;
        if (Build.VERSION.SDK_INT >= 31) {
            canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
            if (!canScheduleExactAlarms) {
                throw new ExactAlarmPermissionException();
            }
        }
    }

    private static t createMessage(Context context, MessageDetails messageDetails) {
        String str;
        t tVar = new t(messageDetails.text, messageDetails.timestamp.longValue(), buildPerson(context, messageDetails.person));
        String str2 = messageDetails.dataUri;
        if (str2 != null && (str = messageDetails.dataMimeType) != null) {
            Uri parse = Uri.parse(str2);
            tVar.f3783e = str;
            tVar.f3784f = parse;
        }
        return tVar;
    }

    public static Notification createNotification(Context context, NotificationDetails notificationDetails) {
        CharSequence charSequence;
        CharSequence charSequence2;
        IconCompat iconCompat;
        Intent intent;
        int i2;
        int i3;
        PendingIntent broadcast;
        boolean z;
        CharSequence[] charSequenceArr;
        IconSource iconSource;
        NotificationChannelDetails fromNotificationDetails = NotificationChannelDetails.fromNotificationDetails(notificationDetails);
        if (canCreateNotificationChannel(context, fromNotificationDetails).booleanValue()) {
            setupNotificationChannel(context, fromNotificationDetails);
        }
        Intent launchIntent = getLaunchIntent(context);
        launchIntent.setAction(SELECT_NOTIFICATION);
        launchIntent.putExtra(NOTIFICATION_ID, notificationDetails.id);
        launchIntent.putExtra(PAYLOAD, notificationDetails.payload);
        PendingIntent activity = PendingIntent.getActivity(context, notificationDetails.id.intValue(), launchIntent, 201326592);
        DefaultStyleInformation defaultStyleInformation = (DefaultStyleInformation) notificationDetails.styleInformation;
        C0319j c0319j = new C0319j(context, notificationDetails.channelId);
        if (defaultStyleInformation.htmlFormatTitle.booleanValue()) {
            charSequence = fromHtml(notificationDetails.title);
        } else {
            charSequence = notificationDetails.title;
        }
        c0319j.f3751e = C0319j.b(charSequence);
        if (defaultStyleInformation.htmlFormatBody.booleanValue()) {
            charSequence2 = fromHtml(notificationDetails.body);
        } else {
            charSequence2 = notificationDetails.body;
        }
        c0319j.f3752f = C0319j.b(charSequence2);
        c0319j.f3744G.tickerText = C0319j.b(notificationDetails.ticker);
        c0319j.c(16, BooleanUtils.getValue(notificationDetails.autoCancel));
        c0319j.f3753g = activity;
        c0319j.f3757k = notificationDetails.priority.intValue();
        c0319j.c(2, BooleanUtils.getValue(notificationDetails.ongoing));
        c0319j.f3745H = BooleanUtils.getValue(notificationDetails.silent);
        c0319j.c(8, BooleanUtils.getValue(notificationDetails.onlyAlertOnce));
        int i4 = 0;
        if (notificationDetails.actions != null) {
            int intValue = notificationDetails.id.intValue() * 16;
            for (NotificationAction notificationAction : notificationDetails.actions) {
                if (!TextUtils.isEmpty(notificationAction.icon) && (iconSource = notificationAction.iconSource) != null) {
                    iconCompat = getIconFromSource(context, notificationAction.icon, iconSource);
                } else {
                    iconCompat = null;
                }
                Boolean bool = notificationAction.showsUserInterface;
                if (bool != null && bool.booleanValue()) {
                    intent = getLaunchIntent(context);
                    intent.setAction(SELECT_FOREGROUND_NOTIFICATION_ACTION);
                } else {
                    intent = new Intent(context, (Class<?>) ActionBroadcastReceiver.class);
                    intent.setAction(ActionBroadcastReceiver.ACTION_TAPPED);
                }
                intent.putExtra(NOTIFICATION_ID, notificationDetails.id).putExtra(NOTIFICATION_TAG, notificationDetails.tag).putExtra(ACTION_ID, notificationAction.id).putExtra(CANCEL_NOTIFICATION, notificationAction.cancelNotification).putExtra(PAYLOAD, notificationDetails.payload);
                List<NotificationAction.NotificationActionInput> list = notificationAction.actionInputs;
                if (list != null && !list.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        i2 = 167772160;
                    } else {
                        i2 = 134217728;
                    }
                } else {
                    i2 = 201326592;
                }
                Boolean bool2 = notificationAction.showsUserInterface;
                if (bool2 != null && bool2.booleanValue()) {
                    i3 = intValue + 1;
                    broadcast = PendingIntent.getActivity(context, intValue, intent, i2);
                } else {
                    i3 = intValue + 1;
                    broadcast = PendingIntent.getBroadcast(context, intValue, intent, i2);
                }
                SpannableString spannableString = new SpannableString(notificationAction.title);
                if (notificationAction.titleColor != null) {
                    spannableString.setSpan(new ForegroundColorSpan(notificationAction.titleColor.intValue()), i4, spannableString.length(), i4);
                }
                C0314e c0314e = new C0314e(iconCompat, spannableString, broadcast);
                Boolean bool3 = notificationAction.contextual;
                if (bool3 != null) {
                    c0314e.f3721i = bool3.booleanValue();
                }
                Boolean bool4 = notificationAction.showsUserInterface;
                if (bool4 != null) {
                    c0314e.f3720h = bool4.booleanValue();
                }
                Boolean bool5 = notificationAction.allowGeneratedReplies;
                if (bool5 != null) {
                    c0314e.f3716d = bool5.booleanValue();
                }
                Integer num = notificationAction.semanticAction;
                if (num != null) {
                    c0314e.f3719g = num.intValue();
                }
                List<NotificationAction.NotificationActionInput> list2 = notificationAction.actionInputs;
                if (list2 != null) {
                    for (NotificationAction.NotificationActionInput notificationActionInput : list2) {
                        HashSet hashSet = new HashSet();
                        Bundle bundle = new Bundle();
                        String str = notificationActionInput.label;
                        Boolean bool6 = notificationActionInput.allowFreeFormInput;
                        if (bool6 != null) {
                            z = bool6.booleanValue();
                        } else {
                            z = true;
                        }
                        List<String> list3 = notificationActionInput.allowedMimeTypes;
                        if (list3 != null) {
                            Iterator<String> it = list3.iterator();
                            while (it.hasNext()) {
                                hashSet.add(it.next());
                            }
                        }
                        List<String> list4 = notificationActionInput.choices;
                        i4 = 0;
                        if (list4 != null) {
                            charSequenceArr = (CharSequence[]) list4.toArray(new CharSequence[0]);
                        } else {
                            charSequenceArr = null;
                        }
                        M m2 = new M(str, charSequenceArr, z, bundle, hashSet);
                        if (c0314e.f3718f == null) {
                            c0314e.f3718f = new ArrayList();
                        }
                        c0314e.f3718f.add(m2);
                    }
                }
                if (BooleanUtils.getValue(notificationAction.invisible)) {
                    c0319j.f3750d.add(c0314e.a());
                } else {
                    c0319j.f3748b.add(c0314e.a());
                }
                intValue = i3;
            }
        }
        setSmallIcon(context, notificationDetails, c0319j);
        c0319j.d(getBitmapFromSource(context, notificationDetails.largeIcon, notificationDetails.largeIconBitmapSource));
        Integer num2 = notificationDetails.color;
        if (num2 != null) {
            c0319j.z = num2.intValue();
        }
        Boolean bool7 = notificationDetails.colorized;
        if (bool7 != null) {
            c0319j.f3766v = bool7.booleanValue();
            c0319j.f3767w = true;
        }
        Boolean bool8 = notificationDetails.showWhen;
        if (bool8 != null) {
            c0319j.f3758l = BooleanUtils.getValue(bool8);
        }
        Long l2 = notificationDetails.when;
        if (l2 != null) {
            c0319j.f3744G.when = l2.longValue();
        }
        Boolean bool9 = notificationDetails.usesChronometer;
        if (bool9 != null) {
            c0319j.f3759m = bool9.booleanValue();
        }
        Boolean bool10 = notificationDetails.chronometerCountDown;
        if (bool10 != null) {
            boolean booleanValue = bool10.booleanValue();
            if (c0319j.y == null) {
                c0319j.y = new Bundle();
            }
            c0319j.y.putBoolean("android.chronometerCountDown", booleanValue);
        }
        if (BooleanUtils.getValue(notificationDetails.fullScreenIntent)) {
            c0319j.f3754h = activity;
            c0319j.c(128, true);
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails.shortcutId).booleanValue()) {
            c0319j.f3740C = notificationDetails.shortcutId;
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails.subText).booleanValue()) {
            c0319j.f3761o = C0319j.b(notificationDetails.subText);
        }
        Integer num3 = notificationDetails.number;
        if (num3 != null) {
            c0319j.f3756j = num3.intValue();
        }
        setVisibility(notificationDetails, c0319j);
        applyGrouping(notificationDetails, c0319j);
        setSound(context, notificationDetails, c0319j);
        setVibrationPattern(notificationDetails, c0319j);
        setLights(notificationDetails, c0319j);
        setStyle(context, notificationDetails, c0319j);
        setProgress(notificationDetails, c0319j);
        setCategory(notificationDetails, c0319j);
        setTimeoutAfter(notificationDetails, c0319j);
        Notification a2 = c0319j.a();
        int[] iArr = notificationDetails.additionalFlags;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            while (i4 < length) {
                a2.flags = iArr[i4] | a2.flags;
                i4++;
            }
        }
        return a2;
    }

    private void createNotificationChannel(MethodCall methodCall, MethodChannel.Result result) {
        setupNotificationChannel(this.applicationContext, NotificationChannelDetails.from((Map) methodCall.arguments()));
        result.success(null);
    }

    private void createNotificationChannelGroup(MethodCall methodCall, MethodChannel.Result result) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            NotificationChannelGroupDetails from = NotificationChannelGroupDetails.from((Map) methodCall.arguments());
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            C.a.k();
            NotificationChannelGroup c2 = C.a.c(from.id, from.name);
            if (i2 >= 28) {
                c2.setDescription(from.description);
            }
            notificationManager.createNotificationChannelGroup(c2);
        }
        result.success(null);
    }

    private void deleteNotificationChannel(MethodCall methodCall, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.applicationContext.getSystemService("notification")).deleteNotificationChannel((String) methodCall.arguments());
        }
        result.success(null);
    }

    private void deleteNotificationChannelGroup(MethodCall methodCall, MethodChannel.Result result) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.applicationContext.getSystemService("notification")).deleteNotificationChannelGroup((String) methodCall.arguments());
        }
        result.success(null);
    }

    private Map<String, Object> describeIcon(IconCompat iconCompat) {
        IconSource iconSource;
        String resourceEntryName;
        if (iconCompat != null) {
            int i2 = iconCompat.f1289a;
            if (i2 == -1) {
                i2 = AbstractC0051a.D(iconCompat.f1290b);
            }
            if (i2 != 2) {
                if (i2 != 4) {
                    return null;
                }
                iconSource = IconSource.ContentUri;
                resourceEntryName = iconCompat.g().toString();
            } else {
                iconSource = IconSource.DrawableResource;
                resourceEntryName = this.applicationContext.getResources().getResourceEntryName(iconCompat.f());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.ScionAnalytics.PARAM_SOURCE, Integer.valueOf(iconSource.ordinal()));
            hashMap.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, resourceEntryName);
            return hashMap;
        }
        return null;
    }

    private Map<String, Object> describePerson(K k2) {
        if (k2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key", k2.f3703d);
        hashMap.put("name", k2.f3700a);
        hashMap.put("uri", k2.f3702c);
        hashMap.put("bot", Boolean.valueOf(k2.f3704e));
        hashMap.put("important", Boolean.valueOf(k2.f3705f));
        hashMap.put("icon", describeIcon(k2.f3701b));
        return hashMap;
    }

    private NotificationDetails extractNotificationDetails(MethodChannel.Result result, Map<String, Object> map) {
        NotificationDetails from = NotificationDetails.from(map);
        if (!hasInvalidIcon(result, from.icon) && !hasInvalidLargeIcon(result, from.largeIcon, from.largeIconBitmapSource) && !hasInvalidBigPictureResources(result, from) && !hasInvalidRawSoundResource(result, from) && !hasInvalidLedDetails(result, from)) {
            return from;
        }
        return null;
    }

    public static Map<String, Object> extractNotificationResponseMap(Intent intent) {
        int intExtra = intent.getIntExtra(NOTIFICATION_ID, 0);
        HashMap hashMap = new HashMap();
        hashMap.put(NOTIFICATION_ID, Integer.valueOf(intExtra));
        hashMap.put(NOTIFICATION_TAG, intent.getStringExtra(NOTIFICATION_TAG));
        hashMap.put(ACTION_ID, intent.getStringExtra(ACTION_ID));
        hashMap.put(PAYLOAD, intent.getStringExtra(PAYLOAD));
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null) {
            hashMap.put(INPUT, resultsFromIntent.getString(INPUT_RESULT));
        }
        if (SELECT_NOTIFICATION.equals(intent.getAction())) {
            hashMap.put(NOTIFICATION_RESPONSE_TYPE, 0);
        }
        if (SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            hashMap.put(NOTIFICATION_RESPONSE_TYPE, 1);
        }
        return hashMap;
    }

    private static Spanned fromHtml(String str) {
        if (str == null) {
            return null;
        }
        return Html.fromHtml(str, 0);
    }

    private void getActiveNotificationMessagingStyle(MethodCall methodCall, MethodChannel.Result result) {
        Notification notification;
        NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
        try {
            Map map = (Map) methodCall.arguments();
            int intValue = ((Integer) map.get(CANCEL_ID)).intValue();
            String str = (String) map.get(CANCEL_TAG);
            int i2 = 0;
            for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                if (statusBarNotification.getId() != intValue || (str != null && !str.equals(statusBarNotification.getTag()))) {
                }
                notification = statusBarNotification.getNotification();
            }
            notification = null;
            if (notification == null) {
                result.success(null);
                return;
            }
            u e2 = u.e(notification);
            if (e2 == null) {
                result.success(null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("groupConversation", Boolean.valueOf(e2.f()));
            hashMap.put("person", describePerson(e2.f3787g));
            hashMap.put("conversationTitle", e2.f3788h);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = e2.f3785e;
            int size = arrayList2.size();
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                t tVar = (t) obj;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("text", tVar.f3779a);
                hashMap2.put("timestamp", Long.valueOf(tVar.f3780b));
                hashMap2.put("person", describePerson(tVar.f3781c));
                Uri uri = tVar.f3784f;
                if (uri != null) {
                    hashMap2.put("dataUri", uri.toString());
                }
                String str2 = tVar.f3783e;
                if (str2 != null) {
                    hashMap2.put("dataMimeType", str2);
                }
                arrayList.add(hashMap2);
            }
            hashMap.put("messages", arrayList);
            result.success(hashMap);
        } catch (Throwable th) {
            result.error(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private void getActiveNotifications(MethodChannel.Result result) {
        String channelId;
        try {
            StatusBarNotification[] activeNotifications = ((NotificationManager) this.applicationContext.getSystemService("notification")).getActiveNotifications();
            ArrayList arrayList = new ArrayList();
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                HashMap hashMap = new HashMap();
                hashMap.put(CANCEL_ID, Integer.valueOf(statusBarNotification.getId()));
                Notification notification = statusBarNotification.getNotification();
                if (Build.VERSION.SDK_INT >= 26) {
                    channelId = notification.getChannelId();
                    hashMap.put("channelId", channelId);
                }
                hashMap.put(CANCEL_TAG, statusBarNotification.getTag());
                hashMap.put("groupKey", notification.getGroup());
                hashMap.put("title", notification.extras.getCharSequence("android.title"));
                hashMap.put("body", notification.extras.getCharSequence("android.text"));
                hashMap.put("bigText", notification.extras.getCharSequence("android.bigText"));
                arrayList.add(hashMap);
            }
            result.success(arrayList);
        } catch (Throwable th) {
            result.error(UNSUPPORTED_OS_VERSION_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private static AlarmManager getAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService("alarm");
    }

    private static Bitmap getBitmapFromSource(Context context, Object obj, BitmapSource bitmapSource) {
        if (bitmapSource == BitmapSource.DrawableResource) {
            return BitmapFactory.decodeResource(context.getResources(), getDrawableResourceId(context, (String) obj));
        }
        if (bitmapSource == BitmapSource.FilePath) {
            return BitmapFactory.decodeFile((String) obj);
        }
        if (bitmapSource == BitmapSource.ByteArray) {
            byte[] castObjectToByteArray = castObjectToByteArray(obj);
            return BitmapFactory.decodeByteArray(castObjectToByteArray, 0, castObjectToByteArray.length);
        }
        return null;
    }

    private static PendingIntent getBroadcastPendingIntent(Context context, int i2, Intent intent) {
        return PendingIntent.getBroadcast(context, i2, intent, 201326592);
    }

    private void getCallbackHandle(MethodChannel.Result result) {
        result.success(new IsolatePreferences(this.applicationContext).getCallbackHandle());
    }

    private static int getDrawableResourceId(Context context, String str) {
        return context.getResources().getIdentifier(str, DRAWABLE, context.getPackageName());
    }

    private static IconCompat getIconFromSource(Context context, Object obj, IconSource iconSource) {
        int i2 = AnonymousClass6.$SwitchMap$com$dexterous$flutterlocalnotifications$models$IconSource[iconSource.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        byte[] castObjectToByteArray = castObjectToByteArray(obj);
                        int length = castObjectToByteArray.length;
                        IconCompat iconCompat = new IconCompat(3);
                        iconCompat.f1290b = castObjectToByteArray;
                        iconCompat.f1293e = 0;
                        iconCompat.f1294f = length;
                        return iconCompat;
                    }
                    try {
                        AssetFileDescriptor openFd = context.getAssets().openFd(FlutterInjector.instance().flutterLoader().getLookupKeyForAsset((String) obj));
                        FileInputStream createInputStream = openFd.createInputStream();
                        IconCompat d2 = IconCompat.d(BitmapFactory.decodeStream(createInputStream));
                        createInputStream.close();
                        openFd.close();
                        return d2;
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                String str = (String) obj;
                PorterDuff.Mode mode = IconCompat.f1288k;
                str.getClass();
                IconCompat iconCompat2 = new IconCompat(4);
                iconCompat2.f1290b = str;
                return iconCompat2;
            }
            return IconCompat.d(BitmapFactory.decodeFile((String) obj));
        }
        int drawableResourceId = getDrawableResourceId(context, (String) obj);
        PorterDuff.Mode mode2 = IconCompat.f1288k;
        context.getClass();
        return IconCompat.e(context.getResources(), context.getPackageName(), drawableResourceId);
    }

    private static Intent getLaunchIntent(Context context) {
        return context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    }

    private HashMap<String, Object> getMappedNotificationChannel(NotificationChannel notificationChannel) {
        String id;
        CharSequence name;
        String description;
        String group;
        boolean canShowBadge;
        int importance;
        Uri sound;
        boolean canBypassDnd;
        boolean shouldVibrate;
        long[] vibrationPattern;
        boolean shouldShowLights;
        int lightColor;
        AudioAttributes audioAttributes;
        int usage;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (Build.VERSION.SDK_INT >= 26) {
            id = notificationChannel.getId();
            hashMap.put(CANCEL_ID, id);
            name = notificationChannel.getName();
            hashMap.put("name", name);
            description = notificationChannel.getDescription();
            hashMap.put("description", description);
            group = notificationChannel.getGroup();
            hashMap.put("groupId", group);
            canShowBadge = notificationChannel.canShowBadge();
            hashMap.put("showBadge", Boolean.valueOf(canShowBadge));
            importance = notificationChannel.getImportance();
            hashMap.put("importance", Integer.valueOf(importance));
            sound = notificationChannel.getSound();
            if (sound == null) {
                hashMap.put("sound", null);
                hashMap.put("playSound", Boolean.FALSE);
            } else {
                hashMap.put("playSound", Boolean.TRUE);
                List asList = Arrays.asList(SoundSource.values());
                if (sound.getScheme().equals("android.resource")) {
                    String str = sound.toString().split("/")[r1.length - 1];
                    Integer tryParseInt = tryParseInt(str);
                    if (tryParseInt == null) {
                        hashMap.put("soundSource", Integer.valueOf(asList.indexOf(SoundSource.RawResource)));
                        hashMap.put("sound", str);
                    } else {
                        try {
                            String resourceEntryName = this.applicationContext.getResources().getResourceEntryName(tryParseInt.intValue());
                            if (resourceEntryName != null) {
                                hashMap.put("soundSource", Integer.valueOf(asList.indexOf(SoundSource.RawResource)));
                                hashMap.put("sound", resourceEntryName);
                            }
                        } catch (Exception unused) {
                            hashMap.put("sound", null);
                            hashMap.put("playSound", Boolean.FALSE);
                        }
                    }
                } else {
                    hashMap.put("soundSource", Integer.valueOf(asList.indexOf(SoundSource.Uri)));
                    hashMap.put("sound", sound.toString());
                }
            }
            canBypassDnd = notificationChannel.canBypassDnd();
            hashMap.put("bypassDnd", Boolean.valueOf(canBypassDnd));
            shouldVibrate = notificationChannel.shouldVibrate();
            hashMap.put("enableVibration", Boolean.valueOf(shouldVibrate));
            vibrationPattern = notificationChannel.getVibrationPattern();
            hashMap.put("vibrationPattern", vibrationPattern);
            shouldShowLights = notificationChannel.shouldShowLights();
            hashMap.put("enableLights", Boolean.valueOf(shouldShowLights));
            lightColor = notificationChannel.getLightColor();
            hashMap.put("ledColor", Integer.valueOf(lightColor));
            audioAttributes = notificationChannel.getAudioAttributes();
            if (audioAttributes == null) {
                usage = 5;
            } else {
                usage = audioAttributes.getUsage();
            }
            hashMap.put("audioAttributesUsage", Integer.valueOf(usage));
        }
        return hashMap;
    }

    private static String getNextFireDate(NotificationDetails notificationDetails) {
        ScheduledNotificationRepeatFrequency scheduledNotificationRepeatFrequency = notificationDetails.scheduledNotificationRepeatFrequency;
        if (scheduledNotificationRepeatFrequency == ScheduledNotificationRepeatFrequency.Daily) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.parse(notificationDetails.scheduledDateTime).plusDays(1L));
        }
        if (scheduledNotificationRepeatFrequency == ScheduledNotificationRepeatFrequency.Weekly) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.parse(notificationDetails.scheduledDateTime).plusWeeks(1L));
        }
        return null;
    }

    private static String getNextFireDateMatchingDateTimeComponents(NotificationDetails notificationDetails) {
        ZoneId of = ZoneId.of(notificationDetails.timeZoneName);
        ZonedDateTime of2 = ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), of);
        ZonedDateTime now = ZonedDateTime.now(of);
        ZonedDateTime of3 = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), of2.getHour(), of2.getMinute(), of2.getSecond(), of2.getNano(), of);
        while (of3.isBefore(now)) {
            of3 = of3.plusDays(1L);
        }
        DateTimeComponents dateTimeComponents = notificationDetails.matchDateTimeComponents;
        if (dateTimeComponents == DateTimeComponents.Time) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
        }
        if (dateTimeComponents == DateTimeComponents.DayOfWeekAndTime) {
            while (of3.getDayOfWeek() != of2.getDayOfWeek()) {
                of3 = of3.plusDays(1L);
            }
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
        }
        if (dateTimeComponents == DateTimeComponents.DayOfMonthAndTime) {
            while (of3.getDayOfMonth() != of2.getDayOfMonth()) {
                of3 = of3.plusDays(1L);
            }
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
        }
        if (dateTimeComponents != DateTimeComponents.DateAndTime) {
            return null;
        }
        while (true) {
            if (of3.getMonthValue() == of2.getMonthValue() && of3.getDayOfMonth() == of2.getDayOfMonth()) {
                return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(of3);
            }
            of3 = of3.plusDays(1L);
        }
    }

    private void getNotificationAppLaunchDetails(MethodChannel.Result result) {
        boolean z;
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.FALSE;
        Activity activity = this.mainActivity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null && ((SELECT_NOTIFICATION.equals(intent.getAction()) || SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) && !launchedActivityFromHistory(intent))) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (z) {
                hashMap.put("notificationResponse", extractNotificationResponseMap(intent));
            }
            bool = valueOf;
        }
        hashMap.put(NOTIFICATION_LAUNCHED_APP, bool);
        result.success(hashMap);
    }

    private void getNotificationChannels(MethodChannel.Result result) {
        List list;
        try {
            H notificationManager = getNotificationManager(this.applicationContext);
            if (Build.VERSION.SDK_INT >= 26) {
                list = AbstractC0015o.c(notificationManager.f3699b);
            } else {
                notificationManager.getClass();
                list = Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getMappedNotificationChannel(a.d(it.next())));
            }
            result.success(arrayList);
        } catch (Throwable th) {
            result.error(GET_NOTIFICATION_CHANNELS_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private static H getNotificationManager(Context context) {
        return new H(context);
    }

    private boolean hasInvalidBigPictureResources(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (notificationDetails.style == NotificationStyle.BigPicture) {
            BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
            if (hasInvalidLargeIcon(result, bigPictureStyleInformation.largeIcon, bigPictureStyleInformation.largeIconBitmapSource)) {
                return true;
            }
            BitmapSource bitmapSource = bigPictureStyleInformation.bigPictureBitmapSource;
            if (bitmapSource == BitmapSource.DrawableResource) {
                String str = (String) bigPictureStyleInformation.bigPicture;
                if (!StringUtils.isNullOrEmpty(str).booleanValue() || isValidDrawableResource(this.applicationContext, str, result, INVALID_BIG_PICTURE_ERROR_CODE)) {
                    return false;
                }
                return true;
            }
            if (bitmapSource == BitmapSource.FilePath) {
                return StringUtils.isNullOrEmpty((String) bigPictureStyleInformation.bigPicture).booleanValue();
            }
            if (bitmapSource == BitmapSource.ByteArray) {
                byte[] bArr = (byte[]) bigPictureStyleInformation.bigPicture;
                if (bArr != null && bArr.length != 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean hasInvalidIcon(MethodChannel.Result result, String str) {
        if (!StringUtils.isNullOrEmpty(str).booleanValue() && !isValidDrawableResource(this.applicationContext, str, result, INVALID_ICON_ERROR_CODE)) {
            return true;
        }
        return false;
    }

    private boolean hasInvalidLargeIcon(MethodChannel.Result result, Object obj, BitmapSource bitmapSource) {
        BitmapSource bitmapSource2 = BitmapSource.DrawableResource;
        if (bitmapSource != bitmapSource2 && bitmapSource != BitmapSource.FilePath) {
            if (bitmapSource == BitmapSource.ByteArray && ((byte[]) obj).length == 0) {
                return true;
            }
            return false;
        }
        String str = (String) obj;
        if (!StringUtils.isNullOrEmpty(str).booleanValue() && bitmapSource == bitmapSource2 && !isValidDrawableResource(this.applicationContext, str, result, INVALID_LARGE_ICON_ERROR_CODE)) {
            return true;
        }
        return false;
    }

    private boolean hasInvalidLedDetails(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (notificationDetails.ledColor != null) {
            if (notificationDetails.ledOnMs == null || notificationDetails.ledOffMs == null) {
                result.error(INVALID_LED_DETAILS_ERROR_CODE, INVALID_LED_DETAILS_ERROR_MESSAGE, null);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean hasInvalidRawSoundResource(MethodChannel.Result result, NotificationDetails notificationDetails) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.sound).booleanValue()) {
            SoundSource soundSource = notificationDetails.soundSource;
            if ((soundSource == null || soundSource == SoundSource.RawResource) && this.applicationContext.getResources().getIdentifier(notificationDetails.sound, "raw", this.applicationContext.getPackageName()) == 0) {
                result.error(INVALID_SOUND_ERROR_CODE, O.a.g("The resource ", notificationDetails.sound, " could not be found. Please make sure it has been added as a raw resource to your Android head project."), null);
                return true;
            }
            return false;
        }
        return false;
    }

    private void initialize(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) ((Map) methodCall.arguments()).get(DEFAULT_ICON);
        if (!isValidDrawableResource(this.applicationContext, str, result, INVALID_ICON_ERROR_CODE)) {
            return;
        }
        Long parseLong = LongUtils.parseLong(methodCall.argument(DISPATCHER_HANDLE));
        Long parseLong2 = LongUtils.parseLong(methodCall.argument(CALLBACK_HANDLE));
        if (parseLong != null && parseLong2 != null) {
            new IsolatePreferences(this.applicationContext).saveCallbackKeys(parseLong, parseLong2);
        }
        this.applicationContext.getSharedPreferences(SHARED_PREFERENCES_KEY, 0).edit().putString(DEFAULT_ICON, str).apply();
        result.success(Boolean.TRUE);
    }

    private static boolean isValidDrawableResource(Context context, String str, MethodChannel.Result result, String str2) {
        if (context.getResources().getIdentifier(str, DRAWABLE, context.getPackageName()) == 0) {
            result.error(str2, O.a.g("The resource ", str, " could not be found. Please make sure it has been added as a drawable resource to your Android head project."), null);
            return false;
        }
        return true;
    }

    private static boolean launchedActivityFromHistory(Intent intent) {
        if (intent != null && (intent.getFlags() & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    private static ArrayList<NotificationDetails> loadScheduledNotifications(Context context) {
        ArrayList<NotificationDetails> arrayList = new ArrayList<>();
        String string = context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0).getString(SCHEDULED_NOTIFICATIONS, null);
        if (string != null) {
            return (ArrayList) buildGson().fromJson(string, new TypeToken<ArrayList<NotificationDetails>>() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.1
            }.getType());
        }
        return arrayList;
    }

    private void pendingNotificationRequests(MethodChannel.Result result) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        ArrayList arrayList = new ArrayList();
        int size = loadScheduledNotifications.size();
        int i2 = 0;
        while (i2 < size) {
            NotificationDetails notificationDetails = loadScheduledNotifications.get(i2);
            i2++;
            NotificationDetails notificationDetails2 = notificationDetails;
            HashMap hashMap = new HashMap();
            hashMap.put(CANCEL_ID, notificationDetails2.id);
            hashMap.put("title", notificationDetails2.title);
            hashMap.put("body", notificationDetails2.body);
            hashMap.put(PAYLOAD, notificationDetails2.payload);
            arrayList.add(hashMap);
        }
        result.success(arrayList);
    }

    private void processForegroundNotificationAction(Intent intent, Map<String, Object> map) {
        if (intent.getBooleanExtra(CANCEL_NOTIFICATION, false)) {
            new H(this.applicationContext).a(((Integer) map.get(NOTIFICATION_ID)).intValue(), null);
        }
    }

    public static void removeNotificationFromCache(Context context, Integer num) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(context);
        Iterator<NotificationDetails> it = loadScheduledNotifications.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().id.equals(num)) {
                it.remove();
                break;
            }
        }
        saveScheduledNotifications(context, loadScheduledNotifications);
    }

    private void repeat(MethodCall methodCall, MethodChannel.Result result) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(result, (Map) methodCall.arguments());
        if (extractNotificationDetails != null) {
            try {
                repeatNotification(this.applicationContext, extractNotificationDetails, Boolean.TRUE);
                result.success(null);
            } catch (PluginException e2) {
                result.error(e2.code, e2.getMessage(), null);
            }
        }
    }

    private static void repeatNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        long calculateRepeatIntervalMilliseconds = calculateRepeatIntervalMilliseconds(notificationDetails);
        long longValue = notificationDetails.calledAt.longValue();
        if (notificationDetails.repeatTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(11, notificationDetails.repeatTime.hour.intValue());
            calendar.set(12, notificationDetails.repeatTime.minute.intValue());
            calendar.set(13, notificationDetails.repeatTime.second.intValue());
            Integer num = notificationDetails.day;
            if (num != null) {
                calendar.set(7, num.intValue());
            }
            longValue = calendar.getTimeInMillis();
        }
        long calculateNextNotificationTrigger = calculateNextNotificationTrigger(longValue, calculateRepeatIntervalMilliseconds);
        String json = buildGson().toJson(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.inexact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, calculateNextNotificationTrigger, broadcastPendingIntent);
        } else {
            alarmManager.setInexactRepeating(0, calculateNextNotificationTrigger, calculateRepeatIntervalMilliseconds, broadcastPendingIntent);
        }
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    public static void rescheduleNotifications(Context context) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(context);
        int size = loadScheduledNotifications.size();
        int i2 = 0;
        while (i2 < size) {
            NotificationDetails notificationDetails = loadScheduledNotifications.get(i2);
            i2++;
            NotificationDetails notificationDetails2 = notificationDetails;
            try {
            } catch (ExactAlarmPermissionException e2) {
                Log.e(TAG, e2.getMessage());
                removeNotificationFromCache(context, notificationDetails2.id);
            }
            if (notificationDetails2.repeatInterval == null && notificationDetails2.repeatIntervalMilliseconds == null) {
                if (notificationDetails2.timeZoneName != null) {
                    zonedScheduleNotification(context, notificationDetails2, Boolean.FALSE);
                } else {
                    scheduleNotification(context, notificationDetails2, Boolean.FALSE);
                }
            }
            repeatNotification(context, notificationDetails2, Boolean.FALSE);
        }
    }

    private static Uri retrieveSoundResourceUri(Context context, String str, SoundSource soundSource) {
        if (StringUtils.isNullOrEmpty(str).booleanValue()) {
            return RingtoneManager.getDefaultUri(2);
        }
        if (soundSource != null && soundSource != SoundSource.RawResource) {
            if (soundSource == SoundSource.Uri) {
                return Uri.parse(str);
            }
            return null;
        }
        return Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
    }

    private static void saveScheduledNotification(Context context, NotificationDetails notificationDetails) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(context);
        ArrayList arrayList = new ArrayList();
        int size = loadScheduledNotifications.size();
        int i2 = 0;
        while (i2 < size) {
            NotificationDetails notificationDetails2 = loadScheduledNotifications.get(i2);
            i2++;
            NotificationDetails notificationDetails3 = notificationDetails2;
            if (!notificationDetails3.id.equals(notificationDetails.id)) {
                arrayList.add(notificationDetails3);
            }
        }
        arrayList.add(notificationDetails);
        saveScheduledNotifications(context, arrayList);
    }

    private static void saveScheduledNotifications(Context context, ArrayList<NotificationDetails> arrayList) {
        context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0).edit().putString(SCHEDULED_NOTIFICATIONS, buildGson().toJson(arrayList)).apply();
    }

    public static void scheduleNextNotification(Context context, NotificationDetails notificationDetails) {
        try {
            if (notificationDetails.scheduledNotificationRepeatFrequency != null) {
                zonedScheduleNextNotification(context, notificationDetails);
                return;
            }
            if (notificationDetails.matchDateTimeComponents != null) {
                zonedScheduleNextNotificationMatchingDateComponents(context, notificationDetails);
                return;
            }
            if (notificationDetails.repeatInterval == null && notificationDetails.repeatIntervalMilliseconds == null) {
                removeNotificationFromCache(context, notificationDetails.id);
                return;
            }
            scheduleNextRepeatingNotification(context, notificationDetails);
        } catch (ExactAlarmPermissionException e2) {
            Log.e(TAG, e2.getMessage());
            removeNotificationFromCache(context, notificationDetails.id);
        }
    }

    private static void scheduleNextRepeatingNotification(Context context, NotificationDetails notificationDetails) {
        long calculateNextNotificationTrigger = calculateNextNotificationTrigger(notificationDetails.calledAt.longValue(), calculateRepeatIntervalMilliseconds(notificationDetails));
        String json = buildGson().toJson(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exactAllowWhileIdle;
        }
        setupAllowWhileIdleAlarm(notificationDetails, alarmManager, calculateNextNotificationTrigger, broadcastPendingIntent);
        saveScheduledNotification(context, notificationDetails);
    }

    private static void scheduleNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        String json = buildGson().toJson(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        setupAlarm(notificationDetails, getAlarmManager(context), notificationDetails.millisecondsSinceEpoch.longValue(), getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent));
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    private Boolean sendNotificationPayloadMessage(Intent intent) {
        if (!SELECT_NOTIFICATION.equals(intent.getAction()) && !SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            return Boolean.FALSE;
        }
        Map<String, Object> extractNotificationResponseMap = extractNotificationResponseMap(intent);
        if (SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            processForegroundNotificationAction(intent, extractNotificationResponseMap);
        }
        this.channel.invokeMethod("didReceiveNotificationResponse", extractNotificationResponseMap);
        return Boolean.TRUE;
    }

    private void setActivity(Activity activity) {
        this.mainActivity = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [u.z, u.h] */
    private static void setBigPictureStyle(Context context, NotificationDetails notificationDetails, C0319j c0319j) {
        IconCompat d2;
        CharSequence charSequence;
        CharSequence charSequence2;
        BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
        ?? zVar = new z();
        if (bigPictureStyleInformation.contentTitle != null) {
            if (bigPictureStyleInformation.htmlFormatContentTitle.booleanValue()) {
                charSequence2 = fromHtml(bigPictureStyleInformation.contentTitle);
            } else {
                charSequence2 = bigPictureStyleInformation.contentTitle;
            }
            zVar.f3805b = C0319j.b(charSequence2);
        }
        if (bigPictureStyleInformation.summaryText != null) {
            if (bigPictureStyleInformation.htmlFormatSummaryText.booleanValue()) {
                charSequence = fromHtml(bigPictureStyleInformation.summaryText);
            } else {
                charSequence = bigPictureStyleInformation.summaryText;
            }
            zVar.f3806c = C0319j.b(charSequence);
            zVar.f3807d = true;
        }
        IconCompat iconCompat = null;
        if (bigPictureStyleInformation.hideExpandedLargeIcon.booleanValue()) {
            zVar.f3733f = null;
            zVar.f3734g = true;
        } else {
            Object obj = bigPictureStyleInformation.largeIcon;
            if (obj != null) {
                Bitmap bitmapFromSource = getBitmapFromSource(context, obj, bigPictureStyleInformation.largeIconBitmapSource);
                if (bitmapFromSource == null) {
                    d2 = null;
                } else {
                    d2 = IconCompat.d(bitmapFromSource);
                }
                zVar.f3733f = d2;
                zVar.f3734g = true;
            }
        }
        Bitmap bitmapFromSource2 = getBitmapFromSource(context, bigPictureStyleInformation.bigPicture, bigPictureStyleInformation.bigPictureBitmapSource);
        if (bitmapFromSource2 != null) {
            iconCompat = IconCompat.d(bitmapFromSource2);
        }
        zVar.f3732e = iconCompat;
        c0319j.f(zVar);
    }

    private static void setBigTextStyle(NotificationDetails notificationDetails, C0319j c0319j) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        BigTextStyleInformation bigTextStyleInformation = (BigTextStyleInformation) notificationDetails.styleInformation;
        C0318i c0318i = new C0318i(0);
        if (bigTextStyleInformation.bigText != null) {
            if (bigTextStyleInformation.htmlFormatBigText.booleanValue()) {
                charSequence3 = fromHtml(bigTextStyleInformation.bigText);
            } else {
                charSequence3 = bigTextStyleInformation.bigText;
            }
            c0318i.f3737f = C0319j.b(charSequence3);
        }
        if (bigTextStyleInformation.contentTitle != null) {
            if (bigTextStyleInformation.htmlFormatContentTitle.booleanValue()) {
                charSequence2 = fromHtml(bigTextStyleInformation.contentTitle);
            } else {
                charSequence2 = bigTextStyleInformation.contentTitle;
            }
            c0318i.f3805b = C0319j.b(charSequence2);
        }
        if (bigTextStyleInformation.summaryText != null) {
            if (bigTextStyleInformation.htmlFormatSummaryText.booleanValue()) {
                charSequence = fromHtml(bigTextStyleInformation.summaryText);
            } else {
                charSequence = bigTextStyleInformation.summaryText;
            }
            c0318i.f3806c = C0319j.b(charSequence);
            c0318i.f3807d = true;
        }
        c0319j.f(c0318i);
    }

    private void setCanScheduleExactNotifications(MethodChannel.Result result) {
        boolean canScheduleExactAlarms;
        if (Build.VERSION.SDK_INT >= 31) {
            canScheduleExactAlarms = getAlarmManager(this.applicationContext).canScheduleExactAlarms();
            result.success(Boolean.valueOf(canScheduleExactAlarms));
        } else {
            result.success(Boolean.TRUE);
        }
    }

    private static void setCategory(NotificationDetails notificationDetails, C0319j c0319j) {
        String str = notificationDetails.category;
        if (str == null) {
            return;
        }
        c0319j.f3768x = str;
    }

    private static void setInboxStyle(NotificationDetails notificationDetails, C0319j c0319j) {
        CharSequence charSequence;
        CharSequence charSequence2;
        InboxStyleInformation inboxStyleInformation = (InboxStyleInformation) notificationDetails.styleInformation;
        C0318i c0318i = new C0318i(1);
        if (inboxStyleInformation.contentTitle != null) {
            if (inboxStyleInformation.htmlFormatContentTitle.booleanValue()) {
                charSequence2 = fromHtml(inboxStyleInformation.contentTitle);
            } else {
                charSequence2 = inboxStyleInformation.contentTitle;
            }
            c0318i.f3805b = C0319j.b(charSequence2);
        }
        if (inboxStyleInformation.summaryText != null) {
            if (inboxStyleInformation.htmlFormatSummaryText.booleanValue()) {
                charSequence = fromHtml(inboxStyleInformation.summaryText);
            } else {
                charSequence = inboxStyleInformation.summaryText;
            }
            c0318i.f3806c = C0319j.b(charSequence);
            c0318i.f3807d = true;
        }
        ArrayList<String> arrayList = inboxStyleInformation.lines;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                String str = arrayList.get(i2);
                i2++;
                String str2 = str;
                CharSequence charSequence3 = str2;
                if (inboxStyleInformation.htmlFormatLines.booleanValue()) {
                    charSequence3 = fromHtml(str2);
                }
                if (charSequence3 != null) {
                    ((ArrayList) c0318i.f3737f).add(C0319j.b(charSequence3));
                }
            }
        }
        c0319j.f(c0318i);
    }

    private static void setLights(NotificationDetails notificationDetails, C0319j c0319j) {
        int i2;
        if (BooleanUtils.getValue(notificationDetails.enableLights) && notificationDetails.ledOnMs != null && notificationDetails.ledOffMs != null) {
            int intValue = notificationDetails.ledColor.intValue();
            int intValue2 = notificationDetails.ledOnMs.intValue();
            int intValue3 = notificationDetails.ledOffMs.intValue();
            Notification notification = c0319j.f3744G;
            notification.ledARGB = intValue;
            notification.ledOnMS = intValue2;
            notification.ledOffMS = intValue3;
            if (intValue2 != 0 && intValue3 != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            notification.flags = i2 | (notification.flags & (-2));
        }
    }

    private static void setMediaStyle(C0319j c0319j) {
        c0319j.f(new V.a(0));
    }

    private static void setMessagingStyle(Context context, NotificationDetails notificationDetails, C0319j c0319j) {
        MessagingStyleInformation messagingStyleInformation = (MessagingStyleInformation) notificationDetails.styleInformation;
        u uVar = new u(buildPerson(context, messagingStyleInformation.person));
        uVar.f3789i = Boolean.valueOf(BooleanUtils.getValue(messagingStyleInformation.groupConversation));
        String str = messagingStyleInformation.conversationTitle;
        if (str != null) {
            uVar.f3788h = str;
        }
        ArrayList<MessageDetails> arrayList = messagingStyleInformation.messages;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<MessageDetails> arrayList2 = messagingStyleInformation.messages;
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                MessageDetails messageDetails = arrayList2.get(i2);
                i2++;
                t createMessage = createMessage(context, messageDetails);
                if (createMessage != null) {
                    ArrayList arrayList3 = uVar.f3785e;
                    arrayList3.add(createMessage);
                    if (arrayList3.size() > 25) {
                        arrayList3.remove(0);
                    }
                }
            }
        }
        c0319j.f(uVar);
    }

    private static void setProgress(NotificationDetails notificationDetails, C0319j c0319j) {
        if (BooleanUtils.getValue(notificationDetails.showProgress)) {
            int intValue = notificationDetails.maxProgress.intValue();
            int intValue2 = notificationDetails.progress.intValue();
            boolean booleanValue = notificationDetails.indeterminate.booleanValue();
            c0319j.p = intValue;
            c0319j.q = intValue2;
            c0319j.f3762r = booleanValue;
        }
    }

    private static void setSmallIcon(Context context, NotificationDetails notificationDetails, C0319j c0319j) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.icon).booleanValue()) {
            c0319j.f3744G.icon = getDrawableResourceId(context, notificationDetails.icon);
            return;
        }
        String string = context.getSharedPreferences(SHARED_PREFERENCES_KEY, 0).getString(DEFAULT_ICON, null);
        if (StringUtils.isNullOrEmpty(string).booleanValue()) {
            c0319j.f3744G.icon = notificationDetails.iconResourceId.intValue();
        } else {
            c0319j.f3744G.icon = getDrawableResourceId(context, string);
        }
    }

    private static void setSound(Context context, NotificationDetails notificationDetails, C0319j c0319j) {
        if (BooleanUtils.getValue(notificationDetails.playSound)) {
            c0319j.e(retrieveSoundResourceUri(context, notificationDetails.sound, notificationDetails.soundSource));
        } else {
            c0319j.e(null);
        }
    }

    private static void setStyle(Context context, NotificationDetails notificationDetails, C0319j c0319j) {
        int i2 = AnonymousClass6.$SwitchMap$com$dexterous$flutterlocalnotifications$models$NotificationStyle[notificationDetails.style.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                        setMediaStyle(c0319j);
                        return;
                    }
                    setMessagingStyle(context, notificationDetails, c0319j);
                    return;
                }
                setInboxStyle(notificationDetails, c0319j);
                return;
            }
            setBigTextStyle(notificationDetails, c0319j);
            return;
        }
        setBigPictureStyle(context, notificationDetails, c0319j);
    }

    private static void setTimeoutAfter(NotificationDetails notificationDetails, C0319j c0319j) {
        Long l2 = notificationDetails.timeoutAfter;
        if (l2 == null) {
            return;
        }
        c0319j.f3741D = l2.longValue();
    }

    private static void setVibrationPattern(NotificationDetails notificationDetails, C0319j c0319j) {
        if (BooleanUtils.getValue(notificationDetails.enableVibration)) {
            long[] jArr = notificationDetails.vibrationPattern;
            if (jArr != null && jArr.length > 0) {
                c0319j.f3744G.vibrate = jArr;
                return;
            }
            return;
        }
        c0319j.f3744G.vibrate = new long[]{0};
    }

    private static void setVisibility(NotificationDetails notificationDetails, C0319j c0319j) {
        int i2;
        Integer num = notificationDetails.visibility;
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            i2 = 1;
            if (intValue != 1) {
                if (intValue == 2) {
                    i2 = -1;
                } else {
                    throw new IllegalArgumentException("Unknown index: " + notificationDetails.visibility);
                }
            }
        } else {
            i2 = 0;
        }
        c0319j.f3738A = i2;
    }

    private static void setupAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long j2, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, j2, pendingIntent);
            return;
        }
        if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setExact(0, j2, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j2, pendingIntent), pendingIntent);
        } else {
            alarmManager.set(0, j2, pendingIntent);
        }
    }

    private static void setupAllowWhileIdleAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long j2, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setExactAndAllowWhileIdle(0, j2, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j2, pendingIntent), pendingIntent);
        } else {
            alarmManager.setAndAllowWhileIdle(0, j2, pendingIntent);
        }
    }

    private static void setupNotificationChannel(Context context, NotificationChannelDetails notificationChannelDetails) {
        Integer num;
        int i2;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            C.a.v();
            NotificationChannel b2 = C.a.b(notificationChannelDetails.id, notificationChannelDetails.name, notificationChannelDetails.importance.intValue());
            b2.setDescription(notificationChannelDetails.description);
            b2.setGroup(notificationChannelDetails.groupId);
            if (!notificationChannelDetails.playSound.booleanValue()) {
                b2.setSound(null, null);
            } else {
                Integer num2 = notificationChannelDetails.audioAttributesUsage;
                if (num2 != null) {
                    i2 = num2.intValue();
                } else {
                    i2 = 5;
                }
                b2.setSound(retrieveSoundResourceUri(context, notificationChannelDetails.sound, notificationChannelDetails.soundSource), new AudioAttributes.Builder().setUsage(i2).build());
            }
            if (BooleanUtils.getValue(notificationChannelDetails.bypassDnd)) {
                if (notificationManager.isNotificationPolicyAccessGranted()) {
                    b2.setBypassDnd(true);
                } else {
                    Log.w(TAG, "Channel '" + notificationChannelDetails.name + "' was set to bypass Do Not Disturb but the OS prevents it.");
                }
            }
            b2.enableVibration(BooleanUtils.getValue(notificationChannelDetails.enableVibration));
            long[] jArr = notificationChannelDetails.vibrationPattern;
            if (jArr != null && jArr.length > 0) {
                b2.setVibrationPattern(jArr);
            }
            boolean value = BooleanUtils.getValue(notificationChannelDetails.enableLights);
            b2.enableLights(value);
            if (value && (num = notificationChannelDetails.ledColor) != null) {
                b2.setLightColor(num.intValue());
            }
            b2.setShowBadge(BooleanUtils.getValue(notificationChannelDetails.showBadge));
            notificationManager.createNotificationChannel(b2);
        }
    }

    private void show(MethodCall methodCall, MethodChannel.Result result) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(result, (Map) methodCall.arguments());
        if (extractNotificationDetails != null) {
            showNotification(this.applicationContext, extractNotificationDetails);
            result.success(null);
        }
    }

    public static void showNotification(Context context, NotificationDetails notificationDetails) {
        Notification createNotification = createNotification(context, notificationDetails);
        H notificationManager = getNotificationManager(context);
        String str = notificationDetails.tag;
        if (str != null) {
            notificationManager.b(str, notificationDetails.id.intValue(), createNotification);
        } else {
            notificationManager.b(null, notificationDetails.id.intValue(), createNotification);
        }
    }

    private void startForegroundService(MethodCall methodCall, MethodChannel.Result result) {
        Map<String, Object> map = (Map) methodCall.argument("notificationData");
        Integer num = (Integer) methodCall.argument("startType");
        ArrayList arrayList = (ArrayList) methodCall.argument("foregroundServiceTypes");
        if (arrayList != null && arrayList.size() == 0) {
            result.error("ARGUMENT_ERROR", "If foregroundServiceTypes is non-null it must not be empty!", null);
            return;
        }
        if (map != null && num != null) {
            NotificationDetails extractNotificationDetails = extractNotificationDetails(result, map);
            if (extractNotificationDetails != null) {
                if (extractNotificationDetails.id.intValue() != 0) {
                    ForegroundServiceStartParameter foregroundServiceStartParameter = new ForegroundServiceStartParameter(extractNotificationDetails, num.intValue(), arrayList);
                    Intent intent = new Intent(this.applicationContext, (Class<?>) ForegroundService.class);
                    intent.putExtra(ForegroundServiceStartParameter.EXTRA, foregroundServiceStartParameter);
                    Context context = this.applicationContext;
                    if (Build.VERSION.SDK_INT >= 26) {
                        AbstractC0015o.v(context, intent);
                    } else {
                        context.startService(intent);
                    }
                    result.success(null);
                    return;
                }
                result.error("ARGUMENT_ERROR", "The id of the notification for a foreground service must not be 0!", null);
                return;
            }
            return;
        }
        result.error("ARGUMENT_ERROR", "An argument passed to startForegroundService was null!", null);
    }

    private void stopForegroundService(MethodChannel.Result result) {
        this.applicationContext.stopService(new Intent(this.applicationContext, (Class<?>) ForegroundService.class));
        result.success(null);
    }

    private Integer tryParseInt(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private void zonedSchedule(MethodCall methodCall, MethodChannel.Result result) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(result, (Map) methodCall.arguments());
        if (extractNotificationDetails != null) {
            if (extractNotificationDetails.matchDateTimeComponents != null) {
                extractNotificationDetails.scheduledDateTime = getNextFireDateMatchingDateTimeComponents(extractNotificationDetails);
            }
            try {
                zonedScheduleNotification(this.applicationContext, extractNotificationDetails, Boolean.TRUE);
                result.success(null);
            } catch (PluginException e2) {
                result.error(e2.code, e2.getMessage(), null);
            }
        }
    }

    private static void zonedScheduleNextNotification(Context context, NotificationDetails notificationDetails) {
        String nextFireDate = getNextFireDate(notificationDetails);
        if (nextFireDate == null) {
            return;
        }
        notificationDetails.scheduledDateTime = nextFireDate;
        zonedScheduleNotification(context, notificationDetails, Boolean.TRUE);
    }

    private static void zonedScheduleNextNotificationMatchingDateComponents(Context context, NotificationDetails notificationDetails) {
        String nextFireDateMatchingDateTimeComponents = getNextFireDateMatchingDateTimeComponents(notificationDetails);
        if (nextFireDateMatchingDateTimeComponents == null) {
            return;
        }
        notificationDetails.scheduledDateTime = nextFireDateMatchingDateTimeComponents;
        zonedScheduleNotification(context, notificationDetails, Boolean.TRUE);
    }

    private static void zonedScheduleNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        String json = buildGson().toJson(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, json);
        setupAlarm(notificationDetails, getAlarmManager(context), ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), ZoneId.of(notificationDetails.timeZoneName)).toInstant().toEpochMilli(), getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent));
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    public void hasNotificationPolicyAccess(MethodChannel.Result result) {
        result.success(Boolean.valueOf(((NotificationManager) this.applicationContext.getSystemService("notification")).isNotificationPolicyAccessGranted()));
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i2, int i3, Intent intent) {
        boolean canUseFullScreenIntent;
        boolean canScheduleExactAlarms;
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            return false;
        }
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingExactAlarmsPermission && i2 == 2 && Build.VERSION.SDK_INT >= 31) {
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            PermissionRequestListener permissionRequestListener = this.callback;
            canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
            permissionRequestListener.complete(canScheduleExactAlarms);
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingFullScreenIntentPermission && i2 == 3 && Build.VERSION.SDK_INT >= 34) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            PermissionRequestListener permissionRequestListener2 = this.callback;
            canUseFullScreenIntent = notificationManager.canUseFullScreenIntent();
            permissionRequestListener2.complete(canUseFullScreenIntent);
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingNotificationPolicyAccess && i2 == 4) {
            this.callback.complete(((NotificationManager) this.applicationContext.getSystemService("notification")).isNotificationPolicyAccessGranted());
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        return true;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
        Activity activity = activityPluginBinding.getActivity();
        this.mainActivity = activity;
        Intent intent = activity.getIntent();
        if (!launchedActivityFromHistory(intent) && SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            processForegroundNotificationAction(intent, extractNotificationResponseMap(intent));
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), METHOD_CHANNEL);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
        this.applicationContext = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2096263152:
                if (str.equals(STOP_FOREGROUND_SERVICE)) {
                    c2 = 0;
                    break;
                }
                break;
            case -2041662895:
                if (str.equals(GET_NOTIFICATION_CHANNELS_METHOD)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1873731438:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1785484984:
                if (str.equals(REQUEST_NOTIFICATIONS_PERMISSION_METHOD)) {
                    c2 = 3;
                    break;
                }
                break;
            case -1624574341:
                if (str.equals(HAS_NOTIFICATION_POLICY_ACCESS_METHOD)) {
                    c2 = 4;
                    break;
                }
                break;
            case -1367724422:
                if (str.equals(CANCEL_METHOD)) {
                    c2 = 5;
                    break;
                }
                break;
            case -1108601471:
                if (str.equals(REQUEST_EXACT_ALARMS_PERMISSION_METHOD)) {
                    c2 = 6;
                    break;
                }
                break;
            case -950516363:
                if (str.equals(REQUEST_FULL_SCREEN_INTENT_PERMISSION_METHOD)) {
                    c2 = 7;
                    break;
                }
                break;
            case -799130106:
                if (str.equals(PENDING_NOTIFICATION_REQUESTS_METHOD)) {
                    c2 = '\b';
                    break;
                }
                break;
            case -321037320:
                if (str.equals(CANCEL_ALL_PENDING_NOTIFICATIONS_METHOD)) {
                    c2 = '\t';
                    break;
                }
                break;
            case -208611345:
                if (str.equals(GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD)) {
                    c2 = '\n';
                    break;
                }
                break;
            case 3529469:
                if (str.equals(SHOW_METHOD)) {
                    c2 = 11;
                    break;
                }
                break;
            case 6625712:
                if (str.equals(PERIODICALLY_SHOW_METHOD)) {
                    c2 = '\f';
                    break;
                }
                break;
            case 116003316:
                if (str.equals(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD)) {
                    c2 = '\r';
                    break;
                }
                break;
            case 476547271:
                if (str.equals(CANCEL_ALL_METHOD)) {
                    c2 = 14;
                    break;
                }
                break;
            case 548573423:
                if (str.equals(ZONED_SCHEDULE_METHOD)) {
                    c2 = 15;
                    break;
                }
                break;
            case 767006947:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c2 = 16;
                    break;
                }
                break;
            case 825311171:
                if (str.equals(GET_CALLBACK_HANDLE_METHOD)) {
                    c2 = 17;
                    break;
                }
                break;
            case 871091088:
                if (str.equals(INITIALIZE_METHOD)) {
                    c2 = 18;
                    break;
                }
                break;
            case 891942317:
                if (str.equals(ARE_NOTIFICATIONS_ENABLED_METHOD)) {
                    c2 = 19;
                    break;
                }
                break;
            case 972029712:
                if (str.equals(CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD)) {
                    c2 = 20;
                    break;
                }
                break;
            case 1008472557:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_METHOD)) {
                    c2 = 21;
                    break;
                }
                break;
            case 1207771056:
                if (str.equals(START_FOREGROUND_SERVICE)) {
                    c2 = 22;
                    break;
                }
                break;
            case 1594833996:
                if (str.equals(GET_ACTIVE_NOTIFICATIONS_METHOD)) {
                    c2 = 23;
                    break;
                }
                break;
            case 1653467900:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_METHOD)) {
                    c2 = 24;
                    break;
                }
                break;
            case 2017789808:
                if (str.equals(REQUEST_NOTIFICATION_POLICY_ACCESS_METHOD)) {
                    c2 = 25;
                    break;
                }
                break;
            case 2147197514:
                if (str.equals(PERIODICALLY_SHOW_WITH_DURATION_METHOD)) {
                    c2 = 26;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                stopForegroundService(result);
                return;
            case 1:
                getNotificationChannels(result);
                return;
            case 2:
                deleteNotificationChannelGroup(methodCall, result);
                return;
            case 3:
                requestNotificationsPermission(new PermissionRequestListener() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.2
                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void complete(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }

                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void fail(String str2) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str2, null);
                    }
                });
                return;
            case 4:
                hasNotificationPolicyAccess(result);
                return;
            case 5:
                cancel(methodCall, result);
                return;
            case 6:
                requestExactAlarmsPermission(new PermissionRequestListener() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.3
                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void complete(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }

                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void fail(String str2) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str2, null);
                    }
                });
                return;
            case 7:
                requestFullScreenIntentPermission(new PermissionRequestListener() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.4
                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void complete(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }

                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void fail(String str2) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str2, null);
                    }
                });
                return;
            case '\b':
                pendingNotificationRequests(result);
                return;
            case '\t':
                cancelAllPendingNotifications(result);
                return;
            case '\n':
                getNotificationAppLaunchDetails(result);
                return;
            case 11:
                show(methodCall, result);
                return;
            case '\f':
                repeat(methodCall, result);
                return;
            case '\r':
                getActiveNotificationMessagingStyle(methodCall, result);
                return;
            case 14:
                cancelAllNotifications(result);
                return;
            case 15:
                zonedSchedule(methodCall, result);
                return;
            case 16:
                createNotificationChannelGroup(methodCall, result);
                return;
            case 17:
                getCallbackHandle(result);
                return;
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                initialize(methodCall, result);
                return;
            case 19:
                areNotificationsEnabled(result);
                return;
            case 20:
                setCanScheduleExactNotifications(result);
                return;
            case 21:
                deleteNotificationChannel(methodCall, result);
                return;
            case 22:
                startForegroundService(methodCall, result);
                return;
            case 23:
                getActiveNotifications(result);
                return;
            case 24:
                createNotificationChannel(methodCall, result);
                return;
            case Build.API_LEVELS.API_25 /* 25 */:
                requestNotificationPolicyAccess(new PermissionRequestListener() { // from class: com.dexterous.flutterlocalnotifications.FlutterLocalNotificationsPlugin.5
                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void complete(boolean z) {
                        result.success(Boolean.valueOf(z));
                    }

                    @Override // com.dexterous.flutterlocalnotifications.PermissionRequestListener
                    public void fail(String str2) {
                        result.error(FlutterLocalNotificationsPlugin.PERMISSION_REQUEST_IN_PROGRESS_ERROR_CODE, str2, null);
                    }
                });
                return;
            case Build.API_LEVELS.API_26 /* 26 */:
                repeat(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Activity activity;
        boolean booleanValue = sendNotificationPayloadMessage(intent).booleanValue();
        if (booleanValue && (activity = this.mainActivity) != null) {
            activity.setIntent(intent);
        }
        return booleanValue;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this);
        activityPluginBinding.addActivityResultListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z = false;
        if (this.permissionRequestProgress == PermissionRequestProgress.RequestingNotificationPermission && i2 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            this.callback.complete(z);
            this.permissionRequestProgress = PermissionRequestProgress.None;
        }
        return z;
    }

    public void requestExactAlarmsPermission(PermissionRequestListener permissionRequestListener) {
        boolean canScheduleExactAlarms;
        PermissionRequestProgress permissionRequestProgress = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress2 = PermissionRequestProgress.None;
        if (permissionRequestProgress != permissionRequestProgress2) {
            permissionRequestListener.fail(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (Build.VERSION.SDK_INT >= 31) {
            canScheduleExactAlarms = getAlarmManager(this.applicationContext).canScheduleExactAlarms();
            if (!canScheduleExactAlarms) {
                this.permissionRequestProgress = PermissionRequestProgress.RequestingExactAlarmsPermission;
                this.mainActivity.startActivityForResult(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + this.applicationContext.getPackageName())), 2);
                return;
            }
            this.callback.complete(true);
            this.permissionRequestProgress = permissionRequestProgress2;
            return;
        }
        permissionRequestListener.complete(true);
    }

    public void requestFullScreenIntentPermission(PermissionRequestListener permissionRequestListener) {
        boolean canUseFullScreenIntent;
        PermissionRequestProgress permissionRequestProgress = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress2 = PermissionRequestProgress.None;
        if (permissionRequestProgress != permissionRequestProgress2) {
            permissionRequestListener.fail(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (Build.VERSION.SDK_INT >= 34) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            getAlarmManager(this.applicationContext);
            canUseFullScreenIntent = notificationManager.canUseFullScreenIntent();
            if (!canUseFullScreenIntent) {
                this.permissionRequestProgress = PermissionRequestProgress.RequestingFullScreenIntentPermission;
                this.mainActivity.startActivityForResult(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + this.applicationContext.getPackageName())), 3);
                return;
            }
            this.callback.complete(true);
            this.permissionRequestProgress = permissionRequestProgress2;
            return;
        }
        permissionRequestListener.complete(true);
    }

    public void requestNotificationPolicyAccess(PermissionRequestListener permissionRequestListener) {
        PermissionRequestProgress permissionRequestProgress = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress2 = PermissionRequestProgress.None;
        if (permissionRequestProgress != permissionRequestProgress2) {
            permissionRequestListener.fail(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (((NotificationManager) this.applicationContext.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            this.callback.complete(true);
            this.permissionRequestProgress = permissionRequestProgress2;
            return;
        }
        this.permissionRequestProgress = PermissionRequestProgress.RequestingNotificationPolicyAccess;
        String packageName = this.applicationContext.getPackageName();
        Bundle bundle = new Bundle();
        bundle.putString(":settings:fragment_args_key", packageName);
        this.mainActivity.startActivityForResult(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS").putExtra(":settings:fragment_args_key", packageName).putExtra(":settings:show_fragment_args", bundle), 4);
    }

    public void requestNotificationsPermission(PermissionRequestListener permissionRequestListener) {
        PermissionRequestProgress permissionRequestProgress = this.permissionRequestProgress;
        PermissionRequestProgress permissionRequestProgress2 = PermissionRequestProgress.None;
        if (permissionRequestProgress != permissionRequestProgress2) {
            permissionRequestListener.fail(PERMISSION_REQUEST_IN_PROGRESS_ERROR_MESSAGE);
            return;
        }
        this.callback = permissionRequestListener;
        if (Build.VERSION.SDK_INT >= 33) {
            if (android.support.v4.media.session.a.e(this.mainActivity, "android.permission.POST_NOTIFICATIONS") == 0) {
                this.callback.complete(true);
                this.permissionRequestProgress = permissionRequestProgress2;
                return;
            } else {
                this.permissionRequestProgress = PermissionRequestProgress.RequestingNotificationPermission;
                android.support.v4.media.session.a.D(this.mainActivity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
                return;
            }
        }
        this.callback.complete(new H(this.mainActivity).f3699b.areNotificationsEnabled());
    }
}
