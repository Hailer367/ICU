package E;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.icaremc.doctors.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: E.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0002b {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f210c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f211a = f210c;

    /* renamed from: b, reason: collision with root package name */
    public final C0001a f212b = new C0001a(this);

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.f211a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void b(View view, F.g gVar) {
        this.f211a.onInitializeAccessibilityNodeInfo(view, gVar.f272a);
    }

    public boolean c(View view, int i2, Bundle bundle) {
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        ClickableSpan[] clickableSpanArr;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i3 = 0; i3 < list.size() && ((AccessibilityNodeInfo.AccessibilityAction) ((F.d) list.get(i3)).f269a).getId() != i2; i3++) {
        }
        boolean performAccessibilityAction = this.f211a.performAccessibilityAction(view, i2, bundle);
        if (!performAccessibilityAction && i2 == R.id.accessibility_action_clickable_span && bundle != null) {
            int i4 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i4)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                if (text instanceof Spanned) {
                    clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                } else {
                    clickableSpanArr = null;
                }
                for (int i5 = 0; clickableSpanArr != null && i5 < clickableSpanArr.length; i5++) {
                    if (clickableSpan.equals(clickableSpanArr[i5])) {
                        clickableSpan.onClick(view);
                        return true;
                    }
                }
            }
            return false;
        }
        return performAccessibilityAction;
    }
}
