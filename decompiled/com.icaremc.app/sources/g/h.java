package g;

import h.AbstractC0296a;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class h extends AbstractC0291c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3750a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3751b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0296a f3752c;

    public h(i iVar, String str, AbstractC0296a abstractC0296a) {
        this.f3750a = iVar;
        this.f3751b = str;
        this.f3752c = abstractC0296a;
    }

    public final void a(Object obj) {
        i iVar = this.f3750a;
        ArrayList arrayList = iVar.f3756d;
        LinkedHashMap linkedHashMap = iVar.f3754b;
        String str = this.f3751b;
        Object obj2 = linkedHashMap.get(str);
        AbstractC0296a abstractC0296a = this.f3752c;
        if (obj2 != null) {
            int intValue = ((Number) obj2).intValue();
            arrayList.add(str);
            try {
                iVar.b(intValue, abstractC0296a, obj);
                return;
            } catch (Exception e4) {
                arrayList.remove(str);
                throw e4;
            }
        }
        throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0296a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
    }
}
