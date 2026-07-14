package I;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.icaremc.app.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: I.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0048b {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f720c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f721a;

    /* renamed from: b, reason: collision with root package name */
    public final C0047a f722b;

    public C0048b() {
        this(f720c);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.f721a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void b(View view, J.f fVar) {
        this.f721a.onInitializeAccessibilityNodeInfo(view, fVar.f875a);
    }

    public boolean c(View view, int i4, Bundle bundle) {
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        ClickableSpan[] clickableSpanArr;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i5 = 0; i5 < list.size() && ((AccessibilityNodeInfo.AccessibilityAction) ((J.c) list.get(i5)).f872a).getId() != i4; i5++) {
        }
        boolean performAccessibilityAction = this.f721a.performAccessibilityAction(view, i4, bundle);
        if (!performAccessibilityAction && i4 == R.id.accessibility_action_clickable_span && bundle != null) {
            int i6 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i6)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                if (text instanceof Spanned) {
                    clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                } else {
                    clickableSpanArr = null;
                }
                for (int i7 = 0; clickableSpanArr != null && i7 < clickableSpanArr.length; i7++) {
                    if (clickableSpan.equals(clickableSpanArr[i7])) {
                        clickableSpan.onClick(view);
                        return true;
                    }
                }
            }
            return false;
        }
        return performAccessibilityAction;
    }

    public C0048b(View.AccessibilityDelegate accessibilityDelegate) {
        this.f721a = accessibilityDelegate;
        this.f722b = new C0047a(this);
    }
}
