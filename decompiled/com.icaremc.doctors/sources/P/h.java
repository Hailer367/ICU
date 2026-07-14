package P;

import a.AbstractC0051a;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import com.google.firebase.encoders.json.BuildConfig;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: A, reason: collision with root package name */
    public static final byte[] f657A;

    /* renamed from: B, reason: collision with root package name */
    public static final byte[] f658B;

    /* renamed from: C, reason: collision with root package name */
    public static final byte[] f659C;

    /* renamed from: D, reason: collision with root package name */
    public static final byte[] f660D;

    /* renamed from: E, reason: collision with root package name */
    public static final byte[] f661E;

    /* renamed from: F, reason: collision with root package name */
    public static final byte[] f662F;

    /* renamed from: G, reason: collision with root package name */
    public static final byte[] f663G;

    /* renamed from: H, reason: collision with root package name */
    public static final byte[] f664H;

    /* renamed from: I, reason: collision with root package name */
    public static final byte[] f665I;

    /* renamed from: J, reason: collision with root package name */
    public static final byte[] f666J;

    /* renamed from: K, reason: collision with root package name */
    public static final byte[] f667K;
    public static final byte[] L;

    /* renamed from: M, reason: collision with root package name */
    public static final byte[] f668M;

    /* renamed from: N, reason: collision with root package name */
    public static final byte[] f669N;

    /* renamed from: O, reason: collision with root package name */
    public static final byte[] f670O;

    /* renamed from: P, reason: collision with root package name */
    public static final byte[] f671P;

    /* renamed from: Q, reason: collision with root package name */
    public static final String[] f672Q;

    /* renamed from: R, reason: collision with root package name */
    public static final int[] f673R;

    /* renamed from: S, reason: collision with root package name */
    public static final byte[] f674S;

    /* renamed from: T, reason: collision with root package name */
    public static final e f675T;

    /* renamed from: U, reason: collision with root package name */
    public static final e[][] f676U;

    /* renamed from: V, reason: collision with root package name */
    public static final e[] f677V;

    /* renamed from: W, reason: collision with root package name */
    public static final HashMap[] f678W;

    /* renamed from: X, reason: collision with root package name */
    public static final HashMap[] f679X;

    /* renamed from: Y, reason: collision with root package name */
    public static final Set f680Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final HashMap f681Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final Charset f682a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final byte[] f683b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final byte[] f684c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final Pattern f685d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final Pattern f686e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final Pattern f687f0;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f688u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f689v;

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f690w;

    /* renamed from: x, reason: collision with root package name */
    public static final byte[] f691x;
    public static final byte[] y;
    public static final byte[] z;

    /* renamed from: a, reason: collision with root package name */
    public final String f692a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDescriptor f693b;

    /* renamed from: c, reason: collision with root package name */
    public int f694c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f695d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap[] f696e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f697f;

    /* renamed from: g, reason: collision with root package name */
    public ByteOrder f698g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f699h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f700i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f701j;

    /* renamed from: k, reason: collision with root package name */
    public int f702k;

    /* renamed from: l, reason: collision with root package name */
    public int f703l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f704m;

    /* renamed from: n, reason: collision with root package name */
    public int f705n;

    /* renamed from: o, reason: collision with root package name */
    public int f706o;
    public int p;
    public int q;

    /* renamed from: r, reason: collision with root package name */
    public int f707r;

    /* renamed from: s, reason: collision with root package name */
    public d f708s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f709t;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f689v = new int[]{8, 8, 8};
        f690w = new int[]{8};
        f691x = new byte[]{-1, -40, -1};
        y = new byte[]{102, 116, 121, 112};
        z = new byte[]{109, 105, 102, 49};
        f657A = new byte[]{104, 101, 105, 99};
        f658B = new byte[]{97, 118, 105, 102};
        f659C = new byte[]{97, 118, 105, 115};
        f660D = new byte[]{79, 76, 89, 77, 80, 0};
        f661E = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f662F = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f663G = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);
        f664H = new byte[]{82, 73, 70, 70};
        f665I = new byte[]{87, 69, 66, 80};
        f666J = new byte[]{69, 88, 73, 70};
        f667K = new byte[]{-99, 1, 42};
        L = "VP8X".getBytes(Charset.defaultCharset());
        f668M = "VP8L".getBytes(Charset.defaultCharset());
        f669N = "VP8 ".getBytes(Charset.defaultCharset());
        f670O = "ANIM".getBytes(Charset.defaultCharset());
        f671P = "ANMF".getBytes(Charset.defaultCharset());
        f672Q = new String[]{BuildConfig.FLAVOR, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f673R = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f674S = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(256, 3, 4, "ImageWidth"), new e(257, 3, 4, "ImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e(40962, 3, 4, "PixelXDimension"), new e(40963, 3, 4, "PixelYDimension"), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e(2, 5, 10, "GPSLatitude"), new e("GPSLongitudeRef", 3, 2), new e(4, 5, 10, "GPSLongitude"), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(256, 3, 4, "ThumbnailImageWidth"), new e(257, 3, 4, "ThumbnailImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        f675T = new e("StripOffsets", 273, 3);
        f676U = new e[][]{eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, new e[]{new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)}, new e[]{new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)}, new e[]{new e("AspectFrame", 4371, 3)}, new e[]{new e("ColorSpace", 55, 3)}};
        f677V = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f678W = new HashMap[10];
        f679X = new HashMap[10];
        f680Y = Collections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        f681Z = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        f682a0 = forName;
        f683b0 = "Exif\u0000\u0000".getBytes(forName);
        f684c0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            e[][] eVarArr6 = f676U;
            if (i2 < eVarArr6.length) {
                f678W[i2] = new HashMap();
                f679X[i2] = new HashMap();
                for (e eVar : eVarArr6[i2]) {
                    f678W[i2].put(Integer.valueOf(eVar.f651a), eVar);
                    f679X[i2].put(eVar.f652b, eVar);
                }
                i2++;
            } else {
                HashMap hashMap = f681Z;
                e[] eVarArr7 = f677V;
                hashMap.put(Integer.valueOf(eVarArr7[0].f651a), 5);
                hashMap.put(Integer.valueOf(eVarArr7[1].f651a), 1);
                hashMap.put(Integer.valueOf(eVarArr7[2].f651a), 2);
                hashMap.put(Integer.valueOf(eVarArr7[3].f651a), 3);
                hashMap.put(Integer.valueOf(eVarArr7[4].f651a), 7);
                hashMap.put(Integer.valueOf(eVarArr7[5].f651a), 8);
                Pattern.compile(".*[1-9].*");
                f685d0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f686e0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f687f0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public h(String str) {
        boolean z2;
        e[][] eVarArr = f676U;
        this.f696e = new HashMap[eVarArr.length];
        this.f697f = new HashSet(eVarArr.length);
        this.f698g = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            this.f692a = str;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        Os.lseek(fileInputStream2.getFD(), 0L, OsConstants.SEEK_CUR);
                        z2 = true;
                    } catch (Exception unused) {
                        if (f688u) {
                            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                        }
                        z2 = false;
                    }
                    if (z2) {
                        this.f693b = fileInputStream2.getFD();
                    } else {
                        this.f693b = null;
                    }
                    r(fileInputStream2);
                    AbstractC0051a.e(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    AbstractC0051a.e(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    public static Pair o(String str) {
        int intValue;
        int i2;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair o2 = o(split[0]);
            if (((Integer) o2.first).intValue() == 2) {
                return o2;
            }
            for (int i3 = 1; i3 < split.length; i3++) {
                Pair o3 = o(split[i3]);
                if (!((Integer) o3.first).equals(o2.first) && !((Integer) o3.second).equals(o2.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) o2.first).intValue();
                }
                if (((Integer) o2.second).intValue() != -1 && (((Integer) o3.first).equals(o2.second) || ((Integer) o3.second).equals(o2.second))) {
                    i2 = ((Integer) o2.second).intValue();
                } else {
                    i2 = -1;
                }
                if (intValue == -1 && i2 == -1) {
                    return new Pair(2, -1);
                }
                if (intValue == -1) {
                    o2 = new Pair(Integer.valueOf(i2), -1);
                } else if (i2 == -1) {
                    o2 = new Pair(Integer.valueOf(intValue), -1);
                }
            }
            return o2;
        }
        if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair(10, 5);
                        }
                        return new Pair(5, -1);
                    }
                    return new Pair(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair(2, -1);
        }
        try {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong >= 0 && parseLong <= 65535) {
                    return new Pair(3, 4);
                }
                if (parseLong < 0) {
                    return new Pair(9, -1);
                }
                return new Pair(4, -1);
            } catch (NumberFormatException unused2) {
                return new Pair(2, -1);
            }
        } catch (NumberFormatException unused3) {
            Double.parseDouble(str);
            return new Pair(12, -1);
        }
    }

    public static ByteOrder u(b bVar) {
        short readShort = bVar.readShort();
        boolean z2 = f688u;
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (z2) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (z2) {
            Log.d("ExifInterface", "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0075 -> B:9:0x0041). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(java.io.BufferedInputStream r9, java.io.BufferedOutputStream r10) {
        /*
            r8 = this;
            boolean r0 = P.h.f688u
            if (r0 == 0) goto L24
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "savePngAttributes starting with (inputStream: "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r1 = ", outputStream: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ExifInterface"
            android.util.Log.d(r1, r0)
        L24:
            P.b r0 = new P.b
            r0.<init>(r9)
            P.c r9 = new P.c
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            r9.<init>(r10, r1)
            byte[] r10 = P.h.f662F
            int r10 = r10.length
            a.AbstractC0051a.h(r0, r9, r10)
            P.d r10 = r8.f708s
            r1 = 1
            r2 = 0
            if (r10 != 0) goto L40
            boolean r10 = r8.f709t
            if (r10 == 0) goto L75
        L40:
            r10 = r1
        L41:
            if (r1 != 0) goto L4a
            if (r10 == 0) goto L46
            goto L4a
        L46:
            a.AbstractC0051a.i(r0, r9)
            return
        L4a:
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            r5 = 1229472850(0x49484452, float:820293.1)
            if (r4 != r5) goto L77
            r9.b(r3)
            r9.b(r4)
            int r3 = r3 + 4
            a.AbstractC0051a.h(r0, r9, r3)
            int r3 = r8.f706o
            if (r3 != 0) goto L6a
            r8.H(r9)
            r1 = r2
        L6a:
            P.d r3 = r8.f708s
            if (r3 == 0) goto L41
            boolean r3 = r8.f709t
            if (r3 != 0) goto L41
            r8.I(r9)
        L75:
            r10 = r2
            goto L41
        L77:
            r5 = 1700284774(0x65584966, float:6.383657E22)
            if (r4 != r5) goto L88
            if (r1 == 0) goto L88
            r8.H(r9)
            int r3 = r3 + 4
            r0.a(r3)
            r1 = r2
            goto L41
        L88:
            r5 = 1767135348(0x69545874, float:1.6044374E25)
            if (r4 != r5) goto Lba
            byte[] r5 = P.h.f663G
            int r6 = r5.length
            if (r3 < r6) goto Lba
            int r6 = r5.length
            byte[] r7 = new byte[r6]
            r0.readFully(r7)
            int r6 = r3 - r6
            int r6 = r6 + 4
            boolean r5 = java.util.Arrays.equals(r7, r5)
            if (r5 == 0) goto Lad
            P.d r10 = r8.f708s
            if (r10 == 0) goto La9
            r8.I(r9)
        La9:
            r0.a(r6)
            goto L75
        Lad:
            r9.b(r3)
            r9.b(r4)
            r9.write(r7)
            a.AbstractC0051a.h(r0, r9, r6)
            goto L41
        Lba:
            r9.b(r3)
            r9.b(r4)
            int r3 = r3 + 4
            a.AbstractC0051a.h(r0, r9, r3)
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.A(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x027e A[Catch: all -> 0x0246, Exception -> 0x024b, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x024b, all -> 0x0246, blocks: (B:22:0x027e, B:121:0x023c, B:126:0x0257), top: B:11:0x0056 }] */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.io.OutputStream, java.lang.Object, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r24v13 */
    /* JADX WARN: Type inference failed for: r24v14 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.io.BufferedInputStream r23, java.io.BufferedOutputStream r24) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.B(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }

    public final void C(b bVar) {
        String str;
        d dVar;
        int i2;
        HashMap hashMap = this.f696e[4];
        d dVar2 = (d) hashMap.get("Compression");
        if (dVar2 != null) {
            int i3 = dVar2.i(this.f698g);
            this.f705n = i3;
            int i4 = 1;
            if (i3 != 1) {
                if (i3 != 6) {
                    if (i3 != 7) {
                        return;
                    }
                } else {
                    p(bVar, hashMap);
                    return;
                }
            }
            d dVar3 = (d) hashMap.get("BitsPerSample");
            String str2 = "ExifInterface";
            if (dVar3 != null) {
                int[] iArr = (int[]) dVar3.k(this.f698g);
                int[] iArr2 = f689v;
                if (Arrays.equals(iArr2, iArr) || (this.f694c == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((i2 = dVar.i(this.f698g)) == 1 && Arrays.equals(iArr, f690w)) || (i2 == 6 && Arrays.equals(iArr, iArr2))))) {
                    d dVar4 = (d) hashMap.get("StripOffsets");
                    d dVar5 = (d) hashMap.get("StripByteCounts");
                    if (dVar4 != null && dVar5 != null) {
                        long[] g2 = AbstractC0051a.g(dVar4.k(this.f698g));
                        long[] g3 = AbstractC0051a.g(dVar5.k(this.f698g));
                        if (g2 != null && g2.length != 0) {
                            if (g3 != null && g3.length != 0) {
                                if (g2.length != g3.length) {
                                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                                    return;
                                }
                                long j2 = 0;
                                for (long j3 : g3) {
                                    j2 += j3;
                                }
                                int i5 = (int) j2;
                                byte[] bArr = new byte[i5];
                                this.f701j = true;
                                this.f700i = true;
                                this.f699h = true;
                                int i6 = 0;
                                int i7 = 0;
                                int i8 = 0;
                                while (i6 < g2.length) {
                                    int i9 = (int) g2[i6];
                                    int i10 = (int) g3[i6];
                                    if (i6 < g2.length - i4) {
                                        str = str2;
                                        if (i9 + i10 != g2[i6 + 1]) {
                                            this.f701j = false;
                                        }
                                    } else {
                                        str = str2;
                                    }
                                    int i11 = i9 - i7;
                                    if (i11 < 0) {
                                        Log.d(str, "Invalid strip offset value");
                                        return;
                                    }
                                    String str3 = str;
                                    try {
                                        bVar.a(i11);
                                        int i12 = i7 + i11;
                                        byte[] bArr2 = new byte[i10];
                                        try {
                                            bVar.readFully(bArr2);
                                            i7 = i12 + i10;
                                            System.arraycopy(bArr2, 0, bArr, i8, i10);
                                            i8 += i10;
                                            i6++;
                                            str2 = str3;
                                            i4 = 1;
                                        } catch (EOFException unused) {
                                            Log.d(str3, "Failed to read " + i10 + " bytes.");
                                            return;
                                        }
                                    } catch (EOFException unused2) {
                                        Log.d(str3, "Failed to skip " + i11 + " bytes.");
                                        return;
                                    }
                                }
                                this.f704m = bArr;
                                if (this.f701j) {
                                    this.f702k = (int) g2[0];
                                    this.f703l = i5;
                                    return;
                                }
                                return;
                            }
                            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                            return;
                        }
                        Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                        return;
                    }
                    return;
                }
            }
            if (f688u) {
                Log.d("ExifInterface", "Unsupported data type value");
                return;
            }
            return;
        }
        this.f705n = 6;
        p(bVar, hashMap);
    }

    public final void D(int i2, int i3) {
        HashMap[] hashMapArr = this.f696e;
        boolean isEmpty = hashMapArr[i2].isEmpty();
        boolean z2 = f688u;
        if (!isEmpty && !hashMapArr[i3].isEmpty()) {
            d dVar = (d) hashMapArr[i2].get("ImageLength");
            d dVar2 = (d) hashMapArr[i2].get("ImageWidth");
            d dVar3 = (d) hashMapArr[i3].get("ImageLength");
            d dVar4 = (d) hashMapArr[i3].get("ImageWidth");
            if (dVar != null && dVar2 != null) {
                if (dVar3 != null && dVar4 != null) {
                    int i4 = dVar.i(this.f698g);
                    int i5 = dVar2.i(this.f698g);
                    int i6 = dVar3.i(this.f698g);
                    int i7 = dVar4.i(this.f698g);
                    if (i4 < i6 && i5 < i7) {
                        HashMap hashMap = hashMapArr[i2];
                        hashMapArr[i2] = hashMapArr[i3];
                        hashMapArr[i3] = hashMap;
                        return;
                    }
                    return;
                }
                if (z2) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                    return;
                }
                return;
            }
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (z2) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    public final void E(g gVar, int i2) {
        d f2;
        d f3;
        HashMap[] hashMapArr = this.f696e;
        d dVar = (d) hashMapArr[i2].get("DefaultCropSize");
        d dVar2 = (d) hashMapArr[i2].get("SensorTopBorder");
        d dVar3 = (d) hashMapArr[i2].get("SensorLeftBorder");
        d dVar4 = (d) hashMapArr[i2].get("SensorBottomBorder");
        d dVar5 = (d) hashMapArr[i2].get("SensorRightBorder");
        if (dVar != null) {
            if (dVar.f647a == 5) {
                f[] fVarArr = (f[]) dVar.k(this.f698g);
                if (fVarArr != null && fVarArr.length == 2) {
                    f2 = d.e(new f[]{fVarArr[0]}, this.f698g);
                    f3 = d.e(new f[]{fVarArr[1]}, this.f698g);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) dVar.k(this.f698g);
                if (iArr != null && iArr.length == 2) {
                    f2 = d.f(iArr[0], this.f698g);
                    f3 = d.f(iArr[1], this.f698g);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            hashMapArr[i2].put("ImageWidth", f2);
            hashMapArr[i2].put("ImageLength", f3);
            return;
        }
        if (dVar2 != null && dVar3 != null && dVar4 != null && dVar5 != null) {
            int i3 = dVar2.i(this.f698g);
            int i4 = dVar4.i(this.f698g);
            int i5 = dVar5.i(this.f698g);
            int i6 = dVar3.i(this.f698g);
            if (i4 > i3 && i5 > i6) {
                d f4 = d.f(i4 - i3, this.f698g);
                d f5 = d.f(i5 - i6, this.f698g);
                hashMapArr[i2].put("ImageLength", f4);
                hashMapArr[i2].put("ImageWidth", f5);
                return;
            }
            return;
        }
        d dVar6 = (d) hashMapArr[i2].get("ImageLength");
        d dVar7 = (d) hashMapArr[i2].get("ImageWidth");
        if (dVar6 == null || dVar7 == null) {
            d dVar8 = (d) hashMapArr[i2].get("JPEGInterchangeFormat");
            d dVar9 = (d) hashMapArr[i2].get("JPEGInterchangeFormatLength");
            if (dVar8 != null && dVar9 != null) {
                int i7 = dVar8.i(this.f698g);
                int i8 = dVar8.i(this.f698g);
                gVar.b(i7);
                byte[] bArr = new byte[i8];
                gVar.readFully(bArr);
                e(new b(bArr), i7, i2);
            }
        }
    }

    public final void F() {
        D(0, 5);
        D(0, 4);
        D(5, 4);
        HashMap[] hashMapArr = this.f696e;
        d dVar = (d) hashMapArr[1].get("PixelXDimension");
        d dVar2 = (d) hashMapArr[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            hashMapArr[0].put("ImageWidth", dVar);
            hashMapArr[0].put("ImageLength", dVar2);
        }
        if (hashMapArr[4].isEmpty() && q(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        if (!q(hashMapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        y(0, "ThumbnailOrientation", "Orientation");
        y(0, "ThumbnailImageLength", "ImageLength");
        y(0, "ThumbnailImageWidth", "ImageWidth");
        y(5, "ThumbnailOrientation", "Orientation");
        y(5, "ThumbnailImageLength", "ImageLength");
        y(5, "ThumbnailImageWidth", "ImageWidth");
        y(4, "Orientation", "ThumbnailOrientation");
        y(4, "ImageLength", "ThumbnailImageLength");
        y(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final int G(c cVar) {
        HashMap[] hashMapArr;
        int i2;
        int i3;
        char c2;
        char c3;
        int[] iArr;
        short s2;
        int i4;
        e[][] eVarArr = f676U;
        int[] iArr2 = new int[eVarArr.length];
        int[] iArr3 = new int[eVarArr.length];
        e[] eVarArr2 = f677V;
        for (e eVar : eVarArr2) {
            x(eVar.f652b);
        }
        if (this.f699h) {
            if (this.f700i) {
                x("StripOffsets");
                x("StripByteCounts");
            } else {
                x("JPEGInterchangeFormat");
                x("JPEGInterchangeFormatLength");
            }
        }
        int i5 = 0;
        while (true) {
            int length = eVarArr.length;
            hashMapArr = this.f696e;
            if (i5 >= length) {
                break;
            }
            Iterator it = hashMapArr[i5].entrySet().iterator();
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    it.remove();
                }
            }
            i5++;
        }
        if (!hashMapArr[1].isEmpty()) {
            i2 = 1;
            i3 = 0;
            hashMapArr[0].put(eVarArr2[1].f652b, d.c(0L, this.f698g));
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (!hashMapArr[2].isEmpty()) {
            c2 = 2;
            hashMapArr[i3].put(eVarArr2[2].f652b, d.c(0L, this.f698g));
        } else {
            c2 = 2;
        }
        if (!hashMapArr[3].isEmpty()) {
            c3 = 3;
            hashMapArr[i2].put(eVarArr2[3].f652b, d.c(0L, this.f698g));
        } else {
            c3 = 3;
        }
        int i6 = 4;
        if (this.f699h) {
            if (this.f700i) {
                hashMapArr[4].put("StripOffsets", d.f(i3, this.f698g));
                hashMapArr[4].put("StripByteCounts", d.f(this.f703l, this.f698g));
            } else {
                hashMapArr[4].put("JPEGInterchangeFormat", d.c(0L, this.f698g));
                hashMapArr[4].put("JPEGInterchangeFormatLength", d.c(this.f703l, this.f698g));
            }
        }
        int i7 = 0;
        while (true) {
            int length2 = eVarArr.length;
            iArr = f673R;
            if (i7 >= length2) {
                break;
            }
            Iterator it2 = hashMapArr[i7].entrySet().iterator();
            int i8 = 0;
            while (it2.hasNext()) {
                d dVar = (d) ((Map.Entry) it2.next()).getValue();
                dVar.getClass();
                int i9 = iArr[dVar.f647a] * dVar.f648b;
                if (i9 > 4) {
                    i8 += i9;
                }
            }
            iArr3[i7] = iArr3[i7] + i8;
            i7++;
        }
        int i10 = 8;
        for (int i11 = 0; i11 < eVarArr.length; i11++) {
            if (!hashMapArr[i11].isEmpty()) {
                iArr2[i11] = i10;
                i10 = (hashMapArr[i11].size() * 12) + 6 + iArr3[i11] + i10;
            }
        }
        if (this.f699h) {
            if (this.f700i) {
                hashMapArr[4].put("StripOffsets", d.f(i10, this.f698g));
            } else {
                hashMapArr[4].put("JPEGInterchangeFormat", d.c(i10, this.f698g));
            }
            this.f702k = i10;
            i10 += this.f703l;
        }
        if (this.f694c == 4) {
            i10 += 8;
        }
        if (f688u) {
            for (int i12 = 0; i12 < eVarArr.length; i12++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i12), Integer.valueOf(iArr2[i12]), Integer.valueOf(hashMapArr[i12].size()), Integer.valueOf(iArr3[i12]), Integer.valueOf(i10)));
            }
        }
        if (!hashMapArr[i2].isEmpty()) {
            hashMapArr[0].put(eVarArr2[i2].f652b, d.c(iArr2[i2], this.f698g));
        }
        if (!hashMapArr[c2].isEmpty()) {
            hashMapArr[0].put(eVarArr2[c2].f652b, d.c(iArr2[c2], this.f698g));
        }
        if (!hashMapArr[c3].isEmpty()) {
            hashMapArr[i2].put(eVarArr2[c3].f652b, d.c(iArr2[c3], this.f698g));
        }
        int i13 = this.f694c;
        if (i13 != 4) {
            if (i13 != 13) {
                if (i13 == 14) {
                    cVar.write(f666J);
                    cVar.b(i10);
                }
            } else {
                cVar.b(i10);
                cVar.b(1700284774);
            }
        } else if (i10 <= 65535) {
            cVar.e(i10);
            cVar.write(f683b0);
        } else {
            throw new IllegalStateException("Size of exif data (" + i10 + " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)");
        }
        int size = cVar.f645c.size();
        if (this.f698g == ByteOrder.BIG_ENDIAN) {
            s2 = 19789;
        } else {
            s2 = 18761;
        }
        cVar.c(s2);
        cVar.f646d = this.f698g;
        cVar.e(42);
        cVar.d(8L);
        int i14 = 0;
        while (i14 < eVarArr.length) {
            if (!hashMapArr[i14].isEmpty()) {
                cVar.e(hashMapArr[i14].size());
                int size2 = (hashMapArr[i14].size() * 12) + iArr2[i14] + 2 + i6;
                for (Map.Entry entry : hashMapArr[i14].entrySet()) {
                    int i15 = ((e) f679X[i14].get(entry.getKey())).f651a;
                    d dVar2 = (d) entry.getValue();
                    dVar2.getClass();
                    int i16 = dVar2.f648b;
                    int i17 = dVar2.f647a;
                    int i18 = iArr[i17] * i16;
                    cVar.e(i15);
                    cVar.e(i17);
                    cVar.b(i16);
                    if (i18 > 4) {
                        cVar.d(size2);
                        size2 += i18;
                    } else {
                        cVar.write(dVar2.f650d);
                        if (i18 < 4) {
                            while (i18 < 4) {
                                cVar.a(0);
                                i18++;
                            }
                        }
                    }
                    i6 = 4;
                }
                int i19 = i6;
                if (i14 == 0 && !hashMapArr[i19].isEmpty()) {
                    cVar.d(iArr2[i19]);
                } else {
                    cVar.d(0L);
                }
                Iterator it3 = hashMapArr[i14].entrySet().iterator();
                while (it3.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it3.next()).getValue()).f650d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
                i4 = 4;
            } else {
                i4 = i6;
            }
            i14++;
            i6 = i4;
        }
        if (this.f699h) {
            cVar.write(m());
        }
        if (this.f694c == 14 && i10 % 2 == i2) {
            cVar.a(0);
        }
        cVar.f646d = ByteOrder.BIG_ENDIAN;
        return size;
    }

    public final void H(c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f706o = cVar.f645c.size() + G(new c(byteArrayOutputStream, ByteOrder.BIG_ENDIAN));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        cVar.write(byteArray);
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray, 4, byteArray.length - 4);
        cVar.b((int) crc32.getValue());
    }

    public final void I(c cVar) {
        cVar.b(this.f708s.f650d.length + 22);
        CRC32 crc32 = new CRC32();
        cVar.b(1767135348);
        crc32.update(105);
        crc32.update(26964);
        crc32.update(6902872);
        crc32.update(1767135348);
        byte[] bArr = f663G;
        cVar.write(bArr);
        crc32.update(bArr);
        cVar.write(this.f708s.f650d);
        crc32.update(this.f708s.f650d);
        cVar.b((int) crc32.getValue());
        this.f709t = true;
    }

    public final void a() {
        String b2 = b("DateTimeOriginal");
        HashMap[] hashMapArr = this.f696e;
        if (b2 != null && b("DateTime") == null) {
            hashMapArr[0].put("DateTime", d.b(b2));
        }
        if (b("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", d.c(0L, this.f698g));
        }
        if (b("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", d.c(0L, this.f698g));
        }
        if (b("Orientation") == null) {
            hashMapArr[0].put("Orientation", d.c(0L, this.f698g));
        }
        if (b("LightSource") == null) {
            hashMapArr[1].put("LightSource", d.c(0L, this.f698g));
        }
    }

    public final String b(String str) {
        if (str != null) {
            d c2 = c(str);
            if (c2 != null) {
                int i2 = c2.f647a;
                if (str.equals("GPSTimeStamp")) {
                    if (i2 != 5 && i2 != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i2);
                        return null;
                    }
                    f[] fVarArr = (f[]) c2.k(this.f698g);
                    if (fVarArr != null && fVarArr.length == 3) {
                        f fVar = fVarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) fVar.f655a) / ((float) fVar.f656b)));
                        f fVar2 = fVarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) fVar2.f655a) / ((float) fVar2.f656b)));
                        f fVar3 = fVarArr[2];
                        return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) fVar3.f655a) / ((float) fVar3.f656b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                if (f680Y.contains(str)) {
                    try {
                        return Double.toString(c2.h(this.f698g));
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    return c2.j(this.f698g);
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final d c(String str) {
        d dVar;
        int i2;
        d dVar2;
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f688u) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            if ("Xmp".equals(str) && (i2 = this.f694c) != 4 && ((i2 == 9 || i2 == 15 || i2 == 12 || i2 == 13) && (dVar2 = this.f708s) != null)) {
                return dVar2;
            }
            for (int i3 = 0; i3 < f676U.length; i3++) {
                d dVar3 = (d) this.f696e[i3].get(str);
                if (dVar3 != null) {
                    return dVar3;
                }
            }
            if ("Xmp".equals(str) && (dVar = this.f708s) != null) {
                return dVar;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void d(g gVar, int i2) {
        String str;
        String str2;
        String str3;
        int i3;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            if (i2 == 15 && i4 < 31) {
                throw new UnsupportedOperationException("Reading EXIF from AVIF files is supported from SDK 31 and above");
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(new a(gVar));
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                    if ("yes".equals(extractMetadata3)) {
                        str = mediaMetadataRetriever.extractMetadata(29);
                        str3 = mediaMetadataRetriever.extractMetadata(30);
                        str2 = mediaMetadataRetriever.extractMetadata(31);
                    } else if ("yes".equals(extractMetadata4)) {
                        str = mediaMetadataRetriever.extractMetadata(18);
                        str3 = mediaMetadataRetriever.extractMetadata(19);
                        str2 = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    HashMap[] hashMapArr = this.f696e;
                    if (str != null) {
                        hashMapArr[0].put("ImageWidth", d.f(Integer.parseInt(str), this.f698g));
                    }
                    if (str3 != null) {
                        hashMapArr[0].put("ImageLength", d.f(Integer.parseInt(str3), this.f698g));
                    }
                    if (str2 != null) {
                        int parseInt = Integer.parseInt(str2);
                        if (parseInt != 90) {
                            if (parseInt != 180) {
                                if (parseInt != 270) {
                                    i3 = 1;
                                } else {
                                    i3 = 8;
                                }
                            } else {
                                i3 = 3;
                            }
                        } else {
                            i3 = 6;
                        }
                        hashMapArr[0].put("Orientation", d.f(i3, this.f698g));
                    }
                    if (extractMetadata != null && extractMetadata2 != null) {
                        int parseInt2 = Integer.parseInt(extractMetadata);
                        int parseInt3 = Integer.parseInt(extractMetadata2);
                        if (parseInt3 > 6) {
                            gVar.b(parseInt2);
                            byte[] bArr = new byte[6];
                            gVar.readFully(bArr);
                            int i5 = parseInt2 + 6;
                            int i6 = parseInt3 - 6;
                            if (Arrays.equals(bArr, f683b0)) {
                                byte[] bArr2 = new byte[i6];
                                gVar.readFully(bArr2);
                                this.f706o = i5;
                                v(bArr2, 0);
                            } else {
                                throw new IOException("Invalid identifier");
                            }
                        } else {
                            throw new IOException("Invalid exif length");
                        }
                    }
                    String extractMetadata5 = mediaMetadataRetriever.extractMetadata(41);
                    String extractMetadata6 = mediaMetadataRetriever.extractMetadata(42);
                    if (extractMetadata5 != null && extractMetadata6 != null) {
                        int parseInt4 = Integer.parseInt(extractMetadata5);
                        int parseInt5 = Integer.parseInt(extractMetadata6);
                        long j2 = parseInt4;
                        gVar.b(j2);
                        byte[] bArr3 = new byte[parseInt5];
                        gVar.readFully(bArr3);
                        this.f708s = new d(j2, bArr3, 1, parseInt5);
                        this.f709t = true;
                    }
                    if (f688u) {
                        Log.d("ExifInterface", "Heif meta: " + str + "x" + str3 + ", rotation " + str2);
                    }
                    try {
                        mediaMetadataRetriever.release();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } catch (RuntimeException e2) {
                    throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e2);
                }
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
        throw new UnsupportedOperationException("Reading EXIF from HEIC files is supported from SDK 28 and above");
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0167, code lost:
    
        r22.f642e = r21.f698g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(P.b r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.e(P.b, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0062, code lost:
    
        if (r9 < 16) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x00ec, code lost:
    
        if (r8 != null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0163 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.io.BufferedInputStream r18) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.f(java.io.BufferedInputStream):int");
    }

    public final void g(g gVar) {
        int i2;
        int i3;
        j(gVar);
        HashMap[] hashMapArr = this.f696e;
        d dVar = (d) hashMapArr[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f650d);
            gVar2.f642e = this.f698g;
            byte[] bArr = f660D;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.b(0L);
            byte[] bArr3 = f661E;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.b(12L);
            }
            w(gVar2, 6);
            d dVar2 = (d) hashMapArr[7].get("PreviewImageStart");
            d dVar3 = (d) hashMapArr[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                hashMapArr[5].put("JPEGInterchangeFormat", dVar2);
                hashMapArr[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) hashMapArr[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.k(this.f698g);
                if (iArr != null && iArr.length == 4) {
                    int i4 = iArr[2];
                    int i5 = iArr[0];
                    if (i4 > i5 && (i2 = iArr[3]) > (i3 = iArr[1])) {
                        int i6 = (i4 - i5) + 1;
                        int i7 = (i2 - i3) + 1;
                        if (i6 < i7) {
                            int i8 = i6 + i7;
                            i7 = i8 - i7;
                            i6 = i8 - i7;
                        }
                        d f2 = d.f(i6, this.f698g);
                        d f3 = d.f(i7, this.f698g);
                        hashMapArr[0].put("ImageWidth", f2);
                        hashMapArr[0].put("ImageLength", f3);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    public final void h(b bVar) {
        if (f688u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f642e = ByteOrder.BIG_ENDIAN;
        int i2 = bVar.f641d;
        bVar.a(f662F.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (z2 && z3) {
                break;
            }
            try {
                int readInt = bVar.readInt();
                int readInt2 = bVar.readInt();
                int i3 = bVar.f641d;
                int i4 = i3 + readInt + 4;
                int i5 = i3 - i2;
                if (i5 == 16 && readInt2 != 1229472850) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appear as the first chunk");
                }
                if (readInt2 == 1229278788) {
                    break;
                }
                if (readInt2 == 1700284774 && !z2) {
                    this.f706o = i5;
                    byte[] bArr = new byte[readInt];
                    bVar.readFully(bArr);
                    int readInt3 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(readInt2 >>> 24);
                    crc32.update(readInt2 >>> 16);
                    crc32.update(readInt2 >>> 8);
                    crc32.update(readInt2);
                    crc32.update(bArr);
                    if (((int) crc32.getValue()) == readInt3) {
                        v(bArr, 0);
                        F();
                        C(new b(bArr));
                        z2 = true;
                    } else {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt3 + ", calculated CRC value: " + crc32.getValue());
                    }
                } else if (readInt2 == 1767135348 && !z3) {
                    byte[] bArr2 = f663G;
                    if (readInt >= bArr2.length) {
                        int length = bArr2.length;
                        byte[] bArr3 = new byte[length];
                        bVar.readFully(bArr3);
                        if (Arrays.equals(bArr3, bArr2)) {
                            int i6 = bVar.f641d - i2;
                            int i7 = readInt - length;
                            byte[] bArr4 = new byte[i7];
                            bVar.readFully(bArr4);
                            this.f708s = new d(i6, bArr4, 1, i7);
                            z3 = true;
                        }
                    }
                }
                bVar.a(i4 - bVar.f641d);
            } catch (EOFException e2) {
                throw new IOException("Encountered corrupt PNG file.", e2);
            }
        }
        this.f709t = z3;
    }

    public final void i(b bVar) {
        boolean z2 = f688u;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        bVar.a(i2 - bVar.f641d);
        bVar.readFully(bArr4);
        e(new b(bArr4), i2, 5);
        bVar.a(i4 - bVar.f641d);
        bVar.f642e = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i5 = 0; i5 < readInt; i5++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f675T.f651a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d f2 = d.f(readShort, this.f698g);
                d f3 = d.f(readShort2, this.f698g);
                HashMap[] hashMapArr = this.f696e;
                hashMapArr[0].put("ImageLength", f2);
                hashMapArr[0].put("ImageWidth", f3);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.a(readUnsignedShort2);
        }
    }

    public final void j(g gVar) {
        s(gVar);
        w(gVar, 0);
        E(gVar, 0);
        E(gVar, 5);
        E(gVar, 4);
        F();
        if (this.f694c == 8) {
            HashMap[] hashMapArr = this.f696e;
            d dVar = (d) hashMapArr[1].get("MakerNote");
            if (dVar != null) {
                g gVar2 = new g(dVar.f650d);
                gVar2.f642e = this.f698g;
                gVar2.a(6);
                w(gVar2, 9);
                d dVar2 = (d) hashMapArr[9].get("ColorSpace");
                if (dVar2 != null) {
                    hashMapArr[1].put("ColorSpace", dVar2);
                }
            }
        }
    }

    public final void k(g gVar) {
        if (f688u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        j(gVar);
        HashMap[] hashMapArr = this.f696e;
        d dVar = (d) hashMapArr[0].get("JpgFromRaw");
        if (dVar != null) {
            e(new b(dVar.f650d), (int) dVar.f649c, 5);
        }
        d dVar2 = (d) hashMapArr[0].get("ISO");
        d dVar3 = (d) hashMapArr[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            hashMapArr[1].put("PhotographicSensitivity", dVar2);
        }
    }

    public final boolean l(g gVar) {
        byte[] bArr = f683b0;
        byte[] bArr2 = new byte[bArr.length];
        gVar.readFully(bArr2);
        if (!Arrays.equals(bArr2, bArr)) {
            Log.w("ExifInterface", "Given data is not EXIF-only.");
            return false;
        }
        byte[] bArr3 = new byte[1024];
        int i2 = 0;
        while (true) {
            if (i2 == bArr3.length) {
                bArr3 = Arrays.copyOf(bArr3, bArr3.length * 2);
            }
            int read = gVar.f640c.read(bArr3, i2, bArr3.length - i2);
            if (read != -1) {
                i2 += read;
                gVar.f641d += read;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr3, i2);
                this.f706o = bArr.length;
                v(copyOf, 0);
                return true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] m() {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing fd."
            java.lang.String r1 = "ExifInterfaceUtils"
            java.lang.String r2 = "ExifInterface"
            boolean r3 = r10.f699h
            r4 = 0
            if (r3 != 0) goto Ld
            goto L82
        Ld:
            byte[] r3 = r10.f704m
            if (r3 == 0) goto L12
            return r3
        L12:
            java.lang.String r3 = r10.f692a     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            if (r3 == 0) goto L27
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.String r5 = r10.f692a     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r5 = r4
            goto L3c
        L1f:
            r2 = move-exception
            r5 = r4
            goto L86
        L23:
            r3 = move-exception
            r5 = r4
            r6 = r5
            goto L70
        L27:
            java.io.FileDescriptor r3 = r10.f693b     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.io.FileDescriptor r3 = android.system.Os.dup(r3)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            int r5 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r6 = 0
            android.system.Os.lseek(r3, r6, r5)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r9 = r5
            r5 = r3
            r3 = r9
        L3c:
            P.b r6 = new P.b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r7 = r10.f702k     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r8 = r10.f706o     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r7 = r7 + r8
            r6.a(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r7 = r10.f703l     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r6.readFully(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r10.f704m = r7     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            a.AbstractC0051a.e(r3)
            if (r5 == 0) goto L5f
            android.system.Os.close(r5)     // Catch: android.system.ErrnoException -> L5b
            return r7
        L5b:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L5f:
            return r7
        L60:
            r2 = move-exception
            r4 = r3
            goto L86
        L63:
            r6 = move-exception
            r9 = r5
            r5 = r3
            r3 = r6
            r6 = r9
            goto L70
        L69:
            r2 = move-exception
            r5 = r3
            goto L86
        L6c:
            r5 = move-exception
            r6 = r3
            r3 = r5
            r5 = r4
        L70:
            java.lang.String r7 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r2, r7, r3)     // Catch: java.lang.Throwable -> L83
            a.AbstractC0051a.e(r5)
            if (r6 == 0) goto L82
            android.system.Os.close(r6)     // Catch: android.system.ErrnoException -> L7e
            goto L82
        L7e:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L82:
            return r4
        L83:
            r2 = move-exception
            r4 = r5
            r5 = r6
        L86:
            a.AbstractC0051a.e(r4)
            if (r5 == 0) goto L93
            android.system.Os.close(r5)     // Catch: android.system.ErrnoException -> L8f
            goto L93
        L8f:
            r3 = move-exception
            android.util.Log.e(r1, r0, r3)
        L93:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.m():byte[]");
    }

    public final void n(b bVar) {
        if (f688u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f642e = ByteOrder.LITTLE_ENDIAN;
        bVar.a(f664H.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f665I;
        bVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int readInt2 = bVar.readInt();
                int i2 = length + 8;
                if (Arrays.equals(f666J, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    bVar.readFully(bArr3);
                    byte[] bArr4 = f683b0;
                    if (AbstractC0051a.S(bArr3, bArr4)) {
                        bArr3 = Arrays.copyOfRange(bArr3, bArr4.length, readInt2);
                    }
                    this.f706o = i2;
                    v(bArr3, 0);
                    C(new b(bArr3));
                    return;
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i2 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length <= readInt) {
                    bVar.a(readInt2);
                } else {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
            } catch (EOFException e2) {
                throw new IOException("Encountered corrupt WebP file.", e2);
            }
        }
    }

    public final void p(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int i2 = dVar.i(this.f698g);
            int i3 = dVar2.i(this.f698g);
            if (this.f694c == 7) {
                i2 += this.p;
            }
            if (i2 > 0 && i3 > 0) {
                this.f699h = true;
                if (this.f692a == null && this.f693b == null) {
                    byte[] bArr = new byte[i3];
                    bVar.a(i2);
                    bVar.readFully(bArr);
                    this.f704m = bArr;
                }
                this.f702k = i2;
                this.f703l = i3;
            }
            if (f688u) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i2 + ", length: " + i3);
            }
        }
    }

    public final boolean q(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar != null && dVar2 != null) {
            int i2 = dVar.i(this.f698g);
            int i3 = dVar2.i(this.f698g);
            if (i2 <= 512 && i3 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.io.InputStream r9) {
        /*
            r8 = this;
            boolean r0 = P.h.f688u
            r1 = 0
            r2 = r1
        L4:
            P.e[][] r3 = P.h.f676U     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r3 = r3.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 >= r3) goto L1e
            java.util.HashMap[] r3 = r8.f696e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3[r2] = r4     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2 + 1
            goto L4
        L15:
            r9 = move-exception
            goto Lb4
        L18:
            r9 = move-exception
            goto Laa
        L1b:
            r9 = move-exception
            goto Laa
        L1e:
            boolean r2 = r8.f695d
            if (r2 != 0) goto L30
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4 = 5000(0x1388, float:7.006E-42)
            r3.<init>(r9, r4)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r9 = r8.f(r3)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.f694c = r9     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r9 = r3
        L30:
            int r3 = r8.f694c     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4 = 14
            r5 = 13
            r6 = 9
            r7 = 4
            if (r3 == r7) goto L83
            if (r3 == r6) goto L83
            if (r3 == r5) goto L83
            if (r3 != r4) goto L42
            goto L83
        L42:
            P.g r1 = new P.g     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 == 0) goto L58
            boolean r9 = r8.l(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r9 != 0) goto L79
            r8.a()
            if (r0 == 0) goto Lc5
            r8.t()
            return
        L58:
            int r9 = r8.f694c     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 12
            if (r9 == r2) goto L76
            r2 = 15
            if (r9 != r2) goto L63
            goto L76
        L63:
            r2 = 7
            if (r9 != r2) goto L6a
            r8.g(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L79
        L6a:
            r2 = 10
            if (r9 != r2) goto L72
            r8.k(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L79
        L72:
            r8.j(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L79
        L76:
            r8.d(r1, r9)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L79:
            int r9 = r8.f706o     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r2 = (long) r9     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.b(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.C(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto La1
        L83:
            P.b r2 = new P.b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r9 = r8.f694c     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r9 != r7) goto L90
            r8.e(r2, r1, r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto La1
        L90:
            if (r9 != r5) goto L96
            r8.h(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto La1
        L96:
            if (r9 != r6) goto L9c
            r8.i(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto La1
        L9c:
            if (r9 != r4) goto La1
            r8.n(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        La1:
            r8.a()
            if (r0 == 0) goto Lc5
            r8.t()
            return
        Laa:
            if (r0 == 0) goto Lbd
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file (ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r9)     // Catch: java.lang.Throwable -> L15
            goto Lbd
        Lb4:
            r8.a()
            if (r0 == 0) goto Lbc
            r8.t()
        Lbc:
            throw r9
        Lbd:
            r8.a()
            if (r0 == 0) goto Lc5
            r8.t()
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.r(java.io.InputStream):void");
    }

    public final void s(g gVar) {
        ByteOrder u2 = u(gVar);
        this.f698g = u2;
        gVar.f642e = u2;
        int readUnsignedShort = gVar.readUnsignedShort();
        int i2 = this.f694c;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = gVar.readInt();
        if (readInt >= 8) {
            int i3 = readInt - 8;
            if (i3 > 0) {
                gVar.a(i3);
                return;
            }
            return;
        }
        throw new IOException(O.a.c(readInt, "Invalid first Ifd offset: "));
    }

    public final void t() {
        int i2 = 0;
        while (true) {
            HashMap[] hashMapArr = this.f696e;
            if (i2 < hashMapArr.length) {
                Log.d("ExifInterface", "The size of tag group[" + i2 + "]: " + hashMapArr[i2].size());
                for (Map.Entry entry : hashMapArr[i2].entrySet()) {
                    d dVar = (d) entry.getValue();
                    Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.j(this.f698g) + "'");
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public final void v(byte[] bArr, int i2) {
        g gVar = new g(bArr);
        s(gVar);
        w(gVar, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0299  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(P.g r30, int r31) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P.h.w(P.g, int):void");
    }

    public final void x(String str) {
        for (int i2 = 0; i2 < f676U.length; i2++) {
            this.f696e[i2].remove(str);
        }
    }

    public final void y(int i2, String str, String str2) {
        HashMap[] hashMapArr = this.f696e;
        if (!hashMapArr[i2].isEmpty() && hashMapArr[i2].get(str) != null) {
            HashMap hashMap = hashMapArr[i2];
            hashMap.put(str2, (d) hashMap.get(str));
            hashMapArr[i2].remove(str);
        }
    }

    public final void z(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        byte readByte;
        byte[] bArr;
        if (f688u) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        b bVar = new b(bufferedInputStream);
        c cVar = new c(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.a(-1);
            if (bVar.readByte() == -40) {
                cVar.a(-40);
                cVar.a(-1);
                cVar.a(-31);
                this.f706o = G(cVar);
                d dVar = this.f708s;
                byte[] bArr2 = f684c0;
                if (dVar != null) {
                    cVar.write(-1);
                    cVar.a(-31);
                    cVar.e(bArr2.length + 2 + this.f708s.f650d.length);
                    cVar.write(bArr2);
                    cVar.write(this.f708s.f650d);
                    this.f709t = true;
                }
                byte[] bArr3 = new byte[4096];
                while (bVar.readByte() == -1) {
                    do {
                        readByte = bVar.readByte();
                    } while (readByte == -1);
                    if (readByte != -39 && readByte != -38) {
                        if (readByte != -31) {
                            cVar.a(-1);
                            cVar.a(readByte);
                            int readUnsignedShort = bVar.readUnsignedShort();
                            cVar.e(readUnsignedShort);
                            int i2 = readUnsignedShort - 2;
                            if (i2 >= 0) {
                                while (i2 > 0) {
                                    int read = bVar.read(bArr3, 0, Math.min(i2, 4096));
                                    if (read >= 0) {
                                        cVar.write(bArr3, 0, read);
                                        i2 -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = bVar.readUnsignedShort();
                            int i3 = readUnsignedShort2 - 2;
                            if (i3 >= 0) {
                                int length = bArr2.length;
                                byte[] bArr4 = f683b0;
                                if (i3 >= length) {
                                    bArr = new byte[bArr2.length];
                                } else if (i3 >= bArr4.length) {
                                    bArr = new byte[bArr4.length];
                                } else {
                                    bArr = null;
                                }
                                if (bArr != null) {
                                    bVar.readFully(bArr);
                                    if (AbstractC0051a.S(bArr, bArr4) || AbstractC0051a.S(bArr, bArr2)) {
                                        bVar.a(i3 - bArr.length);
                                    }
                                }
                                cVar.a(-1);
                                cVar.a(readByte);
                                cVar.e(readUnsignedShort2);
                                if (bArr != null) {
                                    i3 -= bArr.length;
                                    cVar.write(bArr);
                                }
                                while (i3 > 0) {
                                    int read2 = bVar.read(bArr3, 0, Math.min(i3, 4096));
                                    if (read2 >= 0) {
                                        cVar.write(bArr3, 0, read2);
                                        i3 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        cVar.a(-1);
                        cVar.a(readByte);
                        AbstractC0051a.i(bVar, cVar);
                        return;
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    public h(ByteArrayInputStream byteArrayInputStream) {
        e[][] eVarArr = f676U;
        this.f696e = new HashMap[eVarArr.length];
        this.f697f = new HashSet(eVarArr.length);
        this.f698g = ByteOrder.BIG_ENDIAN;
        this.f692a = null;
        this.f695d = false;
        this.f693b = null;
        r(byteArrayInputStream);
    }
}
