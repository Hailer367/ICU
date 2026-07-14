package x;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class u {
    public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j4, Person person) {
        return new Notification.MessagingStyle.Message(charSequence, j4, person);
    }

    public static Parcelable a(Person person) {
        return person;
    }
}
