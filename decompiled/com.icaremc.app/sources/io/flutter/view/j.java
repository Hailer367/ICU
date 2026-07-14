package io.flutter.view;

import P1.y;
import android.R;
import android.content.ContentResolver;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class j extends AccessibilityNodeProvider {

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f4508y = 0;

    /* renamed from: a, reason: collision with root package name */
    public final View f4509a;

    /* renamed from: b, reason: collision with root package name */
    public final A2.t f4510b;

    /* renamed from: c, reason: collision with root package name */
    public final AccessibilityManager f4511c;

    /* renamed from: d, reason: collision with root package name */
    public final AccessibilityViewEmbedder f4512d;

    /* renamed from: e, reason: collision with root package name */
    public final io.flutter.plugin.platform.l f4513e;

    /* renamed from: f, reason: collision with root package name */
    public final ContentResolver f4514f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f4515g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f4516h;

    /* renamed from: i, reason: collision with root package name */
    public i f4517i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f4518j;
    public Integer k;

    /* renamed from: l, reason: collision with root package name */
    public int f4519l;

    /* renamed from: m, reason: collision with root package name */
    public String f4520m;

    /* renamed from: n, reason: collision with root package name */
    public i f4521n;

    /* renamed from: o, reason: collision with root package name */
    public i f4522o;

    /* renamed from: p, reason: collision with root package name */
    public i f4523p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f4524q;

    /* renamed from: r, reason: collision with root package name */
    public int f4525r;

    /* renamed from: s, reason: collision with root package name */
    public A2.q f4526s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4527t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4528u;

    /* renamed from: v, reason: collision with root package name */
    public final e f4529v;

    /* renamed from: w, reason: collision with root package name */
    public final f f4530w;

    /* renamed from: x, reason: collision with root package name */
    public final M.a f4531x;

    public j(View view, A2.t tVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.l lVar) {
        int i4;
        AccessibilityViewEmbedder accessibilityViewEmbedder = new AccessibilityViewEmbedder(view, 65536);
        this.f4515g = new HashMap();
        this.f4516h = new HashMap();
        this.f4519l = 0;
        this.f4524q = new ArrayList();
        this.f4525r = 0;
        this.f4527t = false;
        this.f4528u = false;
        d dVar = new d(this);
        e eVar = new e(this);
        this.f4529v = eVar;
        M.a aVar = new M.a(this, new Handler(), 2);
        this.f4531x = aVar;
        this.f4509a = view;
        this.f4510b = tVar;
        this.f4511c = accessibilityManager;
        this.f4514f = contentResolver;
        this.f4512d = accessibilityViewEmbedder;
        this.f4513e = lVar;
        tVar.f101i = dVar;
        ((FlutterJNI) tVar.f100h).setAccessibilityDelegate(dVar);
        eVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(eVar);
        f fVar = new f(this, accessibilityManager);
        this.f4530w = fVar;
        fVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(fVar);
        this.f4519l |= 128;
        aVar.onChange(false, null);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, aVar);
        if (Build.VERSION.SDK_INT >= 31 && view != null && view.getResources() != null) {
            i4 = view.getResources().getConfiguration().fontWeightAdjustment;
            if (i4 != Integer.MAX_VALUE && i4 >= 300) {
                this.f4519l |= 8;
            } else {
                this.f4519l &= -9;
            }
            ((FlutterJNI) tVar.f100h).setAccessibilityFeatures(this.f4519l);
        }
        lVar.d(this);
    }

    public static String d(ByteBuffer byteBuffer, String[] strArr) {
        int i4 = byteBuffer.getInt();
        if (i4 == -1) {
            return null;
        }
        return strArr[i4];
    }

    public final boolean a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.f4512d;
        if (!accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType != 8) {
            if (eventType != 128) {
                if (eventType != 32768) {
                    if (eventType == 65536) {
                        this.k = null;
                        this.f4518j = null;
                        return true;
                    }
                    return true;
                }
                this.f4518j = recordFlutterId;
                this.f4517i = null;
                return true;
            }
            this.f4523p = null;
            return true;
        }
        this.k = recordFlutterId;
        this.f4521n = null;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [io.flutter.view.h, java.lang.Object] */
    public final h b(int i4) {
        Integer valueOf = Integer.valueOf(i4);
        HashMap hashMap = this.f4516h;
        h hVar = (h) hashMap.get(valueOf);
        if (hVar == null) {
            ?? obj = new Object();
            obj.f4453c = -1;
            obj.f4452b = i4;
            obj.f4451a = 267386881 + i4;
            hashMap.put(Integer.valueOf(i4), obj);
            return obj;
        }
        return hVar;
    }

    public final i c(int i4) {
        Integer valueOf = Integer.valueOf(i4);
        HashMap hashMap = this.f4515g;
        i iVar = (i) hashMap.get(valueOf);
        if (iVar == null) {
            i iVar2 = new i(this);
            iVar2.f4483b = i4;
            hashMap.put(Integer.valueOf(i4), iVar2);
            return iVar2;
        }
        return iVar;
    }

    /* JADX WARN: Type inference failed for: r2v25, types: [P1.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v28, types: [P1.y, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v21, types: [P1.y, java.lang.Object] */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i4) {
        boolean z;
        boolean g4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        boolean z7;
        int i5;
        int length;
        int i6;
        boolean z8;
        boolean z9;
        j(true);
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.f4512d;
        if (i4 >= 65536) {
            return accessibilityViewEmbedder.createAccessibilityNodeInfo(i4);
        }
        HashMap hashMap = this.f4515g;
        View view = this.f4509a;
        if (i4 == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
            view.onInitializeAccessibilityNodeInfo(obtain);
            if (hashMap.containsKey(0)) {
                obtain.addChild(view, 0);
            }
            obtain.setImportantForAccessibility(false);
            return obtain;
        }
        i iVar = (i) hashMap.get(Integer.valueOf(i4));
        if (iVar != null) {
            int i7 = iVar.f4492i;
            io.flutter.plugin.platform.l lVar = this.f4513e;
            if (i7 != -1 && lVar.g(i7)) {
                View l3 = lVar.l(iVar.f4492i);
                if (l3 != null) {
                    return accessibilityViewEmbedder.getRootNode(l3, iVar.f4483b, iVar.f4486c0);
                }
            } else {
                AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain(view, i4);
                if (iVar.g(12) || (i.b(iVar) == null && iVar.f4487d == 0)) {
                    z = false;
                } else {
                    z = true;
                }
                obtain2.setImportantForAccessibility(z);
                CharSequence charSequence = "";
                obtain2.setViewIdResourceName("");
                String str2 = iVar.f4497o;
                if (str2 != null) {
                    obtain2.setViewIdResourceName(str2);
                }
                obtain2.setPackageName(view.getContext().getPackageName());
                obtain2.setClassName("android.view.View");
                obtain2.setSource(view, i4);
                obtain2.setFocusable(iVar.i());
                i iVar2 = this.f4521n;
                if (iVar2 != null) {
                    if (iVar2.f4483b == i4) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    obtain2.setFocused(z9);
                }
                i iVar3 = this.f4517i;
                if (iVar3 != null) {
                    if (iVar3.f4483b == i4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    obtain2.setAccessibilityFocused(z8);
                }
                if (iVar.g(5)) {
                    obtain2.setPassword(iVar.g(11));
                    if (!iVar.g(21)) {
                        obtain2.setClassName("android.widget.EditText");
                    }
                    obtain2.setEditable(!iVar.g(21));
                    int i8 = iVar.f4490g;
                    if (i8 != -1 && (i6 = iVar.f4491h) != -1) {
                        obtain2.setTextSelection(i8, i6);
                    }
                    i iVar4 = this.f4517i;
                    if (iVar4 != null && iVar4.f4483b == i4) {
                        obtain2.setLiveRegion(1);
                    }
                    if (i.a(iVar, g.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                        obtain2.addAction(256);
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    if (i.a(iVar, g.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                        obtain2.addAction(512);
                        i5 = 1;
                    }
                    if (i.a(iVar, g.MOVE_CURSOR_FORWARD_BY_WORD)) {
                        obtain2.addAction(256);
                        i5 |= 2;
                    }
                    if (i.a(iVar, g.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                        obtain2.addAction(512);
                        i5 |= 2;
                    }
                    obtain2.setMovementGranularities(i5);
                    if (iVar.f4488e >= 0) {
                        String str3 = iVar.f4500r;
                        if (str3 == null) {
                            length = 0;
                        } else {
                            length = str3.length();
                        }
                        obtain2.setMaxTextLength((length - iVar.f4489f) + iVar.f4488e);
                    }
                }
                if (i.a(iVar, g.SET_SELECTION)) {
                    obtain2.addAction(131072);
                }
                if (i.a(iVar, g.COPY)) {
                    obtain2.addAction(16384);
                }
                if (i.a(iVar, g.CUT)) {
                    obtain2.addAction(65536);
                }
                if (i.a(iVar, g.PASTE)) {
                    obtain2.addAction(32768);
                }
                if (i.a(iVar, g.SET_TEXT)) {
                    obtain2.addAction(2097152);
                }
                if (iVar.g(4)) {
                    g4 = true;
                } else {
                    String str4 = iVar.f4456A;
                    if (str4 != null && !str4.isEmpty()) {
                        g4 = false;
                    } else {
                        g4 = iVar.g(23);
                    }
                }
                if (g4) {
                    obtain2.setClassName("android.widget.Button");
                }
                if (iVar.g(15)) {
                    obtain2.setClassName("android.widget.ImageView");
                }
                if (i.a(iVar, g.DISMISS)) {
                    obtain2.setDismissable(true);
                    obtain2.addAction(1048576);
                }
                i iVar5 = iVar.f4473S;
                if (iVar5 != null) {
                    obtain2.setParent(view, iVar5.f4483b);
                } else {
                    obtain2.setParent(view);
                }
                int i9 = iVar.f4459D;
                if (i9 != -1) {
                    obtain2.setTraversalAfter(view, i9);
                }
                Rect rect = iVar.f4486c0;
                i iVar6 = iVar.f4473S;
                if (iVar6 != null) {
                    Rect rect2 = iVar6.f4486c0;
                    Rect rect3 = new Rect(rect);
                    rect3.offset(-rect2.left, -rect2.top);
                    obtain2.setBoundsInParent(rect3);
                } else {
                    obtain2.setBoundsInParent(rect);
                }
                Rect rect4 = new Rect(rect);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                rect4.offset(iArr[0], iArr[1]);
                obtain2.setBoundsInScreen(rect4);
                obtain2.setVisibleToUser(true);
                if (iVar.g(7) && !iVar.g(8)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                obtain2.setEnabled(z3);
                if (i.a(iVar, g.TAP)) {
                    if (iVar.f4477W != null) {
                        obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, iVar.f4477W.f4455e));
                        obtain2.setClickable(true);
                    } else {
                        obtain2.addAction(16);
                        obtain2.setClickable(true);
                    }
                } else if (iVar.g(24)) {
                    obtain2.addAction(16);
                    obtain2.setClickable(true);
                }
                if (i.a(iVar, g.LONG_PRESS)) {
                    if (iVar.f4478X != null) {
                        obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, iVar.f4478X.f4455e));
                        obtain2.setLongClickable(true);
                    } else {
                        obtain2.addAction(32);
                        obtain2.setLongClickable(true);
                    }
                }
                g gVar = g.SCROLL_LEFT;
                boolean a4 = i.a(iVar, gVar);
                g gVar2 = g.SCROLL_DOWN;
                g gVar3 = g.SCROLL_UP;
                g gVar4 = g.SCROLL_RIGHT;
                if (a4 || i.a(iVar, gVar3) || i.a(iVar, gVar4) || i.a(iVar, gVar2)) {
                    obtain2.setScrollable(true);
                    if (iVar.g(19)) {
                        if (!i.a(iVar, gVar) && !i.a(iVar, gVar4)) {
                            obtain2.setClassName("android.widget.ScrollView");
                        } else {
                            obtain2.setClassName("android.widget.HorizontalScrollView");
                        }
                    }
                }
                if (k(iVar)) {
                    if (!i.a(iVar, gVar) && !i.a(iVar, gVar4)) {
                        if (Build.VERSION.SDK_INT < 33) {
                            obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(iVar.f4493j, 1, false));
                        } else {
                            obtain2.setCollectionInfo(b.d(iVar.f4493j));
                        }
                    } else if (Build.VERSION.SDK_INT < 33) {
                        obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, iVar.f4493j, false));
                    } else {
                        obtain2.setCollectionInfo(b.g(iVar.f4493j));
                    }
                }
                i iVar7 = iVar.f4473S;
                if (iVar7 != null && k(iVar7) && iVar.f4473S.g(19)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    i iVar8 = iVar.f4473S;
                    ArrayList arrayList = iVar8.f4474T;
                    if (!i.a(iVar8, gVar) && !i.a(iVar8, gVar4)) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    int indexOf = arrayList.indexOf(iVar);
                    if (z7) {
                        if (Build.VERSION.SDK_INT < 33) {
                            obtain2.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(indexOf, 1, 0, 1, iVar.g(10)));
                        } else {
                            obtain2.setCollectionItemInfo(b.e(indexOf, iVar.g(10)));
                        }
                    } else if (Build.VERSION.SDK_INT < 33) {
                        obtain2.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, indexOf, 1, iVar.g(10)));
                    } else {
                        obtain2.setCollectionItemInfo(b.h(indexOf, iVar.g(10)));
                    }
                }
                if (i.a(iVar, gVar) || i.a(iVar, gVar3)) {
                    obtain2.addAction(4096);
                }
                if (i.a(iVar, gVar4) || i.a(iVar, gVar2)) {
                    obtain2.addAction(8192);
                }
                g gVar5 = g.INCREASE;
                boolean a5 = i.a(iVar, gVar5);
                g gVar6 = g.DECREASE;
                if (a5 || i.a(iVar, gVar6)) {
                    obtain2.setClassName("android.widget.SeekBar");
                    if (i.a(iVar, gVar5)) {
                        obtain2.addAction(4096);
                    }
                    if (i.a(iVar, gVar6)) {
                        obtain2.addAction(8192);
                    }
                }
                if (iVar.g(16)) {
                    obtain2.setLiveRegion(1);
                }
                int i10 = 3;
                if (iVar.g(5)) {
                    ?? obj = new Object();
                    obj.f1469f = iVar.f4500r;
                    obj.f1470g = iVar.f4501s;
                    obj.f1471h = iVar.d();
                    obtain2.setText(obj.c());
                    if (Build.VERSION.SDK_INT >= 28) {
                        ?? obj2 = new Object();
                        obj2.f1469f = iVar.f4498p;
                        obj2.f1470g = iVar.f4499q;
                        obj2.f1472i = iVar.f4456A;
                        obj2.f1471h = iVar.d();
                        SpannableString c4 = obj2.c();
                        ?? obj3 = new Object();
                        obj3.f1469f = iVar.f4506x;
                        obj3.f1470g = iVar.f4507y;
                        obj3.f1471h = iVar.d();
                        CharSequence[] charSequenceArr = {c4, obj3.c()};
                        int i11 = 0;
                        CharSequence charSequence2 = null;
                        for (int i12 = 2; i11 < i12; i12 = 2) {
                            CharSequence charSequence3 = charSequenceArr[i11];
                            if (charSequence3 != null && charSequence3.length() > 0) {
                                if (charSequence2 != null && charSequence2.length() != 0) {
                                    charSequence2 = TextUtils.concat(charSequence2, ", ", charSequence3);
                                } else {
                                    charSequence2 = charSequence3;
                                }
                            }
                            i11++;
                        }
                        obtain2.setHintText(charSequence2);
                    }
                } else if (!iVar.g(12)) {
                    CharSequence b4 = i.b(iVar);
                    if (Build.VERSION.SDK_INT < 28 && iVar.z != null) {
                        if (b4 != null) {
                            charSequence = b4;
                        }
                        b4 = ((Object) charSequence) + "\n" + iVar.z;
                    }
                    if (b4 != null) {
                        obtain2.setContentDescription(b4);
                    }
                }
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 28 && (str = iVar.z) != null) {
                    obtain2.setTooltipText(str);
                    if (i.b(iVar) == null) {
                        obtain2.setContentDescription(iVar.z);
                    }
                }
                boolean g5 = iVar.g(1);
                boolean g6 = iVar.g(17);
                if (!g5 && !g6) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                obtain2.setCheckable(z5);
                if (g5) {
                    obtain2.setChecked(iVar.g(2));
                    if (iVar.g(9)) {
                        obtain2.setClassName("android.widget.RadioButton");
                    } else {
                        obtain2.setClassName("android.widget.CheckBox");
                    }
                } else if (g6) {
                    obtain2.setChecked(iVar.g(18));
                    obtain2.setClassName("android.widget.Switch");
                }
                obtain2.setSelected(iVar.g(3));
                if (i13 >= 36 && iVar.g(27)) {
                    if (!iVar.g(28)) {
                        i10 = 1;
                    }
                    obtain2.setExpandedState(i10);
                    if (i.a(iVar, g.EXPAND)) {
                        obtain2.addAction(262144);
                    }
                    if (i.a(iVar, g.COLLAPSE)) {
                        obtain2.addAction(524288);
                    }
                }
                if (i13 >= 28) {
                    if (iVar.f4458C > 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    obtain2.setHeading(z6);
                }
                i iVar9 = this.f4517i;
                if (iVar9 != null && iVar9.f4483b == i4) {
                    obtain2.addAction(128);
                } else {
                    obtain2.addAction(64);
                }
                ArrayList arrayList2 = iVar.f4476V;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i14 = 0;
                    while (i14 < size) {
                        Object obj4 = arrayList2.get(i14);
                        i14++;
                        h hVar = (h) obj4;
                        obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(hVar.f4451a, hVar.f4454d));
                    }
                }
                ArrayList arrayList3 = iVar.f4474T;
                int size2 = arrayList3.size();
                int i15 = 0;
                while (i15 < size2) {
                    Object obj5 = arrayList3.get(i15);
                    i15++;
                    i iVar10 = (i) obj5;
                    if (!iVar10.g(14)) {
                        int i16 = iVar10.f4492i;
                        if (i16 != -1) {
                            View l4 = lVar.l(i16);
                            if (!lVar.g(iVar10.f4492i) && l4 != null) {
                                l4.setImportantForAccessibility(0);
                                obtain2.addChild(l4);
                            }
                        }
                        obtain2.addChild(view, iVar10.f4483b);
                    }
                }
                return obtain2;
            }
        }
        return null;
    }

    public final AccessibilityEvent e(int i4, int i5) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i5);
        View view = this.f4509a;
        obtain.setPackageName(view.getContext().getPackageName());
        obtain.setSource(view, i4);
        return obtain;
    }

    public final boolean f(MotionEvent motionEvent, boolean z) {
        i h3;
        if (this.f4511c.isTouchExplorationEnabled()) {
            HashMap hashMap = this.f4515g;
            if (!hashMap.isEmpty()) {
                i h4 = ((i) hashMap.get(0)).h(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z);
                if (h4 != null && h4.f4492i != -1) {
                    if (!z) {
                        return this.f4512d.onAccessibilityHoverEvent(h4.f4483b, motionEvent);
                    }
                } else {
                    if (motionEvent.getAction() != 9 && motionEvent.getAction() != 7) {
                        if (motionEvent.getAction() == 10) {
                            i iVar = this.f4523p;
                            if (iVar != null) {
                                h(iVar.f4483b, 256);
                                this.f4523p = null;
                            }
                        } else {
                            motionEvent.toString();
                            return false;
                        }
                    } else {
                        float x3 = motionEvent.getX();
                        float y3 = motionEvent.getY();
                        if (!hashMap.isEmpty() && (h3 = ((i) hashMap.get(0)).h(new float[]{x3, y3, 0.0f, 1.0f}, z)) != this.f4523p) {
                            if (h3 != null) {
                                h(h3.f4483b, 128);
                            }
                            i iVar2 = this.f4523p;
                            if (iVar2 != null) {
                                h(iVar2.f4483b, 256);
                            }
                            this.f4523p = h3;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
        } else {
            i iVar = this.f4521n;
            if (iVar != null) {
                return createAccessibilityNodeInfo(iVar.f4483b);
            }
            Integer num = this.k;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        }
        i iVar2 = this.f4517i;
        if (iVar2 != null) {
            return createAccessibilityNodeInfo(iVar2.f4483b);
        }
        Integer num2 = this.f4518j;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public final boolean g(i iVar, int i4, Bundle bundle, boolean z) {
        int i5;
        int i6 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z3 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i7 = iVar.f4490g;
        int i8 = iVar.f4491h;
        if (i8 >= 0 && i7 >= 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 4) {
                        if (i6 == 8 || i6 == 16) {
                            if (z) {
                                iVar.f4491h = iVar.f4500r.length();
                            } else {
                                iVar.f4491h = 0;
                            }
                        }
                    } else if (z && i8 < iVar.f4500r.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(iVar.f4500r.substring(iVar.f4491h));
                        if (matcher.find()) {
                            iVar.f4491h += matcher.start(1);
                        } else {
                            iVar.f4491h = iVar.f4500r.length();
                        }
                    } else if (!z && iVar.f4491h > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(iVar.f4500r.substring(0, iVar.f4491h));
                        if (matcher2.find()) {
                            iVar.f4491h = matcher2.start(1);
                        } else {
                            iVar.f4491h = 0;
                        }
                    }
                } else if (z && i8 < iVar.f4500r.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(iVar.f4500r.substring(iVar.f4491h));
                    matcher3.find();
                    if (matcher3.find()) {
                        iVar.f4491h += matcher3.start(1);
                    } else {
                        iVar.f4491h = iVar.f4500r.length();
                    }
                } else if (!z && iVar.f4491h > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(iVar.f4500r.substring(0, iVar.f4491h));
                    if (matcher4.find()) {
                        iVar.f4491h = matcher4.start(1);
                    }
                }
            } else if (z && i8 < iVar.f4500r.length()) {
                iVar.f4491h++;
            } else if (!z && (i5 = iVar.f4491h) > 0) {
                iVar.f4491h = i5 - 1;
            }
            if (!z3) {
                iVar.f4490g = iVar.f4491h;
            }
        }
        if (i7 != iVar.f4490g || i8 != iVar.f4491h) {
            String str = iVar.f4500r;
            if (str == null) {
                str = "";
            }
            AccessibilityEvent e4 = e(iVar.f4483b, 8192);
            e4.getText().add(str);
            e4.setFromIndex(iVar.f4490g);
            e4.setToIndex(iVar.f4491h);
            e4.setItemCount(str.length());
            i(e4);
        }
        A2.t tVar = this.f4510b;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 4 || i6 == 8 || i6 == 16) {
                    return true;
                }
            } else {
                if (z) {
                    g gVar = g.MOVE_CURSOR_FORWARD_BY_WORD;
                    if (i.a(iVar, gVar)) {
                        tVar.A(i4, gVar, Boolean.valueOf(z3));
                        return true;
                    }
                }
                if (!z) {
                    g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
                    if (i.a(iVar, gVar2)) {
                        tVar.A(i4, gVar2, Boolean.valueOf(z3));
                        return true;
                    }
                }
            }
        } else {
            if (z) {
                g gVar3 = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (i.a(iVar, gVar3)) {
                    tVar.A(i4, gVar3, Boolean.valueOf(z3));
                    return true;
                }
            }
            if (!z) {
                g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
                if (i.a(iVar, gVar4)) {
                    tVar.A(i4, gVar4, Boolean.valueOf(z3));
                    return true;
                }
            }
        }
        return false;
    }

    public final void h(int i4, int i5) {
        if (!this.f4511c.isEnabled()) {
            return;
        }
        i(e(i4, i5));
    }

    public final void i(AccessibilityEvent accessibilityEvent) {
        if (!this.f4511c.isEnabled()) {
            return;
        }
        View view = this.f4509a;
        view.getParent().requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public final void j(boolean z) {
        if (this.f4527t == z) {
            return;
        }
        this.f4527t = z;
        if (z) {
            this.f4519l |= 1;
        } else {
            this.f4519l &= -2;
        }
        ((FlutterJNI) this.f4510b.f100h).setAccessibilityFeatures(this.f4519l);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.flutter.view.c, java.lang.Object] */
    public final boolean k(i iVar) {
        boolean z;
        if (iVar.f4493j > 1) {
            i iVar2 = this.f4517i;
            i iVar3 = null;
            if (iVar2 != null) {
                i iVar4 = iVar2.f4473S;
                while (true) {
                    if (iVar4 != null) {
                        if (iVar4 == iVar) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            break;
                        }
                        iVar4 = iVar4.f4473S;
                    } else {
                        iVar4 = null;
                        break;
                    }
                }
                if (iVar4 != null) {
                    return true;
                }
            }
            i iVar5 = this.f4517i;
            ?? obj = new Object();
            if (iVar5 != null) {
                i iVar6 = iVar5.f4473S;
                while (true) {
                    if (iVar6 == null) {
                        break;
                    }
                    if (obj.test(iVar6)) {
                        iVar3 = iVar6;
                        break;
                    }
                    iVar6 = iVar6.f4473S;
                }
                if (iVar3 != null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i4, int i5, Bundle bundle) {
        String str;
        if (i4 >= 65536) {
            boolean performAction = this.f4512d.performAction(i4, i5, bundle);
            if (performAction && i5 == 128) {
                this.f4518j = null;
            }
            return performAction;
        }
        Integer valueOf = Integer.valueOf(i4);
        HashMap hashMap = this.f4515g;
        i iVar = (i) hashMap.get(valueOf);
        if (iVar != null) {
            g gVar = g.INCREASE;
            g gVar2 = g.DECREASE;
            A2.t tVar = this.f4510b;
            switch (i5) {
                case 16:
                    tVar.z(i4, g.TAP);
                    return true;
                case 32:
                    tVar.z(i4, g.LONG_PRESS);
                    return true;
                case 64:
                    if (this.f4517i == null) {
                        this.f4509a.invalidate();
                    }
                    this.f4517i = iVar;
                    tVar.z(i4, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("type", "didGainFocus");
                    hashMap2.put("nodeId", Integer.valueOf(iVar.f4483b));
                    ((y) tVar.f99g).v(hashMap2, null);
                    h(i4, 32768);
                    if (!i.a(iVar, gVar) && !i.a(iVar, gVar2)) {
                        return true;
                    }
                    h(i4, 4);
                    return true;
                case 128:
                    i iVar2 = this.f4517i;
                    if (iVar2 != null && iVar2.f4483b == i4) {
                        this.f4517i = null;
                    }
                    Integer num = this.f4518j;
                    if (num != null && num.intValue() == i4) {
                        this.f4518j = null;
                    }
                    tVar.z(i4, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                    h(i4, 65536);
                    return true;
                case 256:
                    return g(iVar, i4, bundle, true);
                case 512:
                    return g(iVar, i4, bundle, false);
                case 4096:
                    g gVar3 = g.SCROLL_UP;
                    if (i.a(iVar, gVar3)) {
                        tVar.z(i4, gVar3);
                        return true;
                    }
                    g gVar4 = g.SCROLL_LEFT;
                    if (i.a(iVar, gVar4)) {
                        tVar.z(i4, gVar4);
                        return true;
                    }
                    if (i.a(iVar, gVar)) {
                        iVar.f4500r = iVar.f4502t;
                        iVar.f4501s = iVar.f4503u;
                        h(i4, 4);
                        tVar.z(i4, gVar);
                        return true;
                    }
                    break;
                case 8192:
                    g gVar5 = g.SCROLL_DOWN;
                    if (i.a(iVar, gVar5)) {
                        tVar.z(i4, gVar5);
                        return true;
                    }
                    g gVar6 = g.SCROLL_RIGHT;
                    if (i.a(iVar, gVar6)) {
                        tVar.z(i4, gVar6);
                        return true;
                    }
                    if (i.a(iVar, gVar2)) {
                        iVar.f4500r = iVar.f4504v;
                        iVar.f4501s = iVar.f4505w;
                        h(i4, 4);
                        tVar.z(i4, gVar2);
                        return true;
                    }
                    break;
                case 16384:
                    tVar.z(i4, g.COPY);
                    return true;
                case 32768:
                    tVar.z(i4, g.PASTE);
                    return true;
                case 65536:
                    tVar.z(i4, g.CUT);
                    return true;
                case 131072:
                    HashMap hashMap3 = new HashMap();
                    if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                        hashMap3.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                        hashMap3.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                    } else {
                        hashMap3.put("base", Integer.valueOf(iVar.f4491h));
                        hashMap3.put("extent", Integer.valueOf(iVar.f4491h));
                    }
                    tVar.A(i4, g.SET_SELECTION, hashMap3);
                    i iVar3 = (i) hashMap.get(Integer.valueOf(i4));
                    iVar3.f4490g = ((Integer) hashMap3.get("base")).intValue();
                    iVar3.f4491h = ((Integer) hashMap3.get("extent")).intValue();
                    return true;
                case 262144:
                    tVar.z(i4, g.EXPAND);
                    return true;
                case 524288:
                    tVar.z(i4, g.COLLAPSE);
                    return true;
                case 1048576:
                    tVar.z(i4, g.DISMISS);
                    return true;
                case 2097152:
                    if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) {
                        str = bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                    } else {
                        str = "";
                    }
                    tVar.A(i4, g.SET_TEXT, str);
                    iVar.f4500r = str;
                    iVar.f4501s = null;
                    return true;
                case R.id.accessibilityActionShowOnScreen:
                    tVar.z(i4, g.SHOW_ON_SCREEN);
                    return true;
                default:
                    h hVar = (h) this.f4516h.get(Integer.valueOf(i5 - 267386881));
                    if (hVar != null) {
                        tVar.A(i4, g.CUSTOM_ACTION, Integer.valueOf(hVar.f4452b));
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
