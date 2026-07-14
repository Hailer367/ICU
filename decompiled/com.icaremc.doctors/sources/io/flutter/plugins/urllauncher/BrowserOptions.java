package io.flutter.plugins.urllauncher;

import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class BrowserOptions {
    public static final Companion Companion = new Companion(null);
    private final boolean showTitle;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final BrowserOptions fromList(List<? extends Object> pigeonVar_list) {
            h.e(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new BrowserOptions(((Boolean) obj).booleanValue());
        }

        private Companion() {
        }
    }

    public BrowserOptions(boolean z) {
        this.showTitle = z;
    }

    public static /* synthetic */ BrowserOptions copy$default(BrowserOptions browserOptions, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = browserOptions.showTitle;
        }
        return browserOptions.copy(z);
    }

    public final boolean component1() {
        return this.showTitle;
    }

    public final BrowserOptions copy(boolean z) {
        return new BrowserOptions(z);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(BrowserOptions.class)) {
            if (this == obj) {
                return true;
            }
            return MessagesPigeonUtils.INSTANCE.deepEquals(Boolean.valueOf(this.showTitle), Boolean.valueOf(((BrowserOptions) obj).showTitle));
        }
        return false;
    }

    public final boolean getShowTitle() {
        return this.showTitle;
    }

    public int hashCode() {
        return (BrowserOptions.class.hashCode() * 31) + MessagesPigeonUtils.INSTANCE.deepHash(Boolean.valueOf(this.showTitle));
    }

    public final List<Object> toList() {
        return android.support.v4.media.session.a.y(Boolean.valueOf(this.showTitle));
    }

    public String toString() {
        return "BrowserOptions(showTitle=" + this.showTitle + ")";
    }
}
