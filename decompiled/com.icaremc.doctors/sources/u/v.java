package u;

import android.app.Notification;
import android.graphics.drawable.Icon;
import java.util.List;

/* loaded from: classes.dex */
public abstract class v {
    public static void a(Notification.ProgressStyle progressStyle, int i2) {
        progressStyle.setProgress(i2);
    }

    public static void b(Notification.ProgressStyle progressStyle, Icon icon) {
        progressStyle.setProgressEndIcon(icon);
    }

    public static void c(Notification.ProgressStyle progressStyle, boolean z) {
        progressStyle.setProgressIndeterminate(z);
    }

    public static void d(Notification.ProgressStyle progressStyle, List<w> list) {
        for (w wVar : list) {
            progressStyle.addProgressPoint(new Notification.ProgressStyle.Point(wVar.f3790a).setColor(wVar.f3792c).setId(wVar.f3791b));
        }
    }

    public static void e(Notification.ProgressStyle progressStyle, List<x> list) {
        for (x xVar : list) {
            progressStyle.addProgressSegment(new Notification.ProgressStyle.Segment(xVar.f3793a).setColor(xVar.f3795c).setId(xVar.f3794b));
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
