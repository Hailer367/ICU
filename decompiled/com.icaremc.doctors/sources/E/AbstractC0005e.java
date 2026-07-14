package E;

import android.app.Notification;
import android.app.Person;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.PrecomputedText;
import android.view.DisplayCutout;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.core.graphics.drawable.IconCompat;
import java.util.concurrent.Executor;
import m.C0273u;

/* renamed from: E.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0005e {
    public static void a(Notification.Builder builder, Person person) {
        builder.addPerson(person);
    }

    public static Handler b(Looper looper) {
        return Handler.createAsync(looper);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [u.K, java.lang.Object] */
    public static u.K c(Person person) {
        IconCompat iconCompat;
        CharSequence name = person.getName();
        if (person.getIcon() != null) {
            iconCompat = IconCompat.b(person.getIcon());
        } else {
            iconCompat = null;
        }
        String uri = person.getUri();
        String key = person.getKey();
        boolean isBot = person.isBot();
        boolean isImportant = person.isImportant();
        ?? obj = new Object();
        obj.f3700a = name;
        obj.f3701b = iconCompat;
        obj.f3702c = uri;
        obj.f3703d = key;
        obj.f3704e = isBot;
        obj.f3705f = isImportant;
        return obj;
    }

    public static String[] d(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static Executor e(Context context) {
        return context.getMainExecutor();
    }

    public static int f(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String g(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static int h(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int i(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int j(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int k(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int l(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static PrecomputedText.Params m(C0273u c0273u) {
        return c0273u.getTextMetricsParams();
    }

    public static int n(Object obj) {
        return ((Icon) obj).getType();
    }

    public static Uri o(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static void p(TextView textView, int i2) {
        textView.setFirstBaselineToTopHeight(i2);
    }

    public static void q(Notification.Action.Builder builder, int i2) {
        builder.setSemanticAction(i2);
    }

    public static boolean r(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }

    public static Person s(u.K k2) {
        Person.Builder name = new Person.Builder().setName(k2.f3700a);
        IconCompat iconCompat = k2.f3701b;
        Icon icon = null;
        if (iconCompat != null) {
            icon = iconCompat.h(null);
        }
        return name.setIcon(icon).setUri(k2.f3702c).setKey(k2.f3703d).setBot(k2.f3704e).setImportant(k2.f3705f).build();
    }
}
