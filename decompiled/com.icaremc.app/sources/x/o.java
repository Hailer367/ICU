package x;

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
import com.icaremc.app.R;
import io.flutter.plugin.platform.C0381e;

/* loaded from: classes.dex */
public final class o extends B {

    /* renamed from: e, reason: collision with root package name */
    public int f6415e;

    /* renamed from: f, reason: collision with root package name */
    public I f6416f;

    /* renamed from: g, reason: collision with root package name */
    public PendingIntent f6417g;

    /* renamed from: h, reason: collision with root package name */
    public PendingIntent f6418h;

    /* renamed from: i, reason: collision with root package name */
    public PendingIntent f6419i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6420j;
    public Integer k;

    /* renamed from: l, reason: collision with root package name */
    public Integer f6421l;

    /* renamed from: m, reason: collision with root package name */
    public IconCompat f6422m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f6423n;

    @Override // x.B
    public final void a(Bundle bundle) {
        super.a(bundle);
        bundle.putInt("android.callType", this.f6415e);
        bundle.putBoolean("android.callIsVideo", this.f6420j);
        I i4 = this.f6416f;
        if (i4 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                bundle.putParcelable("android.callPerson", AbstractC0713m.b(C.b.t(i4)));
            } else {
                bundle.putParcelable("android.callPersonCompat", i4.b());
            }
        }
        IconCompat iconCompat = this.f6422m;
        if (iconCompat != null) {
            bundle.putParcelable("android.verificationIcon", iconCompat.h(this.f6304a.f6391a));
        }
        bundle.putCharSequence("android.verificationText", this.f6423n);
        bundle.putParcelable("android.answerIntent", this.f6417g);
        bundle.putParcelable("android.declineIntent", this.f6418h);
        bundle.putParcelable("android.hangUpIntent", this.f6419i);
        Integer num = this.k;
        if (num != null) {
            bundle.putInt("android.answerColor", num.intValue());
        }
        Integer num2 = this.f6421l;
        if (num2 != null) {
            bundle.putInt("android.declineColor", num2.intValue());
        }
    }

    @Override // x.B
    public final void b(C0381e c0381e) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Notification.Builder builder = (Notification.Builder) c0381e.f4327c;
        int i4 = Build.VERSION.SDK_INT;
        String str = null;
        r5 = null;
        Notification.CallStyle a4 = null;
        if (i4 >= 31) {
            int i5 = this.f6415e;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (Log.isLoggable("NotifCompat", 3)) {
                            Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f6415e));
                        }
                    } else {
                        I i6 = this.f6416f;
                        i6.getClass();
                        a4 = AbstractC0714n.c(C.b.t(i6), this.f6419i, this.f6417g);
                    }
                } else {
                    I i7 = this.f6416f;
                    i7.getClass();
                    a4 = AbstractC0714n.b(C.b.t(i7), this.f6419i);
                }
            } else {
                I i8 = this.f6416f;
                i8.getClass();
                a4 = AbstractC0714n.a(C.b.t(i8), this.f6418h, this.f6417g);
            }
            if (a4 != null) {
                a4.setBuilder(builder);
                Integer num = this.k;
                if (num != null) {
                    AbstractC0714n.d(a4, num.intValue());
                }
                Integer num2 = this.f6421l;
                if (num2 != null) {
                    AbstractC0714n.e(a4, num2.intValue());
                }
                AbstractC0714n.h(a4, this.f6423n);
                IconCompat iconCompat = this.f6422m;
                if (iconCompat != null) {
                    AbstractC0714n.g(a4, iconCompat.h(this.f6304a.f6391a));
                }
                AbstractC0714n.f(a4, this.f6420j);
                return;
            }
            return;
        }
        I i9 = this.f6416f;
        if (i9 != null) {
            charSequence = i9.f6330a;
        } else {
            charSequence = null;
        }
        builder.setContentTitle(charSequence);
        Bundle bundle = this.f6304a.f6414y;
        if (bundle != null && bundle.containsKey("android.text")) {
            charSequence2 = this.f6304a.f6414y.getCharSequence("android.text");
        } else {
            charSequence2 = null;
        }
        if (charSequence2 == null) {
            int i10 = this.f6415e;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        str = this.f6304a.f6391a.getResources().getString(R.string.call_notification_screening_text);
                    }
                } else {
                    str = this.f6304a.f6391a.getResources().getString(R.string.call_notification_ongoing_text);
                }
            } else {
                str = this.f6304a.f6391a.getResources().getString(R.string.call_notification_incoming_text);
            }
            charSequence2 = str;
        }
        builder.setContentText(charSequence2);
        I i11 = this.f6416f;
        if (i11 != null) {
            IconCompat iconCompat2 = i11.f6331b;
            if (iconCompat2 != null) {
                builder.setLargeIcon(iconCompat2.h(this.f6304a.f6391a));
            }
            if (i4 >= 28) {
                I i12 = this.f6416f;
                i12.getClass();
                AbstractC0713m.a(builder, C.b.t(i12));
            } else {
                builder.addPerson(this.f6416f.f6332c);
            }
        }
        builder.setCategory("call");
    }

    @Override // x.B
    public final String c() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }

    @Override // x.B
    public final void d(Bundle bundle) {
        Integer num;
        super.d(bundle);
        this.f6415e = bundle.getInt("android.callType");
        this.f6420j = bundle.getBoolean("android.callIsVideo");
        if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
            this.f6416f = C.b.c(h2.l.c(bundle.getParcelable("android.callPerson")));
        } else if (bundle.containsKey("android.callPersonCompat")) {
            this.f6416f = I.a(bundle.getBundle("android.callPersonCompat"));
        }
        if (bundle.containsKey("android.verificationIcon")) {
            this.f6422m = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
        } else if (bundle.containsKey("android.verificationIconCompat")) {
            this.f6422m = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
        }
        this.f6423n = bundle.getCharSequence("android.verificationText");
        this.f6417g = (PendingIntent) bundle.getParcelable("android.answerIntent");
        this.f6418h = (PendingIntent) bundle.getParcelable("android.declineIntent");
        this.f6419i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
        Integer num2 = null;
        if (bundle.containsKey("android.answerColor")) {
            num = Integer.valueOf(bundle.getInt("android.answerColor"));
        } else {
            num = null;
        }
        this.k = num;
        if (bundle.containsKey("android.declineColor")) {
            num2 = Integer.valueOf(bundle.getInt("android.declineColor"));
        }
        this.f6421l = num2;
    }

    public final C0708h e(int i4, int i5, Integer num, int i6, PendingIntent pendingIntent) {
        if (num == null) {
            num = Integer.valueOf(this.f6304a.f6391a.getColor(i6));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f6304a.f6391a.getResources().getString(i5));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
        Context context = this.f6304a.f6391a;
        PorterDuff.Mode mode = IconCompat.k;
        context.getClass();
        C0708h a4 = new C0707g(IconCompat.e(context.getResources(), context.getPackageName(), i4), spannableStringBuilder, pendingIntent).a();
        a4.f6366a.putBoolean("key_action_priority", true);
        return a4;
    }
}
