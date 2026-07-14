package io.flutter.view;

import android.graphics.Rect;
import android.opengl.Matrix;
import android.text.SpannableString;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: A, reason: collision with root package name */
    public String f4456A;

    /* renamed from: B, reason: collision with root package name */
    public String f4457B;

    /* renamed from: C, reason: collision with root package name */
    public int f4458C;

    /* renamed from: F, reason: collision with root package name */
    public long f4461F;

    /* renamed from: G, reason: collision with root package name */
    public int f4462G;

    /* renamed from: H, reason: collision with root package name */
    public int f4463H;

    /* renamed from: I, reason: collision with root package name */
    public int f4464I;

    /* renamed from: J, reason: collision with root package name */
    public float f4465J;

    /* renamed from: K, reason: collision with root package name */
    public String f4466K;

    /* renamed from: L, reason: collision with root package name */
    public String f4467L;

    /* renamed from: M, reason: collision with root package name */
    public float f4468M;

    /* renamed from: N, reason: collision with root package name */
    public float f4469N;

    /* renamed from: O, reason: collision with root package name */
    public float f4470O;
    public float P;

    /* renamed from: Q, reason: collision with root package name */
    public float[] f4471Q;

    /* renamed from: R, reason: collision with root package name */
    public float[] f4472R;

    /* renamed from: S, reason: collision with root package name */
    public i f4473S;

    /* renamed from: V, reason: collision with root package name */
    public ArrayList f4476V;

    /* renamed from: W, reason: collision with root package name */
    public h f4477W;

    /* renamed from: X, reason: collision with root package name */
    public h f4478X;

    /* renamed from: Z, reason: collision with root package name */
    public float[] f4480Z;

    /* renamed from: a, reason: collision with root package name */
    public final j f4481a;

    /* renamed from: b0, reason: collision with root package name */
    public float[] f4484b0;

    /* renamed from: c, reason: collision with root package name */
    public long f4485c;

    /* renamed from: c0, reason: collision with root package name */
    public Rect f4486c0;

    /* renamed from: d, reason: collision with root package name */
    public int f4487d;

    /* renamed from: e, reason: collision with root package name */
    public int f4488e;

    /* renamed from: f, reason: collision with root package name */
    public int f4489f;

    /* renamed from: g, reason: collision with root package name */
    public int f4490g;

    /* renamed from: h, reason: collision with root package name */
    public int f4491h;

    /* renamed from: i, reason: collision with root package name */
    public int f4492i;

    /* renamed from: j, reason: collision with root package name */
    public int f4493j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public float f4494l;

    /* renamed from: m, reason: collision with root package name */
    public float f4495m;

    /* renamed from: n, reason: collision with root package name */
    public float f4496n;

    /* renamed from: o, reason: collision with root package name */
    public String f4497o;

    /* renamed from: p, reason: collision with root package name */
    public String f4498p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f4499q;

    /* renamed from: r, reason: collision with root package name */
    public String f4500r;

    /* renamed from: s, reason: collision with root package name */
    public List f4501s;

    /* renamed from: t, reason: collision with root package name */
    public String f4502t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f4503u;

    /* renamed from: v, reason: collision with root package name */
    public String f4504v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList f4505w;

    /* renamed from: x, reason: collision with root package name */
    public String f4506x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f4507y;
    public String z;

    /* renamed from: b, reason: collision with root package name */
    public int f4483b = -1;

    /* renamed from: D, reason: collision with root package name */
    public int f4459D = -1;

    /* renamed from: E, reason: collision with root package name */
    public boolean f4460E = false;

    /* renamed from: T, reason: collision with root package name */
    public final ArrayList f4474T = new ArrayList();

    /* renamed from: U, reason: collision with root package name */
    public final ArrayList f4475U = new ArrayList();

    /* renamed from: Y, reason: collision with root package name */
    public boolean f4479Y = true;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f4482a0 = true;

    public i(j jVar) {
        this.f4481a = jVar;
    }

    public static boolean a(i iVar, g gVar) {
        if ((iVar.f4487d & gVar.f4450f) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [P1.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [P1.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [P1.y, java.lang.Object] */
    public static CharSequence b(i iVar) {
        ?? obj = new Object();
        obj.f1469f = iVar.f4500r;
        obj.f1470g = iVar.f4501s;
        obj.f1471h = iVar.d();
        SpannableString c4 = obj.c();
        ?? obj2 = new Object();
        obj2.f1469f = iVar.f4498p;
        obj2.f1470g = iVar.f4499q;
        obj2.f1472i = iVar.f4456A;
        obj2.f1471h = iVar.d();
        SpannableString c5 = obj2.c();
        ?? obj3 = new Object();
        obj3.f1469f = iVar.f4506x;
        obj3.f1470g = iVar.f4507y;
        obj3.f1471h = iVar.d();
        CharSequence[] charSequenceArr = {c4, c5, obj3.c()};
        CharSequence charSequence = null;
        for (int i4 = 0; i4 < 3; i4++) {
            CharSequence charSequence2 = charSequenceArr[i4];
            if (charSequence2 != null && charSequence2.length() > 0) {
                if (charSequence != null && charSequence.length() != 0) {
                    charSequence = TextUtils.concat(charSequence, ", ", charSequence2);
                } else {
                    charSequence = charSequence2;
                }
            }
        }
        return charSequence;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [io.flutter.view.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.flutter.view.k, io.flutter.view.m, java.lang.Object] */
    public static ArrayList f(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        int i4 = byteBuffer.getInt();
        if (i4 == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = byteBuffer.getInt();
            int i7 = byteBuffer.getInt();
            int i8 = R.i.c(2)[byteBuffer.getInt()];
            int b4 = R.i.b(i8);
            if (b4 != 0) {
                if (b4 == 1) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    ?? obj = new Object();
                    obj.f4533a = i6;
                    obj.f4534b = i7;
                    obj.f4535c = i8;
                    obj.f4532d = StandardCharsets.UTF_8.decode(byteBuffer2).toString();
                    arrayList.add(obj);
                }
            } else {
                byteBuffer.getInt();
                ?? obj2 = new Object();
                obj2.f4533a = i6;
                obj2.f4534b = i7;
                obj2.f4535c = i8;
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static void j(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
        float f4 = fArr[3];
        fArr[0] = fArr[0] / f4;
        fArr[1] = fArr[1] / f4;
        fArr[2] = fArr[2] / f4;
        fArr[3] = 0.0f;
    }

    public final void c(ArrayList arrayList) {
        if (g(12)) {
            arrayList.add(this);
        }
        ArrayList arrayList2 = this.f4474T;
        int size = arrayList2.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList2.get(i4);
            i4++;
            ((i) obj).c(arrayList);
        }
    }

    public final String d() {
        String str = this.f4457B;
        if (str != null && !str.isEmpty()) {
            return this.f4457B;
        }
        return this.f4481a.f4520m;
    }

    public final String e() {
        String str;
        if (g(13) && (str = this.f4498p) != null && !str.isEmpty()) {
            return this.f4498p;
        }
        ArrayList arrayList = this.f4474T;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            String e4 = ((i) obj).e();
            if (e4 != null && !e4.isEmpty()) {
                return e4;
            }
        }
        return null;
    }

    public final boolean g(int i4) {
        if ((this.f4485c & A2.i.e(i4)) != 0) {
            return true;
        }
        return false;
    }

    public final i h(float[] fArr, boolean z) {
        float f4 = fArr[3];
        boolean z3 = false;
        float f5 = fArr[0] / f4;
        float f6 = fArr[1] / f4;
        if (f5 >= this.f4468M && f5 < this.f4470O && f6 >= this.f4469N && f6 < this.P) {
            float[] fArr2 = new float[4];
            ArrayList arrayList = this.f4475U;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                i iVar = (i) arrayList.get(i4);
                if (!iVar.g(14)) {
                    if (iVar.f4479Y) {
                        iVar.f4479Y = false;
                        if (iVar.f4480Z == null) {
                            iVar.f4480Z = new float[16];
                        }
                        if (!Matrix.invertM(iVar.f4480Z, 0, iVar.f4472R, 0)) {
                            Arrays.fill(iVar.f4480Z, 0.0f);
                        }
                    }
                    float[] fArr3 = fArr;
                    Matrix.multiplyMV(fArr2, 0, iVar.f4480Z, 0, fArr3, 0);
                    i h3 = iVar.h(fArr2, z);
                    if (h3 != null) {
                        return h3;
                    }
                    fArr = fArr3;
                }
                i4 = i5;
            }
            if (z && this.f4492i != -1) {
                z3 = true;
            }
            if (i() || z3) {
                return this;
            }
            return null;
        }
        return null;
    }

    public final boolean i() {
        if (!g(12)) {
            if (!g(22)) {
                if (!g(32)) {
                    int i4 = this.f4487d;
                    int i5 = j.f4508y;
                    if ((i4 & (-61)) == 0 && (this.f4485c & 10682871) == 0) {
                        String str = this.f4498p;
                        if (str == null || str.isEmpty()) {
                            String str2 = this.f4500r;
                            if (str2 == null || str2.isEmpty()) {
                                String str3 = this.f4506x;
                                if (str3 == null || str3.isEmpty()) {
                                    return false;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public final void k(float[] fArr, HashSet hashSet, boolean z) {
        hashSet.add(this);
        if (this.f4482a0) {
            z = true;
        }
        int i4 = 0;
        if (z) {
            if (this.f4484b0 == null) {
                this.f4484b0 = new float[16];
            }
            if (this.f4471Q == null) {
                this.f4471Q = new float[16];
            }
            Matrix.multiplyMM(this.f4484b0, 0, fArr, 0, this.f4471Q, 0);
            float[] fArr2 = {this.f4468M, this.f4469N, 0.0f, 1.0f};
            float[] fArr3 = new float[4];
            float[] fArr4 = new float[4];
            float[] fArr5 = new float[4];
            float[] fArr6 = new float[4];
            j(fArr3, this.f4484b0, fArr2);
            fArr2[0] = this.f4470O;
            fArr2[1] = this.f4469N;
            j(fArr4, this.f4484b0, fArr2);
            fArr2[0] = this.f4470O;
            fArr2[1] = this.P;
            j(fArr5, this.f4484b0, fArr2);
            fArr2[0] = this.f4468M;
            fArr2[1] = this.P;
            j(fArr6, this.f4484b0, fArr2);
            if (this.f4486c0 == null) {
                this.f4486c0 = new Rect();
            }
            this.f4486c0.set(Math.round(Math.min(fArr3[0], Math.min(fArr4[0], Math.min(fArr5[0], fArr6[0])))), Math.round(Math.min(fArr3[1], Math.min(fArr4[1], Math.min(fArr5[1], fArr6[1])))), Math.round(Math.max(fArr3[0], Math.max(fArr4[0], Math.max(fArr5[0], fArr6[0])))), Math.round(Math.max(fArr3[1], Math.max(fArr4[1], Math.max(fArr5[1], fArr6[1])))));
            this.f4482a0 = false;
        }
        ArrayList arrayList = this.f4474T;
        int size = arrayList.size();
        int i5 = -1;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            i iVar = (i) obj;
            iVar.f4459D = i5;
            i5 = iVar.f4483b;
            iVar.k(this.f4484b0, hashSet, z);
        }
    }
}
