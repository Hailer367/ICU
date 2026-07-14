package com.dexterous.flutterlocalnotifications;

import A2.t;
import R.j;
import T1.m;
import T1.n;
import W1.C;
import a.AbstractC0141a;
import a2.C0143a;
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
import c0.C0254a;
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
import com.dexterous.flutterlocalnotifications.utils.StringUtils;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import m2.C0447e;
import o.B1;
import p2.InterfaceC0586a;
import r2.k;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0642n;
import s2.InterfaceC0643o;
import s2.InterfaceC0646r;
import s2.InterfaceC0647s;
import s2.InterfaceC0648t;
import x.B;
import x.C0707g;
import x.C0711k;
import x.C0712l;
import x.H;
import x.I;
import x.K;
import x.v;
import x.w;

@Keep
/* loaded from: classes.dex */
public class FlutterLocalNotificationsPlugin implements InterfaceC0642n, InterfaceC0647s, InterfaceC0648t, InterfaceC0646r, o2.c, InterfaceC0586a {
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
    static T1.e gson;
    private Context applicationContext;
    private i callback;
    private C0644p channel;
    private Activity mainActivity;
    private f permissionRequestProgress = f.f3340f;

    /* loaded from: classes.dex */
    public class a extends C0143a<ArrayList<NotificationDetails>> {
    }

    private static void applyGrouping(NotificationDetails notificationDetails, C0712l c0712l) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.groupKey).booleanValue()) {
            c0712l.f6408s = notificationDetails.groupKey;
            if (BooleanUtils.getValue(notificationDetails.setAsGroupSummary)) {
                c0712l.f6409t = true;
            }
            c0712l.f6386E = notificationDetails.groupAlertBehavior.intValue();
        }
    }

    private void areNotificationsEnabled(InterfaceC0643o interfaceC0643o) {
        interfaceC0643o.success(Boolean.valueOf(getNotificationManager(this.applicationContext).f6329b.areNotificationsEnabled()));
    }

    public static T1.e buildGson() {
        boolean z;
        if (gson == null) {
            RuntimeTypeAdapterFactory registerSubtype = RuntimeTypeAdapterFactory.of(StyleInformation.class).registerSubtype(DefaultStyleInformation.class).registerSubtype(BigTextStyleInformation.class).registerSubtype(BigPictureStyleInformation.class).registerSubtype(InboxStyleInformation.class).registerSubtype(MessagingStyleInformation.class);
            V1.h hVar = V1.h.f1736h;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            T1.a aVar = T1.e.f1609h;
            m mVar = T1.e.f1610i;
            n nVar = T1.e.f1611j;
            ArrayDeque arrayDeque = new ArrayDeque();
            ScheduleMode.a aVar2 = new ScheduleMode.a();
            C0143a c0143a = new C0143a(ScheduleMode.class);
            if (c0143a.f2217b == c0143a.f2216a) {
                z = true;
            } else {
                z = $assertionsDisabled;
            }
            arrayList.add(new C(aVar2, c0143a, z));
            Objects.requireNonNull(registerSubtype);
            arrayList.add(registerSubtype);
            ArrayList arrayList3 = new ArrayList(arrayList2.size() + arrayList.size() + 3);
            arrayList3.addAll(arrayList);
            Collections.reverse(arrayList3);
            ArrayList arrayList4 = new ArrayList(arrayList2);
            Collections.reverse(arrayList4);
            arrayList3.addAll(arrayList4);
            boolean z3 = Z1.f.f2199a;
            HashMap hashMap2 = new HashMap(hashMap);
            new ArrayList(arrayList);
            new ArrayList(arrayList2);
            gson = new T1.e(hVar, hashMap2, aVar, arrayList3, mVar, nVar, new ArrayList(arrayDeque));
        }
        return gson;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [x.I, java.lang.Object] */
    private static I buildPerson(Context context, PersonDetails personDetails) {
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
        obj2.f6330a = str3;
        obj2.f6331b = iconCompat;
        obj2.f6332c = str;
        obj2.f6333d = str2;
        obj2.f6334e = value;
        obj2.f6335f = value2;
        return obj2;
    }

    private static long calculateNextNotificationTrigger(long j4, long j5) {
        while (j4 < System.currentTimeMillis()) {
            j4 += j5;
        }
        return j4;
    }

    private static long calculateRepeatIntervalMilliseconds(NotificationDetails notificationDetails) {
        if (notificationDetails.repeatIntervalMilliseconds != null) {
            return r0.intValue();
        }
        int i4 = d.f3336a[notificationDetails.repeatInterval.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
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
                z = $assertionsDisabled;
            }
            return Boolean.valueOf(z);
        }
        return Boolean.FALSE;
    }

    private void cancel(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        Map map = (Map) c0641m.f6156b;
        cancelNotification((Integer) map.get(CANCEL_ID), (String) map.get(CANCEL_TAG));
        interfaceC0643o.success(null);
    }

    private void cancelAllNotifications(InterfaceC0643o interfaceC0643o) {
        getNotificationManager(this.applicationContext).f6329b.cancelAll();
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        if (loadScheduledNotifications != null && !loadScheduledNotifications.isEmpty()) {
            Intent intent = new Intent(this.applicationContext, (Class<?>) ScheduledNotificationReceiver.class);
            int size = loadScheduledNotifications.size();
            int i4 = 0;
            while (i4 < size) {
                NotificationDetails notificationDetails = loadScheduledNotifications.get(i4);
                i4++;
                getAlarmManager(this.applicationContext).cancel(getBroadcastPendingIntent(this.applicationContext, notificationDetails.id.intValue(), intent));
            }
            saveScheduledNotifications(this.applicationContext, new ArrayList());
            interfaceC0643o.success(null);
            return;
        }
        interfaceC0643o.success(null);
    }

    private void cancelAllPendingNotifications(InterfaceC0643o interfaceC0643o) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        if (loadScheduledNotifications != null && !loadScheduledNotifications.isEmpty()) {
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            Intent intent = new Intent(this.applicationContext, (Class<?>) ScheduledNotificationReceiver.class);
            int size = loadScheduledNotifications.size();
            int i4 = 0;
            while (i4 < size) {
                NotificationDetails notificationDetails = loadScheduledNotifications.get(i4);
                i4++;
                alarmManager.cancel(getBroadcastPendingIntent(this.applicationContext, notificationDetails.id.intValue(), intent));
            }
            saveScheduledNotifications(this.applicationContext, new ArrayList());
            interfaceC0643o.success(null);
            return;
        }
        interfaceC0643o.success(null);
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
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                bArr[i4] = (byte) ((Double) arrayList.get(i4)).intValue();
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
                throw new e();
            }
        }
    }

    private static v createMessage(Context context, MessageDetails messageDetails) {
        String str;
        v vVar = new v(messageDetails.text, messageDetails.timestamp.longValue(), buildPerson(context, messageDetails.person));
        String str2 = messageDetails.dataUri;
        if (str2 != null && (str = messageDetails.dataMimeType) != null) {
            Uri parse = Uri.parse(str2);
            vVar.f6428e = str;
            vVar.f6429f = parse;
        }
        return vVar;
    }

    public static Notification createNotification(Context context, NotificationDetails notificationDetails) {
        CharSequence charSequence;
        CharSequence charSequence2;
        IconCompat iconCompat;
        Intent intent;
        int i4;
        int i5;
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
        C0712l c0712l = new C0712l(context, notificationDetails.channelId);
        if (defaultStyleInformation.htmlFormatTitle.booleanValue()) {
            charSequence = fromHtml(notificationDetails.title);
        } else {
            charSequence = notificationDetails.title;
        }
        c0712l.f6395e = C0712l.b(charSequence);
        if (defaultStyleInformation.htmlFormatBody.booleanValue()) {
            charSequence2 = fromHtml(notificationDetails.body);
        } else {
            charSequence2 = notificationDetails.body;
        }
        c0712l.f6396f = C0712l.b(charSequence2);
        c0712l.f6388G.tickerText = C0712l.b(notificationDetails.ticker);
        c0712l.c(16, BooleanUtils.getValue(notificationDetails.autoCancel));
        c0712l.f6397g = activity;
        c0712l.k = notificationDetails.priority.intValue();
        c0712l.c(2, BooleanUtils.getValue(notificationDetails.ongoing));
        c0712l.f6389H = BooleanUtils.getValue(notificationDetails.silent);
        c0712l.c(8, BooleanUtils.getValue(notificationDetails.onlyAlertOnce));
        int i6 = 0;
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
                    intent.setAction("com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED");
                }
                intent.putExtra(NOTIFICATION_ID, notificationDetails.id).putExtra(NOTIFICATION_TAG, notificationDetails.tag).putExtra(ACTION_ID, notificationAction.id).putExtra(CANCEL_NOTIFICATION, notificationAction.cancelNotification).putExtra(PAYLOAD, notificationDetails.payload);
                List<C0.a> list = notificationAction.actionInputs;
                if (list != null && !list.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        i4 = 167772160;
                    } else {
                        i4 = 134217728;
                    }
                } else {
                    i4 = 201326592;
                }
                Boolean bool2 = notificationAction.showsUserInterface;
                if (bool2 != null && bool2.booleanValue()) {
                    i5 = intValue + 1;
                    broadcast = PendingIntent.getActivity(context, intValue, intent, i4);
                } else {
                    i5 = intValue + 1;
                    broadcast = PendingIntent.getBroadcast(context, intValue, intent, i4);
                }
                SpannableString spannableString = new SpannableString(notificationAction.title);
                if (notificationAction.titleColor != null) {
                    spannableString.setSpan(new ForegroundColorSpan(notificationAction.titleColor.intValue()), i6, spannableString.length(), i6);
                }
                C0707g c0707g = new C0707g(iconCompat, spannableString, broadcast);
                Boolean bool3 = notificationAction.contextual;
                if (bool3 != null) {
                    c0707g.f6365i = bool3.booleanValue();
                }
                Boolean bool4 = notificationAction.showsUserInterface;
                if (bool4 != null) {
                    c0707g.f6364h = bool4.booleanValue();
                }
                Boolean bool5 = notificationAction.allowGeneratedReplies;
                if (bool5 != null) {
                    c0707g.f6360d = bool5.booleanValue();
                }
                Integer num = notificationAction.semanticAction;
                if (num != null) {
                    c0707g.f6363g = num.intValue();
                }
                List<C0.a> list2 = notificationAction.actionInputs;
                if (list2 != null) {
                    for (C0.a aVar : list2) {
                        HashSet hashSet = new HashSet();
                        Bundle bundle = new Bundle();
                        String str = aVar.f253h;
                        Boolean bool6 = aVar.f252g;
                        if (bool6 != null) {
                            z = bool6.booleanValue();
                        } else {
                            z = true;
                        }
                        List list3 = aVar.f254i;
                        if (list3 != null) {
                            Iterator it = list3.iterator();
                            while (it.hasNext()) {
                                hashSet.add((String) it.next());
                            }
                        }
                        List list4 = aVar.f251f;
                        i6 = 0;
                        if (list4 != null) {
                            charSequenceArr = (CharSequence[]) list4.toArray(new CharSequence[0]);
                        } else {
                            charSequenceArr = null;
                        }
                        K k = new K(str, charSequenceArr, z, bundle, hashSet);
                        if (c0707g.f6362f == null) {
                            c0707g.f6362f = new ArrayList();
                        }
                        c0707g.f6362f.add(k);
                    }
                }
                if (BooleanUtils.getValue(notificationAction.invisible)) {
                    c0712l.f6394d.add(c0707g.a());
                } else {
                    c0712l.f6392b.add(c0707g.a());
                }
                intValue = i5;
            }
        }
        setSmallIcon(context, notificationDetails, c0712l);
        c0712l.d(getBitmapFromSource(context, notificationDetails.largeIcon, notificationDetails.largeIconBitmapSource));
        Integer num2 = notificationDetails.color;
        if (num2 != null) {
            c0712l.z = num2.intValue();
        }
        Boolean bool7 = notificationDetails.colorized;
        if (bool7 != null) {
            c0712l.f6411v = bool7.booleanValue();
            c0712l.f6412w = true;
        }
        Boolean bool8 = notificationDetails.showWhen;
        if (bool8 != null) {
            c0712l.f6401l = BooleanUtils.getValue(bool8);
        }
        Long l3 = notificationDetails.when;
        if (l3 != null) {
            c0712l.f6388G.when = l3.longValue();
        }
        Boolean bool9 = notificationDetails.usesChronometer;
        if (bool9 != null) {
            c0712l.f6402m = bool9.booleanValue();
        }
        Boolean bool10 = notificationDetails.chronometerCountDown;
        if (bool10 != null) {
            boolean booleanValue = bool10.booleanValue();
            if (c0712l.f6414y == null) {
                c0712l.f6414y = new Bundle();
            }
            c0712l.f6414y.putBoolean("android.chronometerCountDown", booleanValue);
        }
        if (BooleanUtils.getValue(notificationDetails.fullScreenIntent)) {
            c0712l.f6398h = activity;
            c0712l.c(128, true);
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails.shortcutId).booleanValue()) {
            c0712l.f6384C = notificationDetails.shortcutId;
        }
        if (!StringUtils.isNullOrEmpty(notificationDetails.subText).booleanValue()) {
            c0712l.f6404o = C0712l.b(notificationDetails.subText);
        }
        Integer num3 = notificationDetails.number;
        if (num3 != null) {
            c0712l.f6400j = num3.intValue();
        }
        setVisibility(notificationDetails, c0712l);
        applyGrouping(notificationDetails, c0712l);
        setSound(context, notificationDetails, c0712l);
        setVibrationPattern(notificationDetails, c0712l);
        setLights(notificationDetails, c0712l);
        setStyle(context, notificationDetails, c0712l);
        setProgress(notificationDetails, c0712l);
        setCategory(notificationDetails, c0712l);
        setTimeoutAfter(notificationDetails, c0712l);
        Notification a4 = c0712l.a();
        int[] iArr = notificationDetails.additionalFlags;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            while (i6 < length) {
                a4.flags = iArr[i6] | a4.flags;
                i6++;
            }
        }
        return a4;
    }

    private void createNotificationChannel(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        setupNotificationChannel(this.applicationContext, NotificationChannelDetails.from((Map) c0641m.f6156b));
        interfaceC0643o.success(null);
    }

    private void createNotificationChannelGroup(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            NotificationChannelGroupDetails from = NotificationChannelGroupDetails.from((Map) c0641m.f6156b);
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            com.dexterous.flutterlocalnotifications.a.C();
            NotificationChannelGroup f4 = com.dexterous.flutterlocalnotifications.a.f(from.id, from.name);
            if (i4 >= 28) {
                f4.setDescription(from.description);
            }
            notificationManager.createNotificationChannelGroup(f4);
        }
        interfaceC0643o.success(null);
    }

    private void deleteNotificationChannel(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.applicationContext.getSystemService("notification")).deleteNotificationChannel((String) c0641m.f6156b);
        }
        interfaceC0643o.success(null);
    }

    private void deleteNotificationChannelGroup(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.applicationContext.getSystemService("notification")).deleteNotificationChannelGroup((String) c0641m.f6156b);
        }
        interfaceC0643o.success(null);
    }

    private Map<String, Object> describeIcon(IconCompat iconCompat) {
        IconSource iconSource;
        String resourceEntryName;
        if (iconCompat != null) {
            int i4 = iconCompat.f2508a;
            if (i4 == -1) {
                i4 = k3.b.n(iconCompat.f2509b);
            }
            if (i4 != 2) {
                if (i4 != 4) {
                    return null;
                }
                iconSource = IconSource.ContentUri;
                resourceEntryName = iconCompat.g().toString();
            } else {
                iconSource = IconSource.DrawableResource;
                resourceEntryName = this.applicationContext.getResources().getResourceEntryName(iconCompat.f());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("source", Integer.valueOf(iconSource.ordinal()));
            hashMap.put("data", resourceEntryName);
            return hashMap;
        }
        return null;
    }

    private Map<String, Object> describePerson(I i4) {
        if (i4 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("key", i4.f6333d);
        hashMap.put("name", i4.f6330a);
        hashMap.put("uri", i4.f6332c);
        hashMap.put("bot", Boolean.valueOf(i4.f6334e));
        hashMap.put("important", Boolean.valueOf(i4.f6335f));
        hashMap.put("icon", describeIcon(i4.f6331b));
        return hashMap;
    }

    private NotificationDetails extractNotificationDetails(InterfaceC0643o interfaceC0643o, Map<String, Object> map) {
        NotificationDetails from = NotificationDetails.from(map);
        if (!hasInvalidIcon(interfaceC0643o, from.icon) && !hasInvalidLargeIcon(interfaceC0643o, from.largeIcon, from.largeIconBitmapSource) && !hasInvalidBigPictureResources(interfaceC0643o, from) && !hasInvalidRawSoundResource(interfaceC0643o, from) && !hasInvalidLedDetails(interfaceC0643o, from)) {
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

    private void getActiveNotificationMessagingStyle(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        Notification notification;
        NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
        try {
            Map map = (Map) c0641m.f6156b;
            int intValue = ((Integer) map.get(CANCEL_ID)).intValue();
            String str = (String) map.get(CANCEL_TAG);
            int i4 = 0;
            for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                if (statusBarNotification.getId() != intValue || (str != null && !str.equals(statusBarNotification.getTag()))) {
                }
                notification = statusBarNotification.getNotification();
            }
            notification = null;
            if (notification == null) {
                interfaceC0643o.success(null);
                return;
            }
            w e4 = w.e(notification);
            if (e4 == null) {
                interfaceC0643o.success(null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("groupConversation", Boolean.valueOf(e4.f()));
            hashMap.put("person", describePerson(e4.f6432g));
            hashMap.put("conversationTitle", e4.f6433h);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = e4.f6430e;
            int size = arrayList2.size();
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                v vVar = (v) obj;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("text", vVar.f6424a);
                hashMap2.put("timestamp", Long.valueOf(vVar.f6425b));
                hashMap2.put("person", describePerson(vVar.f6426c));
                Uri uri = vVar.f6429f;
                if (uri != null) {
                    hashMap2.put("dataUri", uri.toString());
                }
                String str2 = vVar.f6428e;
                if (str2 != null) {
                    hashMap2.put("dataMimeType", str2);
                }
                arrayList.add(hashMap2);
            }
            hashMap.put("messages", arrayList);
            interfaceC0643o.success(hashMap);
        } catch (Throwable th) {
            interfaceC0643o.error(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private void getActiveNotifications(InterfaceC0643o interfaceC0643o) {
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
            interfaceC0643o.success(arrayList);
        } catch (Throwable th) {
            interfaceC0643o.error(UNSUPPORTED_OS_VERSION_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
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

    private static PendingIntent getBroadcastPendingIntent(Context context, int i4, Intent intent) {
        return PendingIntent.getBroadcast(context, i4, intent, 201326592);
    }

    private void getCallbackHandle(InterfaceC0643o interfaceC0643o) {
        interfaceC0643o.success(Long.valueOf(this.applicationContext.getSharedPreferences("flutter_local_notifications_plugin", 0).getLong("com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY", -1L)));
    }

    private static int getDrawableResourceId(Context context, String str) {
        return context.getResources().getIdentifier(str, DRAWABLE, context.getPackageName());
    }

    private static IconCompat getIconFromSource(Context context, Object obj, IconSource iconSource) {
        int i4 = d.f3337b[iconSource.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return null;
                        }
                        byte[] castObjectToByteArray = castObjectToByteArray(obj);
                        int length = castObjectToByteArray.length;
                        IconCompat iconCompat = new IconCompat(3);
                        iconCompat.f2509b = castObjectToByteArray;
                        iconCompat.f2512e = 0;
                        iconCompat.f2513f = length;
                        return iconCompat;
                    }
                    try {
                        AssetFileDescriptor openFd = context.getAssets().openFd(((C0447e) t.O().f99g).b((String) obj));
                        FileInputStream createInputStream = openFd.createInputStream();
                        IconCompat d4 = IconCompat.d(BitmapFactory.decodeStream(createInputStream));
                        createInputStream.close();
                        openFd.close();
                        return d4;
                    } catch (IOException e4) {
                        throw new RuntimeException(e4);
                    }
                }
                String str = (String) obj;
                PorterDuff.Mode mode = IconCompat.k;
                str.getClass();
                IconCompat iconCompat2 = new IconCompat(4);
                iconCompat2.f2509b = str;
                return iconCompat2;
            }
            return IconCompat.d(BitmapFactory.decodeFile((String) obj));
        }
        int drawableResourceId = getDrawableResourceId(context, (String) obj);
        PorterDuff.Mode mode2 = IconCompat.k;
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

    private void getNotificationAppLaunchDetails(InterfaceC0643o interfaceC0643o) {
        boolean z;
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.FALSE;
        Activity activity = this.mainActivity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if (intent != null && ((SELECT_NOTIFICATION.equals(intent.getAction()) || SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) && !launchedActivityFromHistory(intent))) {
                z = true;
            } else {
                z = $assertionsDisabled;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (z) {
                hashMap.put("notificationResponse", extractNotificationResponseMap(intent));
            }
            bool = valueOf;
        }
        hashMap.put(NOTIFICATION_LAUNCHED_APP, bool);
        interfaceC0643o.success(hashMap);
    }

    private void getNotificationChannels(InterfaceC0643o interfaceC0643o) {
        List list;
        try {
            H notificationManager = getNotificationManager(this.applicationContext);
            if (Build.VERSION.SDK_INT >= 26) {
                list = C.a.c(notificationManager.f6329b);
            } else {
                notificationManager.getClass();
                list = Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getMappedNotificationChannel(com.dexterous.flutterlocalnotifications.a.d(it.next())));
            }
            interfaceC0643o.success(arrayList);
        } catch (Throwable th) {
            interfaceC0643o.error(GET_NOTIFICATION_CHANNELS_ERROR_CODE, th.getMessage(), Log.getStackTraceString(th));
        }
    }

    private static H getNotificationManager(Context context) {
        return new H(context);
    }

    private boolean hasInvalidBigPictureResources(InterfaceC0643o interfaceC0643o, NotificationDetails notificationDetails) {
        if (notificationDetails.style == NotificationStyle.BigPicture) {
            BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
            if (hasInvalidLargeIcon(interfaceC0643o, bigPictureStyleInformation.largeIcon, bigPictureStyleInformation.largeIconBitmapSource)) {
                return true;
            }
            BitmapSource bitmapSource = bigPictureStyleInformation.bigPictureBitmapSource;
            if (bitmapSource == BitmapSource.DrawableResource) {
                String str = (String) bigPictureStyleInformation.bigPicture;
                if (!StringUtils.isNullOrEmpty(str).booleanValue() || isValidDrawableResource(this.applicationContext, str, interfaceC0643o, INVALID_BIG_PICTURE_ERROR_CODE)) {
                    return $assertionsDisabled;
                }
                return true;
            }
            if (bitmapSource == BitmapSource.FilePath) {
                return StringUtils.isNullOrEmpty((String) bigPictureStyleInformation.bigPicture).booleanValue();
            }
            if (bitmapSource == BitmapSource.ByteArray) {
                byte[] bArr = (byte[]) bigPictureStyleInformation.bigPicture;
                if (bArr != null && bArr.length != 0) {
                    return $assertionsDisabled;
                }
                return true;
            }
        }
        return $assertionsDisabled;
    }

    private boolean hasInvalidIcon(InterfaceC0643o interfaceC0643o, String str) {
        if (!StringUtils.isNullOrEmpty(str).booleanValue() && !isValidDrawableResource(this.applicationContext, str, interfaceC0643o, INVALID_ICON_ERROR_CODE)) {
            return true;
        }
        return $assertionsDisabled;
    }

    private boolean hasInvalidLargeIcon(InterfaceC0643o interfaceC0643o, Object obj, BitmapSource bitmapSource) {
        BitmapSource bitmapSource2 = BitmapSource.DrawableResource;
        if (bitmapSource != bitmapSource2 && bitmapSource != BitmapSource.FilePath) {
            if (bitmapSource == BitmapSource.ByteArray && ((byte[]) obj).length == 0) {
                return true;
            }
            return $assertionsDisabled;
        }
        String str = (String) obj;
        if (!StringUtils.isNullOrEmpty(str).booleanValue() && bitmapSource == bitmapSource2 && !isValidDrawableResource(this.applicationContext, str, interfaceC0643o, INVALID_LARGE_ICON_ERROR_CODE)) {
            return true;
        }
        return $assertionsDisabled;
    }

    private boolean hasInvalidLedDetails(InterfaceC0643o interfaceC0643o, NotificationDetails notificationDetails) {
        if (notificationDetails.ledColor != null) {
            if (notificationDetails.ledOnMs == null || notificationDetails.ledOffMs == null) {
                interfaceC0643o.error(INVALID_LED_DETAILS_ERROR_CODE, INVALID_LED_DETAILS_ERROR_MESSAGE, null);
                return true;
            }
            return $assertionsDisabled;
        }
        return $assertionsDisabled;
    }

    private boolean hasInvalidRawSoundResource(InterfaceC0643o interfaceC0643o, NotificationDetails notificationDetails) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.sound).booleanValue()) {
            SoundSource soundSource = notificationDetails.soundSource;
            if ((soundSource == null || soundSource == SoundSource.RawResource) && this.applicationContext.getResources().getIdentifier(notificationDetails.sound, "raw", this.applicationContext.getPackageName()) == 0) {
                interfaceC0643o.error(INVALID_SOUND_ERROR_CODE, k.b("The resource ", notificationDetails.sound, " could not be found. Please make sure it has been added as a raw resource to your Android head project."), null);
                return true;
            }
            return $assertionsDisabled;
        }
        return $assertionsDisabled;
    }

    private void initialize(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        String str = (String) ((Map) c0641m.f6156b).get(DEFAULT_ICON);
        if (!isValidDrawableResource(this.applicationContext, str, interfaceC0643o, INVALID_ICON_ERROR_CODE)) {
            return;
        }
        Long x3 = AbstractC0141a.x(c0641m.a(DISPATCHER_HANDLE));
        Long x4 = AbstractC0141a.x(c0641m.a(CALLBACK_HANDLE));
        if (x3 != null && x4 != null) {
            Context context = this.applicationContext;
            context.getSharedPreferences("flutter_local_notifications_plugin", 0).edit().putLong("com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY", x3.longValue()).apply();
            context.getSharedPreferences("flutter_local_notifications_plugin", 0).edit().putLong("com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY", x4.longValue()).apply();
        }
        this.applicationContext.getSharedPreferences(SHARED_PREFERENCES_KEY, 0).edit().putString(DEFAULT_ICON, str).apply();
        interfaceC0643o.success(Boolean.TRUE);
    }

    private static boolean isValidDrawableResource(Context context, String str, InterfaceC0643o interfaceC0643o, String str2) {
        if (context.getResources().getIdentifier(str, DRAWABLE, context.getPackageName()) == 0) {
            interfaceC0643o.error(str2, k.b("The resource ", str, " could not be found. Please make sure it has been added as a drawable resource to your Android head project."), null);
            return $assertionsDisabled;
        }
        return true;
    }

    private static boolean launchedActivityFromHistory(Intent intent) {
        if (intent != null && (intent.getFlags() & 1048576) == 1048576) {
            return true;
        }
        return $assertionsDisabled;
    }

    private static ArrayList<NotificationDetails> loadScheduledNotifications(Context context) {
        ArrayList<NotificationDetails> arrayList = new ArrayList<>();
        String string = context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0).getString(SCHEDULED_NOTIFICATIONS, null);
        if (string != null) {
            return (ArrayList) buildGson().b(string, new a().f2217b);
        }
        return arrayList;
    }

    private void pendingNotificationRequests(InterfaceC0643o interfaceC0643o) {
        ArrayList<NotificationDetails> loadScheduledNotifications = loadScheduledNotifications(this.applicationContext);
        ArrayList arrayList = new ArrayList();
        int size = loadScheduledNotifications.size();
        int i4 = 0;
        while (i4 < size) {
            NotificationDetails notificationDetails = loadScheduledNotifications.get(i4);
            i4++;
            NotificationDetails notificationDetails2 = notificationDetails;
            HashMap hashMap = new HashMap();
            hashMap.put(CANCEL_ID, notificationDetails2.id);
            hashMap.put("title", notificationDetails2.title);
            hashMap.put("body", notificationDetails2.body);
            hashMap.put(PAYLOAD, notificationDetails2.payload);
            arrayList.add(hashMap);
        }
        interfaceC0643o.success(arrayList);
    }

    private void processForegroundNotificationAction(Intent intent, Map<String, Object> map) {
        if (intent.getBooleanExtra(CANCEL_NOTIFICATION, $assertionsDisabled)) {
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

    private void repeat(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(interfaceC0643o, (Map) c0641m.f6156b);
        if (extractNotificationDetails != null) {
            try {
                repeatNotification(this.applicationContext, extractNotificationDetails, Boolean.TRUE);
                interfaceC0643o.success(null);
            } catch (e e4) {
                interfaceC0643o.error(e4.f3339f, e4.getMessage(), null);
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
        String f4 = buildGson().f(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, f4);
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
        int i4 = 0;
        while (i4 < size) {
            NotificationDetails notificationDetails = loadScheduledNotifications.get(i4);
            i4++;
            NotificationDetails notificationDetails2 = notificationDetails;
            try {
            } catch (e e4) {
                Log.e(TAG, e4.getMessage());
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
        int i4 = 0;
        while (i4 < size) {
            NotificationDetails notificationDetails2 = loadScheduledNotifications.get(i4);
            i4++;
            NotificationDetails notificationDetails3 = notificationDetails2;
            if (!notificationDetails3.id.equals(notificationDetails.id)) {
                arrayList.add(notificationDetails3);
            }
        }
        arrayList.add(notificationDetails);
        saveScheduledNotifications(context, arrayList);
    }

    private static void saveScheduledNotifications(Context context, ArrayList<NotificationDetails> arrayList) {
        context.getSharedPreferences(SCHEDULED_NOTIFICATIONS, 0).edit().putString(SCHEDULED_NOTIFICATIONS, buildGson().f(arrayList)).apply();
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
        } catch (e e4) {
            Log.e(TAG, e4.getMessage());
            removeNotificationFromCache(context, notificationDetails.id);
        }
    }

    private static void scheduleNextRepeatingNotification(Context context, NotificationDetails notificationDetails) {
        long calculateNextNotificationTrigger = calculateNextNotificationTrigger(notificationDetails.calledAt.longValue(), calculateRepeatIntervalMilliseconds(notificationDetails));
        String f4 = buildGson().f(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, f4);
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent);
        AlarmManager alarmManager = getAlarmManager(context);
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exactAllowWhileIdle;
        }
        setupAllowWhileIdleAlarm(notificationDetails, alarmManager, calculateNextNotificationTrigger, broadcastPendingIntent);
        saveScheduledNotification(context, notificationDetails);
    }

    private static void scheduleNotification(Context context, NotificationDetails notificationDetails, Boolean bool) {
        String f4 = buildGson().f(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, f4);
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
        this.channel.a("didReceiveNotificationResponse", extractNotificationResponseMap, null);
        return Boolean.TRUE;
    }

    private void setActivity(Activity activity) {
        this.mainActivity = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [x.j, x.B] */
    private static void setBigPictureStyle(Context context, NotificationDetails notificationDetails, C0712l c0712l) {
        IconCompat d4;
        CharSequence charSequence;
        CharSequence charSequence2;
        BigPictureStyleInformation bigPictureStyleInformation = (BigPictureStyleInformation) notificationDetails.styleInformation;
        ?? b4 = new B();
        if (bigPictureStyleInformation.contentTitle != null) {
            if (bigPictureStyleInformation.htmlFormatContentTitle.booleanValue()) {
                charSequence2 = fromHtml(bigPictureStyleInformation.contentTitle);
            } else {
                charSequence2 = bigPictureStyleInformation.contentTitle;
            }
            b4.f6305b = C0712l.b(charSequence2);
        }
        if (bigPictureStyleInformation.summaryText != null) {
            if (bigPictureStyleInformation.htmlFormatSummaryText.booleanValue()) {
                charSequence = fromHtml(bigPictureStyleInformation.summaryText);
            } else {
                charSequence = bigPictureStyleInformation.summaryText;
            }
            b4.f6306c = C0712l.b(charSequence);
            b4.f6307d = true;
        }
        IconCompat iconCompat = null;
        if (bigPictureStyleInformation.hideExpandedLargeIcon.booleanValue()) {
            b4.f6377f = null;
            b4.f6378g = true;
        } else {
            Object obj = bigPictureStyleInformation.largeIcon;
            if (obj != null) {
                Bitmap bitmapFromSource = getBitmapFromSource(context, obj, bigPictureStyleInformation.largeIconBitmapSource);
                if (bitmapFromSource == null) {
                    d4 = null;
                } else {
                    d4 = IconCompat.d(bitmapFromSource);
                }
                b4.f6377f = d4;
                b4.f6378g = true;
            }
        }
        Bitmap bitmapFromSource2 = getBitmapFromSource(context, bigPictureStyleInformation.bigPicture, bigPictureStyleInformation.bigPictureBitmapSource);
        if (bitmapFromSource2 != null) {
            iconCompat = IconCompat.d(bitmapFromSource2);
        }
        b4.f6376e = iconCompat;
        c0712l.f(b4);
    }

    private static void setBigTextStyle(NotificationDetails notificationDetails, C0712l c0712l) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        BigTextStyleInformation bigTextStyleInformation = (BigTextStyleInformation) notificationDetails.styleInformation;
        C0711k c0711k = new C0711k(0);
        if (bigTextStyleInformation.bigText != null) {
            if (bigTextStyleInformation.htmlFormatBigText.booleanValue()) {
                charSequence3 = fromHtml(bigTextStyleInformation.bigText);
            } else {
                charSequence3 = bigTextStyleInformation.bigText;
            }
            c0711k.f6381f = C0712l.b(charSequence3);
        }
        if (bigTextStyleInformation.contentTitle != null) {
            if (bigTextStyleInformation.htmlFormatContentTitle.booleanValue()) {
                charSequence2 = fromHtml(bigTextStyleInformation.contentTitle);
            } else {
                charSequence2 = bigTextStyleInformation.contentTitle;
            }
            c0711k.f6305b = C0712l.b(charSequence2);
        }
        if (bigTextStyleInformation.summaryText != null) {
            if (bigTextStyleInformation.htmlFormatSummaryText.booleanValue()) {
                charSequence = fromHtml(bigTextStyleInformation.summaryText);
            } else {
                charSequence = bigTextStyleInformation.summaryText;
            }
            c0711k.f6306c = C0712l.b(charSequence);
            c0711k.f6307d = true;
        }
        c0712l.f(c0711k);
    }

    private void setCanScheduleExactNotifications(InterfaceC0643o interfaceC0643o) {
        boolean canScheduleExactAlarms;
        if (Build.VERSION.SDK_INT >= 31) {
            canScheduleExactAlarms = getAlarmManager(this.applicationContext).canScheduleExactAlarms();
            interfaceC0643o.success(Boolean.valueOf(canScheduleExactAlarms));
        } else {
            interfaceC0643o.success(Boolean.TRUE);
        }
    }

    private static void setCategory(NotificationDetails notificationDetails, C0712l c0712l) {
        String str = notificationDetails.category;
        if (str == null) {
            return;
        }
        c0712l.f6413x = str;
    }

    private static void setInboxStyle(NotificationDetails notificationDetails, C0712l c0712l) {
        CharSequence charSequence;
        CharSequence charSequence2;
        InboxStyleInformation inboxStyleInformation = (InboxStyleInformation) notificationDetails.styleInformation;
        C0711k c0711k = new C0711k(1);
        if (inboxStyleInformation.contentTitle != null) {
            if (inboxStyleInformation.htmlFormatContentTitle.booleanValue()) {
                charSequence2 = fromHtml(inboxStyleInformation.contentTitle);
            } else {
                charSequence2 = inboxStyleInformation.contentTitle;
            }
            c0711k.f6305b = C0712l.b(charSequence2);
        }
        if (inboxStyleInformation.summaryText != null) {
            if (inboxStyleInformation.htmlFormatSummaryText.booleanValue()) {
                charSequence = fromHtml(inboxStyleInformation.summaryText);
            } else {
                charSequence = inboxStyleInformation.summaryText;
            }
            c0711k.f6306c = C0712l.b(charSequence);
            c0711k.f6307d = true;
        }
        ArrayList<String> arrayList = inboxStyleInformation.lines;
        if (arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                String str = arrayList.get(i4);
                i4++;
                String str2 = str;
                CharSequence charSequence3 = str2;
                if (inboxStyleInformation.htmlFormatLines.booleanValue()) {
                    charSequence3 = fromHtml(str2);
                }
                if (charSequence3 != null) {
                    ((ArrayList) c0711k.f6381f).add(C0712l.b(charSequence3));
                }
            }
        }
        c0712l.f(c0711k);
    }

    private static void setLights(NotificationDetails notificationDetails, C0712l c0712l) {
        int i4;
        if (BooleanUtils.getValue(notificationDetails.enableLights) && notificationDetails.ledOnMs != null && notificationDetails.ledOffMs != null) {
            int intValue = notificationDetails.ledColor.intValue();
            int intValue2 = notificationDetails.ledOnMs.intValue();
            int intValue3 = notificationDetails.ledOffMs.intValue();
            Notification notification = c0712l.f6388G;
            notification.ledARGB = intValue;
            notification.ledOnMS = intValue2;
            notification.ledOffMS = intValue3;
            if (intValue2 != 0 && intValue3 != 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            notification.flags = i4 | (notification.flags & (-2));
        }
    }

    private static void setMediaStyle(C0712l c0712l) {
        c0712l.f(new C0254a(0));
    }

    private static void setMessagingStyle(Context context, NotificationDetails notificationDetails, C0712l c0712l) {
        MessagingStyleInformation messagingStyleInformation = (MessagingStyleInformation) notificationDetails.styleInformation;
        w wVar = new w(buildPerson(context, messagingStyleInformation.person));
        wVar.f6434i = Boolean.valueOf(BooleanUtils.getValue(messagingStyleInformation.groupConversation));
        String str = messagingStyleInformation.conversationTitle;
        if (str != null) {
            wVar.f6433h = str;
        }
        ArrayList<MessageDetails> arrayList = messagingStyleInformation.messages;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<MessageDetails> arrayList2 = messagingStyleInformation.messages;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                MessageDetails messageDetails = arrayList2.get(i4);
                i4++;
                v createMessage = createMessage(context, messageDetails);
                if (createMessage != null) {
                    ArrayList arrayList3 = wVar.f6430e;
                    arrayList3.add(createMessage);
                    if (arrayList3.size() > 25) {
                        arrayList3.remove(0);
                    }
                }
            }
        }
        c0712l.f(wVar);
    }

    private static void setProgress(NotificationDetails notificationDetails, C0712l c0712l) {
        if (BooleanUtils.getValue(notificationDetails.showProgress)) {
            int intValue = notificationDetails.maxProgress.intValue();
            int intValue2 = notificationDetails.progress.intValue();
            boolean booleanValue = notificationDetails.indeterminate.booleanValue();
            c0712l.f6405p = intValue;
            c0712l.f6406q = intValue2;
            c0712l.f6407r = booleanValue;
        }
    }

    private static void setSmallIcon(Context context, NotificationDetails notificationDetails, C0712l c0712l) {
        if (!StringUtils.isNullOrEmpty(notificationDetails.icon).booleanValue()) {
            c0712l.f6388G.icon = getDrawableResourceId(context, notificationDetails.icon);
            return;
        }
        String string = context.getSharedPreferences(SHARED_PREFERENCES_KEY, 0).getString(DEFAULT_ICON, null);
        if (StringUtils.isNullOrEmpty(string).booleanValue()) {
            c0712l.f6388G.icon = notificationDetails.iconResourceId.intValue();
        } else {
            c0712l.f6388G.icon = getDrawableResourceId(context, string);
        }
    }

    private static void setSound(Context context, NotificationDetails notificationDetails, C0712l c0712l) {
        if (BooleanUtils.getValue(notificationDetails.playSound)) {
            c0712l.e(retrieveSoundResourceUri(context, notificationDetails.sound, notificationDetails.soundSource));
        } else {
            c0712l.e(null);
        }
    }

    private static void setStyle(Context context, NotificationDetails notificationDetails, C0712l c0712l) {
        int i4 = d.f3338c[notificationDetails.style.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return;
                        }
                        setMediaStyle(c0712l);
                        return;
                    }
                    setMessagingStyle(context, notificationDetails, c0712l);
                    return;
                }
                setInboxStyle(notificationDetails, c0712l);
                return;
            }
            setBigTextStyle(notificationDetails, c0712l);
            return;
        }
        setBigPictureStyle(context, notificationDetails, c0712l);
    }

    private static void setTimeoutAfter(NotificationDetails notificationDetails, C0712l c0712l) {
        Long l3 = notificationDetails.timeoutAfter;
        if (l3 == null) {
            return;
        }
        c0712l.f6385D = l3.longValue();
    }

    private static void setVibrationPattern(NotificationDetails notificationDetails, C0712l c0712l) {
        if (BooleanUtils.getValue(notificationDetails.enableVibration)) {
            long[] jArr = notificationDetails.vibrationPattern;
            if (jArr != null && jArr.length > 0) {
                c0712l.f6388G.vibrate = jArr;
                return;
            }
            return;
        }
        c0712l.f6388G.vibrate = new long[]{0};
    }

    private static void setVisibility(NotificationDetails notificationDetails, C0712l c0712l) {
        int i4;
        Integer num = notificationDetails.visibility;
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            i4 = 1;
            if (intValue != 1) {
                if (intValue == 2) {
                    i4 = -1;
                } else {
                    throw new IllegalArgumentException("Unknown index: " + notificationDetails.visibility);
                }
            }
        } else {
            i4 = 0;
        }
        c0712l.f6382A = i4;
    }

    private static void setupAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long j4, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode == null) {
            notificationDetails.scheduleMode = ScheduleMode.exact;
        }
        if (notificationDetails.scheduleMode.useAllowWhileIdle()) {
            setupAllowWhileIdleAlarm(notificationDetails, alarmManager, j4, pendingIntent);
            return;
        }
        if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setExact(0, j4, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j4, pendingIntent), pendingIntent);
        } else {
            alarmManager.set(0, j4, pendingIntent);
        }
    }

    private static void setupAllowWhileIdleAlarm(NotificationDetails notificationDetails, AlarmManager alarmManager, long j4, PendingIntent pendingIntent) {
        if (notificationDetails.scheduleMode.useExactAlarm()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setExactAndAllowWhileIdle(0, j4, pendingIntent);
        } else if (notificationDetails.scheduleMode.useAlarmClock()) {
            checkCanScheduleExactAlarms(alarmManager);
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j4, pendingIntent), pendingIntent);
        } else {
            alarmManager.setAndAllowWhileIdle(0, j4, pendingIntent);
        }
    }

    private static void setupNotificationChannel(Context context, NotificationChannelDetails notificationChannelDetails) {
        Integer num;
        int i4;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            com.dexterous.flutterlocalnotifications.a.n();
            NotificationChannel e4 = com.dexterous.flutterlocalnotifications.a.e(notificationChannelDetails.id, notificationChannelDetails.name, notificationChannelDetails.importance.intValue());
            e4.setDescription(notificationChannelDetails.description);
            e4.setGroup(notificationChannelDetails.groupId);
            if (!notificationChannelDetails.playSound.booleanValue()) {
                e4.setSound(null, null);
            } else {
                Integer num2 = notificationChannelDetails.audioAttributesUsage;
                if (num2 != null) {
                    i4 = num2.intValue();
                } else {
                    i4 = 5;
                }
                e4.setSound(retrieveSoundResourceUri(context, notificationChannelDetails.sound, notificationChannelDetails.soundSource), new AudioAttributes.Builder().setUsage(i4).build());
            }
            if (BooleanUtils.getValue(notificationChannelDetails.bypassDnd)) {
                if (notificationManager.isNotificationPolicyAccessGranted()) {
                    e4.setBypassDnd(true);
                } else {
                    Log.w(TAG, "Channel '" + notificationChannelDetails.name + "' was set to bypass Do Not Disturb but the OS prevents it.");
                }
            }
            e4.enableVibration(BooleanUtils.getValue(notificationChannelDetails.enableVibration));
            long[] jArr = notificationChannelDetails.vibrationPattern;
            if (jArr != null && jArr.length > 0) {
                e4.setVibrationPattern(jArr);
            }
            boolean value = BooleanUtils.getValue(notificationChannelDetails.enableLights);
            e4.enableLights(value);
            if (value && (num = notificationChannelDetails.ledColor) != null) {
                e4.setLightColor(num.intValue());
            }
            e4.setShowBadge(BooleanUtils.getValue(notificationChannelDetails.showBadge));
            notificationManager.createNotificationChannel(e4);
        }
    }

    private void show(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(interfaceC0643o, (Map) c0641m.f6156b);
        if (extractNotificationDetails != null) {
            showNotification(this.applicationContext, extractNotificationDetails);
            interfaceC0643o.success(null);
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

    private void startForegroundService(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        Map<String, Object> map = (Map) c0641m.a("notificationData");
        Integer num = (Integer) c0641m.a("startType");
        ArrayList arrayList = (ArrayList) c0641m.a("foregroundServiceTypes");
        if (arrayList != null && arrayList.size() == 0) {
            interfaceC0643o.error("ARGUMENT_ERROR", "If foregroundServiceTypes is non-null it must not be empty!", null);
            return;
        }
        if (map != null && num != null) {
            NotificationDetails extractNotificationDetails = extractNotificationDetails(interfaceC0643o, map);
            if (extractNotificationDetails != null) {
                if (extractNotificationDetails.id.intValue() != 0) {
                    h hVar = new h(extractNotificationDetails, num.intValue(), arrayList);
                    Intent intent = new Intent(this.applicationContext, (Class<?>) g.class);
                    intent.putExtra("com.dexterous.flutterlocalnotifications.ForegroundServiceStartParameter", hVar);
                    Context context = this.applicationContext;
                    if (Build.VERSION.SDK_INT >= 26) {
                        C.a.v(context, intent);
                    } else {
                        context.startService(intent);
                    }
                    interfaceC0643o.success(null);
                    return;
                }
                interfaceC0643o.error("ARGUMENT_ERROR", "The id of the notification for a foreground service must not be 0!", null);
                return;
            }
            return;
        }
        interfaceC0643o.error("ARGUMENT_ERROR", "An argument passed to startForegroundService was null!", null);
    }

    private void stopForegroundService(InterfaceC0643o interfaceC0643o) {
        this.applicationContext.stopService(new Intent(this.applicationContext, (Class<?>) g.class));
        interfaceC0643o.success(null);
    }

    private Integer tryParseInt(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private void zonedSchedule(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        NotificationDetails extractNotificationDetails = extractNotificationDetails(interfaceC0643o, (Map) c0641m.f6156b);
        if (extractNotificationDetails != null) {
            if (extractNotificationDetails.matchDateTimeComponents != null) {
                extractNotificationDetails.scheduledDateTime = getNextFireDateMatchingDateTimeComponents(extractNotificationDetails);
            }
            try {
                zonedScheduleNotification(this.applicationContext, extractNotificationDetails, Boolean.TRUE);
                interfaceC0643o.success(null);
            } catch (e e4) {
                interfaceC0643o.error(e4.f3339f, e4.getMessage(), null);
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
        String f4 = buildGson().f(notificationDetails);
        Intent intent = new Intent(context, (Class<?>) ScheduledNotificationReceiver.class);
        intent.putExtra(NOTIFICATION_DETAILS, f4);
        setupAlarm(notificationDetails, getAlarmManager(context), ZonedDateTime.of(LocalDateTime.parse(notificationDetails.scheduledDateTime), ZoneId.of(notificationDetails.timeZoneName)).toInstant().toEpochMilli(), getBroadcastPendingIntent(context, notificationDetails.id.intValue(), intent));
        if (bool.booleanValue()) {
            saveScheduledNotification(context, notificationDetails);
        }
    }

    public void hasNotificationPolicyAccess(InterfaceC0643o interfaceC0643o) {
        interfaceC0643o.success(Boolean.valueOf(((NotificationManager) this.applicationContext.getSystemService("notification")).isNotificationPolicyAccessGranted()));
    }

    @Override // s2.InterfaceC0646r
    public boolean onActivityResult(int i4, int i5, Intent intent) {
        boolean canUseFullScreenIntent;
        boolean canScheduleExactAlarms;
        if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4) {
            return $assertionsDisabled;
        }
        f fVar = this.permissionRequestProgress;
        f fVar2 = f.f3343i;
        f fVar3 = f.f3340f;
        if (fVar == fVar2 && i4 == 2 && Build.VERSION.SDK_INT >= 31) {
            AlarmManager alarmManager = getAlarmManager(this.applicationContext);
            i iVar = this.callback;
            canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
            iVar.a(canScheduleExactAlarms);
            this.permissionRequestProgress = fVar3;
        }
        if (this.permissionRequestProgress == f.f3344j && i4 == 3 && Build.VERSION.SDK_INT >= 34) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            i iVar2 = this.callback;
            canUseFullScreenIntent = notificationManager.canUseFullScreenIntent();
            iVar2.a(canUseFullScreenIntent);
            this.permissionRequestProgress = fVar3;
        }
        if (this.permissionRequestProgress == f.f3342h && i4 == 4) {
            this.callback.a(((NotificationManager) this.applicationContext.getSystemService("notification")).isNotificationPolicyAccessGranted());
            this.permissionRequestProgress = fVar3;
        }
        return true;
    }

    @Override // p2.InterfaceC0586a
    public void onAttachedToActivity(p2.b bVar) {
        B1 b12 = (B1) bVar;
        b12.b(this);
        ((HashSet) b12.f5416h).add(this);
        b12.a(this);
        Activity activity = (Activity) b12.f5414f;
        this.mainActivity = activity;
        Intent intent = activity.getIntent();
        if (!launchedActivityFromHistory(intent) && SELECT_FOREGROUND_NOTIFICATION_ACTION.equals(intent.getAction())) {
            processForegroundNotificationAction(intent, extractNotificationResponseMap(intent));
        }
    }

    @Override // o2.c
    public void onAttachedToEngine(o2.b bVar) {
        this.applicationContext = bVar.f5785a;
        C0644p c0644p = new C0644p(bVar.f5787c, METHOD_CHANNEL);
        this.channel = c0644p;
        c0644p.b(this);
    }

    @Override // p2.InterfaceC0586a
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    @Override // p2.InterfaceC0586a
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // o2.c
    public void onDetachedFromEngine(o2.b bVar) {
        this.channel.b(null);
        this.channel = null;
        this.applicationContext = null;
    }

    @Override // s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2096263152:
                if (str.equals(STOP_FOREGROUND_SERVICE)) {
                    c4 = 0;
                    break;
                }
                break;
            case -2041662895:
                if (str.equals(GET_NOTIFICATION_CHANNELS_METHOD)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1873731438:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1785484984:
                if (str.equals(REQUEST_NOTIFICATIONS_PERMISSION_METHOD)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1624574341:
                if (str.equals(HAS_NOTIFICATION_POLICY_ACCESS_METHOD)) {
                    c4 = 4;
                    break;
                }
                break;
            case -1367724422:
                if (str.equals(CANCEL_METHOD)) {
                    c4 = 5;
                    break;
                }
                break;
            case -1108601471:
                if (str.equals(REQUEST_EXACT_ALARMS_PERMISSION_METHOD)) {
                    c4 = 6;
                    break;
                }
                break;
            case -950516363:
                if (str.equals(REQUEST_FULL_SCREEN_INTENT_PERMISSION_METHOD)) {
                    c4 = 7;
                    break;
                }
                break;
            case -799130106:
                if (str.equals(PENDING_NOTIFICATION_REQUESTS_METHOD)) {
                    c4 = '\b';
                    break;
                }
                break;
            case -321037320:
                if (str.equals(CANCEL_ALL_PENDING_NOTIFICATIONS_METHOD)) {
                    c4 = '\t';
                    break;
                }
                break;
            case -208611345:
                if (str.equals(GET_NOTIFICATION_APP_LAUNCH_DETAILS_METHOD)) {
                    c4 = '\n';
                    break;
                }
                break;
            case 3529469:
                if (str.equals(SHOW_METHOD)) {
                    c4 = 11;
                    break;
                }
                break;
            case 6625712:
                if (str.equals(PERIODICALLY_SHOW_METHOD)) {
                    c4 = '\f';
                    break;
                }
                break;
            case 116003316:
                if (str.equals(GET_ACTIVE_NOTIFICATION_MESSAGING_STYLE_METHOD)) {
                    c4 = '\r';
                    break;
                }
                break;
            case 476547271:
                if (str.equals(CANCEL_ALL_METHOD)) {
                    c4 = 14;
                    break;
                }
                break;
            case 548573423:
                if (str.equals(ZONED_SCHEDULE_METHOD)) {
                    c4 = 15;
                    break;
                }
                break;
            case 767006947:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_GROUP_METHOD)) {
                    c4 = 16;
                    break;
                }
                break;
            case 825311171:
                if (str.equals(GET_CALLBACK_HANDLE_METHOD)) {
                    c4 = 17;
                    break;
                }
                break;
            case 871091088:
                if (str.equals(INITIALIZE_METHOD)) {
                    c4 = 18;
                    break;
                }
                break;
            case 891942317:
                if (str.equals(ARE_NOTIFICATIONS_ENABLED_METHOD)) {
                    c4 = 19;
                    break;
                }
                break;
            case 972029712:
                if (str.equals(CAN_SCHEDULE_EXACT_NOTIFICATIONS_METHOD)) {
                    c4 = 20;
                    break;
                }
                break;
            case 1008472557:
                if (str.equals(DELETE_NOTIFICATION_CHANNEL_METHOD)) {
                    c4 = 21;
                    break;
                }
                break;
            case 1207771056:
                if (str.equals(START_FOREGROUND_SERVICE)) {
                    c4 = 22;
                    break;
                }
                break;
            case 1594833996:
                if (str.equals(GET_ACTIVE_NOTIFICATIONS_METHOD)) {
                    c4 = 23;
                    break;
                }
                break;
            case 1653467900:
                if (str.equals(CREATE_NOTIFICATION_CHANNEL_METHOD)) {
                    c4 = 24;
                    break;
                }
                break;
            case 2017789808:
                if (str.equals(REQUEST_NOTIFICATION_POLICY_ACCESS_METHOD)) {
                    c4 = 25;
                    break;
                }
                break;
            case 2147197514:
                if (str.equals(PERIODICALLY_SHOW_WITH_DURATION_METHOD)) {
                    c4 = 26;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                stopForegroundService(interfaceC0643o);
                return;
            case 1:
                getNotificationChannels(interfaceC0643o);
                return;
            case 2:
                deleteNotificationChannelGroup(c0641m, interfaceC0643o);
                return;
            case 3:
                requestNotificationsPermission(new b(0, interfaceC0643o));
                return;
            case 4:
                hasNotificationPolicyAccess(interfaceC0643o);
                return;
            case 5:
                cancel(c0641m, interfaceC0643o);
                return;
            case 6:
                requestExactAlarmsPermission(new c(0, interfaceC0643o));
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                requestFullScreenIntentPermission(new b(1, interfaceC0643o));
                return;
            case j.BYTES_FIELD_NUMBER /* 8 */:
                pendingNotificationRequests(interfaceC0643o);
                return;
            case '\t':
                cancelAllPendingNotifications(interfaceC0643o);
                return;
            case '\n':
                getNotificationAppLaunchDetails(interfaceC0643o);
                return;
            case 11:
                show(c0641m, interfaceC0643o);
                return;
            case '\f':
                repeat(c0641m, interfaceC0643o);
                return;
            case '\r':
                getActiveNotificationMessagingStyle(c0641m, interfaceC0643o);
                return;
            case 14:
                cancelAllNotifications(interfaceC0643o);
                return;
            case 15:
                zonedSchedule(c0641m, interfaceC0643o);
                return;
            case 16:
                createNotificationChannelGroup(c0641m, interfaceC0643o);
                return;
            case 17:
                getCallbackHandle(interfaceC0643o);
                return;
            case 18:
                initialize(c0641m, interfaceC0643o);
                return;
            case 19:
                areNotificationsEnabled(interfaceC0643o);
                return;
            case 20:
                setCanScheduleExactNotifications(interfaceC0643o);
                return;
            case 21:
                deleteNotificationChannel(c0641m, interfaceC0643o);
                return;
            case 22:
                startForegroundService(c0641m, interfaceC0643o);
                return;
            case 23:
                getActiveNotifications(interfaceC0643o);
                return;
            case 24:
                createNotificationChannel(c0641m, interfaceC0643o);
                return;
            case 25:
                requestNotificationPolicyAccess(new c(1, interfaceC0643o));
                return;
            case 26:
                repeat(c0641m, interfaceC0643o);
                return;
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }

    @Override // s2.InterfaceC0647s
    public boolean onNewIntent(Intent intent) {
        Activity activity;
        boolean booleanValue = sendNotificationPayloadMessage(intent).booleanValue();
        if (booleanValue && (activity = this.mainActivity) != null) {
            activity.setIntent(intent);
        }
        return booleanValue;
    }

    @Override // p2.InterfaceC0586a
    public void onReattachedToActivityForConfigChanges(p2.b bVar) {
        B1 b12 = (B1) bVar;
        b12.b(this);
        ((HashSet) b12.f5416h).add(this);
        b12.a(this);
        this.mainActivity = (Activity) b12.f5414f;
    }

    @Override // s2.InterfaceC0648t
    public boolean onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        f fVar = this.permissionRequestProgress;
        f fVar2 = f.f3341g;
        boolean z = $assertionsDisabled;
        if (fVar == fVar2 && i4 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            this.callback.a(z);
            this.permissionRequestProgress = f.f3340f;
        }
        return z;
    }

    public void requestExactAlarmsPermission(i iVar) {
        boolean canScheduleExactAlarms;
        f fVar = this.permissionRequestProgress;
        f fVar2 = f.f3340f;
        if (fVar != fVar2) {
            iVar.b();
            return;
        }
        this.callback = iVar;
        if (Build.VERSION.SDK_INT >= 31) {
            canScheduleExactAlarms = getAlarmManager(this.applicationContext).canScheduleExactAlarms();
            if (!canScheduleExactAlarms) {
                this.permissionRequestProgress = f.f3343i;
                this.mainActivity.startActivityForResult(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + this.applicationContext.getPackageName())), 2);
                return;
            }
            this.callback.a(true);
            this.permissionRequestProgress = fVar2;
            return;
        }
        iVar.a(true);
    }

    public void requestFullScreenIntentPermission(i iVar) {
        boolean canUseFullScreenIntent;
        f fVar = this.permissionRequestProgress;
        f fVar2 = f.f3340f;
        if (fVar != fVar2) {
            iVar.b();
            return;
        }
        this.callback = iVar;
        if (Build.VERSION.SDK_INT >= 34) {
            NotificationManager notificationManager = (NotificationManager) this.applicationContext.getSystemService("notification");
            getAlarmManager(this.applicationContext);
            canUseFullScreenIntent = notificationManager.canUseFullScreenIntent();
            if (!canUseFullScreenIntent) {
                this.permissionRequestProgress = f.f3344j;
                this.mainActivity.startActivityForResult(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + this.applicationContext.getPackageName())), 3);
                return;
            }
            this.callback.a(true);
            this.permissionRequestProgress = fVar2;
            return;
        }
        iVar.a(true);
    }

    public void requestNotificationPolicyAccess(i iVar) {
        f fVar = this.permissionRequestProgress;
        f fVar2 = f.f3340f;
        if (fVar != fVar2) {
            iVar.b();
            return;
        }
        this.callback = iVar;
        if (((NotificationManager) this.applicationContext.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            this.callback.a(true);
            this.permissionRequestProgress = fVar2;
            return;
        }
        this.permissionRequestProgress = f.f3342h;
        String packageName = this.applicationContext.getPackageName();
        Bundle bundle = new Bundle();
        bundle.putString(":settings:fragment_args_key", packageName);
        this.mainActivity.startActivityForResult(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS").putExtra(":settings:fragment_args_key", packageName).putExtra(":settings:show_fragment_args", bundle), 4);
    }

    public void requestNotificationsPermission(i iVar) {
        f fVar = this.permissionRequestProgress;
        f fVar2 = f.f3340f;
        if (fVar != fVar2) {
            iVar.b();
            return;
        }
        this.callback = iVar;
        if (Build.VERSION.SDK_INT >= 33) {
            if (android.support.v4.media.session.a.i(this.mainActivity, "android.permission.POST_NOTIFICATIONS") == 0) {
                this.callback.a(true);
                this.permissionRequestProgress = fVar2;
                return;
            } else {
                this.permissionRequestProgress = f.f3341g;
                android.support.v4.media.session.a.u(this.mainActivity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
                return;
            }
        }
        this.callback.a(new H(this.mainActivity).f6329b.areNotificationsEnabled());
    }
}
