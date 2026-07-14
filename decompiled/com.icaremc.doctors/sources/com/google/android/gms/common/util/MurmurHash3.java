package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6 = i2;
        while (true) {
            i5 = (i3 & (-4)) + i2;
            if (i6 >= i5) {
                break;
            }
            int i7 = ((bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | (bArr[i6 + 3] << 24)) * (-862048943);
            int i8 = i4 ^ (((i7 >>> 17) | (i7 << 15)) * 461845907);
            i4 = (((i8 >>> 19) | (i8 << 13)) * 5) - 430675100;
            i6 += 4;
        }
        int i9 = i3 & 3;
        int i10 = 0;
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    i10 = (bArr[i5 + 2] & 255) << 16;
                }
                int i11 = i4 ^ i3;
                int i12 = (i11 ^ (i11 >>> 16)) * (-2048144789);
                int i13 = (i12 ^ (i12 >>> 13)) * (-1028477387);
                return i13 ^ (i13 >>> 16);
            }
            i10 |= (bArr[i5 + 1] & 255) << 8;
        }
        int i14 = ((bArr[i5] & 255) | i10) * (-862048943);
        i4 ^= ((i14 >>> 17) | (i14 << 15)) * 461845907;
        int i112 = i4 ^ i3;
        int i122 = (i112 ^ (i112 >>> 16)) * (-2048144789);
        int i132 = (i122 ^ (i122 >>> 13)) * (-1028477387);
        return i132 ^ (i132 >>> 16);
    }
}
