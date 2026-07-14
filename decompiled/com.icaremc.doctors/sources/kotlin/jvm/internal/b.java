package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class b implements i1.b, Serializable {
    public static final Object NO_RECEIVER = a.f2780c;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient i1.b reflected;
    private final String signature;

    public b(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // i1.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // i1.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public i1.b compute() {
        i1.b bVar = this.reflected;
        if (bVar == null) {
            i1.b computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return bVar;
    }

    public abstract i1.b computeReflected();

    @Override // i1.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public i1.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            r.f2790a.getClass();
            return new j(cls);
        }
        return r.a(cls);
    }

    @Override // i1.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public i1.b getReflected() {
        i1.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new Error("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    @Override // i1.b
    public i1.k getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // i1.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // i1.b
    public i1.l getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // i1.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // i1.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // i1.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // i1.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
