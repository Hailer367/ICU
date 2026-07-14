package io.flutter.embedding.engine.image;

import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import io.flutter.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaMetadataReader {
    private static final String TAG = "MediaMetadataReader";

    private static MediaExtractor getMediaExtractor(final byte[] bArr) {
        MediaDataSource mediaDataSource = new MediaDataSource() { // from class: io.flutter.embedding.engine.image.MediaMetadataReader.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return bArr.length;
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr2, int i2, int i3) {
                byte[] bArr3 = bArr;
                if (j2 >= bArr3.length) {
                    return -1;
                }
                if (i3 + j2 > bArr3.length) {
                    i3 = (int) (bArr3.length - j2);
                }
                System.arraycopy(bArr3, (int) j2, bArr2, i2, i3);
                return i3;
            }
        };
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(mediaDataSource);
        return mediaExtractor;
    }

    public static void read(byte[] bArr, Metadata metadata) {
        try {
            read(bArr, metadata, getMediaExtractor(bArr));
        } catch (Exception e2) {
            Log.e(TAG, "Failed to decode HEIF image using MediaExtractor", e2);
        }
    }

    public static void read(byte[] bArr, Metadata metadata, MediaExtractor mediaExtractor) {
        try {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string != null && string.startsWith("image/")) {
                    int integer = trackFormat.containsKey("rotation-degrees") ? trackFormat.getInteger("rotation-degrees") : 0;
                    int i3 = metadata.originalWidth;
                    int i4 = metadata.originalHeight;
                    if (integer != 90 && integer != 270) {
                        i4 = i3;
                        i3 = i4;
                    }
                    metadata.height = i3;
                    metadata.width = i4;
                    metadata.rotation = integer;
                    return;
                }
            }
        } catch (Exception e2) {
            Log.e(TAG, "Failed to decode HEIF image using MediaExtractor", e2);
        }
    }
}
