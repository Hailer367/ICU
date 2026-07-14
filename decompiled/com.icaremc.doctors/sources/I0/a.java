package I0;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f324a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f325b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f326c;

    public /* synthetic */ a(String str, Object obj, int i2) {
        this.f324a = i2;
        this.f325b = str;
        this.f326c = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f324a) {
            case 0:
                return ComponentMonitor.a(this.f325b, (Component) this.f326c, componentContainer);
            default:
                return LibraryVersionComponent.a(this.f325b, (LibraryVersionComponent.VersionExtractor) this.f326c, componentContainer);
        }
    }
}
