package io.flutter.plugins.urllauncher;

import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.UrlLauncher;
import io.flutter.plugins.urllauncher.UrlLauncherApi;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler, UrlLauncher.IntentResolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2451a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2452b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f2451a = i2;
        this.f2452b = obj;
    }

    @Override // io.flutter.plugins.urllauncher.UrlLauncher.IntentResolver
    public String getHandlerComponentName(Intent intent) {
        return UrlLauncher.a((Context) this.f2452b, intent);
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        switch (this.f2451a) {
            case 0:
                UrlLauncherApi.Companion.d((UrlLauncherApi) this.f2452b, obj, reply);
                return;
            case 1:
                UrlLauncherApi.Companion.b((UrlLauncherApi) this.f2452b, obj, reply);
                return;
            case 2:
                UrlLauncherApi.Companion.e((UrlLauncherApi) this.f2452b, obj, reply);
                return;
            case 3:
                UrlLauncherApi.Companion.a((UrlLauncherApi) this.f2452b, obj, reply);
                return;
            default:
                UrlLauncherApi.Companion.f((UrlLauncherApi) this.f2452b, obj, reply);
                return;
        }
    }
}
