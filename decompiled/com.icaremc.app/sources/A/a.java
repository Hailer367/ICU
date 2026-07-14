package A;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f0a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3d;

    /* renamed from: e, reason: collision with root package name */
    public final float f4e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5f;

    public a(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f0a = f4;
        this.f1b = f5;
        this.f2c = f6;
        this.f3d = f7;
        this.f4e = f8;
        this.f5f = f9;
    }

    public static a a(int i4) {
        float f4;
        n nVar = n.k;
        float c4 = b.c(Color.red(i4));
        float c5 = b.c(Color.green(i4));
        float c6 = b.c(Color.blue(i4));
        float[][] fArr = b.f9d;
        float[] fArr2 = fArr[0];
        float f5 = (fArr2[2] * c6) + (fArr2[1] * c5) + (fArr2[0] * c4);
        float[] fArr3 = fArr[1];
        float f6 = (fArr3[2] * c6) + (fArr3[1] * c5) + (fArr3[0] * c4);
        float[] fArr4 = fArr[2];
        float f7 = (c6 * fArr4[2]) + (c5 * fArr4[1]) + (c4 * fArr4[0]);
        float[][] fArr5 = b.f6a;
        float[] fArr6 = fArr5[0];
        float f8 = (fArr6[2] * f7) + (fArr6[1] * f6) + (fArr6[0] * f5);
        float[] fArr7 = fArr5[1];
        float f9 = (fArr7[2] * f7) + (fArr7[1] * f6) + (fArr7[0] * f5);
        float[] fArr8 = fArr5[2];
        float f10 = (f7 * fArr8[2]) + (f6 * fArr8[1]) + (f5 * fArr8[0]);
        float[] fArr9 = nVar.f44g;
        float f11 = nVar.f46i;
        float f12 = nVar.f41d;
        float f13 = nVar.f38a;
        float f14 = fArr9[0] * f8;
        float f15 = fArr9[1] * f9;
        float f16 = fArr9[2] * f10;
        float f17 = nVar.f45h;
        float pow = (float) Math.pow((Math.abs(f14) * f17) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((Math.abs(f15) * f17) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f16) * f17) / 100.0d, 0.42d);
        float signum = ((Math.signum(f14) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f15) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f16) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d4 = signum3;
        float f18 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d4)) / 11.0f;
        float f19 = ((float) ((signum + signum2) - (d4 * 2.0d))) / 9.0f;
        float f20 = signum2 * 20.0f;
        float f21 = ((21.0f * signum3) + ((signum * 20.0f) + f20)) / 20.0f;
        float f22 = (((signum * 40.0f) + f20) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f19, f18)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f23 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f22 * nVar.f39b) / f13, nVar.f47j * f12)) * 100.0f;
        Math.sqrt(pow4 / 100.0f);
        float f24 = f13 + 4.0f;
        if (atan2 < 20.14d) {
            f4 = 360.0f + atan2;
        } else {
            f4 = atan2;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, nVar.f43f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f4 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * nVar.f42e) * nVar.f40c) * ((float) Math.sqrt((f19 * f19) + (f18 * f18)))) / (f21 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow4 / 100.0d));
        Math.sqrt((r0 * f12) / f24);
        float f25 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((f11 * pow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d5 = f23;
        return new a(atan2, pow5, pow4, f25, log * ((float) Math.cos(d5)), log * ((float) Math.sin(d5)));
    }

    public static a b(float f4, float f5, float f6) {
        n nVar = n.k;
        float f7 = nVar.f41d;
        Math.sqrt(f4 / 100.0d);
        float f8 = nVar.f38a + 4.0f;
        float f9 = nVar.f46i * f5;
        Math.sqrt(((f5 / ((float) Math.sqrt(r1))) * nVar.f41d) / f8);
        float f10 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float log = ((float) Math.log((f9 * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (3.1415927f * f6) / 180.0f;
        return new a(f6, f5, f4, f10, log * ((float) Math.cos(d4)), log * ((float) Math.sin(d4)));
    }

    public final int c(n nVar) {
        float f4;
        float f5 = this.f1b;
        double d4 = f5;
        float f6 = this.f2c;
        if (d4 != 0.0d) {
            double d5 = f6;
            if (d5 != 0.0d) {
                f4 = f5 / ((float) Math.sqrt(d5 / 100.0d));
                float f7 = nVar.f43f;
                float f8 = nVar.f45h;
                float pow = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, f7), 0.73d), 1.1111111111111112d);
                double d6 = (this.f0a * 3.1415927f) / 180.0f;
                float cos = ((float) (Math.cos(2.0d + d6) + 3.8d)) * 0.25f;
                float pow2 = nVar.f38a * ((float) Math.pow(f6 / 100.0d, (1.0d / nVar.f41d) / nVar.f47j));
                float f9 = cos * 3846.1538f * nVar.f42e * nVar.f40c;
                float f10 = pow2 / nVar.f39b;
                float sin = (float) Math.sin(d6);
                float cos2 = (float) Math.cos(d6);
                float f11 = (((0.305f + f10) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (f9 * 23.0f)));
                float f12 = cos2 * f11;
                float f13 = f11 * sin;
                float f14 = f10 * 460.0f;
                float f15 = ((288.0f * f13) + ((451.0f * f12) + f14)) / 1403.0f;
                float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
                float f17 = ((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f;
                float f18 = 100.0f / f8;
                float signum = Math.signum(f15) * f18 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
                float signum2 = Math.signum(f16) * f18 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f16) * 27.13d) / (400.0d - Math.abs(f16))), 2.380952380952381d));
                float signum3 = Math.signum(f17) * f18 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f17) * 27.13d) / (400.0d - Math.abs(f17))), 2.380952380952381d));
                float[] fArr = nVar.f44g;
                float f19 = signum / fArr[0];
                float f20 = signum2 / fArr[1];
                float f21 = signum3 / fArr[2];
                float[][] fArr2 = b.f7b;
                float[] fArr3 = fArr2[0];
                float f22 = (fArr3[2] * f21) + (fArr3[1] * f20) + (fArr3[0] * f19);
                float[] fArr4 = fArr2[1];
                float f23 = (fArr4[2] * f21) + (fArr4[1] * f20) + (fArr4[0] * f19);
                float[] fArr5 = fArr2[2];
                return B.a.a(f22, f23, (f21 * fArr5[2]) + (f20 * fArr5[1]) + (f19 * fArr5[0]));
            }
        }
        f4 = 0.0f;
        float f72 = nVar.f43f;
        float f82 = nVar.f45h;
        float pow3 = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, f72), 0.73d), 1.1111111111111112d);
        double d62 = (this.f0a * 3.1415927f) / 180.0f;
        float cos3 = ((float) (Math.cos(2.0d + d62) + 3.8d)) * 0.25f;
        float pow22 = nVar.f38a * ((float) Math.pow(f6 / 100.0d, (1.0d / nVar.f41d) / nVar.f47j));
        float f92 = cos3 * 3846.1538f * nVar.f42e * nVar.f40c;
        float f102 = pow22 / nVar.f39b;
        float sin2 = (float) Math.sin(d62);
        float cos22 = (float) Math.cos(d62);
        float f112 = (((0.305f + f102) * 23.0f) * pow3) / (((pow3 * 108.0f) * sin2) + (((11.0f * pow3) * cos22) + (f92 * 23.0f)));
        float f122 = cos22 * f112;
        float f132 = f112 * sin2;
        float f142 = f102 * 460.0f;
        float f152 = ((288.0f * f132) + ((451.0f * f122) + f142)) / 1403.0f;
        float f162 = ((f142 - (891.0f * f122)) - (261.0f * f132)) / 1403.0f;
        float f172 = ((f142 - (f122 * 220.0f)) - (f132 * 6300.0f)) / 1403.0f;
        float f182 = 100.0f / f82;
        float signum4 = Math.signum(f152) * f182 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f152) * 27.13d) / (400.0d - Math.abs(f152))), 2.380952380952381d));
        float signum22 = Math.signum(f162) * f182 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f162) * 27.13d) / (400.0d - Math.abs(f162))), 2.380952380952381d));
        float signum32 = Math.signum(f172) * f182 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f172) * 27.13d) / (400.0d - Math.abs(f172))), 2.380952380952381d));
        float[] fArr6 = nVar.f44g;
        float f192 = signum4 / fArr6[0];
        float f202 = signum22 / fArr6[1];
        float f212 = signum32 / fArr6[2];
        float[][] fArr22 = b.f7b;
        float[] fArr32 = fArr22[0];
        float f222 = (fArr32[2] * f212) + (fArr32[1] * f202) + (fArr32[0] * f192);
        float[] fArr42 = fArr22[1];
        float f232 = (fArr42[2] * f212) + (fArr42[1] * f202) + (fArr42[0] * f192);
        float[] fArr52 = fArr22[2];
        return B.a.a(f222, f232, (f212 * fArr52[2]) + (f202 * fArr52[1]) + (f192 * fArr52[0]));
    }
}
