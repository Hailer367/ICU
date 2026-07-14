package Z0;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: classes.dex */
public final class m implements DialogInterface.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2156f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Intent f2157g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f2158h;

    public /* synthetic */ m(Intent intent, Object obj, int i4) {
        this.f2156f = i4;
        this.f2157g = intent;
        this.f2158h = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [Y0.e, java.lang.Object] */
    public final void a() {
        switch (this.f2156f) {
            case 0:
                Intent intent = this.f2157g;
                if (intent != null) {
                    ((GoogleApiActivity) this.f2158h).startActivityForResult(intent, 2);
                    return;
                }
                return;
            default:
                Intent intent2 = this.f2157g;
                if (intent2 != null) {
                    this.f2158h.a(intent2, 2);
                    return;
                }
                return;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e4) {
                String str = "Failed to start resolution intent.";
                if (true == Build.FINGERPRINT.contains("generic")) {
                    str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
                }
                Log.e("DialogRedirect", str, e4);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
