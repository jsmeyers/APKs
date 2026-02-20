package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int value) {
        return (value & ENFORCE_UTF8_MASK) != 0;
    }

    private static boolean isRequired(int value) {
        return (value & REQUIRED_MASK) != 0;
    }

    private static long offset(int value) {
        return value & 1048575;
    }

    private static int type(int value) {
        return (value & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] buffer, Object[] objects, int minFieldNumber, int maxFieldNumber, MessageLite defaultInstance, boolean proto3, boolean useCachedSizeField, int[] intArray, int checkInitialized, int mapFieldPositions, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = buffer;
        this.objects = objects;
        this.minFieldNumber = minFieldNumber;
        this.maxFieldNumber = maxFieldNumber;
        this.lite = defaultInstance instanceof GeneratedMessageLite;
        this.proto3 = proto3;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(defaultInstance);
        this.useCachedSizeField = useCachedSizeField;
        this.intArray = intArray;
        this.checkInitializedCount = checkInitialized;
        this.repeatedFieldOffsetStart = mapFieldPositions;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T> MessageSchema<T> newSchema(Class<T> messageClass, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Found duplicated region for block: B:122:0x024d  */
    /* JADX WARN: Found duplicated region for block: B:123:0x0250  */
    /* JADX WARN: Found duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Found duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Found duplicated region for block: B:161:0x031a  */
    /* JADX WARN: Found duplicated region for block: B:162:0x031c  */
    /* JADX WARN: Found duplicated region for block: B:164:0x031f  */
    /* JADX WARN: Found duplicated region for block: B:179:0x036e  */
    /* JADX WARN: Found duplicated region for block: B:182:0x037c  */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int iCharAt5;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        int i5;
        char cCharAt2;
        int i6;
        char cCharAt3;
        int i7;
        char cCharAt4;
        int i8;
        char cCharAt5;
        int i9;
        char cCharAt6;
        int i10;
        char cCharAt7;
        int i11;
        char cCharAt8;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        String str;
        boolean z;
        Object[] objArr;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        java.lang.reflect.Field fieldReflectField;
        char cCharAt9;
        int i20;
        int i21;
        int i22;
        Object obj;
        java.lang.reflect.Field fieldReflectField2;
        int i23;
        Object obj2;
        java.lang.reflect.Field fieldReflectField3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        boolean z2 = messageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = messageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i28 = 1;
            while (true) {
                i = i28 + 1;
                if (stringInfo.charAt(i28) < 55296) {
                    break;
                }
                i28 = i;
            }
        } else {
            i = 1;
        }
        int i29 = i + 1;
        int iCharAt6 = stringInfo.charAt(i);
        if (iCharAt6 >= 55296) {
            int i30 = iCharAt6 & 8191;
            int i31 = 13;
            while (true) {
                i27 = i29 + 1;
                cCharAt13 = stringInfo.charAt(i29);
                if (cCharAt13 < 55296) {
                    break;
                }
                i30 |= (cCharAt13 & 8191) << i31;
                i31 += 13;
                i29 = i27;
            }
            iCharAt6 = i30 | (cCharAt13 << i31);
            i29 = i27;
        }
        if (iCharAt6 == 0) {
            iArr = EMPTY_INT_ARRAY;
            i3 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            iCharAt4 = 0;
            iCharAt5 = 0;
            i2 = 0;
        } else {
            int i32 = i29 + 1;
            int iCharAt7 = stringInfo.charAt(i29);
            if (iCharAt7 >= 55296) {
                int i33 = iCharAt7 & 8191;
                int i34 = 13;
                while (true) {
                    i11 = i32 + 1;
                    cCharAt8 = stringInfo.charAt(i32);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt8 & 8191) << i34;
                    i34 += 13;
                    i32 = i11;
                }
                iCharAt7 = i33 | (cCharAt8 << i34);
                i32 = i11;
            }
            int i35 = i32 + 1;
            int iCharAt8 = stringInfo.charAt(i32);
            if (iCharAt8 >= 55296) {
                int i36 = iCharAt8 & 8191;
                int i37 = 13;
                while (true) {
                    i10 = i35 + 1;
                    cCharAt7 = stringInfo.charAt(i35);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt7 & 8191) << i37;
                    i37 += 13;
                    i35 = i10;
                }
                iCharAt8 = i36 | (cCharAt7 << i37);
                i35 = i10;
            }
            int i38 = i35 + 1;
            iCharAt = stringInfo.charAt(i35);
            if (iCharAt >= 55296) {
                int i39 = iCharAt & 8191;
                int i40 = 13;
                while (true) {
                    i9 = i38 + 1;
                    cCharAt6 = stringInfo.charAt(i38);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt6 & 8191) << i40;
                    i40 += 13;
                    i38 = i9;
                }
                iCharAt = i39 | (cCharAt6 << i40);
                i38 = i9;
            }
            int i41 = i38 + 1;
            iCharAt2 = stringInfo.charAt(i38);
            if (iCharAt2 >= 55296) {
                int i42 = iCharAt2 & 8191;
                int i43 = 13;
                while (true) {
                    i8 = i41 + 1;
                    cCharAt5 = stringInfo.charAt(i41);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt5 & 8191) << i43;
                    i43 += 13;
                    i41 = i8;
                }
                iCharAt2 = i42 | (cCharAt5 << i43);
                i41 = i8;
            }
            int i44 = i41 + 1;
            iCharAt3 = stringInfo.charAt(i41);
            if (iCharAt3 >= 55296) {
                int i45 = iCharAt3 & 8191;
                int i46 = 13;
                while (true) {
                    i7 = i44 + 1;
                    cCharAt4 = stringInfo.charAt(i44);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt4 & 8191) << i46;
                    i46 += 13;
                    i44 = i7;
                }
                iCharAt3 = i45 | (cCharAt4 << i46);
                i44 = i7;
            }
            int i47 = i44 + 1;
            iCharAt4 = stringInfo.charAt(i44);
            if (iCharAt4 >= 55296) {
                int i48 = iCharAt4 & 8191;
                int i49 = 13;
                while (true) {
                    i6 = i47 + 1;
                    cCharAt3 = stringInfo.charAt(i47);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt3 & 8191) << i49;
                    i49 += 13;
                    i47 = i6;
                }
                iCharAt4 = i48 | (cCharAt3 << i49);
                i47 = i6;
            }
            int i50 = i47 + 1;
            int iCharAt9 = stringInfo.charAt(i47);
            if (iCharAt9 >= 55296) {
                int i51 = iCharAt9 & 8191;
                int i52 = 13;
                while (true) {
                    i5 = i50 + 1;
                    cCharAt2 = stringInfo.charAt(i50);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt2 & 8191) << i52;
                    i52 += 13;
                    i50 = i5;
                }
                iCharAt9 = i51 | (cCharAt2 << i52);
                i50 = i5;
            }
            int i53 = i50 + 1;
            iCharAt5 = stringInfo.charAt(i50);
            if (iCharAt5 >= 55296) {
                int i54 = iCharAt5 & 8191;
                int i55 = 13;
                while (true) {
                    i4 = i53 + 1;
                    cCharAt = stringInfo.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i55;
                    i55 += 13;
                    i53 = i4;
                }
                iCharAt5 = i54 | (cCharAt << i55);
                i53 = i4;
            }
            iArr = new int[iCharAt5 + iCharAt4 + iCharAt9];
            i2 = (iCharAt7 * 2) + iCharAt8;
            i3 = iCharAt7;
            i29 = i53;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = messageInfo.getObjects();
        Class<?> cls = messageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[iCharAt3 * 3];
        Object[] objArr2 = new Object[iCharAt3 * 2];
        int i56 = iCharAt5 + iCharAt4;
        int i57 = iCharAt5;
        int i58 = i56;
        int i59 = 0;
        int i60 = 0;
        while (i29 < length) {
            int i61 = i29 + 1;
            int iCharAt10 = stringInfo.charAt(i29);
            if (iCharAt10 >= c) {
                int i62 = iCharAt10 & 8191;
                int i63 = i61;
                int i64 = 13;
                while (true) {
                    i26 = i63 + 1;
                    cCharAt12 = stringInfo.charAt(i63);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i62 |= (cCharAt12 & 8191) << i64;
                    i64 += 13;
                    i63 = i26;
                }
                iCharAt10 = i62 | (cCharAt12 << i64);
                i12 = i26;
            } else {
                i12 = i61;
            }
            int i65 = i12 + 1;
            int iCharAt11 = stringInfo.charAt(i12);
            if (iCharAt11 >= c) {
                int i66 = iCharAt11 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i25 = i67 + 1;
                    cCharAt11 = stringInfo.charAt(i67);
                    i13 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i66 |= (cCharAt11 & 8191) << i68;
                    i68 += 13;
                    i67 = i25;
                    length = i13;
                }
                iCharAt11 = i66 | (cCharAt11 << i68);
                i14 = i25;
            } else {
                i13 = length;
                i14 = i65;
            }
            int i69 = iCharAt11 & 255;
            int i70 = iCharAt5;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i59] = i60;
                i59++;
            }
            int i71 = i59;
            if (i69 >= 51) {
                int i72 = i14 + 1;
                int iCharAt12 = stringInfo.charAt(i14);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i73 = iCharAt12 & 8191;
                    int i74 = 13;
                    while (true) {
                        i24 = i72 + 1;
                        cCharAt10 = stringInfo.charAt(i72);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i73 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i72 = i24;
                        c2 = 55296;
                    }
                    iCharAt12 = i73 | (cCharAt10 << i74);
                    i72 = i24;
                }
                int i75 = i69 - 51;
                int i76 = i72;
                if (i75 == 9 || i75 == 17) {
                    i21 = i2 + 1;
                    objArr2[((i60 / 3) * 2) + 1] = objects[i2];
                } else {
                    if (i75 == 12 && !z2) {
                        i21 = i2 + 1;
                        objArr2[((i60 / 3) * 2) + 1] = objects[i2];
                    }
                    i22 = iCharAt12 * 2;
                    obj = objects[i22];
                    if (obj instanceof java.lang.reflect.Field) {
                        fieldReflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i22] = fieldReflectField2;
                    }
                    i15 = iCharAt;
                    i16 = iCharAt2;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i23 = i22 + 1;
                    obj2 = objects[i23];
                    if (obj2 instanceof java.lang.reflect.Field) {
                        fieldReflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i23] = fieldReflectField3;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    str = stringInfo;
                    z = z2;
                    objArr = objArr2;
                    i18 = i76;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i19 = 0;
                }
                i2 = i21;
                i22 = iCharAt12 * 2;
                obj = objects[i22];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i22] = fieldReflectField2;
                }
                i15 = iCharAt;
                i16 = iCharAt2;
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i23 = i22 + 1;
                obj2 = objects[i23];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i23] = fieldReflectField3;
                }
                int iObjectFieldOffset42 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                str = stringInfo;
                z = z2;
                objArr = objArr2;
                i18 = i76;
                iObjectFieldOffset2 = iObjectFieldOffset42;
                iObjectFieldOffset = iObjectFieldOffset32;
                i19 = 0;
            } else {
                i15 = iCharAt;
                i16 = iCharAt2;
                int i77 = i2 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i69 == 9 || i69 == 17) {
                    objArr2[((i60 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i69 == 27 || i69 == 49) {
                        i20 = i77 + 1;
                        objArr2[((i60 / 3) * 2) + 1] = objects[i77];
                    } else if (i69 == 12 || i69 == 30 || i69 == 44) {
                        if (!z2) {
                            i20 = i77 + 1;
                            objArr2[((i60 / 3) * 2) + 1] = objects[i77];
                        }
                    } else if (i69 == 50) {
                        int i78 = i57 + 1;
                        iArr[i57] = i60;
                        int i79 = (i60 / 3) * 2;
                        int i80 = i77 + 1;
                        objArr2[i79] = objects[i77];
                        if ((iCharAt11 & 2048) != 0) {
                            i77 = i80 + 1;
                            objArr2[i79 + 1] = objects[i80];
                            i57 = i78;
                        } else {
                            i57 = i78;
                            i17 = i80;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        int i81 = i17;
                        if (((iCharAt11 & 4096) == 4096) || i69 > 17) {
                            str = stringInfo;
                            z = z2;
                            objArr = objArr2;
                            iObjectFieldOffset2 = 1048575;
                            i18 = i14;
                            i19 = 0;
                        } else {
                            int i82 = i14 + 1;
                            int iCharAt13 = stringInfo.charAt(i14);
                            if (iCharAt13 >= 55296) {
                                int i83 = iCharAt13 & 8191;
                                int i84 = 13;
                                while (true) {
                                    i18 = i82 + 1;
                                    cCharAt9 = stringInfo.charAt(i82);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i83 |= (cCharAt9 & 8191) << i84;
                                    i84 += 13;
                                    i82 = i18;
                                }
                                iCharAt13 = i83 | (cCharAt9 << i84);
                            } else {
                                i18 = i82;
                            }
                            int i85 = (i3 * 2) + (iCharAt13 / 32);
                            Object obj3 = objects[i85];
                            str = stringInfo;
                            if (obj3 instanceof java.lang.reflect.Field) {
                                fieldReflectField = (java.lang.reflect.Field) obj3;
                            } else {
                                fieldReflectField = reflectField(cls, (String) obj3);
                                objects[i85] = fieldReflectField;
                            }
                            z = z2;
                            objArr = objArr2;
                            i19 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                        }
                        if (i69 >= 18 && i69 <= 49) {
                            iArr[i58] = iObjectFieldOffset;
                            i58++;
                        }
                        i2 = i81;
                    }
                    i17 = i20;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    int i812 = i17;
                    if ((iCharAt11 & 4096) == 4096) {
                        str = stringInfo;
                        z = z2;
                        objArr = objArr2;
                        iObjectFieldOffset2 = 1048575;
                        i18 = i14;
                        i19 = 0;
                    } else {
                        str = stringInfo;
                        z = z2;
                        objArr = objArr2;
                        iObjectFieldOffset2 = 1048575;
                        i18 = i14;
                        i19 = 0;
                    }
                    if (i69 >= 18) {
                        iArr[i58] = iObjectFieldOffset;
                        i58++;
                    }
                    i2 = i812;
                }
                i17 = i77;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                int i8122 = i17;
                if ((iCharAt11 & 4096) == 4096) {
                    str = stringInfo;
                    z = z2;
                    objArr = objArr2;
                    iObjectFieldOffset2 = 1048575;
                    i18 = i14;
                    i19 = 0;
                } else {
                    str = stringInfo;
                    z = z2;
                    objArr = objArr2;
                    iObjectFieldOffset2 = 1048575;
                    i18 = i14;
                    i19 = 0;
                }
                if (i69 >= 18) {
                    iArr[i58] = iObjectFieldOffset;
                    i58++;
                }
                i2 = i8122;
            }
            int i86 = i60 + 1;
            iArr2[i60] = iCharAt10;
            int i87 = i86 + 1;
            iArr2[i86] = ((iCharAt11 & 256) != 0 ? REQUIRED_MASK : 0) | ((iCharAt11 & 512) != 0 ? ENFORCE_UTF8_MASK : 0) | (i69 << 20) | iObjectFieldOffset;
            i60 = i87 + 1;
            iArr2[i87] = (i19 << 20) | iObjectFieldOffset2;
            z2 = z;
            objArr2 = objArr;
            iCharAt = i15;
            iCharAt5 = i70;
            length = i13;
            i29 = i18;
            i59 = i71;
            stringInfo = str;
            iCharAt2 = i16;
            c = 55296;
        }
        return new MessageSchema<>(iArr2, objArr2, iCharAt, iCharAt2, messageInfo.getDefaultInstance(), z2, false, iArr, iCharAt5, i56, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static java.lang.reflect.Field reflectField(Class<?> messageClass, String fieldName) {
        try {
            return messageClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = messageClass.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (fieldName.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + fieldName + " for " + messageClass.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z = messageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = messageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = messageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i7] = i5;
                i7++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    i = i5;
                    iArr3[i8] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i8++;
                }
                i4++;
                i5 = i + 3;
            }
            i = i5;
            i4++;
            i5 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, messageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Found duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Found duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Found duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Found duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Found duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Found duplicated region for block: B:34:0x00b4  */
    /* JADX WARN: Found duplicated region for block: B:35:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Found duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Found duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Found duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    private static void storeFieldData(FieldInfo fi, int[] buffer, int bufferIndex, Object[] objects) {
        int iObjectFieldOffset;
        int iId;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        Class<?> messageFieldClass;
        int i;
        OneofInfo oneof = fi.getOneof();
        if (oneof != null) {
            iId = fi.getType().id() + 51;
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
            jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        } else {
            FieldType type = fi.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fi.getField());
            iId = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fi.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fi.getPresenceMask());
            } else {
                if (fi.getCachedSizeField() == null) {
                    iObjectFieldOffset2 = 0;
                } else {
                    jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fi.getCachedSizeField());
                }
                iNumberOfTrailingZeros = 0;
            }
            buffer[bufferIndex] = fi.getFieldNumber();
            buffer[bufferIndex + 1] = (fi.isRequired() ? REQUIRED_MASK : 0) | (fi.isEnforceUtf8() ? ENFORCE_UTF8_MASK : 0) | (iId << 20) | iObjectFieldOffset;
            buffer[bufferIndex + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            messageFieldClass = fi.getMessageFieldClass();
            if (fi.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fi.getEnumVerifier() != null) {
                        objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i = (bufferIndex / 3) * 2;
            objects[i] = fi.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objects[i + 1] = messageFieldClass;
            } else if (fi.getEnumVerifier() != null) {
                objects[i + 1] = fi.getEnumVerifier();
            }
        }
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        buffer[bufferIndex] = fi.getFieldNumber();
        if (fi.isEnforceUtf8()) {
        }
        buffer[bufferIndex + 1] = (fi.isRequired() ? REQUIRED_MASK : 0) | (fi.isEnforceUtf8() ? ENFORCE_UTF8_MASK : 0) | (iId << 20) | iObjectFieldOffset;
        buffer[bufferIndex + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        messageFieldClass = fi.getMessageFieldClass();
        if (fi.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objects[((bufferIndex / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fi.getEnumVerifier() != null) {
                    objects[((bufferIndex / 3) * 2) + 1] = fi.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i = (bufferIndex / 3) * 2;
        objects[i] = fi.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objects[i + 1] = messageFieldClass;
        } else if (fi.getEnumVerifier() != null) {
            objects[i + 1] = fi.getEnumVerifier();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T message, T other) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(message, other, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
        }
        return true;
    }

    private boolean equals(T message, T other, int pos) {
        int iTypeAndOffsetAt = typeAndOffsetAt(pos);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(message, other, pos) && Double.doubleToLongBits(UnsafeUtil.getDouble(message, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(other, jOffset));
            case 1:
                return arePresentForEquals(message, other, pos) && Float.floatToIntBits(UnsafeUtil.getFloat(message, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(other, jOffset));
            case 2:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 3:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 4:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 5:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 6:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 7:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getBoolean(message, jOffset) == UnsafeUtil.getBoolean(other, jOffset);
            case 8:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 9:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 10:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 11:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 12:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 13:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 14:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 15:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getInt(message, jOffset) == UnsafeUtil.getInt(other, jOffset);
            case 16:
                return arePresentForEquals(message, other, pos) && UnsafeUtil.getLong(message, jOffset) == UnsafeUtil.getLong(other, jOffset);
            case 17:
                return arePresentForEquals(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(message, other, pos) && SchemaUtil.safeEquals(UnsafeUtil.getObject(message, jOffset), UnsafeUtil.getObject(other, jOffset));
            default:
                return true;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T message) {
        int i;
        int iHashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(message, jOffset)));
                    i2 = i + iHashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(message, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(message, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(message, jOffset)).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(message, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(message, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(message, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(message, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(message, jOffset);
                    i2 = i + iHashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(message, jOffset));
                    i2 = i + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(message, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(message, jOffset)));
                        i2 = i + iHashLong;
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 53:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 55:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(message, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(message, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(message, jOffset)).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(message, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(message, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(message, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 65:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 66:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(message, jOffset);
                        i2 = i + iHashLong;
                    }
                    break;
                case 67:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(message, jOffset));
                        i2 = i + iHashLong;
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(message, jOffset).hashCode();
                        i2 = i + iHashLong;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.unknownFieldSchema.getFromMessage(message).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(message).hashCode() : iHashCode2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, T other) {
        checkMutable(message);
        other.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(message, other, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        }
    }

    private void mergeSingleField(T message, T other, int pos) {
        int iTypeAndOffsetAt = typeAndOffsetAt(pos);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(pos);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putDouble(message, jOffset, UnsafeUtil.getDouble(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 1:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putFloat(message, jOffset, UnsafeUtil.getFloat(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 2:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 3:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 4:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 5:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 6:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 7:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putBoolean(message, jOffset, UnsafeUtil.getBoolean(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 8:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 9:
                mergeMessage(message, other, pos);
                break;
            case 10:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 11:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 12:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 13:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 14:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 15:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putInt(message, jOffset, UnsafeUtil.getInt(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 16:
                if (isFieldPresent(other, pos)) {
                    UnsafeUtil.putLong(message, jOffset, UnsafeUtil.getLong(other, jOffset));
                    setFieldPresent(message, pos);
                }
                break;
            case 17:
                mergeMessage(message, other, pos);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(message, other, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, message, other, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(other, iNumberAt, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setOneofPresent(message, iNumberAt, pos);
                }
                break;
            case 60:
                mergeOneofMessage(message, other, pos);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(other, iNumberAt, pos)) {
                    UnsafeUtil.putObject(message, jOffset, UnsafeUtil.getObject(other, jOffset));
                    setOneofPresent(message, iNumberAt, pos);
                }
                break;
            case 68:
                mergeOneofMessage(message, other, pos);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T targetParent, T sourceParent, int pos) {
        if (isFieldPresent(sourceParent, pos)) {
            long jOffset = offset(typeAndOffsetAt(pos));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(sourceParent, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
            }
            Schema messageFieldSchema = getMessageFieldSchema(pos);
            if (!isFieldPresent(targetParent, pos)) {
                if (!isMutable(object)) {
                    unsafe.putObject(targetParent, jOffset, object);
                } else {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(targetParent, jOffset, objNewInstance);
                }
                setFieldPresent(targetParent, pos);
                return;
            }
            Object object2 = unsafe.getObject(targetParent, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(targetParent, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T targetParent, T sourceParent, int pos) {
        int iNumberAt = numberAt(pos);
        if (isOneofPresent(sourceParent, iNumberAt, pos)) {
            long jOffset = offset(typeAndOffsetAt(pos));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(sourceParent, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(pos) + " is present but null: " + sourceParent);
            }
            Schema messageFieldSchema = getMessageFieldSchema(pos);
            if (!isOneofPresent(targetParent, iNumberAt, pos)) {
                if (!isMutable(object)) {
                    unsafe.putObject(targetParent, jOffset, object);
                } else {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(targetParent, jOffset, objNewInstance);
                }
                setOneofPresent(targetParent, iNumberAt, pos);
                return;
            }
            Object object2 = unsafe.getObject(targetParent, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(targetParent, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int getSerializedSize(T message) {
        return this.proto3 ? getSerializedSizeProto3(message) : getSerializedSizeProto2(message);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:184:0x041e A[PHI: r6
      0x041e: PHI (r6v4 int) = 
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v7 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v8 int)
      (r6v1 int)
     binds: [B:20:0x005f, B:223:0x04c5, B:220:0x04ba, B:214:0x049e, B:211:0x048d, B:208:0x047e, B:205:0x0471, B:202:0x0464, B:198:0x0459, B:195:0x0450, B:192:0x0443, B:189:0x0436, B:186:0x0423, B:160:0x0334, B:154:0x0317, B:148:0x02fa, B:142:0x02dd, B:136:0x02bf, B:130:0x02a1, B:124:0x0283, B:118:0x0265, B:112:0x0247, B:106:0x0229, B:100:0x020b, B:94:0x01ed, B:88:0x01cf, B:82:0x01b1, B:77:0x017d, B:74:0x0171, B:71:0x0161, B:68:0x0151, B:65:0x0141, B:62:0x0135, B:59:0x0128, B:56:0x011b, B:50:0x00fd, B:47:0x00e9, B:44:0x00d7, B:41:0x00c7, B:38:0x00b7, B:200:0x0460, B:35:0x00aa, B:32:0x009e, B:29:0x008e, B:26:0x007e, B:183:0x041d, B:23:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    private int getSerializedSizeProto2(T message) {
        int i;
        int i2;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeSFixed32Size;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        int i7 = 0;
        while (i4 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i4 + 2];
                int i8 = i & i3;
                i2 = 1 << (i >>> 20);
                if (i8 != i6) {
                    i7 = unsafe.getInt(message, i8);
                    i6 = i8;
                }
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i4 + 2] & i3;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(message, jOffset));
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(message, jOffset));
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(message, jOffset));
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i5 += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i7 & i2) != 0) {
                        Object object = unsafe.getObject(message, jOffset);
                        if (object instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 9:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 10:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i7 & i2) != 0) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(message, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 19:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 20:
                    iComputeBoolSize = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 21:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 22:
                    iComputeBoolSize = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 23:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 24:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 25:
                    iComputeBoolSize = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 26:
                    iComputeBoolSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(message, jOffset));
                    i5 += iComputeBoolSize;
                    break;
                case 27:
                    iComputeBoolSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(message, jOffset), getMessageFieldSchema(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 28:
                    iComputeBoolSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(message, jOffset));
                    i5 += iComputeBoolSize;
                    break;
                case 29:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 30:
                    iComputeBoolSize = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 31:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 32:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 33:
                    iComputeBoolSize = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 34:
                    iComputeBoolSize = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(message, jOffset), false);
                    i5 += iComputeBoolSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 49:
                    iComputeBoolSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(message, jOffset), getMessageFieldSchema(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 50:
                    iComputeBoolSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(message, jOffset), getMapFieldDefaultEntry(i4));
                    i5 += iComputeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        Object object2 = unsafe.getObject(message, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeBoolSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i5 += iComputeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i5 += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i4)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(message, jOffset), getMessageFieldSchema(i4));
                        i5 += iComputeBoolSize;
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i3 = 1048575;
        }
        int unknownFieldsSerializedSize = i5 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(message).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T message) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i2);
            long jOffset = offset(iTypeAndOffsetAt);
            int i3 = (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.buffer[i2 + 2] & 1048575;
            switch (iType) {
                case 0:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(message, i2)) {
                        Object object = UnsafeUtil.getObject(message, jOffset);
                        if (object instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i += iComputeDoubleSize;
                    }
                    break;
                case 9:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(message, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 10:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(message, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(message, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, listAt(message, jOffset));
                    i += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(message, jOffset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(message, jOffset));
                    i += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(message, jOffset), false);
                    i += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(message, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(message, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                    }
                    break;
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(message, jOffset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(message, jOffset), getMapFieldDefaultEntry(i2));
                    i += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        Object object2 = UnsafeUtil.getObject(message, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i += iComputeDoubleSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(message, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(message, jOffset));
                        i += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(message, jOffset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return i + getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSize(schema.getFromMessage(message));
    }

    private static List<?> listAt(Object message, long offset) {
        return (List) UnsafeUtil.getObject(message, offset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(message, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(message, writer);
        } else {
            writeFieldsInAscendingOrderProto2(message, writer);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0021  */
    private void writeFieldsInAscendingOrderProto2(T message, Writer writer) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(message);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        } else {
            it = null;
            entry = null;
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 1048575;
        int i5 = 0;
        while (i3 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i6 = this.buffer[i3 + 2];
                int i7 = i6 & i2;
                if (i7 != i4) {
                    i5 = unsafe.getInt(message, i7);
                    i4 = i7;
                }
                i = 1 << (i6 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i & i5) != 0) {
                        writer.writeDouble(iNumberAt, doubleAt(message, jOffset));
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 1:
                    if ((i & i5) != 0) {
                        writer.writeFloat(iNumberAt, floatAt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 2:
                    if ((i & i5) != 0) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 3:
                    if ((i & i5) != 0) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 4:
                    if ((i & i5) != 0) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 5:
                    if ((i & i5) != 0) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 6:
                    if ((i & i5) != 0) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 7:
                    if ((i & i5) != 0) {
                        writer.writeBool(iNumberAt, booleanAt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 8:
                    if ((i & i5) != 0) {
                        writeString(iNumberAt, unsafe.getObject(message, jOffset), writer);
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 9:
                    if ((i & i5) != 0) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 10:
                    if ((i & i5) != 0) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 11:
                    if ((i & i5) != 0) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 12:
                    if ((i & i5) != 0) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 13:
                    if ((i & i5) != 0) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 14:
                    if ((i & i5) != 0) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 15:
                    if ((i & i5) != 0) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 16:
                    if ((i & i5) != 0) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(message, jOffset));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 17:
                    if ((i & i5) != 0) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i3));
                    } else {
                        continue;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, getMessageFieldSchema(i3));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, false);
                    continue;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i3), (List) unsafe.getObject(message, jOffset), writer, getMessageFieldSchema(i3));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(message, jOffset), i3);
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(message, jOffset));
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(message, jOffset));
                    }
                    break;
                case 53:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    break;
                case 55:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(message, jOffset));
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writeString(iNumberAt, unsafe.getObject(message, jOffset), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i3));
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(message, jOffset));
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    break;
                case 65:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    break;
                case 66:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(message, jOffset));
                    }
                    break;
                case 67:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(message, jOffset));
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i3)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(message, jOffset), getMessageFieldSchema(i3));
                    }
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x001c  */
    private void writeFieldsInAscendingOrderProto3(T message, Writer writer) throws IOException {
        Iterator it;
        Map.Entry<?, ?> entry;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(message);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        } else {
            it = null;
            entry = null;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iNumberAt = numberAt(i);
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(message, i)) {
                        writer.writeDouble(iNumberAt, doubleAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(message, i)) {
                        writer.writeFloat(iNumberAt, floatAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(message, i)) {
                        writer.writeInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(message, i)) {
                        writer.writeUInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(message, i)) {
                        writer.writeInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(message, i)) {
                        writer.writeFixed64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(message, i)) {
                        writer.writeFixed32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(message, i)) {
                        writer.writeBool(iNumberAt, booleanAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(message, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(message, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 10:
                    if (isFieldPresent(message, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(message, i)) {
                        writer.writeUInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(message, i)) {
                        writer.writeEnum(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(message, i)) {
                        writer.writeSFixed32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(message, i)) {
                        writer.writeSFixed64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(message, i)) {
                        writer.writeSInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(message, i)) {
                        writer.writeSInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(message, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), i);
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T message, Writer writer) throws IOException {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, message, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(message);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        } else {
            itDescendingIterator = null;
            entry = null;
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(message, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(message, length)) {
                        writer.writeFloat(iNumberAt, floatAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(message, length)) {
                        writer.writeInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(message, length)) {
                        writer.writeUInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(message, length)) {
                        writer.writeInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(message, length)) {
                        writer.writeFixed64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(message, length)) {
                        writer.writeFixed32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(message, length)) {
                        writer.writeBool(iNumberAt, booleanAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(message, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(message, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(message, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(message, length)) {
                        writer.writeUInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(message, length)) {
                        writer.writeEnum(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(message, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(message, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(message, length)) {
                        writer.writeSInt32(iNumberAt, intAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(message, length)) {
                        writer.writeSInt64(iNumberAt, longAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(message, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(message, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(message, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(message, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int number, Object mapField, int pos) throws IOException {
        if (mapField != null) {
            writer.writeMap(number, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(pos)), this.mapFieldSchema.forMapData(mapField));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> schema, T message, Writer writer) throws IOException {
        schema.writeTo(schema.getFromMessage(message), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws Throwable {
        extensionRegistry.getClass();
        checkMutable(message);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    /* JADX WARN: Found duplicated region for block: B:169:0x0646 A[Catch: all -> 0x069e, TRY_LEAVE, TryCatch #13 {all -> 0x069e, blocks: (B:156:0x0617, B:167:0x0640, B:169:0x0646, B:179:0x066e, B:180:0x0673), top: B:208:0x0617 }] */
    /* JADX WARN: Found duplicated region for block: B:174:0x0653 A[LOOP:2: B:172:0x064f->B:174:0x0653, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:176:0x0668  */
    /* JADX WARN: Found duplicated region for block: B:178:0x066c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:179:0x066e A[Catch: all -> 0x069e, TRY_ENTER, TryCatch #13 {all -> 0x069e, blocks: (B:156:0x0617, B:167:0x0640, B:169:0x0646, B:179:0x066e, B:180:0x0673), top: B:208:0x0617 }] */
    /* JADX WARN: Found duplicated region for block: B:185:0x0680 A[LOOP:3: B:183:0x067c->B:185:0x0680, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:187:0x0695  */
    /* JADX WARN: Found duplicated region for block: B:201:0x06b0 A[LOOP:4: B:199:0x06ac->B:201:0x06b0, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:203:0x06c5  */
    /* JADX WARN: Found duplicated region for block: B:233:0x064c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:234:0x0679 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:248:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.crypto.tink.shaded.protobuf.Reader] */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        UnknownFieldSchema unknownFieldSchema2;
        T t2;
        int i;
        Object objFilterMapUnknownEnumValues;
        T t3;
        ExtensionRegistryLite extensionRegistryLite2;
        int i2;
        Object objFilterMapUnknownEnumValues2;
        int i3;
        Object objFilterMapUnknownEnumValues3;
        Object obj;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t4 = t;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        Object builderFromMessage = null;
        FieldSet mutableExtensions = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    t2 = t4;
                    try {
                        int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                        switch (type(iTypeAndOffsetAt)) {
                            case 0:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader.readDouble());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 1:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader.readFloat());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 2:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readInt64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 3:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readUInt64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 4:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readInt32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 5:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readFixed64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 6:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readFixed32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 7:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader.readBool());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 8:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readString(t2, iTypeAndOffsetAt, reader);
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 9:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                reader.mergeMessageField(messageLite, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                storeMessageField(t2, iPositionForFieldNumber, messageLite);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 10:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader.readBytes());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 11:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readUInt32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 12:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                int i4 = reader.readEnum();
                                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i4)) {
                                    UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i4);
                                    setFieldPresent(t2, iPositionForFieldNumber);
                                    builderFromMessage = obj;
                                } else {
                                    builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i4, obj, unknownFieldSchema2);
                                }
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 13:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readSFixed32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 14:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readSFixed64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 15:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader.readSInt32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 16:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader.readSInt64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 17:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                reader.mergeGroupField(messageLite2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                storeMessageField(t2, iPositionForFieldNumber, messageLite2);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 18:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 19:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 20:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 21:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 22:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 23:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 24:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 25:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 26:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readStringList(t2, iTypeAndOffsetAt, reader);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 27:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readMessageList(t, iTypeAndOffsetAt, reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 28:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 29:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 30:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                                reader.readEnumList(listMutableListAt);
                                builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, (List<Integer>) listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 31:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 32:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 33:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 34:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 35:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 36:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 37:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 38:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 39:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 40:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 41:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 42:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 43:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 44:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                                reader.readEnumList(listMutableListAt2);
                                builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, (List<Integer>) listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 45:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 46:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 47:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 48:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 49:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 50:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                try {
                                    mergeMap(t, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite, reader);
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                        if (builderFromMessage == null) {
                                            builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                        }
                                        if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                            objFilterMapUnknownEnumValues2 = builderFromMessage;
                                            for (i2 = this.checkInitializedCount; i2 < this.repeatedFieldOffsetStart; i2++) {
                                                objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues2 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                return;
                                            }
                                            return;
                                        }
                                    } else if (!reader.skipField()) {
                                        objFilterMapUnknownEnumValues3 = builderFromMessage;
                                        for (i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                            objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues3 != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 51:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 52:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 53:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 54:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 55:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 56:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 57:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 58:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 59:
                                readString(t2, iTypeAndOffsetAt, reader);
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 60:
                                MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                reader.mergeMessageField(messageLite3, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite3);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 61:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader.readBytes());
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 62:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 63:
                                int i5 = reader.readEnum();
                                Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                                if (enumFieldVerifier2 == null || enumFieldVerifier2.isInRange(i5)) {
                                    UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i5));
                                    setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                } else {
                                    builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i5, builderFromMessage, unknownFieldSchema3);
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                }
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 64:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 65:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 66:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 67:
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 68:
                                try {
                                    MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                    reader.mergeGroupField(messageLite4, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                    storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite4);
                                    obj = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                        if (builderFromMessage == null) {
                                            builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                        }
                                        if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                            objFilterMapUnknownEnumValues2 = builderFromMessage;
                                            while (i2 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues2 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                return;
                                            }
                                            return;
                                        }
                                    } else if (!reader.skipField()) {
                                        objFilterMapUnknownEnumValues3 = builderFromMessage;
                                        while (i3 < this.repeatedFieldOffsetStart) {
                                            objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                        }
                                        if (objFilterMapUnknownEnumValues3 != null) {
                                            unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            default:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                if (obj == null) {
                                    try {
                                        builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                        builderFromMessage = obj;
                                        if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                while (i2 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            while (i3 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                        t4 = t2;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        builderFromMessage = obj;
                                    }
                                } else {
                                    builderFromMessage = obj;
                                }
                                try {
                                    try {
                                        if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                            Object objFilterMapUnknownEnumValues4 = builderFromMessage;
                                            for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                                objFilterMapUnknownEnumValues4 = filterMapUnknownEnumValues(t, this.intArray[i6], objFilterMapUnknownEnumValues4, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues4 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues4);
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                        if (unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, reader)) {
                                                objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                while (i2 < this.repeatedFieldOffsetStart) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i2], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!reader.skipField()) {
                                            objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            while (i3 < this.repeatedFieldOffsetStart) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    t4 = t2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                                break;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object objFilterMapUnknownEnumValues5 = builderFromMessage;
                        for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                            objFilterMapUnknownEnumValues5 = filterMapUnknownEnumValues(t, this.intArray[i7], objFilterMapUnknownEnumValues5, unknownFieldSchema, t);
                        }
                        if (objFilterMapUnknownEnumValues5 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t4, objFilterMapUnknownEnumValues5);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objFindExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite3, this.defaultInstance, fieldNumber);
                        if (objFindExtensionByNumber != null) {
                            if (mutableExtensions == null) {
                                try {
                                    mutableExtensions = extensionSchema.getMutableExtensions(t);
                                } catch (Throwable th6) {
                                    th = th6;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t2 = t4;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i < this.repeatedFieldOffsetStart) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            }
                            FieldSet fieldSet = mutableExtensions;
                            t3 = t4;
                            try {
                                builderFromMessage = extensionSchema.parseExtension(t, reader, objFindExtensionByNumber, extensionRegistryLite, fieldSet, builderFromMessage, unknownFieldSchema);
                                mutableExtensions = fieldSet;
                            } catch (Throwable th7) {
                                th = th7;
                                t2 = t3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                objFilterMapUnknownEnumValues = builderFromMessage;
                                while (i < this.repeatedFieldOffsetStart) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                }
                                throw th;
                            }
                        } else {
                            t3 = t4;
                            if (unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                if (!reader.skipField()) {
                                }
                                mutableExtensions = mutableExtensions;
                            } else {
                                if (builderFromMessage == null) {
                                    builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t3);
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader)) {
                                }
                                mutableExtensions = mutableExtensions;
                            }
                        }
                        t4 = t3;
                    } catch (Throwable th8) {
                        th = th8;
                        t2 = t4;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
            }
            objFilterMapUnknownEnumValues = builderFromMessage;
            while (i < this.repeatedFieldOffsetStart) {
                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
            }
            if (objFilterMapUnknownEnumValues != null) {
                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
            }
            throw th;
        }
        int i8 = this.checkInitializedCount;
        Object objFilterMapUnknownEnumValues6 = builderFromMessage;
        while (i8 < this.repeatedFieldOffsetStart) {
            objFilterMapUnknownEnumValues6 = filterMapUnknownEnumValues(t, this.intArray[i8], objFilterMapUnknownEnumValues6, unknownFieldSchema, t);
            i8++;
            t3 = t3;
        }
        T t5 = t3;
        if (objFilterMapUnknownEnumValues6 != null) {
            unknownFieldSchema3.setBuilderToMessage(t5, objFilterMapUnknownEnumValues6);
        }
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object message) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] data, int position, int limit, WireFormat.FieldType fieldType, Class<?> messageType, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(data, position, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(data, position));
                return position + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(data, position));
                return position + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(data, position));
                return position + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(data, position));
                return position + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) messageType), data, position, limit, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(data, position, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(data, position, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(data, position, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] data, int position, int limit, MapEntryLite.Metadata<K, V> metadata, Map<K, V> target, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32;
        int iDecodeVarint322 = ArrayDecoders.decodeVarint32(data, position, registers);
        int i = registers.int1;
        if (i < 0 || i > limit - iDecodeVarint322) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i2 = iDecodeVarint322 + i;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint322 < i2) {
            int i3 = iDecodeVarint322 + 1;
            int i4 = data[iDecodeVarint322];
            if (i4 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i4, data, i3, registers);
                i4 = registers.int1;
            } else {
                iDecodeVarint32 = i3;
            }
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i5 == 1) {
                if (i6 == metadata.keyType.getWireType()) {
                    iDecodeVarint322 = decodeMapEntryValue(data, iDecodeVarint32, limit, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    iDecodeVarint322 = ArrayDecoders.skipField(i4, data, iDecodeVarint32, limit, registers);
                }
            } else if (i5 == 2 && i6 == metadata.valueType.getWireType()) {
                iDecodeVarint322 = decodeMapEntryValue(data, iDecodeVarint32, limit, metadata.valueType, metadata.defaultValue.getClass(), registers);
                obj2 = registers.object1;
            } else {
                iDecodeVarint322 = ArrayDecoders.skipField(i4, data, iDecodeVarint32, limit, registers);
            }
        }
        if (iDecodeVarint322 != i2) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        target.put(obj, obj2);
        return i2;
    }

    private int parseRepeatedField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int bufferPosition, long typeAndOffset, int fieldType, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(message, fieldOffset);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(message, fieldOffset, protobufListMutableCopyWithCapacity2);
        }
        switch (fieldType) {
            case 18:
            case 35:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedDoubleList(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 1 ? ArrayDecoders.decodeDoubleList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 19:
            case 36:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFloatList(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 5 ? ArrayDecoders.decodeFloatList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 20:
            case 21:
            case 37:
            case 38:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedVarint64List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeVarint64List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 22:
            case 29:
            case 39:
            case 43:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedVarint32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeVarint32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 23:
            case 32:
            case 40:
            case 46:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFixed64List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 1 ? ArrayDecoders.decodeFixed64List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 24:
            case 31:
            case 41:
            case 45:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedFixed32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 5 ? ArrayDecoders.decodeFixed32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 25:
            case 42:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedBoolList(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeBoolList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 26:
                if (wireType != 2) {
                    return position;
                }
                if ((typeAndOffset & 536870912) == 0) {
                    return ArrayDecoders.decodeStringList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers);
                }
                return ArrayDecoders.decodeStringListRequireUtf8(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers);
            case 27:
                return wireType == 2 ? ArrayDecoders.decodeMessageList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 28:
                return wireType == 2 ? ArrayDecoders.decodeBytesList(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 30:
            case 44:
                if (wireType == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                } else {
                    if (wireType != 0) {
                        return position;
                    }
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) message, number, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(bufferPosition), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedSInt32List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeSInt32List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 34:
            case 48:
                if (wireType == 2) {
                    return ArrayDecoders.decodePackedSInt64List(data, position, protobufListMutableCopyWithCapacity2, registers);
                }
                return wireType == 0 ? ArrayDecoders.decodeSInt64List(tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            case 49:
                return wireType == 3 ? ArrayDecoders.decodeGroupList(getMessageFieldSchema(bufferPosition), tag, data, position, limit, protobufListMutableCopyWithCapacity2, registers) : position;
            default:
                return position;
        }
    }

    private <K, V> int parseMapField(T message, byte[] data, int position, int limit, int bufferPosition, long fieldOffset, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(bufferPosition);
        Object object = unsafe.getObject(message, fieldOffset);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(message, fieldOffset, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(data, position, limit, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T message, byte[] data, int position, int limit, int tag, int number, int wireType, int typeAndOffset, int fieldType, long fieldOffset, int bufferPosition, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j = this.buffer[bufferPosition + 2] & 1048575;
        switch (fieldType) {
            case 51:
                if (wireType != 1) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Double.valueOf(ArrayDecoders.decodeDouble(data, position)));
                int i = position + 8;
                unsafe.putInt(message, j, number);
                return i;
            case 52:
                if (wireType != 5) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Float.valueOf(ArrayDecoders.decodeFloat(data, position)));
                int i2 = position + 4;
                unsafe.putInt(message, j, number);
                return i2;
            case 53:
            case 54:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(data, position, registers);
                unsafe.putObject(message, fieldOffset, Long.valueOf(registers.long1));
                unsafe.putInt(message, j, number);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(data, position, registers);
                unsafe.putObject(message, fieldOffset, Integer.valueOf(registers.int1));
                unsafe.putInt(message, j, number);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (wireType != 1) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Long.valueOf(ArrayDecoders.decodeFixed64(data, position)));
                int i3 = position + 8;
                unsafe.putInt(message, j, number);
                return i3;
            case 57:
            case 64:
                if (wireType != 5) {
                    return position;
                }
                unsafe.putObject(message, fieldOffset, Integer.valueOf(ArrayDecoders.decodeFixed32(data, position)));
                int i4 = position + 4;
                unsafe.putInt(message, j, number);
                return i4;
            case 58:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(data, position, registers);
                unsafe.putObject(message, fieldOffset, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(message, j, number);
                return iDecodeVarint642;
            case 59:
                if (wireType != 2) {
                    return position;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(data, position, registers);
                int i5 = registers.int1;
                if (i5 == 0) {
                    unsafe.putObject(message, fieldOffset, "");
                } else {
                    if ((typeAndOffset & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(data, iDecodeVarint322, iDecodeVarint322 + i5)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(message, fieldOffset, new String(data, iDecodeVarint322, i5, Internal.UTF_8));
                    iDecodeVarint322 += i5;
                }
                unsafe.putInt(message, j, number);
                return iDecodeVarint322;
            case 60:
                if (wireType != 2) {
                    return position;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(bufferPosition), data, position, limit, registers);
                storeOneofMessageField(message, number, bufferPosition, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case 61:
                if (wireType != 2) {
                    return position;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(data, position, registers);
                unsafe.putObject(message, fieldOffset, registers.object1);
                unsafe.putInt(message, j, number);
                return iDecodeBytes;
            case 63:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(data, position, registers);
                int i6 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(bufferPosition);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i6)) {
                    unsafe.putObject(message, fieldOffset, Integer.valueOf(i6));
                    unsafe.putInt(message, j, number);
                } else {
                    getMutableUnknownFields(message).storeField(tag, Long.valueOf(i6));
                }
                return iDecodeVarint323;
            case 66:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(data, position, registers);
                unsafe.putObject(message, fieldOffset, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(message, j, number);
                return iDecodeVarint324;
            case 67:
                if (wireType != 0) {
                    return position;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(data, position, registers);
                unsafe.putObject(message, fieldOffset, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(message, j, number);
                return iDecodeVarint643;
            case 68:
                if (wireType != 3) {
                    return position;
                }
                Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(message, number, bufferPosition);
                int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(bufferPosition), data, position, limit, (tag & (-8)) | 4, registers);
                storeOneofMessageField(message, number, bufferPosition, objMutableOneofMessageFieldForMerge2);
                return iMergeGroupField;
            default:
                return position;
        }
    }

    private Schema getMessageFieldSchema(int pos) {
        int i = (pos / 3) * 2;
        Schema schema = (Schema) this.objects[i];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i + 1]);
        this.objects[i] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    private Object getMapFieldDefaultEntry(int pos) {
        return this.objects[(pos / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int pos) {
        return (Internal.EnumVerifier) this.objects[((pos / 3) * 2) + 1];
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x008e. Please report as an issue. */
    int parseProto2Message(T message, byte[] data, int position, int limit, int endGroup, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        int i;
        MessageSchema<T> messageSchema;
        int i2;
        int i3;
        int i4;
        int i5;
        T t;
        int i6;
        int iPositionForFieldNumber;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        byte[] bArr;
        int iDecodeVarint64;
        int i17;
        int i18;
        MessageSchema<T> messageSchema2 = this;
        T t2 = message;
        byte[] bArr2 = data;
        int i19 = limit;
        int i20 = endGroup;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(message);
        Unsafe unsafe2 = UNSAFE;
        int iDecodeUnknownField = position;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 1048575;
        while (true) {
            if (iDecodeUnknownField < i19) {
                int i26 = iDecodeUnknownField + 1;
                byte b = bArr2[iDecodeUnknownField];
                if (b < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b, bArr2, i26, registers2);
                    i6 = registers2.int1;
                    i26 = iDecodeVarint32;
                } else {
                    i6 = b;
                }
                int i27 = i6 >>> 3;
                int i28 = i6 & 7;
                if (i27 > i21) {
                    iPositionForFieldNumber = messageSchema2.positionForFieldNumber(i27, i22 / 3);
                } else {
                    iPositionForFieldNumber = messageSchema2.positionForFieldNumber(i27);
                }
                int i29 = iPositionForFieldNumber;
                if (i29 == -1) {
                    i7 = i27;
                    i8 = i26;
                    i3 = i6;
                    i9 = i24;
                    i10 = i25;
                    unsafe = unsafe2;
                    i = i20;
                    i11 = 0;
                } else {
                    int i30 = messageSchema2.buffer[i29 + 1];
                    int iType = type(i30);
                    long jOffset = offset(i30);
                    int i31 = i6;
                    if (iType <= 17) {
                        int i32 = messageSchema2.buffer[i29 + 2];
                        int i33 = 1 << (i32 >>> 20);
                        int i34 = i32 & 1048575;
                        if (i34 != i25) {
                            if (i25 != 1048575) {
                                unsafe2.putInt(t2, i25, i24);
                            }
                            i13 = i34;
                            i12 = unsafe2.getInt(t2, i34);
                        } else {
                            i12 = i24;
                            i13 = i25;
                        }
                        switch (iType) {
                            case 0:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 1) {
                                    UnsafeUtil.putDouble(t2, jOffset, ArrayDecoders.decodeDouble(bArr, i26));
                                    iDecodeUnknownField = i26 + 8;
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 1:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 5) {
                                    UnsafeUtil.putFloat(t2, jOffset, ArrayDecoders.decodeFloat(bArr, i26));
                                    iDecodeUnknownField = i26 + 4;
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 2:
                            case 3:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i26, registers2);
                                    unsafe2.putLong(message, jOffset, registers2.long1);
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 4:
                            case 11:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i26, registers2);
                                    unsafe2.putInt(t2, jOffset, registers2.int1);
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 5:
                            case 14:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 1) {
                                    unsafe2.putLong(message, jOffset, ArrayDecoders.decodeFixed64(bArr, i26));
                                    iDecodeUnknownField = i26 + 8;
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 5) {
                                    unsafe2.putInt(t2, jOffset, ArrayDecoders.decodeFixed32(bArr, i26));
                                    iDecodeUnknownField = i26 + 4;
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 7:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr, i26, registers2);
                                    UnsafeUtil.putBoolean(t2, jOffset, registers2.long1 != 0);
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 8:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 2) {
                                    if ((ENFORCE_UTF8_MASK & i30) == 0) {
                                        iDecodeUnknownField = ArrayDecoders.decodeString(bArr, i26, registers2);
                                    } else {
                                        iDecodeUnknownField = ArrayDecoders.decodeStringRequireUtf8(bArr, i26, registers2);
                                    }
                                    unsafe2.putObject(t2, jOffset, registers2.object1);
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 9:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 2) {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t2, i16);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i16), data, i26, limit, registers);
                                    messageSchema2.storeMessageField(t2, i16, objMutableMessageFieldForMerge);
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 10:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 2) {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr, i26, registers2);
                                    unsafe2.putObject(t2, jOffset, registers2.object1);
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 12:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i26, registers2);
                                    int i35 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i16);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i35)) {
                                        unsafe2.putInt(t2, jOffset, i35);
                                        i24 = i12 | i33;
                                        i20 = endGroup;
                                        i22 = i16;
                                        i23 = i15;
                                        i21 = i7;
                                        i25 = i14;
                                    } else {
                                        getMutableUnknownFields(message).storeField(i15, Long.valueOf(i35));
                                        i22 = i16;
                                        i24 = i12;
                                        i23 = i15;
                                        i21 = i7;
                                        i25 = i14;
                                        i20 = endGroup;
                                    }
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 15:
                                bArr = data;
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                if (i28 == 0) {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr, i26, registers2);
                                    unsafe2.putInt(t2, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 16:
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                bArr = data;
                                if (i28 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i26, registers2);
                                    unsafe2.putLong(message, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                    i24 = i12 | i33;
                                    i20 = endGroup;
                                    i22 = i16;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i23 = i15;
                                    i21 = i7;
                                    i25 = i14;
                                    bArr2 = bArr;
                                } else {
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            case 17:
                                if (i28 == 3) {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t2, i29);
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(i29), data, i26, limit, (i27 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t2, i29, objMutableMessageFieldForMerge2);
                                    i24 = i12 | i33;
                                    i25 = i13;
                                    i20 = endGroup;
                                    i22 = i29;
                                    i23 = i31;
                                    i21 = i27;
                                    bArr2 = data;
                                } else {
                                    i7 = i27;
                                    i14 = i13;
                                    i15 = i31;
                                    i16 = i29;
                                    i10 = i14;
                                    i = endGroup;
                                    i8 = i26;
                                    i11 = i16;
                                    unsafe = unsafe2;
                                    i9 = i12;
                                    i3 = i15;
                                }
                                break;
                            default:
                                i7 = i27;
                                i16 = i29;
                                i14 = i13;
                                i15 = i31;
                                i10 = i14;
                                i = endGroup;
                                i8 = i26;
                                i11 = i16;
                                unsafe = unsafe2;
                                i9 = i12;
                                i3 = i15;
                                break;
                        }
                    } else {
                        i7 = i27;
                        i10 = i25;
                        i9 = i24;
                        if (iType == 27) {
                            if (i28 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t2, jOffset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(t2, jOffset, protobufListMutableCopyWithCapacity2);
                                }
                                iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i29), i31, data, i26, limit, protobufListMutableCopyWithCapacity2, registers);
                                i22 = i29;
                                i23 = i31;
                                i25 = i10;
                                i24 = i9;
                                i21 = i7;
                                bArr2 = data;
                                i20 = endGroup;
                            } else {
                                i17 = i26;
                                unsafe = unsafe2;
                                i11 = i29;
                                i18 = i31;
                                i = endGroup;
                                i8 = i17;
                                i3 = i18;
                            }
                        } else if (iType <= 49) {
                            int i36 = i26;
                            unsafe = unsafe2;
                            i11 = i29;
                            i18 = i31;
                            iDecodeUnknownField = parseRepeatedField(message, data, i26, limit, i31, i7, i28, i29, i30, iType, jOffset, registers);
                            if (iDecodeUnknownField != i36) {
                                messageSchema2 = this;
                                t2 = message;
                                bArr2 = data;
                                i19 = limit;
                                i20 = endGroup;
                                registers2 = registers;
                                i25 = i10;
                                i24 = i9;
                                i22 = i11;
                                i23 = i18;
                                i21 = i7;
                                unsafe2 = unsafe;
                            } else {
                                i = endGroup;
                                i8 = iDecodeUnknownField;
                                i3 = i18;
                            }
                        } else {
                            i17 = i26;
                            unsafe = unsafe2;
                            i11 = i29;
                            i18 = i31;
                            if (iType != 50) {
                                iDecodeUnknownField = parseOneofField(message, data, i17, limit, i18, i7, i28, i30, iType, jOffset, i11, registers);
                                if (iDecodeUnknownField != i17) {
                                    messageSchema2 = this;
                                    t2 = message;
                                    bArr2 = data;
                                    i19 = limit;
                                    i20 = endGroup;
                                    registers2 = registers;
                                    i25 = i10;
                                    i24 = i9;
                                    i22 = i11;
                                    i23 = i18;
                                    i21 = i7;
                                    unsafe2 = unsafe;
                                } else {
                                    i = endGroup;
                                    i8 = iDecodeUnknownField;
                                    i3 = i18;
                                }
                            } else if (i28 == 2) {
                                iDecodeUnknownField = parseMapField(message, data, i17, limit, i11, jOffset, registers);
                                if (iDecodeUnknownField != i17) {
                                    messageSchema2 = this;
                                    t2 = message;
                                    bArr2 = data;
                                    i19 = limit;
                                    i20 = endGroup;
                                    registers2 = registers;
                                    i25 = i10;
                                    i24 = i9;
                                    i22 = i11;
                                    i23 = i18;
                                    i21 = i7;
                                    unsafe2 = unsafe;
                                } else {
                                    i = endGroup;
                                    i8 = iDecodeUnknownField;
                                    i3 = i18;
                                }
                            } else {
                                i = endGroup;
                                i8 = i17;
                                i3 = i18;
                            }
                        }
                    }
                }
                if (i3 != i || i == 0) {
                    if (this.hasExtensions && registers.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i3, data, i8, limit, message, this.defaultInstance, this.unknownFieldSchema, registers);
                    } else {
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i3, data, i8, limit, getMutableUnknownFields(message), registers);
                    }
                    t2 = message;
                    bArr2 = data;
                    i19 = limit;
                    i23 = i3;
                    messageSchema2 = this;
                    registers2 = registers;
                    i25 = i10;
                    i24 = i9;
                    i22 = i11;
                    i21 = i7;
                    unsafe2 = unsafe;
                    i20 = i;
                } else {
                    i5 = 1048575;
                    messageSchema = this;
                    i2 = i8;
                    i4 = i10;
                    i24 = i9;
                }
            } else {
                int i37 = i25;
                unsafe = unsafe2;
                i = i20;
                messageSchema = messageSchema2;
                i2 = iDecodeUnknownField;
                i3 = i23;
                i4 = i37;
                i5 = 1048575;
            }
        }
        if (i4 != i5) {
            t = message;
            unsafe.putInt(t, i4, i24);
        } else {
            t = message;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i38 = messageSchema.checkInitializedCount; i38 < messageSchema.repeatedFieldOffsetStart; i38++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(message, messageSchema.intArray[i38], unknownFieldSetLite, messageSchema.unknownFieldSchema, message);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t, unknownFieldSetLite);
        }
        if (i == 0) {
            if (i2 != limit) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i2 > limit || i3 != i) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T message, int pos) {
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        long jOffset = offset(typeAndOffsetAt(pos));
        if (!isFieldPresent(message, pos)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(message, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    private void storeMessageField(T message, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setFieldPresent(message, pos);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T message, int fieldNumber, int pos) {
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        if (!isOneofPresent(message, fieldNumber, pos)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(message, offset(typeAndOffsetAt(pos)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    private void storeOneofMessageField(T message, int fieldNumber, int pos, Object field) {
        UNSAFE.putObject(message, offset(typeAndOffsetAt(pos)), field);
        setOneofPresent(message, fieldNumber, pos);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0087. Please report as an issue. */
    /* JADX WARN: Found duplicated region for block: B:100:0x0298 A[PHI: r0 r19 r22 r26 r28
      0x0298: PHI (r0v15 int) = (r0v10 int), (r0v13 int), (r0v17 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r19v2 int) = (r19v0 int), (r19v0 int), (r19v3 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r22v2 int) = (r22v0 int), (r22v0 int), (r22v3 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r26v3 int) = (r26v1 int), (r26v1 int), (r26v4 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0298: PHI (r28v3 sun.misc.Unsafe) = (r28v1 sun.misc.Unsafe), (r28v1 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:113:0x0301 A[PHI: r0 r19 r22 r26 r28
      0x0301: PHI (r0v14 int) = (r0v10 int), (r0v13 int), (r0v17 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0301: PHI (r19v1 int) = (r19v0 int), (r19v0 int), (r19v3 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0301: PHI (r22v1 int) = (r22v0 int), (r22v0 int), (r22v3 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0301: PHI (r26v2 int) = (r26v1 int), (r26v1 int), (r26v4 int) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]
      0x0301: PHI (r28v2 sun.misc.Unsafe) = (r28v1 sun.misc.Unsafe), (r28v1 sun.misc.Unsafe), (r28v4 sun.misc.Unsafe) binds: [B:111:0x02fe, B:106:0x02db, B:99:0x0296] A[DONT_GENERATE, DONT_INLINE]] */
    private int parseProto3Message(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        int i;
        int iDecodeVarint32;
        int iPositionForFieldNumber;
        int i2;
        int i3;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iDecodeBytes;
        MessageSchema<T> messageSchema = this;
        T t = message;
        byte[] bArr = data;
        int i11 = limit;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(message);
        Unsafe unsafe2 = UNSAFE;
        int i12 = -1;
        int oneofField = position;
        int i13 = -1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1048575;
        while (oneofField < i11) {
            int i17 = oneofField + 1;
            byte b = bArr[oneofField];
            if (b < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(b, bArr, i17, registers2);
                i = registers2.int1;
            } else {
                i = b;
                iDecodeVarint32 = i17;
            }
            int i18 = i >>> 3;
            int i19 = i & 7;
            if (i18 > i13) {
                iPositionForFieldNumber = messageSchema.positionForFieldNumber(i18, i14 / 3);
            } else {
                iPositionForFieldNumber = messageSchema.positionForFieldNumber(i18);
            }
            int i20 = iPositionForFieldNumber;
            if (i20 == i12) {
                i7 = iDecodeVarint32;
                i2 = i18;
                unsafe = unsafe2;
                i5 = 0;
            } else {
                int i21 = messageSchema.buffer[i20 + 1];
                int iType = type(i21);
                long jOffset = offset(i21);
                if (iType <= 17) {
                    int i22 = messageSchema.buffer[i20 + 2];
                    int i23 = 1 << (i22 >>> 20);
                    int i24 = 1048575;
                    int i25 = i22 & 1048575;
                    if (i25 != i16) {
                        if (i16 != 1048575) {
                            unsafe2.putInt(t, i16, i15);
                            i24 = 1048575;
                        }
                        if (i25 != i24) {
                            i15 = unsafe2.getInt(t, i25);
                        }
                        i16 = i25;
                    }
                    switch (iType) {
                        case 0:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            if (i19 == 1) {
                                UnsafeUtil.putDouble(t, jOffset, ArrayDecoders.decodeDouble(bArr, i9));
                                oneofField = i9 + 8;
                                i15 = i10 | i23;
                                i14 = i8;
                            }
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 1:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            if (i19 == 5) {
                                UnsafeUtil.putFloat(t, jOffset, ArrayDecoders.decodeFloat(bArr, i9));
                                oneofField = i9 + 4;
                                i15 = i10 | i23;
                                i14 = i8;
                            }
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 2:
                        case 3:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            if (i19 == 0) {
                                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i9, registers2);
                                unsafe2.putLong(message, jOffset, registers2.long1);
                                i15 = i10 | i23;
                                i14 = i8;
                                oneofField = iDecodeVarint64;
                            }
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 4:
                        case 11:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            if (i19 == 0) {
                                oneofField = ArrayDecoders.decodeVarint32(bArr, i9, registers2);
                                unsafe2.putInt(t, jOffset, registers2.int1);
                                i15 = i10 | i23;
                                i14 = i8;
                            }
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 5:
                        case 14:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i10 = i15;
                            if (i19 == 1) {
                                i9 = iDecodeVarint32;
                                unsafe2.putLong(message, jOffset, ArrayDecoders.decodeFixed64(bArr, iDecodeVarint32));
                                oneofField = i9 + 8;
                                i15 = i10 | i23;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 6:
                        case 13:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i10 = i15;
                            if (i19 == 5) {
                                unsafe2.putInt(t, jOffset, ArrayDecoders.decodeFixed32(bArr, iDecodeVarint32));
                                oneofField = iDecodeVarint32 + 4;
                                i15 = i10 | i23;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 7:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i10 = i15;
                            if (i19 == 0) {
                                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, iDecodeVarint32, registers2);
                                UnsafeUtil.putBoolean(t, jOffset, registers2.long1 != 0);
                                i15 = i10 | i23;
                                oneofField = iDecodeVarint642;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 8:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            i10 = i15;
                            if (i19 == 2) {
                                if ((ENFORCE_UTF8_MASK & i21) == 0) {
                                    oneofField = ArrayDecoders.decodeString(bArr, iDecodeVarint32, registers2);
                                } else {
                                    oneofField = ArrayDecoders.decodeStringRequireUtf8(bArr, iDecodeVarint32, registers2);
                                }
                                unsafe2.putObject(t, jOffset, registers2.object1);
                                i15 = i10 | i23;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 9:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            if (i19 == 2) {
                                Object objMutableMessageFieldForMerge = messageSchema.mutableMessageFieldForMerge(t, i8);
                                oneofField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema.getMessageFieldSchema(i8), data, iDecodeVarint32, limit, registers);
                                messageSchema.storeMessageField(t, i8, objMutableMessageFieldForMerge);
                                i15 |= i23;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 10:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            if (i19 == 2) {
                                iDecodeBytes = ArrayDecoders.decodeBytes(bArr, iDecodeVarint32, registers2);
                                unsafe2.putObject(t, jOffset, registers2.object1);
                                i15 |= i23;
                                oneofField = iDecodeBytes;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 12:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            if (i19 == 0) {
                                iDecodeBytes = ArrayDecoders.decodeVarint32(bArr, iDecodeVarint32, registers2);
                                unsafe2.putInt(t, jOffset, registers2.int1);
                                i15 |= i23;
                                oneofField = iDecodeBytes;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 15:
                            i2 = i18;
                            registers2 = registers;
                            i8 = i20;
                            if (i19 == 0) {
                                oneofField = ArrayDecoders.decodeVarint32(bArr, iDecodeVarint32, registers2);
                                unsafe2.putInt(t, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                i15 |= i23;
                                i14 = i8;
                            }
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                        case 16:
                            if (i19 == 0) {
                                registers2 = registers;
                                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, iDecodeVarint32, registers2);
                                i2 = i18;
                                unsafe2.putLong(message, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                i15 |= i23;
                                i14 = i20;
                                oneofField = iDecodeVarint643;
                                break;
                            }
                        default:
                            i2 = i18;
                            i8 = i20;
                            i9 = iDecodeVarint32;
                            i10 = i15;
                            i15 = i10;
                            i5 = i8;
                            unsafe = unsafe2;
                            i7 = i9;
                            break;
                    }
                    i12 = -1;
                } else {
                    i2 = i18;
                    int i26 = i15;
                    registers2 = registers;
                    int i27 = iDecodeVarint32;
                    if (iType != 27) {
                        if (iType <= 49) {
                            i3 = i26;
                            i5 = i20;
                            unsafe = unsafe2;
                            i4 = i16;
                            oneofField = parseRepeatedField(message, data, i27, limit, i, i2, i19, i20, i21, iType, jOffset, registers);
                            if (oneofField != i27) {
                                messageSchema = this;
                                t = message;
                                bArr = data;
                                i11 = limit;
                                registers2 = registers;
                                i13 = i2;
                                i14 = i5;
                                i16 = i4;
                                i15 = i3;
                            } else {
                                i7 = oneofField;
                                i16 = i4;
                                i15 = i3;
                                oneofField = ArrayDecoders.decodeUnknownField(i, data, i7, limit, getMutableUnknownFields(message), registers);
                                messageSchema = this;
                                t = message;
                                bArr = data;
                                i11 = limit;
                                registers2 = registers;
                                i13 = i2;
                                i14 = i5;
                            }
                        } else {
                            i3 = i26;
                            i4 = i16;
                            i5 = i20;
                            unsafe = unsafe2;
                            i6 = i27;
                            if (iType != 50) {
                                oneofField = parseOneofField(message, data, i6, limit, i, i2, i19, i21, iType, jOffset, i5, registers);
                                if (oneofField != i6) {
                                    messageSchema = this;
                                    t = message;
                                    bArr = data;
                                    i11 = limit;
                                    registers2 = registers;
                                    i13 = i2;
                                    i14 = i5;
                                    i16 = i4;
                                    i15 = i3;
                                } else {
                                    i7 = oneofField;
                                    i16 = i4;
                                    i15 = i3;
                                    oneofField = ArrayDecoders.decodeUnknownField(i, data, i7, limit, getMutableUnknownFields(message), registers);
                                    messageSchema = this;
                                    t = message;
                                    bArr = data;
                                    i11 = limit;
                                    registers2 = registers;
                                    i13 = i2;
                                    i14 = i5;
                                }
                            } else {
                                if (i19 == 2) {
                                    oneofField = parseMapField(message, data, i6, limit, i5, jOffset, registers);
                                    if (oneofField != i6) {
                                        messageSchema = this;
                                        t = message;
                                        bArr = data;
                                        i11 = limit;
                                        registers2 = registers;
                                        i13 = i2;
                                        i14 = i5;
                                        i16 = i4;
                                        i15 = i3;
                                    } else {
                                        i7 = oneofField;
                                    }
                                }
                                i16 = i4;
                                i15 = i3;
                                oneofField = ArrayDecoders.decodeUnknownField(i, data, i7, limit, getMutableUnknownFields(message), registers);
                                messageSchema = this;
                                t = message;
                                bArr = data;
                                i11 = limit;
                                registers2 = registers;
                                i13 = i2;
                                i14 = i5;
                            }
                        }
                        unsafe2 = unsafe;
                        i12 = -1;
                    } else if (i19 == 2) {
                        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t, jOffset);
                        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                            int size = protobufListMutableCopyWithCapacity2.size();
                            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t, jOffset, protobufListMutableCopyWithCapacity2);
                        }
                        oneofField = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i20), i, data, i27, limit, protobufListMutableCopyWithCapacity2, registers);
                        i14 = i20;
                        i15 = i26;
                    } else {
                        i4 = i16;
                        i5 = i20;
                        unsafe = unsafe2;
                        i6 = i27;
                        i3 = i26;
                    }
                    i7 = i6;
                    i16 = i4;
                    i15 = i3;
                    oneofField = ArrayDecoders.decodeUnknownField(i, data, i7, limit, getMutableUnknownFields(message), registers);
                    messageSchema = this;
                    t = message;
                    bArr = data;
                    i11 = limit;
                    registers2 = registers;
                    i13 = i2;
                    i14 = i5;
                    unsafe2 = unsafe;
                    i12 = -1;
                }
                i13 = i2;
                i12 = -1;
            }
            oneofField = ArrayDecoders.decodeUnknownField(i, data, i7, limit, getMutableUnknownFields(message), registers);
            messageSchema = this;
            t = message;
            bArr = data;
            i11 = limit;
            registers2 = registers;
            i13 = i2;
            i14 = i5;
            unsafe2 = unsafe;
            i12 = -1;
        }
        int i28 = i15;
        Unsafe unsafe3 = unsafe2;
        if (i16 != 1048575) {
            unsafe3.putInt(message, i16, i28);
        }
        if (oneofField == limit) {
            return oneofField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void mergeFrom(T message, byte[] data, int position, int limit, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(message, data, position, limit, registers);
        } else {
            parseProto2Message(message, data, position, limit, 0, registers);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Found duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Found duplicated region for block: B:31:0x005c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void makeImmutable(T message) {
        if (isMutable(message)) {
            if (message instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) message;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    switch (iType) {
                        case 17:
                            if (isFieldPresent(message, i)) {
                                getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(message, jOffset));
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.listFieldSchema.makeImmutableListAt(message, jOffset);
                            break;
                        case 50:
                            Unsafe unsafe = UNSAFE;
                            Object object = unsafe.getObject(message, jOffset);
                            if (object != null) {
                                unsafe.putObject(message, jOffset, this.mapFieldSchema.toImmutable(object));
                            }
                            break;
                    }
                } else if (isFieldPresent(message, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(message, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(message);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(message);
            }
        }
    }

    private final <K, V> void mergeMap(Object message, int pos, Object mapDefaultEntry, ExtensionRegistryLite extensionRegistry, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(pos));
        Object object = UnsafeUtil.getObject(message, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(mapDefaultEntry);
            UnsafeUtil.putObject(message, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(message, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(mapDefaultEntry), extensionRegistry);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Found duplicated region for block: B:39:0x008b  */
    /* JADX WARN: Found duplicated region for block: B:58:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:63:0x00ac A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T message) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int iNumberAt = numberAt(i6);
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = UNSAFE.getInt(message, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i3;
                i2 = i4;
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(message, i6, i, i2, i9)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(message, i6, i, i2, i9) && !isInitialized(message, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(message, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(message, iNumberAt, i6) && !isInitialized(message, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 49) {
                if (!isListInitialized(message, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 50 && !isMapInitialized(message, iTypeAndOffsetAt, i6)) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(message).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object message, int typeAndOffset, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(message, offset(typeAndOffset)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object message, int typeAndOffset, int pos) {
        List list = (List) UnsafeUtil.getObject(message, offset(typeAndOffset));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(pos);
        for (int i = 0; i < list.size(); i++) {
            if (!messageFieldSchema.isInitialized(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            if (SchemaFor == 0) {
                SchemaFor = SchemaFor;
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            SchemaFor = SchemaFor;
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int fieldNumber, Object value, Writer writer) throws IOException {
        if (value instanceof String) {
            writer.writeString(fieldNumber, (String) value);
        } else {
            writer.writeBytes(fieldNumber, (ByteString) value);
        }
    }

    private void readString(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readString());
        } else {
            UnsafeUtil.putObject(message, offset(typeAndOffset), reader.readBytes());
        }
    }

    private void readStringList(Object message, int typeAndOffset, Reader reader) throws IOException {
        if (isEnforceUtf8(typeAndOffset)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)));
        }
    }

    private <E> void readMessageList(Object message, int typeAndOffset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(message, offset(typeAndOffset)), schema, extensionRegistry);
    }

    private <E> void readGroupList(Object message, long offset, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(message, offset), schema, extensionRegistry);
    }

    private int numberAt(int pos) {
        return this.buffer[pos];
    }

    private int typeAndOffsetAt(int pos) {
        return this.buffer[pos + 1];
    }

    private int presenceMaskAndOffsetAt(int pos) {
        return this.buffer[pos + 2];
    }

    private static boolean isMutable(Object message) {
        if (message == null) {
            return false;
        }
        if (message instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) message).isMutable();
        }
        return true;
    }

    private static void checkMutable(Object message) {
        if (isMutable(message)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + message);
    }

    private static <T> double doubleAt(T message, long offset) {
        return UnsafeUtil.getDouble(message, offset);
    }

    private static <T> float floatAt(T message, long offset) {
        return UnsafeUtil.getFloat(message, offset);
    }

    private static <T> int intAt(T message, long offset) {
        return UnsafeUtil.getInt(message, offset);
    }

    private static <T> long longAt(T message, long offset) {
        return UnsafeUtil.getLong(message, offset);
    }

    private static <T> boolean booleanAt(T message, long offset) {
        return UnsafeUtil.getBoolean(message, offset);
    }

    private static <T> double oneofDoubleAt(T message, long offset) {
        return ((Double) UnsafeUtil.getObject(message, offset)).doubleValue();
    }

    private static <T> float oneofFloatAt(T message, long offset) {
        return ((Float) UnsafeUtil.getObject(message, offset)).floatValue();
    }

    private static <T> int oneofIntAt(T message, long offset) {
        return ((Integer) UnsafeUtil.getObject(message, offset)).intValue();
    }

    private static <T> long oneofLongAt(T message, long offset) {
        return ((Long) UnsafeUtil.getObject(message, offset)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T message, long offset) {
        return ((Boolean) UnsafeUtil.getObject(message, offset)).booleanValue();
    }

    private boolean arePresentForEquals(T message, T other, int pos) {
        return isFieldPresent(message, pos) == isFieldPresent(other, pos);
    }

    private boolean isFieldPresent(T message, int pos, int presenceFieldOffset, int presenceField, int presenceMask) {
        if (presenceFieldOffset == 1048575) {
            return isFieldPresent(message, pos);
        }
        return (presenceField & presenceMask) != 0;
    }

    private boolean isFieldPresent(T message, int pos) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(message, j) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(pos);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(message, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(message, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(message, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(message, jOffset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(message, jOffset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(message, jOffset));
            case 11:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(message, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(message, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(message, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setFieldPresent(T message, int pos) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(message, j, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(message, j));
    }

    private boolean isOneofPresent(T message, int fieldNumber, int pos) {
        return UnsafeUtil.getInt(message, (long) (presenceMaskAndOffsetAt(pos) & 1048575)) == fieldNumber;
    }

    private boolean isOneofCaseEqual(T message, T other, int pos) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(pos) & 1048575;
        return UnsafeUtil.getInt(message, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(other, jPresenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T message, int fieldNumber, int pos) {
        UnsafeUtil.putInt(message, presenceMaskAndOffsetAt(pos) & 1048575, fieldNumber);
    }

    private int positionForFieldNumber(final int number) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, 0);
    }

    private int positionForFieldNumber(final int number, final int min) {
        if (number < this.minFieldNumber || number > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(number, min);
    }

    private int slowPositionForFieldNumber(final int number, int min) {
        int length = (this.buffer.length / 3) - 1;
        while (min <= length) {
            int i = (length + min) >>> 1;
            int i2 = i * 3;
            int iNumberAt = numberAt(i2);
            if (number == iNumberAt) {
                return i2;
            }
            if (number < iNumberAt) {
                length = i - 1;
            } else {
                min = i + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
