package k3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface;

/* loaded from: classes.dex */
public final class a implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final FeatureFlagHolderBoundaryInterface f5108a;

    public a(FeatureFlagHolderBoundaryInterface featureFlagHolderBoundaryInterface) {
        this.f5108a = featureFlagHolderBoundaryInterface;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        boolean z = obj instanceof a;
        FeatureFlagHolderBoundaryInterface featureFlagHolderBoundaryInterface = this.f5108a;
        if (z) {
            return featureFlagHolderBoundaryInterface.equals(((a) obj).f5108a);
        }
        return featureFlagHolderBoundaryInterface.equals(obj);
    }

    public final int hashCode() {
        return this.f5108a.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        FeatureFlagHolderBoundaryInterface featureFlagHolderBoundaryInterface = this.f5108a;
        try {
            return Class.forName(method.getDeclaringClass().getName(), true, featureFlagHolderBoundaryInterface.getClass().getClassLoader()).getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(featureFlagHolderBoundaryInterface, objArr);
        } catch (InvocationTargetException e4) {
            throw e4.getTargetException();
        } catch (ReflectiveOperationException e5) {
            throw new RuntimeException("Reflection failed for method " + method, e5);
        }
    }
}
