package x2;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import s2.C0649u;
import s2.C0650v;

/* loaded from: classes.dex */
public final class m extends C0650v {

    /* renamed from: d, reason: collision with root package name */
    public static final m f6533d = new Object();

    /* JADX WARN: Type inference failed for: r7v1, types: [x2.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [x2.g, java.lang.Object] */
    @Override // s2.C0650v
    public final Object f(byte b4, ByteBuffer byteBuffer) {
        if (b4 != -127) {
            if (b4 != -126) {
                return super.f(b4, byteBuffer);
            }
            ArrayList arrayList = (ArrayList) e(byteBuffer);
            ?? obj = new Object();
            String str = (String) arrayList.get(0);
            if (str != null) {
                obj.f6522a = str;
                f fVar = (f) arrayList.get(1);
                if (fVar != null) {
                    obj.f6523b = fVar;
                    obj.f6524c = (Boolean) arrayList.get(2);
                    Map map = (Map) arrayList.get(3);
                    if (map != null) {
                        obj.f6525d = map;
                        return obj;
                    }
                    throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
                }
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            throw new IllegalStateException("Nonnull field \"name\" is null.");
        }
        ArrayList arrayList2 = (ArrayList) e(byteBuffer);
        ?? obj2 = new Object();
        String str2 = (String) arrayList2.get(0);
        if (str2 != null) {
            obj2.f6509a = str2;
            String str3 = (String) arrayList2.get(1);
            if (str3 != null) {
                obj2.f6510b = str3;
                String str4 = (String) arrayList2.get(2);
                if (str4 != null) {
                    obj2.f6511c = str4;
                    String str5 = (String) arrayList2.get(3);
                    if (str5 != null) {
                        obj2.f6512d = str5;
                        obj2.f6513e = (String) arrayList2.get(4);
                        obj2.f6514f = (String) arrayList2.get(5);
                        obj2.f6515g = (String) arrayList2.get(6);
                        obj2.f6516h = (String) arrayList2.get(7);
                        obj2.f6517i = (String) arrayList2.get(8);
                        obj2.f6518j = (String) arrayList2.get(9);
                        obj2.k = (String) arrayList2.get(10);
                        obj2.f6519l = (String) arrayList2.get(11);
                        obj2.f6520m = (String) arrayList2.get(12);
                        obj2.f6521n = (String) arrayList2.get(13);
                        return obj2;
                    }
                    throw new IllegalStateException("Nonnull field \"projectId\" is null.");
                }
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            throw new IllegalStateException("Nonnull field \"appId\" is null.");
        }
        throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
    }

    @Override // s2.C0650v
    public final void k(C0649u c0649u, Object obj) {
        if (obj instanceof f) {
            c0649u.write(129);
            f fVar = (f) obj;
            fVar.getClass();
            ArrayList arrayList = new ArrayList(14);
            arrayList.add(fVar.f6509a);
            arrayList.add(fVar.f6510b);
            arrayList.add(fVar.f6511c);
            arrayList.add(fVar.f6512d);
            arrayList.add(fVar.f6513e);
            arrayList.add(fVar.f6514f);
            arrayList.add(fVar.f6515g);
            arrayList.add(fVar.f6516h);
            arrayList.add(fVar.f6517i);
            arrayList.add(fVar.f6518j);
            arrayList.add(fVar.k);
            arrayList.add(fVar.f6519l);
            arrayList.add(fVar.f6520m);
            arrayList.add(fVar.f6521n);
            k(c0649u, arrayList);
            return;
        }
        if (obj instanceof g) {
            c0649u.write(130);
            g gVar = (g) obj;
            gVar.getClass();
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(gVar.f6522a);
            arrayList2.add(gVar.f6523b);
            arrayList2.add(gVar.f6524c);
            arrayList2.add(gVar.f6525d);
            k(c0649u, arrayList2);
            return;
        }
        super.k(c0649u, obj);
    }
}
