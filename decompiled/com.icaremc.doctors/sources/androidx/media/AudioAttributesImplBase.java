package androidx.media;

import O.a;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f1869a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1870b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1871c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f1872d = -1;

    public final boolean equals(Object obj) {
        int i2;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f1870b == audioAttributesImplBase.f1870b) {
            int i3 = this.f1871c;
            int i4 = audioAttributesImplBase.f1871c;
            int i5 = audioAttributesImplBase.f1872d;
            if (i5 != -1) {
                i2 = i5;
            } else {
                int i6 = audioAttributesImplBase.f1869a;
                int i7 = AudioAttributesCompat.f1865b;
                if ((i4 & 1) == 1) {
                    i2 = 7;
                } else {
                    i2 = 4;
                    if ((i4 & 4) == 4) {
                        i2 = 6;
                    } else {
                        switch (i6) {
                            case 2:
                                i2 = 0;
                                break;
                            case 3:
                                i2 = 8;
                                break;
                            case 4:
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i2 = 5;
                                break;
                            case 6:
                                i2 = 2;
                                break;
                            case 11:
                                i2 = 10;
                                break;
                            case 12:
                            default:
                                i2 = 3;
                                break;
                            case 13:
                                i2 = 1;
                                break;
                        }
                    }
                }
            }
            if (i2 == 6) {
                i4 |= 4;
            } else if (i2 == 7) {
                i4 |= 1;
            }
            if (i3 == (i4 & 273) && this.f1869a == audioAttributesImplBase.f1869a && this.f1872d == i5) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1870b), Integer.valueOf(this.f1871c), Integer.valueOf(this.f1869a), Integer.valueOf(this.f1872d)});
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1872d != -1) {
            sb.append(" stream=");
            sb.append(this.f1872d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i2 = this.f1869a;
        int i3 = AudioAttributesCompat.f1865b;
        switch (i2) {
            case 0:
                str = "USAGE_UNKNOWN";
                break;
            case 1:
                str = "USAGE_MEDIA";
                break;
            case 2:
                str = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                str = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                str = "USAGE_ALARM";
                break;
            case 5:
                str = "USAGE_NOTIFICATION";
                break;
            case 6:
                str = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                str = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                str = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                str = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                str = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                str = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                str = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                str = "USAGE_GAME";
                break;
            case 15:
            default:
                str = a.c(i2, "unknown usage ");
                break;
            case 16:
                str = "USAGE_ASSISTANT";
                break;
        }
        sb.append(str);
        sb.append(" content=");
        sb.append(this.f1870b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1871c).toUpperCase());
        return sb.toString();
    }
}
