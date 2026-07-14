package C;

import android.app.Notification;
import android.app.Person;
import android.content.Context;
import android.content.pm.PackageInfo;
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
import o.C0516f0;
import x.I;

/* loaded from: classes.dex */
public abstract class b {
    public static void a(Notification.Builder builder, Person person) {
        builder.addPerson(person);
    }

    public static Handler b(Looper looper) {
        return Handler.createAsync(looper);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [x.I, java.lang.Object] */
    public static I c(Person person) {
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
        obj.f6330a = name;
        obj.f6331b = iconCompat;
        obj.f6332c = uri;
        obj.f6333d = key;
        obj.f6334e = isBot;
        obj.f6335f = isImportant;
        return obj;
    }

    public static String[] d(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static long e(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    public static Executor f(Context context) {
        return context.getMainExecutor();
    }

    public static int g(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static String h(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    public static int i(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int j(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int k(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int l(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int m(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static PrecomputedText.Params n(C0516f0 c0516f0) {
        return c0516f0.getTextMetricsParams();
    }

    public static int o(Object obj) {
        return ((Icon) obj).getType();
    }

    public static Uri p(Object obj) {
        return ((Icon) obj).getUri();
    }

    public static void q(TextView textView, int i4) {
        textView.setFirstBaselineToTopHeight(i4);
    }

    public static void r(Notification.Action.Builder builder, int i4) {
        builder.setSemanticAction(i4);
    }

    public static boolean s(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }

    public static Person t(I i4) {
        Person.Builder name = new Person.Builder().setName(i4.f6330a);
        IconCompat iconCompat = i4.f6331b;
        Icon icon = null;
        if (iconCompat != null) {
            icon = iconCompat.h(null);
        }
        return name.setIcon(icon).setUri(i4.f6332c).setKey(i4.f6333d).setBot(i4.f6334e).setImportant(i4.f6335f).build();
    }
}
