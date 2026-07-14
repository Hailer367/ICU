package io.flutter.view;

import io.flutter.view.AccessibilityBridge;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        boolean lambda$shouldSetCollectionInfo$1;
        lambda$shouldSetCollectionInfo$1 = AccessibilityBridge.lambda$shouldSetCollectionInfo$1((AccessibilityBridge.SemanticsNode) obj);
        return lambda$shouldSetCollectionInfo$1;
    }
}
