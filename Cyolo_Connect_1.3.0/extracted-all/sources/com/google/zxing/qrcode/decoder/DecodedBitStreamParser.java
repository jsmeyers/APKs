package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.kxml2.wap.Wbxml;

/* JADX INFO: loaded from: classes3.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:41:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:42:0x00e7  */
    /* JADX WARN: Found duplicated region for block: B:43:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Found duplicated region for block: B:45:0x00ee  */
    /* JADX WARN: Found duplicated region for block: B:46:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:47:0x00f2  */
    /* JADX WARN: Found duplicated region for block: B:48:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:49:0x00f6  */
    /* JADX WARN: Found duplicated region for block: B:50:0x00f9  */
    /* JADX WARN: Found duplicated region for block: B:53:0x0106  */
    /* JADX WARN: Found duplicated region for block: B:54:0x0108  */
    /* JADX WARN: Found duplicated region for block: B:57:0x010c  */
    /* JADX WARN: Found duplicated region for block: B:60:0x011d A[LOOP:0: B:63:0x0022->B:60:0x011d, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:67:0x00e3 A[SYNTHETIC] */
    static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode modeForBits;
        Mode mode;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECIByValue = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = -1;
        int bits = -1;
        while (true) {
            try {
                if (bitSource.available() < 4) {
                    modeForBits = Mode.TERMINATOR;
                } else {
                    modeForBits = Mode.forBits(bitSource.readBits(4));
                }
                Mode mode2 = modeForBits;
                switch (mode2) {
                    case TERMINATOR:
                        mode = mode2;
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                    case FNC1_FIRST_POSITION:
                        mode = mode2;
                        z = true;
                        z2 = true;
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                    case FNC1_SECOND_POSITION:
                        mode = mode2;
                        z = true;
                        z3 = true;
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                    case STRUCTURED_APPEND:
                        if (bitSource.available() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int bits2 = bitSource.readBits(8);
                        bits = bitSource.readBits(8);
                        i2 = bits2;
                        mode = mode2;
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                        break;
                    case ECI:
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                        mode = mode2;
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                    case HANZI:
                        int bits3 = bitSource.readBits(4);
                        int bits4 = bitSource.readBits(mode2.getCharacterCountBits(version));
                        if (bits3 == i) {
                            decodeHanziSegment(bitSource, sb, bits4);
                        }
                        mode = mode2;
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                    default:
                        int bits5 = bitSource.readBits(mode2.getCharacterCountBits(version));
                        int i3 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode2.ordinal()];
                        if (i3 == i) {
                            mode = mode2;
                            decodeNumericSegment(bitSource, sb, bits5);
                        } else if (i3 == 2) {
                            mode = mode2;
                            decodeAlphanumericSegment(bitSource, sb, bits5, z);
                        } else if (i3 == 3) {
                            mode = mode2;
                            decodeByteSegment(bitSource, sb, bits5, characterSetECIByValue, arrayList, map);
                        } else if (i3 == 4) {
                            decodeKanjiSegment(bitSource, sb, bits5);
                            mode = mode2;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        if (mode == Mode.TERMINATOR) {
                            return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, i2, bits, characterSetECIByValue != null ? z2 ? 4 : z3 ? 6 : 2 : z2 ? 3 : z3 ? 5 : 1);
                        }
                        i = 1;
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % 96) | ((bits / 96) << 8);
            int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
            bArr[i2] = (byte) ((i4 >> 8) & 255);
            bArr[i2 + 1] = (byte) (i4 & 255);
            i2 += 2;
            i--;
        }
        sb.append(new String(bArr, StringUtils.GB2312_CHARSET));
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % Wbxml.EXT_0) | ((bits / Wbxml.EXT_0) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        sb.append(new String(bArr, StringUtils.SHIFT_JIS_CHARSET));
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        Charset charset;
        if (i * 8 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) bitSource.readBits(8);
        }
        if (characterSetECI == null) {
            charset = StringUtils.guessCharset(bArr, map);
        } else {
            charset = characterSetECI.getCharset();
        }
        sb.append(new String(bArr, charset));
        collection.add(bArr);
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i >= cArr.length) {
            throw FormatException.getFormatInstance();
        }
        return cArr[i];
    }

    /* JADX WARN: Found duplicated region for block: B:26:0x006a  */
    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(bits / 45));
            sb.append(toAlphaNumericChar(bits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(10);
            if (bits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits / 100));
            sb.append(toAlphaNumericChar((bits / 10) % 10));
            sb.append(toAlphaNumericChar(bits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int bits2 = bitSource.readBits(7);
            if (bits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits2 / 10));
            sb.append(toAlphaNumericChar(bits2 % 10));
            return;
        }
        if (i == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int bits3 = bitSource.readBits(4);
            if (bits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits3));
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int bits = bitSource.readBits(8);
        if ((bits & 128) == 0) {
            return bits & 127;
        }
        if ((bits & Wbxml.EXT_0) == 128) {
            return bitSource.readBits(8) | ((bits & 63) << 8);
        }
        if ((bits & 224) == 192) {
            return bitSource.readBits(16) | ((bits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }
}
