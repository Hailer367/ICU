package f;

import g.AbstractC0199b;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: f.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0192h extends AbstractC0187c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2261a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0193i f2262b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2263c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0199b f2264d;

    public /* synthetic */ C0192h(AbstractC0193i abstractC0193i, String str, AbstractC0199b abstractC0199b, int i2) {
        this.f2261a = i2;
        this.f2262b = abstractC0193i;
        this.f2263c = str;
        this.f2264d = abstractC0199b;
    }

    @Override // f.AbstractC0187c
    public final void a(Object obj) {
        switch (this.f2261a) {
            case 0:
                AbstractC0193i abstractC0193i = this.f2262b;
                ArrayList arrayList = abstractC0193i.f2268d;
                LinkedHashMap linkedHashMap = abstractC0193i.f2266b;
                String str = this.f2263c;
                Object obj2 = linkedHashMap.get(str);
                AbstractC0199b abstractC0199b = this.f2264d;
                if (obj2 != null) {
                    int intValue = ((Number) obj2).intValue();
                    arrayList.add(str);
                    try {
                        abstractC0193i.b(intValue, abstractC0199b, obj);
                        return;
                    } catch (Exception e2) {
                        arrayList.remove(str);
                        throw e2;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0199b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            default:
                AbstractC0193i abstractC0193i2 = this.f2262b;
                ArrayList arrayList2 = abstractC0193i2.f2268d;
                LinkedHashMap linkedHashMap2 = abstractC0193i2.f2266b;
                String str2 = this.f2263c;
                Object obj3 = linkedHashMap2.get(str2);
                AbstractC0199b abstractC0199b2 = this.f2264d;
                if (obj3 != null) {
                    int intValue2 = ((Number) obj3).intValue();
                    arrayList2.add(str2);
                    try {
                        abstractC0193i2.b(intValue2, abstractC0199b2, obj);
                        return;
                    } catch (Exception e3) {
                        arrayList2.remove(str2);
                        throw e3;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0199b2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
    }

    public void b() {
        this.f2262b.f(this.f2263c);
    }
}
