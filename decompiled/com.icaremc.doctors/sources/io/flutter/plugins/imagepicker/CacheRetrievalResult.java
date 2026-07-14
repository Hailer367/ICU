package io.flutter.plugins.imagepicker;

import R0.k;
import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class CacheRetrievalResult {
    public static final Companion Companion = new Companion(null);
    private final CacheRetrievalError error;
    private final List<String> paths;
    private final CacheRetrievalType type;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final CacheRetrievalResult fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.CacheRetrievalType");
            CacheRetrievalError cacheRetrievalError = (CacheRetrievalError) pigeonVar_list.get(1);
            Object obj2 = pigeonVar_list.get(2);
            h.c(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            return new CacheRetrievalResult((CacheRetrievalType) obj, cacheRetrievalError, (List) obj2);
        }

        private Companion() {
        }
    }

    public CacheRetrievalResult(CacheRetrievalType type, CacheRetrievalError cacheRetrievalError, List<String> paths) {
        h.e(type, "type");
        h.e(paths, "paths");
        this.type = type;
        this.error = cacheRetrievalError;
        this.paths = paths;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CacheRetrievalResult copy$default(CacheRetrievalResult cacheRetrievalResult, CacheRetrievalType cacheRetrievalType, CacheRetrievalError cacheRetrievalError, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cacheRetrievalType = cacheRetrievalResult.type;
        }
        if ((i2 & 2) != 0) {
            cacheRetrievalError = cacheRetrievalResult.error;
        }
        if ((i2 & 4) != 0) {
            list = cacheRetrievalResult.paths;
        }
        return cacheRetrievalResult.copy(cacheRetrievalType, cacheRetrievalError, list);
    }

    public final CacheRetrievalType component1() {
        return this.type;
    }

    public final CacheRetrievalError component2() {
        return this.error;
    }

    public final List<String> component3() {
        return this.paths;
    }

    public final CacheRetrievalResult copy(CacheRetrievalType type, CacheRetrievalError cacheRetrievalError, List<String> paths) {
        h.e(type, "type");
        h.e(paths, "paths");
        return new CacheRetrievalResult(type, cacheRetrievalError, paths);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(CacheRetrievalResult.class)) {
            if (this == obj) {
                return true;
            }
            CacheRetrievalResult cacheRetrievalResult = (CacheRetrievalResult) obj;
            MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
            if (messagesPigeonUtils.deepEquals(this.type, cacheRetrievalResult.type) && messagesPigeonUtils.deepEquals(this.error, cacheRetrievalResult.error) && messagesPigeonUtils.deepEquals(this.paths, cacheRetrievalResult.paths)) {
                return true;
            }
        }
        return false;
    }

    public final CacheRetrievalError getError() {
        return this.error;
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public final CacheRetrievalType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = CacheRetrievalResult.class.hashCode() * 31;
        MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
        return ((((hashCode + messagesPigeonUtils.deepHash(this.type)) * 31) + messagesPigeonUtils.deepHash(this.error)) * 31) + messagesPigeonUtils.deepHash(this.paths);
    }

    public final List<Object> toList() {
        return k.N(this.type, this.error, this.paths);
    }

    public String toString() {
        return "CacheRetrievalResult(type=" + this.type + ", error=" + this.error + ", paths=" + this.paths + ")";
    }

    public /* synthetic */ CacheRetrievalResult(CacheRetrievalType cacheRetrievalType, CacheRetrievalError cacheRetrievalError, List list, int i2, kotlin.jvm.internal.e eVar) {
        this(cacheRetrievalType, (i2 & 2) != 0 ? null : cacheRetrievalError, list);
    }
}
