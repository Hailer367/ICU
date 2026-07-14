package W;

import A2.i;
import a.AbstractC0141a;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
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
    public static final byte[] f1792A;

    /* renamed from: B, reason: collision with root package name */
    public static final byte[] f1793B;

    /* renamed from: C, reason: collision with root package name */
    public static final byte[] f1794C;

    /* renamed from: D, reason: collision with root package name */
    public static final byte[] f1795D;

    /* renamed from: E, reason: collision with root package name */
    public static final byte[] f1796E;

    /* renamed from: F, reason: collision with root package name */
    public static final byte[] f1797F;

    /* renamed from: G, reason: collision with root package name */
    public static final byte[] f1798G;

    /* renamed from: H, reason: collision with root package name */
    public static final byte[] f1799H;

    /* renamed from: I, reason: collision with root package name */
    public static final byte[] f1800I;

    /* renamed from: J, reason: collision with root package name */
    public static final byte[] f1801J;

    /* renamed from: K, reason: collision with root package name */
    public static final byte[] f1802K;

    /* renamed from: L, reason: collision with root package name */
    public static final byte[] f1803L;

    /* renamed from: M, reason: collision with root package name */
    public static final byte[] f1804M;

    /* renamed from: N, reason: collision with root package name */
    public static final byte[] f1805N;

    /* renamed from: O, reason: collision with root package name */
    public static final byte[] f1806O;
    public static final byte[] P;

    /* renamed from: Q, reason: collision with root package name */
    public static final String[] f1807Q;

    /* renamed from: R, reason: collision with root package name */
    public static final int[] f1808R;

    /* renamed from: S, reason: collision with root package name */
    public static final byte[] f1809S;

    /* renamed from: T, reason: collision with root package name */
    public static final e f1810T;

    /* renamed from: U, reason: collision with root package name */
    public static final e[][] f1811U;

    /* renamed from: V, reason: collision with root package name */
    public static final e[] f1812V;

    /* renamed from: W, reason: collision with root package name */
    public static final HashMap[] f1813W;

    /* renamed from: X, reason: collision with root package name */
    public static final HashMap[] f1814X;

    /* renamed from: Y, reason: collision with root package name */
    public static final Set f1815Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final HashMap f1816Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final Charset f1817a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final byte[] f1818b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final byte[] f1819c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final Pattern f1820d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final Pattern f1821e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final Pattern f1822f0;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f1823u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f1824v;

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f1825w;

    /* renamed from: x, reason: collision with root package name */
    public static final byte[] f1826x;

    /* renamed from: y, reason: collision with root package name */
    public static final byte[] f1827y;
    public static final byte[] z;

    /* renamed from: a, reason: collision with root package name */
    public final String f1828a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDescriptor f1829b;

    /* renamed from: c, reason: collision with root package name */
    public int f1830c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1831d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap[] f1832e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f1833f;

    /* renamed from: g, reason: collision with root package name */
    public ByteOrder f1834g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1835h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1836i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1837j;
    public int k;

    /* renamed from: l, reason: collision with root package name */
    public int f1838l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f1839m;

    /* renamed from: n, reason: collision with root package name */
    public int f1840n;

    /* renamed from: o, reason: collision with root package name */
    public int f1841o;

    /* renamed from: p, reason: collision with root package name */
    public int f1842p;

    /* renamed from: q, reason: collision with root package name */
    public int f1843q;

    /* renamed from: r, reason: collision with root package name */
    public int f1844r;

    /* renamed from: s, reason: collision with root package name */
    public d f1845s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1846t;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        f1824v = new int[]{8, 8, 8};
        f1825w = new int[]{8};
        f1826x = new byte[]{-1, -40, -1};
        f1827y = new byte[]{102, 116, 121, 112};
        z = new byte[]{109, 105, 102, 49};
        f1792A = new byte[]{104, 101, 105, 99};
        f1793B = new byte[]{97, 118, 105, 102};
        f1794C = new byte[]{97, 118, 105, 115};
        f1795D = new byte[]{79, 76, 89, 77, 80, 0};
        f1796E = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f1797F = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        f1798G = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);
        f1799H = new byte[]{82, 73, 70, 70};
        f1800I = new byte[]{87, 69, 66, 80};
        f1801J = new byte[]{69, 88, 73, 70};
        f1802K = new byte[]{-99, 1, 42};
        f1803L = "VP8X".getBytes(Charset.defaultCharset());
        f1804M = "VP8L".getBytes(Charset.defaultCharset());
        f1805N = "VP8 ".getBytes(Charset.defaultCharset());
        f1806O = "ANIM".getBytes(Charset.defaultCharset());
        P = "ANMF".getBytes(Charset.defaultCharset());
        f1807Q = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f1808R = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f1809S = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(256, 3, 4, "ImageWidth"), new e(257, 3, 4, "ImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e(40962, 3, 4, "PixelXDimension"), new e(40963, 3, 4, "PixelYDimension"), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e(2, 5, 10, "GPSLatitude"), new e("GPSLongitudeRef", 3, 2), new e(4, 5, 10, "GPSLongitude"), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e(256, 3, 4, "ThumbnailImageWidth"), new e(257, 3, 4, "ThumbnailImageLength"), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e(273, 3, 4, "StripOffsets"), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e(278, 3, 4, "RowsPerStrip"), new e(279, 3, 4, "StripByteCounts"), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e(50720, 3, 4, "DefaultCropSize")};
        f1810T = new e("StripOffsets", 273, 3);
        f1811U = new e[][]{eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, new e[]{new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)}, new e[]{new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)}, new e[]{new e("AspectFrame", 4371, 3)}, new e[]{new e("ColorSpace", 55, 3)}};
        f1812V = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f1813W = new HashMap[10];
        f1814X = new HashMap[10];
        f1815Y = Collections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        f1816Z = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        f1817a0 = forName;
        f1818b0 = "Exif\u0000\u0000".getBytes(forName);
        f1819c0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i4 = 0;
        while (true) {
            e[][] eVarArr6 = f1811U;
            if (i4 < eVarArr6.length) {
                f1813W[i4] = new HashMap();
                f1814X[i4] = new HashMap();
                for (e eVar : eVarArr6[i4]) {
                    f1813W[i4].put(Integer.valueOf(eVar.f1786a), eVar);
                    f1814X[i4].put(eVar.f1787b, eVar);
                }
                i4++;
            } else {
                HashMap hashMap = f1816Z;
                e[] eVarArr7 = f1812V;
                hashMap.put(Integer.valueOf(eVarArr7[0].f1786a), 5);
                hashMap.put(Integer.valueOf(eVarArr7[1].f1786a), 1);
                hashMap.put(Integer.valueOf(eVarArr7[2].f1786a), 2);
                hashMap.put(Integer.valueOf(eVarArr7[3].f1786a), 3);
                hashMap.put(Integer.valueOf(eVarArr7[4].f1786a), 7);
                hashMap.put(Integer.valueOf(eVarArr7[5].f1786a), 8);
                Pattern.compile(".*[1-9].*");
                f1820d0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f1821e0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f1822f0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public h(String str) {
        boolean z3;
        e[][] eVarArr = f1811U;
        this.f1832e = new HashMap[eVarArr.length];
        this.f1833f = new HashSet(eVarArr.length);
        this.f1834g = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            this.f1828a = str;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        Os.lseek(fileInputStream2.getFD(), 0L, OsConstants.SEEK_CUR);
                        z3 = true;
                    } catch (Exception unused) {
                        if (f1823u) {
                            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                        }
                        z3 = false;
                    }
                    if (z3) {
                        this.f1829b = fileInputStream2.getFD();
                    } else {
                        this.f1829b = null;
                    }
                    r(fileInputStream2);
                    AbstractC0141a.f(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    AbstractC0141a.f(fileInputStream);
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
        int i4;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair o3 = o(split[0]);
            if (((Integer) o3.first).intValue() == 2) {
                return o3;
            }
            for (int i5 = 1; i5 < split.length; i5++) {
                Pair o4 = o(split[i5]);
                if (!((Integer) o4.first).equals(o3.first) && !((Integer) o4.second).equals(o3.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) o3.first).intValue();
                }
                if (((Integer) o3.second).intValue() != -1 && (((Integer) o4.first).equals(o3.second) || ((Integer) o4.second).equals(o3.second))) {
                    i4 = ((Integer) o3.second).intValue();
                } else {
                    i4 = -1;
                }
                if (intValue == -1 && i4 == -1) {
                    return new Pair(2, -1);
                }
                if (intValue == -1) {
                    o3 = new Pair(Integer.valueOf(i4), -1);
                } else if (i4 == -1) {
                    o3 = new Pair(Integer.valueOf(intValue), -1);
                }
            }
            return o3;
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
        boolean z3 = f1823u;
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (z3) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (z3) {
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
            boolean r0 = W.h.f1823u
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
            W.b r0 = new W.b
            r0.<init>(r9)
            W.c r9 = new W.c
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            r9.<init>(r10, r1)
            byte[] r10 = W.h.f1797F
            int r10 = r10.length
            a.AbstractC0141a.h(r0, r9, r10)
            W.d r10 = r8.f1845s
            r1 = 1
            r2 = 0
            if (r10 != 0) goto L40
            boolean r10 = r8.f1846t
            if (r10 == 0) goto L75
        L40:
            r10 = r1
        L41:
            if (r1 != 0) goto L4a
            if (r10 == 0) goto L46
            goto L4a
        L46:
            a.AbstractC0141a.i(r0, r9)
            return
        L4a:
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            r5 = 1229472850(0x49484452, float:820293.1)
            if (r4 != r5) goto L77
            r9.b(r3)
            r9.b(r4)
            int r3 = r3 + 4
            a.AbstractC0141a.h(r0, r9, r3)
            int r3 = r8.f1841o
            if (r3 != 0) goto L6a
            r8.H(r9)
            r1 = r2
        L6a:
            W.d r3 = r8.f1845s
            if (r3 == 0) goto L41
            boolean r3 = r8.f1846t
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
            byte[] r5 = W.h.f1798G
            int r6 = r5.length
            if (r3 < r6) goto Lba
            int r6 = r5.length
            byte[] r7 = new byte[r6]
            r0.readFully(r7)
            int r6 = r3 - r6
            int r6 = r6 + 4
            boolean r5 = java.util.Arrays.equals(r7, r5)
            if (r5 == 0) goto Lad
            W.d r10 = r8.f1845s
            if (r10 == 0) goto La9
            r8.I(r9)
        La9:
            r0.a(r6)
            goto L75
        Lad:
            r9.b(r3)
            r9.b(r4)
            r9.write(r7)
            a.AbstractC0141a.h(r0, r9, r6)
            goto L41
        Lba:
            r9.b(r3)
            r9.b(r4)
            int r3 = r3 + 4
            a.AbstractC0141a.h(r0, r9, r3)
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: W.h.A(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
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
        throw new UnsupportedOperationException("Method not decompiled: W.h.B(java.io.BufferedInputStream, java.io.BufferedOutputStream):void");
    }

    public final void C(b bVar) {
        String str;
        d dVar;
        int i4;
        HashMap hashMap = this.f1832e[4];
        d dVar2 = (d) hashMap.get("Compression");
        if (dVar2 != null) {
            int i5 = dVar2.i(this.f1834g);
            this.f1840n = i5;
            int i6 = 1;
            if (i5 != 1) {
                if (i5 != 6) {
                    if (i5 != 7) {
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
                int[] iArr = (int[]) dVar3.k(this.f1834g);
                int[] iArr2 = f1824v;
                if (Arrays.equals(iArr2, iArr) || (this.f1830c == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((i4 = dVar.i(this.f1834g)) == 1 && Arrays.equals(iArr, f1825w)) || (i4 == 6 && Arrays.equals(iArr, iArr2))))) {
                    d dVar4 = (d) hashMap.get("StripOffsets");
                    d dVar5 = (d) hashMap.get("StripByteCounts");
                    if (dVar4 != null && dVar5 != null) {
                        long[] g4 = AbstractC0141a.g(dVar4.k(this.f1834g));
                        long[] g5 = AbstractC0141a.g(dVar5.k(this.f1834g));
                        if (g4 != null && g4.length != 0) {
                            if (g5 != null && g5.length != 0) {
                                if (g4.length != g5.length) {
                                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                                    return;
                                }
                                long j4 = 0;
                                for (long j5 : g5) {
                                    j4 += j5;
                                }
                                int i7 = (int) j4;
                                byte[] bArr = new byte[i7];
                                this.f1837j = true;
                                this.f1836i = true;
                                this.f1835h = true;
                                int i8 = 0;
                                int i9 = 0;
                                int i10 = 0;
                                while (i8 < g4.length) {
                                    int i11 = (int) g4[i8];
                                    int i12 = (int) g5[i8];
                                    if (i8 < g4.length - i6) {
                                        str = str2;
                                        if (i11 + i12 != g4[i8 + 1]) {
                                            this.f1837j = false;
                                        }
                                    } else {
                                        str = str2;
                                    }
                                    int i13 = i11 - i9;
                                    if (i13 < 0) {
                                        Log.d(str, "Invalid strip offset value");
                                        return;
                                    }
                                    String str3 = str;
                                    try {
                                        bVar.a(i13);
                                        int i14 = i9 + i13;
                                        byte[] bArr2 = new byte[i12];
                                        try {
                                            bVar.readFully(bArr2);
                                            i9 = i14 + i12;
                                            System.arraycopy(bArr2, 0, bArr, i10, i12);
                                            i10 += i12;
                                            i8++;
                                            str2 = str3;
                                            i6 = 1;
                                        } catch (EOFException unused) {
                                            Log.d(str3, "Failed to read " + i12 + " bytes.");
                                            return;
                                        }
                                    } catch (EOFException unused2) {
                                        Log.d(str3, "Failed to skip " + i13 + " bytes.");
                                        return;
                                    }
                                }
                                this.f1839m = bArr;
                                if (this.f1837j) {
                                    this.k = (int) g4[0];
                                    this.f1838l = i7;
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
            if (f1823u) {
                Log.d("ExifInterface", "Unsupported data type value");
                return;
            }
            return;
        }
        this.f1840n = 6;
        p(bVar, hashMap);
    }

    public final void D(int i4, int i5) {
        HashMap[] hashMapArr = this.f1832e;
        boolean isEmpty = hashMapArr[i4].isEmpty();
        boolean z3 = f1823u;
        if (!isEmpty && !hashMapArr[i5].isEmpty()) {
            d dVar = (d) hashMapArr[i4].get("ImageLength");
            d dVar2 = (d) hashMapArr[i4].get("ImageWidth");
            d dVar3 = (d) hashMapArr[i5].get("ImageLength");
            d dVar4 = (d) hashMapArr[i5].get("ImageWidth");
            if (dVar != null && dVar2 != null) {
                if (dVar3 != null && dVar4 != null) {
                    int i6 = dVar.i(this.f1834g);
                    int i7 = dVar2.i(this.f1834g);
                    int i8 = dVar3.i(this.f1834g);
                    int i9 = dVar4.i(this.f1834g);
                    if (i6 < i8 && i7 < i9) {
                        HashMap hashMap = hashMapArr[i4];
                        hashMapArr[i4] = hashMapArr[i5];
                        hashMapArr[i5] = hashMap;
                        return;
                    }
                    return;
                }
                if (z3) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                    return;
                }
                return;
            }
            if (z3) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (z3) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    public final void E(g gVar, int i4) {
        d f4;
        d f5;
        HashMap[] hashMapArr = this.f1832e;
        d dVar = (d) hashMapArr[i4].get("DefaultCropSize");
        d dVar2 = (d) hashMapArr[i4].get("SensorTopBorder");
        d dVar3 = (d) hashMapArr[i4].get("SensorLeftBorder");
        d dVar4 = (d) hashMapArr[i4].get("SensorBottomBorder");
        d dVar5 = (d) hashMapArr[i4].get("SensorRightBorder");
        if (dVar != null) {
            if (dVar.f1782a == 5) {
                f[] fVarArr = (f[]) dVar.k(this.f1834g);
                if (fVarArr != null && fVarArr.length == 2) {
                    f4 = d.e(new f[]{fVarArr[0]}, this.f1834g);
                    f5 = d.e(new f[]{fVarArr[1]}, this.f1834g);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) dVar.k(this.f1834g);
                if (iArr != null && iArr.length == 2) {
                    f4 = d.f(iArr[0], this.f1834g);
                    f5 = d.f(iArr[1], this.f1834g);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            hashMapArr[i4].put("ImageWidth", f4);
            hashMapArr[i4].put("ImageLength", f5);
            return;
        }
        if (dVar2 != null && dVar3 != null && dVar4 != null && dVar5 != null) {
            int i5 = dVar2.i(this.f1834g);
            int i6 = dVar4.i(this.f1834g);
            int i7 = dVar5.i(this.f1834g);
            int i8 = dVar3.i(this.f1834g);
            if (i6 > i5 && i7 > i8) {
                d f6 = d.f(i6 - i5, this.f1834g);
                d f7 = d.f(i7 - i8, this.f1834g);
                hashMapArr[i4].put("ImageLength", f6);
                hashMapArr[i4].put("ImageWidth", f7);
                return;
            }
            return;
        }
        d dVar6 = (d) hashMapArr[i4].get("ImageLength");
        d dVar7 = (d) hashMapArr[i4].get("ImageWidth");
        if (dVar6 == null || dVar7 == null) {
            d dVar8 = (d) hashMapArr[i4].get("JPEGInterchangeFormat");
            d dVar9 = (d) hashMapArr[i4].get("JPEGInterchangeFormatLength");
            if (dVar8 != null && dVar9 != null) {
                int i9 = dVar8.i(this.f1834g);
                int i10 = dVar8.i(this.f1834g);
                gVar.b(i9);
                byte[] bArr = new byte[i10];
                gVar.readFully(bArr);
                e(new b(bArr), i9, i4);
            }
        }
    }

    public final void F() {
        D(0, 5);
        D(0, 4);
        D(5, 4);
        HashMap[] hashMapArr = this.f1832e;
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
        int i4;
        int i5;
        char c4;
        char c5;
        int[] iArr;
        short s3;
        int i6;
        e[][] eVarArr = f1811U;
        int[] iArr2 = new int[eVarArr.length];
        int[] iArr3 = new int[eVarArr.length];
        e[] eVarArr2 = f1812V;
        for (e eVar : eVarArr2) {
            x(eVar.f1787b);
        }
        if (this.f1835h) {
            if (this.f1836i) {
                x("StripOffsets");
                x("StripByteCounts");
            } else {
                x("JPEGInterchangeFormat");
                x("JPEGInterchangeFormatLength");
            }
        }
        int i7 = 0;
        while (true) {
            int length = eVarArr.length;
            hashMapArr = this.f1832e;
            if (i7 >= length) {
                break;
            }
            Iterator it = hashMapArr[i7].entrySet().iterator();
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    it.remove();
                }
            }
            i7++;
        }
        if (!hashMapArr[1].isEmpty()) {
            i4 = 1;
            i5 = 0;
            hashMapArr[0].put(eVarArr2[1].f1787b, d.c(0L, this.f1834g));
        } else {
            i4 = 1;
            i5 = 0;
        }
        if (!hashMapArr[2].isEmpty()) {
            c4 = 2;
            hashMapArr[i5].put(eVarArr2[2].f1787b, d.c(0L, this.f1834g));
        } else {
            c4 = 2;
        }
        if (!hashMapArr[3].isEmpty()) {
            c5 = 3;
            hashMapArr[i4].put(eVarArr2[3].f1787b, d.c(0L, this.f1834g));
        } else {
            c5 = 3;
        }
        int i8 = 4;
        if (this.f1835h) {
            if (this.f1836i) {
                hashMapArr[4].put("StripOffsets", d.f(i5, this.f1834g));
                hashMapArr[4].put("StripByteCounts", d.f(this.f1838l, this.f1834g));
            } else {
                hashMapArr[4].put("JPEGInterchangeFormat", d.c(0L, this.f1834g));
                hashMapArr[4].put("JPEGInterchangeFormatLength", d.c(this.f1838l, this.f1834g));
            }
        }
        int i9 = 0;
        while (true) {
            int length2 = eVarArr.length;
            iArr = f1808R;
            if (i9 >= length2) {
                break;
            }
            Iterator it2 = hashMapArr[i9].entrySet().iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                d dVar = (d) ((Map.Entry) it2.next()).getValue();
                dVar.getClass();
                int i11 = iArr[dVar.f1782a] * dVar.f1783b;
                if (i11 > 4) {
                    i10 += i11;
                }
            }
            iArr3[i9] = iArr3[i9] + i10;
            i9++;
        }
        int i12 = 8;
        for (int i13 = 0; i13 < eVarArr.length; i13++) {
            if (!hashMapArr[i13].isEmpty()) {
                iArr2[i13] = i12;
                i12 = (hashMapArr[i13].size() * 12) + 6 + iArr3[i13] + i12;
            }
        }
        if (this.f1835h) {
            if (this.f1836i) {
                hashMapArr[4].put("StripOffsets", d.f(i12, this.f1834g));
            } else {
                hashMapArr[4].put("JPEGInterchangeFormat", d.c(i12, this.f1834g));
            }
            this.k = i12;
            i12 += this.f1838l;
        }
        if (this.f1830c == 4) {
            i12 += 8;
        }
        if (f1823u) {
            for (int i14 = 0; i14 < eVarArr.length; i14++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i14), Integer.valueOf(iArr2[i14]), Integer.valueOf(hashMapArr[i14].size()), Integer.valueOf(iArr3[i14]), Integer.valueOf(i12)));
            }
        }
        if (!hashMapArr[i4].isEmpty()) {
            hashMapArr[0].put(eVarArr2[i4].f1787b, d.c(iArr2[i4], this.f1834g));
        }
        if (!hashMapArr[c4].isEmpty()) {
            hashMapArr[0].put(eVarArr2[c4].f1787b, d.c(iArr2[c4], this.f1834g));
        }
        if (!hashMapArr[c5].isEmpty()) {
            hashMapArr[i4].put(eVarArr2[c5].f1787b, d.c(iArr2[c5], this.f1834g));
        }
        int i15 = this.f1830c;
        if (i15 != 4) {
            if (i15 != 13) {
                if (i15 == 14) {
                    cVar.write(f1801J);
                    cVar.b(i12);
                }
            } else {
                cVar.b(i12);
                cVar.b(1700284774);
            }
        } else if (i12 <= 65535) {
            cVar.e(i12);
            cVar.write(f1818b0);
        } else {
            throw new IllegalStateException("Size of exif data (" + i12 + " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)");
        }
        int size = cVar.f1780f.size();
        if (this.f1834g == ByteOrder.BIG_ENDIAN) {
            s3 = 19789;
        } else {
            s3 = 18761;
        }
        cVar.c(s3);
        cVar.f1781g = this.f1834g;
        cVar.e(42);
        cVar.d(8L);
        int i16 = 0;
        while (i16 < eVarArr.length) {
            if (!hashMapArr[i16].isEmpty()) {
                cVar.e(hashMapArr[i16].size());
                int size2 = (hashMapArr[i16].size() * 12) + iArr2[i16] + 2 + i8;
                for (Map.Entry entry : hashMapArr[i16].entrySet()) {
                    int i17 = ((e) f1814X[i16].get(entry.getKey())).f1786a;
                    d dVar2 = (d) entry.getValue();
                    dVar2.getClass();
                    int i18 = dVar2.f1783b;
                    int i19 = dVar2.f1782a;
                    int i20 = iArr[i19] * i18;
                    cVar.e(i17);
                    cVar.e(i19);
                    cVar.b(i18);
                    if (i20 > 4) {
                        cVar.d(size2);
                        size2 += i20;
                    } else {
                        cVar.write(dVar2.f1785d);
                        if (i20 < 4) {
                            while (i20 < 4) {
                                cVar.a(0);
                                i20++;
                            }
                        }
                    }
                    i8 = 4;
                }
                int i21 = i8;
                if (i16 == 0 && !hashMapArr[i21].isEmpty()) {
                    cVar.d(iArr2[i21]);
                } else {
                    cVar.d(0L);
                }
                Iterator it3 = hashMapArr[i16].entrySet().iterator();
                while (it3.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it3.next()).getValue()).f1785d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
                i6 = 4;
            } else {
                i6 = i8;
            }
            i16++;
            i8 = i6;
        }
        if (this.f1835h) {
            cVar.write(m());
        }
        if (this.f1830c == 14 && i12 % 2 == i4) {
            cVar.a(0);
        }
        cVar.f1781g = ByteOrder.BIG_ENDIAN;
        return size;
    }

    public final void H(c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f1841o = cVar.f1780f.size() + G(new c(byteArrayOutputStream, ByteOrder.BIG_ENDIAN));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        cVar.write(byteArray);
        CRC32 crc32 = new CRC32();
        crc32.update(byteArray, 4, byteArray.length - 4);
        cVar.b((int) crc32.getValue());
    }

    public final void I(c cVar) {
        cVar.b(this.f1845s.f1785d.length + 22);
        CRC32 crc32 = new CRC32();
        cVar.b(1767135348);
        crc32.update(105);
        crc32.update(26964);
        crc32.update(6902872);
        crc32.update(1767135348);
        byte[] bArr = f1798G;
        cVar.write(bArr);
        crc32.update(bArr);
        cVar.write(this.f1845s.f1785d);
        crc32.update(this.f1845s.f1785d);
        cVar.b((int) crc32.getValue());
        this.f1846t = true;
    }

    public final void a() {
        String b4 = b("DateTimeOriginal");
        HashMap[] hashMapArr = this.f1832e;
        if (b4 != null && b("DateTime") == null) {
            hashMapArr[0].put("DateTime", d.b(b4));
        }
        if (b("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", d.c(0L, this.f1834g));
        }
        if (b("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", d.c(0L, this.f1834g));
        }
        if (b("Orientation") == null) {
            hashMapArr[0].put("Orientation", d.c(0L, this.f1834g));
        }
        if (b("LightSource") == null) {
            hashMapArr[1].put("LightSource", d.c(0L, this.f1834g));
        }
    }

    public final String b(String str) {
        if (str != null) {
            d c4 = c(str);
            if (c4 != null) {
                int i4 = c4.f1782a;
                if (str.equals("GPSTimeStamp")) {
                    if (i4 != 5 && i4 != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i4);
                        return null;
                    }
                    f[] fVarArr = (f[]) c4.k(this.f1834g);
                    if (fVarArr != null && fVarArr.length == 3) {
                        f fVar = fVarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) fVar.f1790a) / ((float) fVar.f1791b)));
                        f fVar2 = fVarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) fVar2.f1790a) / ((float) fVar2.f1791b)));
                        f fVar3 = fVarArr[2];
                        return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) fVar3.f1790a) / ((float) fVar3.f1791b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                if (f1815Y.contains(str)) {
                    try {
                        return Double.toString(c4.h(this.f1834g));
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    return c4.j(this.f1834g);
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final d c(String str) {
        d dVar;
        int i4;
        d dVar2;
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f1823u) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            if ("Xmp".equals(str) && (i4 = this.f1830c) != 4 && ((i4 == 9 || i4 == 15 || i4 == 12 || i4 == 13) && (dVar2 = this.f1845s) != null)) {
                return dVar2;
            }
            for (int i5 = 0; i5 < f1811U.length; i5++) {
                d dVar3 = (d) this.f1832e[i5].get(str);
                if (dVar3 != null) {
                    return dVar3;
                }
            }
            if ("Xmp".equals(str) && (dVar = this.f1845s) != null) {
                return dVar;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void d(g gVar, int i4) {
        String str;
        String str2;
        String str3;
        int i5;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 28) {
            if (i4 == 15 && i6 < 31) {
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
                    HashMap[] hashMapArr = this.f1832e;
                    if (str != null) {
                        hashMapArr[0].put("ImageWidth", d.f(Integer.parseInt(str), this.f1834g));
                    }
                    if (str3 != null) {
                        hashMapArr[0].put("ImageLength", d.f(Integer.parseInt(str3), this.f1834g));
                    }
                    if (str2 != null) {
                        int parseInt = Integer.parseInt(str2);
                        if (parseInt != 90) {
                            if (parseInt != 180) {
                                if (parseInt != 270) {
                                    i5 = 1;
                                } else {
                                    i5 = 8;
                                }
                            } else {
                                i5 = 3;
                            }
                        } else {
                            i5 = 6;
                        }
                        hashMapArr[0].put("Orientation", d.f(i5, this.f1834g));
                    }
                    if (extractMetadata != null && extractMetadata2 != null) {
                        int parseInt2 = Integer.parseInt(extractMetadata);
                        int parseInt3 = Integer.parseInt(extractMetadata2);
                        if (parseInt3 > 6) {
                            gVar.b(parseInt2);
                            byte[] bArr = new byte[6];
                            gVar.readFully(bArr);
                            int i7 = parseInt2 + 6;
                            int i8 = parseInt3 - 6;
                            if (Arrays.equals(bArr, f1818b0)) {
                                byte[] bArr2 = new byte[i8];
                                gVar.readFully(bArr2);
                                this.f1841o = i7;
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
                        long j4 = parseInt4;
                        gVar.b(j4);
                        byte[] bArr3 = new byte[parseInt5];
                        gVar.readFully(bArr3);
                        this.f1845s = new d(j4, bArr3, 1, parseInt5);
                        this.f1846t = true;
                    }
                    if (f1823u) {
                        Log.d("ExifInterface", "Heif meta: " + str + "x" + str3 + ", rotation " + str2);
                    }
                    try {
                        mediaMetadataRetriever.release();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } catch (RuntimeException e4) {
                    throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e4);
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
    
        r22.f1777h = r21.f1834g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(W.b r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.h.e(W.b, int, int):void");
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
        throw new UnsupportedOperationException("Method not decompiled: W.h.f(java.io.BufferedInputStream):int");
    }

    public final void g(g gVar) {
        int i4;
        int i5;
        j(gVar);
        HashMap[] hashMapArr = this.f1832e;
        d dVar = (d) hashMapArr[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f1785d);
            gVar2.f1777h = this.f1834g;
            byte[] bArr = f1795D;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.b(0L);
            byte[] bArr3 = f1796E;
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
                int[] iArr = (int[]) dVar4.k(this.f1834g);
                if (iArr != null && iArr.length == 4) {
                    int i6 = iArr[2];
                    int i7 = iArr[0];
                    if (i6 > i7 && (i4 = iArr[3]) > (i5 = iArr[1])) {
                        int i8 = (i6 - i7) + 1;
                        int i9 = (i4 - i5) + 1;
                        if (i8 < i9) {
                            int i10 = i8 + i9;
                            i9 = i10 - i9;
                            i8 = i10 - i9;
                        }
                        d f4 = d.f(i8, this.f1834g);
                        d f5 = d.f(i9, this.f1834g);
                        hashMapArr[0].put("ImageWidth", f4);
                        hashMapArr[0].put("ImageLength", f5);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    public final void h(b bVar) {
        if (f1823u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f1777h = ByteOrder.BIG_ENDIAN;
        int i4 = bVar.f1776g;
        bVar.a(f1797F.length);
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (z3 && z4) {
                break;
            }
            try {
                int readInt = bVar.readInt();
                int readInt2 = bVar.readInt();
                int i5 = bVar.f1776g;
                int i6 = i5 + readInt + 4;
                int i7 = i5 - i4;
                if (i7 == 16 && readInt2 != 1229472850) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appear as the first chunk");
                }
                if (readInt2 == 1229278788) {
                    break;
                }
                if (readInt2 == 1700284774 && !z3) {
                    this.f1841o = i7;
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
                        z3 = true;
                    } else {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt3 + ", calculated CRC value: " + crc32.getValue());
                    }
                } else if (readInt2 == 1767135348 && !z4) {
                    byte[] bArr2 = f1798G;
                    if (readInt >= bArr2.length) {
                        int length = bArr2.length;
                        byte[] bArr3 = new byte[length];
                        bVar.readFully(bArr3);
                        if (Arrays.equals(bArr3, bArr2)) {
                            int i8 = bVar.f1776g - i4;
                            int i9 = readInt - length;
                            byte[] bArr4 = new byte[i9];
                            bVar.readFully(bArr4);
                            this.f1845s = new d(i8, bArr4, 1, i9);
                            z4 = true;
                        }
                    }
                }
                bVar.a(i6 - bVar.f1776g);
            } catch (EOFException e4) {
                throw new IOException("Encountered corrupt PNG file.", e4);
            }
        }
        this.f1846t = z4;
    }

    public final void i(b bVar) {
        boolean z3 = f1823u;
        if (z3) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i4 = ByteBuffer.wrap(bArr).getInt();
        int i5 = ByteBuffer.wrap(bArr2).getInt();
        int i6 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i5];
        bVar.a(i4 - bVar.f1776g);
        bVar.readFully(bArr4);
        e(new b(bArr4), i4, 5);
        bVar.a(i6 - bVar.f1776g);
        bVar.f1777h = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        if (z3) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i7 = 0; i7 < readInt; i7++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f1810T.f1786a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d f4 = d.f(readShort, this.f1834g);
                d f5 = d.f(readShort2, this.f1834g);
                HashMap[] hashMapArr = this.f1832e;
                hashMapArr[0].put("ImageLength", f4);
                hashMapArr[0].put("ImageWidth", f5);
                if (z3) {
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
        if (this.f1830c == 8) {
            HashMap[] hashMapArr = this.f1832e;
            d dVar = (d) hashMapArr[1].get("MakerNote");
            if (dVar != null) {
                g gVar2 = new g(dVar.f1785d);
                gVar2.f1777h = this.f1834g;
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
        if (f1823u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        j(gVar);
        HashMap[] hashMapArr = this.f1832e;
        d dVar = (d) hashMapArr[0].get("JpgFromRaw");
        if (dVar != null) {
            e(new b(dVar.f1785d), (int) dVar.f1784c, 5);
        }
        d dVar2 = (d) hashMapArr[0].get("ISO");
        d dVar3 = (d) hashMapArr[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            hashMapArr[1].put("PhotographicSensitivity", dVar2);
        }
    }

    public final boolean l(g gVar) {
        byte[] bArr = f1818b0;
        byte[] bArr2 = new byte[bArr.length];
        gVar.readFully(bArr2);
        if (!Arrays.equals(bArr2, bArr)) {
            Log.w("ExifInterface", "Given data is not EXIF-only.");
            return false;
        }
        byte[] bArr3 = new byte[1024];
        int i4 = 0;
        while (true) {
            if (i4 == bArr3.length) {
                bArr3 = Arrays.copyOf(bArr3, bArr3.length * 2);
            }
            int read = gVar.f1775f.read(bArr3, i4, bArr3.length - i4);
            if (read != -1) {
                i4 += read;
                gVar.f1776g += read;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr3, i4);
                this.f1841o = bArr.length;
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
            boolean r3 = r10.f1835h
            r4 = 0
            if (r3 != 0) goto Ld
            goto L82
        Ld:
            byte[] r3 = r10.f1839m
            if (r3 == 0) goto L12
            return r3
        L12:
            java.lang.String r3 = r10.f1828a     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            if (r3 == 0) goto L27
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.String r5 = r10.f1828a     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
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
            java.io.FileDescriptor r3 = r10.f1829b     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
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
            W.b r6 = new W.b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r7 = r10.k     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r8 = r10.f1841o     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r7 = r7 + r8
            r6.a(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r7 = r10.f1838l     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r6.readFully(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r10.f1839m = r7     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            a.AbstractC0141a.f(r3)
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
            a.AbstractC0141a.f(r5)
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
            a.AbstractC0141a.f(r4)
            if (r5 == 0) goto L93
            android.system.Os.close(r5)     // Catch: android.system.ErrnoException -> L8f
            goto L93
        L8f:
            r3 = move-exception
            android.util.Log.e(r1, r0, r3)
        L93:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: W.h.m():byte[]");
    }

    public final void n(b bVar) {
        if (f1823u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f1777h = ByteOrder.LITTLE_ENDIAN;
        bVar.a(f1799H.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f1800I;
        bVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int readInt2 = bVar.readInt();
                int i4 = length + 8;
                if (Arrays.equals(f1801J, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    bVar.readFully(bArr3);
                    byte[] bArr4 = f1818b0;
                    if (AbstractC0141a.H(bArr3, bArr4)) {
                        bArr3 = Arrays.copyOfRange(bArr3, bArr4.length, readInt2);
                    }
                    this.f1841o = i4;
                    v(bArr3, 0);
                    C(new b(bArr3));
                    return;
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i4 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length <= readInt) {
                    bVar.a(readInt2);
                } else {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
            } catch (EOFException e4) {
                throw new IOException("Encountered corrupt WebP file.", e4);
            }
        }
    }

    public final void p(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int i4 = dVar.i(this.f1834g);
            int i5 = dVar2.i(this.f1834g);
            if (this.f1830c == 7) {
                i4 += this.f1842p;
            }
            if (i4 > 0 && i5 > 0) {
                this.f1835h = true;
                if (this.f1828a == null && this.f1829b == null) {
                    byte[] bArr = new byte[i5];
                    bVar.a(i4);
                    bVar.readFully(bArr);
                    this.f1839m = bArr;
                }
                this.k = i4;
                this.f1838l = i5;
            }
            if (f1823u) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i4 + ", length: " + i5);
            }
        }
    }

    public final boolean q(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar != null && dVar2 != null) {
            int i4 = dVar.i(this.f1834g);
            int i5 = dVar2.i(this.f1834g);
            if (i4 <= 512 && i5 <= 512) {
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
            boolean r0 = W.h.f1823u
            r1 = 0
            r2 = r1
        L4:
            W.e[][] r3 = W.h.f1811U     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r3 = r3.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 >= r3) goto L1e
            java.util.HashMap[] r3 = r8.f1832e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
            boolean r2 = r8.f1831d
            if (r2 != 0) goto L30
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4 = 5000(0x1388, float:7.006E-42)
            r3.<init>(r9, r4)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r9 = r8.f(r3)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.f1830c = r9     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r9 = r3
        L30:
            int r3 = r8.f1830c     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
            W.g r1 = new W.g     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r2 == 0) goto L58
            boolean r9 = r8.l(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r9 != 0) goto L79
            r8.a()
            if (r0 == 0) goto Lc5
            r8.t()
            return
        L58:
            int r9 = r8.f1830c     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
            int r9 = r8.f1841o     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r2 = (long) r9     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.b(r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r8.C(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto La1
        L83:
            W.b r2 = new W.b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r9 = r8.f1830c     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
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
        throw new UnsupportedOperationException("Method not decompiled: W.h.r(java.io.InputStream):void");
    }

    public final void s(g gVar) {
        ByteOrder u3 = u(gVar);
        this.f1834g = u3;
        gVar.f1777h = u3;
        int readUnsignedShort = gVar.readUnsignedShort();
        int i4 = this.f1830c;
        if (i4 != 7 && i4 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = gVar.readInt();
        if (readInt >= 8) {
            int i5 = readInt - 8;
            if (i5 > 0) {
                gVar.a(i5);
                return;
            }
            return;
        }
        throw new IOException(i.g(readInt, "Invalid first Ifd offset: "));
    }

    public final void t() {
        int i4 = 0;
        while (true) {
            HashMap[] hashMapArr = this.f1832e;
            if (i4 < hashMapArr.length) {
                Log.d("ExifInterface", "The size of tag group[" + i4 + "]: " + hashMapArr[i4].size());
                for (Map.Entry entry : hashMapArr[i4].entrySet()) {
                    d dVar = (d) entry.getValue();
                    Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.j(this.f1834g) + "'");
                }
                i4++;
            } else {
                return;
            }
        }
    }

    public final void v(byte[] bArr, int i4) {
        g gVar = new g(bArr);
        s(gVar);
        w(gVar, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0299  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(W.g r30, int r31) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.h.w(W.g, int):void");
    }

    public final void x(String str) {
        for (int i4 = 0; i4 < f1811U.length; i4++) {
            this.f1832e[i4].remove(str);
        }
    }

    public final void y(int i4, String str, String str2) {
        HashMap[] hashMapArr = this.f1832e;
        if (!hashMapArr[i4].isEmpty() && hashMapArr[i4].get(str) != null) {
            HashMap hashMap = hashMapArr[i4];
            hashMap.put(str2, (d) hashMap.get(str));
            hashMapArr[i4].remove(str);
        }
    }

    public final void z(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        byte readByte;
        byte[] bArr;
        if (f1823u) {
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
                this.f1841o = G(cVar);
                d dVar = this.f1845s;
                byte[] bArr2 = f1819c0;
                if (dVar != null) {
                    cVar.write(-1);
                    cVar.a(-31);
                    cVar.e(bArr2.length + 2 + this.f1845s.f1785d.length);
                    cVar.write(bArr2);
                    cVar.write(this.f1845s.f1785d);
                    this.f1846t = true;
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
                            int i4 = readUnsignedShort - 2;
                            if (i4 >= 0) {
                                while (i4 > 0) {
                                    int read = bVar.read(bArr3, 0, Math.min(i4, 4096));
                                    if (read >= 0) {
                                        cVar.write(bArr3, 0, read);
                                        i4 -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = bVar.readUnsignedShort();
                            int i5 = readUnsignedShort2 - 2;
                            if (i5 >= 0) {
                                int length = bArr2.length;
                                byte[] bArr4 = f1818b0;
                                if (i5 >= length) {
                                    bArr = new byte[bArr2.length];
                                } else if (i5 >= bArr4.length) {
                                    bArr = new byte[bArr4.length];
                                } else {
                                    bArr = null;
                                }
                                if (bArr != null) {
                                    bVar.readFully(bArr);
                                    if (AbstractC0141a.H(bArr, bArr4) || AbstractC0141a.H(bArr, bArr2)) {
                                        bVar.a(i5 - bArr.length);
                                    }
                                }
                                cVar.a(-1);
                                cVar.a(readByte);
                                cVar.e(readUnsignedShort2);
                                if (bArr != null) {
                                    i5 -= bArr.length;
                                    cVar.write(bArr);
                                }
                                while (i5 > 0) {
                                    int read2 = bVar.read(bArr3, 0, Math.min(i5, 4096));
                                    if (read2 >= 0) {
                                        cVar.write(bArr3, 0, read2);
                                        i5 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        cVar.a(-1);
                        cVar.a(readByte);
                        AbstractC0141a.i(bVar, cVar);
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
        e[][] eVarArr = f1811U;
        this.f1832e = new HashMap[eVarArr.length];
        this.f1833f = new HashSet(eVarArr.length);
        this.f1834g = ByteOrder.BIG_ENDIAN;
        this.f1828a = null;
        this.f1831d = false;
        this.f1829b = null;
        r(byteArrayInputStream);
    }
}
