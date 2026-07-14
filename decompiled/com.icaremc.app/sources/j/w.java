package j;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class w extends x {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5013c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LayoutInflaterFactory2C0393A f5014d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f5015e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A, A2.t tVar) {
        super(layoutInflaterFactory2C0393A);
        this.f5014d = layoutInflaterFactory2C0393A;
        this.f5015e = tVar;
    }

    @Override // j.x
    public final IntentFilter d() {
        switch (this.f5013c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [j.L, java.lang.Object] */
    @Override // j.x
    public final int e() {
        Location location;
        boolean z;
        long j4;
        Location location2;
        switch (this.f5013c) {
            case 0:
                if (((PowerManager) this.f5015e).isPowerSaveMode()) {
                    return 2;
                }
                return 1;
            default:
                A2.t tVar = (A2.t) this.f5015e;
                C0405M c0405m = (C0405M) tVar.f101i;
                LocationManager locationManager = (LocationManager) tVar.f100h;
                if (c0405m.f4907b > System.currentTimeMillis()) {
                    z = c0405m.f4906a;
                } else {
                    Context context = (Context) tVar.f99g;
                    Location location3 = null;
                    if (android.support.v4.media.session.a.j(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e4) {
                            Log.d("TwilightManager", "Failed to get last known location", e4);
                        }
                        if (locationManager.isProviderEnabled("network")) {
                            location2 = locationManager.getLastKnownLocation("network");
                            location = location2;
                        }
                        location2 = null;
                        location = location2;
                    } else {
                        location = null;
                    }
                    if (android.support.v4.media.session.a.j(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                location3 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e5) {
                            Log.d("TwilightManager", "Failed to get last known location", e5);
                        }
                    }
                    if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                        location = location3;
                    }
                    z = false;
                    if (location != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (C0404L.f4902d == null) {
                            C0404L.f4902d = new Object();
                        }
                        C0404L c0404l = C0404L.f4902d;
                        c0404l.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        c0404l.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                        if (c0404l.f4905c == 1) {
                            z = true;
                        }
                        long j5 = c0404l.f4904b;
                        long j6 = c0404l.f4903a;
                        c0404l.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
                        long j7 = c0404l.f4904b;
                        if (j5 != -1 && j6 != -1) {
                            if (currentTimeMillis > j6) {
                                j5 = j7;
                            } else if (currentTimeMillis > j5) {
                                j5 = j6;
                            }
                            j4 = j5 + 60000;
                        } else {
                            j4 = currentTimeMillis + 43200000;
                        }
                        c0405m.f4906a = z;
                        c0405m.f4907b = j4;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i4 = Calendar.getInstance().get(11);
                        if (i4 < 6 || i4 >= 22) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    return 1;
                }
                return 2;
        }
    }

    @Override // j.x
    public final void g() {
        switch (this.f5013c) {
            case 0:
                this.f5014d.o(true, true);
                return;
            default:
                this.f5014d.o(true, true);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(LayoutInflaterFactory2C0393A layoutInflaterFactory2C0393A, Context context) {
        super(layoutInflaterFactory2C0393A);
        this.f5014d = layoutInflaterFactory2C0393A;
        this.f5015e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
