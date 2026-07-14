package u;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class s {
    public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j2, Person person) {
        return new Notification.MessagingStyle.Message(charSequence, j2, person);
    }

    public static Parcelable a(Person person) {
        return person;
    }
}
