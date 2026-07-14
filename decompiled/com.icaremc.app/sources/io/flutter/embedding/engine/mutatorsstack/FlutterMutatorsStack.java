package io.flutter.embedding.engine.mutatorsstack;

import H1.f;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class FlutterMutatorsStack {
    private List<f> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();
    private float finalOpacity = 1.0f;

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public float getFinalOpacity() {
        return this.finalOpacity;
    }

    public List<f> getMutators() {
        return this.mutators;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pushClipPath(Path path) {
        this.mutators.add(new Object());
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pushClipRRect(int i4, int i5, int i6, int i7, float[] fArr) {
        Rect rect = new Rect(i4, i5, i6, i7);
        this.mutators.add(new Object());
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pushClipRect(int i4, int i5, int i6, int i7) {
        Rect rect = new Rect(i4, i5, i6, i7);
        this.mutators.add(new Object());
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pushOpacity(float f4) {
        this.mutators.add(new Object());
        this.finalOpacity *= f4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        this.mutators.add(new Object());
        this.finalMatrix.preConcat(matrix);
    }
}
