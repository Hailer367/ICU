package u;

import E.AbstractC0005e;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import com.icaremc.doctors.R;

/* renamed from: u.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0322m extends z {

    /* renamed from: e, reason: collision with root package name */
    public int f3769e;

    /* renamed from: f, reason: collision with root package name */
    public K f3770f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f3771g;

    /* renamed from: h, reason: collision with root package name */
    public PendingIntent f3772h;

    /* renamed from: i, reason: collision with root package name */
    public PendingIntent f3773i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3774j;

    /* renamed from: k, reason: collision with root package name */
    public Integer f3775k;

    /* renamed from: l, reason: collision with root package name */
    public Integer f3776l;

    /* renamed from: m, reason: collision with root package name */
    public IconCompat f3777m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f3778n;

    @Override // u.z
    public final void a(Bundle bundle) {
        super.a(bundle);
        bundle.putInt("android.callType", this.f3769e);
        bundle.putBoolean("android.callIsVideo", this.f3774j);
        K k2 = this.f3770f;
        if (k2 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                bundle.putParcelable("android.callPerson", AbstractC0320k.b(AbstractC0005e.s(k2)));
            } else {
                bundle.putParcelable("android.callPersonCompat", k2.b());
            }
        }
        IconCompat iconCompat = this.f3777m;
        if (iconCompat != null) {
            bundle.putParcelable("android.verificationIcon", iconCompat.h(this.f3804a.f3747a));
        }
        bundle.putCharSequence("android.verificationText", this.f3778n);
        bundle.putParcelable("android.answerIntent", this.f3771g);
        bundle.putParcelable("android.declineIntent", this.f3772h);
        bundle.putParcelable("android.hangUpIntent", this.f3773i);
        Integer num = this.f3775k;
        if (num != null) {
            bundle.putInt("android.answerColor", num.intValue());
        }
        Integer num2 = this.f3776l;
        if (num2 != null) {
            bundle.putInt("android.declineColor", num2.intValue());
        }
    }

    @Override // u.z
    public final void b(C0308C c0308c) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Notification.Builder builder = c0308c.f3674b;
        int i2 = Build.VERSION.SDK_INT;
        String str = null;
        r5 = null;
        Notification.CallStyle a2 = null;
        if (i2 >= 31) {
            int i3 = this.f3769e;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (Log.isLoggable("NotifCompat", 3)) {
                            Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f3769e));
                        }
                    } else {
                        K k2 = this.f3770f;
                        k2.getClass();
                        a2 = AbstractC0321l.c(AbstractC0005e.s(k2), this.f3773i, this.f3771g);
                    }
                } else {
                    K k3 = this.f3770f;
                    k3.getClass();
                    a2 = AbstractC0321l.b(AbstractC0005e.s(k3), this.f3773i);
                }
            } else {
                K k4 = this.f3770f;
                k4.getClass();
                a2 = AbstractC0321l.a(AbstractC0005e.s(k4), this.f3772h, this.f3771g);
            }
            if (a2 != null) {
                a2.setBuilder(builder);
                Integer num = this.f3775k;
                if (num != null) {
                    AbstractC0321l.d(a2, num.intValue());
                }
                Integer num2 = this.f3776l;
                if (num2 != null) {
                    AbstractC0321l.e(a2, num2.intValue());
                }
                AbstractC0321l.h(a2, this.f3778n);
                IconCompat iconCompat = this.f3777m;
                if (iconCompat != null) {
                    AbstractC0321l.g(a2, iconCompat.h(this.f3804a.f3747a));
                }
                AbstractC0321l.f(a2, this.f3774j);
                return;
            }
            return;
        }
        K k5 = this.f3770f;
        if (k5 != null) {
            charSequence = k5.f3700a;
        } else {
            charSequence = null;
        }
        builder.setContentTitle(charSequence);
        Bundle bundle = this.f3804a.y;
        if (bundle != null && bundle.containsKey("android.text")) {
            charSequence2 = this.f3804a.y.getCharSequence("android.text");
        } else {
            charSequence2 = null;
        }
        if (charSequence2 == null) {
            int i4 = this.f3769e;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        str = this.f3804a.f3747a.getResources().getString(R.string.call_notification_screening_text);
                    }
                } else {
                    str = this.f3804a.f3747a.getResources().getString(R.string.call_notification_ongoing_text);
                }
            } else {
                str = this.f3804a.f3747a.getResources().getString(R.string.call_notification_incoming_text);
            }
            charSequence2 = str;
        }
        builder.setContentText(charSequence2);
        K k6 = this.f3770f;
        if (k6 != null) {
            IconCompat iconCompat2 = k6.f3701b;
            if (iconCompat2 != null) {
                builder.setLargeIcon(iconCompat2.h(this.f3804a.f3747a));
            }
            if (i2 >= 28) {
                K k7 = this.f3770f;
                k7.getClass();
                AbstractC0320k.a(builder, AbstractC0005e.s(k7));
            } else {
                builder.addPerson(this.f3770f.f3702c);
            }
        }
        builder.setCategory("call");
    }

    @Override // u.z
    public final String c() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }

    @Override // u.z
    public final void d(Bundle bundle) {
        Integer num;
        super.d(bundle);
        this.f3769e = bundle.getInt("android.callType");
        this.f3774j = bundle.getBoolean("android.callIsVideo");
        if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
            this.f3770f = AbstractC0005e.c(io.flutter.embedding.engine.image.a.d(bundle.getParcelable("android.callPerson")));
        } else if (bundle.containsKey("android.callPersonCompat")) {
            this.f3770f = K.a(bundle.getBundle("android.callPersonCompat"));
        }
        if (bundle.containsKey("android.verificationIcon")) {
            this.f3777m = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
        } else if (bundle.containsKey("android.verificationIconCompat")) {
            this.f3777m = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
        }
        this.f3778n = bundle.getCharSequence("android.verificationText");
        this.f3771g = (PendingIntent) bundle.getParcelable("android.answerIntent");
        this.f3772h = (PendingIntent) bundle.getParcelable("android.declineIntent");
        this.f3773i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
        Integer num2 = null;
        if (bundle.containsKey("android.answerColor")) {
            num = Integer.valueOf(bundle.getInt("android.answerColor"));
        } else {
            num = null;
        }
        this.f3775k = num;
        if (bundle.containsKey("android.declineColor")) {
            num2 = Integer.valueOf(bundle.getInt("android.declineColor"));
        }
        this.f3776l = num2;
    }

    public final C0315f e(int i2, int i3, Integer num, int i4, PendingIntent pendingIntent) {
        if (num == null) {
            num = Integer.valueOf(this.f3804a.f3747a.getColor(i4));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f3804a.f3747a.getResources().getString(i3));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
        Context context = this.f3804a.f3747a;
        PorterDuff.Mode mode = IconCompat.f1288k;
        context.getClass();
        C0315f a2 = new C0314e(IconCompat.e(context.getResources(), context.getPackageName(), i2), spannableStringBuilder, pendingIntent).a();
        a2.f3722a.putBoolean("key_action_priority", true);
        return a2;
    }
}
