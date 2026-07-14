package com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview;

import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DisplayListenerProxy {
    private static final String TAG = "DisplayListenerProxy";
    private ArrayList<DisplayManager.DisplayListener> listenersBeforeWebView;

    private static ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners(DisplayManager displayManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new ArrayList<>();
        }
        try {
            Field declaredField = DisplayManager.class.getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(displayManager);
            Field declaredField2 = obj.getClass().getDeclaredField("mDisplayListeners");
            declaredField2.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField2.get(obj);
            ArrayList<DisplayManager.DisplayListener> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            Field field = null;
            int i4 = 0;
            while (i4 < size) {
                Object obj2 = arrayList.get(i4);
                i4++;
                if (field == null) {
                    field = obj2.getClass().getField("mListener");
                    field.setAccessible(true);
                }
                arrayList2.add((DisplayManager.DisplayListener) field.get(obj2));
            }
            return arrayList2;
        } catch (IllegalAccessException | NoSuchFieldException e4) {
            Log.w(TAG, "Could not extract WebView's display listeners. " + e4);
            return new ArrayList<>();
        }
    }

    public void onPostWebViewInitialization(final DisplayManager displayManager) {
        final ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners = yoinkDisplayListeners(displayManager);
        yoinkDisplayListeners.removeAll(this.listenersBeforeWebView);
        if (!yoinkDisplayListeners.isEmpty()) {
            int size = yoinkDisplayListeners.size();
            int i4 = 0;
            while (i4 < size) {
                DisplayManager.DisplayListener displayListener = yoinkDisplayListeners.get(i4);
                i4++;
                displayManager.unregisterDisplayListener(displayListener);
                displayManager.registerDisplayListener(new DisplayManager.DisplayListener() { // from class: com.pichillilorenzo.flutter_inappwebview_android.webview.in_app_webview.DisplayListenerProxy.1
                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayAdded(int i5) {
                        ArrayList arrayList = yoinkDisplayListeners;
                        int size2 = arrayList.size();
                        int i6 = 0;
                        while (i6 < size2) {
                            Object obj = arrayList.get(i6);
                            i6++;
                            ((DisplayManager.DisplayListener) obj).onDisplayAdded(i5);
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayChanged(int i5) {
                        if (displayManager.getDisplay(i5) != null) {
                            ArrayList arrayList = yoinkDisplayListeners;
                            int size2 = arrayList.size();
                            int i6 = 0;
                            while (i6 < size2) {
                                Object obj = arrayList.get(i6);
                                i6++;
                                ((DisplayManager.DisplayListener) obj).onDisplayChanged(i5);
                            }
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayRemoved(int i5) {
                        ArrayList arrayList = yoinkDisplayListeners;
                        int size2 = arrayList.size();
                        int i6 = 0;
                        while (i6 < size2) {
                            Object obj = arrayList.get(i6);
                            i6++;
                            ((DisplayManager.DisplayListener) obj).onDisplayRemoved(i5);
                        }
                    }
                }, null);
            }
        }
    }

    public void onPreWebViewInitialization(DisplayManager displayManager) {
        this.listenersBeforeWebView = yoinkDisplayListeners(displayManager);
    }
}
