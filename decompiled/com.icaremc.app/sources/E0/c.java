package E0;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
public final class c implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f461a;

    public c(String str) {
        this.f461a = str;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.startsWith(this.f461a);
    }
}
