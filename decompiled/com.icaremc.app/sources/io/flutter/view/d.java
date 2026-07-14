package io.flutter.view;

import android.opengl.Matrix;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import i2.InterfaceC0375j;
import i2.InterfaceC0376k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class d implements InterfaceC0375j, InterfaceC0376k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4423a;

    public /* synthetic */ d(Object obj) {
        this.f4423a = obj;
    }

    public void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        int i4;
        long j4;
        AccessibilityEvent accessibilityEvent;
        i iVar;
        i iVar2;
        int i5;
        int i6;
        i iVar3;
        String str;
        float f4;
        float f5;
        View l3;
        Integer num;
        View l4;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        for (ByteBuffer byteBuffer2 : byteBufferArr) {
            byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        }
        j jVar = (j) this.f4423a;
        HashMap hashMap = jVar.f4515g;
        io.flutter.plugin.platform.l lVar = jVar.f4513e;
        ArrayList arrayList = jVar.f4524q;
        ArrayList arrayList2 = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            i c4 = jVar.c(byteBuffer.getInt());
            ArrayList arrayList3 = c4.f4475U;
            j jVar2 = c4.f4481a;
            c4.f4460E = true;
            c4.f4466K = c4.f4500r;
            c4.f4467L = c4.f4498p;
            c4.f4461F = c4.f4485c;
            c4.f4462G = c4.f4487d;
            c4.f4463H = c4.f4490g;
            c4.f4464I = c4.f4491h;
            c4.f4465J = c4.f4494l;
            c4.f4485c = byteBuffer.getLong();
            c4.f4487d = byteBuffer.getInt();
            c4.f4488e = byteBuffer.getInt();
            c4.f4489f = byteBuffer.getInt();
            c4.f4490g = byteBuffer.getInt();
            c4.f4491h = byteBuffer.getInt();
            c4.f4492i = byteBuffer.getInt();
            c4.f4493j = byteBuffer.getInt();
            c4.k = byteBuffer.getInt();
            byteBuffer.getInt();
            c4.f4494l = byteBuffer.getFloat();
            c4.f4495m = byteBuffer.getFloat();
            c4.f4496n = byteBuffer.getFloat();
            c4.f4497o = j.d(byteBuffer, strArr);
            c4.f4498p = j.d(byteBuffer, strArr);
            c4.f4499q = i.f(byteBuffer, byteBufferArr);
            c4.f4500r = j.d(byteBuffer, strArr);
            c4.f4501s = i.f(byteBuffer, byteBufferArr);
            c4.f4502t = j.d(byteBuffer, strArr);
            c4.f4503u = i.f(byteBuffer, byteBufferArr);
            c4.f4504v = j.d(byteBuffer, strArr);
            c4.f4505w = i.f(byteBuffer, byteBufferArr);
            c4.f4506x = j.d(byteBuffer, strArr);
            c4.f4507y = i.f(byteBuffer, byteBufferArr);
            c4.z = j.d(byteBuffer, strArr);
            c4.f4456A = j.d(byteBuffer, strArr);
            c4.f4457B = j.d(byteBuffer, strArr);
            c4.f4458C = byteBuffer.getInt();
            byteBuffer.getInt();
            c4.f4468M = byteBuffer.getFloat();
            c4.f4469N = byteBuffer.getFloat();
            c4.f4470O = byteBuffer.getFloat();
            c4.P = byteBuffer.getFloat();
            float[] fArr = c4.f4471Q;
            if (fArr == null) {
                fArr = new float[16];
            }
            for (int i7 = 0; i7 < 16; i7++) {
                fArr[i7] = byteBuffer.getFloat();
            }
            c4.f4471Q = fArr;
            float[] fArr2 = c4.f4472R;
            if (fArr2 == null) {
                fArr2 = new float[16];
            }
            for (int i8 = 0; i8 < 16; i8++) {
                fArr2[i8] = byteBuffer.getFloat();
            }
            c4.f4472R = fArr2;
            c4.f4479Y = true;
            c4.f4482a0 = true;
            int i9 = byteBuffer.getInt();
            ArrayList arrayList4 = c4.f4474T;
            arrayList4.clear();
            for (int i10 = 0; i10 < i9; i10++) {
                i c5 = jVar2.c(byteBuffer.getInt());
                c5.f4473S = c4;
                arrayList4.add(c5);
            }
            int i11 = byteBuffer.getInt();
            arrayList3.clear();
            for (int i12 = 0; i12 < i11; i12++) {
                i c6 = jVar2.c(byteBuffer.getInt());
                c6.f4473S = c4;
                arrayList3.add(c6);
            }
            int i13 = byteBuffer.getInt();
            if (i13 == 0) {
                c4.f4476V = null;
            } else {
                ArrayList arrayList5 = c4.f4476V;
                if (arrayList5 == null) {
                    c4.f4476V = new ArrayList(i13);
                } else {
                    arrayList5.clear();
                }
                for (int i14 = 0; i14 < i13; i14++) {
                    h b4 = jVar2.b(byteBuffer.getInt());
                    int i15 = b4.f4453c;
                    if (i15 == 1) {
                        c4.f4477W = b4;
                    } else if (i15 == 2) {
                        c4.f4478X = b4;
                    } else {
                        c4.f4476V.add(b4);
                    }
                    c4.f4476V.add(b4);
                }
            }
            if (!c4.g(14)) {
                if (c4.g(6)) {
                    jVar.f4521n = c4;
                }
                if (c4.f4460E) {
                    arrayList2.add(c4);
                }
                int i16 = c4.f4492i;
                if (i16 != -1 && !lVar.g(i16) && (l4 = lVar.l(c4.f4492i)) != null) {
                    l4.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        i iVar4 = (i) hashMap.get(0);
        ArrayList arrayList6 = new ArrayList();
        if (iVar4 != null) {
            float[] fArr3 = new float[16];
            Matrix.setIdentityM(fArr3, 0);
            iVar4.k(fArr3, hashSet, false);
            iVar4.c(arrayList6);
        }
        int size = arrayList6.size();
        i iVar5 = null;
        int i17 = 0;
        while (i17 < size) {
            Object obj = arrayList6.get(i17);
            i17++;
            i iVar6 = (i) obj;
            if (!arrayList.contains(Integer.valueOf(iVar6.f4483b))) {
                iVar5 = iVar6;
            }
        }
        if (iVar5 == null && !arrayList6.isEmpty()) {
            iVar5 = (i) arrayList6.get(arrayList6.size() - 1);
        }
        if (iVar5 != null && (iVar5.f4483b != jVar.f4525r || arrayList6.size() != arrayList.size())) {
            jVar.f4525r = iVar5.f4483b;
            String e4 = iVar5.e();
            if (e4 == null) {
                e4 = " ";
            }
            if (Build.VERSION.SDK_INT >= 28) {
                jVar.f4509a.setAccessibilityPaneTitle(e4);
            } else {
                AccessibilityEvent e5 = jVar.e(iVar5.f4483b, 32);
                e5.getText().add(e4);
                jVar.i(e5);
            }
        }
        arrayList.clear();
        int size2 = arrayList6.size();
        int i18 = 0;
        while (i18 < size2) {
            Object obj2 = arrayList6.get(i18);
            i18++;
            arrayList.add(Integer.valueOf(((i) obj2).f4483b));
        }
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            i iVar7 = (i) ((Map.Entry) it.next()).getValue();
            if (!hashSet.contains(iVar7)) {
                iVar7.f4473S = null;
                if (iVar7.f4492i != -1 && (num = jVar.f4518j) != null && jVar.f4512d.platformViewOfNode(num.intValue()) == lVar.l(iVar7.f4492i)) {
                    jVar.h(jVar.f4518j.intValue(), 65536);
                    jVar.f4518j = null;
                }
                int i19 = iVar7.f4492i;
                if (i19 != -1 && (l3 = lVar.l(i19)) != null) {
                    l3.setImportantForAccessibility(4);
                }
                i iVar8 = jVar.f4517i;
                if (iVar8 == iVar7) {
                    jVar.h(iVar8.f4483b, 65536);
                    jVar.f4517i = null;
                }
                if (jVar.f4521n == iVar7) {
                    jVar.f4521n = null;
                }
                if (jVar.f4523p == iVar7) {
                    jVar.f4523p = null;
                }
                it.remove();
            }
        }
        int i20 = 2048;
        int i21 = 0;
        AccessibilityEvent e6 = jVar.e(0, 2048);
        e6.setContentChangeTypes(1);
        jVar.i(e6);
        int size3 = arrayList2.size();
        int i22 = 0;
        while (i22 < size3) {
            Object obj3 = arrayList2.get(i22);
            i22++;
            i iVar9 = (i) obj3;
            if (!Float.isNaN(iVar9.f4494l) && !Float.isNaN(iVar9.f4465J) && iVar9.f4465J != iVar9.f4494l) {
                AccessibilityEvent e7 = jVar.e(iVar9.f4483b, 4096);
                float f6 = iVar9.f4494l;
                float f7 = iVar9.f4495m;
                if (Float.isInfinite(f7)) {
                    if (f6 > 70000.0f) {
                        f6 = 70000.0f;
                    }
                    f7 = 100000.0f;
                }
                if (Float.isInfinite(iVar9.f4496n)) {
                    f4 = f7 + 100000.0f;
                    if (f6 < -70000.0f) {
                        f6 = -70000.0f;
                    }
                    f5 = f6 + 100000.0f;
                } else {
                    float f8 = iVar9.f4496n;
                    f4 = f7 - f8;
                    f5 = f6 - f8;
                }
                int i23 = iVar9.f4462G;
                if ((i23 & 16) != 0 || (i23 & 32) != 0) {
                    e7.setScrollY((int) f5);
                    e7.setMaxScrollY((int) f4);
                } else if ((i23 & 4) != 0 || (i23 & 8) != 0) {
                    e7.setScrollX((int) f5);
                    e7.setMaxScrollX((int) f4);
                }
                int i24 = iVar9.f4493j;
                if (i24 > 0) {
                    e7.setItemCount(i24);
                    e7.setFromIndex(iVar9.k);
                    ArrayList arrayList7 = iVar9.f4475U;
                    int size4 = arrayList7.size();
                    int i25 = i21;
                    int i26 = i25;
                    while (i26 < size4) {
                        Object obj4 = arrayList7.get(i26);
                        i26++;
                        if (!((i) obj4).g(14)) {
                            i25++;
                        }
                    }
                    e7.setToIndex((iVar9.k + i25) - 1);
                }
                jVar.i(e7);
            }
            if (iVar9.g(16) && (((str = iVar9.f4498p) != null || iVar9.f4467L != null) && (str == null || !str.equals(iVar9.f4467L)))) {
                AccessibilityEvent e8 = jVar.e(iVar9.f4483b, i20);
                e8.setContentChangeTypes(1);
                jVar.i(e8);
            }
            i iVar10 = jVar.f4517i;
            if (iVar10 != null && iVar10.f4483b == iVar9.f4483b) {
                i4 = size3;
                j4 = 0;
                if ((iVar9.f4461F & A2.i.e(3)) == 0 && iVar9.g(3)) {
                    AccessibilityEvent e9 = jVar.e(iVar9.f4483b, 4);
                    e9.getText().add(iVar9.f4498p);
                    jVar.i(e9);
                }
            } else {
                i4 = size3;
                j4 = 0;
            }
            i iVar11 = jVar.f4521n;
            if (iVar11 != null && (i5 = iVar11.f4483b) == (i6 = iVar9.f4483b) && ((iVar3 = jVar.f4522o) == null || iVar3.f4483b != i5)) {
                jVar.f4522o = iVar11;
                jVar.i(jVar.e(i6, 8));
            } else if (iVar11 == null) {
                accessibilityEvent = null;
                jVar.f4522o = null;
                iVar = jVar.f4521n;
                if (iVar == null && iVar.f4483b == iVar9.f4483b && (iVar9.f4461F & A2.i.e(5)) != j4 && iVar9.g(5) && ((iVar2 = jVar.f4517i) == null || iVar2.f4483b == jVar.f4521n.f4483b)) {
                    String str2 = iVar9.f4466K;
                    String str3 = "";
                    if (str2 == null) {
                        str2 = "";
                    }
                    String str4 = iVar9.f4500r;
                    if (str4 != null) {
                        str3 = str4;
                    }
                    AccessibilityEvent e10 = jVar.e(iVar9.f4483b, 16);
                    e10.setBeforeText(str2);
                    e10.getText().add(str3);
                    int i27 = 0;
                    while (i27 < str2.length() && i27 < str3.length() && str2.charAt(i27) == str3.charAt(i27)) {
                        i27++;
                    }
                    if (i27 >= str2.length() && i27 >= str3.length()) {
                        e10 = accessibilityEvent;
                    } else {
                        e10.setFromIndex(i27);
                        int length = str2.length() - 1;
                        int length2 = str3.length() - 1;
                        while (length >= i27 && length2 >= i27 && str2.charAt(length) == str3.charAt(length2)) {
                            length--;
                            length2--;
                        }
                        e10.setRemovedCount((length - i27) + 1);
                        e10.setAddedCount((length2 - i27) + 1);
                    }
                    if (e10 != null) {
                        jVar.i(e10);
                    }
                    if (iVar9.f4463H != iVar9.f4490g || iVar9.f4464I != iVar9.f4491h) {
                        AccessibilityEvent e11 = jVar.e(iVar9.f4483b, 8192);
                        e11.getText().add(str3);
                        e11.setFromIndex(iVar9.f4490g);
                        e11.setToIndex(iVar9.f4491h);
                        e11.setItemCount(str3.length());
                        jVar.i(e11);
                    }
                }
                size3 = i4;
                i20 = 2048;
                i21 = 0;
            }
            accessibilityEvent = null;
            iVar = jVar.f4521n;
            if (iVar == null) {
            }
            size3 = i4;
            i20 = 2048;
            i21 = 0;
        }
    }
}
