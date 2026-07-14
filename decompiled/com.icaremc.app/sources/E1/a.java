package E1;

import F1.f;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements C1.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f462a;

    @Override // C1.a
    public final void a(Object obj, Object obj2) {
        switch (this.f462a) {
            case 0:
                throw new RuntimeException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                C1.e eVar = (C1.e) obj2;
                eVar.c(f.f535g, entry.getKey());
                eVar.c(f.f536h, entry.getValue());
                return;
            default:
                throw new RuntimeException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
