package org.chromium.support_lib_boundary;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface WebViewStartUpConfigBoundaryInterface {
    Executor getBackgroundExecutor();

    Set<String> getProfileNamesToLoad();

    boolean shouldRunUiThreadStartUpTasks();
}
