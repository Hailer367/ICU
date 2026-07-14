package o;

import I.C0050d;
import I.InterfaceC0049c;
import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* renamed from: o.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0471F {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        InterfaceC0049c interfaceC0049c;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                interfaceC0049c = new R1.c(clipData, 3);
            } else {
                C0050d c0050d = new C0050d();
                c0050d.f725g = clipData;
                c0050d.f726h = 3;
                interfaceC0049c = c0050d;
            }
            I.T.g(textView, interfaceC0049c.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        InterfaceC0049c interfaceC0049c;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            interfaceC0049c = new R1.c(clipData, 3);
        } else {
            C0050d c0050d = new C0050d();
            c0050d.f725g = clipData;
            c0050d.f726h = 3;
            interfaceC0049c = c0050d;
        }
        I.T.g(view, interfaceC0049c.build());
        return true;
    }
}
