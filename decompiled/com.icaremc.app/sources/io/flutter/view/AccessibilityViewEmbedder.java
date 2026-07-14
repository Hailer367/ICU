package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@Keep
/* loaded from: classes.dex */
public class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final n reflectionAccessors = new n();
    private final SparseArray<o> flutterIdToOrigin = new SparseArray<>();
    private final Map<o, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    public AccessibilityViewEmbedder(View view, int i4) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void addChildrenToFlutterNode(android.view.accessibility.AccessibilityNodeInfo r6, android.view.View r7, android.view.accessibility.AccessibilityNodeInfo r8) {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r6.getChildCount()
            if (r0 >= r1) goto L99
            io.flutter.view.n r1 = r5.reflectionAccessors
            java.lang.reflect.Method r2 = r1.f4541f
            java.lang.reflect.Field r3 = r1.f4540e
            java.lang.reflect.Method r1 = r1.f4539d
            if (r1 != 0) goto L16
            if (r3 == 0) goto L60
            if (r2 != 0) goto L16
            goto L60
        L16:
            java.lang.String r4 = "AccessibilityBridge"
            if (r1 == 0) goto L39
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.reflect.InvocationTargetException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.reflect.InvocationTargetException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object r1 = r1.invoke(r6, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.reflect.InvocationTargetException -> L29 java.lang.IllegalAccessException -> L2b
            goto L61
        L29:
            r1 = move-exception
            goto L2d
        L2b:
            r1 = move-exception
            goto L33
        L2d:
            java.lang.String r2 = "The getChildId method threw an exception when invoked."
            android.util.Log.w(r4, r2, r1)
            goto L60
        L33:
            java.lang.String r2 = "Failed to access getChildId method."
            android.util.Log.w(r4, r2, r1)
            goto L60
        L39:
            java.lang.Object r1 = r3.get(r6)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L4f java.lang.reflect.InvocationTargetException -> L51 java.lang.IllegalAccessException -> L53
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L4f java.lang.reflect.InvocationTargetException -> L51 java.lang.IllegalAccessException -> L53
            java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L4f java.lang.reflect.InvocationTargetException -> L51 java.lang.IllegalAccessException -> L53
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L4f java.lang.reflect.InvocationTargetException -> L51 java.lang.IllegalAccessException -> L53
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L4f java.lang.reflect.InvocationTargetException -> L51 java.lang.IllegalAccessException -> L53
            r1.getClass()     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L4f java.lang.reflect.InvocationTargetException -> L51 java.lang.IllegalAccessException -> L53
            goto L61
        L4f:
            r1 = move-exception
            goto L55
        L51:
            r1 = move-exception
            goto L55
        L53:
            r1 = move-exception
            goto L5b
        L55:
            java.lang.String r2 = "The longArrayGetIndex method threw an exception when invoked."
            android.util.Log.w(r4, r2, r1)
            goto L60
        L5b:
            java.lang.String r2 = "Failed to access longArrayGetIndex method or the childNodeId field."
            android.util.Log.w(r4, r2, r1)
        L60:
            r1 = 0
        L61:
            if (r1 != 0) goto L64
            goto L95
        L64:
            long r1 = r1.longValue()
            r3 = 32
            long r1 = r1 >> r3
            int r1 = (int) r1
            io.flutter.view.o r2 = new io.flutter.view.o
            r2.<init>(r7, r1)
            java.util.Map<io.flutter.view.o, java.lang.Integer> r3 = r5.originToFlutterId
            boolean r3 = r3.containsKey(r2)
            if (r3 == 0) goto L86
            java.util.Map<io.flutter.view.o, java.lang.Integer> r1 = r5.originToFlutterId
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L90
        L86:
            int r2 = r5.nextFlutterId
            int r3 = r2 + 1
            r5.nextFlutterId = r3
            r5.cacheVirtualIdMappings(r7, r1, r2)
            r1 = r2
        L90:
            android.view.View r2 = r5.rootAccessibilityView
            r8.addChild(r2, r1)
        L95:
            int r0 = r0 + 1
            goto L1
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.addChildrenToFlutterNode(android.view.accessibility.AccessibilityNodeInfo, android.view.View, android.view.accessibility.AccessibilityNodeInfo):void");
    }

    private void cacheVirtualIdMappings(View view, int i4, int i5) {
        o oVar = new o(view, i4);
        this.originToFlutterId.put(oVar, Integer.valueOf(i5));
        this.flutterIdToOrigin.put(i5, oVar);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i4, View view) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i4);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i4);
        obtain.setClassName(accessibilityNodeInfo.getClassName());
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        copyAccessibilityFields(accessibilityNodeInfo, obtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, rect, obtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
        return obtain;
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        List availableExtraData;
        CharSequence hintText;
        boolean isShowingHintText;
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
        accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        if (Build.VERSION.SDK_INT >= 26) {
            availableExtraData = accessibilityNodeInfo.getAvailableExtraData();
            accessibilityNodeInfo2.setAvailableExtraData(availableExtraData);
            hintText = accessibilityNodeInfo.getHintText();
            accessibilityNodeInfo2.setHintText(hintText);
            isShowingHintText = accessibilityNodeInfo.isShowingHintText();
            accessibilityNodeInfo2.setShowingHintText(isShowingHintText);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setFlutterNodeParent(android.view.accessibility.AccessibilityNodeInfo r6, android.view.View r7, android.view.accessibility.AccessibilityNodeInfo r8) {
        /*
            r5 = this;
            io.flutter.view.n r0 = r5.reflectionAccessors
            java.lang.reflect.Method r0 = r0.f4537b
            r1 = 0
            java.lang.String r2 = "AccessibilityBridge"
            if (r0 == 0) goto L22
            java.lang.Object r0 = r0.invoke(r6, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            r0.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            goto L74
        L13:
            r0 = move-exception
            goto L17
        L15:
            r0 = move-exception
            goto L1d
        L17:
            java.lang.String r3 = "The getParentNodeId method threw an exception when invoked."
            android.util.Log.w(r2, r3, r0)
            goto L22
        L1d:
            java.lang.String r3 = "Failed to access getParentNodeId method."
            android.util.Log.w(r2, r3, r0)
        L22:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r0 >= r3) goto L2e
            java.lang.String r6 = "Unexpected Android version. Unable to find the parent ID."
            android.util.Log.w(r2, r6)
            goto L73
        L2e:
            android.view.accessibility.AccessibilityNodeInfo r6 = android.view.accessibility.AccessibilityNodeInfo.obtain(r6)
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r2 = 0
            r0.setDataPosition(r2)
            r6.writeToParcel(r0, r2)
            r0.setDataPosition(r2)
            long r3 = r0.readLong()
            boolean r6 = io.flutter.view.n.b(r3, r2)
            if (r6 == 0) goto L4d
            r0.readInt()
        L4d:
            r6 = 1
            boolean r6 = io.flutter.view.n.b(r3, r6)
            if (r6 == 0) goto L57
            r0.readLong()
        L57:
            r6 = 2
            boolean r6 = io.flutter.view.n.b(r3, r6)
            if (r6 == 0) goto L61
            r0.readInt()
        L61:
            r6 = 3
            boolean r6 = io.flutter.view.n.b(r3, r6)
            if (r6 == 0) goto L70
            long r1 = r0.readLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L70:
            r0.recycle()
        L73:
            r0 = r1
        L74:
            if (r0 != 0) goto L77
            goto L97
        L77:
            long r0 = r0.longValue()
            r6 = 32
            long r0 = r0 >> r6
            int r6 = (int) r0
            java.util.Map<io.flutter.view.o, java.lang.Integer> r0 = r5.originToFlutterId
            io.flutter.view.o r1 = new io.flutter.view.o
            r1.<init>(r7, r6)
            java.lang.Object r6 = r0.get(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L97
            android.view.View r7 = r5.rootAccessibilityView
            int r6 = r6.intValue()
            r8.setParent(r7, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.setFlutterNodeParent(android.view.accessibility.AccessibilityNodeInfo, android.view.View, android.view.accessibility.AccessibilityNodeInfo):void");
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i4) {
        AccessibilityNodeInfo createAccessibilityNodeInfo;
        o oVar = this.flutterIdToOrigin.get(i4);
        if (oVar == null) {
            return null;
        }
        View view = oVar.f4542a;
        if (!this.embeddedViewToDisplayBounds.containsKey(view) || view.getAccessibilityNodeProvider() == null || (createAccessibilityNodeInfo = view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(oVar.f4543b)) == null) {
            return null;
        }
        return convertToFlutterNode(createAccessibilityNodeInfo, i4, view);
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        Long a4 = n.a(this.reflectionAccessors, accessibilityRecord);
        if (a4 == null) {
            return null;
        }
        return this.originToFlutterId.get(new o(view, (int) (a4.longValue() >> 32)));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo getRootNode(android.view.View r6, int r7, android.graphics.Rect r8) {
        /*
            r5 = this;
            android.view.accessibility.AccessibilityNodeInfo r0 = r6.createAccessibilityNodeInfo()
            io.flutter.view.n r1 = r5.reflectionAccessors
            java.lang.String r2 = "AccessibilityBridge"
            java.lang.reflect.Method r1 = r1.f4536a
            r3 = 0
            if (r1 != 0) goto Le
            goto L24
        Le:
            java.lang.Object r1 = r1.invoke(r0, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L15 java.lang.IllegalAccessException -> L17
            java.lang.Long r1 = (java.lang.Long) r1     // Catch: java.lang.reflect.InvocationTargetException -> L15 java.lang.IllegalAccessException -> L17
            goto L25
        L15:
            r1 = move-exception
            goto L19
        L17:
            r1 = move-exception
            goto L1f
        L19:
            java.lang.String r4 = "The getSourceNodeId method threw an exception when invoked."
            android.util.Log.w(r2, r4, r1)
            goto L24
        L1f:
            java.lang.String r4 = "Failed to access getSourceNodeId method."
            android.util.Log.w(r2, r4, r1)
        L24:
            r1 = r3
        L25:
            if (r1 != 0) goto L28
            return r3
        L28:
            java.util.Map<android.view.View, android.graphics.Rect> r2 = r5.embeddedViewToDisplayBounds
            r2.put(r6, r8)
            long r1 = r1.longValue()
            r8 = 32
            long r1 = r1 >> r8
            int r8 = (int) r1
            r5.cacheVirtualIdMappings(r6, r8, r7)
            android.view.accessibility.AccessibilityNodeInfo r6 = r5.convertToFlutterNode(r0, r7, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.getRootNode(android.view.View, int, android.graphics.Rect):android.view.accessibility.AccessibilityNodeInfo");
    }

    public boolean onAccessibilityHoverEvent(int i4, MotionEvent motionEvent) {
        o oVar = this.flutterIdToOrigin.get(i4);
        if (oVar == null) {
            return false;
        }
        View view = oVar.f4542a;
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i5 = 0; i5 < motionEvent.getPointerCount(); i5++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i5] = pointerProperties;
            motionEvent.getPointerProperties(i5, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i5, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i5] = pointerCoords2;
            pointerCoords2.x -= rect.left;
            pointerCoords2.y -= rect.top;
        }
        return view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i4, int i5, Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        o oVar = this.flutterIdToOrigin.get(i4);
        if (oVar == null || (accessibilityNodeProvider = oVar.f4542a.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(oVar.f4543b, i5, bundle);
    }

    public View platformViewOfNode(int i4) {
        o oVar = this.flutterIdToOrigin.get(i4);
        if (oVar == null) {
            return null;
        }
        return oVar.f4542a;
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long a4 = n.a(this.reflectionAccessors, accessibilityEvent);
        if (a4 != null) {
            int longValue = (int) (a4.longValue() >> 32);
            Integer num = this.originToFlutterId.get(new o(view, longValue));
            if (num == null) {
                int i4 = this.nextFlutterId;
                this.nextFlutterId = i4 + 1;
                Integer valueOf = Integer.valueOf(i4);
                cacheVirtualIdMappings(view, longValue, i4);
                num = valueOf;
            }
            obtain.setSource(this.rootAccessibilityView, num.intValue());
            obtain.setClassName(accessibilityEvent.getClassName());
            obtain.setPackageName(accessibilityEvent.getPackageName());
            for (int i5 = 0; i5 < obtain.getRecordCount(); i5++) {
                AccessibilityRecord record = obtain.getRecord(i5);
                Long a5 = n.a(this.reflectionAccessors, record);
                if (a5 != null) {
                    o oVar = new o(view, (int) (a5.longValue() >> 32));
                    if (this.originToFlutterId.containsKey(oVar)) {
                        record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(oVar).intValue());
                    }
                }
            }
            return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
        }
        return false;
    }
}
