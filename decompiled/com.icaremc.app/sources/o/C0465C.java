package o;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import i.AbstractC0357a;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: o.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0465C {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f5420d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5421a = 2;

    /* renamed from: b, reason: collision with root package name */
    public View f5422b;

    /* renamed from: c, reason: collision with root package name */
    public Object f5423c;

    public /* synthetic */ C0465C() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (!(keyListener instanceof NumberKeyListener)) {
            ((E0.a) ((R1.c) this.f5423c).f1532g).getClass();
            if (keyListener instanceof V.e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new V.e(keyListener);
        }
        return keyListener;
    }

    public void b(AttributeSet attributeSet, int i4) {
        switch (this.f5421a) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f5422b;
                A2.t P = A2.t.P(absSeekBar.getContext(), attributeSet, f5420d, i4);
                Drawable I3 = P.I(0);
                if (I3 != null) {
                    if (I3 instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) I3;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i5 = 0; i5 < numberOfFrames; i5++) {
                            Drawable e4 = e(animationDrawable.getFrame(i5), true);
                            e4.setLevel(10000);
                            animationDrawable2.addFrame(e4, animationDrawable.getDuration(i5));
                        }
                        animationDrawable2.setLevel(10000);
                        I3 = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(I3);
                }
                Drawable I4 = P.I(1);
                if (I4 != null) {
                    absSeekBar.setProgressDrawable(e(I4, false));
                }
                P.T();
                return;
            default:
                TypedArray obtainStyledAttributes = ((EditText) this.f5422b).getContext().obtainStyledAttributes(attributeSet, AbstractC0357a.f4074i, i4, 0);
                try {
                    boolean z = true;
                    if (obtainStyledAttributes.hasValue(14)) {
                        z = obtainStyledAttributes.getBoolean(14, true);
                    }
                    obtainStyledAttributes.recycle();
                    d(z);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public V.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        R1.c cVar = (R1.c) this.f5423c;
        if (inputConnection == null) {
            cVar.getClass();
            inputConnection = null;
        } else {
            E0.a aVar = (E0.a) cVar.f1532g;
            aVar.getClass();
            if (!(inputConnection instanceof V.b)) {
                inputConnection = new V.b((EditText) aVar.f459g, inputConnection, editorInfo);
            }
        }
        return (V.b) inputConnection;
    }

    public void d(boolean z) {
        V.i iVar = (V.i) ((E0.a) ((R1.c) this.f5423c).f1532g).f460h;
        if (iVar.f1670h != z) {
            if (iVar.f1669g != null) {
                T.k a4 = T.k.a();
                V.h hVar = iVar.f1669g;
                a4.getClass();
                android.support.v4.media.session.a.h(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = a4.f1557a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    a4.f1558b.remove(hVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            iVar.f1670h = z;
            if (z) {
                V.i.a(iVar.f1668f, T.k.a().b());
            }
        }
    }

    public Drawable e(Drawable drawable, boolean z) {
        boolean z3;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i4 = 0; i4 < numberOfLayers; i4++) {
                int id = layerDrawable.getId(i4);
                Drawable drawable2 = layerDrawable.getDrawable(i4);
                if (id != 16908301 && id != 16908303) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                drawableArr[i4] = e(drawable2, z3);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i5 = 0; i5 < numberOfLayers; i5++) {
                layerDrawable2.setId(i5, layerDrawable.getId(i5));
                layerDrawable2.setLayerGravity(i5, layerDrawable.getLayerGravity(i5));
                layerDrawable2.setLayerWidth(i5, layerDrawable.getLayerWidth(i5));
                layerDrawable2.setLayerHeight(i5, layerDrawable.getLayerHeight(i5));
                layerDrawable2.setLayerInsetLeft(i5, layerDrawable.getLayerInsetLeft(i5));
                layerDrawable2.setLayerInsetRight(i5, layerDrawable.getLayerInsetRight(i5));
                layerDrawable2.setLayerInsetTop(i5, layerDrawable.getLayerInsetTop(i5));
                layerDrawable2.setLayerInsetBottom(i5, layerDrawable.getLayerInsetBottom(i5));
                layerDrawable2.setLayerInsetStart(i5, layerDrawable.getLayerInsetStart(i5));
                layerDrawable2.setLayerInsetEnd(i5, layerDrawable.getLayerInsetEnd(i5));
            }
            return layerDrawable2;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.f5423c) == null) {
                this.f5423c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
        return drawable;
    }

    public C0465C(AbsSeekBar absSeekBar) {
        this.f5422b = absSeekBar;
    }

    public C0465C(EditText editText) {
        this.f5422b = editText;
        this.f5423c = new R1.c(editText);
    }
}
