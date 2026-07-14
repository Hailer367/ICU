package io.flutter.plugins.imagepicker;

import R0.k;
import java.util.List;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class CacheRetrievalError {
    public static final Companion Companion = new Companion(null);
    private final String code;
    private final String message;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final CacheRetrievalError fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type kotlin.String");
            return new CacheRetrievalError((String) obj, (String) pigeonVar_list.get(1));
        }

        private Companion() {
        }
    }

    public CacheRetrievalError(String code, String str) {
        h.e(code, "code");
        this.code = code;
        this.message = str;
    }

    public static /* synthetic */ CacheRetrievalError copy$default(CacheRetrievalError cacheRetrievalError, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cacheRetrievalError.code;
        }
        if ((i2 & 2) != 0) {
            str2 = cacheRetrievalError.message;
        }
        return cacheRetrievalError.copy(str, str2);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final CacheRetrievalError copy(String code, String str) {
        h.e(code, "code");
        return new CacheRetrievalError(code, str);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(CacheRetrievalError.class)) {
            if (this == obj) {
                return true;
            }
            CacheRetrievalError cacheRetrievalError = (CacheRetrievalError) obj;
            MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
            if (messagesPigeonUtils.deepEquals(this.code, cacheRetrievalError.code) && messagesPigeonUtils.deepEquals(this.message, cacheRetrievalError.message)) {
                return true;
            }
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int hashCode = CacheRetrievalError.class.hashCode() * 31;
        MessagesPigeonUtils messagesPigeonUtils = MessagesPigeonUtils.INSTANCE;
        return ((hashCode + messagesPigeonUtils.deepHash(this.code)) * 31) + messagesPigeonUtils.deepHash(this.message);
    }

    public final List<Object> toList() {
        return k.N(this.code, this.message);
    }

    public String toString() {
        return "CacheRetrievalError(code=" + this.code + ", message=" + this.message + ")";
    }

    public /* synthetic */ CacheRetrievalError(String str, String str2, int i2, kotlin.jvm.internal.e eVar) {
        this(str, (i2 & 2) != 0 ? null : str2);
    }
}
