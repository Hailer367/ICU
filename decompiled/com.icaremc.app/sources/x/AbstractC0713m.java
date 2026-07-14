package x;

import android.app.Notification;
import android.app.Person;
import android.os.Parcelable;

/* renamed from: x.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0713m {
    public static Notification.Builder a(Notification.Builder builder, Person person) {
        return builder.addPerson(person);
    }

    public static Parcelable b(Person person) {
        return person;
    }
}
