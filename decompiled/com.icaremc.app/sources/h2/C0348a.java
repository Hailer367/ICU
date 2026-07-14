package h2;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/* renamed from: h2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0348a {

    /* renamed from: f, reason: collision with root package name */
    public static final Matrix f3965f = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.j f3966a;

    /* renamed from: b, reason: collision with root package name */
    public final E0.a f3967b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3968c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f3969d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public int f3970e;

    public C0348a(io.flutter.embedding.engine.renderer.j jVar, boolean z) {
        this.f3966a = jVar;
        if (E0.a.f457i == null) {
            E0.a.f457i = new E0.a(28);
        }
        this.f3967b = E0.a.f457i;
        this.f3968c = z;
    }

    public static int b(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 5) {
                    return 4;
                }
                if (i4 != 6) {
                    if (i4 == 2) {
                        return 5;
                    }
                    if (i4 != 7) {
                        if (i4 == 3) {
                            return 0;
                        }
                        if (i4 != 8) {
                            return -1;
                        }
                    }
                    return 3;
                }
            }
            return 6;
        }
        return 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
    
        if (r11 == (-1)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.MotionEvent r29, int r30, int r31, int r32, android.graphics.Matrix r33, java.nio.ByteBuffer r34, android.content.Context r35) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C0348a.a(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer, android.content.Context):void");
    }

    public final int c(Context context) {
        if (this.f3970e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.f3970e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3970e;
    }

    public final void d(MotionEvent motionEvent, Matrix matrix) {
        boolean z;
        boolean z3;
        int i4;
        int actionMasked = motionEvent.getActionMasked();
        int b4 = b(motionEvent.getActionMasked());
        char c4 = 5;
        if (actionMasked != 0 && actionMasked != 5) {
            z = false;
        } else {
            z = true;
        }
        if (!z && (actionMasked == 1 || actionMasked == 6)) {
            z3 = true;
        } else {
            z3 = false;
        }
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        if (toolType != 1) {
            if (toolType != 2) {
                if (toolType != 3) {
                    if (toolType == 4) {
                        c4 = 3;
                    }
                } else {
                    c4 = 1;
                }
            } else {
                c4 = 2;
            }
        } else {
            c4 = 0;
        }
        if (z3 && c4 == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((pointerCount + i4) * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z) {
            a(motionEvent, motionEvent.getActionIndex(), b4, 0, matrix, allocateDirect, null);
        } else if (z3) {
            for (int i5 = 0; i5 < pointerCount; i5++) {
                if (i5 != motionEvent.getActionIndex() && motionEvent.getToolType(i5) == 1) {
                    a(motionEvent, i5, 5, 1, matrix, allocateDirect, null);
                }
            }
            a(motionEvent, motionEvent.getActionIndex(), b4, 0, matrix, allocateDirect, null);
            if (i4 != 0) {
                a(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, allocateDirect, null);
            }
        } else {
            for (int i6 = 0; i6 < pointerCount; i6++) {
                a(motionEvent, i6, b4, (pointerCount << 8) | 2, matrix, allocateDirect, null);
            }
        }
        if (allocateDirect.position() % 288 == 0) {
            this.f3966a.f4233a.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return;
        }
        throw new AssertionError("Packet position is not on field boundary");
    }
}
