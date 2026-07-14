package androidx.media;

import A2.i;
import R.j;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f3051a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3052b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f3053c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f3054d = -1;

    public final boolean equals(Object obj) {
        int i4;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f3052b == audioAttributesImplBase.f3052b) {
            int i5 = this.f3053c;
            int i6 = audioAttributesImplBase.f3053c;
            int i7 = audioAttributesImplBase.f3054d;
            if (i7 != -1) {
                i4 = i7;
            } else {
                int i8 = audioAttributesImplBase.f3051a;
                int i9 = AudioAttributesCompat.f3047b;
                if ((i6 & 1) == 1) {
                    i4 = 7;
                } else {
                    i4 = 4;
                    if ((i6 & 4) == 4) {
                        i4 = 6;
                    } else {
                        switch (i8) {
                            case 2:
                                i4 = 0;
                                break;
                            case 3:
                                i4 = 8;
                                break;
                            case 4:
                                break;
                            case 5:
                            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                            case j.BYTES_FIELD_NUMBER /* 8 */:
                            case 9:
                            case 10:
                                i4 = 5;
                                break;
                            case 6:
                                i4 = 2;
                                break;
                            case 11:
                                i4 = 10;
                                break;
                            case 12:
                            default:
                                i4 = 3;
                                break;
                            case 13:
                                i4 = 1;
                                break;
                        }
                    }
                }
            }
            if (i4 == 6) {
                i6 |= 4;
            } else if (i4 == 7) {
                i6 |= 1;
            }
            if (i5 == (i6 & 273) && this.f3051a == audioAttributesImplBase.f3051a && this.f3054d == i7) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3052b), Integer.valueOf(this.f3053c), Integer.valueOf(this.f3051a), Integer.valueOf(this.f3054d)});
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3054d != -1) {
            sb.append(" stream=");
            sb.append(this.f3054d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i4 = this.f3051a;
        int i5 = AudioAttributesCompat.f3047b;
        switch (i4) {
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
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case j.BYTES_FIELD_NUMBER /* 8 */:
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
                str = i.g(i4, "unknown usage ");
                break;
            case 16:
                str = "USAGE_ASSISTANT";
                break;
        }
        sb.append(str);
        sb.append(" content=");
        sb.append(this.f3052b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3053c).toUpperCase());
        return sb.toString();
    }
}
