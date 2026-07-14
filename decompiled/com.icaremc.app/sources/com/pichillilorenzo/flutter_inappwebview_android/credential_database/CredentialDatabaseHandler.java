package com.pichillilorenzo.flutter_inappwebview_android.credential_database;

import android.content.Context;
import android.webkit.WebViewDatabase;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLCredentialContract;
import com.pichillilorenzo.flutter_inappwebview_android.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import s2.C0641m;
import s2.C0644p;
import s2.InterfaceC0643o;

/* loaded from: classes.dex */
public class CredentialDatabaseHandler extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "CredentialDatabaseHandler";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_credential_database";
    public static CredentialDatabase credentialDatabase;
    public InAppWebViewFlutterPlugin plugin;

    public CredentialDatabaseHandler(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new C0644p(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static void init(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        if (credentialDatabase == null) {
            credentialDatabase = CredentialDatabase.getInstance(inAppWebViewFlutterPlugin.applicationContext);
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
        credentialDatabase = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, s2.InterfaceC0642n
    public void onMethodCall(C0641m c0641m, InterfaceC0643o interfaceC0643o) {
        Context context;
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null) {
            init(inAppWebViewFlutterPlugin);
        }
        String str = c0641m.f6155a;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1851697792:
                if (str.equals("clearAllAuthCredentials")) {
                    c4 = 0;
                    break;
                }
                break;
            case -410271914:
                if (str.equals("getHttpAuthCredentials")) {
                    c4 = 1;
                    break;
                }
                break;
            case 589173355:
                if (str.equals("removeHttpAuthCredential")) {
                    c4 = 2;
                    break;
                }
                break;
            case 998955721:
                if (str.equals("setHttpAuthCredential")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1084504936:
                if (str.equals("removeHttpAuthCredentials")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1930845769:
                if (str.equals("getAllAuthCredentials")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                CredentialDatabase credentialDatabase2 = credentialDatabase;
                if (credentialDatabase2 != null) {
                    credentialDatabase2.clearAllAuthCredentials();
                    InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
                    if (inAppWebViewFlutterPlugin2 != null && (context = inAppWebViewFlutterPlugin2.applicationContext) != null) {
                        WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
                    }
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                }
                interfaceC0643o.success(Boolean.FALSE);
                return;
            case 1:
                ArrayList arrayList = new ArrayList();
                if (credentialDatabase != null) {
                    Iterator<URLCredential> it = credentialDatabase.getHttpAuthCredentials((String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT)).iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().toMap());
                    }
                }
                interfaceC0643o.success(arrayList);
                return;
            case 2:
                if (credentialDatabase != null) {
                    credentialDatabase.removeHttpAuthCredential((String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT), (String) c0641m.a(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME), (String) c0641m.a(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 3:
                if (credentialDatabase != null) {
                    credentialDatabase.setHttpAuthCredential((String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT), (String) c0641m.a(URLCredentialContract.FeedEntry.COLUMN_NAME_USERNAME), (String) c0641m.a(URLCredentialContract.FeedEntry.COLUMN_NAME_PASSWORD));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 4:
                if (credentialDatabase != null) {
                    credentialDatabase.removeHttpAuthCredentials((String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL), (String) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM), (Integer) c0641m.a(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT));
                    interfaceC0643o.success(Boolean.TRUE);
                    return;
                } else {
                    interfaceC0643o.success(Boolean.FALSE);
                    return;
                }
            case 5:
                ArrayList arrayList2 = new ArrayList();
                CredentialDatabase credentialDatabase3 = credentialDatabase;
                if (credentialDatabase3 != null) {
                    for (URLProtectionSpace uRLProtectionSpace : credentialDatabase3.protectionSpaceDao.getAll()) {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator<URLCredential> it2 = credentialDatabase.credentialDao.getAllByProtectionSpaceId(uRLProtectionSpace.getId()).iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(it2.next().toMap());
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("protectionSpace", uRLProtectionSpace.toMap());
                        hashMap.put("credentials", arrayList3);
                        arrayList2.add(hashMap);
                    }
                }
                interfaceC0643o.success(arrayList2);
                return;
            default:
                interfaceC0643o.notImplemented();
                return;
        }
    }
}
