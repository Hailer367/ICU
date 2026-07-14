package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import io.flutter.BuildConfig;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = BuildConfig.RELEASE)
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zad();
    private static final Builder zak = new zab(new String[0], null);

    @SafeParcelable.VersionField(id = 1000)
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    boolean zae;

    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] zaf;

    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zag;

    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int zah;

    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    private final Bundle zai;
    private boolean zaj;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder {
        private final String[] zaa;
        private final ArrayList zab = new ArrayList();
        private final HashMap zac = new HashMap();

        public /* synthetic */ Builder(String[] strArr, String str, byte[] bArr) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @KeepForSdk
        public DataHolder build(int i2) {
            return new DataHolder(this, i2, (Bundle) null, (byte[]) (0 == true ? 1 : 0));
        }

        @KeepForSdk
        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        public Builder zaa(HashMap hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }

        public final /* synthetic */ String[] zab() {
            return this.zaa;
        }

        public final /* synthetic */ ArrayList zac() {
            return this.zab;
        }

        @KeepForSdk
        public DataHolder build(int i2, Bundle bundle) {
            return new DataHolder(this, i2, bundle, -1, (byte[]) null);
        }
    }

    public /* synthetic */ DataHolder(Builder builder, int i2, Bundle bundle, byte[] bArr) {
        this(builder, i2, (Bundle) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @KeepForSdk
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, null, 0 == true ? 1 : 0);
    }

    @KeepForSdk
    public static DataHolder empty(int i2) {
        return new DataHolder(zak, i2, (Bundle) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x013f, code lost:
    
        r0 = r0.toString();
        r5 = new java.lang.StringBuilder((java.lang.String.valueOf(r15).length() + 32) + r0.length());
        r5.append("Unsupported object for column ");
        r5.append(r15);
        r5.append(": ");
        r5.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x016c, code lost:
    
        throw new java.lang.IllegalArgumentException(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0181, code lost:
    
        if (r12 != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0183, code lost:
    
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r11).length() + 63);
        r5.append("Couldn't populate window data for row ");
        r5.append(r11);
        r5.append(" - allocating new window.");
        android.util.Log.d("DataHolder", r5.toString());
        r9.freeLastRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a7, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01a8, code lost:
    
        r0 = new android.database.CursorWindow(false);
        r0.setStartPosition(r11);
        r0.setNumColumns(r21.zab().length);
        r10.add(r0);
        r11 = r11 - 1;
        r9 = r0;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01be, code lost:
    
        r11 = r11 + 1;
        r7 = r5;
        r0 = r18;
        r5 = r19;
        r6 = r20;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01d4, code lost:
    
        r1 = r10.size();
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01db, code lost:
    
        ((android.database.CursorWindow) r10.get(r7)).close();
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01e7, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01cb, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01d3, code lost:
    
        throw new com.google.android.gms.common.data.zac("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.database.CursorWindow] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.CursorWindow[] zae(com.google.android.gms.common.data.DataHolder.Builder r21, int r22) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.zae(com.google.android.gms.common.data.DataHolder$Builder, int):android.database.CursorWindow[]");
    }

    private final void zaf(String str, int i2) {
        Bundle bundle = this.zab;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i2 >= 0 && i2 < this.zad) {
                    return;
                } else {
                    throw new CursorIndexOutOfBoundsException(i2, this.zad);
                }
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public void close() {
        synchronized (this) {
            try {
                if (!this.zae) {
                    this.zae = true;
                    int i2 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.zag;
                        if (i2 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i2].close();
                        i2++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() {
        try {
            if (this.zaj && this.zag.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public boolean getBoolean(String str, int i2, int i3) {
        zaf(str, i2);
        if (this.zag[i3].getLong(i2, this.zab.getInt(str)) == 1) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public byte[] getByteArray(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].getBlob(i2, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getCount() {
        return this.zad;
    }

    @KeepForSdk
    public int getInteger(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].getInt(i2, this.zab.getInt(str));
    }

    @KeepForSdk
    public long getLong(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].getLong(i2, this.zab.getInt(str));
    }

    @KeepForSdk
    public Bundle getMetadata() {
        return this.zai;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.zah;
    }

    @KeepForSdk
    public String getString(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].getString(i2, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getWindowIndex(int i2) {
        boolean z;
        int length;
        int i3 = 0;
        if (i2 >= 0 && i2 < this.zad) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i3 >= length) {
                break;
            }
            if (i2 < iArr[i3]) {
                i3--;
                break;
            }
            i3++;
        }
        if (i3 == length) {
            return i3 - 1;
        }
        return i3;
    }

    @KeepForSdk
    public boolean hasColumn(String str) {
        return this.zab.containsKey(str);
    }

    @KeepForSdk
    public boolean hasNull(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].isNull(i2, this.zab.getInt(str));
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.zae;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        String[] strArr = this.zaf;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, strArr, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zag, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    public final void zaa() {
        this.zab = new Bundle();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zaf;
            if (i2 >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i2], i2);
            i2++;
        }
        CursorWindow[] cursorWindowArr = this.zag;
        this.zac = new int[cursorWindowArr.length];
        int i3 = 0;
        for (int i4 = 0; i4 < cursorWindowArr.length; i4++) {
            this.zac[i4] = i3;
            i3 += cursorWindowArr[i4].getNumRows() - (i3 - cursorWindowArr[i4].getStartPosition());
        }
        this.zad = i3;
    }

    public final float zab(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].getFloat(i2, this.zab.getInt(str));
    }

    public final double zac(String str, int i2, int i3) {
        zaf(str, i2);
        return this.zag[i3].getDouble(i2, this.zab.getInt(str));
    }

    public final void zad(String str, int i2, int i3, CharArrayBuffer charArrayBuffer) {
        zaf(str, i2);
        this.zag[i3].copyStringToBuffer(i2, this.zab.getInt(str), charArrayBuffer);
    }

    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.zae = false;
        this.zaj = true;
        this.zaa = i2;
        this.zaf = strArr;
        this.zag = cursorWindowArr;
        this.zah = i3;
        this.zai = bundle;
    }

    @KeepForSdk
    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.zae = false;
        this.zaj = true;
        this.zaa = 1;
        this.zaf = (String[]) Preconditions.checkNotNull(strArr);
        this.zag = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zah = i2;
        this.zai = bundle;
        zaa();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DataHolder(android.database.Cursor r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L2e
            android.database.CursorWindow r3 = r0.getWindow()     // Catch: java.lang.Throwable -> L2e
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L30
            int r6 = r3.getStartPosition()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L30
            r3.acquireReference()     // Catch: java.lang.Throwable -> L2e
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L2e
            r1.add(r3)     // Catch: java.lang.Throwable -> L2e
            int r3 = r3.getNumRows()     // Catch: java.lang.Throwable -> L2e
            goto L31
        L2e:
            r8 = move-exception
            goto L78
        L30:
            r3 = r5
        L31:
            if (r3 >= r2) goto L65
            boolean r6 = r0.moveToPosition(r3)     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L65
            android.database.CursorWindow r6 = r0.getWindow()     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L46
            r6.acquireReference()     // Catch: java.lang.Throwable -> L2e
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L2e
            goto L51
        L46:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch: java.lang.Throwable -> L2e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            r6.setStartPosition(r3)     // Catch: java.lang.Throwable -> L2e
            r0.fillWindow(r3, r6)     // Catch: java.lang.Throwable -> L2e
        L51:
            int r3 = r6.getNumRows()     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L58
            goto L65
        L58:
            r1.add(r6)     // Catch: java.lang.Throwable -> L2e
            int r3 = r6.getStartPosition()     // Catch: java.lang.Throwable -> L2e
            int r6 = r6.getNumRows()     // Catch: java.lang.Throwable -> L2e
            int r3 = r3 + r6
            goto L31
        L65:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>(r8, r0, r9, r10)
            return
        L78:
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i2, Bundle bundle) {
        this(builder.zab(), zae(builder, -1), i2, (Bundle) null);
    }

    public /* synthetic */ DataHolder(Builder builder, int i2, Bundle bundle, int i3, byte[] bArr) {
        this(builder.zab(), zae(builder, -1), i2, bundle);
    }
}
