package x;

import android.app.Notification;
import android.graphics.drawable.Icon;
import java.util.List;

/* loaded from: classes.dex */
public abstract class x {
    public static void a(Notification.ProgressStyle progressStyle, int i4) {
        progressStyle.setProgress(i4);
    }

    public static void b(Notification.ProgressStyle progressStyle, Icon icon) {
        progressStyle.setProgressEndIcon(icon);
    }

    public static void c(Notification.ProgressStyle progressStyle, boolean z) {
        progressStyle.setProgressIndeterminate(z);
    }

    public static void d(Notification.ProgressStyle progressStyle, List<y> list) {
        for (y yVar : list) {
            progressStyle.addProgressPoint(new Notification.ProgressStyle.Point(yVar.f6435a).setColor(yVar.f6437c).setId(yVar.f6436b));
        }
    }

    public static void e(Notification.ProgressStyle progressStyle, List<z> list) {
        for (z zVar : list) {
            progressStyle.addProgressSegment(new Notification.ProgressStyle.Segment(zVar.f6438a).setColor(zVar.f6440c).setId(zVar.f6439b));
        }
    }

    public static void f(Notification.ProgressStyle progressStyle, Icon icon) {
        progressStyle.setProgressStartIcon(icon);
    }

    public static void g(Notification.ProgressStyle progressStyle, Icon icon) {
        progressStyle.setProgressTrackerIcon(icon);
    }

    public static void h(Notification.ProgressStyle progressStyle, boolean z) {
        progressStyle.setStyledByProgress(z);
    }
}
