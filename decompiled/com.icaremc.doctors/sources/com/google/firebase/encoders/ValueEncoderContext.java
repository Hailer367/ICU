package com.google.firebase.encoders;

/* loaded from: classes.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d2);

    ValueEncoderContext add(float f2);

    ValueEncoderContext add(int i2);

    ValueEncoderContext add(long j2);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z);

    ValueEncoderContext add(byte[] bArr);
}
