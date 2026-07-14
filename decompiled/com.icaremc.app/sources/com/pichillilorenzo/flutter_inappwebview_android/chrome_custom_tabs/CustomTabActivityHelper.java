package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import b.C0219b;
import b.InterfaceC0221d;
import java.util.List;
import java.util.Map;
import r.AbstractC0606a;
import r.AbstractC0613h;
import r.AbstractServiceConnectionC0617l;
import r.BinderC0612g;
import r.C0615j;
import r.o;
import s.C0626c;

/* loaded from: classes.dex */
public class CustomTabActivityHelper implements ServiceConnectionCallback {
    private AbstractC0613h mClient;
    private AbstractServiceConnectionC0617l mConnection;
    private ConnectionCallback mConnectionCallback;
    private AbstractC0606a mCustomTabsCallback;
    private o mCustomTabsSession;

    /* loaded from: classes.dex */
    public interface ConnectionCallback {
        void onCustomTabsConnected();

        void onCustomTabsDisconnected();
    }

    public static boolean isAvailable(Activity activity) {
        if (CustomTabsHelper.getPackageNameToUse(activity) != null) {
            return true;
        }
        return false;
    }

    public static void openCustomTab(Activity activity, Intent intent, Uri uri, Map<String, String> map, Uri uri2, int i4) {
        intent.setData(uri);
        if (map != null) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            intent.putExtra("com.android.browser.headers", bundle);
        }
        if (uri2 != null) {
            intent.putExtra("android.intent.extra.REFERRER", uri2);
        }
        activity.startActivityForResult(intent, i4);
    }

    public static void openTrustedWebActivity(Activity activity, C0626c c0626c, Uri uri, Map<String, String> map, Uri uri2, int i4) {
        openCustomTab(activity, c0626c.f6118a, uri, map, uri2, i4);
    }

    public boolean bindCustomTabsService(Activity activity) {
        if (this.mClient != null) {
            return true;
        }
        String packageNameToUse = CustomTabsHelper.getPackageNameToUse(activity);
        if (packageNameToUse == null) {
            return false;
        }
        ServiceConnection serviceConnection = new ServiceConnection(this);
        this.mConnection = serviceConnection;
        serviceConnection.setApplicationContext(activity.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!packageNameToUse.isEmpty()) {
            intent.setPackage(packageNameToUse);
            return activity.bindService(intent, serviceConnection, 33);
        }
        throw new IllegalArgumentException("Service Intents must be explicit");
    }

    public o getSession() {
        AbstractC0613h abstractC0613h = this.mClient;
        o oVar = null;
        if (abstractC0613h == null) {
            this.mCustomTabsSession = null;
        } else if (this.mCustomTabsSession == null) {
            AbstractC0606a abstractC0606a = this.mCustomTabsCallback;
            InterfaceC0221d interfaceC0221d = abstractC0613h.f5994a;
            BinderC0612g binderC0612g = new BinderC0612g(abstractC0606a);
            try {
                if (((C0219b) interfaceC0221d).f(binderC0612g)) {
                    oVar = new o(interfaceC0221d, binderC0612g, abstractC0613h.f5995b);
                }
            } catch (RemoteException unused) {
            }
            this.mCustomTabsSession = oVar;
        }
        return this.mCustomTabsSession;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        o session;
        if (this.mClient != null && (session = getSession()) != null) {
            try {
                return ((C0219b) session.f6012b).d(session.f6013c, uri, session.a(bundle), list);
            } catch (RemoteException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ServiceConnectionCallback
    public void onServiceConnected(AbstractC0613h abstractC0613h) {
        this.mClient = abstractC0613h;
        abstractC0613h.getClass();
        try {
            ((C0219b) abstractC0613h.f5994a).n();
        } catch (RemoteException unused) {
        }
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsConnected();
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ServiceConnectionCallback
    public void onServiceDisconnected() {
        this.mClient = null;
        this.mCustomTabsSession = null;
        ConnectionCallback connectionCallback = this.mConnectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsDisconnected();
        }
    }

    public void setConnectionCallback(ConnectionCallback connectionCallback) {
        this.mConnectionCallback = connectionCallback;
    }

    public void setCustomTabsCallback(AbstractC0606a abstractC0606a) {
        this.mCustomTabsCallback = abstractC0606a;
    }

    public void unbindCustomTabsService(Activity activity) {
        AbstractServiceConnectionC0617l abstractServiceConnectionC0617l = this.mConnection;
        if (abstractServiceConnectionC0617l == null) {
            return;
        }
        activity.unbindService(abstractServiceConnectionC0617l);
        this.mClient = null;
        this.mCustomTabsSession = null;
        this.mConnection = null;
    }

    public static void openCustomTab(Activity activity, C0615j c0615j, Uri uri, Map<String, String> map, Uri uri2, int i4) {
        openCustomTab(activity, c0615j.f6003a, uri, map, uri2, i4);
    }
}
