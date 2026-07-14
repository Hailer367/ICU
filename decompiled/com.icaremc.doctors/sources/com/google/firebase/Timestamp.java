package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import c1.l;
import j$.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp createFromParcel(Parcel source) {
            h.e(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp[] newArray(int i2) {
            return new Timestamp[i2];
        }
    };

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Q0.e toPreciseTime(Date date) {
            long j2 = 1000;
            long time = date.getTime() / j2;
            int time2 = (int) ((date.getTime() % j2) * 1000000);
            if (time2 < 0) {
                return new Q0.e(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000));
            }
            return new Q0.e(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateRange(long j2, int i2) {
            if (i2 >= 0 && i2 < 1000000000) {
                if (-62135596800L <= j2 && j2 < 253402300800L) {
                    return;
                }
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j2).toString());
            }
            throw new IllegalArgumentException(O.a.c(i2, "Timestamp nanoseconds out of range: ").toString());
        }

        public final Timestamp now() {
            return new Timestamp(new Date());
        }

        private Companion() {
        }
    }

    public Timestamp(long j2, int i2) {
        Companion.validateRange(j2, i2);
        this.seconds = j2;
        this.nanoseconds = i2;
    }

    public static final Timestamp now() {
        return Companion.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof Timestamp) || compareTo((Timestamp) obj) != 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j2 = this.seconds;
        return (((((int) j2) * 1369) + ((int) (j2 >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * 1000) + (this.nanoseconds / 1000000));
    }

    public final Instant toInstant() {
        Instant ofEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        h.d(ofEpochSecond, "ofEpochSecond(...)");
        return ofEpochSecond;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i2) {
        h.e(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp other) {
        int compareTo;
        h.e(other, "other");
        l[] lVarArr = {new kotlin.jvm.internal.l() { // from class: com.google.firebase.Timestamp$compareTo$1
            @Override // kotlin.jvm.internal.l, i1.h
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new kotlin.jvm.internal.l() { // from class: com.google.firebase.Timestamp$compareTo$2
            @Override // kotlin.jvm.internal.l, i1.h
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        }};
        for (int i2 = 0; i2 < 2; i2++) {
            l lVar = lVarArr[i2];
            Comparable comparable = (Comparable) lVar.invoke(this);
            Comparable comparable2 = (Comparable) lVar.invoke(other);
            if (comparable == comparable2) {
                compareTo = 0;
            } else if (comparable == null) {
                compareTo = -1;
            } else {
                compareTo = comparable2 == null ? 1 : comparable.compareTo(comparable2);
            }
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public Timestamp(Date date) {
        h.e(date, "date");
        Companion companion = Companion;
        Q0.e preciseTime = companion.toPreciseTime(date);
        long longValue = ((Number) preciseTime.f714c).longValue();
        int intValue = ((Number) preciseTime.f715d).intValue();
        companion.validateRange(longValue, intValue);
        this.seconds = longValue;
        this.nanoseconds = intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Timestamp(Instant time) {
        this(time.getEpochSecond(), time.getNano());
        h.e(time, "time");
    }
}
