package u;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

/* renamed from: u.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0320k {
    public static Notification.Builder a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Parcelable b(Person person) {
        return person;
    }
}
